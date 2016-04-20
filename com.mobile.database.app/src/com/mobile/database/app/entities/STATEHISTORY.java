package com.mobile.database.app.entities;

import java.util.Date;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="STATEHISTORY")
public class STATEHISTORY {
	@DatabaseField( 
			generatedId=true)
	private Integer ID;
	@DatabaseField(
			dataType=DataType.STRING,
			width=15)
    private String PROSPEKID;
	@DatabaseField(
			dataType=DataType.STRING,
			width=15)
    private String STARTDATE;
	@DatabaseField(
			dataType=DataType.STRING,
			width=15)
    private String ENDDATE;
	@DatabaseField(
			dataType=DataType.STRING,
			width=1)
    private String STAGE;
	@DatabaseField(
			dataType=DataType.STRING,
			width=5)
    private String PROSPEKIDLOCAL;
	@DatabaseField(
			dataType=DataType.STRING,
			width=50)
    private String APPROVEDBY;
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getPROSPEKID() {
		return PROSPEKID;
	}
	public void setPROSPEKID(String pROSPEKID) {
		PROSPEKID = pROSPEKID;
	}
	public Date getSTARTDATE() {
		return DataConverter.stringToDateTime(STARTDATE);
	}
	public void setSTARTDATE(Date sTARTDATE) {
		STARTDATE = DataConverter.dateTimeToString(sTARTDATE);
	}
	public Date getENDDATE() {
		return DataConverter.stringToDateTime(ENDDATE);
	}
	public void setENDDATE(Date eNDDATE) {
		ENDDATE = DataConverter.dateTimeToString(eNDDATE);
	}
	public String getSTAGE() {
		return STAGE;
	}
	public void setSTAGE(String sTAGE) {
		STAGE = sTAGE;
	}
	public String getPROSPEKIDLOCAL() {
		return PROSPEKIDLOCAL;
	}
	public void setPROSPEKIDLOCAL(String pROSPEKIDLOCAL) {
		PROSPEKIDLOCAL = pROSPEKIDLOCAL;
	}
	public String getAPPROVEDBY() {
		return APPROVEDBY;
	}
	public void setAPPROVEDBY(String aPPROVEDBY) {
		APPROVEDBY = aPPROVEDBY;
	}
}
