package com.travel.ac.act;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.travel.R;
import com.travel.ac.utils.DataPersistence;
import com.travel.ac.utils.GetAssignedResultId;
import com.travel.ac.view.CircleView;

/**
 * Created by lwh on 2016/4/25. description
 */
public class SplashActivity extends BaseActivity
{
	private ViewPager  vpSplash;
	private CircleView cvCircle;

	@Override
	protected int setLayoutId()
	{
		return R.layout.activity_splash;
	}

	@Override
	protected void initData()
	{
		//判断是否第一次进入程序
		if (DataPersistence.getData(mActivity).getBoolean(getString(R.string.FIRST), false))
		{
			Intent in = new Intent();
			in.setClass(mActivity, MainActivity.class);
			mActivity.startActivity(in);
			finish();
			return;
		}
		//设置viewpager适配器
		vpSplash.setAdapter(new PagerAdapter() {
			@Override
			public int getCount()
			{
				return 4;
			}

			public void destroyItem(ViewGroup container, int position, Object object)
			{
				container.removeView((View) object);
			}

			@Override
			public boolean isViewFromObject(View view, Object object)
			{
				return view == object;
			}

			@TargetApi(Build.VERSION_CODES.LOLLIPOP)
			@Override
			public Object instantiateItem(ViewGroup container, int position)
			{
				View view = View.inflate(mActivity, R.layout.viewpager_item, null);
				ImageView iv_splash = (ImageView) view.findViewById(R.id.im_splash);
				iv_splash.setBackgroundResource(GetAssignedResultId.GetAssigned("g" + (position + 1), "mipmap"));
				if ((position + 1) == getCount())
				{
					iv_splash.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View v)
						{
							//进入主界面
							Intent in = new Intent();
							in.setClass(mActivity, MainActivity.class);
							mActivity.startActivity(in);
							removeSelfActivity();
							DataPersistence.addData(mActivity, getString(R.string.FIRST), true);
							finish();
						}
					});
				}
				container.addView(view);
				return view;
			}
		});
		vpSplash.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
			{

			}

			@Override
			public void onPageSelected(int position)
			{
				//更新进度动画
				cvCircle.setSelectedCircle(position);
			}

			@Override
			public void onPageScrollStateChanged(int state)
			{

			}
		});

	}

	@Override
	protected void initView()
	{
		vpSplash = (ViewPager) findViewById(R.id.vp_splash);
		cvCircle = (CircleView) findViewById(R.id.cv_circle);
	}
}
