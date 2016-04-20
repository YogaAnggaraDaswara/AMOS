package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.mobile.database.app.common.DataConverter;

import com.mobile.database.app.entities.AMOS_ENTRY_DEBITUR_INT;

public class DataType_inbox_document implements Serializable {
	
	/**
	 * 
	 */
	
	public String AP_REGNO;
	public String CU_BORNDATE;
	public String USERID;
	public String AP_NEXTTRBYNAME;
	public String PRODUCTDESC;
	public String AP_RECVDATE;
	
	
	public void updateMainFromJSON(JSONObject obj) throws Exception {
		AP_REGNO = obj.getString("AP_REGNO");
		CU_BORNDATE = obj.getString("CU_BORNDATE");
		USERID = obj.getString("USERID");
		AP_NEXTTRBYNAME = obj.getString("AP_NEXTTRBYNAME");
		PRODUCTDESC = obj.getString("PRODUCTDESC");
		AP_RECVDATE = obj.getString("AP_RECVDATE");
	}
	
	public DataType_inbox_document()
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
			String cU_BORNDATE,
			String uSERID,
			String aP_NEXTTRBYNAME,
			String pRODUCTDESC,
			String aP_RECVDATE
	) {
		AP_REGNO = aP_REGNO;
		CU_BORNDATE = cU_BORNDATE;
		USERID = uSERID;
		AP_NEXTTRBYNAME = aP_NEXTTRBYNAME;
		PRODUCTDESC = pRODUCTDESC;
		AP_RECVDATE = aP_RECVDATE;
		
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

	public String getPRODUCTDESC() {
		return PRODUCTDESC;
	}

	public void setPRODUCTDESC(String pRODUCTDESC) {
		PRODUCTDESC = pRODUCTDESC;
	}
	
	public String getAP_RECVDATE() {
		return AP_RECVDATE;
	}
	public void setAP_RECVDATE(String aP_RECVDATE) {
		AP_RECVDATE = aP_RECVDATE;
	}
	
	
}
