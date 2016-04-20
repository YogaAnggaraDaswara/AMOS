package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

import com.mobile.database.app.entities.NEWS;
import com.mobile.framework.common.DateFormatter;

public class NewsData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8474174690453720919L;
	private String ID;
	private String FROM;
    private String SUBJECT;
    private String MESSAGE;
    private Date DATE;
    private String ISREAD;

    public NewsData(String id,String from,String subject,String message,Date date,String isRead){
    	ID = id;
    	FROM=from;
		SUBJECT=subject;
		MESSAGE=message;
		DATE=date;
		ISREAD = isRead;
	}
    public NewsData( ) {
    
   	}
    
    public NewsData(NEWS news) {
    	update(news);
   	}
    public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getFROM() {
		return FROM;
	}
	public void setFROM(String fROM) {
		FROM = fROM;
	}
	public String getSUBJECT() {
		return SUBJECT;
	}
	public void setSUBJECT(String sUBJECT) {
		SUBJECT = sUBJECT;
	}
	public String getMESSAGE() {
		return MESSAGE;
	}
	public void setMESSAGE(String mESSAGE) {
		MESSAGE = mESSAGE;
	}
	public Date getDATE() {
		return DATE;
	}
	public void setDATE(Date dATE) {
		DATE = dATE;
	}
	public String getISREAD() {
		return ISREAD;
	}
	public void setISREAD(String iSREAD) {
		ISREAD = iSREAD;
	}
	public NEWS toRowData(){
		NEWS rowData= new NEWS();
		
		rowData.setID(ID);
		rowData.setFROM(FROM);
		rowData.setSUBJECT(SUBJECT);
		rowData.setMESSAGE(MESSAGE);
		rowData.setDATE(DATE);
		rowData.setISREAD(ISREAD);

		return rowData;
	}
	
	public void update(NEWS rowData) {
		ID = rowData.getID();
		FROM = rowData.getFROM();
		SUBJECT = rowData.getSUBJECT();
		MESSAGE = rowData.getMESSAGE();
		DATE=rowData.getDATE();
		ISREAD = rowData.getISREAD();
	}
	
	public void update(String id,String from,String subject,String message,Date date,String isRead){
		ID=id;
		FROM=from;
		SUBJECT=subject;
		MESSAGE=message;
		DATE=date;
		ISREAD = isRead;
	}
	
	public void updateNewsFromJSON(JSONObject obj) throws Exception{
		ID = obj.getString("ID");
		FROM = obj.getString("FROM");
		SUBJECT = obj.getString("SUBJECT");
		MESSAGE = obj.getString("MESSAGE");
		DATE = DateFormatter.formatDate(obj.getString("DATE"));
	}
}
