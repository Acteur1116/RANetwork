package com.renard.rjnetwork.injector.modules;

import android.content.Context;

import com.renard.rjnetwork.NetworkApplication;

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
//    private final DaoSession mDaoSession;
//    private final RxBus mRxBus;

    public ApplicationModule(NetworkApplication application) {
        mApplication = application;
//        mDaoSession = daoSession;
//        mRxBus = rxBus;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return mApplication.getApplicationContext();
    }

//    @Provides
//    @Singleton
//    RxBus provideRxBus() {
//        return mRxBus;
//    }
//
//    @Provides
//    @Singleton
//    DaoSession provideDaoSession() {
//        return mDaoSession;
//    }
}