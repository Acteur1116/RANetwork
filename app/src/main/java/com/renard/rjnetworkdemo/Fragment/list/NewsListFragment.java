package com.renard.rjnetworkdemo.Fragment.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.renard.rjnetwork.Base.BaseFragment;
import com.renard.rjnetwork.Base.BasePresenter;
import com.renard.rjnetwork.recyclerview.adapter.BaseQuickAdapter;
import com.renard.rjnetwork.recyclerview.helper.RecyclerViewHelper;
import com.renard.rjnetwork.recyclerview.listener.OnRequestDataListener;
import com.renard.rjnetworkdemo.R;
import com.renard.rjnetworkdemo.adapter.item.NewsMultiItem;
import com.renard.rjnetworkdemo.api.bean.NewsInfo;
import com.renard.rjnetworkdemo.injector.components.DaggerNewsListComponent;
import com.renard.rjnetworkdemo.injector.modules.NewsListModule;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInRightAnimationAdapter;

/**
 * Created by Riven_rabbit on 2018/11/29
 */
public class NewsListFragment extends BaseFragment<BasePresenter> implements NewsListView{
    private static final String NEWS_TYPE_KEY = "NewsTypeKey";

    @BindView(R.id.rv_news_list)
    RecyclerView mRvNewsList;

    @Inject
    BaseQuickAdapter mAdapter;
//    private SliderLayout mAdSlider;

    private String mNewsId;


    public static NewsListFragment newInstance(String newsId) {
        NewsListFragment fragment = new NewsListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(NEWS_TYPE_KEY, newsId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mNewsId = getArguments().getString(NEWS_TYPE_KEY);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
//        if (mAdSlider != null) {
//            mAdSlider.startAutoCycle();
//        }
    }

    @Override
    public void onStop() {
        super.onStop();
//        if (mAdSlider != null) {
//            mAdSlider.stopAutoCycle();
//        }
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_news_list;
    }

    @Override
    protected void initInjector() {
        DaggerNewsListComponent.builder()
                .applicationComponent(getAppComponent())
                .newsListModule(new NewsListModule(this, mNewsId))
                .build()
                .inject(this);
    }

    @Override
    protected void initViews() {
        SlideInRightAnimationAdapter animAdapter = new SlideInRightAnimationAdapter(mAdapter);
        RecyclerViewHelper.initRecyclerViewV(mContext, mRvNewsList, true, new AlphaInAnimationAdapter(animAdapter));
        mAdapter.setRequestDataListener(new OnRequestDataListener() {
            @Override
            public void onLoadMore() {
                mPresenter.getMoreData();
            }
        });
    }

    @Override
    protected void updateViews(boolean isRefresh) {
        mPresenter.getData(isRefresh);
    }

    @Override
    public void loadData(List<NewsMultiItem> newsList) {
        mAdapter.updateItems(newsList);
    }

    @Override
    public void loadMoreData(List<NewsMultiItem> newsList) {
        mAdapter.loadComplete();
        mAdapter.addItems(newsList);
    }

    @Override
    public void loadNoData() {
        mAdapter.loadAbnormal();
    }

    @Override
    public void loadAdData(NewsInfo newsBean) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.head_news_list, null);
//        mAdSlider = (SliderLayout) view.findViewById(R.id.slider_ads);
//        SliderHelper.initAdSlider(mContext, mAdSlider, newsBean);
        mAdapter.addHeaderView(view);
    }
}
