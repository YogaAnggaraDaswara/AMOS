package com.mobile.bo.app.datatype;

import java.io.Serializable;
import org.json.JSONObject;
import com.mobile.framework.widget.ISpinnerItem;

public class MitraData implements Serializable, ISpinnerItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = -821995505374557726L;
	
	private String USERID;
	private String NAME;
	
	public String getUSERID() {
		return USERID;
	}

	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}
	
	public void updateMitraFromJSON(JSONObject obj) throws Exception{
		USERID = obj.getString("USERID");
		NAME = obj.getString("NAME");
	}

	@Override
	public String onSpinnerGetText() {
		// TODO Auto-generated method stub
		return NAME;
	}

	@Override
	public Object onSpinnerGetValue() {
		// TODO Auto-generated method stub
		return USERID.toString();
	}

}
