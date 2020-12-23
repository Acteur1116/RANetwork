package com.renard.rjnetworkdemo.Fragment.photo.welfare;

import android.support.v7.widget.RecyclerView;

import com.renard.rjnetwork.Base.BaseFragment;
import com.renard.rjnetwork.Base.BasePresenter;
import com.renard.rjnetwork.Base.LoadDataView;
import com.renard.rjnetwork.recyclerview.adapter.BaseQuickAdapter;
import com.renard.rjnetwork.recyclerview.helper.RecyclerViewHelper;
import com.renard.rjnetwork.recyclerview.listener.OnRequestDataListener;
import com.renard.rjnetworkdemo.R;
import com.renard.rjnetworkdemo.adapter.SlideInBottomAdapter;
import com.renard.rjnetworkdemo.api.bean.WelfarePhotoInfo;
import com.renard.rjnetworkdemo.injector.components.DaggerWelfarePhotoComponent;
import com.renard.rjnetworkdemo.injector.modules.WelfarePhotoModule;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Riven_rabbit on 12/16/20
 *
 * @author suyanan
 */
public class WelfareListFragment extends BaseFragment<BasePresenter> implements LoadDataView<List<WelfarePhotoInfo>> {

    @BindView(R.id.rv_photo_list)
    RecyclerView mRvPhotoList;

    @Inject
    BaseQuickAdapter mAdapter;


    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_photo_list;
    }

    @Override
    protected void initInjector() {
        DaggerWelfarePhotoComponent.builder()
                .applicationComponent(getAppComponent())
                .welfarePhotoModule(new WelfarePhotoModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void initViews() {
        SlideInBottomAdapter slideAdapter = new SlideInBottomAdapter(mAdapter);
        RecyclerViewHelper.initRecyclerViewSV(mContext, mRvPhotoList, slideAdapter, 2);
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
    public void loadData(List<WelfarePhotoInfo> photoList) {
        mAdapter.updateItems(photoList);
    }

    @Override
    public void loadMoreData(List<WelfarePhotoInfo> photoList) {
        mAdapter.loadComplete();
        mAdapter.addItems(photoList);
    }

    @Override
    public void loadNoData() {
        mAdapter.loadAbnormal();
    }
}
