package com.sw0039.justdoit.shape_drawables;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sw0039.justdoit.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * ShapeDrawable用来画几何图形
 */
public class ShapeDrawableTest extends Activity {


    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    private Unbinder mUnbinder;
    private List<ShapeDrawableBean> mList;
    private RecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shape_drawable_activity);
        mUnbinder = ButterKnife.bind(this);

        initDatas();
        setViewDatas();
    }

    private void setViewDatas() {
        //设置布局管理器
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        //设置分割线
        mRecyclerview.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        //设置Item增加、移除动画
        mRecyclerview.setItemAnimator(new DefaultItemAnimator());
        //设置适配器
        mAdapter = new RecyclerViewAdapter(this, mList);
        mRecyclerview.setAdapter(mAdapter);
    }

    private void initDatas() {
        mList = new ArrayList<>();
        mList.add(getItemBean(0));//直角矩形
        mList.add(getItemBean(1));//圆角矩形
        mList.add(getItemBean(2));//无填充带边框
        mList.add(getItemBean(3));//渐变
        mList.add(getItemBean(4));//纯色的圆
        mList.add(getItemBean(5));//圆的渐变效果
        mList.add(getItemBean(6));//虚线
        mList.add(getItemBean(7));//圆环

    }

    private ShapeDrawableBean getItemBean(int type){
        ShapeDrawableBean shapeDrawableBean = new ShapeDrawableBean();
        switch (type){
            case 0:
                shapeDrawableBean.setName("直角矩形");
                shapeDrawableBean.setImgId(R.drawable.rectangle_shape);
                break;
            case 1:
                shapeDrawableBean.setName("圆角矩形");
                shapeDrawableBean.setImgId(R.drawable.rectangle_shape1);
                break;
            case 2:
                shapeDrawableBean.setName("无填充带边框");
                shapeDrawableBean.setImgId(R.drawable.rectangle_shape2);
                break;
            case 3:
                shapeDrawableBean.setName("渐变");
                shapeDrawableBean.setImgId(R.drawable.rectangle_shape3);
                break;
            case 4:
                shapeDrawableBean.setName("纯色的圆");
                shapeDrawableBean.setImgId(R.drawable.rectangle_shape4);
                break;
            case 5:
                shapeDrawableBean.setName("圆的渐变效果");
                shapeDrawableBean.setImgId(R.drawable.rectangle_shape5);
                break;
            case 6:
                shapeDrawableBean.setName("虚线");
                shapeDrawableBean.setImgId(R.drawable.rectangle_shape6);
                break;
            case 7:
                shapeDrawableBean.setName("圆环");
                shapeDrawableBean.setImgId(R.drawable.rectangle_shape7);
                break;
            default:
                break;
        }

        return shapeDrawableBean;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }

    //recyclerview的适配器
    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

        private Context mContext;
        private List<ShapeDrawableBean> mDataList;

        public RecyclerViewAdapter(Context context, List<ShapeDrawableBean> mList) {
            mContext = context;
            mDataList = mList;
        }

        //加载layout的布局
        @Override
        public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ViewHolder holder = new ViewHolder(LayoutInflater.from(mContext).
                    inflate(R.layout.shape_drawable_item, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
            ShapeDrawableBean itemData = mDataList.get(position);
            if (itemData != null ) {
                holder.mNametext.setText(itemData.getName());
                holder.mImageview.setImageResource(itemData.getImgId());
            }
        }

        @Override
        public int getItemCount() {
            return mDataList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.nametext)
            public TextView mNametext;
            @BindView(R.id.imageview)
            public ImageView mImageview;

            ViewHolder(View view) {
                super(view);
                ButterKnife.bind(this, view);
            }
        }
    }
}
