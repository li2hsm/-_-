package com.sw0039.twenty;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sw0039.twenty.chapters02.Chapter02Activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
