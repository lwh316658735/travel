package com.travel.ac.adapter;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.travel.BuildConfig;
import com.travel.R;
import com.travel.ac.act.ItemActivity;
import com.travel.ac.adapter.viewholder.MainListViewHolder;
import com.travel.ac.bean.MyTravelItemBean;
import com.travel.ac.bean.TravelListBean;
import com.travel.ac.utils.GetAssignedResultId;
import com.travel.ac.utils.ImageCache;
import com.travel.ac.utils.ImageFetcher;
import com.travel.ac.view.CircleView;
import com.travel.ac.view.RecyclingImageView;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Outline;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by lwh on 2016/5/4. description
 */
public class MainListViewAdapter extends BaseViewHolderAdapter<MainListViewHolder> {
    private GridView   gvMainView;
    private ViewPager  vpMain;
    private CircleView cvMainCount;
    private int mNumber = 5;
    private MyTask mTimerTask;
    private Timer  mTimer;
    private static final String LOG_TAG = "MainListViewAdapter";
    private final List         mDatas2;
    private final MainAdapter  mMainAdapter;
    private final MyViewPager  mMyViewPager;
    private final ImageFetcher mImageFetcher;

    /**
     * @param datas
     *         数据源
     * @param activity
     */
    public MainListViewAdapter(List datas, Activity activity, Fragment f) {
        super(datas, activity);
        mTimerTask = new MyTask();
        mTimer = new Timer();
        mDatas2 = new ArrayList();
        for (int i = 0; i < 8; i++) {
            mDatas2.add(new MyTravelItemBean());
        }
        mMainAdapter = new MainAdapter(mDatas2, mActivity);
        mMyViewPager = new MyViewPager();
        mTimer.schedule(mTimerTask, 5000, 3000);
        ImageCache.ImageCacheParams imageCacheParams = new ImageCache.ImageCacheParams(activity, "home");
        imageCacheParams.setMemCacheSizePercent(0.25f);
        InputStream inputStream = mActivity.getResources().openRawResource(R.mipmap.main_moren);
        Bitmap      bitmap      = BitmapFactory.decodeStream(inputStream);
        mImageFetcher = new ImageFetcher(mActivity, bitmap.getWidth(), bitmap.getHeight());
        mImageFetcher.setLoadingImage(R.mipmap.main_moren);
        mImageFetcher.addImageCache(f.getFragmentManager(), imageCacheParams);
        mImageFetcher.getImageCache().getCacheItemSize();
    }

    public ImageFetcher getImageFetcher() {
        return mImageFetcher;
    }

    @Override
    protected View setItemView() {
        View view = null;
        if (mPosition > 1) {
            view = View.inflate(mActivity, R.layout.item_main_listview, null);

        } else if (mPosition == 0) {
            view = View.inflate(mActivity, R.layout.item_home_top, null);
        } else if (mPosition == 1) {
            view = View.inflate(mActivity, R.layout.item_home_center, null);
        }
        return view;
    }

    @Override
    protected void initItemView(MainListViewHolder baseViewHolder) {
        if (mPosition == 0) {
            CircleView cv = (CircleView) mView.findViewById(R.id.cv_main_count);
            baseViewHolder.mSubViewHolder.setCircleView(cv);
            baseViewHolder.setViewPager((ViewPager) mView.findViewById(R.id.vp_main));
        }
        if (mPosition == 1) {
            baseViewHolder.setGridView((GridView) mView.findViewById(R.id.gv_main_view));
        }
        if (mPosition > 1) {
            baseViewHolder.setImager((RecyclingImageView) mView.findViewById(R.id.im_image));
            baseViewHolder.setDescribe((TextView) mView.findViewById(R.id.tv_describe));
            baseViewHolder.setAmount((TextView) mView.findViewById(R.id.tv_amount));
        }

    }

    @Override
    protected void initItemData(MainListViewHolder baseViewHolder) {
        if (mPosition > 1) {
            RecyclingImageView imager = baseViewHolder.getImager();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                imager.setOutlineProvider(new ViewOutlineProvider() {
                    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void getOutline(View view, Outline outline) {
                        final int margin = Math.min(view.getWidth(), view.getHeight()) / 20;
                        outline.setRoundRect(margin, margin, view.getWidth() - margin, view.getHeight() - margin, margin / 2);
                    }
                });
                if (!imager.getClipToOutline()) {
                    imager.setClipToOutline(true);

                }
            }

            TravelListBean.ListBean mainListViewBean = (TravelListBean.ListBean) getItem(mPosition);
            mImageFetcher.loadImage(mainListViewBean.getUrl(), baseViewHolder.getImager());
            baseViewHolder.getDescribe().setText(mainListViewBean.getDescription());
            baseViewHolder.getAmount().setText(mainListViewBean.getPrice());

        } else if (mPosition == 1) {
            gvMainView = baseViewHolder.getGridView();
            ListAdapter adapter = gvMainView.getAdapter();
            if (adapter != mMainAdapter || adapter == null) {
                Log.e(LOG_TAG, "gvMainView set Adapter");
                gvMainView.setAdapter(mMainAdapter);
            }
            gvMainView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent in = new Intent();
                    in.setClass(mActivity, ItemActivity.class);
                    switch (position) {
                        case 0:
                            in.putExtra("title", "景区门票");
                            in.putExtra("id", 0);
                            break;
                        case 1:
                            in.putExtra("title", "国内游");
                            in.putExtra("id", 1);
                            break;
                        case 2:
                            in.putExtra("title", "酒店");
                            in.putExtra("id", 2);
                            break;
                        case 3:
                            in.putExtra("title", "周边");
                            in.putExtra("id", 3);
                            break;

                    }
                    if (position > 3) {
                        Toast.makeText(mActivity, "未添加改功能", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    mActivity.startActivity(in);
                }
            });

        } else if (mPosition == 0) {
            vpMain = baseViewHolder.getViewPager();
            cvMainCount = baseViewHolder.mSubViewHolder.getCircleView();
            cvMainCount.setNumber(mNumber);
            if (vpMain.getAdapter() != mMyViewPager) {
                Log.e(LOG_TAG, "vpMain set Adapter");
                vpMain.setAdapter(mMyViewPager);
                //TODO setCurrentItem方法放到判断外会ANR
                vpMain.setCurrentItem(mNumber * 1000);
            }
            vpMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    int index = Math.abs(position - 1000) % 5;
                    cvMainCount.setSelectedCircle(index);
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });

        }
    }

    @Override
    protected MainListViewHolder setViewHolder() {
        return new MainListViewHolder();
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        int type;
        if (position == 0) {
            type = 0;
        } else if (position == 1) {
            type = 1;
        } else {
            type = 2;
        }
        return type;
    }

    @Override
    public boolean isEnabled(int position) {
        if (position > 1) {
            return true;
        } else {
            return false;
        }
    }

    class MyTask extends TimerTask {
        @Override
        public void run() {
            mActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (vpMain != null) {
                        int currentItem = vpMain.getCurrentItem();
                        vpMain.setCurrentItem(++currentItem);
                    }
                }
            });

        }
    }

    class MyViewPager extends PagerAdapter {
        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            //TODO listView中嵌套viewpager时，viewpager必须给出具体高度
            ImageView                 imageView    = new ImageView(mActivity);
            LinearLayout              linearLayout = new LinearLayout(mActivity);
            LinearLayout.LayoutParams params1      = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            linearLayout.setLayoutParams(params1);
            linearLayout.addView(imageView);
            int mipmap = GetAssignedResultId.GetAssigned("banner_" + ((position - 1000) % 5), "mipmap");
            imageView.setBackgroundResource(mipmap);
            container.addView(linearLayout);
            return linearLayout;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    @Override
    public Object getItem(int position) {

        return mDatas == null ? null : mDatas.get(position - 2);
    }

    @Override
    public int getCount() {
        return 2 + super.getCount();
    }
}
