package com.travel.ac.act;

import android.content.Intent;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.travel.R;
import com.travel.ac.bean.GlobalParameter;
import com.travel.ac.utils.NetworkHelper;
import com.travel.ac.utils.mProgressDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class OrderSubmitAtivity extends BaseActivity {
    private ImageView ivBack;
    private TextView  tvTitleContent;
    private TextView  tvRegister;
    private EditText  edName;
    private EditText  edPhoneNo;
    private TextView  textView5;
    private TextView  tvPrice;
    private Button    btSubmit;
    private String    mType;
    private String    mPrice;
    private String    mTitle;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_order_submit_ativity;
    }

    @Override
    protected void initData() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvRegister.setVisibility(View.GONE);
        tvTitleContent.setText("门票订单填写");
        mPrice = getIntent().getStringExtra("price");
        mType = getIntent().getStringExtra("type");
        mTitle = getIntent().getStringExtra("title");
        try {
            mTitle = URLEncoder.encode(mTitle, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        tvPrice.setText(mPrice);
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String phoneNo = edPhoneNo.getText().toString();
                final String name    = edName.getText().toString();
                if (!TextUtils.isEmpty(phoneNo) && !TextUtils.isEmpty(name)) {
                    if (GlobalParameter.sLoginBean == null) {
                        Intent in = new Intent(mActivity, LoginActivity.class);
                        startActivity(in);
                        return;
                    }

                    mProgressDialog mProgressDialog = new mProgressDialog(mActivity, new mProgressDialog.mProgressListener() {
                        @Override
                        public void onProgress() {
                            NetworkHelper.requestAndResponse(mActivity,
                                                             GlobalParameter.URL_ROOT + "/read_travel_ticket_order_submit?user=" + GlobalParameter.sLoginBean.getUser() + "&phoneNo=" + phoneNo + "&name=" + name + "&orderNo=" + DateFormat.format(
                                                                     "yyyyhhss", System.currentTimeMillis()) + mType + "&price=" + mPrice + "&title=" + mTitle,
                                                             new Response.Listener<String>() {
                                                                 @Override
                                                                 public void onResponse(String response) {
                                                                     try {

                                                                         JSONObject jsonObject = new JSONObject(response);
                                                                         String     ret        = jsonObject.getString("ret");
                                                                         if (ret.equals("0"))

                                                                         {
                                                                             Toast.makeText(mActivity, "提交订单成功", Toast.LENGTH_LONG).show();
                                                                             finish();
                                                                         } else if (ret.equals("-0")) {
                                                                             Toast.makeText(mActivity, "提交订单失败", Toast.LENGTH_LONG).show();
                                                                             finish();
                                                                         } else {
                                                                             Toast.makeText(mActivity, "请不要重复提交订单", Toast.LENGTH_LONG).show();
                                                                             finish();
                                                                         }
                                                                     } catch (JSONException e) {
                                                                         e.printStackTrace();
                                                                     }
                                                                 }
                                                             });
                        }

                        @Override
                        public void onCancel() {

                        }
                    });
                    mProgressDialog.show();

                    //                    finish();
                } else {
                    Toast.makeText(mActivity, "提交订单失败", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void initView() {
        ivBack = (ImageView) findViewById(R.id.iv_back);
        tvTitleContent = (TextView) findViewById(R.id.tv_title_content);
        tvRegister = (TextView) findViewById(R.id.tv_register);
        edName = (EditText) findViewById(R.id.ed_name);
        edPhoneNo = (EditText) findViewById(R.id.ed_phone_no);
        textView5 = (TextView) findViewById(R.id.textView5);
        tvPrice = (TextView) findViewById(R.id.tv_price);
        btSubmit = (Button) findViewById(R.id.bt_submit);

    }
}
