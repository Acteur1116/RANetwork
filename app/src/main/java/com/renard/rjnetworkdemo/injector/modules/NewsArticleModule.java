package com.renard.rjnetworkdemo.injector.modules;

import com.renard.rjnetwork.Base.BasePresenter;
import com.renard.rjnetwork.injector.PerActivity;
import com.renard.rjnetworkdemo.Fragment.news.article.NewsArticleActivity;
import com.renard.rjnetworkdemo.Fragment.news.article.NewsArticlePresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Riven_rabbit on 12/10/20
 *
 * @author suyanan
 */
@Module
public class NewsArticleModule {

    private final String mNewsId;
    private final NewsArticleActivity mView;

    public NewsArticleModule(String mNewsId, NewsArticleActivity mView) {
        this.mNewsId = mNewsId;
        this.mView = mView;
    }

    @PerActivity
    @Provides
    public BasePresenter providePresenter(){
        return new NewsArticlePresenter(mNewsId,mView);
    }
}
