package com.mobile.database.app.entities;

import java.util.Date;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="APPR_VHC_DATA_INT")
public class APPR_VHC_DATA_INT {
	@DatabaseField(id=true,unique=true,canBeNull=false,uniqueIndexName="APPR_VHC_DATA_INT_INT_PK",dataType=DataType.STRING,width=16) private String COL_ID;
	@DatabaseField(dataType=DataType.STRING,width=20) private String AP_REGNO;
	@DatabaseField(dataType=DataType.STRING,width=50) private String VHC_CODE;
	@DatabaseField(dataType=DataType.STRING,width=50) private String VHC_BRAND_CODE;
	@DatabaseField(dataType=DataType.STRING,width=50) private String VHC_MODEL_CODE;
	@DatabaseField(dataType=DataType.STRING,width=50) private String VHC_TYPE_CODE;
	@DatabaseField(dataType=DataType.STRING,width=5) private String YEAR_CREATED;
	@DatabaseField(dataType=DataType.STRING,width=4) private String CYLINDER;
	@DatabaseField(dataType=DataType.STRING,width=50) private String COLOR_CODE;
	@DatabaseField(dataType=DataType.STRING,width=50) private String FRAME_NO;
	@DatabaseField(dataType=DataType.STRING,width=50) private String MACHINE_NO;
	@DatabaseField(dataType=DataType.STRING,width=10) private String FUEL;
	@DatabaseField(dataType=DataType.STRING,width=4) private String KM;
	@DatabaseField(dataType=DataType.STRING,width=20) private String POLICE_NO;
	@DatabaseField(dataType=DataType.STRING,width=10) private String VHC_PURPOSE_CODE;
	@DatabaseField(dataType=DataType.STRING,width=1) private String TRAYEK;
	@DatabaseField(dataType=DataType.STRING,width=1) private String TRAYEK_LICENSE;
	@DatabaseField(dataType=DataType.STRING,width=8) private String BUYPRICE;
	@DatabaseField(dataType=DataType.STRING,width=50) private String DEALER;
	@DatabaseField(dataType=DataType.STRING,width=50) private String DEALER_SALES;
	@DatabaseField(dataType=DataType.STRING,width=200) private String DEALER_ADDR1;
	@DatabaseField(dataType=DataType.STRING,width=200) private String DEALER_ADDR2;
	@DatabaseField(dataType=DataType.STRING,width=200) private String DEALER_ADDR3;
	@DatabaseField(dataType=DataType.STRING,width=20) private String DEALER_PHONE1_1;
	@DatabaseField(dataType=DataType.STRING,width=20) private String DEALER_PHONE1_2;
	@DatabaseField(dataType=DataType.STRING,width=20) private String DEALER_PHONE2_1;
	@DatabaseField(dataType=DataType.STRING,width=20) private String DEALER_PHONE2_2;
	@DatabaseField(dataType=DataType.STRING,width=10) private String VHC_MACHINE_COND_CODE;
	@DatabaseField(dataType=DataType.STRING,width=10) private String VHC_PHYSIC_COND_CODE;
	@DatabaseField(dataType=DataType.STRING,width=10) private String VHC_PAINT_COND_CODE;
	@DatabaseField(dataType=DataType.STRING,width=1) private String CRASH;
	@DatabaseField(dataType=DataType.STRING,width=1) private String TRANSMISION;
	@DatabaseField(dataType=DataType.STRING,width=1) private String RADIO_TAPE;
	@DatabaseField(dataType=DataType.STRING,width=1) private String CD_PLAYER;
	@DatabaseField(dataType=DataType.STRING,width=1) private String ALARM;
	@DatabaseField(dataType=DataType.STRING,width=1) private String AC;
	@DatabaseField(dataType=DataType.STRING,width=1) private String POWER_WINDOW;
	@DatabaseField(dataType=DataType.STRING,width=1) private String VELG_RACING;
	@DatabaseField(dataType=DataType.STRING,width=50) private String S_DEALER;
	@DatabaseField(dataType=DataType.STRING,width=50) private String S_MEDIA_MASSA;
	@DatabaseField(dataType=DataType.STRING,width=50) private String S_SUMBER_LAIN;
	@DatabaseField(dataType=DataType.STRING,width=8) private String S_DEALER_PRICE;
	@DatabaseField(dataType=DataType.STRING,width=8) private String S_MEDIA_MASSA_PRICE;
	@DatabaseField(dataType=DataType.STRING,width=8) private String S_SUMBER_LAIN_PRICE;
	@DatabaseField(dataType=DataType.STRING,width=200) private String S_LAIN_LAIN;
	@DatabaseField(dataType=DataType.STRING,width=300) private String VHC_COND_KET;
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
