package com.mobile.bo.app.dataprovider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.mobile.bo.app.datatype.ScheduleData;
import com.mobile.database.app.entities.SCHEDULE;

public class ScheduleDataProvider extends BaseDataProvider{
	
		public ArrayList<ScheduleData> getAllSchedule() {
		ArrayList<ScheduleData> retVal = new ArrayList<ScheduleData>();
		List<SCHEDULE> qResult = null;
		
		if (isDaoSCHEDULEExist()) {
			try {
				qResult = getDaoSCHEDULE().queryForAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (SCHEDULE rowData : qResult) {
					retVal.add(new ScheduleData(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	public ArrayList<ScheduleData> getProspekSchedule() {
		ArrayList<ScheduleData> retVal = new ArrayList<ScheduleData>();
		List<SCHEDULE> qResult = null;
		
		List<String> schedulesToRetrieve=new ArrayList<String>();
		schedulesToRetrieve.add("1");
		/*schedulesToRetrieve.add("13");
		schedulesToRetrieve.add("14");
		schedulesToRetrieve.add("15");
		*/
		if (isDaoSCHEDULEExist()) {
			try {
				qResult = getDaoSCHEDULE().queryBuilder().where().in("ID", schedulesToRetrieve)
						  .query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (SCHEDULE rowData : qResult) {
					retVal.add(new ScheduleData(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	public ScheduleData getDetailSchedule(String id) {
		ScheduleData retData = null;
		SCHEDULE qData = null;
		if (isDaoSCHEDULEExist()) {
			try {
				qData = getDaoSCHEDULE().queryForId(id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qData != null) {
				retData = new ScheduleData(qData);
			}
		}
		return retData;
	}
	
	public int updateSchedule(ScheduleData data) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoSCHEDULEExist()) {
			try {
				result = getDaoSCHEDULE().createOrUpdate(data.toRowData());
				retVal = result.getNumLinesChanged();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return retVal;		
	}
	public void delete(String id) throws Exception{
		if (isDaoSCHEDULEExist()) {
			DeleteBuilder<SCHEDULE, String> deleteBuilder = null;
			deleteBuilder = getDaoSCHEDULE().deleteBuilder();
			deleteBuilder.where().eq("ID", id);
			deleteBuilder.delete();
		}
	}
	
}
