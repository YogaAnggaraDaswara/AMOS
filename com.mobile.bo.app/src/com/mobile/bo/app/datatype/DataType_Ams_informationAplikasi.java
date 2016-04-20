package com.mobile.bo.app.datatype;

import java.io.Serializable;

import org.json.JSONObject;

public class DataType_Ams_informationAplikasi implements Serializable {
	
	/**
	 * 
	 */
	
	public String AP_REGNO;
	public String CU_BORNDATE;
	public String USERID;
	public String AP_NEXTTRBYNAME;
	public String PRODCATDESC;
	public String AP_RECVDATE;
	public String AP_CURRTRCODE;
	public String TR_DESC;
	
	public void updateMainFromJSON(JSONObject obj) throws Exception {
		AP_REGNO = obj.getString("AP_REGNO");
		CU_BORNDATE = obj.getString("CU_BORNDATE");
		USERID = obj.getString("USERID");
		AP_NEXTTRBYNAME = obj.getString("AP_NEXTTRBYNAME");
		PRODCATDESC = obj.getString("PRODCATDESC");
		AP_RECVDATE = obj.getString("AP_RECVDATE");
		AP_CURRTRCODE = obj.getString("AP_CURRTRCODE");
		TR_DESC = obj.getString("TR_DESC");
	}
	
	public DataType_Ams_informationAplikasi()
	{
		update("",
			"",
			"", 
			"",
			"",
			"", 
			"",
			"");
	}
	
	public void update(
			String aP_REGNO,
			String cU_BORNDATE,
			String uSERID,
			String aP_NEXTTRBYNAME,
			String pRODCATDESC,
			String aP_RECVDATE,
			String aP_CURRTRCODE,
			String tR_DESC
	) {
		AP_REGNO = aP_REGNO;
		CU_BORNDATE = cU_BORNDATE;
		USERID = uSERID;
		AP_NEXTTRBYNAME = aP_NEXTTRBYNAME;
		PRODCATDESC = pRODCATDESC;
		AP_RECVDATE = aP_RECVDATE;
		AP_CURRTRCODE = aP_CURRTRCODE;
		TR_DESC = tR_DESC;
	}

	public String getAP_REGNO() {
		return AP_REGNO;
	}

	public void setAP_REGNO(String aP_REGNO) {
		AP_REGNO = aP_REGNO;
	}

	public String getCU_BORNDATE() {
		return CU_BORNDATE;
	}

	public void setCU_BORNDATE(String cU_BORNDATE) {
		CU_BORNDATE = cU_BORNDATE;
	}

	public String getUSERID() {
		return USERID;
	}

	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}

	public String getAP_NEXTTRBYNAME() {
		return AP_NEXTTRBYNAME;
	}

	public void setAP_NEXTTRBYNAME(String aP_NEXTTRBYNAME) {
		AP_NEXTTRBYNAME = aP_NEXTTRBYNAME;
	}

	public String getPRODCATDESC() {
		return PRODCATDESC;
	}

	public void setPRODCATDESC(String pRODCATDESC) {
		PRODCATDESC = pRODCATDESC;
	}

	public String getAP_RECVDATE() {
		return AP_RECVDATE;
	}
	public void setAP_RECVDATE(String aP_RECVDATE) {
		AP_RECVDATE = aP_RECVDATE;
	}
	
	public String getAP_CURRTRCODE() {
		return AP_CURRTRCODE;
	}
	public void setAP_CURRTRCODE(String aP_CURRTRCODE) {
		AP_CURRTRCODE = aP_CURRTRCODE;
	}
	
	public String getTR_DESC() {
		return TR_DESC;
	}
	public void setTR_DESC(String tR_DESC) {
		TR_DESC = tR_DESC;
	}
	
}
