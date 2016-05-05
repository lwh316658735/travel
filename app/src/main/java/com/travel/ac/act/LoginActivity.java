package com.travel.ac.act;

import android.support.v4.myview.ViewPager;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.google.gson.Gson;
import com.travel.R;
import com.travel.ac.bean.GlobalParameter;
import com.travel.ac.bean.LoginBean;
import com.travel.ac.utils.NetworkHelper;
import com.travel.ac.utils.mProgressDialog;
import com.travel.ac.view.UnderlinePageIndicator;

public class LoginActivity extends BaseActivity
{
	private ImageView				ivBack;
	private TextView				tvTitleContent;
	private TextView				tvRegister;
	private UnderlinePageIndicator	indicator;
	private ViewPager				pager;

	@Override
	protected int setLayoutId()
	{
		return R.layout.activity_login;
	}

	@Override
	protected void initData()
	{
		LoginPagerAdapter loginPagerAdapter = new LoginPagerAdapter();
		pager.setAdapter(loginPagerAdapter);

		pager.setOffscreenPageLimit(0);
		indicator.setTitle(getResources().getStringArray(R.array.login_hint));

		indicator.setFades(false);
		indicator.setViewPager(pager);
		ivBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v)
			{
				finish();
			}
		});
	}

	@Override
	protected void initView()
	{
		ivBack = (ImageView) findViewById(R.id.iv_back);
		tvTitleContent = (TextView) findViewById(R.id.tv_title_content);
		tvRegister = (TextView) findViewById(R.id.tv_register);
		indicator = (UnderlinePageIndicator) findViewById(R.id.indicator);
		pager = (ViewPager) findViewById(R.id.pager);

	}

	class LoginPagerAdapter extends PagerAdapter
	{
		private TextView		textView2;
		private EditText		tvUser;
		private ImageView		imageView3;
		private TextView		textView3;
		private EditText		tvPassword;
		private Button			btLogin;
		private ViewHolder[]	mViewHolders	= new ViewHolder[2];

		@Override
		public int getCount()
		{
			return 2;
		}

		@Override
		public boolean isViewFromObject(View view, Object object)
		{
			return view == object;
		}

		@Override
		public Object instantiateItem(ViewGroup viewGroup, final int position)
		{
			View view = View.inflate(mActivity, R.layout.item_pager_login, null);
			textView2 = (TextView) view.findViewById(R.id.textView2);
			imageView3 = (ImageView) view.findViewById(R.id.imageView3);
			textView3 = (TextView) view.findViewById(R.id.textView3);
			btLogin = (Button) view.findViewById(R.id.bt_login);
			if (mViewHolders.length <= 2)
			{
				mViewHolders[position] = new ViewHolder();
				tvUser = (EditText) view.findViewById(R.id.tv_user);
				tvPassword = (EditText) view.findViewById(R.id.tv_password);
				mViewHolders[position].setTvPassword(tvPassword);
				mViewHolders[position].setTvUser(tvUser);
			}
			else
			{
				tvPassword = mViewHolders[position].getTvPassword();
				tvUser = mViewHolders[position].getTvUser();
			}
			if (position == 0)
			{
				textView2.setText(R.string.userNo);
				tvUser.setHint(R.string.user_hint);
				textView3.setText(R.string.passwordText);
				tvPassword.setHint(R.string.password_hint);

			}
			else
			{
				textView2.setText(R.string.phoneNo);
				tvUser.setHint(R.string.input_phone);
				textView3.setText(R.string.checkNo);
				tvPassword.setHint(R.string.input_checkNP);
			}
			btLogin.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v)
				{
					mProgressDialog msProgressDialog = new mProgressDialog(mActivity, new mProgressDialog.mProgressListener() {
						@Override
						public void onProgress()
						{
							NetworkHelper.requestAndResponse(mActivity,
																GlobalParameter.URL_ROOT + "/loginAct?user="
																		+ mViewHolders[position].getTvUser().getText().toString()
																		+ "&psd="
																		+ mViewHolders[position].getTvPassword().getText().toString(),
																new Response.Listener<String>() {
																	@Override
																	public void onResponse(String response)
																	{
																		Log.e(LOG_TAG, "onResponse: " + response);
																		Gson gson = new Gson();
																		LoginBean loginBean = gson.fromJson(response, LoginBean.class);

																	}
																});
						}

						@Override
						public void onCancel()
						{
							NetworkHelper.cancel();
						}
					});
					msProgressDialog.show();
				}

			});
			viewGroup.addView(view);
			return view;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object)
		{
			super.destroyItem(container, position, object);
			container.removeView((View) object);
		}
	}

	class ViewHolder
	{
		private EditText	tvUser;
		private EditText	tvPassword;
		private Button		btLogin;

		public EditText getTvUser()
		{
			return tvUser;
		}

		public void setTvUser(EditText tvUser)
		{
			this.tvUser = tvUser;
		}

		public EditText getTvPassword()
		{
			return tvPassword;
		}

		public void setTvPassword(EditText tvPassword)
		{
			this.tvPassword = tvPassword;
		}

		public Button getBtLogin()
		{
			return btLogin;
		}

		public void setBtLogin(Button btLogin)
		{
			this.btLogin = btLogin;
		}
	}
}
