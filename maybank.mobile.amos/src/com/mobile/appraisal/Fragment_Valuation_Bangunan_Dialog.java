package com.mobile.appraisal;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import bii.mobile.amos.R;

import com.mobile.app.ui.DatePickerManager;
import com.mobile.app.ui.MasterEntryDialog;
import com.mobile.framework.common.NumberTextWatcher;
import com.mobile.framework.common.StringUtility;

public class Fragment_Valuation_Bangunan_Dialog extends MasterEntryDialog {
    private EditText data_kendaraan_txt_jenis_bangunan;
    private EditText data_kendaraan_txt_id;
    private EditText data_kendaraan_txt_seq;
    private EditText data_kendaraan_txt_luas_sesuai_fisik;
    private EditText data_kendaraan_txt_nilai;
    private Button btn_save;
	private EditText data_kendaraan_txt_nilai_pasar;
    private EditText data_kendaraan_txt_likuidasi;
    private EditText data_kendaraan_txt_nilai_likuidasi; 
    private EditText data_kendaraan_txt_luas_pemotongan;
    
    public EditText Edata_kendaraan_txt_luas_pemotongan(){
    	return data_kendaraan_txt_luas_pemotongan;
    }
    public EditText Edata_kendaraan_txt_nilai(){
    	return data_kendaraan_txt_nilai;
    }
    public EditText Edata_kendaraan_txt_likuidasi(){
    	return data_kendaraan_txt_likuidasi;
    }
    public String getData_kendaraan_txt_luas_pemotongan() {
  		return data_kendaraan_txt_luas_pemotongan.getText().toString();
  	}

  	public void setData_kendaraan_txt_luas_pemotongan(
  			String data_kendaraan_txt_luas_pemotongan) {
  		this.data_kendaraan_txt_luas_pemotongan.setText(data_kendaraan_txt_luas_pemotongan);
  	}

    public String getData_kendaraan_txt_nilai_pasar() {
		return data_kendaraan_txt_nilai_pasar.getText().toString();
	}

	public void setData_kendaraan_txt_nilai_pasar(
			String data_kendaraan_txt_nilai_pasar) {
		this.data_kendaraan_txt_nilai_pasar.setText( data_kendaraan_txt_nilai_pasar);
	}

	public String getData_kendaraan_txt_likuidasi() {
		return data_kendaraan_txt_likuidasi.getText().toString();
	}

	public void setData_kendaraan_txt_likuidasi(
			String data_kendaraan_txt_likuidasi) {
		this.data_kendaraan_txt_likuidasi.setText( data_kendaraan_txt_likuidasi);
	}

	public String getData_kendaraan_txt_nilai_likuidasi() {
		return data_kendaraan_txt_nilai_likuidasi.getText().toString();
	}

	public void setData_kendaraan_txt_nilai_likuidasi(
			String data_kendaraan_txt_nilai_likuidasi) {
		this.data_kendaraan_txt_nilai_likuidasi.setText( data_kendaraan_txt_nilai_likuidasi);
	}


	
    
    
    public String getData_kendaraan_txt_seq() {
		return data_kendaraan_txt_seq.getText().toString();
	}

	public void setData_kendaraan_txt_seq(String data_kendaraan_txt_seq) {
		this.data_kendaraan_txt_seq.setText( data_kendaraan_txt_seq);
	}

	public String getData_kendaraan_txt_id() {
		return data_kendaraan_txt_id.getText().toString();
	}

	public void setData_kendaraan_txt_id(String data_kendaraan_txt_id) {
		this.data_kendaraan_txt_id.setText(data_kendaraan_txt_id);
	}

	public String getData_kendaraan_txt_jenis_bangunan() {
		return data_kendaraan_txt_jenis_bangunan.getText().toString();
	}

	public void setData_kendaraan_txt_jenis_bangunan(String data_kendaraan_txt_jenis_bangunan) {
		this.data_kendaraan_txt_jenis_bangunan.setText(data_kendaraan_txt_jenis_bangunan);
	}

	public String getData_kendaraan_txt_luas_sesuai_fisik() {
		return data_kendaraan_txt_luas_sesuai_fisik.getText().toString();
	}

	public void setData_kendaraan_txt_luas_sesuai_fisik(String data_kendaraan_txt_luas_sesuai_fisik) {
		this.data_kendaraan_txt_luas_sesuai_fisik.setText(data_kendaraan_txt_luas_sesuai_fisik);
	}

	public String getData_kendaraan_txt_nilai() {
		return data_kendaraan_txt_nilai.getText().toString();
	}

	public void setData_kendaraan_txt_nilai(String data_kendaraan_txt_nilai) {
		this.data_kendaraan_txt_nilai.setText(data_kendaraan_txt_nilai);
	}


	public Button getBtn_save() {
		return btn_save;
	}

	public void setBtn_saveimb(Button btn_saveimb) {
		this.btn_save = btn_saveimb;
	}

	public Fragment_Valuation_Bangunan_Dialog(Context context) {
        super(context);
    }

    @Override
    protected void onInitMasterEntryDialogContentView(final Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_valuation_bangunan_dialog, getContentBody());
        getContentTitle().setText("Bangunan");
        getContentHeader().getLayoutParams().height = 720;
        //getContentHeader().invalidate();
        data_kendaraan_txt_jenis_bangunan = (EditText) getContentBody().findViewById(R.id.data_kendaraan_txt_jenis_bangunan);
        data_kendaraan_txt_luas_sesuai_fisik = (EditText) getContentBody().findViewById(R.id.data_kendaraan_txt_luas_sesuai_fisik);
        data_kendaraan_txt_nilai = (EditText) getContentBody().findViewById(R.id.data_kendaraan_txt_nilai);
        data_kendaraan_txt_nilai_pasar = (EditText) getContentBody().findViewById(R.id.data_kendaraan_txt_nilai_pasar);
        data_kendaraan_txt_likuidasi = (EditText) getContentBody().findViewById(R.id.data_kendaraan_txt_likuidasi);
        data_kendaraan_txt_nilai_likuidasi = (EditText) getContentBody().findViewById(R.id.data_kendaraan_txt_nilai_likuidasi); 
        data_kendaraan_txt_luas_pemotongan= (EditText) getContentBody().findViewById(R.id.data_kendaraan_txt_luas_pemotongan); 
		data_kendaraan_txt_id= (EditText) getContentBody().findViewById(R.id.data_kendaraan_txt_id);
		data_kendaraan_txt_seq= (EditText) getContentBody().findViewById(R.id.data_kendaraan_txt_seq);
		data_kendaraan_txt_luas_pemotongan= (EditText) getContentBody().findViewById(R.id.data_kendaraan_txt_luas_pemotongan);
		btn_save = (Button) getContentBody().findViewById(R.id.btn_save);
		
    }
   
    Boolean CekMandatory(){
    	  boolean retval=true;
    	  if(data_kendaraan_txt_jenis_bangunan.getText().length()==0){
    		  data_kendaraan_txt_jenis_bangunan.setError("Field Tidak Boleh Kososng");
    		  retval=false;
    	  }
    	return retval;
    }
    @Override
    public View checkContentValidation() {
     
        return null;
    }

 

}
