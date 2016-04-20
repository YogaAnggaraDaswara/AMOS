package com.mobile.appraisal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.mobile.app.configuration.AppConstants;
import com.mobile.app.ui.DatePickerManager;
import com.mobile.app.ui.ListOfValueAdapter;
import com.mobile.bo.app.dataprovider.Appr_Collateral;
import com.mobile.bo.app.dataprovider.Appr_Rtb_DataDataProvider;
import com.mobile.bo.app.dataprovider.Appr_Rtb_ValuationDataProvider;
import com.mobile.bo.app.datatype.Datatype_Appr_Rtb_Data_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_Rtb_Valuation_Int;
import com.mobile.bo.app.dataprovider.Appr_Val_BangunanDataProvider;
import com.mobile.bo.app.dataprovider.LOVDataProvider;
import com.mobile.bo.app.datatype.Datatype_Appr_Collateral;

import com.mobile.bo.app.datatype.Datatype_Appr_valBangunan;
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
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioButton;

import bii.mobile.amos.R;

public class Fragment_Valuation_Rumah_Tanah_Bangunan extends Fragment {
    Button button,btn_new;
    private LOVDataProvider lovDataProvider;
    private EditText val_rtb_txt_no_laporan_1;
    private EditText val_rtb_txt_divisi;
    private EditText  val_rtb_txt_segment;
    private EditText  val_rtb_txt_nama_contact;
    private EditText  val_rtb_txt_no_hp;
    private EditText  val_rtb_txt_notelp;
    private EditText  val_rtb_txt_luas;
    private EditText  val_rtb_txt_nilai;
    private EditText  val_rtb_txt_nilai_pasar;
    private EditText  val_rtb_txt_likuidasi_tanah;
    private EditText  val_rtb_txt_Likuidasi2;
    private EditText  val_rtb_txt_total_fisik_bangunan;
    private EditText  val_rtb_txt_total_likuidasi_fisik_bangunan;
    private EditText  val_rtb_txt_total_fisik;
    private EditText  val_rtb_txt_total_fisik_likuidasi;
    private EditText  val_rtb_txt_bangunan_asuransi;
    private EditText  val_rtb_txt_jumlah_unit;
    private EditText  val_rtb_txt_luas_tanah;
    private EditText  val_rtb_txt_luas_bangunan;
    private EditText  val_rtb_txt_unit_nilai_pasar;
    private EditText  val_rtb_txt_likuidasi1;
    private EditText  val_rtb_txt_unit_nilai_likuidasi;
    private EditText  val_rtb_txt_tgl_laporan_1;
    private EditText  val_rtb_txt_tgl_survey_1;
    private ImageView val_rtb_view_img_tgl_laporan_1;
    private ImageView val_rtb_view_img_survey_1;
    private EditText val_rtb_txt_likuidasi3;
    private ArrayList<ISpinnerItem> lovpenilai = new ArrayList<ISpinnerItem>();
    private ExSpinner val_rtb_spn_nama_penilai;
    private RadioGroup val_rtb_rdogroup_cek_tatakota;
    private RadioButton val_rtb_rdo_cek_tatakota_ya;
    private RadioButton val_rtb_rdo_cek_tatakota_tidak;
    private EditText val_rtb_txt_nilai_pemotongan;
    private RadioGroup val_rtb_rdogroup_cek_penilaian;
    private RadioButton val_rtb_rdo_cek_penilaian_tanah;
    private RadioButton val_rtb_rdo_cek_penilaian_bangunan;
    private RadioButton val_rtb_rdo_penilaian_unit;
    private TextView val_rtb_header_dok_nilai1;
	private LinearLayout contentlayout;
    private LinearLayout val_rtb_header_tanah;
    private LinearLayout val_rtb_header_tanahbangunan;
    private LinearLayout val_rtb_header_unit;
    private LinearLayout val_rtb_linear_penilaian;
    private LinearLayout val_header_bangunan_asuransi;
    private LinearLayout val_header_bangunan_asuransi1;
    
    private Appr_Rtb_ValuationDataProvider appr_Rtb_ValuationDataProvider;
    private Datatype_Appr_Rtb_Valuation_Int appr_rtb_valuation_int = new Datatype_Appr_Rtb_Valuation_Int();
    private Appr_Val_BangunanDataProvider appr_Val_BangunanDataProvider=new Appr_Val_BangunanDataProvider();
    private Datatype_Appr_valBangunan appr_valBangunan = new Datatype_Appr_valBangunan();
    private ArrayList<Datatype_Appr_valBangunan> listdataBangunan  = null;
    private Fragment_Valuation_Bangunan_Dialog fragment_Valuation_Bangunan_Dialog=null;
    private TableLayout inbox_tableLayout=null;
    private Context ctx = null;
    View view=null;
    Button Btnsave;
    private String col_id="";
    private String ap_regno="",status="";

    private Datatype_Appr_Collateral datatype_Appr_Collateral = new Datatype_Appr_Collateral();
    private Appr_Collateral appr_Collateral=new Appr_Collateral();
    private Appr_Rtb_DataDataProvider appr_Rtb_DataProvider=new Appr_Rtb_DataDataProvider();
    private Datatype_Appr_Rtb_Data_Int appr_Rtb_data_int = new Datatype_Appr_Rtb_Data_Int();
    
    private TextView header_deb;
    private TextView header_alamat;
    public Fragment_Valuation_Rumah_Tanah_Bangunan() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_valuation_rumah_tanah_bangunan, null);
    	
        ctx = this.getActivity();
      
        appr_Rtb_ValuationDataProvider=new Appr_Rtb_ValuationDataProvider();
        appr_rtb_valuation_int=new Datatype_Appr_Rtb_Valuation_Int();
        appr_Val_BangunanDataProvider=new Appr_Val_BangunanDataProvider();
        fragment_Valuation_Bangunan_Dialog=new Fragment_Valuation_Bangunan_Dialog(ctx) ;    
        inbox_tableLayout = (TableLayout) view.findViewById(R.id.inbox_tableLayout);
        datatype_Appr_Collateral = new Datatype_Appr_Collateral();
        appr_Rtb_DataProvider=new Appr_Rtb_DataDataProvider();
        appr_Rtb_data_int = new Datatype_Appr_Rtb_Data_Int();
        
        appr_Collateral=new Appr_Collateral();
        Bundle b = getArguments();
    	col_id=b.getString("COL_ID");
        ap_regno=b.getString("AP_REGNO");
        status=b.getString("STATUS");
        initControl();
        loadData();
        setMaxLen("");
        viewdataBangunan();
        return view;
    }
    private void viewdataBangunan() {
    	listdataBangunan =appr_Val_BangunanDataProvider.getAllAppr_Bangunan(col_id);
    	inbox_tableLayout.removeAllViews();
    	
    	TableRow rowHeaderTable = new TableRow(ctx);
        rowHeaderTable.setBackgroundColor(getResources().getColor(R.color.color_bacground2));
        rowHeaderTable.setPadding(0, 0, 0, 2);

        TableRow.LayoutParams rowParamsDetail = new TableRow.LayoutParams();
        rowParamsDetail.gravity = Gravity.LEFT;

        TextView header1 = new TextView(ctx);
        header1.setGravity(Gravity.LEFT);
        header1.setTextColor(getResources().getColor(android.R.color.black));
        header1.setPadding(0, 3, 0, 3);
        header1.setTextSize(12);
        header1.setWidth(50);
        header1.setText("Jenis Bangunan");

        rowHeaderTable.addView(header1, rowParamsDetail);

        TextView header2 = new TextView(ctx);
        header2.setGravity(Gravity.LEFT);
        header2.setTextColor(getResources().getColor(android.R.color.black));
        header2.setPadding(0, 2, 0,2);
        header2.setTextSize(12);
        header2.setWidth(340);
        header2.setText("Luas(m2) sesuai fisik");
        rowHeaderTable.addView(header2, rowParamsDetail);
        
        TextView header3 = new TextView(ctx);
        header3.setGravity(Gravity.LEFT);
        header3.setTextColor(getResources().getColor(android.R.color.black));
        header3.setPadding(0, 3, 0, 3);
        header3.setTextSize(12);
        header3.setWidth(170);
        header3.setText("Nilai (per m2)");
        rowHeaderTable.addView(header3, rowParamsDetail);
       
        
        TextView header4 = new TextView(ctx);
        header4.setGravity(Gravity.LEFT);
        header4.setTextColor(getResources().getColor(android.R.color.black));
        header4.setPadding(0, 3, 0, 3);
        header4.setTextSize(12);
        header4.setWidth(170);
        header4.setText("Nilai pasar sesuai fisik");
        rowHeaderTable.addView(header4, rowParamsDetail);
        
        
        TextView header5 = new TextView(ctx);
        header5.setGravity(Gravity.LEFT);
        header5.setTextColor(getResources().getColor(android.R.color.black));
        header5.setPadding(0, 3, 0, 3);
        header5.setTextSize(12);
        header5.setWidth(170);
        header5.setText("Likuidasi Bangunan(%) sesuai fisik");
        rowHeaderTable.addView(header5, rowParamsDetail);
        
        TextView header6 = new TextView(ctx);
        header6.setGravity(Gravity.LEFT);
        header6.setTextColor(getResources().getColor(android.R.color.black));
        header6.setPadding(0, 3, 0, 3);
        header6.setTextSize(12);
        header6.setWidth(170);
        header6.setText("Nilai Likuidasi Bangunan sesuai fisik");
        rowHeaderTable.addView(header6, rowParamsDetail);
        
        inbox_tableLayout.addView(rowHeaderTable);

        for (int i = 0; i < listdataBangunan.size(); i++) {
            final Datatype_Appr_valBangunan contentdata = listdataBangunan.get(i);
            final TableRow rowContentTable = new TableRow(ctx);
            if ((i + 1) % 2 == 0) {
                rowContentTable.setBackgroundColor(getResources().getColor(R.color.color_bacground1));
            } else {
                rowContentTable.setBackgroundColor(Color.WHITE);
            }
           
            TextView content_col_id = new TextView(ctx);
            content_col_id.setText(contentdata.getID());
            content_col_id.setVisibility(View.GONE);
            rowContentTable.addView(content_col_id);
            
            TextView content_seq = new TextView(ctx);
            content_seq.setText(contentdata.getBUILD_SEQ());
            content_seq.setVisibility(View.GONE);
            rowContentTable.addView(content_seq);
            
            
            Button content_detail = new Button(ctx);
            content_detail.setGravity(Gravity.CENTER);
            content_detail.setText(R.string.form_action_detail);
            rowContentTable.addView(content_detail, 5, 50);
            
            /*TextView content_detail = new TextView(ctx);
            content_detail.setText(R.string.form_action_detail);
            content_detail.setGravity(Gravity.CENTER);
            content_detail.setTextColor(getResources().getColor(android.R.color.black));
            content_detail.setPadding(0, 3, 0, 3);
            content_detail.setTextSize(12);
            content_detail.setWidth(170);
            content_detail.setBackgroundResource(R.drawable.button_nav);
            
            rowContentTable.addView(content_detail, rowParamsDetail);*/
            content_detail.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					TextView content_id = (TextView) rowContentTable.getChildAt(0);
					TextView content_seq = (TextView) rowContentTable.getChildAt(1);
					TextView content_jenis = (TextView) rowContentTable.getChildAt(4);
					TextView content_luas = (TextView) rowContentTable.getChildAt(5);
					TextView content_pemotong = (TextView) rowContentTable.getChildAt(6);
					TextView content_nilai = (TextView) rowContentTable.getChildAt(7);
					TextView content_nilai_pasar = (TextView) rowContentTable.getChildAt(8);
					TextView content_likuidasi = (TextView) rowContentTable.getChildAt(9);
					TextView content_nilai_likuidasi = (TextView) rowContentTable.getChildAt(10);
					
					fragment_Valuation_Bangunan_Dialog.setData_kendaraan_txt_seq(content_seq.getText().toString());
					fragment_Valuation_Bangunan_Dialog.setData_kendaraan_txt_id(content_id.getText().toString());
					fragment_Valuation_Bangunan_Dialog.setData_kendaraan_txt_jenis_bangunan(content_jenis.getText().toString());
					fragment_Valuation_Bangunan_Dialog.setData_kendaraan_txt_nilai(content_luas.getText().toString());
					fragment_Valuation_Bangunan_Dialog.setData_kendaraan_txt_luas_pemotongan(content_pemotong.getText().toString());
					fragment_Valuation_Bangunan_Dialog.setData_kendaraan_txt_nilai_pasar(content_nilai.getText().toString());
					fragment_Valuation_Bangunan_Dialog.setData_kendaraan_txt_likuidasi(content_nilai_pasar.getText().toString());
					fragment_Valuation_Bangunan_Dialog.setData_kendaraan_txt_nilai_likuidasi(content_likuidasi.getText().toString());
					fragment_Valuation_Bangunan_Dialog.setData_kendaraan_txt_luas_sesuai_fisik(content_nilai_likuidasi.getText().toString());
                	
                	fragment_Valuation_Bangunan_Dialog.show();	
				}
			});
            
            
            Button content_delete = new Button(ctx);
            content_delete.setGravity(Gravity.CENTER);
            content_delete.setText(R.string.form_action_delete);
            rowContentTable.addView(content_delete, 5, 50);
            
           
           content_delete.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					TextView content_id = (TextView) rowContentTable.getChildAt(0);
					showConfirmationDelete(true,content_id.getText().toString());
					
				}
			});
            
            
            
            TextView content_jenis = new TextView(ctx);
            content_jenis.setGravity(Gravity.LEFT);
            content_jenis.setTextColor(getResources().getColor(android.R.color.black));
            content_jenis.setPadding(0, 3, 0, 3);
            content_jenis.setTextSize(12);
            content_jenis.setWidth(170);
            content_jenis.setText(contentdata.getBUILDING_TYPE());
            rowContentTable.addView(content_jenis, rowParamsDetail);
           

            TextView content_luas = new TextView(ctx);
            content_luas.setGravity(Gravity.LEFT);
            content_luas.setTextColor(getResources().getColor(android.R.color.black));
            content_luas.setPadding(0, 3, 0, 3);
            content_luas.setTextSize(12);
            content_luas.setWidth(170);
            content_luas.setText(contentdata.getBUILD_AREA_FISIK());
            rowContentTable.addView(content_luas, rowParamsDetail);
            
            TextView content_pemotong = new TextView(ctx);
            content_pemotong.setTextColor(getResources().getColor(android.R.color.black));
            content_pemotong.setPadding(0, 3, 0, 3);
            content_pemotong.setTextSize(12);
            content_pemotong.setWidth(170);
            content_pemotong.setText(contentdata.getBUILD_LAND_AREA_AFTER_POTONG());
            rowContentTable.addView(content_pemotong, rowParamsDetail);
           
            TextView content_nilai = new TextView(ctx);
            content_nilai.setGravity(Gravity.LEFT);
            content_nilai.setTextColor(getResources().getColor(android.R.color.black));
            content_nilai.setPadding(0, 3, 0, 3);
            content_nilai.setTextSize(12);
            content_nilai.setWidth(200);
            content_nilai.setText(contentdata.getBUILD_PERMETER_VALUE());
            rowContentTable.addView(content_nilai, rowParamsDetail);

            
            TextView content_nilai_pasar = new TextView(ctx);
            content_nilai_pasar.setGravity(Gravity.LEFT);
            content_nilai_pasar.setTextColor(getResources().getColor(android.R.color.black));
            content_nilai_pasar.setPadding(0, 3, 0, 3);
            content_nilai_pasar.setTextSize(12);
            content_nilai_pasar.setWidth(200);
            content_nilai_pasar.setText(contentdata.getBUILD_MARKET_VALUE_FISIK());
            rowContentTable.addView(content_nilai_pasar, rowParamsDetail);

            TextView content_liq = new TextView(ctx);
            content_liq.setGravity(Gravity.LEFT);
            content_liq.setTextColor(getResources().getColor(android.R.color.black));
            content_liq.setPadding(0, 3, 0, 3);
            content_liq.setTextSize(12);
            content_liq.setWidth(200);
            content_liq.setText(contentdata.getBUILD_LIQ_PCT_FISIK());
            rowContentTable.addView(content_liq, rowParamsDetail);
            
            TextView content_nilai_liq = new TextView(ctx);
            content_nilai_liq.setGravity(Gravity.LEFT);
            content_nilai_liq.setTextColor(getResources().getColor(android.R.color.black));
            content_nilai_liq.setPadding(0, 3, 0, 3);
            content_nilai_liq.setTextSize(12);
            content_nilai_liq.setWidth(200);
            content_nilai_liq.setText(contentdata.getBUILD_LIQ_VALUE_FISIK());
            rowContentTable.addView(content_nilai_liq, rowParamsDetail);
            
            inbox_tableLayout.addView(rowContentTable);
        }
    }

  
    private void initControl(){
    	///Insert LOV
    	//jenis usaha group 05
    	lovDataProvider=new LOVDataProvider();
    	header_deb							=(TextView) view.findViewById(R.id.info_Nama_deb);
    	header_alamat						=(TextView) view.findViewById(R.id.info_Nama_Alamat);
        val_rtb_header_tanah= (LinearLayout) view.findViewById(R.id.val_rtb_header_tanah);
        val_rtb_header_tanahbangunan= (LinearLayout) view.findViewById(R.id.val_rtb_header_tanahbangunan);
        val_rtb_header_unit= (LinearLayout) view.findViewById(R.id.val_rtb_header_unit);
        val_header_bangunan_asuransi= (LinearLayout) view.findViewById(R.id.val_header_bangunan_asuransi);
        val_header_bangunan_asuransi1= (LinearLayout) view.findViewById(R.id.val_header_bangunan_asuransi1);
        
        val_rtb_txt_nilai_pemotongan= (EditText) view.findViewById(R.id.val_rtb_txt_nilai_pemotongan);
        val_rtb_header_dok_nilai1= (TextView) view.findViewById(R.id.val_rtb_header_dok_nilai1);
        val_rtb_linear_penilaian= (LinearLayout) view.findViewById(R.id.val_rtb_linear_penilaian);
    	val_rtb_txt_no_laporan_1 = (EditText) view.findViewById(R.id.val_rtb_txt_an_sertifikat);
    	val_rtb_txt_divisi = (EditText) view.findViewById(R.id.val_rtb_txt_tgl_expire);
    	val_rtb_txt_segment = (EditText) view.findViewById(R.id.val_rtb_txt_segment);
    	val_rtb_txt_nama_contact = (EditText) view.findViewById(R.id.val_rtb_txt_nama_contact);
    	val_rtb_txt_no_hp = (EditText) view.findViewById(R.id.val_rtb_txt_no_hp);
    	val_rtb_txt_notelp = (EditText) view.findViewById(R.id.val_rtb_txt_notelp);
    	val_rtb_txt_luas = (EditText) view.findViewById(R.id.val_rtb_txt_luas);
    	val_rtb_txt_nilai = (EditText) view.findViewById(R.id.val_rtb_txt_nilai);
    	val_rtb_txt_nilai_pasar = (EditText) view.findViewById(R.id.val_rtb_txt_nilai_pasar);
    	val_rtb_txt_likuidasi_tanah = (EditText) view.findViewById(R.id.val_rtb_txt_likuidasi_tnh);
    	val_rtb_txt_Likuidasi2 = (EditText) view.findViewById(R.id.val_rtb_txt_Likuidasi2);
    	val_rtb_txt_total_fisik_bangunan = (EditText) view.findViewById(R.id.val_rtb_txt_total_fisik_bangunan);
    	val_rtb_txt_total_likuidasi_fisik_bangunan = (EditText) view.findViewById(R.id.val_rtb_txt_total_likuidasi_fisik_bangunan);
    	val_rtb_txt_total_fisik = (EditText) view.findViewById(R.id.val_rtb_txt_total_fisik);
    	val_rtb_txt_total_fisik_likuidasi = (EditText) view.findViewById(R.id.val_rtb_txt_total_fisik_likuidasi);
    	val_rtb_txt_bangunan_asuransi = (EditText) view.findViewById(R.id.val_rtb_txt_bangunan_asuransi);
    	val_rtb_txt_jumlah_unit = (EditText) view.findViewById(R.id.val_rtb_txt_jumlah_unit);
    	val_rtb_txt_luas_tanah = (EditText) view.findViewById(R.id.val_rtb_txt_luas_tanah);
    	val_rtb_txt_luas_bangunan = (EditText) view.findViewById(R.id.val_rtb_txt_luas_bangunan);
    	val_rtb_txt_unit_nilai_pasar = (EditText) view.findViewById(R.id.val_rtb_txt_unit_nilai_pasar);
    	
    	val_rtb_txt_unit_nilai_likuidasi = (EditText) view.findViewById(R.id.val_rtb_txt_unit_nilai_likuidasi);
    	val_rtb_txt_tgl_laporan_1= (EditText) view.findViewById(R.id.val_rtb_txt_tgl_laporan_1);
    	val_rtb_txt_tgl_survey_1= (EditText) view.findViewById(R.id.val_rtb_txt_tgl_survey_1);
    	val_rtb_txt_likuidasi3 = (EditText) view.findViewById(R.id.val_rtb_txt_likuidasi3);
    	val_rtb_view_img_tgl_laporan_1= (ImageView) view.findViewById(R.id.val_rtb_view_img_tgl_laporan_1);
    	val_rtb_view_img_survey_1= (ImageView) view.findViewById(R.id.val_rtb_view_img_survey_1);
    	//val_rtb_rdogroup_cek_tatakota= (RadioGroup) view.findViewById(R.id.val_rtb_rdogroup_cek_tatakota);
    	val_rtb_rdogroup_cek_penilaian= (RadioGroup) view.findViewById(R.id.val_rtb_rdogroup_cek_penilaian);
    	val_rtb_rdo_cek_tatakota_ya= (RadioButton) view.findViewById(R.id.val_rtb_rdo_cek_tatakota_ya);
    	val_rtb_rdo_cek_tatakota_tidak= (RadioButton) view.findViewById(R.id.val_rtb_rdo_cek_tatakota_tidak);
        val_rtb_rdo_cek_penilaian_tanah= (RadioButton) view.findViewById(R.id.val_rtb_rdo_cek_penilaian_tanah);
        val_rtb_rdo_cek_penilaian_bangunan= (RadioButton) view.findViewById(R.id.val_rtb_rdo_cek_penilaian_bangunan);
        val_rtb_rdo_penilaian_unit= (RadioButton) view.findViewById(R.id.val_rtb_rdo_penilaian_unit);
        
        
        val_rtb_spn_nama_penilai=(ExSpinner) view.findViewById(R.id.val_rtb_spn_nama_penilai);
        lovDataProvider = new LOVDataProvider();
        lovpenilai = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_PENILAI));
        val_rtb_spn_nama_penilai.setListOfValue(lovpenilai, false);
        btn_new = (Button) view.findViewById(R.id.btn_new);
        btn_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	fragment_Valuation_Bangunan_Dialog.setData_kendaraan_txt_seq("");
				fragment_Valuation_Bangunan_Dialog.setData_kendaraan_txt_id("");
				fragment_Valuation_Bangunan_Dialog.setData_kendaraan_txt_luas_pemotongan("");
				fragment_Valuation_Bangunan_Dialog.setData_kendaraan_txt_jenis_bangunan("");
				fragment_Valuation_Bangunan_Dialog.setData_kendaraan_txt_nilai("");
				fragment_Valuation_Bangunan_Dialog.setData_kendaraan_txt_nilai_pasar("");
				fragment_Valuation_Bangunan_Dialog.setData_kendaraan_txt_likuidasi("");
				fragment_Valuation_Bangunan_Dialog.setData_kendaraan_txt_nilai_likuidasi("");
				fragment_Valuation_Bangunan_Dialog.setData_kendaraan_txt_luas_sesuai_fisik("");
            	
            	fragment_Valuation_Bangunan_Dialog.show();	
           }
        }); 
        Btnsave = (Button) view.findViewById(R.id.btn_savetanah);
    	
        val_rtb_rdogroup_cek_penilaian.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                RadioButton rb=(RadioButton) view.findViewById(checkedId);
               //Toast.makeText(ctx, rb.getText(), Toast.LENGTH_LONG).show();
               if(rb.getText().equals("Tanah")){
            	   val_rtb_header_dok_nilai1.setText("Nilai Tanah Property");
            	   val_rtb_header_tanah.setVisibility(View.VISIBLE);
            	   val_rtb_header_tanahbangunan.setVisibility(View.GONE);
            	   val_rtb_header_unit.setVisibility(View.GONE);
            	   val_header_bangunan_asuransi.setVisibility(View.GONE);
            	   val_header_bangunan_asuransi1.setVisibility(View.GONE);
            	   setMaxLen("Tanah");
               }
               else if(rb.getText().equals("Tanah dan Bangunan")){
            	   val_rtb_header_dok_nilai1.setText("Nilai Tanah dan Bangunan Property");
            	   val_rtb_header_tanah.setVisibility(View.VISIBLE);
            	   val_rtb_header_tanahbangunan.setVisibility(View.VISIBLE);
            	   val_rtb_header_unit.setVisibility(View.GONE);
            	   val_header_bangunan_asuransi.setVisibility(View.VISIBLE);
            	   val_header_bangunan_asuransi1.setVisibility(View.VISIBLE);
            	   setMaxLen("Tanah dan Bangunan");
               }
               else if(rb.getText().equals("Unit")){
            	   val_rtb_header_dok_nilai1.setText("Nilai Unit Property");
            	   val_rtb_header_tanah.setVisibility(View.GONE);
            	   val_rtb_header_tanahbangunan.setVisibility(View.GONE);
            	   val_rtb_header_unit.setVisibility(View.VISIBLE);
            	   val_header_bangunan_asuransi.setVisibility(View.VISIBLE);
            	   val_header_bangunan_asuransi1.setVisibility(View.VISIBLE);
            	   setMaxLen("Unit");
               }
               
               
            }
        });
        fragment_Valuation_Bangunan_Dialog.getBtn_save().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	if(fragment_Valuation_Bangunan_Dialog.CekMandatory().equals(false)){
        			showAlert(R.string.msg_notification_mandatory);
        		}else{
	            	int intCount=0;
	            	if(!fragment_Valuation_Bangunan_Dialog.getData_kendaraan_txt_seq().equals(""))
	            	{
	            		intCount=Integer.parseInt(fragment_Valuation_Bangunan_Dialog.getData_kendaraan_txt_seq());
	            	}
	            	else{
	            		intCount=appr_Val_BangunanDataProvider.getAllAppr_detail_bangunan_by_MaxSeq(col_id);
	            	}
	            	appr_valBangunan.setCOL_ID(col_id);
	            	appr_valBangunan.setBUILD_SEQ(""+ intCount);
	            	appr_valBangunan.setID(col_id + intCount);
	            	appr_valBangunan.setBUILD_LAND_AREA_AFTER_POTONG(fragment_Valuation_Bangunan_Dialog.getData_kendaraan_txt_luas_pemotongan());
	            	appr_valBangunan.setBUILDING_TYPE(fragment_Valuation_Bangunan_Dialog.getData_kendaraan_txt_jenis_bangunan());
	            	appr_valBangunan.setBUILD_AREA_FISIK(fragment_Valuation_Bangunan_Dialog.getData_kendaraan_txt_luas_sesuai_fisik() );
	            	appr_valBangunan.setBUILD_PERMETER_VALUE(fragment_Valuation_Bangunan_Dialog.getData_kendaraan_txt_nilai());
	            	appr_valBangunan.setBUILD_MARKET_VALUE_FISIK(fragment_Valuation_Bangunan_Dialog.getData_kendaraan_txt_nilai_pasar());
	            	appr_valBangunan.setBUILD_LIQ_PCT_FISIK(fragment_Valuation_Bangunan_Dialog.getData_kendaraan_txt_likuidasi());
	            	appr_valBangunan.setBUILD_LIQ_VALUE_FISIK(fragment_Valuation_Bangunan_Dialog.getData_kendaraan_txt_nilai_likuidasi());
	            	
	            	appr_Val_BangunanDataProvider.updateData(appr_valBangunan);   
	            	viewdataBangunan();
	            	fragment_Valuation_Bangunan_Dialog.dismiss();
	            	showAlert(R.string.msg_notification_update_success);
            }
           }
        }); 
    	Btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	try{
            		if(cekTanggalLaporan().equals(true)){
            			saveData();
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
    	
    	val_rtb_view_img_tgl_laporan_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] arrTglLahir = null;

                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = (c.get(Calendar.MONTH));
                int day = c.get(Calendar.DAY_OF_MONTH);
                try{
	                if (val_rtb_txt_tgl_laporan_1.getText().toString().equalsIgnoreCase("")) {
	                    arrTglLahir = val_rtb_txt_tgl_laporan_1.getText().toString().split("-");
	                    year = Integer.parseInt(arrTglLahir[2]);
	                    month = Integer.parseInt(arrTglLahir[1]) - 1;
	                    day = Integer.parseInt(arrTglLahir[0]);
	                }
                }
                catch(Exception e){
                	
                }
                DatePickerManager datePickerDialog = new DatePickerManager(ctx, RtbTglLaporDateSetListener, year, month, day);
                datePickerDialog.show();

            }
        });
    	
    	val_rtb_view_img_survey_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] arrTglLahir = null;

                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = (c.get(Calendar.MONTH));
                int day = c.get(Calendar.DAY_OF_MONTH);
                try{
                if (val_rtb_txt_tgl_survey_1.getText().toString().equalsIgnoreCase("")) {
                    arrTglLahir = val_rtb_txt_tgl_survey_1.getText().toString().split("-");
                    year = Integer.parseInt(arrTglLahir[2]);
                    month = Integer.parseInt(arrTglLahir[1]) - 1;
                    day = Integer.parseInt(arrTglLahir[0]);
                }
                }
                catch(Exception e){
                	
                }
                DatePickerManager datePickerDialog = new DatePickerManager(ctx, RtbSurveyDateSetListener, year, month, day);
                datePickerDialog.show();

            }
        });
    	
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
    	Date LaporanDate = DateFormatter.formatDate(val_rtb_txt_tgl_laporan_1.getText().toString());
        Date SurveyDate=  DateFormatter.formatDate(val_rtb_txt_tgl_survey_1.getText().toString());
    	
        if(LaporanDate.before(SurveyDate))
        	retval=false;
        return retval;
    }
    private void setMaxLen(String value){
    	val_rtb_txt_tgl_laporan_1.setBackgroundResource(R.drawable.fillcolor);
    	val_rtb_txt_tgl_survey_1.setBackgroundResource(R.drawable.fillcolor);
    	val_rtb_txt_no_hp.setBackgroundResource(R.drawable.fillcolor);
    	val_rtb_txt_notelp.setBackgroundResource(R.drawable.fillcolor);
    	val_rtb_txt_bangunan_asuransi.setBackgroundResource(R.drawable.fillcolor);
    	val_rtb_txt_luas_tanah.setBackgroundResource(R.drawable.fillcolor);
    	val_rtb_txt_luas_bangunan.setBackgroundResource(R.drawable.fillcolor);
    	val_rtb_txt_nama_contact.setBackgroundResource(R.drawable.fillcolor);
    	val_rtb_txt_tgl_laporan_1.setBackgroundResource(R.drawable.fillcolor);
    	val_rtb_txt_tgl_survey_1.setBackgroundResource(R.drawable.fillcolor);
    	val_rtb_txt_bangunan_asuransi.setBackgroundResource(R.drawable.fillcolor);
    
    	if(value.equals("Tanah")){
    		
    		val_rtb_txt_luas.setBackgroundResource(R.drawable.fillcolor);
    		val_rtb_txt_nilai.setBackgroundResource(R.drawable.fillcolor);
    		val_rtb_txt_nilai_pasar.setBackgroundResource(R.drawable.fillcolor);
    		val_rtb_txt_likuidasi_tanah.setBackgroundResource(R.drawable.fillcolor);
    		val_rtb_txt_Likuidasi2.setBackgroundResource(R.drawable.fillcolor);

    		
    		val_rtb_txt_total_fisik_bangunan.setBackgroundResource(R.drawable.fillcolorwhite);
    		val_rtb_txt_total_likuidasi_fisik_bangunan.setBackgroundResource(R.drawable.fillcolorwhite);
    		val_rtb_txt_total_fisik_likuidasi.setBackgroundResource(R.drawable.fillcolorwhite);

    		val_rtb_txt_unit_nilai_pasar.setBackgroundResource(R.drawable.fillcolorwhite);
    		val_rtb_txt_likuidasi3.setBackgroundResource(R.drawable.fillcolorwhite);
    		val_rtb_txt_unit_nilai_likuidasi.setBackgroundResource(R.drawable.fillcolorwhite);    
    		
    		val_rtb_txt_bangunan_asuransi.setBackgroundResource(R.drawable.fillcolorwhite);
    		val_rtb_txt_luas_tanah.setBackgroundResource(R.drawable.fillcolorwhite);
        	val_rtb_txt_luas_bangunan.setBackgroundResource(R.drawable.fillcolorwhite);
    	}
    	else if(value.equals("Tanah dan Bangunan")){
    		val_rtb_txt_luas.setBackgroundResource(R.drawable.fillcolor);
    		val_rtb_txt_nilai.setBackgroundResource(R.drawable.fillcolor);
    		val_rtb_txt_nilai_pasar.setBackgroundResource(R.drawable.fillcolor);
    		val_rtb_txt_likuidasi_tanah.setBackgroundResource(R.drawable.fillcolor);
    		val_rtb_txt_Likuidasi2.setBackgroundResource(R.drawable.fillcolor);
    		val_rtb_txt_total_fisik_bangunan.setBackgroundResource(R.drawable.fillcolor);
    		val_rtb_txt_total_likuidasi_fisik_bangunan.setBackgroundResource(R.drawable.fillcolor);
    		val_rtb_txt_total_fisik_likuidasi.setBackgroundResource(R.drawable.fillcolor);
    		
    		val_rtb_txt_unit_nilai_pasar.setBackgroundResource(R.drawable.fillcolorwhite);
    		val_rtb_txt_likuidasi3.setBackgroundResource(R.drawable.fillcolorwhite);
    		val_rtb_txt_unit_nilai_likuidasi.setBackgroundResource(R.drawable.fillcolorwhite);
    		
      		val_rtb_txt_bangunan_asuransi.setBackgroundResource(R.drawable.fillcolor);
    	
    		
    	}
    	else if(value.equals("Unit")){
    		val_rtb_txt_luas.setBackgroundResource(R.drawable.fillcolorwhite);
    		val_rtb_txt_nilai.setBackgroundResource(R.drawable.fillcolorwhite);
    		val_rtb_txt_nilai_pasar.setBackgroundResource(R.drawable.fillcolorwhite);
    		val_rtb_txt_likuidasi_tanah.setBackgroundResource(R.drawable.fillcolorwhite);
    		val_rtb_txt_Likuidasi2.setBackgroundResource(R.drawable.fillcolorwhite);
    		val_rtb_txt_total_fisik_bangunan.setBackgroundResource(R.drawable.fillcolorwhite);
    		val_rtb_txt_total_likuidasi_fisik_bangunan.setBackgroundResource(R.drawable.fillcolorwhite);
    		val_rtb_txt_total_fisik_likuidasi.setBackgroundResource(R.drawable.fillcolorwhite);
    		
    		
    		val_rtb_txt_unit_nilai_pasar.setBackgroundResource(R.drawable.fillcolor);
    		val_rtb_txt_likuidasi3.setBackgroundResource(R.drawable.fillcolor);
    		val_rtb_txt_unit_nilai_likuidasi.setBackgroundResource(R.drawable.fillcolor);
    		val_rtb_txt_luas_tanah.setBackgroundResource(R.drawable.fillcolor);
        	val_rtb_txt_luas_bangunan.setBackgroundResource(R.drawable.fillcolor);
    	}

    	val_rtb_txt_luas.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                	hitung();
                
            }
        });
    	val_rtb_txt_nilai.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                    hitung();
            }
        });
    	val_rtb_txt_likuidasi_tanah.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                    hitung();
            }
        });
    	
    	val_rtb_txt_nilai_pemotongan.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                    hitung();
            }
        });
    	
    	val_rtb_txt_likuidasi_tanah.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                    hitung();
            }
        });
    	
    	val_rtb_txt_likuidasi_tanah.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                    hitung();
            }
        });
    	val_rtb_txt_unit_nilai_pasar.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                    hitung_unit();
            }
        });
    	val_rtb_txt_likuidasi3.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                    hitung_unit();
            }
        });
    	fragment_Valuation_Bangunan_Dialog.Edata_kendaraan_txt_luas_pemotongan().setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                	hitung_bangunan();
            }
        });
    	fragment_Valuation_Bangunan_Dialog.Edata_kendaraan_txt_nilai().setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                	hitung_bangunan();
            }
        });
    	
    	fragment_Valuation_Bangunan_Dialog.Edata_kendaraan_txt_likuidasi().setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                	hitung_bangunan();
            }
        });
    	
    	
    	/*val_rtb_txt_total_fisik_bangunan.setBackgroundResource(R.drawable.fillcolor);
    	val_rtb_txt_bangunan_asuransi.setBackgroundResource(R.drawable.fillcolor);

    	val_rtb_txt_luas.setBackgroundResource(R.drawable.fillcolor);
    	val_rtb_txt_nilai.setBackgroundResource(R.drawable.fillcolor);
    	val_rtb_txt_nilai_pasar.setBackgroundResource(R.drawable.fillcolor);
    	val_rtb_txt_likuidasi_tanah.setBackgroundResource(R.drawable.fillcolor);
    	val_rtb_txt_Likuidasi2.setBackgroundResource(R.drawable.fillcolor);

    	val_rtb_txt_luas_tanah.setBackgroundResource(R.drawable.fillcolor);
    	val_rtb_txt_luas_bangunan.setBackgroundResource(R.drawable.fillcolor);
    	val_rtb_txt_unit_nilai_pasar.setBackgroundResource(R.drawable.fillcolor);
    	val_rtb_txt_likuidasi3.setBackgroundResource(R.drawable.fillcolor);
    	val_rtb_txt_unit_nilai_likuidasi.setBackgroundResource(R.drawable.fillcolor);*/

		
	}
    private DatePickerDialog.OnDateSetListener RtbTglLaporDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int monthOfYear, int dayOfMonth) {
        	val_rtb_txt_tgl_laporan_1.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
        }
    };
    private DatePickerDialog.OnDateSetListener RtbSurveyDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int monthOfYear, int dayOfMonth) {
        	val_rtb_txt_tgl_survey_1.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
        }
    };

    private void loadData(){
    

    	appr_rtb_valuation_int=appr_Rtb_ValuationDataProvider.getAllAppr_Rtb_Valuation_Int(col_id);
    	if(appr_rtb_valuation_int.COL_ID!=null){
    		
    		datatype_Appr_Collateral=appr_Collateral.getAllAppr_Collateral(col_id);
          	if(datatype_Appr_Collateral.COL_ID!=null && !datatype_Appr_Collateral.COL_ID.toString().equals("")){
          		header_deb.setText(datatype_Appr_Collateral.getAP_REGNO() + " # " + datatype_Appr_Collateral.getCU_NAME() );
          		val_rtb_txt_divisi.setText((datatype_Appr_Collateral.getBRANCHNAME()));
    	    	val_rtb_txt_segment.setText((datatype_Appr_Collateral.getSEG_DESC()));
          	}
          	appr_Rtb_data_int=appr_Rtb_DataProvider.getAllAppr_Rtb_Data_Int(col_id);
          	if(appr_Rtb_data_int.COL_ID!=null && !appr_Rtb_data_int.COL_ID.equals("")){
          		header_alamat.setText(appr_Rtb_data_int.getCOL_ADDR1() + " , " +  appr_Rtb_data_int.getCOL_KELURAHAN() + " , " +  appr_Rtb_data_int.getCOL_KECAMATAN() + " , " +  appr_Rtb_data_int.getCOL_CITY() + " , " +  appr_Rtb_data_int.getCOL_ZIPCODE());
          	}
  	  	  if(datatype_Appr_Collateral.getTATAKOTA().equals("1")){
	          	val_rtb_rdo_cek_tatakota_ya.setChecked(true);
	          }
	          else{
	        	  val_rtb_rdo_cek_tatakota_tidak.setChecked(true);
	        	
	          }
	    	val_rtb_txt_no_laporan_1.setText((appr_rtb_valuation_int.getREPORT_NO()));
	    	val_rtb_txt_nama_contact.setText((appr_rtb_valuation_int.getAPPR_CPNAME()));
	    	val_rtb_txt_no_hp.setText((appr_rtb_valuation_int.getAPPR_CPHP()));
	    	val_rtb_txt_notelp.setText((appr_rtb_valuation_int.getAPPR_CPPHONE()));
	    	val_rtb_txt_luas.setText((appr_rtb_valuation_int.getLAND_AREA()));
	    	val_rtb_txt_nilai.setText((appr_rtb_valuation_int.getLAND_PERMETER_VALUE()));
	    	val_rtb_txt_nilai_pasar.setText((appr_rtb_valuation_int.getLAND_MARKET_VALUE()));
	    	val_rtb_txt_likuidasi_tanah.setText((appr_rtb_valuation_int.getLAND_LIQ_PCT().toString()));
	    	val_rtb_txt_Likuidasi2.setText((appr_rtb_valuation_int.getLAND_LIQ_VALUE().toString()));
	    	val_rtb_txt_total_fisik_bangunan.setText((appr_rtb_valuation_int.getBUILD_MARKET_VALUE_FISIK_TOTAL().toString()));
	    	val_rtb_txt_total_likuidasi_fisik_bangunan.setText((appr_rtb_valuation_int.getBUILD_LIQ_VALUE_FISIK_TOTAL().toString()));
	    	val_rtb_txt_total_fisik.setText((appr_rtb_valuation_int.getTOTAL_MARKET_VALUE_FISIK().toString()));
	    	val_rtb_txt_total_fisik_likuidasi.setText((appr_rtb_valuation_int.getTOTAL_LIQ_VALUE_FISIK().toString()));
			val_rtb_txt_bangunan_asuransi.setText((appr_rtb_valuation_int.getBUILD_ASURANSI_MARKET().toString()));
	    	val_rtb_txt_jumlah_unit.setText((appr_rtb_valuation_int.getUNIT_JUMLAH().toString()));
	    	val_rtb_txt_luas_tanah.setText((appr_rtb_valuation_int.getUNIT_AREA().toString()));
	    	val_rtb_txt_luas_bangunan.setText((appr_rtb_valuation_int.getUNIT_BUILD_AREA().toString()));
	    	val_rtb_txt_unit_nilai_pasar.setText((appr_rtb_valuation_int.getUNIT_MARKET_VALUE().toString()));
	    	val_rtb_txt_likuidasi3.setText((appr_rtb_valuation_int.getUNIT_LIQ_PCT()));
	    	val_rtb_txt_unit_nilai_likuidasi.setText((appr_rtb_valuation_int.getUNIT_LIQ_VALUE().toString()));
	    	val_rtb_txt_nilai_pemotongan.setText((appr_rtb_valuation_int.getLAND_AREA_AFTER_POTONG().toString()));
	    	 
	    	 val_rtb_txt_nilai_pemotongan.setText(appr_rtb_valuation_int.getLAND_AREA_AFTER_POTONG().toString());
	    	val_rtb_spn_nama_penilai.setSelectedListOfValue((appr_rtb_valuation_int.getCOL_APPRAISER_CODE().toString()));
	    	if(appr_rtb_valuation_int.getAPPR_JNSPENILAIAN().equals("T")){
	        	val_rtb_rdo_cek_penilaian_tanah.setChecked(true);
	        }
	        else if(appr_rtb_valuation_int.getAPPR_JNSPENILAIAN().equals("TB")){
	        	val_rtb_rdo_cek_penilaian_bangunan.setChecked(true);
	        }
	        else if(appr_rtb_valuation_int.getAPPR_JNSPENILAIAN().equals("U")){	
	        	val_rtb_rdo_penilaian_unit.setChecked(true);
	        }
	    	
	    	try{
	    	 if (appr_rtb_valuation_int.getREPORT_DATE() != null) {
	    		 val_rtb_txt_tgl_laporan_1.setText(DateFormatter.formatString(appr_rtb_valuation_int.getREPORT_DATE()));
	         }
	    	 if (appr_rtb_valuation_int.getREPORT_INSPECT_DATE() != null) {
	    		 val_rtb_txt_tgl_survey_1.setText(DateFormatter.formatString(appr_rtb_valuation_int.getREPORT_INSPECT_DATE()));
	         }
	    	}
	    	catch(Exception ex)
	    	{
	    		
	    	}
    	}
   
    }
    private Boolean CekMandatory(){
    	  boolean retval=true;
    	  appr_rtb_valuation_int=appr_Rtb_ValuationDataProvider.getAllAppr_Rtb_Valuation_Int(col_id);
      	if(appr_rtb_valuation_int.COL_ID!=null){
      		if(appr_rtb_valuation_int.APPR_JNSPENILAIAN==null || appr_rtb_valuation_int.APPR_JNSPENILAIAN.equals(""))
      			retval=false;
      		if(appr_rtb_valuation_int.REPORT_DATE==null || appr_rtb_valuation_int.REPORT_DATE.equals(""))
      			retval=false;
      		if(appr_rtb_valuation_int.REPORT_INSPECT_DATE==null || appr_rtb_valuation_int.REPORT_DATE.equals(""))
      			retval=false;
      		if(appr_rtb_valuation_int.APPR_CPNAME==null || appr_rtb_valuation_int.APPR_CPNAME.equals(""))
      			retval=false;
      		if(appr_rtb_valuation_int.APPR_CPHP==null || appr_rtb_valuation_int.APPR_CPHP.equals(""))
      			retval=false;
      		
      		if(appr_rtb_valuation_int.APPR_CPPHONE==null || appr_rtb_valuation_int.APPR_CPPHONE.equals(""))
      			retval=false;
      		if(appr_rtb_valuation_int.COL_APPRAISER_CODE==null || appr_rtb_valuation_int.COL_APPRAISER_CODE.equals(""))
      			retval=false;
      		if(appr_rtb_valuation_int.LAND_AREA==null || appr_rtb_valuation_int.LAND_AREA.equals(""))
      			retval=false;
      		if(appr_rtb_valuation_int.LAND_PERMETER_VALUE==null || appr_rtb_valuation_int.LAND_PERMETER_VALUE.equals(""))
      			retval=false;
      		if(appr_rtb_valuation_int.LAND_MARKET_VALUE==null || appr_rtb_valuation_int.LAND_MARKET_VALUE.equals(""))
      			retval=false;
      		if(appr_rtb_valuation_int.LAND_LIQ_PCT==null || appr_rtb_valuation_int.LAND_LIQ_PCT.equals(""))
      			retval=false;
      		if(appr_rtb_valuation_int.LAND_LIQ_VALUE==null || appr_rtb_valuation_int.LAND_LIQ_VALUE.equals(""))
      			retval=false;
      		if(appr_rtb_valuation_int.BUILD_MARKET_VALUE_FISIK_TOTAL==null || appr_rtb_valuation_int.BUILD_MARKET_VALUE_FISIK_TOTAL.equals(""))
      			retval=false;
      		if(appr_rtb_valuation_int.BUILD_LIQ_VALUE_FISIK_TOTAL==null || appr_rtb_valuation_int.BUILD_LIQ_VALUE_FISIK_TOTAL.equals(""))
      			retval=false;
      		if(appr_rtb_valuation_int.TOTAL_LIQ_VALUE_FISIK==null || appr_rtb_valuation_int.TOTAL_LIQ_VALUE_FISIK.equals(""))
      			retval=false;
      		if(appr_rtb_valuation_int.BUILD_ASURANSI_MARKET==null || appr_rtb_valuation_int.BUILD_ASURANSI_MARKET.equals(""))
      			retval=false;
      		if(appr_rtb_valuation_int.UNIT_MARKET_VALUE==null || appr_rtb_valuation_int.UNIT_MARKET_VALUE.equals(""))
      			retval=false;
      		if(appr_rtb_valuation_int.UNIT_LIQ_PCT==null || appr_rtb_valuation_int.UNIT_LIQ_PCT.equals(""))
      			retval=false;
      		if(appr_rtb_valuation_int.UNIT_LIQ_VALUE==null || appr_rtb_valuation_int.UNIT_LIQ_VALUE.equals(""))
      			retval=false;
      		if(appr_rtb_valuation_int.UNIT_AREA==null || appr_rtb_valuation_int.UNIT_AREA.equals(""))
      			retval=false;
      		if(appr_rtb_valuation_int.UNIT_BUILD_AREA==null || appr_rtb_valuation_int.UNIT_BUILD_AREA.equals(""))
      			retval=false;
      		
      		if(appr_rtb_valuation_int.APPR_JNSPENILAIAN.equals("T"))
      		{
      			if(appr_rtb_valuation_int.LAND_AREA==null || appr_rtb_valuation_int.LAND_AREA.equals(""))
      				retval=false;
      			if(appr_rtb_valuation_int.LAND_MARKET_VALUE==null || appr_rtb_valuation_int.LAND_MARKET_VALUE.equals(""))
      				retval=false;
      			if(appr_rtb_valuation_int.LAND_MARKET_VALUE==null || appr_rtb_valuation_int.LAND_MARKET_VALUE.equals(""))
      				retval=false;
      			if(appr_rtb_valuation_int.LAND_LIQ_PCT==null || appr_rtb_valuation_int.LAND_LIQ_PCT.equals(""))
      				retval=false;
      			if(appr_rtb_valuation_int.LAND_LIQ_VALUE==null || appr_rtb_valuation_int.LAND_LIQ_VALUE.equals(""))
      				retval=false;
      		}
      		if(appr_rtb_valuation_int.APPR_JNSPENILAIAN.equals("TB"))
      		{
      			if(appr_rtb_valuation_int.BUILD_ASURANSI_AREA==null || appr_rtb_valuation_int.BUILD_ASURANSI_AREA.equals(""))
      				retval=false;
      			if(appr_rtb_valuation_int.TOTAL_LIQ_VALUE_FISIK==null || appr_rtb_valuation_int.TOTAL_LIQ_VALUE_FISIK.equals(""))
      				retval=false;
      			if(appr_rtb_valuation_int.BUILD_LIQ_VALUE_FISIK_TOTAL==null || appr_rtb_valuation_int.BUILD_LIQ_VALUE_FISIK_TOTAL.equals(""))
      				retval=false;
      			if(appr_rtb_valuation_int.BUILD_MARKET_VALUE_FISIK_TOTAL==null || appr_rtb_valuation_int.BUILD_MARKET_VALUE_FISIK_TOTAL.equals(""))
      				retval=false;
      			if(appr_rtb_valuation_int.LAND_LIQ_VALUE==null || appr_rtb_valuation_int.LAND_LIQ_VALUE.equals(""))
      				retval=false;
      			if(appr_rtb_valuation_int.LAND_LIQ_PCT==null || appr_rtb_valuation_int.LAND_LIQ_PCT.equals(""))
      				retval=false;
      			if(appr_rtb_valuation_int.LAND_MARKET_VALUE==null || appr_rtb_valuation_int.LAND_MARKET_VALUE.equals(""))
      				retval=false;
      			if(appr_rtb_valuation_int.LAND_PERMETER_VALUE==null || appr_rtb_valuation_int.LAND_PERMETER_VALUE.equals(""))
      				retval=false;
      			if(appr_rtb_valuation_int.LAND_AREA==null || appr_rtb_valuation_int.LAND_AREA.equals(""))
      				retval=false;
      		}
      		if(appr_rtb_valuation_int.APPR_JNSPENILAIAN.equals("U"))
      		{
      			if(appr_rtb_valuation_int.UNIT_MARKET_VALUE==null || appr_rtb_valuation_int.UNIT_MARKET_VALUE.equals(""))
      				retval=false;
      			if(appr_rtb_valuation_int.UNIT_LIQ_PCT==null || appr_rtb_valuation_int.UNIT_LIQ_PCT.equals(""))
      				retval=false;
      			if(appr_rtb_valuation_int.UNIT_LIQ_VALUE==null || appr_rtb_valuation_int.UNIT_LIQ_VALUE.equals(""))
      				retval=false;
      			if(appr_rtb_valuation_int.UNIT_JUMLAH==null || appr_rtb_valuation_int.UNIT_JUMLAH.equals(""))
      				retval=false;
      			if(appr_rtb_valuation_int.UNIT_BUILD_AREA==null || appr_rtb_valuation_int.UNIT_BUILD_AREA.equals(""))
      				retval=false;
      		}
      	}
    	/* 
    	
    	 *  APPR_JNSPENILAIAN
    	  REPORT_DATE
    	  REPORT_INSPECT_DATE
    	  APPR_CPNAME	
    	  APPR_CPHP
    	  APPR_CPPHONE
    	  COL_APPRAISER_CODE
    	  LAND_AREA
    	  LAND_PERMETER_VALUE
    	  LAND_MARKET_VALUE
    	  getLAND_LIQ_PCT
    	  getLAND_LIQ_VALUE
    	  getBUILD_MARKET_VALUE_FISIK_TOTAL
    	  
    	  getBUILD_LIQ_VALUE_FISIK_TOTAL
    	  getTOTAL_LIQ_VALUE_FISIK
    	  getBUILD_ASURANSI_MARKET
    	  getUNIT_MARKET_VALUE
    	  getUNIT_LIQ_PCT
    	  getUNIT_LIQ_VALUE
    	  getUNIT_AREA
    	  getUNIT_BUILD_AREA
    	      	
    	        	  if(val_rtb_rdo_cek_penilaian_tanah.isChecked()){
    	        		setLAND_AREA	
    	  			setLAND_MARKET_VALUE	
    	  			setLAND_MARKET_VALUE
    	  			setLAND_LIQ_PCT
    	  			setLAND_LIQ_VALUE


    	      	}
    	      	else if(val_rtb_rdo_cek_penilaian_bangunan.isChecked()){
    	  			setBUILD_ASURANSI_AREA
    	  			setTOTAL_LIQ_VALUE_FISIK	
    	  			setBUILD_LIQ_VALUE_FISIK_TOTAL
    	  			setBUILD_MARKET_VALUE_FISIK_TOTAL
    	  			getLAND_LIQ_VALUE
    	  			getLAND_LIQ_PCT
    	  			getLAND_MARKET_VALUE
    	  			getLAND_PERMETER_VALUE
    	  			getLAND_AREA
    	      	}
    	      	else if(val_rtb_rdo_penilaian_unit.isChecked()){
    	  			getUNIT_MARKET_VALUE
    	  			getUNIT_LIQ_PCT
    	  			getUNIT_LIQ_VALUE
    	  			getUNIT_JUMLAH
    	  			getUNIT_BUILD_AREA
    	      	}*/
    	 
    	  /*
    	  if(!val_rtb_rdo_cek_penilaian_tanah.isChecked() && !val_rtb_rdo_cek_penilaian_bangunan.isChecked() && !val_rtb_rdo_penilaian_unit.isChecked()){
    		  retval=false;
    		  val_rtb_linear_penilaian.setBackgroundResource(R.drawable.fillcolor);
    	  }else{
    		  val_rtb_linear_penilaian.setBackgroundResource(R.drawable.fillcolorwhite);
    	  }
    	  if(val_rtb_txt_tgl_laporan_1.getText().length()==0){
    		  val_rtb_txt_tgl_laporan_1.setError("Field Tidak Boleh Kososng");
      		  retval=false;
      	  }
    	  if(val_rtb_txt_tgl_survey_1.getText().length()==0){
    		  val_rtb_txt_tgl_survey_1.setError("Field Tidak Boleh Kososng");
      		  retval=false;
      	  }
    	  if(val_rtb_txt_nama_contact.getText().length()==0){
    		  val_rtb_txt_nama_contact.setError("Field Tidak Boleh Kososng");
      		  retval=false;
      	  }		
    	  if(val_rtb_txt_no_hp.getText().length()==0){
    		  val_rtb_txt_no_hp.setError("Field Tidak Boleh Kososng");
      		  retval=false;
      	  }		
    	  if(val_rtb_txt_notelp.getText().length()==0){
    		  val_rtb_txt_notelp.setError("Field Tidak Boleh Kososng");
      		  retval=false;
      	  }		
    	  
  		 View selectedView = val_rtb_spn_nama_penilai.getSelectedView();
      	  if (selectedView != null && selectedView instanceof TextView) {
      	      TextView selectedTextView = (TextView) selectedView;
      	      if (val_rtb_spn_nama_penilai.getSelectedListOfValue().toString().length()==0) {
      	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
      	          selectedTextView.setError(errorString);
      	          retval=false;
      	      }
      	      else {
      	          selectedTextView.setError(null);
      	      }
      	  }
      	  
      	val_rtb_txt_luas.setError(null);
  		val_rtb_txt_nilai.setError(null);
  		val_rtb_txt_nilai_pasar.setError(null);
  		val_rtb_txt_likuidasi_tanah.setError(null);
  		val_rtb_txt_Likuidasi2.setError(null);
		val_rtb_txt_total_fisik_bangunan.setError(null);
		val_rtb_txt_total_likuidasi_fisik_bangunan.setError(null);
		val_rtb_txt_total_fisik_likuidasi.setError(null);
  		val_rtb_txt_bangunan_asuransi.setError(null);
		val_rtb_txt_unit_nilai_pasar.setError(null);
		val_rtb_txt_likuidasi3.setError(null);
		val_rtb_txt_unit_nilai_likuidasi.setError(null);
		val_rtb_txt_luas_tanah.setError(null);
    	val_rtb_txt_luas_bangunan.setError(null);
    	
      	  if(val_rtb_rdo_cek_penilaian_tanah.isChecked()){
      		if(val_rtb_txt_luas.getText().length()==0){
      			val_rtb_txt_luas.setError("Field Tidak Boleh Kososng");
        		  retval=false;
        	  }		
      		if(val_rtb_txt_nilai.getText().length()==0){
      			val_rtb_txt_nilai.setError("Field Tidak Boleh Kososng");
        		  retval=false;
        	  }		
      		if(val_rtb_txt_nilai_pasar.getText().length()==0){
      			val_rtb_txt_nilai_pasar.setError("Field Tidak Boleh Kososng");
        		  retval=false;
        	  }		
      		if(val_rtb_txt_likuidasi_tanah.getText().length()==0){
      			val_rtb_txt_likuidasi_tanah.setError("Field Tidak Boleh Kososng");
        		  retval=false;
        	  }		
      		if(val_rtb_txt_Likuidasi2.getText().length()==0){
      			val_rtb_txt_Likuidasi2.setError("Field Tidak Boleh Kososng");
        		  retval=false;
        	  }		


    	}
    	else if(val_rtb_rdo_cek_penilaian_bangunan.isChecked()){
      		if(val_rtb_txt_bangunan_asuransi.getText().length()==0){
      			val_rtb_txt_bangunan_asuransi.setError("Field Tidak Boleh Kososng");
        		  retval=false;
        	  }	
      		if(val_rtb_txt_total_fisik_likuidasi.getText().length()==0){
      			val_rtb_txt_total_fisik_likuidasi.setError("Field Tidak Boleh Kososng");
        		  retval=false;
        	  }	
      		if(val_rtb_txt_total_likuidasi_fisik_bangunan.getText().length()==0){
      			val_rtb_txt_total_likuidasi_fisik_bangunan.setError("Field Tidak Boleh Kososng");
        		  retval=false;
        	  }	
      		if(val_rtb_txt_total_fisik_bangunan.getText().length()==0){
      			val_rtb_txt_total_fisik_bangunan.setError("Field Tidak Boleh Kososng");
        		  retval=false;
        	  }	
      		if(val_rtb_txt_Likuidasi2.getText().length()==0){
      			val_rtb_txt_Likuidasi2.setError("Field Tidak Boleh Kososng");
        		  retval=false;
        	  }	
      		if(val_rtb_txt_likuidasi_tanah.getText().length()==0){
      			val_rtb_txt_likuidasi_tanah.setError("Field Tidak Boleh Kososng");
        		  retval=false;
        	  }	
      		if(val_rtb_txt_nilai_pasar.getText().length()==0){
      			val_rtb_txt_nilai_pasar.setError("Field Tidak Boleh Kososng");
        		  retval=false;
        	  }	
      		if(val_rtb_txt_nilai.getText().length()==0){
      			val_rtb_txt_nilai.setError("Field Tidak Boleh Kososng");
        		  retval=false;
        	  }	
      		if(val_rtb_txt_luas.getText().length()==0){
      			val_rtb_txt_luas.setError("Field Tidak Boleh Kososng");
        		  retval=false;
        	  }	
    		
    		
    		
    		
    	}
    	else if(val_rtb_rdo_penilaian_unit.isChecked()){

        	if(val_rtb_txt_unit_nilai_pasar.getText().length()==0){
        		val_rtb_txt_unit_nilai_pasar.setError("Field Tidak Boleh Kososng");
        		  retval=false;
        	  }	
        	if(val_rtb_txt_likuidasi3.getText().length()==0){
        		val_rtb_txt_likuidasi3.setError("Field Tidak Boleh Kososng");
        		  retval=false;
        	  }	
        	if(val_rtb_txt_unit_nilai_likuidasi.getText().length()==0){
        		val_rtb_txt_unit_nilai_likuidasi.setError("Field Tidak Boleh Kososng");
        		  retval=false;
        	  }	
        	if(val_rtb_txt_luas_tanah.getText().length()==0){
        		val_rtb_txt_luas_tanah.setError("Field Tidak Boleh Kososng");
        		  retval=false;
        	  }	
        	if(val_rtb_txt_luas_bangunan.getText().length()==0){
        		val_rtb_txt_luas_bangunan.setError("Field Tidak Boleh Kososng");
        		  retval=false;
        	  }	
    	}*/
      	  return retval;
    }
    private void saveData(){
    	// if(CekMandatory().equals(false)){
 		//	showAlert(R.string.msg_notification_mandatory);
 		//}else{
	    	appr_rtb_valuation_int.setCOL_ID(col_id);
	    	appr_rtb_valuation_int.setAP_REGNO(ap_regno);
	        appr_rtb_valuation_int.setREPORT_NO(val_rtb_txt_no_laporan_1.getText().toString());
	        appr_rtb_valuation_int.setREPORT_DATE(DateFormatter.formatDate((val_rtb_txt_tgl_laporan_1.getText().toString())));
	        appr_rtb_valuation_int.setLAND_AREA_AFTER_POTONG(val_rtb_txt_nilai_pemotongan.getText().toString());
	        
	        appr_rtb_valuation_int.setREPORT_INSPECT_DATE(DateFormatter.formatDate((val_rtb_txt_tgl_survey_1.getText().toString())));
	        //appr_rtb_valuation_int.setREPORT_BRANCH_CODE("11111");
	        //appr_rtb_valuation_int.setREPORT_SEG_CODE("11111");
	        if(val_rtb_rdo_cek_tatakota_ya.isChecked()){
	        	appr_rtb_valuation_int.setREPORT_APPR_TYPE(val_rtb_rdo_cek_tatakota_ya.getText().toString());
	        }
	        else{
	        	appr_rtb_valuation_int.setREPORT_APPR_TYPE(val_rtb_rdo_cek_tatakota_tidak.getText().toString());
	        }
	        
	        appr_rtb_valuation_int.setAPPR_CPNAME(val_rtb_txt_nama_contact.getText().toString());
	        appr_rtb_valuation_int.setAPPR_DATELAPORAN(DateFormatter.formatDate((val_rtb_txt_tgl_laporan_1.getText().toString())));
	        //appr_rtb_valuation_int.setKJPP("11111");
	        //appr_rtb_valuation_int.setAPPR_PENILAINAME("11111");
	        appr_rtb_valuation_int.setAPPR_CPHP(val_rtb_txt_no_hp.getText().toString());
	        appr_rtb_valuation_int.setAPPR_CPPHONE(val_rtb_txt_notelp.getText().toString());
	        //appr_rtb_valuation_int.setAPPR_DATESURVEY(DateFormatter.formatDate((val_rtb_txt_tgl_laporan_1.getText().toString())));
	        appr_rtb_valuation_int.setLAND_AREA(val_rtb_txt_luas.getText().toString());
	        
	        appr_rtb_valuation_int.setLAND_LIQ_PCT(val_rtb_txt_likuidasi_tanah.getText().toString());
	        appr_rtb_valuation_int.setLAND_LIQ_VALUE(val_rtb_txt_Likuidasi2.getText().toString());
	        appr_rtb_valuation_int.setLAND_MARKET_VALUE(val_rtb_txt_nilai_pasar.getText().toString());
	        appr_rtb_valuation_int.setLAND_PERMETER_VALUE(val_rtb_txt_nilai.getText().toString());
	        appr_rtb_valuation_int.setTOTAL_LIQ_VALUE_FISIK(val_rtb_txt_total_fisik_likuidasi.getText().toString());
	        //hitung appr_rtb_valuation_int.setTOTAL_LIQ_VALUE_IMB(val_rtb_txt_total_likuidasi_fisik_bangunan.getText().toString());
	        appr_rtb_valuation_int.setTOTAL_MARKET_VALUE_FISIK(val_rtb_txt_total_fisik.getText().toString());
	        //hitung appr_rtb_valuation_int.setTOTAL_MARKET_VALUE_IMB(val_rtb_txt_total_fisik_likuidasi.getText().toString());
	        
	        appr_rtb_valuation_int.setBUILD_ASURANSI_AREA(val_rtb_txt_bangunan_asuransi.getText().toString());
	        appr_rtb_valuation_int.setBUILD_ASURANSI_MARKET(val_rtb_txt_bangunan_asuransi.getText().toString());
	      
	        ///Unit
	        appr_rtb_valuation_int.setUNIT_JUMLAH(val_rtb_txt_jumlah_unit.getText().toString());
	        appr_rtb_valuation_int.setUNIT_AREA(val_rtb_txt_luas_tanah.getText().toString());
	        appr_rtb_valuation_int.setUNIT_BUILD_AREA(val_rtb_txt_luas_bangunan.getText().toString());
	        
	        //appr_rtb_valuation_int.setUNIT_PERMETER_VALUE(val_rtb_txt_luas_bangunan);
	        
	        appr_rtb_valuation_int.setUNIT_MARKET_VALUE(val_rtb_txt_unit_nilai_pasar.getText().toString());
	        appr_rtb_valuation_int.setUNIT_LIQ_PCT(val_rtb_txt_likuidasi3.getText().toString()); 
	        appr_rtb_valuation_int.setUNIT_LIQ_VALUE(val_rtb_txt_unit_nilai_likuidasi.getText().toString());
	        
	        ////Unit
	        
	        
	        appr_rtb_valuation_int.setBUILD_MARKET_VALUE_FISIK_TOTAL(val_rtb_txt_total_fisik_bangunan.getText().toString());
	        ///hitung appr_rtb_valuation_int.setBUILD_MARKET_VALUE_IMB_TOTAL("11111");
	        appr_rtb_valuation_int.setBUILD_LIQ_VALUE_FISIK_TOTAL(val_rtb_txt_total_likuidasi_fisik_bangunan.getText().toString());
	      ///hitung appr_rtb_valuation_int.setBUILD_LIQ_VALUE_IMB_TOTAL("11111");
	       
	        
	     
	        
	        if(val_rtb_rdo_cek_penilaian_tanah.isChecked()){
	        	appr_rtb_valuation_int.setAPPR_JNSPENILAIAN("T");
	        }
	        else if(val_rtb_rdo_cek_penilaian_bangunan.isChecked()){
	        	appr_rtb_valuation_int.setAPPR_JNSPENILAIAN("TB");
	        }
	        else if(val_rtb_rdo_penilaian_unit.isChecked()){
	        	appr_rtb_valuation_int.setAPPR_JNSPENILAIAN("U");	
	        }
	        
	        
	        
	        //appr_rtb_valuation_int.setAPPR_REKANAN("11111");
	        //dari spinel
	        appr_rtb_valuation_int.setCOL_APPRAISER_CODE(val_rtb_spn_nama_penilai.getSelectedListOfValue().toString());
	  
	        appr_Rtb_ValuationDataProvider.updateData(appr_rtb_valuation_int);
	        showAlert(R.string.msg_notification_update_success);   
 		//}
	    /* if(CekMandatory().equals(false)){
	 			showAlert(R.string.msg_notification_mandatory);
	 	}*/
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
    private void hitung_unit(){
    	try{
    	 if (val_rtb_rdo_penilaian_unit.isChecked()) {
             // App.fBUILD_ASURANSI_MARKET.setValue(App.fTOTAL_MARKET_VALUE_FISIK.getValue());
          }
          else if (!val_rtb_txt_unit_nilai_pasar.getText().toString().equals("")){
              if (!val_rtb_txt_likuidasi3.getText().toString().equals(""))
            	  val_rtb_txt_unit_nilai_likuidasi.setText("" + (Long.parseLong(val_rtb_txt_unit_nilai_pasar.getText().toString()) * Long.parseLong(val_rtb_txt_likuidasi3.getText().toString()))/ 100);
          }
    	}
    	 catch(Exception ex){} 
    }
    private void hitung_bangunan(){
    	
    	double marketimb, marketfisik, liqfisik, liqimb, landvalue, landliq;
    	try{
	    	if (!fragment_Valuation_Bangunan_Dialog.getData_kendaraan_txt_nilai().equals("") && !fragment_Valuation_Bangunan_Dialog.getData_kendaraan_txt_luas_pemotongan().equals(""))
	    		fragment_Valuation_Bangunan_Dialog.setData_kendaraan_txt_nilai_pasar("" + (Long.parseLong(fragment_Valuation_Bangunan_Dialog.getData_kendaraan_txt_luas_pemotongan()) * Long.parseLong(fragment_Valuation_Bangunan_Dialog.getData_kendaraan_txt_nilai())));
	    
	    	if (!fragment_Valuation_Bangunan_Dialog.getData_kendaraan_txt_likuidasi().equals("") && !val_rtb_txt_nilai_pasar.getText().equals(""))
	    		fragment_Valuation_Bangunan_Dialog.setData_kendaraan_txt_nilai_likuidasi("" + ( (Long.parseLong(fragment_Valuation_Bangunan_Dialog.getData_kendaraan_txt_nilai_pasar().toString())* Long.parseLong(fragment_Valuation_Bangunan_Dialog.getData_kendaraan_txt_likuidasi().toString()))/100));
	    	}
	    
    	catch(Exception ex){}
    	
    	
    	
    }
    private void hitung(){
    	double marketimb, marketfisik, liqfisik, liqimb, landvalue, landliq;
    	try{
	    	if (!val_rtb_txt_nilai.getText().toString().equals("") && !val_rtb_txt_nilai_pemotongan.getText().toString().equals("")){
	    		 val_rtb_txt_nilai_pasar.setText("" + (Long.parseLong(val_rtb_txt_nilai_pemotongan.getText().toString()) * Long.parseLong(val_rtb_txt_nilai.getText().toString())));
	    	}
	    	else{
	    		 val_rtb_txt_nilai_pasar.setText("0");
	    	}
	    	if (!val_rtb_txt_likuidasi_tanah.getText().toString().equals("")){
	    			val_rtb_txt_Likuidasi2.setText("" + ( (Long.parseLong(val_rtb_txt_nilai_pasar.getText().toString())* Long.parseLong(val_rtb_txt_likuidasi_tanah.getText().toString()))/100));
	    	}
	    	else{
	    		val_rtb_txt_Likuidasi2.setText("0" );
	    	}
	    	if(!val_rtb_txt_nilai_pasar.getText().toString().equals("")){
	    		landvalue = Long.parseLong(val_rtb_txt_nilai_pasar.getText().toString());
	    	}else {
	    		landvalue=(double) 0;
	    	}
	    	if(!val_rtb_txt_Likuidasi2.getText().toString().equals("")){
	    		landliq = Long.parseLong(val_rtb_txt_Likuidasi2.getText().toString());
	    	}
	    	else
	    	{
	    		landliq=(double) 0;
	    	}
	    	
	    	 /* if (fBUILD_MARKET_VALUE_IMB_TOTAL.Value != null)
	              marketimb = double.Parse(fBUILD_MARKET_VALUE_IMB_TOTAL.Value.ToString()) + landvalue;
	          else marketimb = landvalue;*/
	    	if(!val_rtb_txt_total_fisik_bangunan.getText().toString().equals(""))
	    	{
	    		marketfisik =  Long.parseLong(val_rtb_txt_total_fisik_bangunan.getText().toString()) + landvalue;
	    	}
	    	else
	    	{
	    		marketfisik=(double) 0;
	    	}
	    	
	    	if (!val_rtb_txt_total_likuidasi_fisik_bangunan.getText().toString().equals(""))
	            liqfisik = Long.parseLong(val_rtb_txt_total_likuidasi_fisik_bangunan.getText().toString()) + landliq;
	        else liqfisik = landliq;
	
	       /* if (fBUILD_LIQ_VALUE_IMB_TOTAL.Value != null)
	            liqimb = double.Parse(fBUILD_LIQ_VALUE_IMB_TOTAL.Value.ToString()) + landliq;
	        else liqimb = landliq;*/
	    	
	    	val_rtb_txt_total_fisik.setText(""+ marketfisik);
	        //TOTAL_MARKET_VALUE_IMB.SetValue(marketimb);
	    	val_rtb_txt_total_fisik_likuidasi.setText(""+ liqfisik);
	        //TOTAL_LIQ_VALUE_IMB.SetValue(liqimb);
	    	
	    	
	    	if(val_rtb_rdo_cek_penilaian_bangunan.isChecked())
	    		val_rtb_txt_bangunan_asuransi.setText(val_rtb_txt_total_fisik_bangunan.getText().toString());	
	    	

    	}
	    
    	catch(Exception ex){}
    	
    }
    public void showConfirmationDelete(final boolean isparent,final String id) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctx);
        alertDialog.setTitle("Confirm");
        alertDialog.setMessage(R.string.msg_notification_delete);
        alertDialog.setPositiveButton(R.string.str_yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            	try {
					appr_Val_BangunanDataProvider.deleteTransaksiById(id);
					viewdataBangunan();
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
