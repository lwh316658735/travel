package com.travel.ac.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.travel.R;
import com.travel.ac.adapter.viewholder.OrderItemViewHolder;

import java.util.List;

/**
 * Created by lwh on 2016/4/29. description
 */
public class OrderMenuAdapter extends BaseViewHolderAdapter<OrderItemViewHolder> {
    private static final String LOG_TAG = "OrderMenuAdapter";
    private Activity mActivity;

    public OrderMenuAdapter(List<Object> datas, Activity activity) {
        super(datas, activity);
        mActivity = activity;
    }

    @Override
    protected View setItemView() {
        return View.inflate(mActivity, R.layout.item_order_listview, null);
    }

    @Override
    protected void initItemView(OrderItemViewHolder baseViewHolder) {
        baseViewHolder.setText((TextView) mView.findViewById(R.id.tv_item_text));
        baseViewHolder.setIco((ImageView) mView.findViewById(R.id.imageView2));
        baseViewHolder.setClick((ImageView) mView.findViewById(R.id.iv_item_click));
    }

    @Override
    protected void initItemData(final OrderItemViewHolder baseViewHolder) {
        baseViewHolder.getText().setText(getItem(mPosition).toString());
        baseViewHolder.getClick().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(LOG_TAG, "onClick: " + baseViewHolder.getText().getText().toString());
            }
        });
    }

    @Override
    protected OrderItemViewHolder setViewHolder() {
        return new OrderItemViewHolder();
    }

}
