package com.mobile.database.app.entities;

import java.util.Date;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.mobile.database.app.common.DataConverter;

@DatabaseTable(tableName="AMOS_ENTRY_DEBITUR_INT")
public class AMOS_ENTRY_DEBITUR_INT {
	@DatabaseField(id=true,canBeNull=false,uniqueIndexName="AMOS_ENTRY_DEBITUR_INT_PK",dataType=DataType.STRING,width=30) private String ID;
	@DatabaseField(dataType=DataType.STRING,width=4) private String SEQ;
	@DatabaseField(dataType=DataType.STRING,width=20) private String AP_REGNO;
	
	@DatabaseField(dataType=DataType.STRING,width=20) private String USERID;
	
	@DatabaseField(dataType=DataType.STRING,width=100) private String CU_FULLNM;
	@DatabaseField(dataType=DataType.STRING,width=20) private String CU_HPNO;
	@DatabaseField(dataType=DataType.STRING,width=20) private String CU_EMAIL;
	@DatabaseField(dataType=DataType.STRING,width=200) private String CU_KTPADDR1;
	@DatabaseField(dataType=DataType.STRING,width=8) private String CU_BORNDATE;
	
	@DatabaseField(dataType=DataType.STRING,width=6) private String CU_USIA_YY;
	
	@DatabaseField(dataType=DataType.STRING,width=6) private String CU_USIA_MM;
	
	@DatabaseField(dataType=DataType.STRING,width=10) private String CU_JOB_CODE;
	@DatabaseField(dataType=DataType.STRING,width=100) private String SP_FULLNM;
	@DatabaseField(dataType=DataType.STRING,width=8) private String SP_BORNDATE;
	
	@DatabaseField(dataType=DataType.STRING,width=100) private String CU_COMPNAME;
	@DatabaseField(dataType=DataType.STRING,width=200) private String CU_OFADDR1;
	@DatabaseField(dataType=DataType.STRING,width=10) private String CU_INCOMEMONTH;
	@DatabaseField(dataType=DataType.STRING,width=10) private String INCOME;
	@DatabaseField(dataType=DataType.STRING,width=10) private String OTHINSTALLMENT;
	@DatabaseField(dataType=DataType.STRING,width=10) private String PRODCATID;
	@DatabaseField(dataType=DataType.STRING,width=10) private String PRODUCTID;
	@DatabaseField(dataType=DataType.STRING,width=10) private String SUBPRODUCTID;
	@DatabaseField(dataType=DataType.STRING,width=10) private String COL_CODE;
	
	@DatabaseField(dataType=DataType.STRING,width=10) private String PR_ID;
	
	@DatabaseField(dataType=DataType.STRING,width=20) private String FINS_COMP;
	@DatabaseField(dataType=DataType.STRING,width=50) private String FINS_PLAN;
	@DatabaseField(dataType=DataType.STRING,width=20) private String LINS_COMP;
	@DatabaseField(dataType=DataType.STRING,width=50) private String LINS_PLAN;
	@DatabaseField(dataType=DataType.STRING,width=9) private String PURCHASE_PRICE;
	@DatabaseField(dataType=DataType.STRING,width=9) private String CP_DOWNPAYMENT_PCT;
	@DatabaseField(dataType=DataType.STRING,width=10) private String CP_INTEREST;
	@DatabaseField(dataType=DataType.STRING,width=10) private String CP_TENOR;
	@DatabaseField(dataType=DataType.STRING,width=8) private String COL_LUAS;
	@DatabaseField(dataType=DataType.STRING,width=9) private String COL_VALUE;
	@DatabaseField(dataType=DataType.STRING,width=10) private String CP_INSTALLMENT;
	@DatabaseField(dataType=DataType.STRING,width=9) private String CP_LTV;
	@DatabaseField(dataType=DataType.STRING,width=10) private String IIR_IDR;
	@DatabaseField(dataType=DataType.STRING,width=10) private String CP_LIMIT;
	
	@DatabaseField(dataType=DataType.STRING,width=10) private String PROVISION;
	@DatabaseField(dataType=DataType.STRING,width=9) private String ADMINFEE;
	@DatabaseField(dataType=DataType.STRING,width=9) private String LINS_PREMI;
	@DatabaseField(dataType=DataType.STRING,width=9) private String FINS_PREMI;
	@DatabaseField(dataType=DataType.STRING,width=9) private String NOTACHARGE;
	
	@DatabaseField(dataType=DataType.STRING,width=20) private String CH_CODE;
	@DatabaseField(dataType=DataType.STRING,width=20) private String AP_CREATEDATE;
	@DatabaseField(dataType=DataType.STRING,width=20) private String AP_DOCRECVDATE;
	@DatabaseField(dataType=DataType.STRING,width=20) private String BOOKINGBRANCH;
	@DatabaseField(dataType=DataType.STRING,width=20) private String LINS_POLICYFEEFIRE;
	@DatabaseField(dataType=DataType.STRING,width=20) private String FINS_POLICYFEELIFE;	
	@DatabaseField(dataType=DataType.STRING,width=20) private String PPHTFEE;
	

	@DatabaseField(dataType=DataType.STRING,width=20) private String CU_WORKSINCE_YY;
	@DatabaseField(dataType=DataType.STRING,width=20) private String CU_ED_CODE;
	@DatabaseField(dataType=DataType.STRING,width=20) private String CU_COMPSCALE;
	@DatabaseField(dataType=DataType.STRING,width=20) private String CU_GENDER_CODE;
	@DatabaseField(dataType=DataType.STRING,width=20) private String LP_CODE;	
	@DatabaseField(dataType=DataType.STRING,width=20) private String CU_WORKSINCE_YY_INT;
	@DatabaseField(dataType=DataType.STRING,width=20) private String CU_WORKSINCEM_MM_INT;
	
	
	public String getCU_WORKSINCE_YY_INT() {
		return CU_WORKSINCE_YY_INT;
	}
	public void setCU_WORKSINCE_YY_INT(String cU_WORKSINCE_YY_INT) {
		CU_WORKSINCE_YY_INT = cU_WORKSINCE_YY_INT;
	}
	
	public String getCU_WORKSINCE_MM_INT() {
		return CU_WORKSINCEM_MM_INT;
	}
	public void setCU_WORKSINCE_MM_INT(String cU_WORKSINCEM_MM_INT) {
		CU_WORKSINCEM_MM_INT = cU_WORKSINCEM_MM_INT;
	}
	
	public Date getCU_WORKSINCE_YY() {
		return DataConverter.stringToDate(CU_WORKSINCE_YY);
	}
	public void setCU_WORKSINCE_YY(Date cU_WORKSINCE_YY) {
		CU_WORKSINCE_YY = DataConverter.dateToString(cU_WORKSINCE_YY);
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
	public void setSP_BORNDATE(String sP_BORNDATE) {
		SP_BORNDATE = sP_BORNDATE;
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
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
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
	
	public String getUSERID(){
		return USERID;
	}
	public void setUSERID(String uSERID) {
		USERID = uSERID;
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
		return DataConverter.stringToDate(CU_BORNDATE);
	}
	public void setCU_BORNDATE(Date cU_BORNDATE) {
		CU_BORNDATE = DataConverter.dateToString(cU_BORNDATE);
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
		return DataConverter.stringToDate(SP_BORNDATE);
	}
	public void setSP_BORNDATE(Date sP_BORNDATE) {
		SP_BORNDATE = DataConverter.dateToString(sP_BORNDATE);
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
	
	public String getCH_CODE(){
		return CH_CODE;
	}
	public void setCH_CODE(String cH_CODE) {
		CH_CODE = cH_CODE;
	}
	
	public Date getAP_CREATEDATE(){
		return DataConverter.stringToDateTime(AP_CREATEDATE);
	}
	public void setAP_CREATEDATE(Date aP_CREATEDATE) {
		AP_CREATEDATE = DataConverter.dateTimeToString(aP_CREATEDATE);
	}
	
	public Date getAP_DOCRECVDATE(){
		return DataConverter.stringToDateTime(AP_DOCRECVDATE);
	}
	public void setAP_DOCRECVDATE(Date aP_DOCRECVDATE) {
		AP_DOCRECVDATE = DataConverter.dateTimeToString(aP_DOCRECVDATE);
	}
	
	public String getBOOKINGBRANCH(){
		return BOOKINGBRANCH;
	}
	public void setBOOKINGBRANCH(String bOOKINGBRANCH) {
		BOOKINGBRANCH = bOOKINGBRANCH;
	}
	
	public String getPPHTFEE() {
		return PPHTFEE;
	}
	public void setPPHTFEE(String pPHTFEE) {
		PPHTFEE = pPHTFEE;
	}
	
	
}
