package com.renard.rjnetworkdemo.injector.modules;



import com.renard.rjnetwork.Base.BasePresenter;
import com.renard.rjnetwork.injector.PerFragment;
import com.renard.rjnetwork.recyclerview.adapter.BaseQuickAdapter;
import com.renard.rjnetworkdemo.Fragment.list.NewsListFragment;
import com.renard.rjnetworkdemo.Fragment.list.NewsListPresenter;
import com.renard.rjnetworkdemo.adapter.NewsMultiListAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by long on 2016/8/23.
 * 新闻列表 Module
 */
@Module
public class NewsListModule {

    private final NewsListFragment mNewsListView;
    private final String mNewsId;

    public NewsListModule(NewsListFragment view, String newsId) {
        this.mNewsListView = view;
        this.mNewsId = newsId;
    }

    @PerFragment
    @Provides
    public BasePresenter providePresenter() {
        return new NewsListPresenter(mNewsListView, mNewsId);
    }

    @PerFragment
    @Provides
    public BaseQuickAdapter provideAdapter() {
        return new NewsMultiListAdapter(mNewsListView.getContext());
    }
}
