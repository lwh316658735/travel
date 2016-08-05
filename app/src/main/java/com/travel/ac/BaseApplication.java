package com.travel.ac;

import android.app.Application;
import android.os.Handler;
import android.util.Log;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by lwh on 2016/4/25. description 全局Application类
 */
public class BaseApplication extends Application
{
	private static final String	LOG_TAG	= "BaseApplication";
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
		//初始化推送
		Log.e(LOG_TAG, "BaseApplication: ");
		JPushInterface.setDebugMode(true);
		JPushInterface.init(this);
	}

}
