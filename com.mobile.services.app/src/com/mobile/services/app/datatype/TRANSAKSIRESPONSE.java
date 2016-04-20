package com.mobile.services.app.datatype;

import org.json.JSONObject;

public class TRANSAKSIRESPONSE {
	private String NOMORREKENING;
	private int STATUS;
	public String getNOMORREKENING() {
		return NOMORREKENING;
	}
	public void setNOMORREKENING(String nOMORREKENING) {
		NOMORREKENING = nOMORREKENING;
	}
	public int getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}
	
	public void updateFromJSON(JSONObject obj) throws Exception{
		String result = obj.getString("result");
		JSONObject object=new JSONObject(result);
		NOMORREKENING = object.getString("NOMORREKENING");
		STATUS = Integer.parseInt(object.getString("STATUS"));
	}
}
