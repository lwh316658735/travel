package com.travel.ac.adapter;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.travel.R;
import com.travel.ac.adapter.viewholder.OrderList_ViewHodler;
import com.travel.ac.bean.OrderListBean;

import java.util.List;

/**
 * Created by lwh on 2016/5/9. description
 */
public class OrderListAdapter extends BaseViewHolderAdapter<OrderList_ViewHodler>
{
	/**
	 * @param datas
	 *            数据源
	 * @param activity
	 */
	public OrderListAdapter(List datas, Activity activity)
	{
		super(datas, activity);
	}

	@Override
	protected View setItemView()
	{
		return View.inflate(mActivity, R.layout.item_order_list, null);
	}

	@Override
	protected void initItemView(OrderList_ViewHodler baseViewHolder)
	{
		baseViewHolder.setTitle((TextView) mView.findViewById(R.id.tv_order_title));
		baseViewHolder.setOrderNo((TextView) mView.findViewById(R.id.tv_order_no));
		baseViewHolder.setPayDate((TextView) mView.findViewById(R.id.tv_order_date));
		baseViewHolder.setPrice((TextView) mView.findViewById(R.id.tv_order_price));

	}

	@Override
	protected void initItemData(OrderList_ViewHodler baseViewHolder)
	{
		OrderListBean bean = (OrderListBean) mDatas.get(mPosition);
		baseViewHolder.getPrice().setText(bean.getPrice());
        baseViewHolder.getTitle().setText(bean.getTitle());
        baseViewHolder.getOrderNo().setText(bean.getOrderNo());
        baseViewHolder.getPayDate().setText(bean.getPayDate());
    }

	@Override
	protected OrderList_ViewHodler setViewHolder()
	{
		return new OrderList_ViewHodler();
	}
}
