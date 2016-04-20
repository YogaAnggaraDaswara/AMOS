package com.mobile.database.app.entities;

import java.util.Date;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="APPR_RTB_PROGRESS_BANGUNAN_INT")
public class APPR_RTB_PROGRESS_BANGUNAN_INT {
	@DatabaseField(id=true,unique=true,canBeNull=false,uniqueIndexName="APPR_RTB_PROGRESS_BANGUNAN_INT_PK",dataType=DataType.STRING,width=16) private String COL_ID;
	@DatabaseField(dataType=DataType.STRING,width=20) private String AP_REGNO;
	@DatabaseField(dataType=DataType.STRING,width=20) private String REPORT_NO;
	@DatabaseField(dataType=DataType.STRING,width=8) private String REPORT_DATE;
	@DatabaseField(dataType=DataType.STRING,width=8) private String REPORT_INSPECT_DATE;
	@DatabaseField(dataType=DataType.STRING,width=10) private String REPORT_BRANCH_CODE;
	@DatabaseField(dataType=DataType.STRING,width=10) private String REPORT_SEG_CODE;
	@DatabaseField(dataType=DataType.STRING,width=8) private String INSPECT_DATE;
	@DatabaseField(dataType=DataType.STRING,width=50) private String INSPECTOR_NAME;
	@DatabaseField(dataType=DataType.STRING,width=8) private String BUILDING_PROGRESS;
	@DatabaseField(dataType=DataType.STRING,width=16) private String BUILDING_PROGRESS_DATA;
	@DatabaseField(dataType=DataType.STRING,width=1) private String COL_PEMERIKSAAN;
	@DatabaseField(dataType=DataType.STRING,width=10) private String COL_APPRAISER_CODE;
	@DatabaseField(dataType=DataType.STRING,width=100) private String COL_ADDR1;
	@DatabaseField(dataType=DataType.STRING,width=10) private String COL_RT;
	@DatabaseField(dataType=DataType.STRING,width=10) private String COL_RW;
	@DatabaseField(dataType=DataType.STRING,width=50) private String COL_KELURAHAN;
	@DatabaseField(dataType=DataType.STRING,width=50) private String COL_KECAMATAN;
	@DatabaseField(dataType=DataType.STRING,width=50) private String COL_CITY;
	@DatabaseField(dataType=DataType.STRING,width=10) private String COL_ZIPCODE;
	@DatabaseField(dataType=DataType.STRING,width=10) private String COL_TYPE;
	@DatabaseField(dataType=DataType.STRING,width=100) private String COL_DOK_NAME;
	@DatabaseField(dataType=DataType.STRING,width=50) private String COL_DOK_NO;
	@DatabaseField(dataType=DataType.STRING,width=10) private String COL_DOK_TYPE;
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
	public String getREPORT_NO() {
		return REPORT_NO;
	}
	public void setREPORT_NO(String rEPORT_NO) {
		REPORT_NO = rEPORT_NO;
	}
	public Date getREPORT_DATE() {
		return  DataConverter.stringToDate(REPORT_DATE);
	}
	public void setREPORT_DATE(Date rEPORT_DATE) {
		REPORT_DATE = DataConverter.dateToString(rEPORT_DATE);
	}
	public Date getREPORT_INSPECT_DATE() {
		return DataConverter.stringToDate(REPORT_INSPECT_DATE);
	}
	public void setREPORT_INSPECT_DATE(Date rEPORT_INSPECT_DATE) {
		REPORT_INSPECT_DATE = DataConverter.dateToString(rEPORT_INSPECT_DATE);
	}
	public String getREPORT_BRANCH_CODE() {
		return REPORT_BRANCH_CODE;
	}
	public void setREPORT_BRANCH_CODE(String rEPORT_BRANCH_CODE) {
		REPORT_BRANCH_CODE = rEPORT_BRANCH_CODE;
	}
	public String getREPORT_SEG_CODE() {
		return REPORT_SEG_CODE;
	}
	public void setREPORT_SEG_CODE(String rEPORT_SEG_CODE) {
		REPORT_SEG_CODE = rEPORT_SEG_CODE;
	}
	public Date getINSPECT_DATE() {
		return DataConverter.stringToDate(INSPECT_DATE);
	}
	public void setINSPECT_DATE(Date iNSPECT_DATE) {
		INSPECT_DATE = DataConverter.dateToString(iNSPECT_DATE);
	}
	public String getINSPECTOR_NAME() {
		return INSPECTOR_NAME;
	}
	public void setINSPECTOR_NAME(String iNSPECTOR_NAME) {
		INSPECTOR_NAME = iNSPECTOR_NAME;
	}
	public String getBUILDING_PROGRESS() {
		return BUILDING_PROGRESS;
	}
	public void setBUILDING_PROGRESS(String bUILDING_PROGRESS) {
		BUILDING_PROGRESS = bUILDING_PROGRESS;
	}
	public String getBUILDING_PROGRESS_DATA() {
		return BUILDING_PROGRESS_DATA;
	}
	public void setBUILDING_PROGRESS_DATA(String bUILDING_PROGRESS_DATA) {
		BUILDING_PROGRESS_DATA = bUILDING_PROGRESS_DATA;
	}
	public String getCOL_PEMERIKSAAN() {
		return COL_PEMERIKSAAN;
	}
	public void setCOL_PEMERIKSAAN(String cOL_PEMERIKSAAN) {
		COL_PEMERIKSAAN = cOL_PEMERIKSAAN;
	}
	public String getCOL_APPRAISER_CODE() {
		return COL_APPRAISER_CODE;
	}
	public void setCOL_APPRAISER_CODE(String cOL_APPRAISER_CODE) {
		COL_APPRAISER_CODE = cOL_APPRAISER_CODE;
	}
	public String getCOL_ADDR1() {
		return COL_ADDR1;
	}
	public void setCOL_ADDR1(String cOL_ADDR1) {
		COL_ADDR1 = cOL_ADDR1;
	}
	public String getCOL_RT() {
		return COL_RT;
	}
	public void setCOL_RT(String cOL_RT) {
		COL_RT = cOL_RT;
	}
	public String getCOL_RW() {
		return COL_RW;
	}
	public void setCOL_RW(String cOL_RW) {
		COL_RW = cOL_RW;
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
	public String getCOL_ZIPCODE() {
		return COL_ZIPCODE;
	}
	public void setCOL_ZIPCODE(String cOL_ZIPCODE) {
		COL_ZIPCODE = cOL_ZIPCODE;
	}
	public String getCOL_TYPE() {
		return COL_TYPE;
	}
	public void setCOL_TYPE(String cOL_TYPE) {
		COL_TYPE = cOL_TYPE;
	}
	public String getCOL_DOK_NAME() {
		return COL_DOK_NAME;
	}
	public void setCOL_DOK_NAME(String cOL_DOK_NAME) {
		COL_DOK_NAME = cOL_DOK_NAME;
	}
	public String getCOL_DOK_NO() {
		return COL_DOK_NO;
	}
	public void setCOL_DOK_NO(String cOL_DOK_NO) {
		COL_DOK_NO = cOL_DOK_NO;
	}
	public String getCOL_DOK_TYPE() {
		return COL_DOK_TYPE;
	}
	public void setCOL_DOK_TYPE(String cOL_DOK_TYPE) {
		COL_DOK_TYPE = cOL_DOK_TYPE;
	}
	
}
