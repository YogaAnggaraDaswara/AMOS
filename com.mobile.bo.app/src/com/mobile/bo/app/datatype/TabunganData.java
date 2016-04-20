package com.mobile.bo.app.datatype;

import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import com.mobile.database.app.entities.TABUNGAN;
import com.mobile.framework.widget.ISpinnerItem;

public class TabunganData implements Serializable, ISpinnerItem{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8636617794768824988L;
    private String NOMORREKENING;		
    private String NAMADEBITUR;
    private String ALAMAT;
    private String JENISTABUNGAN;
    private String JUMLAHTABUNGAN;
    private String CIF;
    private String NOHANDPHONE;
    public String getNOHANDPHONE() {
		return NOHANDPHONE;
	}

	public void setNOHANDPHONE(String nOHANDPHONE) {
		NOHANDPHONE = nOHANDPHONE;
	}

	private ArrayList<DetailTabunganData> detailTabunganDatas =new ArrayList<DetailTabunganData>();
    
    public TabunganData() {
	}
    
    public TabunganData(TABUNGAN tabungan) {
		update(tabungan);
	}
    
    public TabunganData(String nomorekening,String namadebitur,String alamat,String jenistabungan,String cif,String nohandphone){
    	NOMORREKENING = nomorekening;
    	NAMADEBITUR = namadebitur;
		ALAMAT = alamat;
		JENISTABUNGAN = jenistabungan;
		CIF = cif;
		NOHANDPHONE=nohandphone;
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
	public String getJENISTABUNGAN() {
		return JENISTABUNGAN;
	}
	public void setJENISTABUNGAN(String jENISTABUNGAN) {
		JENISTABUNGAN = jENISTABUNGAN;
	}
    
	public String getJUMLAHTABUNGAN() {
		return JUMLAHTABUNGAN;
	}

	public void setJUMLAHTABUNGAN(String jUMLAHTABUNGAN) {
		JUMLAHTABUNGAN = jUMLAHTABUNGAN;
	}

	public String getCIF() {
		return CIF;
	}
	public void setCIF(String cIF) {
		CIF = cIF;
	}

	public ArrayList<DetailTabunganData> getDetailTabunganDatas() {
		return detailTabunganDatas;
	}

	public void setDetailTabunganDatas(
			ArrayList<DetailTabunganData> detailTabunganDatas) {
		this.detailTabunganDatas = detailTabunganDatas;
	}

	public TABUNGAN toRowData(){
		TABUNGAN rowData= new TABUNGAN();
		rowData.setNOMORREKENING(NOMORREKENING);
		rowData.setNAMADEBITUR(NAMADEBITUR);
		rowData.setALAMAT(ALAMAT);
		rowData.setJENISTABUNGAN(JENISTABUNGAN);
		rowData.setCIF(CIF);
		rowData.setNOHANDPHONE(NOHANDPHONE);
		return rowData;
	}
	
	public void update(TABUNGAN rowData) {
		NOMORREKENING = rowData.getNOMORREKENING();
		NAMADEBITUR = rowData.getNAMADEBITUR();
		ALAMAT = rowData.getALAMAT();
		JENISTABUNGAN = rowData.getJENISTABUNGAN();
		CIF = rowData.getCIF();
		NOHANDPHONE= rowData.getNOHANDPHONE();
	}
	
	public void update(String nomorekening,String namadebitur,String alamat,String jenistabungan,String cif,String nohandphone){
		NOMORREKENING = nomorekening;
		NAMADEBITUR = namadebitur;
		ALAMAT = alamat;
		JENISTABUNGAN = jenistabungan;
		CIF = cif;
		NOHANDPHONE= nohandphone;
	}
	
	public void updateTabunganMasterFromJSON(JSONObject obj) throws Exception{
		NOMORREKENING = obj.getString("NOMORREKENING");
		NAMADEBITUR = obj.getString("NAMADEBITUR");
		ALAMAT = obj.getString("ALAMAT");
		JENISTABUNGAN = obj.getString("JENISTABUNGAN");
		CIF = obj.getString("CIF");
		NOHANDPHONE= obj.getString("NOHANDPHONE");
		JSONArray arrDetail = new JSONArray(obj.getString("LISTCIF"));
		if (arrDetail.length() > 0){
			for (int i=0;i<arrDetail.length();i++){
				DetailTabunganData detailTabungan=new DetailTabunganData();
				detailTabungan.setCIF(arrDetail.getJSONObject(i).getString("CIF"));
				detailTabungan.setNOTABUNGAN(arrDetail.getJSONObject(i).getString("NOTABUNGAN"));
				detailTabungan.setNAMA(arrDetail.getJSONObject(i).getString("NAMA"));
				detailTabunganDatas.add(detailTabungan);
			}
		}
		arrDetail = null;
	}
	
	public void updateTabunganFromJSON(JSONObject obj) throws Exception{
		NOMORREKENING = obj.getString("NOMORREKENING");
		NAMADEBITUR = obj.getString("NAMADEBITUR");
		JUMLAHTABUNGAN = obj.getString("JUMLAHTABUNGAN");
	}

	@Override
	public String onSpinnerGetText() {
		return String.format("%s", NOMORREKENING);
	}

	@Override
	public Object onSpinnerGetValue() {
		return NOMORREKENING.toString();
	}
}
