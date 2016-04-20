package com.mobile.bo.app.datatype;

import java.io.Serializable;
import org.json.JSONObject;
import com.mobile.database.app.entities.USER;

public class UserData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9203651201902219109L;
	private String USERID;
	private String PASSWORD;
	private String NAME;
	private String POSITION;
	private String LOCATION;
	private String IMEI;
	private String UNIT;
	
	public UserData() {
		
	}
	
	public UserData(USER rowData) {
		update(rowData);
	}
	
	public String getUSERID() {
		return USERID;
	}

	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getPOSITION() {
		return POSITION;
	}

	public void setPOSITION(String pOSITION) {
		POSITION = pOSITION;
	}

	public String getLOCATION() {
		return LOCATION;
	}

	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
	}

	public String getIMEI() {
		return IMEI;
	}

	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}
	
	public String getUNIT() {
		return UNIT;
	}

	public void setUNIT(String uNIT) {
		UNIT = uNIT;
	}

	public USER toRowData() {
		USER rowData = new USER();
		
		rowData.setNAME(NAME);
		rowData.setPASSWORD(PASSWORD);
		rowData.setPOSITION(POSITION);
		rowData.setLOCATION(LOCATION);
		rowData.setUSERID(USERID);
		rowData.setUNIT(UNIT);
		
		return rowData;
	}
	
	
	public void update(USER rowData) {
		 USERID = rowData.getUSERID();
		 PASSWORD = rowData.getPASSWORD();
		 NAME = rowData.getNAME();
		 POSITION = rowData.getPOSITION();
		 LOCATION = rowData.getLOCATION();
		 UNIT = rowData.getUNIT();
	}
	
	public void updateUserFromJSON(JSONObject obj) throws Exception{
		USERID = obj.getString("USERID");
		PASSWORD = obj.getString("PASSWORD");
		NAME = obj.getString("NAME");
//		POSITION = obj.getString("POSITION");
		LOCATION = obj.getString("LOCATION");
		IMEI = obj.getString("IMEI");
		UNIT = obj.getString("UNIT");
	}
}
