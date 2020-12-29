package com.renard.rjnetworkdemo.injector.modules;

import com.renard.rjnetwork.Base.RxBusPresenter;
import com.renard.rjnetwork.adapter.ViewPagerAdapter;
import com.renard.rjnetwork.injector.PerFragment;
import com.renard.rjnetwork.local.table.DaoSession;
import com.renard.rjnetwork.rxbus.RxBus;
import com.renard.rjnetworkdemo.Fragment.video.main.VideoMainFragment;
import com.renard.rjnetworkdemo.Fragment.video.main.VideoMainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Riven_rabbit on 12/23/20
 *
 * @author suyanan
 */
@Module
public class VideoMainModule {
    private final VideoMainFragment mView;

    public VideoMainModule(VideoMainFragment view){
        mView=view;
    }

    @PerFragment
    @Provides
    public ViewPagerAdapter provideViewPagerAdapter(){
        return new ViewPagerAdapter(mView.getChildFragmentManager());
    }

    @PerFragment
    @Provides
    public RxBusPresenter provideVideosPresenter(DaoSession daoSession, RxBus rxBus){
        return new VideoMainPresenter(mView,daoSession.getVideoInfoDao(),rxBus);
    }
}
