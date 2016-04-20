package com.mobile.database.app.entities;

import java.util.Date;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="APPR_RTB_DETAIL_INT")
public class APPR_RTB_DETAIL_INT {
	@DatabaseField(id=true,unique=true,canBeNull=false,uniqueIndexName="APPR_RTB_DETAIL_INT_PK",dataType=DataType.STRING,width=16) private String COL_ID;
	@DatabaseField(dataType=DataType.STRING,width=20) private String AP_REGNO;
	@DatabaseField(dataType=DataType.STRING,width=50) private String CERTIFICATE_NAME;
	@DatabaseField(dataType=DataType.STRING,width=20) private String CERTIFCATE_NO;
	@DatabaseField(dataType=DataType.STRING,width=10) private String CERTIFICATE_TYPE;
	@DatabaseField(dataType=DataType.STRING,width=8) private String CERTIFICATE_EXPIRE;
	@DatabaseField(dataType=DataType.STRING,width=10) private String RELATIONSHIP_DEBITUR;
	@DatabaseField(dataType=DataType.STRING,width=8) private String LAND_AREA;
	@DatabaseField(dataType=DataType.STRING,width=4) private String LAND_LENGTH;
	@DatabaseField(dataType=DataType.STRING,width=4) private String LAND_WIDTH;
	@DatabaseField(dataType=DataType.STRING,width=50) private String NORTH_BOUNDARY;
	@DatabaseField(dataType=DataType.STRING,width=50) private String SOUTH_BOUNDARY;
	@DatabaseField(dataType=DataType.STRING,width=10) private String LAND_SHAPE;
	@DatabaseField(dataType=DataType.STRING,width=50) private String LAND_SHAPE_DESC;
	@DatabaseField(dataType=DataType.STRING,width=10) private String LAND_CONTOUR;
	@DatabaseField(dataType=DataType.STRING,width=50) private String LAND_CONTOUR_DESC;
	@DatabaseField(dataType=DataType.STRING,width=10) private String LAND_PURPOSE;
	@DatabaseField(dataType=DataType.STRING,width=10) private String PYSHIC_LAND;
	@DatabaseField(dataType=DataType.STRING,width=50) private String PYSHIC_LAND_DESC;
	@DatabaseField(dataType=DataType.STRING,width=10) private String RANGE_ROAD;
	@DatabaseField(dataType=DataType.STRING,width=50) private String EAST_BOUNDARY;
	@DatabaseField(dataType=DataType.STRING,width=50) private String WEST_BOUNDARY;
	@DatabaseField(dataType=DataType.STRING,width=10) private String BUILDING_TYPE;
	@DatabaseField(dataType=DataType.STRING,width=10) private String BUILDING_CONDITION;
	@DatabaseField(dataType=DataType.STRING,width=10) private String BUILDING_CHARACTERISTIC;
	@DatabaseField(dataType=DataType.STRING,width=8) private String BUILDING_AREA;
	@DatabaseField(dataType=DataType.STRING,width=4) private String BUILDING_LENGTH;
	@DatabaseField(dataType=DataType.STRING,width=4) private String BUILDING_WIDTH;
	@DatabaseField(dataType=DataType.STRING,width=10) private String CONST_INTI;
	@DatabaseField(dataType=DataType.STRING,width=10) private String CONST_FLOOR;
	@DatabaseField(dataType=DataType.STRING,width=10) private String CONST_WALL;
	@DatabaseField(dataType=DataType.STRING,width=10) private String CONST_CEILING;
	@DatabaseField(dataType=DataType.STRING,width=10) private String CONST_ROOF;
	@DatabaseField(dataType=DataType.STRING,width=10) private String CONST_WINDOW;
	@DatabaseField(dataType=DataType.STRING,width=10) private String CONST_PARTITION;
	@DatabaseField(dataType=DataType.STRING,width=8) private String AVAIL_PLN;
	@DatabaseField(dataType=DataType.STRING,width=8) private String AVAIL_GENSET;
	@DatabaseField(dataType=DataType.STRING,width=10) private String AVAIL_PDAM;
	@DatabaseField(dataType=DataType.STRING,width=50) private String AVAIL_PDAM_DESC;
	@DatabaseField(dataType=DataType.STRING,width=10) private String AVAIL_PHONE;
	@DatabaseField(dataType=DataType.STRING,width=50) private String IMB_NAME;
	@DatabaseField(dataType=DataType.STRING,width=20) private String IMB_NO;
	@DatabaseField(dataType=DataType.STRING,width=8) private String IMB_DATE;
	@DatabaseField(dataType=DataType.STRING,width=50) private String IMB_CREATED_PLACE;
	@DatabaseField(dataType=DataType.STRING,width=200) private String IMB_PURPOSE;
	@DatabaseField(dataType=DataType.STRING,width=200) private String PURPOSE_NOT_IMB;
	@DatabaseField(dataType=DataType.STRING,width=8) private String CONST_PROGRESS;
	@DatabaseField(dataType=DataType.STRING,width=8) private String CONST_LANTAI;
	@DatabaseField(dataType=DataType.STRING,width=10) private String AVAIL_AIR;
	@DatabaseField(dataType=DataType.STRING,width=5) private String CONST_TAHUN;
	@DatabaseField(dataType=DataType.STRING,width=8) private String RANGE_WIDTH;
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
	public String getCERTIFICATE_NAME() {
		return CERTIFICATE_NAME;
	}
	public void setCERTIFICATE_NAME(String cERTIFICATE_NAME) {
		CERTIFICATE_NAME = cERTIFICATE_NAME;
	}
	public String getCERTIFCATE_NO() {
		return CERTIFCATE_NO;
	}
	public void setCERTIFCATE_NO(String cERTIFCATE_NO) {
		CERTIFCATE_NO = cERTIFCATE_NO;
	}
	public String getCERTIFICATE_TYPE() {
		return CERTIFICATE_TYPE;
	}
	public void setCERTIFICATE_TYPE(String cERTIFICATE_TYPE) {
		CERTIFICATE_TYPE = cERTIFICATE_TYPE;
	}
	public Date getCERTIFICATE_EXPIRE() {
		return DataConverter.stringToDate(CERTIFICATE_EXPIRE);
	}
	public void setCERTIFICATE_EXPIRE(Date cERTIFICATE_EXPIRE) {
		CERTIFICATE_EXPIRE = DataConverter.dateToString(cERTIFICATE_EXPIRE);
	}
	public String getRELATIONSHIP_DEBITUR() {
		return RELATIONSHIP_DEBITUR;
	}
	public void setRELATIONSHIP_DEBITUR(String rELATIONSHIP_DEBITUR) {
		RELATIONSHIP_DEBITUR = rELATIONSHIP_DEBITUR;
	}
	public String getLAND_AREA() {
		return LAND_AREA;
	}
	public void setLAND_AREA(String lAND_AREA) {
		LAND_AREA = lAND_AREA;
	}
	public String getLAND_LENGTH() {
		return LAND_LENGTH;
	}
	public void setLAND_LENGTH(String lAND_LENGTH) {
		LAND_LENGTH = lAND_LENGTH;
	}
	public String getLAND_WIDTH() {
		return LAND_WIDTH;
	}
	public void setLAND_WIDTH(String lAND_WIDTH) {
		LAND_WIDTH = lAND_WIDTH;
	}
	public String getNORTH_BOUNDARY() {
		return NORTH_BOUNDARY;
	}
	public void setNORTH_BOUNDARY(String nORTH_BOUNDARY) {
		NORTH_BOUNDARY = nORTH_BOUNDARY;
	}
	public String getSOUTH_BOUNDARY() {
		return SOUTH_BOUNDARY;
	}
	public void setSOUTH_BOUNDARY(String sOUTH_BOUNDARY) {
		SOUTH_BOUNDARY = sOUTH_BOUNDARY;
	}
	public String getLAND_SHAPE() {
		return LAND_SHAPE;
	}
	public void setLAND_SHAPE(String lAND_SHAPE) {
		LAND_SHAPE = lAND_SHAPE;
	}
	public String getLAND_SHAPE_DESC() {
		return LAND_SHAPE_DESC;
	}
	public void setLAND_SHAPE_DESC(String lAND_SHAPE_DESC) {
		LAND_SHAPE_DESC = lAND_SHAPE_DESC;
	}
	public String getLAND_CONTOUR() {
		return LAND_CONTOUR;
	}
	public void setLAND_CONTOUR(String lAND_CONTOUR) {
		LAND_CONTOUR = lAND_CONTOUR;
	}
	public String getLAND_CONTOUR_DESC() {
		return LAND_CONTOUR_DESC;
	}
	public void setLAND_CONTOUR_DESC(String lAND_CONTOUR_DESC) {
		LAND_CONTOUR_DESC = lAND_CONTOUR_DESC;
	}
	public String getLAND_PURPOSE() {
		return LAND_PURPOSE;
	}
	public void setLAND_PURPOSE(String lAND_PURPOSE) {
		LAND_PURPOSE = lAND_PURPOSE;
	}
	public String getPYSHIC_LAND() {
		return PYSHIC_LAND;
	}
	public void setPYSHIC_LAND(String pYSHIC_LAND) {
		PYSHIC_LAND = pYSHIC_LAND;
	}
	public String getPYSHIC_LAND_DESC() {
		return PYSHIC_LAND_DESC;
	}
	public void setPYSHIC_LAND_DESC(String pYSHIC_LAND_DESC) {
		PYSHIC_LAND_DESC = pYSHIC_LAND_DESC;
	}
	public String getRANGE_ROAD() {
		return RANGE_ROAD;
	}
	public void setRANGE_ROAD(String rANGE_ROAD) {
		RANGE_ROAD = rANGE_ROAD;
	}
	public String getEAST_BOUNDARY() {
		return EAST_BOUNDARY;
	}
	public void setEAST_BOUNDARY(String eAST_BOUNDARY) {
		EAST_BOUNDARY = eAST_BOUNDARY;
	}
	public String getWEST_BOUNDARY() {
		return WEST_BOUNDARY;
	}
	public void setWEST_BOUNDARY(String wEST_BOUNDARY) {
		WEST_BOUNDARY = wEST_BOUNDARY;
	}
	public String getBUILDING_TYPE() {
		return BUILDING_TYPE;
	}
	public void setBUILDING_TYPE(String bUILDING_TYPE) {
		BUILDING_TYPE = bUILDING_TYPE;
	}
	public String getBUILDING_CONDITION() {
		return BUILDING_CONDITION;
	}
	public void setBUILDING_CONDITION(String bUILDING_CONDITION) {
		BUILDING_CONDITION = bUILDING_CONDITION;
	}
	public String getBUILDING_CHARACTERISTIC() {
		return BUILDING_CHARACTERISTIC;
	}
	public void setBUILDING_CHARACTERISTIC(String bUILDING_CHARACTERISTIC) {
		BUILDING_CHARACTERISTIC = bUILDING_CHARACTERISTIC;
	}
	public String getBUILDING_AREA() {
		return BUILDING_AREA;
	}
	public void setBUILDING_AREA(String bUILDING_AREA) {
		BUILDING_AREA = bUILDING_AREA;
	}
	public String getBUILDING_LENGTH() {
		return BUILDING_LENGTH;
	}
	public void setBUILDING_LENGTH(String bUILDING_LENGTH) {
		BUILDING_LENGTH = bUILDING_LENGTH;
	}
	public String getBUILDING_WIDTH() {
		return BUILDING_WIDTH;
	}
	public void setBUILDING_WIDTH(String bUILDING_WIDTH) {
		BUILDING_WIDTH = bUILDING_WIDTH;
	}
	public String getCONST_INTI() {
		return CONST_INTI;
	}
	public void setCONST_INTI(String cONST_INTI) {
		CONST_INTI = cONST_INTI;
	}
	public String getCONST_FLOOR() {
		return CONST_FLOOR;
	}
	public void setCONST_FLOOR(String cONST_FLOOR) {
		CONST_FLOOR = cONST_FLOOR;
	}
	public String getCONST_WALL() {
		return CONST_WALL;
	}
	public void setCONST_WALL(String cONST_WALL) {
		CONST_WALL = cONST_WALL;
	}
	public String getCONST_CEILING() {
		return CONST_CEILING;
	}
	public void setCONST_CEILING(String cONST_CEILING) {
		CONST_CEILING = cONST_CEILING;
	}
	public String getCONST_ROOF() {
		return CONST_ROOF;
	}
	public void setCONST_ROOF(String cONST_ROOF) {
		CONST_ROOF = cONST_ROOF;
	}
	public String getCONST_WINDOW() {
		return CONST_WINDOW;
	}
	public void setCONST_WINDOW(String cONST_WINDOW) {
		CONST_WINDOW = cONST_WINDOW;
	}
	public String getCONST_PARTITION() {
		return CONST_PARTITION;
	}
	public void setCONST_PARTITION(String cONST_PARTITION) {
		CONST_PARTITION = cONST_PARTITION;
	}
	public String getAVAIL_PLN() {
		return AVAIL_PLN;
	}
	public void setAVAIL_PLN(String aVAIL_PLN) {
		AVAIL_PLN = aVAIL_PLN;
	}
	public String getAVAIL_GENSET() {
		return AVAIL_GENSET;
	}
	public void setAVAIL_GENSET(String aVAIL_GENSET) {
		AVAIL_GENSET = aVAIL_GENSET;
	}
	public String getAVAIL_PDAM() {
		return AVAIL_PDAM;
	}
	public void setAVAIL_PDAM(String aVAIL_PDAM) {
		AVAIL_PDAM = aVAIL_PDAM;
	}
	public String getAVAIL_PDAM_DESC() {
		return AVAIL_PDAM_DESC;
	}
	public void setAVAIL_PDAM_DESC(String aVAIL_PDAM_DESC) {
		AVAIL_PDAM_DESC = aVAIL_PDAM_DESC;
	}
	public String getAVAIL_PHONE() {
		return AVAIL_PHONE;
	}
	public void setAVAIL_PHONE(String aVAIL_PHONE) {
		AVAIL_PHONE = aVAIL_PHONE;
	}
	public String getIMB_NAME() {
		return IMB_NAME;
	}
	public void setIMB_NAME(String iMB_NAME) {
		IMB_NAME = iMB_NAME;
	}
	public String getIMB_NO() {
		return IMB_NO;
	}
	public void setIMB_NO(String iMB_NO) {
		IMB_NO = iMB_NO;
	}
	public String getIMB_DATE() {
		return IMB_DATE;
	}
	public void setIMB_DATE(String iMB_DATE) {
		IMB_DATE = iMB_DATE;
	}
	public String getIMB_CREATED_PLACE() {
		return IMB_CREATED_PLACE;
	}
	public void setIMB_CREATED_PLACE(String iMB_CREATED_PLACE) {
		IMB_CREATED_PLACE = iMB_CREATED_PLACE;
	}
	public String getIMB_PURPOSE() {
		return IMB_PURPOSE;
	}
	public void setIMB_PURPOSE(String iMB_PURPOSE) {
		IMB_PURPOSE = iMB_PURPOSE;
	}
	public String getPURPOSE_NOT_IMB() {
		return PURPOSE_NOT_IMB;
	}
	public void setPURPOSE_NOT_IMB(String pURPOSE_NOT_IMB) {
		PURPOSE_NOT_IMB = pURPOSE_NOT_IMB;
	}
	public String getCONST_PROGRESS() {
		return CONST_PROGRESS;
	}
	public void setCONST_PROGRESS(String cONST_PROGRESS) {
		CONST_PROGRESS = cONST_PROGRESS;
	}
	public String getCONST_LANTAI() {
		return CONST_LANTAI;
	}
	public void setCONST_LANTAI(String cONST_LANTAI) {
		CONST_LANTAI = cONST_LANTAI;
	}
	public String getAVAIL_AIR() {
		return AVAIL_AIR;
	}
	public void setAVAIL_AIR(String aVAIL_AIR) {
		AVAIL_AIR = aVAIL_AIR;
	}
	public String getCONST_TAHUN() {
		return CONST_TAHUN;
	}
	public void setCONST_TAHUN(String cONST_TAHUN) {
		CONST_TAHUN = cONST_TAHUN;
	}
	public String getRANGE_WIDTH() {
		return RANGE_WIDTH;
	}
	public void setRANGE_WIDTH(String rANGE_WIDTH) {
		RANGE_WIDTH = rANGE_WIDTH;
	}



}
