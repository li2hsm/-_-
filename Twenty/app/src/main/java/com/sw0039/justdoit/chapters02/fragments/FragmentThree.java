package com.sw0039.justdoit.chapters02.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sw0039.justdoit.utils.LogUtils;

/**
 * 测试回退栈的 第三个fragment
 * Created by hsm on 2017/12/12.
 */
public class FragmentThree extends BaseFragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewGroup = super.onCreateView(inflater, container, savedInstanceState);
        setButtonText("最后一页了");
        return viewGroup;
    }

    public void onViewClicked() {
        LogUtils.showShortToast(getActivity(),"最后一页了");
    }
}
