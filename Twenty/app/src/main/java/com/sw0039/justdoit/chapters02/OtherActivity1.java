
package com.sw0039.justdoit.chapters02;

import android.app.Activity;
import android.os.Bundle;

import com.sw0039.justdoit.R;

public class OtherActivity1 extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		// 设置该Activity显示的页面
		setContentView(R.layout.other);
	}
}

