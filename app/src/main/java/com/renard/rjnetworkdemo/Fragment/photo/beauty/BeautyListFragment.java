package com.renard.rjnetworkdemo.Fragment.photo.beauty;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.renard.rjnetwork.Base.BaseFragment;
import com.renard.rjnetwork.Base.BasePresenter;
import com.renard.rjnetwork.Base.LoadDataView;
import com.renard.rjnetwork.recyclerview.adapter.BaseQuickAdapter;
import com.renard.rjnetwork.recyclerview.helper.RecyclerViewHelper;
import com.renard.rjnetwork.recyclerview.listener.OnRequestDataListener;
import com.renard.rjnetworkdemo.R;
import com.renard.rjnetworkdemo.adapter.SlideInBottomAdapter;
import com.renard.rjnetwork.local.table.BeautyPhotoInfo;
import com.renard.rjnetworkdemo.injector.components.DaggerBeautyListComponent;
import com.renard.rjnetworkdemo.injector.modules.BeautyListModule;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Riven_rabbit on 12/15/20
 *
 * @author suyanan
 */
public class BeautyListFragment extends BaseFragment<BasePresenter> implements LoadDataView<List<BeautyPhotoInfo>> {

    @BindView(R.id.rv_photo_list)
    RecyclerView mRvPhotoList;
    @BindView(R.id.iv_transition_photo)
    ImageView mIvTransitionPhoto;

    @Inject
    BaseQuickAdapter mAdapter;
    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_photo_list;
    }

    @Override
    protected void initInjector() {
        DaggerBeautyListComponent.builder()
                .applicationComponent(getAppComponent())
                .beautyListModule(new BeautyListModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void initViews() {
        SlideInBottomAdapter slideAdapter = new SlideInBottomAdapter(mAdapter);
        RecyclerViewHelper.initRecyclerViewSV(mContext,mRvPhotoList,slideAdapter,2);
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
    public void loadData(List<BeautyPhotoInfo> photoList) {
        mAdapter.updateItems(photoList);
    }

    @Override
    public void loadMoreData(List<BeautyPhotoInfo> photoList) {
        mAdapter.loadComplete();
        mAdapter.addItems(photoList);
    }

    @Override
    public void loadNoData() {
        mAdapter.loadAbnormal();
    }
}
