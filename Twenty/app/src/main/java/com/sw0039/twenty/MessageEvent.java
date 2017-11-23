package com.sw0039.twenty;

import android.view.View;

/**
 * eventbus的参数类
 * Created by Administrator on 2017/11/12.
 */
public class MessageEvent {
    private String mShowMsg;
    private String mBtnName;
    private View.OnClickListener mOnClickListener;

    public String getmShowMsg() {
        return mShowMsg;
    }

    public void setmShowMsg(String mShowMsg) {
        this.mShowMsg = mShowMsg;
    }

    public String getmBtnName() {
        return mBtnName;
    }

    public void setmBtnName(String mBtnName) {
        this.mBtnName = mBtnName;
    }

    public View.OnClickListener getmOnClickListener() {
        return mOnClickListener;
    }

    public void setmOnClickListener(View.OnClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
    }
}
