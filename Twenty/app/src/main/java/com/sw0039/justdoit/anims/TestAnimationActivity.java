package com.sw0039.justdoit.anims;

import android.os.Bundle;

import com.sw0039.justdoit.BaseRecyclerViewActivity;
import com.sw0039.justdoit.R;

/**
 * 测试动画
 */
public class TestAnimationActivity extends BaseRecyclerViewActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("测试动画");
        //添加数据
        String[] arrays = getResources().getStringArray(R.array.animation_list);
        String[] activitys = getResources().getStringArray(R.array.animation_action_list);
        addDatas(arrays,activitys);
    }
}
