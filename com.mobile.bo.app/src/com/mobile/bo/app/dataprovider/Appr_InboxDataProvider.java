package com.mobile.bo.app.dataprovider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.mobile.bo.app.datatype.Datatype_Appr_Inbox;
import com.mobile.bo.app.datatype.Datatype_Appr_Rtb_Data_Int;
import com.mobile.database.app.entities.APPR_INBOXS;
import com.mobile.database.app.entities.ATTACHMENT;

public class Appr_InboxDataProvider extends BaseDataProvider{
	public ArrayList<Datatype_Appr_Inbox> getAllAppr_InboxbyKey(String AP_REGNO) {
		ArrayList<Datatype_Appr_Inbox> retVal = new ArrayList<Datatype_Appr_Inbox>();
		List<APPR_INBOXS> qResult = null;
		
		if (isDaoAPPR_INBOXExist()) {
			try {
				qResult = getdoaAPPR_INBOXS().queryBuilder().where().eq("AP_REGNO", AP_REGNO).query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (APPR_INBOXS rowData : qResult) {
					
					retVal.add(new Datatype_Appr_Inbox(rowData));
				}
			}
		}
		
		return retVal;
	}
	public ArrayList<Datatype_Appr_Inbox> getAllAppr_InboxbyCol_id(String COL_ID) {
		ArrayList<Datatype_Appr_Inbox> retVal = new ArrayList<Datatype_Appr_Inbox>();
		List<APPR_INBOXS> qResult = null;
		
		if (isDaoAPPR_INBOXExist()) {
			try {
				qResult = getdoaAPPR_INBOXS().queryBuilder().where().eq("ALT_ID", COL_ID).query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (APPR_INBOXS rowData : qResult) {
					
					retVal.add(new Datatype_Appr_Inbox(rowData));
				}
			}
		}
		
		return retVal;
	}
	public ArrayList<Datatype_Appr_Inbox> getAllAppr_Inbox() {
		ArrayList<Datatype_Appr_Inbox> retVal = new ArrayList<Datatype_Appr_Inbox>();
		List<APPR_INBOXS> qResult = null;
		
		if (isDaoAPPR_INBOXExist()) {
			try {
				qResult = getdoaAPPR_INBOXS().queryForAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (APPR_INBOXS rowData : qResult) {
					
					retVal.add(new Datatype_Appr_Inbox(rowData));
				}
			}
		}
		
		return retVal;
	}
	public Datatype_Appr_Inbox getAllAppr_Inboxbyid(String COL_ID) {
		Datatype_Appr_Inbox retVal = new Datatype_Appr_Inbox();
		List<APPR_INBOXS> qResult = null;
		
		if (isDaoAPPR_INBOXExist()) {
			try {
				qResult = getdoaAPPR_INBOXS().queryBuilder().where().eq("ALT_ID", COL_ID).query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (APPR_INBOXS rowData : qResult) {
					retVal=(new Datatype_Appr_Inbox(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	public int updateData(Datatype_Appr_Inbox data) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoAPPR_INBOXExist()) {
			try {
				result = getdoaAPPR_INBOXS().createOrUpdate(data.toRowData());
				retVal = result.getNumLinesChanged();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return retVal;		
	}
	public void deleteallrecord() throws Exception{
		if (isDaoAPPR_INBOXExist()) {
			DeleteBuilder<APPR_INBOXS, String> deleteBuilder = null;
			deleteBuilder = getdoaAPPR_INBOXS().deleteBuilder();
			deleteBuilder.where().eq("APP_STATUS", "0");
			deleteBuilder.delete();
		}
	}
}
