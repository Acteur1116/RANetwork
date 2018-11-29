package com.renard.rjnetwork.Base;

import rx.functions.Action1;

/**
 * Created by Riven_rabbit on 2018/11/29
 */
public interface RxBusPresenter extends BasePresenter {

    /**
     * 注册
     * @param eventType
     * @param <T>
     */
    <T> void registerRxBus(Class<T> eventType, Action1<T> action);

    /**
     * 注销
     */
    void unregisterRxBus();
}