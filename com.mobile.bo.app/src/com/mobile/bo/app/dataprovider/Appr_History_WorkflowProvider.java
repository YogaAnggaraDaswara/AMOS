package com.mobile.bo.app.dataprovider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.mobile.bo.app.datatype.Datatype_Appr_Dokument;
import com.mobile.bo.app.datatype.Datatype_Appr_History_Workflow;
import com.mobile.database.app.entities.APPR_HISTORY_WORKFLOW;

public class Appr_History_WorkflowProvider extends BaseDataProvider{
	public ArrayList<Datatype_Appr_History_Workflow> getAllAppr_histoy(String AP_REGNO) {
		ArrayList<Datatype_Appr_History_Workflow> retVal = new ArrayList<Datatype_Appr_History_Workflow>();
		List<APPR_HISTORY_WORKFLOW> qResult = null;
		
		if (isDaoAPPR_HISTORY_WORKFLOWExist()) {
			try {
				qResult = getDoaAPPR_HISTORY_WORKFLOW().queryBuilder().where().eq("AP_REGNO", AP_REGNO)
						  .query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (APPR_HISTORY_WORKFLOW rowData : qResult) {
					retVal.add(new Datatype_Appr_History_Workflow(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	public int updateData(Datatype_Appr_History_Workflow data) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoAPPR_HISTORY_WORKFLOWExist()) {
			try {
				result = getDoaAPPR_HISTORY_WORKFLOW().createOrUpdate(data.toRowData());
				retVal = result.getNumLinesChanged();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return retVal;		
	}
	
}
