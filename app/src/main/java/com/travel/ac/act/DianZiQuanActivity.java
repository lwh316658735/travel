package com.travel.ac.act;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.travel.R;

public class DianZiQuanActivity extends BaseActivity
{
	private ImageView	ivBack;
	private TextView	tvTitleContent;
	private TextView	tvRegister;
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
		tvRegister.setVisibility(View.GONE);
		tvTitleContent.setText("我的电子券");
		ivBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v)
			{
				finish();
			}
		});
	}

	@Override
	protected void initView()
	{
		ivBack = (ImageView) findViewById(R.id.iv_back);
		tvTitleContent = (TextView) findViewById(R.id.tv_title_content);
		tvRegister = (TextView) findViewById(R.id.tv_register);
		imNormal = (ImageView) findViewById(R.id.im_normal);
		tvDianziquanHint = (TextView) findViewById(R.id.tv_dianziquan_hint);
	}
}
