package com.renard.rjnetworkdemo.injector.modules;

import com.renard.rjnetwork.injector.PerActivity;
import com.renard.rjnetwork.local.table.DaoSession;
import com.renard.rjnetwork.local.table.VideoInfo;
import com.renard.rjnetwork.rxbus.RxBus;
import com.renard.rjnetworkdemo.Fragment.video.player.VideoPlayerActivity;
import com.renard.rjnetworkdemo.Fragment.video.player.VideoPlayerPresenter;
import com.renard.rjnetworkdemo.Fragment.video.player.VideoPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Riven_rabbit on 12/25/20
 *
 * @author suyanan
 */
@Module
public class VideoPlayerModule {

    private final VideoPlayerActivity mView;
    private final VideoInfo mVideoData;


    public VideoPlayerModule(VideoPlayerActivity mView, VideoInfo mVideoData) {
        this.mView = mView;
        this.mVideoData = mVideoData;
    }

    @PerActivity
    @Provides
    public VideoPresenter providePresenter(DaoSession daoSession, RxBus rxBus){
        return new VideoPlayerPresenter(mView,daoSession.getVideoInfoDao(),rxBus,mVideoData,daoSession.getDanmakuInfoDao());
    }
}
