package com.renard.downloaderlib.helper;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by Riven_rabbit on 12/25/20
 *
 * @author suyanan
 */
public class MainHandler {

    private final Handler mHandler;


    private MainHandler() {
        mHandler = new Handler(Looper.getMainLooper());
    }

    private static class HolderClass {
        private static final MainHandler instance = new MainHandler();
    }

    public static MainHandler getInstance() {
        return HolderClass.instance;
    }

    /**
     * 在主线程执行
     * @param runnable
     */
    public void runInMainThread(Runnable runnable) {
        mHandler.post(runnable);
    }
}
