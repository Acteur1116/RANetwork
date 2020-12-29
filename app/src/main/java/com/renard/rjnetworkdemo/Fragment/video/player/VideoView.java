package com.renard.rjnetworkdemo.Fragment.video.player;

import com.renard.rjnetwork.Base.BaseView;
import com.renard.rjnetwork.local.table.VideoInfo;

import java.io.InputStream;

/**
 * Created by Riven_rabbit on 12/24/20
 *
 * @author suyanan
 */
public interface VideoView extends BaseView {
    /**
     * 获取Video数据
     * @param videoInfo 数据
     */
    void loadData(VideoInfo videoInfo);

    /**
     * 获取弹幕数据
     * @param inputStream 数据
     */
    void loadDanmakuData(InputStream inputStream);
}
