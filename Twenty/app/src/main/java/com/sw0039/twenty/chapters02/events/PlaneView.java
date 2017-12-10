package com.sw0039.twenty.chapters02.events;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.sw0039.twenty.R;

public class PlaneView extends View
{
	public float currentX;
	public float currentY;
	Bitmap plane;

	public PlaneView(Context context) {
		super(context);
		inits(context);
	}

	public PlaneView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		inits(context);
	}

	public PlaneView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		inits(context);
	}

	//	public PlaneView(Context context)
//	{
//		super(context);
//		// 定义飞机图片
//		plane = BitmapFactory.decodeResource(context.getResources(),
//			R.mipmap.plane);
//		setFocusable(true);
//	}

	private void inits(Context context){
		// 定义飞机图片
		plane = BitmapFactory.decodeResource(context.getResources(),
			R.mipmap.plane);
		setFocusable(true);
	}
	@Override
	public void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
		// 创建画笔
		Paint p = new Paint();
		// 绘制飞机
		canvas.drawBitmap(plane, currentX, currentY, p);
	}
}
