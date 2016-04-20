package com.mobile.database.app;

import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;

public abstract class DBModel<T, I> {
	
	private DBHelper objDB;
	private Dao<T, I> objDao;
	private boolean isDaoExist = false;
	
	public DBModel() {
		init();
	}
	
	protected abstract Class<T> onGetTableModel();
	
	private void init() {
		
		objDB = DBHelper.getInstance(DBConfig.getAttachedContext());
		
		if (objDB != null) {
			Class<T> tableModel = onGetTableModel();
			if (tableModel != null) {
				try {
					objDao = objDB.getDao(tableModel);
					if (objDao != null) {
						isDaoExist = true;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public DBHelper getDb() {
		return objDB;
	}
	
	public boolean isDaoExist() {
		return isDaoExist;
	}
	
	public Dao<T, I> getDao() {
		return objDao;
	}
	
	public void release() {
		objDao = null;
		isDaoExist = false;
		DBHelper.repleaseInstance();
		objDB = null;
	}	

}
