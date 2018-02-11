package com.sw0039.justdoit.anims;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.sw0039.justdoit.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 显示动画效果的基类
 */
public class AnimationActivity extends Activity {

    @BindView(R.id.title_txt)
    TextView titleTxt;
    @BindView(R.id.img_xml)
    ImageView imgXml;
    @BindView(R.id.img_java)
    ImageView imgJava;

    Unbinder unbinder;

    Context mContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_frame_animation);
        unbinder = ButterKnife.bind(this);
        mContext = this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
