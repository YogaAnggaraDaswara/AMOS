package com.mobile.bo.app.dataprovider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.mobile.bo.app.datatype.Datatype_Appr_Dokument;
import com.mobile.bo.app.datatype.Datatype_Appr_History;
import com.mobile.bo.app.datatype.Datatype_Appr_Mch_Valuation_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_Pb_Valuation_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_Rtb_Cek_Tata_Kota_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_Rtb_Pembanding_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_imb;
import com.mobile.database.app.entities.APPR_HISTORY;
import com.mobile.database.app.entities.APPR_MCH_VALUATION_INT;
import com.mobile.database.app.entities.APPR_PB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_RTB_CEK_TATA_KOTA_INT;
import com.mobile.database.app.entities.APPR_RTB_IMB_INT;
import com.mobile.database.app.entities.APPR_RTB_PEMBANDING_INT;

public class Appr_ImbProvider extends BaseDataProvider{
	public ArrayList<Datatype_Appr_imb> getAllAppr_imb(String COL_ID) {
		ArrayList<Datatype_Appr_imb> retVal = new ArrayList<Datatype_Appr_imb>();
		List<APPR_RTB_IMB_INT> qResult = null;
		
		if (isDaoAPPR_RTB_IMB_INTExist()) {
			try {
				qResult = getDoaAPPR_RTB_IMB_INT().queryBuilder().where().eq("COL_ID", COL_ID)
						  .query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (APPR_RTB_IMB_INT rowData : qResult) {
					retVal.add(new Datatype_Appr_imb(rowData));
				}
			}
		}
		
		return retVal;
	}
	public ArrayList<Datatype_Appr_imb> getAllAppr_imb_by_id(String ID) {
		ArrayList<Datatype_Appr_imb> retVal = new ArrayList<Datatype_Appr_imb>();
		List<APPR_RTB_IMB_INT> qResult = null;
		
		if (isDaoAPPR_RTB_IMB_INTExist()) {
			try {
				qResult = getDoaAPPR_RTB_IMB_INT().queryBuilder().where().eq("ID", ID)
						  .query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (APPR_RTB_IMB_INT rowData : qResult) {
					retVal.add(new Datatype_Appr_imb(rowData));
				}
			}
		}
		
		return retVal;
	}
	public int updateData(Datatype_Appr_imb data) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoAPPR_RTB_IMB_INTExist()) {
			try {
				result = getDoaAPPR_RTB_IMB_INT().createOrUpdate(data.toRowData());
				retVal = result.getNumLinesChanged();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return retVal;		
	}
	public int getAllAppr_detail_imb_by_MaxSeq(String COL_ID) {
		Datatype_Appr_imb retVal = new Datatype_Appr_imb();
		List<APPR_RTB_IMB_INT> qResult = null;
		
		if (isDaoAPPR_RTB_IMB_INTExist()) {
			try {
				qResult = getDoaAPPR_RTB_IMB_INT().queryBuilder().orderByRaw("IMB_SEQ desc").where().eq("COL_ID", COL_ID).query();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (APPR_RTB_IMB_INT rowData : qResult) {
					retVal=(new Datatype_Appr_imb(rowData));
					break;
					//retVal.add(new Datatype_Appr_Rtb_Pembanding_Int(rowData));
				}
			}
		}
		
		try{
			return Integer.parseInt(retVal.getIMB_SEQ().toString()) +1 ;
		}
		catch(Exception ex){
			
			return 1 ;
		}
		
		
	}
	 public void deleteTransaksiById(String id) throws Exception{
		if (isDaoAPPR_RTB_IMB_INTExist()) {
		DeleteBuilder<APPR_RTB_IMB_INT, String> deleteBuilder = null;
		deleteBuilder = getDoaAPPR_RTB_IMB_INT().deleteBuilder();
		deleteBuilder.where().eq("ID", id);
		deleteBuilder.delete();
		}
	 }
}
