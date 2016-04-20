package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;
import org.json.JSONObject;
import com.mobile.database.app.entities.PROSPEK;
import com.mobile.framework.common.DateFormatter;

public class ProspekData implements Serializable,Comparable<Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6267778678354410044L;
	private String ID;
	private String PROSPEKID;
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
    private Date TGLLAHIR;
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
    private boolean ISPENDINGUPLOADED ;
    private boolean ISBLACKBOXFROMSERVER ;
    private String UNIT;
    private String PREVIOUSSTAGE;
    private String REQUESTID;
    private boolean ISCHECKED;
    private boolean ISPENDINGUPDATEDTOSERVER;
    
    public ProspekData() {
    	update("","","",null,"","","","","","","",null,"","","","","","","","","");
	}
    
    public ProspekData(PROSPEK prospek) {
		update(prospek);
	}
	
    
    
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

	public Date getTGLLAHIR() {
		return TGLLAHIR;
	}

	public void setTGLLAHIR(Date tGLLAHIR) {
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

	public boolean isPENDINGUPLOADED() {
		return ISPENDINGUPLOADED;
	}

	public void setISPENDINGUPLOADED(boolean iSPENDINGUPLOADED) {
		ISPENDINGUPLOADED = iSPENDINGUPLOADED;
	}
	public boolean isISBLACKBOXFROMSERVER() {
		return ISBLACKBOXFROMSERVER;
	}

	public void setISBLACKBOXFROMSERVER(boolean iSBLACKBOXFROMSERVER) {
		ISBLACKBOXFROMSERVER = iSBLACKBOXFROMSERVER;
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
	public void setISCHECKED(boolean iSCHECKED) {
		ISCHECKED = iSCHECKED;
	}
	public boolean isISCHECKED() {
		return ISCHECKED;
	}
	public boolean isISPENDINGUPDATEDTOSERVER() {
		return ISPENDINGUPDATEDTOSERVER;
	}
	public void setISPENDINGUPDATEDTOSERVER(boolean iSPENDINGUPDATEDTOSERVER) {
		ISPENDINGUPDATEDTOSERVER = iSPENDINGUPDATEDTOSERVER;
	}

	public PROSPEK toRowData(){
		PROSPEK rowData= new PROSPEK();
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
		rowData.setISPENDINGUPLOADED(ISPENDINGUPLOADED);
		rowData.setSTAGE(STAGE);
		rowData.setAPREQNO(APREQNO);
		rowData.setSUBMITDATE(SUBMITDATE);
		rowData.setISBLACKBOXFROMSERVER(ISBLACKBOXFROMSERVER);
		rowData.setPROSPEKID(PROSPEKID);
		rowData.setUNIT(UNIT);
		rowData.setPREVIOUSSTAGE(PREVIOUSSTAGE);
		rowData.setREQUESTID(REQUESTID);
		rowData.setISCHECKED(ISCHECKED);
		rowData.setISPENDINGUPDATEDTOSERVER(ISPENDINGUPDATEDTOSERVER);
		
		return rowData;
	}
	
	public void update(PROSPEK rowData) {
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
	    ISPENDINGUPLOADED=rowData.getISPENDINGUPLOADED();
	    STAGE=rowData.getSTAGE();
	    APREQNO=rowData.getAPREQNO();
	    SUBMITDATE=rowData.getSUBMITDATE();
	    ISBLACKBOXFROMSERVER = rowData.getISBLACKBOXFROMSERVER();
	    PROSPEKID = rowData.getPROSPEKID();
	    UNIT = rowData.getUNIT();
	    PREVIOUSSTAGE = rowData.getPREVIOUSSTAGE();
	    REQUESTID = rowData.getREQUESTID();
	    ISCHECKED = rowData.getISCHECKED();
	    ISPENDINGUPDATEDTOSERVER = rowData.getISPENDINGUPDATEDTOSERVER();
	}
	
	public void update(String userid,String latitude,String longitude,Date date,String time,String namausaha,String alamat,String jenisusaha,String radius,String komunitas, boolean isblackbox, boolean ispendinguploaded, String stage, String prospekid, Date submitdate){
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
		ISPENDINGUPLOADED=ispendinguploaded;
		STAGE=stage;
		PROSPEKID=prospekid;
		SUBMITDATE=submitdate;
	}
	
	public void update(String namaDebitur,Date tglLahir,String jenisPembiayaan,String handphone,String fotoLokasi){
		NAMADEBITUR=namaDebitur;
	    TGLLAHIR=tglLahir;
	    JENISPEMBIAYAAN=jenisPembiayaan;
	    HANDPHONE=handphone;
	    FOTOLOKASI=fotoLokasi;
	}
	
	public void update(String namaDebitur,Date tglLahir,String jenisPembiayaan,String handphone,String fotoLokasi,String teleponrumah,String alamatrumah,String plafon,String ktp,String npwp,String siupsku){
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
	
	public void update(String userid,String latitude,String longitude,Date date,String time,String namausaha,String alamat,String jenisusaha,String radius,String komunitas,String namaDebitur,Date tglLahir,String jenisPembiayaan,String handphone,String fotoLokasi,String teleponrumah,String alamatrumah,String plafon,String ktp,String npwp,String siupsku){
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
	    TGLLAHIR=null;
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
	
	public void updateBlackboxFromJSON(JSONObject obj) throws Exception{
		USERID = obj.getString("USERID");		
		LATITUDE = obj.getString("LATITUDE");
		LONGITUDE = obj.getString("LONGITUDE");
		DATE = DateFormatter.formatDateYYYMMDD(obj.getString("DATE"));
		TIME= obj.getString("TIME");
		NAMAUSAHA= obj.getString("NAMAUSAHA");
		ALAMATUSAHA=obj.getString("ALAMATUSAHA");
		JENISUSAHA= obj.getString("JENISUSAHA");
		RADIUS=obj.getString("RADIUS");
		KOMUNITAS= obj.getString("KOMUNITAS");
		NAMADEBITUR= obj.getString("NAMADEBITUR");
	    TGLLAHIR= DateFormatter.formatDateYYYMMDD(obj.getString("TGLLAHIR"));
	    JENISPEMBIAYAAN= obj.getString("JENISPEMBIAYAAN");
	    HANDPHONE= obj.getString("HANDPHONE");
//	    FOTOLOKASI= obj.getString("FOTOLOKASI");
	    TELEPONRUMAH= obj.getString("TELEPONRUMAH");
	    ALAMATRUMAH= obj.getString("ALAMATRUMAH");
	    PLAFOND= obj.getString("PLAFOND");
	    KTP= obj.getString("KTP");
	    NPWP= obj.getString("NPWP");
	    SIUPSKU= obj.getString("SIUPSKU");	    
	    ISBLACKBOX= obj.getString("ISBLACKBOX").equalsIgnoreCase("1")?true:false;
	    ISPENDINGUPLOADED= obj.getString("ISUPLOADED").equalsIgnoreCase("1")?true:false;
	    STAGE= obj.getString("STAGE");
	    PROSPEKID = obj.getString("PROSPEKID");
	    SUBMITDATE= DateFormatter.formatDateYYYMMDD(obj.getString("SUBMITDATE"));
	    ISBLACKBOXFROMSERVER = true;
	    UNIT = obj.getString("UNIT");
	    REQUESTID = obj.getString("REQUESTID");
	    ISCHECKED = false;
	}

	@Override
	public int compareTo(Object o1) {
		 return this.getSTAGE().compareTo(((ProspekData) o1).getSTAGE());
	}
}
