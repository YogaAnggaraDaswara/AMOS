package com.mobile.database.app.entities;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="TABUNGAN")
public class TABUNGAN {
	@DatabaseField(
			id=true, 
			unique=true,
			canBeNull=false,
			uniqueIndexName="TABUNGAN_PK",
			dataType=DataType.STRING,
			width=20)		
    private String NOMORREKENING;
	
	@DatabaseField(
			dataType=DataType.STRING,
			width=20)
    private String NAMADEBITUR;
	
	@DatabaseField(
			dataType=DataType.STRING,
			width=50)
    private String ALAMAT;
	
	@DatabaseField(
			dataType=DataType.STRING,
			width=20)
    private String JENISTABUNGAN;
	
	@DatabaseField(
			dataType=DataType.STRING,
			width=25)
    private String NOMORTABUNGAN;
	
	@DatabaseField(
			dataType=DataType.STRING,
			width=40)
    private String NAMATABUNGAN;
	
	@DatabaseField(
			dataType=DataType.STRING,
			width=40)
    private String CIF;
	@DatabaseField(
			dataType=DataType.STRING,
			width=25)
   
	private String NOHANDPHONE;
	private String NOHANDPHONE1;
	public String getNOHANDPHONE() {
		return NOHANDPHONE;
	}

	public void setNOHANDPHONE(String nOHANDPHONE) {
		NOHANDPHONE = nOHANDPHONE;
	}
	public String getNOHANDPHONE1() {
		return NOHANDPHONE1;
	}

	public void setNOHANDPHONE1(String nOHANDPHONE1) {
		NOHANDPHONE1 = nOHANDPHONE1;
	}
	public String getNOMORREKENING() {
		return NOMORREKENING;
	}

	public void setNOMORREKENING(String nOMORREKENING) {
		NOMORREKENING = nOMORREKENING;
	}

	public String getNAMADEBITUR() {
		return NAMADEBITUR;
	}

	public void setNAMADEBITUR(String nAMADEBITUR) {
		NAMADEBITUR = nAMADEBITUR;
	}

	public String getALAMAT() {
		return ALAMAT;
	}

	public void setALAMAT(String aLAMAT) {
		ALAMAT = aLAMAT;
	}

	public String getJENISTABUNGAN() {
		return JENISTABUNGAN;
	}

	public void setJENISTABUNGAN(String jENISTABUNGAN) {
		JENISTABUNGAN = jENISTABUNGAN;
	}

	public String getNOMORTABUNGAN() {
		return NOMORTABUNGAN;
	}

	public void setNOMORTABUNGAN(String nOMORTABUNGAN) {
		NOMORTABUNGAN = nOMORTABUNGAN;
	}

	public String getNAMATABUNGAN() {
		return NAMATABUNGAN;
	}

	public void setNAMATABUNGAN(String nAMATABUNGAN) {
		NAMATABUNGAN = nAMATABUNGAN;
	}

	public String getCIF() {
		return CIF;
	}

	public void setCIF(String cIF) {
		CIF = cIF;
	}
}
