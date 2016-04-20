package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

import com.mobile.database.app.common.DataConverter;
import com.mobile.database.app.entities.APPR_MAIN;
import com.mobile.database.app.entities.APPR_RTB_VALUATION_INT;
import com.mobile.database.app.entities.BLACKBOX;

public class Datatype_Appr_Rtb_Valuation_Int implements Serializable {

	/**
	 * 
	 */
	public String COL_ID;
	public String AP_REGNO;
	public String REPORT_NO;
	public Date REPORT_DATE;
	public Date REPORT_INSPECT_DATE;
	public String REPORT_BRANCH_CODE;
	public String REPORT_SEG_CODE;
	public String REPORT_APPR_TYPE;
	public String APPR_CPNAME;
	public Date APPR_DATELAPORAN;
	public String KJPP;
	public String APPR_PENILAINAME;
	public String APPR_CPHP;
	public String APPR_CPPHONE;
	public Date APPR_DATESURVEY;
	public String LAND_AREA;
	public String LAND_LIQ_PCT;
	public String LAND_LIQ_VALUE;
	public String LAND_MARKET_VALUE;
	public String LAND_PERMETER_VALUE;
	public String TOTAL_LIQ_VALUE_FISIK;
	public String TOTAL_LIQ_VALUE_IMB;
	public String TOTAL_MARKET_VALUE_FISIK;
	public String TOTAL_MARKET_VALUE_IMB;
	public String BUILD_ASURANSI_AREA;
	public String BUILD_ASURANSI_MARKET;
	public String BUILD_ASURANSI_VALUE;
	public String BUILD_KET;
	public String FINAL_VALUE;
	public String LAND_USE;
	public String BUILD_USE;
	public String UNIT_JUMLAH;
	public String UNIT_LIQ_VALUE;
	public String BUILD_MARKET_VALUE_FISIK_TOTAL;
	public String BUILD_MARKET_VALUE_IMB_TOTAL;
	public String BUILD_LIQ_VALUE_FISIK_TOTAL;
	public String BUILD_LIQ_VALUE_IMB_TOTAL;
	public String UNIT_LIQ_PCT;
	public String APPR_JNSPENILAIAN;
	public String APPR_REKANAN;
	public String UNIT_AREA;
	public String UNIT_PERMETER_VALUE;
	public String UNIT_MARKET_VALUE;
	public String COL_APPRAISER_CODE;
	public String UNIT_BUILD_AREA;
	public String LAND_AREA_AFTER_POTONG ;
   
	 public void updateMainFromJSON(JSONObject obj) throws Exception{
		 COL_ID=obj.getString("COL_ID");
		 AP_REGNO=obj.getString("AP_REGNO");
		 REPORT_NO=obj.getString("REPORT_NO");
		 REPORT_DATE=DataConverter.stringToDate(obj.getString("REPORT_DATE"));
		 REPORT_INSPECT_DATE=DataConverter.stringToDate(obj.getString("REPORT_INSPECT_DATE"));
		 REPORT_BRANCH_CODE=obj.getString("REPORT_BRANCH_CODE");
		 REPORT_SEG_CODE=obj.getString("REPORT_SEG_CODE");
		 REPORT_APPR_TYPE=obj.getString("REPORT_APPR_TYPE");
		 APPR_CPNAME=obj.getString("APPR_CPNAME");
		 APPR_DATELAPORAN=DataConverter.stringToDate(obj.getString("APPR_DATELAPORAN"));
		 KJPP=obj.getString("KJPP");
		 APPR_PENILAINAME=obj.getString("APPR_PENILAINAME");
		 APPR_CPHP=obj.getString("APPR_CPHP");
		 APPR_CPPHONE=obj.getString("APPR_CPPHONE");
		 APPR_DATESURVEY=DataConverter.stringToDate(obj.getString("APPR_DATESURVEY"));
		 LAND_AREA=obj.getString("LAND_AREA");
		 LAND_LIQ_PCT=obj.getString("LAND_LIQ_PCT");
		 LAND_LIQ_VALUE=obj.getString("LAND_LIQ_VALUE");
		 LAND_MARKET_VALUE=obj.getString("LAND_MARKET_VALUE");
		 LAND_PERMETER_VALUE=obj.getString("LAND_PERMETER_VALUE");
		 TOTAL_LIQ_VALUE_FISIK=obj.getString("TOTAL_LIQ_VALUE_FISIK");
		 TOTAL_LIQ_VALUE_IMB=obj.getString("TOTAL_LIQ_VALUE_IMB");
		 TOTAL_MARKET_VALUE_FISIK=obj.getString("TOTAL_MARKET_VALUE_FISIK");
		 TOTAL_MARKET_VALUE_IMB=obj.getString("TOTAL_MARKET_VALUE_IMB");
		 BUILD_ASURANSI_AREA=obj.getString("BUILD_ASURANSI_AREA");
		 BUILD_ASURANSI_MARKET=obj.getString("BUILD_ASURANSI_MARKET");
		 BUILD_ASURANSI_VALUE=obj.getString("BUILD_ASURANSI_VALUE");
		 BUILD_KET=obj.getString("BUILD_KET");
		 FINAL_VALUE=obj.getString("FINAL_VALUE");
		 LAND_USE=obj.getString("LAND_USE");
		 BUILD_USE=obj.getString("BUILD_USE");
		 UNIT_JUMLAH=obj.getString("UNIT_JUMLAH");
		 UNIT_LIQ_VALUE=obj.getString("UNIT_LIQ_VALUE");
		 BUILD_MARKET_VALUE_FISIK_TOTAL=obj.getString("BUILD_MARKET_VALUE_FISIK_TOTAL");
		 BUILD_MARKET_VALUE_IMB_TOTAL=obj.getString("BUILD_MARKET_VALUE_IMB_TOTAL");
		 BUILD_LIQ_VALUE_FISIK_TOTAL=obj.getString("BUILD_LIQ_VALUE_FISIK_TOTAL");
		 BUILD_LIQ_VALUE_IMB_TOTAL=obj.getString("BUILD_LIQ_VALUE_IMB_TOTAL");
		 UNIT_LIQ_PCT=obj.getString("UNIT_LIQ_PCT");
		 APPR_JNSPENILAIAN=obj.getString("APPR_JNSPENILAIAN");
		 APPR_REKANAN=obj.getString("APPR_REKANAN");
		 UNIT_AREA=obj.getString("UNIT_AREA");
		 UNIT_PERMETER_VALUE=obj.getString("UNIT_PERMETER_VALUE");
		 UNIT_MARKET_VALUE=obj.getString("UNIT_MARKET_VALUE");
		 COL_APPRAISER_CODE=obj.getString("COL_APPRAISER_CODE");
		 UNIT_BUILD_AREA=obj.getString("UNIT_BUILD_AREA");
		 LAND_AREA_AFTER_POTONG=obj.getString("LAND_AREA_AFTER_POTONG");
		 
	 }
	 public Datatype_Appr_Rtb_Valuation_Int() {
	    	update("",
	    			"",
	    			"",
	    			null,
	    			null,
	    			"",
	    			"",
	    			"",
	    			"",
	    			null,
	    			"",
	    			"",
	    			"",
	    			"",
	    			null,
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"","");
		}
	    
	 public Datatype_Appr_Rtb_Valuation_Int(APPR_RTB_VALUATION_INT blackbox) {
			update(blackbox);
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
		return REPORT_DATE;
	}

	public void setREPORT_DATE(Date rEPORT_DATE) {
		REPORT_DATE = rEPORT_DATE;
	}

	public Date getREPORT_INSPECT_DATE() {
		return REPORT_INSPECT_DATE;
	}

	public void setREPORT_INSPECT_DATE(Date rEPORT_INSPECT_DATE) {
		REPORT_INSPECT_DATE = rEPORT_INSPECT_DATE;
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
		return APPR_DATELAPORAN;
	}

	public void setAPPR_DATELAPORAN(Date aPPR_DATELAPORAN) {
		APPR_DATELAPORAN = aPPR_DATELAPORAN;
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
		return APPR_DATESURVEY;
	}

	public void setAPPR_DATESURVEY(Date aPPR_DATESURVEY) {
		APPR_DATESURVEY = aPPR_DATESURVEY;
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

	public String getLAND_AREA_AFTER_POTONG() {
		return LAND_AREA_AFTER_POTONG;
	}
	public void setLAND_AREA_AFTER_POTONG(String lAND_AREA_AFTER_POTONG) {
		LAND_AREA_AFTER_POTONG = lAND_AREA_AFTER_POTONG;
	}
	public APPR_RTB_VALUATION_INT toRowData(){
		APPR_RTB_VALUATION_INT rowData= new APPR_RTB_VALUATION_INT();
		rowData.setCOL_ID(COL_ID);
		rowData.setAP_REGNO(AP_REGNO);
		rowData.setREPORT_NO(REPORT_NO);
		rowData.setREPORT_DATE(REPORT_DATE);
		rowData.setREPORT_INSPECT_DATE(REPORT_INSPECT_DATE);
		rowData.setREPORT_BRANCH_CODE(REPORT_BRANCH_CODE);
		rowData.setREPORT_SEG_CODE(REPORT_SEG_CODE);
		rowData.setREPORT_APPR_TYPE(REPORT_APPR_TYPE);
		rowData.setAPPR_CPNAME(APPR_CPNAME);
		rowData.setAPPR_DATELAPORAN(APPR_DATELAPORAN);
		rowData.setKJPP(KJPP);
		rowData.setAPPR_PENILAINAME(APPR_PENILAINAME);
		rowData.setAPPR_CPHP(APPR_CPHP);
		rowData.setAPPR_CPPHONE(APPR_CPPHONE);
		rowData.setAPPR_DATESURVEY(APPR_DATESURVEY);
		rowData.setLAND_AREA(LAND_AREA);
		rowData.setLAND_LIQ_PCT(LAND_LIQ_PCT);
		rowData.setLAND_LIQ_VALUE(LAND_LIQ_VALUE);
		rowData.setLAND_MARKET_VALUE(LAND_MARKET_VALUE);
		rowData.setLAND_PERMETER_VALUE(LAND_PERMETER_VALUE);
		rowData.setTOTAL_LIQ_VALUE_FISIK(TOTAL_LIQ_VALUE_FISIK);
		rowData.setTOTAL_LIQ_VALUE_IMB(TOTAL_LIQ_VALUE_IMB);
		rowData.setTOTAL_MARKET_VALUE_FISIK(TOTAL_MARKET_VALUE_FISIK);
		rowData.setTOTAL_MARKET_VALUE_IMB(TOTAL_MARKET_VALUE_IMB);
		rowData.setBUILD_ASURANSI_AREA(BUILD_ASURANSI_AREA);
		rowData.setBUILD_ASURANSI_MARKET(BUILD_ASURANSI_MARKET);
		rowData.setBUILD_ASURANSI_VALUE(BUILD_ASURANSI_VALUE);
		rowData.setBUILD_KET(BUILD_KET);
		rowData.setFINAL_VALUE(FINAL_VALUE);
		rowData.setLAND_USE(LAND_USE);
		rowData.setBUILD_USE(BUILD_USE);
		rowData.setUNIT_JUMLAH(UNIT_JUMLAH);
		rowData.setUNIT_LIQ_VALUE(UNIT_LIQ_VALUE);
		rowData.setBUILD_MARKET_VALUE_FISIK_TOTAL(BUILD_MARKET_VALUE_FISIK_TOTAL);
		rowData.setBUILD_MARKET_VALUE_IMB_TOTAL(BUILD_MARKET_VALUE_IMB_TOTAL);
		rowData.setBUILD_LIQ_VALUE_FISIK_TOTAL(BUILD_LIQ_VALUE_FISIK_TOTAL);
		rowData.setBUILD_LIQ_VALUE_IMB_TOTAL(BUILD_LIQ_VALUE_IMB_TOTAL);
		rowData.setUNIT_LIQ_PCT(UNIT_LIQ_PCT);
		rowData.setAPPR_JNSPENILAIAN(APPR_JNSPENILAIAN);
		rowData.setAPPR_REKANAN(APPR_REKANAN);
		rowData.setUNIT_AREA(UNIT_AREA);
		rowData.setUNIT_PERMETER_VALUE(UNIT_PERMETER_VALUE);
		rowData.setUNIT_MARKET_VALUE(UNIT_MARKET_VALUE);
		rowData.setCOL_APPRAISER_CODE(COL_APPRAISER_CODE);
		rowData.setUNIT_BUILD_AREA(UNIT_BUILD_AREA);
		rowData.setLAND_AREA_AFTER_POTONG(LAND_AREA_AFTER_POTONG);
		
	
		return rowData;
	}
	
	public void update(APPR_RTB_VALUATION_INT rowData) {
		COL_ID=rowData.getCOL_ID();
		AP_REGNO=rowData.getAP_REGNO();
		REPORT_NO=rowData.getREPORT_NO();
		REPORT_DATE=rowData.getREPORT_DATE();
		REPORT_INSPECT_DATE=rowData.getREPORT_INSPECT_DATE();
		REPORT_BRANCH_CODE=rowData.getREPORT_BRANCH_CODE();
		REPORT_SEG_CODE=rowData.getREPORT_SEG_CODE();
		REPORT_APPR_TYPE=rowData.getREPORT_APPR_TYPE();
		APPR_CPNAME=rowData.getAPPR_CPNAME();
		APPR_DATELAPORAN=rowData.getAPPR_DATELAPORAN();
		KJPP=rowData.getKJPP();
		APPR_PENILAINAME=rowData.getAPPR_PENILAINAME();
		APPR_CPHP=rowData.getAPPR_CPHP();
		APPR_CPPHONE=rowData.getAPPR_CPPHONE();
		APPR_DATESURVEY=rowData.getAPPR_DATESURVEY();
		LAND_AREA=rowData.getLAND_AREA();
		LAND_LIQ_PCT=rowData.getLAND_LIQ_PCT();
		LAND_LIQ_VALUE=rowData.getLAND_LIQ_VALUE();
		LAND_MARKET_VALUE=rowData.getLAND_MARKET_VALUE();
		LAND_PERMETER_VALUE=rowData.getLAND_PERMETER_VALUE();
		TOTAL_LIQ_VALUE_FISIK=rowData.getTOTAL_LIQ_VALUE_FISIK();
		TOTAL_LIQ_VALUE_IMB=rowData.getTOTAL_LIQ_VALUE_IMB();
		TOTAL_MARKET_VALUE_FISIK=rowData.getTOTAL_MARKET_VALUE_FISIK();
		TOTAL_MARKET_VALUE_IMB=rowData.getTOTAL_MARKET_VALUE_IMB();
		BUILD_ASURANSI_AREA=rowData.getBUILD_ASURANSI_AREA();
		BUILD_ASURANSI_MARKET=rowData.getBUILD_ASURANSI_MARKET();
		BUILD_ASURANSI_VALUE=rowData.getBUILD_ASURANSI_VALUE();
		BUILD_KET=rowData.getBUILD_KET();
		FINAL_VALUE=rowData.getFINAL_VALUE();
		LAND_USE=rowData.getLAND_USE();
		BUILD_USE=rowData.getBUILD_USE();
		UNIT_JUMLAH=rowData.getUNIT_JUMLAH();
		UNIT_LIQ_VALUE=rowData.getUNIT_LIQ_VALUE();
		BUILD_MARKET_VALUE_FISIK_TOTAL=rowData.getBUILD_MARKET_VALUE_FISIK_TOTAL();
		BUILD_MARKET_VALUE_IMB_TOTAL=rowData.getBUILD_MARKET_VALUE_IMB_TOTAL();
		BUILD_LIQ_VALUE_FISIK_TOTAL=rowData.getBUILD_LIQ_VALUE_FISIK_TOTAL();
		BUILD_LIQ_VALUE_IMB_TOTAL=rowData.getBUILD_LIQ_VALUE_IMB_TOTAL();
		UNIT_LIQ_PCT=rowData.getUNIT_LIQ_PCT();
		APPR_JNSPENILAIAN=rowData.getAPPR_JNSPENILAIAN();
		APPR_REKANAN=rowData.getAPPR_REKANAN();
		UNIT_AREA=rowData.getUNIT_AREA();
		UNIT_PERMETER_VALUE=rowData.getUNIT_PERMETER_VALUE();
		UNIT_MARKET_VALUE=rowData.getUNIT_MARKET_VALUE();
		COL_APPRAISER_CODE=rowData.getCOL_APPRAISER_CODE();
		UNIT_BUILD_AREA=rowData.getUNIT_BUILD_AREA();
		LAND_AREA_AFTER_POTONG=rowData.getLAND_AREA_AFTER_POTONG();
		
	}
	
	
	public void update(String col_id,
			String ap_regno,
			String report_no,
			Date report_date,
			Date report_inspect_date,
			String report_branch_code,
			String report_seg_code,
			String report_appr_type,
			String appr_cpname,
			Date appr_datelaporan,
			String kjpp,
			String appr_penilainame,
			String appr_cphp,
			String appr_cpphone,
			Date appr_datesurvey,
			String land_area,
			String land_liq_pct,
			String land_liq_value,
			String land_market_value,
			String land_permeter_value,
			String total_liq_value_fisik,
			String total_liq_value_imb,
			String total_market_value_fisik,
			String total_market_value_imb,
			String build_asuransi_area,
			String build_asuransi_market,
			String build_asuransi_value,
			String build_ket,
			String final_value,
			String land_use,
			String build_use,
			String unit_jumlah,
			String unit_liq_value,
			String build_market_value_fisik_total,
			String build_market_value_imb_total,
			String build_liq_value_fisik_total,
			String build_liq_value_imb_total,
			String unit_liq_pct,
			String appr_jnspenilaian,
			String appr_rekanan,
			String unit_area,
			String unit_permeter_value,
			String unit_market_value,
			String col_appraiser_code,
			String unit_build_area,String land_area_after_potong){
		COL_ID=col_id;
		AP_REGNO=ap_regno;
		REPORT_NO=report_no;
		REPORT_DATE=report_date;
		REPORT_INSPECT_DATE=report_inspect_date;
		REPORT_BRANCH_CODE=report_branch_code;
		REPORT_SEG_CODE=report_seg_code;
		REPORT_APPR_TYPE=report_appr_type;
		APPR_CPNAME=appr_cpname;
		APPR_DATELAPORAN=appr_datelaporan;
		KJPP=kjpp;
		APPR_PENILAINAME=appr_penilainame;
		APPR_CPHP=appr_cphp;
		APPR_CPPHONE=appr_cpphone;
		APPR_DATESURVEY=appr_datesurvey;
		LAND_AREA=land_area;
		LAND_LIQ_PCT=land_liq_pct;
		LAND_LIQ_VALUE=land_liq_value;
		LAND_MARKET_VALUE=land_market_value;
		LAND_PERMETER_VALUE=land_permeter_value;
		TOTAL_LIQ_VALUE_FISIK=total_liq_value_fisik;
		TOTAL_LIQ_VALUE_IMB=total_liq_value_imb;
		TOTAL_MARKET_VALUE_FISIK=total_market_value_fisik;
		TOTAL_MARKET_VALUE_IMB=total_market_value_imb;
		BUILD_ASURANSI_AREA=build_asuransi_area;
		BUILD_ASURANSI_MARKET=build_asuransi_market;
		BUILD_ASURANSI_VALUE=build_asuransi_value;
		BUILD_KET=build_ket;
		FINAL_VALUE=final_value;
		LAND_USE=land_use;
		BUILD_USE=build_use;
		UNIT_JUMLAH=unit_jumlah;
		UNIT_LIQ_VALUE=unit_liq_value;
		BUILD_MARKET_VALUE_FISIK_TOTAL=build_market_value_fisik_total;
		BUILD_MARKET_VALUE_IMB_TOTAL=build_market_value_imb_total;
		BUILD_LIQ_VALUE_FISIK_TOTAL=build_liq_value_fisik_total;
		BUILD_LIQ_VALUE_IMB_TOTAL=build_liq_value_imb_total;
		UNIT_LIQ_PCT=unit_liq_pct;
		APPR_JNSPENILAIAN=appr_jnspenilaian;
		APPR_REKANAN=appr_rekanan;
		UNIT_AREA=unit_area;
		UNIT_PERMETER_VALUE=unit_permeter_value;
		UNIT_MARKET_VALUE=unit_market_value;
		COL_APPRAISER_CODE=col_appraiser_code;
		UNIT_BUILD_AREA=unit_build_area;
		LAND_AREA_AFTER_POTONG=land_area_after_potong;
		
	}
	
	public void updateDataToNullForKenalan(){
		/*NAMADEBITUR="";
	    TGLLAHIR="";
	    JENISPEMBIAYAAN="";
	    HANDPHONE="";
	    FOTOLOKASI="";*/
	}
	
	public void updateDataToNullForPendekatan(){
	    /*TELEPONRUMAH="";
	    ALAMATRUMAH="";
	    PLAFOND="";
	    KTP="";
	    NPWP="";
	    SIUPSKU="";*/
	}
	
	public void updateDataToNullForClosing(){

	}
}
