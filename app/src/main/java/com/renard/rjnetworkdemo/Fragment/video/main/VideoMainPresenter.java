package com.renard.rjnetworkdemo.Fragment.video.main;

import com.renard.rjnetwork.Base.RxBusPresenter;
import com.renard.rjnetwork.local.table.VideoInfoDao;
import com.renard.rjnetwork.rxbus.RxBus;

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

    }

    @Override
    public void unregisterRxBus() {

    }

    @Override
    public void getData(boolean isRefresh) {

    }

    @Override
    public void getMoreData() {

    }
}
