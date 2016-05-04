package com.travel.ac.adapter;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.travel.R;
import com.travel.ac.adapter.viewholder.MainListViewHolder;
import com.travel.ac.bean.MainListViewBean;

import java.util.List;

/**
 * Created by lwh on 2016/5/4. description
 */
public class MainListViewAdapter extends BaseViewHolderAdapter<MainListViewHolder> {

    /**
     * @param datas
     *         数据源
     * @param activity
     */
    public MainListViewAdapter(List datas, Activity activity) {
        super(datas, activity);

    }

    @Override
    protected View setItemView() {
        return View.inflate(mActivity, R.layout.item_main_listview, null);
    }

    @Override
    protected void initItemView(MainListViewHolder baseViewHolder) {
        baseViewHolder.setImager((ImageView) mView.findViewById(R.id.im_image));
        baseViewHolder.setDescribe((TextView) mView.findViewById(R.id.tv_describe));
        baseViewHolder.setAmount((TextView) mView.findViewById(R.id.tv_amount));
    }

    @Override
    protected void initItemData(MainListViewHolder baseViewHolder) {
        MainListViewBean mainListViewBean = (MainListViewBean) getItem(mPosition);
        baseViewHolder.getImager().setBackgroundResource(R.drawable.test);
        baseViewHolder.getDescribe().setText(mainListViewBean.getDescribe());
        baseViewHolder.getAmount().setText(mainListViewBean.getAmount());
    }

    @Override
    protected MainListViewHolder setViewHolder() {
        return new MainListViewHolder();
    }
}
