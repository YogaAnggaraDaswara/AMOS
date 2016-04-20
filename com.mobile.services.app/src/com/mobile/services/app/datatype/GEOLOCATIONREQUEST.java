package com.mobile.services.app.datatype;

import java.util.ArrayList;
import com.google.gson.Gson;
import com.mobile.bo.app.datatype.GeoLocationData;
import com.mobile.framework.common.DateFormatter;

public class GEOLOCATIONREQUEST {
	private String ID;
    private String LATITUDE;
    private String LONGITUDE;
    private String DATE;
    private String IMEI;
    
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getLATITUDE() {
		return LATITUDE;
	}
	public void setLATITUDE(String lATITUDE) {
		LATITUDE = lATITUDE;
	}
	public String getLONGITUDE() {
		return LONGITUDE;
	}
	public void setLONGITUDE(String lONGITUDE) {
		LONGITUDE = lONGITUDE;
	}
	public String getDATE() {
		return DATE;
	}
	public void setDATE(String dATE) {
		DATE = dATE;
	}
	public String getIMEI() {
		return IMEI;
	}
	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}
	public String toJSONString(ArrayList<GeoLocationData> geoLocation) throws Exception {  
		Gson gsonGeoLocation =  new Gson();
		ArrayList<GEOLOCATIONREQUEST> arrayGeoLocationRequest=new ArrayList<GEOLOCATIONREQUEST>();
		
		 for (int i=0;i<geoLocation.size();i++){
			 	GEOLOCATIONREQUEST gld=new GEOLOCATIONREQUEST();
			 	GeoLocationData geoLocationData= geoLocation.get(i);
			 	gld.setID(geoLocationData.getID().toString());
			 	gld.setLATITUDE(geoLocationData.getLATITUDE());
			 	gld.setLONGITUDE(geoLocationData.getLONGITUDE());
			 	gld.setDATE(DateFormatter.formatStringYYYYMMdd(geoLocationData.getDATE(),true));
			 	gld.setIMEI(geoLocationData.getIMEI());
			 	
			 	arrayGeoLocationRequest.add(gld);
		 }
		return gsonGeoLocation.toJson(arrayGeoLocationRequest);
	}

}
