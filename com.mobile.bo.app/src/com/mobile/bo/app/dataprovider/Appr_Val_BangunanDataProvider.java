package com.mobile.bo.app.dataprovider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.mobile.bo.app.datatype.Datatype_Appr_Dokument;
import com.mobile.bo.app.datatype.Datatype_Appr_NegativeList;
import com.mobile.bo.app.datatype.Datatype_Appr_valBangunan;
import com.mobile.database.app.entities.APPR_DOKUMENT;
import com.mobile.database.app.entities.APPR_NEGATIVELIST_INT;
import com.mobile.database.app.entities.APPR_VALBANGUNAN;

public class Appr_Val_BangunanDataProvider extends BaseDataProvider{
	public ArrayList<Datatype_Appr_valBangunan> getAllAppr_Bangunan(String COL_ID) {
		ArrayList<Datatype_Appr_valBangunan> retVal = new ArrayList<Datatype_Appr_valBangunan>();
		List<APPR_VALBANGUNAN> qResult = null;
		
		if (isDaoAPPR_VALBANGUNANExist()) {
			try {
				qResult = getDoaAPPR_VALBANGUNAN().queryBuilder().where().eq("COL_ID", COL_ID)
						  .query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (APPR_VALBANGUNAN rowData : qResult) {
					retVal.add(new Datatype_Appr_valBangunan(rowData));
				}
			}
		}
		
		return retVal;
	}
	public Datatype_Appr_valBangunan Datatype_Appr_valBangunan(String ID) {
		Datatype_Appr_valBangunan retVal = new Datatype_Appr_valBangunan();
			List<APPR_VALBANGUNAN> qResult = null;
			
			if (isDaoAPPR_VALBANGUNANExist()) {
				try {
					qResult = getDoaAPPR_VALBANGUNAN().queryBuilder().where().eq("ID", ID)
							  .query();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (qResult != null) {
					for (APPR_VALBANGUNAN rowData : qResult) {
						retVal=(new Datatype_Appr_valBangunan(rowData));
					}
				}
			}
			
			return retVal;
		}
		


	public int updateData(Datatype_Appr_valBangunan data) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoAPPR_VALBANGUNANExist()) {
			try {
				result = getDoaAPPR_VALBANGUNAN().createOrUpdate(data.toRowData());
				retVal = result.getNumLinesChanged();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return retVal;		
	}
	public int getAllAppr_detail_bangunan_by_MaxSeq(String COL_ID) {
		Datatype_Appr_valBangunan retVal = new Datatype_Appr_valBangunan();
		List<APPR_VALBANGUNAN> qResult = null;
		
		if (isDaoAPPR_VALBANGUNANExist()) {
			try {
				qResult = getDoaAPPR_VALBANGUNAN().queryBuilder().orderByRaw("BUILD_SEQ desc").where().eq("COL_ID", COL_ID).query();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (APPR_VALBANGUNAN rowData : qResult) {
					retVal=(new Datatype_Appr_valBangunan(rowData));
					break;
					//retVal.add(new Datatype_Appr_Rtb_Pembanding_Int(rowData));
				}
			}
		}
		
		try{
			return Integer.parseInt(retVal.getBUILD_SEQ().toString()) +1 ;
		}
		catch(Exception ex){
			
			return 1 ;
		}
	}
	
	public void deleteTransaksiById(String id) throws Exception{
		if (isDaoAPPR_VALBANGUNANExist()) {
			DeleteBuilder<APPR_VALBANGUNAN, String> deleteBuilder = null;
			deleteBuilder = getDoaAPPR_VALBANGUNAN().deleteBuilder();
			deleteBuilder.where().eq("ID", id);
			deleteBuilder.delete();
		}
	}
}
