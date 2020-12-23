package com.renard.rjnetworkdemo.injector.components;

import com.renard.rjnetwork.injector.PerFragment;
import com.renard.rjnetwork.injector.components.ApplicationComponent;
import com.renard.rjnetworkdemo.Fragment.photo.main.PhotoMainFragment;
import com.renard.rjnetworkdemo.injector.modules.PhotoMainModule;

import dagger.Component;

/**
 * Created by Riven_rabbit on 12/15/20
 *
 * @author suyanan
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = PhotoMainModule.class)
public interface PhotoMainComponent {
    void inject(PhotoMainFragment fragment);
}
