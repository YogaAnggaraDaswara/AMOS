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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;

import bii.mobile.amos.R;

import com.mobile.app.ui.DatePickerManager;
import com.mobile.app.ui.MasterEntryDialog;
import com.mobile.framework.common.NumberTextWatcher;
import com.mobile.framework.common.StringUtility;

public class Fragment_Dokumen_Jaminan_Dialog extends MasterEntryDialog {
    private EditText data_kendaraan_txt_nama_dokumen;
    private EditText val_rtb_txt_tgl_kadaluarsa;
    private ImageView val_rtb_view_img_tgl_kadaluarsa;
    private EditText data_kendaraan_txt_no_dokumen;
    private RadioButton data_kendaraan_rdo_asli;
    private RadioButton data_kendaraan_rdo_na;
    private RadioButton data_kendaraan_rdo_copy;
    private RadioButton data_kendaraan_rdo_waiver;
    private RadioButton data_kendaraan_rdo_tbo;
    private EditText val_rtb_txt_tgl_tbo;
    private ImageView val_rtb_view_img_tgl_tbo;
    private EditText data_kendaraan_txt_justifikasi;
    private EditText data_kendaraan_txt_upload;
    private EditText data_kendaraan_txt_last_upload;
    private EditText data_kendaraan_txt_id_dokumen;
    
    public Fragment_Dokumen_Jaminan_Dialog(Context context) {
        super(context);
    }

    @Override
    protected void onInitMasterEntryDialogContentView(final Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_dokumen_jaminan_dialog, getContentBody());
        getContentTitle().setText(context.getString(R.string.DOKJAMINAN));
        getContentHeader().getLayoutParams().height = 700;
        //getContentHeader().invalidate();
        data_kendaraan_txt_nama_dokumen = (EditText) getContentBody().findViewById(R.id.data_kendaraan_txt_nama_dokumen);
        data_kendaraan_txt_id_dokumen = (EditText) getContentBody().findViewById(R.id.data_kendaraan_txt_id_dokumen);
        data_kendaraan_txt_no_dokumen = (EditText) getContentBody().findViewById(R.id.data_kendaraan_txt_no_dokumen);
        val_rtb_txt_tgl_kadaluarsa = (EditText) getContentBody().findViewById(R.id.val_rtb_txt_tgl_kadaluarsa);
        val_rtb_view_img_tgl_kadaluarsa = (ImageView) getContentBody().findViewById(R.id.val_rtb_view_img_tgl_kadaluarsa);
        data_kendaraan_rdo_asli = (RadioButton) getContentBody().findViewById(R.id.data_kendaraan_rdo_asli);
        data_kendaraan_rdo_copy= (RadioButton) getContentBody().findViewById(R.id.data_kendaraan_rdo_copy);
        data_kendaraan_rdo_na= (RadioButton) getContentBody().findViewById(R.id.data_kendaraan_rdo_na);
        data_kendaraan_rdo_waiver= (RadioButton) getContentBody().findViewById(R.id.data_kendaraan_rdo_waiver);
        data_kendaraan_rdo_tbo= (RadioButton) getContentBody().findViewById(R.id.data_kendaraan_rdo_tbo);
        val_rtb_txt_tgl_tbo= (EditText) getContentBody().findViewById(R.id.val_rtb_txt_tgl_tbo);
        val_rtb_view_img_tgl_tbo= (ImageView) getContentBody().findViewById(R.id.val_rtb_view_img_tgl_tbo);
        data_kendaraan_txt_justifikasi= (EditText) getContentBody().findViewById(R.id.data_kendaraan_txt_justifikasi);
        data_kendaraan_txt_upload= (EditText) getContentBody().findViewById(R.id.data_kendaraan_txt_upload);
        data_kendaraan_txt_last_upload = (EditText) getContentBody().findViewById(R.id.data_kendaraan_txt_last_upload);
			
		btn_savedokumen = (Button) getContentBody().findViewById(R.id.btn_savedokumen);
		val_rtb_view_img_tgl_kadaluarsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] arrTglLahir = null;

                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = (c.get(Calendar.MONTH));
                int day = c.get(Calendar.DAY_OF_MONTH);
                try{
	                if (val_rtb_txt_tgl_kadaluarsa.getText().toString().equalsIgnoreCase("")) {
	                    arrTglLahir = val_rtb_txt_tgl_kadaluarsa.getText().toString().split("-");
	                    year = Integer.parseInt(arrTglLahir[2]);
	                    month = Integer.parseInt(arrTglLahir[1]) - 1;
	                    day = Integer.parseInt(arrTglLahir[0]);
	                }
                }
                catch(Exception e){
                	
                }
                DatePickerManager datePickerDialog = new DatePickerManager(context, PbTglLaporDateSetListener, year, month, day);
                datePickerDialog.show();

            }
        });
		val_rtb_view_img_tgl_tbo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] arrTglLahir = null;

                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = (c.get(Calendar.MONTH));
                int day = c.get(Calendar.DAY_OF_MONTH);
                try{
	                if (val_rtb_txt_tgl_tbo.getText().toString().equalsIgnoreCase("")) {
	                    arrTglLahir = val_rtb_txt_tgl_tbo.getText().toString().split("-");
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
    }
    private DatePickerDialog.OnDateSetListener PbTglLaporDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int monthOfYear, int dayOfMonth) {
        	val_rtb_txt_tgl_kadaluarsa.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
        }
    };
    private DatePickerDialog.OnDateSetListener Pbtxt_tgl_tboDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int monthOfYear, int dayOfMonth) {
        	val_rtb_txt_tgl_tbo.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
        }
    };
	@Override
	public View checkContentValidation() {
		// TODO Auto-generated method stub
		return null;
	}
	
    public EditText getData_kendaraan_txt_nama_dokumen() {
		return data_kendaraan_txt_nama_dokumen;
	}
    public String getdata_kendaraan_txt_id_dokumen() {
		return data_kendaraan_txt_id_dokumen.getText().toString();
	}
    public void setData_kendaraan_txt_id_dokumen(String data_kendaraan_txt_id_dokumen) {
		this.data_kendaraan_txt_id_dokumen.setText(data_kendaraan_txt_id_dokumen);
	}
	public void setData_kendaraan_txt_nama_dokumen(String data_kendaraan_txt_nama_dokumen) {
		this.data_kendaraan_txt_nama_dokumen.setText(data_kendaraan_txt_nama_dokumen);
	}

	public String getVal_rtb_txt_tgl_kadaluarsa() {
		return val_rtb_txt_tgl_kadaluarsa.getText().toString();
	}

	public void setVal_rtb_txt_tgl_kadaluarsa(String val_rtb_txt_tgl_kadaluarsa) {
		this.val_rtb_txt_tgl_kadaluarsa.setText(val_rtb_txt_tgl_kadaluarsa);
	}

	public ImageView getVal_rtb_view_img_tgl_kadaluarsa() {
		return val_rtb_view_img_tgl_kadaluarsa;
	}

	public void setVal_rtb_view_img_tgl_kadaluarsa(
			ImageView val_rtb_view_img_tgl_kadaluarsa) {
		this.val_rtb_view_img_tgl_kadaluarsa = val_rtb_view_img_tgl_kadaluarsa;
	}

	public String getData_kendaraan_txt_no_dokumen() {
		return data_kendaraan_txt_no_dokumen.getText().toString();
	}

	public void setData_kendaraan_txt_no_dokumen(String data_kendaraan_txt_no_dokumen) {
		this.data_kendaraan_txt_no_dokumen.setText(data_kendaraan_txt_no_dokumen);
	}

	public RadioButton getData_kendaraan_rdo_asli() {
		return data_kendaraan_rdo_asli;
	}

	public void setData_kendaraan_rdo_asli(boolean data_kendaraan_rdo_asli) {
		this.data_kendaraan_rdo_asli.setChecked(data_kendaraan_rdo_asli);
	}

	public RadioButton getData_kendaraan_rdo_na() {
		return data_kendaraan_rdo_na;
	}

	public void setData_kendaraan_rdo_na(boolean data_kendaraan_rdo_na) {
		this.data_kendaraan_rdo_na.setChecked(data_kendaraan_rdo_na);
	}

	public RadioButton getData_kendaraan_rdo_copy() {
		return data_kendaraan_rdo_copy;
	}

	public void setData_kendaraan_rdo_copy(boolean data_kendaraan_rdo_copy) {
		this.data_kendaraan_rdo_copy.setChecked( data_kendaraan_rdo_copy);
	}

	public RadioButton getData_kendaraan_rdo_waiver() {
		return data_kendaraan_rdo_waiver;
	}

	public void setData_kendaraan_rdo_waiver(boolean data_kendaraan_rdo_waiver) {
		this.data_kendaraan_rdo_waiver.setChecked( data_kendaraan_rdo_waiver);
	}

	public RadioButton getData_kendaraan_rdo_tbo() {
		return data_kendaraan_rdo_tbo;
	}

	public void setData_kendaraan_rdo_tbo(boolean data_kendaraan_rdo_tbo) {
		this.data_kendaraan_rdo_tbo.setChecked( data_kendaraan_rdo_tbo);
	}

	public String getVal_rtb_txt_tgl_tbo() {
		return val_rtb_txt_tgl_tbo.getText().toString();
	}

	public void setVal_rtb_txt_tgl_tbo(String val_rtb_txt_tgl_tbo) {
		this.val_rtb_txt_tgl_tbo.setText(val_rtb_txt_tgl_tbo);
	}

	public ImageView getVal_rtb_view_img_tgl_tbo() {
		return val_rtb_view_img_tgl_tbo;
	}

	public void setVal_rtb_view_img_tgl_tbo(ImageView val_rtb_view_img_tgl_tbo) {
		this.val_rtb_view_img_tgl_tbo = val_rtb_view_img_tgl_tbo;
	}

	public String getData_kendaraan_txt_justifikasi() {
		return data_kendaraan_txt_justifikasi.getText().toString();
	}

	public void setData_kendaraan_txt_justifikasi(String data_kendaraan_txt_justifikasi) {
		this.data_kendaraan_txt_justifikasi.setText(data_kendaraan_txt_justifikasi);
	}

	public String getData_kendaraan_txt_upload() {
		return data_kendaraan_txt_upload.getText().toString();
	}

	public void setData_kendaraan_txt_upload(String data_kendaraan_txt_upload) {
		this.data_kendaraan_txt_upload.setText(data_kendaraan_txt_upload);
	}

	public String getData_kendaraan_txt_last_upload() {
		return data_kendaraan_txt_last_upload.getText().toString();
	}

	public void setData_kendaraan_txt_last_upload(String data_kendaraan_txt_last_upload) {
		this.data_kendaraan_txt_last_upload.setText(data_kendaraan_txt_last_upload);
	}

	public Button getBtn_savedokumen() {
		return btn_savedokumen;
	}

	public void setBtn_savedokumen(Button btn_savedokumen) {
		this.btn_savedokumen = btn_savedokumen;
	}

	private Button btn_savedokumen;

    

    
}
