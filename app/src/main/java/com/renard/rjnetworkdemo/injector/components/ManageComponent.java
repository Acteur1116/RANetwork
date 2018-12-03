package com.renard.rjnetworkdemo.injector.components;

import com.renard.rjnetwork.injector.PerActivity;
import com.renard.rjnetwork.injector.components.ApplicationComponent;
import com.renard.rjnetworkdemo.Fragment.channel.ChannelActivity;
import com.renard.rjnetworkdemo.injector.modules.ChannelModule;

import dagger.Component;

/**
 * Created by Riven_rabbit on 2018/12/3
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ChannelModule.class)
public interface ManageComponent {
    void inject(ChannelActivity activity);
}
