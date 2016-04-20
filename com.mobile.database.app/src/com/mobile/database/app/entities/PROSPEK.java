package com.mobile.database.app.entities;

import java.util.Date;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="PROSPEK")
public class PROSPEK {
	@DatabaseField(
			id=true, 
			unique=true,
			canBeNull=false,
			uniqueIndexName="PROSPEK_PK",
			dataType=DataType.STRING,
			width=40)		
    private String ID;
	@DatabaseField(
			dataType=DataType.STRING,
			width=25)
    private String PROSPEKID;
	@DatabaseField(
			dataType=DataType.STRING,
			width=20)
    private String USERID;
	
	@DatabaseField(
			dataType=DataType.STRING,
			width=30)
    private String LATITUDE;
	
	@DatabaseField(
			dataType=DataType.STRING,
			width=30)
    private String LONGITUDE;
	@DatabaseField(
			dataType=DataType.STRING,
			width=15)
    private String DATE;
	@DatabaseField(
			dataType=DataType.STRING,
			width=15)
    private String TIME ;	
	@DatabaseField(
			dataType=DataType.STRING,
			width=50)
    private String NAMAUSAHA ;	
	@DatabaseField(
			dataType=DataType.STRING,
			width=100)
    private String ALAMATUSAHA ;	
	@DatabaseField(
			dataType=DataType.STRING,
			width=2)
    private String JENISUSAHA ;
	@DatabaseField(
			dataType=DataType.STRING,
			width=2)
    private String RADIUS ;
	@DatabaseField(
			dataType=DataType.STRING,
			width=2)
    private String KOMUNITAS ;
	@DatabaseField(
			dataType=DataType.STRING,
			width=20)
    private String NAMADEBITUR;	
	@DatabaseField(
			dataType=DataType.STRING,
			width=15)
    private String TGLLAHIR;
	@DatabaseField(
			dataType=DataType.STRING,
			width=10)
    private String JENISPEMBIAYAAN;	
	@DatabaseField(
			dataType=DataType.STRING,
			width=20)
    private String HANDPHONE;
	@DatabaseField(
			dataType=DataType.STRING,
			width=100)
    private String FOTOLOKASI ;	
	@DatabaseField(
			dataType=DataType.STRING,
			width=20)
    private String TELEPONRUMAH;	
	@DatabaseField(
			dataType=DataType.STRING,
			width=20)
    private String ALAMATRUMAH;
	@DatabaseField(
			dataType=DataType.STRING,
			width=20)
    private String PLAFOND;	
	@DatabaseField(
			dataType=DataType.STRING,
			width=25)
    private String KTP;	
	@DatabaseField(
			dataType=DataType.STRING,
			width=25)
    private String NPWP;
	
	@DatabaseField(
			dataType=DataType.STRING,
			width=25)
    private String SIUPSKU;
	
	@DatabaseField(
			dataType=DataType.STRING,
			width=25)
    private String APREQNO;
	@DatabaseField(
			dataType=DataType.STRING,
			width=15)
    private String SUBMITDATE;
	@DatabaseField(
			dataType=DataType.STRING,
			width=1)
    private String STAGE;
	@DatabaseField(
			dataType=DataType.STRING,
			width=3)
    private String ISBLACKBOX ;
	@DatabaseField(
			dataType=DataType.STRING,
			width=3)
    private String ISPENDINGUPLOADED ;
	@DatabaseField(
			dataType=DataType.STRING,
			width=3)
    private String ISPENDINGUPDATEDTOSERVER ;
	@DatabaseField(
			dataType=DataType.STRING,
			width=1)
    private String ISBLACKBOXFROMSERVER ;
	@DatabaseField(
			dataType=DataType.STRING,
			width=20)
    private String UNIT ;
	@DatabaseField(
			dataType=DataType.STRING,
			width=1)
    private String PREVIOUSSTAGE;
	@DatabaseField(
			dataType=DataType.STRING,
			width=3)
    private String ISCHECKED ;
	@DatabaseField(
			dataType=DataType.STRING,
			width=1)
    private String REQUESTID;
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getUSERID() {
		return USERID;
	}

	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}

	public String getLATITUDE() {
		return LATITUDE;
	}

	public String getLONGITUDE() {
		return LONGITUDE;
	}

	public void setLATITUDE(String lATITUDE) {
		LATITUDE = lATITUDE;
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

	public String getTIME() {
		return TIME;
	}

	public void setTIME(String tIME) {
		TIME = tIME;
	}

	public String getNAMAUSAHA() {
		return NAMAUSAHA;
	}

	public void setNAMAUSAHA(String nAMAUSAHA) {
		NAMAUSAHA = nAMAUSAHA;
	}

	public String getALAMATUSAHA() {
		return ALAMATUSAHA;
	}

	public void setALAMATUSAHA(String aLAMATUSAHA) {
		ALAMATUSAHA = aLAMATUSAHA;
	}

	public String getJENISUSAHA() {
		return JENISUSAHA;
	}

	public void setJENISUSAHA(String jENISUSAHA) {
		JENISUSAHA = jENISUSAHA;
	}

	public String getRADIUS() {
		return RADIUS;
	}

	public void setRADIUS(String rADIUS) {
		RADIUS = rADIUS;
	}

	public String getKOMUNITAS() {
		return KOMUNITAS;
	}

	public void setKOMUNITAS(String kOMUNITAS) {
		KOMUNITAS = kOMUNITAS;
	}
	
	public String getNAMADEBITUR() {
		return NAMADEBITUR;
	}

	public void setNAMADEBITUR(String nAMADEBITUR) {
		NAMADEBITUR = nAMADEBITUR;
	}	
	public Date getTGLLAHIR() {
		return DataConverter.stringToDateTime(TGLLAHIR);
	}

	public void setTGLLAHIR(Date tGLLAHIR) {
		TGLLAHIR = DataConverter.dateTimeToString(tGLLAHIR);
	}


	public String getJENISPEMBIAYAAN() {
		return JENISPEMBIAYAAN;
	}

	public void setJENISPEMBIAYAAN(String jENISPEMBIAYAAN) {
		JENISPEMBIAYAAN = jENISPEMBIAYAAN;
	}

	public String getHANDPHONE() {
		return HANDPHONE;
	}

	public void setHANDPHONE(String hANDPHONE) {
		HANDPHONE = hANDPHONE;
	}

	public String getFOTOLOKASI() {
		return FOTOLOKASI;
	}

	public void setFOTOLOKASI(String fOTOLOKASI) {
		FOTOLOKASI = fOTOLOKASI;
	}

	public String getTELEPONRUMAH() {
		return TELEPONRUMAH;
	}

	public void setTELEPONRUMAH(String tELEPONRUMAH) {
		TELEPONRUMAH = tELEPONRUMAH;
	}

	public String getALAMATRUMAH() {
		return ALAMATRUMAH;
	}

	public void setALAMATRUMAH(String aLAMATRUMAH) {
		ALAMATRUMAH = aLAMATRUMAH;
	}

	public String getPLAFOND() {
		return PLAFOND;
	}

	public void setPLAFOND(String pLAFOND) {
		PLAFOND = pLAFOND;
	}

	public String getKTP() {
		return KTP;
	}

	public void setKTP(String kTP) {
		KTP = kTP;
	}

	public String getNPWP() {
		return NPWP;
	}

	public void setNPWP(String nPWP) {
		NPWP = nPWP;
	}

	public String getSIUPSKU() {
		return SIUPSKU;
	}

	public void setSIUPSKU(String sIUPSKU) {
		SIUPSKU = sIUPSKU;
	}

	public String getAPREQNO() {
		return APREQNO;
	}

	public void setAPREQNO(String aPREQNO) {
		APREQNO = aPREQNO;
	}

	public Date getSUBMITDATE() {
		return DataConverter.stringToDateTime(SUBMITDATE);
	}

	public void setSUBMITDATE(Date sUBMITDATE) {
		SUBMITDATE = DataConverter.dateTimeToString(sUBMITDATE);
	}

	public String getSTAGE() {
		return STAGE;
	}

	public void setSTAGE(String sTAGE) {
		STAGE = sTAGE;
	}

	public boolean getISBLACKBOX() {
		return ISBLACKBOX.equalsIgnoreCase("1")?true:false;
	}

	public void setISBLACKBOX(boolean iSBLACKBOX) {
		ISBLACKBOX = iSBLACKBOX?"1":"0";
	}

	public boolean getISPENDINGUPLOADED() {
		return ISPENDINGUPLOADED.equalsIgnoreCase("1")?true:false;
	}

	public void setISPENDINGUPLOADED(boolean iSPENDINGUPLOADED) {
		ISPENDINGUPLOADED = iSPENDINGUPLOADED?"1":"0";
	}

	public boolean getISBLACKBOXFROMSERVER() {
		return ISBLACKBOXFROMSERVER.equalsIgnoreCase("1")?true:false;
	}

	public void setISBLACKBOXFROMSERVER(boolean iSBLACKBOXFROMSERVER) {
		ISBLACKBOXFROMSERVER = iSBLACKBOXFROMSERVER?"1":"0";
	}

	public String getPROSPEKID() {
		return PROSPEKID;
	}

	public void setPROSPEKID(String pROSPEKID) {
		PROSPEKID = pROSPEKID;
	}

	public String getUNIT() {
		return UNIT;
	}

	public void setUNIT(String uNIT) {
		UNIT = uNIT;
	}

	public String getPREVIOUSSTAGE() {
		return PREVIOUSSTAGE;
	}

	public void setPREVIOUSSTAGE(String pREVIOUSCURRENTSTAGE) {
		PREVIOUSSTAGE = pREVIOUSCURRENTSTAGE;
	}

	public String getREQUESTID() {
		return REQUESTID;
	}

	public void setREQUESTID(String rEQUESTID) {
		REQUESTID = rEQUESTID;
	}
	public boolean getISCHECKED() {
		return ISCHECKED.equalsIgnoreCase("1")?true:false;
	}

	public void setISCHECKED(boolean iSCHECKED) {
		ISCHECKED = iSCHECKED?"1":"0";
	}

	public boolean getISPENDINGUPDATEDTOSERVER() {
		return ISPENDINGUPDATEDTOSERVER.equalsIgnoreCase("1")?true:false;
	}

	public void setISPENDINGUPDATEDTOSERVER(boolean iSPENDINGUPDATEDTOSERVER) {
		ISPENDINGUPDATEDTOSERVER = iSPENDINGUPDATEDTOSERVER?"1":"0";
	}
}
