package com.renard.rjnetworkdemo.Fragment.cunfangyigemokuai;

import com.orhanobut.logger.Logger;
import com.renard.rjnetwork.Base.RxBusPresenter;
import com.renard.rjnetwork.local.table.NewsTypeInfo;
import com.renard.rjnetwork.local.table.NewsTypeInfoDao;
import com.renard.rjnetwork.rxbus.RxBus;

import java.util.List;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by Riven_rabbit on 2018/11/29
 */
public class NewsMainPresenter implements RxBusPresenter {

    private final NewsMainView mView;
    private final NewsTypeInfoDao mDbDao;
    private final RxBus mRxBus;

    public NewsMainPresenter(NewsMainView view, NewsTypeInfoDao dbDao, RxBus rxBus) {
        mView = view;
        mDbDao = dbDao;
        mRxBus = rxBus;
    }

    @Override
    public void getData(boolean isRefresh) {
        mDbDao.queryBuilder().rx().list()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<NewsTypeInfo>>() {
                    @Override
                    public void call(List<NewsTypeInfo> newsTypeBeen) {
                        mView.loadData(newsTypeBeen);
                    }
                });
    }

    @Override
    public void getMoreData() {
    }

    @Override
    public <T> void registerRxBus(Class<T> eventType, Action1<T> action) {
        Subscription subscription = mRxBus.doSubscribe(eventType, action, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Logger.e(throwable.toString());
            }
        });
        mRxBus.addSubscription(this, subscription);
    }

    @Override
    public void unregisterRxBus() {
        mRxBus.unSubscribe(this);
    }
}