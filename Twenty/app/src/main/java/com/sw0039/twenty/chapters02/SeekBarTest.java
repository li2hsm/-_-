package com.sw0039.twenty.chapters02;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.sw0039.twenty.R;

import static android.widget.SeekBar.OnSeekBarChangeListener;


public class SeekBarTest extends Activity
{
	ImageView image;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_seekbar);
		image = (ImageView) findViewById(R.id.image);
		SeekBar seekBar = (SeekBar) findViewById(R.id.seekbar);
		seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener()
		{
			// 当拖动条的滑块位置发生改变时触发该方法
			@Override
			public void onProgressChanged(SeekBar arg0, int progress,
										  boolean fromUser)
			{
				// 动态改变图片的透明度
				image.setImageAlpha(progress);
			}
			@Override
			public void onStartTrackingTouch(SeekBar bar)
			{
			}
			@Override
			public void onStopTrackingTouch(SeekBar bar)
			{
			}
		});
	}
}


