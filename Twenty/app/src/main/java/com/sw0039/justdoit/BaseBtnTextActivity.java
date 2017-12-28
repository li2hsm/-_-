package com.sw0039.justdoit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 带一个文本框和一个按钮的activity
 */
public class BaseBtnTextActivity extends AppCompatActivity {

    @BindView(R.id.content_text)
    public TextView contentText;
    @BindView(R.id.jum_btn)
    public Button jumBtn;

    //当前操作的名称
    private String actionName = null;

    public final static String INTENT_PARAMS_ACTIONNAME = "actionName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_btn_text);
        ButterKnife.bind(this);
    }

    /*=================start===EventBus部分===============*/
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        /* Do something */
        if(null == event){
            return;
        }

        contentText.setText(event.getmShowMsg());
        jumBtn.setText(event.getmBtnName());
        jumBtn.setOnClickListener(event.getmOnClickListener());
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
