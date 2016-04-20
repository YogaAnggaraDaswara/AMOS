package com.mobile.amos;

import java.util.ArrayList;

import android.content.Context;
import android.opengl.Visibility;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import maybank.mobile.amos.R;

import com.mobile.app.ui.MasterEntryDialog;
import com.mobile.framework.widget.ExSpinner;
import com.mobile.framework.widget.ISpinnerItem;

public class Upload_Jaminan_Document_Dialog extends MasterEntryDialog {
	
	private EditText data_txt_seq;
	private EditText data_txt_id_dokumen;
	private EditText data_txt_nama_dokumen;
	private EditText data_txt_no_dokumen;
	private EditText data_txt_file_upload;
	
	private RadioGroup data_rdogroup_orig;
	private RadioButton data_document_rdo_or_asli;
	private RadioButton data_document_rdo_or_copy;
	
	private RadioGroup data_rdogroup_avail;
	private RadioButton data_document_rdo_av_ya;
	private RadioButton data_document_rdo_av_tidak;
	
	private RadioGroup data_rdogroup_valid;
	private RadioButton data_document_rdo_va_true;
	private RadioButton data_document_rdo_va_false;
	
	private Button btn_savedokumen, btn_cancel;
	private Button btn_takepicture, btn_takefile, btn_imgPreview;
	
	private LinearLayout new_dokumen_layout;
	private LinearLayout upd_dokumen_layout;
	
	private ExSpinner data_spn_dokumen_code;
    private ArrayList<ISpinnerItem> lovDokumen = new ArrayList<ISpinnerItem>();
    
    private LinearLayout search_layout_action;
    
    private  AutoCompleteTextView val_txt_auto_dokumen;
    
	public Upload_Jaminan_Document_Dialog(Context context) {
		super(context);
	}

	@Override
	protected void onInitMasterEntryDialogContentView(Context context) {
		
		// TODO Auto-generated method stub
		LayoutInflater.from(context).inflate(R.layout.amos_upload_document_jaminan_dialog, getContentBody());
		getContentTitle().setText(context.getString(R.string.DOKJAMINAN));
		getContentHeader().getLayoutParams().height = 820;
		
		data_txt_seq = (EditText) getContentBody().findViewById(R.id.data_txt_seq);
		data_txt_id_dokumen = (EditText) getContentBody().findViewById(R.id.data_txt_id_dokumen);
		data_txt_nama_dokumen = (EditText) getContentBody().findViewById(R.id.data_txt_nama_dokumen);
		data_txt_no_dokumen = (EditText) getContentBody().findViewById(R.id.data_txt_no_dokumen);
		data_txt_file_upload = (EditText) getContentBody().findViewById(R.id.data_txt_file_upload);
		data_txt_file_upload.setVisibility(View.GONE);
		data_rdogroup_orig = (RadioGroup) findViewById(R.id.data_rdogroup_orig);
		data_document_rdo_or_asli = (RadioButton) getContentBody().findViewById(R.id.data_document_rdo_or_asli);
		data_document_rdo_or_copy = (RadioButton) getContentBody().findViewById(R.id.data_document_rdo_or_copy);
		
		data_rdogroup_avail = (RadioGroup) findViewById(R.id.data_rdogroup_avail);
		data_document_rdo_av_ya = (RadioButton) getContentBody().findViewById(R.id.data_document_rdo_av_ya);
		data_document_rdo_av_tidak = (RadioButton) getContentBody().findViewById(R.id.data_document_rdo_av_tidak);
		
		data_rdogroup_valid = (RadioGroup) findViewById(R.id.data_rdogroup_valid);
		data_document_rdo_va_true = (RadioButton) getContentBody().findViewById(R.id.data_document_rdo_va_true);
		data_document_rdo_va_false = (RadioButton) getContentBody().findViewById(R.id.data_document_rdo_va_false);
		
		btn_savedokumen = (Button) getContentBody().findViewById(R.id.btn_savedokumen);
		btn_cancel = (Button) getContentBody().findViewById(R.id.btn_cancel);
		
		btn_takepicture =(Button) findViewById(R.id.btn_takepicture);
    	btn_takefile =(Button) findViewById(R.id.btn_takefile);
    	btn_imgPreview = (Button) findViewById(R.id.btn_imgPreview);
    	
    	data_spn_dokumen_code =(ExSpinner) findViewById(R.id.data_spn_dokumen_code);
    	
    	new_dokumen_layout = (LinearLayout) getContentBody().findViewById(R.id.dialog_new_dokumen);
		upd_dokumen_layout = (LinearLayout) getContentBody().findViewById(R.id.dialog_update_dokumen);
		
		search_layout_action=(LinearLayout) findViewById(R.id.search_layout_action);
		
		val_txt_auto_dokumen  = (AutoCompleteTextView) findViewById(R.id.val_txt_auto_dokumen);
		
	}
	
	@Override
	public View checkContentValidation() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getData_txt_seq() {
		return data_txt_seq.getText().toString();
	}
	public void setData_txt_seq(String data_txt_seq) {
		this.data_txt_seq.setText(data_txt_seq);
	}
	
	public String getData_txt_id_dokumen() {
		return data_txt_id_dokumen.getText().toString();
	}
	public void setData_txt_id_dokumen(String data_txt_id_dokumen) {
		this.data_txt_id_dokumen.setText(data_txt_id_dokumen);
	}
	
	public String getData_txt_nama_dokumen() {
		return data_txt_nama_dokumen.getText().toString();
	}
	public void setData_txt_nama_dokumen(String data_txt_nama_dokumen) {
		this.data_txt_nama_dokumen.setText(data_txt_nama_dokumen);
	}
	
	public String getData_txt_file_upload() {
		return data_txt_file_upload.getText().toString();
	}

	public void setData_txt_file_upload(String data_txt_file_upload) {
		this.data_txt_file_upload.setText(data_txt_file_upload);
	}
	
	public String getData_txt_no_dokumen() {
		return data_txt_no_dokumen.getText().toString();
	}
	public void setData_txt_no_dokumen(String data_txt_no_dokumen) {
		this.data_txt_no_dokumen.setText(data_txt_no_dokumen);
	}
	
	public RadioButton getData_document_rdo_or_asli() {
		return data_document_rdo_or_asli;
	}
	public void setData_document_rdo_or_asli(boolean data_document_rdo_or_asli) {
		this.data_document_rdo_or_asli.setChecked(data_document_rdo_or_asli);
	}
	
	public RadioButton getData_document_rdo_or_copy() {
		return data_document_rdo_or_copy;
	}
	public void setData_document_rdo_or_copy(boolean data_document_rdo_or_copy) {
		this.data_document_rdo_or_copy.setChecked(data_document_rdo_or_copy);
	}
	
	public RadioButton getData_document_rdo_av_ya() {
		return data_document_rdo_av_ya;
	}
	public void setData_document_rdo_av_ya(boolean data_document_rdo_av_ya) {
		this.data_document_rdo_av_ya.setChecked(data_document_rdo_av_ya);
	}
	
	public RadioButton getData_document_rdo_av_tidak() {
		return data_document_rdo_av_tidak;
	}
	public void setData_document_rdo_av_tidak(boolean data_document_rdo_av_tidak) {
		this.data_document_rdo_av_tidak.setChecked(data_document_rdo_av_tidak);
	}
	
	public RadioButton getdata_document_rdo_va_true() {
		return data_document_rdo_va_true;
	}
	public void setData_document_rdo_va_true(boolean data_document_rdo_va_true) {
		this.data_document_rdo_va_true.setChecked(data_document_rdo_va_true);
	}
	
	public RadioButton getData_document_rdo_va_false() {
		return data_document_rdo_va_false;
	}
	public void setData_document_rdo_va_false(boolean data_document_rdo_va_false) {
		this.data_document_rdo_va_false.setChecked(data_document_rdo_va_false);
	}
	
	public Button getBtn_savedokumen() {
		return btn_savedokumen;
	}
	public void setBtn_savedokumen(Button btn_savedokumen) {
		this.btn_savedokumen = btn_savedokumen;
	}
	
	public Button getBtn_cancel() {
		return btn_cancel;
	}
	public void setBtn_cancel(Button btn_cancel) {
		this.btn_cancel = btn_cancel;
	}
	
	public Button getBtn_takepicture() {
		return btn_takepicture;
	}
	public void setBtn_takepicture(Button btn_takepicture) {
		this.btn_takepicture = btn_takepicture;
	}
	
	public Button getBtn_takefile() {
		return btn_takefile;
	}
	public void setBtn_takefile(Button btn_takefile) {
		this.btn_takefile = btn_takefile;
	}
	
	public Button getBtn_imgPreview() {
		return btn_imgPreview;
	}
	public void setBtn_imgPreview(Button btn_imgPreview) {
		this.btn_imgPreview = btn_imgPreview;
	}
	
	public ExSpinner getData_spn_dokumen() {
		return data_spn_dokumen_code;
	}
	public void setData_spn_dokumen(String string) {
		this.data_spn_dokumen_code.setSelectedListOfValue(string);
	}
	public void setList_spn_dokumen(ArrayList<ISpinnerItem> List, Boolean bol) {
		this.data_spn_dokumen_code.setListOfValue(List, false);
	}
	
	public LinearLayout getNew_dokumen_layout() {
		return new_dokumen_layout;
	}
	public LinearLayout getUpd_dokumen_layout() {
		return upd_dokumen_layout;
	}
	
	public LinearLayout getSearch_Layout_Action() {
		return search_layout_action;
	}
	
	public AutoCompleteTextView getData_txt_auto_dokumen() {
		return val_txt_auto_dokumen;
	}
	public void setData_txt_auto_dokumen(String valuE) {
		this.val_txt_auto_dokumen.setText(valuE);
	}
	
	public void onBackPressed() {
        /*ActivityHandler.gotoActivity(ctx, HomeActivity.class, null);
        finish();*/
    }

}
