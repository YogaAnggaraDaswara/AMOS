package com.mobile.database.app.entities;

import java.util.Date;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="APPR_INBOXS")
public class APPR_INBOXS {
	@DatabaseField(id=true,unique=true,canBeNull=false,uniqueIndexName="APPR_INBOXS_PK",dataType=DataType.STRING) private String ALT_ID;
	@DatabaseField(dataType=DataType.STRING,width=20) private String ALT_TYPE;
	@DatabaseField(dataType=DataType.STRING,width=40) private String AP_REGNO;
	@DatabaseField(dataType=DataType.STRING,width=10) private String ALT_CURRTRCODE;
	@DatabaseField(dataType=DataType.STRING,width=30) private String ALT_NEXTTRBY;
	@DatabaseField(dataType=DataType.STRING,width=10) private String ALT_LASTTRCODE;
	@DatabaseField(dataType=DataType.STRING,width=8) private String AP_RECVDATE;
	@DatabaseField(dataType=DataType.STRING,width=100) private String CU_NAME;
	@DatabaseField(dataType=DataType.STRING,width=10) private String CUTYPE_CODE;
	@DatabaseField(dataType=DataType.STRING,width=100) private String CUTYPE_DESC;
	@DatabaseField(dataType=DataType.STRING,width=10) private String BRANCHID;
	@DatabaseField(dataType=DataType.STRING,width=10) private String CCOBRANCH;
	@DatabaseField(dataType=DataType.STRING,width=150) private String BRANCHNAME;
	@DatabaseField(dataType=DataType.STRING,width=50) private String COL_KELURAHAN;
	@DatabaseField(dataType=DataType.STRING,width=50) private String COL_KECAMATAN;
	@DatabaseField(dataType=DataType.STRING,width=50) private String COL_DOK_NO;
	@DatabaseField(dataType=DataType.STRING,width=100) private String COL_DESC;
	@DatabaseField(dataType=DataType.STRING,width=10) private String COL_TYPE;
	@DatabaseField(dataType=DataType.STRING,width=50) private String ALT_TRDESC;
	@DatabaseField(dataType=DataType.STRING,width=1) private String PENDINGTRACK;
	@DatabaseField(dataType=DataType.STRING,width=100) private String ALT_TYPEDESC;
	@DatabaseField(dataType=DataType.STRING,width=101) private String ALT_DESC;
	@DatabaseField(dataType=DataType.STRING,width=102) private String AP_REGNO_DESC;
	@DatabaseField(dataType=DataType.STRING,width=102) private String CU_NPWP;
	@DatabaseField(dataType=DataType.STRING,width=102) private String AGING;
	@DatabaseField(dataType=DataType.STRING,width=102) private String PENDINGSTATUS;
	@DatabaseField(dataType=DataType.STRING,width=102) private String APPRAISE_TYPE;
	@DatabaseField(dataType=DataType.STRING,width=100) private String APP_STATUS;

	
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
	public String getPENDINGSTATUS() {
		return PENDINGSTATUS;
	}
	public void setPENDINGSTATUS(String pENDINGSTATUS) {
		PENDINGSTATUS = pENDINGSTATUS;
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
	public void setAP_RECVDATE(String aP_RECVDATE) {
		AP_RECVDATE = aP_RECVDATE;
	}
	public String getAP_REGNO() {
		return AP_REGNO;
	}
	public void setAP_REGNO(String aP_REGNO) {
		AP_REGNO = aP_REGNO;
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
	public Date getAP_RECVDATE() {
		return DataConverter.stringToDate(AP_RECVDATE);
	}
	public void setAP_RECVDATE(Date aP_RECVDATE) {
		AP_RECVDATE = DataConverter.dateToString(aP_RECVDATE);
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
