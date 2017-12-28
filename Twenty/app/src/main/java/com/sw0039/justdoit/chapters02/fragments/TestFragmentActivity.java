package com.sw0039.justdoit.chapters02.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.sw0039.justdoit.R;
import com.sw0039.justdoit.chapters02.fragments.savedata.HomeActivity;
import com.sw0039.justdoit.utils.LogUtils;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 测试fragment的应用
 */
public class TestFragmentActivity extends FragmentActivity {


    @BindView(R.id.content_framelayout)
    LinearLayout contentFramelayout;
    @BindView(R.id.firstpage_btn)
    Button firstpageBtn;
    @BindView(R.id.comment_btn)
    Button commentBtn;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;
    @BindView(R.id.relativeLayout)
    ConstraintLayout relativeLayout;

    //获取管理对象
    FragmentManager fragmentManager = null;
    //开启事务
    FragmentTransaction fragmentTransaction = null;

    private int delayMillis = 10 * 1000;
    private MyHandler myHandler = null;

    private static class MyHandler extends Handler {
        WeakReference<TestFragmentActivity> activitys;

        public MyHandler(TestFragmentActivity activity) {
            activitys = new WeakReference<TestFragmentActivity>(activity);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment);
        ButterKnife.bind(this);
        myHandler = new MyHandler(this);

        //①hideAndShow
//        addFragments();

        //②replace的一个bug
//        addFragments1();

        //③fragment回退栈
//        addFragmentToBackStack();

        //④处理横竖屏切换，网络请求和防止大量数据丢失的方法。
        saveDataWithFragment();
    }

    /**
     * 测试activity切换横竖屏的时候,利用fragment保存数据
     */
    private void saveDataWithFragment() {
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
    }

    private void addFragmentToBackStack() {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        FragmentOne fragmentOne = new FragmentOne();
        fragmentTransaction.add(R.id.content_framelayout,fragmentOne);
        fragmentTransaction.commit();

        //隐藏上一个功能用到的控件
        hideOtherView();
    }

    private void hideOtherView() {
        firstpageBtn.setVisibility(View.GONE);
        commentBtn.setVisibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != myHandler) {
            myHandler.removeCallbacksAndMessages(null);
        }
    }

    /*---------start--------replace no bug--------------------*/
    //②
    String[] arrays = new String[]{"第1页", "第2页", "第3页", "第4页", "第5页", "第6页"};

    /**
     * ②
     * replace多个fragment
     */
    private void addFragments1() {
        //获取管理对象
        FragmentManager fragmentManager = getSupportFragmentManager();
        //开启事务
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        for (int i = 0; i < arrays.length; i++) {
            FirstPageFragment fragment = FirstPageFragment.getInstance(arrays[i]);
            fragmentTransaction.add(R.id.content_framelayout, fragment, arrays[i]);
            fragmentTransaction.hide(fragment);
        }
//        fragmentTransaction.hide(comment3);
        fragmentTransaction.commit();

        //
        myHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                printAllFragments();
            }
        }, delayMillis);

    }

    private void replaceFragment(boolean isFirstPage) {
        //获取管理对象
        FragmentManager fragmentManager = getSupportFragmentManager();
        //开启事务
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (isFirstPage) {
            fragmentTransaction.replace(R.id.content_framelayout, FirstPageFragment.getInstance("首页"), "首页");
        } else {
            fragmentTransaction.replace(R.id.content_framelayout, FirstPageFragment.getInstance("推荐"), "推荐");
        }
        fragmentTransaction.commit();
        myHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                printAllFragments();
            }
        }, delayMillis);
    }

    public void printAllFragments() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (null == fragmentManager) {
            LogUtils.printWarn("测试fragment replace的bug", "fragmentManager == null");
            return;
        }

        for (int i = 0; i < arrays.length; i++) {
            Fragment fragment = fragmentManager.findFragmentByTag(arrays[i]);
            if (null != fragment) {
                FirstPageFragment firstPageFragment = (FirstPageFragment) fragment;
                printTag(firstPageFragment);
            }
        }

        Fragment fragment = fragmentManager.findFragmentByTag("首页");
        if (null != fragment) {
            FirstPageFragment firstPageFragment = (FirstPageFragment) fragment;
            printTag(firstPageFragment);
        }

        Fragment fragment1 = fragmentManager.findFragmentByTag("推荐");
        if (null != fragment1) {
            FirstPageFragment firstPageFragment = (FirstPageFragment) fragment1;
            printTag(firstPageFragment);
        }
    }

    private void printTag(FirstPageFragment firstPageFragment) {
        if (null != firstPageFragment) {
            String content = firstPageFragment.getContent();
            if (TextUtils.isEmpty(content)) {
                LogUtils.printWarn("测试fragment replace的bug", "无显示内容");
            } else {
                LogUtils.printWarn("测试fragment replace的bug", content);
            }
        }
    }
    /*---------end--------replace no bug--------------------*/


    /*---------start--------hideAndShow--------------------*/
    //①
    FirstPageFragment firstPageFragment;
    CommentFragment commentFragment;

    private void addFragments() {
        //获取管理对象
        FragmentManager fragmentManager = getSupportFragmentManager();
        //开启事务
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        firstPageFragment = FirstPageFragment.getInstance(null);
        commentFragment = CommentFragment.getInstance(null);
        //参数一，需要替换的布局里的控件id。参数二，用来替换的fragment
        fragmentTransaction.add(R.id.content_framelayout, firstPageFragment);
        fragmentTransaction.add(R.id.content_framelayout, commentFragment);
        fragmentTransaction.hide(firstPageFragment);
        fragmentTransaction.hide(commentFragment);
        fragmentTransaction.commit();
    }

    private void hideAndShow(boolean isFirstPage) {
        //获取管理对象
        FragmentManager fragmentManager = getSupportFragmentManager();
        //开启事务
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (isFirstPage) {
            fragmentTransaction.hide(commentFragment);
            fragmentTransaction.show(firstPageFragment);
        } else {
            fragmentTransaction.hide(firstPageFragment);
            fragmentTransaction.show(commentFragment);
        }
        fragmentTransaction.commit();
    }
    /*---------end--------hideAndShow--------------------*/

    @OnClick({R.id.firstpage_btn, R.id.comment_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.firstpage_btn://首页
                //①
//                hideAndShow(true);
                //②
                replaceFragment(true);
                break;
            case R.id.comment_btn://推荐
                //①
//                hideAndShow(false);
                //②
                replaceFragment(false);
                break;
        }
    }
}
