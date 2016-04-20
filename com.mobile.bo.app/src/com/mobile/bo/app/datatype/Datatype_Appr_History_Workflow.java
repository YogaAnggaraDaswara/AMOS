package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

import com.mobile.database.app.common.DataConverter;
import com.mobile.database.app.entities.APPR_DOKUMENT;
import com.mobile.database.app.entities.APPR_HISTORY;
import com.mobile.database.app.entities.APPR_HISTORY_WORKFLOW;
import com.mobile.database.app.entities.APPR_MAIN;
import com.mobile.database.app.entities.APPR_MCH_VALUATION_INT;
import com.mobile.database.app.entities.APPR_PB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_RTB_CEK_TATA_KOTA_INT;
import com.mobile.database.app.entities.APPR_RTB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_VHC_VALUATION_INT;
import com.mobile.database.app.entities.BLACKBOX;

public class Datatype_Appr_History_Workflow implements Serializable {

	/**
	 * 
	 */
	public String ID;
	public String AP_REGNO;
	public String ALT_TYPE;
	public String ALT_DESC;
	public String TR_CODE;
	public String TR_DESC;
	public String TR_BY;
	public String TR_START;
	public String TR_END;
	public String AGING;





	 public void updateMainFromJSON(JSONObject obj) throws Exception{
		 ID=obj.getString("ID");
		 AP_REGNO=obj.getString("AP_REGNO");
		 ALT_TYPE=obj.getString("ALT_TYPE");
		 ALT_DESC=obj.getString("ALT_DESC");
		 TR_CODE=obj.getString("TR_CODE");
		 TR_DESC=obj.getString("TR_DESC");
		 TR_BY=obj.getString("TR_BY");
		 TR_START=obj.getString("TR_START");
		 TR_END=obj.getString("TR_END");
		 AGING=obj.getString("AGING");





	 }
    
	 public Datatype_Appr_History_Workflow() {
	    	update("",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"");
		}
	    
	 public Datatype_Appr_History_Workflow(APPR_HISTORY_WORKFLOW Data) {
			update(Data);
	}
		

	public APPR_HISTORY_WORKFLOW toRowData(){
		APPR_HISTORY_WORKFLOW rowData= new APPR_HISTORY_WORKFLOW();
		rowData.setID(ID);
		rowData.setAP_REGNO(AP_REGNO);
		rowData.setALT_TYPE(ALT_TYPE);
		rowData.setALT_DESC(ALT_DESC);
		rowData.setTR_CODE(TR_CODE);
		rowData.setTR_DESC(TR_DESC);
		rowData.setTR_BY(TR_BY);
		rowData.setTR_START(TR_START);
		rowData.setTR_END(TR_END);
		rowData.setAGING(AGING);




	
		return rowData;
	}
	
	public void update(APPR_HISTORY_WORKFLOW rowData) {
		ID=rowData.getID();
		AP_REGNO=rowData.getAP_REGNO();
		ALT_TYPE=rowData.getALT_TYPE();
		ALT_DESC=rowData.getALT_DESC();
		TR_CODE=rowData.getTR_CODE();
		TR_DESC=rowData.getTR_DESC();
		TR_BY=rowData.getTR_BY();
		TR_START=rowData.getTR_START();
		TR_END=rowData.getTR_END();
		AGING=rowData.getAGING();





	}
	
	public void update(String id,
			String ap_regno,
			String alt_type,
			String alt_desc,
			String tr_code,
			String tr_desc,
			String tr_by,
			String tr_start,
			String tr_end,
			String aging){
		ID=id;
		AP_REGNO=ap_regno;
		ALT_TYPE=alt_type;
		ALT_DESC=alt_desc;
		TR_CODE=tr_code;
		TR_DESC=tr_desc;
		TR_BY=tr_by;
		TR_START=tr_start;
		TR_END=tr_end;
		AGING=aging;




}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getAP_REGNO() {
		return AP_REGNO;
	}

	public void setAP_REGNO(String aP_REGNO) {
		AP_REGNO = aP_REGNO;
	}

	public String getALT_TYPE() {
		return ALT_TYPE;
	}

	public void setALT_TYPE(String aLT_TYPE) {
		ALT_TYPE = aLT_TYPE;
	}

	public String getALT_DESC() {
		return ALT_DESC;
	}

	public void setALT_DESC(String aLT_DESC) {
		ALT_DESC = aLT_DESC;
	}

	public String getTR_CODE() {
		return TR_CODE;
	}

	public void setTR_CODE(String tR_CODE) {
		TR_CODE = tR_CODE;
	}

	public String getTR_DESC() {
		return TR_DESC;
	}

	public void setTR_DESC(String tR_DESC) {
		TR_DESC = tR_DESC;
	}

	public String getTR_BY() {
		return TR_BY;
	}

	public void setTR_BY(String tR_BY) {
		TR_BY = tR_BY;
	}

	public String getTR_START() {
		return TR_START;
	}

	public void setTR_START(String tR_START) {
		TR_START = tR_START;
	}

	public String getTR_END() {
		return TR_END;
	}

	public void setTR_END(String tR_END) {
		TR_END = tR_END;
	}

	public String getAGING() {
		return AGING;
	}

	public void setAGING(String aGING) {
		AGING = aGING;
	}

	
	
	
}
