package com.travel.ac.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by lwh on 2016/4/25. description
 */
public class CircleView extends View
{
	private int					mNumber			= 4;
	private float				R				= 10;
	private int					mNormalColor	= Color.GRAY;
	private int					mSelectedColor	= Color.WHITE;
	private Paint				mNormalPaint;
	private Paint				mSelectedPaint;
	private float				mWidth;
	private float				mHeight;
	private float				mSelectedCircle	= 0;
	private float				mStartPoint;
	private float				mInterval		= 0;
	private float				mDensity		= 1.5f;
	private static final String	LOG_TAG			= "CircleView";
	private Context				mContext;

	public int getNumber()
	{
		return mNumber;
	}

	public void setNumber(int number)
	{
		mNumber = number;
	}

	public float getSelectedCircle()
	{
		return mSelectedCircle;
	}

	public void setSelectedCircle(int selectedCircle)
	{
		mSelectedCircle = selectedCircle;
		postInvalidate();
	}

	public CircleView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		mContext = context;
		mNormalPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mSelectedPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mNormalPaint.setColor(mNormalColor);
		mSelectedPaint.setColor(mSelectedColor);
		mDensity = context.getResources().getDisplayMetrics().density;

	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		mWidth = getWidth();
		Log.e(LOG_TAG, "width: " + mWidth);
		mHeight = getHeight();
		mStartPoint = mWidth / 5 * 3 / 2 + 0.5f;
		mInterval = (mWidth - mStartPoint * 2) / (mNumber);
		Log.e(LOG_TAG, "start x: " + mStartPoint);
		Log.e(LOG_TAG, "interval: " + mInterval);
		for (int i = 0; i < mNumber; i++)
		{
			if (i == mSelectedCircle)
			{
				canvas.drawCircle(mStartPoint + (mInterval * i + mInterval / 2), mHeight / 2, R, mSelectedPaint);
			}
			else
			{
				canvas.drawCircle(mStartPoint + (mInterval * i + mInterval / 2), mHeight / 2, R, mNormalPaint);
			}
			Log.e(LOG_TAG, "x: " + (mStartPoint + (mInterval * i + mInterval / 2)));
		}
		super.onDraw(canvas);
	}
}
