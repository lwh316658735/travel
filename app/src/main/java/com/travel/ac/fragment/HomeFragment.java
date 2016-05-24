package com.travel.ac.fragment;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.travel.R;
import com.travel.ac.act.ParticularSpotActivity;
import com.travel.ac.adapter.MainListViewAdapter;
import com.travel.ac.bean.GlobalParameter;
import com.travel.ac.bean.TravelListBean;
import com.travel.ac.utils.NetworkHelper;
import com.travel.ac.utils.PropertiesUtils;
import com.travel.ac.utils.Utils;

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
    private SwipeRefreshLayout srlRefresh;

    @Override
    protected int setContentView() {
        return R.layout.home_fragment;
    }

    @Override
    protected void initView() {

        srlRefresh = (SwipeRefreshLayout) mView.findViewById(R.id.srl_refresh);

        mListView = (ListView) mView.findViewById(R.id.lv_home_list);
    }

    @Override
    protected void initData() {
        datas = new ArrayList();
        final Gson gson = new Gson();
        mMainListViewAdapter = new MainListViewAdapter(datas, (Activity) mContext, HomeFragment.this);
        String cacheData = PropertiesUtils.get("home", "");
        mListView.setAdapter(mMainListViewAdapter);
        srlRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                NetworkHelper.requestAndResponse((Activity) mContext, GlobalParameter.URL_ROOT + "/read_travel_list", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        TravelListBean                travelListBean = gson.fromJson(response, TravelListBean.class);
                        List<TravelListBean.ListBean> list           = travelListBean.getList();
                        PropertiesUtils.put(String.valueOf("home"), response, true);
                        mMainListViewAdapter.setDatas(list);
                        mMainListViewAdapter.notifyDataSetChanged();
                        srlRefresh.setRefreshing(false);
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (srlRefresh.isRefreshing()) {
                            srlRefresh.setRefreshing(false);
                            Toast.makeText(mContext, "刷新失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        if (!TextUtils.isEmpty(cacheData)) {
            TravelListBean travelListBean = gson.fromJson(cacheData, TravelListBean.class);
            mMainListViewAdapter.setDatas(travelListBean.getList());
            mMainListViewAdapter.notifyDataSetChanged();
        } else {
            NetworkHelper.requestAndResponse((Activity) mContext, GlobalParameter.URL_ROOT + "/read_travel_list", new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    TravelListBean                travelListBean = gson.fromJson(response, TravelListBean.class);
                    List<TravelListBean.ListBean> list           = travelListBean.getList();
                    PropertiesUtils.put(String.valueOf("home"), response, true);
                    mMainListViewAdapter.setDatas(list);
                    mMainListViewAdapter.notifyDataSetChanged();
                }
            });
        }
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
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int scrollState) {
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_FLING) {
                    if (!Utils.hasHoneycomb()) {
                        mMainListViewAdapter.getImageFetcher().setPauseWork(true);
                    }
                } else {
                    mMainListViewAdapter.getImageFetcher().setPauseWork(false);
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
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
