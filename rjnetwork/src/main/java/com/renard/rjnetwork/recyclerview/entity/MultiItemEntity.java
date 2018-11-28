package com.renard.rjnetwork.recyclerview.entity;

import java.io.Serializable;

/**
 * Created by Riven_rabbit on 2018/11/28
 */
public abstract class MultiItemEntity implements Serializable {
    protected int itemType;

    public MultiItemEntity(int itemType) {
        this.itemType = itemType;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }
}

