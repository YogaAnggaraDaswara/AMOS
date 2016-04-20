package com.mobile.bo.app.dataprovider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.mobile.bo.app.datatype.GeoLocationData;
import com.mobile.database.app.entities.GEOLOCATION;

public class GeoLocationDataProvider extends BaseDataProvider{
	
	/*public ArrayList<GeoLocationData> getAllGeoLocation() {
		ArrayList<GeoLocationData> retVal = new ArrayList<GeoLocationData>();
		List<GEOLOCATION> qResult = null;
		
		if (isDaoGEOLOCATIONExist()) {
			try {
				qResult = getDaoGEOLOCATION().queryForAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (GEOLOCATION rowData : qResult) {
					retVal.add(new GeoLocationData(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	public GeoLocationData getDetailGeoLocation(String id) {
		GeoLocationData retData = null;
		GEOLOCATION qData = null;
		if (isDaoGEOLOCATIONExist()) {
			try {
				qData = getDaoGEOLOCATION().queryForId(id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qData != null) {
				retData = new GeoLocationData(qData);
			}
		}
		return retData;
	}
	
	public GeoLocationData getLastGeoLocation() {
		GeoLocationData retVal = null;
		List<GEOLOCATION> qResult = null;
		
		if (isDaoGEOLOCATIONExist()) {
			try {
				qResult = getDaoGEOLOCATION().queryForAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				if (qResult.size() > 0){
					retVal = new GeoLocationData(qResult.get(qResult.size() - 1));
				}
			}
		}
		return retVal;
	}
	
	public int updateGeoLocation(GeoLocationData data) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoGEOLOCATIONExist()) {
			try {
				result = getDaoGEOLOCATION().createOrUpdate(data.toRowData());
				retVal = result.getNumLinesChanged();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return retVal;		
	}
	public void deleteGeoLocationById(String id) throws Exception{
		if (isDaoGEOLOCATIONExist()) {
			DeleteBuilder<GEOLOCATION, String> deleteBuilder = null;
			deleteBuilder = getDaoGEOLOCATION().deleteBuilder();
			deleteBuilder.where().eq("ID", id);
			deleteBuilder.delete();
		}
	}
	
	public void deleteGeoLocations(ArrayList<String> arrId) throws Exception{		
		if (isDaoGEOLOCATIONExist()) {			
			for (int i=0;i<arrId.size();i++){
				deleteGeoLocationById(arrId.get(i));
			}	
		}			
	}*/
}
