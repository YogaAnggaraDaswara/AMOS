package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

import com.mobile.database.app.common.DataConverter;
import com.mobile.database.app.entities.APPR_INBOXS;
import com.mobile.database.app.entities.APPR_MAIN;
import com.mobile.database.app.entities.APPR_MCH_VALUATION_INT;
import com.mobile.database.app.entities.APPR_PB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_RTB_CEK_TATA_KOTA_INT;
import com.mobile.database.app.entities.APPR_RTB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_VHC_VALUATION_INT;
import com.mobile.database.app.entities.BLACKBOX;

public class Datatype_Appr_Inbox implements Serializable {

	/**
	 * 
	 */
	public String ALT_TYPE;
	public String ALT_ID;
	public String ALT_CURRTRCODE;
	public String ALT_NEXTTRBY;
	public String ALT_LASTTRCODE;
	public String AP_REGNO;
	public Date AP_RECVDATE;
	public String CU_NAME;
	public String CUTYPE_CODE;
	public String CUTYPE_DESC;
	public String BRANCHID;
	public String CCOBRANCH;
	public String BRANCHNAME;
	public String COL_KELURAHAN;
	public String COL_KECAMATAN;
	public String COL_DOK_NO;
	public String COL_DESC;
	public String COL_TYPE;
	public String ALT_TRDESC;
	public String PENDINGTRACK;
	public String ALT_TYPEDESC;
	public String ALT_DESC;
	public String AP_REGNO_DESC;
	public String CU_NPWP;
	public String AGING;
	public String PENDINGSTATUS;
	public String APPRAISE_TYPE;
	public String APP_STATUS;
	public void updateMainFromJSON(JSONObject obj) throws Exception{
		 ALT_TYPE=obj.getString("ALT_TYPE");
		 ALT_ID=obj.getString("ALT_ID");
		 ALT_CURRTRCODE=obj.getString("ALT_CURRTRCODE");
		 ALT_NEXTTRBY=obj.getString("ALT_NEXTTRBY");
		 ALT_LASTTRCODE=obj.getString("ALT_LASTTRCODE");
		 AP_REGNO=obj.getString("AP_REGNO");
		 AP_RECVDATE=DataConverter.stringToDate(obj.getString("AP_RECVDATE"));
		 CU_NAME=obj.getString("CU_NAME");
		 CUTYPE_CODE=obj.getString("CUTYPE_CODE");
		 CUTYPE_DESC=obj.getString("CUTYPE_DESC");
		 BRANCHID=obj.getString("BRANCHID");
		 CCOBRANCH=obj.getString("CCOBRANCH");
		 BRANCHNAME=obj.getString("BRANCHNAME");
		 COL_KELURAHAN=obj.getString("COL_KELURAHAN");
		 COL_KECAMATAN=obj.getString("COL_KECAMATAN");
		 COL_DOK_NO=obj.getString("COL_DOK_NO");
		 COL_DESC=obj.getString("COL_DESC");
		 COL_TYPE=obj.getString("COL_TYPE");
		 ALT_TRDESC=obj.getString("ALT_TRDESC");
		 PENDINGTRACK=obj.getString("PENDINGTRACK");
		 ALT_TYPEDESC=obj.getString("ALT_TYPEDESC");
		 ALT_DESC=obj.getString("ALT_DESC");
		 AP_REGNO_DESC=obj.getString("AP_REGNO_DESC");
		 CU_NPWP=obj.getString("CU_NPWP");
		 AGING=obj.getString("AGING");
		 PENDINGSTATUS=obj.getString("PENDINGSTATUS");
		 APPRAISE_TYPE=obj.getString("APPRAISE_TYPE");
		 APP_STATUS=obj.getString("APP_STATUS");
		 
	 }
    
	 public Datatype_Appr_Inbox() {
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
	    			"","","","","","");
		}
	    
	 public Datatype_Appr_Inbox(APPR_INBOXS Data) {
			update(Data);
	}
		

	public APPR_INBOXS toRowData(){
		APPR_INBOXS rowData= new APPR_INBOXS();
		rowData.setALT_TYPE(ALT_TYPE);
		rowData.setALT_ID(ALT_ID);
		rowData.setALT_CURRTRCODE(ALT_CURRTRCODE);
		rowData.setALT_NEXTTRBY(ALT_NEXTTRBY);
		rowData.setALT_LASTTRCODE(ALT_LASTTRCODE);
		rowData.setAP_REGNO(AP_REGNO);
		rowData.setAP_RECVDATE(AP_RECVDATE);
		rowData.setCU_NAME(CU_NAME);
		rowData.setCUTYPE_CODE(CUTYPE_CODE);
		rowData.setCUTYPE_DESC(CUTYPE_DESC);
		rowData.setBRANCHID(BRANCHID);
		rowData.setCCOBRANCH(CCOBRANCH);
		rowData.setBRANCHNAME(BRANCHNAME);
		rowData.setCOL_KELURAHAN(COL_KELURAHAN);
		rowData.setCOL_KECAMATAN(COL_KECAMATAN);
		rowData.setCOL_DOK_NO(COL_DOK_NO);
		rowData.setCOL_DESC(COL_DESC);
		rowData.setCOL_TYPE(COL_TYPE);
		rowData.setALT_TRDESC(ALT_TRDESC);
		rowData.setPENDINGTRACK(PENDINGTRACK);
		rowData.setALT_TYPEDESC(ALT_TYPEDESC);
		rowData.setALT_DESC(ALT_DESC);
		rowData.setAP_REGNO_DESC(AP_REGNO_DESC);

		rowData.setCU_NPWP(CU_NPWP);
		rowData.setAGING(AGING);
		rowData.setPENDINGSTATUS(PENDINGSTATUS);
		rowData.setAPPRAISE_TYPE(APPRAISE_TYPE);
		rowData.setAPP_STATUS(APP_STATUS);
		
		return rowData;
	}
	
	public void update(APPR_INBOXS rowData) {
		ALT_TYPE=rowData.getALT_TYPE();
		ALT_ID=rowData.getALT_ID();
		ALT_CURRTRCODE=rowData.getALT_CURRTRCODE();
		ALT_NEXTTRBY=rowData.getALT_NEXTTRBY();
		ALT_LASTTRCODE=rowData.getALT_LASTTRCODE();
		AP_REGNO=rowData.getAP_REGNO();
		AP_RECVDATE=rowData.getAP_RECVDATE();
		CU_NAME=rowData.getCU_NAME();
		CUTYPE_CODE=rowData.getCUTYPE_CODE();
		CUTYPE_DESC=rowData.getCUTYPE_DESC();
		BRANCHID=rowData.getBRANCHID();
		CCOBRANCH=rowData.getCCOBRANCH();
		BRANCHNAME=rowData.getBRANCHNAME();
		COL_KELURAHAN=rowData.getCOL_KELURAHAN();
		COL_KECAMATAN=rowData.getCOL_KECAMATAN();
		COL_DOK_NO=rowData.getCOL_DOK_NO();
		COL_DESC=rowData.getCOL_DESC();
		COL_TYPE=rowData.getCOL_TYPE();
		ALT_TRDESC=rowData.getALT_TRDESC();
		PENDINGTRACK=rowData.getPENDINGTRACK();
		ALT_TYPEDESC=rowData.getALT_TYPEDESC();
		ALT_DESC=rowData.getALT_DESC();
		AP_REGNO_DESC=rowData.getAP_REGNO_DESC();

		CU_NPWP=rowData.getCU_NPWP();
		AGING=rowData.getAGING();
		PENDINGSTATUS=rowData.getPENDINGSTATUS();
		APPRAISE_TYPE=rowData.getAPPRAISE_TYPE();
		APP_STATUS=rowData.getAPP_STATUS();
		
	}
	
	public void update(String alt_type,
			String alt_id,
			String alt_currtrcode,
			String alt_nexttrby,
			String alt_lasttrcode,
			String ap_regno,
			Date ap_recvdate,
			String cu_name,
			String cutype_code,
			String cutype_desc,
			String branchid,
			String ccobranch,
			String branchname,
			String col_kelurahan,
			String col_kecamatan,
			String col_dok_no,
			String col_desc,
			String col_type,
			String alt_trdesc,
			String pendingtrack,
			String alt_typedesc,
			String alt_desc,
			String ap_regno_desc,
			String cu_npwp,
			String aging,
			String pendingstatus,
			String appraise_type,String aPP_STATUS
			){
		ALT_TYPE=alt_type;
		ALT_ID=alt_id;
		ALT_CURRTRCODE=alt_currtrcode;
		ALT_NEXTTRBY=alt_nexttrby;
		ALT_LASTTRCODE=alt_lasttrcode;
		AP_REGNO=ap_regno;
		AP_RECVDATE=ap_recvdate;
		CU_NAME=cu_name;
		CUTYPE_CODE=cutype_code;
		CUTYPE_DESC=cutype_desc;
		BRANCHID=branchid;
		CCOBRANCH=ccobranch;
		BRANCHNAME=branchname;
		COL_KELURAHAN=col_kelurahan;
		COL_KECAMATAN=col_kecamatan;
		COL_DOK_NO=col_dok_no;
		COL_DESC=col_desc;
		COL_TYPE=col_type;
		ALT_TRDESC=alt_trdesc;
		PENDINGTRACK=pendingtrack;
		ALT_TYPEDESC=alt_typedesc;
		ALT_DESC=alt_desc;
		AP_REGNO_DESC=ap_regno_desc;
		
		CU_NPWP=cu_npwp;
		AGING=aging;
		PENDINGSTATUS=pendingstatus;
		APPRAISE_TYPE=appraise_type;
		APP_STATUS=aPP_STATUS;

}

	public String getAPP_STATUS() {
		return APP_STATUS;
	}

	public void setAPP_STATUS(String aPP_STATUS) {
		APP_STATUS = aPP_STATUS;
	}

	public String getAPPRAISE_TYPE() {
		return APPRAISE_TYPE;
	}

	public void setAPPRAISE_TYPE(String aPPRAISE_TYPE) {
		APPRAISE_TYPE = aPPRAISE_TYPE;
	}

	public String getCU_NPWP() {
		return CU_NPWP;
	}

	public void setCU_NPWP(String cU_NPWP) {
		CU_NPWP = cU_NPWP;
	}

	public String getAGING() {
		return AGING;
	}

	public void setAGING(String aGING) {
		AGING = aGING;
	}

	public String getPENDINGSTATUS() {
		return PENDINGSTATUS;
	}

	public void setPENDINGSTATUS(String pENDINGSTATUS) {
		PENDINGSTATUS = pENDINGSTATUS;
	}

	public String getALT_TYPE() {
		return ALT_TYPE;
	}

	public void setALT_TYPE(String aLT_TYPE) {
		ALT_TYPE = aLT_TYPE;
	}

	public String getALT_ID() {
		return ALT_ID;
	}

	public void setALT_ID(String aLT_ID) {
		ALT_ID = aLT_ID;
	}

	public String getALT_CURRTRCODE() {
		return ALT_CURRTRCODE;
	}

	public void setALT_CURRTRCODE(String aLT_CURRTRCODE) {
		ALT_CURRTRCODE = aLT_CURRTRCODE;
	}

	public String getALT_NEXTTRBY() {
		return ALT_NEXTTRBY;
	}

	public void setALT_NEXTTRBY(String aLT_NEXTTRBY) {
		ALT_NEXTTRBY = aLT_NEXTTRBY;
	}

	public String getALT_LASTTRCODE() {
		return ALT_LASTTRCODE;
	}

	public void setALT_LASTTRCODE(String aLT_LASTTRCODE) {
		ALT_LASTTRCODE = aLT_LASTTRCODE;
	}

	public String getAP_REGNO() {
		return AP_REGNO;
	}

	public void setAP_REGNO(String aP_REGNO) {
		AP_REGNO = aP_REGNO;
	}

	public Date getAP_RECVDATE() {
		return AP_RECVDATE;
	}

	public void setAP_RECVDATE(Date aP_RECVDATE) {
		AP_RECVDATE = aP_RECVDATE;
	}

	public String getCU_NAME() {
		return CU_NAME;
	}

	public void setCU_NAME(String cU_NAME) {
		CU_NAME = cU_NAME;
	}

	public String getCUTYPE_CODE() {
		return CUTYPE_CODE;
	}

	public void setCUTYPE_CODE(String cUTYPE_CODE) {
		CUTYPE_CODE = cUTYPE_CODE;
	}

	public String getCUTYPE_DESC() {
		return CUTYPE_DESC;
	}

	public void setCUTYPE_DESC(String cUTYPE_DESC) {
		CUTYPE_DESC = cUTYPE_DESC;
	}

	public String getBRANCHID() {
		return BRANCHID;
	}

	public void setBRANCHID(String bRANCHID) {
		BRANCHID = bRANCHID;
	}

	public String getCCOBRANCH() {
		return CCOBRANCH;
	}

	public void setCCOBRANCH(String cCOBRANCH) {
		CCOBRANCH = cCOBRANCH;
	}

	public String getBRANCHNAME() {
		return BRANCHNAME;
	}

	public void setBRANCHNAME(String bRANCHNAME) {
		BRANCHNAME = bRANCHNAME;
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

	public String getCOL_DOK_NO() {
		return COL_DOK_NO;
	}

	public void setCOL_DOK_NO(String cOL_DOK_NO) {
		COL_DOK_NO = cOL_DOK_NO;
	}

	public String getCOL_DESC() {
		return COL_DESC;
	}

	public void setCOL_DESC(String cOL_DESC) {
		COL_DESC = cOL_DESC;
	}

	public String getCOL_TYPE() {
		return COL_TYPE;
	}

	public void setCOL_TYPE(String cOL_TYPE) {
		COL_TYPE = cOL_TYPE;
	}

	public String getALT_TRDESC() {
		return ALT_TRDESC;
	}

	public void setALT_TRDESC(String aLT_TRDESC) {
		ALT_TRDESC = aLT_TRDESC;
	}

	public String getPENDINGTRACK() {
		return PENDINGTRACK;
	}

	public void setPENDINGTRACK(String pENDINGTRACK) {
		PENDINGTRACK = pENDINGTRACK;
	}

	public String getALT_TYPEDESC() {
		return ALT_TYPEDESC;
	}

	public void setALT_TYPEDESC(String aLT_TYPEDESC) {
		ALT_TYPEDESC = aLT_TYPEDESC;
	}

	public String getALT_DESC() {
		return ALT_DESC;
	}

	public void setALT_DESC(String aLT_DESC) {
		ALT_DESC = aLT_DESC;
	}

	public String getAP_REGNO_DESC() {
		return AP_REGNO_DESC;
	}

	public void setAP_REGNO_DESC(String aP_REGNO_DESC) {
		AP_REGNO_DESC = aP_REGNO_DESC;
	}


	
}
