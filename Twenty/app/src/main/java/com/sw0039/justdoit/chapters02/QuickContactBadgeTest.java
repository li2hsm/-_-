package com.sw0039.justdoit.chapters02;

import android.app.Activity;
import android.os.Bundle;
import android.widget.QuickContactBadge;

import com.sw0039.justdoit.R;

/**
 * QuickContactBadge添加陌生号码到联系人
 */
public class QuickContactBadgeTest extends Activity
{
	QuickContactBadge badge;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_quickcontactbadge);
		// 获取QuickContactBadge组件
		badge = (QuickContactBadge) findViewById(R.id.badge);
		// 将QuickContactBadge组件与特定电话号码对应的联系人建立关联
		badge.assignContactFromPhone("020-88888888", false);
	}
}

