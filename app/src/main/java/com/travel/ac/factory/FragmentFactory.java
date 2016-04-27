package com.travel.ac.factory;

import android.support.v4.app.Fragment;
import android.support.v4.util.ArrayMap;

import com.travel.ac.fragment.HomeFragment;
import com.travel.ac.fragment.MyOrderFragment;
import com.travel.ac.fragment.MyTravelFragment;

/**
 * 
 * Created by lwh on 2016/4/27. description 这是一个生产Fragment的工厂类
 */
public class FragmentFactory
{
	private static ArrayMap<String,Fragment>	sFragments	= new ArrayMap<>();

	private FragmentFactory()
	{

	}

	/**
	 * 获取指定类名的Fragment
	 * 
	 * @param tag
	 *            类名
	 * @return
	 */
	public static Fragment getTagFragment(String tag)
	{
		Fragment f = null;
		if (sFragments.get(tag) != null)
		{
			return sFragments.get(tag);
		}
		switch (tag)
		{
			case "HomeFragment":
				f = new HomeFragment();
				break;
			case "MyTravelFragment":
				f = new MyTravelFragment();
				break;
			case "MyOrderFragment":
				f = new MyOrderFragment();
				break;
			default:
				f = new HomeFragment();
				break;
		}

		return f;
	}
}
