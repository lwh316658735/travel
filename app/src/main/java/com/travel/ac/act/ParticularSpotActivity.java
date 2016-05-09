package com.travel.ac.act;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.travel.R;

public class ParticularSpotActivity extends BaseActivity
{
	private ImageView	ivParticularImage;
	private TextView	tvTitle;
	private TextView	tvPrice;
	private Button		btOk;
	private TextView	tvSpotDescription;

	@Override
	protected int setLayoutId()
	{
		return R.layout.activity_particular_spot;
	}

	@Override
	protected void initData()
	{
		btOk.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent in = new Intent(mActivity, OrderSubmitAtivity.class);
				startActivity(in);
			}
		});
	}

	@Override
	protected void initView()
	{
		ivParticularImage = (ImageView) findViewById(R.id.iv_particular_image);
		tvTitle = (TextView) findViewById(R.id.tv_title);
		tvPrice = (TextView) findViewById(R.id.tv_price);
		btOk = (Button) findViewById(R.id.bt_ok);
		tvSpotDescription = (TextView) findViewById(R.id.tv_spot_description);
	}
}
