package com.renard.rjnetworkdemo.Fragment.video.main;

import com.orhanobut.logger.Logger;
import com.renard.downloaderlib.model.DownloadStatus;
import com.renard.rjnetwork.Base.RxBusPresenter;
import com.renard.rjnetwork.local.table.VideoInfoDao;
import com.renard.rjnetwork.rxbus.RxBus;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by Riven_rabbit on 12/23/20
 *
 * @author suyanan
 */
public class VideoMainPresenter implements RxBusPresenter {

    private final VideoMainView mView;
    private final VideoInfoDao mDbDao;
    private final RxBus mRxBus;

    public VideoMainPresenter(VideoMainView mView,VideoInfoDao dbDao, RxBus mRxBus) {
        this.mView = mView;
        this.mDbDao=dbDao;
        this.mRxBus = mRxBus;
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

    @Override
    public void getData(boolean isRefresh) {
        mView.updateLoveCount((int) mDbDao.queryBuilder().where(VideoInfoDao.Properties.IsCollect.eq(true)).count());
        mView.updateDownloadCount((int) mDbDao.queryBuilder()
                .where(VideoInfoDao.Properties.DownloadStatus.notIn(DownloadStatus.NORMAL, DownloadStatus.COMPLETE)).count());
    }

    @Override
    public void getMoreData() {

    }
}
