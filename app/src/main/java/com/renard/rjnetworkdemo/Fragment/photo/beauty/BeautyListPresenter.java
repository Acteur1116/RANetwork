package com.renard.rjnetworkdemo.Fragment.photo.beauty;

import com.orhanobut.logger.Logger;
import com.renard.rjnetwork.Base.BasePresenter;
import com.renard.rjnetwork.Base.LoadDataView;
import com.renard.rjnetworkdemo.api.RetrofitService;
import com.renard.rjnetwork.local.table.BeautyPhotoInfo;

import java.util.List;

import rx.Subscriber;
import rx.functions.Action0;

/**
 * Created by Riven_rabbit on 12/15/20
 *
 * @author suyanan
 */
public class BeautyListPresenter implements BasePresenter {

    private final LoadDataView mView;

    private int mPage = 0;

    public BeautyListPresenter(LoadDataView view) {
        this.mView = view;
    }

    @Override
    public void getData(boolean isRefresh) {
        // 因为网易这个原接口参数一大堆，我只传了部分参数，返回的数据会出现图片重复的情况，请不要在意这个问题- -
        RetrofitService.getBeautyPhoto(mPage)
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mView.showLoading();
                    }
                })
                .compose(mView.<List<BeautyPhotoInfo>>bindToLife())
                .subscribe(new Subscriber<List<BeautyPhotoInfo>>() {
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
                    public void onNext(List<BeautyPhotoInfo> photoList) {
                        mView.loadData(photoList);
                        mPage++;
                    }
                });
    }

    @Override
    public void getMoreData() {
        RetrofitService.getBeautyPhoto(mPage)
                .compose(mView.<List<BeautyPhotoInfo>>bindToLife())
                .subscribe(new Subscriber<List<BeautyPhotoInfo>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.e(e.toString());
                        mView.loadNoData();
                    }

                    @Override
                    public void onNext(List<BeautyPhotoInfo> photoList) {
                        mView.loadMoreData(photoList);
                        mPage++;
                    }
                });
    }
}
