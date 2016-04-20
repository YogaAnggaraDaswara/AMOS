package com.mobile.bo.app.dataprovider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.mobile.bo.app.datatype.Datatype_Appr_Rtb_Detail_Int;
import com.mobile.database.app.entities.APPR_RTB_DETAIL_INT;

public class Appr_Rtb_DetailProvider extends BaseDataProvider{
	public Datatype_Appr_Rtb_Detail_Int getAllAppr_Rtb_Detail(String COL_ID) {
		Datatype_Appr_Rtb_Detail_Int retVal = new Datatype_Appr_Rtb_Detail_Int();
		List<APPR_RTB_DETAIL_INT> qResult = null;
		
		if (isDaoAPPR_RTB_DETAIL_INTExist()) {
			try {
				qResult = getDoaAPPR_RTB_DETAIL_INT().queryBuilder().where().eq("COL_ID", COL_ID).query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (APPR_RTB_DETAIL_INT rowData : qResult) {
					retVal=(new Datatype_Appr_Rtb_Detail_Int(rowData));
					
					//retVal.add(new Datatype_Appr_Rtb_Valuation_Int(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	public int updateData(Datatype_Appr_Rtb_Detail_Int data) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoAPPR_RTB_DETAIL_INTExist()) {
			try {
				result = getDoaAPPR_RTB_DETAIL_INT().createOrUpdate(data.toRowData());
				retVal = result.getNumLinesChanged();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return retVal;		
	}
	
}
