package com.travel.ac.utils;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by lwh on 2016/5/17. description This is a Properties(key - value)
 * tool class.
 */
public class PropertiesUtils
{
	private final static Properties	PROPERTIES	= new Properties();
	private static final String		TAG			= "PropertiesUtils";
	private static InputStream		in			= null;
	private static OutputStream		out			= null;
	private static File				f;

	public static void init(Context context, String path, String fileName)
	{
		if (path == null || path.equals(""))
		{
			//			context.getFilesDir();
			path = "/data/data/" + context.getPackageName() + "/cache/";
		}
		if (f == null)
		{
			f = new File(path);
			if (!f.exists())
			{
				Log.e(TAG, "init: creating dir");
				f.mkdirs();
			}
			f = new File(path + fileName);
			if (!f.exists())
			{
				try
				{
					f.createNewFile();
					Log.e(TAG, "init: creating file");
				}
				catch (IOException e)
				{
					Log.e(TAG, "creating file failed ");
					e.printStackTrace();
				}
			}
		}
		if (in == null || out == null)
		{
			try
			{
				in = new FileInputStream(f);
				PROPERTIES.load(in);
				out = new FileOutputStream(f, false);

			}
			catch (IOException e)
			{
				Log.e(TAG, "init failed ");
				e.printStackTrace();
			}
		}

	}

	public static void put(String key, String value, boolean commit)
	{
		PROPERTIES.setProperty(key, value);
		if (commit)
			commit();
	}

	public static void commit()
	{
		try
		{
			PROPERTIES.store(out, "");
		}
		catch (IOException e)
		{
			e.printStackTrace();
			close();
		}
	}

	public static void remove(String key, String value)
	{
		PROPERTIES.remove(key);
		commit();
	}

	public static void removeAll()
	{
		PROPERTIES.clear();
		commit();
	}

	public static String get(String key, String defaultValue)
	{
		String property = PROPERTIES.getProperty(key, defaultValue);
		commit();
		return property;

	}

	public static void close()
	{
		f = null;
		if (in != null)
		{
			try
			{
				in.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			finally
			{
				in = null;
			}
		}
		if (out != null)
		{
			try
			{
				out.close();

			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			finally
			{
				out = null;
			}
		}

	}

	public static ArrayList getAll()
	{
		ArrayList<String> arrayList = new ArrayList<>();
		int index = 0;
		Set<Map.Entry<Object,Object>> entries = PROPERTIES.entrySet();
		Iterator<Map.Entry<Object,Object>> iterator = entries.iterator();
		while (iterator.hasNext())
		{
			Map.Entry<Object,Object> next = iterator.next();
			arrayList.add(index, next.getKey() + "  :  " + next.getValue());
			index++;
		}
		commit();
		return arrayList;
	}
}
