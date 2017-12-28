package com.sw0039.justdoit.chapters02.menus;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.sw0039.justdoit.R;


public class PopupMenuTest extends Activity
{
	PopupMenu popup = null;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_pop_menu);
	}
	public void onPopupButtonClick(View button)
	{
		// 创建PopupMenu对象
		popup = new PopupMenu(this, button);
		// 将R.menu.popup_menu菜单资源加载到popup菜单中
		getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
		// 为popup菜单的菜单项单击事件绑定事件监听器
		popup.setOnMenuItemClickListener(
			new PopupMenu.OnMenuItemClickListener()
			{
				@Override
				public boolean onMenuItemClick(MenuItem item)
				{
					switch (item.getItemId())
					{
						case R.id.exit:
							// 隐藏该对话框
							popup.dismiss();
							break;
						default:
							// 使用Toast显示用户单击的菜单项
							Toast.makeText(PopupMenuTest.this,
								"您单击了【" + item.getTitle() + "】菜单项"
								, Toast.LENGTH_SHORT).show();
							break;
					}
					return true;
				}
			});
		popup.show();
	}
}

