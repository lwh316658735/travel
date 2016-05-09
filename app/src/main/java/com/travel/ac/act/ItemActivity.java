package com.travel.ac.act;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.travel.R;
import com.travel.ac.adapter.SpotListViewAdapter;
import com.travel.ac.bean.SpotListViewBean;

import java.util.ArrayList;
import java.util.List;

public class ItemActivity extends BaseActivity
{
	private ImageView	ivBack;
	private TextView	tvTitleContent;
	private TextView	tvRegister;
	private ListView	lvSpotList;
	List				datas;

	@Override
	protected int setLayoutId()
	{
		return R.layout.activity_item;
	}

	@Override
	protected void initData()
	{
		datas = new ArrayList();
		SpotListViewBean spotListViewBean = new SpotListViewBean();
		spotListViewBean.setContent("水电费水电费水电费等所发生的士大夫似的啊");
		spotListViewBean.setTitle("士大夫士大夫撒");
		spotListViewBean.setPrice("￥30起");
		datas.add(spotListViewBean);
		ivBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v)
			{
				finish();
			}
		});
		tvRegister.setVisibility(View.GONE);
		tvTitleContent.setText("景点门票");
		SpotListViewAdapter spotListViewAdapter = new SpotListViewAdapter(datas, mActivity);
		lvSpotList.setAdapter(spotListViewAdapter);
		lvSpotList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id)
			{
				Intent in = new Intent(mActivity, ParticularSpotActivity.class);
				in.putExtra("id", position);
				startActivity(in);
			}
		});
	}

	@Override
	protected void initView()
	{
		ivBack = (ImageView) findViewById(R.id.iv_back);
		tvTitleContent = (TextView) findViewById(R.id.tv_title_content);
		tvRegister = (TextView) findViewById(R.id.tv_register);
		lvSpotList = (ListView) findViewById(R.id.lv_spot_list);
	}

}
