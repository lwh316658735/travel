package com.travel.ac.adapter.viewholder;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by lwh on 2016/5/3. description
 */
public class MyTravelViewHolder extends BaseViewHolder
{
	private ImageView	ivIco;
	private TextView	tvItemText;

	public ImageView getIvIco()
	{
		return ivIco;
	}

	public void setIvIco(ImageView ivIco)
	{
		this.ivIco = ivIco;
	}

	public TextView getTvItemText()
	{
		return tvItemText;
	}

	public void setTvItemText(TextView tvItemText)
	{
		this.tvItemText = tvItemText;
	}
}
