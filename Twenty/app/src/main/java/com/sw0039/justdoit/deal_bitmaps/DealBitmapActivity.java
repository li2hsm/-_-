package com.sw0039.justdoit.deal_bitmaps;

import android.os.Bundle;

import com.sw0039.justdoit.BaseRecyclerViewActivity;
import com.sw0039.justdoit.R;

/**
 * 图形与图像处理
 */
public class DealBitmapActivity extends BaseRecyclerViewActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("图形与图像处理");
        //添加数据
        String[] arrays = getResources().getStringArray(R.array.chapters07_list);
        String[] activitys = getResources().getStringArray(R.array.chapters07_action_list);
        addDatas(arrays,activitys);
    }
}
