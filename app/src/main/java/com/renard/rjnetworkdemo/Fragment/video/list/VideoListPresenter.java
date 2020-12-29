package com.renard.rjnetworkdemo.Fragment.video.list;

import com.orhanobut.logger.Logger;
import com.renard.rjnetwork.Base.BasePresenter;
import com.renard.rjnetwork.Base.LoadDataView;
import com.renard.rjnetwork.local.table.VideoInfo;
import com.renard.rjnetworkdemo.api.RetrofitService;

import java.util.List;

import rx.Subscriber;
import rx.functions.Action0;

/**
 * Created by Riven_rabbit on 12/28/20
 *
 * @author suyanan
 */
public class VideoListPresenter implements BasePresenter {
    private final LoadDataView mView;
    private final String mVideoId;

    private int mPage=0;

    public VideoListPresenter(LoadDataView mView, String mVideoId) {
        this.mView = mView;
        this.mVideoId = mVideoId;
    }

    @Override
    public void getData(boolean isRefresh) {
        RetrofitService.getVideoList(mVideoId,mPage)
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mView.showLoading();
                    }
                })
                .compose(mView.<List<VideoInfo>>bindToLife())
                .subscribe(new Subscriber<List<VideoInfo>>() {
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
                    public void onNext(List<VideoInfo> videoList) {
                        mView.loadData(videoList);
                        mPage++;
                    }
                });
    }

    @Override
    public void getMoreData() {
        RetrofitService.getVideoList(mVideoId,mPage)
                .compose(mView.<List<VideoInfo>>bindToLife())
                .subscribe(new Subscriber<List<VideoInfo>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.e(e.toString());
                        mView.loadNoData();
                    }

                    @Override
                    public void onNext(List<VideoInfo> videoList) {
                        mView.loadMoreData(videoList);
                        mPage++;
                    }
                });
    }
}
