package com.sw0039.justdoit.anims;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.sw0039.justdoit.R;

/**
 * 帧动画 xml实现，java实现
 */
public class FrameAnimation extends AnimationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        titleTxt.setText("帧动画");
        showXml();
        showJava();
    }

    private void showJava() {
        AnimationDrawable mAnimationDrawable = new AnimationDrawable();
        for (int i = 1; i <= 10; i++) {
            int id = getResources().getIdentifier("d" + i, "mipmap", getPackageName());
            Drawable drawable = getResources().getDrawable(id);
            mAnimationDrawable.addFrame(drawable, 100);
        }
        mAnimationDrawable.setOneShot(false);
        imgJava.setImageDrawable(mAnimationDrawable);
        mAnimationDrawable.start();
    }

    private AnimationDrawable animationDrawable = null;

    private void showXml() {
        imgXml.setImageResource(R.drawable.frame_animation);
        animationDrawable = (AnimationDrawable) imgXml.getDrawable();
        animationDrawable.start();
    }
}
