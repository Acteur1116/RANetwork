package com.renard.rjnetworkdemo.utils;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.renard.rjnetworkdemo.R;
import com.renard.rjnetworkdemo.manage.download.DownloadActivity;

/**
 * Created by Riven_rabbit on 12/28/20
 *
 * @author suyanan
 *
 * Snackbar
 */
public final class SnackbarUtils {

    private SnackbarUtils() {
        throw new AssertionError();
    }

    /**
     * 显示 Snackbar
     * @param activity
     * @param message
     * @param isLong
     */
    public static void showSnackbar(Activity activity, String message, boolean isLong) {
        if (activity == null) {
            return;
        }
        View view = activity.getWindow().getDecorView().findViewById(android.R.id.content);
        Snackbar.make(view, message, isLong ? Snackbar.LENGTH_LONG : Snackbar.LENGTH_SHORT).show();
    }


    /**
     * 显示下载 Snackbar
     * @param activity
     * @param message
     * @param isLong
     */
    public static void showDownloadSnackbar(final Activity activity, String message, boolean isLong) {
        if (activity == null) {
            return;
        }
        View view = activity.getWindow().getDecorView().findViewById(android.R.id.content);
        Snackbar snackbar = Snackbar.make(view, message, isLong ? Snackbar.LENGTH_LONG : Snackbar.LENGTH_SHORT);
        View snackbarView = snackbar.getView();
        if (snackbarView != null) {
            snackbarView.setBackgroundColor(ContextCompat.getColor(activity, R.color.snackbar_bg));
        }
        snackbar.setAction("查看任务>", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadActivity.launch(activity, 1);
            }
        }).show();
    }
}
