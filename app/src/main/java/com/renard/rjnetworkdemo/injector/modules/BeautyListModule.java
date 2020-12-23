package com.renard.rjnetworkdemo.injector.modules;

import com.renard.rjnetwork.Base.BasePresenter;
import com.renard.rjnetwork.injector.PerFragment;
import com.renard.rjnetwork.recyclerview.adapter.BaseQuickAdapter;
import com.renard.rjnetworkdemo.Fragment.photo.beauty.BeautyListFragment;
import com.renard.rjnetworkdemo.Fragment.photo.beauty.BeautyListPresenter;
import com.renard.rjnetworkdemo.adapter.BeautyPhotosAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Riven_rabbit on 12/15/20
 *
 * @author suyanan
 */
@Module
public class BeautyListModule {

    private final BeautyListFragment mView;

    public BeautyListModule(BeautyListFragment view) {
        this.mView = view;
    }

    @PerFragment
    @Provides
    public BasePresenter providePresenter() {
        return new BeautyListPresenter(mView);
    }

    @PerFragment
    @Provides
    public BaseQuickAdapter provideAdapter() {
        return new BeautyPhotosAdapter(mView.getContext());
    }
}

