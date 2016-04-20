package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

import com.mobile.database.app.common.DataConverter;
import com.mobile.database.app.entities.APPR_COLLATERAL;
import com.mobile.database.app.entities.APPR_DOKUMENT;
import com.mobile.database.app.entities.APPR_HISTORY;
import com.mobile.database.app.entities.APPR_MAIN;
import com.mobile.database.app.entities.APPR_MCH_VALUATION_INT;
import com.mobile.database.app.entities.APPR_PB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_RTB_CEK_TATA_KOTA_INT;
import com.mobile.database.app.entities.APPR_RTB_IMB_INT;
import com.mobile.database.app.entities.APPR_RTB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_VHC_VALUATION_INT;
import com.mobile.database.app.entities.BLACKBOX;

public class Datatype_Appr_Collateral implements Serializable {

	/**
	 * 
	 */
	public String COL_ID;
	public String COL_TYPE;
	public String COL_DESC;
	public String COL_CLASS_DESC;
	public String COL_RELATIONSHIP_DESC;
	public String DOC_DESC;
	public String AP_REGNO;
	public String COL_SEQ;
	public String COL_CODE;
	public String COL_CLASS;
	public String COL_DOK_TYPE;
	public String COL_DOK_NO;
	public String COL_DOK_NAME;
	public Date COL_DOK_DATE;
	public Date COL_DOK_EXPDATE;
	public String COL_BRANCH;
	public String COL_SANDIWIL;
	public String COL_UNIT;
	public String COL_CURR;
	public String COL_VALUE;
	public String COL_RELATIONSHIP;
	public String COL_ADDR1;
	public String COL_ADDR2;
	public String COL_ADDR3;
	public String COL_ZIPCODE;
	public String COL_KELURAHAN;
	public String COL_KECAMATAN;
	public String COL_CITY;
	public String COL_PROVINCE;
	public String CP_NAME;
	public String CP_HP;
	public String COL_PEMERINGKATAN;
	public String COL_PENERBIT;
	public String EKSTERNAL;
	public String INTERNAL;
	public String TATAKOTA;
	public String APPRAISE_BRANCH;
	public String COL_PENGIKATAN;
	public String CU_NAME;
	public String TATAKOTA_DESC;
	public String BRANCHID;
	public String SEG_CODE;
	public String COL_ISNEW;
	public String ISAPPRAISE;
	public String COL_DAHULUIAKTA;
	public String DOC_LENGKAP;
	public String APPRAISE_TYPE;
	public String APPR_DESC;
	public String DOC_COL_TYPE;
	public String BRANCHNAME;
	public String SEG_DESC;




	 public void updateMainFromJSON(JSONObject obj) throws Exception{
		 COL_ID=obj.getString("COL_ID");
		 COL_TYPE=obj.getString("COL_TYPE");
		 COL_DESC=obj.getString("COL_DESC");
		 COL_CLASS_DESC=obj.getString("COL_CLASS_DESC");
		 COL_RELATIONSHIP_DESC=obj.getString("COL_RELATIONSHIP_DESC");
		 DOC_DESC=obj.getString("DOC_DESC");
		 AP_REGNO=obj.getString("AP_REGNO");
		 COL_SEQ=obj.getString("COL_SEQ");
		 COL_CODE=obj.getString("COL_CODE");
		 COL_CLASS=obj.getString("COL_CLASS");
		 COL_DOK_TYPE=obj.getString("COL_DOK_TYPE");
		 COL_DOK_NO=obj.getString("COL_DOK_NO");
		 COL_DOK_NAME=obj.getString("COL_DOK_NAME");
		 COL_DOK_DATE=DataConverter.stringToDate(obj.getString("COL_DOK_DATE"));
		 COL_DOK_EXPDATE=DataConverter.stringToDate(obj.getString("COL_DOK_EXPDATE"));
		 COL_BRANCH=obj.getString("COL_BRANCH");
		 COL_SANDIWIL=obj.getString("COL_SANDIWIL");
		 COL_UNIT=obj.getString("COL_UNIT");
		 COL_CURR=obj.getString("COL_CURR");
		 COL_VALUE=obj.getString("COL_VALUE");
		 COL_RELATIONSHIP=obj.getString("COL_RELATIONSHIP");
		 COL_ADDR1=obj.getString("COL_ADDR1");
		 COL_ADDR2=obj.getString("COL_ADDR2");
		 COL_ADDR3=obj.getString("COL_ADDR3");
		 COL_ZIPCODE=obj.getString("COL_ZIPCODE");
		 COL_KELURAHAN=obj.getString("COL_KELURAHAN");
		 COL_KECAMATAN=obj.getString("COL_KECAMATAN");
		 COL_CITY=obj.getString("COL_CITY");
		 COL_PROVINCE=obj.getString("COL_PROVINCE");
		 CP_NAME=obj.getString("CP_NAME");
		 CP_HP=obj.getString("CP_HP");
		 COL_PEMERINGKATAN=obj.getString("COL_PEMERINGKATAN");
		 COL_PENERBIT=obj.getString("COL_PENERBIT");
		 EKSTERNAL=obj.getString("EKSTERNAL");
		 INTERNAL=obj.getString("INTERNAL");
		 TATAKOTA=obj.getString("TATAKOTA");
		 APPRAISE_BRANCH=obj.getString("APPRAISE_BRANCH");
		 COL_PENGIKATAN=obj.getString("COL_PENGIKATAN");
		 CU_NAME=obj.getString("CU_NAME");
		 TATAKOTA_DESC=obj.getString("TATAKOTA_DESC");
		 BRANCHID=obj.getString("BRANCHID");
		 SEG_CODE=obj.getString("SEG_CODE");
		 COL_ISNEW=obj.getString("COL_ISNEW");
		 ISAPPRAISE=obj.getString("ISAPPRAISE");
		 COL_DAHULUIAKTA=obj.getString("COL_DAHULUIAKTA");
		 DOC_LENGKAP=obj.getString("DOC_LENGKAP");
		 APPRAISE_TYPE=obj.getString("APPRAISE_TYPE");
		 APPR_DESC=obj.getString("APPR_DESC");
		 DOC_COL_TYPE=obj.getString("DOC_COL_TYPE");
		 BRANCHNAME=obj.getString("BRANCHNAME");
		 SEG_DESC=obj.getString("SEG_DESC");




	 }
    
	 public Datatype_Appr_Collateral() {
	    	update("",
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
	    			"","","");
		}
	    
	 public Datatype_Appr_Collateral(APPR_COLLATERAL Data) {
			update(Data);
	}
		

	public APPR_COLLATERAL toRowData(){
		APPR_COLLATERAL rowData= new APPR_COLLATERAL();
		rowData.setCOL_ID(COL_ID);
		rowData.setCOL_TYPE(COL_TYPE);
		rowData.setCOL_DESC(COL_DESC);
		rowData.setCOL_CLASS_DESC(COL_CLASS_DESC);
		rowData.setCOL_RELATIONSHIP_DESC(COL_RELATIONSHIP_DESC);
		rowData.setDOC_DESC(DOC_DESC);
		rowData.setAP_REGNO(AP_REGNO);
		rowData.setCOL_SEQ(COL_SEQ);
		rowData.setCOL_CODE(COL_CODE);
		rowData.setCOL_CLASS(COL_CLASS);
		rowData.setCOL_DOK_TYPE(COL_DOK_TYPE);
		rowData.setCOL_DOK_NO(COL_DOK_NO);
		rowData.setCOL_DOK_NAME(COL_DOK_NAME);
		rowData.setCOL_DOK_DATE(COL_DOK_DATE);
		rowData.setCOL_DOK_EXPDATE(COL_DOK_EXPDATE);
		rowData.setCOL_BRANCH(COL_BRANCH);
		rowData.setCOL_SANDIWIL(COL_SANDIWIL);
		rowData.setCOL_UNIT(COL_UNIT);
		rowData.setCOL_CURR(COL_CURR);
		rowData.setCOL_VALUE(COL_VALUE);
		rowData.setCOL_RELATIONSHIP(COL_RELATIONSHIP);
		rowData.setCOL_ADDR1(COL_ADDR1);
		rowData.setCOL_ADDR2(COL_ADDR2);
		rowData.setCOL_ADDR3(COL_ADDR3);
		rowData.setCOL_ZIPCODE(COL_ZIPCODE);
		rowData.setCOL_KELURAHAN(COL_KELURAHAN);
		rowData.setCOL_KECAMATAN(COL_KECAMATAN);
		rowData.setCOL_CITY(COL_CITY);
		rowData.setCOL_PROVINCE(COL_PROVINCE);
		rowData.setCP_NAME(CP_NAME);
		rowData.setCP_HP(CP_HP);
		rowData.setCOL_PEMERINGKATAN(COL_PEMERINGKATAN);
		rowData.setCOL_PENERBIT(COL_PENERBIT);
		rowData.setEKSTERNAL(EKSTERNAL);
		rowData.setINTERNAL(INTERNAL);
		rowData.setTATAKOTA(TATAKOTA);
		rowData.setAPPRAISE_BRANCH(APPRAISE_BRANCH);
		rowData.setCOL_PENGIKATAN(COL_PENGIKATAN);
		rowData.setCU_NAME(CU_NAME);
		rowData.setTATAKOTA_DESC(TATAKOTA_DESC);
		rowData.setBRANCHID(BRANCHID);
		rowData.setSEG_CODE(SEG_CODE);
		rowData.setCOL_ISNEW(COL_ISNEW);
		rowData.setISAPPRAISE(ISAPPRAISE);
		rowData.setCOL_DAHULUIAKTA(COL_DAHULUIAKTA);
		rowData.setDOC_LENGKAP(DOC_LENGKAP);
		rowData.setAPPRAISE_TYPE(APPRAISE_TYPE);
		rowData.setAPPR_DESC(APPR_DESC);
		rowData.setDOC_COL_TYPE(DOC_COL_TYPE);
		rowData.setBRANCHNAME(BRANCHNAME);
		rowData.setSEG_DESC(SEG_DESC);



	
		return rowData;
	}
	
	public void update(APPR_COLLATERAL rowData) {
		COL_ID=rowData.getCOL_ID();
		COL_TYPE=rowData.getCOL_TYPE();
		COL_DESC=rowData.getCOL_DESC();
		COL_CLASS_DESC=rowData.getCOL_CLASS_DESC();
		COL_RELATIONSHIP_DESC=rowData.getCOL_RELATIONSHIP_DESC();
		DOC_DESC=rowData.getDOC_DESC();
		AP_REGNO=rowData.getAP_REGNO();
		COL_SEQ=rowData.getCOL_SEQ();
		COL_CODE=rowData.getCOL_CODE();
		COL_CLASS=rowData.getCOL_CLASS();
		COL_DOK_TYPE=rowData.getCOL_DOK_TYPE();
		COL_DOK_NO=rowData.getCOL_DOK_NO();
		COL_DOK_NAME=rowData.getCOL_DOK_NAME();
		COL_DOK_DATE=rowData.getCOL_DOK_DATE();
		COL_DOK_EXPDATE=rowData.getCOL_DOK_EXPDATE();
		COL_BRANCH=rowData.getCOL_BRANCH();
		COL_SANDIWIL=rowData.getCOL_SANDIWIL();
		COL_UNIT=rowData.getCOL_UNIT();
		COL_CURR=rowData.getCOL_CURR();
		COL_VALUE=rowData.getCOL_VALUE();
		COL_RELATIONSHIP=rowData.getCOL_RELATIONSHIP();
		COL_ADDR1=rowData.getCOL_ADDR1();
		COL_ADDR2=rowData.getCOL_ADDR2();
		COL_ADDR3=rowData.getCOL_ADDR3();
		COL_ZIPCODE=rowData.getCOL_ZIPCODE();
		COL_KELURAHAN=rowData.getCOL_KELURAHAN();
		COL_KECAMATAN=rowData.getCOL_KECAMATAN();
		COL_CITY=rowData.getCOL_CITY();
		COL_PROVINCE=rowData.getCOL_PROVINCE();
		CP_NAME=rowData.getCP_NAME();
		CP_HP=rowData.getCP_HP();
		COL_PEMERINGKATAN=rowData.getCOL_PEMERINGKATAN();
		COL_PENERBIT=rowData.getCOL_PENERBIT();
		EKSTERNAL=rowData.getEKSTERNAL();
		INTERNAL=rowData.getINTERNAL();
		TATAKOTA=rowData.getTATAKOTA();
		APPRAISE_BRANCH=rowData.getAPPRAISE_BRANCH();
		COL_PENGIKATAN=rowData.getCOL_PENGIKATAN();
		CU_NAME=rowData.getCU_NAME();
		TATAKOTA_DESC=rowData.getTATAKOTA_DESC();
		BRANCHID=rowData.getBRANCHID();
		SEG_CODE=rowData.getSEG_CODE();
		COL_ISNEW=rowData.getCOL_ISNEW();
		ISAPPRAISE=rowData.getISAPPRAISE();
		COL_DAHULUIAKTA=rowData.getCOL_DAHULUIAKTA();
		DOC_LENGKAP=rowData.getDOC_LENGKAP();
		APPRAISE_TYPE=rowData.getAPPRAISE_TYPE();
		APPR_DESC=rowData.getAPPR_DESC();
		DOC_COL_TYPE=rowData.getDOC_COL_TYPE();
		BRANCHNAME=rowData.getBRANCHNAME();
		SEG_DESC=rowData.getSEG_DESC();




	}
	
	public void update(String id,
			String col_id,
			String col_type,
			String col_desc,
			String col_class_desc,
			String col_relationship_desc,
			String doc_desc,
			String ap_regno,
			String col_seq,
			String col_code,
			String col_class,
			String col_dok_type,
			String col_dok_no,
			String col_dok_name,
			Date col_dok_date,
			Date col_dok_expdate,
			String col_branch,
			String col_sandiwil,
			String col_unit,
			String col_curr,
			String col_value,
			String col_relationship,
			String col_addr1,
			String col_addr2,
			String col_addr3,
			String col_zipcode,
			String col_kelurahan,
			String col_kecamatan,
			String col_city,
			String col_province,
			String cp_name,
			String cp_hp,
			String col_pemeringkatan,
			String col_penerbit,
			String eksternal,
			String internal,
			String tatakota,
			String appraise_branch,
			String col_pengikatan,
			String cu_name,
			String tatakota_desc,
			String branchid,
			String seg_code,
			String col_isnew,
			String isappraise,
			String col_dahuluiakta,
			String doc_lengkap,
			String appraise_type,
			String appr_desc,
			String doc_col_type,
			String bRANCHNAME,
			String sEG_DESC){
		COL_ID=col_id;
		COL_TYPE=col_type;
		COL_DESC=col_desc;
		COL_CLASS_DESC=col_class_desc;
		COL_RELATIONSHIP_DESC=col_relationship_desc;
		DOC_DESC=doc_desc;
		AP_REGNO=ap_regno;
		COL_SEQ=col_seq;
		COL_CODE=col_code;
		COL_CLASS=col_class;
		COL_DOK_TYPE=col_dok_type;
		COL_DOK_NO=col_dok_no;
		COL_DOK_NAME=col_dok_name;
		COL_DOK_DATE=col_dok_date;
		COL_DOK_EXPDATE=col_dok_expdate;
		COL_BRANCH=col_branch;
		COL_SANDIWIL=col_sandiwil;
		COL_UNIT=col_unit;
		COL_CURR=col_curr;
		COL_VALUE=col_value;
		COL_RELATIONSHIP=col_relationship;
		COL_ADDR1=col_addr1;
		COL_ADDR2=col_addr2;
		COL_ADDR3=col_addr3;
		COL_ZIPCODE=col_zipcode;
		COL_KELURAHAN=col_kelurahan;
		COL_KECAMATAN=col_kecamatan;
		COL_CITY=col_city;
		COL_PROVINCE=col_province;
		CP_NAME=cp_name;
		CP_HP=cp_hp;
		COL_PEMERINGKATAN=col_pemeringkatan;
		COL_PENERBIT=col_penerbit;
		EKSTERNAL=eksternal;
		INTERNAL=internal;
		TATAKOTA=tatakota;
		APPRAISE_BRANCH=appraise_branch;
		COL_PENGIKATAN=col_pengikatan;
		CU_NAME=cu_name;
		TATAKOTA_DESC=tatakota_desc;
		BRANCHID=branchid;
		SEG_CODE=seg_code;
		COL_ISNEW=col_isnew;
		ISAPPRAISE=isappraise;
		COL_DAHULUIAKTA=col_dahuluiakta;
		DOC_LENGKAP=doc_lengkap;
		APPRAISE_TYPE=appraise_type;
		APPR_DESC=appr_desc;
		DOC_COL_TYPE=doc_col_type;
		BRANCHNAME=bRANCHNAME;
		SEG_DESC=sEG_DESC;

}

	public String getCOL_ID() {
		return COL_ID;
	}

	public void setCOL_ID(String cOL_ID) {
		COL_ID = cOL_ID;
	}

	public String getCOL_TYPE() {
		return COL_TYPE;
	}

	public void setCOL_TYPE(String cOL_TYPE) {
		COL_TYPE = cOL_TYPE;
	}

	public String getCOL_DESC() {
		return COL_DESC;
	}

	public void setCOL_DESC(String cOL_DESC) {
		COL_DESC = cOL_DESC;
	}

	public String getCOL_CLASS_DESC() {
		return COL_CLASS_DESC;
	}

	public void setCOL_CLASS_DESC(String cOL_CLASS_DESC) {
		COL_CLASS_DESC = cOL_CLASS_DESC;
	}

	public String getCOL_RELATIONSHIP_DESC() {
		return COL_RELATIONSHIP_DESC;
	}

	public void setCOL_RELATIONSHIP_DESC(String cOL_RELATIONSHIP_DESC) {
		COL_RELATIONSHIP_DESC = cOL_RELATIONSHIP_DESC;
	}

	public String getDOC_DESC() {
		return DOC_DESC;
	}

	public void setDOC_DESC(String dOC_DESC) {
		DOC_DESC = dOC_DESC;
	}

	public String getAP_REGNO() {
		return AP_REGNO;
	}

	public void setAP_REGNO(String aP_REGNO) {
		AP_REGNO = aP_REGNO;
	}

	public String getCOL_SEQ() {
		return COL_SEQ;
	}

	public void setCOL_SEQ(String cOL_SEQ) {
		COL_SEQ = cOL_SEQ;
	}

	public String getCOL_CODE() {
		return COL_CODE;
	}

	public void setCOL_CODE(String cOL_CODE) {
		COL_CODE = cOL_CODE;
	}

	public String getCOL_CLASS() {
		return COL_CLASS;
	}

	public void setCOL_CLASS(String cOL_CLASS) {
		COL_CLASS = cOL_CLASS;
	}

	public String getCOL_DOK_TYPE() {
		return COL_DOK_TYPE;
	}

	public void setCOL_DOK_TYPE(String cOL_DOK_TYPE) {
		COL_DOK_TYPE = cOL_DOK_TYPE;
	}

	public String getCOL_DOK_NO() {
		return COL_DOK_NO;
	}

	public void setCOL_DOK_NO(String cOL_DOK_NO) {
		COL_DOK_NO = cOL_DOK_NO;
	}

	public String getCOL_DOK_NAME() {
		return COL_DOK_NAME;
	}

	public void setCOL_DOK_NAME(String cOL_DOK_NAME) {
		COL_DOK_NAME = cOL_DOK_NAME;
	}

	public Date getCOL_DOK_DATE() {
		return COL_DOK_DATE;
	}

	public void setCOL_DOK_DATE(Date cOL_DOK_DATE) {
		COL_DOK_DATE = cOL_DOK_DATE;
	}

	public Date getCOL_DOK_EXPDATE() {
		return COL_DOK_EXPDATE;
	}

	public void setCOL_DOK_EXPDATE(Date cOL_DOK_EXPDATE) {
		COL_DOK_EXPDATE = cOL_DOK_EXPDATE;
	}

	public String getCOL_BRANCH() {
		return COL_BRANCH;
	}

	public void setCOL_BRANCH(String cOL_BRANCH) {
		COL_BRANCH = cOL_BRANCH;
	}

	public String getCOL_SANDIWIL() {
		return COL_SANDIWIL;
	}

	public void setCOL_SANDIWIL(String cOL_SANDIWIL) {
		COL_SANDIWIL = cOL_SANDIWIL;
	}

	public String getCOL_UNIT() {
		return COL_UNIT;
	}

	public void setCOL_UNIT(String cOL_UNIT) {
		COL_UNIT = cOL_UNIT;
	}

	public String getCOL_CURR() {
		return COL_CURR;
	}

	public void setCOL_CURR(String cOL_CURR) {
		COL_CURR = cOL_CURR;
	}

	public String getCOL_VALUE() {
		return COL_VALUE;
	}

	public void setCOL_VALUE(String cOL_VALUE) {
		COL_VALUE = cOL_VALUE;
	}

	public String getCOL_RELATIONSHIP() {
		return COL_RELATIONSHIP;
	}

	public void setCOL_RELATIONSHIP(String cOL_RELATIONSHIP) {
		COL_RELATIONSHIP = cOL_RELATIONSHIP;
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

	public String getCOL_ZIPCODE() {
		return COL_ZIPCODE;
	}

	public void setCOL_ZIPCODE(String cOL_ZIPCODE) {
		COL_ZIPCODE = cOL_ZIPCODE;
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

	public String getCOL_PROVINCE() {
		return COL_PROVINCE;
	}

	public void setCOL_PROVINCE(String cOL_PROVINCE) {
		COL_PROVINCE = cOL_PROVINCE;
	}

	public String getCP_NAME() {
		return CP_NAME;
	}

	public void setCP_NAME(String cP_NAME) {
		CP_NAME = cP_NAME;
	}

	public String getCP_HP() {
		return CP_HP;
	}

	public void setCP_HP(String cP_HP) {
		CP_HP = cP_HP;
	}

	public String getCOL_PEMERINGKATAN() {
		return COL_PEMERINGKATAN;
	}

	public void setCOL_PEMERINGKATAN(String cOL_PEMERINGKATAN) {
		COL_PEMERINGKATAN = cOL_PEMERINGKATAN;
	}

	public String getCOL_PENERBIT() {
		return COL_PENERBIT;
	}

	public void setCOL_PENERBIT(String cOL_PENERBIT) {
		COL_PENERBIT = cOL_PENERBIT;
	}

	public String getEKSTERNAL() {
		return EKSTERNAL;
	}

	public void setEKSTERNAL(String eKSTERNAL) {
		EKSTERNAL = eKSTERNAL;
	}

	public String getINTERNAL() {
		return INTERNAL;
	}

	public void setINTERNAL(String iNTERNAL) {
		INTERNAL = iNTERNAL;
	}

	public String getTATAKOTA() {
		return TATAKOTA;
	}

	public void setTATAKOTA(String tATAKOTA) {
		TATAKOTA = tATAKOTA;
	}

	public String getAPPRAISE_BRANCH() {
		return APPRAISE_BRANCH;
	}

	public void setAPPRAISE_BRANCH(String aPPRAISE_BRANCH) {
		APPRAISE_BRANCH = aPPRAISE_BRANCH;
	}

	public String getCOL_PENGIKATAN() {
		return COL_PENGIKATAN;
	}

	public void setCOL_PENGIKATAN(String cOL_PENGIKATAN) {
		COL_PENGIKATAN = cOL_PENGIKATAN;
	}

	public String getCU_NAME() {
		return CU_NAME;
	}

	public void setCU_NAME(String cU_NAME) {
		CU_NAME = cU_NAME;
	}

	public String getTATAKOTA_DESC() {
		return TATAKOTA_DESC;
	}

	public void setTATAKOTA_DESC(String tATAKOTA_DESC) {
		TATAKOTA_DESC = tATAKOTA_DESC;
	}

	public String getBRANCHID() {
		return BRANCHID;
	}

	public void setBRANCHID(String bRANCHID) {
		BRANCHID = bRANCHID;
	}

	public String getSEG_CODE() {
		return SEG_CODE;
	}

	public void setSEG_CODE(String sEG_CODE) {
		SEG_CODE = sEG_CODE;
	}

	public String getCOL_ISNEW() {
		return COL_ISNEW;
	}

	public void setCOL_ISNEW(String cOL_ISNEW) {
		COL_ISNEW = cOL_ISNEW;
	}

	public String getISAPPRAISE() {
		return ISAPPRAISE;
	}

	public void setISAPPRAISE(String iSAPPRAISE) {
		ISAPPRAISE = iSAPPRAISE;
	}

	public String getCOL_DAHULUIAKTA() {
		return COL_DAHULUIAKTA;
	}

	public void setCOL_DAHULUIAKTA(String cOL_DAHULUIAKTA) {
		COL_DAHULUIAKTA = cOL_DAHULUIAKTA;
	}

	public String getDOC_LENGKAP() {
		return DOC_LENGKAP;
	}

	public void setDOC_LENGKAP(String dOC_LENGKAP) {
		DOC_LENGKAP = dOC_LENGKAP;
	}

	public String getAPPRAISE_TYPE() {
		return APPRAISE_TYPE;
	}

	public void setAPPRAISE_TYPE(String aPPRAISE_TYPE) {
		APPRAISE_TYPE = aPPRAISE_TYPE;
	}

	public String getAPPR_DESC() {
		return APPR_DESC;
	}

	public void setAPPR_DESC(String aPPR_DESC) {
		APPR_DESC = aPPR_DESC;
	}

	public String getDOC_COL_TYPE() {
		return DOC_COL_TYPE;
	}

	public void setDOC_COL_TYPE(String dOC_COL_TYPE) {
		DOC_COL_TYPE = dOC_COL_TYPE;
	}

	public String getBRANCHNAME() {
		return BRANCHNAME;
	}

	public void setBRANCHNAME(String bRANCHNAME) {
		BRANCHNAME = bRANCHNAME;
	}

	public String getSEG_DESC() {
		return SEG_DESC;
	}

	public void setSEG_DESC(String sEG_DESC) {
		SEG_DESC = sEG_DESC;
	}

	
	
}
