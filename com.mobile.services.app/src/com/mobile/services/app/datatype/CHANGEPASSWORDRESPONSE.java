package com.mobile.services.app.datatype;

import org.json.JSONObject;

public class CHANGEPASSWORDRESPONSE {
	public String USERID;
	public String OLDPASSWORD;
	public String NEWPASSWORD;
	
	public String getUSERID() {
		return USERID;
	}
	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}
	public String getOLDPASSWORD() {
		return OLDPASSWORD;
	}
	public void setOLDPASSWORD(String oLDPASSWORD) {
		OLDPASSWORD = oLDPASSWORD;
	}
	public String getNEWPASSWORD() {
		return NEWPASSWORD;
	}
	public void setNEWPASSWORD(String nEWPASSWORD) {
		NEWPASSWORD = nEWPASSWORD;
	}
	
	public void updateFromJSON(JSONObject obj) throws Exception{
		String result = obj.getString("result");
		JSONObject object=new JSONObject(result);
		USERID = object.getString("NOMORREKENING");
		OLDPASSWORD = object.getString("STATUS");
		NEWPASSWORD = object.getString("STATUS");
	}
}
