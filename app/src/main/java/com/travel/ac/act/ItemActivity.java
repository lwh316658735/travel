package com.travel.ac.act;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.travel.R;
import com.travel.ac.adapter.SpotListViewAdapter;
import com.travel.ac.bean.GlobalParameter;
import com.travel.ac.bean.SpotTicketJson;
import com.travel.ac.utils.NetworkHelper;
import com.travel.ac.utils.mProgressDialog;

import java.util.ArrayList;
import java.util.List;

public class ItemActivity extends BaseActivity {
    private ImageView ivBack;
    private TextView  tvTitleContent;
    private TextView  tvRegister;
    private ListView  lvSpotList;
    private String    mDescript;
    List datas;
    private String mAction = "/read_travel_ticket";
    private String              mTable;
    private SpotListViewAdapter mSpotListViewAdapter;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_item;
    }

    @Override
    protected void initData() {
        String title = getIntent().getStringExtra("title");
        int    id    = getIntent().getIntExtra("id", 0);
        switch (id) {
            case 0:
                mTable = "";
                mDescript = "";
                break;
            case 1:
                mTable = "?table=spot_list3";
                mDescript = "&table=spot_description3";
                break;
            case 2:
                mTable = "?table=spot_list4";
                mDescript = "&table=spot_description4";
                break;
            case 3:
                mTable = "?table=spot_list5";
                mDescript = "&table=spot_description5";
                break;
        }
        setTitle(title, true);

        datas = new ArrayList();

        mSpotListViewAdapter = new SpotListViewAdapter(datas, mActivity);
        lvSpotList.setAdapter(mSpotListViewAdapter);

        mProgressDialog mProgressDialog = new mProgressDialog(this, new mProgressDialog.mProgressListener() {
            @Override
            public void onProgress() {
                NetworkHelper.requestAndResponse(mActivity, GlobalParameter.URL_ROOT + mAction + mTable, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        SpotTicketJson spotTicketJson = new Gson().fromJson(response, SpotTicketJson.class);
                        datas = spotTicketJson.getList();
                        mSpotListViewAdapter.setDatas(datas);
                        mSpotListViewAdapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(mActivity, "网络异常,请检查网络", Toast.LENGTH_LONG).show();
                        if (datas.size() <= 0) {
                            lvSpotList.setAdapter(null);
                            View view = View.inflate(mActivity, R.layout.item_spot, null);
                            ((ViewGroup) lvSpotList.getParent()).addView(view);
                            lvSpotList.setEmptyView(view);
                        }
                    }
                });
            }

            @Override
            public void onCancel() {

            }
        });
        mProgressDialog.show();
        lvSpotList.setOnItemClickListener(new ListViewOnClick());
    }

    @Override
    protected void initView() {
        ivBack = (ImageView) findViewById(R.id.iv_back);
        tvTitleContent = (TextView) findViewById(R.id.tv_title_content);
        tvRegister = (TextView) findViewById(R.id.tv_register);
        lvSpotList = (ListView) findViewById(R.id.lv_spot_list);
    }

    class ListViewOnClick implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            List<Object> datas = mSpotListViewAdapter.getDatas();
            if (datas != null && datas.size() > 0) {
                SpotTicketJson.ListBean bean = (SpotTicketJson.ListBean) datas.get(position);
                final int               id2  = bean.getId();
                Intent                  in   = new Intent(mActivity, ParticularSpotActivity.class);
                in.putExtra("id", id2);
                in.putExtra("price", bean.getPrice());
                in.putExtra("name", bean.getName());
                in.putExtra("table", mDescript);
                startActivity(in);
            }

        }
    }
}
