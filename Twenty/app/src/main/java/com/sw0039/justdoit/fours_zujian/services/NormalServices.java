package com.sw0039.justdoit.fours_zujian.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * 绑定本地服务
 */
public class NormalServices extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new CustomIBinder();
    }

    public class CustomIBinder extends Binder {
        public void getWords(String str){
            Log.w("绑定服务",str);
        }
    }
}
