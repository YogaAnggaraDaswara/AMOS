package com.mobile.database.app.entities;

import java.util.Date;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="LOGINHISTORY")
public class LOGINHISTORY {
	@DatabaseField( 
			generatedId=true)
	private Integer ID;
	@DatabaseField(
			dataType=DataType.STRING,
			width=20)
    private String USERID;
	@DatabaseField(
			dataType=DataType.STRING,
			width=20)
	private String PASSWORD;
	@DatabaseField(
			dataType=DataType.STRING,
			width=1)
	private String STATUS;
	@DatabaseField(
			dataType=DataType.STRING,
			width=70)
	private String DECSRIPTION;
	@DatabaseField(
			dataType=DataType.STRING,
			width=15)
    private String DATE;
	@DatabaseField(
			dataType=DataType.STRING,
			width=50)
    private String IMEI;
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getUSERID() {
		return USERID;
	}
	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getDECSRIPTION() {
		return DECSRIPTION;
	}
	public void setDECSRIPTION(String dECSRIPTION) {
		DECSRIPTION = dECSRIPTION;
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
