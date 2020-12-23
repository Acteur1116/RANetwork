package com.renard.rjnetworkdemo.Fragment.photo.main;


import android.animation.Animator;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.flyco.tablayout.SlidingTabLayout;
import com.renard.rjnetwork.Base.BaseFragment;
import com.renard.rjnetwork.Base.RxBusPresenter;
import com.renard.rjnetwork.adapter.ViewPagerAdapter;
import com.renard.rjnetworkdemo.Fragment.photo.beauty.BeautyListFragment;
import com.renard.rjnetworkdemo.Fragment.photo.welfare.WelfareListFragment;
import com.renard.rjnetworkdemo.R;
import com.renard.rjnetworkdemo.event.LoveEvent;
import com.renard.rjnetworkdemo.injector.components.DaggerPhotoMainComponent;
import com.renard.rjnetworkdemo.injector.modules.PhotoMainModule;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import rx.functions.Action1;

/**
 * Created by Riven_rabbit on 12/15/20
 *
 * @author suyanan
 */
public class PhotoMainFragment extends BaseFragment<RxBusPresenter> implements PhotoMainView{

    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.tab_layout)
    SlidingTabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    @BindView(R.id.iv_count)
    TextView mIvCount;

    @Inject
    ViewPagerAdapter mPagerAdapter;
    private Animator mLovedAnimator;


    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_photo_main;
    }

    @Override
    protected void initInjector() {
        DaggerPhotoMainComponent.builder()
                .applicationComponent(getAppComponent())
                .photoMainModule(new PhotoMainModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void initViews() {
        initToolBar(mToolBar,true,"图片");
        ArrayList<Fragment> fragments=new ArrayList<>();
        fragments.add(new BeautyListFragment());
        fragments.add(new WelfareListFragment());
        fragments.add(new BeautyListFragment());
        mPagerAdapter.setItems(fragments, new String[] {"美女", "福利", "生活"});
        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setViewPager(mViewPager);
        mPresenter.registerRxBus(LoveEvent.class, new Action1<LoveEvent>() {
            @Override
            public void call(LoveEvent loveEvent) {
                mPresenter.getData(false);
            }
        });
    }

    @Override
    protected void updateViews(boolean isRefresh) {
        mPresenter.getData(isRefresh);
    }

    @Override
    public void updateCount(int lovedCount) {
        mIvCount.setText(lovedCount+"");
    }
}
