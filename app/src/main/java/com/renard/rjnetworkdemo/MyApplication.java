package com.renard.rjnetworkdemo;

import com.renard.rjnetwork.NetworkApplication;
import com.renard.rjnetwork.local.table.DaoMaster;
import com.renard.rjnetwork.local.table.DaoSession;
import com.renard.rjnetworkdemo.api.RetrofitService;
import com.renard.rjnetworkdemo.local.dao.NewsTypeDao;

import org.greenrobot.greendao.database.Database;

import static org.greenrobot.greendao.test.DbTest.DB_NAME;

/**
 * Created by Riven_rabbit on 2018/11/29
 */
public class MyApplication extends NetworkApplication {

    private DaoSession mDaoSession;

    private static final String DB_NAME = "news-db";

    @Override
    public void onCreate() {
        super.onCreate();

        RetrofitService.init();
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(getApplicationContext(), DB_NAME);
        Database database = helper.getWritableDb();
        mDaoSession = new DaoMaster(database).newSession();
        NewsTypeDao.updateLocalData(getApplicationContext(), mDaoSession);
    }
}
