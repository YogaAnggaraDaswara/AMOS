package com.mobile.services.app.datatype;

import java.util.ArrayList;
import android.os.Environment;
import com.google.gson.Gson;
import com.mobile.bo.app.datatype.PhotoData;
import com.mobile.framework.common.FileUtility;

public class UPLOADPHOTOREQUEST {
	public String ID;
	public String PROSPEKID;
	public String FILENAME;
	public String CONTENT;
	public final static String FILEPATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/PROSPEK/IMAGES/";

	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
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
	public String getCONTENT() {
		return CONTENT;
	}
	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}
	
	public String toJSONString(PhotoData photo) throws Exception {   
		ArrayList<UPLOADPHOTOREQUEST> arrPhoto = new ArrayList<UPLOADPHOTOREQUEST>();
		Gson gsonPhoto=new Gson();
		String _encodedPicture= FileUtility.encodeToStringBase64(photo.getFILENAME(),FILEPATH);
		UPLOADPHOTOREQUEST _photo=new UPLOADPHOTOREQUEST();
		_photo.setID(photo.getID().toString());
		//_photo.setPROSPEKID(photo.getPROSPEKID());
		_photo.setFILENAME(photo.getFILENAME());
		_photo.setCONTENT(_encodedPicture);
		arrPhoto.add(_photo);
		
		return gsonPhoto.toJson(arrPhoto);
	}
}
