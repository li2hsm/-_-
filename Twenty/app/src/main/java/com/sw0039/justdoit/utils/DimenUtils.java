package com.sw0039.justdoit.utils;

import android.content.Context;

/**
 * ?????????
 * Created by Administrator on 2017/11/23.
 */
public class DimenUtils {

    /**
     * ?????????????? dp ???λ ???? px(????)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * ?????????????? px(????) ???λ ???? dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
