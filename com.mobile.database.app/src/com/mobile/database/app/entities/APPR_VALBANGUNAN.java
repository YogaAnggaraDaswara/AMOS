package com.mobile.database.app.entities;

import java.util.Date;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="APPR_VALBANGUNAN")
public class APPR_VALBANGUNAN {
	@DatabaseField(id=true,unique=true,canBeNull=false,uniqueIndexName="APPR_VALBANGUNAN_PK",dataType=DataType.STRING) private String ID;
	@DatabaseField(dataType=DataType.STRING,width=100) private String COL_ID;
	@DatabaseField(dataType=DataType.STRING,width=10) private String BUILD_SEQ;
	@DatabaseField(dataType=DataType.STRING,width=10) private String BUILDING_TYPE;
	@DatabaseField(dataType=DataType.STRING,width=10) private String BUILD_AREA_FISIK;
	@DatabaseField(dataType=DataType.STRING,width=10) private String BUILD_AREA_IMB;
	@DatabaseField(dataType=DataType.STRING,width=10) private String BUILD_LIQ_PCT_FISIK;
	@DatabaseField(dataType=DataType.STRING,width=10) private String BUILD_LIQ_PCT_IMB;
	@DatabaseField(dataType=DataType.STRING,width=10) private String BUILD_LIQ_VALUE_FISIK;
	@DatabaseField(dataType=DataType.STRING,width=10) private String BUILD_LIQ_VALUE_IMB;
	@DatabaseField(dataType=DataType.STRING,width=10) private String BUILD_MARKET_VALUE_FISIK;
	@DatabaseField(dataType=DataType.STRING,width=10) private String BUILD_MARKET_VALUE_IMB;
	@DatabaseField(dataType=DataType.STRING,width=10) private String BUILD_PERMETER_VALUE;
	@DatabaseField(dataType=DataType.STRING,width=50) private String BUILD_LAND_AREA_AFTER_POTONG;
	
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
