package com.mobile.bo.app.dataprovider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.mobile.bo.app.datatype.Datatype_Appr_NegativeList;
import com.mobile.bo.app.datatype.Datatype_Appr_Pb_sampling_bangunan;
import com.mobile.bo.app.datatype.Datatype_Appr_Rtb_Cek_Tata_Kota_Int;
import com.mobile.database.app.entities.APPR_NEGATIVELIST_INT;
import com.mobile.database.app.entities.APPR_PB_SAMPLING_BANGUNAN_INT;
import com.mobile.database.app.entities.APPR_RTB_CEK_TATA_KOTA_INT;

public class Appr_Pb_SamplingBangunan_Provider extends BaseDataProvider{
	public ArrayList<Datatype_Appr_Pb_sampling_bangunan> getAllAppr_Pb_sampling(String COL_ID) {
		ArrayList<Datatype_Appr_Pb_sampling_bangunan> retVal = new ArrayList<Datatype_Appr_Pb_sampling_bangunan>();
		List<APPR_PB_SAMPLING_BANGUNAN_INT> qResult = null;
		
		if (isDaoAPPR_PB_SAMPLING_BANGUNAN_INTExist()) {
			try {
				qResult = getDoaAPPR_PB_SAMPLING_BANGUNAN_INT().queryBuilder().where().eq("COL_ID", COL_ID)
						  .query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (APPR_PB_SAMPLING_BANGUNAN_INT rowData : qResult) {
					retVal.add(new Datatype_Appr_Pb_sampling_bangunan(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	public int updateData(Datatype_Appr_Pb_sampling_bangunan data) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoAPPR_PB_SAMPLING_BANGUNAN_INTExist()) {
			try {
				result = getDoaAPPR_PB_SAMPLING_BANGUNAN_INT().createOrUpdate(data.toRowData());
				retVal = result.getNumLinesChanged();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return retVal;		
	}
	public int getAllgetAllAppr_Pb_sampling_by_MaxSeq(String COL_ID) {
		Datatype_Appr_Pb_sampling_bangunan retVal = new Datatype_Appr_Pb_sampling_bangunan();
		List<APPR_PB_SAMPLING_BANGUNAN_INT> qResult = null;
		
		if (isDaoAPPR_PB_SAMPLING_BANGUNAN_INTExist()) {
			try {
				qResult = getDoaAPPR_PB_SAMPLING_BANGUNAN_INT().queryBuilder().orderByRaw("SEQ desc").where().eq("COL_ID", COL_ID).query();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (APPR_PB_SAMPLING_BANGUNAN_INT rowData : qResult) {
					retVal=(new Datatype_Appr_Pb_sampling_bangunan(rowData));
					break;
					//retVal.add(new Datatype_Appr_Rtb_Pembanding_Int(rowData));
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
	  public void deleteTransaksiById(String id) throws Exception{
			if (isDaoAPPR_PB_SAMPLING_BANGUNAN_INTExist()) {
				DeleteBuilder<APPR_PB_SAMPLING_BANGUNAN_INT, String> deleteBuilder = null;
				deleteBuilder = getDoaAPPR_PB_SAMPLING_BANGUNAN_INT().deleteBuilder();
				deleteBuilder.where().eq("ID", id);
				deleteBuilder.delete();
			}
		}
}
