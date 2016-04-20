package com.mobile.bo.app.dataprovider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.mobile.bo.app.datatype.Datatype_Appr_Dokument;
import com.mobile.bo.app.datatype.Datatype_Appr_History;
import com.mobile.bo.app.datatype.Datatype_Appr_Mch_Valuation_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_Pb_Valuation_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_Rtb_Cek_Tata_Kota_Int;
import com.mobile.database.app.entities.APPR_HISTORY;
import com.mobile.database.app.entities.APPR_MCH_VALUATION_INT;
import com.mobile.database.app.entities.APPR_PB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_RTB_CEK_TATA_KOTA_INT;

public class Appr_HistoryProvider extends BaseDataProvider{
	public ArrayList<Datatype_Appr_History> getAllAppr_histoy(String COL_ID) {
		ArrayList<Datatype_Appr_History> retVal = new ArrayList<Datatype_Appr_History>();
		List<APPR_HISTORY> qResult = null;
		
		if (isDaoAPPR_HISTORYExist()) {
			try {
				qResult = getDoaAPPR_HISTORY().queryBuilder().where().eq("COL_ID", COL_ID)
						  .query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (APPR_HISTORY rowData : qResult) {
					retVal.add(new Datatype_Appr_History(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	public int updateData(Datatype_Appr_History data) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoAPPR_HISTORYExist()) {
			try {
				result = getDoaAPPR_HISTORY().createOrUpdate(data.toRowData());
				retVal = result.getNumLinesChanged();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return retVal;		
	}
	
}
