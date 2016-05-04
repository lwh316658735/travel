package com.travel.ac.adapter.viewholder;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by lwh on 2016/5/3. description
 */
public class MainViewHolder extends BaseViewHolder
{
	private ImageView	icon;

	public TextView getTitle()
	{
		return title;
	}

	public void setTitle(TextView title)
	{
		this.title = title;
	}

	public ImageView getIcon()
	{
		return icon;
	}

	public void setIcon(ImageView icon)
	{
		this.icon = icon;
	}

	private TextView	title;
}
