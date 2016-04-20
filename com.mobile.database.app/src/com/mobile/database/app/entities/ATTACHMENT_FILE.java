package com.mobile.database.app.entities;

import java.util.Date;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="ATTACHMENT_FILE")
public class ATTACHMENT_FILE {
	@DatabaseField(id=true,unique=true,canBeNull=false,uniqueIndexName="ATTACHMENT_FILE_PK",dataType=DataType.STRING,width=100) private String ID;
	@DatabaseField(dataType=DataType.STRING,width=548) private String AP_REGNO;
	@DatabaseField(dataType=DataType.STRING,width=549) private String COL_ID;
	@DatabaseField(dataType=DataType.STRING,width=550) private String GENERATE_TYPE;
	@DatabaseField(dataType=DataType.STRING,width=551) private String GENERATE_TYPE_REFF;
	@DatabaseField(dataType=DataType.STRING,width=552) private String USERID;
	@DatabaseField(dataType=DataType.STRING,width=553) private String TOTAL_IMAGE;
	@DatabaseField(dataType=DataType.STRING,width=554) private String STATUS;
	@DatabaseField(dataType=DataType.STRING,width=555) private String FILENAME;
	@DatabaseField(dataType=DataType.STRING,width=555) private String ISDOWNLOAD;
	@DatabaseField(dataType=DataType.STRING,width=555) private String ISSTATUS;
	public String getISSTATUS() {
		return ISSTATUS;
	}
	public void setISSTATUS(String iSSTATUS) {
		ISSTATUS = iSSTATUS;
	}
	public String getFILENAME() {
		return FILENAME;
	}
	public void setFILENAME(String fILENAME) {
		FILENAME = fILENAME;
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
	public String getISDOWNLOAD() {
		return ISDOWNLOAD;
	}
	public void setISDOWNLOAD(String iSDOWNLOAD) {
		ISDOWNLOAD = iSDOWNLOAD;
	}

}
