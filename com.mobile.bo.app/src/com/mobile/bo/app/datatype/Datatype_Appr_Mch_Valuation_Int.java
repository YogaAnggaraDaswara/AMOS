package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

import com.mobile.database.app.common.DataConverter;
import com.mobile.database.app.entities.APPR_MAIN;
import com.mobile.database.app.entities.APPR_MCH_VALUATION_INT;
import com.mobile.database.app.entities.APPR_PB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_RTB_CEK_TATA_KOTA_INT;
import com.mobile.database.app.entities.APPR_RTB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_VHC_VALUATION_INT;
import com.mobile.database.app.entities.BLACKBOX;

public class Datatype_Appr_Mch_Valuation_Int implements Serializable {

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
	public String DOC_CODE;
	public String DOC_NO;
	public Date DOC_DATE;
	public String MCH_CODE;
	public String MCH_BRAND;
	public String MCH_MODEL;
	public String CREATED_YEAR;
	public String MCH_COND;
	public String ON_USE;
	public String ON_USE_REASON;
	public String OTHER;
	public String RANGE_PRICE;
	public String MARKET_PRICE;
	public String SAFETY_MARGIN;
	public String AFTER_SAFETY_MARGIN_PRICE;
	public String LIQUID_PERCENT;
	public String LIQUID_VALUE;
	public String BASIC_VALUATION;
	public String INSPECTION_PERSON;
	public String INSPECTION_BUSINESSUNIT;
	public String TAXAXY_OPINION;
	public String OTHER_INFO;
	public String MCH_FUNGSI;
	public String DOC_NOSERI;
	public String APPR_PENILAINAME;
	public String APPR_REKANAN;
	public String SEQ;
	public String VHC_BRAND_CODE;
	public String VHC_CODE;
	public String YEAR_CREATED;
	public String COLOR_CODE;
	public String TRANSMISION;
	public String CONDITION;
	public String OFFER_PRICE;
	public String AFTER_ADJUSTMENT_PRICE;
	public String NARA_SUMBER;
	public String PHONE_NO;
	public String OFFER_TYPE;



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
		 DOC_CODE=obj.getString("DOC_CODE");
		 DOC_NO=obj.getString("DOC_NO");
		 DOC_DATE=DataConverter.stringToDate(obj.getString("DOC_DATE"));
		 MCH_CODE=obj.getString("MCH_CODE");
		 MCH_BRAND=obj.getString("MCH_BRAND");
		 MCH_MODEL=obj.getString("MCH_MODEL");
		 CREATED_YEAR=obj.getString("CREATED_YEAR");
		 MCH_COND=obj.getString("MCH_COND");
		 ON_USE=obj.getString("ON_USE");
		 ON_USE_REASON=obj.getString("ON_USE_REASON");
		 OTHER=obj.getString("OTHER");
		 RANGE_PRICE=obj.getString("RANGE_PRICE");
		 MARKET_PRICE=obj.getString("MARKET_PRICE");
		 SAFETY_MARGIN=obj.getString("SAFETY_MARGIN");
		 AFTER_SAFETY_MARGIN_PRICE=obj.getString("AFTER_SAFETY_MARGIN_PRICE");
		 LIQUID_PERCENT=obj.getString("LIQUID_PERCENT");
		 LIQUID_VALUE=obj.getString("LIQUID_VALUE");
		 BASIC_VALUATION=obj.getString("BASIC_VALUATION");
		 INSPECTION_PERSON=obj.getString("INSPECTION_PERSON");
		 INSPECTION_BUSINESSUNIT=obj.getString("INSPECTION_BUSINESSUNIT");
		 TAXAXY_OPINION=obj.getString("TAXAXY_OPINION");
		 OTHER_INFO=obj.getString("OTHER_INFO");
		 MCH_FUNGSI=obj.getString("MCH_FUNGSI");
		 DOC_NOSERI=obj.getString("DOC_NOSERI");
		 APPR_PENILAINAME=obj.getString("APPR_PENILAINAME");
		 APPR_REKANAN=obj.getString("APPR_REKANAN");
		 SEQ=obj.getString("SEQ");
		 VHC_BRAND_CODE=obj.getString("VHC_BRAND_CODE");
		 VHC_CODE=obj.getString("VHC_CODE");
		 YEAR_CREATED=obj.getString("YEAR_CREATED");
		 COLOR_CODE=obj.getString("COLOR_CODE");
		 TRANSMISION=obj.getString("TRANSMISION");
		 CONDITION=obj.getString("CONDITION");
		 OFFER_PRICE=obj.getString("OFFER_PRICE");
		 AFTER_ADJUSTMENT_PRICE=obj.getString("AFTER_ADJUSTMENT_PRICE");
		 NARA_SUMBER=obj.getString("NARA_SUMBER");
		 PHONE_NO=obj.getString("PHONE_NO");
		 OFFER_TYPE=obj.getString("OFFER_TYPE");

	 }
    
	 public Datatype_Appr_Mch_Valuation_Int() {
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
	    
	 public Datatype_Appr_Mch_Valuation_Int(APPR_MCH_VALUATION_INT Data) {
			update(Data);
	}
		

	public APPR_MCH_VALUATION_INT toRowData(){
		APPR_MCH_VALUATION_INT rowData= new APPR_MCH_VALUATION_INT();
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
		rowData.setDOC_CODE(DOC_CODE);
		rowData.setDOC_NO(DOC_NO);
		rowData.setDOC_DATE(DOC_DATE);
		rowData.setMCH_CODE(MCH_CODE);
		rowData.setMCH_BRAND(MCH_BRAND);
		rowData.setMCH_MODEL(MCH_MODEL);
		rowData.setCREATED_YEAR(CREATED_YEAR);
		rowData.setMCH_COND(MCH_COND);
		rowData.setON_USE(ON_USE);
		rowData.setON_USE_REASON(ON_USE_REASON);
		rowData.setOTHER(OTHER);
		rowData.setRANGE_PRICE(RANGE_PRICE);
		rowData.setMARKET_PRICE(MARKET_PRICE);
		rowData.setSAFETY_MARGIN(SAFETY_MARGIN);
		rowData.setAFTER_SAFETY_MARGIN_PRICE(AFTER_SAFETY_MARGIN_PRICE);
		rowData.setLIQUID_PERCENT(LIQUID_PERCENT);
		rowData.setLIQUID_VALUE(LIQUID_VALUE);
		rowData.setBASIC_VALUATION(BASIC_VALUATION);
		rowData.setINSPECTION_PERSON(INSPECTION_PERSON);
		rowData.setINSPECTION_BUSINESSUNIT(INSPECTION_BUSINESSUNIT);
		rowData.setTAXAXY_OPINION(TAXAXY_OPINION);
		rowData.setOTHER_INFO(OTHER_INFO);
		rowData.setMCH_FUNGSI(MCH_FUNGSI);
		rowData.setDOC_NOSERI(DOC_NOSERI);
		rowData.setAPPR_PENILAINAME(APPR_PENILAINAME);
		rowData.setAPPR_REKANAN(APPR_REKANAN);
		rowData.setSEQ(SEQ);
		rowData.setVHC_BRAND_CODE(VHC_BRAND_CODE);
		rowData.setVHC_CODE(VHC_CODE);
		rowData.setYEAR_CREATED(YEAR_CREATED);
		rowData.setCOLOR_CODE(COLOR_CODE);
		rowData.setTRANSMISION(TRANSMISION);
		rowData.setCONDITION(CONDITION);
		rowData.setOFFER_PRICE(OFFER_PRICE);
		rowData.setAFTER_ADJUSTMENT_PRICE(AFTER_ADJUSTMENT_PRICE);
		rowData.setNARA_SUMBER(NARA_SUMBER);
		rowData.setPHONE_NO(PHONE_NO);
		rowData.setOFFER_TYPE(OFFER_TYPE);

	
		return rowData;
	}
	
	public void update(APPR_MCH_VALUATION_INT rowData) {
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
		DOC_CODE=rowData.getDOC_CODE();
		DOC_NO=rowData.getDOC_NO();
		DOC_DATE=rowData.getDOC_DATE();
		MCH_CODE=rowData.getMCH_CODE();
		MCH_BRAND=rowData.getMCH_BRAND();
		MCH_MODEL=rowData.getMCH_MODEL();
		CREATED_YEAR=rowData.getCREATED_YEAR();
		MCH_COND=rowData.getMCH_COND();
		ON_USE=rowData.getON_USE();
		ON_USE_REASON=rowData.getON_USE_REASON();
		OTHER=rowData.getOTHER();
		RANGE_PRICE=rowData.getRANGE_PRICE();
		MARKET_PRICE=rowData.getMARKET_PRICE();
		SAFETY_MARGIN=rowData.getSAFETY_MARGIN();
		AFTER_SAFETY_MARGIN_PRICE=rowData.getAFTER_SAFETY_MARGIN_PRICE();
		LIQUID_PERCENT=rowData.getLIQUID_PERCENT();
		LIQUID_VALUE=rowData.getLIQUID_VALUE();
		BASIC_VALUATION=rowData.getBASIC_VALUATION();
		INSPECTION_PERSON=rowData.getINSPECTION_PERSON();
		INSPECTION_BUSINESSUNIT=rowData.getINSPECTION_BUSINESSUNIT();
		TAXAXY_OPINION=rowData.getTAXAXY_OPINION();
		OTHER_INFO=rowData.getOTHER_INFO();
		MCH_FUNGSI=rowData.getMCH_FUNGSI();
		DOC_NOSERI=rowData.getDOC_NOSERI();
		APPR_PENILAINAME=rowData.getAPPR_PENILAINAME();
		APPR_REKANAN=rowData.getAPPR_REKANAN();
		SEQ=rowData.getSEQ();
		VHC_BRAND_CODE=rowData.getVHC_BRAND_CODE();
		VHC_CODE=rowData.getVHC_CODE();
		YEAR_CREATED=rowData.getYEAR_CREATED();
		COLOR_CODE=rowData.getCOLOR_CODE();
		TRANSMISION=rowData.getTRANSMISION();
		CONDITION=rowData.getCONDITION();
		OFFER_PRICE=rowData.getOFFER_PRICE();
		AFTER_ADJUSTMENT_PRICE=rowData.getAFTER_ADJUSTMENT_PRICE();
		NARA_SUMBER=rowData.getNARA_SUMBER();
		PHONE_NO=rowData.getPHONE_NO();
		OFFER_TYPE=rowData.getOFFER_TYPE();


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
			String doc_code,
			String doc_no,
			Date doc_date,
			String mch_code,
			String mch_brand,
			String mch_model,
			String created_year,
			String mch_cond,
			String on_use,
			String on_use_reason,
			String other,
			String range_price,
			String market_price,
			String safety_margin,
			String after_safety_margin_price,
			String liquid_percent,
			String liquid_value,
			String basic_valuation,
			String inspection_person,
			String inspection_businessunit,
			String taxaxy_opinion,
			String other_info,
			String mch_fungsi,
			String doc_noseri,
			String appr_penilainame,
			String appr_rekanan,
			String seq,
			String vhc_brand_code,
			String vhc_code,
			String year_created,
			String color_code,
			String transmision,
			String condition,
			String offer_price,
			String after_adjustment_price,
			String nara_sumber,
			String phone_no,
			String offer_type){
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
		DOC_CODE=doc_code;
		DOC_NO=doc_no;
		DOC_DATE=doc_date;
		MCH_CODE=mch_code;
		MCH_BRAND=mch_brand;
		MCH_MODEL=mch_model;
		CREATED_YEAR=created_year;
		MCH_COND=mch_cond;
		ON_USE=on_use;
		ON_USE_REASON=on_use_reason;
		OTHER=other;
		RANGE_PRICE=range_price;
		MARKET_PRICE=market_price;
		SAFETY_MARGIN=safety_margin;
		AFTER_SAFETY_MARGIN_PRICE=after_safety_margin_price;
		LIQUID_PERCENT=liquid_percent;
		LIQUID_VALUE=liquid_value;
		BASIC_VALUATION=basic_valuation;
		INSPECTION_PERSON=inspection_person;
		INSPECTION_BUSINESSUNIT=inspection_businessunit;
		TAXAXY_OPINION=taxaxy_opinion;
		OTHER_INFO=other_info;
		MCH_FUNGSI=mch_fungsi;
		DOC_NOSERI=doc_noseri;
		APPR_PENILAINAME=appr_penilainame;
		APPR_REKANAN=appr_rekanan;
		SEQ=seq;
		VHC_BRAND_CODE=vhc_brand_code;
		VHC_CODE=vhc_code;
		YEAR_CREATED=year_created;
		COLOR_CODE=color_code;
		TRANSMISION=transmision;
		CONDITION=condition;
		OFFER_PRICE=offer_price;
		AFTER_ADJUSTMENT_PRICE=after_adjustment_price;
		NARA_SUMBER=nara_sumber;
		PHONE_NO=phone_no;
		OFFER_TYPE=offer_type;
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
		return DOC_DATE;
	}

	public void setDOC_DATE(Date dOC_DATE) {
		DOC_DATE = dOC_DATE;
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
