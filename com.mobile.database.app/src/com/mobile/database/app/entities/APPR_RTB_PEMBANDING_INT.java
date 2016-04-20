package com.mobile.database.app.entities;

import java.util.Date;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="APPR_RTB_PEMBANDING_INT")
public class APPR_RTB_PEMBANDING_INT {
	@DatabaseField(id=true,canBeNull=false,uniqueIndexName="APPR_RTB_PEMBANDING_INT_PK",dataType=DataType.STRING,width=30) private String ID;
	@DatabaseField(dataType=DataType.STRING,width=16) private String COL_ID;
	@DatabaseField(dataType=DataType.STRING,width=4) private String SEQ;
	@DatabaseField(dataType=DataType.STRING,width=20) private String AP_REGNO;
	@DatabaseField(dataType=DataType.STRING,width=100) private String PROPERTY_TYPE;
	@DatabaseField(dataType=DataType.STRING,width=50) private String LOCATION;
	@DatabaseField(dataType=DataType.STRING,width=8) private String LAND_AREA;
	@DatabaseField(dataType=DataType.STRING,width=8) private String BUILDING_AREA;
	@DatabaseField(dataType=DataType.STRING,width=50) private String CONDITION;
	@DatabaseField(dataType=DataType.STRING,width=9) private String OFFER_PRICE;
	@DatabaseField(dataType=DataType.STRING,width=9) private String AFTER_ADJUSTMENT_PRICE;
	@DatabaseField(dataType=DataType.STRING,width=50) private String NARA_SUMBER;
	@DatabaseField(dataType=DataType.STRING,width=20) private String PHONE_NO;
	@DatabaseField(dataType=DataType.STRING,width=10) private String OFFER_TYPE;
	
	public String getCOL_ID() {
		return COL_ID;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
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
	public String getPROPERTY_TYPE() {
		return PROPERTY_TYPE;
	}
	public void setPROPERTY_TYPE(String pROPERTY_TYPE) {
		PROPERTY_TYPE = pROPERTY_TYPE;
	}
	public String getLOCATION() {
		return LOCATION;
	}
	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
	}
	public String getLAND_AREA() {
		return LAND_AREA;
	}
	public void setLAND_AREA(String lAND_AREA) {
		LAND_AREA = lAND_AREA;
	}
	public String getBUILDING_AREA() {
		return BUILDING_AREA;
	}
	public void setBUILDING_AREA(String bUILDING_AREA) {
		BUILDING_AREA = bUILDING_AREA;
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


}
