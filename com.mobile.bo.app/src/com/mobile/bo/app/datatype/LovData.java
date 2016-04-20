package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.UUID;

import org.json.JSONObject;

import com.mobile.database.app.entities.LOV;
import com.mobile.framework.widget.ISpinnerItem;

public class LovData implements Serializable, ISpinnerItem , Comparable<Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1141511922296215231L;
	private String ID;
	private String CODE;
	private String DESCRIPTION;
	private String GROUP;
	private String ORDERNUM;
	private String PARENT;
	private String PARENT_2;
	
	public LovData(){
		
	}
	
	public LovData(String _id,String _code,String _description,String _group,String _ordernum,
			String _parent, String _parent_2) {
		ID = _id;
		CODE = _code;
		DESCRIPTION = _description;
		GROUP = _group;
		ORDERNUM = _ordernum;
		PARENT = _parent;
		PARENT_2 = _parent_2;
	}
	public LovData(LOV rowData){
		update(rowData);
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
	public String getCODE() {
		return CODE;
	}
	public void setCODE(String cODE) {
		CODE = cODE;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}
	
	public String getGROUP() {
		return GROUP;
	}
	public void setGROUP(String gROUP) {
		GROUP = gROUP;
	}
	
	public String getORDERNUM() {
		return ORDERNUM;
	}
	
	public String getPARENT() {
		return PARENT;
	}
	public void setPARENT(String pARENT) {
		PARENT = pARENT;
	}
	
	public String getPARENT_2() {
		return PARENT_2;
	}
	public void setPARENT_2(String pARENT2) {
		PARENT_2 = pARENT2;
	}

	public void update(LOV rowData) {
		ID = rowData.getID();
		CODE = rowData.getCODE();
		DESCRIPTION = rowData.getDESCRIPTION();
		GROUP = rowData.getGROUP();
		ORDERNUM = rowData.getORDERNUM();
		PARENT = rowData.getPARENT();
		PARENT_2 = rowData.getPARENT_2();
	}
	
	public LOV toRowData(){
		LOV rowData= new LOV();
		rowData.setID(ID);
		rowData.setCODE(CODE);	
		rowData.setDESCRIPTION(DESCRIPTION);
		rowData.setGROUP(GROUP);
		rowData.setORDERNUM(ORDERNUM);
		rowData.setPARENT(PARENT);
		rowData.setPARENT_2(PARENT_2);
		return rowData;
	}
	public LOV toRowDataNew(){
		LOV rowData= new LOV();
		rowData.setID(UUID.randomUUID().toString().toUpperCase());
		rowData.setCODE(CODE);	
		rowData.setDESCRIPTION(DESCRIPTION);
		rowData.setGROUP(GROUP);
		rowData.setORDERNUM(ORDERNUM);
		rowData.setPARENT(PARENT);
		rowData.setPARENT_2(PARENT_2);
		return rowData;
	}

	
	@Override
	public String onSpinnerGetText() {
		return String.format("%s", DESCRIPTION);
	}
	
	@Override
	public Object onSpinnerGetValue() {
		return CODE;
	}
	public void updateLOVFromJSON(JSONObject obj) throws Exception{
		ID = obj.getString("ID");
		CODE = obj.getString("CODE");
		DESCRIPTION = obj.getString("DESCRIPTION");
		GROUP = obj.getString("GROUP");
		ORDERNUM = obj.getString("ORDERNUM");
		PARENT = obj.getString("PARENT");
		PARENT_2 = obj.getString("PARENT_2");
	}

	@Override
	public int compareTo(Object o1) {
		int seqObj1 = Integer.parseInt(this.getORDERNUM());
		int seqObj2 = Integer.parseInt(((LovData) o1).getORDERNUM());
		 if (seqObj1 == seqObj2)
	            return 0;
	        else if (seqObj1 > seqObj2)
	            return 1;
	        else
	            return -1;
	}
}
