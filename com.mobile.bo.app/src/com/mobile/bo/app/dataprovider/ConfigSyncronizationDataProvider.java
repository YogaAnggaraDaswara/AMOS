package com.mobile.bo.app.dataprovider;

import java.sql.SQLException;
import java.util.List;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.mobile.bo.app.datatype.ConfigSyncronizationData;
import com.mobile.bo.app.datatype.Z_ConfigSyncronizationData;
import com.mobile.database.app.entities.CONFIGSYNCHRONIZATION;

public class ConfigSyncronizationDataProvider extends BaseDataProvider{
	
	public ConfigSyncronizationData getConfigSyncronizationData() {
		ConfigSyncronizationData retVal = null;
		List<CONFIGSYNCHRONIZATION> qResult = null;
		
		if (isDaoConfigSynchronizationExist()) {
			try {
				qResult = getDaoCONFIGSYNCHRONIZATION().queryForAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				retVal= new ConfigSyncronizationData(qResult.get(0));
			}
		}
		
		return retVal;
	}
	
	public int getAllConfigSyncronizationDataCount() {
		int retVal= 0;
		if (isDaoConfigSynchronizationExist()) {
			try {
				retVal = getDaoCONFIGSYNCHRONIZATION().queryForAll().size();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return retVal;
	}
	
	public int updateConfigSyncronization(ConfigSyncronizationData data) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoConfigSynchronizationExist()) {
			try {
				result = getDaoCONFIGSYNCHRONIZATION().createOrUpdate(data.toRowData());
				retVal = result.getNumLinesChanged();	
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return retVal;		
	}
}
