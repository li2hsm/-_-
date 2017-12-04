package com.sw0039.twenty.chapters02;

import android.os.Bundle;

import com.sw0039.twenty.BaseRecyclerViewActivity;
import com.sw0039.twenty.R;

/**
 * Top活动条
 */
public class TestActionBarActivity extends BaseRecyclerViewActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Top活动条");
        //添加数据
        String[] arrays = getResources().getStringArray(R.array.chapter02_actionbar_detail_list);
        String[] activitys = getResources().getStringArray(R.array.chapter02_actionbar_action_list);
        addDatas(arrays,activitys);
    }
}
