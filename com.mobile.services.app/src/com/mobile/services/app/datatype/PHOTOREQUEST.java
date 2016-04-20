package com.mobile.services.app.datatype;

import java.util.ArrayList;
import com.google.gson.Gson;

public class PHOTOREQUEST {
	public String PROSPEKID;
	public String FILENAME;
	
	public String getPROSPEKID() {
		return PROSPEKID;
	}
	public void setPROSPEKID(String pROSPEKID) {
		PROSPEKID = pROSPEKID;
	}
	public String getFILENAME() {
		return FILENAME;
	}
	public void setFILENAME(String fILENAME) {
		FILENAME = fILENAME;
	}
	
	public String toJSONString(String prospekid,String filename) throws Exception {   
		ArrayList<PHOTOREQUEST> arrPhoto = new ArrayList<PHOTOREQUEST>();
		Gson gsonPhoto=new Gson();
		PHOTOREQUEST _photo=new PHOTOREQUEST();
		_photo.setPROSPEKID(prospekid);
		_photo.setFILENAME(filename);
		arrPhoto.add(_photo);
		
		return gsonPhoto.toJson(arrPhoto);
	}
}
