package com.renard.rjnetworkdemo.injector.modules;

import com.renard.rjnetwork.Base.BasePresenter;
import com.renard.rjnetwork.injector.PerFragment;
import com.renard.rjnetwork.recyclerview.adapter.BaseQuickAdapter;
import com.renard.rjnetworkdemo.Fragment.photo.welfare.WelfareListFragment;
import com.renard.rjnetworkdemo.Fragment.photo.welfare.WelfareListPresenter;
import com.renard.rjnetworkdemo.adapter.WelfarePhotoAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Riven_rabbit on 12/16/20
 *
 * @author suyanan
 */
@Module
public class WelfarePhotoModule {

    private final WelfareListFragment mView;

    public WelfarePhotoModule(WelfareListFragment view) {
        this.mView = view;
    }

    @PerFragment
    @Provides
    public BasePresenter providePresenter() {
        return new WelfareListPresenter(mView);
    }

    @PerFragment
    @Provides
    public BaseQuickAdapter provideAdapter() {
        return new WelfarePhotoAdapter(mView.getContext());
    }
}
