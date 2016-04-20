package com.mobile.database.app.entities;

import java.util.Date;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="ATTACHMENT")
public class ATTACHMENT {
	@DatabaseField(id=true,unique=true,canBeNull=false,uniqueIndexName="ATTACHMENT_PK",dataType=DataType.STRING,width=300) private String ID;
	@DatabaseField(dataType=DataType.STRING,width=548) private String AP_REGNO;
	@DatabaseField(dataType=DataType.STRING,width=549) private String ATTACH_ID;
	@DatabaseField(dataType=DataType.STRING,width=550) private String ATTACH_SEQ;
	@DatabaseField(dataType=DataType.STRING,width=551) private String FILEFOLDER;
	@DatabaseField(dataType=DataType.STRING,width=552) private String FILENAME;
	@DatabaseField(dataType=DataType.STRING,width=553) private String FILETYPE;
	@DatabaseField(dataType=DataType.STRING,width=554) private String FILESIZE;
	@DatabaseField(dataType=DataType.STRING,width=555) private String UPLOADBY;
	@DatabaseField(dataType=DataType.STRING,width=556) private String UPLOADDATE;
	@DatabaseField(dataType=DataType.STRING,width=557) private String ATTACH_TYPE;
	@DatabaseField(dataType=DataType.STRING,width=558) private String ATTACH_TYPE_CODE;
	@DatabaseField(dataType=DataType.STRING,width=558) private String COL_ID;
	@DatabaseField(dataType=DataType.STRING,width=558) private String ISALREADYUPLOADEDTOSERVER;
	@DatabaseField(dataType=DataType.STRING,width=558) private String ISALREADYDOWNLOD;
	
	
	public String getISALREADYDOWNLOD() {
		return ISALREADYDOWNLOD;
	}
	public void setISALREADYDOWNLOD(String iSALREADYDOWNLOD) {
		ISALREADYDOWNLOD = iSALREADYDOWNLOD;
	}
	public String getISALREADYUPLOADEDTOSERVER() {
		return ISALREADYUPLOADEDTOSERVER;
	}
	public void setISALREADYUPLOADEDTOSERVER(String iSALREADYUPLOADEDTOSERVER) {
		ISALREADYUPLOADEDTOSERVER = iSALREADYUPLOADEDTOSERVER;
	}
	public String getCOL_ID() {
		return COL_ID;
	}
	public void setCOL_ID(String cOL_ID) {
		COL_ID = cOL_ID;
	}
	public String getATTACH_TYPE() {
		return ATTACH_TYPE;
	}
	public void setATTACH_TYPE(String aTTACH_TYPE) {
		ATTACH_TYPE = aTTACH_TYPE;
	}
	public String getATTACH_TYPE_CODE() {
		return ATTACH_TYPE_CODE;
	}
	public void setATTACH_TYPE_CODE(String aTTACH_TYPE_CODE) {
		ATTACH_TYPE_CODE = aTTACH_TYPE_CODE;
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
	public String getATTACH_ID() {
		return ATTACH_ID;
	}
	public void setATTACH_ID(String aTTACH_ID) {
		ATTACH_ID = aTTACH_ID;
	}
	public String getATTACH_SEQ() {
		return ATTACH_SEQ;
	}
	public void setATTACH_SEQ(String aTTACH_SEQ) {
		ATTACH_SEQ = aTTACH_SEQ;
	}
	public String getFILEFOLDER() {
		return FILEFOLDER;
	}
	public void setFILEFOLDER(String fILEFOLDER) {
		FILEFOLDER = fILEFOLDER;
	}
	public String getFILENAME() {
		return FILENAME;
	}
	public void setFILENAME(String fILENAME) {
		FILENAME = fILENAME;
	}
	public String getFILETYPE() {
		return FILETYPE;
	}
	public void setFILETYPE(String fILETYPE) {
		FILETYPE = fILETYPE;
	}
	public String getFILESIZE() {
		return FILESIZE;
	}
	public void setFILESIZE(String fILESIZE) {
		FILESIZE = fILESIZE;
	}
	public String getUPLOADBY() {
		return UPLOADBY;
	}
	public void setUPLOADBY(String uPLOADBY) {
		UPLOADBY = uPLOADBY;
	}
	public Date getUPLOADDATE() {
		return DataConverter.stringToDateTime(UPLOADDATE);
	}
	public void setUPLOADDATE(Date uPLOADDATE) {
		UPLOADDATE =  DataConverter.dateTimeToString(uPLOADDATE);
	}

}
