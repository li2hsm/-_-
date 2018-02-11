package com.sw0039.justdoit.questions.address_selector;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.PopupWindow;

import com.sw0039.justdoit.R;

/**
 * 显示地址选择器
 */
public class ShowAddressSelectorActivity extends AppCompatActivity {

    private PopupWindow mPopWin;

    private Dialog mDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_address_selector);
    }
}
