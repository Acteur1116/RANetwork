package com.renard.rjnetworkdemo.injector.components;

import com.renard.rjnetwork.injector.PerFragment;
import com.renard.rjnetwork.injector.components.ApplicationComponent;
import com.renard.rjnetworkdemo.Fragment.photo.welfare.WelfareListFragment;
import com.renard.rjnetworkdemo.injector.modules.WelfarePhotoModule;

import dagger.Component;

/**
 * Created by Riven_rabbit on 12/16/20
 *
 * @author suyanan
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = WelfarePhotoModule.class)
public interface WelfarePhotoComponent {
    void inject(WelfareListFragment fragment);
}
