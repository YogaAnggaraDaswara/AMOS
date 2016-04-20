package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

import com.mobile.database.app.entities.TAGIHAN;
import com.mobile.framework.common.DateFormatter;

public class TagihanData implements Serializable,Comparable<Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8273458659171213919L;
	private String ID;
    private String NOMORREKENING;	
    private String NAMADEBITUR;
    private String ALAMAT;
    private String JENISPINJAMAN;
    private String TENOR;
    private Date TANGGALCAIR;
    private String POKOKPINJAMAN;
    private String BUNGAPINJAMAN;
    private String TOTALPINJAMAN;
    private String TOTALCICILAN;
    private String SISAPINJAMAN;
    private String TAGIHAN;
    private String SISATAGIHAN;
    private String NOMORTABUNGAN;
    private String HANDPHONE;
    public TagihanData() {
		
	}
    public TagihanData(TAGIHAN tagihan) {
		update(tagihan);
	}
    
    public TagihanData(String nomorrekening,String namadebitur,String alamat,String jenispinjaman,
			   String tenor,Date tanggalcair,String pokokpinjaman,String bungapinjaman,String totalpinjaman,
			   String totalcicilan, String sisapinjaman, String tagihan,String sisatagihan,String nomortabungan,String handphone)
    {
    	update( nomorrekening, namadebitur, alamat, jenispinjaman,
 			    tenor, tanggalcair, pokokpinjaman, bungapinjaman, totalpinjaman,
 			    totalcicilan,  sisapinjaman,  tagihan,sisatagihan,nomortabungan,handphone);
    }
    
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
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
	public String getPOKOKPINJAMAN() {
		return POKOKPINJAMAN;
	}
	public void setPOKOKPINJAMAN(String pOKOKPINJAMAN) {
		POKOKPINJAMAN = pOKOKPINJAMAN;
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
	public String getBUNGAPINJAMAN() {
		return BUNGAPINJAMAN;
	}

	public void setBUNGAPINJAMAN(String bUNGAPINJAMAN) {
		BUNGAPINJAMAN = bUNGAPINJAMAN;
	}

	public Date getTANGGALCAIR() {
		return TANGGALCAIR;
	}

	public void setTANGGALCAIR(Date tANGGALCAIR) {
		TANGGALCAIR = tANGGALCAIR;
	}
	public String getTENOR() {
		return TENOR;
	}
	public void setTENOR(String tENOR) {
		TENOR = tENOR;
	}
	public String getSISATAGIHAN() {
		return SISATAGIHAN;
	}
	public void setSISATAGIHAN(String sISATAGIHAN) {
		SISATAGIHAN = sISATAGIHAN;
	}
	
	public String getHANDPHONE() {
		return HANDPHONE;
	}
	public void setHANDPHONE(String hANDPHONE) {
		HANDPHONE = hANDPHONE;
	}
	public String getNOMORTABUNGAN() {
		return NOMORTABUNGAN;
	}
	public void setNOMORTABUNGAN(String nOMORTABUNGAN) {
		NOMORTABUNGAN = nOMORTABUNGAN;
	}
	public TAGIHAN toRowData(){
		TAGIHAN rowData= new TAGIHAN();
		rowData.setID(ID);
		rowData.setNOMORREKENING(NOMORREKENING);
		rowData.setNAMADEBITUR(NAMADEBITUR);
		rowData.setALAMAT(ALAMAT);
		rowData.setJENISPINJAMAN(JENISPINJAMAN);		
		rowData.setTENOR(TENOR);
		rowData.setTANGGALCAIR(TANGGALCAIR);
		rowData.setPOKOKPINJAMAN(POKOKPINJAMAN);
		rowData.setBUNGAPINJAMAN(BUNGAPINJAMAN);
		rowData.setTOTALPINJAMAN(TOTALPINJAMAN);
		rowData.setTOTALCICILAN(TOTALCICILAN);
		rowData.setSISAPINJAMAN(SISAPINJAMAN);
		rowData.setTAGIHAN(TAGIHAN);
		rowData.setSISATAGIHAN(SISATAGIHAN);
		rowData.setNOMORTABUNGAN(NOMORTABUNGAN);
		rowData.setHANDPHONE(HANDPHONE);
		return rowData;
	}
	
	public void update(TAGIHAN rowData) {
		ID = rowData.getID();
		NOMORREKENING = rowData.getNOMORREKENING();
		NAMADEBITUR = rowData.getNAMADEBITUR();
		ALAMAT = rowData.getALAMAT();
		JENISPINJAMAN = rowData.getJENISPINJAMAN();
		TENOR = rowData.getTENOR();
		TANGGALCAIR = rowData.getTANGGALCAIR();
		POKOKPINJAMAN = rowData.getPOKOKPINJAMAN();		
		BUNGAPINJAMAN = rowData.getBUNGAPINJAMAN();
		TOTALPINJAMAN = rowData.getTOTALPINJAMAN();
		TOTALCICILAN = rowData.getTOTALCICILAN();
		SISAPINJAMAN = rowData.getSISAPINJAMAN();
		TAGIHAN = rowData.getTAGIHAN();
		SISATAGIHAN = rowData.getSISATAGIHAN();
		NOMORTABUNGAN = rowData.getNOMORTABUNGAN();
		HANDPHONE = rowData.getHANDPHONE();
	}
	
	public void update(String nomorrekening,String namadebitur,String alamat,String jenispinjaman,
					   String tenor,Date tanggalcair,String pokokpinjaman,String bungapinjaman,String totalpinjaman,
					   String totalcicilan, String sisapinjaman, String tagihan,String sisatagihan,String nomortabungan,String handphone){
		NOMORREKENING = nomorrekening;
		NAMADEBITUR = namadebitur;
		ALAMAT = alamat;
		BUNGAPINJAMAN = bungapinjaman;
		JENISPINJAMAN = jenispinjaman;
		TENOR = tenor;
		TANGGALCAIR = tanggalcair;		
		POKOKPINJAMAN = pokokpinjaman;		
		BUNGAPINJAMAN = bungapinjaman;
		TOTALPINJAMAN = totalpinjaman;
		TOTALCICILAN = totalcicilan;
		SISAPINJAMAN = sisapinjaman;
		TAGIHAN = tagihan;
		SISATAGIHAN = sisatagihan;
		NOMORTABUNGAN = nomortabungan;
		HANDPHONE=handphone;
	}
	
	public void updateTagihanMasterFromJSON(JSONObject obj) throws Exception{
		NOMORREKENING = obj.getString("NOMORREKENING");
		NAMADEBITUR = obj.getString("NAMADEBITUR");
		ALAMAT = obj.getString("ALAMAT");
		BUNGAPINJAMAN = obj.getString("BUNGAPINJAMAN");
		JENISPINJAMAN = obj.getString("JENISPINJAMAN");
		TENOR = obj.getString("TENOR");
		TANGGALCAIR = DateFormatter.formatDateYYYMMDD(obj.getString("TANGGALCAIR"));		
		POKOKPINJAMAN = obj.getString("POKOKPINJAMAN");		
		TOTALPINJAMAN = obj.getString("TOTALPINJAMAN");
		TOTALCICILAN = obj.getString("TOTALCICILAN");
		SISAPINJAMAN = obj.getString("SISAPINJAMAN");
		TAGIHAN = obj.getString("TAGIHAN");
		SISATAGIHAN = obj.getString("TAGIHAN");
		NOMORTABUNGAN = obj.getString("NOTABUNGAN");
		HANDPHONE= obj.getString("HANDPHONE");
	}
	
	public void updateTagihanFromJSON(JSONObject obj) throws Exception{
		NOMORREKENING = obj.getString("NOMORREKENING");
		NAMADEBITUR = obj.getString("NAMADEBITUR");
		TAGIHAN =obj.getString("TAGIHAN");
	}
	
	@Override
	public int compareTo(Object o1) {
		 return this.getNAMADEBITUR().compareTo(((TagihanData) o1).getNAMADEBITUR());
	}
}
