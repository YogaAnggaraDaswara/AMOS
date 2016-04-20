package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

import com.mobile.database.app.common.DataConverter;
import com.mobile.database.app.entities.APPR_MAIN;
import com.mobile.database.app.entities.APPR_VHC_PEMBANDING_INT;
import com.mobile.database.app.entities.APPR_RTB_CEK_TATA_KOTA_INT;
import com.mobile.database.app.entities.APPR_RTB_PROGRESS_BANGUNAN_INT;
import com.mobile.database.app.entities.APPR_RTB_PROGRESS_DEVELOPER_INT;
import com.mobile.database.app.entities.APPR_RTB_VALUATION_INT;
import com.mobile.database.app.entities.BLACKBOX;

public class Datatype_Appr_Progress_Bangunan_Int implements Serializable {

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
	public Date INSPECT_DATE;
	public String INSPECTOR_NAME;
	public String BUILDING_PROGRESS;
	public String BUILDING_PROGRESS_DATA;
	public String COL_PEMERIKSAAN;
	public String COL_APPRAISER_CODE;
	public String COL_ADDR1;
	public String COL_RT;
	public String COL_RW;
	public String COL_KELURAHAN;
	public String COL_KECAMATAN;
	public String COL_CITY;
	public String COL_ZIPCODE;
	public String COL_TYPE;
	public String COL_DOK_NAME;
	public String COL_DOK_NO;
	public String COL_DOK_TYPE;



   
	 public void updateMainFromJSON(JSONObject obj) throws Exception{
		 COL_ID=obj.getString("COL_ID");
		 AP_REGNO=obj.getString("AP_REGNO");
		 REPORT_NO=obj.getString("REPORT_NO");
		 REPORT_DATE=DataConverter.stringToDate(obj.getString("REPORT_DATE"));
		 REPORT_INSPECT_DATE=DataConverter.stringToDate(obj.getString("REPORT_INSPECT_DATE"));
		 REPORT_BRANCH_CODE=obj.getString("REPORT_BRANCH_CODE");
		 REPORT_SEG_CODE=obj.getString("REPORT_SEG_CODE");
		 INSPECT_DATE=DataConverter.stringToDate(obj.getString("INSPECT_DATE"));
		 INSPECTOR_NAME=obj.getString("INSPECTOR_NAME");
		 BUILDING_PROGRESS=obj.getString("BUILDING_PROGRESS");
		 BUILDING_PROGRESS_DATA=obj.getString("BUILDING_PROGRESS_DATA");
		 COL_PEMERIKSAAN=obj.getString("COL_PEMERIKSAAN");
		 COL_APPRAISER_CODE=obj.getString("COL_APPRAISER_CODE");
		 COL_ADDR1=obj.getString("COL_ADDR1");
		 COL_RT=obj.getString("COL_RT");
		 COL_RW=obj.getString("COL_RW");
		 COL_KELURAHAN=obj.getString("COL_KELURAHAN");
		 COL_KECAMATAN=obj.getString("COL_KECAMATAN");
		 COL_CITY=obj.getString("COL_CITY");
		 COL_ZIPCODE=obj.getString("COL_ZIPCODE");
		 COL_TYPE=obj.getString("COL_TYPE");
		 COL_DOK_NAME=obj.getString("COL_DOK_NAME");
		 COL_DOK_NO=obj.getString("COL_DOK_NO");
		 COL_DOK_TYPE=obj.getString("COL_DOK_TYPE");

	 }
	 public Datatype_Appr_Progress_Bangunan_Int() {
	    	update("",
	    			"",
	    			"",
	    			null,
	    			null,
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
	    			"");
		}
	    
	 public Datatype_Appr_Progress_Bangunan_Int(APPR_RTB_PROGRESS_BANGUNAN_INT Data) {
			update(Data);
	}
		

	


	public APPR_RTB_PROGRESS_BANGUNAN_INT toRowData(){
		APPR_RTB_PROGRESS_BANGUNAN_INT rowData= new APPR_RTB_PROGRESS_BANGUNAN_INT();
		rowData.setCOL_ID(COL_ID);
		rowData.setAP_REGNO(AP_REGNO);
		rowData.setREPORT_NO(REPORT_NO);
		rowData.setREPORT_DATE(REPORT_DATE);
		rowData.setREPORT_INSPECT_DATE(REPORT_INSPECT_DATE);
		rowData.setREPORT_BRANCH_CODE(REPORT_BRANCH_CODE);
		rowData.setREPORT_SEG_CODE(REPORT_SEG_CODE);
		rowData.setINSPECT_DATE(INSPECT_DATE);
		rowData.setINSPECTOR_NAME(INSPECTOR_NAME);
		rowData.setBUILDING_PROGRESS(BUILDING_PROGRESS);
		rowData.setBUILDING_PROGRESS_DATA(BUILDING_PROGRESS_DATA);
		rowData.setCOL_PEMERIKSAAN(COL_PEMERIKSAAN);
		rowData.setCOL_APPRAISER_CODE(COL_APPRAISER_CODE);
		rowData.setCOL_ADDR1(COL_ADDR1);
		rowData.setCOL_RT(COL_RT);
		rowData.setCOL_RW(COL_RW);
		rowData.setCOL_KELURAHAN(COL_KELURAHAN);
		rowData.setCOL_KECAMATAN(COL_KECAMATAN);
		rowData.setCOL_CITY(COL_CITY);
		rowData.setCOL_ZIPCODE(COL_ZIPCODE);
		rowData.setCOL_TYPE(COL_TYPE);
		rowData.setCOL_DOK_NAME(COL_DOK_NAME);
		rowData.setCOL_DOK_NO(COL_DOK_NO);
		rowData.setCOL_DOK_TYPE(COL_DOK_TYPE);


		return rowData;
	}
	
	public void update(APPR_RTB_PROGRESS_BANGUNAN_INT rowData) {
		COL_ID=rowData.getCOL_ID();
		AP_REGNO=rowData.getAP_REGNO();
		REPORT_NO=rowData.getREPORT_NO();
		REPORT_DATE=rowData.getREPORT_DATE();
		REPORT_INSPECT_DATE=rowData.getREPORT_INSPECT_DATE();
		REPORT_BRANCH_CODE=rowData.getREPORT_BRANCH_CODE();
		REPORT_SEG_CODE=rowData.getREPORT_SEG_CODE();
		INSPECT_DATE=rowData.getINSPECT_DATE();
		INSPECTOR_NAME=rowData.getINSPECTOR_NAME();
		BUILDING_PROGRESS=rowData.getBUILDING_PROGRESS();
		BUILDING_PROGRESS_DATA=rowData.getBUILDING_PROGRESS_DATA();
		COL_PEMERIKSAAN=rowData.getCOL_PEMERIKSAAN();
		COL_APPRAISER_CODE=rowData.getCOL_APPRAISER_CODE();
		COL_ADDR1=rowData.getCOL_ADDR1();
		COL_RT=rowData.getCOL_RT();
		COL_RW=rowData.getCOL_RW();
		COL_KELURAHAN=rowData.getCOL_KELURAHAN();
		COL_KECAMATAN=rowData.getCOL_KECAMATAN();
		COL_CITY=rowData.getCOL_CITY();
		COL_ZIPCODE=rowData.getCOL_ZIPCODE();
		COL_TYPE=rowData.getCOL_TYPE();
		COL_DOK_NAME=rowData.getCOL_DOK_NAME();
		COL_DOK_NO=rowData.getCOL_DOK_NO();
		COL_DOK_TYPE=rowData.getCOL_DOK_TYPE();




	}
	
	public void update(String col_id,
			String ap_regno,
			String report_no,
			Date report_date,
			Date report_inspect_date,
			String report_branch_code,
			String report_seg_code,
			Date inspect_date,
			String inspector_name,
			String building_progress,
			String building_progress_data,
			String col_pemeriksaan,
			String col_appraiser_code,
			String col_addr1,
			String col_rt,
			String col_rw,
			String col_kelurahan,
			String col_kecamatan,
			String col_city,
			String col_zipcode,
			String col_type,
			String col_dok_name,
			String col_dok_no,
			String col_dok_type){
		COL_ID=col_id;
		AP_REGNO=ap_regno;
		REPORT_NO=report_no;
		REPORT_DATE=report_date;
		REPORT_INSPECT_DATE=report_inspect_date;
		REPORT_BRANCH_CODE=report_branch_code;
		REPORT_SEG_CODE=report_seg_code;
		INSPECT_DATE=inspect_date;
		INSPECTOR_NAME=inspector_name;
		BUILDING_PROGRESS=building_progress;
		BUILDING_PROGRESS_DATA=building_progress_data;
		COL_PEMERIKSAAN=col_pemeriksaan;
		COL_APPRAISER_CODE=col_appraiser_code;
		COL_ADDR1=col_addr1;
		COL_RT=col_rt;
		COL_RW=col_rw;
		COL_KELURAHAN=col_kelurahan;
		COL_KECAMATAN=col_kecamatan;
		COL_CITY=col_city;
		COL_ZIPCODE=col_zipcode;
		COL_TYPE=col_type;
		COL_DOK_NAME=col_dok_name;
		COL_DOK_NO=col_dok_no;
		COL_DOK_TYPE=col_dok_type;

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

	public Date getINSPECT_DATE() {
		return INSPECT_DATE;
	}

	public void setINSPECT_DATE(Date iNSPECT_DATE) {
		INSPECT_DATE = iNSPECT_DATE;
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
