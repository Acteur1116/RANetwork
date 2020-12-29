package com.renard.rjnetworkdemo.Fragment.video.player;

import com.renard.rjnetwork.local.table.DanmakuInfo;
import com.renard.rjnetwork.local.table.VideoInfo;
import com.renard.rjnetworkdemo.Fragment.channel.LocalPresenter;

/**
 * Created by Riven_rabbit on 12/24/20
 *
 * @author suyanan
 */
public interface VideoPresenter extends LocalPresenter<VideoInfo> {
    /**
     * 添加一条弹幕到数据库
     * @param danmakuInfo
     */
    void addDanmaku(DanmakuInfo danmakuInfo);
    /**
     * 清空该视频所有缓存弹幕
     */
    void cleanDanmaku();
}
