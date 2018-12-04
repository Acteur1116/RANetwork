package com.renard.rjnetwork;

import android.app.Application;
import android.content.Context;

import com.renard.rjnetwork.injector.components.ApplicationComponent;
import com.renard.rjnetwork.injector.components.DaggerApplicationComponent;
import com.renard.rjnetwork.injector.modules.ApplicationModule;
import com.renard.rjnetwork.local.dao.NewsTypeDao;
import com.renard.rjnetwork.local.table.DaoMaster;
import com.renard.rjnetwork.local.table.DaoSession;
import com.renard.rjnetwork.rxbus.RxBus;
import com.renard.rjnetwork.utils.CrashHandler;

import org.greenrobot.greendao.database.Database;

/**
 * Created by Riven_rabbit on 2018/11/28
 */
public class NetworkApplication extends Application {
    private static final String DB_NAME = "news-db";

    private static ApplicationComponent sAppComponent;
    private static Context sContext;
    private DaoSession mDaoSession;
    // 因为下载那边需要用，这里在外面实例化在通过 ApplicationModule 设置
    private RxBus mRxBus = new RxBus();

    @Override
    public void onCreate() {
        super.onCreate();
        sContext=getApplicationContext();
        _initDatabase();
        _initInjector();
        _initConfig();
    }
    public static ApplicationComponent getAppComponent() {
        return sAppComponent;
    }

    public static Context getContext() {
        return sContext;
    }
    /**
     * 初始化注射器
     */
    private void _initInjector() {
        // 这里不做注入操作，只提供一些全局单例数据
        sAppComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this, mDaoSession, mRxBus))
                .build();
    }

    /**
     * 初始化数据库
     */
    private void _initDatabase() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(getApplicationContext(), DB_NAME);
        Database database = helper.getWritableDb();
        mDaoSession = new DaoMaster(database).newSession();
        NewsTypeDao.updateLocalData(getApplicationContext(), mDaoSession);
    }

    /**
     * 初始化配置
     */
    private void _initConfig() {
        CrashHandler.getInstance().init(getApplicationContext());

    }
}
