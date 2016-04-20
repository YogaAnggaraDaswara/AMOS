package com.mobile.database.app.entities;

import java.util.Date;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="APPR_VHC_PEMBANDING_INT")
public class APPR_VHC_PEMBANDING_INT {
	@DatabaseField(id=true,unique=true,canBeNull=false,uniqueIndexName="APPR_VHC_PEMBANDING_INT_PK",dataType=DataType.STRING,width=30) private String ID;
	@DatabaseField(dataType=DataType.STRING,width=16) private String COL_ID;
	@DatabaseField(dataType=DataType.STRING,width=20) private String AP_REGNO;
	@DatabaseField(dataType=DataType.STRING,width=4) private String SEQ;
	@DatabaseField(dataType=DataType.STRING,width=100) private String VHC_BRAND_CODE;
	@DatabaseField(dataType=DataType.STRING,width=100) private String VHC_CODE;
	@DatabaseField(dataType=DataType.STRING,width=5) private String YEAR_CREATED;
	@DatabaseField(dataType=DataType.STRING,width=50) private String COLOR_CODE;
	@DatabaseField(dataType=DataType.STRING,width=10) private String TRANSMISION;
	@DatabaseField(dataType=DataType.STRING,width=10) private String CONDITION;
	@DatabaseField(dataType=DataType.STRING,width=9) private String OFFER_PRICE;
	@DatabaseField(dataType=DataType.STRING,width=9) private String AFTER_ADJUSTMENT_PRICE;
	@DatabaseField(dataType=DataType.STRING,width=100) private String NARA_SUMBER;
	@DatabaseField(dataType=DataType.STRING,width=50) private String PHONE_NO;
	@DatabaseField(dataType=DataType.STRING,width=10) private String OFFER_TYPE;
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
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}


}
