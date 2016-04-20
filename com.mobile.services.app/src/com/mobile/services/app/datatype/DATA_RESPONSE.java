package com.mobile.services.app.datatype;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.mobile.bo.app.datatype.Datatype_Appr_History_Workflow;
import com.mobile.bo.app.datatype.ProspekData;

public class DATA_RESPONSE {
	private String ID;
	private String COL_ID;
	private String STATUS;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getCOL_ID() {
		return COL_ID;
	}
	public void setCOL_ID(String cOL_ID) {
		COL_ID = cOL_ID;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}

	public ArrayList<DATA_RESPONSE> updateFromJSONList(JSONObject obj) throws Exception{
		JSONArray objArray= new JSONArray(obj.getString("result"));
			
		ArrayList<DATA_RESPONSE> arrDataRequest= new ArrayList<DATA_RESPONSE>();
		
		for (int i=0;i<objArray.length();i++){
			JSONObject object=objArray.getJSONObject(i);
			DATA_RESPONSE dataresponse=new DATA_RESPONSE();
			dataresponse.setID(object.getString("ID"));
//			dataresponse.setCOL_ID(object.getString("COL_ID"));
			dataresponse.setSTATUS(object.getString("STATUS"));
			
			arrDataRequest.add(dataresponse);
		}
		
		return arrDataRequest;
	}
	public DATA_RESPONSE updateFromJSON(JSONObject obj) throws Exception{
		JSONArray objArray= new JSONArray(obj.getString("result"));
			
		
			JSONObject object=objArray.getJSONObject(0);
			DATA_RESPONSE dataresponse=new DATA_RESPONSE();
			dataresponse.setID(object.getString("ID"));
//			dataresponse.setCOL_ID(object.getString("COL_ID"));
			dataresponse.setSTATUS(object.getString("STATUS"));
			
			
		return dataresponse;
	}
	
public DATA_RESPONSE updateFromJSONR(JSONObject obj) throws Exception{
		
	JSONObject objPhoto= new JSONObject(obj.getString("result"));

	DATA_RESPONSE dataresponse=new DATA_RESPONSE();
	dataresponse.setID(objPhoto.getString("ID"));
//	dataresponse.setCOL_ID(object.getString("COL_ID"));
	dataresponse.setSTATUS(objPhoto.getString("STATUS"));
	
	return dataresponse;
	}
	
}
