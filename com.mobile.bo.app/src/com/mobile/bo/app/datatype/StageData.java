package com.mobile.bo.app.datatype;

import java.io.Serializable;

import com.mobile.framework.widget.ISpinnerItem;

public class StageData implements Serializable, ISpinnerItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = -261078129460041055L;
	private String ID;
	private String DESCRIPTION;
	
	public StageData(String id,String description){
		ID = id;
		DESCRIPTION = description;
	}
	

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}

	@Override
	public String onSpinnerGetText() {
		// TODO Auto-generated method stub
		return DESCRIPTION;
	}

	@Override
	public Object onSpinnerGetValue() {
		// TODO Auto-generated method stub
		return ID;
	}

}
