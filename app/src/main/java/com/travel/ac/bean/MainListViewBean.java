package com.travel.ac.bean;

/**
 * Created by lwh on 2016/5/4. description
 */
public class MainListViewBean
{
	private String	imagePath;
	private String	describe;
	private String	amount;

	public String getAmount()
	{
		return amount;
	}

	public void setAmount(String amount)
	{
		this.amount = amount;
	}

	public String getImagePath()
	{
		return imagePath;
	}

	public void setImagePath(String imagePath)
	{
		this.imagePath = imagePath;
	}

	public String getDescribe()
	{
		return describe;
	}

	public void setDescribe(String describe)
	{
		this.describe = describe;
	}
}
