package com.travel.ac.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.travel.R;
import com.travel.ac.adapter.viewholder.MyTravelViewHolder;
import com.travel.ac.bean.MyTravelItemBean;
import com.travel.ac.utils.GetAssignedResultId;

import java.util.List;

/**
 * Created by lwh on 2016/5/3. description
 */
public class MyTravelAdapter extends BaseViewHolderAdapter<MyTravelViewHolder> {
    private ImageView ivIco;
    private TextView  text;
    private static final String LOG_TAG = "MyTravelAdapter";
    /**
     * @param datas
     *         数据源
     * @param activity
     */
    public MyTravelAdapter(List datas, Activity activity) {
        super(datas, activity);
    }

    @Override
    protected View setItemView() {
        Log.e(LOG_TAG, "setItemView: " + mPosition);
        if (mPosition == 3) {
            return View.inflate(mActivity, R.layout.item_divider, null);
        } else {
            return View.inflate(mActivity, R.layout.item_my, null);
        }
    }

    @Override
    protected void initItemView(MyTravelViewHolder baseViewHolder) {
        if (mPosition != 3) {
            ivIco = (ImageView) mView.findViewById(R.id.iv_ico);
            text = (TextView) mView.findViewById(R.id.tv_item_text);
        }
    }

    @Override
    protected void initItemData(MyTravelViewHolder baseViewHolder) {
        if (mPosition != 3) {
            MyTravelItemBean myTravelItemBean = (MyTravelItemBean) getItem(mPosition);
            text.setText(myTravelItemBean.getTextStr());
            ivIco.setBackgroundResource(GetAssignedResultId.GetAssigned(myTravelItemBean.getIcoText(), "mipmap"));
        }
    }

    @Override
    protected MyTravelViewHolder setViewHolder() {
        return new MyTravelViewHolder();
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

//    @Override
//    public int getItemViewType(int position) {
//        if (position == 3) {
//            return 0;
//        } else {
//            return 1;
//        }
//    }

    @Override
    public boolean isEnabled(int position) {
        return !(position == 3);
    }
}
