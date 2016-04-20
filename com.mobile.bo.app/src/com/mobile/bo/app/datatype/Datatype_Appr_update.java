package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

import com.mobile.database.app.common.DataConverter;
import com.mobile.database.app.entities.APPR_COLLATERAL;
import com.mobile.database.app.entities.APPR_DOKUMENT;
import com.mobile.database.app.entities.APPR_HISTORY;
import com.mobile.database.app.entities.APPR_MAIN;
import com.mobile.database.app.entities.APPR_MCH_VALUATION_INT;
import com.mobile.database.app.entities.APPR_PB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_RTB_CEK_TATA_KOTA_INT;
import com.mobile.database.app.entities.APPR_RTB_IMB_INT;
import com.mobile.database.app.entities.APPR_RTB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_VHC_VALUATION_INT;
import com.mobile.database.app.entities.BLACKBOX;

public class Datatype_Appr_update implements Serializable {

	/**
	 * 
	 */
	public String AP_REGNO;
	public String COL_ID;
	public String USERID;
	public String ATC_REQUEST;
	


	 public void updateMainFromJSON(JSONObject obj) throws Exception{
		 AP_REGNO=obj.getString("AP_REGNO");
		 COL_ID=obj.getString("COL_ID");
		 USERID=obj.getString("USERID");
		 ATC_REQUEST=obj.getString("ATC_REQUEST");
		 


	 }
    
	 public Datatype_Appr_update() {
	    	update("",
	    			"",
	    			"",
	    			"");
		}
	    

	public void update(String aP_REGNO,
			String cOL_ID,
			String uSER_ID,
			String aTC_REQUEST){
		AP_REGNO=aP_REGNO;
		COL_ID=cOL_ID;
		USERID=uSER_ID;
		ATC_REQUEST=aTC_REQUEST;
		
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

	public String getATC_REQUEST() {
		return ATC_REQUEST;
	}

	public void setATC_REQUEST(String aTC_REQUEST) {
		ATC_REQUEST = aTC_REQUEST;
	}

	
}
