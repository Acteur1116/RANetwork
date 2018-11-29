package com.renard.rjnetworkdemo.injector.components;


import com.renard.rjnetwork.injector.PerFragment;
import com.renard.rjnetwork.injector.components.ApplicationComponent;
import com.renard.rjnetworkdemo.Fragment.list.NewsListFragment;
import com.renard.rjnetworkdemo.injector.modules.NewsListModule;

import dagger.Component;

/**
 * Created by long on 2016/8/23.
 * 新闻列表 Component
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = NewsListModule.class)
public interface NewsListComponent {
    void inject(NewsListFragment fragment);
}
