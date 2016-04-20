package com.mobile.database.app.entities;

import java.util.Date;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="APPR_INBOXS_QUERY")
public class APPR_INBOXS_QUERY {
	@DatabaseField(id=true,unique=true,canBeNull=false,uniqueIndexName="APPR_INBOXS_QUERY_PK",dataType=DataType.STRING) private String ALT_ID ;
	@DatabaseField(dataType=DataType.STRING,width=515) private String AP_REGNO_DESC;
	@DatabaseField(dataType=DataType.STRING,width=516) private String CU_NAME;
	@DatabaseField(dataType=DataType.STRING,width=517) private String CU_TYPE;
	@DatabaseField(dataType=DataType.STRING,width=518) private String AP_RECVDATE;
	@DatabaseField(dataType=DataType.STRING,width=519) private String CU_NPWP;
	@DatabaseField(dataType=DataType.STRING,width=520) private String ALT_CURRTRDATE;
	@DatabaseField(dataType=DataType.STRING,width=521) private String AGING;
	@DatabaseField(dataType=DataType.STRING,width=522) private String BRANCHID;
	@DatabaseField(dataType=DataType.STRING,width=523) private String CCOBRANCH;
	@DatabaseField(dataType=DataType.STRING,width=524) private String BRANCHNAME;
	@DatabaseField(dataType=DataType.STRING,width=525) private String CCOBRANCH2;
	@DatabaseField(dataType=DataType.STRING,width=526) private String COL_ADDR1;
	@DatabaseField(dataType=DataType.STRING,width=527) private String COL_KELURAHAN;
	@DatabaseField(dataType=DataType.STRING,width=528) private String COL_KECAMATAN;
	@DatabaseField(dataType=DataType.STRING,width=529) private String COL_DOK_NO;
	@DatabaseField(dataType=DataType.STRING,width=530) private String ALT_TYPE;
	@DatabaseField(dataType=DataType.STRING,width=531) private String ALT_TYPEDESC;
	@DatabaseField(dataType=DataType.STRING,width=532) private String AP_REGNO;
	@DatabaseField(dataType=DataType.STRING,width=533) private String ALT_CURRTRCODE;
	@DatabaseField(dataType=DataType.STRING,width=534) private String ALT_NEXTTRBY;
	@DatabaseField(dataType=DataType.STRING,width=535) private String SU_FULLNAME;
	@DatabaseField(dataType=DataType.STRING,width=536) private String ALT_DESC;
	@DatabaseField(dataType=DataType.STRING,width=537) private String COL_TYPE;
	@DatabaseField(dataType=DataType.STRING,width=538) private String ALT_TRDESC;
	@DatabaseField(dataType=DataType.STRING,width=539) private String APPRSTYPE;
	@DatabaseField(dataType=DataType.STRING,width=540) private String TAB_TYPE;
	@DatabaseField(dataType=DataType.STRING,width=541) private String URL_DETAIL_PLUS;
	@DatabaseField(dataType=DataType.STRING,width=542) private String RECIEVE_UNRECEIVE;
	@DatabaseField(dataType=DataType.STRING,width=543) private String DOCUMENT_LENGKAP;
	@DatabaseField(dataType=DataType.STRING,width=544) private String PENDINGTRACK;
	@DatabaseField(dataType=DataType.STRING,width=545) private String PENDINGSTATUS;
	@DatabaseField(dataType=DataType.STRING,width=545) private String APPRAISE_TYPE;
	
	public String getAPPRAISE_TYPE() {
		return APPRAISE_TYPE;
	}
	public void setAPPRAISE_TYPE(String aPPRAISE_TYPE) {
		APPRAISE_TYPE = aPPRAISE_TYPE;
	}
	public String getAP_REGNO() {
		return AP_REGNO;
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
		return DataConverter.stringToDate(AP_RECVDATE);
	}
	public void setAP_RECVDATE(Date aP_RECVDATE) {
		AP_RECVDATE = DataConverter.dateToString(aP_RECVDATE);
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
