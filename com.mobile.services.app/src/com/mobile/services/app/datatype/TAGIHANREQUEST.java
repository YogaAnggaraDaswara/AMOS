package com.mobile.services.app.datatype;

import com.google.gson.Gson;
import com.mobile.bo.app.datatype.TagihanData;
import com.mobile.framework.common.DateFormatter;

public class TAGIHANREQUEST {
	private String NOMORREKENING;	
    private String NAMADEBITUR;
    private String ALAMAT;
    private String JENISPINJAMAN;
    private String TENOR;
    private String TANGGALCAIR;
    private String POKOKPINJAMAN;
    private String BUNGAPINJAMAN;
    private String TOTALPINJAMAN;
    private String TOTALCICILAN;
    private String SISAPINJAMAN;
    private String TAGIHAN;
    private String PEMBAYARAN;
	private String PIN;
	private String HANDPHONE;
	
	public String getHANDPHONE() {
		return HANDPHONE;
	}



	public void setHANDPHONE(String hANDPHONE) {
		HANDPHONE = hANDPHONE;
	}



	public String getNOMORREKENING() {
		return NOMORREKENING;
	}



	public void setNOMORREKENING(String nOMORREKENING) {
		NOMORREKENING = nOMORREKENING;
	}



	public String getNAMADEBITUR() {
		return NAMADEBITUR;
	}



	public void setNAMADEBITUR(String nAMADEBITUR) {
		NAMADEBITUR = nAMADEBITUR;
	}



	public String getALAMAT() {
		return ALAMAT;
	}



	public void setALAMAT(String aLAMAT) {
		ALAMAT = aLAMAT;
	}



	public String getJENISPINJAMAN() {
		return JENISPINJAMAN;
	}



	public void setJENISPINJAMAN(String jENISPINJAMAN) {
		JENISPINJAMAN = jENISPINJAMAN;
	}



	public String getTENOR() {
		return TENOR;
	}



	public void setTENOR(String tENOR) {
		TENOR = tENOR;
	}



	public String getTANGGALCAIR() {
		return TANGGALCAIR;
	}



	public void setTANGGALCAIR(String tANGGALCAIR) {
		TANGGALCAIR = tANGGALCAIR;
	}



	public String getPOKOKPINJAMAN() {
		return POKOKPINJAMAN;
	}



	public void setPOKOKPINJAMAN(String pOKOKPINJAMAN) {
		POKOKPINJAMAN = pOKOKPINJAMAN;
	}



	public String getBUNGAPINJAMAN() {
		return BUNGAPINJAMAN;
	}



	public void setBUNGAPINJAMAN(String bUNGAPINJAMAN) {
		BUNGAPINJAMAN = bUNGAPINJAMAN;
	}



	public String getTOTALPINJAMAN() {
		return TOTALPINJAMAN;
	}



	public void setTOTALPINJAMAN(String tOTALPINJAMAN) {
		TOTALPINJAMAN = tOTALPINJAMAN;
	}



	public String getTOTALCICILAN() {
		return TOTALCICILAN;
	}



	public void setTOTALCICILAN(String tOTALCICILAN) {
		TOTALCICILAN = tOTALCICILAN;
	}



	public String getSISAPINJAMAN() {
		return SISAPINJAMAN;
	}



	public void setSISAPINJAMAN(String sISAPINJAMAN) {
		SISAPINJAMAN = sISAPINJAMAN;
	}



	public String getTAGIHAN() {
		return TAGIHAN;
	}



	public void setTAGIHAN(String tAGIHAN) {
		TAGIHAN = tAGIHAN;
	}

	

	public String getPEMBAYARAN() {
		return PEMBAYARAN;
	}



	public void setPEMBAYARAN(String pEMBAYARAN) {
		PEMBAYARAN = pEMBAYARAN;
	}



	public String getPIN() {
		return PIN;
	}



	public void setPIN(String pIN) {
		PIN = pIN;
	}



	public String toJSONString(TagihanData tagihan,String pembayaran,String pin,String handphone) throws Exception {
		Gson gsontagihan =  new Gson();

		TAGIHANREQUEST tagihanrequest=new TAGIHANREQUEST();
		tagihanrequest.setNOMORREKENING(tagihan.getNOMORREKENING());
		tagihanrequest.setNAMADEBITUR(tagihan.getNAMADEBITUR());
		tagihanrequest.setALAMAT(tagihan.getALAMAT());
		tagihanrequest.setJENISPINJAMAN(tagihan.getJENISPINJAMAN());		
		tagihanrequest.setTENOR(tagihan.getTENOR());
		tagihanrequest.setTANGGALCAIR(DateFormatter.formatStringYYYYMMdd(tagihan.getTANGGALCAIR(),false));
		tagihanrequest.setPOKOKPINJAMAN(tagihan.getPOKOKPINJAMAN());
		tagihanrequest.setBUNGAPINJAMAN(tagihan.getBUNGAPINJAMAN());
		tagihanrequest.setTOTALPINJAMAN(tagihan.getTOTALPINJAMAN());
		tagihanrequest.setTOTALCICILAN(tagihan.getTOTALCICILAN());
		tagihanrequest.setSISAPINJAMAN(tagihan.getSISAPINJAMAN());
		tagihanrequest.setTAGIHAN(tagihan.getTAGIHAN());
		tagihanrequest.setPEMBAYARAN(pembayaran);
		tagihanrequest.setPIN(pin);
		tagihanrequest.setHANDPHONE(handphone);
		
        return gsontagihan.toJson(tagihanrequest).toString();	
	}
}
