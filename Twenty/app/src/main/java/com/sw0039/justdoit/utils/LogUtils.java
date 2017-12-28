package com.sw0039.justdoit.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

/**
 * 显示log信息
 * Created by Administrator on 2017/12/11.
 */
public class LogUtils {

    /**
     * 显示warn的log信息
     * @param tag
     * @param msg
     */
    public static void printWarn(String tag,String msg){
        if(TextUtils.isEmpty(tag)||TextUtils.isEmpty(msg)){
            return;
        }
        Log.w(tag,msg);
    }

    /**
     * 显示toast
     * @param context
     * @param msg
     */
    public static void showShortToast(Context context, String msg){
        if(!TextUtils.isEmpty(msg)){
            Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
        }
    }
}
