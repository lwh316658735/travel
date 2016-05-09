package com.travel.ac.act;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.travel.R;
import com.travel.ac.bean.GlobalParameter;

public class SettingActivity extends BaseActivity
{
	private ImageView		ivBack;
	private TextView		tvTitleContent;
	private TextView		tvRegister;
	private ToggleButton	tbSound;
	private Button			btLogout;

	@Override
	protected int setLayoutId()
	{
		return R.layout.activity_setting;
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
		tvTitleContent.setText("设置");
		tvRegister.setVisibility(View.GONE);
		btLogout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v)
			{
				GlobalParameter.ASSERT_LOGIN = false;
				GlobalParameter.sLoginBean = null;
				finish();
			}
		});
	}

	@Override
	protected void initView()
	{

		btLogout = (Button) findViewById(R.id.bt_logout);
		ivBack = (ImageView) findViewById(R.id.iv_back);
		tvTitleContent = (TextView) findViewById(R.id.tv_title_content);
		tvRegister = (TextView) findViewById(R.id.tv_register);
		tbSound = (ToggleButton) findViewById(R.id.tb_sound);

	}

}
