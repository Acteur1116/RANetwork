package com.renard.rjnetworkdemo.Fragment.news.main;

import com.renard.rjnetwork.local.table.NewsTypeInfo;

import java.util.List;

/**
 * Created by Riven_rabbit on 12/9/20
 *
 * @author suyanan
 */
public interface NewsMainView {
    /**
     * 显示数据
     * @param checkList     选中栏目
     */
    void loadData(List<NewsTypeInfo> checkList);
}
