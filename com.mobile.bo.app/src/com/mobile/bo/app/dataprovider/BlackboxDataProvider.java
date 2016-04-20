package com.mobile.bo.app.dataprovider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.mobile.bo.app.datatype.Z_BlackboxData;
import com.mobile.database.app.entities.BLACKBOX;

public class BlackboxDataProvider extends BaseDataProvider{
	/*public ArrayList<BlackboxData> getAllBlackbox() {
		ArrayList<BlackboxData> retVal = new ArrayList<BlackboxData>();
		List<BLACKBOX> qResult = null;
		
		if (isDaoBLACKBOXExist()) {
			try {
				qResult = getDaoBLACKBOX().queryForAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (BLACKBOX rowData : qResult) {
					retVal.add(new BlackboxData(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	public int updateBlackbox(BlackboxData data) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoBLACKBOXExist()) {
			try {
				result = getDaoBLACKBOX().createOrUpdate(data.toRowData());
				retVal = result.getNumLinesChanged();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return retVal;		
	}
	*/
}
