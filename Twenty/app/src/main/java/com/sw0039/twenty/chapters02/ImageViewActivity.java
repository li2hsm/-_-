package com.sw0039.twenty.chapters02;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.sw0039.twenty.R;

/**
 * ImageView使用
 * Created by Administrator on 2017/10/15.
 */
public class ImageViewActivity extends Activity{
    // 定义一个访问图片的数组
    int[] images = new int[] {
            R.drawable.java,
            R.drawable.javaee,
            R.drawable.swift,
            R.drawable.ajax,
            R.drawable.html, };
    int currentImg = 0;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_imageview);
        // 获取LinearLayout布局容器
        LinearLayout main = (LinearLayout) findViewById(R.id.root);
        // 程序创建ImageView组件
        final ImageView image = new ImageView(this);
        // 将ImageView组件添加到LinearLayout布局容器中
        main.addView(image);
        // 初始化时显示第一张图片
        image.setImageResource(images[0]);
        image.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // 改变ImageView里显示的图片
                image.setImageResource(images[++currentImg % images.length]);
            }
        });
    }
}
