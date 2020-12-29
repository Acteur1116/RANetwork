package com.renard.downloaderlib.helper;

import com.renard.downloaderlib.DownloadListener;
import com.renard.downloaderlib.entity.FileInfo;
import com.renard.downloaderlib.model.DownloadStatus;
import com.renard.downloaderlib.service.DownloadThreadPool;

/**
 * Created by Riven_rabbit on 12/25/20
 *
 * @author suyanan
 */
public final class ListenerDecorator implements DownloadListener {

    private final DownloadListener mListener;
    private final boolean mIsUiThread;

    public ListenerDecorator(DownloadListener listener, boolean isUiThread) {
        this.mListener = listener;
        this.mIsUiThread = isUiThread;
    }


    @Override
    public void onStart(final FileInfo fileInfo) {
        fileInfo.setStatus(DownloadStatus.START);
        if (mIsUiThread) {
            MainHandler.getInstance().runInMainThread(new Runnable() {
                @Override
                public void run() {
                    mListener.onStart(fileInfo);
                }
            });
        } else {
            mListener.onStart(fileInfo);
        }
    }

    @Override
    public void onUpdate(final FileInfo fileInfo) {
        fileInfo.setStatus(DownloadStatus.DOWNLOADING);
        if (mIsUiThread) {
            MainHandler.getInstance().runInMainThread(new Runnable() {
                @Override
                public void run() {
                    mListener.onUpdate(fileInfo);
                }
            });
        } else {
            mListener.onUpdate(fileInfo);
        }
    }

    @Override
    public void onStop(final FileInfo fileInfo) {
        fileInfo.setStatus(DownloadStatus.STOP);
        if (mIsUiThread) {
            MainHandler.getInstance().runInMainThread(new Runnable() {
                @Override
                public void run() {
                    mListener.onStop(fileInfo);
                }
            });
        } else {
            mListener.onStop(fileInfo);
        }
    }

    @Override
    public void onComplete(final FileInfo fileInfo) {
        fileInfo.setStatus(DownloadStatus.COMPLETE);
        if (mIsUiThread) {
            MainHandler.getInstance().runInMainThread(new Runnable() {
                @Override
                public void run() {
                    mListener.onComplete(fileInfo);
                }
            });
        } else {
            mListener.onComplete(fileInfo);
        }
        DownloadThreadPool.getInstance().cancel(fileInfo.getUrl(), false);
    }

    @Override
    public void onCancel(final FileInfo fileInfo) {
        fileInfo.setStatus(DownloadStatus.CANCEL);
        if (mIsUiThread) {
            MainHandler.getInstance().runInMainThread(new Runnable() {
                @Override
                public void run() {
                    mListener.onCancel(fileInfo);
                }
            });
        } else {
            mListener.onCancel(fileInfo);
        }
        DownloadThreadPool.getInstance().cancel(fileInfo.getUrl(), true);
    }

    @Override
    public void onError(final FileInfo fileInfo, final String errorMsg) {
        fileInfo.setStatus(DownloadStatus.ERROR);
        if (mIsUiThread) {
            MainHandler.getInstance().runInMainThread(new Runnable() {
                @Override
                public void run() {
                    mListener.onError(fileInfo, errorMsg);
                }
            });
        } else {
            mListener.onError(fileInfo, errorMsg);
        }
        DownloadThreadPool.getInstance().cancel(fileInfo.getUrl(), false);
    }
}

