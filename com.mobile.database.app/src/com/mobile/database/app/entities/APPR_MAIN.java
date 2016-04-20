package com.mobile.database.app.entities;

import java.util.Date;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="APPR_MAIN")
public class APPR_MAIN {
	@DatabaseField(id=true,unique=true,canBeNull=false,uniqueIndexName="APPR_MAIN_PK",dataType=DataType.STRING) private String COL_ID;
	@DatabaseField(dataType=DataType.STRING,width=8) private String AP_REGNO;
	@DatabaseField(dataType=DataType.STRING,width=10) private String COL_SEQ;
	@DatabaseField(dataType=DataType.STRING,width=10) private String COL_CODE;
	@DatabaseField(dataType=DataType.STRING,width=8) private String COL_CLASS;
	@DatabaseField(dataType=DataType.STRING,width=100) private String COL_DOK_TYPE;
	@DatabaseField(dataType=DataType.STRING,width=100) private String COL_DOK_NO;
	@DatabaseField(dataType=DataType.STRING,width=5) private String COL_DOK_NAME;
	@DatabaseField(dataType=DataType.STRING,width=200) private String COL_BRANCH;
	@DatabaseField(dataType=DataType.STRING,width=15) private String COL_PEMERINGKATAN;
	@DatabaseField(dataType=DataType.STRING,width=5) private String COL_PENERBIT;
	@DatabaseField(dataType=DataType.STRING,width=100) private String COL_ADDR1;
	@DatabaseField(dataType=DataType.STRING,width=100) private String COL_ADDR2;
	@DatabaseField(dataType=DataType.STRING,width=100) private String COL_ADDR3;
	@DatabaseField(dataType=DataType.STRING,width=100) private String COL_ZIPCODE;
	@DatabaseField(dataType=DataType.STRING,width=20) private String COL_KELURAHAN;
	@DatabaseField(dataType=DataType.STRING,width=300) private String COL_KECAMATAN;
	@DatabaseField(dataType=DataType.STRING,width=150) private String COL_CITY;
	@DatabaseField(dataType=DataType.STRING,width=16) private String CP_NAME;
	@DatabaseField(dataType=DataType.STRING,width=20) private String CP_HP;
	@DatabaseField(dataType=DataType.STRING,width=10) private String COL_RELATIONSHIP;
	@DatabaseField(dataType=DataType.STRING,width=10) private String TATAKOTA_DESC;
	@DatabaseField(dataType=DataType.STRING,width=100) private String APPR_DESC;

	
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
	public String getCOL_BRANCH() {
		return COL_BRANCH;
	}
	public void setCOL_BRANCH(String cOL_BRANCH) {
		COL_BRANCH = cOL_BRANCH;
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
	public String getCOL_RELATIONSHIP() {
		return COL_RELATIONSHIP;
	}
	public void setCOL_RELATIONSHIP(String cOL_RELATIONSHIP) {
		COL_RELATIONSHIP = cOL_RELATIONSHIP;
	}
	public String getTATAKOTA_DESC() {
		return TATAKOTA_DESC;
	}
	public void setTATAKOTA_DESC(String tATAKOTA_DESC) {
		TATAKOTA_DESC = tATAKOTA_DESC;
	}
	public String getAPPR_DESC() {
		return APPR_DESC;
	}
	public void setAPPR_DESC(String aPPR_DESC) {
		APPR_DESC = aPPR_DESC;
	}
	
	
	


}
