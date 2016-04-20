package com.mobile.bo.app.dataprovider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.mobile.bo.app.datatype.Datatype_Appr_Dokument;
import com.mobile.database.app.entities.APPR_DOKUMENT;

public class Appr_DokumentDataProvider extends BaseDataProvider{
	public ArrayList<Datatype_Appr_Dokument> getAllAppr_dokument(String AP_REGNO) {
		ArrayList<Datatype_Appr_Dokument> retVal = new ArrayList<Datatype_Appr_Dokument>();
		List<APPR_DOKUMENT> qResult = null;
		
		if (isDaoAPPR_DOKUMENTExist()) {
			try {
				qResult = getDoaAPPR_DOKUMENT().queryBuilder().where().eq("AP_REGNO", AP_REGNO)
						  .query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (APPR_DOKUMENT rowData : qResult) {
					retVal.add(new Datatype_Appr_Dokument(rowData));
				}
			}
		}
		
		return retVal;
	}
	public Datatype_Appr_Dokument getAllAppr_dokument_byid(String ID) {
			Datatype_Appr_Dokument retVal = new Datatype_Appr_Dokument();
			List<APPR_DOKUMENT> qResult = null;
			
			if (isDaoAPPR_DOKUMENTExist()) {
				try {
					qResult = getDoaAPPR_DOKUMENT().queryBuilder().where().eq("ID", ID)
							  .query();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (qResult != null) {
					for (APPR_DOKUMENT rowData : qResult) {
						retVal=(new Datatype_Appr_Dokument(rowData));
					}
				}
			}
			
			return retVal;
		}
		


	public int updateData(Datatype_Appr_Dokument data) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoAPPR_MAINExist()) {
			try {
				result = getDoaAPPR_DOKUMENT().createOrUpdate(data.toRowData());
				retVal = result.getNumLinesChanged();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return retVal;		
	}
	
}
