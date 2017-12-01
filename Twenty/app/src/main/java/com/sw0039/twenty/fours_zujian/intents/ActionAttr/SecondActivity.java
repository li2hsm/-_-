package com.sw0039.twenty.fours_zujian.intents.ActionAttr;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import com.sw0039.twenty.R;

public class SecondActivity extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		EditText show = (EditText) findViewById(R.id.show);
		// 获取该Activity对应的Intent的Action属性
		String action = getIntent().getAction();
		// 显示Action属性
		show.setText("Action为：" + action);
	}
}
