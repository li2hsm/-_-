package com.sw0039.twenty.questions;

import android.os.Bundle;
import com.sw0039.twenty.BaseCenterTextActivity;
import com.sw0039.twenty.R;
/**
 * 解决中文人民币符号在部分机型上的显示问题。
 */
public class RMBSymbolActivity extends BaseCenterTextActivity {

    private String RMB_SYMBOL;
    private String ERROR_RMB_SYMBOL;
    private String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RMB_SYMBOL = getResources().getString(R.string.rmb_symbol);
        ERROR_RMB_SYMBOL = getResources().getString(R.string.rmb_symbol_one);
        str = getResources().getString(R.string.money_string);

        showMoney();
    }

    private void showMoney() {
        char a = 165;
        String result = str.substring(str.indexOf(ERROR_RMB_SYMBOL)+1);
        mText.setText("我的钱:"+a+result);
    }

    private void showMoney2() {
        String rmb = "￥";
        String rb = "¥";
        String result = str.replace(rmb,rb);
        mText.setText("我的钱:"+result);
    }

    private void showMoney1() {
        String result = str.substring(str.indexOf(ERROR_RMB_SYMBOL)+1);
        mText.setText("我的钱:"+RMB_SYMBOL+result);
    }
}
