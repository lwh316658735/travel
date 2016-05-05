package com.travel.ac.act;

import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.travel.R;
import com.travel.ac.factory.FragmentFactory;
import com.travel.ac.utils.GetAssignedResultId;

public class MainActivity extends BaseActivity implements TabHost.OnTabChangeListener {

    private FragmentTabHost mTabHost;
    private String[] mClassNames = {"HomeFragment", "MyOrderFragment", "MyTravelFragment", "OtherFragment"};

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

        //初始化FragmentTabhost组件
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        mTabHost.getTabWidget().setDividerDrawable(null);
        String[] tabTexts = getResources().getStringArray(R.array.tab_string);
        //向组件里添加子控件
        for (int i = 0; i < 4; i++) {
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(tabTexts[i]).setIndicator(initTabView(i, tabTexts[i]));
            mTabHost.addTab(tabSpec, FragmentFactory.getTagFragment(mClassNames[i]).getClass(), null);
        }
        //默认显示的页面
        mTabHost.setCurrentTab(0);
        //设置当点击不同子控件是的监听
        mTabHost.setOnTabChangedListener(this);
    }

    /**
     * 初始化Tab控件
     *
     * @param index
     * @param tabtext
     * @return
     */
    private View initTabView(int index, String tabtext) {
        View      view = View.inflate(this, R.layout.item_tab, null);
        ImageView ivTabIco;
        TextView  tvTabText;
        ivTabIco = (ImageView) view.findViewById(R.id.iv_tab_ico);
        tvTabText = (TextView) view.findViewById(R.id.tv_tab_text);
        ivTabIco.setBackgroundResource(GetAssignedResultId.GetAssigned("selector_tab_" + index));
        tvTabText.setText(tabtext);
        return view;
    }

    @Override
    protected void initView() {
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
    }

    @Override
    public void onTabChanged(String tabId) {
        Log.e(LOG_TAG, "onTabChanged: " + tabId);

    }
}
