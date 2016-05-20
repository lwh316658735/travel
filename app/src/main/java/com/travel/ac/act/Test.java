package com.travel.ac.act;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.travel.R;
import com.travel.ac.view.CircleImageView;

public class Test extends AppCompatActivity
{

	private Bitmap			mBitmap;
	private CircleImageView	imImage;

	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		imImage = (CircleImageView) findViewById(R.id.im_image);
		imImage.setImage(getDrawable(R.mipmap.main_moren));
//		imImage.setImage(R.mipmap.main_moren);
	}

	public void onclick(View view)
	{
		imImage.setImage(R.mipmap.main_moren);
	}
}
