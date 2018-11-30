package com.renard.rjnetworkdemo.injector.modules;

import com.renard.rjnetwork.Base.RxBusPresenter;
import com.renard.rjnetwork.adapter.ViewPagerAdapter;
import com.renard.rjnetwork.injector.PerFragment;
import com.renard.rjnetwork.local.table.DaoSession;
import com.renard.rjnetwork.rxbus.RxBus;
import com.renard.rjnetworkdemo.Fragment.cunfangyigemokuai.NewsMainFragment;
import com.renard.rjnetworkdemo.Fragment.cunfangyigemokuai.NewsMainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Riven_rabbit on 2018/11/29
 */
@Module
public class NewsMainModule {
    private final NewsMainFragment mView;

    public NewsMainModule(NewsMainFragment view) {
        mView = view;
    }
    @PerFragment
    @Provides
    public RxBusPresenter provideMainPresenter(DaoSession daoSession, RxBus rxBus) {
        return new NewsMainPresenter(mView, daoSession.getNewsTypeInfoDao(), rxBus);
    }
    @PerFragment
    @Provides
    public ViewPagerAdapter provideViewPagerAdapter() {
        return new ViewPagerAdapter(mView.getChildFragmentManager());
    }
}
