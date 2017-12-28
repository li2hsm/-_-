package com.sw0039.justdoit.chapters02.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sw0039.justdoit.R;

/**
 * 测试回退栈的 第一个fragment
 * Created by hsm on 2017/12/12.
 */
public class FragmentOne extends BaseFragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewGroup = super.onCreateView(inflater, container, savedInstanceState);
        setButtonText("跳转到fragment two");
        return viewGroup;
    }

    public void onViewClicked() {
        FragmentTwo fragmentTwo = new FragmentTwo();
        fragmentTransaction.replace(R.id.content_framelayout,fragmentTwo);
        //将当前的事务添加到了回退栈，所以FragmentOne实例不会被销毁
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
