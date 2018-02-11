package com.sw0039.justdoit.utils;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * 界面的功能函数
 * Created by Administrator on 2017/11/23.
 */
public class ViewTools {

    /**
     * 动态设置listview的高度
     *
     * @param listView
     */
    public static void setListViewHeightBasedOnChildren(ListView listView, Context context) {
        ListAdapter listAdapter = listView.getAdapter();
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        if (listAdapter == null) {
            // pre-condition
            return;
        }
        int totalHeight = 0;
        View view;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, null, listView);
            //宽度为屏幕宽度
            int i1 = View.MeasureSpec.makeMeasureSpec(ActionTools.getScreenWidth(context),
                    View.MeasureSpec.EXACTLY);
            //根据屏幕宽度计算高度
            int i2 = View.MeasureSpec.makeMeasureSpec(i1, View.MeasureSpec.UNSPECIFIED);
            view.measure(i1, i2);
            totalHeight += view.getMeasuredHeight();
        }
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    /**
     * 用于计算高度一样的listview的总高度
     *
     * @param listView
     */
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    /**
     * 设置activity dialog为全屏显示
     *
     * @param activity
     */
    public static void setDialogFullScreen(Activity activity) {
        if (null == activity) {
            return;
        }

        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.width = ActionTools.getScreenWidth(activity);
        lp.height = (int) (ActionTools.getScreenHeight(activity) * 0.68);
        lp.gravity = Gravity.BOTTOM;
        activity.getWindow().setAttributes(lp);
    }

    /**
     * 动态加载xml布局
     *
     * @param context
     * @param layoutId
     * @return
     */
    public static View getXmlView(Context context, int layoutId) {
        if (null == context) {
            return null;
        }

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (null == inflater) {
            return null;
        }

        return inflater.inflate(layoutId, null);
    }

    /**
     * Fragment动态加载xml布局
     * @param context
     * @param inflater
     * @param layoutId
     * @return
     */
    public static View getXmlViewFragment(Context context,LayoutInflater inflater, int layoutId) {
        if (null == context||null == inflater) {
            return null;
        }

        return inflater.inflate(layoutId, null);
    }
}
