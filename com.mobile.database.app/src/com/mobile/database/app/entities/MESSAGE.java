package com.mobile.database.app.entities;

import java.util.Date;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="MESSAGE")
public class MESSAGE {
	@DatabaseField(
			id=true, 
			unique=true,
			canBeNull=false,
			uniqueIndexName="MESSAGE_PK",
			dataType=DataType.STRING,
			width=10)		
    private String ID;
	@DatabaseField(
			dataType=DataType.STRING,
			width=20)
    private String FROM;
	@DatabaseField(
			dataType=DataType.STRING,
			width=30)
    private String SUBJECT;
	@DatabaseField(
			dataType=DataType.STRING,
			width=200)
    private String MESSAGE;
	@DatabaseField(
			dataType=DataType.STRING,
			width=15)
    private String DATE;
	@DatabaseField(
			dataType=DataType.STRING,
			width=1)
    private String ISREAD;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getFROM() {
		return FROM;
	}
	public void setFROM(String fROM) {
		FROM = fROM;
	}
	public String getSUBJECT() {
		return SUBJECT;
	}
	public void setSUBJECT(String sUBJECT) {
		SUBJECT = sUBJECT;
	}
	public String getMESSAGE() {
		return MESSAGE;
	}
	public void setMESSAGE(String mESSAGE) {
		MESSAGE = mESSAGE;
	}
	public Date getDATE() {
		return DataConverter.stringToDateTime(DATE);
	}

	public void setDATE(Date dATE) {
		DATE = DataConverter.dateTimeToString(dATE);
	}
	public String getISREAD() {
		return ISREAD;
	}
	public void setISREAD(String iSREAD) {
		ISREAD = iSREAD;
	}
}
