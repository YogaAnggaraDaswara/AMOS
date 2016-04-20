package com.mobile.bo.app.dataprovider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.mobile.bo.app.datatype.MessageData;
import com.mobile.database.app.entities.MESSAGE;

public class MessageDataProvider extends BaseDataProvider{
	/*public ArrayList<String> getAllMessage() {
		ArrayList<String> retVal = new ArrayList<String>();
		List<MESSAGE> qResult = null;
		
		if (isDaoMESSAGEExist()) {
			try {
				qResult = getDaoMESSAGE().queryForAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (MESSAGE rowData : qResult) {
					retVal.add(new MessageData(rowData).getID().toString());
				}
			}
		}
		
		return retVal;
	}
	
	public ArrayList<String> getUnreadMessage() {
		ArrayList<String> retVal = new ArrayList<String>();
		List<MESSAGE> qResult = null;
		
		if (isDaoMESSAGEExist()) {
			try {
				qResult = getDaoMESSAGE().queryBuilder().where().eq("ISREAD", "0").query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (MESSAGE rowData : qResult) {
					retVal.add(new MessageData(rowData).getID().toString());
				}
			}
		}
		
		return retVal;
	}
	
	public int getCountAllMessages() {
		int retVal = 0;
		if (isDaoMESSAGEExist()) {
			try {
				retVal = getDaoMESSAGE().queryForAll().size();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return retVal;
	}
	
	public int getCountUnreadMessage() {
		int retVal = 0;
		if (isDaoMESSAGEExist()) {
			try {
				retVal = getDaoMESSAGE().queryBuilder().where().eq("ISREAD", "0").query().size();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return retVal;
	}
	
	public MessageData getMessageDetail(String id) {
		MessageData retData = null;
		MESSAGE qData = null;
		if (isDaoMESSAGEExist()) {
			try {
				qData = getDaoMESSAGE().queryForId(id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qData != null) {
				retData = new MessageData(qData);
			}
		}
		return retData;
	}
	
	
	
	public int updateMessage(MessageData data) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoMESSAGEExist()) {
			try {
				result = getDaoMESSAGE().createOrUpdate(data.toRowData());
				retVal = result.getNumLinesChanged();	
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return retVal;		
	}
	
	public void deleteMessageById(String id) {
		if (isDaoMESSAGEExist()) {
			DeleteBuilder<MESSAGE, String> deleteBuilder = null;
			try {
				deleteBuilder = getDaoMESSAGE().deleteBuilder();
				deleteBuilder.where().eq("ID", id);
				deleteBuilder.delete();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteAllMessages(){
		if (isDaoMESSAGEExist()) {
			DeleteBuilder<MESSAGE, String> dBuilder1 = getDaoMESSAGE().deleteBuilder();
			try {
				dBuilder1.where().isNotNull("ID").prepare();
				dBuilder1.delete();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dBuilder1 = null;
		}
	}*/
}
