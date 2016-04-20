package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

import com.mobile.database.app.entities.FOLLOWUP;
import com.mobile.framework.common.DateFormatter;

public class FollowupData implements Serializable {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 3572504466403518132L;

	private String ID;	
    private String USERID;		
    private String STAGE;
    private String STATUS ;		
    private String CATATAN ;		
    private boolean ISEDITABLE ;		
    private String ACTION ;		
    private Date NEXTFOLLOWUP ;		
    private String PARENTID ;
    private String PROSPEKID ;
    private boolean ISPENDINGUPDATEDTOSERVER;
    
    public FollowupData() {
		
	}
	public FollowupData(FOLLOWUP followup) {
		update(followup);
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getUSERID() {
		return USERID;
	}
	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}
	public String getSTAGE() {
		return STAGE;
	}
	public void setSTAGE(String sTAGE) {
		STAGE = sTAGE;
	}
	public Date getNEXTFOLLOWUP() {
		return NEXTFOLLOWUP;
	}
	public void setNEXTFOLLOWUP(Date nEXTFOLLOWUP) {
		NEXTFOLLOWUP = nEXTFOLLOWUP;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getCATATAN() {
		return CATATAN;
	}
	public void setCATATAN(String cATATAN) {
		CATATAN = cATATAN;
	}
	public boolean isEDITABLE() {
		return ISEDITABLE;
	}
	public void setISEDITABLE(boolean iSEDITABLE) {
		ISEDITABLE = iSEDITABLE;
	}
	public String getACTION() {
		return ACTION;
	}
	public void setACTION(String aCTION) {
		ACTION = aCTION;
	}	
	public String getPARENTID() {
		return PARENTID;
	}
	public void setPARENTID(String pARENTID) {
		PARENTID = pARENTID;
	}
	public String getPROSPEKID() {
		return PROSPEKID;
	}
	public void setPROSPEKID(String pROSPEKID) {
		PROSPEKID = pROSPEKID;
	}
	public boolean isISPENDINGUPDATEDTOSERVER() {
		return ISPENDINGUPDATEDTOSERVER;
	}
	public void setISPENDINGUPDATEDTOSERVER(boolean iSPENDINGUPDATEDTOSERVER) {
		ISPENDINGUPDATEDTOSERVER = iSPENDINGUPDATEDTOSERVER;
	}
	public FOLLOWUP toRowData(){
		FOLLOWUP rowData= new FOLLOWUP();
		
		rowData.setID(ID);
		rowData.setUSERID(USERID);
		rowData.setSTAGE(STAGE);
		rowData.setNEXTFOLLOWUP(NEXTFOLLOWUP);
		rowData.setSTATUS(STATUS);
		rowData.setCATATAN(CATATAN);
		rowData.setISEDITABLE(ISEDITABLE);
		rowData.setACTION(ACTION);
		rowData.setPARENTID(PARENTID);
		rowData.setPROSPEKID(PROSPEKID);
		rowData.setISPENDINGUPDATEDTOSERVER(ISPENDINGUPDATEDTOSERVER);
		
		return rowData;

	}
	
	public void update(FOLLOWUP rowData) {
		ID = rowData.getID();
		USERID = rowData.getUSERID();
		STAGE = rowData.getSTAGE();
		NEXTFOLLOWUP = rowData.getNEXTFOLLOWUP();
		STATUS=rowData.getSTATUS();
		CATATAN=rowData.getCATATAN();
		ISEDITABLE=rowData.getISEDITABLE();
		ACTION=rowData.getACTION();
		PARENTID=rowData.getPARENTID();
		PROSPEKID = rowData.getPROSPEKID();
		ISPENDINGUPDATEDTOSERVER = rowData.getISPENDINGUPDATEDTOSERVER();
	}
	
	public void update(String userid,String stage,Date nextfollowup,String status,String catatan,boolean isEditable,String action,String parentId){
		USERID=userid;
		STAGE=stage;
		NEXTFOLLOWUP=nextfollowup;
		STATUS=status;
		CATATAN=catatan;
		ISEDITABLE=isEditable;
		ACTION=action;
		PARENTID=parentId;
	}
	
	public void update(String userid,String stage,Date nextfollowup,String status,String catatan,boolean isEditable,String action){
		USERID=userid;
		STAGE=stage;
		NEXTFOLLOWUP=nextfollowup;
		STATUS=status;
		CATATAN=catatan;
		ISEDITABLE=isEditable;
		ACTION=action;
	}
	
	public void updateBlackboxFromJSON(JSONObject obj) throws Exception{
		ID = obj.getString("ID");
		NEXTFOLLOWUP=DateFormatter.formatDate(obj.getString("NEXTFOLLOWUP"));
		if(NEXTFOLLOWUP == null){NEXTFOLLOWUP=new Date();}
		STATUS=obj.getString("STATUS");
		CATATAN=obj.getString("CATATAN");
		ISEDITABLE=obj.getString("ISEDITABLEFLAG").equalsIgnoreCase("1")?true:false;
		ACTION=obj.getString("ACTION");
	}
}
