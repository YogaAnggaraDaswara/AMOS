package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

import com.mobile.database.app.common.DataConverter;
import com.mobile.database.app.entities.ATTACHMENT;
import com.mobile.database.app.entities.ATTACHMENT_FILE;

public class Datatype_attachment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7967484269530763870L;
	public String ID  ;
	public String AP_REGNO  ;
	public String COL_ID  ;
	public String GENERATE_TYPE  ;
	public String GENERATE_TYPE_REFF  ;
	public String USERID  ;
	public String TOTAL_IMAGE  ;
	public String STATUS  ;
	public String FILEPATH  ;
	public String GENERATE_DATE  ;
	public String ISDOWNLOAD;
	public String FILENAME;
	public String ISSTATUS  ;	
	public String getFILENAME() {
		return FILENAME;
	}
	public void setFILENAME(String fILENAME) {
		FILENAME = fILENAME;
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
	public String getGENERATE_TYPE() {
		return GENERATE_TYPE;
	}
	public void setGENERATE_TYPE(String gENERATE_TYPE) {
		GENERATE_TYPE = gENERATE_TYPE;
	}
	public String getGENERATE_TYPE_REFF() {
		return GENERATE_TYPE_REFF;
	}
	public void setGENERATE_TYPE_REFF(String gENERATE_TYPE_REFF) {
		GENERATE_TYPE_REFF = gENERATE_TYPE_REFF;
	}
	public String getUSERID() {
		return USERID;
	}
	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}
	public String getTOTAL_IMAGE() {
		return TOTAL_IMAGE;
	}
	public void setTOTAL_IMAGE(String tOTAL_IMAGE) {
		TOTAL_IMAGE = tOTAL_IMAGE;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getFILEPATH() {
		return FILEPATH;
	}
	public void setFILEPATH(String fILEPATH) {
		FILEPATH = fILEPATH;
	}
	public String getGENERATE_DATE() {
		return GENERATE_DATE;
	}
	public void setGENERATE_DATE(String gENERATE_DATE) {
		GENERATE_DATE = gENERATE_DATE;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	 public String getISDOWNLOAD() {
		return ISDOWNLOAD;
	}
	public void setISDOWNLOAD(String iSDOWNLOAD) {
		ISDOWNLOAD = iSDOWNLOAD;
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	
	public String getISSTATUS() {
		return ISSTATUS;
	}
	public void setISSTATUS(String iSSTATUS) {
		ISSTATUS = iSSTATUS;
	}
	public void updateMainFromJSON(JSONObject obj) throws Exception{
		 AP_REGNO=obj.getString("AP_REGNO");
		 COL_ID=obj.getString("COL_ID");
		 GENERATE_TYPE=obj.getString("GENERATE_TYPE");
		 GENERATE_TYPE_REFF=obj.getString("GENERATE_TYPE_REFF");
		 USERID=obj.getString("USERID");
		 TOTAL_IMAGE=obj.getString("TOTAL_IMAGE");
		 STATUS=obj.getString("STATUS");
		 ISDOWNLOAD=obj.getString("ISDOWNLOAD");
		 ID=obj.getString("ID");
		 FILENAME=obj.getString("FILEPATH");

	 }
    
	 public Datatype_attachment() {
	    	update("",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"");
		}
	    
	 public Datatype_attachment(ATTACHMENT_FILE Data) {
			update(Data);
	}
		

	public ATTACHMENT_FILE toRowData(){
		ATTACHMENT_FILE rowData= new ATTACHMENT_FILE();
		rowData.setAP_REGNO(AP_REGNO);
		rowData.setCOL_ID(COL_ID);
		rowData.setGENERATE_TYPE(GENERATE_TYPE);
		rowData.setGENERATE_TYPE_REFF(GENERATE_TYPE_REFF);
		rowData.setUSERID(USERID);
		rowData.setTOTAL_IMAGE(TOTAL_IMAGE);
		rowData.setSTATUS(STATUS);
		rowData.setISDOWNLOAD(ISDOWNLOAD);
		rowData.setFILENAME(FILENAME);
		rowData.setID(ID);
		rowData.setISSTATUS(ISSTATUS);
	
		return rowData;
	}
	
	public void update(ATTACHMENT_FILE rowData) {
		AP_REGNO=rowData.getAP_REGNO();
		COL_ID=rowData.getCOL_ID();
		GENERATE_TYPE=rowData.getGENERATE_TYPE ();
		GENERATE_TYPE_REFF=rowData.getGENERATE_TYPE_REFF ();
		USERID=rowData.getUSERID ();
		TOTAL_IMAGE=rowData.getTOTAL_IMAGE ();
		STATUS=rowData.getSTATUS ();
		ISDOWNLOAD=rowData.getISDOWNLOAD ();
		FILENAME=rowData.getFILENAME();
		ID=rowData.getID();
		ISSTATUS=rowData.getISSTATUS ();

	}
	
	public void update(String aP_REGNO,
			String cOL_ID,
			String gENERATE_TYPE,
			String gENERATE_TYPE_REFF,
			String uSERID,
			String tOTAL_IMAGE,
			String sTATUS,
			String iSDOWNLOAD,
			String fILENAME,
			String iD,
			String iSSTATUS){
		AP_REGNO=aP_REGNO;
		COL_ID=cOL_ID;
		GENERATE_TYPE=gENERATE_TYPE;
		GENERATE_TYPE_REFF=gENERATE_TYPE_REFF;
		USERID=uSERID;
		TOTAL_IMAGE=tOTAL_IMAGE;
		STATUS=sTATUS;
		ISDOWNLOAD=iSDOWNLOAD;
		FILENAME=fILENAME;
		ID=iD;
		ISSTATUS=iSSTATUS;
	}
	
	
	
}
