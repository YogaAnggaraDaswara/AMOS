package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

import com.mobile.database.app.common.DataConverter;
import com.mobile.database.app.entities.APPR_STATUS;
import com.mobile.database.app.entities.ATTACHMENT;
import com.mobile.database.app.entities.ATTACHMENT_FILE;

public class Datatype_Appr_Status implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7967484269530763870L;
	public String ID;
	public String AP_REGNO;
	public String COL_ID;
	public String APPRS_TYPE;
	public String STATUS;
	
	public void updateMainFromJSON(JSONObject obj) throws Exception{
		 AP_REGNO=obj.getString("AP_REGNO");
		 COL_ID=obj.getString("COL_ID");
		 APPRS_TYPE=obj.getString("APPRS_TYPE");
		 STATUS=obj.getString("STATUS");
		 ID=obj.getString("ID");
		

	 }
    
	 public Datatype_Appr_Status() {
	    	update("",
	    			"",
	    			"",
	    			"",
	    			"");
		}
	    
	 public Datatype_Appr_Status(APPR_STATUS Data) {
			update(Data);
	}
		

	public APPR_STATUS toRowData(){
		APPR_STATUS rowData= new APPR_STATUS();
		rowData.setAP_REGNO(AP_REGNO);
		rowData.setCOL_ID(COL_ID);
		rowData.setAPPRS_TYPE(APPRS_TYPE);
		rowData.setSTATUS(STATUS);
		rowData.setID(ID);
		
		return rowData;
	}
	
	public void update(APPR_STATUS rowData) {
		AP_REGNO=rowData.getAP_REGNO();
		COL_ID=rowData.getCOL_ID();
		APPRS_TYPE=rowData.getAPPRS_TYPE();
		STATUS=rowData.getSTATUS();
		ID=rowData.getID();
	
	}
	
	public void update(String aP_REGNO,
			String cOL_ID,
			String aPPRS_TYPE,
			String iD,
			String sTATUS){
		AP_REGNO=aP_REGNO;
		COL_ID=cOL_ID;
		APPRS_TYPE=aPPRS_TYPE;
		ID=iD;
		STATUS=sTATUS;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
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

	public String getAPPRS_TYPE() {
		return APPRS_TYPE;
	}

	public void setAPPRS_TYPE(String aPPRS_TYPE) {
		APPRS_TYPE = aPPRS_TYPE;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	
	
	
}
