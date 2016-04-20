package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.mobile.database.app.common.DataConverter;

import com.mobile.database.app.entities.AMOS_ENTRY_DEBITUR_INT;

public class DataType_Amos_Debitur_Int implements Serializable {
	
	/**
	 * 
	 */
	
	public String ID;
	public String SEQ;
	public String AP_REGNO;
	public String USERID;
	public String CU_FULLNM;
	public String CU_HPNO;
	public String CU_EMAIL;
	public String CU_KTPADDR1;
	public Date CU_BORNDATE;
	
	public String CU_USIA_YY;
	public String CU_USIA_MM;
	
	public String CU_JOB_CODE;
	public String SP_FULLNM;
	public Date SP_BORNDATE;
	public String CU_COMPNAME;
	public String CU_OFADDR1;
	public String CU_INCOMEMONTH;
	public String INCOME;
	public String OTHINSTALLMENT;
	public String PRODCATID;
	public String PRODUCTID;
	public String SUBPRODUCTID;
	public String COL_CODE;
	
	public String PR_ID;
	
	public String FINS_COMP;
	public String FINS_PLAN;
	public String LINS_COMP;
	public String LINS_PLAN;
	public String PURCHASE_PRICE;
	public String CP_DOWNPAYMENT_PCT;
	public String CP_INTEREST;
	public String CP_TENOR;
	public String COL_LUAS;
	public String COL_VALUE;
	public String CP_INSTALLMENT;
	public String CP_LTV;
	public String IIR_IDR;
	public String CP_LIMIT;
	public String PROVISION;
	public String ADMINFEE;
	public String LINS_PREMI;
	public String FINS_PREMI;
	public String NOTACHARGE;
	public String LINS_POLICYFEEFIRE;
	public String FINS_POLICYFEELIFE;
	public String CH_CODE;
	public Date AP_CREATEDATE;
	public Date AP_DOCRECVDATE;
	public String BOOKINGBRANCH;
	
	public Date  CU_WORKSINCE_YY;
	public String  CU_ED_CODE;
	public String  CU_COMPSCALE;
	public String  CU_GENDER_CODE;
	public String  LP_CODE;	
	public String  CU_WORKSINCE_YY_INT;
	public String  CU_WORKSINCE_MM_INT;
	
	public String PPHTFEE;
	
	public String getID() {
		return ID;
	}
	
	public void setID(String iD) {
		ID = iD;
	}
	
	public void updateMainFromJSON(JSONObject obj) throws Exception {
		ID = obj.getString("ID");
		SEQ = obj.getString("SEQ");
		USERID = obj.getString("USERID");
		AP_REGNO = obj.getString("AP_REGNO");
		CU_FULLNM = obj.getString("CU_FULLNM");
		CU_HPNO = obj.getString("CU_HPNO");
		CU_EMAIL = obj.getString("CU_EMAIL");
		CU_KTPADDR1 = obj.getString("CU_KTPADDR1");
		CU_BORNDATE = DataConverter.stringToDate(obj.getString("CU_BORNDATE"));
		CU_USIA_YY = obj.getString("CU_USIA_YY");
		CU_USIA_MM = obj.getString("CU_USIA_MM");
		CU_JOB_CODE = obj.getString("CU_JOB_CODE");
		SP_FULLNM = obj.getString("SP_FULLNM");
		SP_BORNDATE = DataConverter.stringToDate(obj.getString("SP_BORNDATE"));
		CU_COMPNAME = obj.getString("CU_COMPNAME");
		CU_OFADDR1 = obj.getString("CU_OFADDR1");
		CU_INCOMEMONTH = obj.getString("CU_INCOMEMONTH");
		INCOME = obj.getString("INCOME");
		OTHINSTALLMENT = obj.getString("OTHINSTALLMENT");
		PRODCATID = obj.getString("PRODCATID");
		PRODUCTID = obj.getString("PRODUCTID");
		SUBPRODUCTID = obj.getString("SUBPRODUCTID");
		COL_CODE = obj.getString("COL_CODE");
		PR_ID = obj.getString("PR_ID");
		FINS_COMP = obj.getString("FINS_COMP");
		FINS_PLAN = obj.getString("FINS_PLAN");
		LINS_COMP = obj.getString("LINS_COMP");
		LINS_PLAN = obj.getString("LINS_PLAN");
		PURCHASE_PRICE = obj.getString("PURCHASE_PRICE");
		CP_DOWNPAYMENT_PCT = obj.getString("CP_DOWNPAYMENT_PCT");
		CP_INTEREST = obj.getString("CP_INTEREST");
		CP_TENOR = obj.getString("CP_TENOR");
		COL_LUAS = obj.getString("COL_LUAS");
		COL_VALUE = obj.getString("COL_VALUE");
		CP_INSTALLMENT = obj.getString("CP_INSTALLMENT");
		CP_LTV = obj.getString("CP_LTV");
		IIR_IDR = obj.getString("IIR_IDR");
		CP_LIMIT = obj.getString("CP_LIMIT");
		PROVISION = obj.getString("PROVISION");
		ADMINFEE = obj.getString("ADMINFEE");
		LINS_PREMI = obj.getString("LINS_PREMI");
		
		FINS_PREMI = obj.getString("FINS_PREMI");
		NOTACHARGE = obj.getString("NOTACHARGE");
		
		LINS_POLICYFEEFIRE = obj.getString("LINS_POLICYFEEFIRE");
		FINS_POLICYFEELIFE = obj.getString("FINS_POLICYFEELIFE");
		
		AP_CREATEDATE = DataConverter.stringToDateTime(obj.getString("AP_CREATEDATE"));
		AP_DOCRECVDATE = DataConverter.stringToDateTime(obj.getString("AP_DOCRECVDATE"));
		BOOKINGBRANCH = obj.getString("BOOKINGBRANCH");
		CH_CODE= obj.getString("CH_CODE");
		
		PPHTFEE= obj.getString("PPHTFEE");
		
		
		
		CU_WORKSINCE_YY= DataConverter.stringToDate(obj.getString("CU_WORKSINCE_YY"));				
		CU_ED_CODE= obj.getString("CU_ED_CODE");				
		CU_COMPSCALE= obj.getString("CU_COMPSCALE");				
		CU_GENDER_CODE= obj.getString("CU_GENDER_CODE");				
		LP_CODE= obj.getString("LP_CODE");			
		CU_WORKSINCE_YY_INT= obj.getString("CU_WORKSINCE_YY_INT");
		CU_WORKSINCE_MM_INT= obj.getString("CU_WORKSINCE_MM_INT");
	}
	
	public DataType_Amos_Debitur_Int()
	{
		update("",
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
			null,
			null,
			"",
			"",
			"",
			null,
			"",
			"",
			"",
			"",
			"",
			"");
	}
	
	public DataType_Amos_Debitur_Int(AMOS_ENTRY_DEBITUR_INT Data) {
		update(Data);
	}
	
	public AMOS_ENTRY_DEBITUR_INT toRowData(){
		AMOS_ENTRY_DEBITUR_INT rowData= new AMOS_ENTRY_DEBITUR_INT();
		rowData.setID(ID);
		rowData.setSEQ(SEQ);
		rowData.setAP_REGNO(AP_REGNO);
		rowData.setUSERID(USERID);
		rowData.setCU_FULLNM(CU_FULLNM);
		rowData.setCU_HPNO(CU_HPNO);
		rowData.setCU_EMAIL(CU_EMAIL);
		rowData.setCU_KTPADDR1(CU_KTPADDR1);
		rowData.setCU_BORNDATE(CU_BORNDATE);
		rowData.setCU_USIA_YY(CU_USIA_YY);
		rowData.setCU_USIA_MM(CU_USIA_MM);
		rowData.setCU_JOB_CODE(CU_JOB_CODE);
		rowData.setSP_FULLNM(SP_FULLNM);
		rowData.setSP_BORNDATE(SP_BORNDATE);
		rowData.setCU_COMPNAME(CU_COMPNAME);
		rowData.setCU_OFADDR1(CU_OFADDR1);
		rowData.setCU_INCOMEMONTH(CU_INCOMEMONTH);
		rowData.setINCOME(INCOME);
		rowData.setOTHINSTALLMENT(OTHINSTALLMENT);
		rowData.setPRODCATID(PRODCATID);
		rowData.setPRODUCTID(PRODUCTID);
		rowData.setSUBPRODUCTID(SUBPRODUCTID);
		rowData.setCOL_CODE(COL_CODE);
		rowData.setPR_ID(PR_ID);
		rowData.setFINS_COMP(FINS_COMP);
		rowData.setFINS_PLAN(FINS_PLAN);
		rowData.setLINS_COMP(LINS_COMP);
		rowData.setLINS_PLAN(LINS_PLAN);
		rowData.setPURCHASE_PRICE(PURCHASE_PRICE);
		rowData.setCP_DOWNPAYMENT_PCT(CP_DOWNPAYMENT_PCT);
		rowData.setCP_INTEREST(CP_INTEREST);
		rowData.setCP_TENOR(CP_TENOR);
		rowData.setCOL_LUAS(COL_LUAS);
		rowData.setCOL_VALUE(COL_VALUE);
		rowData.setCP_INSTALLMENT(CP_INSTALLMENT);
		rowData.setCP_LTV(CP_LTV);
		rowData.setIIR_IDR(IIR_IDR);
		rowData.setCP_LIMIT(CP_LIMIT);
		rowData.setPROVISION(PROVISION);
		rowData.setADMINFEE(ADMINFEE);
		rowData.setLINS_PREMI(LINS_PREMI);
		rowData.setFINS_PREMI(FINS_PREMI);
		rowData.setNOTACHARGE(NOTACHARGE);

		rowData.setLINS_POLICYFEEFIRE(LINS_POLICYFEEFIRE);
		rowData.setFINS_POLICYFEELIFE(FINS_POLICYFEELIFE);
		
		rowData.setAP_CREATEDATE(AP_CREATEDATE);
		rowData.setAP_DOCRECVDATE(AP_DOCRECVDATE);
		rowData.setBOOKINGBRANCH(BOOKINGBRANCH);
		rowData.setCH_CODE(CH_CODE);
		
		rowData.setPPHTFEE(PPHTFEE);
		
		
		rowData.setCU_WORKSINCE_YY(CU_WORKSINCE_YY);
		rowData.setCU_ED_CODE(CU_ED_CODE);
		rowData.setCU_COMPSCALE(CU_COMPSCALE);
		rowData.setCU_GENDER_CODE(CU_GENDER_CODE);
		rowData.setLP_CODE(LP_CODE);
		rowData.setCU_WORKSINCE_YY_INT(CU_WORKSINCE_YY_INT);
		rowData.setCU_WORKSINCE_MM_INT(CU_WORKSINCE_MM_INT);
		return rowData;
	}
	
	public void update(AMOS_ENTRY_DEBITUR_INT rowData) {
		ID = rowData.getID();
		SEQ = rowData.getSEQ();
		AP_REGNO = rowData.getAP_REGNO();
		USERID = rowData.getUSERID();
		CU_FULLNM = rowData.getCU_FULLNM();
		CU_HPNO = rowData.getCU_HPNO();
		CU_EMAIL = rowData.getCU_EMAIL();
		CU_KTPADDR1 = rowData.getCU_KTPADDR1();
		CU_BORNDATE = rowData.getCU_BORNDATE();
		CU_USIA_YY = rowData.getCU_USIA_YY();
		CU_USIA_MM = rowData.getCU_USIA_MM();
		CU_JOB_CODE = rowData.getCU_JOB_CODE();
		SP_FULLNM = rowData.getSP_FULLNM();
		SP_BORNDATE = rowData.getSP_BORNDATE();
		CU_COMPNAME = rowData.getCU_COMPNAME();
		CU_OFADDR1 = rowData.getCU_OFADDR1();
		CU_INCOMEMONTH = rowData.getCU_INCOMEMONTH();
		INCOME = rowData.getINCOME();
		OTHINSTALLMENT = rowData.getOTHINSTALLMENT();
		PRODCATID = rowData.getPRODCATID();
		PRODUCTID = rowData.getPRODUCTID();
		SUBPRODUCTID = rowData.getSUBPRODUCTID();
		COL_CODE = rowData.getCOL_CODE();
		
		PR_ID = rowData.getPR_ID();
		
		FINS_COMP = rowData.getFINS_COMP();
		FINS_PLAN = rowData.getFINS_PLAN();
		LINS_COMP = rowData.getLINS_COMP();
		LINS_PLAN = rowData.getLINS_PLAN();
		PURCHASE_PRICE = rowData.getPURCHASE_PRICE();
		CP_DOWNPAYMENT_PCT = rowData.getCP_DOWNPAYMENT_PCT();
		CP_INTEREST = rowData.getCP_INTEREST();
		CP_TENOR = rowData.getCP_TENOR();
		COL_LUAS = rowData.getCOL_LUAS();
		COL_VALUE = rowData.getCOL_VALUE();
		CP_INSTALLMENT = rowData.getCP_INSTALLMENT();
		CP_LTV = rowData.getCP_LTV();
		IIR_IDR = rowData.getIIR_IDR();
		CP_LIMIT = rowData.getCP_LIMIT();
		PROVISION = rowData.getPROVISION();
		ADMINFEE = rowData.getADMINFEE();
		LINS_PREMI = rowData.getLINS_PREMI();
		FINS_PREMI = rowData.getFINS_PREMI();
		NOTACHARGE = rowData.getNOTACHARGE();
		
		LINS_POLICYFEEFIRE = rowData.getLINS_POLICYFEEFIRE();
		FINS_POLICYFEELIFE = rowData.getFINS_POLICYFEELIFE();
		
		AP_CREATEDATE = rowData.getAP_CREATEDATE();
		AP_DOCRECVDATE = rowData.getAP_DOCRECVDATE();
		BOOKINGBRANCH = rowData.getBOOKINGBRANCH();
		CH_CODE = rowData.getCH_CODE();
		
		PPHTFEE = rowData.getPPHTFEE();
		
		
		CU_WORKSINCE_YY = rowData.getCU_WORKSINCE_YY();
		CU_ED_CODE = rowData.getCU_ED_CODE();
		CU_COMPSCALE = rowData.getCU_COMPSCALE();
		CU_GENDER_CODE = rowData.getCU_GENDER_CODE();
		LP_CODE = rowData.getLP_CODE();
		CU_WORKSINCE_YY_INT= rowData.getCU_WORKSINCE_YY_INT();
		CU_WORKSINCE_MM_INT= rowData.getCU_WORKSINCE_MM_INT();
	}
	
	public void update(
			String id,
			String seq,
			String ap_regno,
			String userid,
			String cu_fullname,
			String cu_hpno,
			String cu_email,
			String cu_ktpaddr1,
			Date cu_borndate,
			String cu_usia_yy,
			String cu_usia_mm,
			String cu_jobcode,
			String sp_fullnm,
			Date sp_borndate,
			String cu_compname,
			String cu_ofaddr1,
			String cu_incomemonth,
			String income,
			String othinstallment,
			String prodcatid,
			String productid,
			String subproductid,
			String col_code,
			String pr_id,
			String fins_comp,
			String fins_plan,
			String lins_comp,
			String lins_plan,
			String purchase_price,
			String cp_downpayment_pct,
			String cp_interest,
			String cp_tenor,
			String col_luas,
			String col_value,
			String cp_installment,
			String cp_ltv,
			String iir_idr,
			String cp_limit,
			String provision,
			String adminfee,
			String lins_premi,
			String fins_premi,
			String notacharge,
			String lINS_POLICYFEEFIRE,
			String fINS_POLICYFEELIFE,
			Date aP_CREATEDATE,
			Date aP_DOCRECVDATE,
			String bOOKINGBRANCH,
			String cH_CODE,
			String pPHTFEE,
			Date cu_worksince_yy,
			String cu_ed_code,
			String cu_compscale,
			String cu_gender_code,
			String lp_code,
			String cU_WORKSINCE_YY_INT,
			String cU_WORKSINCE_MM_INT
	) {
		ID = id;
		SEQ = seq;
		AP_REGNO = ap_regno;
		USERID = userid;
		CU_FULLNM = cu_fullname;
		CU_HPNO = cu_hpno;
		CU_EMAIL = cu_email;
		CU_KTPADDR1 = cu_ktpaddr1;
		CU_BORNDATE = cu_borndate;
		CU_USIA_YY = cu_usia_yy;
		CU_USIA_MM = cu_usia_mm;
		CU_JOB_CODE = cu_jobcode;
		SP_FULLNM = sp_fullnm;
		SP_BORNDATE = sp_borndate;
		CU_COMPNAME = cu_compname;
		CU_OFADDR1 = cu_ofaddr1;
		CU_INCOMEMONTH = cu_incomemonth;
		INCOME = income;
		OTHINSTALLMENT = othinstallment;
		PRODCATID = prodcatid;
		PRODUCTID = productid;
		SUBPRODUCTID = subproductid;
		COL_CODE = col_code;
		PR_ID = pr_id;
		FINS_COMP = fins_comp;
		FINS_PLAN = fins_plan;
		LINS_COMP = lins_comp;
		LINS_PLAN = lins_plan;
		PURCHASE_PRICE = purchase_price;
		CP_DOWNPAYMENT_PCT = cp_downpayment_pct;
		CP_INTEREST = cp_interest;
		CP_TENOR = cp_tenor;
		COL_LUAS = col_luas;
		COL_VALUE = col_value;
		CP_INSTALLMENT = cp_installment;
		CP_LTV = cp_ltv;
		IIR_IDR = iir_idr;
		CP_LIMIT = cp_limit;
		PROVISION = provision;
		ADMINFEE = adminfee;
		LINS_PREMI = lins_premi;
		FINS_PREMI = fins_premi;
		NOTACHARGE = notacharge;
		LINS_POLICYFEEFIRE=lINS_POLICYFEEFIRE;
		FINS_POLICYFEELIFE=fINS_POLICYFEELIFE;
		AP_CREATEDATE=aP_CREATEDATE;
		AP_DOCRECVDATE=aP_DOCRECVDATE;
		BOOKINGBRANCH=bOOKINGBRANCH;
		CH_CODE=cH_CODE;
		PPHTFEE=pPHTFEE;
		
		CU_WORKSINCE_YY=cu_worksince_yy;
		CU_ED_CODE=cu_ed_code;
		CU_COMPSCALE=cu_compscale;
		CU_GENDER_CODE=cu_gender_code;
		LP_CODE=lp_code;
		CU_WORKSINCE_YY_INT=cU_WORKSINCE_YY_INT;
		CU_WORKSINCE_MM_INT=cU_WORKSINCE_MM_INT;
	}
	
	
	public String getCU_WORKSINCE_YY_INT() {
		return CU_WORKSINCE_YY_INT;
	}
	public void setCU_WORKSINCE_YY_INT(String cU_WORKSINCE_YY_INT) {
		CU_WORKSINCE_YY_INT = cU_WORKSINCE_YY_INT;
	}
	
	public String getCU_WORKSINCE_MM_INT() {
		return CU_WORKSINCE_MM_INT;
	}
	public void setCU_WORKSINCE_MM_INT(String cU_WORKSINCE_MM_INT) {
		CU_WORKSINCE_MM_INT = cU_WORKSINCE_MM_INT;
	}

	public Date getCU_WORKSINCE_YY() {
		return CU_WORKSINCE_YY;
	}

	public void setCU_WORKSINCE_YY(Date cU_WORKSINCE_YY) {
		CU_WORKSINCE_YY = cU_WORKSINCE_YY;
	}

	public String getCU_ED_CODE() {
		return CU_ED_CODE;
	}

	public void setCU_ED_CODE(String cU_ED_CODE) {
		CU_ED_CODE = cU_ED_CODE;
	}

	public String getCU_COMPSCALE() {
		return CU_COMPSCALE;
	}

	public void setCU_COMPSCALE(String cU_COMPSCALE) {
		CU_COMPSCALE = cU_COMPSCALE;
	}

	public String getCU_GENDER_CODE() {
		return CU_GENDER_CODE;
	}

	public void setCU_GENDER_CODE(String cU_GENDER_CODE) {
		CU_GENDER_CODE = cU_GENDER_CODE;
	}

	public String getLP_CODE() {
		return LP_CODE;
	}

	public void setLP_CODE(String lP_CODE) {
		LP_CODE = lP_CODE;
	}

	public String getCH_CODE() {
		return CH_CODE;
	}

	public void setCH_CODE(String cH_CODE) {
		CH_CODE = cH_CODE;
	}

	public Date getAP_CREATEDATE() {
		return AP_CREATEDATE;
	}

	public void setAP_CREATEDATE(Date aP_CREATEDATE) {
		AP_CREATEDATE = aP_CREATEDATE;
	}

	public Date getAP_DOCRECVDATE() {
		return AP_DOCRECVDATE;
	}

	public void setAP_DOCRECVDATE(Date aP_DOCRECVDATE) {
		AP_DOCRECVDATE = aP_DOCRECVDATE;
	}

	public String getBOOKINGBRANCH() {
		return BOOKINGBRANCH;
	}

	public void setBOOKINGBRANCH(String bOOKINGBRANCH) {
		BOOKINGBRANCH = bOOKINGBRANCH;
	}

	public String getLINS_POLICYFEEFIRE() {
		return LINS_POLICYFEEFIRE;
	}

	public void setLINS_POLICYFEEFIRE(String lINS_POLICYFEEFIRE) {
		LINS_POLICYFEEFIRE = lINS_POLICYFEEFIRE;
	}

	public String getFINS_POLICYFEELIFE() {
		return FINS_POLICYFEELIFE;
	}

	public void setFINS_POLICYFEELIFE(String fINS_POLICYFEELIFE) {
		FINS_POLICYFEELIFE = fINS_POLICYFEELIFE;
	}

	public String getUSERID(){
		return USERID;
	}
	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}
	
	public String getSEQ() {
		return SEQ;
	}
	public void setSEQ(String sEQ) {
		SEQ = sEQ;
	}
	
	public String getAP_REGNO(){
		return AP_REGNO;
	}
	public void setAP_REGNO(String aP_REGNO) {
		AP_REGNO = aP_REGNO;
	}
	
	public String getCU_FULLNM(){
		return CU_FULLNM;
	}
	public void setCU_FULLNM(String cU_FULLNM) {
		CU_FULLNM = cU_FULLNM;
	}
	
	public String getCU_HPNO(){
		return CU_HPNO;
	}
	public void setCU_HPNO(String cU_HPNO) {
		CU_HPNO = cU_HPNO;
	}
	
	public String getCU_EMAIL(){
		return CU_EMAIL;
	}
	public void setCU_EMAIL(String cU_EMAIL) {
		CU_EMAIL = cU_EMAIL;
	}
	
	public String getCU_KTPADDR1(){
		return CU_KTPADDR1;
	}
	public void setCU_KTPADDR1(String cU_KTPADDR1) {
		CU_KTPADDR1 = cU_KTPADDR1;
	}
	
	public Date getCU_BORNDATE() {
		return CU_BORNDATE;
	}
	public void setCU_BORNDATE(Date cU_BORNDATE) {
		CU_BORNDATE = cU_BORNDATE;
	}
	
	public String getCU_USIA_YY(){
		return CU_USIA_YY;
	}
	public void setCU_USIA_YY(String cU_USIA_YY) {
		CU_USIA_YY = cU_USIA_YY;
	}
	
	public String getCU_USIA_MM(){
		return CU_USIA_MM;
	}
	public void setCU_USIA_MM(String cU_USIA_MM) {
		CU_USIA_MM = cU_USIA_MM;
	}
	
	public String getCU_JOB_CODE(){
		return CU_JOB_CODE;
	}
	public void setCU_JOB_CODE(String cU_JOB_CODE) {
		CU_JOB_CODE = cU_JOB_CODE;
	}
	
	public String getSP_FULLNM(){
		return SP_FULLNM;
	}
	public void setSP_FULLNM(String sP_FULLNM) {
		SP_FULLNM = sP_FULLNM;
	}
	
	public Date getSP_BORNDATE() {
		return SP_BORNDATE;
	}
	public void setSP_BORNDATE(Date sP_BORNDATE) {
		SP_BORNDATE = sP_BORNDATE;
	}
	
	public String getCU_COMPNAME(){
		return CU_COMPNAME;
	}
	public void setCU_COMPNAME(String cU_COMPNAME) {
		CU_COMPNAME = cU_COMPNAME;
	}
	
	public String getCU_OFADDR1(){
		return CU_OFADDR1;
	}
	public void setCU_OFADDR1(String cU_OFADDR1) {
		CU_OFADDR1 = cU_OFADDR1;
	}
	
	public String getCU_INCOMEMONTH(){
		return CU_INCOMEMONTH;
	}
	public void setCU_INCOMEMONTH(String cU_INCOMEMONTH) {
		CU_INCOMEMONTH = cU_INCOMEMONTH;
	}
	
	public String getINCOME(){
		return INCOME;
	}
	public void setINCOME(String iNCOME) {
		INCOME = iNCOME;
	}
	
	public String getOTHINSTALLMENT(){
		return OTHINSTALLMENT;
	}
	public void setOTHINSTALLMENT(String oTHINSTALLMENT) {
		OTHINSTALLMENT = oTHINSTALLMENT;
	}
	
	public String getPRODCATID(){
		return PRODCATID;
	}
	public void setPRODCATID(String pRODCATID) {
		PRODCATID = pRODCATID;
	}
	
	public String getPRODUCTID(){
		return PRODUCTID;
	}
	public void setPRODUCTID(String pRODUCTID) {
		PRODUCTID = pRODUCTID;
	}
	
	public String getSUBPRODUCTID(){
		return SUBPRODUCTID;
	}
	public void setSUBPRODUCTID(String sUBPRODUCTID) {
		SUBPRODUCTID = sUBPRODUCTID;
	}
	
	public String getCOL_CODE(){
		return COL_CODE;
	}
	public void setCOL_CODE(String cOL_CODE) {
		COL_CODE = cOL_CODE;
	}
	
	public String getPR_ID(){
		return PR_ID;
	}
	public void setPR_ID(String pR_ID) {
		PR_ID = pR_ID;
	}
	
	public String getFINS_COMP(){
		return FINS_COMP;
	}
	public void setFINS_COMP(String fINS_COMP) {
		FINS_COMP = fINS_COMP;
	}
	
	public String getFINS_PLAN(){
		return FINS_PLAN;
	}
	public void setFINS_PLAN(String fINS_PLAN) {
		FINS_PLAN = fINS_PLAN;
	}
	
	public String getLINS_COMP(){
		return LINS_COMP;
	}
	public void setLINS_COMP(String lINS_COMP) {
		LINS_COMP = lINS_COMP;
	}
	
	public String getLINS_PLAN(){
		return LINS_PLAN;
	}
	public void setLINS_PLAN(String lINS_PLAN) {
		LINS_PLAN = lINS_PLAN;
	}
	
	public String getPURCHASE_PRICE(){
		return PURCHASE_PRICE;
	}
	public void setPURCHASE_PRICE(String pURCHASE_PRICE) {
		PURCHASE_PRICE = pURCHASE_PRICE;
	}
	
	public String getCP_DOWNPAYMENT_PCT(){
		return CP_DOWNPAYMENT_PCT;
	}
	public void setCP_DOWNPAYMENT_PCT(String cP_DOWNPAYMENT_PCT) {
		CP_DOWNPAYMENT_PCT = cP_DOWNPAYMENT_PCT;
	}
	
	public String getCP_INTEREST(){
		return CP_INTEREST;
	}
	public void setCP_INTEREST(String cP_INTEREST) {
		CP_INTEREST = cP_INTEREST;
	}
	
	public String getCP_TENOR(){
		return CP_TENOR;
	}
	public void setCP_TENOR(String cP_TENOR) {
		CP_TENOR = cP_TENOR;
	}
	
	public String getCOL_LUAS(){
		return COL_LUAS;
	}
	public void setCOL_LUAS(String cOL_LUAS) {
		COL_LUAS = cOL_LUAS;
	}
	
	public String getCOL_VALUE(){
		return COL_VALUE;
	}
	public void setCOL_VALUE(String cOL_VALUE) {
		COL_VALUE = cOL_VALUE;
	}
	
	public String getCP_INSTALLMENT(){
		return CP_INSTALLMENT;
	}
	public void setCP_INSTALLMENT(String cP_INSTALLMENT) {
		CP_INSTALLMENT = cP_INSTALLMENT;
	}
	
	public String getCP_LTV(){
		return CP_LTV;
	}
	public void setCP_LTV(String cP_LTV) {
		CP_LTV = cP_LTV;
	}
	
	public String getIIR_IDR(){
		return IIR_IDR;
	}
	public void setIIR_IDR(String iIR_IDR) {
		IIR_IDR = iIR_IDR;
	}
	
	public String getCP_LIMIT(){
		return CP_LIMIT;
	}
	public void setCP_LIMIT(String cP_LIMIT) {
		CP_LIMIT = cP_LIMIT;
	}
	
	public String getPROVISION(){
		return PROVISION;
	}
	public void setPROVISION(String pROVISION) {
		PROVISION = pROVISION;
	}
	
	public String getADMINFEE(){
		return ADMINFEE;
	}
	public void setADMINFEE(String aDMINFEE) {
		ADMINFEE = aDMINFEE;
	}
	
	public String getLINS_PREMI(){
		return LINS_PREMI;
	}
	public void setLINS_PREMI(String lINS_PREMI) {
		LINS_PREMI = lINS_PREMI;
	}
	
	public String getFINS_PREMI(){
		return FINS_PREMI;
	}
	public void setFINS_PREMI(String fINS_PREMI) {
		FINS_PREMI = fINS_PREMI;
	}
	
	public String getNOTACHARGE(){
		return NOTACHARGE;
	}
	public void setNOTACHARGE(String nOTACHARGE) {
		NOTACHARGE = nOTACHARGE;
	}
	
	public String getPPHTFEE(){
		return PPHTFEE;
	}
	public void setPPHTFEE(String pPHTFEE) {
		PPHTFEE = pPHTFEE;
	}

}
