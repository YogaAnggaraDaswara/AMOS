package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

import com.mobile.database.app.entities.APPR_MAIN;
import com.mobile.database.app.entities.APPR_MCH_VALUATION_INT;
import com.mobile.database.app.entities.APPR_PB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_RTB_CEK_TATA_KOTA_INT;
import com.mobile.database.app.entities.APPR_RTB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_VHC_DATA_INT;
import com.mobile.database.app.entities.APPR_VHC_VALUATION_INT;
import com.mobile.database.app.entities.BLACKBOX;

public class Datatype_Appr_Vch_Data_Int implements Serializable {

	/**
	 * 
	 */
	public String COL_ID;
	public String AP_REGNO;
	public String VHC_CODE;
	public String VHC_BRAND_CODE;
	public String VHC_MODEL_CODE;
	public String VHC_TYPE_CODE;
	public String YEAR_CREATED;
	public String CYLINDER;
	public String COLOR_CODE;
	public String FRAME_NO;
	public String MACHINE_NO;
	public String FUEL;
	public String KM;
	public String POLICE_NO;
	public String VHC_PURPOSE_CODE;
	public String TRAYEK;
	public String TRAYEK_LICENSE;
	public String BUYPRICE;
	public String DEALER;
	public String DEALER_SALES;
	public String DEALER_ADDR1;
	public String DEALER_ADDR2;
	public String DEALER_ADDR3;
	public String DEALER_PHONE1_1;
	public String DEALER_PHONE1_2;
	public String DEALER_PHONE2_1;
	public String DEALER_PHONE2_2;
	public String VHC_MACHINE_COND_CODE;
	public String VHC_PHYSIC_COND_CODE;
	public String VHC_PAINT_COND_CODE;
	public String CRASH;
	public String TRANSMISION;
	public String RADIO_TAPE;
	public String CD_PLAYER;
	public String ALARM;
	public String AC;
	public String POWER_WINDOW;
	public String VELG_RACING;
	public String S_DEALER;
	public String S_MEDIA_MASSA;
	public String S_SUMBER_LAIN;
	public String S_DEALER_PRICE;
	public String S_MEDIA_MASSA_PRICE;
	public String S_SUMBER_LAIN_PRICE;
	public String S_LAIN_LAIN;
	public String VHC_COND_KET;



   
    
	 public Datatype_Appr_Vch_Data_Int() {
	    	update("",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"");
		}
	    
	 public Datatype_Appr_Vch_Data_Int(APPR_VHC_DATA_INT Data) {
			update(Data);
	}
		

	public APPR_VHC_DATA_INT toRowData(){
		APPR_VHC_DATA_INT rowData= new APPR_VHC_DATA_INT();
		rowData.setCOL_ID(COL_ID);
		rowData.setAP_REGNO(AP_REGNO);
		rowData.setVHC_CODE(VHC_CODE);
		rowData.setVHC_BRAND_CODE(VHC_BRAND_CODE);
		rowData.setVHC_MODEL_CODE(VHC_MODEL_CODE);
		rowData.setVHC_TYPE_CODE(VHC_TYPE_CODE);
		rowData.setYEAR_CREATED(YEAR_CREATED);
		rowData.setCYLINDER(CYLINDER);
		rowData.setCOLOR_CODE(COLOR_CODE);
		rowData.setFRAME_NO(FRAME_NO);
		rowData.setMACHINE_NO(MACHINE_NO);
		rowData.setFUEL(FUEL);
		rowData.setKM(KM);
		rowData.setPOLICE_NO(POLICE_NO);
		rowData.setVHC_PURPOSE_CODE(VHC_PURPOSE_CODE);
		rowData.setTRAYEK(TRAYEK);
		rowData.setTRAYEK_LICENSE(TRAYEK_LICENSE);
		rowData.setBUYPRICE(BUYPRICE);
		rowData.setDEALER(DEALER);
		rowData.setDEALER_SALES(DEALER_SALES);
		rowData.setDEALER_ADDR1(DEALER_ADDR1);
		rowData.setDEALER_ADDR2(DEALER_ADDR2);
		rowData.setDEALER_ADDR3(DEALER_ADDR3);
		rowData.setDEALER_PHONE1_1(DEALER_PHONE1_1);
		rowData.setDEALER_PHONE1_2(DEALER_PHONE1_2);
		rowData.setDEALER_PHONE2_1(DEALER_PHONE2_1);
		rowData.setDEALER_PHONE2_2(DEALER_PHONE2_2);
		rowData.setVHC_MACHINE_COND_CODE(VHC_MACHINE_COND_CODE);
		rowData.setVHC_PHYSIC_COND_CODE(VHC_PHYSIC_COND_CODE);
		rowData.setVHC_PAINT_COND_CODE(VHC_PAINT_COND_CODE);
		rowData.setCRASH(CRASH);
		rowData.setTRANSMISION(TRANSMISION);
		rowData.setRADIO_TAPE(RADIO_TAPE);
		rowData.setCD_PLAYER(CD_PLAYER);
		rowData.setALARM(ALARM);
		rowData.setAC(AC);
		rowData.setPOWER_WINDOW(POWER_WINDOW);
		rowData.setVELG_RACING(VELG_RACING);
		rowData.setS_DEALER(S_DEALER);
		rowData.setS_MEDIA_MASSA(S_MEDIA_MASSA);
		rowData.setS_SUMBER_LAIN(S_SUMBER_LAIN);
		rowData.setS_DEALER_PRICE(S_DEALER_PRICE);
		rowData.setS_MEDIA_MASSA_PRICE(S_MEDIA_MASSA_PRICE);
		rowData.setS_SUMBER_LAIN_PRICE(S_SUMBER_LAIN_PRICE);
		rowData.setS_LAIN_LAIN(S_LAIN_LAIN);
		rowData.setVHC_COND_KET(VHC_COND_KET);
		return rowData;
	}
	
	public void update(APPR_VHC_DATA_INT rowData) {
		COL_ID=rowData.getCOL_ID();
		AP_REGNO=rowData.getAP_REGNO();
		VHC_CODE=rowData.getVHC_CODE();
		VHC_BRAND_CODE=rowData.getVHC_BRAND_CODE();
		VHC_MODEL_CODE=rowData.getVHC_MODEL_CODE();
		VHC_TYPE_CODE=rowData.getVHC_TYPE_CODE();
		YEAR_CREATED=rowData.getYEAR_CREATED();
		CYLINDER=rowData.getCYLINDER();
		COLOR_CODE=rowData.getCOLOR_CODE();
		FRAME_NO=rowData.getFRAME_NO();
		MACHINE_NO=rowData.getMACHINE_NO();
		FUEL=rowData.getFUEL();
		KM=rowData.getKM();
		POLICE_NO=rowData.getPOLICE_NO();
		VHC_PURPOSE_CODE=rowData.getVHC_PURPOSE_CODE();
		TRAYEK=rowData.getTRAYEK();
		TRAYEK_LICENSE=rowData.getTRAYEK_LICENSE();
		BUYPRICE=rowData.getBUYPRICE();
		DEALER=rowData.getDEALER();
		DEALER_SALES=rowData.getDEALER_SALES();
		DEALER_ADDR1=rowData.getDEALER_ADDR1();
		DEALER_ADDR2=rowData.getDEALER_ADDR2();
		DEALER_ADDR3=rowData.getDEALER_ADDR3();
		DEALER_PHONE1_1=rowData.getDEALER_PHONE1_1();
		DEALER_PHONE1_2=rowData.getDEALER_PHONE1_2();
		DEALER_PHONE2_1=rowData.getDEALER_PHONE2_1();
		DEALER_PHONE2_2=rowData.getDEALER_PHONE2_2();
		VHC_MACHINE_COND_CODE=rowData.getVHC_MACHINE_COND_CODE();
		VHC_PHYSIC_COND_CODE=rowData.getVHC_PHYSIC_COND_CODE();
		VHC_PAINT_COND_CODE=rowData.getVHC_PAINT_COND_CODE();
		CRASH=rowData.getCRASH();
		TRANSMISION=rowData.getTRANSMISION();
		RADIO_TAPE=rowData.getRADIO_TAPE();
		CD_PLAYER=rowData.getCD_PLAYER();
		ALARM=rowData.getALARM();
		AC=rowData.getAC();
		POWER_WINDOW=rowData.getPOWER_WINDOW();
		VELG_RACING=rowData.getVELG_RACING();
		S_DEALER=rowData.getS_DEALER();
		S_MEDIA_MASSA=rowData.getS_MEDIA_MASSA();
		S_SUMBER_LAIN=rowData.getS_SUMBER_LAIN();
		S_DEALER_PRICE=rowData.getS_DEALER_PRICE();
		S_MEDIA_MASSA_PRICE=rowData.getS_MEDIA_MASSA_PRICE();
		S_SUMBER_LAIN_PRICE=rowData.getS_SUMBER_LAIN_PRICE();
		S_LAIN_LAIN=rowData.getS_LAIN_LAIN();
		VHC_COND_KET=rowData.getVHC_COND_KET();


	}
	
	public void update(String col_id,
			String ap_regno,
			String vhc_code,
			String vhc_brand_code,
			String vhc_model_code,
			String vhc_type_code,
			String year_created,
			String cylinder,
			String color_code,
			String frame_no,
			String machine_no,
			String fuel,
			String km,
			String police_no,
			String vhc_purpose_code,
			String trayek,
			String trayek_license,
			String buyprice,
			String dealer,
			String dealer_sales,
			String dealer_addr1,
			String dealer_addr2,
			String dealer_addr3,
			String dealer_phone1_1,
			String dealer_phone1_2,
			String dealer_phone2_1,
			String dealer_phone2_2,
			String vhc_machine_cond_code,
			String vhc_physic_cond_code,
			String vhc_paint_cond_code,
			String crash,
			String transmision,
			String radio_tape,
			String cd_player,
			String alarm,
			String ac,
			String power_window,
			String velg_racing,
			String s_dealer,
			String s_media_massa,
			String s_sumber_lain,
			String s_dealer_price,
			String s_media_massa_price,
			String s_sumber_lain_price,
			String s_lain_lain,
			String vhc_cond_ket){
		COL_ID=col_id;
		AP_REGNO=ap_regno;
		VHC_CODE=vhc_code;
		VHC_BRAND_CODE=vhc_brand_code;
		VHC_MODEL_CODE=vhc_model_code;
		VHC_TYPE_CODE=vhc_type_code;
		YEAR_CREATED=year_created;
		CYLINDER=cylinder;
		COLOR_CODE=color_code;
		FRAME_NO=frame_no;
		MACHINE_NO=machine_no;
		FUEL=fuel;
		KM=km;
		POLICE_NO=police_no;
		VHC_PURPOSE_CODE=vhc_purpose_code;
		TRAYEK=trayek;
		TRAYEK_LICENSE=trayek_license;
		BUYPRICE=buyprice;
		DEALER=dealer;
		DEALER_SALES=dealer_sales;
		DEALER_ADDR1=dealer_addr1;
		DEALER_ADDR2=dealer_addr2;
		DEALER_ADDR3=dealer_addr3;
		DEALER_PHONE1_1=dealer_phone1_1;
		DEALER_PHONE1_2=dealer_phone1_2;
		DEALER_PHONE2_1=dealer_phone2_1;
		DEALER_PHONE2_2=dealer_phone2_2;
		VHC_MACHINE_COND_CODE=vhc_machine_cond_code;
		VHC_PHYSIC_COND_CODE=vhc_physic_cond_code;
		VHC_PAINT_COND_CODE=vhc_paint_cond_code;
		CRASH=crash;
		TRANSMISION=transmision;
		RADIO_TAPE=radio_tape;
		CD_PLAYER=cd_player;
		ALARM=alarm;
		AC=ac;
		POWER_WINDOW=power_window;
		VELG_RACING=velg_racing;
		S_DEALER=s_dealer;
		S_MEDIA_MASSA=s_media_massa;
		S_SUMBER_LAIN=s_sumber_lain;
		S_DEALER_PRICE=s_dealer_price;
		S_MEDIA_MASSA_PRICE=s_media_massa_price;
		S_SUMBER_LAIN_PRICE=s_sumber_lain_price;
		S_LAIN_LAIN=s_lain_lain;
		VHC_COND_KET=vhc_cond_ket;
}

	public void updateMainFromJSON(JSONObject obj) throws Exception{
		COL_ID=obj.getString("COL_ID");
		AP_REGNO=obj.getString("AP_REGNO");
		VHC_CODE=obj.getString("VHC_CODE");
		VHC_BRAND_CODE=obj.getString("VHC_BRAND_CODE");
		VHC_MODEL_CODE=obj.getString("VHC_MODEL_CODE");
		VHC_TYPE_CODE=obj.getString("VHC_TYPE_CODE");
		YEAR_CREATED=obj.getString("YEAR_CREATED");
		CYLINDER=obj.getString("CYLINDER");
		COLOR_CODE=obj.getString("COLOR_CODE");
		FRAME_NO=obj.getString("FRAME_NO");
		MACHINE_NO=obj.getString("MACHINE_NO");
		FUEL=obj.getString("FUEL");
		KM=obj.getString("KM");
		POLICE_NO=obj.getString("POLICE_NO");
		VHC_PURPOSE_CODE=obj.getString("VHC_PURPOSE_CODE");
		TRAYEK=obj.getString("TRAYEK");
		TRAYEK_LICENSE=obj.getString("TRAYEK_LICENSE");
		BUYPRICE=obj.getString("BUYPRICE");
		DEALER=obj.getString("DEALER");
		DEALER_SALES=obj.getString("DEALER_SALES");
		DEALER_ADDR1=obj.getString("DEALER_ADDR1");
		DEALER_ADDR2=obj.getString("DEALER_ADDR2");
		DEALER_ADDR3=obj.getString("DEALER_ADDR3");
		DEALER_PHONE1_1=obj.getString("DEALER_PHONE1_1");
		DEALER_PHONE1_2=obj.getString("DEALER_PHONE1_2");
		DEALER_PHONE2_1=obj.getString("DEALER_PHONE2_1");
		DEALER_PHONE2_2=obj.getString("DEALER_PHONE2_2");
		VHC_MACHINE_COND_CODE=obj.getString("VHC_MACHINE_COND_CODE");
		VHC_PHYSIC_COND_CODE=obj.getString("VHC_PHYSIC_COND_CODE");
		VHC_PAINT_COND_CODE=obj.getString("VHC_PAINT_COND_CODE");
		CRASH=obj.getString("CRASH");
		TRANSMISION=obj.getString("TRANSMISION");
		RADIO_TAPE=obj.getString("RADIO_TAPE");
		CD_PLAYER=obj.getString("CD_PLAYER");
		ALARM=obj.getString("ALARM");
		AC=obj.getString("AC");
		POWER_WINDOW=obj.getString("POWER_WINDOW");
		VELG_RACING=obj.getString("VELG_RACING");
		S_DEALER=obj.getString("S_DEALER");
		S_MEDIA_MASSA=obj.getString("S_MEDIA_MASSA");
		S_SUMBER_LAIN=obj.getString("S_SUMBER_LAIN");
		S_DEALER_PRICE=obj.getString("S_DEALER_PRICE");
		S_MEDIA_MASSA_PRICE=obj.getString("S_MEDIA_MASSA_PRICE");
		S_SUMBER_LAIN_PRICE=obj.getString("S_SUMBER_LAIN_PRICE");
		S_LAIN_LAIN=obj.getString("S_LAIN_LAIN");
		VHC_COND_KET=obj.getString("VHC_COND_KET");

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

	public String getVHC_CODE() {
		return VHC_CODE;
	}

	public void setVHC_CODE(String vHC_CODE) {
		VHC_CODE = vHC_CODE;
	}

	public String getVHC_BRAND_CODE() {
		return VHC_BRAND_CODE;
	}

	public void setVHC_BRAND_CODE(String vHC_BRAND_CODE) {
		VHC_BRAND_CODE = vHC_BRAND_CODE;
	}

	public String getVHC_MODEL_CODE() {
		return VHC_MODEL_CODE;
	}

	public void setVHC_MODEL_CODE(String vHC_MODEL_CODE) {
		VHC_MODEL_CODE = vHC_MODEL_CODE;
	}

	public String getVHC_TYPE_CODE() {
		return VHC_TYPE_CODE;
	}

	public void setVHC_TYPE_CODE(String vHC_TYPE_CODE) {
		VHC_TYPE_CODE = vHC_TYPE_CODE;
	}

	public String getYEAR_CREATED() {
		return YEAR_CREATED;
	}

	public void setYEAR_CREATED(String yEAR_CREATED) {
		YEAR_CREATED = yEAR_CREATED;
	}

	public String getCYLINDER() {
		return CYLINDER;
	}

	public void setCYLINDER(String cYLINDER) {
		CYLINDER = cYLINDER;
	}

	public String getCOLOR_CODE() {
		return COLOR_CODE;
	}

	public void setCOLOR_CODE(String cOLOR_CODE) {
		COLOR_CODE = cOLOR_CODE;
	}

	public String getFRAME_NO() {
		return FRAME_NO;
	}

	public void setFRAME_NO(String fRAME_NO) {
		FRAME_NO = fRAME_NO;
	}

	public String getMACHINE_NO() {
		return MACHINE_NO;
	}

	public void setMACHINE_NO(String mACHINE_NO) {
		MACHINE_NO = mACHINE_NO;
	}

	public String getFUEL() {
		return FUEL;
	}

	public void setFUEL(String fUEL) {
		FUEL = fUEL;
	}

	public String getKM() {
		return KM;
	}

	public void setKM(String kM) {
		KM = kM;
	}

	public String getPOLICE_NO() {
		return POLICE_NO;
	}

	public void setPOLICE_NO(String pOLICE_NO) {
		POLICE_NO = pOLICE_NO;
	}

	public String getVHC_PURPOSE_CODE() {
		return VHC_PURPOSE_CODE;
	}

	public void setVHC_PURPOSE_CODE(String vHC_PURPOSE_CODE) {
		VHC_PURPOSE_CODE = vHC_PURPOSE_CODE;
	}

	public String getTRAYEK() {
		return TRAYEK;
	}

	public void setTRAYEK(String tRAYEK) {
		TRAYEK = tRAYEK;
	}

	public String getTRAYEK_LICENSE() {
		return TRAYEK_LICENSE;
	}

	public void setTRAYEK_LICENSE(String tRAYEK_LICENSE) {
		TRAYEK_LICENSE = tRAYEK_LICENSE;
	}

	public String getBUYPRICE() {
		return BUYPRICE;
	}

	public void setBUYPRICE(String bUYPRICE) {
		BUYPRICE = bUYPRICE;
	}

	public String getDEALER() {
		return DEALER;
	}

	public void setDEALER(String dEALER) {
		DEALER = dEALER;
	}

	public String getDEALER_SALES() {
		return DEALER_SALES;
	}

	public void setDEALER_SALES(String dEALER_SALES) {
		DEALER_SALES = dEALER_SALES;
	}

	public String getDEALER_ADDR1() {
		return DEALER_ADDR1;
	}

	public void setDEALER_ADDR1(String dEALER_ADDR1) {
		DEALER_ADDR1 = dEALER_ADDR1;
	}

	public String getDEALER_ADDR2() {
		return DEALER_ADDR2;
	}

	public void setDEALER_ADDR2(String dEALER_ADDR2) {
		DEALER_ADDR2 = dEALER_ADDR2;
	}

	public String getDEALER_ADDR3() {
		return DEALER_ADDR3;
	}

	public void setDEALER_ADDR3(String dEALER_ADDR3) {
		DEALER_ADDR3 = dEALER_ADDR3;
	}

	public String getDEALER_PHONE1_1() {
		return DEALER_PHONE1_1;
	}

	public void setDEALER_PHONE1_1(String dEALER_PHONE1_1) {
		DEALER_PHONE1_1 = dEALER_PHONE1_1;
	}

	public String getDEALER_PHONE1_2() {
		return DEALER_PHONE1_2;
	}

	public void setDEALER_PHONE1_2(String dEALER_PHONE1_2) {
		DEALER_PHONE1_2 = dEALER_PHONE1_2;
	}

	public String getDEALER_PHONE2_1() {
		return DEALER_PHONE2_1;
	}

	public void setDEALER_PHONE2_1(String dEALER_PHONE2_1) {
		DEALER_PHONE2_1 = dEALER_PHONE2_1;
	}

	public String getDEALER_PHONE2_2() {
		return DEALER_PHONE2_2;
	}

	public void setDEALER_PHONE2_2(String dEALER_PHONE2_2) {
		DEALER_PHONE2_2 = dEALER_PHONE2_2;
	}

	public String getVHC_MACHINE_COND_CODE() {
		return VHC_MACHINE_COND_CODE;
	}

	public void setVHC_MACHINE_COND_CODE(String vHC_MACHINE_COND_CODE) {
		VHC_MACHINE_COND_CODE = vHC_MACHINE_COND_CODE;
	}

	public String getVHC_PHYSIC_COND_CODE() {
		return VHC_PHYSIC_COND_CODE;
	}

	public void setVHC_PHYSIC_COND_CODE(String vHC_PHYSIC_COND_CODE) {
		VHC_PHYSIC_COND_CODE = vHC_PHYSIC_COND_CODE;
	}

	public String getVHC_PAINT_COND_CODE() {
		return VHC_PAINT_COND_CODE;
	}

	public void setVHC_PAINT_COND_CODE(String vHC_PAINT_COND_CODE) {
		VHC_PAINT_COND_CODE = vHC_PAINT_COND_CODE;
	}

	public String getCRASH() {
		return CRASH;
	}

	public void setCRASH(String cRASH) {
		CRASH = cRASH;
	}

	public String getTRANSMISION() {
		return TRANSMISION;
	}

	public void setTRANSMISION(String tRANSMISION) {
		TRANSMISION = tRANSMISION;
	}

	public String getRADIO_TAPE() {
		return RADIO_TAPE;
	}

	public void setRADIO_TAPE(String rADIO_TAPE) {
		RADIO_TAPE = rADIO_TAPE;
	}

	public String getCD_PLAYER() {
		return CD_PLAYER;
	}

	public void setCD_PLAYER(String cD_PLAYER) {
		CD_PLAYER = cD_PLAYER;
	}

	public String getALARM() {
		return ALARM;
	}

	public void setALARM(String aLARM) {
		ALARM = aLARM;
	}

	public String getAC() {
		return AC;
	}

	public void setAC(String aC) {
		AC = aC;
	}

	public String getPOWER_WINDOW() {
		return POWER_WINDOW;
	}

	public void setPOWER_WINDOW(String pOWER_WINDOW) {
		POWER_WINDOW = pOWER_WINDOW;
	}

	public String getVELG_RACING() {
		return VELG_RACING;
	}

	public void setVELG_RACING(String vELG_RACING) {
		VELG_RACING = vELG_RACING;
	}

	public String getS_DEALER() {
		return S_DEALER;
	}

	public void setS_DEALER(String s_DEALER) {
		S_DEALER = s_DEALER;
	}

	public String getS_MEDIA_MASSA() {
		return S_MEDIA_MASSA;
	}

	public void setS_MEDIA_MASSA(String s_MEDIA_MASSA) {
		S_MEDIA_MASSA = s_MEDIA_MASSA;
	}

	public String getS_SUMBER_LAIN() {
		return S_SUMBER_LAIN;
	}

	public void setS_SUMBER_LAIN(String s_SUMBER_LAIN) {
		S_SUMBER_LAIN = s_SUMBER_LAIN;
	}

	public String getS_DEALER_PRICE() {
		return S_DEALER_PRICE;
	}

	public void setS_DEALER_PRICE(String s_DEALER_PRICE) {
		S_DEALER_PRICE = s_DEALER_PRICE;
	}

	public String getS_MEDIA_MASSA_PRICE() {
		return S_MEDIA_MASSA_PRICE;
	}

	public void setS_MEDIA_MASSA_PRICE(String s_MEDIA_MASSA_PRICE) {
		S_MEDIA_MASSA_PRICE = s_MEDIA_MASSA_PRICE;
	}

	public String getS_SUMBER_LAIN_PRICE() {
		return S_SUMBER_LAIN_PRICE;
	}

	public void setS_SUMBER_LAIN_PRICE(String s_SUMBER_LAIN_PRICE) {
		S_SUMBER_LAIN_PRICE = s_SUMBER_LAIN_PRICE;
	}

	public String getS_LAIN_LAIN() {
		return S_LAIN_LAIN;
	}

	public void setS_LAIN_LAIN(String s_LAIN_LAIN) {
		S_LAIN_LAIN = s_LAIN_LAIN;
	}

	public String getVHC_COND_KET() {
		return VHC_COND_KET;
	}

	public void setVHC_COND_KET(String vHC_COND_KET) {
		VHC_COND_KET = vHC_COND_KET;
	}

}
