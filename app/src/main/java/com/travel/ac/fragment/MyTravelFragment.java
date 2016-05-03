package com.travel.ac.fragment;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.travel.R;
import com.travel.ac.act.LoginActivity;
import com.travel.ac.adapter.MyTravelAdapter;
import com.travel.ac.bean.MyTravelItemBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lwh on 2016/4/27. description
 */
public class MyTravelFragment extends BaseFragment implements View.OnClickListener
{
	private static final String		LOG_TAG	= "MyTravelFragment";
	private ImageView				imageView4;
	private TextView				textView4;
	private ImageView				ivLogin;
	private ListView				lvMyListview;
	private TextView				tvLogin;
	private List<MyTravelItemBean>	datas;

	@Override
	protected int setContentView()
	{
		return R.layout.fragment_person_center;
	}

	@Override
	protected void initView()
	{
		imageView4 = (ImageView) mView.findViewById(R.id.imageView4);
		textView4 = (TextView) mView.findViewById(R.id.textView4);
		ivLogin = (ImageView) mView.findViewById(R.id.iv_login);
		lvMyListview = (ListView) mView.findViewById(R.id.lv_myListview);
		tvLogin = (TextView) mView.findViewById(R.id.tv_login);
	}

	@Override
	protected void initData()
	{
		datas = new ArrayList<>();
		String[] stringArray = getResources().getStringArray(R.array.my_travel);
		int i = 0;
		for (String item : stringArray)
		{
			MyTravelItemBean myTravelItemBean = new MyTravelItemBean();
			myTravelItemBean.setTextStr(item);
			myTravelItemBean.setIcoText("icon_" + i);
			i++;
			datas.add(myTravelItemBean);
		}
		ivLogin.setOnClickListener(this);
		tvLogin.setOnClickListener(this);
		MyTravelAdapter travelAdapter = new MyTravelAdapter(datas, (Activity) mContext);
		lvMyListview.setAdapter(travelAdapter);
	}

	@Override
	public void onClick(View v)
	{
		startActivity(new Intent(mContext, LoginActivity.class));
	}
}
