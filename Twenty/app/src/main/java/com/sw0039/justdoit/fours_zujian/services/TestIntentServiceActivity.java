package com.sw0039.justdoit.fours_zujian.services;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.sw0039.justdoit.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 测试IntentService使用
 */
public class TestIntentServiceActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button2)
    Button button2;
    Unbinder mUnbinder = null;

    private Intent mIntentServiceIntent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_local_bind_service);
        mUnbinder = ButterKnife.bind(this);
        button.setText("发起服务");
//        button2.setText("解绑定本地服务");
    }

    @Override
    protected void onDestroy() {
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        super.onDestroy();
    }

    @OnClick({R.id.button, R.id.button2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button:
                //发起IntentService服务
                startIntentService();
                break;
            case R.id.button2:

                break;
        }
    }

    private void startIntentService() {
        if (mIntentServiceIntent == null) {
            mIntentServiceIntent = new Intent(TestIntentServiceActivity.this, CustomIntentServices.class);
        }
        startService(mIntentServiceIntent);
    }
}
