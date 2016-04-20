package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

import com.mobile.database.app.common.DataConverter;
import com.mobile.database.app.entities.APPR_MAIN;
import com.mobile.database.app.entities.APPR_PB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_RTB_CEK_TATA_KOTA_INT;
import com.mobile.database.app.entities.APPR_RTB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_VHC_VALUATION_INT;
import com.mobile.database.app.entities.BLACKBOX;

public class Datatype_Appr_Pb_Valuation_Int implements Serializable {

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
	public String COL_ADDR1;
	public String COL_ADDR2;
	public String COL_ADDR3;
	public String COL_RT;
	public String COL_RW;
	public String COL_KELURAHAN;
	public String COL_KECAMATAN;
	public String COL_CITY;
	public String COL_ZIPCODE;
	public String COL_BRANCH_CODE;
	public Date COL_REQ_DATE;
	public String COL_APPRAISER_CODE;
	public Date COL_INSPECT_DATE;
	public String COL_INSPECT_PERSON;
	public String PB_RANDOM_SAMPLING_COUNT;
	public String PB_TOTAL_ITEM;
	public Date PB_BII_DATE;
	public String PB_FIRETOOL;
	public String PB_FIRETOOL_OWNED;
	public String PB_SECURITY;
	public String PB_SECURITY_OWNED;
	public String PB_FLOOD_RISK;
	public String PB_FLOOD_RISK_INTERVAL;
	public String INSPECTION_PERSON;
	public String INSPECTION_BUSINESSUNIT;
	public String TAXAXY_OPINION;
	public String OTHER_INFO;
	public String APPR_PENILAINAME;
	public String APPR_REKANAN;


	 public void updateMainFromJSON(JSONObject obj) throws Exception{
		 COL_ID=obj.getString("COL_ID");
		 AP_REGNO=obj.getString("AP_REGNO");
		 REPORT_NO=obj.getString("REPORT_NO");
		 REPORT_DATE=DataConverter.stringToDate(obj.getString("REPORT_DATE"));
		 REPORT_INSPECT_DATE=DataConverter.stringToDate(obj.getString("REPORT_INSPECT_DATE"));
		 REPORT_BRANCH_CODE=obj.getString("REPORT_BRANCH_CODE");
		 REPORT_SEG_CODE=obj.getString("REPORT_SEG_CODE");
		 REPORT_APPR_TYPE=obj.getString("REPORT_APPR_TYPE");
		 COL_ADDR1=obj.getString("COL_ADDR1");
		 COL_ADDR2=obj.getString("COL_ADDR2");
		 COL_ADDR3=obj.getString("COL_ADDR3");
		 COL_RT=obj.getString("COL_RT");
		 COL_RW=obj.getString("COL_RW");
		 COL_KELURAHAN=obj.getString("COL_KELURAHAN");
		 COL_KECAMATAN=obj.getString("COL_KECAMATAN");
		 COL_CITY=obj.getString("COL_CITY");
		 COL_ZIPCODE=obj.getString("COL_ZIPCODE");
		 COL_BRANCH_CODE=obj.getString("COL_BRANCH_CODE");
		 COL_REQ_DATE=DataConverter.stringToDate(obj.getString("COL_REQ_DATE"));
		 COL_APPRAISER_CODE=obj.getString("COL_APPRAISER_CODE");
		 COL_INSPECT_DATE=DataConverter.stringToDate(obj.getString("COL_INSPECT_DATE"));
		 COL_INSPECT_PERSON=obj.getString("COL_INSPECT_PERSON");
		 PB_RANDOM_SAMPLING_COUNT=obj.getString("PB_RANDOM_SAMPLING_COUNT");
		 PB_TOTAL_ITEM=obj.getString("PB_TOTAL_ITEM");
		 PB_BII_DATE=DataConverter.stringToDate(obj.getString("PB_BII_DATE"));
		 PB_FIRETOOL=obj.getString("PB_FIRETOOL");
		 PB_FIRETOOL_OWNED=obj.getString("PB_FIRETOOL_OWNED");
		 PB_SECURITY=obj.getString("PB_SECURITY");
		 PB_SECURITY_OWNED=obj.getString("PB_SECURITY_OWNED");
		 PB_FLOOD_RISK=obj.getString("PB_FLOOD_RISK");
		 PB_FLOOD_RISK_INTERVAL=obj.getString("PB_FLOOD_RISK_INTERVAL");
		 INSPECTION_PERSON=obj.getString("INSPECTION_PERSON");
		 INSPECTION_BUSINESSUNIT=obj.getString("INSPECTION_BUSINESSUNIT");
		 TAXAXY_OPINION=obj.getString("TAXAXY_OPINION");
		 OTHER_INFO=obj.getString("OTHER_INFO");
		 APPR_PENILAINAME=obj.getString("APPR_PENILAINAME");
		 APPR_REKANAN=obj.getString("APPR_REKANAN");

	 }
   
    
	 public Datatype_Appr_Pb_Valuation_Int() {
	    	update("",
	    			"",
	    			"",
	    			null,
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
	    			null,
	    			"",
	    			null,
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
	    			"");
		}
	    
	 public Datatype_Appr_Pb_Valuation_Int(APPR_PB_VALUATION_INT Data) {
			update(Data);
	}
		

	public APPR_PB_VALUATION_INT toRowData(){
		APPR_PB_VALUATION_INT rowData= new APPR_PB_VALUATION_INT();
		rowData.setCOL_ID(COL_ID);
		rowData.setAP_REGNO(AP_REGNO);
		rowData.setREPORT_NO(REPORT_NO);
		rowData.setREPORT_DATE(REPORT_DATE);
		rowData.setREPORT_INSPECT_DATE(REPORT_INSPECT_DATE);
		rowData.setREPORT_BRANCH_CODE(REPORT_BRANCH_CODE);
		rowData.setREPORT_SEG_CODE(REPORT_SEG_CODE);
		rowData.setREPORT_APPR_TYPE(REPORT_APPR_TYPE);
		rowData.setCOL_ADDR1(COL_ADDR1);
		rowData.setCOL_ADDR2(COL_ADDR2);
		rowData.setCOL_ADDR3(COL_ADDR3);
		rowData.setCOL_RT(COL_RT);
		rowData.setCOL_RW(COL_RW);
		rowData.setCOL_KELURAHAN(COL_KELURAHAN);
		rowData.setCOL_KECAMATAN(COL_KECAMATAN);
		rowData.setCOL_CITY(COL_CITY);
		rowData.setCOL_ZIPCODE(COL_ZIPCODE);
		rowData.setCOL_BRANCH_CODE(COL_BRANCH_CODE);
		rowData.setCOL_REQ_DATE(COL_REQ_DATE);
		rowData.setCOL_APPRAISER_CODE(COL_APPRAISER_CODE);
		rowData.setCOL_INSPECT_DATE(COL_INSPECT_DATE);
		rowData.setCOL_INSPECT_PERSON(COL_INSPECT_PERSON);
		rowData.setPB_RANDOM_SAMPLING_COUNT(PB_RANDOM_SAMPLING_COUNT);
		rowData.setPB_TOTAL_ITEM(PB_TOTAL_ITEM);
		rowData.setPB_BII_DATE(PB_BII_DATE);
		rowData.setPB_FIRETOOL(PB_FIRETOOL);
		rowData.setPB_FIRETOOL_OWNED(PB_FIRETOOL_OWNED);
		rowData.setPB_SECURITY(PB_SECURITY);
		rowData.setPB_SECURITY_OWNED(PB_SECURITY_OWNED);
		rowData.setPB_FLOOD_RISK(PB_FLOOD_RISK);
		rowData.setPB_FLOOD_RISK_INTERVAL(PB_FLOOD_RISK_INTERVAL);
		rowData.setINSPECTION_PERSON(INSPECTION_PERSON);
		rowData.setINSPECTION_BUSINESSUNIT(INSPECTION_BUSINESSUNIT);
		rowData.setTAXAXY_OPINION(TAXAXY_OPINION);
		rowData.setOTHER_INFO(OTHER_INFO);
		rowData.setAPPR_PENILAINAME(APPR_PENILAINAME);
		rowData.setAPPR_REKANAN(APPR_REKANAN);


	
		return rowData;
	}
	
	public void update(APPR_PB_VALUATION_INT rowData) {
		COL_ID=rowData.getCOL_ID();
		AP_REGNO=rowData.getAP_REGNO();
		REPORT_NO=rowData.getREPORT_NO();
		REPORT_DATE=rowData.getREPORT_DATE();
		REPORT_INSPECT_DATE=rowData.getREPORT_INSPECT_DATE();
		REPORT_BRANCH_CODE=rowData.getREPORT_BRANCH_CODE();
		REPORT_SEG_CODE=rowData.getREPORT_SEG_CODE();
		REPORT_APPR_TYPE=rowData.getREPORT_APPR_TYPE();
		COL_ADDR1=rowData.getCOL_ADDR1();
		COL_ADDR2=rowData.getCOL_ADDR2();
		COL_ADDR3=rowData.getCOL_ADDR3();
		COL_RT=rowData.getCOL_RT();
		COL_RW=rowData.getCOL_RW();
		COL_KELURAHAN=rowData.getCOL_KELURAHAN();
		COL_KECAMATAN=rowData.getCOL_KECAMATAN();
		COL_CITY=rowData.getCOL_CITY();
		COL_ZIPCODE=rowData.getCOL_ZIPCODE();
		COL_BRANCH_CODE=rowData.getCOL_BRANCH_CODE();
		COL_REQ_DATE=rowData.getCOL_REQ_DATE();
		COL_APPRAISER_CODE=rowData.getCOL_APPRAISER_CODE();
		COL_INSPECT_DATE=rowData.getCOL_INSPECT_DATE();
		COL_INSPECT_PERSON=rowData.getCOL_INSPECT_PERSON();
		PB_RANDOM_SAMPLING_COUNT=rowData.getPB_RANDOM_SAMPLING_COUNT();
		PB_TOTAL_ITEM=rowData.getPB_TOTAL_ITEM();
		PB_BII_DATE=rowData.getPB_BII_DATE();
		PB_FIRETOOL=rowData.getPB_FIRETOOL();
		PB_FIRETOOL_OWNED=rowData.getPB_FIRETOOL_OWNED();
		PB_SECURITY=rowData.getPB_SECURITY();
		PB_SECURITY_OWNED=rowData.getPB_SECURITY_OWNED();
		PB_FLOOD_RISK=rowData.getPB_FLOOD_RISK();
		PB_FLOOD_RISK_INTERVAL=rowData.getPB_FLOOD_RISK_INTERVAL();
		INSPECTION_PERSON=rowData.getINSPECTION_PERSON();
		INSPECTION_BUSINESSUNIT=rowData.getINSPECTION_BUSINESSUNIT();
		TAXAXY_OPINION=rowData.getTAXAXY_OPINION();
		OTHER_INFO=rowData.getOTHER_INFO();
		APPR_PENILAINAME=rowData.getAPPR_PENILAINAME();
		APPR_REKANAN=rowData.getAPPR_REKANAN();


	}
	
	public void update(String col_id,
			String ap_regno,
			String report_no,
			Date report_date,
			Date report_inspect_date,
			String report_branch_code,
			String report_seg_code,
			String report_appr_type,
			String col_addr1,
			String col_addr2,
			String col_addr3,
			String col_rt,
			String col_rw,
			String col_kelurahan,
			String col_kecamatan,
			String col_city,
			String col_zipcode,
			String col_branch_code,
			Date col_req_date,
			String col_appraiser_code,
			Date col_inspect_date,
			String col_inspect_person,
			String pb_random_sampling_count,
			String pb_total_item,
			Date pb_bii_date,
			String pb_firetool,
			String pb_firetool_owned,
			String pb_security,
			String pb_security_owned,
			String pb_flood_risk,
			String pb_flood_risk_interval,
			String inspection_person,
			String inspection_businessunit,
			String taxaxy_opinion,
			String other_info,
			String appr_penilainame,
			String appr_rekanan){
	COL_ID=col_id;
	AP_REGNO=ap_regno;
	REPORT_NO=report_no;
	REPORT_DATE=report_date;
	REPORT_INSPECT_DATE=report_inspect_date;
	REPORT_BRANCH_CODE=report_branch_code;
	REPORT_SEG_CODE=report_seg_code;
	REPORT_APPR_TYPE=report_appr_type;
	COL_ADDR1=col_addr1;
	COL_ADDR2=col_addr2;
	COL_ADDR3=col_addr3;
	COL_RT=col_rt;
	COL_RW=col_rw;
	COL_KELURAHAN=col_kelurahan;
	COL_KECAMATAN=col_kecamatan;
	COL_CITY=col_city;
	COL_ZIPCODE=col_zipcode;
	COL_BRANCH_CODE=col_branch_code;
	COL_REQ_DATE=col_req_date;
	COL_APPRAISER_CODE=col_appraiser_code;
	COL_INSPECT_DATE=col_inspect_date;
	COL_INSPECT_PERSON=col_inspect_person;
	PB_RANDOM_SAMPLING_COUNT=pb_random_sampling_count;
	PB_TOTAL_ITEM=pb_total_item;
	PB_BII_DATE=pb_bii_date;
	PB_FIRETOOL=pb_firetool;
	PB_FIRETOOL_OWNED=pb_firetool_owned;
	PB_SECURITY=pb_security;
	PB_SECURITY_OWNED=pb_security_owned;
	PB_FLOOD_RISK=pb_flood_risk;
	PB_FLOOD_RISK_INTERVAL=pb_flood_risk_interval;
	INSPECTION_PERSON=inspection_person;
	INSPECTION_BUSINESSUNIT=inspection_businessunit;
	TAXAXY_OPINION=taxaxy_opinion;
	OTHER_INFO=other_info;
	APPR_PENILAINAME=appr_penilainame;
	APPR_REKANAN=appr_rekanan;
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
		return COL_REQ_DATE;
	}

	public void setCOL_REQ_DATE(Date cOL_REQ_DATE) {
		COL_REQ_DATE = cOL_REQ_DATE;
	}

	public String getCOL_APPRAISER_CODE() {
		return COL_APPRAISER_CODE;
	}

	public void setCOL_APPRAISER_CODE(String cOL_APPRAISER_CODE) {
		COL_APPRAISER_CODE = cOL_APPRAISER_CODE;
	}

	public Date getCOL_INSPECT_DATE() {
		return COL_INSPECT_DATE;
	}

	public void setCOL_INSPECT_DATE(Date cOL_INSPECT_DATE) {
		COL_INSPECT_DATE = cOL_INSPECT_DATE;
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
		return PB_BII_DATE;
	}

	public void setPB_BII_DATE(Date pB_BII_DATE) {
		PB_BII_DATE = pB_BII_DATE;
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
