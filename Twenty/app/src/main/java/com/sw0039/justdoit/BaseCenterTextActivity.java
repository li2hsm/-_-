package com.sw0039.justdoit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 中间带一句话的activity
 */
public class BaseCenterTextActivity extends AppCompatActivity {

    /**
     * 传递信息的key
     */
    public final static String MSG = "msg";

    @BindView(R.id.textView)
    public TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_center_text);
        ButterKnife.bind(this);

        //设置文字信息
        setmText();
    }

    /**
     * 设置文字信息
     */
    public void setmText() {
        Intent intent = getIntent();
        String msg = intent.getStringExtra(MSG);
        if (!TextUtils.isEmpty(msg)) {
            mText.setText(msg);
        } else {
            mText.setText("没有要显示的文字");
        }
    }

    /*=================start===EventBus部分===============*/
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        /* Do something */
        if(null == event){
            return;
        }

        mText.setText(event.getmShowMsg());
    }

    //注册EventBus
    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    //取消注册EventBus
    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
    /*=================end===EventBus部分===============*/
}
