package com.renard.rjnetworkdemo.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.renard.rjnetwork.local.table.VideoInfo;
import com.renard.rjnetwork.recyclerview.adapter.BaseQuickAdapter;
import com.renard.rjnetwork.recyclerview.adapter.BaseViewHolder;
import com.renard.rjnetwork.utils.DefIconFactory;
import com.renard.rjnetwork.utils.ImageLoader;
import com.renard.rjnetworkdemo.Fragment.video.player.VideoPlayerActivity;
import com.renard.rjnetworkdemo.R;

import java.util.List;

/**
 * Created by Riven_rabbit on 12/29/20
 *
 * @author suyanan
 */
public class VideoListAdapter extends BaseQuickAdapter<VideoInfo> {

    public VideoListAdapter(Context context) {
        super(context);
    }

    public VideoListAdapter(Context context, List<VideoInfo> data) {
        super(context, data);
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.adapter_video_list;
    }

    @Override
    protected void convert(BaseViewHolder holder, final VideoInfo item) {
        final ImageView ivPhoto = holder.getView(R.id.iv_photo);
        ImageLoader.loadFitCenter(mContext, item.getCover(), ivPhoto, DefIconFactory.provideIcon());
        holder.setText(R.id.tv_title, item.getTitle());
        holder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoPlayerActivity.launch(mContext, item);
            }
        });
    }
}
