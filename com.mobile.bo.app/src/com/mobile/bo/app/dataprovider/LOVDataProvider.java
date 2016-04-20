package com.mobile.bo.app.dataprovider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.mobile.bo.app.datatype.LovData;
import com.mobile.database.app.entities.LOV;

public class LOVDataProvider extends BaseDataProvider {
	
	public LovData getLOVDetail(String code,String group) {
		LovData retData = null;
		LOV qResult = null;
		if (isDaoLOVExist()) {
			try {
				qResult = getDaoLOV().queryForFirst(
						getDaoLOV().queryBuilder().where().eq("CODE", code).and()
						.eq("GROUP", group).prepare());
	
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				retData = new LovData(qResult);
			}
		}
		return retData;
	}
	public LovData getLOVDetailbyID(String ID) {
		LovData retData = null;
		LOV qResult = null;
		if (isDaoLOVExist()) {
			try {
				qResult = getDaoLOV().queryForFirst(
						getDaoLOV().queryBuilder().where().eq("ID", ID).prepare());
	
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				retData = new LovData(qResult);
			}
		}
		return retData;
	}
	public int getListOfValueDataCount() {
		int retVal=0;
		if (isDaoLOVExist()) {
			try {
				retVal = getDaoLOV().queryForAll().size();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		return retVal;
	}
	
	
	public ArrayList<LovData> getListOfValueData(String group) {
		ArrayList<LovData> retData = new ArrayList<LovData>();
		List<LOV> qResult = null;
		if (isDaoLOVExist()) {
			try {
				qResult = getDaoLOV().queryBuilder().where().eq("GROUP", group)
						  .query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (LOV rowData : qResult) {
					retData.add(new LovData(rowData));
				}
			}
		}
		return retData;
	}
	
	public ArrayList<LovData> getListOfValueDataDuo(String group, String parent) {
		ArrayList<LovData> retData = new ArrayList<LovData>();
		List<LOV> qResult = null;
		if (isDaoLOVExist()) {
			try {
				qResult = getDaoLOV().queryBuilder().where().eq("GROUP", group).and().eq("PARENT", parent)
						  .query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (LOV rowData : qResult) {
					retData.add(new LovData(rowData));
				}
			}
		}
		return retData;
	}
	
	
	public LovData getListOfValueDataTrio(String group, String code, String parent) {
		LovData retData = null;
		LOV qResult = null;
		if (isDaoLOVExist()) {
			try {
				qResult = getDaoLOV().queryForFirst(
						getDaoLOV().queryBuilder().where().eq("GROUP", group).and().eq("CODE", code).and().eq("PARENT", parent).prepare());
	
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				retData = new LovData(qResult);
			}
		}
		return retData;
	}
	
	public ArrayList<LovData> getListOfValueDataWithNotInCode(String group, ArrayList<String> ids) {
		ArrayList<LovData> retData = new ArrayList<LovData>();
		List<LOV> qResult = null;
		if (isDaoLOVExist()) {
			try {
				qResult = getDaoLOV().queryBuilder().orderBy("DESCRIPTION", true)
						.distinct().where().eq("GROUP", group)
						.and().notIn("CODE", ids)
						.query();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (LOV rowData : qResult) {
					retData.add(new LovData(rowData));
				}
			}
		}
		return retData;
	}
	
	public LovData getListOfValueDataGrupCode(String group, String code) {
		LovData retData = null;
		LOV qResult = null;
		if (isDaoLOVExist()) {
			try {
				qResult = getDaoLOV().queryForFirst(
						getDaoLOV().queryBuilder().where().eq("GROUP", group).and().eq("CODE", code).prepare());
	
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				retData = new LovData(qResult);
			}
		}
		return retData;
	}
	
	public LovData getListOfValueDataRatelife(String group, String tenor, String age,String code) {
		LovData retData = null;
		LOV qResult = null;
		if (isDaoLOVExist()) {
			try {
				qResult = getDaoLOV().queryForFirst(
						getDaoLOV().queryBuilder().where().eq("GROUP", group).and().eq("CODE", code).and().eq("PARENT", tenor).and().eq("PARENT_2", age).prepare());
	
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				retData = new LovData(qResult);
			}
		}
		return retData;
	}
	public int update(LovData data) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoLOVExist()) {
			LovData lovData = getLOVDetailbyID(data.getID());
			if (lovData == null){
				try {
					result = getDaoLOV().createOrUpdate(data.toRowData());
					retVal = result.getNumLinesChanged();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}
		return retVal;		
	}
	public void deleteAllTabungan(){
		if (isDaoLOVExist()) {
			DeleteBuilder<LOV, String> dBuilder1 = getDaoLOV().deleteBuilder();
			try {
				dBuilder1.where().isNotNull("ID").prepare();
				dBuilder1.delete();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dBuilder1 = null;
		}
	}
}
