package com.renard.rjnetworkdemo.Fragment.photo.main;

import com.orhanobut.logger.Logger;
import com.renard.rjnetwork.Base.RxBusPresenter;
import com.renard.rjnetwork.local.table.BeautyPhotoInfo;
import com.renard.rjnetwork.local.table.BeautyPhotoInfoDao;
import com.renard.rjnetwork.rxbus.RxBus;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by Riven_rabbit on 12/15/20
 *
 * @author suyanan
 */
public class PhotoMainPresenter implements RxBusPresenter {

    private final PhotoMainView mView;
    private final BeautyPhotoInfoDao mDbDao;
    private final RxBus mRxBus;

    public PhotoMainPresenter(PhotoMainView view, BeautyPhotoInfoDao dbDao, RxBus rxBus) {
        mView = view;
        mDbDao = dbDao;
        mRxBus = rxBus;
    }

    @Override
    public void getData(boolean isRefresh) {
        mView.updateCount((int) mDbDao.queryBuilder().where(BeautyPhotoInfoDao.Properties.IsLove.eq(true)).count());
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
