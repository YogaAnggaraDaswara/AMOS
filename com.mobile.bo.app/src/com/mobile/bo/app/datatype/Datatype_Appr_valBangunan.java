package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

import com.mobile.database.app.common.DataConverter;
import com.mobile.database.app.entities.APPR_DOKUMENT;
import com.mobile.database.app.entities.APPR_MAIN;
import com.mobile.database.app.entities.APPR_MCH_VALUATION_INT;
import com.mobile.database.app.entities.APPR_PB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_RTB_CEK_TATA_KOTA_INT;
import com.mobile.database.app.entities.APPR_RTB_VALUATION_INT;
import com.mobile.database.app.entities.APPR_VALBANGUNAN;
import com.mobile.database.app.entities.APPR_VHC_VALUATION_INT;
import com.mobile.database.app.entities.BLACKBOX;

public class Datatype_Appr_valBangunan implements Serializable {

	/**
	 * 
	 */
	public String ID;
	public String COL_ID;
	public String BUILD_SEQ;
	public String BUILDING_TYPE;
	public String BUILD_AREA_FISIK;
	public String BUILD_AREA_IMB;
	public String BUILD_LIQ_PCT_FISIK;
	public String BUILD_LIQ_PCT_IMB;
	public String BUILD_LIQ_VALUE_FISIK;
	public String BUILD_LIQ_VALUE_IMB;
	public String BUILD_MARKET_VALUE_FISIK;
	public String BUILD_MARKET_VALUE_IMB;
	public String BUILD_PERMETER_VALUE;
	public String BUILD_LAND_AREA_AFTER_POTONG;



	 public void updateMainFromJSON(JSONObject obj) throws Exception{
		 ID=obj.getString("ID");
		 COL_ID=obj.getString("COL_ID");
		 BUILD_SEQ=obj.getString("BUILD_SEQ");
		 BUILDING_TYPE=obj.getString("BUILDING_TYPE");
		 BUILD_AREA_FISIK=obj.getString("BUILD_AREA_FISIK");
		 BUILD_AREA_IMB=obj.getString("BUILD_AREA_IMB");
		 BUILD_LIQ_PCT_FISIK=obj.getString("BUILD_LIQ_PCT_FISIK");
		 BUILD_LIQ_PCT_IMB=obj.getString("BUILD_LIQ_PCT_IMB");
		 BUILD_LIQ_VALUE_FISIK=obj.getString("BUILD_LIQ_VALUE_FISIK");
		 BUILD_LIQ_VALUE_IMB=obj.getString("BUILD_LIQ_VALUE_IMB");
		 BUILD_MARKET_VALUE_FISIK=obj.getString("BUILD_MARKET_VALUE_FISIK");
		 BUILD_MARKET_VALUE_IMB=obj.getString("BUILD_MARKET_VALUE_IMB");
		 BUILD_PERMETER_VALUE=obj.getString("BUILD_PERMETER_VALUE");
		 BUILD_LAND_AREA_AFTER_POTONG=obj.getString("BUILD_LAND_AREA_AFTER_POTONG");



	 }
    
	 public Datatype_Appr_valBangunan() {
	    	update("",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"","");
		}
	    
	 public Datatype_Appr_valBangunan(APPR_VALBANGUNAN Data) {
			update(Data);
	}
		

	public APPR_VALBANGUNAN toRowData(){
		APPR_VALBANGUNAN rowData= new APPR_VALBANGUNAN();
		rowData.setID(ID);
		rowData.setCOL_ID(COL_ID);
		rowData.setBUILD_SEQ(BUILD_SEQ);
		rowData.setBUILDING_TYPE(BUILDING_TYPE);
		rowData.setBUILD_AREA_FISIK(BUILD_AREA_FISIK);
		rowData.setBUILD_AREA_IMB(BUILD_AREA_IMB);
		rowData.setBUILD_LIQ_PCT_FISIK(BUILD_LIQ_PCT_FISIK);
		rowData.setBUILD_LIQ_PCT_IMB(BUILD_LIQ_PCT_IMB);
		rowData.setBUILD_LIQ_VALUE_FISIK(BUILD_LIQ_VALUE_FISIK);
		rowData.setBUILD_LIQ_VALUE_IMB(BUILD_LIQ_VALUE_IMB);
		rowData.setBUILD_MARKET_VALUE_FISIK(BUILD_MARKET_VALUE_FISIK);
		rowData.setBUILD_MARKET_VALUE_IMB(BUILD_MARKET_VALUE_IMB);
		rowData.setBUILD_PERMETER_VALUE(BUILD_PERMETER_VALUE);
		rowData.setBUILD_LAND_AREA_AFTER_POTONG(BUILD_LAND_AREA_AFTER_POTONG);


	
		return rowData;
	}
	
	public void update(APPR_VALBANGUNAN rowData) {
		ID=rowData.getID();
		COL_ID=rowData.getCOL_ID();
		BUILD_SEQ=rowData.getBUILD_SEQ();
		BUILDING_TYPE=rowData.getBUILDING_TYPE();
		BUILD_AREA_FISIK=rowData.getBUILD_AREA_FISIK();
		BUILD_AREA_IMB=rowData.getBUILD_AREA_IMB();
		BUILD_LIQ_PCT_FISIK=rowData.getBUILD_LIQ_PCT_FISIK();
		BUILD_LIQ_PCT_IMB=rowData.getBUILD_LIQ_PCT_IMB();
		BUILD_LIQ_VALUE_FISIK=rowData.getBUILD_LIQ_VALUE_FISIK();
		BUILD_LIQ_VALUE_IMB=rowData.getBUILD_LIQ_VALUE_IMB();
		BUILD_MARKET_VALUE_FISIK=rowData.getBUILD_MARKET_VALUE_FISIK();
		BUILD_MARKET_VALUE_IMB=rowData.getBUILD_MARKET_VALUE_IMB();
		BUILD_PERMETER_VALUE=rowData.getBUILD_PERMETER_VALUE();
		BUILD_LAND_AREA_AFTER_POTONG=rowData.getBUILD_LAND_AREA_AFTER_POTONG();



	}
	
	public void update(String id,
			String col_id,
			String build_seq,
			String building_type,
			String build_area_fisik,
			String build_area_imb,
			String build_liq_pct_fisik,
			String build_liq_pct_imb,
			String build_liq_value_fisik,
			String build_liq_value_imb,
			String build_market_value_fisik,
			String build_market_value_imb,
			String build_permeter_value,String bUILD_LAND_AREA_AFTER_POTONG){
		ID=id;
		COL_ID=col_id;
		BUILD_SEQ=build_seq;
		BUILDING_TYPE=building_type;
		BUILD_AREA_FISIK=build_area_fisik;
		BUILD_AREA_IMB=build_area_imb;
		BUILD_LIQ_PCT_FISIK=build_liq_pct_fisik;
		BUILD_LIQ_PCT_IMB=build_liq_pct_imb;
		BUILD_LIQ_VALUE_FISIK=build_liq_value_fisik;
		BUILD_LIQ_VALUE_IMB=build_liq_value_imb;
		BUILD_MARKET_VALUE_FISIK=build_market_value_fisik;
		BUILD_MARKET_VALUE_IMB=build_market_value_imb;
		BUILD_PERMETER_VALUE=build_permeter_value;
		BUILD_LAND_AREA_AFTER_POTONG=bUILD_LAND_AREA_AFTER_POTONG;

}

	public String getBUILD_LAND_AREA_AFTER_POTONG() {
		return BUILD_LAND_AREA_AFTER_POTONG;
	}

	public void setBUILD_LAND_AREA_AFTER_POTONG(String bUILD_LAND_AREA_AFTER_POTONG) {
		BUILD_LAND_AREA_AFTER_POTONG = bUILD_LAND_AREA_AFTER_POTONG;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getCOL_ID() {
		return COL_ID;
	}

	public void setCOL_ID(String cOL_ID) {
		COL_ID = cOL_ID;
	}

	public String getBUILD_SEQ() {
		return BUILD_SEQ;
	}

	public void setBUILD_SEQ(String bUILD_SEQ) {
		BUILD_SEQ = bUILD_SEQ;
	}

	public String getBUILDING_TYPE() {
		return BUILDING_TYPE;
	}

	public void setBUILDING_TYPE(String bUILDING_TYPE) {
		BUILDING_TYPE = bUILDING_TYPE;
	}

	public String getBUILD_AREA_FISIK() {
		return BUILD_AREA_FISIK;
	}

	public void setBUILD_AREA_FISIK(String bUILD_AREA_FISIK) {
		BUILD_AREA_FISIK = bUILD_AREA_FISIK;
	}

	public String getBUILD_AREA_IMB() {
		return BUILD_AREA_IMB;
	}

	public void setBUILD_AREA_IMB(String bUILD_AREA_IMB) {
		BUILD_AREA_IMB = bUILD_AREA_IMB;
	}

	public String getBUILD_LIQ_PCT_FISIK() {
		return BUILD_LIQ_PCT_FISIK;
	}

	public void setBUILD_LIQ_PCT_FISIK(String bUILD_LIQ_PCT_FISIK) {
		BUILD_LIQ_PCT_FISIK = bUILD_LIQ_PCT_FISIK;
	}

	public String getBUILD_LIQ_PCT_IMB() {
		return BUILD_LIQ_PCT_IMB;
	}

	public void setBUILD_LIQ_PCT_IMB(String bUILD_LIQ_PCT_IMB) {
		BUILD_LIQ_PCT_IMB = bUILD_LIQ_PCT_IMB;
	}

	public String getBUILD_LIQ_VALUE_FISIK() {
		return BUILD_LIQ_VALUE_FISIK;
	}

	public void setBUILD_LIQ_VALUE_FISIK(String bUILD_LIQ_VALUE_FISIK) {
		BUILD_LIQ_VALUE_FISIK = bUILD_LIQ_VALUE_FISIK;
	}

	public String getBUILD_LIQ_VALUE_IMB() {
		return BUILD_LIQ_VALUE_IMB;
	}

	public void setBUILD_LIQ_VALUE_IMB(String bUILD_LIQ_VALUE_IMB) {
		BUILD_LIQ_VALUE_IMB = bUILD_LIQ_VALUE_IMB;
	}

	public String getBUILD_MARKET_VALUE_FISIK() {
		return BUILD_MARKET_VALUE_FISIK;
	}

	public void setBUILD_MARKET_VALUE_FISIK(String bUILD_MARKET_VALUE_FISIK) {
		BUILD_MARKET_VALUE_FISIK = bUILD_MARKET_VALUE_FISIK;
	}

	public String getBUILD_MARKET_VALUE_IMB() {
		return BUILD_MARKET_VALUE_IMB;
	}

	public void setBUILD_MARKET_VALUE_IMB(String bUILD_MARKET_VALUE_IMB) {
		BUILD_MARKET_VALUE_IMB = bUILD_MARKET_VALUE_IMB;
	}

	public String getBUILD_PERMETER_VALUE() {
		return BUILD_PERMETER_VALUE;
	}

	public void setBUILD_PERMETER_VALUE(String bUILD_PERMETER_VALUE) {
		BUILD_PERMETER_VALUE = bUILD_PERMETER_VALUE;
	}

	
	
}
