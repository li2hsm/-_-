package com.sw0039.justdoit.anims;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import com.sw0039.justdoit.R;

import static android.view.animation.Animation.RELATIVE_TO_PARENT;

/**
 * 补间动画 xml实现，java实现
 */
public class TweenAnimation extends AnimationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        titleTxt.setText("补间动画");
        showXml();
        showJava();
    }

    private void showJava() {
        //创建动画，参数表示他的子动画是否共用一个插值器
        AnimationSet animationSet = new AnimationSet(true);
        //添加动画
        //透明动画
        animationSet.addAnimation(new AlphaAnimation(1.0f, 0.05f));
        //位移动画
        animationSet.addAnimation(new TranslateAnimation(0, 300, 0, 300));
        //缩放动画
        animationSet.addAnimation(new ScaleAnimation(1.0f,
                0.01f,
                1.0f,
                0.01f,
                Animation.ABSOLUTE,
                0.5f,
                Animation.ABSOLUTE,
                0.5f));
        //旋转动画
        animationSet.addAnimation(new RotateAnimation(0,
                1800,
                RELATIVE_TO_PARENT,
                0.5F,
                RELATIVE_TO_PARENT,
                0.5F));

        //设置插值器
        animationSet.setInterpolator(new LinearInterpolator());
        //设置动画持续时长
        animationSet.setDuration(3000);
        //设置动画结束之后是否保持动画的目标状态
        animationSet.setFillAfter(true);
        //设置动画结束之后是否保持动画开始时的状态
        animationSet.setFillBefore(true);
        //设置重复模式
        animationSet.setRepeatMode(AnimationSet.REVERSE);
        //设置重复次数
        animationSet.setRepeatCount(AnimationSet.INFINITE);
        //设置动画延时时间
        animationSet.setStartOffset(2000);
        //取消动画
        animationSet.cancel();
        //释放资源
        animationSet.reset();
        imgJava.setImageResource(R.mipmap.d1);
        //开始动画
        imgJava.startAnimation(animationSet);
    }

    private void showXml() {
        Animation animator = AnimationUtils.loadAnimation(this, R.anim.anim);
        imgXml.setImageResource(R.mipmap.d1);
        imgXml.setAnimation(animator);
        animator.start();
    }
}
