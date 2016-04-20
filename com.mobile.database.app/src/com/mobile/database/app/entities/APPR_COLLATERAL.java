package com.mobile.database.app.entities;

import java.util.Date;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="APPR_COLLATERAL")
public class APPR_COLLATERAL {
	@DatabaseField(id=true,unique=true,canBeNull=false,uniqueIndexName="APPR_COLLATERAL_PK",dataType=DataType.STRING) private String COL_ID;
	@DatabaseField(dataType=DataType.STRING,width=500) private String COL_TYPE;
	@DatabaseField(dataType=DataType.STRING,width=500) private String COL_DESC;
	@DatabaseField(dataType=DataType.STRING,width=500) private String COL_CLASS_DESC;
	@DatabaseField(dataType=DataType.STRING,width=500) private String COL_RELATIONSHIP_DESC;
	@DatabaseField(dataType=DataType.STRING,width=500) private String DOC_DESC;
	@DatabaseField(dataType=DataType.STRING,width=500) private String AP_REGNO;
	@DatabaseField(dataType=DataType.STRING,width=500) private String COL_SEQ;
	@DatabaseField(dataType=DataType.STRING,width=500) private String COL_CODE;
	@DatabaseField(dataType=DataType.STRING,width=500) private String COL_CLASS;
	@DatabaseField(dataType=DataType.STRING,width=500) private String COL_DOK_TYPE;
	@DatabaseField(dataType=DataType.STRING,width=500) private String COL_DOK_NO;
	@DatabaseField(dataType=DataType.STRING,width=500) private String COL_DOK_NAME;
	@DatabaseField(dataType=DataType.STRING,width=500) private String COL_DOK_DATE;
	@DatabaseField(dataType=DataType.STRING,width=500) private String COL_DOK_EXPDATE;
	@DatabaseField(dataType=DataType.STRING,width=500) private String COL_BRANCH;
	@DatabaseField(dataType=DataType.STRING,width=500) private String COL_SANDIWIL;
	@DatabaseField(dataType=DataType.STRING,width=500) private String COL_UNIT;
	@DatabaseField(dataType=DataType.STRING,width=500) private String COL_CURR;
	@DatabaseField(dataType=DataType.STRING,width=500) private String COL_VALUE;
	@DatabaseField(dataType=DataType.STRING,width=500) private String COL_RELATIONSHIP;
	@DatabaseField(dataType=DataType.STRING,width=500) private String COL_ADDR1;
	@DatabaseField(dataType=DataType.STRING,width=500) private String COL_ADDR2;
	@DatabaseField(dataType=DataType.STRING,width=500) private String COL_ADDR3;
	@DatabaseField(dataType=DataType.STRING,width=500) private String COL_ZIPCODE;
	@DatabaseField(dataType=DataType.STRING,width=500) private String COL_KELURAHAN;
	@DatabaseField(dataType=DataType.STRING,width=500) private String COL_KECAMATAN;
	@DatabaseField(dataType=DataType.STRING,width=500) private String COL_CITY;
	@DatabaseField(dataType=DataType.STRING,width=500) private String COL_PROVINCE;
	@DatabaseField(dataType=DataType.STRING,width=500) private String CP_NAME;
	@DatabaseField(dataType=DataType.STRING,width=500) private String CP_HP;
	@DatabaseField(dataType=DataType.STRING,width=500) private String COL_PEMERINGKATAN;
	@DatabaseField(dataType=DataType.STRING,width=500) private String COL_PENERBIT;
	@DatabaseField(dataType=DataType.STRING,width=500) private String EKSTERNAL;
	@DatabaseField(dataType=DataType.STRING,width=500) private String INTERNAL;
	@DatabaseField(dataType=DataType.STRING,width=500) private String TATAKOTA;
	@DatabaseField(dataType=DataType.STRING,width=500) private String APPRAISE_BRANCH;
	@DatabaseField(dataType=DataType.STRING,width=500) private String COL_PENGIKATAN;
	@DatabaseField(dataType=DataType.STRING,width=500) private String CU_NAME;
	@DatabaseField(dataType=DataType.STRING,width=500) private String TATAKOTA_DESC;
	@DatabaseField(dataType=DataType.STRING,width=500) private String BRANCHID;
	@DatabaseField(dataType=DataType.STRING,width=500) private String SEG_CODE;
	@DatabaseField(dataType=DataType.STRING,width=500) private String COL_ISNEW;
	@DatabaseField(dataType=DataType.STRING,width=500) private String ISAPPRAISE;
	@DatabaseField(dataType=DataType.STRING,width=500) private String COL_DAHULUIAKTA;
	@DatabaseField(dataType=DataType.STRING,width=500) private String DOC_LENGKAP;
	@DatabaseField(dataType=DataType.STRING,width=500) private String APPRAISE_TYPE;
	@DatabaseField(dataType=DataType.STRING,width=500) private String APPR_DESC;
	@DatabaseField(dataType=DataType.STRING,width=500) private String DOC_COL_TYPE;
	@DatabaseField(dataType=DataType.STRING,width=500) private String BRANCHNAME;
	@DatabaseField(dataType=DataType.STRING,width=500) private String SEG_DESC;
	public String getCOL_ID() {
		return COL_ID;
	}
	public String getBRANCHNAME() {
		return BRANCHNAME;
	}
	public void setBRANCHNAME(String bRANCHNAME) {
		BRANCHNAME = bRANCHNAME;
	}
	public String getSEG_DESC() {
		return SEG_DESC;
	}
	public void setSEG_DESC(String sEG_DESC) {
		SEG_DESC = sEG_DESC;
	}
	public void setCOL_ID(String cOL_ID) {
		COL_ID = cOL_ID;
	}
	public String getCOL_TYPE() {
		return COL_TYPE;
	}
	public void setCOL_TYPE(String cOL_TYPE) {
		COL_TYPE = cOL_TYPE;
	}
	public String getCOL_DESC() {
		return COL_DESC;
	}
	public void setCOL_DESC(String cOL_DESC) {
		COL_DESC = cOL_DESC;
	}
	public String getCOL_CLASS_DESC() {
		return COL_CLASS_DESC;
	}
	public void setCOL_CLASS_DESC(String cOL_CLASS_DESC) {
		COL_CLASS_DESC = cOL_CLASS_DESC;
	}
	public String getCOL_RELATIONSHIP_DESC() {
		return COL_RELATIONSHIP_DESC;
	}
	public void setCOL_RELATIONSHIP_DESC(String cOL_RELATIONSHIP_DESC) {
		COL_RELATIONSHIP_DESC = cOL_RELATIONSHIP_DESC;
	}
	public String getDOC_DESC() {
		return DOC_DESC;
	}
	public void setDOC_DESC(String dOC_DESC) {
		DOC_DESC = dOC_DESC;
	}
	public String getAP_REGNO() {
		return AP_REGNO;
	}
	public void setAP_REGNO(String aP_REGNO) {
		AP_REGNO = aP_REGNO;
	}
	public String getCOL_SEQ() {
		return COL_SEQ;
	}
	public void setCOL_SEQ(String cOL_SEQ) {
		COL_SEQ = cOL_SEQ;
	}
	public String getCOL_CODE() {
		return COL_CODE;
	}
	public void setCOL_CODE(String cOL_CODE) {
		COL_CODE = cOL_CODE;
	}
	public String getCOL_CLASS() {
		return COL_CLASS;
	}
	public void setCOL_CLASS(String cOL_CLASS) {
		COL_CLASS = cOL_CLASS;
	}
	public String getCOL_DOK_TYPE() {
		return COL_DOK_TYPE;
	}
	public void setCOL_DOK_TYPE(String cOL_DOK_TYPE) {
		COL_DOK_TYPE = cOL_DOK_TYPE;
	}
	public String getCOL_DOK_NO() {
		return COL_DOK_NO;
	}
	public void setCOL_DOK_NO(String cOL_DOK_NO) {
		COL_DOK_NO = cOL_DOK_NO;
	}
	public String getCOL_DOK_NAME() {
		return COL_DOK_NAME;
	}
	public void setCOL_DOK_NAME(String cOL_DOK_NAME) {
		COL_DOK_NAME = cOL_DOK_NAME;
	}
	public Date getCOL_DOK_DATE() {
		return DataConverter.stringToDate(COL_DOK_DATE);
	}
	public void setCOL_DOK_DATE(Date cOL_DOK_DATE) {
		COL_DOK_DATE = DataConverter.dateToString(cOL_DOK_DATE);
	}
	public Date getCOL_DOK_EXPDATE() {
		return DataConverter.stringToDate(COL_DOK_EXPDATE);
	}
	public void setCOL_DOK_EXPDATE(Date cOL_DOK_EXPDATE) {
		COL_DOK_EXPDATE =  DataConverter.dateToString(cOL_DOK_EXPDATE);
	}
	public String getCOL_BRANCH() {
		return COL_BRANCH;
	}
	public void setCOL_BRANCH(String cOL_BRANCH) {
		COL_BRANCH = cOL_BRANCH;
	}
	public String getCOL_SANDIWIL() {
		return COL_SANDIWIL;
	}
	public void setCOL_SANDIWIL(String cOL_SANDIWIL) {
		COL_SANDIWIL = cOL_SANDIWIL;
	}
	public String getCOL_UNIT() {
		return COL_UNIT;
	}
	public void setCOL_UNIT(String cOL_UNIT) {
		COL_UNIT = cOL_UNIT;
	}
	public String getCOL_CURR() {
		return COL_CURR;
	}
	public void setCOL_CURR(String cOL_CURR) {
		COL_CURR = cOL_CURR;
	}
	public String getCOL_VALUE() {
		return COL_VALUE;
	}
	public void setCOL_VALUE(String cOL_VALUE) {
		COL_VALUE = cOL_VALUE;
	}
	public String getCOL_RELATIONSHIP() {
		return COL_RELATIONSHIP;
	}
	public void setCOL_RELATIONSHIP(String cOL_RELATIONSHIP) {
		COL_RELATIONSHIP = cOL_RELATIONSHIP;
	}
	public String getCOL_ADDR1() {
		return COL_ADDR1;
	}
	public void setCOL_ADDR1(String cOL_ADDR1) {
		COL_ADDR1 = cOL_ADDR1;
	}
	public String getCOL_ADDR2() {
		return COL_ADDR2;
	}
	public void setCOL_ADDR2(String cOL_ADDR2) {
		COL_ADDR2 = cOL_ADDR2;
	}
	public String getCOL_ADDR3() {
		return COL_ADDR3;
	}
	public void setCOL_ADDR3(String cOL_ADDR3) {
		COL_ADDR3 = cOL_ADDR3;
	}
	public String getCOL_ZIPCODE() {
		return COL_ZIPCODE;
	}
	public void setCOL_ZIPCODE(String cOL_ZIPCODE) {
		COL_ZIPCODE = cOL_ZIPCODE;
	}
	public String getCOL_KELURAHAN() {
		return COL_KELURAHAN;
	}
	public void setCOL_KELURAHAN(String cOL_KELURAHAN) {
		COL_KELURAHAN = cOL_KELURAHAN;
	}
	public String getCOL_KECAMATAN() {
		return COL_KECAMATAN;
	}
	public void setCOL_KECAMATAN(String cOL_KECAMATAN) {
		COL_KECAMATAN = cOL_KECAMATAN;
	}
	public String getCOL_CITY() {
		return COL_CITY;
	}
	public void setCOL_CITY(String cOL_CITY) {
		COL_CITY = cOL_CITY;
	}
	public String getCOL_PROVINCE() {
		return COL_PROVINCE;
	}
	public void setCOL_PROVINCE(String cOL_PROVINCE) {
		COL_PROVINCE = cOL_PROVINCE;
	}
	public String getCP_NAME() {
		return CP_NAME;
	}
	public void setCP_NAME(String cP_NAME) {
		CP_NAME = cP_NAME;
	}
	public String getCP_HP() {
		return CP_HP;
	}
	public void setCP_HP(String cP_HP) {
		CP_HP = cP_HP;
	}
	public String getCOL_PEMERINGKATAN() {
		return COL_PEMERINGKATAN;
	}
	public void setCOL_PEMERINGKATAN(String cOL_PEMERINGKATAN) {
		COL_PEMERINGKATAN = cOL_PEMERINGKATAN;
	}
	public String getCOL_PENERBIT() {
		return COL_PENERBIT;
	}
	public void setCOL_PENERBIT(String cOL_PENERBIT) {
		COL_PENERBIT = cOL_PENERBIT;
	}
	public String getEKSTERNAL() {
		return EKSTERNAL;
	}
	public void setEKSTERNAL(String eKSTERNAL) {
		EKSTERNAL = eKSTERNAL;
	}
	public String getINTERNAL() {
		return INTERNAL;
	}
	public void setINTERNAL(String iNTERNAL) {
		INTERNAL = iNTERNAL;
	}
	public String getTATAKOTA() {
		return TATAKOTA;
	}
	public void setTATAKOTA(String tATAKOTA) {
		TATAKOTA = tATAKOTA;
	}
	public String getAPPRAISE_BRANCH() {
		return APPRAISE_BRANCH;
	}
	public void setAPPRAISE_BRANCH(String aPPRAISE_BRANCH) {
		APPRAISE_BRANCH = aPPRAISE_BRANCH;
	}
	public String getCOL_PENGIKATAN() {
		return COL_PENGIKATAN;
	}
	public void setCOL_PENGIKATAN(String cOL_PENGIKATAN) {
		COL_PENGIKATAN = cOL_PENGIKATAN;
	}
	public String getCU_NAME() {
		return CU_NAME;
	}
	public void setCU_NAME(String cU_NAME) {
		CU_NAME = cU_NAME;
	}
	public String getTATAKOTA_DESC() {
		return TATAKOTA_DESC;
	}
	public void setTATAKOTA_DESC(String tATAKOTA_DESC) {
		TATAKOTA_DESC = tATAKOTA_DESC;
	}
	public String getBRANCHID() {
		return BRANCHID;
	}
	public void setBRANCHID(String bRANCHID) {
		BRANCHID = bRANCHID;
	}
	public String getSEG_CODE() {
		return SEG_CODE;
	}
	public void setSEG_CODE(String sEG_CODE) {
		SEG_CODE = sEG_CODE;
	}
	public String getCOL_ISNEW() {
		return COL_ISNEW;
	}
	public void setCOL_ISNEW(String cOL_ISNEW) {
		COL_ISNEW = cOL_ISNEW;
	}
	public String getISAPPRAISE() {
		return ISAPPRAISE;
	}
	public void setISAPPRAISE(String iSAPPRAISE) {
		ISAPPRAISE = iSAPPRAISE;
	}
	public String getCOL_DAHULUIAKTA() {
		return COL_DAHULUIAKTA;
	}
	public void setCOL_DAHULUIAKTA(String cOL_DAHULUIAKTA) {
		COL_DAHULUIAKTA = cOL_DAHULUIAKTA;
	}
	public String getDOC_LENGKAP() {
		return DOC_LENGKAP;
	}
	public void setDOC_LENGKAP(String dOC_LENGKAP) {
		DOC_LENGKAP = dOC_LENGKAP;
	}
	public String getAPPRAISE_TYPE() {
		return APPRAISE_TYPE;
	}
	public void setAPPRAISE_TYPE(String aPPRAISE_TYPE) {
		APPRAISE_TYPE = aPPRAISE_TYPE;
	}
	public String getAPPR_DESC() {
		return APPR_DESC;
	}
	public void setAPPR_DESC(String aPPR_DESC) {
		APPR_DESC = aPPR_DESC;
	}
	public String getDOC_COL_TYPE() {
		return DOC_COL_TYPE;
	}
	public void setDOC_COL_TYPE(String dOC_COL_TYPE) {
		DOC_COL_TYPE = dOC_COL_TYPE;
	}



}
