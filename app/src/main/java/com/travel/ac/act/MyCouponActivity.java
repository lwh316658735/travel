package com.travel.ac.act;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.travel.R;

public class MyCouponActivity extends BaseActivity
{
	private ImageView	ivBack;
	private TextView	tvTitleContent;
	private TextView	tvRegister;
	private TextView	tvKeshiyong;
	private TextView	tvShixiao;
	private ImageView	ivCoupon;
	private TextView	tvDianziquanHint;

	@Override
	protected int setLayoutId()
	{
		return R.layout.activity_my_coupon;
	}

	@Override
	protected void initData()
	{
		ivBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v)
			{
				finish();
			}
		});
		tvTitleContent.setText("我的优惠券");
		tvRegister.setVisibility(View.GONE);

	}

	@Override
	protected void initView()
	{
		ivBack = (ImageView) findViewById(R.id.iv_back);
		tvTitleContent = (TextView) findViewById(R.id.tv_title_content);
		tvRegister = (TextView) findViewById(R.id.tv_register);
		tvKeshiyong = (TextView) findViewById(R.id.tv_keshiyong);
		tvShixiao = (TextView) findViewById(R.id.tv_shixiao);
		ivCoupon = (ImageView) findViewById(R.id.iv_coupon);
		tvDianziquanHint = (TextView) findViewById(R.id.tv_dianziquan_hint);

	}
}
