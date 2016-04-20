package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

import com.mobile.database.app.common.DataConverter;

import com.mobile.database.app.entities.AMOS_DOCUMENT_UPLOAD;

public class DataType_Amos_Document_Upload implements Serializable {
	
	/**
	 * 
	 */
	
	public String ID;
	public String AP_REGNO;
	public String SEQ;
	public String USERID;
	public String DOC_CODE;
	public String DOC_NO;
	public String DOC_ORIG;
	public String DOC_AVAIL;
	public String DOC_VALID;
	public Date DOC_RECVDATE;
	public String DOC_FILE_PATH;
	public String DOC_DESC;
	public String ISALREADYSUBMIT;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	
	public void updateMainFromJSON(JSONObject obj) throws Exception {
		ID = obj.getString("ID");
		AP_REGNO = obj.getString("AP_REGNO");
		SEQ = obj.getString("SEQ");
		USERID = obj.getString("USERID");
		DOC_CODE = obj.getString("DOC_CODE");
		DOC_NO = obj.getString("DOC_NO");
		DOC_ORIG = obj.getString("DOC_ORIG");
		DOC_AVAIL = obj.getString("DOC_AVAIL");
		DOC_VALID = obj.getString("DOC_VALID");
		DOC_RECVDATE = DataConverter.stringToDate(obj.getString("DOC_RECVDATE"));
		DOC_FILE_PATH = obj.getString("DOC_FILE_PATH");
		DOC_DESC = obj.getString("DOC_DESC");
		
	}
	
	public DataType_Amos_Document_Upload()
	{
		update("",
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
			"",
			"");
	}
	
	public DataType_Amos_Document_Upload(AMOS_DOCUMENT_UPLOAD Data) {
		update(Data);
	}
	
	public AMOS_DOCUMENT_UPLOAD toRowData(){
		AMOS_DOCUMENT_UPLOAD rowData= new AMOS_DOCUMENT_UPLOAD();
		rowData.setID(ID);
		rowData.setAP_REGNO(AP_REGNO);
		rowData.setSEQ(SEQ);
		rowData.setUSERID(USERID);
		rowData.setDOC_CODE(DOC_CODE);
		rowData.setDOC_NO(DOC_NO);
		rowData.setDOC_ORIG(DOC_ORIG);
		rowData.setDOC_AVAIL(DOC_AVAIL);
		rowData.setDOC_VALID(DOC_VALID);
		rowData.setDOC_RECVDATE(DOC_RECVDATE);
		rowData.setDOC_FILE_PATH(DOC_FILE_PATH);
		rowData.setDOC_DESC(DOC_DESC);
		rowData.setISALREADYSUBMIT(ISALREADYSUBMIT);
		return rowData;
	}
	
	public void update(AMOS_DOCUMENT_UPLOAD rowData) {
		ID = rowData.getID();
		AP_REGNO = rowData.getAP_REGNO();
		SEQ = rowData.getSEQ();
		USERID = rowData.getUSERID();
		DOC_CODE = rowData.getDOC_CODE();
		DOC_NO = rowData.getDOC_NO();
		DOC_ORIG = rowData.getDOC_ORIG();
		DOC_AVAIL = rowData.getDOC_AVAIL();
		DOC_VALID = rowData.getDOC_VALID();
		DOC_RECVDATE = rowData.getDOC_RECVDATE();
		DOC_FILE_PATH = rowData.getDOC_FILE_PATH();
		DOC_DESC = rowData.getDOC_DESC();
		ISALREADYSUBMIT = rowData.getISALREADYSUBMIT();
	}
	
	public void update(
			String id,
			String ap_regno,
			String seq,
			String userid,
			String doc_code,
			String doc_no,
			String doc_orig,
			String doc_vail,
			String dic_valid,
			Date doc_recvdate,
			String doc_file_path,
			String dOC_DESC,
			String iSALREADYSUBMIT
	) {
		ID = id;
		AP_REGNO = ap_regno;
		SEQ = seq;
		USERID = userid;
		DOC_CODE = doc_code;
		DOC_NO = doc_no;
		DOC_ORIG = doc_orig;
		DOC_AVAIL = doc_vail;
		DOC_VALID = dic_valid;
		DOC_RECVDATE = doc_recvdate;
		DOC_FILE_PATH = doc_file_path;
		DOC_DESC = dOC_DESC;
		ISALREADYSUBMIT = iSALREADYSUBMIT;
	}
	
	public String getDOC_DESC() {
		return DOC_DESC;
	}

	public void setDOC_DESC(String dOC_DESC) {
		DOC_DESC = dOC_DESC;
	}

	public String getAP_REGNO(){
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
	
	public String getDOC_CODE(){
		return DOC_CODE;
	}
	public void setDOC_CODE(String dOC_CODE) {
		DOC_CODE = dOC_CODE;
	}
	
	public String getDOC_NO(){
		return DOC_NO;
	}
	public void setDOC_NO(String dOC_NO) {
		DOC_NO = dOC_NO;
	}
	
	public String getDOC_ORIG(){
		return DOC_ORIG;
	}
	public void setDOC_ORIG(String dOC_ORIG) {
		DOC_ORIG = dOC_ORIG;
	}
	
	public String getDOC_AVAIL(){
		return DOC_AVAIL;
	}
	public void setDOC_AVAIL(String dOC_AVAIL) {
		DOC_AVAIL = dOC_AVAIL;
	}
	
	public String getDOC_VALID(){
		return DOC_VALID;
	}
	public void setDOC_VALID(String dOC_VALID) {
		DOC_VALID = dOC_VALID;
	}
	
	public Date getDOC_RECVDATE() {
		return DOC_RECVDATE;
	}
	public void setDOC_RECVDATE(Date dOC_RECVDATE) {
		DOC_RECVDATE = dOC_RECVDATE;
	}
	
	public String getDOC_FILE_PATH(){
		return DOC_FILE_PATH;
	}
	public void setDOC_FILE_PATH(String dOC_FILE_PATH) {
		DOC_FILE_PATH = dOC_FILE_PATH;
	}
	
	public String getISALREADYSUBMIT(){
		return ISALREADYSUBMIT;
	}
	public void setISALREADYSUBMIT(String iSALREADYSUBMIT) {
		ISALREADYSUBMIT = iSALREADYSUBMIT;
	}
	

}
