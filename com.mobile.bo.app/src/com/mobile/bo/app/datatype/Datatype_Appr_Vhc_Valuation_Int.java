package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

import com.mobile.database.app.common.DataConverter;
import com.mobile.database.app.entities.APPR_MAIN;
import com.mobile.database.app.entities.APPR_RTB_CEK_TATA_KOTA_INT;
import com.mobile.database.app.entities.APPR_RTB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_VHC_VALUATION_INT;
import com.mobile.database.app.entities.BLACKBOX;
import com.mobile.framework.common.DateFormatter;

public class Datatype_Appr_Vhc_Valuation_Int implements Serializable {

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
	public String BPKB_NAME;
	public Date BPKB_EXPIRE_DATE;
	public String STNK_NAME;
	public Date STNK_EXPIRE_DATE;
	public String INVOICE_NAME;
	public Date INVOICE_DATE;
	public String ORDER_NAME;
	public Date ORDER_DATE;
	public String BPKB_ADDR1;
	public String BPKB_ADDR2;
	public String BPKB_ADDR3;
	public String BPKB_RT;
	public String BPKB_RW;
	public String BPKB_KELURAHAN;
	public String BPKB_KECAMATAN;
	public String BPKB_CITY;
	public String BPKB_ZIPCODE;
	public String RANGE_PRICE;
	public String MARKET_PRICE;
	public String SAFETY_MARGIN;
	public String AFTER_SAFETY_MARGIN_PRICE;
	public String LIQUID_PERCENT;
	public String LIQUID_VALUE;
	public String POSITIVE_FACTOR;
	public String NEGATIVE_FACTOR;
	public String CONCLUSION;
	public String INSPECTION_PERSON;
	public String INSPECTION_BUSINESSUNIT;
	public String TAXAXY_OPINION;
	public String OTHER_INFO;
	public String STNK_NO;
	public String BPKB_NO;
	public String INVOICE_NO;
	public String ORDER_NO;
	public String BPKB_ADDRESS;
	public String STNK_ADDRESS;
	public String INVOICE_ADDRESS;
	public String ORDER_ADDRESS;
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
		 COL_REQ_DATE= DataConverter.stringToDate(obj.getString("COL_REQ_DATE"));
		 COL_APPRAISER_CODE=obj.getString("COL_APPRAISER_CODE");
		 COL_INSPECT_DATE=DataConverter.stringToDate(obj.getString("COL_INSPECT_DATE"));
		 COL_INSPECT_PERSON=obj.getString("COL_INSPECT_PERSON");
		 BPKB_NAME=obj.getString("BPKB_NAME");
		 BPKB_EXPIRE_DATE=DataConverter.stringToDate(obj.getString("BPKB_EXPIRE_DATE"));
		 STNK_NAME=obj.getString("STNK_NAME");
		 STNK_EXPIRE_DATE=DataConverter.stringToDate(obj.getString("STNK_EXPIRE_DATE"));
		 INVOICE_NAME=obj.getString("INVOICE_NAME");
		 INVOICE_DATE=DataConverter.stringToDate(obj.getString("INVOICE_DATE"));
		 ORDER_NAME=obj.getString("ORDER_NAME");
		 ORDER_DATE=DataConverter.stringToDate(obj.getString("ORDER_DATE"));
		 BPKB_ADDR1=obj.getString("BPKB_ADDR1");
		 BPKB_ADDR2=obj.getString("BPKB_ADDR2");
		 BPKB_ADDR3=obj.getString("BPKB_ADDR3");
		 BPKB_RT=obj.getString("BPKB_RT");
		 BPKB_RW=obj.getString("BPKB_RW");
		 BPKB_KELURAHAN=obj.getString("BPKB_KELURAHAN");
		 BPKB_KECAMATAN=obj.getString("BPKB_KECAMATAN");
		 BPKB_CITY=obj.getString("BPKB_CITY");
		 BPKB_ZIPCODE=obj.getString("BPKB_ZIPCODE");
		 RANGE_PRICE=obj.getString("RANGE_PRICE");
		 MARKET_PRICE=obj.getString("MARKET_PRICE");
		 SAFETY_MARGIN=obj.getString("SAFETY_MARGIN");
		 AFTER_SAFETY_MARGIN_PRICE=obj.getString("AFTER_SAFETY_MARGIN_PRICE");
		 LIQUID_PERCENT=obj.getString("LIQUID_PERCENT");
		 LIQUID_VALUE=obj.getString("LIQUID_VALUE");
		 POSITIVE_FACTOR=obj.getString("POSITIVE_FACTOR");
		 NEGATIVE_FACTOR=obj.getString("NEGATIVE_FACTOR");
		 CONCLUSION=obj.getString("CONCLUSION");
		 INSPECTION_PERSON=obj.getString("INSPECTION_PERSON");
		 INSPECTION_BUSINESSUNIT=obj.getString("INSPECTION_BUSINESSUNIT");
		 TAXAXY_OPINION=obj.getString("TAXAXY_OPINION");
		 OTHER_INFO=obj.getString("OTHER_INFO");
		 STNK_NO=obj.getString("STNK_NO");
		 BPKB_NO=obj.getString("BPKB_NO");
		 INVOICE_NO=obj.getString("INVOICE_NO");
		 ORDER_NO=obj.getString("ORDER_NO");
		 BPKB_ADDRESS=obj.getString("BPKB_ADDRESS");
		 STNK_ADDRESS=obj.getString("STNK_ADDRESS");
		 INVOICE_ADDRESS=obj.getString("INVOICE_ADDRESS");
		 ORDER_ADDRESS=obj.getString("ORDER_ADDRESS");
		 APPR_PENILAINAME=obj.getString("APPR_PENILAINAME");
		 APPR_REKANAN=obj.getString("APPR_REKANAN");

	 }
    
	 public Datatype_Appr_Vhc_Valuation_Int() {
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
	    			null,
	    			"",
	    			null,
	    			"",
	    			null,
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
	    			"",
	    			"",
	    			"");
		}
	    
	 public Datatype_Appr_Vhc_Valuation_Int(APPR_VHC_VALUATION_INT Data) {
			update(Data);
	}
		

	public APPR_VHC_VALUATION_INT toRowData(){
		APPR_VHC_VALUATION_INT rowData= new APPR_VHC_VALUATION_INT();
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
		rowData.setBPKB_NAME(BPKB_NAME);
		rowData.setBPKB_EXPIRE_DATE(BPKB_EXPIRE_DATE);
		rowData.setSTNK_NAME(STNK_NAME);
		rowData.setSTNK_EXPIRE_DATE(STNK_EXPIRE_DATE);
		rowData.setINVOICE_NAME(INVOICE_NAME);
		rowData.setINVOICE_DATE(INVOICE_DATE);
		rowData.setORDER_NAME(ORDER_NAME);
		rowData.setORDER_DATE(ORDER_DATE);
		rowData.setBPKB_ADDR1(BPKB_ADDR1);
		rowData.setBPKB_ADDR2(BPKB_ADDR2);
		rowData.setBPKB_ADDR3(BPKB_ADDR3);
		rowData.setBPKB_RT(BPKB_RT);
		rowData.setBPKB_RW(BPKB_RW);
		rowData.setBPKB_KELURAHAN(BPKB_KELURAHAN);
		rowData.setBPKB_KECAMATAN(BPKB_KECAMATAN);
		rowData.setBPKB_CITY(BPKB_CITY);
		rowData.setBPKB_ZIPCODE(BPKB_ZIPCODE);
		rowData.setRANGE_PRICE(RANGE_PRICE);
		rowData.setMARKET_PRICE(MARKET_PRICE);
		rowData.setSAFETY_MARGIN(SAFETY_MARGIN);
		rowData.setAFTER_SAFETY_MARGIN_PRICE(AFTER_SAFETY_MARGIN_PRICE);
		rowData.setLIQUID_PERCENT(LIQUID_PERCENT);
		rowData.setLIQUID_VALUE(LIQUID_VALUE);
		rowData.setPOSITIVE_FACTOR(POSITIVE_FACTOR);
		rowData.setNEGATIVE_FACTOR(NEGATIVE_FACTOR);
		rowData.setCONCLUSION(CONCLUSION);
		rowData.setINSPECTION_PERSON(INSPECTION_PERSON);
		rowData.setINSPECTION_BUSINESSUNIT(INSPECTION_BUSINESSUNIT);
		rowData.setTAXAXY_OPINION(TAXAXY_OPINION);
		rowData.setOTHER_INFO(OTHER_INFO);
		rowData.setSTNK_NO(STNK_NO);
		rowData.setBPKB_NO(BPKB_NO);
		rowData.setINVOICE_NO(INVOICE_NO);
		rowData.setORDER_NO(ORDER_NO);
		rowData.setBPKB_ADDRESS(BPKB_ADDRESS);
		rowData.setSTNK_ADDRESS(STNK_ADDRESS);
		rowData.setINVOICE_ADDRESS(INVOICE_ADDRESS);
		rowData.setORDER_ADDRESS(ORDER_ADDRESS);
		rowData.setAPPR_PENILAINAME(APPR_PENILAINAME);
		rowData.setAPPR_REKANAN(APPR_REKANAN);

		return rowData;
	}
	
	public void update(APPR_VHC_VALUATION_INT rowData) {
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
		BPKB_NAME=rowData.getBPKB_NAME();
		BPKB_EXPIRE_DATE=rowData.getBPKB_EXPIRE_DATE();
		STNK_NAME=rowData.getSTNK_NAME();
		STNK_EXPIRE_DATE=rowData.getSTNK_EXPIRE_DATE();
		INVOICE_NAME=rowData.getINVOICE_NAME();
		INVOICE_DATE=rowData.getINVOICE_DATE();
		ORDER_NAME=rowData.getORDER_NAME();
		ORDER_DATE=rowData.getORDER_DATE();
		BPKB_ADDR1=rowData.getBPKB_ADDR1();
		BPKB_ADDR2=rowData.getBPKB_ADDR2();
		BPKB_ADDR3=rowData.getBPKB_ADDR3();
		BPKB_RT=rowData.getBPKB_RT();
		BPKB_RW=rowData.getBPKB_RW();
		BPKB_KELURAHAN=rowData.getBPKB_KELURAHAN();
		BPKB_KECAMATAN=rowData.getBPKB_KECAMATAN();
		BPKB_CITY=rowData.getBPKB_CITY();
		BPKB_ZIPCODE=rowData.getBPKB_ZIPCODE();
		RANGE_PRICE=rowData.getRANGE_PRICE();
		MARKET_PRICE=rowData.getMARKET_PRICE();
		SAFETY_MARGIN=rowData.getSAFETY_MARGIN();
		AFTER_SAFETY_MARGIN_PRICE=rowData.getAFTER_SAFETY_MARGIN_PRICE();
		LIQUID_PERCENT=rowData.getLIQUID_PERCENT();
		LIQUID_VALUE=rowData.getLIQUID_VALUE();
		POSITIVE_FACTOR=rowData.getPOSITIVE_FACTOR();
		NEGATIVE_FACTOR=rowData.getNEGATIVE_FACTOR();
		CONCLUSION=rowData.getCONCLUSION();
		INSPECTION_PERSON=rowData.getINSPECTION_PERSON();
		INSPECTION_BUSINESSUNIT=rowData.getINSPECTION_BUSINESSUNIT();
		TAXAXY_OPINION=rowData.getTAXAXY_OPINION();
		OTHER_INFO=rowData.getOTHER_INFO();
		STNK_NO=rowData.getSTNK_NO();
		BPKB_NO=rowData.getBPKB_NO();
		INVOICE_NO=rowData.getINVOICE_NO();
		ORDER_NO=rowData.getORDER_NO();
		BPKB_ADDRESS=rowData.getBPKB_ADDRESS();
		STNK_ADDRESS=rowData.getSTNK_ADDRESS();
		INVOICE_ADDRESS=rowData.getINVOICE_ADDRESS();
		ORDER_ADDRESS=rowData.getORDER_ADDRESS();
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
			String bpkb_name,
			Date bpkb_expire_date,
			String stnk_name,
			Date stnk_expire_date,
			String invoice_name,
			Date invoice_date,
			String order_name,
			Date order_date,
			String bpkb_addr1,
			String bpkb_addr2,
			String bpkb_addr3,
			String bpkb_rt,
			String bpkb_rw,
			String bpkb_kelurahan,
			String bpkb_kecamatan,
			String bpkb_city,
			String bpkb_zipcode,
			String range_price,
			String market_price,
			String safety_margin,
			String after_safety_margin_price,
			String liquid_percent,
			String liquid_value,
			String positive_factor,
			String negative_factor,
			String conclusion,
			String inspection_person,
			String inspection_businessunit,
			String taxaxy_opinion,
			String other_info,
			String stnk_no,
			String bpkb_no,
			String invoice_no,
			String order_no,
			String bpkb_address,
			String stnk_address,
			String invoice_address,
			String order_address,
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
		BPKB_NAME=bpkb_name;
		BPKB_EXPIRE_DATE=bpkb_expire_date;
		STNK_NAME=stnk_name;
		STNK_EXPIRE_DATE=stnk_expire_date;
		INVOICE_NAME=invoice_name;
		INVOICE_DATE=invoice_date;
		ORDER_NAME=order_name;
		ORDER_DATE=order_date;
		BPKB_ADDR1=bpkb_addr1;
		BPKB_ADDR2=bpkb_addr2;
		BPKB_ADDR3=bpkb_addr3;
		BPKB_RT=bpkb_rt;
		BPKB_RW=bpkb_rw;
		BPKB_KELURAHAN=bpkb_kelurahan;
		BPKB_KECAMATAN=bpkb_kecamatan;
		BPKB_CITY=bpkb_city;
		BPKB_ZIPCODE=bpkb_zipcode;
		RANGE_PRICE=range_price;
		MARKET_PRICE=market_price;
		SAFETY_MARGIN=safety_margin;
		AFTER_SAFETY_MARGIN_PRICE=after_safety_margin_price;
		LIQUID_PERCENT=liquid_percent;
		LIQUID_VALUE=liquid_value;
		POSITIVE_FACTOR=positive_factor;
		NEGATIVE_FACTOR=negative_factor;
		CONCLUSION=conclusion;
		INSPECTION_PERSON=inspection_person;
		INSPECTION_BUSINESSUNIT=inspection_businessunit;
		TAXAXY_OPINION=taxaxy_opinion;
		OTHER_INFO=other_info;
		STNK_NO=stnk_no;
		BPKB_NO=bpkb_no;
		INVOICE_NO=invoice_no;
		ORDER_NO=order_no;
		BPKB_ADDRESS=bpkb_address;
		STNK_ADDRESS=stnk_address;
		INVOICE_ADDRESS=invoice_address;
		ORDER_ADDRESS=order_address;
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

	public String getBPKB_NAME() {
		return BPKB_NAME;
	}

	public void setBPKB_NAME(String bPKB_NAME) {
		BPKB_NAME = bPKB_NAME;
	}

	public Date getBPKB_EXPIRE_DATE() {
		return BPKB_EXPIRE_DATE;
	}

	public void setBPKB_EXPIRE_DATE(Date bPKB_EXPIRE_DATE) {
		BPKB_EXPIRE_DATE = bPKB_EXPIRE_DATE;
	}

	public String getSTNK_NAME() {
		return STNK_NAME;
	}

	public void setSTNK_NAME(String sTNK_NAME) {
		STNK_NAME = sTNK_NAME;
	}

	public Date getSTNK_EXPIRE_DATE() {
		return STNK_EXPIRE_DATE;
	}

	public void setSTNK_EXPIRE_DATE(Date sTNK_EXPIRE_DATE) {
		STNK_EXPIRE_DATE = sTNK_EXPIRE_DATE;
	}

	public String getINVOICE_NAME() {
		return INVOICE_NAME;
	}

	public void setINVOICE_NAME(String iNVOICE_NAME) {
		INVOICE_NAME = iNVOICE_NAME;
	}

	public Date getINVOICE_DATE() {
		return INVOICE_DATE;
	}

	public void setINVOICE_DATE(Date iNVOICE_DATE) {
		INVOICE_DATE = iNVOICE_DATE;
	}

	public String getORDER_NAME() {
		return ORDER_NAME;
	}

	public void setORDER_NAME(String oRDER_NAME) {
		ORDER_NAME = oRDER_NAME;
	}

	public Date getORDER_DATE() {
		return ORDER_DATE;
	}

	public void setORDER_DATE(Date oRDER_DATE) {
		ORDER_DATE = oRDER_DATE;
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
