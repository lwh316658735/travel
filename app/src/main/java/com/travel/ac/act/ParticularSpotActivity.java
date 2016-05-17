package com.travel.ac.act;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.google.gson.Gson;
import com.lidroid.xutils.BitmapUtils;
import com.travel.R;
import com.travel.ac.bean.GlobalParameter;
import com.travel.ac.bean.SpotTicketOrderJson;
import com.travel.ac.utils.NetworkHelper;
import com.travel.ac.utils.mProgressDialog;

public class ParticularSpotActivity extends BaseActivity
{
	private ImageView	ivParticularImage;
	private TextView	tvTitle;
	private TextView	tvPrice;
	private Button		btOk;
	private TextView	tvSpotDescription;
	private String		mTable;

	@Override
	protected int setLayoutId()
	{
		return R.layout.activity_particular_spot;
	}

	@Override
	protected void initData()
	{
		ivParticularImage.setBackgroundResource(R.mipmap.main_moren);
		final Intent intent = getIntent();
		final int id = intent.getIntExtra("id", 0);
		mTable = intent.getStringExtra("table");
		if (mTable == null)
		{
			mTable = "";
		}
		mProgressDialog mProgressDialog = new mProgressDialog(mActivity, new mProgressDialog.mProgressListener() {
			@Override
			public void onProgress()
			{
				NetworkHelper.requestAndResponse(mActivity, GlobalParameter.URL_ROOT + "/read_travel_ticket_description?id=" + id + mTable,
													new Response.Listener<String>() {
														@Override
														public void onResponse(String response)
														{
															Log.e(LOG_TAG, "onResponse: " + response);
															final SpotTicketOrderJson spotTicketOrderJson = new Gson().fromJson(response, SpotTicketOrderJson.class);
															mActivity.runOnUiThread(new Runnable() {
																@Override
																public void run()
																{
																	tvSpotDescription.setText(spotTicketOrderJson.getBean().getDescription());
																	tvTitle.setText(intent.getStringExtra("name"));
																	tvPrice.setText("￥" + intent.getStringExtra("price"));
																	BitmapUtils bitmapUtils = new BitmapUtils(mActivity);
																	bitmapUtils.display(ivParticularImage, spotTicketOrderJson.getBean().getUrl());
																	mTable = spotTicketOrderJson.getBean().getType();
																	//                                Log.e(LOG_TAG, "run: " + spotTicketOrderJson.getBean());

																}
															});

														}
													});
			}

			@Override
			public void onCancel()
			{

			}
		});
		mProgressDialog.show();

		btOk.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v)
			{
				Intent in = new Intent(mActivity, OrderSubmitAtivity.class);
				in.putExtra("price", intent.getStringExtra("price"));
				in.putExtra("type", mTable);
				in.putExtra("title", intent.getStringExtra("name"));
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
