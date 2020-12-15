package com.renard.rjnetworkdemo.injector.components;

/**
 * Created by Riven_rabbit on 12/9/20
 *
 * @author suyanan
 */

import com.renard.rjnetwork.injector.PerActivity;
import com.renard.rjnetworkdemo.Fragment.news.detail.NewsDetailActivity;
import com.renard.rjnetworkdemo.injector.modules.NewsDetailModule;

import dagger.Component;

/**
 * Created by long on 2016/8/23.
 * 新闻详情 Component
 */

@PerActivity
@Component(modules = NewsDetailModule.class)
public interface NewsDetailComponent {
    void inject(NewsDetailActivity activity);
}

