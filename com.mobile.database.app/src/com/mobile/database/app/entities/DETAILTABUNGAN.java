package com.mobile.database.app.entities;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="DETAILTABUNGAN")
public class DETAILTABUNGAN {
	@DatabaseField(
			id=true, 
			unique=true,
			canBeNull=false,
			uniqueIndexName="DETAILTABUNGAN_PK",
			dataType=DataType.STRING,
			width=25)		
    private String NOTABUNGAN;
	@DatabaseField(
			dataType=DataType.STRING,
			width=25)
    private String CIF;
	@DatabaseField(
			dataType=DataType.STRING,
			width=40)
    private String NAMA;
	public String getCIF() {
		return CIF;
	}
	public void setCIF(String cIF) {
		CIF = cIF;
	}
	public String getNOTABUNGAN() {
		return NOTABUNGAN;
	}
	public void setNOTABUNGAN(String nOTABUNGAN) {
		NOTABUNGAN = nOTABUNGAN;
	}
	public String getNAMA() {
		return NAMA;
	}
	public void setNAMA(String nAMA) {
		NAMA = nAMA;
	}
}
