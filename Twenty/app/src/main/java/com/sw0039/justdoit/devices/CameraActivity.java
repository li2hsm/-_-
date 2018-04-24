/*
 * Copyright 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sw0039.justdoit.devices;

import android.Manifest;
import android.app.AlertDialog;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.sw0039.justdoit.BaseHSMActivity;
import com.sw0039.justdoit.R;

import java.io.File;

/**
 * camera2使用
 */
public class CameraActivity extends BaseHSMActivity implements View.OnClickListener {

    private ImageView mCaptureImage;
    private CameraTextureView mCameraTextureView;
    private boolean isFirstLoad = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera2_basic);

        findViewById(R.id.picture).setOnClickListener(this);
        findViewById(R.id.info).setOnClickListener(this);

        mCaptureImage = findViewById(R.id.iv_capture_pic);
        mCameraTextureView = findViewById(R.id.texture);

        File mFile = new File(getExternalFilesDir(null), "pic.jpg");
//                //配置CameraTexture
        mCameraTextureView.setActivity(mContext);
        mCameraTextureView.setPicSaveFile(mFile);

        //请求摄像头权限
        setPermissionCallBack(new RequestPermissionCallBack() {
            @Override
            public void onSuccessRequest() {
                //权限请求成功。
                showToastCenter("你申请权限成功。");
                //执行相机初始化操作
                mCameraTextureView.onResume();
            }

            @Override
            public void onFailRequest() {
                //权限请求失败.
                showToastCenter("你拒绝了权限，将无法使用该功能。");
            }
        });

        String[] permissions = new String[]{Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE};
        requestPermissions(permissions);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.picture: {
                mCameraTextureView.takePicture(new CameraTextureView.TackPhotoCallback() {
                    @Override
                    public void tackPhotoSuccess(String photoPath) {
                        showToastCenter(photoPath);
                        mCaptureImage.setImageBitmap(BitmapFactory.decodeFile(photoPath));
                    }

                    @Override
                    public void tackPhotoError(Exception e) {
                        showToastCenter(e.getMessage());
                    }
                });
                break;
            }
            case R.id.info: {
                new AlertDialog.Builder(this)
                        .setMessage(R.string.intro_message)
                        .setPositiveButton(android.R.string.ok, null)
                        .show();
                break;
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(!isFirstLoad){
            mCameraTextureView.onResume();
        }
        isFirstLoad = false;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mCameraTextureView.onPause();
    }

}
