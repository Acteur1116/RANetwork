package com.renard.rjnetworkdemo;

import com.renard.rjnetwork.NetworkApplication;
import com.renard.rjnetworkdemo.api.RetrofitService;

/**
 * Created by Riven_rabbit on 2018/11/29
 */
public class MyApplication extends NetworkApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        RetrofitService.init();
    }
}
