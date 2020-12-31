package com.renard.rjnetworkdemo.Fragment.video.player;

import com.renard.downloaderlib.model.DownloadStatus;
import com.renard.rjnetwork.local.table.DanmakuInfo;
import com.renard.rjnetwork.local.table.DanmakuInfoDao;
import com.renard.rjnetwork.local.table.VideoInfo;
import com.renard.rjnetwork.local.table.VideoInfoDao;
import com.renard.rjnetwork.rxbus.RxBus;
import com.renard.rjnetwork.utils.GsonHelper;
import com.renard.rjnetworkdemo.event.VideoEvent;
import com.renard.rjnetworkdemo.utils.DownloadUtils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;


/**
 * Created by Riven_rabbit on 12/24/20
 *
 * @author suyanan
 */
public class VideoPlayerPresenter implements VideoPresenter{

    private final VideoView mView;
    private final VideoInfoDao mDbDao;
    private final RxBus mRxBus;
    private final VideoInfo mVideoData;
    private final DanmakuInfoDao mDanmakuDao;
    //是否存在数据库记录
    private boolean mIsContains = false;

    public VideoPlayerPresenter(VideoView mView, VideoInfoDao mDbDao, RxBus mRxBus, VideoInfo mVideoData, DanmakuInfoDao mDanmakuDao) {
        this.mView = mView;
        this.mDbDao = mDbDao;
        this.mRxBus = mRxBus;
        this.mVideoData = mVideoData;
        this.mDanmakuDao = mDanmakuDao;
        this.mIsContains = mDbDao.queryBuilder().list().contains(mVideoData);
    }

    @Override
    public void getData(boolean isRefresh) {
        mDbDao.queryBuilder().rx()
                .oneByOne()
                .filter(new Func1<VideoInfo, Boolean>() {
                    @Override
                    public Boolean call(VideoInfo videoInfo) {
                        return mVideoData.equals(videoInfo);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .compose(mView.<VideoInfo>bindToLife())
                .subscribe(new Action1<VideoInfo>() {
                    @Override
                    public void call(VideoInfo videoInfo) {
                        mIsContains = true;
                        mView.loadData(videoInfo);
                    }
                });
        mDanmakuDao.queryBuilder().where(DanmakuInfoDao.Properties.Vid.eq(mVideoData.getVid()))
                .rx()
                .list()
                .map(new Func1<List<DanmakuInfo>, InputStream>() {
                    @Override
                    public InputStream call(List<DanmakuInfo> danmakuInfos) {
                        // 有同志提交了关于 Gson 解析的问题处理，这里去掉之前的 Fastjson
//                        String jsonStr = JSON.toJSONString(danmakuInfos);
                        String jsonStr = GsonHelper.object2JsonStr(danmakuInfos);
                        // 将 String 转为 InputStream
                        InputStream inputStream = new ByteArrayInputStream(jsonStr.getBytes());
                        return inputStream;
                    }
                })
                .compose(mView.<InputStream>bindToLife())
                .subscribe(new Action1<InputStream>() {
                    @Override
                    public void call(InputStream inputStream) {
                        mView.loadDanmakuData(inputStream);
                    }
                });
    }

    @Override
    public void getMoreData() {

    }

    @Override
    public void insert(VideoInfo data) {
        if (mIsContains){
            mDbDao.update(data);
        }else {
            mDbDao.insert(data);
        }
        mRxBus.post(new VideoEvent());
    }

    @Override
    public void delete(VideoInfo data) {
        if (!data.isCollect()&&data.getDownloadStatus()== DownloadStatus.NORMAL){
            mDbDao.delete(data);
            mIsContains=false;
        }else {
            mDbDao.update(data);
        }
        mRxBus.post(new VideoEvent());
    }

    @Override
    public void update(List<VideoInfo> list) {

    }

    @Override
    public void addDanmaku(DanmakuInfo danmakuInfo) {
        mDanmakuDao.insert(danmakuInfo);
    }

    @Override
    public void cleanDanmaku() {
        mDanmakuDao.queryBuilder().where(DanmakuInfoDao.Properties.Vid.eq(mVideoData.getVid()))
                .rx()
                .list()
                .compose(mView.<List<DanmakuInfo>>bindToLife())
                .subscribe(new Action1<List<DanmakuInfo>>() {
                    @Override
                    public void call(List<DanmakuInfo> danmakuInfos) {
                        mDanmakuDao.deleteInTx(danmakuInfos);
                    }
                });
    }
}
