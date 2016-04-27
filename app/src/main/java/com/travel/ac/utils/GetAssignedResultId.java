package com.travel.ac.utils;

import com.travel.ac.BaseApplication;

/**
 * 作者 lwh 日期 2016/1/14
 */
public class GetAssignedResultId
{
	/**
	 * 
	 * @param id
	 * @return
	 */
	public static int GetAssigned(String id)
	{

		return GetAssigned(id, "drawable");
	}

	/**
	 * 
	 * @param id
	 * @param path
	 * @return
	 */
	public static int GetAssigned(String id, String path)
	{

		int drawable = BaseApplication.sApplication.getResources().getIdentifier(id, path, BaseApplication.sApplication.getPackageName());
		return drawable;
	}
}
