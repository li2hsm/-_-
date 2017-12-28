package com.sw0039.justdoit;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

/**
 * 测试搜索控件的，包括搜索图标，输入框，清除内容按钮，搜索按钮。
 */
public class SearchViewActivity extends AppCompatActivity {

    private SearchView mSearchView;
    private ListView mListView;
    private Context mContext;

    private String[] autoStrings = new String[]{"aaaa","bbbb","cccc"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);
        mContext = this;
        initViews();
    }

    /**
     * 初始化界面
     */
    private void initViews() {
        mListView = (ListView) findViewById(R.id.listview);
        mListView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,
                autoStrings));

        mSearchView = (SearchView) findViewById(R.id.search_view);
        //默认显示小图标
        mSearchView.setIconifiedByDefault(true);
        //设置显示搜索按钮
        mSearchView.setSubmitButtonEnabled(true);
        //设置搜索框的默认文本
        mSearchView.setQueryHint("查找");
        //设置文本监听器
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //单击搜索按钮事件
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(mContext,"你要搜索的是："+query,Toast.LENGTH_SHORT).show();
                return false;
            }
            //用户输入文本事件
            @Override
            public boolean onQueryTextChange(String newText) {

                if(TextUtils.isEmpty(newText)){

                }else{

                }
                return true;
            }
        });
    }
}
