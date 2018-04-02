package com.hsm.justdoit.utils;

import android.content.Context;
import android.graphics.Typeface;

/**
 * 字体工具类
 */
public class TypeFaceUtils {

    /**
     * 获取楷体字字体
     * @param context
     * @return
     */
    public static Typeface getKaiChinese(Context context){
        return Typeface.createFromAsset(context.getAssets(),"fonts/kai_chinese.ttf");
    }
}
