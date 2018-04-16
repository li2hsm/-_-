package com.sw0039.justdoit;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.TextView;

import com.sw0039.justdoit.R;

/**
 * 测试菜单的使用
 */
public class MenuActivity extends AppCompatActivity {

    //-----------"字体大小"菜单的标识----------
    private static final int font_11 = 0x111;
    private static final int font_12 = 0x112;
    private static final int font_13 = 0x113;
    private static final int font_14 = 0x114;
    private static final int font_15 = 0x115;
    private static final int font_16 = 0x116;

    //-----------普通菜单的标识---------
    private static final int PLAN_FORM = 0X120;

    //-----------"字体颜色"菜单的标识----------
    private static final int font_red = 0x121;
    private static final int font_green = 0x122;
    private static final int font_blue = 0x123;

    private Context mContext;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mContext = this;
        initViews();
    }








    /**
     * 初始化界面
     */
    private void initViews() {
        mTextView = (TextView) findViewById(R.id.textView);
    }

    //用户单击menu键的时候触发
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //--------------添加“字体大小”的子菜单-------------
        SubMenu subMenu = menu.addSubMenu("字体大小");
        //设置菜单的图标
        subMenu.setIcon(R.mipmap.ic_launcher);
        //设置菜单头的图标
        subMenu.setHeaderIcon(R.mipmap.ic_launcher);
        //设置菜单头的标题
        subMenu.setHeaderTitle("请选择字体大小");
        //添加菜单项
        subMenu.add(0,font_11,0,"11号字体");
        subMenu.add(0,font_12,0,"12号字体");
        subMenu.add(0,font_13,0,"13号字体");
        subMenu.add(0,font_14,0,"14号字体");
        subMenu.add(0,font_15,0,"15号字体");
        subMenu.add(0,font_16,0,"16号字体");

        //--------------向menu中添加普通菜单-------------
        menu.add(0,PLAN_FORM,0,"普通菜单");

        //-------------向menu中添加"字体颜色"的子菜单----------
        SubMenu colorMenu = menu.addSubMenu("字体颜色");
        colorMenu.setIcon(R.mipmap.ic_launcher);
        colorMenu.setHeaderIcon(R.mipmap.ic_launcher);
        colorMenu.setHeaderTitle("请选择字体颜色");
        //添加菜单项
        colorMenu.add(0,font_red,0,"红色字体");
        colorMenu.add(0,font_green,0,"绿色字体");
        colorMenu.add(0,font_blue,0,"蓝色字体");
        return super.onCreateOptionsMenu(menu);
    }
    //选项菜单的点击监听器
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case font_11:
                mTextView.setTextSize(11*3);
                break;
            case font_12:
                mTextView.setTextSize(12*3);
                break;
            case font_13:
                mTextView.setTextSize(13*3);
                break;
            case font_14:
                mTextView.setTextSize(14*3);
                break;
            case font_15:
                mTextView.setTextSize(15*3);
                break;
            case font_16:
                mTextView.setTextSize(16*3);
                break;
            case PLAN_FORM:
                mTextView.setText("普通菜单");
                break;

            case font_red:
                mTextView.setTextColor(Color.RED);
                break;
            case font_green:
                mTextView.setTextColor(Color.GREEN);
                break;
            case font_blue:
                mTextView.setTextColor(Color.BLUE);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}