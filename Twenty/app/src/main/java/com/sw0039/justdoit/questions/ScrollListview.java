package com.sw0039.justdoit.questions;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * 使ListView适应ScrollView的效果
 * Created by Administrator on 2017/11/25.
 */
public class ScrollListview extends ListView{

    public ScrollListview(Context context) {
        super(context);
    }

    public ScrollListview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollListview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //重写该方法，达到使ListView适应ScrollView的效果
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                       MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
