package com.sw0039.twenty.chapters02.actionbars;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.sw0039.twenty.R;

import static android.widget.SeekBar.OnSeekBarChangeListener;


public class SeekBarTest extends Activity
{
	ImageView image;
	Handler mHandler;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_seekbar);
		mHandler = new Handler();
//		mHandler.sendEmptyMessage();
		image = (ImageView) findViewById(R.id.image);
		SeekBar seekBar = (SeekBar) findViewById(R.id.seekbar);
		seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener()
		{
			// 当拖动条的滑块位置发生改变时触发该方法
			@Override
			public void onProgressChanged(SeekBar arg0, final int progress,
										  boolean fromUser)
			{
				image.setImageAlpha(progress);
//				if(progress%10==0){
//					// 动态改变图片的透明度
//					mHandler.postDelayed(new Runnable() {
//						@Override
//						public void run() {
//							image.setImageAlpha(progress);
//						}
//					},1000);
//				}

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


