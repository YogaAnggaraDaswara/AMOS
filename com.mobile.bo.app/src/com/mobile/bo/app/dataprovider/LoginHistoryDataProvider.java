package com.mobile.bo.app.dataprovider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.mobile.bo.app.datatype.LoginHistoryData;
import com.mobile.database.app.entities.LOGINHISTORY;

public class LoginHistoryDataProvider extends BaseDataProvider{

	/*public ArrayList<LoginHistoryData> getAllLoginHistory() {
		ArrayList<LoginHistoryData> retVal = new ArrayList<LoginHistoryData>();
		List<LOGINHISTORY> qResult = null;
		
		if (isDaoLoginHistoryExist()) {
			try {
				qResult = getDaoLOGINHISTORY().queryForAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (LOGINHISTORY rowData : qResult) {
					retVal.add(new LoginHistoryData(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	public int updateLoginHistory(LoginHistoryData data) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoLoginHistoryExist()) {
			try {
				result = getDaoLOGINHISTORY().createOrUpdate(data.toRowData());
				retVal = result.getNumLinesChanged();	
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return retVal;		
	}
	
	public void deleteLoginHistoryById(String id) {
		if (isDaoLoginHistoryExist()) {
			DeleteBuilder<LOGINHISTORY, String> deleteBuilder = null;
			try {
				deleteBuilder = getDaoLOGINHISTORY().deleteBuilder();
				deleteBuilder.where().eq("ID", id);
				deleteBuilder.delete();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteLoginHistories(ArrayList<String> arrId) throws Exception{		
		if (isDaoLoginHistoryExist()) {			
			for (int i=0;i<arrId.size();i++){
				deleteLoginHistoryById(arrId.get(i));
			}	
		}			
	}*/
}
