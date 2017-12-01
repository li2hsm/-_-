package com.sw0039.twenty.questions;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ScrollView;

import com.sw0039.twenty.R;
import com.sw0039.twenty.utils.ViewTools;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * activity dialog
 */
public class ScrollviewListview1Activity extends FragmentActivity {


    @BindView(R.id.listview)
    ScrollListview listview;
    @BindView(R.id.scrollview)
    ScrollView scrollview;

    private Handler mHandler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        setContentView(R.layout.activity_scrollview_listview1);
        ViewTools.setDialogFullScreen(this);

        //会隐藏actionbar
//        getWindow().setLayout(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
        ButterKnife.bind(this);
        mHandler = new Handler();
        setViewsData();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                scrollview.fullScroll(View.FOCUS_UP);
            }
        },1000);
    }

    private void setViewsData() {
        int arraylenght = 100;
        List<String> arrays = new ArrayList<>();
        for (int i = 0; i < arraylenght; i++) {
            arrays.add("第" + String.valueOf(i + 1) + "项");
        }

        TextViewAdapter adapter1 = new TextViewAdapter(arrays, this);
        listview.setAdapter(adapter1);

//        ViewTools.setListViewHeightBasedOnChildren(listview);
    }
}
