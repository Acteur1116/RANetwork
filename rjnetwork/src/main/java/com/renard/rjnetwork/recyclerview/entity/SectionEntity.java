package com.renard.rjnetwork.recyclerview.entity;

/**
 * Created by Riven_rabbit on 2018/11/28
 */
public abstract class SectionEntity<T> {
    public boolean isHeader;
    public T t;
    public String header;

    public SectionEntity(boolean isHeader, String header) {
        this.isHeader = isHeader;
        this.header = header;
        this.t = null;
    }

    public SectionEntity(T t) {
        this.isHeader = false;
        this.header = null;
        this.t = t;
    }
}
