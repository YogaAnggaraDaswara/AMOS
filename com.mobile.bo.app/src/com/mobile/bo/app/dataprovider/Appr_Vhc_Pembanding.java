package com.mobile.bo.app.dataprovider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.mobile.bo.app.datatype.Datatype_Appr_Vhc_Pembanding_Int;
import com.mobile.database.app.entities.APPR_RTB_IMB_INT;
import com.mobile.database.app.entities.APPR_VHC_PEMBANDING_INT;

public class Appr_Vhc_Pembanding extends BaseDataProvider{
	public ArrayList<Datatype_Appr_Vhc_Pembanding_Int> getAllAppr_Vhc_Pembanding(String COL_ID) {
		ArrayList<Datatype_Appr_Vhc_Pembanding_Int> retVal = new ArrayList<Datatype_Appr_Vhc_Pembanding_Int>();
		List<APPR_VHC_PEMBANDING_INT> qResult = null;
		
		if (isDaoAPPR_VHC_PEMBANDING_INTExist()) {
			try {
				qResult = getAPPR_VHC_PEMBANDING_INT().queryBuilder().where().eq("COL_ID", COL_ID).query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (APPR_VHC_PEMBANDING_INT rowData : qResult) {
					//retVal=(new Datatype_Appr_Vhc_Pembanding_Int(rowData));
					
					retVal.add(new Datatype_Appr_Vhc_Pembanding_Int(rowData));
				}
			}
		}
		
		return retVal;
	}
	public Datatype_Appr_Vhc_Pembanding_Int getAllAppr_Vhc_Pembanding_by_seq(String ID) {
		Datatype_Appr_Vhc_Pembanding_Int retVal = new Datatype_Appr_Vhc_Pembanding_Int();
		List<APPR_VHC_PEMBANDING_INT> qResult = null;
		
		if (isDaoAPPR_VHC_PEMBANDING_INTExist()) {
			try {
				qResult = getAPPR_VHC_PEMBANDING_INT().queryBuilder().where().eq("ID", ID).and().query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (APPR_VHC_PEMBANDING_INT rowData : qResult) {
					retVal=(new Datatype_Appr_Vhc_Pembanding_Int(rowData));
					
					//retVal.add(new Datatype_Appr_Vhc_Valuation_Int(rowData));
				}
			}
		}
		
		return retVal;
	}
	public int getAllAppr_Vhc_Pembanding_by_MaxSeq(String COL_ID) {
		Datatype_Appr_Vhc_Pembanding_Int retVal = new Datatype_Appr_Vhc_Pembanding_Int();
		List<APPR_VHC_PEMBANDING_INT> qResult = null;
		
		if (isDaoAPPR_VHC_PEMBANDING_INTExist()) {
			try {
				qResult = getAPPR_VHC_PEMBANDING_INT().queryBuilder().orderByRaw("SEQ desc").where().eq("COL_ID", COL_ID).query();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (APPR_VHC_PEMBANDING_INT rowData : qResult) {
					retVal=(new Datatype_Appr_Vhc_Pembanding_Int(rowData));
					break;
					//retVal.add(new Datatype_Appr_Vhc_Pembanding_Int(rowData));
				}
			}
		}
		
		try{
			return Integer.parseInt(retVal.getSEQ().toString()) +1 ;
		}
		catch(Exception ex){
			
			return 1 ;
		}
		
		
	}
	public int updateData(Datatype_Appr_Vhc_Pembanding_Int data) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoAPPR_VHC_PEMBANDING_INTExist()) {
			try {
				result = getAPPR_VHC_PEMBANDING_INT().createOrUpdate(data.toRowData());
				retVal = result.getNumLinesChanged();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return retVal;		
	}
	
	 public void deleteTransaksiById(String id) throws Exception{
			if (isDaoAPPR_VHC_PEMBANDING_INTExist()) {
			DeleteBuilder<APPR_VHC_PEMBANDING_INT, String> deleteBuilder = null;
			deleteBuilder = getAPPR_VHC_PEMBANDING_INT().deleteBuilder();
			deleteBuilder.where().eq("ID", id);
			deleteBuilder.delete();
			}
		 }
}
