package com.mobile.bo.app.dataprovider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.mobile.bo.app.datatype.NewsData;
import com.mobile.database.app.entities.NEWS;

public class NewsDataProvider extends BaseDataProvider{
	/*public ArrayList<String> getAllNews() {
		ArrayList<String> retVal = new ArrayList<String>();
		List<NEWS> qResult = null;
		
		if (isDaoNEWSExist()) {
			try {
				qResult = getDaoNEWS().queryForAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (NEWS rowData : qResult) {
					retVal.add(new NewsData(rowData).getID().toString());
				}
			}
		}
		
		return retVal;
	}
	public ArrayList<NewsData> getUnreadNews() {
		ArrayList<NewsData> retVal = new ArrayList<NewsData>();
		List<NEWS> qResult = null;
		if (isDaoNEWSExist()) {
			try {
				qResult = getDaoNEWS().queryBuilder().where().eq("ISREAD", "0").query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (NEWS rowData : qResult) {
					retVal.add(new NewsData(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	public int getCountNews() {
		int retVal = 0;
		if (isDaoNEWSExist()) {
			try {
				retVal = getDaoNEWS().queryForAll().size();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return retVal;
	}
	
	public int getCountUnreadNews() {
		int retVal = 0;
		if (isDaoNEWSExist()) {
			try {
				retVal = getDaoNEWS().queryBuilder().where().eq("ISREAD", "0").query().size();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return retVal;
	}
	
	public NewsData getNewsDetail(String id) {
		NewsData retData = null;
		NEWS qData = null;
		if (isDaoNEWSExist()) {
			try {
				qData = getDaoNEWS().queryForId(id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qData != null) {
				retData = new NewsData(qData);
			}
		}
		return retData;
	}
	
	
	
	public int udpateNews(NewsData data) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoNEWSExist()) {
			try {
				result = getDaoNEWS().createOrUpdate(data.toRowData());
				retVal = result.getNumLinesChanged();	
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return retVal;		
	}
	
	public void deleteNewsById(String id) {
		if (isDaoNEWSExist()) {
			DeleteBuilder<NEWS, String> deleteBuilder = null;
			try {
				deleteBuilder = getDaoNEWS().deleteBuilder();
				deleteBuilder.where().eq("ID", id);
				deleteBuilder.delete();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteAllNews(){
		if (isDaoNEWSExist()) {
			DeleteBuilder<NEWS, String> dBuilder1 = getDaoNEWS().deleteBuilder();
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
