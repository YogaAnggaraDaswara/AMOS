package com.mobile.appraisal;

import java.util.ArrayList;
import java.util.Date;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.EditText;

import java.util.Calendar;

import com.mobile.app.configuration.AppConstants;
import com.mobile.app.ui.DatePickerManager;
import com.mobile.app.ui.ListOfValueAdapter;
import com.mobile.bo.app.dataprovider.Appr_Collateral;
import com.mobile.bo.app.dataprovider.Appr_Mch_ValuationDataProvider;
import com.mobile.bo.app.dataprovider.LOVDataProvider;
import com.mobile.bo.app.datatype.Datatype_Appr_Collateral;
import com.mobile.bo.app.datatype.Datatype_Appr_Mch_Valuation_Int;
import com.mobile.framework.common.DateFormatter;
import com.mobile.framework.widget.ExSpinner;
import com.mobile.framework.widget.ISpinnerItem;

import bii.mobile.amos.R;

public class Fragment_Valuation_Mesin extends Fragment {


    public Fragment_Valuation_Mesin() {
    }

    private TableLayout tableLayout;
 
    private Appr_Mch_ValuationDataProvider appr_mch_ValuationDataProvider=new Appr_Mch_ValuationDataProvider();
    private Datatype_Appr_Mch_Valuation_Int appr_mch_valuation_int = new Datatype_Appr_Mch_Valuation_Int();
    private ArrayList<ISpinnerItem> lovkodepos = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovpenilai = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovdokcode = new ArrayList<ISpinnerItem>();
    private LOVDataProvider lovDataProvider;
    private ExSpinner val_mesin_spn_dokumen;
    private LinearLayout contentlayout;
    private TextView val_mesin_txt_no_laporan_1;
    private TextView val_mesin_txt_tgl_laporan_1;
    private TextView val_mesin_txt_tgl_survey_1;
    private TextView val_mesin_txt_divisi;
    private TextView val_mesin_txt_segment;
    private TextView val_mesin_txt_alamat_lokasi;
    private TextView val_mesin_txt_rt;
    private TextView val_mesin_txt_rw;
    private TextView val_mesin_txt_kelurahan;
    private TextView val_mesin_txt_kecamatan;
    private TextView val_mesin_txt_kota;
    private ExSpinner val_mesin_spn_kodepos;
    private TextView val_mesin_txt_nodokumen;
    private TextView val_mesin_txt_tgldokumen;
    private TextView val_mesin_txt_jenis_mesin;
    private TextView val_mesin_txt_merek;
    private TextView val_mesin_txt_model;
    private TextView val_mesin_txt_tahun;
    private RadioButton val_mesin_rdo_kondisi_baru;
    private RadioButton val_mesin_rdo_kondisi_bekas;
    private RadioButton val_mesin_rdo_kondisi_rekondisi;
    
    private Datatype_Appr_Collateral datatype_Appr_Collateral = null;
    private Appr_Collateral appr_Collateral=new Appr_Collateral();
    private TextView val_mesin_txt_harga_pasar;
    private TextView val_mesin_txt_likuidasi;
    private TextView val_mesin_txt_nilai_likuidasi;
    private TextView val_mesin_txt_inspeksi;
    private RadioButton val_mesin_rdo_business_ya;
    private RadioButton val_mesin_rdo_business_tidak;
    private RadioButton val_mesin_rdo_beroperasi_ya;
    private RadioButton val_mesin_rdo_beroperasi_tidak;
    private RadioButton val_mesin_rdo_ll_pabrikan;
    private RadioButton val_mesin_rdo_ll_customize;
    private TextView val_mesin_txt_beroperasi;
	private TextView val_mesin_txt_dasar_penilaian;
    private TextView val_mesin_txt_ket_lain;
    private TextView val_mesin_txt_fungsi;
    private TextView val_mesin_txt_noseri;
    private ExSpinner val_mesin_spn_nama_penilai;
    private RadioButton val_mesin_rdo_ll_berdiri_sendiri;
    private RadioButton val_mesin_rdo_ll_saturangkaian;
    private ImageView val_mesin_view_img_tgl_laporan_1;
    private ImageView val_mesin_view_img_survey_1;
    private ImageView val_mesin_view_img_tgl_dokumen;
    private String col_id="";
    private String ap_regno="",status="";
    private TextView header_deb;
    private TextView header_alamat;
    View view=null;
    Button Btnsave;
    private Context ctx = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_valuation_mesin, null);
        ctx = this.getActivity();
        appr_mch_ValuationDataProvider=new Appr_Mch_ValuationDataProvider();
        appr_mch_valuation_int = new Datatype_Appr_Mch_Valuation_Int();
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
    public static String replaceNull(String input) {
    	  return input == null ? "" : input;
    	}
    private void initControl(){
    	header_deb							=(TextView) view.findViewById(R.id.info_Nama_deb);
    	header_alamat						=(TextView) view.findViewById(R.id.info_Nama_Alamat);
    	    	
    	val_mesin_txt_no_laporan_1= (EditText) view.findViewById(R.id.val_mesin_txt_nama_debitur);
    	val_mesin_txt_tgl_laporan_1= (EditText) view.findViewById(R.id.val_mesin_txt_tgl_laporan_1);
    	val_mesin_txt_tgl_survey_1= (EditText) view.findViewById(R.id.val_mesin_txt_tgl_survey_1);
    	val_mesin_txt_divisi= (EditText) view.findViewById(R.id.val_mesin_txt_divisi);
    	val_mesin_txt_segment= (EditText) view.findViewById(R.id.val_mesin_txt_segment);
    	val_mesin_txt_alamat_lokasi= (EditText) view.findViewById(R.id.val_mesin_txt_alamat_lokasi);
    	val_mesin_txt_rt= (EditText) view.findViewById(R.id.val_mesin_txt_rt);
    	val_mesin_txt_rw= (EditText) view.findViewById(R.id.val_mesin_txt_rw);
    	val_mesin_txt_kelurahan= (EditText) view.findViewById(R.id.val_mesin_txt_kelurahan);
    	val_mesin_txt_kecamatan= (EditText) view.findViewById(R.id.val_mesin_txt_kecamatan);
    	val_mesin_txt_kota= (EditText) view.findViewById(R.id.val_mesin_txt_kota);
    	val_mesin_spn_kodepos= (ExSpinner) view.findViewById(R.id.val_mesin_spn_kodepos);
    	val_mesin_txt_nodokumen= (EditText) view.findViewById(R.id.val_mesin_txt_nodokumen);
    	val_mesin_txt_tgldokumen= (EditText) view.findViewById(R.id.val_mesin_txt_tgldokumen);
    	val_mesin_txt_jenis_mesin= (EditText) view.findViewById(R.id.val_mesin_txt_jenis_mesin);
    	val_mesin_txt_merek= (EditText) view.findViewById(R.id.val_mesin_txt_merek);
    	val_mesin_txt_model= (EditText) view.findViewById(R.id.val_mesin_txt_model);
    	val_mesin_txt_tahun= (EditText) view.findViewById(R.id.val_mesin_txt_tahun);
    	val_mesin_rdo_kondisi_baru= (RadioButton) view.findViewById(R.id.val_mesin_rdo_kondisi_baru);
    	val_mesin_rdo_kondisi_bekas= (RadioButton) view.findViewById(R.id.val_mesin_rdo_kondisi_bekas);
    	val_mesin_rdo_kondisi_rekondisi= (RadioButton) view.findViewById(R.id.val_mesin_rdo_kondisi_rekondisi);

    	val_mesin_rdo_beroperasi_ya= (RadioButton) view.findViewById(R.id.val_mesin_rdo_beroperasi_ya);
    	val_mesin_rdo_beroperasi_tidak= (RadioButton) view.findViewById(R.id.val_mesin_rdo_beroperasi_tidak);
    	val_mesin_txt_beroperasi= (EditText) view.findViewById(R.id.val_mesin_txt_beroperasi);
    	
    	val_mesin_rdo_ll_berdiri_sendiri= (RadioButton) view.findViewById(R.id.val_mesin_rdo_ll_berdiri_sendiri);
    	val_mesin_rdo_ll_saturangkaian= (RadioButton) view.findViewById(R.id.val_mesin_rdo_ll_saturangkaian);
    	val_mesin_rdo_ll_pabrikan= (RadioButton) view.findViewById(R.id.val_mesin_rdo_ll_pabrikan);
    	val_mesin_rdo_ll_customize= (RadioButton) view.findViewById(R.id.val_mesin_rdo_ll_customize);
    	val_mesin_txt_harga_pasar= (EditText) view.findViewById(R.id.val_mesin_txt_harga_pasar);
    	val_mesin_txt_likuidasi= (EditText) view.findViewById(R.id.val_mesin_txt_likuidasi);
    	val_mesin_txt_nilai_likuidasi= (EditText) view.findViewById(R.id.val_mesin_txt_nilai_likuidasi);
    	val_mesin_txt_inspeksi= (EditText) view.findViewById(R.id.val_mesin_txt_inspeksi);
    	val_mesin_rdo_business_ya= (RadioButton) view.findViewById(R.id.val_mesin_rdo_business_ya);
    	val_mesin_rdo_business_tidak= (RadioButton) view.findViewById(R.id.val_mesin_rdo_business_tidak);
    	val_mesin_txt_dasar_penilaian= (EditText) view.findViewById(R.id.val_mesin_txt_dasar_penilaian);
    	val_mesin_txt_ket_lain= (EditText) view.findViewById(R.id.val_mesin_txt_ket_lain);
    	val_mesin_txt_fungsi= (EditText) view.findViewById(R.id.val_mesin_txt_fungsi);
    	val_mesin_txt_noseri= (EditText) view.findViewById(R.id.val_mesin_txt_noseri);
    	val_mesin_spn_nama_penilai= (ExSpinner) view.findViewById(R.id.val_mesin_spn_nama_penilai);
    	
    	Btnsave = (Button) view.findViewById(R.id.btn_savemesin);

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
            		}
                }
            	catch(Exception ex){
            		showAlert(R.string.msg_notification_update_error);
            	}
           }
        }); 
    	val_mesin_view_img_tgl_laporan_1= (ImageView) view.findViewById(R.id.val_mesin_view_img_tgl_laporan_1);
    	val_mesin_view_img_survey_1= (ImageView) view.findViewById(R.id.val_mesin_view_img_survey_1);
    	val_mesin_view_img_tgl_dokumen= (ImageView) view.findViewById(R.id.val_mesin_view_img_tgl_dokumen);
    	
    	val_mesin_view_img_tgl_laporan_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] arrTglLahir = null;

                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = (c.get(Calendar.MONTH));
                int day = c.get(Calendar.DAY_OF_MONTH);
                try{
	                if (val_mesin_txt_tgl_laporan_1.getText().toString().equalsIgnoreCase("")) {
	                    arrTglLahir = val_mesin_txt_tgl_laporan_1.getText().toString().split("-");
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
    	
    	val_mesin_view_img_survey_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] arrTglLahir = null;

                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = (c.get(Calendar.MONTH));
                int day = c.get(Calendar.DAY_OF_MONTH);
                try{
                if (val_mesin_txt_tgl_survey_1.getText().toString().equalsIgnoreCase("")) {
                    arrTglLahir = val_mesin_txt_tgl_survey_1.getText().toString().split("-");
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
    
    	val_mesin_view_img_tgl_dokumen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] arrTglLahir = null;

                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = (c.get(Calendar.MONTH));
                int day = c.get(Calendar.DAY_OF_MONTH);
                try{
	                if (val_mesin_txt_tgldokumen.getText().toString().equalsIgnoreCase("")) {
	                    arrTglLahir = val_mesin_txt_tgldokumen.getText().toString().split("-");
	                    year = Integer.parseInt(arrTglLahir[2]);
	                    month = Integer.parseInt(arrTglLahir[1]) - 1;
	                    day = Integer.parseInt(arrTglLahir[0]);
	                }
                }
                catch(Exception e){
                	
                }
                DatePickerManager datePickerDialog = new DatePickerManager(ctx, PbTglDokumenDateSetListener, year, month, day);
                datePickerDialog.show();

            }
        });
    	val_mesin_spn_nama_penilai=(ExSpinner) view.findViewById(R.id.val_mesin_spn_nama_penilai);
        lovDataProvider = new LOVDataProvider();
        lovpenilai = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_PENILAI));
        val_mesin_spn_nama_penilai.setListOfValue(lovpenilai, false);
        
        
        val_mesin_spn_kodepos=(ExSpinner) view.findViewById(R.id.val_mesin_spn_kodepos);
        lovDataProvider = new LOVDataProvider();
        lovkodepos = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_DATI2));
        val_mesin_spn_kodepos.setListOfValue(lovkodepos, false);
        
        val_mesin_spn_dokumen=(ExSpinner) view.findViewById(R.id.val_mesin_spn_dokumen);
        lovDataProvider = new LOVDataProvider();
        lovdokcode = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_DOCCODE));
        val_mesin_spn_dokumen.setListOfValue(lovdokcode, false);
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
    private Boolean cekTanggalLaporan(){
    	Boolean retval=true;
    	Date LaporanDate = DateFormatter.formatDate(val_mesin_txt_tgl_laporan_1.getText().toString());
        Date SurveyDate=  DateFormatter.formatDate(val_mesin_txt_tgl_survey_1.getText().toString());
    	
        if(LaporanDate.before(SurveyDate))
        	retval=false;
        return retval;
 }					
    private void setColorMandatory(){
    	val_mesin_txt_tgl_laporan_1.setBackgroundResource(R.drawable.fillcolor);
    	val_mesin_txt_tgl_survey_1.setBackgroundResource(R.drawable.fillcolor);
    	val_mesin_txt_alamat_lokasi.setBackgroundResource(R.drawable.fillcolor);
    	val_mesin_txt_kelurahan.setBackgroundResource(R.drawable.fillcolor);
    	val_mesin_txt_kecamatan.setBackgroundResource(R.drawable.fillcolor);
    	val_mesin_txt_kota.setBackgroundResource(R.drawable.fillcolor);
    	val_mesin_txt_nodokumen.setBackgroundResource(R.drawable.fillcolor);
    	val_mesin_txt_tgldokumen.setBackgroundResource(R.drawable.fillcolor);
    	val_mesin_txt_noseri.setBackgroundResource(R.drawable.fillcolor);
    	val_mesin_txt_jenis_mesin.setBackgroundResource(R.drawable.fillcolor);
    	val_mesin_txt_merek.setBackgroundResource(R.drawable.fillcolor);
    	val_mesin_txt_model.setBackgroundResource(R.drawable.fillcolor);
    	val_mesin_txt_fungsi.setBackgroundResource(R.drawable.fillcolor);
    	val_mesin_txt_tahun.setBackgroundResource(R.drawable.fillcolor);
    	val_mesin_txt_harga_pasar.setBackgroundResource(R.drawable.fillcolor);
    	val_mesin_txt_likuidasi.setBackgroundResource(R.drawable.fillcolor);
    	val_mesin_txt_nilai_likuidasi.setBackgroundResource(R.drawable.fillcolor);
    	val_mesin_txt_inspeksi.setBackgroundResource(R.drawable.fillcolor);
    }
    private Boolean CekMandatory(){
    	
    	/*setMCH_FUNGSI
    	getCREATED_YEAR
    	getLIQUID_PERCENT
    	getLIQUID_VALUE
    	getINSPECTION_PERSON
    	setDOC_NO
    	setDOC_NOSERI
    	setMCH_CODE
    	setMCH_BRAND
    	setMCH_MODEL
    	setREPORT_DATE
    	setREPORT_INSPECT_DATE
    	setCOL_ADDR1
    	setCOL_KELURAHAN
    	setCOL_KECAMATAN
    	setCOL_CITY
    	setDOC_DATE
    	setMARKET_PRICE
    	setCOL_ZIPCODE
    	setAPPR_PENILAINAME
    	setDOC_CODE
    			  
    			  
    			  */
  	  boolean retval=true;
  	  
  	appr_mch_valuation_int=appr_mch_ValuationDataProvider.getAllAppr_Mch_Valuation_Int(col_id);
  	if(appr_mch_valuation_int.COL_ID!=null && !appr_mch_valuation_int.COL_ID.equals("")){
		if(appr_mch_valuation_int.CREATED_YEAR==null || appr_mch_valuation_int.CREATED_YEAR.equals(""))
  			retval=false;
  		if(appr_mch_valuation_int.LIQUID_PERCENT==null || appr_mch_valuation_int.LIQUID_PERCENT.equals(""))
  			retval=false;
  		if(appr_mch_valuation_int.LIQUID_VALUE==null || appr_mch_valuation_int.LIQUID_VALUE.equals(""))
  			retval=false;
  		if(appr_mch_valuation_int.INSPECTION_PERSON==null || appr_mch_valuation_int.INSPECTION_PERSON.equals(""))
  			retval=false;
  		if(appr_mch_valuation_int.DOC_NO==null || appr_mch_valuation_int.DOC_NO.equals(""))
  			retval=false;
  			
  		if(appr_mch_valuation_int.MCH_FUNGSI==null || appr_mch_valuation_int.MCH_FUNGSI.equals(""))
  			retval=false;	
		if(appr_mch_valuation_int.DOC_NOSERI==null || appr_mch_valuation_int.DOC_NOSERI.equals(""))
  			retval=false;
		if(appr_mch_valuation_int.MCH_CODE==null || appr_mch_valuation_int.MCH_CODE.equals(""))
			retval=false;
		if(appr_mch_valuation_int.MCH_BRAND==null || appr_mch_valuation_int.MCH_BRAND.equals(""))
			retval=false;
		if(appr_mch_valuation_int.MCH_MODEL==null || appr_mch_valuation_int.MCH_MODEL.equals(""))
			retval=false;
		if(appr_mch_valuation_int.REPORT_DATE==null || appr_mch_valuation_int.REPORT_DATE.equals(""))
			retval=false;
		if(appr_mch_valuation_int.REPORT_INSPECT_DATE==null || appr_mch_valuation_int.REPORT_INSPECT_DATE.equals(""))
			retval=false;	
		if(appr_mch_valuation_int.COL_ADDR1==null || appr_mch_valuation_int.COL_ADDR1.equals(""))
			retval=false;	
		if(appr_mch_valuation_int.COL_KELURAHAN==null || appr_mch_valuation_int.COL_KELURAHAN.equals(""))
			retval=false;	
		if(appr_mch_valuation_int.COL_KECAMATAN==null || appr_mch_valuation_int.COL_KECAMATAN.equals(""))
			retval=false;		
		if(appr_mch_valuation_int.COL_CITY==null || appr_mch_valuation_int.COL_CITY.equals(""))
			retval=false;	
		if(appr_mch_valuation_int.DOC_DATE==null || appr_mch_valuation_int.DOC_DATE.equals(""))
			retval=false;	
		if(appr_mch_valuation_int.MARKET_PRICE==null || appr_mch_valuation_int.MARKET_PRICE.equals(""))
			retval=false;
		if(appr_mch_valuation_int.COL_ZIPCODE==null || appr_mch_valuation_int.COL_ZIPCODE.equals(""))
			retval=false;
		if(appr_mch_valuation_int.APPR_PENILAINAME==null || appr_mch_valuation_int.APPR_PENILAINAME.equals(""))
			retval=false;
		if(appr_mch_valuation_int.DOC_CODE==null || appr_mch_valuation_int.DOC_CODE.equals(""))
			retval=false;	
	}

	
	
	
  	/*if(val_mesin_txt_fungsi.getText().length()==0){
  		val_mesin_txt_fungsi.setError("Field Tidak Boleh Kososng");
		  retval=false;
	  }
  	if(val_mesin_txt_tahun.getText().length()==0){
  		val_mesin_txt_tahun.setError("Field Tidak Boleh Kososng");
		  retval=false;
	  }
  	if(val_mesin_txt_likuidasi.getText().length()==0){
  		val_mesin_txt_likuidasi.setError("Field Tidak Boleh Kososng");
		  retval=false;
	  }
  	if(val_mesin_txt_nilai_likuidasi.getText().length()==0){
  		val_mesin_txt_nilai_likuidasi.setError("Field Tidak Boleh Kososng");
		  retval=false;
	  }
  	if(val_mesin_txt_inspeksi.getText().length()==0){
  		val_mesin_txt_inspeksi.setError("Field Tidak Boleh Kososng");
		  retval=false;
	  }
  	
  	
  	if(val_mesin_txt_nodokumen.getText().length()==0){
  		val_mesin_txt_nodokumen.setError("Field Tidak Boleh Kososng");
		  retval=false;
	  }
	  if(val_mesin_txt_noseri.getText().length()==0){
		  val_mesin_txt_noseri.setError("Field Tidak Boleh Kososng");
		  retval=false;
	  }
	  if(val_mesin_txt_jenis_mesin.getText().length()==0){
		  val_mesin_txt_jenis_mesin.setError("Field Tidak Boleh Kososng");
		  retval=false;
	  }
	  if(val_mesin_txt_merek.getText().length()==0){
		  val_mesin_txt_merek.setError("Field Tidak Boleh Kososng");
		  retval=false;
	  }
	  if(val_mesin_txt_model.getText().length()==0){
		  val_mesin_txt_model.setError("Field Tidak Boleh Kososng");
		  retval=false;
	  }
  	  if(val_mesin_txt_tgl_laporan_1.getText().length()==0){
  		val_mesin_txt_tgl_laporan_1.setError("Field Tidak Boleh Kososng");
  		  retval=false;
  	  }
  	  if(val_mesin_txt_tgl_survey_1.getText().length()==0){
  		val_mesin_txt_tgl_survey_1.setError("Field Tidak Boleh Kososng");
  		  retval=false;
  	  }
  	  if(val_mesin_txt_alamat_lokasi.getText().length()==0){
  		val_mesin_txt_alamat_lokasi.setError("Field Tidak Boleh Kososng");
  		  retval=false;
  	  }
  	  if(val_mesin_txt_kelurahan.getText().length()==0){
  		val_mesin_txt_kelurahan.setError("Field Tidak Boleh Kososng");
  		  retval=false;
  	  }
  	  if(val_mesin_txt_kecamatan.getText().length()==0){
  		val_mesin_txt_kecamatan.setError("Field Tidak Boleh Kososng");
  		  retval=false;
  	  }
  	  if(val_mesin_txt_kota.getText().length()==0){
  		val_mesin_txt_kota.setError("Field Tidak Boleh Kososng");
  		  retval=false;
  	  }
  	
    if(val_mesin_txt_tgldokumen.getText().length()==0){
    	val_mesin_txt_tgldokumen.setError("Field Tidak Boleh Kososng");
  		  retval=false;
  	  }
    if(val_mesin_txt_harga_pasar.getText().length()==0){
    	val_mesin_txt_harga_pasar.setError("Field Tidak Boleh Kososng");
  		  retval=false;
  	  }
  	View selectedView = val_mesin_spn_kodepos.getSelectedView();
	  if (selectedView != null && selectedView instanceof TextView) {
	      TextView selectedTextView = (TextView) selectedView;
	      if (val_mesin_spn_kodepos.getSelectedListOfValue().toString().length()==0) {
	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
	          selectedTextView.setError(errorString);
	          retval=false;
	      }
	      else {
	          selectedTextView.setError(null);
	      }
	  }
	 	View selectedView1 = val_mesin_spn_nama_penilai.getSelectedView();
		  if (selectedView1 != null && selectedView1 instanceof TextView) {
		      TextView selectedTextView = (TextView) selectedView1;
		      if (val_mesin_spn_nama_penilai.getSelectedListOfValue().toString().length()==0) {
		          String errorString = selectedTextView.getResources().getString(R.drawable.error);
		          selectedTextView.setError(errorString);
		          retval=false;
		      }
		      else {
		          selectedTextView.setError(null);
		      }
		  }
		 	View selectedView2 = val_mesin_spn_dokumen.getSelectedView();
			  if (selectedView2 != null && selectedView2 instanceof TextView) {
			      TextView selectedTextView = (TextView) selectedView2;
			      if (val_mesin_spn_dokumen.getSelectedListOfValue().toString().length()==0) {
			          String errorString = selectedTextView.getResources().getString(R.drawable.error);
			          selectedTextView.setError(errorString);
			          retval=false;
			      }
			      else {
			          selectedTextView.setError(null);
			      }
			  }
		  
		  */
		  
		  
  	  return retval;
    }
    private DatePickerDialog.OnDateSetListener PbSurveyDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int monthOfYear, int dayOfMonth) {
        	val_mesin_txt_tgl_survey_1.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
        }
    };
    private DatePickerDialog.OnDateSetListener PbTglLaporDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int monthOfYear, int dayOfMonth) {
        	val_mesin_txt_tgl_laporan_1.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
        }
    };
    private DatePickerDialog.OnDateSetListener PbTglDokumenDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int monthOfYear, int dayOfMonth) {
        	val_mesin_txt_tgldokumen.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
        }
    };

    private void saveData(){
    	
	    	appr_mch_valuation_int.setCOL_ID(col_id);
	    	appr_mch_valuation_int.setAP_REGNO(ap_regno);
		  	appr_mch_valuation_int.setREPORT_NO(val_mesin_txt_no_laporan_1.getText().toString());
		  	appr_mch_valuation_int.setREPORT_DATE(DateFormatter.formatDate(val_mesin_txt_tgl_laporan_1.getText().toString()));
		  	appr_mch_valuation_int.setREPORT_INSPECT_DATE(DateFormatter.formatDate(val_mesin_txt_tgl_survey_1.getText().toString()));
		  	//appr_mch_valuation_int.setREPORT_BRANCH_CODE(val_mesin_txt_tgl_survey_1.getText().toString());
		  	appr_mch_valuation_int.setREPORT_SEG_CODE(val_mesin_txt_divisi.getText().toString());
		  	appr_mch_valuation_int.setREPORT_APPR_TYPE(val_mesin_txt_segment.getText().toString());
		  	appr_mch_valuation_int.setCOL_ADDR1(val_mesin_txt_alamat_lokasi.getText().toString());
		  	appr_mch_valuation_int.setCOL_RT(val_mesin_txt_rt.getText().toString());
		  	appr_mch_valuation_int.setCOL_RW(val_mesin_txt_rw.getText().toString());
		  	appr_mch_valuation_int.setCOL_KELURAHAN(val_mesin_txt_kelurahan.getText().toString());
		  	appr_mch_valuation_int.setCOL_KECAMATAN(val_mesin_txt_kecamatan.getText().toString());
		  	appr_mch_valuation_int.setCOL_CITY(val_mesin_txt_kota.getText().toString());
		  	appr_mch_valuation_int.setCOL_ZIPCODE(val_mesin_spn_kodepos.getSelectedListOfValue().toString());
		  	appr_mch_valuation_int.setDOC_NO(val_mesin_txt_nodokumen.getText().toString());
		  	appr_mch_valuation_int.setDOC_DATE(DateFormatter.formatDate(val_mesin_txt_tgldokumen.getText().toString()));
		  	appr_mch_valuation_int.setMCH_CODE(val_mesin_txt_jenis_mesin.getText().toString());
		  	appr_mch_valuation_int.setMCH_BRAND(val_mesin_txt_merek.getText().toString());
		  	appr_mch_valuation_int.setMCH_MODEL(val_mesin_txt_model.getText().toString());
		  	appr_mch_valuation_int.setCREATED_YEAR(val_mesin_txt_tahun.getText().toString());
		  	appr_mch_valuation_int.setMCH_COND(val_mesin_rdo_kondisi_baru.getText().toString());
		   	appr_mch_valuation_int.setON_USE_REASON(val_mesin_txt_beroperasi.getText().toString());
		  	appr_mch_valuation_int.setMARKET_PRICE(val_mesin_txt_harga_pasar.getText().toString());
		  	appr_mch_valuation_int.setLIQUID_PERCENT(val_mesin_txt_likuidasi.getText().toString());
		  	appr_mch_valuation_int.setLIQUID_VALUE(val_mesin_txt_nilai_likuidasi.getText().toString());
		  	appr_mch_valuation_int.setINSPECTION_PERSON(val_mesin_txt_inspeksi.getText().toString());
		  	
		  	//appr_mch_valuation_int.setINSPECTION_BUSINESSUNIT(val_mesin_rdo_business_ya.getText().toString());
		  	
		  	appr_mch_valuation_int.setOTHER_INFO(val_mesin_txt_ket_lain.getText().toString());
		  	appr_mch_valuation_int.setMCH_FUNGSI(val_mesin_txt_fungsi.getText().toString());
		  	appr_mch_valuation_int.setDOC_NOSERI(val_mesin_txt_noseri.getText().toString());
		  	appr_mch_valuation_int.setBASIC_VALUATION(val_mesin_txt_dasar_penilaian.getText().toString());
		  	
		  	appr_mch_valuation_int.setAPPR_PENILAINAME(val_mesin_spn_nama_penilai.getSelectedListOfValue().toString());
		  	appr_mch_valuation_int.setDOC_CODE(val_mesin_spn_dokumen.getSelectedListOfValue().toString());
		
		  	if(val_mesin_rdo_kondisi_bekas.isChecked()){
		  		appr_mch_valuation_int.setMCH_COND(AppConstants.RDOB);
		  	}
	    	else if(val_mesin_rdo_kondisi_baru.isChecked()){
	    		appr_mch_valuation_int.setMCH_COND(AppConstants.RDOA);
	    	}
	    	else if(val_mesin_rdo_kondisi_rekondisi.isChecked()){
	    		appr_mch_valuation_int.setMCH_COND(AppConstants.RDOC);
	    	}
		  	
		  	  if(val_mesin_rdo_beroperasi_ya.isChecked()){
		  		appr_mch_valuation_int.setON_USE(AppConstants.RDOYA);  
		  	  }
		  	  else if(val_mesin_rdo_beroperasi_tidak.isChecked()){
		  		appr_mch_valuation_int.setON_USE(AppConstants.RDOTIDAK);  
		  	  }
			  if(val_mesin_rdo_ll_berdiri_sendiri.isChecked()){
		  		  appr_mch_valuation_int.setOTHER(AppConstants.RDOA);  
		  	  }
		  	  else if(val_mesin_rdo_ll_saturangkaian.isChecked()){
		  		  appr_mch_valuation_int.setOTHER(AppConstants.RDOB);  
		  	  }
		  	  else if(val_mesin_rdo_ll_pabrikan.isChecked()){
		  		  appr_mch_valuation_int.setOTHER(AppConstants.RDOC);  
		  	  }
		  	  else if(val_mesin_rdo_ll_customize.isChecked()){
		  		  appr_mch_valuation_int.setOTHER(AppConstants.RDOD);  
		  	  }
			  
			  //appr_mesin_valuation_int.setINSPECTION_PERSON(appr_mesin_txt_inspeksi.getText().toString());
			  
			  if(val_mesin_rdo_business_ya.isChecked()){
				  appr_mch_valuation_int.setINSPECTION_BUSINESSUNIT(AppConstants.RDOYA);  
			  }
			  else if(val_mesin_rdo_business_tidak.isChecked()){
				  appr_mch_valuation_int.setINSPECTION_BUSINESSUNIT(AppConstants.RDOTIDAK);  
			  }
			  
		        appr_mch_ValuationDataProvider.updateData(appr_mch_valuation_int);
		        showAlert(R.string.msg_notification_update_success);    
		        //if(CekMandatory().equals(false)){
		 		//	showAlert(R.string.msg_notification_mandatory);
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
    private void loadData(){
    	appr_mch_valuation_int=appr_mch_ValuationDataProvider.getAllAppr_Mch_Valuation_Int(col_id);
      	if(appr_mch_valuation_int.COL_ID!=null && !appr_mch_valuation_int.COL_ID.equals("")){
      		val_mesin_txt_no_laporan_1.setText(replaceNull(appr_mch_valuation_int.getREPORT_NO()));
      		
      		if (appr_mch_valuation_int.getREPORT_DATE() != null) {
	      		val_mesin_txt_tgl_laporan_1.setText(replaceNull(DateFormatter.formatString(appr_mch_valuation_int.getREPORT_DATE())));
	      	}
	    	if (appr_mch_valuation_int.getREPORT_INSPECT_DATE() != null) {
	    		val_mesin_txt_tgl_survey_1.setText(replaceNull(DateFormatter.formatString(appr_mch_valuation_int.getREPORT_INSPECT_DATE())));
	    	}
	    	//val_mesin_txt_tgl_survey_1.setText(replaceNull(appr_mch_valuation_int.getREPORT_BRANCH_CODE()));
	    	
	    	datatype_Appr_Collateral=appr_Collateral.getAllAppr_Collateral(col_id);
          	if(datatype_Appr_Collateral.COL_ID!=null && !datatype_Appr_Collateral.COL_ID.toString().equals("")){
          		val_mesin_txt_divisi.setText((datatype_Appr_Collateral.getBRANCHNAME()));
          		val_mesin_txt_segment.setText((datatype_Appr_Collateral.getSEG_DESC()));
          		 header_deb.setText(datatype_Appr_Collateral.getAP_REGNO() + " # " + datatype_Appr_Collateral.getCU_NAME() );
          	}
          	header_alamat.setText(appr_mch_valuation_int.getCOL_ADDR1() + " , " +  appr_mch_valuation_int.getCOL_KELURAHAN() + " , " +  appr_mch_valuation_int.getCOL_KECAMATAN() + " , " +  appr_mch_valuation_int.getCOL_CITY() + " , " +  appr_mch_valuation_int.getCOL_ZIPCODE());
       	   
          	val_mesin_txt_alamat_lokasi.setText(replaceNull(appr_mch_valuation_int.getCOL_ADDR1()));
          	val_mesin_txt_rt.setText(replaceNull(appr_mch_valuation_int.getCOL_RT()));
	    	val_mesin_txt_rw.setText(replaceNull(appr_mch_valuation_int.getCOL_RW()));
	    	val_mesin_txt_kelurahan.setText(replaceNull(appr_mch_valuation_int.getCOL_KELURAHAN()));
	    	val_mesin_txt_kecamatan.setText(replaceNull(appr_mch_valuation_int.getCOL_KECAMATAN()));
	    	val_mesin_txt_kota.setText(replaceNull(appr_mch_valuation_int.getCOL_CITY()));
	    	val_mesin_spn_kodepos.setSelectedListOfValue(replaceNull(appr_mch_valuation_int.getCOL_ZIPCODE()));
	    	val_mesin_txt_nodokumen.setText(replaceNull(appr_mch_valuation_int.getDOC_NO()));
	    	if (appr_mch_valuation_int.getDOC_DATE() != null) {
	    		val_mesin_txt_tgldokumen.setText(DateFormatter.formatString(appr_mch_valuation_int.getDOC_DATE()));
	      	}
	    	val_mesin_txt_jenis_mesin.setText(replaceNull(appr_mch_valuation_int.getMCH_CODE()));
	    	val_mesin_txt_merek.setText(replaceNull(appr_mch_valuation_int.getMCH_BRAND()));
	    	val_mesin_txt_model.setText(replaceNull(appr_mch_valuation_int.getMCH_MODEL()));
	    	val_mesin_txt_tahun.setText(replaceNull(appr_mch_valuation_int.getCREATED_YEAR()));
	    	
	    	val_mesin_txt_harga_pasar.setText(replaceNull(appr_mch_valuation_int.getMARKET_PRICE()));
	    	val_mesin_txt_likuidasi.setText(replaceNull(appr_mch_valuation_int.getLIQUID_PERCENT()));
	    	val_mesin_txt_nilai_likuidasi.setText(replaceNull(appr_mch_valuation_int.getLIQUID_VALUE()));
	    	val_mesin_txt_inspeksi.setText(replaceNull(appr_mch_valuation_int.getINSPECTION_PERSON()));
	    	
	    	
	    	val_mesin_txt_ket_lain.setText(replaceNull(appr_mch_valuation_int.getOTHER_INFO()));
	    	val_mesin_txt_fungsi.setText(replaceNull(appr_mch_valuation_int.getMCH_FUNGSI()));
	    	val_mesin_txt_noseri.setText(replaceNull(appr_mch_valuation_int.getDOC_NOSERI()));
	    	val_mesin_spn_nama_penilai.setSelectedListOfValue(replaceNull(appr_mch_valuation_int.getAPPR_PENILAINAME()));
	    	val_mesin_spn_dokumen.setSelectedListOfValue(replaceNull(appr_mch_valuation_int.getDOC_CODE()));
	    	val_mesin_txt_dasar_penilaian.setText(replaceNull(appr_mch_valuation_int.getBASIC_VALUATION()));	
	    	if(appr_mch_valuation_int.getINSPECTION_BUSINESSUNIT().equals("1")){
	    		val_mesin_rdo_business_ya.setChecked(true);
	    	}
	    	else if(appr_mch_valuation_int.getINSPECTION_BUSINESSUNIT().equals("0")){
	    		val_mesin_rdo_business_tidak.setChecked(true);
	    	}
	    	if(appr_mch_valuation_int.getMCH_COND().equals("B")){
	    		val_mesin_rdo_kondisi_bekas.setChecked(true);
	    	}
	    	else if(appr_mch_valuation_int.getMCH_COND().equals("A")){
	    		val_mesin_rdo_kondisi_baru.setChecked(true);
	    	}
	    	else if(appr_mch_valuation_int.getMCH_COND().equals("C")){
	    		val_mesin_rdo_kondisi_rekondisi.setChecked(true);
	    	}
	    	if(appr_mch_valuation_int.getON_USE().equals("1")){
	    		val_mesin_rdo_beroperasi_ya.setChecked(true);
	    	}
	    	else if(appr_mch_valuation_int.getON_USE().equals("0")){
	    		val_mesin_rdo_beroperasi_tidak.setChecked(true);
	    	}
	    	
	    	
	    	if(appr_mch_valuation_int.getOTHER().equals("A")){
	    		val_mesin_rdo_ll_berdiri_sendiri.setChecked(true);
	    	}
	    	else if(appr_mch_valuation_int.getOTHER().equals("B")){
	    		val_mesin_rdo_ll_saturangkaian.setChecked(true);
	    	}
	    	
	    	else if(appr_mch_valuation_int.getOTHER().equals("C")){
	    		val_mesin_rdo_ll_pabrikan.setChecked(true);
	    	}
	    	else if(appr_mch_valuation_int.getOTHER().equals("D")){
	    		val_mesin_rdo_ll_customize.setChecked(true);
	    	}
	    	
	    	val_mesin_txt_beroperasi.setText(replaceNull(appr_mch_valuation_int.getON_USE_REASON()));
      	}
      	
    }
    private void loadViewTagihan() {

		/*if(listTagihan != null){
			if(tagihan.getTableLayout()!=null)
				tagihan.getTableLayout().removeAllViews();*/

        //tagihan = new Tagihan(ctx);
        //{"No","No.Rekening","Nama Debitur","Nominal","Sisa Tagihan","Action"};

        //Collections.sort(listTagihan);
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
        header.setWidth(1000);
        header.setText("No");
        rowHeaderTable.addView(header, rowParamsDetail);

        TextView header1 = new TextView(ctx);
        header1.setGravity(Gravity.LEFT);
        header1.setTextColor(getResources().getColor(android.R.color.black));
        header1.setPadding(0, 3, 0, 3);
        header1.setTextSize(12);
        header1.setWidth(1000);
        header1.setText("No.Rekening");
        rowHeaderTable.addView(header1, rowParamsDetail);

        TextView header2 = new TextView(ctx);
        header2.setGravity(Gravity.LEFT);
        header2.setTextColor(getResources().getColor(android.R.color.black));
        header2.setPadding(0, 3, 0, 3);
        header2.setTextSize(12);
        header2.setWidth(180);
        header2.setText("Nama Debitur");
        rowHeaderTable.addView(header2, rowParamsDetail);

        TextView header3 = new TextView(ctx);
        header3.setGravity(Gravity.LEFT);
        header3.setTextColor(getResources().getColor(android.R.color.black));
        header3.setPadding(0, 3, 0, 3);
        header3.setTextSize(12);
        header3.setWidth(100);
        header3.setText("Nominal");
        rowHeaderTable.addView(header3, rowParamsDetail);

        TextView header4 = new TextView(ctx);
        header4.setGravity(Gravity.LEFT);
        header4.setTextColor(getResources().getColor(android.R.color.black));
        header4.setPadding(0, 3, 0, 3);
        header4.setTextSize(12);
        header4.setWidth(100);
        header4.setText("Sisa Tagihan");
        rowHeaderTable.addView(header4, rowParamsDetail);

        TextView header5 = new TextView(ctx);
        header5.setGravity(Gravity.LEFT);
        header5.setTextColor(getResources().getColor(android.R.color.black));
        header5.setPadding(0, 3, 0, 3);
        header5.setTextSize(12);
        header5.setWidth(60);
        header5.setText("Action");
        rowHeaderTable.addView(header5, rowParamsDetail);

        tableLayout.addView(rowHeaderTable);

        // loop data
			/*int intnomor=0;
			if(pageNo > 1)		
				intnomor=pageNo*10;
			
			for(int i=0;i<listTagihan.size();i++){
				TagihanData contentdata= listTagihan.get(i);
				
				final TableRow rowContentTable = new TableRow(this);
				if ((i+1)%2==0){rowContentTable.setBackgroundColor(getResources().getColor(R.color.color_bacground1));}
				else{rowContentTable.setBackgroundColor(Color.WHITE);}
				
				TextView counter = new TextView(ctx);
				counter.setGravity(Gravity.LEFT);
				counter.setTextColor(getResources().getColor(android.R.color.black));
				counter.setPadding(0, 3, 0, 3);
				counter.setTextSize(12);
				counter.setWidth(25);
				counter.setText(""+(i+1+intnomor));
				rowContentTable.addView(counter,rowParamsDetail);
				
				
									
				TextView tv_valuehidden = new TextView(ctx);
				tv_valuehidden.setText(contentdata.getID().toString());
				rowContentTable.addView(tv_valuehidden);
				tv_valuehidden.setVisibility(View.GONE);
				
				TextView tv_rekening = new TextView(ctx);
				tv_rekening.setGravity(Gravity.LEFT);
				tv_rekening.setTextColor(getResources().getColor(android.R.color.black));
				tv_rekening.setPadding(0, 3, 0, 3);
				tv_rekening.setTextSize(12);
				tv_rekening.setWidth(100);
				tv_rekening.setText(contentdata.getNOMORREKENING());
				rowContentTable.addView(tv_rekening,rowParamsDetail);
				
				TextView tv_namadebitur = new TextView(ctx);
				tv_namadebitur.setGravity(Gravity.LEFT);
				tv_namadebitur.setTextColor(getResources().getColor(android.R.color.black));
				tv_namadebitur.setPadding(0, 3, 0, 3);
				tv_namadebitur.setTextSize(12);
				tv_namadebitur.setWidth(180);
				tv_namadebitur.setText(contentdata.getNAMADEBITUR());
				rowContentTable.addView(tv_namadebitur,rowParamsDetail);
				
				TextView tv_nominal = new TextView(ctx);
				tv_nominal.setGravity(Gravity.LEFT);
				tv_nominal.setTextColor(getResources().getColor(android.R.color.black));
				tv_nominal.setPadding(0, 3, 0, 3);
				tv_nominal.setTextSize(12);
				tv_nominal.setWidth(100);
				tv_nominal.setText(contentdata.getTAGIHAN());
				rowContentTable.addView(tv_nominal,rowParamsDetail);
										
				TextView tv_sisatagihan = new TextView(ctx);
				tv_sisatagihan.setGravity(Gravity.LEFT);
				tv_sisatagihan.setTextColor(getResources().getColor(android.R.color.black));
				tv_sisatagihan.setPadding(0, 3, 0, 3);
				tv_sisatagihan.setTextSize(12);
				tv_sisatagihan.setWidth(95);
				tv_sisatagihan.setText(contentdata.getSISATAGIHAN());
				rowContentTable.addView(tv_sisatagihan,rowParamsDetail);
				
								
			
				
				if (Double.parseDouble(contentdata.getSISATAGIHAN())==0){
					TextView tv_lunas = new TextView(ctx);
					tv_lunas.setGravity(Gravity.LEFT);
					tv_lunas.setTextColor(getResources().getColor(android.R.color.black));
					tv_lunas.setPadding(0, 3, 0, 3);
					tv_lunas.setTextSize(12);
					tv_lunas.setWidth(57);
					tv_lunas.setText(R.string.form_action_status_lunas);
					rowContentTable.addView(tv_lunas,rowParamsDetail);
				}
				else{
					Button bt_bayar = new Button(ctx);
					bt_bayar.setGravity(Gravity.LEFT);
					bt_bayar.setText(R.string.form_action_status_bayar);
					rowContentTable.addView(bt_bayar,60,35);
					
					bt_bayar.setOnClickListener(new View.OnClickListener() {
					    @Override
					    public void onClick(View view) {
					        TextView contentTrx = (TextView) rowContentTable.getChildAt(1);
					        loadDetailTagihan(contentTrx.getText().toString());
					        loadTagihanDialog();
					    }
					});
				}
				tagihan.getTableLayout().addView(rowContentTable);
			}
			
			if (contentContainer != null){
				contentContainer.removeView(prevShownView);
			}
			
			contentContainer.addView(tagihan);
			prevShownView = tagihan;*/
        //}
    }

}
