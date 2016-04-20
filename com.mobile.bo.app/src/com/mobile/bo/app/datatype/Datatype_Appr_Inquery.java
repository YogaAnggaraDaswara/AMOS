package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

import com.mobile.database.app.common.DataConverter;
import com.mobile.database.app.entities.APPR_COLLATERAL;
import com.mobile.database.app.entities.APPR_DOKUMENT;
import com.mobile.database.app.entities.APPR_HISTORY;
import com.mobile.database.app.entities.APPR_INBOXS_QUERY;
import com.mobile.database.app.entities.APPR_MAIN;
import com.mobile.database.app.entities.APPR_MCH_VALUATION_INT;
import com.mobile.database.app.entities.APPR_PB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_RTB_CEK_TATA_KOTA_INT;
import com.mobile.database.app.entities.APPR_RTB_IMB_INT;
import com.mobile.database.app.entities.APPR_RTB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_VHC_VALUATION_INT;
import com.mobile.database.app.entities.BLACKBOX;

public class Datatype_Appr_Inquery implements Serializable {

	/**
	 * 
	 */
	public String AP_REGNO;
	public String AP_REGNO_DESC;
	public String CU_NAME;
	public String CU_TYPE;
	public Date AP_RECVDATE;
	public String CU_NPWP;
	public String ALT_CURRTRDATE;
	public String AGING;
	public String BRANCHID;
	public String CCOBRANCH;
	public String BRANCHNAME;
	public String CCOBRANCH2;
	public String COL_ADDR1;
	public String COL_KELURAHAN;
	public String COL_KECAMATAN;
	public String COL_DOK_NO;
	public String ALT_TYPE;
	public String ALT_TYPEDESC;
	public String ALT_ID;
	public String ALT_CURRTRCODE;
	public String ALT_NEXTTRBY;
	public String SU_FULLNAME;
	public String ALT_DESC;
	public String COL_TYPE;
	public String ALT_TRDESC;
	public String APPRSTYPE;
	public String TAB_TYPE;
	public String URL_DETAIL_PLUS;
	public String RECIEVE_UNRECEIVE;
	public String DOCUMENT_LENGKAP;
	public String PENDINGTRACK;
	public String PENDINGSTATUS;
	public String APPRAISE_TYPE;





	 public void updateMainFromJSON(JSONObject obj) throws Exception{
		 AP_REGNO=obj.getString("AP_REGNO");
		 AP_REGNO_DESC=obj.getString("AP_REGNO_DESC");
		 CU_NAME=obj.getString("CU_NAME");
		 CU_TYPE=obj.getString("CU_TYPE");
		 AP_RECVDATE=DataConverter.stringToDate(obj.getString("AP_RECVDATE"));
		 CU_NPWP=obj.getString("CU_NPWP");
		 ALT_CURRTRDATE=obj.getString("ALT_CURRTRDATE");
		 AGING=obj.getString("AGING");
		 BRANCHID=obj.getString("BRANCHID");
		 CCOBRANCH=obj.getString("CCOBRANCH");
		 BRANCHNAME=obj.getString("BRANCHNAME");
		 CCOBRANCH2=obj.getString("CCOBRANCH2");
		 COL_ADDR1=obj.getString("COL_ADDR1");
		 COL_KELURAHAN=obj.getString("COL_KELURAHAN");
		 COL_KECAMATAN=obj.getString("COL_KECAMATAN");
		 COL_DOK_NO=obj.getString("COL_DOK_NO");
		 ALT_TYPE=obj.getString("ALT_TYPE");
		 ALT_TYPEDESC=obj.getString("ALT_TYPEDESC");
		 ALT_ID=obj.getString("ALT_ID");
		 ALT_CURRTRCODE=obj.getString("ALT_CURRTRCODE");
		 ALT_NEXTTRBY=obj.getString("ALT_NEXTTRBY");
		 SU_FULLNAME=obj.getString("SU_FULLNAME");
		 ALT_DESC=obj.getString("ALT_DESC");
		 COL_TYPE=obj.getString("COL_TYPE");
		 ALT_TRDESC=obj.getString("ALT_TRDESC");
		 APPRSTYPE=obj.getString("APPRSTYPE");
		 TAB_TYPE=obj.getString("TAB_TYPE");
		 URL_DETAIL_PLUS=obj.getString("URL_DETAIL_PLUS");
		 RECIEVE_UNRECEIVE=obj.getString("RECIEVE_UNRECEIVE");
		 DOCUMENT_LENGKAP=obj.getString("DOCUMENT_LENGKAP");
		 PENDINGTRACK=obj.getString("PENDINGTRACK");
		 PENDINGSTATUS=obj.getString("PENDINGSTATUS");
		 APPRAISE_TYPE=obj.getString("APPRAISE_TYPE");




	 }
    
	 public Datatype_Appr_Inquery() {
	    	update("",
	    			"",
	    			"",
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
	    			"","");
		}
	    
	 public Datatype_Appr_Inquery(APPR_INBOXS_QUERY Data) {
			update(Data);
	}
		

	public APPR_INBOXS_QUERY toRowData(){
		APPR_INBOXS_QUERY rowData= new APPR_INBOXS_QUERY();
		rowData.setAP_REGNO(AP_REGNO);
		rowData.setAP_REGNO_DESC(AP_REGNO_DESC);
		rowData.setCU_NAME(CU_NAME);
		rowData.setCU_TYPE(CU_TYPE);
		rowData.setAP_RECVDATE(AP_RECVDATE);
		rowData.setCU_NPWP(CU_NPWP);
		rowData.setALT_CURRTRDATE(ALT_CURRTRDATE);
		rowData.setAGING(AGING);
		rowData.setBRANCHID(BRANCHID);
		rowData.setCCOBRANCH(CCOBRANCH);
		rowData.setBRANCHNAME(BRANCHNAME);
		rowData.setCCOBRANCH2(CCOBRANCH2);
		rowData.setCOL_ADDR1(COL_ADDR1);
		rowData.setCOL_KELURAHAN(COL_KELURAHAN);
		rowData.setCOL_KECAMATAN(COL_KECAMATAN);
		rowData.setCOL_DOK_NO(COL_DOK_NO);
		rowData.setALT_TYPE(ALT_TYPE);
		rowData.setALT_TYPEDESC(ALT_TYPEDESC);
		rowData.setALT_ID(ALT_ID);
		rowData.setALT_CURRTRCODE(ALT_CURRTRCODE);
		rowData.setALT_NEXTTRBY(ALT_NEXTTRBY);
		rowData.setSU_FULLNAME(SU_FULLNAME);
		rowData.setALT_DESC(ALT_DESC);
		rowData.setCOL_TYPE(COL_TYPE);
		rowData.setALT_TRDESC(ALT_TRDESC);
		rowData.setAPPRSTYPE(APPRSTYPE);
		rowData.setTAB_TYPE(TAB_TYPE);
		rowData.setURL_DETAIL_PLUS(URL_DETAIL_PLUS);
		rowData.setRECIEVE_UNRECEIVE(RECIEVE_UNRECEIVE);
		rowData.setDOCUMENT_LENGKAP(DOCUMENT_LENGKAP);
		rowData.setPENDINGTRACK(PENDINGTRACK);
		rowData.setPENDINGSTATUS(PENDINGSTATUS);
		rowData.setPENDINGSTATUS(APPRAISE_TYPE);
		


	
		return rowData;
	}
	
	public void update(APPR_INBOXS_QUERY rowData) {
		AP_REGNO=rowData.getAP_REGNO();
		AP_REGNO_DESC=rowData.getAP_REGNO_DESC();
		CU_NAME=rowData.getCU_NAME();
		CU_TYPE=rowData.getCU_TYPE();
		AP_RECVDATE=rowData.getAP_RECVDATE();
		CU_NPWP=rowData.getCU_NPWP();
		ALT_CURRTRDATE=rowData.getALT_CURRTRDATE();
		AGING=rowData.getAGING();
		BRANCHID=rowData.getBRANCHID();
		CCOBRANCH=rowData.getCCOBRANCH();
		BRANCHNAME=rowData.getBRANCHNAME();
		CCOBRANCH2=rowData.getCCOBRANCH2();
		COL_ADDR1=rowData.getCOL_ADDR1();
		COL_KELURAHAN=rowData.getCOL_KELURAHAN();
		COL_KECAMATAN=rowData.getCOL_KECAMATAN();
		COL_DOK_NO=rowData.getCOL_DOK_NO();
		ALT_TYPE=rowData.getALT_TYPE();
		ALT_TYPEDESC=rowData.getALT_TYPEDESC();
		ALT_ID=rowData.getALT_ID();
		ALT_CURRTRCODE=rowData.getALT_CURRTRCODE();
		ALT_NEXTTRBY=rowData.getALT_NEXTTRBY();
		SU_FULLNAME=rowData.getSU_FULLNAME();
		ALT_DESC=rowData.getALT_DESC();
		COL_TYPE=rowData.getCOL_TYPE();
		ALT_TRDESC=rowData.getALT_TRDESC();
		APPRSTYPE=rowData.getAPPRSTYPE();
		TAB_TYPE=rowData.getTAB_TYPE();
		URL_DETAIL_PLUS=rowData.getURL_DETAIL_PLUS();
		RECIEVE_UNRECEIVE=rowData.getRECIEVE_UNRECEIVE();
		DOCUMENT_LENGKAP=rowData.getDOCUMENT_LENGKAP();
		PENDINGTRACK=rowData.getPENDINGTRACK();
		PENDINGSTATUS=rowData.getPENDINGSTATUS();
		APPRAISE_TYPE=rowData.getAPPRAISE_TYPE();
		

	}
	
	public void update(String ap_regno,
			String ap_regno_desc,
			String cu_name,
			String cu_type,
			Date ap_recvdate,
			String cu_npwp,
			String alt_currtrdate,
			String aging,
			String branchid,
			String ccobranch,
			String branchname,
			String ccobranch2,
			String col_addr1,
			String col_kelurahan,
			String col_kecamatan,
			String col_dok_no,
			String alt_type,
			String alt_typedesc,
			String alt_id,
			String alt_currtrcode,
			String alt_nexttrby,
			String su_fullname,
			String alt_desc,
			String col_type,
			String alt_trdesc,
			String apprstype,
			String tab_type,
			String url_detail_plus,
			String recieve_unreceive,
			String document_lengkap,
			String pendingtrack,
			String pendingstatus,String aPPRAISE_TYPE){
		AP_REGNO=ap_regno;
		AP_REGNO_DESC=ap_regno_desc;
		CU_NAME=cu_name;
		CU_TYPE=cu_type;
		AP_RECVDATE=ap_recvdate;
		CU_NPWP=cu_npwp;
		ALT_CURRTRDATE=alt_currtrdate;
		AGING=aging;
		BRANCHID=branchid;
		CCOBRANCH=ccobranch;
		BRANCHNAME=branchname;
		CCOBRANCH2=ccobranch2;
		COL_ADDR1=col_addr1;
		COL_KELURAHAN=col_kelurahan;
		COL_KECAMATAN=col_kecamatan;
		COL_DOK_NO=col_dok_no;
		ALT_TYPE=alt_type;
		ALT_TYPEDESC=alt_typedesc;
		ALT_ID=alt_id;
		ALT_CURRTRCODE=alt_currtrcode;
		ALT_NEXTTRBY=alt_nexttrby;
		SU_FULLNAME=su_fullname;
		ALT_DESC=alt_desc;
		COL_TYPE=col_type;
		ALT_TRDESC=alt_trdesc;
		APPRSTYPE=apprstype;
		TAB_TYPE=tab_type;
		URL_DETAIL_PLUS=url_detail_plus;
		RECIEVE_UNRECEIVE=recieve_unreceive;
		DOCUMENT_LENGKAP=document_lengkap;
		PENDINGTRACK=pendingtrack;
		PENDINGSTATUS=pendingstatus;
		APPRAISE_TYPE=aPPRAISE_TYPE;


}

	public String getAP_REGNO() {
		return AP_REGNO;
	}

	public String getAPPRAISE_TYPE() {
		return APPRAISE_TYPE;
	}

	public void setAPPRAISE_TYPE(String aPPRAISE_TYPE) {
		APPRAISE_TYPE = aPPRAISE_TYPE;
	}

	public void setAP_REGNO(String aP_REGNO) {
		AP_REGNO = aP_REGNO;
	}

	public String getAP_REGNO_DESC() {
		return AP_REGNO_DESC;
	}

	public void setAP_REGNO_DESC(String aP_REGNO_DESC) {
		AP_REGNO_DESC = aP_REGNO_DESC;
	}

	public String getCU_NAME() {
		return CU_NAME;
	}

	public void setCU_NAME(String cU_NAME) {
		CU_NAME = cU_NAME;
	}

	public String getCU_TYPE() {
		return CU_TYPE;
	}

	public void setCU_TYPE(String cU_TYPE) {
		CU_TYPE = cU_TYPE;
	}

	public Date getAP_RECVDATE() {
		return AP_RECVDATE;
	}

	public void setAP_RECVDATE(Date aP_RECVDATE) {
		AP_RECVDATE = aP_RECVDATE;
	}

	public String getCU_NPWP() {
		return CU_NPWP;
	}

	public void setCU_NPWP(String cU_NPWP) {
		CU_NPWP = cU_NPWP;
	}

	public String getALT_CURRTRDATE() {
		return ALT_CURRTRDATE;
	}

	public void setALT_CURRTRDATE(String aLT_CURRTRDATE) {
		ALT_CURRTRDATE = aLT_CURRTRDATE;
	}

	public String getAGING() {
		return AGING;
	}

	public void setAGING(String aGING) {
		AGING = aGING;
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

	public String getCCOBRANCH2() {
		return CCOBRANCH2;
	}

	public void setCCOBRANCH2(String cCOBRANCH2) {
		CCOBRANCH2 = cCOBRANCH2;
	}

	public String getCOL_ADDR1() {
		return COL_ADDR1;
	}

	public void setCOL_ADDR1(String cOL_ADDR1) {
		COL_ADDR1 = cOL_ADDR1;
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

	public String getALT_TYPE() {
		return ALT_TYPE;
	}

	public void setALT_TYPE(String aLT_TYPE) {
		ALT_TYPE = aLT_TYPE;
	}

	public String getALT_TYPEDESC() {
		return ALT_TYPEDESC;
	}

	public void setALT_TYPEDESC(String aLT_TYPEDESC) {
		ALT_TYPEDESC = aLT_TYPEDESC;
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

	public String getSU_FULLNAME() {
		return SU_FULLNAME;
	}

	public void setSU_FULLNAME(String sU_FULLNAME) {
		SU_FULLNAME = sU_FULLNAME;
	}

	public String getALT_DESC() {
		return ALT_DESC;
	}

	public void setALT_DESC(String aLT_DESC) {
		ALT_DESC = aLT_DESC;
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

	public String getAPPRSTYPE() {
		return APPRSTYPE;
	}

	public void setAPPRSTYPE(String aPPRSTYPE) {
		APPRSTYPE = aPPRSTYPE;
	}

	public String getTAB_TYPE() {
		return TAB_TYPE;
	}

	public void setTAB_TYPE(String tAB_TYPE) {
		TAB_TYPE = tAB_TYPE;
	}

	public String getURL_DETAIL_PLUS() {
		return URL_DETAIL_PLUS;
	}

	public void setURL_DETAIL_PLUS(String uRL_DETAIL_PLUS) {
		URL_DETAIL_PLUS = uRL_DETAIL_PLUS;
	}

	public String getRECIEVE_UNRECEIVE() {
		return RECIEVE_UNRECEIVE;
	}

	public void setRECIEVE_UNRECEIVE(String rECIEVE_UNRECEIVE) {
		RECIEVE_UNRECEIVE = rECIEVE_UNRECEIVE;
	}

	public String getDOCUMENT_LENGKAP() {
		return DOCUMENT_LENGKAP;
	}

	public void setDOCUMENT_LENGKAP(String dOCUMENT_LENGKAP) {
		DOCUMENT_LENGKAP = dOCUMENT_LENGKAP;
	}

	public String getPENDINGTRACK() {
		return PENDINGTRACK;
	}

	public void setPENDINGTRACK(String pENDINGTRACK) {
		PENDINGTRACK = pENDINGTRACK;
	}

	public String getPENDINGSTATUS() {
		return PENDINGSTATUS;
	}

	public void setPENDINGSTATUS(String pENDINGSTATUS) {
		PENDINGSTATUS = pENDINGSTATUS;
	}

	
	
	
}
