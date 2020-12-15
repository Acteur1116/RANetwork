package com.renard.rjnetworkdemo.Fragment.news.article;

import com.renard.rjnetwork.Base.BaseView;
import com.renard.rjnetworkdemo.Fragment.news.detail.bean.NewsDetailInfo;

/**
 * Created by Riven_rabbit on 12/10/20
 *
 * @author suyanan
 */
public interface NewsArticleView extends BaseView {

    void loadData(NewsDetailInfo newsDetailInfo);
}
