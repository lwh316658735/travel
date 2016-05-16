package com.travel.ac.act;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.travel.R;

import cn.jpush.android.api.JPushInterface;

public class AboutActivity extends BaseActivity {
    private ImageView ivBack;
    private TextView  tvTitleContent;
    private TextView  tvRegister;
    private TextView  text;
    public static final String  KEY_MESSAGE  = "message";
    public static final String  KEY_EXTRAS   = "extras";
    public static       boolean isForeground = false;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_about;
    }

    @Override
    protected void initData() {
        tvTitleContent.setText("关于");
        tvRegister.setVisibility(View.GONE);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }

        });
        Bundle bundle  = getIntent().getExtras();
        String data = bundle.getString(JPushInterface.EXTRA_ALERT);
        Log.e(LOG_TAG, "initData: " + data);
        if (data != null) {
            text.setText(data);
        }
    }

    @Override
    protected void initView() {

        text = (TextView) findViewById(R.id.text);

        ivBack = (ImageView) findViewById(R.id.iv_back);
        tvTitleContent = (TextView) findViewById(R.id.tv_title_content);
        tvRegister = (TextView) findViewById(R.id.tv_register);

    }
}
