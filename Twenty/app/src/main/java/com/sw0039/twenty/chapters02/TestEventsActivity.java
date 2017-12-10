package com.sw0039.twenty.chapters02;

import android.os.Bundle;

import com.sw0039.twenty.BaseRecyclerViewActivity;
import com.sw0039.twenty.R;

/**
 * 测试事件处理
 */
public class TestEventsActivity extends BaseRecyclerViewActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("事件");
        //添加数据
        String[] arrays = getResources().getStringArray(R.array.chapter02_events_detail_list);
        String[] activitys = getResources().getStringArray(R.array.chapter02_events_action_list);
        addDatas(arrays,activitys);
    }
}
