package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;
import com.mobile.database.app.entities.LOGINHISTORY;

public class LoginHistoryData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8481094983041700101L;
	private Integer ID;
	private String USERID;
	private String PASSWORD;
	private String STATUS;
	private String DESCRIPTION;
	private Date DATE;
    private String IMEI;

	public LoginHistoryData(){
		
	}
	public LoginHistoryData(String userid,String password,String status,String description,Date date,String imei){
		update(userid,password,status,description,date,imei);
	}
	public LoginHistoryData(LOGINHISTORY loginhistory) {
    	update(loginhistory);
   	}
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
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
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
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
	public LOGINHISTORY toRowData(){
		LOGINHISTORY rowData= new LOGINHISTORY();
		
		rowData.setID(ID);
		rowData.setUSERID(USERID);
		rowData.setPASSWORD(PASSWORD);
		rowData.setSTATUS(STATUS);
		rowData.setDECSRIPTION(DESCRIPTION);
		rowData.setDATE(DATE);
		rowData.setIMEI(IMEI);

		return rowData;
	}
	public void update(LOGINHISTORY rowData) {
		ID = rowData.getID();
		USERID = rowData.getUSERID();
		PASSWORD = rowData.getPASSWORD();
		STATUS = rowData.getSTATUS();
		DESCRIPTION = rowData.getDECSRIPTION();
		DATE = rowData.getDATE();
		IMEI = rowData.getIMEI();
	}
	
	public void update(String userid,String password,String status,String description,Date date,String imei){
		USERID = userid;
		PASSWORD = password;
		STATUS = status;
		DESCRIPTION = description;
		DATE = date;
		IMEI = imei;
	}
	
}
