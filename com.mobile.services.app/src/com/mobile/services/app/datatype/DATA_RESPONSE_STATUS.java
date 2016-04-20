package com.mobile.services.app.datatype;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.mobile.bo.app.datatype.Datatype_Appr_History_Workflow;
import com.mobile.bo.app.datatype.ProspekData;

public class DATA_RESPONSE_STATUS {
	private String COL_ID;
	private String AP_REGNO;

	public String getCOL_ID() {
		return COL_ID;
	}
	public void setCOL_ID(String cOL_ID) {
		COL_ID = cOL_ID;
	}
	public String getAP_REGNO() {
		return AP_REGNO;
	}
	public void setAP_REGNO(String aP_REGNO) {
		AP_REGNO = aP_REGNO;
	}
	public ArrayList<DATA_RESPONSE_STATUS> updateFromJSONList(JSONObject obj) throws Exception{
		JSONArray objArray= new JSONArray(obj.getString("result"));
			
		ArrayList<DATA_RESPONSE_STATUS> arrDataRequest= new ArrayList<DATA_RESPONSE_STATUS>();
		
		for (int i=0;i<objArray.length();i++){
			JSONObject object=objArray.getJSONObject(i);
			DATA_RESPONSE_STATUS dataresponse=new DATA_RESPONSE_STATUS();
			dataresponse.setAP_REGNO(object.getString("AP_REGNO"));
			dataresponse.setCOL_ID(object.getString("COL_ID"));
			
			arrDataRequest.add(dataresponse);
		}
		
		return arrDataRequest;
	}
	public DATA_RESPONSE_STATUS updateFromJSON(JSONObject obj) throws Exception{
		JSONArray objArray= new JSONArray(obj.getString("result"));
			
		
			JSONObject object=objArray.getJSONObject(0);
			DATA_RESPONSE_STATUS dataresponse=new DATA_RESPONSE_STATUS();
			dataresponse.setAP_REGNO(object.getString("AP_REGNO"));
			
			
		return dataresponse;
	}
	
}
