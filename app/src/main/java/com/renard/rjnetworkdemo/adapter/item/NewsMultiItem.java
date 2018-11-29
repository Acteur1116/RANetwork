package com.renard.rjnetworkdemo.adapter.item;

import android.support.annotation.IntDef;

import com.renard.rjnetwork.recyclerview.entity.MultiItemEntity;
import com.renard.rjnetworkdemo.api.bean.NewsInfo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Riven_rabbit on 2018/11/29
 */
public class NewsMultiItem extends MultiItemEntity {

    public static final int ITEM_TYPE_NORMAL = 1;
    public static final int ITEM_TYPE_PHOTO_SET = 2;

    private NewsInfo mNewsBean;

    public NewsMultiItem(@NewsItemType int itemType, NewsInfo newsBean) {
        super(itemType);
        mNewsBean = newsBean;
    }

    public NewsInfo getNewsBean() {
        return mNewsBean;
    }

    public void setNewsBean(NewsInfo newsBean) {
        mNewsBean = newsBean;
    }

    @Override
    public void setItemType(@NewsItemType int itemType) {
        super.setItemType(itemType);
    }


    @Retention(RetentionPolicy.SOURCE)
    @IntDef({ITEM_TYPE_NORMAL, ITEM_TYPE_PHOTO_SET})
    public @interface NewsItemType {}
}