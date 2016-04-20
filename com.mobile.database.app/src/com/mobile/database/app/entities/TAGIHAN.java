package com.mobile.database.app.entities;

import java.util.Date;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="TAGIHAN")
public class TAGIHAN {
	@DatabaseField(
			id=true, 
			unique=true,
			canBeNull=false,
			uniqueIndexName="TAGIHAN_PK",
			dataType=DataType.STRING,
			width=20)		
    private String ID;
	@DatabaseField(
			dataType=DataType.STRING,
			width=2)
    private String NOMORREKENING;
	@DatabaseField(
			dataType=DataType.STRING,
			width=15)
    private String NAMADEBITUR;
	@DatabaseField(
			dataType=DataType.STRING,
			width=50)
    private String ALAMAT;
	@DatabaseField(
			dataType=DataType.STRING,
			width=20)
    private String JENISPINJAMAN;
	@DatabaseField(
			dataType=DataType.STRING,
			width=20)
    private String TENOR;
	@DatabaseField(
			dataType=DataType.STRING,
			width=15)
    private String TANGGALCAIR;
	@DatabaseField(
			dataType=DataType.STRING,
			width=15)
    private String POKOKPINJAMAN;
	@DatabaseField(
			dataType=DataType.STRING,
			width=15)
    private String BUNGAPINJAMAN;
	@DatabaseField(
			dataType=DataType.STRING,
			width=15)
    private String TOTALPINJAMAN;
	@DatabaseField(
			dataType=DataType.STRING,
			width=15)
    private String TOTALCICILAN;
	@DatabaseField(
			dataType=DataType.STRING,
			width=15)
    private String SISAPINJAMAN;
	@DatabaseField(
			dataType=DataType.STRING,
			width=15)
    private String TAGIHAN;	
	@DatabaseField(
			dataType=DataType.STRING,
			width=15)
    private String SISATAGIHAN;

	@DatabaseField(
			dataType=DataType.STRING,
			width=25)
    private String NOMORTABUNGAN;
	@DatabaseField(
			dataType=DataType.STRING,
			width=25)
    private String NOHANDPHONE;
	
	
	public String getHANDPHONE() {
		return NOHANDPHONE;
	}
	public void setHANDPHONE(String hANDPHONE) {
		NOHANDPHONE = hANDPHONE;
	}
	public void setTANGGALCAIR(String tANGGALCAIR) {
		TANGGALCAIR = tANGGALCAIR;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
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
	public String getJENISPINJAMAN() {
		return JENISPINJAMAN;
	}
	public void setJENISPINJAMAN(String jENISPINJAMAN) {
		JENISPINJAMAN = jENISPINJAMAN;
	}
	public String getPOKOKPINJAMAN() {
		return POKOKPINJAMAN;
	}
	public void setPOKOKPINJAMAN(String pOKOKPINJAMAN) {
		POKOKPINJAMAN = pOKOKPINJAMAN;
	}
	public String getTOTALPINJAMAN() {
		return TOTALPINJAMAN;
	}
	public void setTOTALPINJAMAN(String tOTALPINJAMAN) {
		TOTALPINJAMAN = tOTALPINJAMAN;
	}
	public String getTOTALCICILAN() {
		return TOTALCICILAN;
	}
	public void setTOTALCICILAN(String tOTALCICILAN) {
		TOTALCICILAN = tOTALCICILAN;
	}
	public String getSISAPINJAMAN() {
		return SISAPINJAMAN;
	}
	public void setSISAPINJAMAN(String sISAPINJAMAN) {
		SISAPINJAMAN = sISAPINJAMAN;
	}
	public String getTAGIHAN() {
		return TAGIHAN;
	}
	public void setTAGIHAN(String tAGIHAN) {
		TAGIHAN = tAGIHAN;
	}
	public String getBUNGAPINJAMAN() {
		return BUNGAPINJAMAN;
	}
	public void setBUNGAPINJAMAN(String bUNGAPINJAMAN) {
		BUNGAPINJAMAN = bUNGAPINJAMAN;
	}
	
	public void setTANGGALCAIR(Date tANGGALCAIR) {
		TANGGALCAIR = DataConverter.dateTimeToString(tANGGALCAIR);
	}
	public Date getTANGGALCAIR() {
		return DataConverter.stringToDateTime(TANGGALCAIR);
	}
	public String getTENOR() {
		return TENOR;
	}
	public void setTENOR(String tENOR) {
		TENOR = tENOR;
	}
	public String getSISATAGIHAN() {
		return SISATAGIHAN;
	}
	public void setSISATAGIHAN(String sISATAGIHAN) {
		SISATAGIHAN = sISATAGIHAN;
	}
	public String getNOMORTABUNGAN() {
		return NOMORTABUNGAN;
	}
	public void setNOMORTABUNGAN(String nOMORTABUNGAN) {
		NOMORTABUNGAN = nOMORTABUNGAN;
	}
}
