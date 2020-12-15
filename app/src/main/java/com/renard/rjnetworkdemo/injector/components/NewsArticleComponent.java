package com.renard.rjnetworkdemo.injector.components;

import com.renard.rjnetwork.injector.PerActivity;
import com.renard.rjnetworkdemo.Fragment.news.article.NewsArticleActivity;
import com.renard.rjnetworkdemo.injector.modules.NewsArticleModule;

import dagger.Component;

/**
 * Created by Riven_rabbit on 12/10/20
 *
 * @author suyanan
 */
@PerActivity
@Component(modules = NewsArticleModule.class)
public interface NewsArticleComponent {
    void inject(NewsArticleActivity activity);
}
