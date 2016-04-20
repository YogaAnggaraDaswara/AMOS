package com.mobile.bo.app.dataprovider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.mobile.bo.app.datatype.Datatype_Appr_Status;
import com.mobile.database.app.entities.APPR_STATUS;

public class Appr_Status extends BaseDataProvider{
	public ArrayList<Datatype_Appr_Status> getAllAppr_Status(String COL_ID) {
		ArrayList<Datatype_Appr_Status> retVal = new ArrayList<Datatype_Appr_Status>();
		List<APPR_STATUS> qResult = null;
		
		if (isDaoATTACHMENT_FILEExist()) {
			try {
				qResult = getDoaAPPR_STATUS().queryBuilder().where().eq("COL_ID", COL_ID)
						  .query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (APPR_STATUS rowData : qResult) {
					
					retVal.add(new Datatype_Appr_Status(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	public int updateData(Datatype_Appr_Status data) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoAPPR_STATUSExist()) {
			try {
				result = getDoaAPPR_STATUS().createOrUpdate(data.toRowData());
				retVal = result.getNumLinesChanged();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return retVal;		
	}
	
}
