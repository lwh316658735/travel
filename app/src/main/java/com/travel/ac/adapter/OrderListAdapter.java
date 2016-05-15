package com.travel.ac.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Response;
import com.travel.R;
import com.travel.ac.adapter.viewholder.OrderList_ViewHodler;
import com.travel.ac.bean.GlobalParameter;
import com.travel.ac.bean.OrderJson;
import com.travel.ac.utils.NetworkHelper;

import java.util.List;

/**
 * Created by lwh on 2016/5/9. description
 */
public class OrderListAdapter extends BaseViewHolderAdapter<OrderList_ViewHodler> {
    /**
     * @param datas
     *         数据源
     * @param activity
     */
    public OrderListAdapter(List datas, Activity activity) {
        super(datas, activity);
    }

    @Override
    protected View setItemView() {
        return View.inflate(mActivity, R.layout.item_order_list, null);
    }

    @Override
    protected void initItemView(OrderList_ViewHodler baseViewHolder) {
        baseViewHolder.setTitle((TextView) mView.findViewById(R.id.tv_order_title));
        baseViewHolder.setOrderNo((TextView) mView.findViewById(R.id.tv_order_no));
        baseViewHolder.setPayDate((TextView) mView.findViewById(R.id.tv_order_date));
        baseViewHolder.setPrice((TextView) mView.findViewById(R.id.tv_order_price));
        baseViewHolder.setTest((Button) mView.findViewById(R.id.test));

    }

    @Override
    protected void initItemData(OrderList_ViewHodler baseViewHolder) {
        final OrderJson.ListBean bean = (OrderJson.ListBean) mDatas.get(mPosition);
        baseViewHolder.getPrice().setText("￥" + (String) bean.getPrice());
        baseViewHolder.getTitle().setText(bean.getTitle());
        baseViewHolder.getOrderNo().setText(bean.getOrderNo());
        baseViewHolder.getPayDate().setText(bean.getDate());
        baseViewHolder.getTest().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NetworkHelper.requestAndResponse(mActivity, GlobalParameter.URL_ROOT + "/read_travel_order_del?orderNo=" + bean.getOrderNo(),
                                                 new Response.Listener<String>() {
                                                     @Override
                                                     public void onResponse(String response) {
                                                         Log.e("====", "onResponse: ");
                                                         mActivity.runOnUiThread(new Runnable() {
                                                             @Override
                                                             public void run() {
                                                                 mDatas.remove(mDatas.get(mPosition));
                                                                 notifyDataSetChanged();

                                                             }
                                                         });

                                                     }
                                                 });
            }

        });
    }

    @Override
    protected OrderList_ViewHodler setViewHolder() {
        return new OrderList_ViewHodler();
    }
}
