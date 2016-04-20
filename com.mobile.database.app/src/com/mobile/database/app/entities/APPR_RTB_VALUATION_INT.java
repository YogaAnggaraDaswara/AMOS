package com.mobile.database.app.entities;

import java.util.Date;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="APPR_RTB_VALUATION_INT")
public class APPR_RTB_VALUATION_INT {
	@DatabaseField(id=true,unique=true,canBeNull=false,uniqueIndexName="APPR_RTB_VALUATION_INT_PK",dataType=DataType.STRING,width=16) private String COL_ID;
	@DatabaseField(dataType=DataType.STRING,width=20) private String AP_REGNO;
	@DatabaseField(dataType=DataType.STRING,width=100) private String REPORT_NO;
	@DatabaseField(dataType=DataType.STRING,width=8) private String REPORT_DATE;
	@DatabaseField(dataType=DataType.STRING,width=8) private String REPORT_INSPECT_DATE;
	@DatabaseField(dataType=DataType.STRING,width=10) private String REPORT_BRANCH_CODE;
	@DatabaseField(dataType=DataType.STRING,width=10) private String REPORT_SEG_CODE;
	@DatabaseField(dataType=DataType.STRING,width=1) private String REPORT_APPR_TYPE;
	@DatabaseField(dataType=DataType.STRING,width=100) private String APPR_CPNAME;
	@DatabaseField(dataType=DataType.STRING,width=8) private String APPR_DATELAPORAN;
	@DatabaseField(dataType=DataType.STRING,width=100) private String KJPP;
	@DatabaseField(dataType=DataType.STRING,width=100) private String APPR_PENILAINAME;
	@DatabaseField(dataType=DataType.STRING,width=30) private String APPR_CPHP;
	@DatabaseField(dataType=DataType.STRING,width=30) private String APPR_CPPHONE;
	@DatabaseField(dataType=DataType.STRING,width=8) private String APPR_DATESURVEY;
	@DatabaseField(dataType=DataType.STRING,width=8) private String LAND_AREA;
	@DatabaseField(dataType=DataType.STRING,width=4) private String LAND_LIQ_PCT;
	@DatabaseField(dataType=DataType.STRING,width=8) private String LAND_LIQ_VALUE;
	@DatabaseField(dataType=DataType.STRING,width=8) private String LAND_MARKET_VALUE;
	@DatabaseField(dataType=DataType.STRING,width=8) private String LAND_PERMETER_VALUE;
	@DatabaseField(dataType=DataType.STRING,width=9) private String TOTAL_LIQ_VALUE_FISIK;
	@DatabaseField(dataType=DataType.STRING,width=8) private String TOTAL_LIQ_VALUE_IMB;
	@DatabaseField(dataType=DataType.STRING,width=9) private String TOTAL_MARKET_VALUE_FISIK;
	@DatabaseField(dataType=DataType.STRING,width=8) private String TOTAL_MARKET_VALUE_IMB;
	@DatabaseField(dataType=DataType.STRING,width=8) private String BUILD_ASURANSI_AREA;
	@DatabaseField(dataType=DataType.STRING,width=8) private String BUILD_ASURANSI_MARKET;
	@DatabaseField(dataType=DataType.STRING,width=8) private String BUILD_ASURANSI_VALUE;
	@DatabaseField(dataType=DataType.STRING,width=300) private String BUILD_KET;
	@DatabaseField(dataType=DataType.STRING,width=8) private String FINAL_VALUE;
	@DatabaseField(dataType=DataType.STRING,width=1) private String LAND_USE;
	@DatabaseField(dataType=DataType.STRING,width=1) private String BUILD_USE;
	@DatabaseField(dataType=DataType.STRING,width=4) private String UNIT_JUMLAH;
	@DatabaseField(dataType=DataType.STRING,width=8) private String UNIT_LIQ_VALUE;
	@DatabaseField(dataType=DataType.STRING,width=9) private String BUILD_MARKET_VALUE_FISIK_TOTAL;
	@DatabaseField(dataType=DataType.STRING,width=8) private String BUILD_MARKET_VALUE_IMB_TOTAL;
	@DatabaseField(dataType=DataType.STRING,width=9) private String BUILD_LIQ_VALUE_FISIK_TOTAL;
	@DatabaseField(dataType=DataType.STRING,width=8) private String BUILD_LIQ_VALUE_IMB_TOTAL;
	@DatabaseField(dataType=DataType.STRING,width=8) private String UNIT_LIQ_PCT;
	@DatabaseField(dataType=DataType.STRING,width=10) private String APPR_JNSPENILAIAN;
	@DatabaseField(dataType=DataType.STRING,width=1) private String APPR_REKANAN;
	@DatabaseField(dataType=DataType.STRING,width=8) private String UNIT_AREA;
	@DatabaseField(dataType=DataType.STRING,width=8) private String UNIT_PERMETER_VALUE;
	@DatabaseField(dataType=DataType.STRING,width=8) private String UNIT_MARKET_VALUE;
	@DatabaseField(dataType=DataType.STRING,width=10) private String COL_APPRAISER_CODE;
	@DatabaseField(dataType=DataType.STRING,width=8) private String UNIT_BUILD_AREA;
	@DatabaseField(dataType=DataType.STRING,width=50) private String LAND_AREA_AFTER_POTONG;
	public String getLAND_AREA_AFTER_POTONG() {
		return LAND_AREA_AFTER_POTONG;
	}
	public void setLAND_AREA_AFTER_POTONG(String lAND_AREA_AFTER_POTONG) {
		LAND_AREA_AFTER_POTONG = lAND_AREA_AFTER_POTONG;
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
		REPORT_INSPECT_DATE = DataConverter.dateToString( rEPORT_INSPECT_DATE);
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
	public String getAPPR_CPNAME() {
		return APPR_CPNAME;
	}
	public void setAPPR_CPNAME(String aPPR_CPNAME) {
		APPR_CPNAME = aPPR_CPNAME;
	}
	public Date getAPPR_DATELAPORAN() {
		return DataConverter.stringToDateTime(APPR_DATELAPORAN);
	}
	public void setAPPR_DATELAPORAN(Date aPPR_DATELAPORAN) {
		APPR_DATELAPORAN = DataConverter.dateToString( aPPR_DATELAPORAN);
	}
	public String getKJPP() {
		return KJPP;
	}
	public void setKJPP(String kJPP) {
		KJPP = kJPP;
	}
	public String getAPPR_PENILAINAME() {
		return APPR_PENILAINAME;
	}
	public void setAPPR_PENILAINAME(String aPPR_PENILAINAME) {
		APPR_PENILAINAME = aPPR_PENILAINAME;
	}
	public String getAPPR_CPHP() {
		return APPR_CPHP;
	}
	public void setAPPR_CPHP(String aPPR_CPHP) {
		APPR_CPHP = aPPR_CPHP;
	}
	public String getAPPR_CPPHONE() {
		return APPR_CPPHONE;
	}
	public void setAPPR_CPPHONE(String aPPR_CPPHONE) {
		APPR_CPPHONE = aPPR_CPPHONE;
	}
	public Date getAPPR_DATESURVEY() {
		return DataConverter.stringToDateTime(APPR_DATESURVEY);
	}
	public void setAPPR_DATESURVEY(Date aPPR_DATESURVEY) {
		APPR_DATESURVEY = DataConverter.dateToString( aPPR_DATESURVEY);
	}
	public String getLAND_AREA() {
		return LAND_AREA;
	}
	public void setLAND_AREA(String lAND_AREA) {
		LAND_AREA = lAND_AREA;
	}
	public String getLAND_LIQ_PCT() {
		return LAND_LIQ_PCT;
	}
	public void setLAND_LIQ_PCT(String lAND_LIQ_PCT) {
		LAND_LIQ_PCT = lAND_LIQ_PCT;
	}
	public String getLAND_LIQ_VALUE() {
		return LAND_LIQ_VALUE;
	}
	public void setLAND_LIQ_VALUE(String lAND_LIQ_VALUE) {
		LAND_LIQ_VALUE = lAND_LIQ_VALUE;
	}
	public String getLAND_MARKET_VALUE() {
		return LAND_MARKET_VALUE;
	}
	public void setLAND_MARKET_VALUE(String lAND_MARKET_VALUE) {
		LAND_MARKET_VALUE = lAND_MARKET_VALUE;
	}
	public String getLAND_PERMETER_VALUE() {
		return LAND_PERMETER_VALUE;
	}
	public void setLAND_PERMETER_VALUE(String lAND_PERMETER_VALUE) {
		LAND_PERMETER_VALUE = lAND_PERMETER_VALUE;
	}
	public String getTOTAL_LIQ_VALUE_FISIK() {
		return TOTAL_LIQ_VALUE_FISIK;
	}
	public void setTOTAL_LIQ_VALUE_FISIK(String tOTAL_LIQ_VALUE_FISIK) {
		TOTAL_LIQ_VALUE_FISIK = tOTAL_LIQ_VALUE_FISIK;
	}
	public String getTOTAL_LIQ_VALUE_IMB() {
		return TOTAL_LIQ_VALUE_IMB;
	}
	public void setTOTAL_LIQ_VALUE_IMB(String tOTAL_LIQ_VALUE_IMB) {
		TOTAL_LIQ_VALUE_IMB = tOTAL_LIQ_VALUE_IMB;
	}
	public String getTOTAL_MARKET_VALUE_FISIK() {
		return TOTAL_MARKET_VALUE_FISIK;
	}
	public void setTOTAL_MARKET_VALUE_FISIK(String tOTAL_MARKET_VALUE_FISIK) {
		TOTAL_MARKET_VALUE_FISIK = tOTAL_MARKET_VALUE_FISIK;
	}
	public String getTOTAL_MARKET_VALUE_IMB() {
		return TOTAL_MARKET_VALUE_IMB;
	}
	public void setTOTAL_MARKET_VALUE_IMB(String tOTAL_MARKET_VALUE_IMB) {
		TOTAL_MARKET_VALUE_IMB = tOTAL_MARKET_VALUE_IMB;
	}
	public String getBUILD_ASURANSI_AREA() {
		return BUILD_ASURANSI_AREA;
	}
	public void setBUILD_ASURANSI_AREA(String bUILD_ASURANSI_AREA) {
		BUILD_ASURANSI_AREA = bUILD_ASURANSI_AREA;
	}
	public String getBUILD_ASURANSI_MARKET() {
		return BUILD_ASURANSI_MARKET;
	}
	public void setBUILD_ASURANSI_MARKET(String bUILD_ASURANSI_MARKET) {
		BUILD_ASURANSI_MARKET = bUILD_ASURANSI_MARKET;
	}
	public String getBUILD_ASURANSI_VALUE() {
		return BUILD_ASURANSI_VALUE;
	}
	public void setBUILD_ASURANSI_VALUE(String bUILD_ASURANSI_VALUE) {
		BUILD_ASURANSI_VALUE = bUILD_ASURANSI_VALUE;
	}
	public String getBUILD_KET() {
		return BUILD_KET;
	}
	public void setBUILD_KET(String bUILD_KET) {
		BUILD_KET = bUILD_KET;
	}
	public String getFINAL_VALUE() {
		return FINAL_VALUE;
	}
	public void setFINAL_VALUE(String fINAL_VALUE) {
		FINAL_VALUE = fINAL_VALUE;
	}
	public String getLAND_USE() {
		return LAND_USE;
	}
	public void setLAND_USE(String lAND_USE) {
		LAND_USE = lAND_USE;
	}
	public String getBUILD_USE() {
		return BUILD_USE;
	}
	public void setBUILD_USE(String bUILD_USE) {
		BUILD_USE = bUILD_USE;
	}
	public String getUNIT_JUMLAH() {
		return UNIT_JUMLAH;
	}
	public void setUNIT_JUMLAH(String uNIT_JUMLAH) {
		UNIT_JUMLAH = uNIT_JUMLAH;
	}
	public String getUNIT_LIQ_VALUE() {
		return UNIT_LIQ_VALUE;
	}
	public void setUNIT_LIQ_VALUE(String uNIT_LIQ_VALUE) {
		UNIT_LIQ_VALUE = uNIT_LIQ_VALUE;
	}
	public String getBUILD_MARKET_VALUE_FISIK_TOTAL() {
		return BUILD_MARKET_VALUE_FISIK_TOTAL;
	}
	public void setBUILD_MARKET_VALUE_FISIK_TOTAL(
			String bUILD_MARKET_VALUE_FISIK_TOTAL) {
		BUILD_MARKET_VALUE_FISIK_TOTAL = bUILD_MARKET_VALUE_FISIK_TOTAL;
	}
	public String getBUILD_MARKET_VALUE_IMB_TOTAL() {
		return BUILD_MARKET_VALUE_IMB_TOTAL;
	}
	public void setBUILD_MARKET_VALUE_IMB_TOTAL(String bUILD_MARKET_VALUE_IMB_TOTAL) {
		BUILD_MARKET_VALUE_IMB_TOTAL = bUILD_MARKET_VALUE_IMB_TOTAL;
	}
	public String getBUILD_LIQ_VALUE_FISIK_TOTAL() {
		return BUILD_LIQ_VALUE_FISIK_TOTAL;
	}
	public void setBUILD_LIQ_VALUE_FISIK_TOTAL(String bUILD_LIQ_VALUE_FISIK_TOTAL) {
		BUILD_LIQ_VALUE_FISIK_TOTAL = bUILD_LIQ_VALUE_FISIK_TOTAL;
	}
	public String getBUILD_LIQ_VALUE_IMB_TOTAL() {
		return BUILD_LIQ_VALUE_IMB_TOTAL;
	}
	public void setBUILD_LIQ_VALUE_IMB_TOTAL(String bUILD_LIQ_VALUE_IMB_TOTAL) {
		BUILD_LIQ_VALUE_IMB_TOTAL = bUILD_LIQ_VALUE_IMB_TOTAL;
	}
	public String getUNIT_LIQ_PCT() {
		return UNIT_LIQ_PCT;
	}
	public void setUNIT_LIQ_PCT(String uNIT_LIQ_PCT) {
		UNIT_LIQ_PCT = uNIT_LIQ_PCT;
	}
	public String getAPPR_JNSPENILAIAN() {
		return APPR_JNSPENILAIAN;
	}
	public void setAPPR_JNSPENILAIAN(String aPPR_JNSPENILAIAN) {
		APPR_JNSPENILAIAN = aPPR_JNSPENILAIAN;
	}
	public String getAPPR_REKANAN() {
		return APPR_REKANAN;
	}
	public void setAPPR_REKANAN(String aPPR_REKANAN) {
		APPR_REKANAN = aPPR_REKANAN;
	}
	public String getUNIT_AREA() {
		return UNIT_AREA;
	}
	public void setUNIT_AREA(String uNIT_AREA) {
		UNIT_AREA = uNIT_AREA;
	}
	public String getUNIT_PERMETER_VALUE() {
		return UNIT_PERMETER_VALUE;
	}
	public void setUNIT_PERMETER_VALUE(String uNIT_PERMETER_VALUE) {
		UNIT_PERMETER_VALUE = uNIT_PERMETER_VALUE;
	}
	public String getUNIT_MARKET_VALUE() {
		return UNIT_MARKET_VALUE;
	}
	public void setUNIT_MARKET_VALUE(String uNIT_MARKET_VALUE) {
		UNIT_MARKET_VALUE = uNIT_MARKET_VALUE;
	}
	public String getCOL_APPRAISER_CODE() {
		return COL_APPRAISER_CODE;
	}
	public void setCOL_APPRAISER_CODE(String cOL_APPRAISER_CODE) {
		COL_APPRAISER_CODE = cOL_APPRAISER_CODE;
	}
	public String getUNIT_BUILD_AREA() {
		return UNIT_BUILD_AREA;
	}
	public void setUNIT_BUILD_AREA(String uNIT_BUILD_AREA) {
		UNIT_BUILD_AREA = uNIT_BUILD_AREA;
	}



}
