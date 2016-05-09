package com.travel.ac.adapter.viewholder;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by lwh on 2016/5/9. description
 */
public class SpotListViewHolder extends BaseViewHolder
{
	private ImageView	icon;
	private TextView	title;
	private TextView	content;
	private TextView	price;

	public ImageView getIcon()
	{
		return icon;
	}

	public void setIcon(ImageView icon)
	{
		this.icon = icon;
	}

	public TextView getTitle()
	{
		return title;
	}

	public void setTitle(TextView title)
	{
		this.title = title;
	}

	public TextView getContent()
	{
		return content;
	}

	public void setContent(TextView content)
	{
		this.content = content;
	}

	public TextView getPrice()
	{
		return price;
	}

	public void setPrice(TextView price)
	{
		this.price = price;
	}
}
