package com.renard.rjnetworkdemo.injector.modules;

import com.renard.rjnetwork.Base.RxBusPresenter;
import com.renard.rjnetwork.adapter.ViewPagerAdapter;
import com.renard.rjnetwork.injector.PerFragment;
import com.renard.rjnetwork.local.table.DaoSession;
import com.renard.rjnetwork.rxbus.RxBus;
import com.renard.rjnetworkdemo.Fragment.photo.main.PhotoMainFragment;
import com.renard.rjnetworkdemo.Fragment.photo.main.PhotoMainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Riven_rabbit on 12/15/20
 *
 * @author suyanan
 */
@Module
public class PhotoMainModule {

    private final PhotoMainFragment mView;

    public PhotoMainModule(PhotoMainFragment view) {
        mView = view;
    }

    @PerFragment
    @Provides
    public RxBusPresenter providePhotosPresenter(DaoSession daoSession, RxBus rxBus) {
        return new PhotoMainPresenter(mView, daoSession.getBeautyPhotoInfoDao(), rxBus);
    }

    @PerFragment
    @Provides
    public ViewPagerAdapter provideViewPagerAdapter() {
        return new ViewPagerAdapter(mView.getChildFragmentManager());
    }
}

