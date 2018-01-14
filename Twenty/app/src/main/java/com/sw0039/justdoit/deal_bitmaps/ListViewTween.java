package com.sw0039.justdoit.deal_bitmaps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ListView;

import com.sw0039.justdoit.R;
import com.sw0039.justdoit.anims.MyAnimation;

/**
 * 列表的补间动画
 */
public class ListViewTween extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_tween);

        // 获取ListView组件
        ListView list = (ListView) findViewById(R.id.list);
        WindowManager windowManager = (WindowManager)
                getSystemService(WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics metrice = new DisplayMetrics();
        // 获取屏幕的宽和高
        display.getMetrics(metrice);
        // 设置对ListView组件应用动画
        list.setAnimation(new MyAnimation(metrice.xdpi / 2
                , metrice.ydpi / 2, 3500));
    }
}
