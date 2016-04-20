package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

import com.mobile.database.app.entities.APPR_MAIN;
import com.mobile.database.app.entities.APPR_VHC_PEMBANDING_INT;
import com.mobile.database.app.entities.APPR_RTB_CEK_TATA_KOTA_INT;
import com.mobile.database.app.entities.APPR_RTB_VALUATION_INT;
import com.mobile.database.app.entities.BLACKBOX;

public class Datatype_Appr_Pb_Pembanding_Int implements Serializable {

	/**
	 * 
	 */
	public String COL_ID;
	public String AP_REGNO;
	public String SEQ;
	public String VHC_BRAND_CODE;
	public String VHC_CODE;
	public String YEAR_CREATED;
	public String COLOR_CODE;
	public String TRANSMISION;
	public String CONDITION;
	public String OFFER_PRICE;
	public String AFTER_ADJUSTMENT_PRICE;
	public String NARA_SUMBER;
	public String PHONE_NO;
	public String OFFER_TYPE;



	 public void updateMainFromJSON(JSONObject obj) throws Exception{
		 COL_ID=obj.getString("COL_ID");
		 AP_REGNO=obj.getString("AP_REGNO");
		 SEQ=obj.getString("SEQ");
		 VHC_BRAND_CODE=obj.getString("VHC_BRAND_CODE");
		 VHC_CODE=obj.getString("VHC_CODE");
		 YEAR_CREATED=obj.getString("YEAR_CREATED");
		 COLOR_CODE=obj.getString("COLOR_CODE");
		 TRANSMISION=obj.getString("TRANSMISION");
		 CONDITION=obj.getString("CONDITION");
		 OFFER_PRICE=obj.getString("OFFER_PRICE");
		 AFTER_ADJUSTMENT_PRICE=obj.getString("AFTER_ADJUSTMENT_PRICE");
		 NARA_SUMBER=obj.getString("NARA_SUMBER");
		 PHONE_NO=obj.getString("PHONE_NO");
		 OFFER_TYPE=obj.getString("OFFER_TYPE");

	 }
   
    
	 public Datatype_Appr_Pb_Pembanding_Int() {
	    	update("","","",null,"","","","","","","","","","","","","","","","","");
		}
	    
	 public Datatype_Appr_Pb_Pembanding_Int(APPR_VHC_PEMBANDING_INT Data) {
			update(Data);
	}
		

	


	public String getCOL_ID() {
		return COL_ID;
	}

	public void setCOL_ID(String cOL_ID) {
		COL_ID = cOL_ID;
	}

	public String getAP_REGNO() {
		return AP_REGNO;
	}

	public void setAP_REGNO(String aP_REGNO) {
		AP_REGNO = aP_REGNO;
	}

	public String getSEQ() {
		return SEQ;
	}

	public void setSEQ(String sEQ) {
		SEQ = sEQ;
	}

	public String getVHC_BRAND_CODE() {
		return VHC_BRAND_CODE;
	}

	public void setVHC_BRAND_CODE(String vHC_BRAND_CODE) {
		VHC_BRAND_CODE = vHC_BRAND_CODE;
	}

	public String getVHC_CODE() {
		return VHC_CODE;
	}

	public void setVHC_CODE(String vHC_CODE) {
		VHC_CODE = vHC_CODE;
	}

	public String getYEAR_CREATED() {
		return YEAR_CREATED;
	}

	public void setYEAR_CREATED(String yEAR_CREATED) {
		YEAR_CREATED = yEAR_CREATED;
	}

	public String getCOLOR_CODE() {
		return COLOR_CODE;
	}

	public void setCOLOR_CODE(String cOLOR_CODE) {
		COLOR_CODE = cOLOR_CODE;
	}

	public String getTRANSMISION() {
		return TRANSMISION;
	}

	public void setTRANSMISION(String tRANSMISION) {
		TRANSMISION = tRANSMISION;
	}

	public String getCONDITION() {
		return CONDITION;
	}

	public void setCONDITION(String cONDITION) {
		CONDITION = cONDITION;
	}

	public String getOFFER_PRICE() {
		return OFFER_PRICE;
	}

	public void setOFFER_PRICE(String oFFER_PRICE) {
		OFFER_PRICE = oFFER_PRICE;
	}

	public String getAFTER_ADJUSTMENT_PRICE() {
		return AFTER_ADJUSTMENT_PRICE;
	}

	public void setAFTER_ADJUSTMENT_PRICE(String aFTER_ADJUSTMENT_PRICE) {
		AFTER_ADJUSTMENT_PRICE = aFTER_ADJUSTMENT_PRICE;
	}

	public String getNARA_SUMBER() {
		return NARA_SUMBER;
	}

	public void setNARA_SUMBER(String nARA_SUMBER) {
		NARA_SUMBER = nARA_SUMBER;
	}

	public String getPHONE_NO() {
		return PHONE_NO;
	}

	public void setPHONE_NO(String pHONE_NO) {
		PHONE_NO = pHONE_NO;
	}

	public String getOFFER_TYPE() {
		return OFFER_TYPE;
	}

	public void setOFFER_TYPE(String oFFER_TYPE) {
		OFFER_TYPE = oFFER_TYPE;
	}

	public APPR_VHC_PEMBANDING_INT toRowData(){
		APPR_VHC_PEMBANDING_INT rowData= new APPR_VHC_PEMBANDING_INT();
		rowData.setCOL_ID(COL_ID);
		rowData.setAP_REGNO(AP_REGNO);
		rowData.setSEQ(SEQ);
		rowData.setVHC_BRAND_CODE(VHC_BRAND_CODE);
		rowData.setVHC_CODE(VHC_CODE);
		rowData.setYEAR_CREATED(YEAR_CREATED);
		rowData.setCOLOR_CODE(COLOR_CODE);
		rowData.setTRANSMISION(TRANSMISION);
		rowData.setCONDITION(CONDITION);
		rowData.setOFFER_PRICE(OFFER_PRICE);
		rowData.setAFTER_ADJUSTMENT_PRICE(AFTER_ADJUSTMENT_PRICE);
		rowData.setNARA_SUMBER(NARA_SUMBER);
		rowData.setPHONE_NO(PHONE_NO);
		rowData.setOFFER_TYPE(OFFER_TYPE);

	
		return rowData;
	}
	
	public void update(APPR_VHC_PEMBANDING_INT rowData) {
		COL_ID=rowData.getCOL_ID();
		AP_REGNO=rowData.getAP_REGNO();
		SEQ=rowData.getSEQ();
		VHC_BRAND_CODE=rowData.getVHC_BRAND_CODE();
		VHC_CODE=rowData.getVHC_CODE();
		YEAR_CREATED=rowData.getYEAR_CREATED();
		COLOR_CODE=rowData.getCOLOR_CODE();
		TRANSMISION=rowData.getTRANSMISION();
		CONDITION=rowData.getCONDITION();
		OFFER_PRICE=rowData.getOFFER_PRICE();
		AFTER_ADJUSTMENT_PRICE=rowData.getAFTER_ADJUSTMENT_PRICE();
		NARA_SUMBER=rowData.getNARA_SUMBER();
		PHONE_NO=rowData.getPHONE_NO();
		OFFER_TYPE=rowData.getOFFER_TYPE();


	}
	
	public void update(String userid,String latitude,String longitude,Date date,String time,String namausaha,String alamat,String jenisusaha,String radius,String komunitas, boolean isblackbox, boolean isuploaded, String stage, String apreqno, Date submitdate){
		/*USERID = userid;
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
		SUBMITDATE=submitdate;*/
	}
	
	public void update(String namaDebitur,String tglLahir,String jenisPembiayaan,String handphone,String fotoLokasi){
		/*NAMADEBITUR=namaDebitur;
	    TGLLAHIR=tglLahir;
	    JENISPEMBIAYAAN=jenisPembiayaan;
	    HANDPHONE=handphone;
	    FOTOLOKASI=fotoLokasi;*/
	}
	
	public void update(String namaDebitur,String tglLahir,String jenisPembiayaan,String handphone,String fotoLokasi,String teleponrumah,String alamatrumah,String plafon,String ktp,String npwp,String siupsku){
		/*NAMADEBITUR=namaDebitur;
	    TGLLAHIR=tglLahir;
	    JENISPEMBIAYAAN=jenisPembiayaan;
	    HANDPHONE=handphone;
	    FOTOLOKASI=fotoLokasi;	    
	    TELEPONRUMAH=teleponrumah;
	    ALAMATRUMAH=alamatrumah;
	    PLAFOND=plafon;
	    KTP=ktp;
	    NPWP=npwp;
	    SIUPSKU=siupsku;*/
	}
	
	public void update(String teleponrumah,String alamatrumah,String plafon,String ktp,String npwp,String siupsku){   
	    /*TELEPONRUMAH=teleponrumah;
	    ALAMATRUMAH=alamatrumah;
	    PLAFOND=plafon;
	    KTP=ktp;
	    NPWP=npwp;
	    SIUPSKU=siupsku;*/
	}
	
	public void update(String userid,String latitude,String longitude,Date date,String time,String namausaha,String alamat,String jenisusaha,String radius,String komunitas,String namaDebitur,String tglLahir,String jenisPembiayaan,String handphone,String fotoLokasi,String teleponrumah,String alamatrumah,String plafon,String ktp,String npwp,String siupsku){
		/*USERID = userid;
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
	    SIUPSKU=siupsku;*/
	}
	
	public void updateDataToNullForKenalan(){
		/*NAMADEBITUR="";
	    TGLLAHIR="";
	    JENISPEMBIAYAAN="";
	    HANDPHONE="";
	    FOTOLOKASI="";*/
	}
	
	public void updateDataToNullForPendekatan(){
	    /*TELEPONRUMAH="";
	    ALAMATRUMAH="";
	    PLAFOND="";
	    KTP="";
	    NPWP="";
	    SIUPSKU="";*/
	}
	
	public void updateDataToNullForClosing(){

	}
}
