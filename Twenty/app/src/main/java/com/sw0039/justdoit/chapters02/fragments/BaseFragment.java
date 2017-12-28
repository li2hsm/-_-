package com.sw0039.justdoit.chapters02.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.sw0039.justdoit.R;
import com.sw0039.justdoit.utils.ViewTools;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 上面有一个输入框，中间一个按钮
 * Created by hsm on 2017/12/10.
 */
public class BaseFragment extends Fragment {


    @BindView(R.id.base_fragment_edit)
    public EditText baseFragmentEdit;
    @BindView(R.id.base_fragment_btn)
    public Button baseFragmentBtn;
    Unbinder unbinder;

    //获取管理对象
    FragmentManager fragmentManager = null;
    //开启事务
    FragmentTransaction fragmentTransaction = null;

    public BaseFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewgroup = ViewTools.getXmlViewFragment(getActivity(), inflater, R.layout.base_fragment_layout);

        fragmentManager = getActivity().getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        unbinder = ButterKnife.bind(this, viewgroup);
        return viewgroup;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.base_fragment_btn)
    public void onViewClicked() {
        //处理按钮的事件

    }

    /**
     * 设置按钮的文字
     * @param buttonText
     */
    public void setButtonText(String buttonText){
        if(!TextUtils.isEmpty(buttonText)){
            baseFragmentBtn.setText(buttonText);
        }
    }
}
