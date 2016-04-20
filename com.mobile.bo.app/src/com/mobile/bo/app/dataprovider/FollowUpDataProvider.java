package com.mobile.bo.app.dataprovider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.mobile.bo.app.datatype.FollowupData;
import com.mobile.database.app.entities.FOLLOWUP;

public class FollowUpDataProvider extends BaseDataProvider {
	/*public ArrayList<FollowupData> getFollowupDetailByDate(String parentId,String parentType) {
		ArrayList<FollowupData> retVal = new ArrayList<FollowupData>();
		List<FOLLOWUP> qResult = null;
		
		if (isDaoFOLLOWUPExist()) {
			try {
				qResult = getDaoFOLLOWUP().queryBuilder().orderByRaw("NEXTFOLLOWUP desc").where().eq("PARENTID", parentId)
						.and().eq("STAGE", parentType).and().eq("ACTION", "01")
						.query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (FOLLOWUP rowData : qResult) {
					retVal.add(new FollowupData(rowData));
				}
			}
		}
		
		return retVal;
	}
	public ArrayList<FollowupData> getAllFollowup() {
		ArrayList<FollowupData> retVal = new ArrayList<FollowupData>();
		List<FOLLOWUP> qResult = null;
		
		if (isDaoFOLLOWUPExist()) {
			try {
				qResult = getDaoFOLLOWUP().queryForAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (FOLLOWUP rowData : qResult) {
					retVal.add(new FollowupData(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	public FollowupData getFollowupDetail(String id) {
		FollowupData retData = null;
		FOLLOWUP qData = null;
		if (isDaoFOLLOWUPExist()) {
			try {
				qData = getDaoFOLLOWUP().queryForId(id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qData != null) {
				retData = new FollowupData(qData);
			}
		}
		return retData;
	}
	
	
	public ArrayList<FollowupData> getFollowupDetailByParent(String parentId,String parentType) {
		ArrayList<FollowupData> retVal = new ArrayList<FollowupData>();
		List<FOLLOWUP> qResult = null;
		
		if (isDaoFOLLOWUPExist()) {
			try {
				qResult = getDaoFOLLOWUP().queryBuilder().where().eq("PARENTID", parentId)
						.and().eq("STAGE", parentType).query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (FOLLOWUP rowData : qResult) {
					retVal.add(new FollowupData(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	public ArrayList<FollowupData> getPendingUpdatedFollowUp(String parentId,String parentType) {
		ArrayList<FollowupData> retVal = new ArrayList<FollowupData>();
		List<FOLLOWUP> qResult = null;
		
		if (isDaoFOLLOWUPExist()) {
			try {
				qResult = getDaoFOLLOWUP().queryBuilder().where().eq("PARENTID", parentId)
						.and().eq("STAGE", parentType)
						.and().eq("ISPENDINGUPDATEDTOSERVER", "1").query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (FOLLOWUP rowData : qResult) {
					retVal.add(new FollowupData(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	public ArrayList<String> getPendingIdsUpdatedFollowUp() {
		ArrayList<String> retVal = new ArrayList<String>();
		List<FOLLOWUP> qResult = null;
		
		if (isDaoFOLLOWUPExist()) {
			try {
				qResult = getDaoFOLLOWUP().queryBuilder().where().eq("ISPENDINGUPDATEDTOSERVER", "1").query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (FOLLOWUP rowData : qResult) {
					retVal.add(new FollowupData(rowData).getPARENTID());
				}
			}
		}
		
		return retVal;
	}
	
	public ArrayList<FollowupData> getAllActiveFollowUp() {
		ArrayList<FollowupData> retVal = new ArrayList<FollowupData>();
		List<FOLLOWUP> qResult = null;
		
		if (isDaoFOLLOWUPExist()) {
			try {
				qResult = getDaoFOLLOWUP().queryBuilder().where().eq("ISEDITABLE", "1").query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (FOLLOWUP rowData : qResult) {
					retVal.add(new FollowupData(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	
	
	public ArrayList<String> getFollowupDetailIdByParent(String parentId,String parentType) {
		ArrayList<String> retVal = new ArrayList<String>();
		List<FOLLOWUP> qResult = null;
		
		if (isDaoFOLLOWUPExist()) {
			try {
				qResult = getDaoFOLLOWUP().queryBuilder().orderByRaw("NEXTFOLLOWUP,ACTION asc").where().eq("PARENTID", parentId)
						.and().eq("STAGE", parentType).query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (FOLLOWUP rowData : qResult) {
					retVal.add(rowData.getID().toString());
				}
			}
		}
		
		return retVal;
	}
	
	public int getCountFollowupDetailByParent(String parentId,String parentType) {
		int retVal = 0;
		
		if (isDaoFOLLOWUPExist()) {
			try {
				retVal = getDaoFOLLOWUP().queryBuilder().where().eq("PARENTID", parentId)
						.and().eq("STAGE", parentType).query().size();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		
		return retVal;
	}
	
	public int udpateFollowUp(FollowupData data) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoFOLLOWUPExist()) {
			try {
				result = getDaoFOLLOWUP().createOrUpdate(data.toRowData());
				retVal = result.getNumLinesChanged();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return retVal;		
	}
	
	public void deleteFollowUpById(String id) {
		if (isDaoFOLLOWUPExist()) {
			DeleteBuilder<FOLLOWUP, String> deleteBuilder = null;
			try {
				deleteBuilder = getDaoFOLLOWUP().deleteBuilder();
				deleteBuilder.where().eq("ID", id);
				deleteBuilder.delete();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteFollowUpByParent(String id) throws Exception{
		if (isDaoFOLLOWUPExist()) {
			DeleteBuilder<FOLLOWUP, String> deleteBuilder = null;
			deleteBuilder = getDaoFOLLOWUP().deleteBuilder();
			deleteBuilder.where().eq("PARENTID", id);
			deleteBuilder.delete();
		}
	}
	
	public void deleteFollowUpByParents(ArrayList<String> arrIdx) throws Exception{
		if (isDaoFOLLOWUPExist()) {
			for (int i=0;i< arrIdx.size();i++){
				DeleteBuilder<FOLLOWUP, String> deleteBuilder = null;
				deleteBuilder = getDaoFOLLOWUP().deleteBuilder();
				deleteBuilder.where().eq("PARENTID", arrIdx.get(i));
				deleteBuilder.delete();
			}
			
		}
	}
	
	public void deleteFollowUpByParentAndType(String id,String type) throws Exception{
		if (isDaoFOLLOWUPExist()) {
			DeleteBuilder<FOLLOWUP, String> deleteBuilder = null;
			deleteBuilder = getDaoFOLLOWUP().deleteBuilder();
			deleteBuilder.where().eq("PARENTID", id)
			.and().eq("STAGE", type);
			deleteBuilder.delete();
		}
	}
	
	public void updateFollowUpByParentAndType(String prospekId,String id,String type) throws Exception{
		if (isDaoFOLLOWUPExist()) {
			UpdateBuilder<FOLLOWUP, String> updateBuilder = null;
			updateBuilder = getDaoFOLLOWUP().updateBuilder();
			updateBuilder.where().eq("PARENTID", id).
			and().eq("STAGE", type);
			updateBuilder.updateColumnValue("PROSPEKID", prospekId);
			updateBuilder.update();
		}
	}
	
	public void updateProspekIdFollowUp(String prospekId,String id) throws Exception{
		if (isDaoFOLLOWUPExist()) {
			UpdateBuilder<FOLLOWUP, String> updateBuilder = null;
			updateBuilder = getDaoFOLLOWUP().updateBuilder();
			updateBuilder.where().eq("PARENTID", id).
			and().eq("PROSPEKID", "");
			updateBuilder.updateColumnValue("PROSPEKID", prospekId);
			updateBuilder.update();
		}
	}
	
	public void updatePendingUpdatedFollowUpToServer(String prospekId,String type) throws Exception{
		if (isDaoFOLLOWUPExist()) {
			UpdateBuilder<FOLLOWUP, String> updateBuilder = null;
			updateBuilder = getDaoFOLLOWUP().updateBuilder();
			updateBuilder.where().eq("PARENTID", prospekId).
			and().eq("STAGE", type);
			updateBuilder.updateColumnValue("ISPENDINGUPDATEDTOSERVER", "0");
			updateBuilder.update();
		}
	}
	
	public void updateExpiredFollowUp(ArrayList<String> arrId) throws Exception{
		if (isDaoFOLLOWUPExist()) {
			for (int i=0;i<arrId.size();i++){
				UpdateBuilder<FOLLOWUP, String> updateBuilder = null;
				updateBuilder = getDaoFOLLOWUP().updateBuilder();
				updateBuilder.where().eq("ID", arrId.get(i));
				updateBuilder.updateColumnValue("ISEDITABLE", "0");
				updateBuilder.update();
			}
		}
	}
	*/
}
