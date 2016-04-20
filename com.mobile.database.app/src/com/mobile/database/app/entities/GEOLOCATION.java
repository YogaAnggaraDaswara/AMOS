package com.mobile.database.app.entities;

import java.util.Date;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="GEOLOCATION")
public class GEOLOCATION {
	@DatabaseField(
			id=true, 
			unique=true,
			canBeNull=false,
			uniqueIndexName="GEOLOCATION_PK",
			dataType=DataType.STRING,
			width=20)		
    private String ID;
	@DatabaseField(
			dataType=DataType.STRING,
			width=80)
    private String LATITUDE;
	@DatabaseField(
			dataType=DataType.STRING,
			width=80)
    private String LONGITUDE;
	@DatabaseField(
			dataType=DataType.STRING,
			width=15)
    private String DATE;
	@DatabaseField(
			dataType=DataType.STRING,
			width=50)
    private String IMEI;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getLATITUDE() {
		return LATITUDE;
	}
	public void setLATITUDE(String lATITUDE) {
		LATITUDE = lATITUDE;
	}
	public String getLONGITUDE() {
		return LONGITUDE;
	}
	public void setLONGITUDE(String lONGITUDE) {
		LONGITUDE = lONGITUDE;
	}
	public Date getDATE() {
		return DataConverter.stringToDateTime(DATE);
	}
	public void setDATE(Date dATE) {
		DATE = DataConverter.dateTimeToString(dATE);
	}
	public String getIMEI() {
		return IMEI;
	}
	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}
}
