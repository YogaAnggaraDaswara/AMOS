package com.mobile.services.app.datatype;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.mobile.bo.app.datatype.Datatype_Appr_History_Workflow;
import com.mobile.bo.app.datatype.ProspekData;

public class DATA_RESPONSE_SCORE {
	private String ID;
	private String COL_ID;
	private String STATUS;
	private String SCORE;
	
	
	public String getSCORE() {
		return SCORE;
	}
	public void setSCORE(String sCORE) {
		SCORE = sCORE;
	}
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

	public ArrayList<DATA_RESPONSE_SCORE> updateFromJSONList(JSONObject obj) throws Exception{
		JSONArray objArray= new JSONArray(obj.getString("result"));
			
		ArrayList<DATA_RESPONSE_SCORE> arrDataRequest= new ArrayList<DATA_RESPONSE_SCORE>();
		
		for (int i=0;i<objArray.length();i++){
			JSONObject object=objArray.getJSONObject(i);
			DATA_RESPONSE_SCORE dataresponse=new DATA_RESPONSE_SCORE();
			dataresponse.setID(object.getString("ID"));
			dataresponse.setSCORE(object.getString("SCORE"));
			dataresponse.setSTATUS(object.getString("STATUS"));
			dataresponse.setCOL_ID(object.getString("COL_ID"));
			
			arrDataRequest.add(dataresponse);
		}
		
		return arrDataRequest;
	}
	public DATA_RESPONSE_SCORE updateFromJSON(JSONObject obj) throws Exception{
		JSONArray objArray= new JSONArray(obj.getString("RESULTS"));
			
		
			JSONObject object=objArray.getJSONObject(0);
			DATA_RESPONSE_SCORE dataresponse=new DATA_RESPONSE_SCORE();
			dataresponse.setID(object.getString("ID"));
			dataresponse.setSCORE(object.getString("SCORE"));
			dataresponse.setSTATUS(object.getString("STATUS"));
			
			
		return dataresponse;
	}
	
}
