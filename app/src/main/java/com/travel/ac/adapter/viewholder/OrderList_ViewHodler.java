package com.travel.ac.adapter.viewholder;

import android.widget.TextView;

/**
 * Created by lwh on 2016/5/9. description
 */
public class OrderList_ViewHodler extends BaseViewHolder
{
	private TextView	price;
	private TextView	title;
	private TextView	orderNo;
	private TextView	payDate;

	public TextView getPrice()
	{
		return price;
	}

	public void setPrice(TextView price)
	{
		this.price = price;
	}

	public TextView getTitle()
	{
		return title;
	}

	public void setTitle(TextView title)
	{
		this.title = title;
	}

	public TextView getOrderNo()
	{
		return orderNo;
	}

	public void setOrderNo(TextView orderNo)
	{
		this.orderNo = orderNo;
	}

	public TextView getPayDate()
	{
		return payDate;
	}

	public void setPayDate(TextView payDate)
	{
		this.payDate = payDate;
	}
}
