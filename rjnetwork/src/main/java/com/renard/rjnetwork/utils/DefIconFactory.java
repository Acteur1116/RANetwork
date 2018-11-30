package com.renard.rjnetwork.utils;

import com.renard.rjnetwork.R;

import java.util.Random;

/**
 * Created by Riven_rabbit on 2018/11/30
 */
public class DefIconFactory {
    private final static int[] DEF_ICON_ID = new int[] {
            R.drawable.ic_default_1,
            R.drawable.ic_default_2,
            R.drawable.ic_default_3,
            R.drawable.ic_default_4,
            R.drawable.ic_default_5
    };

    private static Random sRandom = new Random();

    private DefIconFactory() {
        throw new RuntimeException("DefIconFactory cannot be initialized!");
    }


    public static int provideIcon() {
        int index = sRandom.nextInt(DEF_ICON_ID.length);
        return DEF_ICON_ID[index];
    }
}
