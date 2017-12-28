package com.sw0039.justdoit.chapters02.events;

import android.Manifest;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.sw0039.justdoit.R;
import com.sw0039.justdoit.bases.Android6PermissionActivity;

/**
 * 发送短信
 */
public class SendSmsActivity extends Android6PermissionActivity {
    EditText address;
    EditText content;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        // 获取页面中收件人地址、短信内容
        address = (EditText) findViewById(R.id.address);
        content = (EditText) findViewById(R.id.content);
        Button bn = (Button) findViewById(R.id.send);
        // 使用外部类的实例作为事件监听器
        bn.setOnLongClickListener(new SendSmsListener(
                this, address, content));

        //android 6.0添加发短信的权限
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            requestPermission(Manifest.permission.SEND_SMS);
        }
    }
}
