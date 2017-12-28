package com.sw0039.justdoit.bases;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

/**
 * android6.0动态申请权限
 * Created by hsm on 2017/12/5.
 */
public class Android6PermissionActivity extends Activity {

    public Activity mActivity;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
    }

    /**
     * 添加权限
     * @param permission
     */
    public void requestPermission(String permission){
        if (ContextCompat.checkSelfPermission(mActivity, permission) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(mActivity, new String[]{Manifest.permission.SEND_SMS}, 1);
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //这里写操作 如send（）； send函数中New SendMsg （号码，内容）；
                    Toast.makeText(this, "你启动了权限", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "你没启动权限", Toast.LENGTH_SHORT).show();
                }
                break;

            default:
        }
    }
}
