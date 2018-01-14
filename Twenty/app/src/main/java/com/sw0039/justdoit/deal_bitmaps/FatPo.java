package com.sw0039.justdoit.deal_bitmaps;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.sw0039.justdoit.R;


/**
 * 逐帧动画
 */
public class FatPo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fat_po);

        // 获取两个按钮
        Button play = (Button) findViewById(R.id.play);
        Button stop = (Button) findViewById(R.id.stop);
        ImageView imageView = (ImageView) findViewById(R.id.anim);
        // 获取AnimationDrawable动画对象
        final AnimationDrawable anim = (AnimationDrawable) imageView
                .getBackground();
        play.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // 开始播放动画
                anim.start();
            }
        });
        stop.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // 停止播放动画
                anim.stop();
            }
        });
    }
}
