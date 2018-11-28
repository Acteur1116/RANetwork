package com.renard.rjnetwork.injector.modules;

import android.app.Activity;


import com.renard.rjnetwork.injector.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Riven_rabbit on 2018/11/28
 * Activity Module
 */
@Module
public class ActivityModule {

    private final Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @PerActivity
    @Provides
    Activity getActivity() {
        return mActivity;
    }
}
