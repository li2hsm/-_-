package com.sw0039.justdoit.questions;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.sw0039.justdoit.R;
import com.sw0039.justdoit.utils.DimenUtils;
import com.sw0039.justdoit.utils.ViewTools;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * activity???dialog???????
 */
//<!--activity ????????????-->
//    <style name="activity_dialog" parent="@android:style/Theme.Dialog">
//            <item name="android:windowFrame">@null</item><!--????-->
//<item name="android:windowFullscreen">true</item><!--??????-->
//<item name="android:windowIsFloating">true</item><!--???????activity???-->
//<!--<item name="android:windowIsTranslucent">true</item> ? Theme ???????????,?????????????????????Ч-->
//<item name="android:windowNoTitle">true</item><!--?????-->
//<item name="android:windowBackground">@android:color/transparent</item><!-- ? Theme ???????? ????dialog?????-->
//</style>
public class ScrollviewListviewActivity extends Activity {

    @BindView(R.id.listview1)
    ListView listview1;
    @BindView(R.id.listview2)
    ListView listview2;
    @BindView(R.id.scrollview)
    ScrollView scrollview;
    private Handler mHandler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollview_listview);
        getWindow().setLayout(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
        ButterKnife.bind(this);
        mHandler = new Handler();
        setViewsData();

//        scrollview.fullScroll(View.FOCUS_UP);
//        scrollview.scrollTo(0,0);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                scrollview.fullScroll(View.FOCUS_UP);
            }
        },1000);
    }

    private void setViewsData() {
        int arraylenght = 100;
        List<String> arrays1 = new ArrayList<>();
        List<String> arrays2 = new ArrayList<>();
        for (int i = 0; i < arraylenght; i++) {
            arrays1.add("??" + String.valueOf(i + 1) + "??");
            arrays2.add("??" + String.valueOf(i + 1) + "??");
        }

        TextViewAdapter adapter1 = new TextViewAdapter(arrays1, this);
        listview1.setAdapter(adapter1);

        TextViewAdapter adapter2 = new TextViewAdapter(arrays2, this);
        listview2.setAdapter(adapter2);

        TextView textView = new TextView(this);
        textView.setText("?????");
        textView.setTextSize(15);
        textView.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        textView.setGravity(Gravity.CENTER_VERTICAL);

        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,
                DimenUtils.dip2px(this, 100));
        textView.setLayoutParams(lp);
        listview2.addFooterView(textView);

        ViewTools.setListViewHeightBasedOnChildren(listview1);
        ViewTools.setListViewHeightBasedOnChildren(listview2);
    }
}
