package com.mobile.bo.app.dataprovider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.mobile.bo.app.datatype.Datatype_Appr_Vch_Data_Int;
import com.mobile.database.app.entities.APPR_VHC_DATA_INT;

public class Appr_Vhc_DataDataProvider extends BaseDataProvider{
	public Datatype_Appr_Vch_Data_Int getAllAppr_Vhc_Data_Int(String COL_ID) {
		Datatype_Appr_Vch_Data_Int retVal = new Datatype_Appr_Vch_Data_Int();
		List<APPR_VHC_DATA_INT> qResult = null;
		
		if (isDaoAPPR_VHC_DATA_INTExist()) {
			try {
				qResult = getDoaAPPR_VHC_DATA_INT().queryBuilder().where().eq("COL_ID", COL_ID).query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (APPR_VHC_DATA_INT rowData : qResult) {
					retVal=(new Datatype_Appr_Vch_Data_Int(rowData));
					
					//retVal.add(new Datatype_Appr_Rtb_Valuation_Int(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	public int updateData(Datatype_Appr_Vch_Data_Int data) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoAPPR_VHC_DATA_INTExist()) {
			try {
				result = getDoaAPPR_VHC_DATA_INT().createOrUpdate(data.toRowData());
				retVal = result.getNumLinesChanged();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return retVal;		
	}
	
}
