package com.sw0039.twenty.chapters02;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import com.sw0039.twenty.R;


public class AutoCompleteTextViewTest extends Activity
{
	AutoCompleteTextView actv;
	MultiAutoCompleteTextView mauto;
	// 定义字符串数组，作为提示的文本
	String[] books = new String[]{
			"疯狂Java讲义",
			"疯狂Ajax讲义",
			"疯狂XML讲义",
			"疯狂Workflow讲义"
	};
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_autocompletetextview);
		// 创建一个ArrayAdapter，封装数组
		ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line, books);
		actv = (AutoCompleteTextView)findViewById(R.id.auto);
		// 设置Adapter
		actv.setAdapter(aa);
		//多文本输入框，可以同时输入多个字符串,用指定的分隔符分开。
		mauto = (MultiAutoCompleteTextView)findViewById(R.id.mauto);
		// 设置Adapter
		mauto.setAdapter(aa);
		// 为MultiAutoCompleteTextView设置分隔符
		mauto.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
	}
}

