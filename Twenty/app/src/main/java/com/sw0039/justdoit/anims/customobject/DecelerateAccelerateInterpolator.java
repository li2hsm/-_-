package com.sw0039.justdoit.anims.customobject;

import android.animation.TimeInterpolator;

import com.sw0039.justdoit.utils.LogUtils;

/**
 * 实现先减速，后加速的自定义插值器
 * 根据时间流逝的百分比计算出当前属性值改变的百分比。
 */
public class DecelerateAccelerateInterpolator implements TimeInterpolator {
    @Override
    public float getInterpolation(float input) {
        //input-的值是从0-1
        float result;
        if (input <= 0.5) {
            //前半部分的变化是减速
            result = (float) (Math.cos(Math.PI * input) / 2);
        } else {
            result =  (float) (Math.sin(Math.PI * input) / 2);
        }
        LogUtils.printWarn("属性动画","input="+input+",result="+result);
        return result;
    }
}
