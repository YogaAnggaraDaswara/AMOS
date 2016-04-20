package com.mobile.services.app.datatype;
import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;
import com.mobile.framework.common.DateFormatter;

public class RequestCount implements Serializable,Comparable<Object>{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5967782337101462527L;
	private String PAGES;
	 public RequestCount() {
			
		}
	
	public String getPAGES() {
		return PAGES;
	}
	public void setPAGES(String pAGES) {
		PAGES = pAGES;
	}

	public void updateRequestCountFromJSON(JSONObject obj) throws Exception{
		PAGES = obj.getString("PAGES");
		
	}

	@Override
	public int compareTo(Object another) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
