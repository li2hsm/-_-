
package com.sw0039.twenty.chapters02;

import android.app.Activity;
import android.os.Bundle;

import com.sw0039.twenty.R;

public class OtherActivity extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		//设置该Activity显示的页面
		setContentView(R.layout.other);
	}
}