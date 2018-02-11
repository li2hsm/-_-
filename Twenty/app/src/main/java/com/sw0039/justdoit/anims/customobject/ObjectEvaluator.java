package com.sw0039.justdoit.anims.customobject;

import android.animation.TypeEvaluator;

/**
 * 自定义估值器
 */
public class ObjectEvaluator implements TypeEvaluator<Float> {

    /**
     * 自定义属性值的具体变化逻辑
     *
     * @param fraction   动画的完成度
     * @param startValue 动画的初始值
     * @param endValue   动画的结束
     * @return
     */
    @Override
    public Float evaluate(float fraction, Float startValue, Float endValue) {

        if (fraction < 0.3f) {
            //前30%
            return startValue;
        } else if (fraction >= 0.3f && fraction < 0.6f) {
            //中间30%
            return startValue + (endValue - startValue) * fraction;
        } else {
            //后面30%
            return endValue;
        }
    }
}
