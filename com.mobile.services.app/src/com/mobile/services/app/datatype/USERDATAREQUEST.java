package com.mobile.services.app.datatype;

import org.json.JSONObject;

public class USERDATAREQUEST {

	public String USERID;
	public String PASSWORD;
	public String IMEI;
	public String MODULEID;
	
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
	public String getIMEI() {
		return IMEI;
	}
	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}
	public String getMODULEID() {
		return MODULEID;
	}
	public void setMODULEID(String mODULEID) {
		MODULEID = mODULEID;
	}
	public JSONObject toJSONObject(String userid,String password,String imei,String moduleId) throws Exception {
		JSONObject jsonObject = new JSONObject();
        jsonObject.accumulate("USERID", userid);
        jsonObject.accumulate("PASSWORD", password);
        jsonObject.accumulate("IMEI", imei);
        jsonObject.accumulate("MODULEID", moduleId);
        
        return jsonObject;
	}
}
