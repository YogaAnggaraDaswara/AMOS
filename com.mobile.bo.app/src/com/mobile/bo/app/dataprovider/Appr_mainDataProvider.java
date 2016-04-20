package com.mobile.bo.app.dataprovider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.mobile.bo.app.datatype.Datatype_Apprs_Main;
import com.mobile.database.app.entities.APPR_MAIN;

public class Appr_mainDataProvider extends BaseDataProvider{
	public Datatype_Apprs_Main getAllAppr_Main(String COL_ID) {
		Datatype_Apprs_Main retVal = new Datatype_Apprs_Main();
		List<APPR_MAIN> qResult = null;
		
		if (isDaoAPPR_MAINExist()) {
			try {
				qResult = getDoaAPPR_MAIN().queryBuilder().where().eq("COL_ID", COL_ID)
						  .query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (APPR_MAIN rowData : qResult) {
					retVal=(new Datatype_Apprs_Main(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	public int updateBlackbox(Datatype_Apprs_Main data) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoAPPR_MAINExist()) {
			try {
				result = getDoaAPPR_MAIN().createOrUpdate(data.toRowData());
				retVal = result.getNumLinesChanged();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return retVal;		
	}
	
}
