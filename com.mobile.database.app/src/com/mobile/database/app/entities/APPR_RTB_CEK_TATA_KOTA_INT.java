package com.mobile.database.app.entities;

import java.util.Date;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="APPR_RTB_CEK_TATA_KOTA_INT")
public class APPR_RTB_CEK_TATA_KOTA_INT {
	@DatabaseField(id=true,unique=true,canBeNull=false,uniqueIndexName="APPR_RTB_CEK_TATA_KOTA_INT_PK",dataType=DataType.STRING,width=16) private String COL_ID;
	@DatabaseField(dataType=DataType.STRING,width=20) private String AP_REGNO;
	@DatabaseField(dataType=DataType.STRING,width=8) private String REPORT_NO;
	@DatabaseField(dataType=DataType.STRING,width=4) private String REPORT_DATE;
	@DatabaseField(dataType=DataType.STRING,width=4) private String REPORT_INSPECT_DATE;
	@DatabaseField(dataType=DataType.STRING,width=50) private String REPORT_BRANCH_CODE;
	@DatabaseField(dataType=DataType.STRING,width=50) private String REPORT_SEG_CODE;
	@DatabaseField(dataType=DataType.STRING,width=10) private String INSPECT_DATE;
	@DatabaseField(dataType=DataType.STRING,width=50) private String INSPECT_WAY;
	@DatabaseField(dataType=DataType.STRING,width=10) private String INSPECTOR_NAME;
	@DatabaseField(dataType=DataType.STRING,width=50) private String WIDENING;
	@DatabaseField(dataType=DataType.STRING,width=10) private String WIDENING_DESC;
	@DatabaseField(dataType=DataType.STRING,width=10) private String LINE_VIOLATE;
	@DatabaseField(dataType=DataType.STRING,width=50) private String LINE_VIOLATE_DESC;
	@DatabaseField(dataType=DataType.STRING,width=10) private String OBJECT_PURPOSE;
	@DatabaseField(dataType=DataType.STRING,width=50) private String OTHER_INFORMATION;
	@DatabaseField(dataType=DataType.STRING,width=100) private String CU_NAME;
	@DatabaseField(dataType=DataType.STRING,width=200) private String COL_ADDR1;
	@DatabaseField(dataType=DataType.STRING,width=300) private String DOC_DESC;
	@DatabaseField(dataType=DataType.STRING,width=50) private String COL_DOK_NO;
	@DatabaseField(dataType=DataType.STRING,width=100) private String COL_DOK_NAME;
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
		return DataConverter.stringToDate(REPORT_DATE);
	}
	public void setREPORT_DATE(Date rEPORT_DATE) {
		REPORT_DATE = DataConverter.dateToString(rEPORT_DATE);
	}
	public Date getREPORT_INSPECT_DATE() {
		return DataConverter.stringToDate(REPORT_INSPECT_DATE);
	}
	public void setREPORT_INSPECT_DATE(Date rEPORT_INSPECT_DATE) {
		REPORT_INSPECT_DATE = DataConverter.dateToString(rEPORT_INSPECT_DATE);
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
		return DataConverter.stringToDate(INSPECT_DATE);
	}
	public void setINSPECT_DATE(Date iNSPECT_DATE) {
		INSPECT_DATE = DataConverter.dateToString(iNSPECT_DATE);
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
