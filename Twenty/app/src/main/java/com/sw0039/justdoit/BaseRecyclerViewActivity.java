package com.sw0039.justdoit;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sw0039.justdoit.utils.ActionTools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 只带一个RecyclerView的界面
 */
public class BaseRecyclerViewActivity extends AppCompatActivity {

    @BindView(R.id.title_textview)
    TextView titleTextview;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    private HomeAdapter adapter;
    private List<String> mList = new ArrayList<>();

    //该页需要跳转的activity数组
    private String[] activityArrays = null;

    public Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //隐藏ActionBar
//        getSupportActionBar().hide();

        ButterKnife.bind(this);
//        requestWindowFeature(Window.FEATURE_PROGRESS);

        mContext = this;
        initViews();
    }

    /**
     * 添加数据
     * @param arrays
     */
    public void addDatas(String[] arrays, String[] activityArrays) {
        mList = Arrays.asList(arrays);
        adapter.notifyDataSetChanged();

        int arrayLength = activityArrays.length;
        this.activityArrays = new String[arrayLength];
        //5个参数  原数组 起始index  数组2   起始index  拷贝长度
        System.arraycopy(activityArrays,0,this.activityArrays,0,arrayLength);
    }

    /**
     * 设置标题
     *
     * @param title
     */
    public void setTitle(String title) {
        titleTextview.setText(title);
    }

    private void initViews() {

        //设置布局管理器
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        //设置adapter
        adapter = new HomeAdapter();
        adapter.setOnItemClicker(new OnItemClicker() {
            @Override
            public void OnClickListeners(View view, int pos) {
//                Toast.makeText(mContext,"点击"+pos+"项",Toast.LENGTH_SHORT).show();
                go2FunctionActivity(pos);
            }
        });
        recyclerview.setAdapter(adapter);
        //设置Item增加、移除动画
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        //添加分割线
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(
                mContext, DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.listview_line_bg));
        recyclerview.addItemDecoration(dividerItemDecoration);
    }

    private void go2FunctionActivity(int pos) {
        ActionTools.go2ActivityByClassName(mContext, activityArrays[pos]);
    }

    /**
     * 适配器
     */
    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

        private OnItemClicker mOnItemClicker;

        public void setOnItemClicker(OnItemClicker onItemClicker) {
            this.mOnItemClicker = onItemClicker;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder mViewHolder = new MyViewHolder(LayoutInflater.from(BaseRecyclerViewActivity.this).
                    inflate(R.layout.main_function_list_item, parent, false));
            return mViewHolder;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {
            holder.mTextView.setText((position+1)+","+mList.get(position));
            //设置点击事件
            if (null != mOnItemClicker) {
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = holder.getLayoutPosition();
                        mOnItemClicker.OnClickListeners(v, pos);
                    }
                });
            }
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView mTextView;
            RelativeLayout mRe;

            public MyViewHolder(View itemView) {
                super(itemView);
                mTextView = (TextView) itemView.findViewById(R.id.textview);
                mRe = (RelativeLayout) itemView.findViewById(R.id.root_view);
            }
        }
    }


    public interface OnItemClicker {
        public void OnClickListeners(View view, int pos);
    }
}
