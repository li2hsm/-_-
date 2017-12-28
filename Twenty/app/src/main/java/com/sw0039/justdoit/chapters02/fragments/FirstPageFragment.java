package com.sw0039.justdoit.chapters02.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sw0039.justdoit.R;
import com.sw0039.justdoit.utils.ViewTools;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 首页的fragment
 * Created by Administrator on 2017/12/10.
 */
public class FirstPageFragment extends Fragment {

    String content;

    /**
     * fragment用于保存activity的状态，当activity销毁的时候，这个时候需要重新创建fragment，
     * 但是这个时候参数就没有了。
     * 所以一定要用无参数的构造函数
     * 防止数据丢失,就不直接使用构造函数传参数
     * @param str
     * @return
     */
    public static FirstPageFragment getInstance(String str){
        FirstPageFragment instance = new FirstPageFragment();
        Bundle args = new Bundle();
        args.putString("content", str);
        instance.setArguments(args);
        return instance;
    }


    public FirstPageFragment() {
    }

    private ViewHolder viewHolder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewgroup = ViewTools.getXmlViewFragment(getActivity(), inflater, R.layout.fragment_firstpage);
        viewHolder = new ViewHolder(viewgroup);
        getParams();
        if (TextUtils.isEmpty(content)) {
            viewHolder.textview.setText("首页的fragment");
        } else {
            viewHolder.textview.setText(content);
        }

        return viewgroup;
    }

    private void getParams(){
        Bundle bundle = getArguments();
        if(bundle!=null){
            content = bundle.getString("content");
        }
    }

    public String getContent(){
        return content;
    }

    static class ViewHolder {
        @BindView(R.id.textview)
        TextView textview;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
