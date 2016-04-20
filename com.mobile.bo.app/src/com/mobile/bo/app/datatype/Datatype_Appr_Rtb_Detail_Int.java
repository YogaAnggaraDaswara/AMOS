package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

import com.mobile.database.app.common.DataConverter;
import com.mobile.database.app.entities.APPR_MAIN;
import com.mobile.database.app.entities.APPR_RTB_DATA_INT;
import com.mobile.database.app.entities.APPR_RTB_DETAIL_INT;
import com.mobile.database.app.entities.APPR_RTB_VALUATION_INT;
import com.mobile.database.app.entities.BLACKBOX;

public class Datatype_Appr_Rtb_Detail_Int implements Serializable {

	/**
	 * 
	 */
	public String COL_ID;
	public String AP_REGNO;
	public String CERTIFICATE_NAME;
	public String CERTIFCATE_NO;
	public String CERTIFICATE_TYPE;
	public Date CERTIFICATE_EXPIRE;
	public String RELATIONSHIP_DEBITUR;
	public String LAND_AREA;
	public String LAND_LENGTH;
	public String LAND_WIDTH;
	public String NORTH_BOUNDARY;
	public String SOUTH_BOUNDARY;
	public String LAND_SHAPE;
	public String LAND_SHAPE_DESC;
	public String LAND_CONTOUR;
	public String LAND_CONTOUR_DESC;
	public String LAND_PURPOSE;
	public String PYSHIC_LAND;
	public String PYSHIC_LAND_DESC;
	public String RANGE_ROAD;
	public String EAST_BOUNDARY;
	public String WEST_BOUNDARY;
	public String BUILDING_TYPE;
	public String BUILDING_CONDITION;
	public String BUILDING_CHARACTERISTIC;
	public String BUILDING_AREA;
	public String BUILDING_LENGTH;
	public String BUILDING_WIDTH;
	public String CONST_INTI;
	public String CONST_FLOOR;
	public String CONST_WALL;
	public String CONST_CEILING;
	public String CONST_ROOF;
	public String CONST_WINDOW;
	public String CONST_PARTITION;
	public String AVAIL_PLN;
	public String AVAIL_GENSET;
	public String AVAIL_PDAM;
	public String AVAIL_PDAM_DESC;
	public String AVAIL_PHONE;
	public String IMB_NAME;
	public String IMB_NO;
	public String IMB_DATE;
	public String IMB_CREATED_PLACE;
	public String IMB_PURPOSE;
	public String PURPOSE_NOT_IMB;
	public String CONST_PROGRESS;
	public String CONST_LANTAI;
	public String AVAIL_AIR;
	public String CONST_TAHUN;
	public String RANGE_WIDTH;



   
    
	 public Datatype_Appr_Rtb_Detail_Int() {
	    	update("",
	    			"",
	    			"",
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
	    			null,
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"",
	    			"");
		}
	    
	 public Datatype_Appr_Rtb_Detail_Int(APPR_RTB_DETAIL_INT Data) {
			update(Data);
	}
		

	

	

	
	public APPR_RTB_DETAIL_INT toRowData(){
		APPR_RTB_DETAIL_INT rowData= new APPR_RTB_DETAIL_INT();
		rowData.setCOL_ID(COL_ID);
		rowData.setAP_REGNO(AP_REGNO);
		rowData.setCERTIFICATE_NAME(CERTIFICATE_NAME);
		rowData.setCERTIFCATE_NO(CERTIFCATE_NO);
		rowData.setCERTIFICATE_TYPE(CERTIFICATE_TYPE);
		rowData.setCERTIFICATE_EXPIRE(CERTIFICATE_EXPIRE);
		rowData.setRELATIONSHIP_DEBITUR(RELATIONSHIP_DEBITUR);
		rowData.setLAND_AREA(LAND_AREA);
		rowData.setLAND_LENGTH(LAND_LENGTH);
		rowData.setLAND_WIDTH(LAND_WIDTH);
		rowData.setNORTH_BOUNDARY(NORTH_BOUNDARY);
		rowData.setSOUTH_BOUNDARY(SOUTH_BOUNDARY);
		rowData.setLAND_SHAPE(LAND_SHAPE);
		rowData.setLAND_SHAPE_DESC(LAND_SHAPE_DESC);
		rowData.setLAND_CONTOUR(LAND_CONTOUR);
		rowData.setLAND_CONTOUR_DESC(LAND_CONTOUR_DESC);
		rowData.setLAND_PURPOSE(LAND_PURPOSE);
		rowData.setPYSHIC_LAND(PYSHIC_LAND);
		rowData.setPYSHIC_LAND_DESC(PYSHIC_LAND_DESC);
		rowData.setRANGE_ROAD(RANGE_ROAD);
		rowData.setEAST_BOUNDARY(EAST_BOUNDARY);
		rowData.setWEST_BOUNDARY(WEST_BOUNDARY);
		rowData.setBUILDING_TYPE(BUILDING_TYPE);
		rowData.setBUILDING_CONDITION(BUILDING_CONDITION);
		rowData.setBUILDING_CHARACTERISTIC(BUILDING_CHARACTERISTIC);
		rowData.setBUILDING_AREA(BUILDING_AREA);
		rowData.setBUILDING_LENGTH(BUILDING_LENGTH);
		rowData.setBUILDING_WIDTH(BUILDING_WIDTH);
		rowData.setCONST_INTI(CONST_INTI);
		rowData.setCONST_FLOOR(CONST_FLOOR);
		rowData.setCONST_WALL(CONST_WALL);
		rowData.setCONST_CEILING(CONST_CEILING);
		rowData.setCONST_ROOF(CONST_ROOF);
		rowData.setCONST_WINDOW(CONST_WINDOW);
		rowData.setCONST_PARTITION(CONST_PARTITION);
		rowData.setAVAIL_PLN(AVAIL_PLN);
		rowData.setAVAIL_GENSET(AVAIL_GENSET);
		rowData.setAVAIL_PDAM(AVAIL_PDAM);
		rowData.setAVAIL_PDAM_DESC(AVAIL_PDAM_DESC);
		rowData.setAVAIL_PHONE(AVAIL_PHONE);
		rowData.setIMB_NAME(IMB_NAME);
		rowData.setIMB_NO(IMB_NO);
		rowData.setIMB_DATE(IMB_DATE);
		rowData.setIMB_CREATED_PLACE(IMB_CREATED_PLACE);
		rowData.setIMB_PURPOSE(IMB_PURPOSE);
		rowData.setPURPOSE_NOT_IMB(PURPOSE_NOT_IMB);
		rowData.setCONST_PROGRESS(CONST_PROGRESS);
		rowData.setCONST_LANTAI(CONST_LANTAI);
		rowData.setAVAIL_AIR(AVAIL_AIR);
		rowData.setCONST_TAHUN(CONST_TAHUN);
		rowData.setRANGE_WIDTH(RANGE_WIDTH);

		return rowData;
	}
	
	public void update(APPR_RTB_DETAIL_INT rowData) {
		COL_ID=rowData.getCOL_ID();
		AP_REGNO=rowData.getAP_REGNO();
		CERTIFICATE_NAME=rowData.getCERTIFICATE_NAME();
		CERTIFCATE_NO=rowData.getCERTIFCATE_NO();
		CERTIFICATE_TYPE=rowData.getCERTIFICATE_TYPE();
		CERTIFICATE_EXPIRE=rowData.getCERTIFICATE_EXPIRE();
		RELATIONSHIP_DEBITUR=rowData.getRELATIONSHIP_DEBITUR();
		LAND_AREA=rowData.getLAND_AREA();
		LAND_LENGTH=rowData.getLAND_LENGTH();
		LAND_WIDTH=rowData.getLAND_WIDTH();
		NORTH_BOUNDARY=rowData.getNORTH_BOUNDARY();
		SOUTH_BOUNDARY=rowData.getSOUTH_BOUNDARY();
		LAND_SHAPE=rowData.getLAND_SHAPE();
		LAND_SHAPE_DESC=rowData.getLAND_SHAPE_DESC();
		LAND_CONTOUR=rowData.getLAND_CONTOUR();
		LAND_CONTOUR_DESC=rowData.getLAND_CONTOUR_DESC();
		LAND_PURPOSE=rowData.getLAND_PURPOSE();
		PYSHIC_LAND=rowData.getPYSHIC_LAND();
		PYSHIC_LAND_DESC=rowData.getPYSHIC_LAND_DESC();
		RANGE_ROAD=rowData.getRANGE_ROAD();
		EAST_BOUNDARY=rowData.getEAST_BOUNDARY();
		WEST_BOUNDARY=rowData.getWEST_BOUNDARY();
		BUILDING_TYPE=rowData.getBUILDING_TYPE();
		BUILDING_CONDITION=rowData.getBUILDING_CONDITION();
		BUILDING_CHARACTERISTIC=rowData.getBUILDING_CHARACTERISTIC();
		BUILDING_AREA=rowData.getBUILDING_AREA();
		BUILDING_LENGTH=rowData.getBUILDING_LENGTH();
		BUILDING_WIDTH=rowData.getBUILDING_WIDTH();
		CONST_INTI=rowData.getCONST_INTI();
		CONST_FLOOR=rowData.getCONST_FLOOR();
		CONST_WALL=rowData.getCONST_WALL();
		CONST_CEILING=rowData.getCONST_CEILING();
		CONST_ROOF=rowData.getCONST_ROOF();
		CONST_WINDOW=rowData.getCONST_WINDOW();
		CONST_PARTITION=rowData.getCONST_PARTITION();
		AVAIL_PLN=rowData.getAVAIL_PLN();
		AVAIL_GENSET=rowData.getAVAIL_GENSET();
		AVAIL_PDAM=rowData.getAVAIL_PDAM();
		AVAIL_PDAM_DESC=rowData.getAVAIL_PDAM_DESC();
		AVAIL_PHONE=rowData.getAVAIL_PHONE();
		IMB_NAME=rowData.getIMB_NAME();
		IMB_NO=rowData.getIMB_NO();
		IMB_DATE=rowData.getIMB_DATE();
		IMB_CREATED_PLACE=rowData.getIMB_CREATED_PLACE();
		IMB_PURPOSE=rowData.getIMB_PURPOSE();
		PURPOSE_NOT_IMB=rowData.getPURPOSE_NOT_IMB();
		CONST_PROGRESS=rowData.getCONST_PROGRESS();
		CONST_LANTAI=rowData.getCONST_LANTAI();
		AVAIL_AIR=rowData.getAVAIL_AIR();
		CONST_TAHUN=rowData.getCONST_TAHUN();
		RANGE_WIDTH=rowData.getRANGE_WIDTH();




	}
	
	public void update(String col_id,
			String ap_regno,
			String certificate_name,
			String certifcate_no,
			String certificate_type,
			Date certificate_expire,
			String relationship_debitur,
			String land_area,
			String land_length,
			String land_width,
			String north_boundary,
			String south_boundary,
			String land_shape,
			String land_shape_desc,
			String land_contour,
			String land_contour_desc,
			String land_purpose,
			String pyshic_land,
			String pyshic_land_desc,
			String range_road,
			String east_boundary,
			String west_boundary,
			String building_type,
			String building_condition,
			String building_characteristic,
			String building_area,
			String building_length,
			String building_width,
			String const_inti,
			String const_floor,
			String const_wall,
			String const_ceiling,
			String const_roof,
			String const_window,
			String const_partition,
			String avail_pln,
			String avail_genset,
			String avail_pdam,
			String avail_pdam_desc,
			String avail_phone,
			String imb_name,
			String imb_no,
			String imb_date,
			String imb_created_place,
			String imb_purpose,
			String purpose_not_imb,
			String const_progress,
			String const_lantai,
			String avail_air,
			String const_tahun,
			String range_width){
		COL_ID=col_id;
		AP_REGNO=ap_regno;
		CERTIFICATE_NAME=certificate_name;
		CERTIFCATE_NO=certifcate_no;
		CERTIFICATE_TYPE=certificate_type;
		CERTIFICATE_EXPIRE=certificate_expire;
		RELATIONSHIP_DEBITUR=relationship_debitur;
		LAND_AREA=land_area;
		LAND_LENGTH=land_length;
		LAND_WIDTH=land_width;
		NORTH_BOUNDARY=north_boundary;
		SOUTH_BOUNDARY=south_boundary;
		LAND_SHAPE=land_shape;
		LAND_SHAPE_DESC=land_shape_desc;
		LAND_CONTOUR=land_contour;
		LAND_CONTOUR_DESC=land_contour_desc;
		LAND_PURPOSE=land_purpose;
		PYSHIC_LAND=pyshic_land;
		PYSHIC_LAND_DESC=pyshic_land_desc;
		RANGE_ROAD=range_road;
		EAST_BOUNDARY=east_boundary;
		WEST_BOUNDARY=west_boundary;
		BUILDING_TYPE=building_type;
		BUILDING_CONDITION=building_condition;
		BUILDING_CHARACTERISTIC=building_characteristic;
		BUILDING_AREA=building_area;
		BUILDING_LENGTH=building_length;
		BUILDING_WIDTH=building_width;
		CONST_INTI=const_inti;
		CONST_FLOOR=const_floor;
		CONST_WALL=const_wall;
		CONST_CEILING=const_ceiling;
		CONST_ROOF=const_roof;
		CONST_WINDOW=const_window;
		CONST_PARTITION=const_partition;
		AVAIL_PLN=avail_pln;
		AVAIL_GENSET=avail_genset;
		AVAIL_PDAM=avail_pdam;
		AVAIL_PDAM_DESC=avail_pdam_desc;
		AVAIL_PHONE=avail_phone;
		IMB_NAME=imb_name;
		IMB_NO=imb_no;
		IMB_DATE=imb_date;
		IMB_CREATED_PLACE=imb_created_place;
		IMB_PURPOSE=imb_purpose;
		PURPOSE_NOT_IMB=purpose_not_imb;
		CONST_PROGRESS=const_progress;
		CONST_LANTAI=const_lantai;
		AVAIL_AIR=avail_air;
		CONST_TAHUN=const_tahun;
		RANGE_WIDTH=range_width;

	}
	 public void updateMainFromJSON(JSONObject obj) throws Exception{
		 COL_ID=obj.getString("COL_ID");
		 AP_REGNO=obj.getString("AP_REGNO");
		 CERTIFICATE_NAME=obj.getString("CERTIFICATE_NAME");
		 CERTIFCATE_NO=obj.getString("CERTIFCATE_NO");
		 CERTIFICATE_TYPE=obj.getString("CERTIFICATE_TYPE");
		 CERTIFICATE_EXPIRE=DataConverter.stringToDate(obj.getString("CERTIFICATE_EXPIRE"));
		 RELATIONSHIP_DEBITUR=obj.getString("RELATIONSHIP_DEBITUR");
		 LAND_AREA=obj.getString("LAND_AREA");
		 LAND_LENGTH=obj.getString("LAND_LENGTH");
		 LAND_WIDTH=obj.getString("LAND_WIDTH");
		 NORTH_BOUNDARY=obj.getString("NORTH_BOUNDARY");
		 SOUTH_BOUNDARY=obj.getString("SOUTH_BOUNDARY");
		 LAND_SHAPE=obj.getString("LAND_SHAPE");
		 LAND_SHAPE_DESC=obj.getString("LAND_SHAPE_DESC");
		 LAND_CONTOUR=obj.getString("LAND_CONTOUR");
		 LAND_CONTOUR_DESC=obj.getString("LAND_CONTOUR_DESC");
		 LAND_PURPOSE=obj.getString("LAND_PURPOSE");
		 PYSHIC_LAND=obj.getString("PYSHIC_LAND");
		 PYSHIC_LAND_DESC=obj.getString("PYSHIC_LAND_DESC");
		 RANGE_ROAD=obj.getString("RANGE_ROAD");
		 EAST_BOUNDARY=obj.getString("EAST_BOUNDARY");
		 WEST_BOUNDARY=obj.getString("WEST_BOUNDARY");
		 BUILDING_TYPE=obj.getString("BUILDING_TYPE");
		 BUILDING_CONDITION=obj.getString("BUILDING_CONDITION");
		 BUILDING_CHARACTERISTIC=obj.getString("BUILDING_CHARACTERISTIC");
		 BUILDING_AREA=obj.getString("BUILDING_AREA");
		 BUILDING_LENGTH=obj.getString("BUILDING_LENGTH");
		 BUILDING_WIDTH=obj.getString("BUILDING_WIDTH");
		 CONST_INTI=obj.getString("CONST_INTI");
		 CONST_FLOOR=obj.getString("CONST_FLOOR");
		 CONST_WALL=obj.getString("CONST_WALL");
		 CONST_CEILING=obj.getString("CONST_CEILING");
		 CONST_ROOF=obj.getString("CONST_ROOF");
		 CONST_WINDOW=obj.getString("CONST_WINDOW");
		 CONST_PARTITION=obj.getString("CONST_PARTITION");
		 AVAIL_PLN=obj.getString("AVAIL_PLN");
		 AVAIL_GENSET=obj.getString("AVAIL_GENSET");
		 AVAIL_PDAM=obj.getString("AVAIL_PDAM");
		 AVAIL_PDAM_DESC=obj.getString("AVAIL_PDAM_DESC");
		 AVAIL_PHONE=obj.getString("AVAIL_PHONE");
		 IMB_NAME=obj.getString("IMB_NAME");
		 IMB_NO=obj.getString("IMB_NO");
		 IMB_DATE=obj.getString("IMB_DATE");
		 IMB_CREATED_PLACE=obj.getString("IMB_CREATED_PLACE");
		 IMB_PURPOSE=obj.getString("IMB_PURPOSE");
		 PURPOSE_NOT_IMB=obj.getString("PURPOSE_NOT_IMB");
		 CONST_PROGRESS=obj.getString("CONST_PROGRESS");
		 CONST_LANTAI=obj.getString("CONST_LANTAI");
		 AVAIL_AIR=obj.getString("AVAIL_AIR");
		 CONST_TAHUN=obj.getString("CONST_TAHUN");
		 RANGE_WIDTH=obj.getString("RANGE_WIDTH");

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
		return CERTIFICATE_EXPIRE;
	}

	public void setCERTIFICATE_EXPIRE(Date cERTIFICATE_EXPIRE) {
		CERTIFICATE_EXPIRE = cERTIFICATE_EXPIRE;
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
