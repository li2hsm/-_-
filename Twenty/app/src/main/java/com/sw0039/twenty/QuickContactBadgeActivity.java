package com.sw0039.twenty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.QuickContactBadge;

/**
 * 测试QuickContactBadge使用
 */
public class QuickContactBadgeActivity extends AppCompatActivity {

    private QuickContactBadge quickContactBadge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_contact_badge);
        initViews();
    }

    private void initViews() {
        quickContactBadge = (QuickContactBadge) findViewById(R.id.badge);
        //将指定的电话号码与控件相关联
//        quickContactBadge.assignContactFromPhone("18601792926",true);
        //如果号码是联系人就跳转到联系人，如果不是就弹框可以添加到联系人。
        quickContactBadge.assignContactFromPhone("02188888888",true);
//        quickContactBadge.assignContactFromEmail("24413480@qq.com",false);
    }
}
