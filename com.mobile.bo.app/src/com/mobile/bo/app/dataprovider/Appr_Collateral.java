package com.mobile.bo.app.dataprovider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.mobile.bo.app.datatype.Datatype_Appr_Collateral;
import com.mobile.database.app.entities.APPR_COLLATERAL;

public class Appr_Collateral extends BaseDataProvider{
	public Datatype_Appr_Collateral getAllAppr_Collateral (String COL_ID) {
		Datatype_Appr_Collateral retVal = new Datatype_Appr_Collateral();
		List<APPR_COLLATERAL> qResult = null;
		
		if (isDaoAPPR_COLLATERALExist()) {
			try {
				qResult = getDoaAPPR_COLLATERAL().queryBuilder().where().eq("COL_ID", COL_ID)
						  .query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (APPR_COLLATERAL rowData : qResult) {
					retVal=(new Datatype_Appr_Collateral(rowData));
					
					//retVal.add(new Datatype_Appr_Rtb_Valuation_Int(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	public int updateData(Datatype_Appr_Collateral data) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoAPPR_COLLATERALExist()) {
			try {
				result = getDoaAPPR_COLLATERAL().createOrUpdate(data.toRowData());
				retVal = result.getNumLinesChanged();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return retVal;		
	}
	
}
