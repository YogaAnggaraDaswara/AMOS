package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

import com.mobile.database.app.common.DataConverter;


public class Datatype_Appr_UpdateStatus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7967484269530763870L;
	public String AP_REGNO;
	public String COL_ID;
	public String USERID;
	public String FLAG;
	
	public void updateMainFromJSON(JSONObject obj) throws Exception{
		 AP_REGNO=obj.getString("AP_REGNO");
		 COL_ID=obj.getString("COL_ID");
		 USERID=obj.getString("USERID");
		 FLAG=obj.getString("FLAG");
	
	 }
    
	 public Datatype_Appr_UpdateStatus() {
	    	update("",
	    			"",
	    			"",
	    			"");
		}
	    
		

	
	public void update(String aP_REGNO,
			String cOL_ID,
			String uSERID,
			String fLAG){
		AP_REGNO=aP_REGNO;
		COL_ID=cOL_ID;
		USERID=uSERID;
		FLAG=fLAG;
	}

	public String getAP_REGNO() {
		return AP_REGNO;
	}

	public void setAP_REGNO(String aP_REGNO) {
		AP_REGNO = aP_REGNO;
	}

	public String getCOL_ID() {
		return COL_ID;
	}

	public void setCOL_ID(String cOL_ID) {
		COL_ID = cOL_ID;
	}

	public String getUSERID() {
		return USERID;
	}

	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}

	public String getFLAG() {
		return FLAG;
	}

	public void setFLAG(String fLAG) {
		FLAG = fLAG;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
}
