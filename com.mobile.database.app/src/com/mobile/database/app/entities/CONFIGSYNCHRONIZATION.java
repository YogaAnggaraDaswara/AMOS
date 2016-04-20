package com.mobile.database.app.entities;

import java.util.Date;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="CONFIGSYNCHRONIZATION")
public class CONFIGSYNCHRONIZATION {
	@DatabaseField(
			id=true, 
			unique=true,
			canBeNull=false,
			uniqueIndexName="CONFIGSYNCHRONIZATION_PK",
			dataType=DataType.STRING,
			width=10)		
    private String ID;
	@DatabaseField(
			dataType=DataType.STRING,
			width=15)
    private String LASTSYNCHRONIZELOV;
	@DatabaseField(
			dataType=DataType.STRING,
			width=15)
    private String LASTSYNCHRONIZETABUNGAN;
	@DatabaseField(
			dataType=DataType.STRING,
			width=15)
    private String LASTSYNCHRONIZETAGIHAN;
	@DatabaseField(
			dataType=DataType.STRING,
			width=15)
    private String LASTSYNCHRONIZEMESSAGE;
	@DatabaseField(
			dataType=DataType.STRING,
			width=15)
    private String LASTSYNCHRONIZENEWS;
	@DatabaseField(
			dataType=DataType.STRING,
			width=15)
    private String LASTSYNCHRONIZESCHEDULE;
	@DatabaseField(
			dataType=DataType.STRING,
			width=15)
    private String LASTSYNCHRONIZEBLACKBOX;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public Date getLASTSYNCHRONIZELOV() {
		return DataConverter.stringToDateTime(LASTSYNCHRONIZELOV);	
	}
	public void setLASTSYNCHRONIZELOV(Date lASTSYNCHRONIZELOV) {
		LASTSYNCHRONIZELOV = DataConverter.dateTimeToString(lASTSYNCHRONIZELOV);
	}
	public Date getLASTSYNCHRONIZETABUNGAN() {
		return DataConverter.stringToDateTime(LASTSYNCHRONIZETABUNGAN);
	}
	public void setLASTSYNCHRONIZETABUNGAN(Date lASTSYNCHRONIZETABUNGAN) {
		LASTSYNCHRONIZETABUNGAN = DataConverter.dateTimeToString(lASTSYNCHRONIZETABUNGAN);
	}
	public Date getLASTSYNCHRONIZETAGIHAN() {
		return DataConverter.stringToDateTime(LASTSYNCHRONIZETAGIHAN);
	}
	public void setLASTSYNCHRONIZETAGIHAN(Date lASTSYNCHRONIZETAGIHAN) {
		LASTSYNCHRONIZETAGIHAN = DataConverter.dateTimeToString(lASTSYNCHRONIZETAGIHAN);
	}
	public Date getLASTSYNCHRONIZEMESSAGE() {
		return DataConverter.stringToDateTime(LASTSYNCHRONIZEMESSAGE);
	}
	public void setLASTSYNCHRONIZEMESSAGE(Date lASTSYNCHRONIZEMESSAGE) {
		LASTSYNCHRONIZEMESSAGE = DataConverter.dateTimeToString(lASTSYNCHRONIZEMESSAGE);
	}
	public Date getLASTSYNCHRONIZENEWS() {
		return DataConverter.stringToDateTime(LASTSYNCHRONIZENEWS);
	}
	public void setLASTSYNCHRONIZENEWS(Date lASTSYNCHRONIZENEWS) {
		LASTSYNCHRONIZENEWS = DataConverter.dateTimeToString(lASTSYNCHRONIZENEWS);
	}
	public Date getLASTSYNCHRONIZESCHEDULE() {
		return DataConverter.stringToDateTime(LASTSYNCHRONIZESCHEDULE);
	}
	public void setLASTSYNCHRONIZESCHEDULE(Date lASTSYNCHRONIZESCHEDULE) {
		LASTSYNCHRONIZESCHEDULE = DataConverter.dateTimeToString(lASTSYNCHRONIZESCHEDULE);
	}

	public Date getLASTSYNCHRONIZEBLACKBOX() {
		return DataConverter.stringToDateTime(LASTSYNCHRONIZEBLACKBOX);
	}
	public void setLASTSYNCHRONIZEBLACKBOX(Date lASTSYNCHRONIZEBLACKBOX) {
		LASTSYNCHRONIZEBLACKBOX = DataConverter.dateTimeToString(lASTSYNCHRONIZEBLACKBOX);
	}
}
