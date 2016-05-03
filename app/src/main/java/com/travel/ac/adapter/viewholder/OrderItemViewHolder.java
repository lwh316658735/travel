package com.travel.ac.adapter.viewholder;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by lwh on 2016/4/29. description
 */
public class OrderItemViewHolder extends BaseViewHolder
{
	private TextView	text;
	private ImageView	ico;
	private ImageView	click;

	public TextView getText()
	{
		return text;
	}

	public void setText(TextView text)
	{
		this.text = text;
	}

	public ImageView getIco()
	{
		return ico;
	}

	public void setIco(ImageView ico)
	{
		this.ico = ico;
	}

	public ImageView getClick()
	{
		return click;
	}

	public void setClick(ImageView click)
	{
		this.click = click;
	}
}
