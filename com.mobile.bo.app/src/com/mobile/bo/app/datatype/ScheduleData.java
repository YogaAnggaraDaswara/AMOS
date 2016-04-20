package com.mobile.bo.app.datatype;

import java.io.Serializable;
import org.json.JSONObject;
import com.mobile.database.app.entities.SCHEDULE;

public class ScheduleData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8275787611887650057L;
	private String ID;
    private String TYPE;
    private String INTERVAL;
    private String START;
    private String END;
    
    public ScheduleData(){
    	
    }
    
    public ScheduleData(String id,String type,String interval,String start,String end){
    	update( id, type, interval, start, end);
    }
    
    public ScheduleData(SCHEDULE schedule) {
		update(schedule);
	}
    
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getTYPE() {
		return TYPE;
	}
	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}
	public String getINTERVAL() {
		return INTERVAL;
	}
	public void setINTERVAL(String iNTERVAL) {
		INTERVAL = iNTERVAL;
	}
	public String getSTART() {
		return START;
	}
	public void setSTART(String sTART) {
		START = sTART;
	}
	public String getEND() {
		return END;
	}
	public void setEND(String eND) {
		END = eND;
	}
    
	public SCHEDULE toRowData(){
		SCHEDULE rowData= new SCHEDULE();
		rowData.setID(ID);
		rowData.setTYPE(TYPE);
		rowData.setINTERVAL(INTERVAL);
		rowData.setSTART(START);
		rowData.setEND(END);
		
		return rowData;
	}
	
	public void update(SCHEDULE rowData) {
		ID = rowData.getID();
		TYPE = rowData.getTYPE();
		INTERVAL = rowData.getINTERVAL();
		START = rowData.getSTART();
		END = rowData.getEND();
	}
	
	public void update(String id,String type,String interval,String start,String end){
		ID = id;
		TYPE = type;
		INTERVAL = interval;
		START = start;
		END = end;
	}
	
	public void updateScheduleFromJSON(JSONObject obj) throws Exception{
		ID = obj.getString("ID");
		TYPE = obj.getString("TYPE");
		INTERVAL = obj.getString("INTERVAL");
		START = obj.getString("START");
		END = obj.getString("END");
	}
}
