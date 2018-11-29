package com.renard.rjnetwork.Base;

/**
 * Created by Riven_rabbit on 2018/11/29
 * 加载数据的界面接口
 */
public interface LoadDataView <T> extends BaseView  {
    /**
     * 加载数据
     * @param data 数据
     */
    void loadData(T data);

    /**
     * 加载更多
     * @param data 数据
     */
    void loadMoreData(T data);

    /**
     * 没有数据
     */
    void loadNoData();
}
