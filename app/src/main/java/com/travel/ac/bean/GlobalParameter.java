package com.travel.ac.bean;

/**
 * Created by lwh on 2016/5/5. description
 */
public class GlobalParameter
{
	public static String	IP				= "192.168.6.19";
	public static String	URL_ROOT		= "http://" + IP + ":8080/TravelServer";

	public static boolean	ASSERT_LOGIN	= false;
	public static LoginBean	sLoginBean		= null;
}
