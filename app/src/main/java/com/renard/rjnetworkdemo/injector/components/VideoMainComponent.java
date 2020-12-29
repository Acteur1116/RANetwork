package com.renard.rjnetworkdemo.injector.components;

import com.renard.rjnetwork.injector.PerFragment;
import com.renard.rjnetwork.injector.components.ApplicationComponent;
import com.renard.rjnetworkdemo.Fragment.video.main.VideoMainFragment;
import com.renard.rjnetworkdemo.injector.modules.VideoMainModule;

import dagger.Component;

/**
 * Created by Riven_rabbit on 12/23/20
 *
 * @author suyanan
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = VideoMainModule.class)
public interface VideoMainComponent {
    void inject(VideoMainFragment fragment);
}
