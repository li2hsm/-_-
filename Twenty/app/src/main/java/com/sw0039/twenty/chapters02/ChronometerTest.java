package com.sw0039.twenty.chapters02;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import com.sw0039.twenty.R;

import static android.widget.Chronometer.OnChronometerTickListener;

/**
 * 计时器，只到秒
 */
public class ChronometerTest extends Activity
{
	Chronometer ch;
	Button start;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_chronometer);
		// 获取计时器组件
		ch = (Chronometer) findViewById(R.id.test);
		// 获取“开始”按钮
		start = (Button) findViewById(R.id.start);
		start.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View source)
			{
				// 设置开始计时时间
				ch.setBase(SystemClock.elapsedRealtime());
				// 启动计时器
				ch.start();
				start.setEnabled(false);
			}
		});
		// 为Chronometer绑定事件监听器
		ch.setOnChronometerTickListener(new OnChronometerTickListener()
		{
			@Override
			public void onChronometerTick(Chronometer ch)
			{
				// 如果从开始计时到现在超过了20s
				if (SystemClock.elapsedRealtime() - ch.getBase() > 20 * 1000)
				{
					ch.stop();
					start.setEnabled(true);
				}
			}
		});
	}
}
