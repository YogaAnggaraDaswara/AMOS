package com.mobile.database.app.entities;

import java.util.Date;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="APPR_DOKUMENT")
public class APPR_DOKUMENT {
	@DatabaseField(id=true,unique=true,canBeNull=false,uniqueIndexName="APPR_DOKUMENT_PK",dataType=DataType.STRING) private String ID;
	@DatabaseField(dataType=DataType.STRING,width=20) private String AP_REGNO;
	@DatabaseField(dataType=DataType.STRING,width=50) private String DOC_ID;
	@DatabaseField(dataType=DataType.STRING,width=10) private String DOC_TYPE;
	@DatabaseField(dataType=DataType.STRING,width=50) private String DOC_CODE;
	@DatabaseField(dataType=DataType.STRING,width=50) private String DOC_NO;
	@DatabaseField(dataType=DataType.STRING,width=10) private String DOC_EXPIREDATE;
	@DatabaseField(dataType=DataType.STRING,width=5) private String DOC_ORIG;
	@DatabaseField(dataType=DataType.STRING,width=5) private String DOC_COPY;
	@DatabaseField(dataType=DataType.STRING,width=5) private String DOC_WAIVE;
	@DatabaseField(dataType=DataType.STRING,width=5) private String DOC_TBO;
	@DatabaseField(dataType=DataType.STRING,width=10) private String DOC_TBODATE;
	@DatabaseField(dataType=DataType.STRING,width=5) private String DOC_VER_MANAGER;
	@DatabaseField(dataType=DataType.STRING,width=5) private String DOC_VER_CDU;
	@DatabaseField(dataType=DataType.STRING,width=100) private String DOC_DESC;
	@DatabaseField(dataType=DataType.STRING,width=5) private String DOC_NA;
	@DatabaseField(dataType=DataType.STRING,width=100) private String DOC_JUSTIFIED;
	@DatabaseField(dataType=DataType.STRING,width=5) private String DOC_MANDATORY;
	@DatabaseField(dataType=DataType.STRING,width=10) private String UPLOADDATE;
	@DatabaseField(dataType=DataType.STRING,width=10) private String JUMLAH;
	@DatabaseField(dataType=DataType.STRING,width=10) private String DOC_DECISION_TBO;
	@DatabaseField(dataType=DataType.STRING,width=5) private String DOC_VER_CAC;
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
	public String getDOC_ID() {
		return DOC_ID;
	}
	public void setDOC_ID(String dOC_ID) {
		DOC_ID = dOC_ID;
	}
	public String getDOC_TYPE() {
		return DOC_TYPE;
	}
	public void setDOC_TYPE(String dOC_TYPE) {
		DOC_TYPE = dOC_TYPE;
	}
	public String getDOC_CODE() {
		return DOC_CODE;
	}
	public void setDOC_CODE(String dOC_CODE) {
		DOC_CODE = dOC_CODE;
	}
	public String getDOC_NO() {
		return DOC_NO;
	}
	public void setDOC_NO(String dOC_NO) {
		DOC_NO = dOC_NO;
	}
	public Date getDOC_EXPIREDATE() {
		return DataConverter.stringToDate(DOC_EXPIREDATE);
	}
	public void setDOC_EXPIREDATE(Date dOC_EXPIREDATE) {
		DOC_EXPIREDATE = DataConverter.dateToString(dOC_EXPIREDATE);
	}
	public String getDOC_ORIG() {
		return DOC_ORIG;
	}
	public void setDOC_ORIG(String dOC_ORIG) {
		DOC_ORIG = dOC_ORIG;
	}
	public String getDOC_COPY() {
		return DOC_COPY;
	}
	public void setDOC_COPY(String dOC_COPY) {
		DOC_COPY = dOC_COPY;
	}
	public String getDOC_WAIVE() {
		return DOC_WAIVE;
	}
	public void setDOC_WAIVE(String dOC_WAIVE) {
		DOC_WAIVE = dOC_WAIVE;
	}
	public String getDOC_TBO() {
		return DOC_TBO;
	}
	public void setDOC_TBO(String dOC_TBO) {
		DOC_TBO = dOC_TBO;
	}
	public Date getDOC_TBODATE() {
		return DataConverter.stringToDate(DOC_TBODATE);
	}
	public void setDOC_TBODATE(Date dOC_TBODATE) {
		DOC_TBODATE = DataConverter.dateToString(dOC_TBODATE);
	}
	public String getDOC_VER_MANAGER() {
		return DOC_VER_MANAGER;
	}
	public void setDOC_VER_MANAGER(String dOC_VER_MANAGER) {
		DOC_VER_MANAGER = dOC_VER_MANAGER;
	}
	public String getDOC_VER_CDU() {
		return DOC_VER_CDU;
	}
	public void setDOC_VER_CDU(String dOC_VER_CDU) {
		DOC_VER_CDU = dOC_VER_CDU;
	}
	public String getDOC_DESC() {
		return DOC_DESC;
	}
	public void setDOC_DESC(String dOC_DESC) {
		DOC_DESC = dOC_DESC;
	}
	public String getDOC_NA() {
		return DOC_NA;
	}
	public void setDOC_NA(String dOC_NA) {
		DOC_NA = dOC_NA;
	}
	public String getDOC_JUSTIFIED() {
		return DOC_JUSTIFIED;
	}
	public void setDOC_JUSTIFIED(String dOC_JUSTIFIED) {
		DOC_JUSTIFIED = dOC_JUSTIFIED;
	}
	public String getDOC_MANDATORY() {
		return DOC_MANDATORY;
	}
	public void setDOC_MANDATORY(String dOC_MANDATORY) {
		DOC_MANDATORY = dOC_MANDATORY;
	}
	public Date getUPLOADDATE() {
		return DataConverter.stringToDate(UPLOADDATE);
	}
	public void setUPLOADDATE(Date uPLOADDATE) {
		UPLOADDATE = DataConverter.dateToString(uPLOADDATE);
	}
	public String getJUMLAH() {
		return JUMLAH;
	}
	public void setJUMLAH(String jUMLAH) {
		JUMLAH = jUMLAH;
	}
	public String getDOC_DECISION_TBO() {
		return DOC_DECISION_TBO;
	}
	public void setDOC_DECISION_TBO(String dOC_DECISION_TBO) {
		DOC_DECISION_TBO = dOC_DECISION_TBO;
	}
	public String getDOC_VER_CAC() {
		return DOC_VER_CAC;
	}
	public void setDOC_VER_CAC(String dOC_VER_CAC) {
		DOC_VER_CAC = dOC_VER_CAC;
	}

	


}
