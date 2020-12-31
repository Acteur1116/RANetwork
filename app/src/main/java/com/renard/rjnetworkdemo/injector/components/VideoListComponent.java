package com.renard.rjnetworkdemo.injector.components;

import com.renard.rjnetwork.injector.PerFragment;
import com.renard.rjnetwork.injector.components.ApplicationComponent;
import com.renard.rjnetworkdemo.Fragment.video.list.VideoListFragment;
import com.renard.rjnetworkdemo.injector.modules.VideoListModule;

import dagger.Component;

/**
 * Created by Riven_rabbit on 12/28/20
 *
 * @author suyanan
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = VideoListModule.class)
public interface VideoListComponent {
    void inject(VideoListFragment fragment);
}
