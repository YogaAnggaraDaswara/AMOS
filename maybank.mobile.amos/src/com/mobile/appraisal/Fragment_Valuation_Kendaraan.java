package com.mobile.appraisal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.EditText;
import android.widget.TextView;

import com.mobile.app.configuration.AppConstants;
import com.mobile.app.ui.DatePickerManager;
import com.mobile.app.ui.ListOfValueAdapter;
import com.mobile.bo.app.dataprovider.Appr_Collateral;
import com.mobile.bo.app.dataprovider.Appr_Status;
import com.mobile.bo.app.dataprovider.Appr_Vhc_ValuationDataProvider;
import com.mobile.bo.app.dataprovider.LOVDataProvider;
import com.mobile.bo.app.datatype.Datatype_Appr_Collateral;
import com.mobile.bo.app.datatype.Datatype_Appr_Status;
import com.mobile.bo.app.datatype.Datatype_Appr_Vhc_Valuation_Int;
import com.mobile.framework.common.DateFormatter;
import com.mobile.framework.widget.ExSpinner;
import com.mobile.framework.widget.ISpinnerItem;

import bii.mobile.amos.R;
public class Fragment_Valuation_Kendaraan extends Fragment {


    public Fragment_Valuation_Kendaraan() {
    }

    private TableLayout tableLayout;

    View view=null;
    Button Btnsave;
    private Context ctx = null;
    private Appr_Vhc_ValuationDataProvider appr_vhc_ValuationDataProvider=new Appr_Vhc_ValuationDataProvider();
    private Datatype_Appr_Vhc_Valuation_Int appr_kendaraan_valuation_int = new Datatype_Appr_Vhc_Valuation_Int();
    private Datatype_Appr_Collateral datatype_Appr_Collateral = null;
    private Datatype_Appr_Status datatype_Appr_Status = null;
    private Appr_Status appr_Status=new Appr_Status();
    private Appr_Collateral appr_Collateral=new Appr_Collateral();
    private TextView header_deb;
    private TextView header_alamat;
    private ArrayList<ISpinnerItem> lovkodepos = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovpenilai = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovdokcode = new ArrayList<ISpinnerItem>();
    private LOVDataProvider lovDataProvider;
    private RadioButton val_kendaraan_rdo_business_ya;
    private RadioButton val_kendaraan_rdo_business_tidak;
    private EditText val_kendaraan_txt_no_laporan_1;
    private EditText val_kendaraan_txt_tgl_laporan_1;
    private EditText val_kendaraan_txt_tgl_survey_1;
    private EditText val_kendaraan_txt_divisi;
    private EditText val_kendaraan_txt_segment;
    private EditText val_kendaraan_txt_alamat_lokasi;
    private EditText val_kendaraan_txt_rt;
    private EditText val_kendaraan_txt_rw;
    private EditText val_kendaraan_txt_kelurahan;
    private EditText val_kendaraan_txt_kecamatan;
    private EditText val_kendaraan_txt_kota;
    private ExSpinner val_kendaraan_spn_kodepos;
    private EditText val_kendaraan_txt_an_bpkb;
    private EditText val_kendaraan_txt_tgl_bpkb;
    private EditText val_kendaraan_txt_an_stnk;
    private EditText val_kendaraan_txt_tgl_stnk;
    private EditText val_kendaraan_txt_an_invoice;
    private EditText val_kendaraan_txt_tgl_invoice;
    private EditText val_kendaraan_txt_tgl_surat_penawaran;
    private EditText val_kendaraan_txt_an_surat_penawaran;
    private EditText val_kendaraan_txt_harga_pasar;
    private EditText val_kendaraan_txt_likuidasi;
    private EditText val_kendaraan_txt_nilai_likuidasi;
    private EditText val_kendaraan_txt_inspeksi;
    private EditText val_kendaraan_txt_ket_lain;
    private EditText val_kendaraan_txt_jns_stnk;
    private EditText val_kendaraan_txt_jns_bpkb;
    private EditText val_kendaraan_txt_jns_invoice;
    private EditText val_kendaraan_txt_jns_surat_penawaran;
    private EditText val_kendaraan_txt_alm_bpkb;
    private EditText val_kendaraan_txt_alm_stnk;
    private EditText val_kendaraan_txt_alm_invoice;
    private EditText val_kendaraan_txt_alm_surat_penawaran;
    private ExSpinner val_kendaraan_spn_nama_penilai;

    private LinearLayout contentlayout;
    private ImageView val_kendaraan_view_img_tgl_laporan_1;
    private ImageView val_kendaraan_view_img_survey_1;
    private ImageView val_kendaraan_view_img_tgl_bpkb;
    private ImageView val_kendaraan_view_img_tgl_stnk;
    private ImageView val_kendaraan_view_img_tgl_invoice;
    private ImageView val_kendaraan_view_img_tgl_surat_penawaran;
    private String col_id="";
    private String ap_regno="",status="";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_valuation_kendaraan, null);
        tableLayout = (TableLayout) view.findViewById(R.id.tagihan_tableLayout);
        super.onCreate(savedInstanceState);
        ctx = this.getActivity();
        datatype_Appr_Status = new Datatype_Appr_Status ();
        appr_Status=new Appr_Status();
        
        appr_vhc_ValuationDataProvider=new Appr_Vhc_ValuationDataProvider();
        appr_kendaraan_valuation_int = new Datatype_Appr_Vhc_Valuation_Int();
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
    private void loadData(){
    	
    	appr_kendaraan_valuation_int=appr_vhc_ValuationDataProvider.getAllAppr_Vhc_Valuation_Int(col_id);
      	if(appr_kendaraan_valuation_int.COL_ID!=null && !appr_kendaraan_valuation_int.COL_ID.equals("")){
      		val_kendaraan_txt_no_laporan_1.setText(replaceNull(appr_kendaraan_valuation_int.getREPORT_NO()));
      		if (appr_kendaraan_valuation_int.getREPORT_DATE() != null) {
	      		val_kendaraan_txt_tgl_laporan_1.setText(replaceNull(DateFormatter.formatString(appr_kendaraan_valuation_int.getREPORT_DATE())));
	      	}
      		if (appr_kendaraan_valuation_int.getREPORT_INSPECT_DATE() != null) {
      			val_kendaraan_txt_tgl_survey_1.setText(replaceNull(DateFormatter.formatString(appr_kendaraan_valuation_int.getREPORT_INSPECT_DATE())));
	      	}
      		
      		datatype_Appr_Collateral=appr_Collateral.getAllAppr_Collateral(col_id);
          	if(datatype_Appr_Collateral.COL_ID!=null && !datatype_Appr_Collateral.COL_ID.toString().equals("")){
          		val_kendaraan_txt_divisi.setText((datatype_Appr_Collateral.getBRANCHNAME()));
          		val_kendaraan_txt_segment.setText((datatype_Appr_Collateral.getSEG_DESC()));
          		header_deb.setText(datatype_Appr_Collateral.getAP_REGNO() + " # " + datatype_Appr_Collateral.getCU_NAME() );
    	  	 }
          	header_alamat.setText(appr_kendaraan_valuation_int.getCOL_ADDR1() + " , " +  appr_kendaraan_valuation_int.getCOL_KELURAHAN() + " , " +  appr_kendaraan_valuation_int.getCOL_KECAMATAN() + " , " +  appr_kendaraan_valuation_int.getCOL_CITY() + " , " +  appr_kendaraan_valuation_int.getCOL_ZIPCODE());
      	    
      		val_kendaraan_txt_alamat_lokasi.setText(replaceNull(appr_kendaraan_valuation_int.getCOL_ADDR1()));
      		val_kendaraan_txt_rt.setText(replaceNull(appr_kendaraan_valuation_int.getCOL_RT()));
      		val_kendaraan_txt_rw.setText(replaceNull(appr_kendaraan_valuation_int.getCOL_RW()));
      		val_kendaraan_txt_kelurahan.setText(replaceNull(appr_kendaraan_valuation_int.getCOL_KELURAHAN()));
      		val_kendaraan_txt_kecamatan.setText(replaceNull(appr_kendaraan_valuation_int.getCOL_KECAMATAN()));
      		val_kendaraan_txt_kota.setText(replaceNull(appr_kendaraan_valuation_int.getCOL_CITY()));
      		val_kendaraan_spn_kodepos.setSelectedListOfValue(replaceNull(appr_kendaraan_valuation_int.getCOL_ZIPCODE()));
      		val_kendaraan_txt_an_bpkb.setText(replaceNull(appr_kendaraan_valuation_int.getBPKB_NAME()));
      		if (appr_kendaraan_valuation_int.getBPKB_EXPIRE_DATE() != null) {
      			val_kendaraan_txt_tgl_bpkb.setText(replaceNull(DateFormatter.formatString(appr_kendaraan_valuation_int.getBPKB_EXPIRE_DATE())));
	      	}
      		val_kendaraan_txt_an_stnk.setText(replaceNull(appr_kendaraan_valuation_int.getSTNK_NAME()));
      		if (appr_kendaraan_valuation_int.getSTNK_EXPIRE_DATE() != null) {
      			val_kendaraan_txt_tgl_stnk.setText(replaceNull(DateFormatter.formatString(appr_kendaraan_valuation_int.getSTNK_EXPIRE_DATE())));
	      	}
      		val_kendaraan_txt_an_invoice.setText(replaceNull(appr_kendaraan_valuation_int.getINVOICE_NAME()));
      		if (appr_kendaraan_valuation_int.getINVOICE_DATE() != null) {
      			val_kendaraan_txt_tgl_invoice.setText(replaceNull(DateFormatter.formatString(appr_kendaraan_valuation_int.getINVOICE_DATE())));
	      	}
      		if (appr_kendaraan_valuation_int.getORDER_DATE() != null) {
      			val_kendaraan_txt_tgl_surat_penawaran.setText(replaceNull(DateFormatter.formatString(appr_kendaraan_valuation_int.getORDER_DATE())));
	      	}
      		val_kendaraan_txt_an_surat_penawaran.setText(replaceNull(appr_kendaraan_valuation_int.getORDER_NAME()));
      		val_kendaraan_txt_harga_pasar.setText(replaceNull(appr_kendaraan_valuation_int.getMARKET_PRICE()));
      		val_kendaraan_txt_likuidasi.setText(replaceNull(appr_kendaraan_valuation_int.getLIQUID_PERCENT()));
      		val_kendaraan_txt_nilai_likuidasi.setText(replaceNull(appr_kendaraan_valuation_int.getLIQUID_VALUE()));
      		val_kendaraan_txt_inspeksi.setText(replaceNull(appr_kendaraan_valuation_int.getINSPECTION_PERSON()));
      		val_kendaraan_txt_ket_lain.setText(replaceNull(appr_kendaraan_valuation_int.getOTHER_INFO()));
      		val_kendaraan_txt_jns_stnk.setText(replaceNull(appr_kendaraan_valuation_int.getSTNK_NO()));
      		val_kendaraan_txt_jns_bpkb.setText(replaceNull(appr_kendaraan_valuation_int.getBPKB_NO()));
      		val_kendaraan_txt_jns_invoice.setText(replaceNull(appr_kendaraan_valuation_int.getINVOICE_NO()));
      		val_kendaraan_txt_jns_surat_penawaran.setText(replaceNull(appr_kendaraan_valuation_int.getORDER_NO()));
      		val_kendaraan_txt_alm_bpkb.setText(replaceNull(appr_kendaraan_valuation_int.getBPKB_ADDRESS()));
      		val_kendaraan_txt_alm_stnk.setText(replaceNull(appr_kendaraan_valuation_int.getSTNK_ADDRESS()));
      		val_kendaraan_txt_alm_invoice.setText(replaceNull(appr_kendaraan_valuation_int.getINVOICE_ADDRESS()));
      		val_kendaraan_txt_alm_surat_penawaran.setText(replaceNull(appr_kendaraan_valuation_int.getORDER_ADDRESS()));
      		val_kendaraan_spn_nama_penilai.setSelectedListOfValue(replaceNull(appr_kendaraan_valuation_int.getCOL_APPRAISER_CODE()));
      		if(appr_kendaraan_valuation_int.getINSPECTION_BUSINESSUNIT().toUpperCase().equals("TRUE")){
	    		val_kendaraan_rdo_business_ya.setChecked(true);
	    	}
	    	else if(appr_kendaraan_valuation_int.getINSPECTION_BUSINESSUNIT().toUpperCase().equals("FALSE")){
	    		val_kendaraan_rdo_business_tidak.setChecked(true);
	    	}

      	}
    }
    private void initControl(){
    	val_kendaraan_spn_nama_penilai=(ExSpinner) view.findViewById(R.id.val_kendaraan_spn_nama_penilai);
        lovDataProvider = new LOVDataProvider();
        lovpenilai = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_PENILAI));
        val_kendaraan_spn_nama_penilai.setListOfValue(lovpenilai, false);
        header_deb							=(TextView) view.findViewById(R.id.info_Nama_deb);
        header_alamat						=(TextView) view.findViewById(R.id.info_Nama_Alamat);
        
        val_kendaraan_spn_kodepos=(ExSpinner) view.findViewById(R.id.val_kendaraan_spn_kodepos);
        lovkodepos = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_DATI2));
        val_kendaraan_spn_kodepos.setListOfValue(lovkodepos, false);
        val_kendaraan_rdo_business_ya= (RadioButton) view.findViewById(R.id.val_kendaraan_rdo_business_ya);
    	val_kendaraan_rdo_business_tidak= (RadioButton) view.findViewById(R.id.val_kendaraan_rdo_business_tidak);
    	
    	val_kendaraan_txt_no_laporan_1= (EditText) view.findViewById(R.id.val_kendaraan_txt_no_laporan_1);
    	val_kendaraan_txt_tgl_laporan_1= (EditText) view.findViewById(R.id.val_kendaraan_txt_tgl_laporan_1);
    	val_kendaraan_txt_tgl_survey_1= (EditText) view.findViewById(R.id.val_kendaraan_txt_tgl_survey_1);
    	val_kendaraan_txt_divisi= (EditText) view.findViewById(R.id.val_kendaraan_txt_divisi);
    	val_kendaraan_txt_segment= (EditText) view.findViewById(R.id.val_kendaraan_txt_segment);
    	val_kendaraan_txt_alamat_lokasi= (EditText) view.findViewById(R.id.val_kendaraan_txt_alamat_lokasi);
    	val_kendaraan_txt_rt= (EditText) view.findViewById(R.id.val_kendaraan_txt_rt);
    	val_kendaraan_txt_rw= (EditText) view.findViewById(R.id.val_kendaraan_txt_rw);
    	val_kendaraan_txt_kelurahan= (EditText) view.findViewById(R.id.val_kendaraan_txt_kelurahan);
    	val_kendaraan_txt_kecamatan= (EditText) view.findViewById(R.id.val_kendaraan_txt_kecamatan);
    	val_kendaraan_txt_kota= (EditText) view.findViewById(R.id.val_kendaraan_txt_kota);
    	val_kendaraan_txt_an_bpkb= (EditText) view.findViewById(R.id.val_kendaraan_txt_an_bpkb);
    	val_kendaraan_txt_tgl_bpkb= (EditText) view.findViewById(R.id.val_kendaraan_txt_tgl_bpkb);
    	val_kendaraan_txt_an_stnk= (EditText) view.findViewById(R.id.val_kendaraan_txt_an_stnk);
    	val_kendaraan_txt_tgl_stnk= (EditText) view.findViewById(R.id.val_kendaraan_txt_tgl_stnk);
    	val_kendaraan_txt_an_invoice= (EditText) view.findViewById(R.id.val_kendaraan_txt_an_invoice);
    	val_kendaraan_txt_tgl_invoice= (EditText) view.findViewById(R.id.val_kendaraan_txt_tgl_invoice);
 
    	val_kendaraan_txt_an_surat_penawaran= (EditText) view.findViewById(R.id.val_kendaraan_txt_an_surat_penawaran);
    	val_kendaraan_txt_tgl_surat_penawaran= (EditText) view.findViewById(R.id.val_kendaraan_txt_tgl_surat_penawaran);
    	val_kendaraan_txt_harga_pasar= (EditText) view.findViewById(R.id.val_kendaraan_txt_harga_pasar);
    	val_kendaraan_txt_likuidasi= (EditText) view.findViewById(R.id.val_kendaraan_txt_likuidasi);
    	val_kendaraan_txt_nilai_likuidasi= (EditText) view.findViewById(R.id.val_kendaraan_txt_nilai_likuidasi);
    	val_kendaraan_txt_inspeksi= (EditText) view.findViewById(R.id.val_kendaraan_txt_inspeksi);
    	val_kendaraan_txt_ket_lain= (EditText) view.findViewById(R.id.val_kendaraan_txt_ket_lain);
    	val_kendaraan_txt_jns_stnk= (EditText) view.findViewById(R.id.val_kendaraan_txt_jns_stnk);
    	val_kendaraan_txt_jns_bpkb= (EditText) view.findViewById(R.id.val_kendaraan_txt_jns_bpkb);
    	val_kendaraan_txt_jns_invoice= (EditText) view.findViewById(R.id.val_kendaraan_txt_jns_invoice);
    	val_kendaraan_txt_jns_surat_penawaran= (EditText) view.findViewById(R.id.val_kendaraan_txt_jns_surat_penawaran);
    	val_kendaraan_txt_alm_bpkb= (EditText) view.findViewById(R.id.val_kendaraan_txt_alm_bpkb);
    	val_kendaraan_txt_alm_stnk= (EditText) view.findViewById(R.id.val_kendaraan_txt_alm_stnk);
    	val_kendaraan_txt_alm_invoice= (EditText) view.findViewById(R.id.val_kendaraan_txt_alm_invoice);
    	val_kendaraan_txt_alm_surat_penawaran= (EditText) view.findViewById(R.id.val_kendaraan_txt_alm_surat_penawaran);
    	
        val_kendaraan_view_img_tgl_bpkb = (ImageView) view.findViewById(R.id.val_kendaraan_view_img_tgl_bpkb);
        val_kendaraan_view_img_tgl_stnk = (ImageView) view.findViewById(R.id.val_kendaraan_view_img_tgl_stnk);
        val_kendaraan_view_img_tgl_invoice = (ImageView) view.findViewById(R.id.val_kendaraan_view_img_tgl_invoice);
        val_kendaraan_view_img_tgl_surat_penawaran = (ImageView) view.findViewById(R.id.val_kendaraan_view_img_tgl_surat_penawaran);
        
        val_kendaraan_view_img_tgl_laporan_1= (ImageView) view.findViewById(R.id.val_kendaraan_view_img_tgl_laporan_1);
        val_kendaraan_view_img_survey_1= (ImageView) view.findViewById(R.id.val_kendaraan_view_img_survey_1);
        
        Btnsave = (Button) view.findViewById(R.id.btn_savekendaraan);

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

        val_kendaraan_view_img_tgl_laporan_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] arrTglLahir = null;

                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = (c.get(Calendar.MONTH));
                int day = c.get(Calendar.DAY_OF_MONTH);
                try{
	                if (val_kendaraan_txt_tgl_laporan_1.getText().toString().equalsIgnoreCase("")) {
	                    arrTglLahir = val_kendaraan_txt_tgl_laporan_1.getText().toString().split("-");
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
    	
        val_kendaraan_view_img_survey_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] arrTglLahir = null;

                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = (c.get(Calendar.MONTH));
                int day = c.get(Calendar.DAY_OF_MONTH);
                try{
                if (val_kendaraan_txt_tgl_survey_1.getText().toString().equalsIgnoreCase("")) {
                    arrTglLahir = val_kendaraan_txt_tgl_survey_1.getText().toString().split("-");
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
        
        
        val_kendaraan_view_img_tgl_bpkb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] arrTglLahir = null;

                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = (c.get(Calendar.MONTH));
                int day = c.get(Calendar.DAY_OF_MONTH);
                try{
                if (val_kendaraan_txt_tgl_bpkb.getText().toString().equalsIgnoreCase("")) {
                    arrTglLahir = val_kendaraan_txt_tgl_bpkb.getText().toString().split("-");
                    year = Integer.parseInt(arrTglLahir[2]);
                    month = Integer.parseInt(arrTglLahir[1]) - 1;
                    day = Integer.parseInt(arrTglLahir[0]);
                }
                }
                catch(Exception e){
                	
                }
                DatePickerManager datePickerDialog = new DatePickerManager(ctx, PbBpkbDateSetListener, year, month, day);
                datePickerDialog.show();

            }
        });
        
        val_kendaraan_view_img_tgl_invoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] arrTglLahir = null;

                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = (c.get(Calendar.MONTH));
                int day = c.get(Calendar.DAY_OF_MONTH);
                try{
                if (val_kendaraan_txt_tgl_invoice.getText().toString().equalsIgnoreCase("")) {
                    arrTglLahir = val_kendaraan_txt_tgl_invoice.getText().toString().split("-");
                    year = Integer.parseInt(arrTglLahir[2]);
                    month = Integer.parseInt(arrTglLahir[1]) - 1;
                    day = Integer.parseInt(arrTglLahir[0]);
                }
                }
                catch(Exception e){
                	
                }
                DatePickerManager datePickerDialog = new DatePickerManager(ctx, PbInvoiceDateSetListener, year, month, day);
                datePickerDialog.show();

            }
        });
        val_kendaraan_view_img_tgl_stnk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] arrTglLahir = null;

                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = (c.get(Calendar.MONTH));
                int day = c.get(Calendar.DAY_OF_MONTH);
                try{
                if (val_kendaraan_txt_tgl_stnk.getText().toString().equalsIgnoreCase("")) {
                    arrTglLahir = val_kendaraan_txt_tgl_stnk.getText().toString().split("-");
                    year = Integer.parseInt(arrTglLahir[2]);
                    month = Integer.parseInt(arrTglLahir[1]) - 1;
                    day = Integer.parseInt(arrTglLahir[0]);
                }
                }
                catch(Exception e){
                	
                }
                DatePickerManager datePickerDialog = new DatePickerManager(ctx, PbStnkDateSetListener, year, month, day);
                datePickerDialog.show();

            }
        });
        
        val_kendaraan_view_img_tgl_surat_penawaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] arrTglLahir = null;

                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = (c.get(Calendar.MONTH));
                int day = c.get(Calendar.DAY_OF_MONTH);
                try{
                if (val_kendaraan_txt_tgl_surat_penawaran.getText().toString().equalsIgnoreCase("")) {
                    arrTglLahir = val_kendaraan_txt_tgl_surat_penawaran.getText().toString().split("-");
                    year = Integer.parseInt(arrTglLahir[2]);
                    month = Integer.parseInt(arrTglLahir[1]) - 1;
                    day = Integer.parseInt(arrTglLahir[0]);
                }
                }
                catch(Exception e){
                	
                }
                DatePickerManager datePickerDialog = new DatePickerManager(ctx, PbSuratpenawaranDateSetListener, year, month, day);
                datePickerDialog.show();

            }
        });
        setColorMandatory();
        if(status.equals("INQUERY")){
	    	contentlayout= (LinearLayout) view.findViewById(R.id.contentlayout);
	    	//Btnsave.setEnabled(false);
	    	
	    	
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
    	if(val_kendaraan_txt_tgl_laporan_1.getText().length()>0 && val_kendaraan_txt_tgl_survey_1.getText().length() >0 ){
	    	Date LaporanDate = DateFormatter.formatDate(val_kendaraan_txt_tgl_laporan_1.getText().toString());
	        Date SurveyDate=  DateFormatter.formatDate(val_kendaraan_txt_tgl_survey_1.getText().toString());
	    	
	        if(LaporanDate.before(SurveyDate))
	        	retval=false;
    	}
        return retval;
 }		
    private void setColorMandatory(){
    	val_kendaraan_txt_no_laporan_1.setBackgroundResource(R.drawable.fillcolor);
    	val_kendaraan_txt_tgl_laporan_1.setBackgroundResource(R.drawable.fillcolor);
    	val_kendaraan_txt_tgl_survey_1.setBackgroundResource(R.drawable.fillcolor);
    	val_kendaraan_txt_alamat_lokasi.setBackgroundResource(R.drawable.fillcolor);
    	val_kendaraan_txt_kelurahan.setBackgroundResource(R.drawable.fillcolor);
    	val_kendaraan_txt_kecamatan.setBackgroundResource(R.drawable.fillcolor);
    	val_kendaraan_txt_kota.setBackgroundResource(R.drawable.fillcolor);
    	val_kendaraan_txt_harga_pasar.setBackgroundResource(R.drawable.fillcolor);
    	val_kendaraan_txt_likuidasi.setBackgroundResource(R.drawable.fillcolor);
    	val_kendaraan_txt_nilai_likuidasi.setBackgroundResource(R.drawable.fillcolor);
    	val_kendaraan_txt_inspeksi.setBackgroundResource(R.drawable.fillcolor);

  	
    }
    private Boolean CekMandatory(){
    	/*setREPORT_NO
    	setREPORT_DATE
    	setREPORT_INSPECT_DATE
    	setCOL_ADDR1
    	setCOL_KELURAHAN
    	setCOL_KECAMATAN
    	setCOL_CITY
    	setMARKET_PRICE
    	setLIQUID_PERCENT
    	setLIQUID_VALUE
    	getINSPECTION_PERSON
    	getCOL_ZIPCODE
    	setCOL_APPRAISER_CODE*/
  	 boolean retval=true;
  	  
  	appr_kendaraan_valuation_int=appr_vhc_ValuationDataProvider.getAllAppr_Vhc_Valuation_Int(col_id);
  	if(appr_kendaraan_valuation_int.COL_ID!=null && !appr_kendaraan_valuation_int.COL_ID.equals("")){
		if(appr_kendaraan_valuation_int.REPORT_NO==null || appr_kendaraan_valuation_int.REPORT_NO.equals(""))
  			retval=false;
		if(appr_kendaraan_valuation_int.REPORT_DATE==null || appr_kendaraan_valuation_int.REPORT_DATE.equals(""))
  			retval=false;
		if(appr_kendaraan_valuation_int.REPORT_INSPECT_DATE==null || appr_kendaraan_valuation_int.REPORT_INSPECT_DATE.equals(""))
  			retval=false;
		if(appr_kendaraan_valuation_int.COL_ADDR1==null || appr_kendaraan_valuation_int.COL_ADDR1.equals(""))
  			retval=false;
		if(appr_kendaraan_valuation_int.COL_KELURAHAN==null || appr_kendaraan_valuation_int.COL_KELURAHAN.equals(""))
  			retval=false;
		if(appr_kendaraan_valuation_int.COL_KECAMATAN==null || appr_kendaraan_valuation_int.COL_KECAMATAN.equals(""))
  			retval=false;
		if(appr_kendaraan_valuation_int.COL_CITY==null || appr_kendaraan_valuation_int.COL_CITY.equals(""))
  			retval=false;
		if(appr_kendaraan_valuation_int.MARKET_PRICE==null || appr_kendaraan_valuation_int.MARKET_PRICE.equals(""))
  			retval=false;
		if(appr_kendaraan_valuation_int.LIQUID_PERCENT==null || appr_kendaraan_valuation_int.LIQUID_PERCENT.equals(""))
  			retval=false;
		if(appr_kendaraan_valuation_int.LIQUID_VALUE==null || appr_kendaraan_valuation_int.LIQUID_VALUE.equals(""))
  			retval=false;
		if(appr_kendaraan_valuation_int.INSPECTION_PERSON==null || appr_kendaraan_valuation_int.INSPECTION_PERSON.equals(""))
  			retval=false;
		if(appr_kendaraan_valuation_int.COL_ZIPCODE==null || appr_kendaraan_valuation_int.COL_ZIPCODE.equals(""))
  			retval=false;
		if(appr_kendaraan_valuation_int.COL_APPRAISER_CODE==null || appr_kendaraan_valuation_int.COL_APPRAISER_CODE.equals(""))
  			retval=false;
	}
  	/*
  	  if(val_kendaraan_txt_no_laporan_1.getText().length()==0){
  		val_kendaraan_txt_no_laporan_1.setError("Field Tidak Boleh Kososng");
  		  retval=false;
  	  }
  	  if(val_kendaraan_txt_tgl_laporan_1.getText().length()==0){
  		val_kendaraan_txt_tgl_laporan_1.setError("Field Tidak Boleh Kososng");
  		  retval=false;
  	  }
  	  if(val_kendaraan_txt_tgl_survey_1.getText().length()==0){
  		val_kendaraan_txt_tgl_survey_1.setError("Field Tidak Boleh Kososng");
  		  retval=false;
  	  }
  	  if(val_kendaraan_txt_alamat_lokasi.getText().length()==0){
  		val_kendaraan_txt_alamat_lokasi.setError("Field Tidak Boleh Kososng");
  		  retval=false;
  	  }
  	  if(val_kendaraan_txt_kelurahan.getText().length()==0){
  		val_kendaraan_txt_kelurahan.setError("Field Tidak Boleh Kososng");
  		  retval=false;
  	  }
  	  if(val_kendaraan_txt_kecamatan.getText().length()==0){
  		  val_kendaraan_txt_kecamatan.setError("Field Tidak Boleh Kososng");
  		  retval=false;
  	  }
  	  if(val_kendaraan_txt_kota.getText().length()==0){
  		  val_kendaraan_txt_kota.setError("Field Tidak Boleh Kososng");
  		  retval=false;
  	  }
  	  if(val_kendaraan_txt_harga_pasar.getText().length()==0){
  		val_kendaraan_txt_harga_pasar.setError("Field Tidak Boleh Kososng");
  		  retval=false;
  	  }
  	  if(val_kendaraan_txt_likuidasi.getText().length()==0){
  		val_kendaraan_txt_likuidasi.setError("Field Tidak Boleh Kososng");
  		  retval=false;
  	  }
  	  if(val_kendaraan_txt_nilai_likuidasi.getText().length()==0){
  		val_kendaraan_txt_nilai_likuidasi.setError("Field Tidak Boleh Kososng");
  		  retval=false;
  	  }
  	  if(val_kendaraan_txt_inspeksi.getText().length()==0){
  		  val_kendaraan_txt_inspeksi.setError("Field Tidak Boleh Kososng");
  		  retval=false;
  	  }
  	  
  	
  	  View selectedView = val_kendaraan_spn_kodepos.getSelectedView();
	  if (selectedView != null && selectedView instanceof TextView) {
	      TextView selectedTextView = (TextView) selectedView;
	      if (val_kendaraan_spn_kodepos.getSelectedListOfValue().toString().length()==0) {
	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
	          selectedTextView.setError(errorString);
	          retval=false;
	      }
	      else {
	          selectedTextView.setError(null);
	      }
	  }
  	  

	  View selectedView1 = val_kendaraan_spn_nama_penilai.getSelectedView();
	  if (selectedView1 != null && selectedView1 instanceof TextView) {
	      TextView selectedTextView = (TextView) selectedView1;
	      if (val_kendaraan_spn_nama_penilai.getSelectedListOfValue().toString().length()==0) {
	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
	          selectedTextView.setError(errorString);
	          retval=false;
	      }
	      else {
	          selectedTextView.setError(null);
	      }
	  }*/
	  
  	  return retval;
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
    private void saveData(){
    	
	    	appr_kendaraan_valuation_int.setCOL_ID(col_id);
	    	appr_kendaraan_valuation_int.setAP_REGNO(ap_regno);
	    	appr_kendaraan_valuation_int.setREPORT_NO(val_kendaraan_txt_no_laporan_1.getText().toString());
	    	appr_kendaraan_valuation_int.setREPORT_DATE(DateFormatter.formatDate(val_kendaraan_txt_tgl_laporan_1.getText().toString()));
	    	appr_kendaraan_valuation_int.setREPORT_INSPECT_DATE(DateFormatter.formatDate(val_kendaraan_txt_tgl_survey_1.getText().toString()));
	    	appr_kendaraan_valuation_int.setREPORT_BRANCH_CODE(val_kendaraan_txt_divisi.getText().toString());
	    	appr_kendaraan_valuation_int.setREPORT_SEG_CODE(val_kendaraan_txt_segment.getText().toString());
	    	appr_kendaraan_valuation_int.setCOL_ADDR1(val_kendaraan_txt_alamat_lokasi.getText().toString());
	    	appr_kendaraan_valuation_int.setCOL_RT(val_kendaraan_txt_rt.getText().toString());
	    	appr_kendaraan_valuation_int.setCOL_RW(val_kendaraan_txt_rw.getText().toString());
	    	appr_kendaraan_valuation_int.setCOL_KELURAHAN(val_kendaraan_txt_kelurahan.getText().toString());
	    	appr_kendaraan_valuation_int.setCOL_KECAMATAN(val_kendaraan_txt_kecamatan.getText().toString());
	    	appr_kendaraan_valuation_int.setCOL_CITY(val_kendaraan_txt_kota.getText().toString());
	    	appr_kendaraan_valuation_int.setCOL_ZIPCODE(val_kendaraan_spn_kodepos.getSelectedListOfValue().toString());
	    	appr_kendaraan_valuation_int.setBPKB_NAME(val_kendaraan_txt_an_bpkb.getText().toString());
	    	appr_kendaraan_valuation_int.setBPKB_EXPIRE_DATE(DateFormatter.formatDate(val_kendaraan_txt_tgl_bpkb.getText().toString()));
	    	appr_kendaraan_valuation_int.setSTNK_NAME(val_kendaraan_txt_an_stnk.getText().toString());
	    	appr_kendaraan_valuation_int.setSTNK_EXPIRE_DATE(DateFormatter.formatDate(val_kendaraan_txt_tgl_stnk.getText().toString()));
	    	appr_kendaraan_valuation_int.setINVOICE_NAME(val_kendaraan_txt_an_invoice.getText().toString());
	    	appr_kendaraan_valuation_int.setINVOICE_DATE(DateFormatter.formatDate(val_kendaraan_txt_tgl_invoice.getText().toString()));
	    	appr_kendaraan_valuation_int.setORDER_DATE(DateFormatter.formatDate(val_kendaraan_txt_tgl_surat_penawaran.getText().toString()));
	    	appr_kendaraan_valuation_int.setORDER_NAME(val_kendaraan_txt_an_surat_penawaran.getText().toString());
	    	appr_kendaraan_valuation_int.setMARKET_PRICE(val_kendaraan_txt_harga_pasar.getText().toString());
	    	appr_kendaraan_valuation_int.setLIQUID_PERCENT(val_kendaraan_txt_likuidasi.getText().toString());
	    	appr_kendaraan_valuation_int.setLIQUID_VALUE(val_kendaraan_txt_nilai_likuidasi.getText().toString());
	    	appr_kendaraan_valuation_int.setINSPECTION_PERSON(val_kendaraan_txt_inspeksi.getText().toString());
	    	appr_kendaraan_valuation_int.setOTHER_INFO(val_kendaraan_txt_ket_lain.getText().toString());
	    	appr_kendaraan_valuation_int.setSTNK_NO(val_kendaraan_txt_jns_stnk.getText().toString());
	    	appr_kendaraan_valuation_int.setBPKB_NO(val_kendaraan_txt_jns_bpkb.getText().toString());
	    	appr_kendaraan_valuation_int.setINVOICE_NO(val_kendaraan_txt_jns_invoice.getText().toString());
	    	appr_kendaraan_valuation_int.setORDER_NO(val_kendaraan_txt_jns_surat_penawaran.getText().toString());
	    	appr_kendaraan_valuation_int.setBPKB_ADDRESS(val_kendaraan_txt_alm_bpkb.getText().toString());
	    	appr_kendaraan_valuation_int.setSTNK_ADDRESS(val_kendaraan_txt_alm_stnk.getText().toString());
	    	appr_kendaraan_valuation_int.setINVOICE_ADDRESS(val_kendaraan_txt_alm_invoice.getText().toString());
	    	appr_kendaraan_valuation_int.setORDER_ADDRESS(val_kendaraan_txt_alm_surat_penawaran.getText().toString());
	    	appr_kendaraan_valuation_int.setCOL_APPRAISER_CODE(val_kendaraan_spn_nama_penilai.getSelectedListOfValue().toString());
	    	 if(val_kendaraan_rdo_business_ya.isChecked()){
	    		 appr_kendaraan_valuation_int.setINSPECTION_BUSINESSUNIT(AppConstants.RDOYA);  
			  }
			  else if(val_kendaraan_rdo_business_tidak.isChecked()){
				  appr_kendaraan_valuation_int.setINSPECTION_BUSINESSUNIT(AppConstants.RDOTIDAK);  
			  }
	
		  	
		        appr_vhc_ValuationDataProvider.updateData(appr_kendaraan_valuation_int);
		        
		        
		        datatype_Appr_Status.setAP_REGNO(ap_regno);
		        datatype_Appr_Status.setCOL_ID(col_id);
		        datatype_Appr_Status.setAPPRS_TYPE("V");
		        datatype_Appr_Status.setSTATUS("1");
		        appr_Status.updateData(datatype_Appr_Status);
		        showAlert(R.string.msg_notification_update_success);

		        
		//if(CekMandatory().equals(false)){
    	//	showAlert(R.string.msg_notification_mandatory);
    	//}
    }
    private DatePickerDialog.OnDateSetListener PbSurveyDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int monthOfYear, int dayOfMonth) {
        	val_kendaraan_txt_tgl_survey_1.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
        }
    };
    private DatePickerDialog.OnDateSetListener PbBpkbDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int monthOfYear, int dayOfMonth) {
        	val_kendaraan_txt_tgl_bpkb.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
        }
    };
    private DatePickerDialog.OnDateSetListener PbStnkDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int monthOfYear, int dayOfMonth) {
        	val_kendaraan_txt_tgl_stnk.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
        }
    };
    private DatePickerDialog.OnDateSetListener PbSuratpenawaranDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int monthOfYear, int dayOfMonth) {
        	val_kendaraan_txt_tgl_surat_penawaran.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
        }
    };
      private DatePickerDialog.OnDateSetListener PbTglLaporDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int monthOfYear, int dayOfMonth) {
        	val_kendaraan_txt_tgl_laporan_1.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
        }
    };
    private DatePickerDialog.OnDateSetListener PbInvoiceDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int monthOfYear, int dayOfMonth) {
        	val_kendaraan_txt_tgl_invoice.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
        }
    };
    public static String replaceNull(String input) {
  	  return input == null ? "" : input;
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

        EditText header = new EditText(ctx);
        header.setGravity(Gravity.LEFT);
        header.setTextColor(getResources().getColor(android.R.color.black));
        header.setPadding(0, 3, 0, 3);
        header.setTextSize(12);
        header.setWidth(1000);
        header.setText("No");
        rowHeaderTable.addView(header, rowParamsDetail);

        EditText header1 = new EditText(ctx);
        header1.setGravity(Gravity.LEFT);
        header1.setTextColor(getResources().getColor(android.R.color.black));
        header1.setPadding(0, 3, 0, 3);
        header1.setTextSize(12);
        header1.setWidth(1000);
        header1.setText("No.Rekening");
        rowHeaderTable.addView(header1, rowParamsDetail);

        EditText header2 = new EditText(ctx);
        header2.setGravity(Gravity.LEFT);
        header2.setTextColor(getResources().getColor(android.R.color.black));
        header2.setPadding(0, 3, 0, 3);
        header2.setTextSize(12);
        header2.setWidth(180);
        header2.setText("Nama Debitur");
        rowHeaderTable.addView(header2, rowParamsDetail);

        EditText header3 = new EditText(ctx);
        header3.setGravity(Gravity.LEFT);
        header3.setTextColor(getResources().getColor(android.R.color.black));
        header3.setPadding(0, 3, 0, 3);
        header3.setTextSize(12);
        header3.setWidth(100);
        header3.setText("Nominal");
        rowHeaderTable.addView(header3, rowParamsDetail);

        EditText header4 = new EditText(ctx);
        header4.setGravity(Gravity.LEFT);
        header4.setTextColor(getResources().getColor(android.R.color.black));
        header4.setPadding(0, 3, 0, 3);
        header4.setTextSize(12);
        header4.setWidth(100);
        header4.setText("Sisa Tagihan");
        rowHeaderTable.addView(header4, rowParamsDetail);

        EditText header5 = new EditText(ctx);
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
				
				EditText counter = new EditText(ctx);
				counter.setGravity(Gravity.LEFT);
				counter.setTextColor(getResources().getColor(android.R.color.black));
				counter.setPadding(0, 3, 0, 3);
				counter.setTextSize(12);
				counter.setWidth(25);
				counter.setText(""+(i+1+intnomor));
				rowContentTable.addView(counter,rowParamsDetail);
				
				
									
				EditText tv_valuehidden = new EditText(ctx);
				tv_valuehidden.setText(contentdata.getID().toString());
				rowContentTable.addView(tv_valuehidden);
				tv_valuehidden.setVisibility(View.GONE);
				
				EditText tv_rekening = new EditText(ctx);
				tv_rekening.setGravity(Gravity.LEFT);
				tv_rekening.setTextColor(getResources().getColor(android.R.color.black));
				tv_rekening.setPadding(0, 3, 0, 3);
				tv_rekening.setTextSize(12);
				tv_rekening.setWidth(100);
				tv_rekening.setText(contentdata.getNOMORREKENING());
				rowContentTable.addView(tv_rekening,rowParamsDetail);
				
				EditText tv_namadebitur = new EditText(ctx);
				tv_namadebitur.setGravity(Gravity.LEFT);
				tv_namadebitur.setTextColor(getResources().getColor(android.R.color.black));
				tv_namadebitur.setPadding(0, 3, 0, 3);
				tv_namadebitur.setTextSize(12);
				tv_namadebitur.setWidth(180);
				tv_namadebitur.setText(contentdata.getNAMADEBITUR());
				rowContentTable.addView(tv_namadebitur,rowParamsDetail);
				
				EditText tv_nominal = new EditText(ctx);
				tv_nominal.setGravity(Gravity.LEFT);
				tv_nominal.setTextColor(getResources().getColor(android.R.color.black));
				tv_nominal.setPadding(0, 3, 0, 3);
				tv_nominal.setTextSize(12);
				tv_nominal.setWidth(100);
				tv_nominal.setText(contentdata.getTAGIHAN());
				rowContentTable.addView(tv_nominal,rowParamsDetail);
										
				EditText tv_sisatagihan = new EditText(ctx);
				tv_sisatagihan.setGravity(Gravity.LEFT);
				tv_sisatagihan.setTextColor(getResources().getColor(android.R.color.black));
				tv_sisatagihan.setPadding(0, 3, 0, 3);
				tv_sisatagihan.setTextSize(12);
				tv_sisatagihan.setWidth(95);
				tv_sisatagihan.setText(contentdata.getSISATAGIHAN());
				rowContentTable.addView(tv_sisatagihan,rowParamsDetail);
				
								
			
				
				if (Double.parseDouble(contentdata.getSISATAGIHAN())==0){
					EditText tv_lunas = new EditText(ctx);
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
					        EditText contentTrx = (EditText) rowContentTable.getChildAt(1);
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
