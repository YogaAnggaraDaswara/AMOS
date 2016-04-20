package com.mobile.framework.activity;

import com.mobile.framework.data.ExDataTable;

import android.app.Activity;

public abstract class ExDatabaseActivity extends Activity {

	public abstract ExDataTable onGetDataTable(String tableName, String condition);
	
}
