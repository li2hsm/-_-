package com.sw0039.twenty.questions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.common.math.DoubleMath;
import com.sw0039.twenty.BaseCenterTextActivity;
import com.sw0039.twenty.R;

import java.math.BigDecimal;

/**
 * 解决java double型数据的计算。
 * 最大支持16位double精度以内的数值比较，4位小数。
 */
public class JavaCirculateDoubleActivity extends BaseCenterTextActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //
//        double d1 = -0.00d;
//        double d2 = 0.00d;
        double d1 = 123456789123.12345678;
        double d2 = 123456789123.12345679;

        circulateBigDecimal(d1, d2);
    }

    /**
     * 比较2个double的大小
     */
    private void circulateBigDecimal(double d1, double d2) {
        StringBuilder stringBuilder = new StringBuilder();

        String digitStr1 = formatFloatNumber(d1);
        String digitStr2 = formatFloatNumber(d2);
        stringBuilder.append("digit1=" + digitStr1 + "\n");
        stringBuilder.append("digit2=" + digitStr2 + "\n");

        BigDecimal digit1 = new BigDecimal(digitStr1);
        BigDecimal digit2 = new BigDecimal(digitStr2);

        //最多支持16位有效数位的比较
        int retval = digit1.compareTo(digit2);

        if (retval > 0) {
            stringBuilder.append("digit1 > digit2" + "\n");
        } else if (retval < 0) {
            stringBuilder.append("digit1 < digit2" + "\n");
        } else {
            stringBuilder.append("digit1 == digit2" + "\n");
        }

        mText.setText(stringBuilder.toString());
    }

    /**
     * 当浮点型数据位数超过10位之后，数据变成科学计数法显示。用此方法可以使其正常显示。
     *
     * @param value
     * @return Sting
     */
    public String formatFloatNumber(double value) {
        if (value != -0.00d && value != 0.00d) {
            BigDecimal digit = new BigDecimal(value);
            java.text.DecimalFormat df = new java.text.DecimalFormat("########.00000000");
            return df.format(digit);
        } else {
            return "0.0000";
        }
    }

    public String formatFloatNumber(Double value) {
        if (value != null) {
            if (value.doubleValue() != 0.00) {
                java.text.DecimalFormat df = new java.text.DecimalFormat("########.00");
                return df.format(value.doubleValue());
            } else {
                return "0.00";
            }
        }
        return "";
    }
}
