package com.travel.ac.adapter;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.travel.R;
import com.travel.ac.adapter.viewholder.SpotListViewHolder;
import com.travel.ac.bean.SpotListViewBean;

import java.util.List;

/**
 * Created by lwh on 2016/5/9. description
 */
public class SpotListViewAdapter extends BaseViewHolderAdapter<SpotListViewHolder> {
    /**
     * @param datas
     *         数据源
     * @param activity
     */
    public SpotListViewAdapter(List datas, Activity activity) {
        super(datas, activity);
    }

    @Override
    protected View setItemView() {
        return View.inflate(mActivity, R.layout.item_spot, null);
    }

    @Override
    protected void initItemView(SpotListViewHolder baseViewHolder) {
        baseViewHolder.setIcon((ImageView) mView.findViewById(R.id.iv_item_spot));
        baseViewHolder.setTitle((TextView) mView.findViewById(R.id.tv_item_title));
        baseViewHolder.setContent((TextView) mView.findViewById(R.id.tv_item_description));
        baseViewHolder.setPrice((TextView) mView.findViewById(R.id.tv_item_price));
    }

    @Override
    protected void initItemData(SpotListViewHolder baseViewHolder) {
        SpotListViewBean spotListViewBean = (SpotListViewBean) mDatas.get(mPosition);
        baseViewHolder.getTitle().setText(spotListViewBean.getTitle());
        baseViewHolder.getIcon().setBackgroundResource(R.mipmap.item1);
        baseViewHolder.getContent().setText(spotListViewBean.getContent());
        baseViewHolder.getPrice().setText(spotListViewBean.getPrice());
    }

    @Override
    protected SpotListViewHolder setViewHolder() {
        return new SpotListViewHolder();
    }
}
