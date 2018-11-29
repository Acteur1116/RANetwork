package com.renard.rjnetwork.injector.modules;

import android.content.Context;

import com.renard.rjnetwork.NetworkApplication;
import com.renard.rjnetwork.local.table.DaoSession;
import com.renard.rjnetwork.rxbus.RxBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Riven_rabbit on 2018/11/28
 * Application Module
 */
@Module
public class ApplicationModule {

    private final NetworkApplication mApplication;
    private final DaoSession mDaoSession;
    private final RxBus mRxBus;

    public ApplicationModule(NetworkApplication application, DaoSession daoSession, RxBus rxBus) {
        mApplication = application;
        mDaoSession = daoSession;
        mRxBus = rxBus;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return mApplication.getApplicationContext();
    }

    @Provides
    @Singleton
    RxBus provideRxBus() {
        return mRxBus;
    }

    @Provides
    @Singleton
    DaoSession provideDaoSession() {
        return mDaoSession;
    }
}