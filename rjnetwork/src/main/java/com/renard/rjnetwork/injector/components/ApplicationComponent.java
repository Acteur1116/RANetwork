package com.renard.rjnetwork.injector.components;

import android.content.Context;

import com.renard.rjnetwork.Base.BaseActivity;
import com.renard.rjnetwork.injector.modules.ApplicationModule;
import com.renard.rjnetwork.local.table.DaoSession;
import com.renard.rjnetwork.rxbus.RxBus;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Riven_rabbit on 2018/11/28
 * Application Component
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

//    void inject(BaseActivity baseActivity);

    // provide
    Context getContext();
    RxBus getRxBus();
    DaoSession getDaoSession();
}