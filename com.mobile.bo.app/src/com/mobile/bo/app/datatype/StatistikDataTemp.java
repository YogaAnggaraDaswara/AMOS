package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;

public class StatistikDataTemp  implements Serializable{

	/**
	 * author: Frans Simanjuntak
	 */
	private static final long serialVersionUID = -5487683863606277393L;
	private Integer ID;
	private Date DATE;
	private int PROSPEK; 
	private int KENALAN; 
	private int PDKT; 
	private int CLOSING;
	private int BLACKBOX;
	
	public  StatistikDataTemp(Integer id,Date date,int prospek,int kenalan,int pdkt,int closing,int blackbox){   
		ID=id;
		DATE=date;
		PROSPEK=prospek;
		KENALAN=kenalan;
		PDKT=pdkt;
		CLOSING=closing;
		BLACKBOX=blackbox;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Date getDATE() {
		return DATE;
	}

	public void setDATE(Date dATE) {
		DATE = dATE;
	}

	public int getPROSPEK() {
		return PROSPEK;
	}

	public void setPROSPEK(int pROSPEK) {
		PROSPEK = pROSPEK;
	}

	public int getKENALAN() {
		return KENALAN;
	}

	public void setKENALAN(int kENALAN) {
		KENALAN = kENALAN;
	}

	public int getPDKT() {
		return PDKT;
	}

	public void setPDKT(int pDKT) {
		PDKT = pDKT;
	}

	public int getCLOSING() {
		return CLOSING;
	}

	public void setCLOSING(int cLOSING) {
		CLOSING = cLOSING;
	}

	public int getBLACKBOX() {
		return BLACKBOX;
	}

	public void setBLACKBOX(int bLACKBOX) {
		BLACKBOX = bLACKBOX;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
