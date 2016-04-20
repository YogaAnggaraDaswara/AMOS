package com.mobile.bo.app.dataprovider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.mobile.bo.app.datatype.Datatype_Appr_Progress_Bangunan_Int;
import com.mobile.database.app.entities.APPR_RTB_PROGRESS_BANGUNAN_INT;

public class Appr_Rtb_Progress_BangunanDataProvider extends BaseDataProvider{
	public Datatype_Appr_Progress_Bangunan_Int getAllAppr_Rtb_Progress_Int(String COL_ID) {
		Datatype_Appr_Progress_Bangunan_Int retVal = new Datatype_Appr_Progress_Bangunan_Int();
		List<APPR_RTB_PROGRESS_BANGUNAN_INT> qResult = null;
		
		if (isDaoAPPR_RTB_PROGRESS_BANGUNAN_INTExist()) {
			try {
				qResult = getDoaAPPR_RTB_PROGRESS_BANGUNAN_INT().queryBuilder().where().eq("COL_ID", COL_ID).query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (APPR_RTB_PROGRESS_BANGUNAN_INT rowData : qResult) {
					retVal=(new Datatype_Appr_Progress_Bangunan_Int(rowData));
					
					//retVal.add(new Datatype_Appr_Rtb_Valuation_Int(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	

	public int updateData(Datatype_Appr_Progress_Bangunan_Int data) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoAPPR_RTB_PROGRESS_BANGUNAN_INTExist()) {
			try {
				result = getDoaAPPR_RTB_PROGRESS_BANGUNAN_INT().createOrUpdate(data.toRowData());
				retVal = result.getNumLinesChanged();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return retVal;		
	}
	
}
