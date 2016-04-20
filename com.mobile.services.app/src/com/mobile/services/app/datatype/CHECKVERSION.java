package com.mobile.services.app.datatype;

import java.util.ArrayList;

import org.json.JSONObject;

import android.R.string;
import android.os.Build.VERSION;

import com.google.gson.Gson;
import com.mobile.bo.app.datatype.ProspekData;

public class CHECKVERSION {
	public String USERID;
	public String SUCCESS;
	public String LATESTVERSION;
	public String APPURI;
	public String getSUCCESS() {
		return SUCCESS;
	}




	public void setSUCCESS(String sUCCESS) {
		SUCCESS = sUCCESS;
	}




	public String getLATESTVERSION() {
		return LATESTVERSION;
	}




	public void setLATESTVERSION(String lATESTVERSION) {
		LATESTVERSION = lATESTVERSION;
	}




	public String getAPPURI() {
		return APPURI;
	}




	public void setAPPURI(String aPPURI) {
		APPURI = aPPURI;
	}




	public String getUSERID() {
		return USERID;
	}




	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}




	public String getIMEI() {
		return IMEI;
	}




	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}




	public String IMEI;
	
	
	

	public String toJSONString(String userid,String imei) throws Exception {
		ArrayList<CHECKVERSION> arrVersion = new ArrayList<CHECKVERSION>();
		Gson gsonVersion=new Gson();
		CHECKVERSION _version=new CHECKVERSION();
		_version.setUSERID(userid);
		_version.setIMEI(imei);
		arrVersion.add(_version);
		
		return gsonVersion.toJson(arrVersion);

	}
	public void updateVersionFromJSON(JSONObject obj) throws Exception{
		LATESTVERSION = obj.getString("LATESTVERSION");
		APPURI = obj.getString("APPURI");
		
	}
}
