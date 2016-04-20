package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;
import com.mobile.database.app.entities.GEOLOCATION;

public class GeoLocationData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5576681850970635145L;
	private String ID;
    private String LATITUDE;
    private String LONGITUDE;
    private Date DATE;
    private String IMEI;
    
    public GeoLocationData(){
    	
    }
    
    public GeoLocationData(GEOLOCATION geolocation) {
		update(geolocation);
	}
    
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
    
	public Date getDATE() {
		return DATE;
	}
	public void setDATE(Date dATE) {
		DATE = dATE;
	}

	public String getIMEI() {
		return IMEI;
	}

	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}

	public GEOLOCATION toRowData(){
		GEOLOCATION rowData= new GEOLOCATION();
		rowData.setID(ID);
		rowData.setLATITUDE(LATITUDE);
		rowData.setLONGITUDE(LONGITUDE);
		rowData.setDATE(DATE);
		rowData.setIMEI(IMEI);
		
		return rowData;
	}
	
	public void update(GEOLOCATION rowData) {
		ID = rowData.getID();
		LATITUDE = rowData.getLATITUDE();
		LONGITUDE = rowData.getLONGITUDE();
		DATE = rowData.getDATE();
		IMEI = rowData.getIMEI();
	}
	
	public void update(String latitude,String longitude,Date date,String imei){
		LATITUDE = latitude;
		LONGITUDE = longitude;
		DATE = date;
		IMEI = imei;
	}
}
