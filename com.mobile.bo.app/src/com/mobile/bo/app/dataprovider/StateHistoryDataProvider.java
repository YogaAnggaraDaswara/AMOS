package com.mobile.bo.app.dataprovider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.mobile.bo.app.datatype.StateHistoryData;
import com.mobile.database.app.entities.STATEHISTORY;

public class StateHistoryDataProvider extends BaseDataProvider{
	
	/*public ArrayList<StateHistoryData> getAllStateHistory() {
		ArrayList<StateHistoryData> retVal = new ArrayList<StateHistoryData>();
		List<STATEHISTORY> qResult = null;
		if (isDaoSTATEHISTORYExist()) {
			try {
				qResult = getDaoSTATEHISTORY().queryForAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (STATEHISTORY rowData : qResult) {
					retVal.add(new StateHistoryData(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	public void deleteStateHistoryById(String id) {
		if (isDaoSTATEHISTORYExist()) {
			DeleteBuilder<STATEHISTORY, String> deleteBuilder = null;
			try {
				deleteBuilder = getDaoSTATEHISTORY().deleteBuilder();
				deleteBuilder.where().eq("ID", id);
				deleteBuilder.delete();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteStateHistories(ArrayList<String> arrId) throws Exception{		
		if (isDaoSTATEHISTORYExist()) {			
			for (int i=0;i<arrId.size();i++){
				deleteStateHistoryById(arrId.get(i));
			}	
		}			
	}*/
}
