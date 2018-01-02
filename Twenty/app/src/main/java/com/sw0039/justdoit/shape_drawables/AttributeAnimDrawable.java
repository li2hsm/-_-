package com.sw0039.justdoit.shape_drawables;

import android.animation.AnimatorInflater;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.sw0039.justdoit.R;

/**
 * 给图片设置加载的属性动画
 */
public class AttributeAnimDrawable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attribute_anim_drawable);
        LinearLayout container = (LinearLayout)
                findViewById(R.id.container);
        // 添加MyAnimationView组件
        container.addView(new MyAnimationView(this));
    }

    public class MyAnimationView extends View
    {
        public MyAnimationView(Context context)
        {
            super(context);
            // 加载动画资源
            ObjectAnimator colorAnim = (ObjectAnimator) AnimatorInflater
                    .loadAnimator(AttributeAnimDrawable.this, R.animator.color_anim);
            colorAnim.setEvaluator(new ArgbEvaluator());
            // 对该View本身应用属性动画
            colorAnim.setTarget(this);
            // 开始指定动画
            colorAnim.start();
        }
    }
}
