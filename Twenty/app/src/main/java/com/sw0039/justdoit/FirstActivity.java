package com.sw0039.justdoit;

import android.os.Bundle;

/**
 * 首页
 */
public class FirstActivity extends BaseRecyclerViewActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("首页");
        //添加数据
        String[] arrays = getResources().getStringArray(R.array.chapter_list);
        String[] activitys = getResources().getStringArray(R.array.first_activitys_list);
        addDatas(arrays,activitys);
    }
}
