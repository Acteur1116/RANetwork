package com.renard.rjnetworkdemo.injector.components;

import com.renard.rjnetwork.injector.PerActivity;
import com.renard.rjnetwork.injector.components.ApplicationComponent;
import com.renard.rjnetworkdemo.Fragment.video.player.VideoPlayerActivity;
import com.renard.rjnetworkdemo.injector.modules.VideoPlayerModule;

import dagger.Component;

/**
 * Created by Riven_rabbit on 12/25/20
 *
 * @author suyanan
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,modules = VideoPlayerModule.class)
public interface VideoPlayerComponent {
    void inject(VideoPlayerActivity activity);
}
