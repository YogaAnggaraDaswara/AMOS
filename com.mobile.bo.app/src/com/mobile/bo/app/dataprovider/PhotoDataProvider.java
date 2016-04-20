package com.mobile.bo.app.dataprovider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.mobile.bo.app.datatype.Datatype_Appr_imb;
import com.mobile.bo.app.datatype.PhotoData;
import com.mobile.database.app.entities.APPR_RTB_IMB_INT;
import com.mobile.database.app.entities.ATTACHMENT;

public class PhotoDataProvider extends BaseDataProvider{
	public int get_MaxSeq(String COL_ID) {
		PhotoData retVal = new PhotoData();
		List<ATTACHMENT> qResult = null;
		
		if (isDaoATTACHMENTExist()) {
			try {
				qResult = getDaoATTACHMENT().queryBuilder().orderByRaw("ATTACH_SEQ desc").where().eq("AP_REGNO", COL_ID).query();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (ATTACHMENT rowData : qResult) {
					retVal=(new PhotoData(rowData));
					break;
					//retVal.add(new Datatype_Appr_Rtb_Pembanding_Int(rowData));
				}
			}
		}
		
		try{
			return Integer.parseInt(retVal.getATTACH_SEQ().toString()) +1 ;
		}
		catch(Exception ex){
			
			return 1 ;
		}
		
		
	}
	
	public ArrayList<PhotoData> getATTACHMENTByProspek(String AP_REGNO) {
		ArrayList<PhotoData> retVal = new ArrayList<PhotoData>();
		List<ATTACHMENT> qResult = null;
		
		if (isDaoATTACHMENTExist()) {
			try {
				qResult = getDaoATTACHMENT().queryBuilder().
						  where().eq("AP_REGNO", AP_REGNO).
						  query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (ATTACHMENT rowData : qResult) {
					retVal.add(new PhotoData(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	public ArrayList<PhotoData> getATTACHMENTByUploader(String AP_REGNO) {
		ArrayList<PhotoData> retVal = new ArrayList<PhotoData>();
		List<ATTACHMENT> qResult = null;
		
		if (isDaoATTACHMENTExist()) {
			try {
				qResult = getDaoATTACHMENT().queryBuilder().
						  where().eq("AP_REGNO", AP_REGNO).and().eq("ISALREADYUPLOADEDTOSERVER", "1").
						  query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (ATTACHMENT rowData : qResult) {
					retVal.add(new PhotoData(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	public ArrayList<PhotoData> getATTACHMENTByDownloader(String AP_REGNO) {
		ArrayList<PhotoData> retVal = new ArrayList<PhotoData>();
		List<ATTACHMENT> qResult = null;
		
		if (isDaoATTACHMENTExist()) {
			try {
				qResult = getDaoATTACHMENT().queryBuilder().
						  where().eq("AP_REGNO", AP_REGNO).and().eq("ISALREADYDOWNLOD", "1").
						  query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (ATTACHMENT rowData : qResult) {
					retVal.add(new PhotoData(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	public ArrayList<PhotoData> getATTACHMENTByProspekAll() {
		ArrayList<PhotoData> retVal = new ArrayList<PhotoData>();
		List<ATTACHMENT> qResult = null;
		
		if (isDaoATTACHMENTExist()) {
			try {
				qResult = getDaoATTACHMENT().queryBuilder().
						  where().eq("ISALREADYUPLOADEDTOSERVER", "0").
						  query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (ATTACHMENT rowData : qResult) {
					retVal.add(new PhotoData(rowData));
				}
			}
		}
		
		return retVal;
	}
	public ArrayList<PhotoData> getUnUploadedATTACHMENTByProspek(String prospeId) {
		ArrayList<PhotoData> retVal = new ArrayList<PhotoData>();
		List<ATTACHMENT> qResult = null;
		
		if (isDaoATTACHMENTExist()) {
			try {
				qResult = getDaoATTACHMENT().queryBuilder().
						  where().eq("PROSPEKIDLOCAL", prospeId).and().
						  eq("ISALREADYUPLOADEDTOSERVER", "0").
//						  and().
//						  eq("ISPENDINGDELETED", "0").
						  query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (ATTACHMENT rowData : qResult) {
					retVal.add(new PhotoData(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	
	public ArrayList<String> getUnUploadedATTACHMENTNamesByProspek(String prospeId) {
		ArrayList<String> retVal = new ArrayList<String>();
		List<ATTACHMENT> qResult = null;
		
		if (isDaoATTACHMENTExist()) {
			try {
				qResult = getDaoATTACHMENT().queryBuilder().
						  where().eq("PROSPEKIDLOCAL", prospeId).and().
						  eq("ISALREADYUPLOADEDTOSERVER", "0").
						  query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (ATTACHMENT rowData : qResult) {
					retVal.add(new PhotoData(rowData).getFILENAME());
				}
			}
		}
		
		return retVal;
	}
	

	public ArrayList<PhotoData> getPendingUploadDeletedATTACHMENTs() {
		ArrayList<PhotoData> retVal = new ArrayList<PhotoData>();
		List<ATTACHMENT> qResult = null;
		
		if (isDaoATTACHMENTExist()) {
			try {
				qResult = getDaoATTACHMENT().queryBuilder().
						  where().
//						  eq("ISPENDINGDELETED", "1").and().
						  eq("ISALREADYUPLOADEDTOSERVER", "1").
						  query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (ATTACHMENT rowData : qResult) {
					retVal.add(new PhotoData(rowData));
				}
			}
		}
		
		return retVal;
	}
	public ArrayList<PhotoData> getPendingDownloadATTACHMENTs() {
		ArrayList<PhotoData> retVal = new ArrayList<PhotoData>();
		List<ATTACHMENT> qResult = null;
		
		if (isDaoATTACHMENTExist()) {
			try {
				qResult = getDaoATTACHMENT().queryBuilder().
						  where().eq("ISALREADYDOWNLOD", "0").
						  query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (ATTACHMENT rowData : qResult) {
					retVal.add(new PhotoData(rowData));
				}
			}
		}
		
		return retVal;
	}
	public ArrayList<PhotoData> getPendingUploadedATTACHMENTs() {
		ArrayList<PhotoData> retVal = new ArrayList<PhotoData>();
		List<ATTACHMENT> qResult = null;
		
		if (isDaoATTACHMENTExist()) {
			try {
				qResult = getDaoATTACHMENT().queryBuilder().
						  where().eq("ISPENDINGUPLOADED", "1").and().
						  eq("ISPENDINGDELETED", "0").
						  query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (ATTACHMENT rowData : qResult) {
					retVal.add(new PhotoData(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	public PhotoData getATTACHMENTDetail(String id) {
		PhotoData retData = null;
		ATTACHMENT qData = null;
		if (isDaoATTACHMENTExist()) {
			try {
				qData = getDaoATTACHMENT().queryForId(id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qData != null) {
				retData = new PhotoData(qData);
			}
		}
		return retData;
	}
	
	public PhotoData getATTACHMENTByFileName(String filename) {
		List<ATTACHMENT> qResult = null;
		PhotoData retData = null;
		
		if (isDaoATTACHMENTExist()) {
			try {
				qResult = getDaoATTACHMENT().queryBuilder().
						  where().eq("FILENAME", filename).
						  query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				if (qResult.size() > 0){
					retData = new PhotoData(qResult.get(0));
				}
			}
		}
		return retData;
	}
	
	public int updateATTACHMENT(PhotoData data) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoATTACHMENTExist()) {
			try {
				result = getDaoATTACHMENT().createOrUpdate(data.toRowData());
				retVal = result.getNumLinesChanged();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return retVal;		
	}
	
	public void deleteATTACHMENTById(String id) throws Exception{
		if (isDaoATTACHMENTExist()) {
			DeleteBuilder<ATTACHMENT, String> deleteBuilder = null;
			deleteBuilder = getDaoATTACHMENT().deleteBuilder();
			deleteBuilder.where().eq("ID", id);
			deleteBuilder.delete();
		}
	}
	
	public void deleteATTACHMENTByNmrDanCodeAll(String nOAPK, String cODE) throws Exception{
		if (isDaoATTACHMENTExist()) {
			DeleteBuilder<ATTACHMENT, String> deleteBuilder = null;
			deleteBuilder = getDaoATTACHMENT().deleteBuilder();
			deleteBuilder.where().eq("AP_REGNO", nOAPK).and().eq("ATTACH_ID", cODE);
			deleteBuilder.delete();
		}
	}
	
	public void deleteATTACHMENTByProspek(String prospekId) throws Exception{
		if (isDaoATTACHMENTExist()) {
			DeleteBuilder<ATTACHMENT, String> deleteBuilder = null;
			deleteBuilder = getDaoATTACHMENT().deleteBuilder();
			deleteBuilder.where().eq("PROSPEKIDLOCAL", prospekId);
			deleteBuilder.delete();
		}
	}
	
	public void deleteATTACHMENTByProspekid(String prospekId) throws Exception{
		if (isDaoATTACHMENTExist()) {
			DeleteBuilder<ATTACHMENT, String> deleteBuilder = null;
			deleteBuilder = getDaoATTACHMENT().deleteBuilder();
			deleteBuilder.where().eq("PROSPEKID", prospekId);
			deleteBuilder.delete();
		}
	}
	
	public void deleteATTACHMENTBynoApk(String apK) throws Exception{
		if (isDaoATTACHMENTExist()) {
			DeleteBuilder<ATTACHMENT, String> deleteBuilder = null;
			deleteBuilder = getDaoATTACHMENT().deleteBuilder();
			deleteBuilder.where().eq("AP_REGNO", apK);
			deleteBuilder.delete();
		}
	}
	
	public void deleteATTACHMENTByFileName(String fileName) throws Exception{
		if (isDaoATTACHMENTExist()) {
			DeleteBuilder<ATTACHMENT, String> deleteBuilder = null;
			deleteBuilder = getDaoATTACHMENT().deleteBuilder();
			deleteBuilder.where().eq("FILENAME", fileName);
			deleteBuilder.delete();
		}
	}
	
	public void updatePendingUploadedATTACHMENTByProspek(String prospekId) throws Exception{
		if (isDaoATTACHMENTExist()) {
			UpdateBuilder<ATTACHMENT, String> updateBuilder = null;
			updateBuilder = getDaoATTACHMENT().updateBuilder();
			updateBuilder.where().eq("PROSPEKIDLOCAL", prospekId);
			updateBuilder.updateColumnValue("ISPENDINGUPLOADED", "1");
			updateBuilder.update();
		}
	}
	
	public ArrayList<PhotoData> getATTACHMENTByReadyUploadToServer(String NoApk, String kONS) {
		ArrayList<PhotoData> retVal = new ArrayList<PhotoData>();
		List<ATTACHMENT> qResult = null;
		
		if (isDaoATTACHMENTExist()) {
			try {
				qResult = getDaoATTACHMENT().queryBuilder().
						  where().eq("AP_REGNO", NoApk).and().eq("ISALREADYUPLOADEDTOSERVER", "0").
						  and().eq("ATTACH_TYPE_CODE", kONS).query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (ATTACHMENT rowData : qResult) {
					retVal.add(new PhotoData(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	public ArrayList<PhotoData> getATTACHMENTByReadyUploadToServerNew(String NoApk, ArrayList<String> FileName, String kONS) {
		ArrayList<PhotoData> retVal = new ArrayList<PhotoData>();
		List<ATTACHMENT> qResult = null;
		
		if (isDaoATTACHMENTExist()) {
			try {
				qResult = getDaoATTACHMENT().queryBuilder().
						  where().eq("AP_REGNO", NoApk).and().eq("ISALREADYUPLOADEDTOSERVER", "0").
						  and().eq("ATTACH_TYPE_CODE", kONS).
						  and().in("FILENAME", FileName).query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (ATTACHMENT rowData : qResult) {
					retVal.add(new PhotoData(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	public ArrayList<PhotoData> getATTACHMENTByReadyUploadToServerNews(String NoApk, String FileName, String kONS) {
		ArrayList<PhotoData> retVal = new ArrayList<PhotoData>();
		List<ATTACHMENT> qResult = null;
		
		if (isDaoATTACHMENTExist()) {
			try {
				qResult = getDaoATTACHMENT().queryBuilder().
						  where().eq("AP_REGNO", NoApk).and().eq("ISALREADYUPLOADEDTOSERVER", "0").
						  and().eq("ATTACH_TYPE_CODE", kONS).
						  and().eq("FILENAME", FileName).query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (ATTACHMENT rowData : qResult) {
					retVal.add(new PhotoData(rowData));
				}
			}
		}
		
		return retVal;
	}

	public ArrayList<PhotoData> getATTACHMENTByNomorAndCode(String aP_REGNO, String cODE) {
		ArrayList<PhotoData> retVal = new ArrayList<PhotoData>();
		List<ATTACHMENT> qResult = null;
		
		if (isDaoATTACHMENTExist()) {
			try {
				qResult = getDaoATTACHMENT().queryBuilder().where().eq("AP_REGNO", aP_REGNO).
						and().eq("ATTACH_ID", cODE).query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (ATTACHMENT rowData : qResult) {
					retVal.add(new PhotoData(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	public ArrayList<PhotoData> getATTACHMENTByFileOld(String aP_REGNO, String cODE, String iDS) {
		ArrayList<PhotoData> retVal = new ArrayList<PhotoData>();
		List<ATTACHMENT> qResult = null;
		
		if (isDaoATTACHMENTExist()) {
			try {
				qResult = getDaoATTACHMENT().queryBuilder().where().eq("AP_REGNO", aP_REGNO).
						and().eq("ATTACH_ID", cODE).
						and().notIn("ID", iDS).query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (ATTACHMENT rowData : qResult) {
					retVal.add(new PhotoData(rowData));
				}
			}
		}
		
		return retVal;
	}
	
}
