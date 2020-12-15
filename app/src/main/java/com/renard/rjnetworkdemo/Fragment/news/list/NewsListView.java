package com.renard.rjnetworkdemo.Fragment.news.list;

import com.renard.rjnetwork.Base.LoadDataView;
import com.renard.rjnetworkdemo.adapter.item.NewsMultiItem;
import com.renard.rjnetworkdemo.api.bean.NewsInfo;

import java.util.List;

/**
 * Created by Riven_rabbit on 2018/11/29
 */
public interface NewsListView extends LoadDataView<List<NewsMultiItem>> {
    /**
     * 加载广告数据
     * @param newsBean 新闻
     */
    void loadAdData(NewsInfo newsBean);
}
