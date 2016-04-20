package com.mobile.bo.app.datatype;

import java.io.Serializable;
import org.json.JSONObject;
import com.mobile.database.app.entities.DETAILTABUNGAN;

public class DetailTabunganData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1146005151972784251L;
	private String CIF;		
    private String NOTABUNGAN;
    private String NAMA;
    
    public DetailTabunganData() {
	}
    
    public DetailTabunganData(DETAILTABUNGAN detailtabungan) {
		update(detailtabungan);
	}
    
    public DetailTabunganData(String cif,String nomortabungan,String nama){
    	CIF = cif;
    	NOTABUNGAN = nomortabungan;
    	NAMA = nama;
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
	public String getNAMA() {
		return NAMA;
	}
	public void setNAMA(String nAMA) {
		NAMA = nAMA;
	}
    
	public DETAILTABUNGAN toRowData(){
		DETAILTABUNGAN rowData= new DETAILTABUNGAN();
		rowData.setCIF(CIF);
		rowData.setNOTABUNGAN(NOTABUNGAN);
		rowData.setNAMA(NAMA);
		
		return rowData;
	}
	
	public void update(DETAILTABUNGAN rowData) {
		CIF = rowData.getCIF();
		NOTABUNGAN = rowData.getNOTABUNGAN();
		NAMA = rowData.getNAMA();
	}
	public void update(String cif,String nomortabungan,String nama){
		CIF = cif;
		NOTABUNGAN = nomortabungan;
		NAMA = nama;
	}
	
	public void updateDetailTabunganFromJSON(JSONObject obj) throws Exception{
		CIF = obj.getString("CIF");
		NOTABUNGAN = obj.getString("NOTABUNGAN");
		NAMA = obj.getString("NAMA");
	}
}
