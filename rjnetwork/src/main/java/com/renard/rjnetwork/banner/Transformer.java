package com.renard.rjnetwork.banner;

import android.support.v4.view.ViewPager.PageTransformer;

import com.renard.rjnetwork.banner.transformer.AccordionTransformer;
import com.renard.rjnetwork.banner.transformer.BackgroundToForegroundTransformer;
import com.renard.rjnetwork.banner.transformer.CubeInTransformer;
import com.renard.rjnetwork.banner.transformer.CubeOutTransformer;
import com.renard.rjnetwork.banner.transformer.DefaultTransformer;
import com.renard.rjnetwork.banner.transformer.DepthPageTransformer;
import com.renard.rjnetwork.banner.transformer.FlipHorizontalTransformer;
import com.renard.rjnetwork.banner.transformer.FlipVerticalTransformer;
import com.renard.rjnetwork.banner.transformer.ForegroundToBackgroundTransformer;
import com.renard.rjnetwork.banner.transformer.RotateDownTransformer;
import com.renard.rjnetwork.banner.transformer.RotateUpTransformer;
import com.renard.rjnetwork.banner.transformer.ScaleInOutTransformer;
import com.renard.rjnetwork.banner.transformer.StackTransformer;
import com.renard.rjnetwork.banner.transformer.TabletTransformer;
import com.renard.rjnetwork.banner.transformer.ZoomInTransformer;
import com.renard.rjnetwork.banner.transformer.ZoomOutSlideTransformer;
import com.renard.rjnetwork.banner.transformer.ZoomOutTranformer;

public class Transformer {
    public static Class<? extends PageTransformer> Default = DefaultTransformer.class;
    public static Class<? extends PageTransformer> Accordion = AccordionTransformer.class;
    public static Class<? extends PageTransformer> BackgroundToForeground = BackgroundToForegroundTransformer.class;
    public static Class<? extends PageTransformer> ForegroundToBackground = ForegroundToBackgroundTransformer.class;
    public static Class<? extends PageTransformer> CubeIn = CubeInTransformer.class;
    public static Class<? extends PageTransformer> CubeOut = CubeOutTransformer.class;
    public static Class<? extends PageTransformer> DepthPage = DepthPageTransformer.class;
    public static Class<? extends PageTransformer> FlipHorizontal = FlipHorizontalTransformer.class;
    public static Class<? extends PageTransformer> FlipVertical = FlipVerticalTransformer.class;
    public static Class<? extends PageTransformer> RotateDown = RotateDownTransformer.class;
    public static Class<? extends PageTransformer> RotateUp = RotateUpTransformer.class;
    public static Class<? extends PageTransformer> ScaleInOut = ScaleInOutTransformer.class;
    public static Class<? extends PageTransformer> Stack = StackTransformer.class;
    public static Class<? extends PageTransformer> Tablet = TabletTransformer.class;
    public static Class<? extends PageTransformer> ZoomIn = ZoomInTransformer.class;
    public static Class<? extends PageTransformer> ZoomOut = ZoomOutTranformer.class;
    public static Class<? extends PageTransformer> ZoomOutSlide = ZoomOutSlideTransformer.class;
}
