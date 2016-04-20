package com.mobile.appraisal;

import java.util.ArrayList;

import android.content.Context;
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
import com.mobile.framework.widget.ExSpinner;
import com.mobile.framework.widget.ISpinnerItem;

public class Fragment_VHC_Pembanding_Dialog extends MasterEntryDialog {
    private EditText val_vhc_txt_merk ;
    private EditText  val_vhc_txt_model;
    private EditText val_vhc_txt_warna;
    private EditText val_vhc_txt_tahun;
    private EditText val_vhc_txt_kodisi;
    private ExSpinner val_vhc_spn_penawaran;
    private ExSpinner val_vhc_spn_transmisi;
    private ExSpinner val_vhc_spn_kondisi;
    private EditText val_vhc_txt_harga_penawaran;
    private EditText  val_vhc_txt_adjusment;
    private ArrayList<ISpinnerItem> lovPenawaran = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovkondisi = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovtransmisi = new ArrayList<ISpinnerItem>();
    private EditText val_vhc_txt_nara_sumber;
    private EditText val_vhc_txt_no_telp;
    private EditText val_vhc_txt_seq;
    private Button btn_save;
    
    public String getval_vhc_spn_kondisi() {
		return val_vhc_spn_kondisi.getSelectedListOfValue().toString();
	}

	public void setval_vhc_spn_kondisi(String string) {
		this.val_vhc_spn_kondisi.setSelectedListOfValue(string);
	}
	 public String getval_vhc_spn_transmisi() {
			return val_vhc_spn_transmisi.getSelectedListOfValue().toString();
		}

		public void setval_vhc_spn_transmisi(String string) {
			this.val_vhc_spn_transmisi.setSelectedListOfValue(string);
		}
	


    public EditText getVal_vhc_txt_seq() {
		return val_vhc_txt_seq;
	}

	public void setVal_vhc_txt_seq(String string) {
		this.val_vhc_txt_seq.setText(string);
	}


	private LOVDataProvider lovDataProvider;
    
    public EditText getval_vhc_txt_merk() {
		return val_vhc_txt_merk;
	}

	public void setval_vhc_txt_merk(String string) {
		this.val_vhc_txt_merk.setText(string);
	}

	public EditText getval_vhc_txt_model() {
		return val_vhc_txt_model;
	}
	public void setval_vhc_txt_model(String string) {
		this.val_vhc_txt_model.setText( string);
	}
	public void setval_vhc_txt_warna(String string) {
		this.val_vhc_txt_warna.setText( string);
	}

	public EditText getval_vhc_txt_warna() {
		return val_vhc_txt_warna;
	}

	public void setval_vhc_txt_warnah(String string) {
		this.val_vhc_txt_warna.setText(string);
	}

	public EditText getval_vhc_txt_tahun() {
		return val_vhc_txt_tahun;
	}

	public void setval_vhc_txt_tahun(String string) {
		this.val_vhc_txt_tahun.setText(string);
	}

	public EditText getVal_vhc_txt_kodisi() {
		return val_vhc_txt_kodisi;
	}

	public void setVal_vhc_txt_kodisi(String string) {
		this.val_vhc_txt_kodisi.setText( string);
	}

	public String getVal_vhc_spn_penawaran() {
		return val_vhc_spn_penawaran.getSelectedListOfValue().toString();
	}

	public void setVal_vhc_spn_penawaran(String string) {
		this.val_vhc_spn_penawaran.setSelectedListOfValue(string);
	}

	public EditText getVal_vhc_txt_harga_penawaran() {
		return val_vhc_txt_harga_penawaran;
	}

	public void setVal_vhc_txt_harga_penawaran(String string) {
		this.val_vhc_txt_harga_penawaran.setText(string);
	}

	public EditText getVal_vhc_txt_adjusment() {
		return val_vhc_txt_adjusment;
	}

	public void setVal_vhc_txt_adjusment(String string) {
		this.val_vhc_txt_adjusment.setText(string);
	}

	public EditText getVal_vhc_txt_nara_sumber() {
		return val_vhc_txt_nara_sumber;
	}

	public void setVal_vhc_txt_nara_sumber(String string) {
		this.val_vhc_txt_nara_sumber.setText(string);
	}

	public EditText getVal_vhc_txt_no_telp() {
		return val_vhc_txt_no_telp;
	}

	public void setVal_vhc_txt_no_telp(String string) {
		this.val_vhc_txt_no_telp.setText(string);
	}

	public Button getBtn_save() {
		return btn_save;
	}

	public void setBtn_save(Button btn_save) {
		this.btn_save = btn_save;
	}


	

    public Fragment_VHC_Pembanding_Dialog(Context context) {
        super(context);
    }

    @Override
    protected void onInitMasterEntryDialogContentView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_vhc_pembanding_dialog, getContentBody());
        getContentTitle().setText(context.getString(R.string.PEMPENAWARAN));
        getContentHeader().getLayoutParams().height = 700;
      
        
        
        //getContentHeader().invalidate();
        val_vhc_txt_merk = (EditText) getContentBody().findViewById(R.id.val_vhc_txt_merek);
        val_vhc_txt_model = (EditText) getContentBody().findViewById(R.id.val_vhc_txt_model);
        val_vhc_txt_warna = (EditText) getContentBody().findViewById(R.id.val_vhc_txt_warna);
        val_vhc_txt_tahun = (EditText) getContentBody().findViewById(R.id.val_vhc_txt_tahun);
        val_vhc_spn_transmisi = (ExSpinner) getContentBody().findViewById(R.id.val_vhc_spn_transmisi);
        val_vhc_spn_kondisi = (ExSpinner) getContentBody().findViewById(R.id.val_vhc_spn_kondisi);
        
        val_vhc_spn_penawaran= (ExSpinner) getContentBody().findViewById(R.id.val_vhc_spn_penawaran);
        val_vhc_txt_harga_penawaran= (EditText) getContentBody().findViewById(R.id.val_vhc_txt_harga_penawaran);
        val_vhc_txt_adjusment= (EditText) getContentBody().findViewById(R.id.val_vhc_txt_adjusment);
        val_vhc_txt_nara_sumber= (EditText) getContentBody().findViewById(R.id.val_vhc_txt_nara_sumber);
        val_vhc_txt_no_telp= (EditText) getContentBody().findViewById(R.id.val_vhc_txt_no_telp);
        val_vhc_txt_seq= (EditText) getContentBody().findViewById(R.id.val_vhc_txt_seq);
		btn_save = (Button) getContentBody().findViewById(R.id.btn_save);
		
		lovDataProvider = new LOVDataProvider();
		lovPenawaran = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_PENAWARAN));
		val_vhc_spn_penawaran.setListOfValue(lovPenawaran, false);
		
		lovkondisi = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_KONDISI));
		val_vhc_spn_kondisi.setListOfValue(lovkondisi, false);
		
		lovtransmisi = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_TRANSMISI));
		val_vhc_spn_transmisi.setListOfValue(lovtransmisi, false);
		
		setColorMandatory();
    }

    private void setColorMandatory(){
    	val_vhc_txt_warna.setBackgroundResource(R.drawable.fillcolor);
    	
    }
    @Override
    public View checkContentValidation() {
       
        return null;
    }

    Boolean CekMandatory(){
    	  boolean retval=true;
    	  if(val_vhc_txt_warna.getText().length()==0){
    		  val_vhc_txt_warna.setError("Field Tidak Boleh Kososng");
    		  retval=false;
    	  }
    	
  		 View selectedView = val_vhc_spn_penawaran.getSelectedView();
      	  if (selectedView != null && selectedView instanceof TextView) {
      	      TextView selectedTextView = (TextView) selectedView;
      	      if (val_vhc_spn_penawaran.getSelectedListOfValue().toString().length()==0) {
      	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
      	          selectedTextView.setError(errorString);
      	          retval=false;
      	      }
      	      else {
      	          selectedTextView.setError(null);
      	      }
      	  }
      	  
      	View selectedView1 = val_vhc_spn_kondisi.getSelectedView();
    	  if (selectedView1 != null && selectedView1 instanceof TextView) {
    	      TextView selectedTextView = (TextView) selectedView1;
    	      if (val_vhc_spn_kondisi.getSelectedListOfValue().toString().length()==0) {
    	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
    	          selectedTextView.setError(errorString);
    	          retval=false;
    	      }
    	      else {
    	          selectedTextView.setError(null);
    	      }
    	  }
    	  
    	  View selectedView2 = val_vhc_spn_transmisi.getSelectedView();
      	  if (selectedView2 != null && selectedView2 instanceof TextView) {
      	      TextView selectedTextView = (TextView) selectedView2;
      	      if (val_vhc_spn_transmisi.getSelectedListOfValue().toString().length()==0) {
      	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
      	          selectedTextView.setError(errorString);
      	          retval=false;
      	      }
      	      else {
      	          selectedTextView.setError(null);
      	      }
      	  }
      	  return retval;
    }

   
}
