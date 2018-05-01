package com.sw0039.justdoit.fours_zujian.services;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.sw0039.justdoit.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 测试本地绑定服务
 */
public class TestLocalBindServiceActivity extends AppCompatActivity {

    ServiceConnection mServiceConnection = null;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button2)
    Button button2;

    Unbinder mUnbinder = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_local_bind_service);
        mUnbinder = ButterKnife.bind(this);
        button.setText("绑定本地服务");
        button2.setText("启用另一个activity");
    }

    @Override
    protected void onDestroy() {
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        super.onDestroy();
    }

    /**
     * 解绑服务
     */
    public void unbindLocalService() {
        Intent intent = new Intent(TestLocalBindServiceActivity.this,
                TestMuiltLocalBindServiceActivity.class);
        startActivity(intent);
    }

    /**
     * 绑定服务
     */
    public void bindLocalService() {
        Intent intent = new Intent(TestLocalBindServiceActivity.this, NormalServices.class);
        mServiceConnection = new ServiceConnection() {

            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                //绑定成功之后，用语传递参数
                Log.w("绑定服务", "第一个activity绑定成功。");
                NormalServices.CustomIBinder customIBinder = (NormalServices.CustomIBinder) service;
                customIBinder.getWords("第一个activity绑定成功");
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                //绑定服务的组件因为内存不足或者内存策略被系统杀死的时候调用这个方法。
                Log.w("绑定服务", "绑定服务的组件因为内存不足或者内存策略被系统杀死的时候调用这个方法。");
            }
        };
        bindService(intent, mServiceConnection, BIND_AUTO_CREATE);
    }

    @OnClick({R.id.button, R.id.button2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button:
                //绑定服务
                bindLocalService();
                break;
            case R.id.button2:
                //解绑服务
                unbindLocalService();
                break;
        }
    }
}
