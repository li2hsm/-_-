package com.sw0039.justdoit.chapters02.menus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

import com.sw0039.justdoit.R;
import com.sw0039.justdoit.chapters02.OtherActivity1;

/**
 * 点击物理菜单键弹出的菜单
 */
public class ActivityMenu extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// -------------向menu中添加子菜单-------------
		SubMenu prog = menu.addSubMenu("启动程序");
		// 设置菜单头的图标
		prog.setHeaderIcon(R.drawable.tools);
		// 设置菜单头的标题
		prog.setHeaderTitle("选择您要启动的程序");
		// 添加菜单项
		MenuItem item = prog.add("查看Swift");
		//为菜单项设置关联的Activity
		item.setIntent(new Intent(this , OtherActivity1.class));
		return super.onCreateOptionsMenu(menu);
	}
}

