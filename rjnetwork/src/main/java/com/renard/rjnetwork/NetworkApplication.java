package com.renard.rjnetwork;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.Logger;
import com.renard.rjnetwork.injector.components.ApplicationComponent;

import org.greenrobot.greendao.database.Database;

import java.io.File;

/**
 * Created by Riven_rabbit on 2018/11/28
 */
public class NetworkApplication extends Application {

    private static ApplicationComponent sAppComponent;
    private static Context sContext;

    public static ApplicationComponent getAppComponent() {
        return sAppComponent;
    }

    public static Context getContext() {
        return sContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        _initDatabase();
        _initInjector();
        _initConfig();
    }

    /**
     * 初始化注射器
     */
    private void _initInjector() {
        // 这里不做注入操作，只提供一些全局单例数据

    }

    /**
     * 初始化数据库
     */
    private void _initDatabase() {

    }

    /**
     * 初始化配置
     */
    private void _initConfig() {

    }
}
