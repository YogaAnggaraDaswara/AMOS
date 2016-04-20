package com.mobile.database.app.entities;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="USER")
public class USER {
	@DatabaseField(
		id=true, 
		unique=true,
		canBeNull=false,
		uniqueIndexName="USER_PK",
		dataType=DataType.STRING,
		width=20)	
	private String USERID;
	@DatabaseField(
			dataType=DataType.STRING,
			width=50)
	private String NAME;
	@DatabaseField(
			dataType=DataType.STRING,
			width=20)
	private String PASSWORD;
	@DatabaseField(
		dataType=DataType.STRING,
		width=5)
	private String POSITION;
	@DatabaseField(
			dataType=DataType.STRING,
			width=30)
		private String LOCATION;
	@DatabaseField(
			dataType=DataType.STRING,
			width=30)
		private String UNIT;
	
	
	public String getUSERID() {
		return USERID;
	}
	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getPOSITION() {
		return POSITION;
	}
	public void setPOSITION(String pOSITION) {
		POSITION = pOSITION;
	}
	public String getLOCATION() {
		return LOCATION;
	}
	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
	}
	public String getUNIT() {
		return UNIT;
	}
	public void setUNIT(String uNIT) {
		UNIT = uNIT;
	}
}
