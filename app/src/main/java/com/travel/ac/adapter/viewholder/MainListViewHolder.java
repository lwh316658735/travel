package com.travel.ac.adapter.viewholder;

import android.support.v4.view.ViewPager;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.travel.ac.view.CircleImageView;
import com.travel.ac.view.CircleView;

/**
 * Created by lwh on 2016/5/4. description
 */
public class MainListViewHolder extends BaseViewHolder
{

	private ViewPager       viewPager;
	private CircleImageView imager;
	private TextView        describe;
	private TextView        amount;
	private GridView        mGridView;
	public SubViewHolder		mSubViewHolder	= new SubViewHolder();

	public GridView getGridView()
	{
		return mGridView;
	}

	public void setGridView(GridView gridView)
	{
		mGridView = gridView;
	}

	public ViewPager getViewPager()
	{
		return viewPager;
	}

	public void setViewPager(ViewPager viewPager)
	{
		this.viewPager = viewPager;
	}

	public CircleImageView getImager()
	{
		return imager;
	}

	public void setImager(CircleImageView imager)
	{
		this.imager = imager;
	}

	public TextView getDescribe()
	{
		return describe;
	}

	public void setDescribe(TextView describe)
	{
		this.describe = describe;
	}

	public TextView getAmount()
	{
		return amount;
	}

	public void setAmount(TextView amount)
	{
		this.amount = amount;
	}

	public class SubViewHolder
	{
		private ImageView	imager;

		public com.travel.ac.view.CircleView getCircleView()
		{
			return CircleView;
		}

		public void setCircleView(com.travel.ac.view.CircleView circleView)
		{
			CircleView = circleView;
		}

		private CircleView	CircleView;

		public ImageView getImager()
		{
			return imager;
		}

		public void setImager(ImageView imager)
		{
			this.imager = imager;
		}
	}
}
