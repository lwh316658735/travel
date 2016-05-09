package com.travel.ac.fragment;

import android.app.Activity;
import android.view.View;
import android.widget.ListView;

import com.android.volley.Response;
import com.google.gson.Gson;
import com.travel.R;
import com.travel.ac.adapter.MainListViewAdapter;
import com.travel.ac.bean.GlobalParameter;
import com.travel.ac.bean.TravelListBean;
import com.travel.ac.utils.NetworkHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lwh on 2016/4/27. description
 */
public class HomeFragment extends BaseFragment
{

	public static final String				LOG_TAG	= "HomeFragment";
	private ListView						mListView;
	private MainListViewAdapter				mMainListViewAdapter;
	private List<TravelListBean.ListBean>	datas;

	@Override
	protected int setContentView()
	{
		return R.layout.home_fragment;
	}

	@Override
	protected void initView()
	{
		mListView = (ListView) mView.findViewById(R.id.lv_home_list);

	}

	@Override
	protected void initData()
	{
		datas = new ArrayList();
		mMainListViewAdapter = new MainListViewAdapter(datas, (Activity) mContext);
		NetworkHelper.requestAndResponse((Activity) mContext, GlobalParameter.URL_ROOT + "/read_travel_list", new Response.Listener<String>() {
			@Override
			public void onResponse(String response)
			{
				Gson gson = new Gson();
				TravelListBean travelListBean = gson.fromJson(response, TravelListBean.class);
				List<TravelListBean.ListBean> list = travelListBean.getList();
				mMainListViewAdapter.setDatas(list);
				mMainListViewAdapter.notifyDataSetChanged();
			}
		});
		mListView.setAdapter(mMainListViewAdapter);
	}

	@Override
	public void onStart()
	{
		super.onStart();

	}

	@Override
	public void onResume()
	{
		super.onResume();
	}

	@Override
	public void onClick(View v)
	{

	}

	@Override
	public void onPause()
	{
		super.onPause();
	}

	@Override
	public void onStop()
	{
		super.onStop();
		//		mTimerTask.cancel();
	}

}
