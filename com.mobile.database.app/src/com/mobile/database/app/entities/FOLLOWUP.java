package com.mobile.database.app.entities;

import java.util.Date;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="FOLLOWUP")
public class FOLLOWUP {
	@DatabaseField(
			id=true, 
			unique=true,
			canBeNull=false,
			uniqueIndexName="FOLLOWUP_PK",
			dataType=DataType.STRING,
			width=40)		
    private String ID;
	
	@DatabaseField(
			dataType=DataType.STRING,
			width=20)
    private String USERID;
	
	@DatabaseField(
			dataType=DataType.STRING,
			width=3)
    private String STAGE;
	
	@DatabaseField(
			dataType=DataType.STRING,
			width=2)
    private String STATUS ;
	
	@DatabaseField(
			dataType=DataType.STRING,
			width=100)
    private String CATATAN ;
	
	@DatabaseField(
			dataType=DataType.STRING,
			width=5)
    private String ACTION ;

	@DatabaseField(
			dataType=DataType.STRING,
			width=15)
    private String NEXTFOLLOWUP ;
	
	@DatabaseField(
			dataType=DataType.STRING,
			width=5)
    private String PARENTID ;
	
	@DatabaseField(
			dataType=DataType.STRING,
			width=1)
    private String ISEDITABLE ;
	@DatabaseField(
			dataType=DataType.STRING,
			width=25)
    private String PROSPEKID ;
	@DatabaseField(
			dataType=DataType.STRING,
			width=3)
    private String ISPENDINGUPDATEDTOSERVER ;

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

	public boolean getISEDITABLE() {
		return ISEDITABLE.equalsIgnoreCase("1")?true:false;
	}

	public void setISEDITABLE(boolean iSEDITABLE) {
		ISEDITABLE = iSEDITABLE?"1":"0";
	}

	public String getACTION() {
		return ACTION;
	}

	public void setACTION(String aCTION) {
		ACTION = aCTION;
	}

	public Date getNEXTFOLLOWUP() {
		return DataConverter.stringToDateTime(NEXTFOLLOWUP);
	}

	public void setNEXTFOLLOWUP(Date nEXTFOLLOWUP) {
		NEXTFOLLOWUP = DataConverter.dateTimeToString(nEXTFOLLOWUP);
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
	public boolean getISPENDINGUPDATEDTOSERVER() {
		return ISPENDINGUPDATEDTOSERVER.equalsIgnoreCase("1")?true:false;
	}

	public void setISPENDINGUPDATEDTOSERVER(boolean iSPENDINGUPDATEDTOSERVER) {
		ISPENDINGUPDATEDTOSERVER = iSPENDINGUPDATEDTOSERVER?"1":"0";
	}
}
