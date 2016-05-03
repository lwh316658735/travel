package com.travel.ac.fragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.travel.R;
import com.travel.ac.view.CircleView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by lwh on 2016/4/27. description
 */
public class HomeFragment extends BaseFragment {

    public static final String LOG_TAG = "HomeFragment";
    private TextView   tvSearch;
    private ViewPager  vpMain;
    private CircleView cvMainCount;
    private int mNumber = 5;
    private Timer     mTimer;
    private TimerTask mTimerTask;
    private GridView  gvMainView;

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

    }

    @Override
    protected void initData() {
        cvMainCount.setNumber(mNumber);
        tvSearch.setOnClickListener(this);
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
                imageView.setBackgroundResource(R.mipmap.banner);
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
        mTimerTask = new TimerTask() {
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
        };
        mTimer = new Timer();
//        gvMainView.setAdapter();
    }

    @Override
    public void onStart() {
        super.onStart();
        mTimer.schedule(mTimerTask, 3000, 3000);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onStop() {
        super.onStop();
        mTimer.cancel();
    }
}
