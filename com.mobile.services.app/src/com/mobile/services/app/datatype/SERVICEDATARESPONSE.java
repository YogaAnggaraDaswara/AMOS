package com.mobile.services.app.datatype;

import org.json.JSONObject;

public class SERVICEDATARESPONSE{

	private String results;
	private int status;
	
	public String getResults() {
		return results;
	}
	public void setResults(String results) {
		this.results = results;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public void updateFromJSON(JSONObject obj) throws Exception{
		String result = obj.getString("result");
		JSONObject object=new JSONObject(result);
		results = object.getString("RESULTS");
		status = Integer.parseInt(object.getString("STATUS"));
	}
}
