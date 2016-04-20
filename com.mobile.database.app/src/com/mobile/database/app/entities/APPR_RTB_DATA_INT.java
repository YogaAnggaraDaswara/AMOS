package com.mobile.database.app.entities;

import java.util.Date;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="APPR_RTB_DATA_INT")
public class APPR_RTB_DATA_INT {
	@DatabaseField(id=true,unique=true,canBeNull=false,uniqueIndexName="APPR_RTB_DATA_INT_PK",dataType=DataType.STRING,width=16) private String COL_ID;
	@DatabaseField(dataType=DataType.STRING,width=20) private String AP_REGNO;
	@DatabaseField(dataType=DataType.STRING,width=10) private String COL_CRITERIA;
	@DatabaseField(dataType=DataType.STRING,width=10) private String COL_TYPE;
	@DatabaseField(dataType=DataType.STRING,width=10) private String COL_DESC;
	@DatabaseField(dataType=DataType.STRING,width=1) private String COL_STATUS;
	@DatabaseField(dataType=DataType.STRING,width=10) private String DEVELOPER;
	@DatabaseField(dataType=DataType.STRING,width=10) private String PROJECT_NAME;
	@DatabaseField(dataType=DataType.STRING,width=10) private String ROAD_TYPE;
	@DatabaseField(dataType=DataType.STRING,width=4) private String ROAD_WIDTH;
	@DatabaseField(dataType=DataType.STRING,width=10) private String TRAFFIC;
	@DatabaseField(dataType=DataType.STRING,width=10) private String SOCIETY;
	@DatabaseField(dataType=DataType.STRING,width=10) private String AREA_LOCATION;
	@DatabaseField(dataType=DataType.STRING,width=10) private String AREA_NEARBY;
	@DatabaseField(dataType=DataType.STRING,width=10) private String AREA_COND;
	@DatabaseField(dataType=DataType.STRING,width=10) private String BUILDING_NEARBY_COND;
	@DatabaseField(dataType=DataType.STRING,width=10) private String LOCATION;
	@DatabaseField(dataType=DataType.STRING,width=1) private String INSURANCE;
	@DatabaseField(dataType=DataType.STRING,width=200) private String COL_ADDR1;
	@DatabaseField(dataType=DataType.STRING,width=200) private String COL_ADDR2;
	@DatabaseField(dataType=DataType.STRING,width=200) private String COL_ADDR3;
	@DatabaseField(dataType=DataType.STRING,width=10) private String COL_RT;
	@DatabaseField(dataType=DataType.STRING,width=10) private String COL_RW;
	@DatabaseField(dataType=DataType.STRING,width=8) private String COL_ZIPCODE;
	@DatabaseField(dataType=DataType.STRING,width=50) private String COL_KELURAHAN;
	@DatabaseField(dataType=DataType.STRING,width=50) private String COL_KECAMATAN;
	@DatabaseField(dataType=DataType.STRING,width=50) private String COL_KABUPATEN;
	@DatabaseField(dataType=DataType.STRING,width=50) private String COL_CITY;
	@DatabaseField(dataType=DataType.STRING,width=50) private String COL_PROVINCE;
	@DatabaseField(dataType=DataType.STRING,width=10) private String COL_AREACODE;
	@DatabaseField(dataType=DataType.STRING,width=1) private String FAS_TEMPAT_IBADAH;
	@DatabaseField(dataType=DataType.STRING,width=1) private String FAS_HOSPITAL;
	@DatabaseField(dataType=DataType.STRING,width=1) private String FAS_SCHOOL;
	@DatabaseField(dataType=DataType.STRING,width=1) private String FAS_MARKET;
	@DatabaseField(dataType=DataType.STRING,width=1) private String FAS_SPORT;
	@DatabaseField(dataType=DataType.STRING,width=1) private String FAS_MALL;
	@DatabaseField(dataType=DataType.STRING,width=1) private String FAS_GOVERNMENT;
	@DatabaseField(dataType=DataType.STRING,width=1) private String FAS_POLICE;
	@DatabaseField(dataType=DataType.STRING,width=1) private String FAS_PHONEBOX;
	@DatabaseField(dataType=DataType.STRING,width=1) private String FAS_CINEMA;
	@DatabaseField(dataType=DataType.STRING,width=100) private String FAS_TRANSPORTATION;
	@DatabaseField(dataType=DataType.STRING,width=8) private String FAS_TRANSPORTATION_DISTANCE;
	@DatabaseField(dataType=DataType.STRING,width=1) private String FAS_OTHER;
	@DatabaseField(dataType=DataType.STRING,width=1) private String NEG_SMALLROAD;
	@DatabaseField(dataType=DataType.STRING,width=1) private String NEG_HELI_LAND;
	@DatabaseField(dataType=DataType.STRING,width=1) private String NEG_NEAR_ELECTRIC;
	@DatabaseField(dataType=DataType.STRING,width=1) private String NEG_FLOOD;
	@DatabaseField(dataType=DataType.STRING,width=1) private String NEG_EVICTION;
	@DatabaseField(dataType=DataType.STRING,width=1) private String NEG_GENERAL_FACILITIES;
	@DatabaseField(dataType=DataType.STRING,width=1) private String NEG_FUNERAL;
	@DatabaseField(dataType=DataType.STRING,width=1) private String NEG_TPA;
	@DatabaseField(dataType=DataType.STRING,width=1) private String NEG_ZONING;
	@DatabaseField(dataType=DataType.STRING,width=1) private String NEG_SEA;
	@DatabaseField(dataType=DataType.STRING,width=1) private String NEG_RAIL;
	@DatabaseField(dataType=DataType.STRING,width=1) private String NEG_CULTURAL;
	@DatabaseField(dataType=DataType.STRING,width=50) private String INSPECTION_PERSON;
	@DatabaseField(dataType=DataType.STRING,width=1) private String INSPECTION_BUSINESSUNIT;
	@DatabaseField(dataType=DataType.STRING,width=200) private String TAXAXY_OPINION;
	@DatabaseField(dataType=DataType.STRING,width=16) private String OTHER_INFO;
	@DatabaseField(dataType=DataType.STRING,width=10) private String COL_CLASS;
	@DatabaseField(dataType=DataType.STRING,width=10) private String NEGATIVELIST;
	
	public String getNEGATIVELIST() {
		return NEGATIVELIST;
	}
	public void setNEGATIVELIST(String nEGATIVELIST) {
		NEGATIVELIST = nEGATIVELIST;
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
	public String getCOL_CRITERIA() {
		return COL_CRITERIA;
	}
	public void setCOL_CRITERIA(String cOL_CRITERIA) {
		COL_CRITERIA = cOL_CRITERIA;
	}
	public String getCOL_TYPE() {
		return COL_TYPE;
	}
	public void setCOL_TYPE(String cOL_TYPE) {
		COL_TYPE = cOL_TYPE;
	}
	public String getCOL_DESC() {
		return COL_DESC;
	}
	public void setCOL_DESC(String cOL_DESC) {
		COL_DESC = cOL_DESC;
	}
	public String getCOL_STATUS() {
		return COL_STATUS;
	}
	public void setCOL_STATUS(String cOL_STATUS) {
		COL_STATUS = cOL_STATUS;
	}
	public String getDEVELOPER() {
		return DEVELOPER;
	}
	public void setDEVELOPER(String dEVELOPER) {
		DEVELOPER = dEVELOPER;
	}
	public String getPROJECT_NAME() {
		return PROJECT_NAME;
	}
	public void setPROJECT_NAME(String pROJECT_NAME) {
		PROJECT_NAME = pROJECT_NAME;
	}
	public String getROAD_TYPE() {
		return ROAD_TYPE;
	}
	public void setROAD_TYPE(String rOAD_TYPE) {
		ROAD_TYPE = rOAD_TYPE;
	}
	public String getROAD_WIDTH() {
		return ROAD_WIDTH;
	}
	public void setROAD_WIDTH(String rOAD_WIDTH) {
		ROAD_WIDTH = rOAD_WIDTH;
	}
	public String getTRAFFIC() {
		return TRAFFIC;
	}
	public void setTRAFFIC(String tRAFFIC) {
		TRAFFIC = tRAFFIC;
	}
	public String getSOCIETY() {
		return SOCIETY;
	}
	public void setSOCIETY(String sOCIETY) {
		SOCIETY = sOCIETY;
	}
	public String getAREA_LOCATION() {
		return AREA_LOCATION;
	}
	public void setAREA_LOCATION(String aREA_LOCATION) {
		AREA_LOCATION = aREA_LOCATION;
	}
	public String getAREA_NEARBY() {
		return AREA_NEARBY;
	}
	public void setAREA_NEARBY(String aREA_NEARBY) {
		AREA_NEARBY = aREA_NEARBY;
	}
	public String getAREA_COND() {
		return AREA_COND;
	}
	public void setAREA_COND(String aREA_COND) {
		AREA_COND = aREA_COND;
	}
	public String getBUILDING_NEARBY_COND() {
		return BUILDING_NEARBY_COND;
	}
	public void setBUILDING_NEARBY_COND(String bUILDING_NEARBY_COND) {
		BUILDING_NEARBY_COND = bUILDING_NEARBY_COND;
	}
	public String getLOCATION() {
		return LOCATION;
	}
	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
	}
	public String getINSURANCE() {
		return INSURANCE;
	}
	public void setINSURANCE(String iNSURANCE) {
		INSURANCE = iNSURANCE;
	}
	public String getCOL_ADDR1() {
		return COL_ADDR1;
	}
	public void setCOL_ADDR1(String cOL_ADDR1) {
		COL_ADDR1 = cOL_ADDR1;
	}
	public String getCOL_ADDR2() {
		return COL_ADDR2;
	}
	public void setCOL_ADDR2(String cOL_ADDR2) {
		COL_ADDR2 = cOL_ADDR2;
	}
	public String getCOL_ADDR3() {
		return COL_ADDR3;
	}
	public void setCOL_ADDR3(String cOL_ADDR3) {
		COL_ADDR3 = cOL_ADDR3;
	}
	public String getCOL_RT() {
		return COL_RT;
	}
	public void setCOL_RT(String cOL_RT) {
		COL_RT = cOL_RT;
	}
	public String getCOL_RW() {
		return COL_RW;
	}
	public void setCOL_RW(String cOL_RW) {
		COL_RW = cOL_RW;
	}
	public String getCOL_ZIPCODE() {
		return COL_ZIPCODE;
	}
	public void setCOL_ZIPCODE(String cOL_ZIPCODE) {
		COL_ZIPCODE = cOL_ZIPCODE;
	}
	public String getCOL_KELURAHAN() {
		return COL_KELURAHAN;
	}
	public void setCOL_KELURAHAN(String cOL_KELURAHAN) {
		COL_KELURAHAN = cOL_KELURAHAN;
	}
	public String getCOL_KECAMATAN() {
		return COL_KECAMATAN;
	}
	public void setCOL_KECAMATAN(String cOL_KECAMATAN) {
		COL_KECAMATAN = cOL_KECAMATAN;
	}
	public String getCOL_KABUPATEN() {
		return COL_KABUPATEN;
	}
	public void setCOL_KABUPATEN(String cOL_KABUPATEN) {
		COL_KABUPATEN = cOL_KABUPATEN;
	}
	public String getCOL_CITY() {
		return COL_CITY;
	}
	public void setCOL_CITY(String cOL_CITY) {
		COL_CITY = cOL_CITY;
	}
	public String getCOL_PROVINCE() {
		return COL_PROVINCE;
	}
	public void setCOL_PROVINCE(String cOL_PROVINCE) {
		COL_PROVINCE = cOL_PROVINCE;
	}
	public String getCOL_AREACODE() {
		return COL_AREACODE;
	}
	public void setCOL_AREACODE(String cOL_AREACODE) {
		COL_AREACODE = cOL_AREACODE;
	}
	public String getFAS_TEMPAT_IBADAH() {
		return FAS_TEMPAT_IBADAH;
	}
	public void setFAS_TEMPAT_IBADAH(String fAS_TEMPAT_IBADAH) {
		FAS_TEMPAT_IBADAH = fAS_TEMPAT_IBADAH;
	}
	public String getFAS_HOSPITAL() {
		return FAS_HOSPITAL;
	}
	public void setFAS_HOSPITAL(String fAS_HOSPITAL) {
		FAS_HOSPITAL = fAS_HOSPITAL;
	}
	public String getFAS_SCHOOL() {
		return FAS_SCHOOL;
	}
	public void setFAS_SCHOOL(String fAS_SCHOOL) {
		FAS_SCHOOL = fAS_SCHOOL;
	}
	public String getFAS_MARKET() {
		return FAS_MARKET;
	}
	public void setFAS_MARKET(String fAS_MARKET) {
		FAS_MARKET = fAS_MARKET;
	}
	public String getFAS_SPORT() {
		return FAS_SPORT;
	}
	public void setFAS_SPORT(String fAS_SPORT) {
		FAS_SPORT = fAS_SPORT;
	}
	public String getFAS_MALL() {
		return FAS_MALL;
	}
	public void setFAS_MALL(String fAS_MALL) {
		FAS_MALL = fAS_MALL;
	}
	public String getFAS_GOVERNMENT() {
		return FAS_GOVERNMENT;
	}
	public void setFAS_GOVERNMENT(String fAS_GOVERNMENT) {
		FAS_GOVERNMENT = fAS_GOVERNMENT;
	}
	public String getFAS_POLICE() {
		return FAS_POLICE;
	}
	public void setFAS_POLICE(String fAS_POLICE) {
		FAS_POLICE = fAS_POLICE;
	}
	public String getFAS_PHONEBOX() {
		return FAS_PHONEBOX;
	}
	public void setFAS_PHONEBOX(String fAS_PHONEBOX) {
		FAS_PHONEBOX = fAS_PHONEBOX;
	}
	public String getFAS_CINEMA() {
		return FAS_CINEMA;
	}
	public void setFAS_CINEMA(String fAS_CINEMA) {
		FAS_CINEMA = fAS_CINEMA;
	}
	public String getFAS_TRANSPORTATION() {
		return FAS_TRANSPORTATION;
	}
	public void setFAS_TRANSPORTATION(String fAS_TRANSPORTATION) {
		FAS_TRANSPORTATION = fAS_TRANSPORTATION;
	}
	public String getFAS_TRANSPORTATION_DISTANCE() {
		return FAS_TRANSPORTATION_DISTANCE;
	}
	public void setFAS_TRANSPORTATION_DISTANCE(String fAS_TRANSPORTATION_DISTANCE) {
		FAS_TRANSPORTATION_DISTANCE = fAS_TRANSPORTATION_DISTANCE;
	}
	public String getFAS_OTHER() {
		return FAS_OTHER;
	}
	public void setFAS_OTHER(String fAS_OTHER) {
		FAS_OTHER = fAS_OTHER;
	}
	public String getNEG_SMALLROAD() {
		return NEG_SMALLROAD;
	}
	public void setNEG_SMALLROAD(String nEG_SMALLROAD) {
		NEG_SMALLROAD = nEG_SMALLROAD;
	}
	public String getNEG_HELI_LAND() {
		return NEG_HELI_LAND;
	}
	public void setNEG_HELI_LAND(String nEG_HELI_LAND) {
		NEG_HELI_LAND = nEG_HELI_LAND;
	}
	public String getNEG_NEAR_ELECTRIC() {
		return NEG_NEAR_ELECTRIC;
	}
	public void setNEG_NEAR_ELECTRIC(String nEG_NEAR_ELECTRIC) {
		NEG_NEAR_ELECTRIC = nEG_NEAR_ELECTRIC;
	}
	public String getNEG_FLOOD() {
		return NEG_FLOOD;
	}
	public void setNEG_FLOOD(String nEG_FLOOD) {
		NEG_FLOOD = nEG_FLOOD;
	}
	public String getNEG_EVICTION() {
		return NEG_EVICTION;
	}
	public void setNEG_EVICTION(String nEG_EVICTION) {
		NEG_EVICTION = nEG_EVICTION;
	}
	public String getNEG_GENERAL_FACILITIES() {
		return NEG_GENERAL_FACILITIES;
	}
	public void setNEG_GENERAL_FACILITIES(String nEG_GENERAL_FACILITIES) {
		NEG_GENERAL_FACILITIES = nEG_GENERAL_FACILITIES;
	}
	public String getNEG_FUNERAL() {
		return NEG_FUNERAL;
	}
	public void setNEG_FUNERAL(String nEG_FUNERAL) {
		NEG_FUNERAL = nEG_FUNERAL;
	}
	public String getNEG_TPA() {
		return NEG_TPA;
	}
	public void setNEG_TPA(String nEG_TPA) {
		NEG_TPA = nEG_TPA;
	}
	public String getNEG_ZONING() {
		return NEG_ZONING;
	}
	public void setNEG_ZONING(String nEG_ZONING) {
		NEG_ZONING = nEG_ZONING;
	}
	public String getNEG_SEA() {
		return NEG_SEA;
	}
	public void setNEG_SEA(String nEG_SEA) {
		NEG_SEA = nEG_SEA;
	}
	public String getNEG_RAIL() {
		return NEG_RAIL;
	}
	public void setNEG_RAIL(String nEG_RAIL) {
		NEG_RAIL = nEG_RAIL;
	}
	public String getNEG_CULTURAL() {
		return NEG_CULTURAL;
	}
	public void setNEG_CULTURAL(String nEG_CULTURAL) {
		NEG_CULTURAL = nEG_CULTURAL;
	}
	public String getINSPECTION_PERSON() {
		return INSPECTION_PERSON;
	}
	public void setINSPECTION_PERSON(String iNSPECTION_PERSON) {
		INSPECTION_PERSON = iNSPECTION_PERSON;
	}
	public String getINSPECTION_BUSINESSUNIT() {
		return INSPECTION_BUSINESSUNIT;
	}
	public void setINSPECTION_BUSINESSUNIT(String iNSPECTION_BUSINESSUNIT) {
		INSPECTION_BUSINESSUNIT = iNSPECTION_BUSINESSUNIT;
	}
	public String getTAXAXY_OPINION() {
		return TAXAXY_OPINION;
	}
	public void setTAXAXY_OPINION(String tAXAXY_OPINION) {
		TAXAXY_OPINION = tAXAXY_OPINION;
	}
	public String getOTHER_INFO() {
		return OTHER_INFO;
	}
	public void setOTHER_INFO(String oTHER_INFO) {
		OTHER_INFO = oTHER_INFO;
	}
	public String getCOL_CLASS() {
		return COL_CLASS;
	}
	public void setCOL_CLASS(String cOL_CLASS) {
		COL_CLASS = cOL_CLASS;
	}



}
