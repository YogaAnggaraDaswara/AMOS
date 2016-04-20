package com.mobile.services.app.datatype;

import java.util.ArrayList;
import com.google.gson.Gson;

public class TRANSAKSIREQUEST {
	public String NOMORREKENING;
	public String HANDPHONE;
	public String TOKEN;
	public String USERID;
	public String TOTALBAYAR;
	public String TRANSTYPE;
	public String CIF;
	public String NOTABUNGAN;
	public String NAMAPENABUNG;
	public String getNAMAPENABUNG() {
		return NAMAPENABUNG;
	}


	public void setNAMAPENABUNG(String nAMAPENABUNG) {
		NAMAPENABUNG = nAMAPENABUNG;
	}
	public String getNOMORREKENING() {
		return NOMORREKENING;
	}


	public void setNOMORREKENING(String nOMORREKENING) {
		NOMORREKENING = nOMORREKENING;
	}


	public String getHANDPHONE() {
		return HANDPHONE;
	}


	public void setHANDPHONE(String hANDPHONE) {
		HANDPHONE = hANDPHONE;
	}


	public String getTOKEN() {
		return TOKEN;
	}


	public void setTOKEN(String tOKEN) {
		TOKEN = tOKEN;
	}


	public String getUSERID() {
		return USERID;
	}


	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}


	public String getTOTALBAYAR() {
		return TOTALBAYAR;
	}


	public void setTOTALBAYAR(String tOTALBAYAR) {
		TOTALBAYAR = tOTALBAYAR;
	}


	public String getTRANSTYPE() {
		return TRANSTYPE;
	}


	public void setTRANSTYPE(String tRANSTYPE) {
		TRANSTYPE = tRANSTYPE;
	}

	
	public String getCIF() {
		return CIF;
	}


	public void setCIF(String cIF) {
		CIF = cIF;
	}


	public String getNOTABUNGAN() {
		return NOTABUNGAN;
	}


	public void setNOTABUNGAN(String nOTABUNGAN) {
		NOTABUNGAN = nOTABUNGAN;
	}


	public String toJSONObject(String norekening,String totalbayar,String token,String userid,String nomorhandphone,String transtype,String cif,String notabungan,String NamaPenabung) throws Exception {
		Gson gsonTransaksi =  new Gson();
		ArrayList<TRANSAKSIREQUEST> arrTransaksiRequest=new ArrayList<TRANSAKSIREQUEST>();
		TRANSAKSIREQUEST transaksirequest=new TRANSAKSIREQUEST();
		
		transaksirequest.setNOMORREKENING(norekening);
		transaksirequest.setUSERID(userid);
		transaksirequest.setTOKEN(token);
		transaksirequest.setUSERID(userid);
		transaksirequest.setHANDPHONE(nomorhandphone);
		transaksirequest.setTOTALBAYAR(totalbayar);
		transaksirequest.setTRANSTYPE(transtype);
		transaksirequest.setCIF(cif);
		transaksirequest.setNOTABUNGAN(notabungan);
		transaksirequest.setNAMAPENABUNG(NamaPenabung);
		arrTransaksiRequest.add(transaksirequest);
		
		return gsonTransaksi.toJson(arrTransaksiRequest);   
	}
}
