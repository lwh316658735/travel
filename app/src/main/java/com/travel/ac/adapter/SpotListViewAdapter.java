package com.travel.ac.adapter;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;
import com.travel.R;
import com.travel.ac.adapter.viewholder.SpotListViewHolder;
import com.travel.ac.bean.SpotTicketJson;

import java.util.List;

/**
 * Created by lwh on 2016/5/9. description
 */
public class SpotListViewAdapter extends BaseViewHolderAdapter<SpotListViewHolder> {
    /**
     * @param datas
     * 数据源
     * @param activity
     */
    private SpotListViewHolder[] mSpotListViewHolders;
    private static final String TAG = "SpotListViewAdapter";

    public SpotListViewAdapter(List datas, Activity activity) {
        super(datas, activity);
    }

    public SpotListViewHolder[] getSpotListViewHolders() {
        return mSpotListViewHolders;
    }

    @Override
    protected View setItemView() {
        return View.inflate(mActivity, R.layout.item_spot, null);
    }

    @Override
    protected void initItemView(SpotListViewHolder baseViewHolder) {
        mSpotListViewHolders[mPosition] = baseViewHolder;
        baseViewHolder.setIcon((ImageView) mView.findViewById(R.id.iv_item_spot));
        baseViewHolder.setTitle((TextView) mView.findViewById(R.id.tv_item_title));
        baseViewHolder.setContent((TextView) mView.findViewById(R.id.tv_item_description));
        baseViewHolder.setPrice((TextView) mView.findViewById(R.id.tv_item_price));
    }

    @Override
    protected void initItemData(SpotListViewHolder baseViewHolder) {
        mSpotListViewHolders[mPosition] = baseViewHolder;
        SpotTicketJson.ListBean spotListViewBean = (SpotTicketJson.ListBean) mDatas.get(mPosition);
        baseViewHolder.getTitle().setText(spotListViewBean.getName());
        BitmapUtils bitmapUtils = new BitmapUtils(mActivity);
        bitmapUtils.display(baseViewHolder.getIcon(), spotListViewBean.getUrl());
        baseViewHolder.getContent().setText(spotListViewBean.getDescription());
        baseViewHolder.getPrice().setText("￥" + spotListViewBean.getPrice());
    }

    @Override
    public void setDatas(List datas) {
        super.setDatas(datas);
        mSpotListViewHolders = new SpotListViewHolder[datas.size()];
    }

    @Override
    protected SpotListViewHolder setViewHolder() {
        return new SpotListViewHolder();
    }
}
