package com.sw0039.twenty.chapters02;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.sw0039.twenty.R;


public class TextSwitcherTest extends Activity
{
	TextSwitcher textSwitcher;
	String[] strs = new String[]
	{
		"疯狂Java讲义",
		"轻量级Java EE企业应用实战",
		"疯狂Android讲义",
		"疯狂Ajax讲义"
	};
	int curStr;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_textswitcher);
		textSwitcher = (TextSwitcher) findViewById(R.id.textSwitcher);
		textSwitcher.setFactory(new ViewSwitcher.ViewFactory()
		{
			public View makeView()
			{
				TextView tv = new TextView(TextSwitcherTest.this);
				tv.setTextSize(40);
				tv.setTextColor(Color.MAGENTA);
				return tv;
			}
		});
		// 调用next方法显示下一个字符串
		next(null);
	}
	// 事件处理函数，控制显示下一个字符串
	public void next(View source)
	{
		textSwitcher.setText(strs[curStr++ % strs.length]);  // ①
	}
}
