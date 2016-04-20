package com.mobile.bo.app.datatype;

import org.json.JSONObject;

public class ProspekResponse {
	private String ID;
	private String PROSPEKID;
	private String STATUS;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPROSPEKID() {
		return PROSPEKID;
	}
	public void setPROSPEKID(String pROSPEKID) {
		PROSPEKID = pROSPEKID;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	
	public void updateProspekResponseFromJSON(JSONObject obj) throws Exception{
		ID = obj.getString("ID");
		PROSPEKID = obj.getString("PROSPEKID");
		STATUS = obj.getString("STATUS");
	}
}
