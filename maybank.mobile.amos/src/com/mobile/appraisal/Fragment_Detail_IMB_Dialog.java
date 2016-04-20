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

public class Fragment_Detail_IMB_Dialog extends MasterEntryDialog {
    private EditText data_kendaraan_txt_no_imb;
    private EditText data_kendaraan_txt_id;
    private EditText data_kendaraan_txt_seq;
    private EditText val_kendaraan_txt_tgl_imb;
    private EditText data_kendaraan_txt_peruntukan;
    private ImageView val_kendaraan_view_img_imb;
    private Button btn_saveimb;

    
    
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

	public String getData_kendaraan_txt_no_imb() {
		return data_kendaraan_txt_no_imb.getText().toString();
	}

	public void setData_kendaraan_txt_no_imb(String data_kendaraan_txt_no_imb) {
		this.data_kendaraan_txt_no_imb.setText(data_kendaraan_txt_no_imb);
	}

	public String getVal_kendaraan_txt_tgl_imb() {
		return val_kendaraan_txt_tgl_imb.getText().toString();
	}

	public void setVal_kendaraan_txt_tgl_imb(String val_kendaraan_txt_tgl_imb) {
		this.val_kendaraan_txt_tgl_imb.setText(val_kendaraan_txt_tgl_imb);
	}

	public String getData_kendaraan_txt_peruntukan() {
		return data_kendaraan_txt_peruntukan.getText().toString();
	}

	public void setData_kendaraan_txt_peruntukan(String data_kendaraan_txt_peruntukan) {
		this.data_kendaraan_txt_peruntukan.setText(data_kendaraan_txt_peruntukan);
	}

	public ImageView getVal_kendaraan_view_img_imb() {
		return val_kendaraan_view_img_imb;
	}

	public void setVal_kendaraan_view_img_imb(ImageView val_kendaraan_view_img_imb) {
		this.val_kendaraan_view_img_imb = val_kendaraan_view_img_imb;
	}

	public Button getBtn_saveimb() {
		return btn_saveimb;
	}

	public void setBtn_saveimb(Button btn_saveimb) {
		this.btn_saveimb = btn_saveimb;
	}

	public Fragment_Detail_IMB_Dialog(Context context) {
        super(context);
    }

    @Override
    protected void onInitMasterEntryDialogContentView(final Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_detail_imb_dialog, getContentBody());
        getContentTitle().setText("IMB");
        getContentHeader().getLayoutParams().height = 700;
        //getContentHeader().invalidate();
        data_kendaraan_txt_no_imb = (EditText) getContentBody().findViewById(R.id.data_kendaraan_txt_no_imb);
		val_kendaraan_txt_tgl_imb = (EditText) getContentBody().findViewById(R.id.val_kendaraan_txt_tgl_imb);
		data_kendaraan_txt_peruntukan = (EditText) getContentBody().findViewById(R.id.data_kendaraan_txt_peruntukan);
		val_kendaraan_view_img_imb = (ImageView) getContentBody().findViewById(R.id.val_kendaraan_view_img_imb);
		data_kendaraan_txt_id= (EditText) getContentBody().findViewById(R.id.data_kendaraan_txt_id);
		data_kendaraan_txt_seq= (EditText) getContentBody().findViewById(R.id.data_kendaraan_txt_seq);
		btn_saveimb = (Button) getContentBody().findViewById(R.id.btn_saveimb);
		val_kendaraan_view_img_imb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] arrTglLahir = null;

                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = (c.get(Calendar.MONTH));
                int day = c.get(Calendar.DAY_OF_MONTH);
                try{
	                if (val_kendaraan_txt_tgl_imb.getText().toString().equalsIgnoreCase("")) {
	                    arrTglLahir = val_kendaraan_txt_tgl_imb.getText().toString().split("-");
	                    year = Integer.parseInt(arrTglLahir[2]);
	                    month = Integer.parseInt(arrTglLahir[1]) - 1;
	                    day = Integer.parseInt(arrTglLahir[0]);
	                }
                }
                catch(Exception e){
                	
                }
                DatePickerManager datePickerDialog = new DatePickerManager(context, Pbtxt_tgl_tboDateSetListener, year, month, day);
                datePickerDialog.show();

            }
        });
		setColorMandatory();
    }
    private void setColorMandatory(){
    	val_kendaraan_txt_tgl_imb.setBackgroundResource(R.drawable.fillcolor);
    	data_kendaraan_txt_no_imb.setBackgroundResource(R.drawable.fillcolor);
    	
    }
    Boolean CekMandatory(){
    	  boolean retval=true;
    	  if(val_kendaraan_txt_tgl_imb.getText().length()==0){
    		  val_kendaraan_txt_tgl_imb.setError("Field Tidak Boleh Kososng");
    		  retval=false;
    	  }
    	  if(data_kendaraan_txt_no_imb.getText().length()==0){
    		  data_kendaraan_txt_no_imb.setError("Field Tidak Boleh Kososng");
    		  retval=false;
    	  }
    	  return retval;
    }
    private DatePickerDialog.OnDateSetListener Pbtxt_tgl_tboDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int monthOfYear, int dayOfMonth) {
        	val_kendaraan_txt_tgl_imb.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
        }
    };

    @Override
    public View checkContentValidation() {
     
        return null;
    }

 

}
