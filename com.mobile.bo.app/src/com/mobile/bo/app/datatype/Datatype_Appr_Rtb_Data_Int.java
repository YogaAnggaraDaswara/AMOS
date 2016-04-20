package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

import com.mobile.database.app.entities.APPR_MAIN;
import com.mobile.database.app.entities.APPR_RTB_DATA_INT;
import com.mobile.database.app.entities.APPR_RTB_VALUATION_INT;
import com.mobile.database.app.entities.BLACKBOX;

public class Datatype_Appr_Rtb_Data_Int implements Serializable {

	/**
	 * 
	 */
	public String COL_ID;
	public String AP_REGNO;
	public String COL_CRITERIA;
	public String COL_TYPE;
	public String COL_DESC;
	public String COL_STATUS;
	public String DEVELOPER;
	public String PROJECT_NAME;
	public String ROAD_TYPE;
	public String ROAD_WIDTH;
	public String TRAFFIC;
	public String SOCIETY;
	public String AREA_LOCATION;
	public String AREA_NEARBY;
	public String AREA_COND;
	public String BUILDING_NEARBY_COND;
	public String LOCATION;
	public String INSURANCE;
	public String COL_ADDR1;
	public String COL_ADDR2;
	public String COL_ADDR3;
	public String COL_RT;
	public String COL_RW;
	public String COL_ZIPCODE;
	public String COL_KELURAHAN;
	public String COL_KECAMATAN;
	public String COL_KABUPATEN;
	public String COL_CITY;
	public String COL_PROVINCE;
	public String COL_AREACODE;
	public String FAS_TEMPAT_IBADAH;
	public String FAS_HOSPITAL;
	public String FAS_SCHOOL;
	public String FAS_MARKET;
	public String FAS_SPORT;
	public String FAS_MALL;
	public String FAS_GOVERNMENT;
	public String FAS_POLICE;
	public String FAS_PHONEBOX;
	public String FAS_CINEMA;
	public String FAS_TRANSPORTATION;
	public String FAS_TRANSPORTATION_DISTANCE;
	public String FAS_OTHER;
	public String NEG_SMALLROAD;
	public String NEG_HELI_LAND;
	public String NEG_NEAR_ELECTRIC;
	public String NEG_FLOOD;
	public String NEG_EVICTION;
	public String NEG_GENERAL_FACILITIES;
	public String NEG_FUNERAL;
	public String NEG_TPA;
	public String NEG_ZONING;
	public String NEG_SEA;
	public String NEG_RAIL;
	public String NEG_CULTURAL;
	public String INSPECTION_PERSON;
	public String INSPECTION_BUSINESSUNIT;
	public String TAXAXY_OPINION;
	public String OTHER_INFO;
	public String COL_CLASS;
	public String NEGATIVELIST;

   
    
	 public Datatype_Appr_Rtb_Data_Int() {
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
	    
	 public Datatype_Appr_Rtb_Data_Int(APPR_RTB_DATA_INT Data) {
			update(Data);
	}
		

	 public void updateMainFromJSON(JSONObject obj) throws Exception{
		 COL_ID=obj.getString("COL_ID");
		 AP_REGNO=obj.getString("AP_REGNO");
		 COL_CRITERIA=obj.getString("COL_CRITERIA");
		 COL_TYPE=obj.getString("COL_TYPE");
		 COL_DESC=obj.getString("COL_DESC");
		 COL_STATUS=obj.getString("COL_STATUS");
		 DEVELOPER=obj.getString("DEVELOPER");
		 PROJECT_NAME=obj.getString("PROJECT_NAME");
		 ROAD_TYPE=obj.getString("ROAD_TYPE");
		 ROAD_WIDTH=obj.getString("ROAD_WIDTH");
		 TRAFFIC=obj.getString("TRAFFIC");
		 SOCIETY=obj.getString("SOCIETY");
		 AREA_LOCATION=obj.getString("AREA_LOCATION");
		 AREA_NEARBY=obj.getString("AREA_NEARBY");
		 AREA_COND=obj.getString("AREA_COND");
		 BUILDING_NEARBY_COND=obj.getString("BUILDING_NEARBY_COND");
		 LOCATION=obj.getString("LOCATION");
		 INSURANCE=obj.getString("INSURANCE");
		 COL_ADDR1=obj.getString("COL_ADDR1");
		 COL_ADDR2=obj.getString("COL_ADDR2");
		 COL_ADDR3=obj.getString("COL_ADDR3");
		 COL_RT=obj.getString("COL_RT");
		 COL_RW=obj.getString("COL_RW");
		 COL_ZIPCODE=obj.getString("COL_ZIPCODE");
		 COL_KELURAHAN=obj.getString("COL_KELURAHAN");
		 COL_KECAMATAN=obj.getString("COL_KECAMATAN");
		 COL_KABUPATEN=obj.getString("COL_KABUPATEN");
		 COL_CITY=obj.getString("COL_CITY");
		 COL_PROVINCE=obj.getString("COL_PROVINCE");
		 COL_AREACODE=obj.getString("COL_AREACODE");
		 FAS_TEMPAT_IBADAH=obj.getString("FAS_TEMPAT_IBADAH");
		 FAS_HOSPITAL=obj.getString("FAS_HOSPITAL");
		 FAS_SCHOOL=obj.getString("FAS_SCHOOL");
		 FAS_MARKET=obj.getString("FAS_MARKET");
		 FAS_SPORT=obj.getString("FAS_SPORT");
		 FAS_MALL=obj.getString("FAS_MALL");
		 FAS_GOVERNMENT=obj.getString("FAS_GOVERNMENT");
		 FAS_POLICE=obj.getString("FAS_POLICE");
		 FAS_PHONEBOX=obj.getString("FAS_PHONEBOX");
		 FAS_CINEMA=obj.getString("FAS_CINEMA");
		 FAS_TRANSPORTATION=obj.getString("FAS_TRANSPORTATION");
		 FAS_TRANSPORTATION_DISTANCE=obj.getString("FAS_TRANSPORTATION_DISTANCE");
		 FAS_OTHER=obj.getString("FAS_OTHER");
		 NEG_SMALLROAD=obj.getString("NEG_SMALLROAD");
		 NEG_HELI_LAND=obj.getString("NEG_HELI_LAND");
		 NEG_NEAR_ELECTRIC=obj.getString("NEG_NEAR_ELECTRIC");
		 NEG_FLOOD=obj.getString("NEG_FLOOD");
		 NEG_EVICTION=obj.getString("NEG_EVICTION");
		 NEG_GENERAL_FACILITIES=obj.getString("NEG_GENERAL_FACILITIES");
		 NEG_FUNERAL=obj.getString("NEG_FUNERAL");
		 NEG_TPA=obj.getString("NEG_TPA");
		 NEG_ZONING=obj.getString("NEG_ZONING");
		 NEG_SEA=obj.getString("NEG_SEA");
		 NEG_RAIL=obj.getString("NEG_RAIL");
		 NEG_CULTURAL=obj.getString("NEG_CULTURAL");
		 INSPECTION_PERSON=obj.getString("INSPECTION_PERSON");
		 INSPECTION_BUSINESSUNIT=obj.getString("INSPECTION_BUSINESSUNIT");
		 TAXAXY_OPINION=obj.getString("TAXAXY_OPINION");
		 OTHER_INFO=obj.getString("OTHER_INFO");
		 COL_CLASS=obj.getString("COL_CLASS");
		 NEGATIVELIST=obj.getString("NEGATIVELIST");
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

	public String getNEGATIVELIST() {
		return NEGATIVELIST;
	}

	public void setNEGATIVELIST(String nEGATIVELIST) {
		NEGATIVELIST = nEGATIVELIST;
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

	public APPR_RTB_DATA_INT toRowData(){
		APPR_RTB_DATA_INT rowData= new APPR_RTB_DATA_INT();
		rowData.setCOL_ID(COL_ID);
		rowData.setAP_REGNO(AP_REGNO);
		rowData.setCOL_CRITERIA(COL_CRITERIA);
		rowData.setCOL_TYPE(COL_TYPE);
		rowData.setCOL_DESC(COL_DESC);
		rowData.setCOL_STATUS(COL_STATUS);
		rowData.setDEVELOPER(DEVELOPER);
		rowData.setPROJECT_NAME(PROJECT_NAME);
		rowData.setROAD_TYPE(ROAD_TYPE);
		rowData.setROAD_WIDTH(ROAD_WIDTH);
		rowData.setTRAFFIC(TRAFFIC);
		rowData.setSOCIETY(SOCIETY);
		rowData.setAREA_LOCATION(AREA_LOCATION);
		rowData.setAREA_NEARBY(AREA_NEARBY);
		rowData.setAREA_COND(AREA_COND);
		rowData.setBUILDING_NEARBY_COND(BUILDING_NEARBY_COND);
		rowData.setLOCATION(LOCATION);
		rowData.setINSURANCE(INSURANCE);
		rowData.setCOL_ADDR1(COL_ADDR1);
		rowData.setCOL_ADDR2(COL_ADDR2);
		rowData.setCOL_ADDR3(COL_ADDR3);
		rowData.setCOL_RT(COL_RT);
		rowData.setCOL_RW(COL_RW);
		rowData.setCOL_ZIPCODE(COL_ZIPCODE);
		rowData.setCOL_KELURAHAN(COL_KELURAHAN);
		rowData.setCOL_KECAMATAN(COL_KECAMATAN);
		rowData.setCOL_KABUPATEN(COL_KABUPATEN);
		rowData.setCOL_CITY(COL_CITY);
		rowData.setCOL_PROVINCE(COL_PROVINCE);
		rowData.setCOL_AREACODE(COL_AREACODE);
		rowData.setFAS_TEMPAT_IBADAH(FAS_TEMPAT_IBADAH);
		rowData.setFAS_HOSPITAL(FAS_HOSPITAL);
		rowData.setFAS_SCHOOL(FAS_SCHOOL);
		rowData.setFAS_MARKET(FAS_MARKET);
		rowData.setFAS_SPORT(FAS_SPORT);
		rowData.setFAS_MALL(FAS_MALL);
		rowData.setFAS_GOVERNMENT(FAS_GOVERNMENT);
		rowData.setFAS_POLICE(FAS_POLICE);
		rowData.setFAS_PHONEBOX(FAS_PHONEBOX);
		rowData.setFAS_CINEMA(FAS_CINEMA);
		rowData.setFAS_TRANSPORTATION(FAS_TRANSPORTATION);
		rowData.setFAS_TRANSPORTATION_DISTANCE(FAS_TRANSPORTATION_DISTANCE);
		rowData.setFAS_OTHER(FAS_OTHER);
		rowData.setNEG_SMALLROAD(NEG_SMALLROAD);
		rowData.setNEG_HELI_LAND(NEG_HELI_LAND);
		rowData.setNEG_NEAR_ELECTRIC(NEG_NEAR_ELECTRIC);
		rowData.setNEG_FLOOD(NEG_FLOOD);
		rowData.setNEG_EVICTION(NEG_EVICTION);
		rowData.setNEG_GENERAL_FACILITIES(NEG_GENERAL_FACILITIES);
		rowData.setNEG_FUNERAL(NEG_FUNERAL);
		rowData.setNEG_TPA(NEG_TPA);
		rowData.setNEG_ZONING(NEG_ZONING);
		rowData.setNEG_SEA(NEG_SEA);
		rowData.setNEG_RAIL(NEG_RAIL);
		rowData.setNEG_CULTURAL(NEG_CULTURAL);
		rowData.setINSPECTION_PERSON(INSPECTION_PERSON);
		rowData.setINSPECTION_BUSINESSUNIT(INSPECTION_BUSINESSUNIT);
		rowData.setTAXAXY_OPINION(TAXAXY_OPINION);
		rowData.setOTHER_INFO(OTHER_INFO);
		rowData.setCOL_CLASS(COL_CLASS);
		rowData.setNEGATIVELIST(NEGATIVELIST);
	
		return rowData;
	}
	
	public void update(APPR_RTB_DATA_INT rowData) {
		COL_ID=rowData.getCOL_ID();
		AP_REGNO=rowData.getAP_REGNO();
		COL_CRITERIA=rowData.getCOL_CRITERIA();
		COL_TYPE=rowData.getCOL_TYPE();
		COL_DESC=rowData.getCOL_DESC();
		COL_STATUS=rowData.getCOL_STATUS();
		DEVELOPER=rowData.getDEVELOPER();
		PROJECT_NAME=rowData.getPROJECT_NAME();
		ROAD_TYPE=rowData.getROAD_TYPE();
		ROAD_WIDTH=rowData.getROAD_WIDTH();
		TRAFFIC=rowData.getTRAFFIC();
		SOCIETY=rowData.getSOCIETY();
		AREA_LOCATION=rowData.getAREA_LOCATION();
		AREA_NEARBY=rowData.getAREA_NEARBY();
		AREA_COND=rowData.getAREA_COND();
		BUILDING_NEARBY_COND=rowData.getBUILDING_NEARBY_COND();
		LOCATION=rowData.getLOCATION();
		INSURANCE=rowData.getINSURANCE();
		COL_ADDR1=rowData.getCOL_ADDR1();
		COL_ADDR2=rowData.getCOL_ADDR2();
		COL_ADDR3=rowData.getCOL_ADDR3();
		COL_RT=rowData.getCOL_RT();
		COL_RW=rowData.getCOL_RW();
		COL_ZIPCODE=rowData.getCOL_ZIPCODE();
		COL_KELURAHAN=rowData.getCOL_KELURAHAN();
		COL_KECAMATAN=rowData.getCOL_KECAMATAN();
		COL_KABUPATEN=rowData.getCOL_KABUPATEN();
		COL_CITY=rowData.getCOL_CITY();
		COL_PROVINCE=rowData.getCOL_PROVINCE();
		COL_AREACODE=rowData.getCOL_AREACODE();
		FAS_TEMPAT_IBADAH=rowData.getFAS_TEMPAT_IBADAH();
		FAS_HOSPITAL=rowData.getFAS_HOSPITAL();
		FAS_SCHOOL=rowData.getFAS_SCHOOL();
		FAS_MARKET=rowData.getFAS_MARKET();
		FAS_SPORT=rowData.getFAS_SPORT();
		FAS_MALL=rowData.getFAS_MALL();
		FAS_GOVERNMENT=rowData.getFAS_GOVERNMENT();
		FAS_POLICE=rowData.getFAS_POLICE();
		FAS_PHONEBOX=rowData.getFAS_PHONEBOX();
		FAS_CINEMA=rowData.getFAS_CINEMA();
		FAS_TRANSPORTATION=rowData.getFAS_TRANSPORTATION();
		FAS_TRANSPORTATION_DISTANCE=rowData.getFAS_TRANSPORTATION_DISTANCE();
		FAS_OTHER=rowData.getFAS_OTHER();
		NEG_SMALLROAD=rowData.getNEG_SMALLROAD();
		NEG_HELI_LAND=rowData.getNEG_HELI_LAND();
		NEG_NEAR_ELECTRIC=rowData.getNEG_NEAR_ELECTRIC();
		NEG_FLOOD=rowData.getNEG_FLOOD();
		NEG_EVICTION=rowData.getNEG_EVICTION();
		NEG_GENERAL_FACILITIES=rowData.getNEG_GENERAL_FACILITIES();
		NEG_FUNERAL=rowData.getNEG_FUNERAL();
		NEG_TPA=rowData.getNEG_TPA();
		NEG_ZONING=rowData.getNEG_ZONING();
		NEG_SEA=rowData.getNEG_SEA();
		NEG_RAIL=rowData.getNEG_RAIL();
		NEG_CULTURAL=rowData.getNEG_CULTURAL();
		INSPECTION_PERSON=rowData.getINSPECTION_PERSON();
		INSPECTION_BUSINESSUNIT=rowData.getINSPECTION_BUSINESSUNIT();
		TAXAXY_OPINION=rowData.getTAXAXY_OPINION();
		OTHER_INFO=rowData.getOTHER_INFO();
		COL_CLASS=rowData.getCOL_CLASS();
		NEGATIVELIST=rowData.getNEGATIVELIST();


	}
	
	public void update(String col_id,
			String ap_regno,
			String col_criteria,
			String col_type,
			String col_desc,
			String col_status,
			String developer,
			String project_name,
			String road_type,
			String road_width,
			String traffic,
			String society,
			String area_location,
			String area_nearby,
			String area_cond,
			String building_nearby_cond,
			String location,
			String insurance,
			String col_addr1,
			String col_addr2,
			String col_addr3,
			String col_rt,
			String col_rw,
			String col_zipcode,
			String col_kelurahan,
			String col_kecamatan,
			String col_kabupaten,
			String col_city,
			String col_province,
			String col_areacode,
			String fas_tempat_ibadah,
			String fas_hospital,
			String fas_school,
			String fas_market,
			String fas_sport,
			String fas_mall,
			String fas_government,
			String fas_police,
			String fas_phonebox,
			String fas_cinema,
			String fas_transportation,
			String fas_transportation_distance,
			String fas_other,
			String neg_smallroad,
			String neg_heli_land,
			String neg_near_electric,
			String neg_flood,
			String neg_eviction,
			String neg_general_facilities,
			String neg_funeral,
			String neg_tpa,
			String neg_zoning,
			String neg_sea,
			String neg_rail,
			String neg_cultural,
			String inspection_person,
			String inspection_businessunit,
			String taxaxy_opinion,
			String other_info,
			String col_class,
			String negativelist){
		COL_ID=col_id;
		AP_REGNO=ap_regno;
		COL_CRITERIA=col_criteria;
		COL_TYPE=col_type;
		COL_DESC=col_desc;
		COL_STATUS=col_status;
		DEVELOPER=developer;
		PROJECT_NAME=project_name;
		ROAD_TYPE=road_type;
		ROAD_WIDTH=road_width;
		TRAFFIC=traffic;
		SOCIETY=society;
		AREA_LOCATION=area_location;
		AREA_NEARBY=area_nearby;
		AREA_COND=area_cond;
		BUILDING_NEARBY_COND=building_nearby_cond;
		LOCATION=location;
		INSURANCE=insurance;
		COL_ADDR1=col_addr1;
		COL_ADDR2=col_addr2;
		COL_ADDR3=col_addr3;
		COL_RT=col_rt;
		COL_RW=col_rw;
		COL_ZIPCODE=col_zipcode;
		COL_KELURAHAN=col_kelurahan;
		COL_KECAMATAN=col_kecamatan;
		COL_KABUPATEN=col_kabupaten;
		COL_CITY=col_city;
		COL_PROVINCE=col_province;
		COL_AREACODE=col_areacode;
		FAS_TEMPAT_IBADAH=fas_tempat_ibadah;
		FAS_HOSPITAL=fas_hospital;
		FAS_SCHOOL=fas_school;
		FAS_MARKET=fas_market;
		FAS_SPORT=fas_sport;
		FAS_MALL=fas_mall;
		FAS_GOVERNMENT=fas_government;
		FAS_POLICE=fas_police;
		FAS_PHONEBOX=fas_phonebox;
		FAS_CINEMA=fas_cinema;
		FAS_TRANSPORTATION=fas_transportation;
		FAS_TRANSPORTATION_DISTANCE=fas_transportation_distance;
		FAS_OTHER=fas_other;
		NEG_SMALLROAD=neg_smallroad;
		NEG_HELI_LAND=neg_heli_land;
		NEG_NEAR_ELECTRIC=neg_near_electric;
		NEG_FLOOD=neg_flood;
		NEG_EVICTION=neg_eviction;
		NEG_GENERAL_FACILITIES=neg_general_facilities;
		NEG_FUNERAL=neg_funeral;
		NEG_TPA=neg_tpa;
		NEG_ZONING=neg_zoning;
		NEG_SEA=neg_sea;
		NEG_RAIL=neg_rail;
		NEG_CULTURAL=neg_cultural;
		INSPECTION_PERSON=inspection_person;
		INSPECTION_BUSINESSUNIT=inspection_businessunit;
		TAXAXY_OPINION=taxaxy_opinion;
		OTHER_INFO=other_info;
		COL_CLASS=col_class;
		NEGATIVELIST=negativelist;
	}
	
	
	public void updateDataToNullForClosing(){

	}
}
