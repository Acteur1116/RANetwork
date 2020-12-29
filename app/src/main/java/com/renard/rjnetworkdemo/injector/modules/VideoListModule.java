package com.renard.rjnetworkdemo.injector.modules;

import com.renard.rjnetwork.Base.BasePresenter;
import com.renard.rjnetwork.injector.PerFragment;
import com.renard.rjnetwork.recyclerview.adapter.BaseQuickAdapter;
import com.renard.rjnetworkdemo.Fragment.video.list.VideoListFragment;
import com.renard.rjnetworkdemo.Fragment.video.list.VideoListPresenter;
import com.renard.rjnetworkdemo.adapter.VideoListAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Riven_rabbit on 12/28/20
 *
 * @author suyanan
 */
@Module
public class VideoListModule {

    private final VideoListFragment mView;
    private final String mVideoId;

    public VideoListModule(VideoListFragment mView, String mVideoId) {
        this.mView = mView;
        this.mVideoId = mVideoId;
    }

    @PerFragment
    @Provides
    public BasePresenter providePresenter(){
        return new VideoListPresenter(mView,mVideoId);
    }

    @PerFragment
    @Provides
    public BaseQuickAdapter provideAdapter(){
        return new VideoListAdapter(mView.getContext());
    }
}
