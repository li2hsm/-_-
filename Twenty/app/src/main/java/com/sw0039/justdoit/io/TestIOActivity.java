package com.sw0039.justdoit.io;

import android.os.Bundle;

import com.sw0039.justdoit.BaseRecyclerViewActivity;
import com.sw0039.justdoit.R;

/**
 * 测试IO
 */
public class TestIOActivity extends BaseRecyclerViewActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("测试IO");
        //添加数据
        String[] arrays = getResources().getStringArray(R.array.storage_list);
        String[] activitys = getResources().getStringArray(R.array.storage_action_list);
        addDatas(arrays,activitys);
    }
}
