package com.sw0039.justdoit.questions;

import android.os.Bundle;

import com.sw0039.justdoit.BaseRecyclerViewActivity;
import com.sw0039.justdoit.R;

/**
 * 所有的问题再现，与解决
 */
public class AllQuestionsActivity extends BaseRecyclerViewActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("所有的问题再现，与解决");
        //添加数据
        String[] arrays = getResources().getStringArray(R.array.questions_list);
        String[] activitys = getResources().getStringArray(R.array.question_action_list);
        addDatas(arrays,activitys);
    }
}
