package com.travel.ac.act;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.travel.R;
import com.travel.ac.MyReceive;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by lwh on 2016/4/25. description 所有Activity的基类
 */
public abstract class BaseActivity extends FragmentActivity
{
	protected Activity							mActivity;
	protected final String						LOG_TAG					= getClass().getSimpleName();
	//Activity栈
	protected static ArrayMap<String,Activity>	sStacks;
	protected ImageView							ivBack;
	protected TextView							tvTitleContent;
	protected TextView							tvRegister;
	private MyReceive							mMyReceive;
	public static final String					MESSAGE_RECEIVED_ACTION	= "com.example.jpushdemo.MESSAGE_RECEIVED_ACTION";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
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
	protected void onDestroy()
	{
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
	protected void addSelfActivity()
	{
		Log.e(LOG_TAG, "addSelfActivity: ");
		if (sStacks.get(LOG_TAG) == null)
		{
			Log.e(LOG_TAG, LOG_TAG + "入栈");
			sStacks.put(LOG_TAG, mActivity);
		}
		else
		{
			Log.e(LOG_TAG, "input stack failed");
		}
	}

	protected void addActivity(String name, Activity activity)
	{
		if (sStacks.get(name) == null)
		{
			Log.e(LOG_TAG, name + "入栈");
			sStacks.put(name, activity);
		}
		else
		{
			Log.e(LOG_TAG, "input stack failed");
		}
	}

	protected Activity getActivity(String name)
	{
		return sStacks.get(name);
	}

	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
	protected Activity removeActivity(String name)
	{
		Activity remove = sStacks.remove(name);
		if (remove != null)
			Log.e(LOG_TAG, name + "出栈");
		return remove;
	}

	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
	protected Activity removeSelfActivity()
	{
		Activity remove = sStacks.remove(LOG_TAG);
		if (remove != null)
			Log.e(LOG_TAG, LOG_TAG + "出栈");
		return remove;
	}

	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
	protected boolean removeAllActivity()
	{
		for (String a : sStacks.keySet())
		{
			Activity remove = sStacks.remove(a);
			if (remove != null)
			{
				Log.e(LOG_TAG, a + "出栈");
			}
		}
		return true;
	}

	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
	protected boolean closeAllActivity()
	{
		for (String a : sStacks.keySet())
		{
			Activity remove = sStacks.remove(a);
			if (!remove.isFinishing())
			{
				remove.finish();
			}
		}
		return true;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		Log.e(LOG_TAG, "onActivityResult: " + resultCode);
		super.onActivityResult(requestCode, resultCode, data);
	}

	public void onStart()
	{
		super.onStart();
	}

	protected void onResume()
	{
		super.onResume();
		JPushInterface.onResume(this);
		mMyReceive = new MyReceive();
		IntentFilter filter = new IntentFilter();
		filter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY);
		filter.addAction(MESSAGE_RECEIVED_ACTION);
		registerReceiver(mMyReceive, filter);
	}

	protected void onPause()
	{
		super.onPause();
		JPushInterface.onPause(this);
		unregisterReceiver(mMyReceive);
	}

	public void onStop()
	{
		super.onStop();
	}

	protected void setTitle(String title, boolean flag)
	{
		ivBack = (ImageView) findViewById(R.id.iv_back);
		tvTitleContent = (TextView) findViewById(R.id.tv_title_content);
		tvRegister = (TextView) findViewById(R.id.tv_register);

		ivBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v)
			{
				finish();
			}
		});
		if (flag)
		{
			tvRegister.setVisibility(View.GONE);
		}
		tvTitleContent.setText(title);
	}
}
