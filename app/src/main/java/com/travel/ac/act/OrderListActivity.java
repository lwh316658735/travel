package com.travel.ac.act;

import android.widget.ListView;

import com.android.volley.Response;
import com.google.gson.Gson;
import com.travel.R;
import com.travel.ac.adapter.OrderListAdapter;
import com.travel.ac.bean.GlobalParameter;
import com.travel.ac.bean.OrderJson;
import com.travel.ac.utils.NetworkHelper;

import java.util.ArrayList;
import java.util.List;

public class OrderListActivity extends BaseActivity {
    private ListView         lvOrderList;
    private OrderListAdapter mOrderListAdapter;
    private List             mDatas;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_order_list;
    }

    @Override
    protected void initData() {
        final int type = getIntent().getIntExtra("type", 0);
        mDatas = new ArrayList();
        setTitle("订单列表", true);
        NetworkHelper.requestAndResponse(mActivity,
                                         GlobalParameter.URL_ROOT + "/read_travel_ticket_order_query?user=" + GlobalParameter.sLoginBean.getUser() + "&type=" + type,
                                         new Response.Listener<String>() {
                                             @Override
                                             public void onResponse(String response) {
                                                 List<OrderJson.ListBean> list = new Gson().fromJson(response, OrderJson.class).getList();
                                                 mOrderListAdapter.setDatas(list);
                                                 mOrderListAdapter.notifyDataSetChanged();

                                             }
                                         });


        mOrderListAdapter = new OrderListAdapter(mDatas, this);
        lvOrderList.setAdapter(mOrderListAdapter);
    }

    @Override
    protected void initView() {
        lvOrderList = (ListView) findViewById(R.id.lv_order_list);

    }
}
