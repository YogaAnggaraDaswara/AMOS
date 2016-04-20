package com.mobile.services.app.datatype;

import org.json.JSONObject;

public class CHANGEPASSWORDREQUEST {
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
	
	public String toJSONString(String userid,String oldpassword,String newpassword) throws Exception {
		JSONObject jsonObject = new JSONObject();
        jsonObject.accumulate("USERID", userid);
        jsonObject.accumulate("OLDPASSWORD", oldpassword);
        jsonObject.accumulate("NEWPASSWORD", newpassword);
        
        return jsonObject.toString();
	}
}
