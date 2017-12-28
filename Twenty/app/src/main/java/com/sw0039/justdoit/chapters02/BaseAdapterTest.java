package com.sw0039.justdoit.chapters02;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.sw0039.justdoit.R;

/**
 * BaseAdapter自定义adapter
 */
public class BaseAdapterTest extends Activity
{
	ListView myList;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_baseadapter);
		myList = (ListView) findViewById(R.id.myList);
		BaseAdapter adapter = new BaseAdapter()
		{
			@Override
			public int getCount()
			{
				// 指定一共包含40个选项
				return 40;
			}
			@Override
			public Object getItem(int position)
			{
				return null;
			}
			// 重写该方法，该方法的返回值将作为列表项的ID
			@Override
			public long getItemId(int position)
			{
				return position;
			}
			// 重写该方法，该方法返回的View将作为列表框
			@Override
			public View getView(int position
					, View convertView , ViewGroup parent)
			{
				// 创建一个LinearLayout，并向其中添加两个组件
				LinearLayout line = new LinearLayout(BaseAdapterTest.this);
				line.setOrientation(LinearLayout.HORIZONTAL);
				ImageView image = new ImageView(BaseAdapterTest.this);
				image.setImageResource(R.mipmap.ic_launcher);
				TextView text = new TextView(BaseAdapterTest.this);
				text.setText("第" + (position +1 ) + "个列表项");
				text.setTextSize(20);
				text.setTextColor(Color.RED);
				line.addView(image);
				line.addView(text);
				// 返回LinearLayout实例
				return line;
			}
		};
		myList.setAdapter(adapter);
	}
}
