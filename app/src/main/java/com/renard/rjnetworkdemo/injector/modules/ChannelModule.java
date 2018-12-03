package com.renard.rjnetworkdemo.injector.modules;

import com.renard.rjnetwork.injector.PerActivity;
import com.renard.rjnetwork.local.table.DaoSession;
import com.renard.rjnetwork.recyclerview.adapter.BaseQuickAdapter;
import com.renard.rjnetwork.rxbus.RxBus;
import com.renard.rjnetworkdemo.Fragment.channel.ChannelActivity;
import com.renard.rjnetworkdemo.Fragment.channel.ChannelPresenter;
import com.renard.rjnetworkdemo.Fragment.channel.IChannelPresenter;
import com.renard.rjnetworkdemo.adapter.ManageAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Riven_rabbit on 2018/12/3
 */
@Module
public class ChannelModule {
    private final ChannelActivity mView;

    public ChannelModule(ChannelActivity view) {
        mView = view;
    }

    @Provides
    public BaseQuickAdapter provideManageAdapter() {
        return new ManageAdapter(mView);
    }

    @PerActivity
    @Provides
    public IChannelPresenter provideManagePresenter(DaoSession daoSession, RxBus rxBus) {
        return new ChannelPresenter(mView, daoSession.getNewsTypeInfoDao(), rxBus);
    }
}
