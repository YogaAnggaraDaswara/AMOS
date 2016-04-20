package com.mobile.database.app.entities;

import java.util.Date;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="APPR_PB_VALUATION_INT")
public class APPR_PB_VALUATION_INT {
	@DatabaseField(id=true,unique=true,canBeNull=false,uniqueIndexName="APPR_PB_VALUATION_INT_PK",dataType=DataType.STRING,width=16) private String COL_ID;
	@DatabaseField(dataType=DataType.STRING,width=20) private String AP_REGNO;
	@DatabaseField(dataType=DataType.STRING,width=100) private String REPORT_NO;
	@DatabaseField(dataType=DataType.STRING,width=8) private String REPORT_DATE;
	@DatabaseField(dataType=DataType.STRING,width=8) private String REPORT_INSPECT_DATE;
	@DatabaseField(dataType=DataType.STRING,width=10) private String REPORT_BRANCH_CODE;
	@DatabaseField(dataType=DataType.STRING,width=10) private String REPORT_SEG_CODE;
	@DatabaseField(dataType=DataType.STRING,width=1) private String REPORT_APPR_TYPE;
	@DatabaseField(dataType=DataType.STRING,width=200) private String COL_ADDR1;
	@DatabaseField(dataType=DataType.STRING,width=200) private String COL_ADDR2;
	@DatabaseField(dataType=DataType.STRING,width=200) private String COL_ADDR3;
	@DatabaseField(dataType=DataType.STRING,width=10) private String COL_RT;
	@DatabaseField(dataType=DataType.STRING,width=10) private String COL_RW;
	@DatabaseField(dataType=DataType.STRING,width=50) private String COL_KELURAHAN;
	@DatabaseField(dataType=DataType.STRING,width=50) private String COL_KECAMATAN;
	@DatabaseField(dataType=DataType.STRING,width=50) private String COL_CITY;
	@DatabaseField(dataType=DataType.STRING,width=10) private String COL_ZIPCODE;
	@DatabaseField(dataType=DataType.STRING,width=10) private String COL_BRANCH_CODE;
	@DatabaseField(dataType=DataType.STRING,width=8) private String COL_REQ_DATE;
	@DatabaseField(dataType=DataType.STRING,width=100) private String COL_APPRAISER_CODE;
	@DatabaseField(dataType=DataType.STRING,width=8) private String COL_INSPECT_DATE;
	@DatabaseField(dataType=DataType.STRING,width=50) private String COL_INSPECT_PERSON;
	@DatabaseField(dataType=DataType.STRING,width=4) private String PB_RANDOM_SAMPLING_COUNT;
	@DatabaseField(dataType=DataType.STRING,width=4) private String PB_TOTAL_ITEM;
	@DatabaseField(dataType=DataType.STRING,width=8) private String PB_BII_DATE;
	@DatabaseField(dataType=DataType.STRING,width=1) private String PB_FIRETOOL;
	@DatabaseField(dataType=DataType.STRING,width=1) private String PB_FIRETOOL_OWNED;
	@DatabaseField(dataType=DataType.STRING,width=1) private String PB_SECURITY;
	@DatabaseField(dataType=DataType.STRING,width=1) private String PB_SECURITY_OWNED;
	@DatabaseField(dataType=DataType.STRING,width=1) private String PB_FLOOD_RISK;
	@DatabaseField(dataType=DataType.STRING,width=1) private String PB_FLOOD_RISK_INTERVAL;
	@DatabaseField(dataType=DataType.STRING,width=50) private String INSPECTION_PERSON;
	@DatabaseField(dataType=DataType.STRING,width=1) private String INSPECTION_BUSINESSUNIT;
	@DatabaseField(dataType=DataType.STRING,width=200) private String TAXAXY_OPINION;
	@DatabaseField(dataType=DataType.STRING,width=200) private String OTHER_INFO;
	@DatabaseField(dataType=DataType.STRING,width=100) private String APPR_PENILAINAME;
	@DatabaseField(dataType=DataType.STRING,width=1) private String APPR_REKANAN;

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
		return DataConverter.stringToDate(REPORT_DATE);
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
	public String getREPORT_APPR_TYPE() {
		return REPORT_APPR_TYPE;
	}
	public void setREPORT_APPR_TYPE(String rEPORT_APPR_TYPE) {
		REPORT_APPR_TYPE = rEPORT_APPR_TYPE;
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
	public String getCOL_BRANCH_CODE() {
		return COL_BRANCH_CODE;
	}
	public void setCOL_BRANCH_CODE(String cOL_BRANCH_CODE) {
		COL_BRANCH_CODE = cOL_BRANCH_CODE;
	}
	public Date getCOL_REQ_DATE() {
		return DataConverter.stringToDate(COL_REQ_DATE);
	}
	public void setCOL_REQ_DATE(Date cOL_REQ_DATE) {
		COL_REQ_DATE = DataConverter.dateToString(cOL_REQ_DATE);
	}
	public String getCOL_APPRAISER_CODE() {
		return COL_APPRAISER_CODE;
	}
	public void setCOL_APPRAISER_CODE(String cOL_APPRAISER_CODE) {
		COL_APPRAISER_CODE = cOL_APPRAISER_CODE;
	}
	public Date getCOL_INSPECT_DATE() {
		return DataConverter.stringToDate(COL_INSPECT_DATE);
	}
	public void setCOL_INSPECT_DATE(Date cOL_INSPECT_DATE) {
		COL_INSPECT_DATE = DataConverter.dateToString(cOL_INSPECT_DATE);
	}
	public String getCOL_INSPECT_PERSON() {
		return COL_INSPECT_PERSON;
	}
	public void setCOL_INSPECT_PERSON(String cOL_INSPECT_PERSON) {
		COL_INSPECT_PERSON = cOL_INSPECT_PERSON;
	}
	public String getPB_RANDOM_SAMPLING_COUNT() {
		return PB_RANDOM_SAMPLING_COUNT;
	}
	public void setPB_RANDOM_SAMPLING_COUNT(String pB_RANDOM_SAMPLING_COUNT) {
		PB_RANDOM_SAMPLING_COUNT = pB_RANDOM_SAMPLING_COUNT;
	}
	public String getPB_TOTAL_ITEM() {
		return PB_TOTAL_ITEM;
	}
	public void setPB_TOTAL_ITEM(String pB_TOTAL_ITEM) {
		PB_TOTAL_ITEM = pB_TOTAL_ITEM;
	}
	public Date getPB_BII_DATE() {
		return DataConverter.stringToDate(PB_BII_DATE);
	}
	public void setPB_BII_DATE(Date pB_BII_DATE) {
		PB_BII_DATE = DataConverter.dateToString(pB_BII_DATE);
	}
	public String getPB_FIRETOOL() {
		return PB_FIRETOOL;
	}
	public void setPB_FIRETOOL(String pB_FIRETOOL) {
		PB_FIRETOOL = pB_FIRETOOL;
	}
	public String getPB_FIRETOOL_OWNED() {
		return PB_FIRETOOL_OWNED;
	}
	public void setPB_FIRETOOL_OWNED(String pB_FIRETOOL_OWNED) {
		PB_FIRETOOL_OWNED = pB_FIRETOOL_OWNED;
	}
	public String getPB_SECURITY() {
		return PB_SECURITY;
	}
	public void setPB_SECURITY(String pB_SECURITY) {
		PB_SECURITY = pB_SECURITY;
	}
	public String getPB_SECURITY_OWNED() {
		return PB_SECURITY_OWNED;
	}
	public void setPB_SECURITY_OWNED(String pB_SECURITY_OWNED) {
		PB_SECURITY_OWNED = pB_SECURITY_OWNED;
	}
	public String getPB_FLOOD_RISK() {
		return PB_FLOOD_RISK;
	}
	public void setPB_FLOOD_RISK(String pB_FLOOD_RISK) {
		PB_FLOOD_RISK = pB_FLOOD_RISK;
	}
	public String getPB_FLOOD_RISK_INTERVAL() {
		return PB_FLOOD_RISK_INTERVAL;
	}
	public void setPB_FLOOD_RISK_INTERVAL(String pB_FLOOD_RISK_INTERVAL) {
		PB_FLOOD_RISK_INTERVAL = pB_FLOOD_RISK_INTERVAL;
	}
	public String getINSPECTION_PERSON() {
		return INSPECTION_PERSON;
	}
	public void setINSPECTION_PERSON(String iNSPECTION_PERSON) {
		INSPECTION_PERSON = iNSPECTION_PERSON;
	}
	public String getINSPECTION_BUSINESSUNIT() {
		return INSPECTION_BUSINESSUNIT;
	}
	public void setINSPECTION_BUSINESSUNIT(String iNSPECTION_BUSINESSUNIT) {
		INSPECTION_BUSINESSUNIT = iNSPECTION_BUSINESSUNIT;
	}
	public String getTAXAXY_OPINION() {
		return TAXAXY_OPINION;
	}
	public void setTAXAXY_OPINION(String tAXAXY_OPINION) {
		TAXAXY_OPINION = tAXAXY_OPINION;
	}
	public String getOTHER_INFO() {
		return OTHER_INFO;
	}
	public void setOTHER_INFO(String oTHER_INFO) {
		OTHER_INFO = oTHER_INFO;
	}
	public String getAPPR_PENILAINAME() {
		return APPR_PENILAINAME;
	}
	public void setAPPR_PENILAINAME(String aPPR_PENILAINAME) {
		APPR_PENILAINAME = aPPR_PENILAINAME;
	}
	public String getAPPR_REKANAN() {
		return APPR_REKANAN;
	}
	public void setAPPR_REKANAN(String aPPR_REKANAN) {
		APPR_REKANAN = aPPR_REKANAN;
	}



}
