package com.mobile.services.app.datatype;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class PROSPEKRESPONSE {
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

	public ArrayList<PROSPEKRESPONSE> updateFromJSON(JSONObject obj) throws Exception{
		JSONArray objArray= new JSONArray(obj.getString("result"));
		ArrayList<PROSPEKRESPONSE> arrProspek= new ArrayList<PROSPEKRESPONSE>();
		
		for (int i=0;i<objArray.length();i++){
			JSONObject object=objArray.getJSONObject(i);
			PROSPEKRESPONSE prospekresponse=new PROSPEKRESPONSE();
			prospekresponse.setID(object.getString("ID"));
			prospekresponse.setPROSPEKID(object.getString("PROSPEKID"));
			prospekresponse.setSTATUS(object.getString("STATUS"));
			
			arrProspek.add(prospekresponse);
		}
		
		return arrProspek;
	}
}
