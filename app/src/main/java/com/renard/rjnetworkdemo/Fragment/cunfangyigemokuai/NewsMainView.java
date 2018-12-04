package com.renard.rjnetworkdemo.Fragment.cunfangyigemokuai;

import com.renard.rjnetwork.local.table.NewsTypeInfo;

import java.util.List;

/**
 * Created by Riven_rabbit on 2018/11/29
 */
public interface NewsMainView {
    /**
     * 显示数据
     * @param checkList     选中栏目
     */
    void loadData(List<NewsTypeInfo> checkList);
}
