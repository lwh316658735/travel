package com.travel.ac.fragment;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.google.gson.Gson;
import com.travel.R;
import com.travel.ac.act.ItemActivity;
import com.travel.ac.adapter.MainAdapter;
import com.travel.ac.adapter.MainListViewAdapter;
import com.travel.ac.bean.GlobalParameter;
import com.travel.ac.bean.MyTravelItemBean;
import com.travel.ac.bean.TravelListBean;
import com.travel.ac.utils.GetAssignedResultId;
import com.travel.ac.utils.NetworkHelper;
import com.travel.ac.view.CircleView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by lwh on 2016/4/27. description
 */
public class HomeFragmentBackups extends BaseFragment {

    public static final String LOG_TAG = "HomeFragment";
    private TextView   tvSearch;
    private ViewPager  vpMain;
    private CircleView cvMainCount;
    private int mNumber = 5;
    private Timer                         mTimer;
    private TimerTask                     mTimerTask;
    private GridView                      gvMainView;
    private ListView                      mListView;
    private MainListViewAdapter           mMainListViewAdapter;
    private List<TravelListBean.ListBean> datas;

    @Override
    protected int setContentView() {
        return R.layout.home_fragment;
    }

    @Override
    protected void initView() {
        tvSearch = (TextView) mView.findViewById(R.id.tv_search);
        vpMain = (ViewPager) mView.findViewById(R.id.vp_main);
        cvMainCount = (CircleView) mView.findViewById(R.id.cv_main_count);
        gvMainView = (GridView) mView.findViewById(R.id.gv_main_view);
        mListView = (ListView) mView.findViewById(R.id.lv_main_listview);

    }

    @Override
    protected void initData() {
        datas = new ArrayList();
        cvMainCount.setNumber(mNumber);
        tvSearch.setOnClickListener(this);
        mMainListViewAdapter = new MainListViewAdapter(datas, (Activity) mContext);
        NetworkHelper.requestAndResponse((Activity) mContext, GlobalParameter.URL_ROOT + "/read_travel_list", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson                          gson           = new Gson();
                TravelListBean                travelListBean = gson.fromJson(response, TravelListBean.class);
                List<TravelListBean.ListBean> list           = travelListBean.getList();
                mMainListViewAdapter.setDatas(list);
                mMainListViewAdapter.notifyDataSetChanged();
            }
        });

        mListView.setAdapter(mMainListViewAdapter);
        vpMain.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return Integer.MAX_VALUE;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView                 imageView    = new ImageView(mContext);
                LinearLayout              linearLayout = new LinearLayout(mContext);
                LinearLayout.LayoutParams params1      = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                linearLayout.setLayoutParams(params1);
                linearLayout.addView(imageView);
                int mipmap = GetAssignedResultId.GetAssigned("banner_" + ((position - 1000) % 5), "mipmap");
                //				Log.e(LOG_TAG, "instantiateItem: " + mipmap);
                imageView.setBackgroundResource(mipmap);
                container.addView(linearLayout);
                return linearLayout;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {

                container.removeView((View) object);
            }
        });
        vpMain.setCurrentItem(mNumber * 1000);
        vpMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int index = Math.abs(position - 1000) % 5;
                cvMainCount.setSelectedCircle(index);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mTimerTask = new MyTask();
        mTimer = new Timer();
        List datas2 = new ArrayList();
        for (int i = 0; i < 8; i++) {
            datas2.add(new MyTravelItemBean());
        }
        MainAdapter mainAdapter = new MainAdapter(datas2, (Activity) mContext);
        gvMainView.setAdapter(mainAdapter);
        gvMainView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in = new Intent();
                switch (position) {
                    case 0:
                        in.setClass(mContext, ItemActivity.class);
                        break;
                }
                startActivity(in);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onResume() {
        super.onResume();
        mTimerTask = new MyTask();
        mTimer.schedule(mTimerTask, 3000, 3000);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mTimerTask.cancel();
    }

    class MyTask extends TimerTask {
        @Override
        public void run() {
            vpMain.post(new Runnable() {
                @Override
                public void run() {
                    int currentItem = vpMain.getCurrentItem();
                    vpMain.setCurrentItem(++currentItem);
                }
            });

        }
    }
}
