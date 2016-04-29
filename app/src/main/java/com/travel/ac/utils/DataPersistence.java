package com.travel.ac.utils;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by lwh on 2016/4/29. description
 */
public class DataPersistence
{
	private static final String	LOG_TAG	= "DataPersistence";

	public static void addData(Activity context, String key, Object data)
	{
		SharedPreferences preferences = context.getPreferences(0);
		SharedPreferences.Editor edit = preferences.edit();
		if (data instanceof Boolean)
		{
			edit.putBoolean(key, (Boolean) data);
		}
		else if (data instanceof Integer)
		{
			edit.putInt(key, (Integer) data);
		}
		else if (data instanceof Double)
		{
			edit.putFloat(key, (Float) data);
		}
		else if (data instanceof Float)
		{
			edit.putFloat(key, (Float) data);
		}
		else if (data instanceof String)
		{
			edit.putString(key, (String) data);
		}
		else if (data instanceof Long)
		{
			edit.putLong(key, (Long) data);
		}
		else
		{
			Log.e(LOG_TAG, "persistence data failed");
		}
		edit.commit();
	}

	public static SharedPreferences getData(Activity context)
	{
		SharedPreferences preferences = context.getPreferences(0);
		return preferences;
	}
}
