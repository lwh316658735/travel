package com.travel.ac.act;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import android.view.Window;

/**
 * Created by lwh on 2016/4/25. description 所有Activity的基类
 */
public abstract class BaseActivity extends FragmentActivity {

    protected Activity mActivity;
    protected final String LOG_TAG = getClass().getSimpleName();
    //Activity栈
    protected static ArrayMap<String, Activity> sStacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(setLayoutId());
        mActivity = this;
        sStacks = new ArrayMap<>();
        addSelfActivity();
        initView();
        initData();
    }

    @Override
    protected void onDestroy() {
        removeSelfActivity();
        super.onDestroy();
    }

    /*
     * 子类实现自己的布局文件
     */
    protected abstract int setLayoutId();

    /*
     * 子类实现自己的数据模块
     */
    protected abstract void initData();

    /*
     * 获取子类控件
     */
    protected abstract void initView();

    /*
     * 自己入栈
     */
    protected void addSelfActivity() {
        Log.e(LOG_TAG, "addSelfActivity: ");
        if (sStacks.get(LOG_TAG) == null) {
            Log.e(LOG_TAG, LOG_TAG + "入栈");
            sStacks.put(LOG_TAG, mActivity);
        } else {
            Log.e(LOG_TAG, "input stack failed");
        }
    }

    protected void addActivity(String name, Activity activity) {
        if (sStacks.get(name) == null) {
            Log.e(LOG_TAG, name + "入栈");
            sStacks.put(name, activity);
        } else {
            Log.e(LOG_TAG, "input stack failed");
        }
    }

    protected Activity getActivity(String name) {
        return sStacks.get(name);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    protected Activity removeActivity(String name) {
        Activity remove = sStacks.remove(name);
        if (remove != null) Log.e(LOG_TAG, name + "出栈");
        return remove;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    protected Activity removeSelfActivity() {
        Activity remove = sStacks.remove(LOG_TAG);
        if (remove != null) Log.e(LOG_TAG, LOG_TAG + "出栈");
        return remove;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    protected boolean removeAllActivity() {
        for (String a : sStacks.keySet()) {
            Activity remove = sStacks.remove(a);
            if (remove != null) {
                Log.e(LOG_TAG, a + "出栈");
            }
        }
        return true;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    protected boolean closeAllActivity() {
        for (String a : sStacks.keySet()) {
            Activity remove = sStacks.remove(a);
            if (!remove.isFinishing()) {
                remove.finish();
            }
        }
        return true;
    }
}
