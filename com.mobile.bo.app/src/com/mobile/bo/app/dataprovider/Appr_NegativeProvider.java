package com.mobile.bo.app.dataprovider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.mobile.bo.app.datatype.Datatype_Appr_Dokument;
import com.mobile.bo.app.datatype.Datatype_Appr_History;
import com.mobile.bo.app.datatype.Datatype_Appr_Mch_Valuation_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_NegativeList;
import com.mobile.bo.app.datatype.Datatype_Appr_Pb_Valuation_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_Rtb_Cek_Tata_Kota_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_Rtb_Pembanding_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_imb;
import com.mobile.database.app.entities.APPR_HISTORY;
import com.mobile.database.app.entities.APPR_MCH_VALUATION_INT;
import com.mobile.database.app.entities.APPR_NEGATIVELIST_INT;
import com.mobile.database.app.entities.APPR_PB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_RTB_CEK_TATA_KOTA_INT;
import com.mobile.database.app.entities.APPR_RTB_IMB_INT;
import com.mobile.database.app.entities.APPR_RTB_PEMBANDING_INT;
import com.mobile.database.app.entities.APPR_VALBANGUNAN;

public class Appr_NegativeProvider extends BaseDataProvider{
	public ArrayList<Datatype_Appr_NegativeList> getAllAppr_Negative(String COL_ID ) {
		ArrayList<Datatype_Appr_NegativeList> retVal = new ArrayList<Datatype_Appr_NegativeList>();
		List<APPR_NEGATIVELIST_INT> qResult = null;
		
		if (isDaoAPPR_NEGATIVELIST_INTExist()) {
			try {
				qResult = getDoaAPPR_NEGATIVELIST_INT().queryBuilder().where().eq("COL_ID", COL_ID)
						  .query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (APPR_NEGATIVELIST_INT rowData : qResult) {
					retVal.add(new Datatype_Appr_NegativeList(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	public int updateData(Datatype_Appr_NegativeList data) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoAPPR_NEGATIVELIST_INTExist()) {
			try {
				result = getDoaAPPR_NEGATIVELIST_INT().createOrUpdate(data.toRowData());
				retVal = result.getNumLinesChanged();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return retVal;		
	}
	public int getAllAppr_detail_Negative_by_MaxSeq(String COL_ID) {
		Datatype_Appr_NegativeList retVal = new Datatype_Appr_NegativeList();
		List<APPR_NEGATIVELIST_INT> qResult = null;
		
		if (isDaoAPPR_NEGATIVELIST_INTExist()) {
			try {
				qResult = getDoaAPPR_NEGATIVELIST_INT().queryBuilder().orderByRaw("NEG_SEQ desc").where().eq("COL_ID", COL_ID).query();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (APPR_NEGATIVELIST_INT rowData : qResult) {
					retVal=(new Datatype_Appr_NegativeList(rowData));
					break;
					//retVal.add(new Datatype_Appr_Rtb_Pembanding_Int(rowData));
				}
			}
		}
		
		try{
			return Integer.parseInt(retVal.getNEG_SEQ().toString()) +1 ;
		}
		catch(Exception ex){
			
			return 1 ;
		}
		
		
	}
	
	public void deleteTransaksiById(String id) throws Exception{
		if (isDaoAPPR_NEGATIVELIST_INTExist()) {
			DeleteBuilder<APPR_NEGATIVELIST_INT, String> deleteBuilder = null;
			deleteBuilder = getDoaAPPR_NEGATIVELIST_INT().deleteBuilder();
			deleteBuilder.where().eq("ID", id);
			deleteBuilder.delete();
		}
	}
}
