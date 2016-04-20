package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

import com.mobile.database.app.common.DataConverter;
import com.mobile.database.app.entities.APPR_DOKUMENT;
import com.mobile.database.app.entities.APPR_MAIN;
import com.mobile.database.app.entities.APPR_MCH_VALUATION_INT;
import com.mobile.database.app.entities.APPR_PB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_RTB_CEK_TATA_KOTA_INT;
import com.mobile.database.app.entities.APPR_RTB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_VHC_VALUATION_INT;
import com.mobile.database.app.entities.BLACKBOX;

public class Datatype_Appr_Dokument implements Serializable {

	/**
	 * 
	 */
	public String ID;
	public String AP_REGNO;
	public String DOC_ID;
	public String DOC_TYPE;
	public String DOC_CODE;
	public String DOC_NO;
	public Date DOC_EXPIREDATE;
	public String DOC_ORIG;
	public String DOC_COPY;
	public String DOC_WAIVE;
	public String DOC_TBO;
	public Date DOC_TBODATE;
	public String DOC_VER_MANAGER;
	public String DOC_VER_CDU;
	public String DOC_DESC;
	public String DOC_NA;
	public String DOC_JUSTIFIED;
	public String DOC_MANDATORY;
	public Date UPLOADDATE;
	public String JUMLAH;
	public String DOC_DECISION_TBO;
	public String DOC_VER_CAC;



	 public void updateMainFromJSON(JSONObject obj) throws Exception{
		 ID=obj.getString("ID");
		 AP_REGNO=obj.getString("AP_REGNO");
		 DOC_ID=obj.getString("DOC_ID");
		 DOC_TYPE=obj.getString("DOC_TYPE");
		 DOC_CODE=obj.getString("DOC_CODE");
		 DOC_NO=obj.getString("DOC_NO");
		 DOC_EXPIREDATE=DataConverter.stringToDate(obj.getString("DOC_EXPIREDATE"));
		 DOC_ORIG=obj.getString("DOC_ORIG");
		 DOC_COPY=obj.getString("DOC_COPY");
		 DOC_WAIVE=obj.getString("DOC_WAIVE");
		 DOC_TBO=obj.getString("DOC_TBO");
		 DOC_TBODATE=DataConverter.stringToDate(obj.getString("DOC_TBODATE"));
		 DOC_VER_MANAGER=obj.getString("DOC_VER_MANAGER");
		 DOC_VER_CDU=obj.getString("DOC_VER_CDU");
		 DOC_DESC=obj.getString("DOC_DESC");
		 DOC_NA=obj.getString("DOC_NA");
		 DOC_JUSTIFIED=obj.getString("DOC_JUSTIFIED");
		 DOC_MANDATORY=obj.getString("DOC_MANDATORY");
		 UPLOADDATE=DataConverter.stringToDate(obj.getString("UPLOADDATE"));
		 JUMLAH=obj.getString("JUMLAH");
		 DOC_DECISION_TBO=obj.getString("DOC_DECISION_TBO");
		 DOC_VER_CAC=obj.getString("DOC_VER_CAC");


	 }
    
	 public Datatype_Appr_Dokument() {
	    	update("",
	    			"",
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
	    			null,
	    			"",
	    			"",
	    			"");
		}
	    
	 public Datatype_Appr_Dokument(APPR_DOKUMENT Data) {
			update(Data);
	}
		

	public APPR_DOKUMENT toRowData(){
		APPR_DOKUMENT rowData= new APPR_DOKUMENT();
		rowData.setID(ID);
		rowData.setAP_REGNO(AP_REGNO);
		rowData.setDOC_ID(DOC_ID);
		rowData.setDOC_TYPE(DOC_TYPE);
		rowData.setDOC_CODE(DOC_CODE);
		rowData.setDOC_NO(DOC_NO);
		rowData.setDOC_EXPIREDATE(DOC_EXPIREDATE);
		rowData.setDOC_ORIG(DOC_ORIG);
		rowData.setDOC_COPY(DOC_COPY);
		rowData.setDOC_WAIVE(DOC_WAIVE);
		rowData.setDOC_TBO(DOC_TBO);
		rowData.setDOC_TBODATE(DOC_TBODATE);
		rowData.setDOC_VER_MANAGER(DOC_VER_MANAGER);
		rowData.setDOC_VER_CDU(DOC_VER_CDU);
		rowData.setDOC_DESC(DOC_DESC);
		rowData.setDOC_NA(DOC_NA);
		rowData.setDOC_JUSTIFIED(DOC_JUSTIFIED);
		rowData.setDOC_MANDATORY(DOC_MANDATORY);
		rowData.setUPLOADDATE(UPLOADDATE);
		rowData.setJUMLAH(JUMLAH);
		rowData.setDOC_DECISION_TBO(DOC_DECISION_TBO);
		rowData.setDOC_VER_CAC(DOC_VER_CAC);


	
		return rowData;
	}
	
	public void update(APPR_DOKUMENT rowData) {
		ID=rowData.getID();
		AP_REGNO=rowData.getAP_REGNO();
		DOC_ID=rowData.getDOC_ID();
		DOC_TYPE=rowData.getDOC_TYPE();
		DOC_CODE=rowData.getDOC_CODE();
		DOC_NO=rowData.getDOC_NO();
		DOC_EXPIREDATE=rowData.getDOC_EXPIREDATE();
		DOC_ORIG=rowData.getDOC_ORIG();
		DOC_COPY=rowData.getDOC_COPY();
		DOC_WAIVE=rowData.getDOC_WAIVE();
		DOC_TBO=rowData.getDOC_TBO();
		DOC_TBODATE=rowData.getDOC_TBODATE();
		DOC_VER_MANAGER=rowData.getDOC_VER_MANAGER();
		DOC_VER_CDU=rowData.getDOC_VER_CDU();
		DOC_DESC=rowData.getDOC_DESC();
		DOC_NA=rowData.getDOC_NA();
		DOC_JUSTIFIED=rowData.getDOC_JUSTIFIED();
		DOC_MANDATORY=rowData.getDOC_MANDATORY();
		UPLOADDATE=rowData.getUPLOADDATE();
		JUMLAH=rowData.getJUMLAH();
		DOC_DECISION_TBO=rowData.getDOC_DECISION_TBO();
		DOC_VER_CAC=rowData.getDOC_VER_CAC();



	}
	
	public void update(String id,
			String ap_regno,
			String doc_id,
			String doc_type,
			String doc_code,
			String doc_no,
			Date doc_expiredate,
			String doc_orig,
			String doc_copy,
			String doc_waive,
			String doc_tbo,
			Date doc_tbodate,
			String doc_ver_manager,
			String doc_ver_cdu,
			String doc_desc,
			String doc_na,
			String doc_justified,
			String doc_mandatory,
			Date uploaddate,
			String jumlah,
			String doc_decision_tbo,
			String doc_ver_cac){
		ID=id;
		AP_REGNO=ap_regno;
		DOC_ID=doc_id;
		DOC_TYPE=doc_type;
		DOC_CODE=doc_code;
		DOC_NO=doc_no;
		DOC_EXPIREDATE=doc_expiredate;
		DOC_ORIG=doc_orig;
		DOC_COPY=doc_copy;
		DOC_WAIVE=doc_waive;
		DOC_TBO=doc_tbo;
		DOC_TBODATE=doc_tbodate;
		DOC_VER_MANAGER=doc_ver_manager;
		DOC_VER_CDU=doc_ver_cdu;
		DOC_DESC=doc_desc;
		DOC_NA=doc_na;
		DOC_JUSTIFIED=doc_justified;
		DOC_MANDATORY=doc_mandatory;
		UPLOADDATE=uploaddate;
		JUMLAH=jumlah;
		DOC_DECISION_TBO=doc_decision_tbo;
		DOC_VER_CAC=doc_ver_cac;

}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getAP_REGNO() {
		return AP_REGNO;
	}

	public void setAP_REGNO(String aP_REGNO) {
		AP_REGNO = aP_REGNO;
	}

	public String getDOC_ID() {
		return DOC_ID;
	}

	public void setDOC_ID(String dOC_ID) {
		DOC_ID = dOC_ID;
	}

	public String getDOC_TYPE() {
		return DOC_TYPE;
	}

	public void setDOC_TYPE(String dOC_TYPE) {
		DOC_TYPE = dOC_TYPE;
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

	public Date getDOC_EXPIREDATE() {
		return DOC_EXPIREDATE;
	}

	public void setDOC_EXPIREDATE(Date dOC_EXPIREDATE) {
		DOC_EXPIREDATE = dOC_EXPIREDATE;
	}

	public String getDOC_ORIG() {
		return DOC_ORIG;
	}

	public void setDOC_ORIG(String dOC_ORIG) {
		DOC_ORIG = dOC_ORIG;
	}

	public String getDOC_COPY() {
		return DOC_COPY;
	}

	public void setDOC_COPY(String dOC_COPY) {
		DOC_COPY = dOC_COPY;
	}

	public String getDOC_WAIVE() {
		return DOC_WAIVE;
	}

	public void setDOC_WAIVE(String dOC_WAIVE) {
		DOC_WAIVE = dOC_WAIVE;
	}

	public String getDOC_TBO() {
		return DOC_TBO;
	}

	public void setDOC_TBO(String dOC_TBO) {
		DOC_TBO = dOC_TBO;
	}

	public Date getDOC_TBODATE() {
		return DOC_TBODATE;
	}

	public void setDOC_TBODATE(Date dOC_TBODATE) {
		DOC_TBODATE = dOC_TBODATE;
	}

	public String getDOC_VER_MANAGER() {
		return DOC_VER_MANAGER;
	}

	public void setDOC_VER_MANAGER(String dOC_VER_MANAGER) {
		DOC_VER_MANAGER = dOC_VER_MANAGER;
	}

	public String getDOC_VER_CDU() {
		return DOC_VER_CDU;
	}

	public void setDOC_VER_CDU(String dOC_VER_CDU) {
		DOC_VER_CDU = dOC_VER_CDU;
	}

	public String getDOC_DESC() {
		return DOC_DESC;
	}

	public void setDOC_DESC(String dOC_DESC) {
		DOC_DESC = dOC_DESC;
	}

	public String getDOC_NA() {
		return DOC_NA;
	}

	public void setDOC_NA(String dOC_NA) {
		DOC_NA = dOC_NA;
	}

	public String getDOC_JUSTIFIED() {
		return DOC_JUSTIFIED;
	}

	public void setDOC_JUSTIFIED(String dOC_JUSTIFIED) {
		DOC_JUSTIFIED = dOC_JUSTIFIED;
	}

	public String getDOC_MANDATORY() {
		return DOC_MANDATORY;
	}

	public void setDOC_MANDATORY(String dOC_MANDATORY) {
		DOC_MANDATORY = dOC_MANDATORY;
	}

	public Date getUPLOADDATE() {
		return UPLOADDATE;
	}

	public void setUPLOADDATE(Date uPLOADDATE) {
		UPLOADDATE = uPLOADDATE;
	}

	public String getJUMLAH() {
		return JUMLAH;
	}

	public void setJUMLAH(String jUMLAH) {
		JUMLAH = jUMLAH;
	}

	public String getDOC_DECISION_TBO() {
		return DOC_DECISION_TBO;
	}

	public void setDOC_DECISION_TBO(String dOC_DECISION_TBO) {
		DOC_DECISION_TBO = dOC_DECISION_TBO;
	}

	public String getDOC_VER_CAC() {
		return DOC_VER_CAC;
	}

	public void setDOC_VER_CAC(String dOC_VER_CAC) {
		DOC_VER_CAC = dOC_VER_CAC;
	}

	

	
}
