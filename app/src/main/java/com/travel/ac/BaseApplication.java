package com.travel.ac;

import android.app.Application;
import android.os.Handler;

/**
 * Created by lwh on 2016/4/25. description 全局Application类
 */
public class BaseApplication extends Application
{
	//全局Application类
	public static Application	sApplication;
	//全局Handler
	public static Handler		sHandler;

	@Override
	public void onCreate()
	{
		super.onCreate();
		sApplication = this;
		sHandler = new Handler();
	}
}
