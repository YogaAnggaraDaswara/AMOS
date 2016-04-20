package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

import com.mobile.database.app.common.DataConverter;
import com.mobile.database.app.entities.APPR_MAIN;
import com.mobile.database.app.entities.APPR_RTB_CEK_TATA_KOTA_INT;
import com.mobile.database.app.entities.APPR_RTB_VALUATION_INT;
import com.mobile.database.app.entities.BLACKBOX;

public class Datatype_Appr_Rtb_Cek_Tata_Kota_Int implements Serializable {

	/**
	 * 
	 */
	public String COL_ID;
	public String AP_REGNO;
	public String REPORT_NO;
	public Date REPORT_DATE;
	public Date REPORT_INSPECT_DATE;
	public String REPORT_BRANCH_CODE;
	public String REPORT_SEG_CODE;
	public Date INSPECT_DATE;
	public String INSPECT_WAY;
	public String INSPECTOR_NAME;
	public String WIDENING;
	public String WIDENING_DESC;
	public String LINE_VIOLATE;
	public String LINE_VIOLATE_DESC;
	public String OBJECT_PURPOSE;
	public String OTHER_INFORMATION;
	public String CU_NAME;
	public String COL_ADDR1;
	public String DOC_DESC;
	public String COL_DOK_NO;
	public String COL_DOK_NAME;



   
    
	 public Datatype_Appr_Rtb_Cek_Tata_Kota_Int() {
	    	update("",
	    			"",
	    			"",
	    			null,
	    			null,
	    			"",
	    			"",
	    			null,
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
	    			"",
	    			"");
		}
	    
	 public Datatype_Appr_Rtb_Cek_Tata_Kota_Int(APPR_RTB_CEK_TATA_KOTA_INT Data) {
			update(Data);
	}
		

	
	public APPR_RTB_CEK_TATA_KOTA_INT toRowData(){
		APPR_RTB_CEK_TATA_KOTA_INT rowData= new APPR_RTB_CEK_TATA_KOTA_INT();
		rowData.setCOL_ID(COL_ID);
		rowData.setAP_REGNO(AP_REGNO);
		rowData.setREPORT_NO(REPORT_NO);
		rowData.setREPORT_DATE(REPORT_DATE);
		rowData.setREPORT_INSPECT_DATE(REPORT_INSPECT_DATE);
		rowData.setREPORT_BRANCH_CODE(REPORT_BRANCH_CODE);
		rowData.setREPORT_SEG_CODE(REPORT_SEG_CODE);
		rowData.setINSPECT_DATE(INSPECT_DATE);
		rowData.setINSPECT_WAY(INSPECT_WAY);
		rowData.setINSPECTOR_NAME(INSPECTOR_NAME);
		rowData.setWIDENING(WIDENING);
		rowData.setWIDENING_DESC(WIDENING_DESC);
		rowData.setLINE_VIOLATE(LINE_VIOLATE);
		rowData.setLINE_VIOLATE_DESC(LINE_VIOLATE_DESC);
		rowData.setOBJECT_PURPOSE(OBJECT_PURPOSE);
		rowData.setOTHER_INFORMATION(OTHER_INFORMATION);
		rowData.setCU_NAME(CU_NAME);
		rowData.setCOL_ADDR1(COL_ADDR1);
		rowData.setDOC_DESC(DOC_DESC);
		rowData.setCOL_DOK_NO(COL_DOK_NO);
		rowData.setCOL_DOK_NAME(COL_DOK_NAME);

	
		return rowData;
	}
	
	public void update(APPR_RTB_CEK_TATA_KOTA_INT rowData) {
		COL_ID=rowData.getCOL_ID();
		AP_REGNO=rowData.getAP_REGNO();
		REPORT_NO=rowData.getREPORT_NO();
		REPORT_DATE=rowData.getREPORT_DATE();
		REPORT_INSPECT_DATE=rowData.getREPORT_INSPECT_DATE();
		REPORT_BRANCH_CODE=rowData.getREPORT_BRANCH_CODE();
		REPORT_SEG_CODE=rowData.getREPORT_SEG_CODE();
		INSPECT_DATE=rowData.getINSPECT_DATE();
		INSPECT_WAY=rowData.getINSPECT_WAY();
		INSPECTOR_NAME=rowData.getINSPECTOR_NAME();
		WIDENING=rowData.getWIDENING();
		WIDENING_DESC=rowData.getWIDENING_DESC();
		LINE_VIOLATE=rowData.getLINE_VIOLATE();
		LINE_VIOLATE_DESC=rowData.getLINE_VIOLATE_DESC();
		OBJECT_PURPOSE=rowData.getOBJECT_PURPOSE();
		OTHER_INFORMATION=rowData.getOTHER_INFORMATION();
		CU_NAME=rowData.getCU_NAME();
		COL_ADDR1=rowData.getCOL_ADDR1();
		DOC_DESC=rowData.getDOC_DESC();
		COL_DOK_NO=rowData.getCOL_DOK_NO();
		COL_DOK_NAME=rowData.getCOL_DOK_NAME();


	}
	public void updateMainFromJSON(JSONObject obj) throws Exception{
	
		COL_ID=obj.getString("COL_ID");
		AP_REGNO=obj.getString("AP_REGNO");
		REPORT_NO=obj.getString("REPORT_NO");
		REPORT_DATE=DataConverter.stringToDate(obj.getString("REPORT_DATE"));
		REPORT_INSPECT_DATE=DataConverter.stringToDate(obj.getString("REPORT_INSPECT_DATE"));
		REPORT_BRANCH_CODE=obj.getString("REPORT_BRANCH_CODE");
		REPORT_SEG_CODE=obj.getString("REPORT_SEG_CODE");
		INSPECT_DATE=DataConverter.stringToDate(obj.getString("INSPECT_DATE"));
		INSPECT_WAY=obj.getString("INSPECT_WAY");
		INSPECTOR_NAME=obj.getString("INSPECTOR_NAME");
		WIDENING=obj.getString("WIDENING");
		WIDENING_DESC=obj.getString("WIDENING_DESC");
		LINE_VIOLATE=obj.getString("LINE_VIOLATE");
		LINE_VIOLATE_DESC=obj.getString("LINE_VIOLATE_DESC");
		OBJECT_PURPOSE=obj.getString("OBJECT_PURPOSE");
		OTHER_INFORMATION=obj.getString("OTHER_INFORMATION");
		CU_NAME=obj.getString("CU_NAME");
		COL_ADDR1=obj.getString("COL_ADDR1");
		DOC_DESC=obj.getString("DOC_DESC");
		COL_DOK_NO=obj.getString("COL_DOK_NO");
		COL_DOK_NAME=obj.getString("COL_DOK_NAME");

	}
	public void update(String col_id,
			String ap_regno,
			String report_no,
			Date report_date,
			Date report_inspect_date,
			String report_branch_code,
			String report_seg_code,
			Date inspect_date,
			String inspect_way,
			String inspector_name,
			String widening,
			String widening_desc,
			String line_violate,
			String line_violate_desc,
			String object_purpose,
			String other_information,
			String cu_name,
			String col_addr1,
			String doc_desc,
			String col_dok_no,
			String col_dok_name){
		COL_ID=col_id;
		AP_REGNO=ap_regno;
		REPORT_NO=report_no;
		REPORT_DATE=report_date;
		REPORT_INSPECT_DATE=report_inspect_date;
		REPORT_BRANCH_CODE=report_branch_code;
		REPORT_SEG_CODE=report_seg_code;
		INSPECT_DATE=inspect_date;
		INSPECT_WAY=inspect_way;
		INSPECTOR_NAME=inspector_name;
		WIDENING=widening;
		WIDENING_DESC=widening_desc;
		LINE_VIOLATE=line_violate;
		LINE_VIOLATE_DESC=line_violate_desc;
		OBJECT_PURPOSE=object_purpose;
		OTHER_INFORMATION=other_information;
		CU_NAME=cu_name;
		COL_ADDR1=col_addr1;
		DOC_DESC=doc_desc;
		COL_DOK_NO=col_dok_no;
		COL_DOK_NAME=col_dok_name;

	}

	public String getCOL_ID() {
		return COL_ID;
	}

	public void setCOL_ID(String cOL_ID) {
		COL_ID = cOL_ID;
	}

	public String getAP_REGNO() {
		return AP_REGNO;
	}

	public void setAP_REGNO(String aP_REGNO) {
		AP_REGNO = aP_REGNO;
	}

	public String getREPORT_NO() {
		return REPORT_NO;
	}

	public void setREPORT_NO(String rEPORT_NO) {
		REPORT_NO = rEPORT_NO;
	}

	public Date getREPORT_DATE() {
		return REPORT_DATE;
	}

	public void setREPORT_DATE(Date rEPORT_DATE) {
		REPORT_DATE = rEPORT_DATE;
	}

	public Date getREPORT_INSPECT_DATE() {
		return REPORT_INSPECT_DATE;
	}

	public void setREPORT_INSPECT_DATE(Date rEPORT_INSPECT_DATE) {
		REPORT_INSPECT_DATE = rEPORT_INSPECT_DATE;
	}

	public String getREPORT_BRANCH_CODE() {
		return REPORT_BRANCH_CODE;
	}

	public void setREPORT_BRANCH_CODE(String rEPORT_BRANCH_CODE) {
		REPORT_BRANCH_CODE = rEPORT_BRANCH_CODE;
	}

	public String getREPORT_SEG_CODE() {
		return REPORT_SEG_CODE;
	}

	public void setREPORT_SEG_CODE(String rEPORT_SEG_CODE) {
		REPORT_SEG_CODE = rEPORT_SEG_CODE;
	}

	public Date getINSPECT_DATE() {
		return INSPECT_DATE;
	}

	public void setINSPECT_DATE(Date iNSPECT_DATE) {
		INSPECT_DATE = iNSPECT_DATE;
	}

	public String getINSPECT_WAY() {
		return INSPECT_WAY;
	}

	public void setINSPECT_WAY(String iNSPECT_WAY) {
		INSPECT_WAY = iNSPECT_WAY;
	}

	public String getINSPECTOR_NAME() {
		return INSPECTOR_NAME;
	}

	public void setINSPECTOR_NAME(String iNSPECTOR_NAME) {
		INSPECTOR_NAME = iNSPECTOR_NAME;
	}

	public String getWIDENING() {
		return WIDENING;
	}

	public void setWIDENING(String wIDENING) {
		WIDENING = wIDENING;
	}

	public String getWIDENING_DESC() {
		return WIDENING_DESC;
	}

	public void setWIDENING_DESC(String wIDENING_DESC) {
		WIDENING_DESC = wIDENING_DESC;
	}

	public String getLINE_VIOLATE() {
		return LINE_VIOLATE;
	}

	public void setLINE_VIOLATE(String lINE_VIOLATE) {
		LINE_VIOLATE = lINE_VIOLATE;
	}

	public String getLINE_VIOLATE_DESC() {
		return LINE_VIOLATE_DESC;
	}

	public void setLINE_VIOLATE_DESC(String lINE_VIOLATE_DESC) {
		LINE_VIOLATE_DESC = lINE_VIOLATE_DESC;
	}

	public String getOBJECT_PURPOSE() {
		return OBJECT_PURPOSE;
	}

	public void setOBJECT_PURPOSE(String oBJECT_PURPOSE) {
		OBJECT_PURPOSE = oBJECT_PURPOSE;
	}

	public String getOTHER_INFORMATION() {
		return OTHER_INFORMATION;
	}

	public void setOTHER_INFORMATION(String oTHER_INFORMATION) {
		OTHER_INFORMATION = oTHER_INFORMATION;
	}

	public String getCU_NAME() {
		return CU_NAME;
	}

	public void setCU_NAME(String cU_NAME) {
		CU_NAME = cU_NAME;
	}

	public String getCOL_ADDR1() {
		return COL_ADDR1;
	}

	public void setCOL_ADDR1(String cOL_ADDR1) {
		COL_ADDR1 = cOL_ADDR1;
	}

	public String getDOC_DESC() {
		return DOC_DESC;
	}

	public void setDOC_DESC(String dOC_DESC) {
		DOC_DESC = dOC_DESC;
	}

	public String getCOL_DOK_NO() {
		return COL_DOK_NO;
	}

	public void setCOL_DOK_NO(String cOL_DOK_NO) {
		COL_DOK_NO = cOL_DOK_NO;
	}

	public String getCOL_DOK_NAME() {
		return COL_DOK_NAME;
	}

	public void setCOL_DOK_NAME(String cOL_DOK_NAME) {
		COL_DOK_NAME = cOL_DOK_NAME;
	}
	
}
