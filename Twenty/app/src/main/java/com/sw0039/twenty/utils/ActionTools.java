package com.sw0039.twenty.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Toast;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 普通的功能函数
 * Created by Administrator on 2017/10/15.
 */
public class ActionTools {

    /**
     * 根据类名跳转activity
     *
     * @param context
     * @param classname
     */
    public static void go2ActivityByClassName(Context context, String classname) {

        // 第二种写法：为了安全起见，可以先做一下检查：
        Intent intent = new Intent();
        String packageName = context.getPackageName();
        intent.setClassName(packageName, packageName + "." + classname);
        // Verify it resolves
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
        boolean isIntentSafe = activities.size() > 0;
        // Start an activity if it's safe
        if (isIntentSafe) {
            context.startActivity(intent);
        } else {
            Toast.makeText(context, classname + "没有注册", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 获取当前时间，精确到毫秒
     *
     * @return
     */
    public static String getCurrentTimeSS() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String date = sDateFormat.format(new java.util.Date());
        return date;
    }

    /**
     * 显示log
     *
     * @param activity
     * @param msg
     */
    public static void showLog(Activity activity, String msg) {
        if (null == activity || TextUtils.isEmpty(msg)) {
            return;
        }

        String TAG = activity.getLocalClassName();
        Log.w(TAG, msg);
    }

    /**
     * 显示短时间的Toast
     *
     * @param context
     * @param msg
     */
    public static void showToastShort(Context context, String msg) {
        if (null == context || TextUtils.isEmpty(msg)) {
            return;
        }

        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 获取屏幕的宽度
     *
     * @param cotext
     * @return
     */
    public static int getScreenWidth(Context cotext) {
        Resources resources = cotext.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        float density = dm.density;
        int width = dm.widthPixels;
        return width;
    }

    /**
     * 获取屏幕的高度
     *
     * @param cotext
     * @return
     */
    public static int getScreenHeight(Context cotext) {
        Resources resources = cotext.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        float density = dm.density;
        int height = dm.heightPixels;
        return height;
    }
}
