package com.renard.rjnetworkdemo.Fragment.video.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.renard.rjnetwork.Base.BaseFragment;
import com.renard.rjnetwork.Base.BasePresenter;
import com.renard.rjnetwork.Base.LoadDataView;
import com.renard.rjnetwork.local.table.VideoInfo;
import com.renard.rjnetwork.recyclerview.adapter.BaseQuickAdapter;
import com.renard.rjnetwork.recyclerview.helper.RecyclerViewHelper;
import com.renard.rjnetwork.recyclerview.listener.OnRequestDataListener;
import com.renard.rjnetworkdemo.R;
import com.renard.rjnetworkdemo.adapter.SlideInBottomAdapter;
import com.renard.rjnetworkdemo.injector.components.DaggerVideoListComponent;
import com.renard.rjnetworkdemo.injector.modules.VideoListModule;

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
        DaggerVideoListComponent.builder()
                .applicationComponent(getAppComponent())
                .videoListModule(new VideoListModule(this, mVideoId))
                .build()
                .inject(this);
    }

    @Override
    protected void initViews() {
        SlideInBottomAdapter slideAdapter = new SlideInBottomAdapter(mAdapter);
        RecyclerViewHelper.initRecyclerViewV(mContext, mRvPhotoList, slideAdapter);
        mAdapter.setRequestDataListener(new OnRequestDataListener() {
            @Override
            public void onLoadMore() {
                mPresenter.getMoreData();
            }
        });
    }

    @Override
    protected void updateViews(boolean isRefresh) {
        mPresenter.getData(isRefresh);
    }

    @Override
    public void loadData(List<VideoInfo> data) {
        mAdapter.updateItems(data);
        for (VideoInfo bean : data) {
            Log.e("VideoListFragment", bean.toString());
        }
    }

    @Override
    public void loadMoreData(List<VideoInfo> data) {
        mAdapter.loadComplete();
        mAdapter.addItems(data);
    }

    @Override
    public void loadNoData() {
        mAdapter.loadAbnormal();
    }
}
