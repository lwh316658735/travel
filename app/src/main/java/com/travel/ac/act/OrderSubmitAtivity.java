package com.travel.ac.act;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.travel.R;

public class OrderSubmitAtivity extends BaseActivity
{
	private ImageView	ivBack;
	private TextView	tvTitleContent;
	private TextView	tvRegister;
	private EditText	edName;
	private EditText	edPhoneNo;
	private TextView	textView5;
	private TextView	tvPrice;
	private Button		btSubmit;

	@Override
	protected int setLayoutId()
	{
		return R.layout.activity_order_submit_ativity;
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
		tvRegister.setVisibility(View.GONE);
		tvTitleContent.setText("门票订单填写");
	}

	@Override
	protected void initView()
	{
		ivBack = (ImageView) findViewById(R.id.iv_back);
		tvTitleContent = (TextView) findViewById(R.id.tv_title_content);
		tvRegister = (TextView) findViewById(R.id.tv_register);
		edName = (EditText) findViewById(R.id.ed_name);
		edPhoneNo = (EditText) findViewById(R.id.ed_phone_no);
		textView5 = (TextView) findViewById(R.id.textView5);
		tvPrice = (TextView) findViewById(R.id.tv_price);
		btSubmit = (Button) findViewById(R.id.bt_submit);

	}
}
