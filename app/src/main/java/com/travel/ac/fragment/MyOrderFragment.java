package com.travel.ac.fragment;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.travel.R;
import com.travel.ac.act.LoginActivity;
import com.travel.ac.adapter.OrderMenuAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lwh on 2016/4/27. description
 */
public class MyOrderFragment extends BaseFragment implements AdapterView.OnItemClickListener
{
	private static final String	LOG_TAG	= "MyOrderFragment";
	private ImageView			imageView;
	private TextView			textView;
	private ListView			lvOrderListview;
	private OrderMenuAdapter	mOrderMenuAdapter;
	private List<Object>		mDatas;

	@Override
	protected int setContentView()
	{
		return R.layout.myorder_fragment;
	}

	@Override
	protected void initView()
	{
		imageView = (ImageView) mView.findViewById(R.id.imageView);
		textView = (TextView) mView.findViewById(R.id.textView);
		lvOrderListview = (ListView) mView.findViewById(R.id.lv_order_listview);

	}

	@Override
	protected void initData()
	{
		mDatas = new ArrayList<>();
		if (mDatas.size() <= 0)
		{
			String[] texts = getResources().getStringArray(R.array.order_pager_item);
			for (String s : texts)
			{
				mDatas.add(s);
			}
		}
		mOrderMenuAdapter = new OrderMenuAdapter(mDatas, (Activity) mContext);
		lvOrderListview.setAdapter(mOrderMenuAdapter);
		lvOrderListview.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id)
	{
        startActivity(new Intent(mContext, LoginActivity.class));
        Log.e(LOG_TAG, "onItemClick: " + mDatas.get(position));
	}
}
