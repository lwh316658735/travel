package com.travel.ac.act;

import android.widget.ListView;

import com.travel.R;
import com.travel.ac.adapter.OrderListAdapter;
import com.travel.ac.bean.OrderListBean;

import java.util.ArrayList;
import java.util.List;

public class OrderListActivity extends BaseActivity
{
	private ListView			lvOrderList;
	private OrderListAdapter	mOrderListAdapter;
	private List				mDatas;

	@Override
	protected int setLayoutId()
	{
		return R.layout.activity_order_list;
	}

	@Override
	protected void initData()
	{
		mDatas = new ArrayList();
		OrderListBean bean = new OrderListBean();
		bean.setOrderNo("012342321323");
		bean.setPayDate("2016-5-9");
		bean.setPrice("￥100");
		bean.setTitle("九寨沟xxxxxxxxxxxxxxxx");
		mDatas.add(bean);
		setTitle("订单列表", true);
		mOrderListAdapter = new OrderListAdapter(mDatas,this);
		lvOrderList.setAdapter(mOrderListAdapter);
	}

	@Override
	protected void initView()
	{
		lvOrderList = (ListView) findViewById(R.id.lv_order_list);

	}
}
