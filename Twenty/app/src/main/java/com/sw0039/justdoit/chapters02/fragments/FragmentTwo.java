package com.sw0039.justdoit.chapters02.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sw0039.justdoit.R;

/**
 * 测试回退栈的 第二个fragment
 * Created by hsm on 2017/12/12.
 */
public class FragmentTwo extends BaseFragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewGroup = super.onCreateView(inflater, container, savedInstanceState);
        setButtonText("跳转到fragment three");
        return viewGroup;
    }

    public void onViewClicked() {
        FragmentThree fragmentThree = new FragmentThree();
        fragmentTransaction.hide(this);
        fragmentTransaction.add(R.id.content_framelayout,fragmentThree);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
