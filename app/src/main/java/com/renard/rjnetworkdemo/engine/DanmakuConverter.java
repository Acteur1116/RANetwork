package com.renard.rjnetworkdemo.engine;

import com.renard.playerview.danmuku.BaseDanmakuConverter;
import com.renard.rjnetwork.local.table.DanmakuInfo;

import master.flame.danmaku.danmaku.model.BaseDanmaku;

/**
 * Created by Riven_rabbit on 12/28/20
 *
 * @author suyanan
 */
public class DanmakuConverter extends BaseDanmakuConverter<DanmakuInfo> {

    private DanmakuConverter(){}
    private static volatile DanmakuConverter instance;

    public static DanmakuConverter instance() {
        if(instance == null){
            synchronized (DanmakuConverter.class){
                if(instance == null)
                    instance = new DanmakuConverter();
            }
        }
        return instance;
    }
    @Override
    public DanmakuInfo convertDanmaku(BaseDanmaku danmaku) {
        DanmakuInfo data = new DanmakuInfo();
        // 弹幕基础数据初始化，重要！记得调用
        initData(data, danmaku);
        return data;
    }
}
