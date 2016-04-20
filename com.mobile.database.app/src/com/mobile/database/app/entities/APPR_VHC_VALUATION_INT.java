package com.mobile.database.app.entities;

import java.util.Date;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="APPR_RTB_VALUATION_EXT_INT")
public class APPR_VHC_VALUATION_INT {
	@DatabaseField(id=true,unique=true,canBeNull=false,uniqueIndexName="APPR_RTB_VALUATION_EXT_INT_PK",dataType=DataType.STRING,width=16) private String COL_ID;
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
	@DatabaseField(dataType=DataType.STRING,width=50) private String BPKB_NAME;
	@DatabaseField(dataType=DataType.STRING,width=8) private String BPKB_EXPIRE_DATE;
	@DatabaseField(dataType=DataType.STRING,width=50) private String STNK_NAME;
	@DatabaseField(dataType=DataType.STRING,width=8) private String STNK_EXPIRE_DATE;
	@DatabaseField(dataType=DataType.STRING,width=50) private String INVOICE_NAME;
	@DatabaseField(dataType=DataType.STRING,width=8) private String INVOICE_DATE;
	@DatabaseField(dataType=DataType.STRING,width=50) private String ORDER_NAME;
	@DatabaseField(dataType=DataType.STRING,width=8) private String ORDER_DATE;
	@DatabaseField(dataType=DataType.STRING,width=200) private String BPKB_ADDR1;
	@DatabaseField(dataType=DataType.STRING,width=200) private String BPKB_ADDR2;
	@DatabaseField(dataType=DataType.STRING,width=200) private String BPKB_ADDR3;
	@DatabaseField(dataType=DataType.STRING,width=10) private String BPKB_RT;
	@DatabaseField(dataType=DataType.STRING,width=10) private String BPKB_RW;
	@DatabaseField(dataType=DataType.STRING,width=50) private String BPKB_KELURAHAN;
	@DatabaseField(dataType=DataType.STRING,width=50) private String BPKB_KECAMATAN;
	@DatabaseField(dataType=DataType.STRING,width=50) private String BPKB_CITY;
	@DatabaseField(dataType=DataType.STRING,width=10) private String BPKB_ZIPCODE;
	@DatabaseField(dataType=DataType.STRING,width=8) private String RANGE_PRICE;
	@DatabaseField(dataType=DataType.STRING,width=8) private String MARKET_PRICE;
	@DatabaseField(dataType=DataType.STRING,width=8) private String SAFETY_MARGIN;
	@DatabaseField(dataType=DataType.STRING,width=8) private String AFTER_SAFETY_MARGIN_PRICE;
	@DatabaseField(dataType=DataType.STRING,width=8) private String LIQUID_PERCENT;
	@DatabaseField(dataType=DataType.STRING,width=8) private String LIQUID_VALUE;
	@DatabaseField(dataType=DataType.STRING,width=200) private String POSITIVE_FACTOR;
	@DatabaseField(dataType=DataType.STRING,width=200) private String NEGATIVE_FACTOR;
	@DatabaseField(dataType=DataType.STRING,width=200) private String CONCLUSION;
	@DatabaseField(dataType=DataType.STRING,width=50) private String INSPECTION_PERSON;
	@DatabaseField(dataType=DataType.STRING,width=1) private String INSPECTION_BUSINESSUNIT;
	@DatabaseField(dataType=DataType.STRING,width=200) private String TAXAXY_OPINION;
	@DatabaseField(dataType=DataType.STRING,width=16) private String OTHER_INFO;
	@DatabaseField(dataType=DataType.STRING,width=50) private String STNK_NO;
	@DatabaseField(dataType=DataType.STRING,width=50) private String BPKB_NO;
	@DatabaseField(dataType=DataType.STRING,width=50) private String INVOICE_NO;
	@DatabaseField(dataType=DataType.STRING,width=50) private String ORDER_NO;
	@DatabaseField(dataType=DataType.STRING,width=300) private String BPKB_ADDRESS;
	@DatabaseField(dataType=DataType.STRING,width=300) private String STNK_ADDRESS;
	@DatabaseField(dataType=DataType.STRING,width=300) private String INVOICE_ADDRESS;
	@DatabaseField(dataType=DataType.STRING,width=300) private String ORDER_ADDRESS;
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
	public String getBPKB_NAME() {
		return BPKB_NAME;
	}
	public void setBPKB_NAME(String bPKB_NAME) {
		BPKB_NAME = bPKB_NAME;
	}
	public Date getBPKB_EXPIRE_DATE() {
		return DataConverter.stringToDate(BPKB_EXPIRE_DATE);
	}
	public void setBPKB_EXPIRE_DATE(Date bPKB_EXPIRE_DATE) {
		BPKB_EXPIRE_DATE = DataConverter.dateToString(bPKB_EXPIRE_DATE);
	}
	public String getSTNK_NAME() {
		return STNK_NAME;
	}
	public void setSTNK_NAME(String sTNK_NAME) {
		STNK_NAME = sTNK_NAME;
	}
	public Date getSTNK_EXPIRE_DATE() {
		return DataConverter.stringToDate(STNK_EXPIRE_DATE);
	}
	public void setSTNK_EXPIRE_DATE(Date sTNK_EXPIRE_DATE) {
		STNK_EXPIRE_DATE = DataConverter.dateToString(sTNK_EXPIRE_DATE);
	}
	public String getINVOICE_NAME() {
		return INVOICE_NAME;
	}
	public void setINVOICE_NAME(String iNVOICE_NAME) {
		INVOICE_NAME = iNVOICE_NAME;
	}
	public Date getINVOICE_DATE() {
		return DataConverter.stringToDate(INVOICE_DATE);
	}
	public void setINVOICE_DATE(Date iNVOICE_DATE) {
		INVOICE_DATE = DataConverter.dateToString(iNVOICE_DATE);
	}
	public String getORDER_NAME() {
		return ORDER_NAME;
	}
	public void setORDER_NAME(String oRDER_NAME) {
		ORDER_NAME = oRDER_NAME;
	}
	public Date getORDER_DATE() {
		return DataConverter.stringToDate(ORDER_DATE);
	}
	public void setORDER_DATE(Date oRDER_DATE) {
		ORDER_DATE = DataConverter.dateToString(oRDER_DATE);
	}
	public String getBPKB_ADDR1() {
		return BPKB_ADDR1;
	}
	public void setBPKB_ADDR1(String bPKB_ADDR1) {
		BPKB_ADDR1 = bPKB_ADDR1;
	}
	public String getBPKB_ADDR2() {
		return BPKB_ADDR2;
	}
	public void setBPKB_ADDR2(String bPKB_ADDR2) {
		BPKB_ADDR2 = bPKB_ADDR2;
	}
	public String getBPKB_ADDR3() {
		return BPKB_ADDR3;
	}
	public void setBPKB_ADDR3(String bPKB_ADDR3) {
		BPKB_ADDR3 = bPKB_ADDR3;
	}
	public String getBPKB_RT() {
		return BPKB_RT;
	}
	public void setBPKB_RT(String bPKB_RT) {
		BPKB_RT = bPKB_RT;
	}
	public String getBPKB_RW() {
		return BPKB_RW;
	}
	public void setBPKB_RW(String bPKB_RW) {
		BPKB_RW = bPKB_RW;
	}
	public String getBPKB_KELURAHAN() {
		return BPKB_KELURAHAN;
	}
	public void setBPKB_KELURAHAN(String bPKB_KELURAHAN) {
		BPKB_KELURAHAN = bPKB_KELURAHAN;
	}
	public String getBPKB_KECAMATAN() {
		return BPKB_KECAMATAN;
	}
	public void setBPKB_KECAMATAN(String bPKB_KECAMATAN) {
		BPKB_KECAMATAN = bPKB_KECAMATAN;
	}
	public String getBPKB_CITY() {
		return BPKB_CITY;
	}
	public void setBPKB_CITY(String bPKB_CITY) {
		BPKB_CITY = bPKB_CITY;
	}
	public String getBPKB_ZIPCODE() {
		return BPKB_ZIPCODE;
	}
	public void setBPKB_ZIPCODE(String bPKB_ZIPCODE) {
		BPKB_ZIPCODE = bPKB_ZIPCODE;
	}
	public String getRANGE_PRICE() {
		return RANGE_PRICE;
	}
	public void setRANGE_PRICE(String rANGE_PRICE) {
		RANGE_PRICE = rANGE_PRICE;
	}
	public String getMARKET_PRICE() {
		return MARKET_PRICE;
	}
	public void setMARKET_PRICE(String mARKET_PRICE) {
		MARKET_PRICE = mARKET_PRICE;
	}
	public String getSAFETY_MARGIN() {
		return SAFETY_MARGIN;
	}
	public void setSAFETY_MARGIN(String sAFETY_MARGIN) {
		SAFETY_MARGIN = sAFETY_MARGIN;
	}
	public String getAFTER_SAFETY_MARGIN_PRICE() {
		return AFTER_SAFETY_MARGIN_PRICE;
	}
	public void setAFTER_SAFETY_MARGIN_PRICE(String aFTER_SAFETY_MARGIN_PRICE) {
		AFTER_SAFETY_MARGIN_PRICE = aFTER_SAFETY_MARGIN_PRICE;
	}
	public String getLIQUID_PERCENT() {
		return LIQUID_PERCENT;
	}
	public void setLIQUID_PERCENT(String lIQUID_PERCENT) {
		LIQUID_PERCENT = lIQUID_PERCENT;
	}
	public String getLIQUID_VALUE() {
		return LIQUID_VALUE;
	}
	public void setLIQUID_VALUE(String lIQUID_VALUE) {
		LIQUID_VALUE = lIQUID_VALUE;
	}
	public String getPOSITIVE_FACTOR() {
		return POSITIVE_FACTOR;
	}
	public void setPOSITIVE_FACTOR(String pOSITIVE_FACTOR) {
		POSITIVE_FACTOR = pOSITIVE_FACTOR;
	}
	public String getNEGATIVE_FACTOR() {
		return NEGATIVE_FACTOR;
	}
	public void setNEGATIVE_FACTOR(String nEGATIVE_FACTOR) {
		NEGATIVE_FACTOR = nEGATIVE_FACTOR;
	}
	public String getCONCLUSION() {
		return CONCLUSION;
	}
	public void setCONCLUSION(String cONCLUSION) {
		CONCLUSION = cONCLUSION;
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
	public String getSTNK_NO() {
		return STNK_NO;
	}
	public void setSTNK_NO(String sTNK_NO) {
		STNK_NO = sTNK_NO;
	}
	public String getBPKB_NO() {
		return BPKB_NO;
	}
	public void setBPKB_NO(String bPKB_NO) {
		BPKB_NO = bPKB_NO;
	}
	public String getINVOICE_NO() {
		return INVOICE_NO;
	}
	public void setINVOICE_NO(String iNVOICE_NO) {
		INVOICE_NO = iNVOICE_NO;
	}
	public String getORDER_NO() {
		return ORDER_NO;
	}
	public void setORDER_NO(String oRDER_NO) {
		ORDER_NO = oRDER_NO;
	}
	public String getBPKB_ADDRESS() {
		return BPKB_ADDRESS;
	}
	public void setBPKB_ADDRESS(String bPKB_ADDRESS) {
		BPKB_ADDRESS = bPKB_ADDRESS;
	}
	public String getSTNK_ADDRESS() {
		return STNK_ADDRESS;
	}
	public void setSTNK_ADDRESS(String sTNK_ADDRESS) {
		STNK_ADDRESS = sTNK_ADDRESS;
	}
	public String getINVOICE_ADDRESS() {
		return INVOICE_ADDRESS;
	}
	public void setINVOICE_ADDRESS(String iNVOICE_ADDRESS) {
		INVOICE_ADDRESS = iNVOICE_ADDRESS;
	}
	public String getORDER_ADDRESS() {
		return ORDER_ADDRESS;
	}
	public void setORDER_ADDRESS(String oRDER_ADDRESS) {
		ORDER_ADDRESS = oRDER_ADDRESS;
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
