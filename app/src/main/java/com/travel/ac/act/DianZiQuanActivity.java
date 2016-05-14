package com.travel.ac.act;

import android.widget.ImageView;
import android.widget.TextView;

import com.travel.R;

public class DianZiQuanActivity extends BaseActivity
{

	private ImageView	imNormal;
	private TextView	tvDianziquanHint;

	@Override
	protected int setLayoutId()
	{
		return R.layout.activity_dianziquan;
	}

	@Override
	protected void initData()
	{
		setTitle("我的电子券",true);
	}

	@Override
	protected void initView()
	{

		imNormal = (ImageView) findViewById(R.id.im_normal);
		tvDianziquanHint = (TextView) findViewById(R.id.tv_dianziquan_hint);
	}
}
