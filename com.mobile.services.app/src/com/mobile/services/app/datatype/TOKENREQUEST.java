package com.mobile.services.app.datatype;

import java.util.ArrayList;
import com.google.gson.Gson;

public class TOKENREQUEST {
	private String NOMORREKENING;
    private String USERID;		
    private String HANDPHONE;
    private String TRANSTYPE;
    
	public String getNOMORREKENING() {
		return NOMORREKENING;
	}
	public void setNOMORREKENING(String nOMORREKENING) {
		NOMORREKENING = nOMORREKENING;
	}
	public String getUSERID() {
		return USERID;
	}
	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}
	public String getHANDPHONE() {
		return HANDPHONE;
	}
	public void setHANDPHONE(String hANDPHONE) {
		HANDPHONE = hANDPHONE;
	}
	public String getTRANSTYPE() {
		return TRANSTYPE;
	}
	public void setTRANSTYPE(String tRANSTYPE) {
		TRANSTYPE = tRANSTYPE;
	}
	public String toJSONString(String nomorrekening,String userid,String handphone,String transtype) throws Exception {
		Gson gsontagihan =  new Gson();
		ArrayList<TOKENREQUEST> arrToken=new ArrayList<TOKENREQUEST>();
		TOKENREQUEST token=new TOKENREQUEST();
		token.setHANDPHONE(handphone);
		token.setUSERID(userid);
		token.setNOMORREKENING(nomorrekening);
		token.setTRANSTYPE(transtype);
		arrToken.add(token);
		return gsontagihan.toJson(arrToken);
		
	}
}
