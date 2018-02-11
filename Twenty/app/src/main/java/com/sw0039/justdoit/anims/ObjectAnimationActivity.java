package com.sw0039.justdoit.anims;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.animation.AccelerateInterpolator;

import com.sw0039.justdoit.R;
import com.sw0039.justdoit.anims.customobject.DecelerateAccelerateInterpolator;
import com.sw0039.justdoit.anims.customobject.MyPoint;
import com.sw0039.justdoit.anims.customobject.ObjectEvaluator;

/**
 * 属性动画之ObjectAnimator xml实现，java实现
 *
 * 实现动画的原理： 通过不断控制值的变化， 再不断自动赋给对象的属性， 从而实现动画效果
    自动赋给对象的属性的本质是调用该对象属性的set()&get()方法进行赋值

 * 自定义插值器，估值器
 */
public class ObjectAnimationActivity extends AnimationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        titleTxt.setText("属性动画-ObjectAnimator");
        showXml();
        showJava();
    }

    private void showJava() {
        float startX = 50;
        float endX = 500;
        imgJava.setImageResource(R.mipmap.d1);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imgJava,"translationX",
                startX,endX);
        objectAnimator.setTarget(imgJava);
        //设置动画时间
        objectAnimator.setDuration(10000);
        //设置动画重复次数
        objectAnimator.setRepeatCount(0);
        objectAnimator.setRepeatMode(ObjectAnimator.REVERSE);
        //使用自定义插值器
        objectAnimator.setInterpolator(new DecelerateAccelerateInterpolator());
        //使用自定义估值器
//        objectAnimator.setEvaluator(new ObjectEvaluator());
        objectAnimator.start();
    }

    private AnimationDrawable animationDrawable = null;

    private void showXml() {
        imgXml.setImageResource(R.mipmap.d1);
        Animator animator= AnimatorInflater.loadAnimator(mContext, R.animator.translates_anim);
        animator.setTarget(imgXml);
        animator.start();
//        animationDrawable = (AnimationDrawable) imgXml.getDrawable();
//        animationDrawable.start();
    }
}
