package com.travel.ac.fragment;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Response;
import com.google.gson.Gson;
import com.travel.R;
import com.travel.ac.act.ParticularSpotActivity;
import com.travel.ac.adapter.MainListViewAdapter;
import com.travel.ac.bean.GlobalParameter;
import com.travel.ac.bean.TravelListBean;
import com.travel.ac.utils.NetworkHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lwh on 2016/4/27. description
 */
public class HomeFragment extends BaseFragment {

    public static final String LOG_TAG = "HomeFragment";
    private ListView                      mListView;
    private MainListViewAdapter           mMainListViewAdapter;
    private List<TravelListBean.ListBean> datas;
    private String mAction = "/read_travel_ticket";

    @Override
    protected int setContentView() {
        return R.layout.home_fragment;
    }

    @Override
    protected void initView() {
        mListView = (ListView) mView.findViewById(R.id.lv_home_list);
    }

    @Override
    protected void initData() {
        datas = new ArrayList();
        mMainListViewAdapter = new MainListViewAdapter(datas, (Activity) mContext);
        NetworkHelper.requestAndResponse((Activity) mContext, GlobalParameter.URL_ROOT + "/read_travel_list", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson                          gson           = new Gson();
                TravelListBean                travelListBean = gson.fromJson(response, TravelListBean.class);
                List<TravelListBean.ListBean> list           = travelListBean.getList();
                mMainListViewAdapter.setDatas(list);
                mMainListViewAdapter.notifyDataSetChanged();
            }
        });
        mListView.setAdapter(mMainListViewAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position > 1) {
                    TravelListBean.ListBean item = (TravelListBean.ListBean) mMainListViewAdapter.getItem(position);
                    Intent                  in   = new Intent(mContext, ParticularSpotActivity.class);
                    in.putExtra("id", position - 1);
                    in.putExtra("price", item.getPrice());
                    in.putExtra("name", item.getName());
                    in.putExtra("table", "&table=spot_description_home");
                    startActivity(in);
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        //		mTimerTask.cancel();
    }

}
