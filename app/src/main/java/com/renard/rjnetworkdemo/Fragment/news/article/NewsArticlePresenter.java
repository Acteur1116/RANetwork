package com.renard.rjnetworkdemo.Fragment.news.article;

import com.orhanobut.logger.Logger;
import com.renard.rjnetwork.Base.BasePresenter;
import com.renard.rjnetwork.utils.ListUtils;
import com.renard.rjnetworkdemo.Fragment.news.detail.bean.NewsDetailInfo;
import com.renard.rjnetworkdemo.api.RetrofitService;

import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;

/**
 * Created by Riven_rabbit on 12/10/20
 *
 * @author suyanan
 */
public class NewsArticlePresenter implements BasePresenter {

    private static final String HTML_IMG_TEMPLATE = "<img src=\"http\" />";

    private final String mNewsId;
    private final NewsArticleView mView;

    public NewsArticlePresenter(String newId,NewsArticleView view) {
        this.mNewsId=newId;
        this.mView=view;
    }

    @Override
    public void getData(boolean isRefresh) {
        RetrofitService.getNewsDetail(mNewsId)
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mView.showLoading();
                    }
                })
                .doOnNext(new Action1<NewsDetailInfo>() {
                    @Override
                    public void call(NewsDetailInfo newsDetailInfo) {
                        RichTextWithImg(newsDetailInfo);
                    }
                })
                .compose(mView.<NewsDetailInfo>bindToLife())
                .subscribe(new Subscriber<NewsDetailInfo>() {
                    @Override
                    public void onCompleted() {
                        mView.hideLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.e(e.toString());
                        mView.showNetError();
                    }

                    @Override
                    public void onNext(NewsDetailInfo newsDetailInfo) {
                        mView.loadData(newsDetailInfo);
                    }
                });
    }

    @Override
    public void getMoreData() {

    }

    /**
     * 处理富文本包含图片的情况
     *
     * @param newsDetailBean 原始数据
     */
    private void RichTextWithImg(NewsDetailInfo newsDetailBean) {
        if (!ListUtils.isEmpty(newsDetailBean.getImg())) {
            String body = newsDetailBean.getBody();
            for (NewsDetailInfo.ImgEntity imgEntity : newsDetailBean.getImg()) {
                String ref = imgEntity.getRef();
                String src = imgEntity.getSrc();
                String img = HTML_IMG_TEMPLATE.replace("http", src);
                body = body.replaceAll(ref, img);
                Logger.w(img);
                Logger.i(body);
            }
            newsDetailBean.setBody(body);
        }
    }
}
