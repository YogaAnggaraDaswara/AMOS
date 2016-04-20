package com.mobile.bo.app.dataprovider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.mobile.bo.app.datatype.Datatype_Appr_Vhc_Valuation_Int;
import com.mobile.database.app.entities.APPR_VHC_VALUATION_INT;

public class Appr_Vhc_ValuationDataProvider extends BaseDataProvider{
	public Datatype_Appr_Vhc_Valuation_Int getAllAppr_Vhc_Valuation_Int(String COL_ID) {
		Datatype_Appr_Vhc_Valuation_Int retVal = new Datatype_Appr_Vhc_Valuation_Int();
		List<APPR_VHC_VALUATION_INT> qResult = null;
		
		if (isDaoAPPR_MCH_VALUATION_INTExist()) {
			try {
				qResult = getDoaAPPR_VHC_VALUATION_INT().queryBuilder().where().eq("COL_ID", COL_ID).query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (APPR_VHC_VALUATION_INT rowData : qResult) {
					retVal=(new Datatype_Appr_Vhc_Valuation_Int(rowData));
					
					//retVal.add(new Datatype_Appr_Rtb_Valuation_Int(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	public int updateData(Datatype_Appr_Vhc_Valuation_Int data) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoAPPR_MCH_VALUATION_INTExist()) {
			try {
				result = getDoaAPPR_VHC_VALUATION_INT().createOrUpdate(data.toRowData());
				retVal = result.getNumLinesChanged();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return retVal;		
	}
	
}
