package com.mobile.appraisal;

import java.util.ArrayList;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import bii.mobile.amos.R;

import com.mobile.app.configuration.AppConstants;
import com.mobile.app.ui.ListOfValueAdapter;
import com.mobile.app.ui.MasterEntryDialog;
import com.mobile.bo.app.dataprovider.LOVDataProvider;
import com.mobile.bo.app.datatype.LovData;
import com.mobile.framework.widget.ExSpinner;
import com.mobile.framework.widget.ISpinnerItem;

public class Fragment_RTB_Pembanding_Dialog extends MasterEntryDialog {
    private EditText val_rtb_txt_type ;
    private EditText  val_rtb_txt_lokasi;
    private EditText val_rtb_txt_luas_tanah;
    private EditText val_rtb_txt_luas_banunan;
    private EditText val_rtb_txt_kodisi;
    private ExSpinner val_rtb_spn_penawaran;
    private EditText val_rtb_txt_harga_penawaran;
    private EditText  val_rtb_txt_adjusment;
    private ArrayList<ISpinnerItem> lovPenawaran = new ArrayList<ISpinnerItem>();
    private EditText val_rtb_txt_nara_sumber;
    private EditText val_rtb_txt_no_telp;
    private EditText val_rtb_txt_seq;
    private Button btn_save;
    private LOVDataProvider lovDataProvider;
    private LovData lovData;
   
    public EditText getVal_rtb_txt_seq() {
		return val_rtb_txt_seq;
	}

	public void setVal_rtb_txt_seq(String string) {
		this.val_rtb_txt_seq.setText(string);
	}

    public EditText getVal_rtb_txt_type() {
		return val_rtb_txt_type;
	}

	public void setVal_rtb_txt_type(String string) {
		this.val_rtb_txt_type.setText(string);
	}

	public EditText getVal_rtb_txt_lokasi() {
		return val_rtb_txt_lokasi;
	}

	public void setVal_rtb_txt_lokasi(String string) {
		this.val_rtb_txt_lokasi.setText( string);
	}

	public EditText getVal_rtb_txt_luas_tanah() {
		return val_rtb_txt_luas_tanah;
	}

	public void setVal_rtb_txt_luas_tanah(String string) {
		this.val_rtb_txt_luas_tanah.setText(string);
	}

	public EditText getVal_rtb_txt_luas_banunan() {
		return val_rtb_txt_luas_banunan;
	}

	public void setVal_rtb_txt_luas_banunan(String string) {
		this.val_rtb_txt_luas_banunan.setText(string);
	}

	public EditText getVal_rtb_txt_kodisi() {
		return val_rtb_txt_kodisi;
	}

	public void setVal_rtb_txt_kodisi(String string) {
		this.val_rtb_txt_kodisi.setText( string);
	}

	public String getVal_rtb_spn_penawaran() {
		return val_rtb_spn_penawaran.getSelectedListOfValue().toString();
	}

	public void setVal_rtb_spn_penawaran(String string) {
		this.val_rtb_spn_penawaran.setSelectedListOfValue(string);
	}

	public EditText getVal_rtb_txt_harga_penawaran() {
		return val_rtb_txt_harga_penawaran;
	}

	public void setVal_rtb_txt_harga_penawaran(String string) {
		this.val_rtb_txt_harga_penawaran.setText(string);
	}

	public EditText getVal_rtb_txt_adjusment() {
		return val_rtb_txt_adjusment;
	}

	public void setVal_rtb_txt_adjusment(String string) {
		this.val_rtb_txt_adjusment.setText(string);
	}

	public EditText getVal_rtb_txt_nara_sumber() {
		return val_rtb_txt_nara_sumber;
	}

	public void setVal_rtb_txt_nara_sumber(String string) {
		this.val_rtb_txt_nara_sumber.setText(string);
	}

	public EditText getVal_rtb_txt_no_telp() {
		return val_rtb_txt_no_telp;
	}

	public void setVal_rtb_txt_no_telp(String string) {
		this.val_rtb_txt_no_telp.setText(string);
	}

	public Button getBtn_save() {
		return btn_save;
	}

	public void setBtn_save(Button btn_save) {
		this.btn_save = btn_save;
	}

    public Fragment_RTB_Pembanding_Dialog(Context context) {
        super(context);
    }

    @Override
    protected void onInitMasterEntryDialogContentView(Context context) {
    	lovDataProvider=new LOVDataProvider();
    	lovDataProvider.deleteAllTabungan();
    	lovDataProvider.update(new LovData("1", "001", "Penawaran", "54", "1", "", ""));
    	lovDataProvider.update(new LovData("2", "002", "Transaksi", "54", "1", "", ""));
    	    
        LayoutInflater.from(context).inflate(R.layout.fragment_rtb_pembanding_dialog, getContentBody());
        getContentTitle().setText(context.getString(R.string.PEMPENAWARAN));
        getContentHeader().getLayoutParams().height = 350;
        
        //getContentHeader().invalidate();
        val_rtb_txt_type = (EditText) getContentBody().findViewById(R.id.val_rtb_txt_type);
        val_rtb_txt_lokasi = (EditText) getContentBody().findViewById(R.id.val_rtb_txt_lokasi);
        val_rtb_txt_luas_tanah = (EditText) getContentBody().findViewById(R.id.val_rtb_txt_luas_tanah);
        val_rtb_txt_luas_banunan = (EditText) getContentBody().findViewById(R.id.val_rtb_txt_luas_banunan);
        val_rtb_txt_kodisi = (EditText) getContentBody().findViewById(R.id.val_rtb_txt_kodisi);
        val_rtb_spn_penawaran= (ExSpinner) getContentBody().findViewById(R.id.val_rtb_spn_penawaran);
        val_rtb_txt_harga_penawaran= (EditText) getContentBody().findViewById(R.id.val_rtb_txt_harga_penawaran);
        val_rtb_txt_adjusment= (EditText) getContentBody().findViewById(R.id.val_rtb_txt_adjusment);
        val_rtb_txt_nara_sumber= (EditText) getContentBody().findViewById(R.id.val_rtb_txt_nara_sumber);
        val_rtb_txt_no_telp= (EditText) getContentBody().findViewById(R.id.val_rtb_txt_no_telp);
        val_rtb_txt_seq= (EditText) getContentBody().findViewById(R.id.val_rtb_txt_seq);
		btn_save = (Button) getContentBody().findViewById(R.id.btn_save);
		
		
		lovDataProvider = new LOVDataProvider();
		lovPenawaran = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_PENAWARAN));
		val_rtb_spn_penawaran.setListOfValue(lovPenawaran, false);
    }

  
    @Override
    public View checkContentValidation() {
       
        return null;
    }

   

   
}
