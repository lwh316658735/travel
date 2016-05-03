package com.travel.ac.act;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.travel.R;
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
		pager.setAdapter(new PagerAdapter() {
			private TextView	textView2;
			private EditText	tvUser;
			private ImageView	imageView3;
			private TextView	textView3;
			private EditText	tvPassword;
			private Button		btLogin;

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
			public Object instantiateItem(ViewGroup viewGroup, int position)
			{
				View view = View.inflate(mActivity, R.layout.item_pager_login, null);
				init(view);
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
				viewGroup.addView(view);
				return view;
			}

			private void init(View view)
			{
				textView2 = (TextView) view.findViewById(R.id.textView2);
				tvUser = (EditText) view.findViewById(R.id.tv_user);
				imageView3 = (ImageView) view.findViewById(R.id.imageView3);
				textView3 = (TextView) view.findViewById(R.id.textView3);
				tvPassword = (EditText) view.findViewById(R.id.tv_password);
				btLogin = (Button) view.findViewById(R.id.bt_login);
			}

			@Override
			public void destroyItem(ViewGroup container, int position, Object object)
			{
				super.destroyItem(container, position, object);
				container.removeView((View) object);
			}
		});
        indicator.setTitle(getResources().getStringArray(R.array.login_hint));

		indicator.setFades(false);
		indicator.setViewPager(pager);

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
}
