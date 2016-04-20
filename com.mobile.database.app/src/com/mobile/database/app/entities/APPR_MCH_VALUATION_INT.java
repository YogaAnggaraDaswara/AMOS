package com.mobile.database.app.entities;

import java.util.Date;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="APPR_MCH_VALUATION_INT")
public class APPR_MCH_VALUATION_INT {
	@DatabaseField(id=true,unique=true,canBeNull=false,uniqueIndexName="APPR_MCH_VALUATION_INT_PK",dataType=DataType.STRING,width=16) private String COL_ID;
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
	@DatabaseField(dataType=DataType.STRING,width=10) private String DOC_CODE;
	@DatabaseField(dataType=DataType.STRING,width=20) private String DOC_NO;
	@DatabaseField(dataType=DataType.STRING,width=8) private String DOC_DATE;
	@DatabaseField(dataType=DataType.STRING,width=100) private String MCH_CODE;
	@DatabaseField(dataType=DataType.STRING,width=50) private String MCH_BRAND;
	@DatabaseField(dataType=DataType.STRING,width=50) private String MCH_MODEL;
	@DatabaseField(dataType=DataType.STRING,width=4) private String CREATED_YEAR;
	@DatabaseField(dataType=DataType.STRING,width=10) private String MCH_COND;
	@DatabaseField(dataType=DataType.STRING,width=1) private String ON_USE;
	@DatabaseField(dataType=DataType.STRING,width=50) private String ON_USE_REASON;
	@DatabaseField(dataType=DataType.STRING,width=10) private String OTHER;
	@DatabaseField(dataType=DataType.STRING,width=8) private String RANGE_PRICE;
	@DatabaseField(dataType=DataType.STRING,width=8) private String MARKET_PRICE;
	@DatabaseField(dataType=DataType.STRING,width=8) private String SAFETY_MARGIN;
	@DatabaseField(dataType=DataType.STRING,width=8) private String AFTER_SAFETY_MARGIN_PRICE;
	@DatabaseField(dataType=DataType.STRING,width=8) private String LIQUID_PERCENT;
	@DatabaseField(dataType=DataType.STRING,width=8) private String LIQUID_VALUE;
	@DatabaseField(dataType=DataType.STRING,width=200) private String BASIC_VALUATION;
	@DatabaseField(dataType=DataType.STRING,width=50) private String INSPECTION_PERSON;
	@DatabaseField(dataType=DataType.STRING,width=1) private String INSPECTION_BUSINESSUNIT;
	@DatabaseField(dataType=DataType.STRING,width=200) private String TAXAXY_OPINION;
	@DatabaseField(dataType=DataType.STRING,width=16) private String OTHER_INFO;
	@DatabaseField(dataType=DataType.STRING,width=200) private String MCH_FUNGSI;
	@DatabaseField(dataType=DataType.STRING,width=100) private String DOC_NOSERI;
	@DatabaseField(dataType=DataType.STRING,width=100) private String APPR_PENILAINAME;
	@DatabaseField(dataType=DataType.STRING,width=1) private String APPR_REKANAN;
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
	public String getDOC_CODE() {
		return DOC_CODE;
	}
	public void setDOC_CODE(String dOC_CODE) {
		DOC_CODE = dOC_CODE;
	}
	public String getDOC_NO() {
		return DOC_NO;
	}
	public void setDOC_NO(String dOC_NO) {
		DOC_NO = dOC_NO;
	}
	public Date getDOC_DATE() {
		return DataConverter.stringToDate(DOC_DATE);
	}
	public void setDOC_DATE(Date dOC_DATE) {
		DOC_DATE = DataConverter.dateToString(dOC_DATE);
	}
	public String getMCH_CODE() {
		return MCH_CODE;
	}
	public void setMCH_CODE(String mCH_CODE) {
		MCH_CODE = mCH_CODE;
	}
	public String getMCH_BRAND() {
		return MCH_BRAND;
	}
	public void setMCH_BRAND(String mCH_BRAND) {
		MCH_BRAND = mCH_BRAND;
	}
	public String getMCH_MODEL() {
		return MCH_MODEL;
	}
	public void setMCH_MODEL(String mCH_MODEL) {
		MCH_MODEL = mCH_MODEL;
	}
	public String getCREATED_YEAR() {
		return CREATED_YEAR;
	}
	public void setCREATED_YEAR(String cREATED_YEAR) {
		CREATED_YEAR = cREATED_YEAR;
	}
	public String getMCH_COND() {
		return MCH_COND;
	}
	public void setMCH_COND(String mCH_COND) {
		MCH_COND = mCH_COND;
	}
	public String getON_USE() {
		return ON_USE;
	}
	public void setON_USE(String oN_USE) {
		ON_USE = oN_USE;
	}
	public String getON_USE_REASON() {
		return ON_USE_REASON;
	}
	public void setON_USE_REASON(String oN_USE_REASON) {
		ON_USE_REASON = oN_USE_REASON;
	}
	public String getOTHER() {
		return OTHER;
	}
	public void setOTHER(String oTHER) {
		OTHER = oTHER;
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
	public String getBASIC_VALUATION() {
		return BASIC_VALUATION;
	}
	public void setBASIC_VALUATION(String bASIC_VALUATION) {
		BASIC_VALUATION = bASIC_VALUATION;
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
	public String getMCH_FUNGSI() {
		return MCH_FUNGSI;
	}
	public void setMCH_FUNGSI(String mCH_FUNGSI) {
		MCH_FUNGSI = mCH_FUNGSI;
	}
	public String getDOC_NOSERI() {
		return DOC_NOSERI;
	}
	public void setDOC_NOSERI(String dOC_NOSERI) {
		DOC_NOSERI = dOC_NOSERI;
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

}
