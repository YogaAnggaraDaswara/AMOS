package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;
import com.mobile.database.app.entities.BLACKBOX;

public class Z_BlackboxData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4625139172873280188L;
	private Integer ID;
    private String USERID;		
    private String LATITUDE;
    private String LONGITUDE;
    private Date DATE;		
    private String TIME ;		
    private String NAMAUSAHA ;		
    private String ALAMATUSAHA ;		
    private String JENISUSAHA ;		
    private String RADIUS ;		
    private String KOMUNITAS ;
    private String NAMADEBITUR;
    private String TGLLAHIR;
    private String JENISPEMBIAYAAN;
    private String HANDPHONE;
    private String FOTOLOKASI ;
    private String TELEPONRUMAH;
    private String ALAMATRUMAH;
    private String PLAFOND;
    private String KTP;
    private String NPWP;
    private String SIUPSKU;
    private String APREQNO;
    private Date SUBMITDATE;
    private String STAGE;
    private boolean ISBLACKBOX ;
    private boolean ISUPLOADED ;
    
    public Z_BlackboxData() {
    	update("","","",null,"","","","","","","","","","","","","","","","","");
	}
    
    public Z_BlackboxData(BLACKBOX blackbox) {
		update(blackbox);
	}
	
    
    
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
		return DATE;
	}

	public void setDATE(Date dATE) {
		DATE = dATE;
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

	public String getTGLLAHIR() {
		return TGLLAHIR;
	}

	public void setTGLLAHIR(String tGLLAHIR) {
		TGLLAHIR = tGLLAHIR;
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
		return SUBMITDATE;
	}

	public void setSUBMITDATE(Date sUBMITDATE) {
		SUBMITDATE = sUBMITDATE;
	}

	public String getSTAGE() {
		return STAGE;
	}

	public void setSTAGE(String sTAGE) {
		STAGE = sTAGE;
	}

	public boolean isISBLACKBOX() {
		return ISBLACKBOX;
	}

	public void setISBLACKBOX(boolean iSBLACKBOX) {
		ISBLACKBOX = iSBLACKBOX;
	}

	public boolean isISUPLOADED() {
		return ISUPLOADED;
	}

	public void setISUPLOADED(boolean iSUPLOADED) {
		ISUPLOADED = iSUPLOADED;
	}

	public BLACKBOX toRowData(){
		BLACKBOX rowData= new BLACKBOX();
		rowData.setID(ID);
		rowData.setUSERID(USERID);
		rowData.setLATITUDE(LATITUDE);
		rowData.setLONGITUDE(LONGITUDE);
		rowData.setDATE(DATE);
		rowData.setTIME(TIME);
		rowData.setNAMAUSAHA(NAMAUSAHA);
		rowData.setALAMATUSAHA(ALAMATUSAHA);
		rowData.setJENISUSAHA(JENISUSAHA);
		rowData.setRADIUS(RADIUS);
		rowData.setKOMUNITAS(KOMUNITAS);
		rowData.setNAMADEBITUR(NAMADEBITUR);
		rowData.setTGLLAHIR(TGLLAHIR);
		rowData.setJENISPEMBIAYAAN(JENISPEMBIAYAAN);
		rowData.setHANDPHONE(HANDPHONE);
		rowData.setFOTOLOKASI(FOTOLOKASI);
		rowData.setTELEPONRUMAH(TELEPONRUMAH);
		rowData.setALAMATRUMAH(ALAMATRUMAH);
		rowData.setPLAFOND(PLAFOND);
		rowData.setKTP(KTP);
		rowData.setNPWP(NPWP);
		rowData.setSIUPSKU(SIUPSKU);		
		rowData.setISBLACKBOX(ISBLACKBOX);
		rowData.setISUPLOADED(ISUPLOADED);
		rowData.setSTAGE(STAGE);
		rowData.setAPREQNO(APREQNO);
		rowData.setSUBMITDATE(SUBMITDATE);
		
		return rowData;
	}
	
	public void update(BLACKBOX rowData) {
		ID = rowData.getID();
		USERID = rowData.getUSERID();
		LATITUDE = rowData.getLATITUDE();
		LONGITUDE = rowData.getLONGITUDE();
		DATE = rowData.getDATE();
		TIME=rowData.getTIME();
		NAMAUSAHA=rowData.getNAMAUSAHA();
		ALAMATUSAHA=rowData.getALAMATUSAHA();
		JENISUSAHA=rowData.getJENISUSAHA();
		RADIUS=rowData.getRADIUS();
		KOMUNITAS=rowData.getKOMUNITAS();
		NAMADEBITUR=rowData.getNAMADEBITUR();
	    TGLLAHIR=rowData.getTGLLAHIR();
	    JENISPEMBIAYAAN=rowData.getJENISPEMBIAYAAN();
	    HANDPHONE=rowData.getHANDPHONE();
	    FOTOLOKASI=rowData.getFOTOLOKASI();
	    TELEPONRUMAH=rowData.getTELEPONRUMAH();
	    ALAMATRUMAH=rowData.getALAMATRUMAH();
	    PLAFOND=rowData.getPLAFOND();
	    KTP=rowData.getKTP();
	    NPWP=rowData.getNPWP();
	    SIUPSKU=rowData.getSIUPSKU();	    
	    ISBLACKBOX=rowData.getISBLACKBOX();
	    ISUPLOADED=rowData.getISUPLOADED();
	    STAGE=rowData.getSTAGE();
	    APREQNO=rowData.getAPREQNO();
	    SUBMITDATE=rowData.getSUBMITDATE();
	}
	
	public void update(String userid,String latitude,String longitude,Date date,String time,String namausaha,String alamat,String jenisusaha,String radius,String komunitas, boolean isblackbox, boolean isuploaded, String stage, String apreqno, Date submitdate){
		USERID = userid;
		LATITUDE = latitude;
		LONGITUDE = longitude;
		DATE = date;
		TIME=time;
		NAMAUSAHA=namausaha;
		ALAMATUSAHA=alamat;
		JENISUSAHA=jenisusaha;
		RADIUS=radius;
		KOMUNITAS=komunitas;
		ISBLACKBOX=isblackbox;
		ISUPLOADED=isuploaded;
		STAGE=stage;
		APREQNO=apreqno;
		SUBMITDATE=submitdate;
	}
	
	public void update(String namaDebitur,String tglLahir,String jenisPembiayaan,String handphone,String fotoLokasi){
		NAMADEBITUR=namaDebitur;
	    TGLLAHIR=tglLahir;
	    JENISPEMBIAYAAN=jenisPembiayaan;
	    HANDPHONE=handphone;
	    FOTOLOKASI=fotoLokasi;
	}
	
	public void update(String namaDebitur,String tglLahir,String jenisPembiayaan,String handphone,String fotoLokasi,String teleponrumah,String alamatrumah,String plafon,String ktp,String npwp,String siupsku){
		NAMADEBITUR=namaDebitur;
	    TGLLAHIR=tglLahir;
	    JENISPEMBIAYAAN=jenisPembiayaan;
	    HANDPHONE=handphone;
	    FOTOLOKASI=fotoLokasi;	    
	    TELEPONRUMAH=teleponrumah;
	    ALAMATRUMAH=alamatrumah;
	    PLAFOND=plafon;
	    KTP=ktp;
	    NPWP=npwp;
	    SIUPSKU=siupsku;
	}
	
	public void update(String teleponrumah,String alamatrumah,String plafon,String ktp,String npwp,String siupsku){   
	    TELEPONRUMAH=teleponrumah;
	    ALAMATRUMAH=alamatrumah;
	    PLAFOND=plafon;
	    KTP=ktp;
	    NPWP=npwp;
	    SIUPSKU=siupsku;
	}
	
	public void update(String userid,String latitude,String longitude,Date date,String time,String namausaha,String alamat,String jenisusaha,String radius,String komunitas,String namaDebitur,String tglLahir,String jenisPembiayaan,String handphone,String fotoLokasi,String teleponrumah,String alamatrumah,String plafon,String ktp,String npwp,String siupsku){
		USERID = userid;
		LATITUDE = latitude;
		LONGITUDE = longitude;
		DATE = date;
		TIME=time;
		NAMAUSAHA=namausaha;
		ALAMATUSAHA=alamat;
		JENISUSAHA=jenisusaha;
		RADIUS=radius;
		KOMUNITAS=komunitas;
		NAMADEBITUR=namaDebitur;
	    TGLLAHIR=tglLahir;
	    JENISPEMBIAYAAN=jenisPembiayaan;
	    HANDPHONE=handphone;
	    FOTOLOKASI=fotoLokasi;	    
	    TELEPONRUMAH=teleponrumah;
	    ALAMATRUMAH=alamatrumah;
	    PLAFOND=plafon;
	    KTP=ktp;
	    NPWP=npwp;
	    SIUPSKU=siupsku;
	}
	
	public void updateDataToNullForKenalan(){
		NAMADEBITUR="";
	    TGLLAHIR="";
	    JENISPEMBIAYAAN="";
	    HANDPHONE="";
	    FOTOLOKASI="";
	}
	
	public void updateDataToNullForPendekatan(){
	    TELEPONRUMAH="";
	    ALAMATRUMAH="";
	    PLAFOND="";
	    KTP="";
	    NPWP="";
	    SIUPSKU="";
	}
	
	public void updateDataToNullForClosing(){

	}
}
