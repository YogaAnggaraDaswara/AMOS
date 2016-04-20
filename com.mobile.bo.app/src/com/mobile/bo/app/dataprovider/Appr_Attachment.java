package com.mobile.bo.app.dataprovider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.mobile.bo.app.datatype.Datatype_Appr_Rtb_Cek_Tata_Kota_Int;
import com.mobile.bo.app.datatype.Datatype_attachment;
import com.mobile.database.app.entities.APPR_RTB_CEK_TATA_KOTA_INT;
import com.mobile.database.app.entities.ATTACHMENT_FILE;

public class Appr_Attachment extends BaseDataProvider{
	public ArrayList<Datatype_attachment> getAllAppr_Attachment_Int(String COL_ID) {
		ArrayList<Datatype_attachment> retVal = new ArrayList<Datatype_attachment>();
		List<ATTACHMENT_FILE> qResult = null;
		
		if (isDaoATTACHMENT_FILEExist()) {
			try {
				qResult = getDaoATTACHMENT_FILE().queryBuilder().where().eq("COL_ID", COL_ID)
						  .query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (ATTACHMENT_FILE rowData : qResult) {
					
					retVal.add(new Datatype_attachment(rowData));
				}
			}
		}
		
		return retVal;
	}
	public ArrayList<Datatype_attachment> getAllAppr_Attachment() {
		ArrayList<Datatype_attachment> retVal = new ArrayList<Datatype_attachment>();
		List<ATTACHMENT_FILE> qResult = null;
		
		if (isDaoATTACHMENT_FILEExist()) {
			try {
				qResult = getDaoATTACHMENT_FILE().queryBuilder().where().eq("ISSTATUS", "0")
						  .query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (ATTACHMENT_FILE rowData : qResult) {
					
					retVal.add(new Datatype_attachment(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	public int updateData(Datatype_attachment data) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoATTACHMENT_FILEExist()) {
			try {
				result = getDaoATTACHMENT_FILE().createOrUpdate(data.toRowData());
				retVal = result.getNumLinesChanged();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return retVal;		
	}
	
}
