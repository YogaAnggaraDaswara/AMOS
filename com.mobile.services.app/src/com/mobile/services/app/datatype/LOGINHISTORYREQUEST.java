package com.mobile.services.app.datatype;

import java.util.ArrayList;
import com.google.gson.Gson;
import com.mobile.bo.app.datatype.LoginHistoryData;
import com.mobile.framework.common.DateFormatter;

public class LOGINHISTORYREQUEST {
	private String ID;
	private String USERID;
	private String PASSWORD;
	private String STATUS;
	private String DESCRIPTION;
	private String DATE;
    private String IMEI;

	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getUSERID() {
		return USERID;
	}
	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}
	public String getDATE() {
		return DATE;
	}
	public void setDATE(String dATE) {
		DATE = dATE;
	}
	public String getIMEI() {
		return IMEI;
	}
	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}
	public String toJSONString(ArrayList<LoginHistoryData> arrLoginHistory) throws Exception {  
		Gson gsonstatehistory =  new Gson();
		ArrayList<LOGINHISTORYREQUEST> arrayStateLoginRequest=new ArrayList<LOGINHISTORYREQUEST>();
		
		 for (int i=0;i<arrLoginHistory.size();i++){
			 	LOGINHISTORYREQUEST lhr=new LOGINHISTORYREQUEST();
			 	LoginHistoryData loginHistoryData= arrLoginHistory.get(i);
			 	lhr.setID(loginHistoryData.getID().toString());
			 	lhr.setUSERID(loginHistoryData.getUSERID());
			 	lhr.setPASSWORD(loginHistoryData.getPASSWORD());
			 	lhr.setSTATUS(loginHistoryData.getSTATUS());
			 	lhr.setDESCRIPTION(loginHistoryData.getDESCRIPTION());
			 	lhr.setDATE(loginHistoryData.getDATE() != null? DateFormatter.formatStringYYYYMMdd(loginHistoryData.getDATE(),true):"");
			 	lhr.setIMEI(loginHistoryData.getIMEI());

			 	arrayStateLoginRequest.add(lhr);
		 }

		return gsonstatehistory.toJson(arrayStateLoginRequest);
	}
}
