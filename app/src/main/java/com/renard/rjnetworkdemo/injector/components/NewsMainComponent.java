package com.renard.rjnetworkdemo.injector.components;

import com.renard.rjnetwork.injector.PerFragment;
import com.renard.rjnetwork.injector.components.ApplicationComponent;
import com.renard.rjnetworkdemo.Fragment.cunfangyigemokuai.NewsMainFragment;
import com.renard.rjnetworkdemo.injector.modules.NewsMainModule;

import dagger.Component;

/**
 * Created by Riven_rabbit on 2018/11/29
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = NewsMainModule.class)
public interface NewsMainComponent {
    void inject(NewsMainFragment fragment);
}
