package com.mobile.appraisal;

import java.util.ArrayList;
import java.util.Calendar;

import com.mobile.app.configuration.AppConstants;
import com.mobile.app.ui.DatePickerManager;
import com.mobile.app.ui.ListOfValueAdapter;
import com.mobile.bo.app.dataprovider.Appr_Collateral;
import com.mobile.bo.app.dataprovider.Appr_Rtb_Progress_DeveloperDataProvider;
import com.mobile.bo.app.dataprovider.LOVDataProvider;
import com.mobile.bo.app.datatype.Datatype_Appr_Collateral;
import com.mobile.bo.app.datatype.Datatype_Appr_Progress_Developer_Int;
import com.mobile.framework.common.DateFormatter;
import com.mobile.framework.widget.ExSpinner;
import com.mobile.framework.widget.ISpinnerItem;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import bii.mobile.amos.R;

public class Fragment_Progress_Developer extends Fragment {
    Button button;
    private Appr_Rtb_Progress_DeveloperDataProvider appr_progress_DataProvider=new Appr_Rtb_Progress_DeveloperDataProvider();
    private Datatype_Appr_Progress_Developer_Int appr_progress_data_int = new Datatype_Appr_Progress_Developer_Int();
    private ArrayList<ISpinnerItem> lovtranspor = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovdivisi= new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovnamapenilai= new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovkodepos= new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovsertifikat =new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovsegment =new ArrayList<ISpinnerItem>();
    private LOVDataProvider lovDataProvider;
    View view=null;
    Button Btnsave;
    private Context ctx = null;
    private EditText info_jaminan_txt_no_laporan;
    private EditText info_jaminan_txt_tgl_laporan;
    private EditText info_jaminan_txt_tgl_pemeriksaan;
    private ExSpinner info_jaminan_spn_divisi;
    private ExSpinner info_jaminan_spn_segment;
    private EditText info_jaminan_txt_bertemu_dengan;
    private EditText info_jaminan_txt_progress_bangunan;
    private EditText info_jaminan_txt_ket_lainnya;
    private CheckBox info_jaminan_chk_Pondasi;
    private EditText info_jaminan_txt_Pondasi;
    private CheckBox info_jaminan_chk_dinding;
    private EditText info_jaminan_txt_dinding;
    private CheckBox info_jaminan_chk_lantai;
    private EditText info_jaminan_txt_lantai;
    private CheckBox info_jaminan_chk_atap;
    private EditText info_jaminan_txt_atap;
    private RadioButton info_jaminan_rdo_serah_terima_siap;
    private RadioButton info_jaminan_rdo_serah_terima_belum;
    
    private RadioButton info_jaminan_rdo_pemeriksaan_luar;
    private RadioButton info_jaminan_rdo_pemeriksaan_dalam;
    private ExSpinner info_jaminan_spn_nama_penilai;
    private EditText info_jaminan_txt_alamat_lokasi;
    private EditText info_jaminan_txt_rt;
    private EditText info_jaminan_txt_rw;
    private EditText info_jaminan_txt_kelurahan;
    private EditText info_jaminan_txt_kecamatan;
    private EditText info_jaminan_txt_kota;
    private ExSpinner info_jaminan_spn_kodepos;
    private EditText info_jaminan_txt_an_sertifikat;
    private EditText info_jaminan_txt_no_sertifikat;
    private ExSpinner info_jaminan_spn_jenis_sertifikat;
    private ImageView info_jaminan_img_tgl_laporan;
    private ImageView info_jaminan_img_tgl_pemeriksaan;
    private String col_id="";
    private String ap_regno="";
    private String col_type="",status="";
	private LinearLayout contentlayout;
	private Datatype_Appr_Collateral datatype_Appr_Collateral = new Datatype_Appr_Collateral();
	private Appr_Collateral appr_Collateral=new Appr_Collateral();
	private TextView header_deb;
	private TextView header_alamat;
	
    public Fragment_Progress_Developer() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_proses_developer, null);
        ctx = this.getActivity();
        appr_progress_DataProvider=new Appr_Rtb_Progress_DeveloperDataProvider();
        appr_progress_data_int = new Datatype_Appr_Progress_Developer_Int();
        appr_Collateral=new Appr_Collateral();
        datatype_Appr_Collateral = new Datatype_Appr_Collateral();
        Bundle b = getArguments();
    	col_id=b.getString("COL_ID");
        ap_regno=b.getString("AP_REGNO");
        col_type=b.getString("COL_TYPE");
        status=b.getString("STATUS");
        initControl();
        loadData();
        return view;
    }
    private void initControl(){
    	header_deb							=(TextView) view.findViewById(R.id.info_Nama_deb);
    	header_alamat						=(TextView) view.findViewById(R.id.info_Nama_Alamat);
    	   
    	info_jaminan_txt_no_laporan= (EditText) view.findViewById(R.id.info_jaminan_txt_no_laporan);
    	info_jaminan_txt_tgl_laporan= (EditText) view.findViewById(R.id.info_jaminan_txt_tgl_laporan);
    	info_jaminan_txt_tgl_pemeriksaan= (EditText) view.findViewById(R.id.info_jaminan_txt_tgl_pemeriksaan);
    	info_jaminan_spn_divisi= (ExSpinner) view.findViewById(R.id.info_jaminan_spn_divisi);
    	info_jaminan_spn_segment= (ExSpinner) view.findViewById(R.id.info_jaminan_spn_segment);
    	info_jaminan_txt_bertemu_dengan= (EditText) view.findViewById(R.id.info_jaminan_txt_bertemu_dengan);
    	//info_jaminan_txt_progress_bangunan= (EditText) view.findViewById(R.id.info_jaminan_txt_progress_bangunan);
    	info_jaminan_txt_ket_lainnya= (EditText) view.findViewById(R.id.info_jaminan_txt_ket_lainnya);
    	info_jaminan_chk_Pondasi= (CheckBox) view.findViewById(R.id.info_jaminan_chk_Pondasi);
    	info_jaminan_txt_Pondasi= (EditText) view.findViewById(R.id.info_jaminan_txt_Pondasi);
    	info_jaminan_chk_atap= (CheckBox) view.findViewById(R.id.info_jaminan_chk_atap);
    	info_jaminan_txt_atap= (EditText) view.findViewById(R.id.info_jaminan_txt_atap);
    	info_jaminan_chk_lantai= (CheckBox) view.findViewById(R.id.info_jaminan_chk_lantai);
    	info_jaminan_txt_lantai= (EditText) view.findViewById(R.id.info_jaminan_txt_lantai);
    	info_jaminan_chk_dinding= (CheckBox) view.findViewById(R.id.info_jaminan_chk_dinding);
    	info_jaminan_txt_dinding= (EditText) view.findViewById(R.id.info_jaminan_txt_dinding);
    	info_jaminan_rdo_serah_terima_siap= (RadioButton) view.findViewById(R.id.info_jaminan_rdo_serah_terima_siap);
    	info_jaminan_rdo_serah_terima_belum= (RadioButton) view.findViewById(R.id.info_jaminan_rdo_serah_terima_belum);
    	info_jaminan_rdo_pemeriksaan_luar= (RadioButton) view.findViewById(R.id.info_jaminan_rdo_pemeriksaan_luar);
    	info_jaminan_rdo_pemeriksaan_dalam= (RadioButton) view.findViewById(R.id.info_jaminan_rdo_pemeriksaan_dalam);
    	info_jaminan_spn_nama_penilai= (ExSpinner) view.findViewById(R.id.info_jaminan_spn_nama_penilai);
    	info_jaminan_txt_alamat_lokasi= (EditText) view.findViewById(R.id.info_jaminan_txt_alamat_lokasi);
    	info_jaminan_txt_rt= (EditText) view.findViewById(R.id.info_jaminan_txt_rt);
    	info_jaminan_txt_rw= (EditText) view.findViewById(R.id.info_jaminan_txt_rw);
    	info_jaminan_txt_kelurahan= (EditText) view.findViewById(R.id.info_jaminan_txt_kelurahan);
    	info_jaminan_txt_kecamatan= (EditText) view.findViewById(R.id.info_jaminan_txt_kecamatan);
    	info_jaminan_txt_kota= (EditText) view.findViewById(R.id.info_jaminan_txt_kota);
    	info_jaminan_spn_kodepos= (ExSpinner) view.findViewById(R.id.info_jaminan_spn_kodepos);
    	info_jaminan_txt_an_sertifikat= (EditText) view.findViewById(R.id.info_jaminan_txt_an_sertifikat);
    	info_jaminan_txt_no_sertifikat= (EditText) view.findViewById(R.id.info_jaminan_txt_no_sertifikat);
    	info_jaminan_spn_jenis_sertifikat= (ExSpinner) view.findViewById(R.id.info_jaminan_spn_jenis_sertifikat);

    	lovDataProvider = new LOVDataProvider();
        lovdivisi = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_BRANCH));
        info_jaminan_spn_divisi.setListOfValue(lovdivisi, false);
        
        lovnamapenilai = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_PENILAI));
        info_jaminan_spn_nama_penilai.setListOfValue(lovnamapenilai, false);
        
        lovkodepos = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_DATI2));
        info_jaminan_spn_kodepos.setListOfValue(lovkodepos, false);
        if(col_type.equals("MHC"))
        	lovsertifikat = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_CERTIFICATE_MHC));
        
        if(col_type.equals("RE"))
        	lovsertifikat = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_CERTIFICATE_RE));
        
        if(col_type.equals("STK"))
        	lovsertifikat = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_CERTIFICATE_STK));
        
        if(col_type.equals("VER"))
        	lovsertifikat = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_CERTIFICATE_VER));
        
        info_jaminan_spn_jenis_sertifikat.setListOfValue(lovsertifikat, false);
        
        lovsegment = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_SEGMEN));
        info_jaminan_spn_segment.setListOfValue(lovsegment, false);
        
        Btnsave = (Button) view.findViewById(R.id.btn_saveprogress_developer);

    	Btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	try{
                	saveData();
                	loadData();
                }
            	catch(Exception ex){
            		showAlert(R.string.msg_notification_update_error);
            	}
           }
        }); 
    	info_jaminan_img_tgl_laporan= (ImageView) view.findViewById(R.id.info_jaminan_img_tgl_laporan);
    	info_jaminan_img_tgl_pemeriksaan= (ImageView) view.findViewById(R.id.info_jaminan_img_tgl_pemeriksaan);
       
    	info_jaminan_img_tgl_laporan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] arrTglLahir = null;

                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = (c.get(Calendar.MONTH));
                int day = c.get(Calendar.DAY_OF_MONTH);
                try{
	                if (info_jaminan_txt_tgl_laporan.getText().toString().equalsIgnoreCase("")) {
	                    arrTglLahir = info_jaminan_txt_tgl_laporan.getText().toString().split("-");
	                    year = Integer.parseInt(arrTglLahir[2]);
	                    month = Integer.parseInt(arrTglLahir[1]) - 1;
	                    day = Integer.parseInt(arrTglLahir[0]);
	                }
                }
                catch(Exception e){
                	
                }
                DatePickerManager datePickerDialog = new DatePickerManager(ctx, PbTglLaporDateSetListener, year, month, day);
                datePickerDialog.show();

            }
        });
    	
    	info_jaminan_img_tgl_pemeriksaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] arrTglLahir = null;

                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = (c.get(Calendar.MONTH));
                int day = c.get(Calendar.DAY_OF_MONTH);
                try{
                if (info_jaminan_txt_tgl_pemeriksaan.getText().toString().equalsIgnoreCase("")) {
                    arrTglLahir = info_jaminan_txt_tgl_pemeriksaan.getText().toString().split("-");
                    year = Integer.parseInt(arrTglLahir[2]);
                    month = Integer.parseInt(arrTglLahir[1]) - 1;
                    day = Integer.parseInt(arrTglLahir[0]);
                }
                }
                catch(Exception e){
                	
                }
                DatePickerManager datePickerDialog = new DatePickerManager(ctx, PbSurveyDateSetListener, year, month, day);
                datePickerDialog.show();

            }
        });
    	setColorMandatory();
    	if(status.equals("INQUERY")){
	    	contentlayout= (LinearLayout) view.findViewById(R.id.contentlayout);
	    	for(int a=0; a< contentlayout.getChildCount(); a++) {
	    		LinearLayout v1 = (LinearLayout) contentlayout.getChildAt(a);
	    	    for(int i=0; i < v1.getChildCount(); i++) {
	    	    	View v = v1.getChildAt(i);
	    	    	if (v instanceof Button) {
		    	        v.setVisibility(View.GONE); //Or View.INVISIBLE to keep its bounds
		    	    }else
		    	    if (v instanceof EditText) {
		    	        ((EditText)v).setEnabled(false);
		    	    }
		    	    if (v instanceof RadioGroup) {
		    	        ((RadioGroup)v).setEnabled(false);
		    	       
		    	    }
		    	    if (v instanceof ImageView) {
		    	        ((ImageView)v).setVisibility(View.GONE);
		    	    }
		    	    if (v instanceof ExSpinner) {
		    	        ((ExSpinner)v).setVisibility(View.GONE);
		    	    }
		    	    if (v instanceof LinearLayout) {
		    	    	 //SetEnableControl((LinearLayout) v);
		 	        	
		    	    }
		    	   
	    	    }
	    	}
    	}
		
    }
    private void setColorMandatory(){
    	info_jaminan_txt_no_laporan.setBackgroundResource(R.drawable.fillcolor);
    	info_jaminan_txt_tgl_laporan.setBackgroundResource(R.drawable.fillcolor);
    	info_jaminan_txt_tgl_pemeriksaan.setBackgroundResource(R.drawable.fillcolor);
    	info_jaminan_txt_alamat_lokasi.setBackgroundResource(R.drawable.fillcolor);
    	info_jaminan_txt_an_sertifikat.setBackgroundResource(R.drawable.fillcolor);
    	info_jaminan_txt_no_sertifikat.setBackgroundResource(R.drawable.fillcolor);
    	info_jaminan_txt_bertemu_dengan.setBackgroundResource(R.drawable.fillcolor);
    }
    private Boolean CekMandatory(){
  	  boolean retval=true;
  	appr_progress_data_int=appr_progress_DataProvider.getAllAppr_Rtb_Progress_Int(col_id);
  	if(appr_progress_data_int.COL_ID!=null && !appr_progress_data_int.COL_ID.equals("")){
		if(appr_progress_data_int.REPORT_NO==null || appr_progress_data_int.REPORT_NO.equals(""))
  			retval=false;
		if(appr_progress_data_int.REPORT_DATE==null || appr_progress_data_int.REPORT_DATE.equals(""))
  			retval=false;
		if(appr_progress_data_int.REPORT_INSPECT_DATE==null || appr_progress_data_int.REPORT_INSPECT_DATE.equals(""))
  			retval=false;
		if(appr_progress_data_int.COL_ADDR1==null || appr_progress_data_int.COL_ADDR1.equals(""))
  			retval=false;
			
		if(appr_progress_data_int.COL_DOK_NAME==null || appr_progress_data_int.COL_DOK_NAME.equals(""))
  			retval=false;
		if(appr_progress_data_int.COL_DOK_NO==null || appr_progress_data_int.COL_DOK_NO.equals(""))
  			retval=false;
			
		if(appr_progress_data_int.INSPECTOR_NAME==null || appr_progress_data_int.INSPECTOR_NAME.equals(""))
  			retval=false;
		if(appr_progress_data_int.REPORT_BRANCH_CODE==null || appr_progress_data_int.REPORT_BRANCH_CODE.equals(""))
  			retval=false;
		if(appr_progress_data_int.REPORT_SEG_CODE==null || appr_progress_data_int.REPORT_SEG_CODE.equals(""))
  			retval=false;
		if(appr_progress_data_int.COL_ZIPCODE==null || appr_progress_data_int.COL_ZIPCODE.equals(""))
  			retval=false;
		if(appr_progress_data_int.COL_APPRAISER_CODE==null || appr_progress_data_int.COL_APPRAISER_CODE.equals(""))
  			retval=false;
		if(appr_progress_data_int.COL_DOK_TYPE==null || appr_progress_data_int.COL_DOK_TYPE.equals(""))
  			retval=false;	
	}



 return retval;	
  	  
  	/*if(info_jaminan_txt_no_laporan.getText().length()==0){
  		info_jaminan_txt_no_laporan.setError("Field Tidak Boleh Kososng");
		  retval=false;
	  }
  	if(info_jaminan_txt_tgl_laporan.getText().length()==0){
  		info_jaminan_txt_tgl_laporan.setError("Field Tidak Boleh Kososng");
		  retval=false;
	  }
  	if(info_jaminan_txt_tgl_pemeriksaan.getText().length()==0){
  		info_jaminan_txt_tgl_pemeriksaan.setError("Field Tidak Boleh Kososng");
		  retval=false;
	  }
  	if(info_jaminan_txt_alamat_lokasi.getText().length()==0){
  		info_jaminan_txt_alamat_lokasi.setError("Field Tidak Boleh Kososng");
		  retval=false;
	  }
  	if(info_jaminan_txt_an_sertifikat.getText().length()==0){
  		info_jaminan_txt_an_sertifikat.setError("Field Tidak Boleh Kososng");
		  retval=false;
	  }
  	if(info_jaminan_txt_no_sertifikat.getText().length()==0){
  		info_jaminan_txt_no_sertifikat.setError("Field Tidak Boleh Kososng");
		  retval=false;
	  }
	  if(info_jaminan_txt_bertemu_dengan.getText().length()==0){
		  info_jaminan_txt_bertemu_dengan.setError("Field Tidak Boleh Kososng");
		  retval=false;
	  }
	  
	  View selectedView = info_jaminan_spn_divisi.getSelectedView();
	  if (selectedView != null && selectedView instanceof TextView) {
	      TextView selectedTextView = (TextView) selectedView;
	      if (info_jaminan_spn_divisi.getSelectedListOfValue().toString().length()==0) {
	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
	          selectedTextView.setError(errorString);
	          retval=false;
	      }
	      else {
	          selectedTextView.setError(null);
	      }
	  }
	  
	  View selectedView5 = info_jaminan_spn_segment.getSelectedView();
	  if (selectedView5 != null && selectedView5 instanceof TextView) {
	      TextView selectedTextView = (TextView) selectedView5;
	      if (info_jaminan_spn_segment.getSelectedListOfValue().toString().length()==0) {
	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
	          selectedTextView.setError(errorString);
	          retval=false;
	      }
	      else {
	          selectedTextView.setError(null);
	      }
	  }
	  
	  
	  View selectedView1 = info_jaminan_spn_segment.getSelectedView();
	  if (selectedView1 != null && selectedView1 instanceof TextView) {
	      TextView selectedTextView = (TextView) selectedView1;
	      if (info_jaminan_spn_segment.getSelectedListOfValue().toString().length()==0) {
	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
	          selectedTextView.setError(errorString);
	          retval=false;
	      }
	      else {
	          selectedTextView.setError(null);
	      }
	  }
	  View selectedView2 = info_jaminan_spn_nama_penilai.getSelectedView();
	  if (selectedView2 != null && selectedView2 instanceof TextView) {
	      TextView selectedTextView = (TextView) selectedView2;
	      if (info_jaminan_spn_nama_penilai.getSelectedListOfValue().toString().length()==0) {
	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
	          selectedTextView.setError(errorString);
	          retval=false;
	      }
	      else {
	          selectedTextView.setError(null);
	      }
	  }	  
	  
	  
	  View selectedView3 = info_jaminan_spn_jenis_sertifikat.getSelectedView();
	  if (selectedView3 != null && selectedView3 instanceof TextView) {
	      TextView selectedTextView = (TextView) selectedView3;
	      if (info_jaminan_spn_jenis_sertifikat.getSelectedListOfValue().toString().length()==0) {
	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
	          selectedTextView.setError(errorString);
	          retval=false;
	      }
	      else {
	          selectedTextView.setError(null);
	      }
	  }	 
	  
  	  return retval; */
    }
    private DatePickerDialog.OnDateSetListener PbSurveyDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int monthOfYear, int dayOfMonth) {
        	info_jaminan_txt_tgl_pemeriksaan.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
        }
    };
    private DatePickerDialog.OnDateSetListener PbTglLaporDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int monthOfYear, int dayOfMonth) {
        	info_jaminan_txt_tgl_laporan.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
        }
    };
    private void saveData(){
    
	    	appr_progress_data_int.setCOL_ID(col_id);
	    	appr_progress_data_int.setAP_REGNO(ap_regno);
	    	appr_progress_data_int.setREPORT_NO(info_jaminan_txt_no_laporan.getText().toString());
	    	appr_progress_data_int.setREPORT_DATE(DateFormatter.formatDate(info_jaminan_txt_tgl_laporan.getText().toString()));
	    	appr_progress_data_int.setREPORT_INSPECT_DATE(DateFormatter.formatDate(info_jaminan_txt_tgl_pemeriksaan.getText().toString()));
	    	appr_progress_data_int.setREPORT_BRANCH_CODE(info_jaminan_spn_divisi.getSelectedListOfValue().toString());
	    	appr_progress_data_int.setREPORT_SEG_CODE(info_jaminan_spn_segment.getSelectedListOfValue().toString());
	    	appr_progress_data_int.setINSPECTOR_NAME(info_jaminan_txt_bertemu_dengan.getText().toString());
	    	
	    	//appr_progress_data_int.setBUILDING_PROGRESS(info_jaminan_txt_progress_bangunan.getText().toString());
	    	appr_progress_data_int.setBUILDING_PROGRESS("0");
	    	appr_progress_data_int.setBUILDING_PROGRESS_DATA(info_jaminan_txt_ket_lainnya.getText().toString());
	    	if(info_jaminan_chk_Pondasi.isChecked()){
	    		appr_progress_data_int.setPONDASI(AppConstants.RDOYA);
	    	}
	    	else{
	    		appr_progress_data_int.setPONDASI(AppConstants.RDOTIDAK);
	    	}
	    	appr_progress_data_int.setPONDASI_KET(info_jaminan_txt_Pondasi.getText().toString());
	    	if(info_jaminan_chk_atap.isChecked()){
	    		appr_progress_data_int.setATAP(AppConstants.RDOYA);
	    	}
	    	else{
	    		appr_progress_data_int.setATAP(AppConstants.RDOTIDAK);
	    	}
	    	appr_progress_data_int.setATAP_KET(info_jaminan_txt_atap.getText().toString());
	    	if(info_jaminan_chk_lantai.isChecked()){
	    		appr_progress_data_int.setLANTAI(AppConstants.RDOYA);
	    	}
	    	else{
	    		appr_progress_data_int.setLANTAI(AppConstants.RDOTIDAK);
	    	}
	    	appr_progress_data_int.setLANTAI_KET(info_jaminan_txt_lantai.getText().toString());
	    	if(info_jaminan_chk_dinding.isChecked()){
	    		appr_progress_data_int.setDINDING(AppConstants.RDOYA);
	    	}
	    	else{
	    		appr_progress_data_int.setDINDING(AppConstants.RDOTIDAK);
	    	}
	    	/*if(progress_bangunan_rdo_pemeriksaan_luar.isChecked())
	    		appr_progress_data_int.setCOL_PEMERIKSAAN(AppConstants.RDOTIDAK);
	    	else if(progress_bangunan_rdo_pemeriksaan_luar.isChecked())
	    		appr_progress_data_int.setCOL_PEMERIKSAAN(AppConstants.RDOYA);*/
	    	
	    	appr_progress_data_int.setDINDING_KET(info_jaminan_txt_dinding.getText().toString());
	    	
	    	if(info_jaminan_rdo_serah_terima_siap.isChecked()){
	    		appr_progress_data_int.setSERAH_TERIMA(AppConstants.RDOYA);
	    	}
	    	if(info_jaminan_rdo_serah_terima_belum.isChecked()){
	    		appr_progress_data_int.setSERAH_TERIMA(AppConstants.RDOTIDAK);
	    	}
	    	if(info_jaminan_rdo_pemeriksaan_luar.isChecked()){
	    		appr_progress_data_int.setCOL_PEMERIKSAAN(AppConstants.RDOYA);
	    	}
	    	if(info_jaminan_rdo_pemeriksaan_dalam.isChecked()){
	    		appr_progress_data_int.setCOL_PEMERIKSAAN(AppConstants.RDOTIDAK);
	    	}
	    	appr_progress_data_int.setCOL_APPRAISER_CODE(info_jaminan_spn_nama_penilai.getSelectedListOfValue().toString());
	    	appr_progress_data_int.setCOL_ADDR1(info_jaminan_txt_alamat_lokasi.getText().toString());
	    	appr_progress_data_int.setCOL_RT(info_jaminan_txt_rt.getText().toString());
	    	appr_progress_data_int.setCOL_RW(info_jaminan_txt_rw.getText().toString());
	    	appr_progress_data_int.setCOL_KELURAHAN(info_jaminan_txt_kelurahan.getText().toString());
	    	appr_progress_data_int.setCOL_KECAMATAN(info_jaminan_txt_kecamatan.getText().toString());
	    	appr_progress_data_int.setCOL_CITY(info_jaminan_txt_kota.getText().toString());
	    	appr_progress_data_int.setCOL_DOK_NAME(info_jaminan_txt_an_sertifikat.getText().toString());
	    	appr_progress_data_int.setCOL_DOK_NO(info_jaminan_txt_no_sertifikat.getText().toString());
	    	appr_progress_data_int.setCOL_DOK_TYPE(info_jaminan_spn_jenis_sertifikat.getSelectedListOfValue().toString());
	    	appr_progress_data_int.setCOL_ZIPCODE(info_jaminan_spn_kodepos.getSelectedListOfValue().toString());
	     	appr_progress_DataProvider.updateData(appr_progress_data_int);
	     	showAlert(R.string.msg_notification_update_success);
    		if(CekMandatory().equals(false)){
    			showAlert(R.string.msg_notification_mandatory);
    		}
    }
	
    public void showAlert(int messageId) {
	AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctx);
	alertDialog.setTitle(R.string.MESSAGE);
	alertDialog.setMessage(messageId);
	alertDialog.setPositiveButton(R.string.str_ok, new DialogInterface.OnClickListener() {
	public void onClick(DialogInterface dialog, int which) {
	    dialog.cancel();
	}
	});
	alertDialog.show();
	}
    public static String replaceNull(String input) {
    	  return input == null ? "" : input;
    	}
    private void loadData(){
    	appr_progress_data_int=appr_progress_DataProvider.getAllAppr_Rtb_Progress_Int(col_id);
      	if(appr_progress_data_int.COL_ID!=null && !appr_progress_data_int.COL_ID.equals("")){
      		info_jaminan_txt_no_laporan.setText(replaceNull(appr_progress_data_int.getREPORT_NO()));
      		if (appr_progress_data_int.getREPORT_DATE() != null) {
      			info_jaminan_txt_tgl_laporan.setText(replaceNull(DateFormatter.formatString(appr_progress_data_int.getREPORT_DATE())));
	         }
	    	 if (appr_progress_data_int.getREPORT_INSPECT_DATE() != null) {
	    		 info_jaminan_txt_tgl_pemeriksaan.setText(replaceNull(DateFormatter.formatString(appr_progress_data_int.getREPORT_INSPECT_DATE())));
	         }
	    	 
	    	 datatype_Appr_Collateral=appr_Collateral.getAllAppr_Collateral(col_id);
	    	 if(datatype_Appr_Collateral.COL_ID!=null && !datatype_Appr_Collateral.COL_ID.toString().equals("")){
	    	     header_deb.setText(datatype_Appr_Collateral.getAP_REGNO() + " # " + datatype_Appr_Collateral.getCU_NAME() );
	    	 }
    	 	header_alamat.setText(appr_progress_data_int.getCOL_ADDR1() + " , " +  appr_progress_data_int.getCOL_KELURAHAN() + " , " +  appr_progress_data_int.getCOL_KECAMATAN() + " , " +  appr_progress_data_int.getCOL_CITY() + " , " +  appr_progress_data_int.getCOL_ZIPCODE());

	    	 info_jaminan_spn_divisi.setSelectedListOfValue(replaceNull(appr_progress_data_int.getREPORT_BRANCH_CODE()));
      		info_jaminan_spn_segment.setSelectedListOfValue(replaceNull(appr_progress_data_int.getREPORT_SEG_CODE()));
      		info_jaminan_txt_bertemu_dengan.setText(replaceNull(appr_progress_data_int.getINSPECTOR_NAME()));
      		//info_jaminan_txt_progress_bangunan.setText(replaceNull(appr_progress_data_int.getBUILDING_PROGRESS()));
      		info_jaminan_txt_ket_lainnya.setText(replaceNull(appr_progress_data_int.getBUILDING_PROGRESS_DATA()));
      		if(appr_progress_data_int.getPONDASI().equals(AppConstants.RDOYA)){
      			info_jaminan_chk_Pondasi.setChecked(true);	
      		}
      		else{
      			info_jaminan_chk_Pondasi.setChecked(false);
      		}
      		info_jaminan_txt_Pondasi.setText(replaceNull(appr_progress_data_int.getPONDASI_KET()));	
      		//info_jaminan_chk_atap.setText(replaceNull(appr_progress_data_int.getATAP()));
      		if(appr_progress_data_int.getATAP().equals(AppConstants.RDOYA)){
      			info_jaminan_chk_atap.setChecked(true);	
      		}
      		else{
      			info_jaminan_chk_atap.setChecked(false);
      		}
      		info_jaminan_txt_atap.setText(replaceNull(appr_progress_data_int.getATAP_KET()));
      		//info_jaminan_chk_lantai.setText(replaceNull(appr_progress_data_int.getLANTAI()));
      		if(appr_progress_data_int.getLANTAI().equals(AppConstants.RDOYA)){
      			info_jaminan_chk_lantai.setChecked(true);	
      		}
      		else{
      			info_jaminan_chk_lantai.setChecked(false);
      		}
      		info_jaminan_txt_lantai.setText(replaceNull(appr_progress_data_int.getLANTAI_KET()));
      		//info_jaminan_chk_dinding.setText(replaceNull(appr_progress_data_int.getDINDING()));
      		if(appr_progress_data_int.getDINDING().equals(AppConstants.RDOYA)){
      			info_jaminan_chk_dinding.setChecked(true);	
      		}
      		else{
      			info_jaminan_chk_dinding.setChecked(false);
      		}
      		info_jaminan_txt_dinding.setText(replaceNull(appr_progress_data_int.getDINDING_KET()));
      		if(appr_progress_data_int.getSERAH_TERIMA().equals(AppConstants.RDOYA))
      			info_jaminan_rdo_serah_terima_siap.setChecked(true);
      		if(appr_progress_data_int.getSERAH_TERIMA().equals(AppConstants.RDOTIDAK))
      			info_jaminan_rdo_serah_terima_belum.setChecked(true);
      		if(appr_progress_data_int.getCOL_PEMERIKSAAN().equals(AppConstants.RDOYA))
      			info_jaminan_rdo_pemeriksaan_luar.setChecked(true);
      		if(appr_progress_data_int.getCOL_PEMERIKSAAN().equals(AppConstants.RDOTIDAK))
      			info_jaminan_rdo_pemeriksaan_dalam.setChecked(true);	
      		info_jaminan_spn_nama_penilai.setSelectedListOfValue(replaceNull(appr_progress_data_int.getCOL_APPRAISER_CODE()));
      		info_jaminan_txt_alamat_lokasi.setText(replaceNull(appr_progress_data_int.getCOL_ADDR1()));
      		info_jaminan_txt_rt.setText(replaceNull(appr_progress_data_int.getCOL_RT()));
      		info_jaminan_txt_rw.setText(replaceNull(appr_progress_data_int.getCOL_RW()));
      		info_jaminan_txt_kelurahan.setText(replaceNull(appr_progress_data_int.getCOL_KELURAHAN()));
      		info_jaminan_txt_kecamatan.setText(replaceNull(appr_progress_data_int.getCOL_KECAMATAN()));
      		info_jaminan_txt_kota.setText(replaceNull(appr_progress_data_int.getCOL_CITY()));
      		info_jaminan_spn_kodepos.setSelectedListOfValue(replaceNull(appr_progress_data_int.getCOL_ZIPCODE()));
      		info_jaminan_txt_an_sertifikat.setText(replaceNull(appr_progress_data_int.getCOL_DOK_NAME()));
      		info_jaminan_txt_no_sertifikat.setText(replaceNull(appr_progress_data_int.getCOL_DOK_NO()));
      		info_jaminan_spn_jenis_sertifikat.setSelectedListOfValue(replaceNull(appr_progress_data_int.getCOL_DOK_TYPE()));

      	}
    	
    }
    }
