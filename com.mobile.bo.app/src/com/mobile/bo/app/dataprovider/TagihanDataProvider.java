package com.mobile.bo.app.dataprovider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import android.R.integer;

import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.mobile.bo.app.datatype.TagihanData;
import com.mobile.database.app.entities.TAGIHAN;

public class TagihanDataProvider extends BaseDataProvider{
/*	
	public ArrayList<TagihanData> getAllTagihan() {
		ArrayList<TagihanData> retVal = new ArrayList<TagihanData>();
		List<TAGIHAN> qResult = null;
		
		if (isDaoTAGIHANExist()) {
			try {
				qResult = getDaoTAGIHAN().queryForAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (TAGIHAN rowData : qResult) {
					retVal.add(new TagihanData(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	
	public ArrayList<TagihanData> getAllTagihan(int limit,int pageNo) {
		ArrayList<TagihanData> retVal = new ArrayList<TagihanData>();
		List<TAGIHAN> qResult = null;
		
		if (isDaoTAGIHANExist()) {
			try {
				//qResult = getDaoTAGIHAN().queryForAll();
				qResult = getDaoTAGIHAN().queryBuilder().orderByRaw("ID asc").limit(limit).offset(limit * (pageNo-1)).query();
				//getDaoFOLLOWUP().queryBuilder().orderByRaw("NEXTFOLLOWUP desc").where().eq("PARENTID", parentId)
				//.and().eq("STAGE", parentType).and().eq("ACTION", "01")
				//.query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (TAGIHAN rowData : qResult) {
					retVal.add(new TagihanData(rowData));
				}
			}
		}
		
		return retVal;
	}
	public int getAllTagihanCount() {
		int retVal = 0;
		
		if (isDaoTAGIHANExist()) {
			try {
				GenericRawResults<String[]> rawResults = getDaoTAGIHAN().queryRaw("select count(*) from TAGIHAN ");
				List<String[]> results = rawResults.getResults();
				String[] resultArray = results.get(0);
				retVal=Integer.parseInt(resultArray[0]);
				//retVal = getDaoTAGIHAN().queryForAll().size();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		
		return retVal;
	}
	
	public TagihanData getDetailTagihan(String id) {
		TagihanData retData = null;
		TAGIHAN qData = null;
		if (isDaoTAGIHANExist()) {
			try {
				qData = getDaoTAGIHAN().queryForId(id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qData != null) {
				retData = new TagihanData(qData);
			}
		}
		return retData;
	}
	
	public int updateTagihan(TagihanData data) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoTAGIHANExist()) {
			try {
				result = getDaoTAGIHAN().createOrUpdate(data.toRowData());
				retVal = result.getNumLinesChanged();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return retVal;		
	}
	public void deleteTransaksiCashPickUpById(String id) throws Exception{
		if (isDaoTAGIHANExist()) {
			DeleteBuilder<TAGIHAN, String> deleteBuilder = null;
			deleteBuilder = getDaoTAGIHAN().deleteBuilder();
			deleteBuilder.where().eq("ID", id);
			deleteBuilder.delete();
		}
	}
	
	public void deleteAllTagihan(){
		if (isDaoTAGIHANExist()) {
			DeleteBuilder<TAGIHAN, String> dBuilder1 = getDaoTAGIHAN().deleteBuilder();
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
