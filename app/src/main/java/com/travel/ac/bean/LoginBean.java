package com.travel.ac.bean;

/**
 * Created by lwh on 2016/5/5. description
 */
public class LoginBean
{
	private String	psd;
	private String	ret;
	private String	user;

	public String getUser()
	{
		return user;
	}

	public void setUser(String user)
	{
		this.user = user;
	}

	public String getPsd()
	{
		return psd;
	}

	public void setPsd(String psd)
	{
		this.psd = psd;
	}

	public String getRet()
	{
		return ret;
	}

	public void setRet(String ret)
	{
		this.ret = ret;
	}

	@Override
	public String toString()
	{
		return "LoginBean{" +
				"user='" + user + '\'' +
				", psd='" + psd + '\'' +
				", ret='" + ret + '\'' +
				'}';
	}
}
