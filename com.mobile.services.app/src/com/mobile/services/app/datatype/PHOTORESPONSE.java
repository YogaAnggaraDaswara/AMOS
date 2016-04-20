package com.mobile.services.app.datatype;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class PHOTORESPONSE {
	private String FILENAME;
	private String CONTENT;
	private String STATUS;
	private String PROSPEKID;
	
	public String getFILENAME() {
		return FILENAME;
	}
	public void setFILENAME(String fILENAME) {
		FILENAME = fILENAME;
	}
	public String getCONTENT() {
		return CONTENT;
	}
	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getPROSPEKID() {
		return PROSPEKID;
	}
	public void setPROSPEKID(String pROSPEKID) {
		PROSPEKID = pROSPEKID;
	}
	public ArrayList<PHOTORESPONSE> updateGetPhotoFromJSON(JSONObject obj) throws Exception{
		JSONArray objArray= new JSONArray(obj.getString("RESULTS"));
		ArrayList<PHOTORESPONSE> arrPhoto= new ArrayList<PHOTORESPONSE>();
		
		for (int i=0;i<objArray.length();i++){
			JSONObject object=objArray.getJSONObject(i);
			PHOTORESPONSE photoresponse=new PHOTORESPONSE();
			photoresponse.setFILENAME(object.getString("FILENAME"));
			photoresponse.setCONTENT(object.getString("CONTENT"));		
			arrPhoto.add(photoresponse);
		}
		
		return arrPhoto;
	}
	
	public void updateUploadPhoto(JSONObject obj) throws Exception{
		JSONObject objPhoto= new JSONObject(obj.getString("RESULTS"));
		String STATUS = obj.getString("STATUS");
		if (objPhoto != null){
			this.setFILENAME(objPhoto.getString("FILENAME"));
			this.setPROSPEKID(objPhoto.getString("PROSPEKID"));
			this.setSTATUS(STATUS);	
		}
		
	}
	/*public  void updateUploadPhotoNew(JSONObject obj) throws Exception{
		JSONArray objArray= new JSONArray(obj.getString("result"));
			
		JSONObject objPhoto= new JSONObject(objArray.getString("RESULTS"));
		String STATUS = obj.getString("STATUS");
		if (objPhoto != null){
			this.setFILENAME(objPhoto.getString("FILENAME"));
			this.setPROSPEKID(objPhoto.getString("PROSPEKID"));
			this.setSTATUS(STATUS);	
		}
	}*/
	public ArrayList<PHOTORESPONSE> updateDeletePhotoFromJSON(String result) throws Exception{
		JSONArray objArray= new JSONArray(result);
		ArrayList<PHOTORESPONSE> arrPhoto= new ArrayList<PHOTORESPONSE>();
		
		for (int i=0;i<objArray.length();i++){
			JSONObject object=objArray.getJSONObject(i);
			PHOTORESPONSE photoresponse=new PHOTORESPONSE();
			photoresponse.setFILENAME(object.getString("FILENAME"));
			photoresponse.setPROSPEKID(object.getString("PROSPEKID"));		
			arrPhoto.add(photoresponse);
		}
		
		return arrPhoto;	
	}
}
