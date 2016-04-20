package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;
import com.mobile.database.app.entities.STATEHISTORY;

public class StateHistoryData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6435086182438768583L;
	private Integer ID;	
    private String PROSPEKID;		
    private String PROSPEKIDLOCAL;
    private Date STARTDATE ;
    private Date ENDDATE ;
    private String STAGE ;
    private String APPROVEDBY;
    
    public StateHistoryData() {

    }    
    public StateHistoryData(STATEHISTORY statehistory) {
		update(statehistory);
	}
    
    public StateHistoryData(String apreqno,String idprospek,String stage,Date startdate,Date endDate,String approvedby)
    {
    	update(apreqno, idprospek, stage, startdate, endDate,approvedby);
    }
    
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getPROSPEKID() {
		return PROSPEKID;
	}

	public void setPROSPEKID(String pROSPEKID) {
		PROSPEKID = pROSPEKID;
	}

	public String getPROSPEKIDLOCAL() {
		return PROSPEKIDLOCAL;
	}

	public void setPROSPEKIDLOCAL(String pROSPEKIDLOCAL) {
		PROSPEKIDLOCAL = pROSPEKIDLOCAL;
	}

	public Date getSTARTDATE() {
		return STARTDATE;
	}
	public void setSTARTDATE(Date sTARTDATE) {
		STARTDATE = sTARTDATE;
	}
	public Date getENDDATE() {
		return ENDDATE;
	}
	public void setENDDATE(Date eNDDATE) {
		ENDDATE = eNDDATE;
	}
	public String getSTAGE() {
		return STAGE;
	}
	public void setSTAGE(String sTAGE) {
		STAGE = sTAGE;
	}
	public String getAPPROVEDBY() {
		return APPROVEDBY;
	}

	public void setAPPROVEDBY(String aPPROVEDBY) {
		APPROVEDBY = aPPROVEDBY;
	}

	public STATEHISTORY toRowData(){
		STATEHISTORY rowData= new STATEHISTORY();		
		rowData.setID(ID);
		rowData.setPROSPEKID(PROSPEKID);
		rowData.setPROSPEKIDLOCAL(PROSPEKIDLOCAL);
		rowData.setSTAGE(STAGE);
		rowData.setSTARTDATE(STARTDATE);
		rowData.setENDDATE(ENDDATE);
		rowData.setAPPROVEDBY(APPROVEDBY);
			
		return rowData;
	}
	
	public void update(STATEHISTORY rowData) {
		ID = rowData.getID();
		PROSPEKID = rowData.getPROSPEKID();
		PROSPEKIDLOCAL = rowData.getPROSPEKIDLOCAL();
		STAGE = rowData.getSTAGE();
		STARTDATE=rowData.getSTARTDATE();
		ENDDATE=rowData.getENDDATE();
		APPROVEDBY = rowData.getAPPROVEDBY();
	}
	
	public void update(String prospekid,String prospekidlocal,String stage,Date startdate,Date endDate,String approvedby){
		PROSPEKID = prospekid;
		PROSPEKIDLOCAL = prospekidlocal;
		STAGE = stage;
		STARTDATE= startdate;
		ENDDATE= endDate;
		APPROVEDBY = approvedby;
	}
}
