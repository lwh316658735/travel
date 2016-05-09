package com.travel.ac.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.travel.R;

public class mProgressDialog extends ProgressDialog
{

	private Context				mcontext;
	private ImageView			iv_progress;
	private TextView			tv_msg;
	private mProgressListener	mListener;

	private mProgressDialog(Context context)
	{
		super(context, R.style.loading_dialog);
		mcontext = context;
	}

	public mProgressDialog(Context context, mProgressListener listener)
	{
		this(context);
		mcontext = context;
		this.mListener = listener;

	}

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_progress);
		iv_progress = (ImageView) findViewById(R.id.iv_progress);
		tv_msg = (TextView) findViewById(R.id.tv_msg);
		Animation mAnimation = AnimationUtils.loadAnimation(mcontext, R.anim.progress_rotate);
		LinearInterpolator lin = new LinearInterpolator();
		mAnimation.setInterpolator(lin);
		iv_progress.startAnimation(mAnimation);

	}

	@Override
	public void show()
	{
		super.show();
		new Thread(new Runnable() {

			@Override
			public void run()
			{
				SystemClock.sleep(1000);
				mListener.onProgress();
				dismiss();
//				((Activity) mcontext).finish();
			}
		}).start();
	}

	@Override
	public void dismiss()
	{
//		if (((Activity) mcontext).isFinishing()) {
			super.dismiss();
//		}
	}

	@Override
	public void cancel()
	{
		mListener.onCancel();
		super.cancel();
	}

	public void setMassage(String msg)
	{
		tv_msg.setText(msg);
	}

	public interface mProgressListener
	{
		public void onProgress();

		public void onCancel();
	}
}
