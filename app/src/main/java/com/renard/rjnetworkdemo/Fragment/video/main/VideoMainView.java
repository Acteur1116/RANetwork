package com.renard.rjnetworkdemo.Fragment.video.main;

/**
 * Created by Riven_rabbit on 12/23/20
 *
 * @author suyanan
 */
public interface VideoMainView {
    /**
     * 更新数据
     * @param lovedCount 收藏数
     */
    void updateLoveCount(int lovedCount);
    /**
     * 更新数据
     * @param downloadCount 下载中个数
     */
    void updateDownloadCount(int downloadCount);
}
