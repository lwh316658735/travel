package com.travel.ac.fragment;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.travel.R;
import com.travel.ac.adapter.MainAdapter;
import com.travel.ac.adapter.MainListViewAdapter;
import com.travel.ac.bean.MainListViewBean;
import com.travel.ac.bean.MyTravelItemBean;
import com.travel.ac.utils.GetAssignedResultId;
import com.travel.ac.view.CircleView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by lwh on 2016/4/27. description
 */
public class HomeFragment extends BaseFragment
{

	public static final String		LOG_TAG	= "HomeFragment";
	private TextView				tvSearch;
	private ViewPager				vpMain;
	private CircleView				cvMainCount;
	private int						mNumber	= 5;
	private Timer					mTimer;
	private TimerTask				mTimerTask;
	private GridView				gvMainView;
	private ListView				mListView;
	private MainListViewAdapter		mMainListViewAdapter;
	private List<MainListViewBean>	datas;

	@Override
	protected int setContentView()
	{
		return R.layout.home_fragment;
	}

	@Override
	protected void initView()
	{
		tvSearch = (TextView) mView.findViewById(R.id.tv_search);
		vpMain = (ViewPager) mView.findViewById(R.id.vp_main);
		cvMainCount = (CircleView) mView.findViewById(R.id.cv_main_count);
		gvMainView = (GridView) mView.findViewById(R.id.gv_main_view);
		mListView = (ListView) mView.findViewById(R.id.lv_main_listview);

	}

	@Override
	protected void initData()
	{
		datas = new ArrayList();
		cvMainCount.setNumber(mNumber);
		tvSearch.setOnClickListener(this);
		for (int i = 0; i < 75; i++)
		{
			MainListViewBean mainListViewBean = new MainListViewBean();
			mainListViewBean.setDescribe("上飞机离开时间分厘卡圣诞节啊弗兰克教授圣诞节分厘卡时间来得及发了 " + i);
			mainListViewBean.setAmount("￥16" + i);
			mainListViewBean.setImagePath("");
			datas.add(mainListViewBean);

		}
		mMainListViewAdapter = new MainListViewAdapter(datas, (Activity) mContext);
		mListView.setAdapter(mMainListViewAdapter);

		vpMain.setAdapter(new PagerAdapter() {
			@Override
			public int getCount()
			{
				return Integer.MAX_VALUE;
			}

			@Override
			public boolean isViewFromObject(View view, Object object)
			{
				return view == object;
			}

			@Override
			public Object instantiateItem(ViewGroup container, int position)
			{
				ImageView imageView = new ImageView(mContext);
				LinearLayout linearLayout = new LinearLayout(mContext);
				LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
				linearLayout.setLayoutParams(params1);
				linearLayout.addView(imageView);
				int mipmap = GetAssignedResultId.GetAssigned("banner_" + ((position - 1000) % 5), "mipmap");
				Log.e(LOG_TAG, "instantiateItem: " + mipmap);
				imageView.setBackgroundResource(mipmap);
				container.addView(linearLayout);
				return linearLayout;
			}

			@Override
			public void destroyItem(ViewGroup container, int position, Object object)
			{

				container.removeView((View) object);
			}
		});
		vpMain.setCurrentItem(mNumber * 1000);
		vpMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
			{

			}

			@Override
			public void onPageSelected(int position)
			{
				int index = Math.abs(position - 1000) % 5;
				cvMainCount.setSelectedCircle(index);
			}

			@Override
			public void onPageScrollStateChanged(int state)
			{

			}
		});
		mTimerTask = new TimerTask() {
			@Override
			public void run()
			{
				vpMain.post(new Runnable() {
					@Override
					public void run()
					{
						int currentItem = vpMain.getCurrentItem();
						vpMain.setCurrentItem(++currentItem);
					}
				});

			}
		};
		mTimer = new Timer();
		List datas = new ArrayList();
		for (int i = 0; i < 8; i++)
		{
			datas.add(new MyTravelItemBean());
		}
		MainAdapter mainAdapter = new MainAdapter(datas, (Activity) mContext);
		gvMainView.setAdapter(mainAdapter);
	}

	@Override
	public void onStart()
	{
		super.onStart();
		mTimer.schedule(mTimerTask, 3000, 3000);
	}

	@Override
	public void onClick(View v)
	{

	}

	@Override
	public void onStop()
	{
		super.onStop();
		mTimer.cancel();
	}
}
