package com.renard.playerview.danmuku;

import android.util.Log;

import com.renard.playerview.media.IjkPlayerView;

import master.flame.danmaku.danmaku.model.AbsDanmakuSync;

/**
 * Created by Riven_rabbit on 12/22/20
 *
 * @author suyanan
 */
@Deprecated
public class VideoDanmakuSync extends AbsDanmakuSync {

    private final IjkPlayerView mPlayerView;

    public VideoDanmakuSync(IjkPlayerView playerView) {
        mPlayerView = playerView;
    }


    @Override
    public long getUptimeMillis() {
        if (mPlayerView != null) {
            Log.i("VideoDanmakuSync", ""+mPlayerView.getCurPosition());
            return mPlayerView.getCurPosition();
        }
        return -1L;
    }

    @Override
    public int getSyncState() {
        if (mPlayerView.isPlaying()) {
            Log.e("VideoDanmakuSync", "SYNC_STATE_PLAYING");
            return SYNC_STATE_PLAYING;
        } else {
            Log.e("VideoDanmakuSync", "SYNC_STATE_HALT");
            return SYNC_STATE_HALT;
        }
    }

    @Override
    public boolean isSyncPlayingState() {
        return true;
    }
}

