package com.mobile.bo.app.datatype;

import java.io.Serializable;

import org.json.JSONObject;

public class DataType_Ams_informationApk_Detail implements Serializable {
	
	/**
	 * 
	 */
	
	public String AP_REGNO;
	public String DOC_DESC;
	public String DOC_AVAIL;
	public String DOC_VALID;
	public String DOC_ORIG;
	public String DOC_RECVDATE;
	
	public void updateMainFromJSON(JSONObject obj) throws Exception {
		AP_REGNO = obj.getString("AP_REGNO");
		DOC_DESC = obj.getString("DOC_DESC");
		DOC_AVAIL = obj.getString("DOC_AVAIL");
		DOC_VALID = obj.getString("DOC_VALID");
		DOC_ORIG = obj.getString("DOC_ORIG");
		DOC_RECVDATE = obj.getString("DOC_RECVDATE");
	}
	
	public DataType_Ams_informationApk_Detail()
	{
		update("",
			"",
			"", 
			"",
			"",
			"");
	}
	
	public void update(
			String aP_REGNO,
			String dOC_DESC,
			String dOC_AVAIL,
			String dOC_VALID,
			String dOC_ORIG,
			String dOC_RECVDATE
	) {
		AP_REGNO = aP_REGNO;
		DOC_DESC = dOC_DESC;
		DOC_AVAIL = dOC_AVAIL;
		DOC_VALID = dOC_VALID;
		DOC_ORIG = dOC_ORIG;
		DOC_RECVDATE = dOC_RECVDATE;
		
	}
	public String getAP_REGNO() {
		return AP_REGNO;
	}

	public void setAP_REGNO(String aP_REGNO) {
		AP_REGNO = aP_REGNO;
	}
	public String getDOC_DESC() {
		return DOC_DESC;
	}

	public void setDOC_DESC(String dOC_DESC) {
		DOC_DESC = dOC_DESC;
	}
	public String getDOC_AVAIL() {
		return DOC_AVAIL;
	}
	public void setDOC_AVAIL(String dOC_AVAIL) {
		DOC_AVAIL = dOC_AVAIL;
	}

	public String getDOC_VALID() {
		return DOC_VALID;
	}
	public void setDOC_VALID(String dOC_VALID) {
		DOC_VALID = dOC_VALID;
	}
	
	public String getDOC_ORIG() {
		return DOC_ORIG;
	}
	public void setDOC_ORIG(String dOC_ORIG) {
		DOC_ORIG = dOC_ORIG;
	}
	
	public String getDOC_RECVDATE() {
		return DOC_RECVDATE;
	}
	public void setDOC_RECVDATE(String dOC_RECVDATE) {
		DOC_RECVDATE = dOC_RECVDATE;
	}

}
