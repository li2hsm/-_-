package com.sw0039.twenty.fours_zujian;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sw0039.twenty.R;

import java.lang.ref.WeakReference;

/**
 * Intent与过滤器
 */
public class IntentActivity extends AppCompatActivity {

    private final MyHandler mHandler = new MyHandler(this);
    private static Runnable mRunnable = null;
    private static class MyHandler extends Handler{
        WeakReference<IntentActivity> mActivity;
        public MyHandler(IntentActivity activity){
            mActivity =new WeakReference <IntentActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        mRunnable = new Runnable() {
            @Override
            public void run() {
                startActivityByXian();
            }
        };
        mHandler.postDelayed(mRunnable,1000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }

    /*----start---------显示启动activity--------------*/
    /**
     * 显示启动activity组件的几种方式.
     */
    private void startActivityByXian(){

        //1,通过setComponent显示启动activity.
//        startActivityByComponentName();

        //2,通过setClass显示启动activity.
//        startActivityBySetClass();

        //3,通过setClassName()显示启动activity.
//        startActivityBySetClassName();

        //4,通过Intent()构造函数启动activity.
        startActivityByIntent();
    }

    private void startActivityByIntent() {
        Intent intent = new Intent(IntentActivity.this,IntentChildActivity.class);
        intent.putExtra(IntentChildActivity.MSG, "通过new Intent(context,a.class)启动activity");
        startActivity(intent);
    }

    private void startActivityBySetClassName() {
        Intent intent = new Intent();
        intent.setClassName(IntentActivity.this,getPackageName()+"."+"IntentChildActivity");
        intent.putExtra(IntentChildActivity.MSG, "通过intent.setClassName(context,'fullpakagename.classname')启动activity");
        startActivity(intent);
    }

    /**
     * 通过setClass显示启动activity.
     */
    private void startActivityBySetClass() {
        Intent intent = new Intent();
        intent.setClass(IntentActivity.this,IntentChildActivity.class);
        intent.putExtra(IntentChildActivity.MSG,"通过intent.setClass(context,a.class)启动activity");
        startActivity(intent);
    }

    /**
     * 通过setComponent显示启动activity.
     */
    private void startActivityByComponentName(){
        Intent intent = new Intent();
        ComponentName comp = new ComponentName(getPackageName(), "com.sw0039.twenty.fours_zujian.IntentChildActivity");
        intent.setComponent(comp);
        intent.putExtra(IntentChildActivity.MSG,"通过intent.setComponent(new ComponentName())启动activity");
        startActivity(intent);
    }
    /*----end---------显示启动activity--------------*/

}
