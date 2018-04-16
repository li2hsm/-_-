package com.sw0039.justdoit;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BaseHSMActivity extends FragmentActivity {

    public FragmentActivity mContext;
    //1
    private final static int PERMISSION_REQUESTCODE = 0x001;
    //2
    private Handler mToastHandler;
    private Object mSynObj;
    private Toast mToast;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        initToast();
    }

    //-----------start------------------android 6.0以后系统请求权限---------------------------------

    /**
     * 请求单个权限
     *
     * @param permissionNames
     */
    public void requestPermissions(@NonNull String[] permissionNames) {
        boolean isMinSdkM = Build.VERSION.SDK_INT < Build.VERSION_CODES.M;
        if (isMinSdkM) {
            //系统版本小于6.0,不用动态申请权限。
            if (mRequestPermissionCallBack != null) {
                mRequestPermissionCallBack.onSuccessRequest();
            }
            return;
        }
        if (permissionNames == null || permissionNames.length == 0) {
            showToastCenter("权限为空，不能申请。");
            return;
        }

        List<String> tempList = new ArrayList<>();
        for (String itemdata : permissionNames) {
            if (!(ContextCompat.checkSelfPermission(mContext, itemdata) == PackageManager.PERMISSION_GRANTED)) {
                tempList.add(itemdata);
            }
        }

        if (!tempList.isEmpty()) {
            //有没有获取的权限，请求权限。
            String[] strings = new String[tempList.size()];
            ActivityCompat.requestPermissions(mContext, tempList.toArray(strings), PERMISSION_REQUESTCODE);
        } else {
            //所有权限都具备
            if (mRequestPermissionCallBack != null) {
                mRequestPermissionCallBack.onSuccessRequest();
            }
        }
    }

    //权限请求结果返回。
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        boolean isNeedRequest = false;
        for (int i = 0; i < grantResults.length; i++) {
            boolean isTip = ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[i]);
            if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                if (isTip) {
                    isNeedRequest = true;
                } else {
                    isNeedRequest = false;
                }
            }
        }

        if (isNeedRequest) {
            //表明用户没有彻底禁止弹出权限请求
            requestPermissions(permissions);
        } else {
            if (mRequestPermissionCallBack != null) {
                mRequestPermissionCallBack.onSuccessRequest();
            }
        }
    }

    private RequestPermissionCallBack mRequestPermissionCallBack = null;

    public void setPermissionCallBack(RequestPermissionCallBack callBack) {
        mRequestPermissionCallBack = callBack;
    }

    public interface RequestPermissionCallBack {
        void onSuccessRequest();

        void onFailRequest();
    }

    //-----------end------------------android 6.0以后系统请求权限---------------------------------


    //-----------start------------------弹toast---------------------------------
    private void initToast() {
        mToastHandler = new Handler();
        mSynObj = new Object();
    }

    public void showToastCenter(@NonNull final String msg) {
        new Thread(new Runnable() {
            public void run() {
                mToastHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        synchronized (mSynObj) {
                            if (mToast != null) {
                                mToast.cancel();
                                mToast.setText(msg);
                                mToast.setDuration(Toast.LENGTH_SHORT);
                            } else {
                                mToast = Toast.makeText(mContext, msg, Toast.LENGTH_SHORT);
                                mToast.setGravity(Gravity.CENTER, 0, 0);
                            }
                            mToast.show();
                        }
                    }
                });
            }
        }).start();
    }
    //-----------end------------------弹toast---------------------------------
}
