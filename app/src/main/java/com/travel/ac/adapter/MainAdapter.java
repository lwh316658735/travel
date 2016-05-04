package com.travel.ac.adapter;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.travel.R;
import com.travel.ac.adapter.viewholder.MainViewHolder;
import com.travel.ac.utils.GetAssignedResultId;

import java.util.List;

/**
 * Created by lwh on 2016/5/3. description
 */
public class MainAdapter extends BaseViewHolderAdapter<MainViewHolder>
{
	private ImageView	ivMainIcon;
	private TextView	tvIconText;

	/**
	 * @param datas
	 *            数据源
	 * @param activity
	 */
	public MainAdapter(List datas, Activity activity)
	{
		super(datas, activity);
	}

	@Override
	protected View setItemView()
	{
		return View.inflate(mActivity, R.layout.item_groupview_main, null);
	}

	@Override
	protected void initItemView(MainViewHolder baseViewHolder)
	{
		baseViewHolder.setIcon((ImageView) mView.findViewById(R.id.iv_main_icon));
		baseViewHolder.setTitle((TextView) mView.findViewById(R.id.tv_icon_text));
	}

	@Override
	protected void initItemData(MainViewHolder baseViewHolder)
	{
		baseViewHolder.getTitle().setText(mActivity.getResources().getStringArray(R.array.str_main)[mPosition + 1]);
		baseViewHolder.getIcon().setBackgroundResource(GetAssignedResultId.GetAssigned("main_icon_" + (mPosition + 1), "mipmap"));
	}

	@Override
	protected MainViewHolder setViewHolder()
	{
		return new MainViewHolder();
	}
}
