package com.sw0039.twenty.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import android.util.Log;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
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
     * @param activity
     * @param msg
     */
    public static void showLog(Activity activity,String msg){
        if(null==activity|| TextUtils.isEmpty(msg)){
            return;
        }

        String TAG = activity.getLocalClassName();
        Log.w(TAG,msg);
    }
}
