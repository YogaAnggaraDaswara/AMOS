package com.mobile.services.app.datatype;

import java.util.ArrayList;
import java.util.Date;
import com.google.gson.Gson;
import com.mobile.framework.common.DateFormatter;

public class REQUESTBLACKBOX {
	private String ENDDATE;
	private String MILIK;
	private String STAGE;
	private String STARTDATE;
	private String STATUS;
	private String USERID;
	public String getENDDATE() {
		return ENDDATE;
	}
	public void setENDDATE(String eNDDATE) {
		ENDDATE = eNDDATE;
	}
	public String getMILIK() {
		return MILIK;
	}
	public void setMILIK(String mILIK) {
		MILIK = mILIK;
	}
	public String getSTAGE() {
		return STAGE;
	}
	public void setSTAGE(String sTAGE) {
		STAGE = sTAGE;
	}
	public String getSTARTDATE() {
		return STARTDATE;
	}
	public void setSTARTDATE(String sTARTDATE) {
		STARTDATE = sTARTDATE;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getUSERID() {
		return USERID;
	}
	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}
	
	public String JsonToString(String milik,String stage,String status,String userid,Date startdate,Date endDate){
		ArrayList<REQUESTBLACKBOX> arrReqBlackbox=new ArrayList<REQUESTBLACKBOX>();
		Gson gsonreblackbox=new Gson();

		REQUESTBLACKBOX reqblackbox=new REQUESTBLACKBOX();
		reqblackbox.setUSERID(userid);
		reqblackbox.setSTATUS(status);
		reqblackbox.setMILIK(milik);
		reqblackbox.setSTARTDATE(DateFormatter.formatStringYYYYMMdd(startdate,false));
		reqblackbox.setENDDATE(DateFormatter.formatStringYYYYMMdd(endDate,false));
		reqblackbox.setSTAGE(stage);

		arrReqBlackbox.add(reqblackbox);
		
		return gsonreblackbox.toJson(arrReqBlackbox);
	}
}
