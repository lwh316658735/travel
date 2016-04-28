package com.travel.ac.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lwh on 2016/4/27. description 同BaseActivity相似
 */
public abstract class BaseFragment extends Fragment
{
	protected Context		mContext;
	protected View			mView;
	protected final String	SIMPLE_TAG	= getClass().getSimpleName();
	protected final String	TAG			= getClass().getName();
	@Override
	public void onAttach(Context context)
	{
		mContext = context;
		super.onAttach(context);
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		int id = setContentView();
		mView = inflater.inflate(id, container, false);
		initView();
		initData();
		return mView;
	}

	protected abstract int setContentView();

	protected abstract void initView();

	protected abstract void initData();

}
