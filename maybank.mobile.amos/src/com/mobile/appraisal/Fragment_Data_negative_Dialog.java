package com.mobile.appraisal;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import bii.mobile.amos.R;

import com.mobile.app.configuration.AppConstants;
import com.mobile.app.ui.ListOfValueAdapter;
import com.mobile.app.ui.MasterEntryDialog;
import com.mobile.bo.app.dataprovider.LOVDataProvider;
import com.mobile.framework.common.NumberTextWatcher;
import com.mobile.framework.common.StringUtility;
import com.mobile.framework.widget.ExSpinner;
import com.mobile.framework.widget.ISpinnerItem;

public class Fragment_Data_negative_Dialog extends MasterEntryDialog {
    private ExSpinner data_kendaraan_spn_negative_list;
    private TextView data_kendaraan_txt_seq;
    private TextView data_kendaraan_txt_id;
    private Button btn_savenegative;
    private ArrayList<ISpinnerItem> lovNegative = new ArrayList<ISpinnerItem>();
    private LOVDataProvider lovDataProvider;
    
    
   
    @Override
    protected void onInitMasterEntryDialogContentView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_data_negative_dialog, getContentBody());
        getContentTitle().setText("Negative List");
        getContentHeader().getLayoutParams().height = 500;
        data_kendaraan_spn_negative_list = (ExSpinner) getContentBody().findViewById(R.id.data_kendaraan_spn_negative_list);
        data_kendaraan_txt_seq = (TextView) getContentBody().findViewById(R.id.data_kendaraan_txt_seq);
        data_kendaraan_txt_id = (TextView) getContentBody().findViewById(R.id.data_kendaraan_txt_id);
        btn_savenegative = (Button) getContentBody().findViewById(R.id.btn_savenegative);
        lovDataProvider = new LOVDataProvider();
       
       
		//lovNegative = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_NEGATIVE));
		//data_kendaraan_spn_negative_list.setListOfValue(lovNegative, false);
		
	}

   
    @Override
    public View checkContentValidation() {
        
        return null;
    }

    
    public void setData_kendaraan_spn_negative_listx( ArrayList<ISpinnerItem> data_kendaraan_spn_negative_list) {
		this.data_kendaraan_spn_negative_list.setListOfValue(data_kendaraan_spn_negative_list, false);
	}
	

	public String getData_kendaraan_spn_negative_list() {
		return data_kendaraan_spn_negative_list.getSelectedListOfValue().toString();
	}

	public void setData_kendaraan_spn_negative_list(String data_kendaraan_spn_negative_list) {
		this.data_kendaraan_spn_negative_list.setSelectedListOfValue(data_kendaraan_spn_negative_list);
	}

	public Button getBtn_savenegative() {
		return btn_savenegative;
	}

	public void setBtn_savenegative(Button btn_savenegative) {
		this.btn_savenegative = btn_savenegative;
	}

	public String getData_kendaraan_txt_seq() {
		return data_kendaraan_txt_seq.getText().toString();
	}

	public void setData_kendaraan_txt_seq(String data_kendaraan_txt_seq) {
		this.data_kendaraan_txt_seq.setText(data_kendaraan_txt_seq);
	}

	public String getData_kendaraan_txt_id() {
		return data_kendaraan_txt_id.getText().toString();
	}

	public void setData_kendaraan_txt_id(String data_kendaraan_txt_id) {
		this.data_kendaraan_txt_id.setText(data_kendaraan_txt_id);
	}

	public Fragment_Data_negative_Dialog(Context context) {
        super(context);
    }
}
