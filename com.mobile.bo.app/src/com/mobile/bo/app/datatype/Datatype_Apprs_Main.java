package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.mobile.database.app.entities.APPR_MAIN;
import com.mobile.database.app.entities.BLACKBOX;

/**
 * @author hendro
 *
 */
public class Datatype_Apprs_Main implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4625139172873280188L;
	public String COL_ID;
	public String AP_REGNO;
	public String COL_SEQ;
	public String COL_CODE;
	public String COL_CLASS;
	public String COL_DOK_TYPE;
	public String COL_DOK_NO;
	public String COL_DOK_NAME;
	public String COL_BRANCH;
	public String COL_PEMERINGKATAN;
	public String COL_PENERBIT;
	public String COL_ADDR1;
	public String COL_ADDR2;
	public String COL_ADDR3;
	public String COL_ZIPCODE;
	public String COL_KELURAHAN;
	public String COL_KECAMATAN;
	public String COL_CITY;
	public String CP_NAME;
	public String CP_HP;
	public String COL_RELATIONSHIP;
	public String TATAKOTA_DESC;
	public String APPR_DESC;

	
	public Datatype_Apprs_Main() {
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
	    
	 public Datatype_Apprs_Main(APPR_MAIN blackbox) {
			update(blackbox);
	}
		


	public APPR_MAIN toRowData(){
		APPR_MAIN rowData= new APPR_MAIN();
		rowData.setCOL_ID(COL_ID);
		rowData.setAP_REGNO(AP_REGNO);
		rowData.setCOL_SEQ(COL_SEQ);
		rowData.setCOL_CODE(COL_CODE);
		rowData.setCOL_CLASS(COL_CLASS);
		rowData.setCOL_DOK_TYPE(COL_DOK_TYPE);
		rowData.setCOL_DOK_NO(COL_DOK_NO);
		rowData.setCOL_DOK_NAME(COL_DOK_NAME);
		rowData.setCOL_BRANCH(COL_BRANCH);
		rowData.setCOL_PEMERINGKATAN(COL_PEMERINGKATAN);
		rowData.setCOL_PENERBIT(COL_PENERBIT);
		rowData.setCOL_ADDR1(COL_ADDR1);
		rowData.setCOL_ADDR2(COL_ADDR2);
		rowData.setCOL_ADDR3(COL_ADDR3);
		rowData.setCOL_ZIPCODE(COL_ZIPCODE);
		rowData.setCOL_KELURAHAN(COL_KELURAHAN);
		rowData.setCOL_KECAMATAN(COL_KECAMATAN);
		rowData.setCOL_CITY(COL_CITY);
		rowData.setCP_NAME(CP_NAME);
		rowData.setCP_HP(CP_HP);
		rowData.setCOL_CODE(COL_CODE);
		rowData.setCOL_RELATIONSHIP(COL_RELATIONSHIP);
		rowData.setTATAKOTA_DESC(TATAKOTA_DESC);
		rowData.setAPPR_DESC(APPR_DESC);

		return rowData;
	}

	public void update(APPR_MAIN rowData) {
		COL_ID=rowData.getCOL_ID();
		AP_REGNO=rowData.getAP_REGNO();
		COL_SEQ=rowData.getCOL_SEQ();
		COL_CODE=rowData.getCOL_CODE();
		COL_CLASS=rowData.getCOL_CLASS();
		COL_DOK_TYPE=rowData.getCOL_DOK_TYPE();
		COL_DOK_NO=rowData.getCOL_DOK_NO();
		COL_DOK_NAME=rowData.getCOL_DOK_NAME();
		COL_BRANCH=rowData.getCOL_BRANCH();
		COL_PEMERINGKATAN=rowData.getCOL_PEMERINGKATAN();
		COL_PENERBIT=rowData.getCOL_PENERBIT();
		COL_ADDR1=rowData.getCOL_ADDR1();
		COL_ADDR2=rowData.getCOL_ADDR2();
		COL_ADDR3=rowData.getCOL_ADDR3();
		COL_ZIPCODE=rowData.getCOL_ZIPCODE();
		COL_KELURAHAN=rowData.getCOL_KELURAHAN();
		COL_KECAMATAN=rowData.getCOL_KECAMATAN();
		COL_CITY=rowData.getCOL_CITY();
		CP_NAME=rowData.getCP_NAME();
		CP_HP=rowData.getCP_HP();
		COL_CODE=rowData.getCOL_CODE();
		COL_RELATIONSHIP=rowData.getCOL_RELATIONSHIP();
		TATAKOTA_DESC=rowData.getTATAKOTA_DESC();
		APPR_DESC=rowData.getAPPR_DESC();

		
		
	}
	
	public void update(String col_id,
			String ap_regno,
			String col_seq,
			String col_code,
			String col_class,
			String col_dok_type,
			String col_dok_no,
			String col_dok_name,
			String col_branch,
			String col_pemeringkatan,
			String col_penerbit,
			String col_addr1,
			String col_addr2,
			String col_addr3,
			String col_zipcode,
			String col_kelurahan,
			String col_kecamatan,
			String col_city,
			String cp_name,
			String cp_hp,
			String col_relationship,
			String tatakota_desc,
			String appr_desc){
		COL_ID=col_id;
		AP_REGNO=ap_regno;
		COL_SEQ=col_seq;
		COL_CODE=col_code;
		COL_CLASS=col_class;
		COL_DOK_TYPE=col_dok_type;
		COL_DOK_NO=col_dok_no;
		COL_DOK_NAME=col_dok_name;
		COL_BRANCH=col_branch;
		COL_PEMERINGKATAN=col_pemeringkatan;
		COL_PENERBIT=col_penerbit;
		COL_ADDR1=col_addr1;
		COL_ADDR2=col_addr2;
		COL_ADDR3=col_addr3;
		COL_ZIPCODE=col_zipcode;
		COL_KELURAHAN=col_kelurahan;
		COL_KECAMATAN=col_kecamatan;
		COL_CITY=col_city;
		CP_NAME=cp_name;
		CP_HP=cp_hp;
		COL_RELATIONSHIP=col_relationship;
		TATAKOTA_DESC=tatakota_desc;
		APPR_DESC=appr_desc;
	
	
	}
	
	public void updateMainFromJSON(JSONObject obj) throws Exception{
		COL_ID=obj.getString("COL_ID");
		AP_REGNO=obj.getString("AP_REGNO");
		COL_SEQ=obj.getString("COL_SEQ");
		COL_CODE=obj.getString("COL_CODE");
		COL_CLASS=obj.getString("COL_CLASS");
		COL_DOK_TYPE=obj.getString("COL_DOK_TYPE");
		COL_DOK_NO=obj.getString("COL_DOK_NO");
		COL_DOK_NAME=obj.getString("COL_DOK_NAME");
		COL_BRANCH=obj.getString("COL_BRANCH");
		COL_PEMERINGKATAN=obj.getString("COL_PEMERINGKATAN");
		COL_PENERBIT=obj.getString("COL_PENERBIT");
		COL_ADDR1=obj.getString("COL_ADDR1");
		COL_ADDR2=obj.getString("COL_ADDR2");
		COL_ADDR3=obj.getString("COL_ADDR3");
		COL_ZIPCODE=obj.getString("COL_ZIPCODE");
		COL_KELURAHAN=obj.getString("COL_KELURAHAN");
		COL_KECAMATAN=obj.getString("COL_KECAMATAN");
		COL_CITY=obj.getString("COL_CITY");
		CP_NAME=obj.getString("CP_NAME");
		CP_HP=obj.getString("CP_HP");
		COL_CODE=obj.getString("COL_CODE");
		COL_RELATIONSHIP=obj.getString("COL_RELATIONSHIP");
		TATAKOTA_DESC=obj.getString("TATAKOTA_DESC");
		APPR_DESC=obj.getString("APPR_DESC");



	
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

	public String getCOL_BRANCH() {
		return COL_BRANCH;
	}

	public void setCOL_BRANCH(String cOL_BRANCH) {
		COL_BRANCH = cOL_BRANCH;
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

	public String getCOL_RELATIONSHIP() {
		return COL_RELATIONSHIP;
	}

	public void setCOL_RELATIONSHIP(String cOL_RELATIONSHIP) {
		COL_RELATIONSHIP = cOL_RELATIONSHIP;
	}

	public String getTATAKOTA_DESC() {
		return TATAKOTA_DESC;
	}

	public void setTATAKOTA_DESC(String tATAKOTA_DESC) {
		TATAKOTA_DESC = tATAKOTA_DESC;
	}

	public String getAPPR_DESC() {
		return APPR_DESC;
	}

	public void setAPPR_DESC(String aPPR_DESC) {
		APPR_DESC = aPPR_DESC;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
