package com.mobile.appraisal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.mobile.app.configuration.AppConstants;
import com.mobile.app.ui.DatePickerManager;
import com.mobile.app.ui.ListOfValueAdapter;
import com.mobile.bo.app.dataprovider.Appr_Collateral;
import com.mobile.bo.app.dataprovider.Appr_PB_ValuationDataProvider;
import com.mobile.bo.app.dataprovider.Appr_Pb_SamplingBangunan_Provider;
import com.mobile.bo.app.dataprovider.LOVDataProvider;
import com.mobile.bo.app.datatype.Datatype_Appr_Collateral;
import com.mobile.bo.app.datatype.Datatype_Appr_Pb_Valuation_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_Pb_sampling_bangunan;
import com.mobile.bo.app.datatype.Datatype_Appr_Rtb_Pembanding_Int;
import com.mobile.bo.app.datatype.LovData;
import com.mobile.framework.common.DateFormatter;
import com.mobile.framework.widget.ExSpinner;
import com.mobile.framework.widget.ISpinnerItem;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import bii.mobile.amos.R;

public class Fragment_Valuation_Persediaan extends Fragment {
    Button button;
    private Appr_PB_ValuationDataProvider appr_Rtb_ValuationDataProvider;
    private Appr_Pb_SamplingBangunan_Provider appr_Pb_SamplingBangunan_Provider;
    private Datatype_Appr_Pb_Valuation_Int appr_pb_valuation_int = new Datatype_Appr_Pb_Valuation_Int();
    private Datatype_Appr_Pb_sampling_bangunan appr_Pb_sampling_bangunan = new Datatype_Appr_Pb_sampling_bangunan();
    private ArrayList<Datatype_Appr_Pb_sampling_bangunan> listdataall  = null;
    private Datatype_Appr_Collateral datatype_Appr_Collateral = null;
    private Appr_Collateral appr_Collateral=new Appr_Collateral();
    

    private TextView header_deb;
    private TextView header_alamat;
    private EditText val_rb_txt_no_laporan_1;
    private EditText val_rb_txt_tgl_laporan_1;
    private EditText val_rb_txt_tgl_survey_1;
    private EditText val_rb_txt_divisi;
    private EditText val_rb_txt_segment;
    private EditText val_rb_txt_alamat_lokasi;
    private EditText val_rb_txt_rt;
    private EditText val_rb_txt_rw;
    private EditText val_rb_txt_kelurahan;
    private EditText val_rb_txt_kecamatan;
    private EditText val_rb_txt_kota;
    private ExSpinner val_rb_spn_kodepos;
    private ExSpinner val_rb_spn_nama_penilai;
    private ArrayList<ISpinnerItem> lovkodepos = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovpenilai = new ArrayList<ISpinnerItem>();
    private LOVDataProvider lovDataProvider;
    
    private EditText val_rb_txt_jumlah_cek;
    private EditText val_rb_txt_jumlah_total;
    private RadioButton val_rb_rdo_perlengkapan_pemadam_ya;
    private RadioButton val_rb_rdo_perlengkapan_pemadam_tidak;
    private RadioButton val_rb_rdo_perlengkapan_pemadam_ya_milik;
    private RadioButton val_rb_rdo_perlengkapan_pemadam_ya_bersama;
    private RadioButton val_rb_rdo_petugas_keamanan_ya;
    private RadioButton val_rb_rdo_petugas_keamanan_tidak;
    private RadioButton val_rb_rdo_petugas_keamanan_ya_milik;
    private RadioButton val_rb_rdo_petugas_keamanan_ya_bersama;
    private RadioButton val_rb_rdo_beresiko_banjir_ya;
    private RadioButton val_rb_rdo_beresiko_banjir_tidak;
    private RadioButton val_rb_rdo_beresiko_banjir_ya_pernah;
    private RadioButton val_rb_rdo_beresiko_banjir_ya_sering;
    private RadioButton val_rb_rdo_business_ya;
    private RadioButton val_rb_rdo_business_tidak;
    private EditText val_rb_txt_inspeksi;
    private LinearLayout val_rb_lbl_perlengkapan_pemadam_ya;
    private LinearLayout val_rb_lbl_petugas_keamanan_ya;
    private LinearLayout val_rb_lbl_beresiko_banjir_ya;
    
    private EditText val_rb_txt_ket_lain;
    private ImageView val_rb_view_img_survey_1;
    private ImageView val_rb_view_img_tgl_laporan_1;
    private ImageView val_rb_view_img_tgl_persediaan;
    private EditText val_rb_txt_tgl_persediaan;
    private RadioGroup val_rb_rdogroup_perlengkapan_pemadam;
    private RadioGroup val_rb_rdogroup_petugas_keamanan;
    private RadioGroup val_rb_rdogroup_beresiko_banjir;
    private String col_id="";
    private String ap_regno="";
    private String status="";
    private Context ctx = null;
    View view=null;
    Button Btnsave,btn_new;
    private TableLayout inbox_tableLayout;
    private Fragment_PB_Sampling_Dialog fragment_PB_Sampling_Dialog=null; 
    private LinearLayout contentlayout;
    public Fragment_Valuation_Persediaan() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_valuation_persediaan, null);
        ctx = this.getActivity();
        
       /* button = (Button) view.findViewById(R.id.fragment_button_button);
        button.setText("Button after clicked");*/
        appr_Pb_SamplingBangunan_Provider=new Appr_Pb_SamplingBangunan_Provider();
        appr_Rtb_ValuationDataProvider=new Appr_PB_ValuationDataProvider();
        appr_pb_valuation_int = new Datatype_Appr_Pb_Valuation_Int();
        appr_Pb_sampling_bangunan=new Datatype_Appr_Pb_sampling_bangunan();
        inbox_tableLayout = (TableLayout) view.findViewById(R.id.inbox_tableLayout);
        fragment_PB_Sampling_Dialog=new  Fragment_PB_Sampling_Dialog(ctx); 
        datatype_Appr_Collateral = new Datatype_Appr_Collateral();
        appr_Collateral=new Appr_Collateral();

        Bundle b = getArguments();
    	col_id=b.getString("COL_ID");
        ap_regno=b.getString("AP_REGNO");
        status=b.getString("STATUS");
        initControl();
        loadData();
        return view;
    }
    
    private void initControl(){
        	
    	header_deb							=(TextView) view.findViewById(R.id.info_Nama_deb);
    	header_alamat						=(TextView) view.findViewById(R.id.info_Nama_Alamat);
    	val_rb_txt_no_laporan_1= (EditText) view.findViewById(R.id.val_rb_txt_no_laporan_1);
    	
    	val_rb_lbl_perlengkapan_pemadam_ya= (LinearLayout) view.findViewById(R.id.val_rb_lbl_perlengkapan_pemadam_ya);
        val_rb_lbl_petugas_keamanan_ya= (LinearLayout) view.findViewById(R.id.val_rb_lbl_petugas_keamanan_ya);
        val_rb_lbl_beresiko_banjir_ya= (LinearLayout) view.findViewById(R.id.val_rb_lbl_beresiko_banjir_ya);
        
        val_rb_rdogroup_perlengkapan_pemadam= (RadioGroup) view.findViewById(R.id.val_rb_rdogroup_perlengkapan_pemadam);
        val_rb_rdogroup_petugas_keamanan= (RadioGroup) view.findViewById(R.id.val_rb_rdogroup_petugas_keamanan);
        val_rb_rdogroup_beresiko_banjir= (RadioGroup) view.findViewById(R.id.val_rb_rdogroup_beresiko_banjir);
        
    	val_rb_txt_tgl_laporan_1= (EditText) view.findViewById(R.id.val_rb_txt_tgl_laporan_1);
    	val_rb_txt_tgl_survey_1= (EditText) view.findViewById(R.id.val_rb_txt_tgl_survey_1);
    	val_rb_txt_divisi= (EditText) view.findViewById(R.id.val_rb_txt_divisi);
    	val_rb_txt_segment= (EditText) view.findViewById(R.id.val_rb_txt_segment);
    	val_rb_txt_alamat_lokasi= (EditText) view.findViewById(R.id.val_rb_txt_alamat_lokasi);
    	val_rb_txt_rt= (EditText) view.findViewById(R.id.val_rb_txt_rt);
    	val_rb_txt_rw= (EditText) view.findViewById(R.id.val_rb_txt_rw);
    	val_rb_txt_kelurahan= (EditText) view.findViewById(R.id.val_rb_txt_kelurahan);
    	val_rb_txt_kecamatan= (EditText) view.findViewById(R.id.val_rb_txt_kecamatan);
    	val_rb_txt_kota= (EditText) view.findViewById(R.id.val_rb_txt_kota);
    	val_rb_txt_jumlah_cek= (EditText) view.findViewById(R.id.val_rb_txt_jumlah_cek);
    	val_rb_txt_jumlah_total= (EditText) view.findViewById(R.id.val_rb_txt_jumlah_total);
    	val_rb_txt_tgl_persediaan= (EditText) view.findViewById(R.id.val_rb_txt_tgl_persediaan);
    	
    	val_rb_rdo_perlengkapan_pemadam_ya= (RadioButton) view.findViewById(R.id.val_rb_rdo_perlengkapan_pemadam_ya);
    	val_rb_rdo_perlengkapan_pemadam_tidak= (RadioButton) view.findViewById(R.id.val_rb_rdo_perlengkapan_pemadam_tidak);
    	
    	val_rb_rdo_perlengkapan_pemadam_ya_milik= (RadioButton) view.findViewById(R.id.val_rb_rdo_perlengkapan_pemadam_ya_milik);
    	val_rb_rdo_perlengkapan_pemadam_ya_bersama= (RadioButton) view.findViewById(R.id.val_rb_rdo_perlengkapan_pemadam_ya_bersama);
    	
    	val_rb_rdo_petugas_keamanan_ya= (RadioButton) view.findViewById(R.id.val_rb_rdo_petugas_keamanan_ya);
    	val_rb_rdo_petugas_keamanan_tidak= (RadioButton) view.findViewById(R.id.val_rb_rdo_petugas_keamanan_tidak);
    	
    	val_rb_rdo_petugas_keamanan_ya_milik= (RadioButton) view.findViewById(R.id.val_rb_rdo_petugas_keamanan_ya_milik);
    	val_rb_rdo_petugas_keamanan_ya_bersama= (RadioButton) view.findViewById(R.id.val_rb_rdo_petugas_keamanan_ya_bersama);
    	
    	val_rb_rdo_beresiko_banjir_ya= (RadioButton) view.findViewById(R.id.val_rb_rdo_beresiko_banjir_ya);
    	val_rb_rdo_beresiko_banjir_tidak= (RadioButton) view.findViewById(R.id.val_rb_rdo_beresiko_banjir_tidak);
    	
    	val_rb_rdo_beresiko_banjir_ya_pernah= (RadioButton) view.findViewById(R.id.val_rb_rdo_beresiko_banjir_ya_pernah);
    	val_rb_rdo_beresiko_banjir_ya_sering= (RadioButton) view.findViewById(R.id.val_rb_rdo_beresiko_banjir_ya_sering);
    	
    	val_rb_txt_inspeksi= (EditText) view.findViewById(R.id.val_rb_txt_inspeksi);
    	val_rb_rdo_business_ya= (RadioButton) view.findViewById(R.id.val_rb_rdo_business_ya);
    	val_rb_rdo_business_tidak= (RadioButton) view.findViewById(R.id.val_rb_rdo_business_tidak);
    	//val_rb_txt_ket_lain= (EditText) view.findViewById(R.id.val_rb_txt_ket_lain);
    	val_rb_view_img_tgl_persediaan= (ImageView) view.findViewById(R.id.val_rb_view_img_tgl_persediaan);
        
    	val_rb_spn_nama_penilai=(ExSpinner) view.findViewById(R.id.val_rb_spn_nama_penilai);
        lovDataProvider = new LOVDataProvider();
        lovpenilai = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_PENILAI));
        val_rb_spn_nama_penilai.setListOfValue(lovpenilai, false);
        
        
        val_rb_spn_kodepos=(ExSpinner) view.findViewById(R.id.val_rb_spn_kodepos);
        lovDataProvider = new LOVDataProvider();
        lovkodepos = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_DATI2));
        val_rb_spn_kodepos.setListOfValue(lovkodepos, false);
        
        val_rb_rdogroup_perlengkapan_pemadam.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
               RadioButton rb=(RadioButton) view.findViewById(checkedId);
               if(rb.getText().equals("Ya")){
            	   val_rb_lbl_perlengkapan_pemadam_ya.setVisibility(View.VISIBLE);
               }
               else if(rb.getText().equals("Tidak")){
            	   val_rb_lbl_perlengkapan_pemadam_ya.setVisibility(View.GONE);
               }
              
               
            }
        });
        val_rb_rdogroup_petugas_keamanan.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                RadioButton rb=(RadioButton) view.findViewById(checkedId);
               if(rb.getText().equals("Ya")){
            	   val_rb_lbl_petugas_keamanan_ya.setVisibility(View.VISIBLE);
               }
               else if(rb.getText().equals("Tidak")){
            	   val_rb_lbl_petugas_keamanan_ya.setVisibility(View.GONE);
               }
              
               
            }
        });
        
        val_rb_rdogroup_beresiko_banjir.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                RadioButton rb=(RadioButton) view.findViewById(checkedId);
               if(rb.getText().equals("Ya")){
            	   val_rb_lbl_beresiko_banjir_ya.setVisibility(View.VISIBLE);
               }
               else if(rb.getText().equals("Tidak")){
            	   val_rb_lbl_beresiko_banjir_ya.setVisibility(View.GONE);
               }
              
               
            }
        });
        Btnsave = (Button) view.findViewById(R.id.btn_savepersediaan);

    	Btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	try{
            		if(cekTanggalLaporan().equals(true)){
            		    saveData();
            		    loadData();
            		}
            		else{
            		    showAlert(R.string.msg_notification_update_laporan);
            		}                }
            	catch(Exception ex){
            		showAlert(R.string.msg_notification_update_error);
            	}
           }
        }); 
    	fragment_PB_Sampling_Dialog.getBtn_save().setOnClickListener(new View.OnClickListener() {
    	       
    	      
            @Override
            public void onClick(View v) {
            	int intCount=1;
            	if(!fragment_PB_Sampling_Dialog.getVal_vhc_txt_seq().getText().toString().equals(""))
            	{
            		intCount=Integer.parseInt(fragment_PB_Sampling_Dialog.getVal_vhc_txt_seq().getText().toString());
            	}
            	else{
            		intCount=appr_Pb_SamplingBangunan_Provider.getAllgetAllAppr_Pb_sampling_by_MaxSeq(col_id);
            	}
            	appr_Pb_sampling_bangunan.setCOL_ID(col_id);
            	appr_Pb_sampling_bangunan.setAP_REGNO(ap_regno);
            	appr_Pb_sampling_bangunan.setSEQ(""+ intCount);
            	appr_Pb_sampling_bangunan.setID(col_id + intCount);
            	
            	appr_Pb_sampling_bangunan.setITEM(fragment_PB_Sampling_Dialog.getVal_vhc_txt_item().getText().toString());
            	if(fragment_PB_Sampling_Dialog.getVal_vhc_chk_ketersediaan().isChecked())
            		appr_Pb_sampling_bangunan.setAVAILABLE(AppConstants.RDOYA);
            	else
            		appr_Pb_sampling_bangunan.setAVAILABLE(AppConstants.RDOTIDAK);
            	
            	appr_Pb_sampling_bangunan.setINFO(fragment_PB_Sampling_Dialog.getVal_vhc_txt_Keterangan().getText().toString());
            	appr_Pb_sampling_bangunan.setMEASUREMENT_UNIT(fragment_PB_Sampling_Dialog.getVal_vhc_txt_satuan().getText().toString());
            	appr_Pb_SamplingBangunan_Provider.updateData(appr_Pb_sampling_bangunan);
            	viewPersediaan();
            	fragment_PB_Sampling_Dialog.dismiss();
            }
    	});
    	
    	 btn_new = (Button) view.findViewById(R.id.btn_new);
         btn_new.setOnClickListener(new View.OnClickListener() {
     		
             @Override
             public void onClick(View v) {
            	 fragment_PB_Sampling_Dialog.setVal_vhc_txt_seq("");
            	 fragment_PB_Sampling_Dialog.setVal_vhc_txt_id("");
            	 fragment_PB_Sampling_Dialog.setVal_vhc_txt_item("");
            	 fragment_PB_Sampling_Dialog.setVal_vhc_txt_Keterangan("");
            	 fragment_PB_Sampling_Dialog.setVal_vhc_txt_satuan("");
            	 fragment_PB_Sampling_Dialog.setVal_vhc_chk_ketersediaan(false);
            	
             	
            	 fragment_PB_Sampling_Dialog.show();
             }
     	});
    	val_rb_view_img_tgl_laporan_1= (ImageView) view.findViewById(R.id.val_rb_view_img_tgl_laporan_1);
    	val_rb_view_img_survey_1= (ImageView) view.findViewById(R.id.val_rb_view_img_survey_1);

    	
    	val_rb_view_img_tgl_laporan_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] arrTglLahir = null;

                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = (c.get(Calendar.MONTH));
                int day = c.get(Calendar.DAY_OF_MONTH);
                try{
	                if (val_rb_txt_tgl_laporan_1.getText().toString().equalsIgnoreCase("")) {
	                    arrTglLahir = val_rb_txt_tgl_laporan_1.getText().toString().split("-");
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
    	
    	val_rb_view_img_survey_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] arrTglLahir = null;

                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = (c.get(Calendar.MONTH));
                int day = c.get(Calendar.DAY_OF_MONTH);
                try{
                if (val_rb_txt_tgl_survey_1.getText().toString().equalsIgnoreCase("")) {
                    arrTglLahir = val_rb_txt_tgl_survey_1.getText().toString().split("-");
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
    	////
    	if(status.equals("INQUERY")){
	    	contentlayout= (LinearLayout) view.findViewById(R.id.contentlayout);
	    	val_rb_txt_rt.setEnabled(false);
	    	val_rb_txt_rw.setEnabled(false);
	    	val_rb_rdo_perlengkapan_pemadam_ya.setEnabled(false);
	    	val_rb_rdo_perlengkapan_pemadam_tidak.setEnabled(false);
	    	val_rb_rdo_business_ya.setEnabled(false);
	    	val_rb_rdo_business_tidak.setEnabled(false);
	    	val_rb_rdo_beresiko_banjir_ya.setEnabled(false);
	    	val_rb_rdo_beresiko_banjir_tidak.setEnabled(false);
	    	val_rb_rdo_beresiko_banjir_ya_pernah.setEnabled(false);
	    	val_rb_rdo_beresiko_banjir_ya_sering.setEnabled(false);
	    	val_rb_rdo_perlengkapan_pemadam_ya_milik.setEnabled(false);
	    	val_rb_rdo_perlengkapan_pemadam_ya_bersama.setEnabled(false);
	    	val_rb_rdo_petugas_keamanan_ya.setEnabled(false);
	    	val_rb_rdo_petugas_keamanan_tidak.setEnabled(false);
	    	val_rb_rdo_petugas_keamanan_ya_milik.setEnabled(false);
	    	val_rb_rdo_petugas_keamanan_ya_bersama.setEnabled(false);
	    	val_rb_view_img_survey_1.setEnabled(false);
	    	val_rb_view_img_tgl_laporan_1.setEnabled(false);
	    	val_rb_view_img_tgl_persediaan.setEnabled(false);
	    	//SetEnableControl((LinearLayout) contentlayout);
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
    private Boolean cekTanggalLaporan(){
    	Boolean retval=true;
    	Date LaporanDate = DateFormatter.formatDate(val_rb_txt_tgl_laporan_1.getText().toString());
        Date SurveyDate=  DateFormatter.formatDate(val_rb_txt_tgl_survey_1.getText().toString());
    	
        if(LaporanDate.before(SurveyDate))
        	retval=false;
        return retval;
 }			
     private DatePickerDialog.OnDateSetListener PbSurveyDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int monthOfYear, int dayOfMonth) {
        	val_rb_txt_tgl_survey_1.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
        }
    };
    private DatePickerDialog.OnDateSetListener PbTglLaporDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int monthOfYear, int dayOfMonth) {
        	val_rb_txt_tgl_laporan_1.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
        }
    };
    public static String replaceNull(String input) {
  	  return input == null ? "" : input;
  	}
  private void loadData(){
  

  	appr_pb_valuation_int=appr_Rtb_ValuationDataProvider.getAllAppr_Pb_Valuation_Int(col_id);
  	if(appr_pb_valuation_int.COL_ID!=null){
  		val_rb_txt_no_laporan_1.setText(appr_pb_valuation_int.getREPORT_NO());
  		if (appr_pb_valuation_int.getREPORT_DATE() != null) {
  			val_rb_txt_tgl_laporan_1.setText(DateFormatter.formatString(appr_pb_valuation_int.getREPORT_DATE()));
        }
  		if (appr_pb_valuation_int.getREPORT_INSPECT_DATE() != null) {
  			val_rb_txt_tgl_survey_1.setText(DateFormatter.formatString(appr_pb_valuation_int.getREPORT_INSPECT_DATE()));
        }

  		
		datatype_Appr_Collateral=appr_Collateral.getAllAppr_Collateral(col_id);
      	if(datatype_Appr_Collateral.COL_ID!=null && !datatype_Appr_Collateral.COL_ID.toString().equals("")){
      		val_rb_txt_divisi.setText((datatype_Appr_Collateral.getBRANCHNAME()));
      		val_rb_txt_segment.setText((datatype_Appr_Collateral.getSEG_DESC()));
      		header_deb.setText(datatype_Appr_Collateral.getAP_REGNO() + " # " + datatype_Appr_Collateral.getCU_NAME() );
	  	  }
      	header_alamat.setText(appr_pb_valuation_int.getCOL_ADDR1() + " , " +  appr_pb_valuation_int.getCOL_KELURAHAN() + " , " +  appr_pb_valuation_int.getCOL_KECAMATAN() + " , " +  appr_pb_valuation_int.getCOL_CITY() + " , " +  appr_pb_valuation_int.getCOL_ZIPCODE());
  	    
  		//val_rb_txt_divisi.setText(replaceNull(appr_pb_valuation_int.getREPORT_BRANCH_CODE()));
  		//val_rb_txt_segment.setText(replaceNull(appr_pb_valuation_int.getREPORT_SEG_CODE()));
  		val_rb_txt_alamat_lokasi.setText(replaceNull(appr_pb_valuation_int.getCOL_ADDR1()));
  		val_rb_txt_rt.setText(replaceNull(appr_pb_valuation_int.getCOL_RT()));
  		val_rb_txt_rw.setText(replaceNull(appr_pb_valuation_int.getCOL_RW()));
  		val_rb_txt_kelurahan.setText(replaceNull(appr_pb_valuation_int.getCOL_KELURAHAN()));
  		val_rb_txt_kecamatan.setText(replaceNull(appr_pb_valuation_int.getCOL_KECAMATAN()));
  		val_rb_txt_kota.setText(replaceNull(appr_pb_valuation_int.getCOL_CITY()));
  		val_rb_txt_jumlah_cek.setText(replaceNull(appr_pb_valuation_int.getPB_RANDOM_SAMPLING_COUNT()));
  		val_rb_txt_jumlah_total.setText(replaceNull(appr_pb_valuation_int.getPB_TOTAL_ITEM()));
  		val_rb_txt_inspeksi.setText(replaceNull(appr_pb_valuation_int.getINSPECTION_PERSON()));
  		if (appr_pb_valuation_int.getPB_BII_DATE() != null) {
  			val_rb_txt_tgl_persediaan.setText(DateFormatter.formatString(appr_pb_valuation_int.getPB_BII_DATE()));
        }
  		
  		if(appr_pb_valuation_int.getPB_FIRETOOL().equals(AppConstants.RDOYA)){
  		  val_rb_rdo_perlengkapan_pemadam_ya.setChecked(true);  
  		}
  		else if(appr_pb_valuation_int.getPB_FIRETOOL().equals(AppConstants.RDOTIDAK)){
  		  val_rb_rdo_perlengkapan_pemadam_tidak.setChecked(true);  
  	  }
  	  
  	  if(appr_pb_valuation_int.getPB_FIRETOOL_OWNED().equals(AppConstants.RDOYA)){
  		  val_rb_rdo_perlengkapan_pemadam_ya_milik.setChecked(true);  
  	  }
  	  else if(appr_pb_valuation_int.getPB_FIRETOOL_OWNED().equals(AppConstants.RDOTIDAK)){
  		  val_rb_rdo_perlengkapan_pemadam_ya_bersama.setChecked(true);  
  	  }
  	  if(appr_pb_valuation_int.getPB_SECURITY().equals(AppConstants.RDOYA)){
  		  val_rb_rdo_petugas_keamanan_ya.setChecked(true);  
  	  }
  	  else if(appr_pb_valuation_int.getPB_SECURITY().equals(AppConstants.RDOTIDAK)){
  		  val_rb_rdo_petugas_keamanan_tidak.setChecked(true);  
  	  }
  	  
  	  if(appr_pb_valuation_int.getPB_SECURITY_OWNED().equals(AppConstants.RDOYA)){
  		  val_rb_rdo_petugas_keamanan_ya_milik.setChecked(true);  
  	  }
  	  else if(appr_pb_valuation_int.getPB_SECURITY_OWNED().equals(AppConstants.RDOTIDAK)){
  		  val_rb_rdo_petugas_keamanan_ya_bersama.setChecked(true);  
  	  }
  	  
  	  if(appr_pb_valuation_int.getPB_FLOOD_RISK().equals(AppConstants.RDOYA)){
  		  val_rb_rdo_beresiko_banjir_ya.setChecked(true);  
  	  }
  	  else   if(appr_pb_valuation_int.getPB_FLOOD_RISK().equals(AppConstants.RDOTIDAK)){
  		  val_rb_rdo_beresiko_banjir_tidak.setChecked(true);  
  	  }
  	  
  	  if(appr_pb_valuation_int.getPB_FLOOD_RISK_INTERVAL().equals(AppConstants.RDOYA)){
  		  val_rb_rdo_beresiko_banjir_ya_pernah.setChecked(true);  
  	  }
  	  else  if(appr_pb_valuation_int.getPB_FLOOD_RISK_INTERVAL().equals(AppConstants.RDOTIDAK)){
  		  val_rb_rdo_beresiko_banjir_ya_sering.setChecked(true);  
  	  }
  	  
  	  if(appr_pb_valuation_int.getINSPECTION_BUSINESSUNIT().equals(AppConstants.RDOYA)){
  		  val_rb_rdo_business_ya.setChecked(true);  
  	  }
  	  else  if(appr_pb_valuation_int.getINSPECTION_BUSINESSUNIT().equals(AppConstants.RDOTIDAK)){
  		  val_rb_rdo_business_tidak.setChecked(true);  
  	  }
  		
  		
  		//val_rb_txt_ket_lain.setText(appr_pb_valuation_int.getOTHER_INFO());
  		
  		val_rb_spn_kodepos.setSelectedListOfValue(appr_pb_valuation_int.getCOL_ZIPCODE().toString());
  		val_rb_spn_nama_penilai.setSelectedListOfValue(appr_pb_valuation_int.getCOL_APPRAISER_CODE().toString());
  		viewPersediaan();
  		val_rb_view_img_tgl_persediaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] arrTglLahir = null;

                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = (c.get(Calendar.MONTH));
                int day = c.get(Calendar.DAY_OF_MONTH);
                try{
	                if (val_rb_txt_tgl_persediaan.getText().toString().equalsIgnoreCase("")) {
	                    arrTglLahir = val_rb_txt_tgl_persediaan.getText().toString().split("-");
	                    year = Integer.parseInt(arrTglLahir[2]);
	                    month = Integer.parseInt(arrTglLahir[1]) - 1;
	                    day = Integer.parseInt(arrTglLahir[0]);
	                }
                }
                catch(Exception e){
                	
                }
                DatePickerManager datePickerDialog = new DatePickerManager(ctx, Rtbtgl_persediaanDateSetListener, year, month, day);
                datePickerDialog.show();

            }
        });
  	}
 
  }
  private void setColorMandatory(){
	  val_rb_txt_no_laporan_1.setBackgroundResource(R.drawable.fillcolor);
	  val_rb_txt_tgl_laporan_1.setBackgroundResource(R.drawable.fillcolor);
	  val_rb_txt_tgl_survey_1.setBackgroundResource(R.drawable.fillcolor);
	  val_rb_txt_alamat_lokasi.setBackgroundResource(R.drawable.fillcolor);
	  val_rb_txt_kelurahan.setBackgroundResource(R.drawable.fillcolor);
	  val_rb_txt_kecamatan.setBackgroundResource(R.drawable.fillcolor);
	  val_rb_txt_kota.setBackgroundResource(R.drawable.fillcolor);
	  val_rb_txt_jumlah_cek.setBackgroundResource(R.drawable.fillcolor);
	  val_rb_txt_jumlah_total.setBackgroundResource(R.drawable.fillcolor);
	  val_rb_txt_tgl_persediaan.setBackgroundResource(R.drawable.fillcolor);
	  val_rb_txt_inspeksi.setBackgroundResource(R.drawable.fillcolor);
	  
	
  }
  private Boolean CekMandatory(){
	  boolean retval=true;
	  
	  appr_pb_valuation_int=appr_Rtb_ValuationDataProvider.getAllAppr_Pb_Valuation_Int(col_id);
	  	if(appr_pb_valuation_int.COL_ID!=null){
	  		if(appr_pb_valuation_int.COL_ZIPCODE==null || appr_pb_valuation_int.COL_ZIPCODE.equals(""))
	      			retval=false;
	      		if(appr_pb_valuation_int.COL_APPRAISER_CODE==null || appr_pb_valuation_int.COL_APPRAISER_CODE.equals(""))
	      			retval=false;
	      		if(appr_pb_valuation_int.REPORT_NO==null || appr_pb_valuation_int.REPORT_NO.equals(""))
	      			retval=false;
	      		if(appr_pb_valuation_int.REPORT_INSPECT_DATE==null || appr_pb_valuation_int.REPORT_INSPECT_DATE.equals(""))
	      			retval=false;
	      		if(appr_pb_valuation_int.COL_ADDR1==null || appr_pb_valuation_int.COL_ADDR1.equals(""))
	      			retval=false;
					
					
				if(appr_pb_valuation_int.COL_KELURAHAN==null || appr_pb_valuation_int.COL_KELURAHAN.equals(""))
	      			retval=false;
				if(appr_pb_valuation_int.COL_KECAMATAN==null || appr_pb_valuation_int.COL_KECAMATAN.equals(""))
					retval=false;
				if(appr_pb_valuation_int.COL_CITY==null || appr_pb_valuation_int.COL_CITY.equals(""))
					retval=false;
				if(appr_pb_valuation_int.PB_RANDOM_SAMPLING_COUNT==null || appr_pb_valuation_int.PB_RANDOM_SAMPLING_COUNT.equals(""))
					retval=false;
				if(appr_pb_valuation_int.PB_TOTAL_ITEM==null || appr_pb_valuation_int.PB_TOTAL_ITEM.equals(""))
					retval=false;
				if(appr_pb_valuation_int.INSPECTION_PERSON==null || appr_pb_valuation_int.INSPECTION_PERSON.equals(""))
					retval=false;	
				if(appr_pb_valuation_int.PB_BII_DATE==null || appr_pb_valuation_int.PB_BII_DATE.equals(""))
					retval=false;								
			}
		
	 /* 
	  * COL_ZIPCODE
	  COL_APPRAISER_CODE
	  REPORT_NO
	  REPORT_INSPECT_DATE
	  COL_ADDR1
	  COL_KELURAHAN
	  COL_KECAMATAN
	  COL_CITY
	  PB_RANDOM_SAMPLING_COUNT
	  PB_TOTAL_ITEM
	  PB_BII_DATE
	  INSPECTION_PERSON
	  	  */
	  
	  
	  /*View selectedView = val_rb_spn_kodepos.getSelectedView();
	  if (selectedView != null && selectedView instanceof TextView) {
	      TextView selectedTextView = (TextView) selectedView;
	      if (val_rb_spn_kodepos.getSelectedListOfValue().toString().length()==0) {
	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
	          selectedTextView.setError(errorString);
	      }
	      else {
	          selectedTextView.setError(null);
	      }
	  }
	  
	  selectedView = val_rb_spn_nama_penilai.getSelectedView();
	  if (selectedView != null && selectedView instanceof TextView) {
	      TextView selectedTextView = (TextView) selectedView;
	      if (val_rb_spn_nama_penilai.getSelectedListOfValue().toString().length()==0) {
	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
	          selectedTextView.setError(errorString);
	      }
	      else {
	          selectedTextView.setError(null);
	      }
	  }
	  
	  if(val_rb_txt_no_laporan_1.getText().length()==0){
		  val_rb_txt_no_laporan_1.setError("Field Tidak Boleh Kososng");
		  retval=false;
	  }
	  if(val_rb_txt_no_laporan_1.getText().length()==0){
		  val_rb_txt_tgl_laporan_1.setError("Field Tidak Boleh Kososng");
		  retval=false;
	  }
	  if(val_rb_txt_tgl_survey_1.getText().length()==0){
		  val_rb_txt_tgl_survey_1.setError("Field Tidak Boleh Kososng");
		  retval=false;
	  }
	  if(val_rb_txt_alamat_lokasi.getText().length()==0){
		  val_rb_txt_alamat_lokasi.setError("Field Tidak Boleh Kososng");
		  retval=false;
	  }
	  if(val_rb_txt_kelurahan.getText().length()==0){
		  val_rb_txt_kelurahan.setError("Field Tidak Boleh Kososng");
		  retval=false;
	  }
	  if(val_rb_txt_kecamatan.getText().length()==0){
		  val_rb_txt_kecamatan.setError("Field Tidak Boleh Kososng");
		  retval=false;
	  }
	  if(val_rb_txt_kota.getText().length()==0){
		  val_rb_txt_kota.setError("Field Tidak Boleh Kososng");
		  retval=false;
	  }
	  if(val_rb_txt_jumlah_cek.getText().length()==0){
		  val_rb_txt_jumlah_cek.setError("Field Tidak Boleh Kososng");
		  retval=false;
	  }
	  if(val_rb_txt_jumlah_total.getText().length()==0){
		  val_rb_txt_jumlah_total.setError("Field Tidak Boleh Kososng");
		  retval=false;
	  }
	  if(val_rb_txt_tgl_persediaan.getText().length()==0){
		  val_rb_txt_tgl_persediaan.setError("Field Tidak Boleh Kososng");
		  retval=false;
	  }
	  if(val_rb_txt_inspeksi.getText().length()==0){
		  val_rb_txt_inspeksi.setError("Field Tidak Boleh Kososng");
		  retval=false;
	  }*/
	  
	  return retval;
  }
  
  private DatePickerDialog.OnDateSetListener Rtbtgl_persediaanDateSetListener = new DatePickerDialog.OnDateSetListener() {
      @Override
      public void onDateSet(DatePicker arg0, int year, int monthOfYear, int dayOfMonth) {
    	  val_rb_txt_tgl_persediaan.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
      }
  };
  private void saveData(){
  	
	  appr_pb_valuation_int.setCOL_ID(col_id);
	  appr_pb_valuation_int.setAP_REGNO(ap_regno);
	  appr_pb_valuation_int.setREPORT_NO(val_rb_txt_no_laporan_1.getText().toString());
	  appr_pb_valuation_int.setREPORT_DATE(DateFormatter.formatDate((val_rb_txt_tgl_laporan_1.getText().toString())));
	  appr_pb_valuation_int.setREPORT_INSPECT_DATE(DateFormatter.formatDate((val_rb_txt_tgl_survey_1.getText().toString())));
	  appr_pb_valuation_int.setREPORT_BRANCH_CODE(val_rb_txt_divisi.getText().toString());
	  appr_pb_valuation_int.setREPORT_SEG_CODE(val_rb_txt_segment.getText().toString());
	  appr_pb_valuation_int.setCOL_ADDR1(val_rb_txt_alamat_lokasi.getText().toString());
	  appr_pb_valuation_int.setCOL_RT(val_rb_txt_rt.getText().toString());
	  appr_pb_valuation_int.setCOL_RW(val_rb_txt_rw.getText().toString());
	  appr_pb_valuation_int.setCOL_KELURAHAN(val_rb_txt_kelurahan.getText().toString());
	  appr_pb_valuation_int.setCOL_KECAMATAN(val_rb_txt_kecamatan.getText().toString());
	  appr_pb_valuation_int.setCOL_CITY(val_rb_txt_kota.getText().toString());
	  
	  
	  appr_pb_valuation_int.setPB_RANDOM_SAMPLING_COUNT(val_rb_txt_jumlah_cek.getText().toString());
	  appr_pb_valuation_int.setPB_TOTAL_ITEM(val_rb_txt_jumlah_total.getText().toString());
	  appr_pb_valuation_int.setPB_BII_DATE(DateFormatter.formatDate((val_rb_txt_tgl_persediaan.getText().toString())));
	  //appr_pb_valuation_int.setOTHER_INFO(val_rb_txt_ket_lain.getText().toString());
	  if(val_rb_rdo_perlengkapan_pemadam_ya.isChecked()){
		  appr_pb_valuation_int.setPB_FIRETOOL(AppConstants.RDOYA);  
	  }
	  else{
		  appr_pb_valuation_int.setPB_FIRETOOL(AppConstants.RDOTIDAK);  
	  }
	  
	  if(val_rb_rdo_perlengkapan_pemadam_ya_milik.isChecked()){
		  appr_pb_valuation_int.setPB_FIRETOOL_OWNED(AppConstants.RDOYA);  
	  }
	  else{
		  appr_pb_valuation_int.setPB_FIRETOOL_OWNED(AppConstants.RDOTIDAK);  
	  }
	  if(val_rb_rdo_petugas_keamanan_ya.isChecked()){
		  appr_pb_valuation_int.setPB_SECURITY(AppConstants.RDOYA);  
	  }
	  else{
		  appr_pb_valuation_int.setPB_SECURITY(AppConstants.RDOTIDAK);  
	  }
	  if(val_rb_rdo_petugas_keamanan_ya_milik.isChecked()){
		  appr_pb_valuation_int.setPB_SECURITY_OWNED(AppConstants.RDOYA);  
	  }
	  else{
		  appr_pb_valuation_int.setPB_SECURITY_OWNED(AppConstants.RDOTIDAK);  
	  }
	  
	  if(val_rb_rdo_beresiko_banjir_ya.isChecked()){
		  appr_pb_valuation_int.setPB_FLOOD_RISK(AppConstants.RDOYA);  
	  }
	  else{
		  appr_pb_valuation_int.setPB_FLOOD_RISK(AppConstants.RDOTIDAK);  
	  }
	  
	  if(val_rb_rdo_beresiko_banjir_ya_pernah.isChecked()){
		  appr_pb_valuation_int.setPB_FLOOD_RISK_INTERVAL(AppConstants.RDOYA);  
	  }
	  else{
		  appr_pb_valuation_int.setPB_FLOOD_RISK_INTERVAL(AppConstants.RDOTIDAK);  
	  }
	  appr_pb_valuation_int.setINSPECTION_PERSON(val_rb_txt_inspeksi.getText().toString());
	  
	  if(val_rb_rdo_business_ya.isChecked()){
		  appr_pb_valuation_int.setINSPECTION_BUSINESSUNIT(AppConstants.RDOYA);  
	  }
	  else{
		  appr_pb_valuation_int.setINSPECTION_BUSINESSUNIT(AppConstants.RDOTIDAK);  
	  }
	  
      appr_pb_valuation_int.setCOL_APPRAISER_CODE(val_rb_spn_nama_penilai.getSelectedListOfValue().toString());
      appr_pb_valuation_int.setCOL_ZIPCODE(val_rb_spn_kodepos.getSelectedListOfValue().toString());
      appr_Rtb_ValuationDataProvider.updateData(appr_pb_valuation_int);
      
      val_rb_txt_no_laporan_1.setError(null);
      val_rb_txt_tgl_laporan_1.setError(null);
      val_rb_txt_tgl_survey_1.setError(null);
      val_rb_txt_alamat_lokasi.setError(null);
      val_rb_txt_kelurahan.setError(null);
      val_rb_txt_kecamatan.setError(null);
      val_rb_txt_kota.setError(null);
      val_rb_txt_jumlah_cek.setError(null);
      val_rb_txt_jumlah_total.setError(null);
      val_rb_txt_tgl_persediaan.setError(null);
      val_rb_txt_inspeksi.setError(null);
      showAlert(R.string.msg_notification_update_success);   
  	
      //if(CekMandatory().equals(false)){
    	//  showAlert(R.string.msg_notification_mandatory);   
      //}
  	
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
  private void viewPersediaan() {
  	
  	listdataall=appr_Pb_SamplingBangunan_Provider.getAllAppr_Pb_sampling(col_id);
  	inbox_tableLayout.removeAllViews();
  	
      TableRow rowHeaderTable = new TableRow(ctx);
      rowHeaderTable.setBackgroundColor(getResources().getColor(R.color.color_bacground2));
      rowHeaderTable.setPadding(0, 0, 0, 2);

      TableRow.LayoutParams rowParamsDetail = new TableRow.LayoutParams();
      rowParamsDetail.gravity = Gravity.LEFT;

      TextView header = new TextView(ctx);
      header.setGravity(Gravity.LEFT);
      header.setTextColor(getResources().getColor(android.R.color.black));
      header.setPadding(0, 3, 0, 3);
      header.setTextSize(12);
      header.setWidth(370);
      header.setText("Action");

      rowHeaderTable.addView(header, rowParamsDetail);

      
      TextView header10 = new TextView(ctx);
      header10.setGravity(Gravity.LEFT);
      header10.setTextColor(getResources().getColor(android.R.color.black));
      header10.setPadding(0, 3, 0, 3);
      header10.setTextSize(12);
      header10.setWidth(200);
      header10.setText("Item");

      rowHeaderTable.addView(header10, rowParamsDetail);

      TextView header9 = new TextView(ctx);
      header9.setGravity(Gravity.LEFT);
      header9.setTextColor(getResources().getColor(android.R.color.black));
      header9.setPadding(0, 2, 0,2);
      header9.setTextSize(12);
      header9.setWidth(200);
      header9.setText("Ketersediaan");
      rowHeaderTable.addView(header9, rowParamsDetail);
      
      TextView header1 = new TextView(ctx);
      header1.setGravity(Gravity.LEFT);
      header1.setTextColor(getResources().getColor(android.R.color.black));
      header1.setPadding(0, 3, 0, 3);
      header1.setTextSize(12);
      header1.setWidth(170);
      header1.setText("Satuan (dus,dll)");
      rowHeaderTable.addView(header1, rowParamsDetail);

      TextView header2 = new TextView(ctx);
      header2.setGravity(Gravity.LEFT);
      header2.setTextColor(getResources().getColor(android.R.color.black));
      header2.setPadding(0, 3, 0, 3);
      header2.setTextSize(12);
      header2.setWidth(170);
      header2.setText("Keterangan");
      rowHeaderTable.addView(header2, rowParamsDetail);

      
      inbox_tableLayout.addView(rowHeaderTable);
      String lov_desc="";
      lovDataProvider = new LOVDataProvider();
      for (int i = 0; i < listdataall.size(); i++) {
          final Datatype_Appr_Pb_sampling_bangunan contentdata = listdataall.get(i);
          final TableRow rowContentTable = new TableRow(ctx);
          if ((i + 1) % 2 == 0) {
              rowContentTable.setBackgroundColor(getResources().getColor(R.color.color_bacground1));
          } else {
              rowContentTable.setBackgroundColor(Color.WHITE);
          }
      	
  	   
          TextView content_col_id = new TextView(ctx);
          content_col_id.setText(contentdata.getID().toString());
          content_col_id.setVisibility(View.GONE);
          rowContentTable.addView(content_col_id);
          
          TextView content_seq = new TextView(ctx);
          content_seq.setText(contentdata.getSEQ().toString());
          content_seq.setVisibility(View.GONE);
          rowContentTable.addView(content_seq);
          
          Button content_detail = new Button(ctx);
          content_detail.setGravity(Gravity.CENTER);
          content_detail.setText(R.string.form_action_detail);
          //content_detail.setWidth(30);
          rowContentTable.addView(content_detail, 5, 50);
          content_detail.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
              	TextView content_id = (TextView) rowContentTable.getChildAt(0);
              	TextView content_seq = (TextView) rowContentTable.getChildAt(1);
              	TextView content_item = (TextView) rowContentTable.getChildAt(4);
              	TextView content_avaluable = (TextView) rowContentTable.getChildAt(5);
              	TextView content_unit = (TextView) rowContentTable.getChildAt(6);
              	TextView content_info = (TextView) rowContentTable.getChildAt(7);
              	
              	 fragment_PB_Sampling_Dialog.setVal_vhc_txt_seq(content_seq.getText().toString());
            	 fragment_PB_Sampling_Dialog.setVal_vhc_txt_id(content_id.getText().toString());
            	 fragment_PB_Sampling_Dialog.setVal_vhc_txt_item(content_item.getText().toString());
            	 fragment_PB_Sampling_Dialog.setVal_vhc_txt_Keterangan(content_info.getText().toString());
            	 fragment_PB_Sampling_Dialog.setVal_vhc_txt_satuan(content_unit.getText().toString());
            	 
            	 fragment_PB_Sampling_Dialog.setVal_vhc_chk_ketersediaan(Boolean.parseBoolean(content_unit.getText().toString()));
            	
             	
            	 fragment_PB_Sampling_Dialog.show();
            	 
              
             }
          });
          Button content_delete = new Button(ctx);
          content_delete.setGravity(Gravity.CENTER);
          content_delete.setText(R.string.form_action_delete);
          //content_delete.setWidth(30);
          rowContentTable.addView(content_delete, 5, 50);
          content_delete.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
              	TextView content_id = (TextView) rowContentTable.getChildAt(0);
            	TextView content_seq = (TextView) rowContentTable.getChildAt(2);
            	showConfirmationDelete(true,content_id.getText().toString());
              	
              }
          });
          
          TextView content_ap_regno = new TextView(ctx);
          content_ap_regno.setGravity(Gravity.LEFT);
          content_ap_regno.setTextColor(getResources().getColor(android.R.color.black));
          content_ap_regno.setPadding(0, 3, 0, 3);
          content_ap_regno.setTextSize(12);
          content_ap_regno.setWidth(200);
          content_ap_regno.setText(contentdata.getITEM().toString());
          rowContentTable.addView(content_ap_regno, rowParamsDetail);

          TextView content_jaminan = new TextView(ctx);
          content_jaminan.setGravity(Gravity.LEFT);
          content_jaminan.setTextColor(getResources().getColor(android.R.color.black));
          content_jaminan.setPadding(0, 3, 0, 3);
          content_jaminan.setTextSize(12);
          content_jaminan.setWidth(200);
          content_jaminan.setText(contentdata.getAVAILABLE().toString());
          rowContentTable.addView(content_jaminan, rowParamsDetail);

          TextView content_nama = new TextView(ctx);
          content_nama.setGravity(Gravity.LEFT);
          content_nama.setTextColor(getResources().getColor(android.R.color.black));
          content_nama.setPadding(0, 3, 0, 3);
          content_nama.setTextSize(12);
          content_nama.setWidth(170);
          content_nama.setText(contentdata.getMEASUREMENT_UNIT().toString());
          rowContentTable.addView(content_nama, rowParamsDetail);

          TextView content_tipe = new TextView(ctx);
          content_tipe.setGravity(Gravity.LEFT);
          content_tipe.setTextColor(getResources().getColor(android.R.color.black));
          content_tipe.setPadding(0, 3, 0, 3);
          content_tipe.setTextSize(12);
          content_tipe.setWidth(170);
          content_tipe.setText(contentdata.getINFO().toString());
          rowContentTable.addView(content_tipe,rowParamsDetail);


          inbox_tableLayout.addView(rowContentTable);
      }
  	}
  
  public void showConfirmationDelete(final boolean isparent,final String id) {
      AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctx);
      alertDialog.setTitle("Confirm");
      alertDialog.setMessage(R.string.msg_notification_delete);
      alertDialog.setPositiveButton(R.string.str_yes, new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int which) {
          	try {
          			appr_Pb_SamplingBangunan_Provider.deleteTransaksiById(id);
          			viewPersediaan();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

              dialog.dismiss();
          }
      });

      // on pressing cancel button
      alertDialog.setNegativeButton(R.string.str_no, new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int which) {
              dialog.cancel();
          }
      });
      alertDialog.show();
  }
}
