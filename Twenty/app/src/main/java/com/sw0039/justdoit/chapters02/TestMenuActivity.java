package com.sw0039.justdoit.chapters02;

import android.os.Bundle;

import com.sw0039.justdoit.BaseRecyclerViewActivity;
import com.sw0039.justdoit.R;

/**
 * 菜单
 */
public class TestMenuActivity extends BaseRecyclerViewActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("菜单");
        //添加数据
        String[] arrays = getResources().getStringArray(R.array.chapter02_menu_detail_list);
        String[] activitys = getResources().getStringArray(R.array.chapter02_menu_action_list);
        addDatas(arrays,activitys);
    }
}
