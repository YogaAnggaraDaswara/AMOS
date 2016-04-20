package com.mobile.database.app.entities;

import java.util.Date;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="AMOS_DOCUMENT_UPLOAD")
public class AMOS_DOCUMENT_UPLOAD {
	@DatabaseField(id=true,unique=true,canBeNull=false,uniqueIndexName="APPR_DOKUMENT_PK",dataType=DataType.STRING) private String ID; // h
	@DatabaseField(dataType=DataType.STRING,width=20) private String AP_REGNO;
	@DatabaseField(dataType=DataType.STRING,width=4) private String SEQ;
	@DatabaseField(dataType=DataType.STRING,width=20) private String USERID;
	@DatabaseField(dataType=DataType.STRING,width=50) private String DOC_CODE;
	@DatabaseField(dataType=DataType.STRING,width=20) private String DOC_NO;
	@DatabaseField(dataType=DataType.STRING,width=5) private String DOC_ORIG;
	@DatabaseField(dataType=DataType.STRING,width=5) private String DOC_AVAIL;
	@DatabaseField(dataType=DataType.STRING,width=5) private String DOC_VALID;
	@DatabaseField(dataType=DataType.STRING,width=10) private String DOC_RECVDATE;
	@DatabaseField(dataType=DataType.STRING,width=100) private String DOC_FILE_PATH;
	@DatabaseField(dataType=DataType.STRING,width=100) private String DOC_DESC;
	@DatabaseField(dataType=DataType.STRING,width=558) private String ISALREADYSUBMIT; //new
	
	public String getDOC_DESC() {
		return DOC_DESC;
	}
	public void setDOC_DESC(String dOC_DESC) {
		DOC_DESC = dOC_DESC;
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
	
	public String getSEQ() {
		return SEQ;
	}
	public void setSEQ(String sEQ) {
		SEQ = sEQ;
	}
	
	public String getUSERID() {
		return USERID;
	}
	public void setUSERID(String uSERID) {
		USERID = uSERID;
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
	
	public String getDOC_ORIG() {
		return DOC_ORIG;
	}
	public void setDOC_ORIG(String dOC_ORIG) {
		DOC_ORIG = dOC_ORIG;
	}
	
	public String getDOC_AVAIL() {
		return DOC_AVAIL;
	}
	public void setDOC_AVAIL(String dOC_AVAIL) {
		DOC_AVAIL = dOC_AVAIL;
	}
	
	public String getDOC_VALID() {
		return DOC_VALID;
	}
	public void setDOC_VALID(String dOC_VALID) {
		DOC_VALID = dOC_VALID;
	}
	
	public Date getDOC_RECVDATE() {
		return DataConverter.stringToDate(DOC_RECVDATE);
	}
	public void setDOC_RECVDATE(Date dOC_RECVDATE) {
		DOC_RECVDATE = DataConverter.dateToString(dOC_RECVDATE);
	}
	
	public String getDOC_FILE_PATH() {
		return DOC_FILE_PATH;
	}
	public void setDOC_FILE_PATH(String dOC_FILE_PATH) {
		DOC_FILE_PATH = dOC_FILE_PATH;
	}
	
	public String getISALREADYSUBMIT() {
		return ISALREADYSUBMIT;
	}
	public void setISALREADYSUBMIT(String iSALREADYSUBMIT) {
		ISALREADYSUBMIT = iSALREADYSUBMIT;
	}
	
}
