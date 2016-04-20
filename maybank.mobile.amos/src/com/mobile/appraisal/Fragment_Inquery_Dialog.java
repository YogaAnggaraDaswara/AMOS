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

public class Fragment_Inquery_Dialog extends MasterEntryDialog {
    public Fragment_Inquery_Dialog(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	private EditText data_kendaraan_txt_no_aplikasi;
    private EditText data_kendaraan_txt_jaminan;
    private EditText data_kendaraan_txt_branch;
    private EditText data_kendaraan_txt_nm_pemohon;
    private EditText data_kendaraan_txt_tipe_customer;
    private EditText data_kendaraan_txt_kelurahan;
    private EditText data_kendaraan_txt_kecamatan;
    private EditText data_kendaraan_txt_no_sertifikat;
    private EditText data_kendaraan_txt_tahapan;
    private Button btn_savedokumen;
    
   

    @Override
    protected void onInitMasterEntryDialogContentView(final Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_inquery_dialog, getContentBody());
        getContentTitle().setText("Search");
        getContentHeader().getLayoutParams().height = 750;
        //getContentHeader().invalidate();
        data_kendaraan_txt_no_aplikasi = (EditText) getContentBody().findViewById(R.id.data_kendaraan_txt_no_aplikasi);
        data_kendaraan_txt_jaminan = (EditText) getContentBody().findViewById(R.id.data_kendaraan_txt_jaminan);
        data_kendaraan_txt_branch = (EditText) getContentBody().findViewById(R.id.data_kendaraan_txt_branch);
        data_kendaraan_txt_nm_pemohon = (EditText) getContentBody().findViewById(R.id.data_kendaraan_txt_nm_pemohon);
        data_kendaraan_txt_tipe_customer= (EditText) getContentBody().findViewById(R.id.data_kendaraan_txt_tipe_customer);
        data_kendaraan_txt_kelurahan= (EditText) getContentBody().findViewById(R.id.data_kendaraan_txt_kelurahan);
        data_kendaraan_txt_kecamatan= (EditText) getContentBody().findViewById(R.id.data_kendaraan_txt_kecamatan);
        data_kendaraan_txt_no_sertifikat= (EditText) getContentBody().findViewById(R.id.data_kendaraan_txt_no_sertifikat);
        data_kendaraan_txt_tahapan= (EditText) getContentBody().findViewById(R.id.data_kendaraan_txt_tahapan);
        btn_savedokumen = (Button) getContentBody().findViewById(R.id.btn_savedokumen);
		
    }

    @Override
    public View checkContentValidation() {
     
        return null;
    }

	public EditText getData_kendaraan_txt_no_aplikasi() {
		return data_kendaraan_txt_no_aplikasi;
	}

	public void setData_kendaraan_txt_no_aplikasi(
			String string) {
		this.data_kendaraan_txt_no_aplikasi.setText(string);
	}

	public EditText getData_kendaraan_txt_jaminan() {
		return data_kendaraan_txt_jaminan;
	}

	public void setData_kendaraan_txt_jaminan(String string) {
		this.data_kendaraan_txt_jaminan.setText(string);
	}

	public EditText getData_kendaraan_txt_branch() {
		return data_kendaraan_txt_branch;
	}

	public void setData_kendaraan_txt_branch(String string) {
		this.data_kendaraan_txt_branch.setText(string);
	}

	public EditText getData_kendaraan_txt_nm_pemohon() {
		return data_kendaraan_txt_nm_pemohon;
	}

	public void setData_kendaraan_txt_nm_pemohon(
			String string) {
		this.data_kendaraan_txt_nm_pemohon.setText(string);
	}

	public EditText getData_kendaraan_txt_tipe_customer() {
		return data_kendaraan_txt_tipe_customer;
	}

	public void setData_kendaraan_txt_tipe_customer(
			String string) {
		this.data_kendaraan_txt_tipe_customer.setText(string);
	}

	public EditText getData_kendaraan_txt_kelurahan() {
		return data_kendaraan_txt_kelurahan;
	}

	public void setData_kendaraan_txt_kelurahan(
			String string) {
		this.data_kendaraan_txt_kelurahan.setText(string);
	}

	public EditText getData_kendaraan_txt_kecamatan() {
		return data_kendaraan_txt_kecamatan;
	}

	public void setData_kendaraan_txt_kecamatan(
			String string) {
		this.data_kendaraan_txt_kecamatan.setText(string);
	}

	public EditText getData_kendaraan_txt_no_sertifikat() {
		return data_kendaraan_txt_no_sertifikat;
	}

	public void setData_kendaraan_txt_no_sertifikat(
			String string) {
		this.data_kendaraan_txt_no_sertifikat.setText(string);
	}

	public EditText getData_kendaraan_txt_tahapan() {
		return data_kendaraan_txt_tahapan;
	}

	public void setData_kendaraan_txt_tahapan(String string) {
		this.data_kendaraan_txt_tahapan.setText(string);
	}

	public Button getBtn_savedokumen() {
		return btn_savedokumen;
	}

	public void setBtn_savedokumen(Button btn_savedokumen) {
		this.btn_savedokumen = btn_savedokumen;
	}



}
