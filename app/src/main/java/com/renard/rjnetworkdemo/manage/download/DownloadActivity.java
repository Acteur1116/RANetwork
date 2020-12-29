package com.renard.rjnetworkdemo.manage.download;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.renard.rjnetwork.Base.BaseActivity;
import com.renard.rjnetwork.Base.RxBusPresenter;
import com.renard.rjnetworkdemo.R;

import static com.renard.rjnetwork.utils.CommonConstant.INDEX_KEY;

/**
 * Created by Riven_rabbit on 12/28/20
 *
 * @author suyanan
 */
public class DownloadActivity extends BaseActivity<RxBusPresenter> {

    public static void launch(Context context, int index) {
        Intent intent = new Intent(context, DownloadActivity.class);
        intent.putExtra(INDEX_KEY, index);
        context.startActivity(intent);
        ((Activity)context).overridePendingTransition(R.anim.zoom_in_entry, R.anim.hold);
    }
    @Override
    protected int attachLayoutRes() {
        return 0;
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
}
