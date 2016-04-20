package com.mobile.appraisal;

import java.util.ArrayList;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import bii.mobile.amos.R;

import com.mobile.app.configuration.AppConstants;
import com.mobile.app.ui.ListOfValueAdapter;
import com.mobile.app.ui.MasterEntryDialog;
import com.mobile.bo.app.dataprovider.LOVDataProvider;
import com.mobile.framework.widget.ExSpinner;
import com.mobile.framework.widget.ISpinnerItem;

public class Fragment_PB_Sampling_Dialog extends MasterEntryDialog {
    private EditText val_vhc_txt_item ;
    private CheckBox  val_vhc_chk_ketersediaan;
    private EditText val_vhc_txt_satuan;
    private EditText val_vhc_txt_Keterangan;
    private EditText val_vhc_txt_id;
    private EditText val_vhc_txt_seq;
    
    private Button btn_save;
    
	public EditText getVal_vhc_txt_item() {
		return val_vhc_txt_item;
	}

	public void setVal_vhc_txt_item(String string) {
		this.val_vhc_txt_item.setText(string);
	}

	public CheckBox getVal_vhc_chk_ketersediaan() {
		return val_vhc_chk_ketersediaan;
	}

	public void setVal_vhc_chk_ketersediaan(boolean string) {
		this.val_vhc_chk_ketersediaan.setChecked(string);
	}

	public EditText getVal_vhc_txt_satuan() {
		return val_vhc_txt_satuan;
	}

	public void setVal_vhc_txt_satuan(String string) {
		this.val_vhc_txt_satuan.setText(string);
	}

	public EditText getVal_vhc_txt_Keterangan() {
		return val_vhc_txt_Keterangan;
	}

	public void setVal_vhc_txt_Keterangan(String string) {
		this.val_vhc_txt_Keterangan.setText(string);
	}

	public EditText getVal_vhc_txt_id() {
		return val_vhc_txt_id;
	}

	public void setVal_vhc_txt_id(String string) {
		this.val_vhc_txt_id.setText(string);
	}

	public EditText getVal_vhc_txt_seq() {
		return val_vhc_txt_seq;
	}

	public void setVal_vhc_txt_seq(String string) {
		this.val_vhc_txt_seq.setText(string);
	}

	public Button getBtn_save() {
		return btn_save;
	}

	public void setBtn_save(Button btn_save) {
		this.btn_save = btn_save;
	}


	

    public Fragment_PB_Sampling_Dialog(Context context) {
        super(context);
    }

    @Override
    protected void onInitMasterEntryDialogContentView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_nilai_sampling_persediaan_dialog, getContentBody());
        getContentTitle().setText(context.getString(R.string.PEMPENAWARAN));
        getContentHeader().getLayoutParams().height = 700;
      
        
        
        //getContentHeader().invalidate();
        val_vhc_txt_item = (EditText) getContentBody().findViewById(R.id.val_vhc_txt_item);
        val_vhc_txt_seq = (EditText) getContentBody().findViewById(R.id.val_vhc_txt_seq);
        val_vhc_txt_id = (EditText) getContentBody().findViewById(R.id.val_vhc_txt_id);
        val_vhc_chk_ketersediaan = (CheckBox) getContentBody().findViewById(R.id.val_vhc_chk_ketersediaan);
        val_vhc_txt_satuan = (EditText) getContentBody().findViewById(R.id.val_vhc_txt_satuan);
        val_vhc_txt_Keterangan= (EditText) getContentBody().findViewById(R.id.val_vhc_txt_Keterangan);
        
		btn_save = (Button) getContentBody().findViewById(R.id.btn_save);
		
		
    }

  
    @Override
    public View checkContentValidation() {
       
        return null;
    }

   

   
}
