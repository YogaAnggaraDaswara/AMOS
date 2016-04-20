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
import com.mobile.bo.app.datatype.Datatype_Appr_Rtb_Pembanding_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_Sertifikat;
import com.mobile.bo.app.datatype.Datatype_Appr_imb;
import com.mobile.database.app.entities.APPR_HISTORY;
import com.mobile.database.app.entities.APPR_MCH_VALUATION_INT;
import com.mobile.database.app.entities.APPR_PB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_RTB_CEK_TATA_KOTA_INT;
import com.mobile.database.app.entities.APPR_RTB_IMB_INT;
import com.mobile.database.app.entities.APPR_RTB_PEMBANDING_INT;
import com.mobile.database.app.entities.APPR_SERTIFIKAT;

public class Appr_SertifikatProvider extends BaseDataProvider{
	public ArrayList<Datatype_Appr_Sertifikat> getAllAppr_Sertifikat(String COL_ID) {
		ArrayList<Datatype_Appr_Sertifikat> retVal = new ArrayList<Datatype_Appr_Sertifikat>();
		List<APPR_SERTIFIKAT> qResult = null;
		
		if (isDaoAPPR_SERTIFIKATExist()) {
			try {
				qResult = getDoaAPPR_SERTIFIKAT().queryBuilder().where().eq("COL_ID", COL_ID)
						  .query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (APPR_SERTIFIKAT rowData : qResult) {
					retVal.add(new Datatype_Appr_Sertifikat(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	public int updateData(Datatype_Appr_Sertifikat data) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoAPPR_SERTIFIKATExist()) {
			try {
				result = getDoaAPPR_SERTIFIKAT().createOrUpdate(data.toRowData());
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
}
