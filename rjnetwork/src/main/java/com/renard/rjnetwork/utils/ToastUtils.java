package com.renard.rjnetwork.utils;

import android.content.Context;
import android.widget.Toast;
/**
 * Created by Riven_rabbit on 12/10/20
 *
 * @author suyanan
 */
public class ToastUtils {
    private static Context sContext;
    private static String oldMsg;
    protected static Toast toast = null;
    private static long oneTime = 0;
    private static long twoTime = 0;

    private ToastUtils() {
        throw new RuntimeException("ToastUtils cannot be initialized!");
    }

    public static void init(Context context) {
        sContext = context;
    }

    public static void showToast(String s) {
        if (toast == null) {
            toast = Toast.makeText(sContext, s, Toast.LENGTH_SHORT);
            toast.show();
            oneTime = System.currentTimeMillis();
        } else {
            twoTime = System.currentTimeMillis();
            if (s.equals(oldMsg)) {
                if (twoTime - oneTime > Toast.LENGTH_SHORT) {
                    toast.show();
                }
            } else {
                oldMsg = s;
                toast.setText(s);
                toast.show();
            }
            oneTime = twoTime;
        }
    }

    public static void showToast(int resId) {
        showToast(sContext.getString(resId));
    }
}
