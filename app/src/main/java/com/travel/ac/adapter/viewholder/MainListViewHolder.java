package com.travel.ac.adapter.viewholder;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by lwh on 2016/5/4. description
 */
public class MainListViewHolder extends BaseViewHolder
{
	private ImageView	imager;
	private TextView	describe;
	private TextView	amount;

	public ImageView getImager()
	{
		return imager;
	}

	public void setImager(ImageView imager)
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
}
