package com.travel.ac.act;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.travel.R;

public class AboutActivity extends BaseActivity
{
	private ImageView	ivBack;
	private TextView	tvTitleContent;
	private TextView	tvRegister;

	@Override
	protected int setLayoutId()
	{
		return R.layout.activity_about;
	}

	@Override
	protected void initData()
	{
		tvTitleContent.setText("关于");
		tvRegister.setVisibility(View.GONE);
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

	}
}
