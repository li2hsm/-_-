//package com.sw0039.justdoit.devices;
//
//import android.Manifest;
//import android.annotation.TargetApi;
//import android.content.pm.PackageManager;
//import android.graphics.SurfaceTexture;
//import android.hardware.camera2.CameraAccessException;
//import android.hardware.camera2.CameraCaptureSession;
//import android.hardware.camera2.CameraCharacteristics;
//import android.hardware.camera2.CameraDevice;
//import android.hardware.camera2.CameraManager;
//import android.hardware.camera2.CaptureRequest;
//import android.hardware.camera2.CaptureResult;
//import android.hardware.camera2.TotalCaptureResult;
//import android.os.Build;
//import android.os.Bundle;
//import android.os.Handler;
//import android.support.annotation.NonNull;
//import android.support.v4.app.ActivityCompat;
//import android.view.Surface;
//import android.view.TextureView;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//
//import HSMBaseActivity;
//import com.sw0039.justdoit.R;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//import butterknife.OnClick;
//import butterknife.Unbinder;
//
///**
// * 测试camera2的使用
// */
//@TargetApi(Build.VERSION_CODES.LOLLIPOP)
//public class TestCamera2Activity extends HSMBaseActivity implements TextureView.SurfaceTextureListener {
//
//    @BindView(R.id.textureView)
//    TextureView mTextureView;
//    @BindView(R.id.take_pictrue_btn)
//    Button mTakePictrueBtn;
//    @BindView(R.id.five_pictrue_btn)
//    Button mFivePictrueBtn;
//    @BindView(R.id.imageView)
//    ImageView mImageView;
//
//    Unbinder mUnbinder = null;
//    Handler mHandler = null;
//
//    private CaptureRequest.Builder mPreviewBuilder;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_test_camera2);
//        mUnbinder = ButterKnife.bind(this);
//
//        mHandler = new Handler();
//
//        //申请摄像头权限，文件读写权限。
//        Map<Integer, String> permissionMap = new HashMap<>();
//        permissionMap.put(0, Manifest.permission.CAMERA);//摄像头权限
//        permissionMap.put(1, Manifest.permission.WRITE_EXTERNAL_STORAGE);//sdcard写权限
//        permissionMap.put(2, Manifest.permission.READ_EXTERNAL_STORAGE);//sdcard读权限
//        getPermission(permissionMap);
//    }
//
//    private void initViews() {
//        //设置TextureView的监听器
//        mTextureView.setSurfaceTextureListener(this);
//    }
//
//    @OnClick({R.id.take_pictrue_btn, R.id.five_pictrue_btn})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.take_pictrue_btn:
//                //拍照
//
//                break;
//            case R.id.five_pictrue_btn:
//                //5连拍
//
//                break;
//        }
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        mUnbinder.unbind();
//    }
//
//    @Override
//    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
//        //布局可用之后，开始打开摄像头
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
//            //获取管理器对象
//            CameraManager cameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);
//
//            try {
//                //获取相机列表
//                String[] cameraIdList = cameraManager.getCameraIdList();
//                //设置相机的属性
//                CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(cameraIdList[0]);
//                cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
//
//                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
//                    // TODO: Consider calling
//                    //    ActivityCompat#requestPermissions
//                    // here to request the missing permissions, and then overriding
//                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                    //                                          int[] grantResults)
//                    // to handle the case where the user grants the permission. See the documentation
//                    // for ActivityCompat#requestPermissions for more details.
//                    show1BtnDialog("提示", "没有调用摄像头的权限", new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            dismissAllDialog();
//                        }
//                    });
//                    return;
//                }
//                cameraManager.openCamera(cameraIdList[0], mCameraDeviceStateCallback, mHandler);
//            } catch (CameraAccessException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    CameraDevice.StateCallback mCameraDeviceStateCallback = new CameraDevice.StateCallback() {
//
//        @Override
//        public void onOpened(@NonNull CameraDevice camera) {
//            //摄像头打开了。
//            //开始预览
//            try {
//                startPreview(camera);
//            } catch (CameraAccessException e) {
//                e.printStackTrace();
//            }
//        }
//
//        @Override
//        public void onDisconnected(@NonNull CameraDevice camera) {
//
//        }
//
//        @Override
//        public void onError(@NonNull CameraDevice camera, int error) {
//
//        }
//    };
//
//    /**
//     * 开始预览
//     *
//     * @param camera
//     */
//    private void startPreview(CameraDevice camera) throws CameraAccessException {
//        SurfaceTexture surfaceTexture = mTextureView.getSurfaceTexture();
//        surfaceTexture.setDefaultBufferSize(mTextureView.getWidth(), mTextureView.getHeight());
//        Surface surface = new Surface(surfaceTexture);
//        try {
//            mPreviewBuilder = camera.createCaptureRequest(CameraDevice.TEMPLATE_STILL_CAPTURE);
//        } catch (CameraAccessException e) {
//            e.printStackTrace();
//        }
//        mPreviewBuilder.addTarget(surface);
//        //调起预览
//        camera.createCaptureSession(Arrays.asList(surface), mSessionStateCallback, mHandler);
//    }
//
//    private CameraCaptureSession.StateCallback mSessionStateCallback = new CameraCaptureSession.StateCallback() {
//
//        @Override
//        public void onConfigured(@NonNull CameraCaptureSession session) {
//            //配置成功
//            //开始预览
//            try {
//                session.setRepeatingRequest(mPreviewBuilder.build(), mSessionCaptureCallback, mHandler);
//            } catch (CameraAccessException e) {
//                e.printStackTrace();
//            }
//        }
//
//        @Override
//        public void onConfigureFailed(@NonNull CameraCaptureSession session) {
//
//        }
//    };
//
//    private CameraCaptureSession.CaptureCallback mSessionCaptureCallback =
//            new CameraCaptureSession.CaptureCallback() {
//                @Override
//                public void onCaptureCompleted(CameraCaptureSession session, CaptureRequest request,
//                                               TotalCaptureResult result) {
//
//                }
//
//                @Override
//                public void onCaptureProgressed(CameraCaptureSession session, CaptureRequest request,
//                                                CaptureResult partialResult) {
//                }
//            };
//};
//
//@Override
//public void onSurfaceTextureSizeChanged(SurfaceTexture surface,int width,int height){
//
//        }
//
//@Override
//public boolean onSurfaceTextureDestroyed(SurfaceTexture surface){
//        return false;
//        }
//
//@Override
//public void onSurfaceTextureUpdated(SurfaceTexture surface){
//
//        }
//
//@Override
//public void onPermissionSuccess(){
//        //权限申请完成。
//        initViews();
//        }
//
//@Override
//public void onPermissionFail(){
//
//        }
//        }
