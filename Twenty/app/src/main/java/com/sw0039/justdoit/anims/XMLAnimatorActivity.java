package com.sw0039.justdoit.anims;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.sw0039.justdoit.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * xml实现属性动画
 */
public class XMLAnimatorActivity extends AppCompatActivity {


    @BindView(R.id.traslate)
    TextView traslate;
    @BindView(R.id.rotate)
    TextView rotate;
    @BindView(R.id.alpha)
    TextView alpha;
    @BindView(R.id.scale)
    TextView scale;
    @BindView(R.id.zuhe1)
    TextView zuhe;
    @BindView(R.id.zuhe2)
    TextView value;

    Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_anim);
        mUnbinder = ButterKnife.bind(this);
    }

    @OnClick({R.id.traslate, R.id.rotate, R.id.alpha, R.id.scale, R.id.zuhe2, R.id.zuhe1})
    public void onclick(View v) {
        switch (v.getId()) {
            case R.id.traslate:
                Animator tra = AnimatorInflater
                        .loadAnimator(XMLAnimatorActivity.this, R.animator.translate);
                tra.setTarget(traslate);
                tra.start();
                break;
            case R.id.rotate:
                Animator rota = AnimatorInflater
                        .loadAnimator(XMLAnimatorActivity.this, R.animator.rotate);
                rota.setTarget(rotate);
                rota.start();
                break;
            case R.id.alpha:
                Animator alph = AnimatorInflater
                        .loadAnimator(XMLAnimatorActivity.this, R.animator.alpha);
                alph.setTarget(alpha);
                alph.start();
                break;
            case R.id.scale:
                Animator sca = AnimatorInflater
                        .loadAnimator(XMLAnimatorActivity.this, R.animator.scale);
                sca.setTarget(scale);
                sca.start();
                break;
            case R.id.zuhe1:
                Animator zuhea = AnimatorInflater
                        .loadAnimator(XMLAnimatorActivity.this, R.animator.zuhe);
                zuhea.setTarget(zuhe);
                zuhea.start();
                break;
            case R.id.zuhe2:
                ValueAnimator valuea = (ValueAnimator) AnimatorInflater
                        .loadAnimator(XMLAnimatorActivity.this, R.animator.value);
                valuea.setTarget(value);
                valuea.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        value.setText("" + animation.getAnimatedValue());
                    }
                });
                valuea.start();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
