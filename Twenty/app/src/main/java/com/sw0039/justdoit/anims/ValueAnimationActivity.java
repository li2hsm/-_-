package com.sw0039.justdoit.anims;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import com.sw0039.justdoit.R;
import com.sw0039.justdoit.anims.customobject.DecelerateAccelerateInterpolator;

/**
 * 属性动画之ValueAnimationActivity xml实现，java实现
 *
 * 实现动画的原理： 通过不断控制值的变化， 再不断手动赋给对象的属性

 * 自定义插值器，估值器
 */
public class ValueAnimationActivity extends AnimationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        titleTxt.setText("属性动画-ValueAnimationActivity");
        showXml();
        showJava();
    }

    private void showJava() {
        float startX = 50;
        float endX = 500;
        imgJava.setImageResource(R.mipmap.d1);
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(startX,endX);
        valueAnimator.setTarget(imgJava);
        //设置动画时间
        valueAnimator.setDuration(10000);
        //设置动画重复次数
        valueAnimator.setRepeatCount(0);
        valueAnimator.setRepeatMode(ObjectAnimator.REVERSE);
        //使用自定义插值器
        valueAnimator.setInterpolator(new DecelerateAccelerateInterpolator());
        //使用自定义估值器
//        objectAnimator.setEvaluator(new ObjectEvaluator());
        valueAnimator.start();
    }

    private void showXml() {
        imgXml.setImageResource(R.mipmap.d1);
        Animator animator= AnimatorInflater.loadAnimator(mContext, R.animator.translates_valueanim);
        animator.setTarget(imgXml);
        animator.start();
    }
}
