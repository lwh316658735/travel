package com.travel.ac.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by lwh on 2016/4/29. description
 */
public abstract class BaseViewHolderAdapter<T extends BaseViewHolder> extends BaseAdapter
{

	private Activity		mActivity;
	protected View			mView;
	protected int			mPosition;
	private List<Object>	mDatas;

	public BaseViewHolderAdapter(List<Object> datas, Activity activity)
	{
		mDatas = datas;
		mActivity = activity;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		mPosition = position;
		T baseViewHolder = null;
		if (convertView == null)
		{
			mView = setItemView();
			convertView = mView;
			baseViewHolder = setViewHolder();
			initItemView(baseViewHolder);
			convertView.setTag(baseViewHolder);
		}
		else
		{
			baseViewHolder = (T) convertView.getTag();
		}
		initItemData(baseViewHolder);
		return mView;
	}

	protected abstract View setItemView();

	protected abstract void initItemView(T baseViewHolder);

	protected abstract void initItemData(T baseViewHolder);

	protected abstract T setViewHolder();

	@Override
	public int getCount()
	{
		return mDatas == null ? 0 : mDatas.size();
	}

	@Override
	public Object getItem(int position)
	{
		return mDatas == null ? null : mDatas.get(position);
	}

	@Override
	public long getItemId(int position)
	{
		return position;
	}

}
