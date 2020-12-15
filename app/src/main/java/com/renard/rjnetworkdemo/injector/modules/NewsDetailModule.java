package com.renard.rjnetworkdemo.injector.modules;

import com.renard.rjnetwork.Base.BasePresenter;
import com.renard.rjnetwork.injector.PerActivity;
import com.renard.rjnetwork.recyclerview.adapter.BaseQuickAdapter;
import com.renard.rjnetworkdemo.Fragment.news.detail.NewsDetailActivity;
import com.renard.rjnetworkdemo.Fragment.news.detail.NewsDetailPresenter;
import com.renard.rjnetworkdemo.adapter.RelatedNewsAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Riven_rabbit on 12/9/20
 *
 * @author suyanan
 *
 * 新闻详情 Module
 */

@Module
public class NewsDetailModule {
    private final String mNewId;
    private final NewsDetailActivity mView;


    public NewsDetailModule(String mNewId, NewsDetailActivity mView) {
        this.mNewId = mNewId;
        this.mView = mView;
    }

    @PerActivity
    @Provides
    public BaseQuickAdapter provideRelatedAdapter(){
        return new RelatedNewsAdapter(mView);
    }

    @PerActivity
    @Provides
    public BasePresenter providePresenter(){
        return new NewsDetailPresenter(mNewId,mView);
    }
}
