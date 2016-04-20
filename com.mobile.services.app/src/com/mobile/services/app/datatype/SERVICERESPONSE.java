package com.mobile.services.app.datatype;

import java.io.Serializable;
import org.json.JSONObject;

public class SERVICERESPONSE implements Serializable{

	/**
	 * @author frans
	 */
	private static final long serialVersionUID = -5849395923250150585L;
	private String result;
	private int status;
	
	public SERVICERESPONSE(){
		
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void updateFromJSON(JSONObject obj) throws Exception{
		result = obj.getString("result");
		status = obj.getInt("status");
	}
}
