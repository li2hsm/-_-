package com.sw0039.justdoit.chapters02;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

/**
 * ListActivity
 */
public class ListActivityTest extends ListActivity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		// 无须使用布局文件
		String[] arr = { "孙悟空", "猪八戒", "唐僧" };
		// 创建ArrayAdapter对象
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_multiple_choice, arr);
		// 设置该窗口显示列表
		setListAdapter(adapter);
	}
}

