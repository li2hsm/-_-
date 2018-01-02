package com.sw0039.justdoit.shape_drawables;

import android.os.Bundle;

import com.sw0039.justdoit.BaseRecyclerViewActivity;
import com.sw0039.justdoit.R;

/**
 * xml sharpe的使用
 */
public class ShareDrawableActivity extends BaseRecyclerViewActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("xml sharpe的使用");
        //添加数据
        String[] arrays = getResources().getStringArray(R.array.chapters06_list);
        String[] activitys = getResources().getStringArray(R.array.chapters06_action_list);
        addDatas(arrays,activitys);
    }
}
