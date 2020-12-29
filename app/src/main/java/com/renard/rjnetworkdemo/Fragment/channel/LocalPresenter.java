package com.renard.rjnetworkdemo.Fragment.channel;

import com.renard.rjnetwork.Base.BasePresenter;

import java.util.List;

/**
 * Created by Riven_rabbit on 2018/12/3
 */
public interface LocalPresenter <T> extends BasePresenter {

    /**
     * 插入数据
     * @param data  数据
     */
    void insert(T data);

    /**
     * 删除数据
     * @param data  数据
     */
    void delete(T data);

    /**
     * 更新数据
     * @param list   所有数据
     */
    void update(List<T> list);
}
