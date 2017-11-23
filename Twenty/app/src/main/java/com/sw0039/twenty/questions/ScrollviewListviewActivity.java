package com.sw0039.twenty.questions;

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

import com.sw0039.twenty.R;
import com.sw0039.twenty.utils.DimenUtils;
import com.sw0039.twenty.utils.ViewTools;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * activity作为dialog弹出显示
 */
//<!--activity 以窗口的形式显示-->
//    <style name="activity_dialog" parent="@android:style/Theme.Dialog">
//            <item name="android:windowFrame">@null</item><!--去边框-->
//<item name="android:windowFullscreen">true</item><!--全屏显示-->
//<item name="android:windowIsFloating">true</item><!--是否浮现在activity之上-->
//<!--<item name="android:windowIsTranslucent">true</item> 为 Theme 设置透明属性,会让界面的启动，关闭动画失效-->
//<item name="android:windowNoTitle">true</item><!--去标题-->
//<item name="android:windowBackground">@android:color/transparent</item><!-- 为 Theme 设置背景图 设置dialog的背景-->
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
            arrays1.add("第" + String.valueOf(i + 1) + "项");
            arrays2.add("第" + String.valueOf(i + 1) + "项");
        }

        TextViewAdapter adapter1 = new TextViewAdapter(arrays1, this);
        listview1.setAdapter(adapter1);

        TextViewAdapter adapter2 = new TextViewAdapter(arrays2, this);
        listview2.setAdapter(adapter2);

        TextView textView = new TextView(this);
        textView.setText("不使用");
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
