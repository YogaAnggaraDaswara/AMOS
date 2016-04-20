package com.mobile.services.app.datatype;

import java.util.ArrayList;
import com.google.gson.Gson;
import com.mobile.bo.app.datatype.StateHistoryData;
import com.mobile.framework.common.DateFormatter;

public class STATEHISTORYREQUEST {
	private String ID;	
    private String PROSPEKID;		
    private String STARTDATE ;
    private String ENDDATE ;
    private String STAGE ;
    private String APPROVEDBY;
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
	public String getSTARTDATE() {
		return STARTDATE;
	}
	public void setSTARTDATE(String sTARTDATE) {
		STARTDATE = sTARTDATE;
	}
	public String getENDDATE() {
		return ENDDATE;
	}
	public void setENDDATE(String eNDDATE) {
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
    
	public String toJSONString(ArrayList<StateHistoryData> stateHistory) throws Exception {  
		Gson gsonstatehistory =  new Gson();
		ArrayList<STATEHISTORYREQUEST> arrayStateHistoryRequest=new ArrayList<STATEHISTORYREQUEST>();
		
		 for (int i=0;i<stateHistory.size();i++){
			 	STATEHISTORYREQUEST shr=new STATEHISTORYREQUEST();
			 	StateHistoryData stateHistoryData= stateHistory.get(i);
			 	shr.setID(stateHistoryData.getID().toString());
			 	shr.setPROSPEKID(stateHistoryData.getPROSPEKID());
			 	shr.setSTAGE(stateHistoryData.getSTAGE());
			 	shr.setSTARTDATE(DateFormatter.formatStringYYYYMMdd(stateHistoryData.getSTARTDATE(),false));
			 	shr.setENDDATE(DateFormatter.formatStringYYYYMMdd(stateHistoryData.getENDDATE(),false));
			 	shr.setAPPROVEDBY(stateHistoryData.getAPPROVEDBY());
			 	
			 	arrayStateHistoryRequest.add(shr);
		 }

		return gsonstatehistory.toJson(arrayStateHistoryRequest);
	}

}
