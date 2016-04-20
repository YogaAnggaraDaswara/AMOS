package com.mobile.bo.app.dataprovider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.mobile.bo.app.datatype.DataType_Amos_Email;
import com.mobile.bo.app.datatype.Datatype_Appr_Rtb_Cek_Tata_Kota_Int;
import com.mobile.bo.app.datatype.Datatype_attachment;
import com.mobile.database.app.entities.AMOS_EMAIL;
import com.mobile.database.app.entities.APPR_RTB_CEK_TATA_KOTA_INT;
import com.mobile.database.app.entities.ATTACHMENT_FILE;

public class Appr_Email extends BaseDataProvider{
	public ArrayList<DataType_Amos_Email> getAllEmail() {
		ArrayList<DataType_Amos_Email> retVal = new ArrayList<DataType_Amos_Email>();
		List<AMOS_EMAIL> qResult = null;
		
		if (isDaoATTACHMENT_FILEExist()) {
			try {
				qResult = getDaoAMOS_EMAIL().queryBuilder().where().eq("ISALREADYSUBMIT", "1")
						  .query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (AMOS_EMAIL rowData : qResult) {
					
					retVal.add(new DataType_Amos_Email(rowData));
				}
			}
		}
		
		return retVal;
	}
	public int updateData(DataType_Amos_Email data) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoAMOS_EMAILExist()) {
			try {
				result = getDaoAMOS_EMAIL().createOrUpdate(data.toRowData());
				retVal = result.getNumLinesChanged();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return retVal;		
	}
	public void deleteEmail(String id) throws Exception{
		if (isDaoAMOS_EMAILExist()) {
			DeleteBuilder<AMOS_EMAIL, String> deleteBuilder = null;
			deleteBuilder = getDaoAMOS_EMAIL().deleteBuilder();
			deleteBuilder.where().eq("ID", id);
			deleteBuilder.delete();
		}
	}
}
