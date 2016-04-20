package com.mobile.bo.app.dataprovider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mobile.bo.app.datatype.StatistikDataTemp;
import com.mobile.database.app.entities.PROSPEK;

public class StatistikDataProvider extends BaseDataProvider{
	/*public final static String PROSPEK_TYPE="T01";
	public final static String KENALAN_TYPE="T02";
	public final static String PENDEKATAN_TYPE="T03";
	public final static String CLOSING_TYPE="T04";
	public final static String REQUEST_BLACKBOX_TYPE="T05";
	
	public ArrayList<StatistikDataTemp> getStatistikDataProspek() {
		ArrayList<StatistikDataTemp> retVal = new ArrayList<StatistikDataTemp>();
		List<PROSPEK> qResult = null;
		FollowUpDataProvider followupdataprovider=new FollowUpDataProvider();
		
		if (isDaoPROSPEKExist()) {
			try {
				qResult = getDaoPROSPEK().queryForAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (PROSPEK rowData : qResult) {
					int countProspek = followupdataprovider.getCountFollowupDetailByParent(rowData.getID().toString(), PROSPEK_TYPE);
					int countKenalan = followupdataprovider.getCountFollowupDetailByParent(rowData.getID().toString(), KENALAN_TYPE);
					int countPendekatan = followupdataprovider.getCountFollowupDetailByParent(rowData.getID().toString(), PENDEKATAN_TYPE);
					int countClosing = followupdataprovider.getCountFollowupDetailByParent(rowData.getID().toString(), CLOSING_TYPE);
					int countRequestBlackbox = 0;
					//retVal.add(new StatistikDataTemp(rowData.getID(),rowData.getDATE(),countProspek,countKenalan,countPendekatan,countClosing,countRequestBlackbox));
				}
			}
		}
		followupdataprovider = null;
		return retVal;
	}*/
}
