package com.renard.rjnetworkdemo.Fragment.news.detail;

import com.renard.rjnetwork.Base.BaseView;
import com.renard.rjnetworkdemo.Fragment.news.detail.bean.NewsDetailInfo;

/**
 * Created by Riven_rabbit on 12/8/20
 *
 * @author suyanan
 */
public interface NewsDetailView extends BaseView {

    /**
     * 显示数据
     * @param newsDetailBean 新闻详情
     */
    void loadData(NewsDetailInfo newsDetailBean);
}
