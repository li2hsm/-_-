package com.sw0039.justdoit.chapters02;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.ToggleButton;

import com.sw0039.justdoit.R;

/**
 * 开关按钮ToggleButton
 */
public class ToggleButtonTest extends Activity
{
	ToggleButton toggle;
	Switch switcher;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_togglebutton);
		toggle = (ToggleButton)findViewById(R.id.toggle);
		switcher = (Switch)findViewById(R.id.switcher);
		final LinearLayout test = (LinearLayout)findViewById(R.id.test);
		OnCheckedChangeListener listener = new OnCheckedChangeListener()
		{
			@Override
			public void onCheckedChanged(CompoundButton button
				, boolean isChecked)
			{
				if(isChecked)
				{
					// 设置LinearLayout垂直布局
					test.setOrientation(LinearLayout.VERTICAL);
					toggle.setChecked(true);
					switcher.setChecked(true);
				}
				else
				{
					// 设置LinearLayout水平布局
					test.setOrientation(LinearLayout.HORIZONTAL);
					toggle.setChecked(false);
					switcher.setChecked(false);
				}
			}
		};
		toggle.setOnCheckedChangeListener(listener);
		switcher.setOnCheckedChangeListener(listener);
	}
}
