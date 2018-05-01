package com.sw0039.justdoit.fours_zujian.services;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * 测试IntentService
 */
public class CustomIntentServices extends IntentService {

    private int count = 0;

    public CustomIntentServices() {
        super("自定义IntentService");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.w("测试IntentService", "onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.w("测试IntentService", "onBind()");
        return null;
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        //开启线程逐一处理发送的请求
        count++;
        //每次启动都是第一次.
        Log.w("测试IntentService", "执行第" + count + "次");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.w("测试IntentService", "onDestroy()");
    }
}
