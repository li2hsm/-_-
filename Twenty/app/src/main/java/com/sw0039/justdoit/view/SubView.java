package com.sw0039.justdoit.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

public class SubView extends TextView {

    public SubView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected void onDraw(android.graphics.Canvas canvas) {
        int px = getMeasuredWidth();
        int py = getMeasuredHeight();

        Paint backgroundPaint = new Paint();
        backgroundPaint.setColor(Color.CYAN);
        canvas.drawRect(0, 0, px, py, backgroundPaint);

        canvas.save();
        // 顺时针旋转180度
        canvas.rotate(180, px / 2, py / 2);

        Paint linePaint = new Paint();
        linePaint.setColor(Color.RED);

        canvas.drawLine(px / 2, 0, 0, py / 2, linePaint);
        canvas.drawLine(px / 2, 0, px, py / 2, linePaint);
        canvas.drawLine(px / 2, 0, px / 2, py, linePaint);

        // 恢复到调用save()方法之前的状态
        // 即没有顺时针旋转180度
        canvas.restore();

        canvas.drawCircle(px - 20, py - 20, 20, linePaint);
    }
}