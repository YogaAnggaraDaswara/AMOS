package com.mobile.bo.app.dataprovider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.mobile.bo.app.datatype.UserData;
import com.mobile.database.app.entities.USER;


public class UserDataProvider extends BaseDataProvider {

	public int deleteUser(UserData userData) {
		int retVal = 0;
		if (isDaoMstUserExist()) {
			try {
				retVal = getdoaUSER().deleteById(userData.getUSERID());
			} catch (SQLException e) {

				e.printStackTrace();
			}			
		}
		return retVal;
	}
	
	public int updateUser(UserData userData) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoMstUserExist()) {
			try {
				result = getdoaUSER().createOrUpdate(userData.toRowData());
				retVal = result.getNumLinesChanged();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return retVal;		
	}
	
	public int updateUser(USER userData) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoMstUserExist()) {
			try {
				result = getdoaUSER().createOrUpdate(userData);
				retVal = result.getNumLinesChanged();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return retVal;
	}
	
	public boolean isAnyUserInDatabase() {
		boolean retVal = false;
		long count = 0;
		if (isDaoMstUserExist()) {
			try {
				count = getdoaUSER().countOf();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (count > 0) {
				retVal = true;
			}
		}
		return retVal;
	}
	
	public ArrayList<UserData> getAllUser() {
		ArrayList<UserData> retVal = new ArrayList<UserData>();
		List<USER> qResult = null;
		
		if (isDaoMstUserExist()) {
			try {
				qResult = getdoaUSER().queryForAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (USER user : qResult) {
					retVal.add(new UserData(user));
				}
			}
		}
		
		return retVal;
	}
	
	public int getAllUserCount() {
		int retVal=0;
		if (isDaoMstUserExist()) {
			try {
				retVal = getdoaUSER().queryForAll().size();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		
		return retVal;
	}
	
	public UserData getUser(String username,String password) {
		UserData retData = null;
		USER qResult = null;
		
		if (isDaoMstUserExist()) {
			try {
				qResult = getdoaUSER().queryForFirst(
						getdoaUSER().queryBuilder().where().like("USERID", username).and()
						.like("PASSWORD", password).prepare());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				retData = new UserData(qResult);
			}
		}
		
		return retData;
	}
	
}
