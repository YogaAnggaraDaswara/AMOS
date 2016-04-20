package com.mobile.services.app.datatype;

import java.util.ArrayList;
import com.google.gson.Gson;
import com.mobile.bo.app.datatype.ProspekData;

public class BLACKBOXDATARESULTREQUEST {
	public String ID;
	public String PROSPEKID;
	public String USERID;
	public String REQUESTID;
	
	
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


	public String getUSERID() {
		return USERID;
	}


	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}


	public String getREQUESTID() {
		return REQUESTID;
	}


	public void setREQUESTID(String rEQUESTID) {
		REQUESTID = rEQUESTID;
	}


	public String toJSONString(ArrayList<ProspekData> arrProspek) throws Exception {
		ArrayList<BLACKBOXDATARESULTREQUEST> arrBlackboxResultRequest= new ArrayList<BLACKBOXDATARESULTREQUEST>();
		Gson gsonBlackboxDataRequest=new Gson();
		
		for (int i=0;i< arrProspek.size(); i++){
			ProspekData pd= arrProspek.get(i);
			BLACKBOXDATARESULTREQUEST bdr=new BLACKBOXDATARESULTREQUEST();
			bdr.setID(pd.getID().toString());
			bdr.setPROSPEKID(pd.getPROSPEKID());
			bdr.setUSERID(pd.getUSERID());
			bdr.setREQUESTID(pd.getREQUESTID());			
			arrBlackboxResultRequest.add(bdr);
		}
	
		return gsonBlackboxDataRequest.toJson(arrBlackboxResultRequest).toString();
	}
}
