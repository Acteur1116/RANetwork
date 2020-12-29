package com.renard.rjnetworkdemo.Fragment.video.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.renard.rjnetwork.Base.BaseFragment;
import com.renard.rjnetwork.Base.BasePresenter;
import com.renard.rjnetwork.Base.LoadDataView;
import com.renard.rjnetwork.local.table.VideoInfo;
import com.renard.rjnetwork.recyclerview.adapter.BaseQuickAdapter;
import com.renard.rjnetworkdemo.R;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;


/**
 * Created by Riven_rabbit on 12/24/20
 *
 * @author suyanan
 */
public class VideoListFragment extends BaseFragment<BasePresenter> implements LoadDataView <List<VideoInfo>>{

    private static final String VIDEO_ID_KEY = "VideoIdKey";

    @BindView(R.id.rv_photo_list)
    RecyclerView mRvPhotoList;

    @Inject
    BaseQuickAdapter mAdapter;
    private String mVideoId;

    public static VideoListFragment newInstance(String videoId){
        VideoListFragment fragment=new VideoListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(VIDEO_ID_KEY,videoId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments()!=null){
            mVideoId=getArguments().getString(VIDEO_ID_KEY);
        }
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_photo_list;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void updateViews(boolean isRefresh) {

    }

    @Override
    public void loadData(List<VideoInfo> data) {

    }

    @Override
    public void loadMoreData(List<VideoInfo> data) {

    }

    @Override
    public void loadNoData() {

    }
}
