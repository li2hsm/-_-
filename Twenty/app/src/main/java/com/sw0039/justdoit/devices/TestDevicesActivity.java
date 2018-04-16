package com.sw0039.justdoit.devices;

import android.os.Bundle;

import com.sw0039.justdoit.BaseRecyclerViewActivity;
import com.sw0039.justdoit.R;

/**
 * 测试设备，多媒体
 */
public class TestDevicesActivity extends BaseRecyclerViewActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("测试设备，多媒体");
        //添加数据
        String[] arrays = getResources().getStringArray(R.array.devices_list);
        String[] activitys = getResources().getStringArray(R.array.devices_action_list);
        addDatas(arrays,activitys);
    }
}
