package com.travel.ac.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.travel.ac.adapter.viewholder.BaseViewHolder;

import java.util.List;

/**
 * Created by lwh on 2016/4/29. description 一个通用的Adapter
 */
public abstract class BaseViewHolderAdapter<T extends BaseViewHolder> extends BaseAdapter
{

	protected Activity		mActivity;
	protected View			mView;
	protected int			mPosition;
	protected List<Object>	mDatas;

	public List<Object> getDatas()
	{
		return mDatas;
	}

	public void setDatas(List datas)
	{
		mDatas = datas;
	}

	/**
	 * 
	 * @param datas
	 *            数据源
	 * @param activity
	 */
	public BaseViewHolderAdapter(List datas, Activity activity)
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
		return convertView;
	}

	/**
	 * 返回item的布局对象
	 * 
	 * @return
	 */
	protected abstract View setItemView();

	/**
	 * 初始化item的控件
	 * 
	 * @param baseViewHolder
	 *            holder
	 */
	protected abstract void initItemView(T baseViewHolder);

	/**
	 * 子类实现listview需要完成的逻辑
	 * 
	 * @param baseViewHolder
	 *            holder
	 */
	protected abstract void initItemData(T baseViewHolder);

	/**
	 * 返回对应的item的viewholder
	 * 
	 * @return
	 */
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
