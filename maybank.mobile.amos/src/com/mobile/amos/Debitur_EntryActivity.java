package com.mobile.amos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.R.integer;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ParseException;
import android.opengl.Visibility;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.Settings;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnFocusChangeListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import maybank.mobile.amos.R;

import com.google.gson.Gson;
import com.mobile.app.activity.HomeActivity;
import com.mobile.app.configuration.AppConstants;
import com.mobile.app.ui.DatePickerManager;
import com.mobile.app.ui.ListOfValueAdapter;
import com.mobile.bo.app.dataprovider.Amos_Entry_Debitur;
import com.mobile.bo.app.dataprovider.Appr_Email;
import com.mobile.bo.app.dataprovider.Appr_ImbProvider;
import com.mobile.bo.app.dataprovider.LOVDataProvider;
import com.mobile.bo.app.datatype.DataType_Amos_Debitur_Int;
import com.mobile.bo.app.datatype.DataType_Amos_Email;
import com.mobile.bo.app.datatype.Datatype_Appr_imb;
import com.mobile.bo.app.datatype.LovData;
import com.mobile.bo.app.datatype.UserData;
import com.mobile.database.app.common.DataConverter;
import com.mobile.framework.activity.ActivityHandler;
import com.mobile.framework.common.CurrencyFormat;

import com.mobile.framework.common.DateFormatter;
import com.mobile.framework.data.SessionSharedPreference;
import com.mobile.framework.widget.ExSpinner;
import com.mobile.framework.widget.ISpinnerItem;
import com.mobile.services.app.datatype.DATA_RESPONSE;
import com.mobile.services.app.datatype.DATA_RESPONSE_SCORE;
import com.mobile.services.app.services.ServiceDataProvider;
@SuppressWarnings("deprecation")
public class Debitur_EntryActivity extends Fragment{
	private UserData userDetail;
	
	private Context ctx;
	
	private Amos_Entry_Debitur amos_entry_debitur_DataProvider = new Amos_Entry_Debitur();
	private DataType_Amos_Debitur_Int amos_debitur_int = new DataType_Amos_Debitur_Int();
	
	
	private Appr_Email appr_Email = new Appr_Email();
	private DataType_Amos_Email dataType_Amos_Email = new DataType_Amos_Email();
	
	private String userid = "";
	private String ap_regno = "";
	String test_no, noSEQ;
	
	Button btnSave, btnCancel, btnSubmit,btn_submit_score,btnDelete;
	private ImageView btnBack;
	private LOVDataProvider lovDataProvider;
	
	private ImageView val_ams_view_img_tgllhr_deb;
    private ImageView val_ams_view_img_tgllhr_rel;
	
    private EditText val_ams_txt_seq;
	private EditText val_ams_txt_nama_deb;
	private EditText val_ams_txt_no_tlp;
	private EditText val_ams_txt_email;
	private EditText val_ams_txt_alamat;
	private EditText val_ams_txt_tgllhr_deb;
	private EditText val_ams_txt_usia;
	private EditText val_ams_txt_usia_b;

	private LinearLayout val_ams_layout1;
	private LinearLayout val_ams_layout2;
	private LinearLayout val_ams_layout3;
	private LinearLayout val_ams_layout4;
	private LinearLayout val_ams_layout5;

	
	private ExSpinner val_ams_spn_job_type;
    private ArrayList<ISpinnerItem> lovJobType = new ArrayList<ISpinnerItem>();
    private ArrayList<String> lovtest = new ArrayList<String>();
	private EditText val_ams_txt_nm_rel;
	private EditText val_ams_txt_tgllhr_rel;
	private EditText val_ams_txt_nm_usaha;
	private EditText val_ams_txt_alamat_usaha;
	private EditText val_ams_txt_pper_bln;
	private EditText val_ams_txt_pengendapan;
	private EditText val_ams_txt_ex_lblt;
	private EditText val_ams_txt_usia_yic;
	private EditText val_ams_txt_usia_mic;
	private ExSpinner val_ams_spn_prdct_kat;
    private ArrayList<ISpinnerItem> lovPrdctKat = new ArrayList<ISpinnerItem>();
    private ExSpinner val_ams_spn_prdct_jns;
    private ArrayList<ISpinnerItem> lovJnsPrdct = new ArrayList<ISpinnerItem>();
    private ExSpinner val_ams_spn_prdct_jnssub;
    private ArrayList<ISpinnerItem> lovJnsPrdctSub = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovfire = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovlife = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovJnsPromo = new ArrayList<ISpinnerItem>();
    private ExSpinner val_ams_spn_jns_jaminan;
    private ArrayList<ISpinnerItem> lovJnsJaminan = new ArrayList<ISpinnerItem>();
    private ExSpinner val_ams_spn_comp_asuransi;
    private ArrayList<ISpinnerItem> lovCompAsuransi = new ArrayList<ISpinnerItem>();
    private ExSpinner val_ams_spn_plan_asuransi;
    private ArrayList<ISpinnerItem> lovPlanAsuransi = new ArrayList<ISpinnerItem>();
    private ExSpinner val_ams_spn_comp_asuransi_fire;
    private ArrayList<ISpinnerItem> lovCompAsuransiFire = new ArrayList<ISpinnerItem>();
    private ExSpinner val_ams_spn_plan_asuransi_fire;
    private ExSpinner val_ams_spn_promo_code;
    private ArrayList<ISpinnerItem> lovPlanAsuransiFire = new ArrayList<ISpinnerItem>();
    
    
    private LovData lovData = new LovData();
    private LovData lovDatalife = new LovData();
    private LovData lovDatafire = new LovData();
    
    private ArrayList<LovData> lovDataArray_1 = new ArrayList<LovData>();
    private ArrayList<LovData> lovDataArray_2 = new ArrayList<LovData>();
    
    private LovData lovDataSingle_1 = new LovData();
    private LovData lovDataSingle_2 = new LovData();
    
	private EditText val_ams_txt_hrg_rumah;
	private EditText val_ams_txt_down_pay;
	private EditText val_ams_txt_suku_bng;
	private EditText val_ams_txt_jw_kredit_perbln;
	private EditText val_ams_txt_luas_bangunan;
	private EditText val_ams_txt_hrg_bangunan;
	private EditText val_ams_txt_cicilan;
	private EditText val_ams_txt_ltv;
	private EditText val_ams_txt_iir_dbr;
	private EditText val_ams_txt_platfond_kredit;
	private EditText val_ams_txt_provisi;
	private EditText val_ams_txt_biaya_administrasi;
	private EditText val_ams_txt_biaya_asuransi;
	private EditText val_ams_txt_biaya_asuransi_fire;
	private EditText val_ams_txt_biaya_notaris;
	private EditText val_ams_txt_biaya_ppht;
	
	private int varUmur;
	private boolean onloadkat=true;
	private boolean onloadjns=true;
	private boolean onloadaslife=true;
	private boolean onloadasfire=true;
	private boolean onloadsuku=true;
	private boolean onloadplatfond=true;
	private boolean onloadtenor=true;
	private boolean onloadharga=true;
	private boolean onloadex=true;
	private boolean onloadpper=true;
	private boolean onloadluas=true;
	private boolean onloadbangunan=true;
	private long polishasfire=0;
	private long polishaslife=0;
	private long biayaasfire=0;
	private long biayaaslife=0;
	private long biayaadmin=0;
	private String ID="";
	private String CH_CODE="";
	private String AP_CREATEDATE="";
	private String AP_DOCRECVDATE="";
	private String BOOKINGBRANCH="";
	private String value1="";
	private String value2="";
	private String value3="";
	private String value4="";
	private String value5="";
	private String value6="";
	private String value7="";
	private String value8="";
	private String value9="";
	private Spinner spinner1;
	
	
	private EditText val_ams_txt_abr;
	private EditText val_ams_txt_yic;
	private ExSpinner val_ams_spn_cus_reff;
	private ArrayList<ISpinnerItem> lovcusreff = new ArrayList<ISpinnerItem>();
	private ExSpinner val_ams_spn_el;
	private ArrayList<ISpinnerItem> lovel = new ArrayList<ISpinnerItem>();
	private ExSpinner val_ams_spn_soc;
	private ArrayList<ISpinnerItem> lovsoc = new ArrayList<ISpinnerItem>();
	private ExSpinner val_ams_spn_ap;
	private ArrayList<ISpinnerItem> lovap = new ArrayList<ISpinnerItem>();
	private RadioButton val_rtb_rdo_sex_male;
	private RadioButton val_rtb_rdo_sex_female;
	private ImageView val_ams_view_img_yic;
	private String jmlPlatfoundKredit, jmlSukuBunga, jmlJ_W_Kredit, jmlCicilan, jmlPenPerBln, 
		jmlExLiabilities, jmlHargaRumah, downPayment;
	
	View view=null;
	
	private String age_years = "0", age_months = "0", age_years_yic = "0", age_years_mic = "0";
	
	private int Ctanggal, Cbulan, Ctahun;
	private TextView val_ams_txt_hasil_scoring;
	public Debitur_EntryActivity() {
	    }

    public void onBackPressed() {
    	 Bundle ba = getArguments();
         if(ba != null) {
        	 
        	 Debitur_InqueryActivity sss=new Debitur_InqueryActivity();
        	 sss.refresh();
        	 ActivityHandler.gotoActivity(ctx, Debitur_InqueryActivity.class, null);
         }
         else{ ActivityHandler.gotoActivity(ctx, HomeActivity.class, null);}
       
       
    }
    public void doBack() {
    	onBackPressed();
    }
	public interface OnBackPressedListener {
	    void onBackPressed();
	}
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		/*super.onCreate(savedInstanceState);*/
		 view = inflater.inflate(R.layout.amos_fragment_debitur_data_entry, null);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
       
		ctx = this.getActivity();
		 try {
				userDetail = (UserData) SessionSharedPreference.getDataFromSharedPreference(ctx, UserData.class, AppConstants.USER_SESSION);
				userid = userDetail.getUSERID();
		 } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	   }

		amos_entry_debitur_DataProvider=new Amos_Entry_Debitur();
		amos_debitur_int=new DataType_Amos_Debitur_Int();
		appr_Email = new Appr_Email();
		dataType_Amos_Email = new DataType_Amos_Email();
		
		initControl();
	
		//Bundle iin =  getArguments();
        Bundle ba = getArguments();
        if(ba != null) {
            loadData(ba);
        }
        
        if(savedInstanceState!=null)
        {
        	value1=savedInstanceState.getString("1");
        	value2=savedInstanceState.getString("2");
        	value3=savedInstanceState.getString("3");
        	value4=savedInstanceState.getString("4");
        	value5=savedInstanceState.getString("5");
        	value6=savedInstanceState.getString("6");
        	value7=savedInstanceState.getString("7");
        	value8=savedInstanceState.getString("8");
        	biayaasfire=Long.parseLong(savedInstanceState.getString("9"));
			biayaaslife=Long.parseLong(savedInstanceState.getString("10"));
			polishasfire=Long.parseLong(savedInstanceState.getString("11"));
			polishaslife=Long.parseLong(savedInstanceState.getString("12"));
			ID=savedInstanceState.getString("13");
        }
        return view;
	}
	
	 @Override
	public void onSaveInstanceState(Bundle outState) {
			// TODO Auto-generated method stub
		 
		 
		 try{
			 outState.putString("1",val_ams_spn_prdct_kat.getSelectedListOfValue().toString());
		 }
		 catch(Exception ex){
			 outState.putString("1","");
		 }
		 try{
			 outState.putString("2",val_ams_spn_prdct_jns.getSelectedListOfValue().toString());
		 }
		 catch(Exception ex){
			 outState.putString("2","");
		 }
		 try{
			 outState.putString("3",val_ams_spn_prdct_jnssub.getSelectedListOfValue().toString());
		 }
		 catch(Exception ex){
			 outState.putString("3","");
		 }
		 try{
			 outState.putString("4",val_ams_spn_promo_code.getSelectedListOfValue().toString());
		 }
		 catch(Exception ex){
			 outState.putString("4","");
		 }
		 try{
			 outState.putString("5",val_ams_spn_comp_asuransi.getSelectedListOfValue().toString());
		 }
		 catch(Exception ex){
			 outState.putString("5","");
		 }
		 try{
			 outState.putString("6",val_ams_spn_plan_asuransi.getSelectedListOfValue().toString());
		 }
		 catch(Exception ex){
			 outState.putString("6","");
		 }
		 try{
			 outState.putString("7",val_ams_spn_comp_asuransi_fire.getSelectedListOfValue().toString());
		 }
		 catch(Exception ex){
			 outState.putString("7","");
		 }
		 try{
			 outState.putString("8",val_ams_spn_plan_asuransi_fire.getSelectedListOfValue().toString());
		 }
		 catch(Exception ex){
			 outState.putString("8","0");
		 }
	    	
		 try{
			 outState.putString("9","" + biayaasfire);
		 }
		 catch(Exception ex){
			 outState.putString("9","");
		 }
		 try{
			 outState.putString("10","" + biayaaslife);
		 }
		 catch(Exception ex){
			 outState.putString("10","0");
		 }
		 try{
			 outState.putString("11","" + polishasfire);
		 }
		 catch(Exception ex){
			 outState.putString("11","0");
		 }
		 try{
			 outState.putString("12","" + polishaslife);
		 }
		 catch(Exception ex){
			 outState.putString("12","0");
		 }
		 try{
			 outState.putString("13",ID);
		 }
		 catch(Exception ex){
			 outState.putString("13","");
		 }
		super.onSaveInstanceState(outState);
	}
	
	private void initControl()
	{
		val_ams_txt_hasil_scoring= (TextView) view.findViewById(R.id.val_ams_txt_hasil_scoring);
		val_ams_txt_usia_yic= (EditText) view.findViewById(R.id.val_ams_txt_usia_yic);
		val_ams_txt_usia_mic= (EditText) view.findViewById(R.id.val_ams_txt_usia_mic);
		val_ams_layout1=(LinearLayout) view.findViewById(R.id.val_ams_layout1);
		val_ams_layout2=(LinearLayout) view.findViewById(R.id.val_ams_layout2);
		val_ams_layout3=(LinearLayout) view.findViewById(R.id.val_ams_layout3);
		val_ams_layout4=(LinearLayout) view.findViewById(R.id.val_ams_layout4);
		val_ams_layout5=(LinearLayout) view.findViewById(R.id.val_ams_layout5);
		val_ams_spn_promo_code=(ExSpinner) view.findViewById(R.id.val_ams_spn_promo_code);
		val_ams_txt_seq = (EditText) view.findViewById(R.id.val_ams_txt_seq);
		val_ams_txt_nama_deb = (EditText) view.findViewById(R.id.val_ams_txt_nama_deb);
		val_ams_txt_no_tlp = (EditText) view.findViewById(R.id.val_ams_txt_no_tlp);
		val_ams_txt_email = (EditText) view.findViewById(R.id.val_ams_txt_email);
		val_ams_txt_alamat = (EditText) view.findViewById(R.id.val_ams_txt_alamat);
		val_ams_txt_tgllhr_deb = (EditText) view.findViewById(R.id.val_ams_txt_tgllhr_deb);
		val_ams_txt_usia = (EditText) view.findViewById(R.id.val_ams_txt_usia);
		val_ams_txt_usia_b = (EditText) view.findViewById(R.id.val_ams_txt_usia_b);
		val_ams_spn_job_type =(ExSpinner) view.findViewById(R.id.val_ams_spn_job_type);
		val_ams_txt_nm_rel = (EditText) view.findViewById(R.id.val_ams_txt_nm_rel);
		val_ams_txt_tgllhr_rel = (EditText) view.findViewById(R.id.val_ams_txt_tgllhr_rel);
		val_ams_txt_nm_usaha = (EditText) view.findViewById(R.id.val_ams_txt_nm_usaha);
		val_ams_txt_alamat_usaha = (EditText) view.findViewById(R.id.val_ams_txt_alamat_usaha);
		val_ams_txt_pper_bln = (EditText) view.findViewById(R.id.val_ams_txt_pper_bln);
		val_ams_txt_pengendapan = (EditText) view.findViewById(R.id.val_ams_txt_pengendapan);
		val_ams_txt_ex_lblt = (EditText) view.findViewById(R.id.val_ams_txt_ex_lblt);
		val_ams_spn_prdct_kat =(ExSpinner) view.findViewById(R.id.val_ams_spn_prdct_kat);
        val_ams_spn_prdct_jns =(ExSpinner) view.findViewById(R.id.val_ams_spn_prdct_jns);
        val_ams_spn_prdct_jnssub =(ExSpinner) view.findViewById(R.id.val_ams_spn_prdct_jnssub);
        val_ams_spn_jns_jaminan =(ExSpinner) view.findViewById(R.id.val_ams_spn_jns_jaminan);
        val_ams_spn_comp_asuransi =(ExSpinner) view.findViewById(R.id.val_ams_spn_comp_asuransi);
        val_ams_spn_plan_asuransi =(ExSpinner) view.findViewById(R.id.val_ams_spn_plan_asuransi);
        val_ams_spn_comp_asuransi_fire =(ExSpinner) view.findViewById(R.id.val_ams_spn_comp_asuransi_fire);
        val_ams_spn_plan_asuransi_fire =(ExSpinner) view.findViewById(R.id.val_ams_spn_plan_asuransi_fire);
		val_ams_txt_hrg_rumah = (EditText) view.findViewById(R.id.val_ams_txt_hrg_rumah);
		
		val_ams_txt_down_pay = (EditText) view.findViewById(R.id.val_ams_txt_down_pay);
		
		
		val_ams_txt_suku_bng = (EditText) view.findViewById(R.id.val_ams_txt_suku_bng);
		val_ams_txt_jw_kredit_perbln = (EditText) view.findViewById(R.id.val_ams_txt_jw_kredit_perbln);
		val_ams_txt_luas_bangunan = (EditText) view.findViewById(R.id.val_ams_txt_luas_bangunan);
		val_ams_txt_hrg_bangunan = (EditText) view.findViewById(R.id.val_ams_txt_hrg_bangunan);
		
		val_ams_txt_cicilan = (EditText) view.findViewById(R.id.val_ams_txt_cicilan);
		val_ams_txt_ltv = (EditText) view.findViewById(R.id.val_ams_txt_ltv);
		val_ams_txt_iir_dbr = (EditText) view.findViewById(R.id.val_ams_txt_iir_dbr);
		val_ams_txt_platfond_kredit = (EditText) view.findViewById(R.id.val_ams_txt_platfond_kredit);
		val_ams_txt_provisi = (EditText) view.findViewById(R.id.val_ams_txt_provisi);
		val_ams_txt_biaya_administrasi = (EditText) view.findViewById(R.id.val_ams_txt_biaya_administrasi);
		val_ams_txt_biaya_asuransi = (EditText) view.findViewById(R.id.val_ams_txt_biaya_asuransi);
		val_ams_txt_biaya_asuransi_fire = (EditText) view.findViewById(R.id.val_ams_txt_biaya_asuransi_fire);
		val_ams_txt_biaya_notaris = (EditText) view.findViewById(R.id.val_ams_txt_biaya_notaris);
		val_ams_txt_biaya_ppht = (EditText) view.findViewById(R.id.val_ams_txt_biaya_ppht);
		
		val_ams_view_img_tgllhr_deb = (ImageView) view.findViewById(R.id.val_ams_view_img_tgllhr_deb);
		val_ams_view_img_tgllhr_rel = (ImageView) view.findViewById(R.id.val_ams_view_img_tgllhr_rel);
		btnSave = (Button) view.findViewById(R.id.btn_save);
		btnCancel = (Button) view.findViewById(R.id.btn_cancel);
		btnSubmit = (Button) view.findViewById(R.id.btn_submit);
		btnBack = (ImageView) view.findViewById(R.id.inbox_btn_back);
		btn_submit_score= (Button) view.findViewById(R.id.btn_submit_score);
		btnDelete= (Button) view.findViewById(R.id.btn_submit_delete);
		val_ams_txt_abr = (EditText) view.findViewById(R.id.val_ams_txt_abr);
		val_ams_txt_yic = (EditText) view.findViewById(R.id.val_ams_txt_yic);
		val_ams_spn_cus_reff =(ExSpinner) view.findViewById(R.id.val_ams_spn_cus_reff);
		val_ams_spn_el=(ExSpinner) view.findViewById(R.id.val_ams_spn_el);
		val_ams_spn_soc =(ExSpinner) view.findViewById(R.id.val_ams_spn_soc);
		val_ams_spn_ap =(ExSpinner) view.findViewById(R.id.val_ams_spn_ap);
		val_rtb_rdo_sex_male =(RadioButton) view.findViewById(R.id.val_rtb_rdo_sex_male);
		val_rtb_rdo_sex_female =(RadioButton) view.findViewById(R.id.val_rtb_rdo_sex_female);
		val_ams_view_img_yic =(ImageView) view.findViewById(R.id.val_ams_view_img_yic);
		btnSubmit.setVisibility(View.GONE);
		btnDelete.setVisibility(View.GONE);
		setTextWatcher(val_ams_txt_hrg_rumah);
		setTextWatcher(val_ams_txt_hrg_bangunan);
		setTextWatcher(val_ams_txt_platfond_kredit);
		setTextWatcher(val_ams_txt_pengendapan);
		setTextWatcher(val_ams_txt_pper_bln);
		setTextWatcher(val_ams_txt_ex_lblt);
		setTextWatcher(val_ams_txt_biaya_notaris);
		setTextWatcher(val_ams_txt_biaya_ppht);
		setTextWatcher(val_ams_txt_biaya_asuransi);
		setTextWatcher(val_ams_txt_biaya_asuransi_fire);
		setTextWatcher(val_ams_txt_down_pay);
		val_ams_txt_platfond_kredit.setEnabled(false);
		//updateSpiner();
		
		lovDataProvider = new LOVDataProvider();
		
        lovJobType = ListOfValueAdapter.createESAdapterLovWithCode(lovDataProvider.getListOfValueData(AppConstants.SPINNER_PEKERJAAN));
        val_ams_spn_job_type.setListOfValue(lovJobType, false);
        
        lovcusreff = ListOfValueAdapter.createESAdapterLovWithCode(lovDataProvider.getListOfValueData(AppConstants.SPINNER_CUST_REFF));
        val_ams_spn_cus_reff.setListOfValue(lovcusreff, false);
        
        lovel = ListOfValueAdapter.createESAdapterLovWithCode(lovDataProvider.getListOfValueData(AppConstants.SPINNER_EDUCATION));
        val_ams_spn_el.setListOfValue(lovel, false);
    	
        lovsoc = ListOfValueAdapter.createESAdapterLovWithCode(lovDataProvider.getListOfValueData(AppConstants.SPINNER_SOC));
        val_ams_spn_soc.setListOfValue(lovsoc, false);
    	
        lovap = ListOfValueAdapter.createESAdapterLovWithCode(lovDataProvider.getListOfValueData(AppConstants.SPINNER_AP));
        val_ams_spn_ap.setListOfValue(lovap, false);
    	
        
      /*  ArrayList<String> list = new ArrayList<String>();
        list.add("Germany");
        list.add("USA");
        list.add("Nairobi");
        list.add("Japan");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ctx, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);*/

//        spinner1.setAdapter(adapter);
        
//        spinner1 =(Spinner)view.findViewById(R.id.spinner1);
//        spinner1.setAdapter(adapter);
//		spinner1.setAdapter(lovJobType);
		
        lovPrdctKat = ListOfValueAdapter.createESAdapterLovWithCode(lovDataProvider.getListOfValueData(AppConstants.SPINNER_PRODUCTTYPE));
        val_ams_spn_prdct_kat.setListOfValue(lovPrdctKat, false);
        
        lovJnsJaminan = ListOfValueAdapter.createESAdapterLovWithCode(lovDataProvider.getListOfValueData(AppConstants.SPINNER_JNSCOLLATERAL));
        val_ams_spn_jns_jaminan.setListOfValue(lovJnsJaminan, false);
        
        lovCompAsuransi = ListOfValueAdapter.createESAdapterLovWithCode(lovDataProvider.getListOfValueData(AppConstants.SPINNER_ASURANSIJW));
        val_ams_spn_comp_asuransi.setListOfValue(lovCompAsuransi, false);
        
        lovCompAsuransiFire = ListOfValueAdapter.createESAdapterLovWithCode(lovDataProvider.getListOfValueData(AppConstants.SPINNER_ASURANSIF));
        val_ams_spn_comp_asuransi_fire.setListOfValue(lovCompAsuransiFire, false);
        val_rtb_rdo_sex_male.setChecked(true);
		
		actionOnCLick();
		
		actionOnFocusChange();
		
		actionOnSelected();
		setColorMandatory();
		//btnDelete.setVisibility(View.GONE);
	}
	 public String formatCurrency(String value) {
	        String numberformat = "";
	        String userInput = value.replace("R", "").replace("p", "").replace(" ", "");

	        int lengthstring = userInput.length();

	        int loops = (int) Math.floor(lengthstring / 3);

	        if (lengthstring % 3 != 0)
	            loops++;

	        Log.d("RESPON " + loops, userInput.toString());

	        for (int x = 0; x < loops; x++) {
	            int startchar = userInput.length() - 3;

	            String stringuse = "";
	            if (startchar > 0) {
	                stringuse = userInput.substring(startchar);
	                userInput = userInput.substring(0, startchar);
	            } else {
	                stringuse = userInput;
	            }

	            if (!numberformat.isEmpty())
	                numberformat = stringuse + "." + numberformat;
	            else
	                numberformat = stringuse + numberformat;
	        }

	        return numberformat = "Rp " + numberformat;

	    }

	   
	public void setTextWatcher(final EditText ed) {
        TextWatcher tw = new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                ed.removeTextChangedListener(this);
                try {
                    String numberformat = "";
                    String userInput = s.toString().replace("R", "").replace("p", "").replace(" ", "").replace(".", "");

                    int lengthstring = userInput.length();

                    int loops = (int) Math.floor(lengthstring / 3);

                    if (lengthstring % 3 != 0)
                        loops++;

                    Log.d("RESPON " + loops, userInput.toString());

                    for (int x = 0; x < loops; x++) {
                        int startchar = userInput.length() - 3;

                        String stringuse = "";
                        if (startchar > 0) {
                            stringuse = userInput.substring(startchar);
                            userInput = userInput.substring(0, startchar);
                        } else {
                            stringuse = userInput;
                        }

                        if (!numberformat.isEmpty())
                            numberformat = stringuse + "." + numberformat;
                        else
                            numberformat = stringuse + numberformat;
                    }

                    numberformat = "Rp " + numberformat;

                    ed.setText(numberformat);
                    Selection.setSelection(ed.getText(), numberformat.toString().length());
                } catch (Exception e) {
                    Log.d("RESPON", e.toString());
                }

                ed.addTextChangedListener(this);
            }
        };

        ed.addTextChangedListener(tw);
    }
	public void setColorMandatory() {
		val_ams_txt_nama_deb.setBackgroundResource(R.drawable.fillcolor);
		val_ams_txt_tgllhr_deb.setBackgroundResource(R.drawable.fillcolor);
		val_ams_txt_pper_bln.setBackgroundResource(R.drawable.fillcolor);
		val_ams_txt_pengendapan.setBackgroundResource(R.drawable.fillcolor);
		val_ams_txt_ex_lblt.setBackgroundResource(R.drawable.fillcolor);
		val_ams_txt_hrg_rumah.setBackgroundResource(R.drawable.fillcolor);
		val_ams_txt_suku_bng.setBackgroundResource(R.drawable.fillcolor);
		val_ams_txt_jw_kredit_perbln.setBackgroundResource(R.drawable.fillcolor);
		val_ams_txt_luas_bangunan.setBackgroundResource(R.drawable.fillcolor);
		val_ams_txt_hrg_bangunan.setBackgroundResource(R.drawable.fillcolor);
		val_ams_txt_no_tlp.setBackgroundResource(R.drawable.fillcolor);
		val_ams_txt_email.setBackgroundResource(R.drawable.fillcolor);
		val_ams_txt_down_pay.setBackgroundResource(R.drawable.fillcolor);
		
//		val_ams_txt_platfond_kredit.setBackgroundResource(R.drawable.fillcolor);
		
	}
	
	private Boolean CekMandatory(){
    	  boolean retval=true;
    	  if(val_ams_txt_nama_deb.getText().length()==0){
    		   val_ams_txt_nama_deb.setError("Field Tidak Boleh Kososng");
    		  retval=false;
    	  }
    	  if(val_ams_txt_email.getText().length()==0){
    		  val_ams_txt_email.setError("Field Tidak Boleh Kososng");
			  retval=false;
		  }
    	  if(val_ams_txt_nama_deb.getText().length()==0){
    		  val_ams_txt_nama_deb.setError("Field Tidak Boleh Kososng");
	   		  retval=false;
	   	  }
    	  if(val_ams_txt_tgllhr_deb.getText().length()==0){
    		  val_ams_txt_tgllhr_deb.setError("Field Tidak Boleh Kososng");
    		  retval=false;
    	  }
    	  if(val_ams_txt_pper_bln.getText().length()==0){
    		  val_ams_txt_pper_bln.setError("Field Tidak Boleh Kososng");
    		  retval=false;
    	  }
    	  if(val_ams_txt_pengendapan.getText().length()==0){
    		  val_ams_txt_pengendapan.setError("Field Tidak Boleh Kososng");
    		  retval=false;
    	  }
    	  if(val_ams_txt_ex_lblt.getText().length()==0){
    		  val_ams_txt_ex_lblt.setError("Field Tidak Boleh Kososng");
    		  retval=false;
    	  }
    	  if(val_ams_txt_hrg_rumah.getText().length()==0){
    		  val_ams_txt_hrg_rumah.setError("Field Tidak Boleh Kososng");
    		  retval=false;
    	  }
    	  if(val_ams_txt_suku_bng.getText().length()==0){
    		  val_ams_txt_suku_bng.setError("Field Tidak Boleh Kososng");
    		  retval=false;
    	  }
    	  if(val_ams_txt_jw_kredit_perbln.getText().length()==0){
    		  val_ams_txt_jw_kredit_perbln.setError("Field Tidak Boleh Kososng");
    		  retval=false;
    	  }
    	  if(val_ams_txt_no_tlp.getText().length()==0){
    		  val_ams_txt_no_tlp.setError("Field Tidak Boleh Kososng");
    		  retval=false;
    	  }
    	  if(val_ams_txt_down_pay.getText().length()==0){
    		  val_ams_txt_down_pay.setError("Field Tidak Boleh Kososng");
    		  retval=false;
    	  }
    	  if((val_ams_spn_jns_jaminan.getSelectedListOfValue().equals("003")) || (val_ams_spn_jns_jaminan.getSelectedListOfValue().equals("004")) || (val_ams_spn_jns_jaminan.getSelectedListOfValue().equals("005"))){
    	  
    	  }
    	  else{
		    	  
		    	  ////
		    	  if(val_ams_txt_luas_bangunan.getText().length()==0){
		    		  val_ams_txt_luas_bangunan.setError("Field Tidak Boleh Kososng");
		    		  retval=false;
		    	  }
		    	  if(val_ams_txt_hrg_bangunan.getText().length()==0){
		    		  val_ams_txt_hrg_bangunan.setError("Field Tidak Boleh Kososng");
		    		  retval=false;
		    	  }
		    	  View selectedView7 = val_ams_spn_comp_asuransi_fire.getSelectedView();
		    	  if (selectedView7 != null && selectedView7 instanceof TextView) {
		    	      TextView selectedTextView = (TextView) selectedView7;
		    	      if (val_ams_spn_comp_asuransi_fire.getSelectedListOfValue().toString().length()==0) {
		    	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
		    	          selectedTextView.setError(errorString);
		    	          retval=false;
		    	      }
		    	      else {
		    	          selectedTextView.setError(null);
		    	      }
		    	  }
		    	  View selectedView8 = val_ams_spn_plan_asuransi_fire.getSelectedView();
		    	  if (selectedView8 != null && selectedView8 instanceof TextView) {
		    	      TextView selectedTextView = (TextView) selectedView8;
		    	      if (val_ams_spn_plan_asuransi_fire.getSelectedListOfValue().toString().length()==0) {
		    	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
		    	          selectedTextView.setError(errorString);
		    	          retval=false;
		    	      }
		    	      else {
		    	          selectedTextView.setError(null);
		    	      }
		    	  }
    	  }    	 
    	  
//    	  if(val_ams_txt_platfond_kredit.getText().length()==0){
//    		  val_ams_txt_platfond_kredit.setError("Field Tidak Boleh Kososng");
//    		  retval=false;
//    	  }
    	
    	  
    	  View selectedView = val_ams_spn_prdct_kat.getSelectedView();
    	  if (selectedView != null && selectedView instanceof TextView) {
    	      TextView selectedTextView = (TextView) selectedView;
    	      if (val_ams_spn_prdct_kat.getSelectedListOfValue().toString().length()==0) {
    	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
    	          selectedTextView.setError(errorString);
    	          retval=false;
    	      }
    	      else {
    	          selectedTextView.setError(null);
    	      }
    	  }
    	  
    	  View selectedView1 = val_ams_spn_prdct_jns.getSelectedView();
    	  if (selectedView1 != null && selectedView1 instanceof TextView) {
    	      TextView selectedTextView = (TextView) selectedView1;
    	      if (val_ams_spn_prdct_jns.getSelectedListOfValue().toString().length()==0) {
    	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
    	          selectedTextView.setError(errorString);
    	          retval=false;
    	      }
    	      else {
    	          selectedTextView.setError(null);
    	      }
    	  }
    	  View selectedView2 = val_ams_spn_prdct_jnssub.getSelectedView();
    	  if (selectedView2 != null && selectedView2 instanceof TextView) {
    	      TextView selectedTextView = (TextView) selectedView2;
    	      if (val_ams_spn_prdct_jnssub.getSelectedListOfValue().toString().length()==0) {
    	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
    	          selectedTextView.setError(errorString);
    	          retval=false;
    	      }
    	      else {
    	          selectedTextView.setError(null);
    	      }
    	  }
    	  View selectedView3 = val_ams_spn_jns_jaminan.getSelectedView();
    	  if (selectedView3 != null && selectedView3 instanceof TextView) {
    	      TextView selectedTextView = (TextView) selectedView3;
    	      if (val_ams_spn_jns_jaminan.getSelectedListOfValue().toString().length()==0) {
    	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
    	          selectedTextView.setError(errorString);
    	          retval=false;
    	      }
    	      else {
    	          selectedTextView.setError(null);
    	      }
    	  }
    	  View selectedView4 = val_ams_spn_promo_code.getSelectedView();
    	  if (selectedView4 != null && selectedView4 instanceof TextView) {
    	      TextView selectedTextView = (TextView) selectedView4;
    	      if (val_ams_spn_promo_code.getSelectedListOfValue().toString().length()==0) {
    	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
    	          selectedTextView.setError(errorString);
    	          retval=false;
    	      }
    	      else {
    	          selectedTextView.setError(null);
    	      }
    	  }
    	  View selectedView5 = val_ams_spn_comp_asuransi.getSelectedView();
    	  if (selectedView5 != null && selectedView5 instanceof TextView) {
    	      TextView selectedTextView = (TextView) selectedView5;
    	      if (val_ams_spn_comp_asuransi.getSelectedListOfValue().toString().length()==0) {
    	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
    	          selectedTextView.setError(errorString);
    	          retval=false;
    	      }
    	      else {
    	          selectedTextView.setError(null);
    	      }
    	  }
    	  View selectedView6 = val_ams_spn_plan_asuransi.getSelectedView();
    	  if (selectedView6 != null && selectedView6 instanceof TextView) {
    	      TextView selectedTextView = (TextView) selectedView6;
    	      if (val_ams_spn_plan_asuransi.getSelectedListOfValue().toString().length()==0) {
    	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
    	          selectedTextView.setError(errorString);
    	          retval=false;
    	      }
    	      else {
    	          selectedTextView.setError(null);
    	      }
    	  }
    	  
    	  View selectedView7 = val_ams_spn_ap.getSelectedView();
    	  if (selectedView7 != null && selectedView7 instanceof TextView) {
    	      TextView selectedTextView = (TextView) selectedView7;
    	      if (val_ams_spn_ap.getSelectedListOfValue().toString().length()==0) {
    	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
    	          selectedTextView.setError(errorString);
    	          retval=false;
    	      }
    	      else {
    	          selectedTextView.setError(null);
    	      }
    	  }
    	  
    	  View selectedView8 = val_ams_spn_el.getSelectedView();
    	  if (selectedView8 != null && selectedView8 instanceof TextView) {
    	      TextView selectedTextView = (TextView) selectedView8;
    	      if (val_ams_spn_el.getSelectedListOfValue().toString().length()==0) {
    	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
    	          selectedTextView.setError(errorString);
    	          retval=false;
    	      }
    	      else {
    	          selectedTextView.setError(null);
    	      }
    	  }
    	  
    	  View selectedView9 = val_ams_spn_cus_reff.getSelectedView();
    	  if (selectedView9 != null && selectedView9 instanceof TextView) {
    	      TextView selectedTextView = (TextView) selectedView9;
    	      if (val_ams_spn_cus_reff.getSelectedListOfValue().toString().length()==0) {
    	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
    	          selectedTextView.setError(errorString);
    	          retval=false;
    	      }
    	      else {
    	          selectedTextView.setError(null);
    	      }
    	  }
    	  
    	  View selectedView10 = val_ams_spn_soc.getSelectedView();
    	  if (selectedView10 != null && selectedView10 instanceof TextView) {
    	      TextView selectedTextView = (TextView) selectedView10;
    	      if (val_ams_spn_soc.getSelectedListOfValue().toString().length()==0) {
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
	private void actionOnCLick() 
	{
		btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityHandler.gotoActivity(ctx, HomeActivity.class, null);
                //finish();
            }
        });
		
		val_ams_view_img_yic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] arrTglLahir = null;

                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = (c.get(Calendar.MONTH));
                int day = c.get(Calendar.DAY_OF_MONTH);
                try{
	                if (!val_ams_txt_yic.getText().toString().equalsIgnoreCase("")) {
	                    arrTglLahir = val_ams_txt_yic.getText().toString().split("-");
	                    year = Integer.parseInt(arrTglLahir[2]);
	                    month = Integer.parseInt(arrTglLahir[1]) - 1;
	                    day = Integer.parseInt(arrTglLahir[0]);
	                }
                }
                catch(Exception e){
                	
                }
                DatePickerManager datePickerDialog = new DatePickerManager(ctx, PbTglYICSetListener, year, month, day);
                datePickerDialog.show();

            }
        });
		
		val_ams_view_img_tgllhr_deb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] arrTglLahir = null;

                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = (c.get(Calendar.MONTH));
                int day = c.get(Calendar.DAY_OF_MONTH);
                try{
	                if (!val_ams_txt_tgllhr_deb.getText().toString().equalsIgnoreCase("")) {
	                    arrTglLahir = val_ams_txt_tgllhr_deb.getText().toString().split("-");
	                    year = Integer.parseInt(arrTglLahir[2]);
	                    month = Integer.parseInt(arrTglLahir[1]) - 1;
	                    day = Integer.parseInt(arrTglLahir[0]);
	                }
                }
                catch(Exception e){
                	
                }
                DatePickerManager datePickerDialog = new DatePickerManager(ctx, PbTglLahirDebSetListener, year, month, day);
                datePickerDialog.show();

            }
        });
		
		val_ams_view_img_tgllhr_rel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] arrTglLahir = null;

                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = (c.get(Calendar.MONTH));
                int day = c.get(Calendar.DAY_OF_MONTH);
                try{
	                if (!val_ams_txt_tgllhr_rel.getText().toString().equalsIgnoreCase("")) {
	                    arrTglLahir = val_ams_txt_tgllhr_rel.getText().toString().split("-");
	                    year = Integer.parseInt(arrTglLahir[2]);
	                    month = Integer.parseInt(arrTglLahir[1]) - 1;
	                    day = Integer.parseInt(arrTglLahir[0]);
	                }
                }
                catch(Exception e){
                	
                }
                DatePickerManager datePickerDialog = new DatePickerManager(ctx, PbTglLahirRelSetListener, year, month, day);
                datePickerDialog.show();

            }
        });
		
		
		btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	try{
            		saveData("Save");
//            		btnDelete.setVisibility(View.VISIBLE);
        		}
            	catch(Exception ex){
            		showAlert(R.string.msg_notification_update_error);
            	}
           }
        });
		btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	boolean result=false;
            	try{
            		showConfirmationSubmit(true,ID);
            		//saveData("Submit");
            		result=true;
            		
        		}
            	catch(Exception ex){
            		showAlert(R.string.msg_notification_update_error);
            	}
            	
           }
        });
		btn_submit_score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	boolean result=false;
            	try{
            		showConfirmationSubmitScore(true,ID);
            		//saveData("Submit");
            		result=true;
        		}
            	catch(Exception ex){
            		showAlert(R.string.msg_notification_update_error);
            	}
            	
           }
        });
		
		btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	boolean result=false;
            	try{
            		showConfirmationDelete(ID);
            		result=true;
        		}
            	catch(Exception ex){
            		showAlert(R.string.msg_notification_update_error);
            	}
            	
           }
        });
		btnCancel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try{
            		newData();
        		}
            	catch(Exception ex){
//            		showAlert(R.string.FEMAIL);
            	}
			}
		});
	}
	
	private void actionOnFocusChange()
	{
		val_ams_txt_pper_bln.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && onloadpper==false)
                	hitung();
                
                onloadpper=false;
            }
        });
		val_ams_txt_ex_lblt.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && onloadex==false){
                	hitung();
                	hitungabr();
                }
                onloadex=false;
            }
        });
		val_ams_txt_hrg_rumah.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus  && onloadharga==false) {
                	
                	hitungPlatfond();
                	hitungasuransikebakaran();
                }
                onloadharga=false;
            }
        });
		val_ams_txt_pengendapan.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus  && onloadharga==false) {
                	hitungabr();
                }
                onloadharga=false;
            }
        });
		val_ams_txt_suku_bng.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && onloadsuku==false)
                	hitung();
                
                onloadsuku=false;
            }
            
        });
		
		val_ams_txt_email.setOnFocusChangeListener(new OnFocusChangeListener() {

			public void onFocusChange(View v, boolean hasFocus) {
				if(isEmailValid(val_ams_txt_email.getText().toString()) == false) {
					if(!val_ams_txt_email.getText().toString().equals("")) {
						val_ams_txt_email.setError("Invalid Email");
						val_ams_txt_email.setText("");
					}
				}
			}
		});
		
		val_ams_txt_jw_kredit_perbln.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && onloadtenor==false){
                	hitung();
                	hitungasuransijiwa();
                }
                onloadtenor=false;
            }
        });
//		val_ams_txt_platfond_kredit.setOnFocusChangeListener(new OnFocusChangeListener() {
//            public void onFocusChange(View v, boolean hasFocus) {
//            	try {
//            		if(!hasFocus && onloadplatfond==false) {
//                    	hitung();
//                    	hitungBiayaNotaris();
//                    	hitungProvisi();
//                    	hitungBiayaAdmin();
//                    	hitungasuransijiwa();
//                    	hitungBiayaPpht();
//                    }
//                    onloadplatfond=false;
//            	} catch(Exception e) {
//            		val_ams_txt_platfond_kredit.setText(formatCurrency("0"));
//            		if(!hasFocus && onloadplatfond==false) {
//                    	hitung();
//                    	hitungBiayaNotaris();
//                    	hitungProvisi();
//                    	hitungBiayaAdmin();
//                    	hitungasuransijiwa();
//                    	hitungBiayaPpht();
//                    }
//                    onloadplatfond=false;
//            	}
//            }
//        });
		val_ams_txt_luas_bangunan.setOnFocusChangeListener(new OnFocusChangeListener(){

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				if(!hasFocus && onloadluas==false){
                	hitung();
                	hitungasuransikebakaran();
				}
				onloadluas=false;
			}
		});
		val_ams_txt_hrg_bangunan.setOnFocusChangeListener(new OnFocusChangeListener(){

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				if(!hasFocus && onloadbangunan==false){
                	hitung();
                	hitungasuransikebakaran();
				}
				onloadbangunan=false;
			}
		});
		
		val_ams_txt_down_pay.setOnFocusChangeListener(new OnFocusChangeListener(){

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				try {
					if(!hasFocus && onloadbangunan==false){
						/*int downPayment = Integer.parseInt(val_ams_txt_down_pay.getText().toString());
						if(downPayment > 100) {
							val_ams_txt_down_pay.setText("100");
						}*/
						hitungPlatfond();
					}
					onloadbangunan=false;
				} catch (Exception e) {}
			}
		});
    }
	
	private void actionOnSelected() {
		val_ams_spn_prdct_kat.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
            	if(onloadkat==false){
	                String selected = (String) val_ams_spn_prdct_kat.getSelectedListOfValue(position);
	                if (!selected.equalsIgnoreCase("")) {
	                	val_ams_spn_prdct_jns.setVisibility(View.VISIBLE);
	                	changeKategoriProduct(selected);

	                } 
	                
	                else {
	                	val_ams_spn_prdct_jns.setListOfValue(new ArrayList<ISpinnerItem>(), false);
	                	val_ams_spn_prdct_jnssub.setListOfValue(new ArrayList<ISpinnerItem>(), false);
	                }
            	}
            	onloadkat=false;
            	if(!value1.equals("")){
            		changeKategoriProduct(value1);
            		val_ams_spn_prdct_kat.setSelectedListOfValue(value1);
            		val_ams_spn_prdct_jns.setSelectedListOfValue(value2);
            		value1="";
            		onloadkat=true;
            	
            	}
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        
        val_ams_spn_prdct_jns.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
            	if(onloadjns==false){
	                String selected = (String) val_ams_spn_prdct_jns.getSelectedListOfValue(position);
	                if (!selected.equalsIgnoreCase("")) {
	                	changeJenisProduct(selected);
	                	
	                	changeinsuraceCompany(selected, "L");
	                	changeinsuraceCompany(selected, "F");
	                	changepromocode(selected);
	                	
	                	
	                	/*if(sub_produk.length()>0)
	                		val_ams_spn_prdct_jnssub.setSelectedListOfValue(sub_produk);*/
	                	
	                } else {
	                	val_ams_spn_prdct_jnssub.setListOfValue(new ArrayList<ISpinnerItem>(), false);
	                }
            	}   
            	onloadjns=false;
            	if(!value2.equals("")){
            		val_ams_spn_prdct_jns.setSelectedListOfValue(value2);
            		changeJenisProduct(value2);
                	
                	changeinsuraceCompany(value2, "L");
                	changeinsuraceCompany(value2, "F");
                	changepromocode(value2);
            		
                	val_ams_spn_prdct_jnssub.setSelectedListOfValue(value3);
                	val_ams_spn_promo_code.setSelectedListOfValue(value4);
                	val_ams_spn_comp_asuransi.setSelectedListOfValue(value5);
                	//val_ams_spn_plan_asuransi.setSelectedListOfValue(value6);
                	val_ams_spn_comp_asuransi_fire.setSelectedListOfValue(value7);
                	//val_ams_spn_plan_asuransi_fire.setSelectedListOfValue(value9);
                	value2="";
                	value3="";
                	value4="";
            		onloadjns=true;
            		
            	}
            	
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            	
            }
        });

        
        val_ams_spn_comp_asuransi.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
            	if(onloadaslife==false){
	                String parent = (String) val_ams_spn_comp_asuransi.getSelectedListOfValue(position);
	                
	                lovDataProvider = new LOVDataProvider();
	                lovData=lovDataProvider.getLOVDetail(parent, AppConstants.SPINNER_ASURANSIJWPLAN_A);
	                if(lovData!=null){
		            	//SPINNER_ASURANSIFPLAN_A
		                if (!lovData.getPARENT_2().equalsIgnoreCase("")) {
		                	changeAsrJw(lovData.getPARENT_2().toString());
		                } else {
		                	val_ams_spn_plan_asuransi.setListOfValue(new ArrayList<ISpinnerItem>(), false);
		                }
	                }
	                
            	}
            	onloadaslife=false;
            	if(!value5.equals("")){
            		 String parent = (String) val_ams_spn_comp_asuransi.getSelectedListOfValue(position);
 	                
            		lovDataProvider = new LOVDataProvider();
 	                lovData=lovDataProvider.getLOVDetail(parent, AppConstants.SPINNER_ASURANSIJWPLAN_A);
 	                if(lovData!=null){
 		            	//SPINNER_ASURANSIFPLAN_A
 		                if (!lovData.getPARENT_2().equalsIgnoreCase("")) {
 		                	changeAsrJw(lovData.getPARENT_2().toString());
 		                } 
 	                }
 	                
            		//val_ams_spn_comp_asuransi.setSelectedListOfValue(value5);
                	val_ams_spn_plan_asuransi.setSelectedListOfValue(value6);

                	onloadaslife=true;
            		
            	}
            	
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        val_ams_spn_plan_asuransi_fire.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
            	 hitungasuransikebakaran();
            	/* try{
         			outState.putString("PLANFIRE", val_ams_spn_plan_asuransi_fire.getSelectedListOfValue().toString());
         		}
         		catch(Exception ex){
         			outState.putString("PLANFIRE", "");
         		}*/
            	 
            	 
         		
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        
        val_ams_spn_prdct_jnssub.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
            	/*try{
         			outState.putString("JNSPRODSUB", val_ams_spn_prdct_jnssub.getSelectedListOfValue().toString());
         			}
         		catch(Exception ex){
         			outState.putString("JNSPRODSUB", "");
         		}*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        
        
        val_ams_spn_jns_jaminan.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
            	if(val_ams_spn_jns_jaminan.getSelectedListOfValue().equals("003") || val_ams_spn_jns_jaminan.getSelectedListOfValue().equals("004") || (val_ams_spn_jns_jaminan.getSelectedListOfValue().equals("005"))){
            		val_ams_layout1.setVisibility(View.GONE);
            		val_ams_layout2.setVisibility(View.GONE);
            		val_ams_layout3.setVisibility(View.GONE);
            		val_ams_layout4.setVisibility(View.GONE);
            		val_ams_layout5.setVisibility(View.GONE);
            	}
            	else{
            		val_ams_layout1.setVisibility(View.VISIBLE);
            		val_ams_layout2.setVisibility(View.VISIBLE);
            		val_ams_layout3.setVisibility(View.VISIBLE);
            		val_ams_layout4.setVisibility(View.VISIBLE);
            		val_ams_layout5.setVisibility(View.VISIBLE);
            	}
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        val_ams_spn_comp_asuransi_fire.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
            	if(onloadasfire==false){
	                String parent = (String) val_ams_spn_comp_asuransi_fire.getSelectedListOfValue(position);
	                lovDataProvider = new LOVDataProvider();
	                lovData=lovDataProvider.getLOVDetail(parent, AppConstants.SPINNER_ASURANSIFPLAN_A);
	                if(lovData!=null){
		                if (!lovData.getPARENT_2().equalsIgnoreCase("")) {
		                	 changeAsrFire(lovData.getPARENT_2().toString());
		                		// mencari biaya asuransi kebakaran
		         			
		                } else {
		                	val_ams_spn_plan_asuransi_fire.setListOfValue(new ArrayList<ISpinnerItem>(), false);
		                }
	                }
            	}
            	onloadasfire=false;
            	if(!value7.equals("")){
            		String parent = (String) val_ams_spn_comp_asuransi_fire.getSelectedListOfValue(position);
	                lovDataProvider = new LOVDataProvider();
	                lovData=lovDataProvider.getLOVDetail(parent, AppConstants.SPINNER_ASURANSIFPLAN_A);
	                if(lovData!=null){
		                if (!lovData.getPARENT_2().equalsIgnoreCase("")) {
		                	 changeAsrFire(lovData.getPARENT_2().toString());
		                		// mencari biaya asuransi kebakaran
		         			
		                } else {
		                	val_ams_spn_plan_asuransi_fire.setListOfValue(new ArrayList<ISpinnerItem>(), false);
		                }
	                }
 	                
            		//val_ams_spn_comp_asuransi_fire.setSelectedListOfValue(value7);
                	val_ams_spn_plan_asuransi_fire.setSelectedListOfValue(value8);
                	onloadasfire=true;
            	}
            	
            	
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        
        val_ams_spn_plan_asuransi_fire.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
            	 hitungasuransikebakaran();
            	 
            	/* try{
         			outState.putString("PLANFIRE", val_ams_spn_plan_asuransi_fire.getSelectedListOfValue().toString());
         		}
         		catch(Exception ex){
         			outState.putString("PLANFIRE", "");
         		}*/
            	 
            	 
         		
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
	}
	private String SubmittedAmos()  {
		String score="";
		Amos_Entry_Debitur amos_Entry_Debitur=new Amos_Entry_Debitur();
				DataType_Amos_Debitur_Int arrdata = amos_Entry_Debitur.getAllAmos_Entry_Debitur_by_seq(ID);					
				if (amos_Entry_Debitur !=null){
					try {
						Gson gsondata=new Gson();
						
						ArrayList<DATA_RESPONSE_SCORE> Response = ServiceDataProvider.submitData_amos(gsondata.toJson(arrdata).toString());
						if (Response != null){
							if (Response.size() > 0){
								for (int i=0;i<Response.size();i++ ){
									DATA_RESPONSE_SCORE objRes= Response.get(i);
									if (objRes.getSTATUS().equalsIgnoreCase(AppConstants.STATUSPROSPEKTRUE)) {
										String id=objRes.getID();
										score=objRes.getSCORE();
										dataType_Amos_Email.setID(ID);
										dataType_Amos_Email.setAP_REGNO(objRes.getCOL_ID());
				                		dataType_Amos_Email.setISALREADYSUBMIT("1");
				                		dataType_Amos_Email.setTYPE("SCORE");
				                		dataType_Amos_Email.setNAMADEBITUR(val_ams_txt_nama_deb.getText().toString());
				                		if (dataType_Amos_Email !=null){
				        					try {
				        						Gson gsondata1=new Gson();
				        						
				        						ArrayList<DATA_RESPONSE_SCORE> Response1 = ServiceDataProvider.submitData_email(gsondata1.toJson(dataType_Amos_Email).toString());
				        						if (Response1 != null){
				        							if (Response1.size() > 0){
				        								for (int a=0;i<Response1.size();i++ ){
				        									DATA_RESPONSE_SCORE objRes1= Response1.get(a);
				        									if (objRes1.getSTATUS().equalsIgnoreCase(AppConstants.STATUSPROSPEKTRUE)) {
				        										
				        									}
				        									else{
				        										appr_Email.updateData(dataType_Amos_Email);
				        									}
				        								}	
				        							}		
				        						}
				        						else{
				        							//Log.d(TAG, "Send Data To Server Via Service: Server returned null");
				        						}
				        					} catch (Exception e) {
				        						Log.d("Error", "Send Data To Server Via Service: Exception ->"+e.getMessage());
				        					}
				        				}
									}
								}	
							}		
						}
						else{
							//Log.d(TAG, "Send Data To Server Via Service: Server returned null");
						}
					} catch (Exception e) {
						Log.d("Error", "Send Data To Server Via Service: Exception ->"+e.getMessage());
					}
				}

				amos_debitur_int = null;
				
		 return score;
		
		 
    }
	
	private class SubmittedData extends AsyncTask<Void, Void,Void> {
		Amos_Entry_Debitur amos_Entry_Debitur=new Amos_Entry_Debitur();
		String score="";
		ProgressDialog dialogSubmit = ProgressDialog.show(ctx, "Loading", "Please wait...", true);
		
		@Override
		protected Void doInBackground(Void... params) 
		{
			DataType_Amos_Debitur_Int arrdata = amos_Entry_Debitur.getAllAmos_Entry_Debitur_by_seq(ID);					
			if (amos_Entry_Debitur !=null){
				try {
					Gson gsondata=new Gson();
					
					ArrayList<DATA_RESPONSE_SCORE> Response = ServiceDataProvider.submitData_amos(gsondata.toJson(arrdata).toString());
					if (Response != null){
						if (Response.size() > 0){
							for (int i=0;i<Response.size();i++ ){
								DATA_RESPONSE_SCORE objRes= Response.get(i);
								if (objRes.getSTATUS().equalsIgnoreCase(AppConstants.STATUSPROSPEKTRUE)) {
									String id=objRes.getID();
									score=objRes.getSCORE();
									
									dataType_Amos_Email.setID(ID);
									dataType_Amos_Email.setAP_REGNO(objRes.getCOL_ID());
			                		dataType_Amos_Email.setISALREADYSUBMIT("1");
			                		dataType_Amos_Email.setTYPE("SCORE");
			                		dataType_Amos_Email.setNAMADEBITUR(val_ams_txt_nama_deb.getText().toString());
			                		if (dataType_Amos_Email !=null){
			        					try {
			        						Gson gsondata1=new Gson();
			        						
			        						ArrayList<DATA_RESPONSE_SCORE> Response1 = ServiceDataProvider.submitData_email(gsondata1.toJson(dataType_Amos_Email).toString());
			        						if (Response1 != null){
			        							if (Response1.size() > 0){
//			        								for (int a=0;i<Response1.size();i++ ){
			        								for (int a=0;a<Response1.size();a++ ){
			        									DATA_RESPONSE_SCORE objRes1= Response1.get(a);
			        									if (objRes1.getSTATUS().equalsIgnoreCase(AppConstants.STATUSPROSPEKTRUE)) {
			        										 
			        									}
			        									else{
			        										appr_Email.updateData(dataType_Amos_Email);
			        									}
			        								}	
			        							}		
			        						}
			        						else{
			        							//Log.d(TAG, "Send Data To Server Via Service: Server returned null");
			        						}
			        					} catch (Exception e) {
			        						Log.d("Error", "Send Data To Server Via Service: Exception ->"+e.getMessage());
			        						dialogSubmit.dismiss();
			        					}
			        				}
								}
							}	
						}		
					}
					else{
						//Log.d(TAG, "Send Data To Server Via Service: Server returned null");
					}
				} catch (Exception e) {
					Log.d("Error", "Send Data To Server Via Service: Exception ->"+e.getMessage());
					dialogSubmit.dismiss();
				}
			}
			
			amos_debitur_int = null;
			
			return null;
		}
		
		@Override
		protected void onPostExecute(Void result) {
			
	 		lovDataProvider = new LOVDataProvider();
        	lovData=lovDataProvider.getLOVDetail(score, AppConstants.SPINNER_SCORE);
               
//			if(score.equals("1")||score.equals("2")){
				//showAlertString("Data Berhasil disubmit hasil scoring : " + lovData.getDESCRIPTION());
				val_ams_txt_hasil_scoring.setText(lovData.getDESCRIPTION());
				
				try {
					amos_entry_debitur_DataProvider.deleteTransaksiById(ID);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					dialogSubmit.dismiss();
				}
				newData();
				
				ActivityHandler.gotoActivity(ctx, HomeActivity.class, null);
		        getActivity().finish();
//         	}
//         	else{
//         		if(lovData!=null){
//         			showAlertString("Data Gagal disubmit karena hasil scoring : " + lovData.getDESCRIPTION());
//         			val_ams_txt_hasil_scoring.setText(lovData.getDESCRIPTION());	
//         			dialogSubmit.dismiss();
//         		}
//         	}
		 	amos_Entry_Debitur = null;
			
		 	btnSubmit.setEnabled(true);
		 	btnSave.setEnabled(true);
		 	btnCancel.setEnabled(true);
		 	btn_submit_score.setEnabled(true);
//		 	btnDelete.setEnabled(true);
//		 	dialogSubmit.dismiss();
 		}
	}
	
	private String SubmittedAmosScore()
	{

		String score="";
		Amos_Entry_Debitur amos_Entry_Debitur=new Amos_Entry_Debitur();
				DataType_Amos_Debitur_Int arrdata = amos_Entry_Debitur.getAllAmos_Entry_Debitur_by_seq(ID);					
				if (amos_Entry_Debitur !=null){
					try {
						Gson gsondata=new Gson();
						
						ArrayList<DATA_RESPONSE_SCORE> Response = ServiceDataProvider.submitData_amos_score(gsondata.toJson(arrdata).toString());
						if (Response != null){
							if (Response.size() > 0){
								for (int i=0;i<Response.size();i++ ){
									DATA_RESPONSE_SCORE objRes= Response.get(i);
									if (objRes.getSTATUS().equalsIgnoreCase(AppConstants.STATUSPROSPEKTRUE)) {
										String id=objRes.getID();
										score=objRes.getSCORE();
										
							
										
										//amos_entry_debitur_DataProvider.deleteTransaksiById(id);
										//newData();
										//showAlert(R.string.msg_notification_submit_success);
										
										//ActivityHandler.gotoActivity(ctx, HomeActivity.class, null);
								        //getActivity().finish();
									}
								}	
							}		
						}
						else{
							//Log.d(TAG, "Send Data To Server Via Service: Server returned null");
						}
					} catch (Exception e) {
						Log.d("Error", "Send Data To Server Via Service: Exception ->"+e.getMessage());
					}
				}

				amos_debitur_int = null;
				
		 return score;
    }
	   
	
	public void hitungasuransikebakaran(){
		try{
            String selected = (String) val_ams_spn_plan_asuransi_fire.getSelectedListOfValue().toString();
            lovDatalife=lovDataProvider.getLOVDetail(selected, AppConstants.SPINNER_ASURANSIJWPLAN_B);
            lovDataProvider = new LOVDataProvider();
            float rate=0;
           
            long polish=0;
            try{
            	polish=Long.parseLong(lovDatalife.getPARENT_2().toString());
            }
            catch(Exception ex){
            	polish=0;
            }
            polishasfire=(long) polish;
    		
            if(selected!="" && val_ams_txt_jw_kredit_perbln.getText().toString().replace("Rp ", "").replace(".", "").replace(",", ".").length() > 0 && 
        		 val_ams_txt_hrg_rumah.getText().toString().replace("Rp ", "").replace(".", "").replace(",", ".").length()>0 &&
        		 val_ams_txt_luas_bangunan.getText().toString().replace("Rp ", "").replace(".", "").replace(",", ".").length() > 0 &&
        		 val_ams_txt_hrg_bangunan.getText().toString().replace("Rp ", "").replace(".", "").replace(",", ".").length() > 0){
            	
            	int tenor= Integer.parseInt(val_ams_txt_jw_kredit_perbln.getText().toString());
            	if(tenor%12 !=0 )
            	{
            		tenor=(tenor/12)+1;
            	}
            	else{
            		tenor=(tenor/12);
            	}
            	
            	float nilai_RatePremi= changegetRate(selected,""+ tenor,AppConstants.SPINNER_ASURANSIFPLAN_B);
            	String jmlHargaRumah = val_ams_txt_hrg_rumah.getText().toString().replace("Rp ", "").replace(".", "").replace(",", ".");
    			String jmlLuasBangunan = val_ams_txt_luas_bangunan.getText().toString().replace("Rp ", "").replace(".", "").replace(",", ".");
    			String jmlHargaBangunan = val_ams_txt_hrg_bangunan.getText().toString().replace("Rp ", "").replace(".", "").replace(",", ".");
    			
    			long hasil=0;


    				try{
    					hasil= (long) (Long.parseLong(jmlLuasBangunan) * Long.parseLong(jmlHargaBangunan) * nilai_RatePremi / 1000);	
    				}
    				catch(Exception ex){
    					hasil=0;
    				}
    		
            	if(!jmlLuasBangunan.equals("") && !jmlHargaBangunan.equals("") && nilai_RatePremi>0) {
            		biayaasfire=(long)hasil;
        			hasil = hasil + polish;
     				val_ams_txt_biaya_asuransi_fire.setText(formatCurrency("" + hasil));
     			}
            }
    	 }
         catch(Exception ex){
        	 val_ams_txt_biaya_asuransi_fire.setText("0");
         }
	}
	public void hitungasuransijiwa()
	{
		try{
            String selected = val_ams_spn_plan_asuransi.getSelectedListOfValue().toString();
           
            lovDataProvider = new LOVDataProvider();
            lovDatalife=lovDataProvider.getLOVDetail(selected, AppConstants.SPINNER_ASURANSIJWPLAN_B);
            float polish=0;
            try{
            	polish=Float.parseFloat(lovDatalife.getPARENT_2().toString());
            }
            catch(Exception ex){
            	polish=0;
            }
            polishaslife=(long)(polish);
            float rate=0;
            if(selected!="" && varUmur > 0 && val_ams_txt_jw_kredit_perbln.getText().toString().replace("Rp ", "").replace(".", "").replace(",", ".").length() >0 ){
            	int tenor= Integer.parseInt(val_ams_txt_jw_kredit_perbln.getText().toString().replace("Rp ", "").replace(".", "").replace(",", "."));
            	if(tenor%12 !=0 )
            	{
            		tenor=(tenor/12)+1;
            	}
            	else{
            		tenor=(tenor/12);
            	}
            	
            	
            	float nilai_RatePremi = changegetRatelife(selected,"" + tenor,AppConstants.SPINNER_ASURANSIJWPLAN_C,"" + varUmur);
           
                
                jmlPlatfoundKredit = val_ams_txt_platfond_kredit.getText().toString().replace("Rp ", "").replace(".", "").replace(",", ".");
    			// mencari biaya asuransi jiwa
                
    			if((jmlPlatfoundKredit.length() > 0) && (nilai_RatePremi >0) ) {
    				float nilaiRatePer = nilai_RatePremi / 1000;
    				long hitungASJ =(long)( Long.parseLong(jmlPlatfoundKredit) * nilaiRatePer);
    				biayaaslife=(long)hitungASJ;
     				
    				hitungASJ = (long) (hitungASJ + polish);
    				val_ams_txt_biaya_asuransi.setText(formatCurrency("" + hitungASJ));
    			}
           }
            
    	}
    	catch(Exception ex){
    		val_ams_txt_biaya_asuransi.setText("0" );
    		}
	}
	public static int getAge(Date dateOfBirth) throws Exception {

	    Calendar today = Calendar.getInstance();
	    Calendar birthDate = Calendar.getInstance();

	    int age = 0;

	    birthDate.setTime(dateOfBirth);
	    if (birthDate.after(today)) {
	        throw new Exception("Tanggal lahir tidak boleh hari mendatang");
	    }

	    age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

	    // If birth date is greater than todays date (after 2 days adjustment of
	    // leap year) then decrement age one year
	    if ((birthDate.get(Calendar.DAY_OF_YEAR)
	            - today.get(Calendar.DAY_OF_YEAR) > 3)
	            || (birthDate.get(Calendar.MONTH) > today.get(Calendar.MONTH))) {
	        age--;

	        // If birth date and todays date are of same month and birth day of
	        // month is greater than todays day of month then decrement age
	    } else if ((birthDate.get(Calendar.MONTH) == today.get(Calendar.MONTH))
	            && (birthDate.get(Calendar.DAY_OF_MONTH) > today
	                    .get(Calendar.DAY_OF_MONTH))) {
	        age--;
	    }

	    return age;
	}
	public static int getUmur(String tanggal) throws java.text.ParseException {
	    int umur = 0;
	    Date tglLahir = null;
	    long time;
	    try {
	        time = new SimpleDateFormat("dd/MM/yyyy").parse(tanggal).getTime();
	        tglLahir = new Date(time);
	    } catch (ParseException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    try {
	        umur = getAge(tglLahir);

	    } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    return umur;

	}
	private DatePickerDialog.OnDateSetListener PbTglYICSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int monthOfYear, int dayOfMonth) {
        	
        	Ctanggal = dayOfMonth;
        	Cbulan = monthOfYear;
        	Ctahun = year;
        	
        	minimalDateNow(Ctahun, Cbulan, Ctanggal);
        	
        	val_ams_txt_yic.setText(Ctanggal + "-" + (Cbulan + 1) + "-" + Ctahun);
        	
        	hitungUmuryic(Ctahun, Cbulan, Ctanggal);
     
        	
        	
        	
        }
    };
	private DatePickerDialog.OnDateSetListener PbTglLahirDebSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int monthOfYear, int dayOfMonth) {
        	
        	Ctanggal = dayOfMonth;
        	Cbulan = monthOfYear;
        	Ctahun = year;
        	
        	minimalDateNow(Ctahun, Cbulan, Ctanggal);
        	
        	val_ams_txt_tgllhr_deb.setText(Ctanggal + "-" + (Cbulan + 1) + "-" + Ctahun);
        	
        	hitungUmur(Ctahun, Cbulan, Ctanggal);
        	hitungasuransijiwa();
        	hitungasuransikebakaran();
        	
        	val_ams_txt_usia.setText(age_years);
        	val_ams_txt_usia_b.setText(age_months);
        	
        }
    };
    
    private void minimalDateNow(int year, int monthOfYear, int dayOfMonth)
    {
    	
    	boolean cariTanggal = true;
    	Calendar now =  Calendar.getInstance();
    	Calendar tanggallahir = Calendar.getInstance();
    	tanggallahir.set(year, monthOfYear, dayOfMonth);
    	if(now.get(Calendar.YEAR) <= tanggallahir.get(Calendar.YEAR)) {
    		if(now.get(Calendar.MONTH) <= tanggallahir.get(Calendar.MONTH)) {
    			if(now.get(Calendar.DATE) <= tanggallahir.get(Calendar.DATE)) {
    				cariTanggal = false;
        		}
    		}
    	}
    	
    	if(cariTanggal == false) {
    		Ctanggal = now.get(Calendar.DATE);
    		Cbulan = now.get(Calendar.MONTH);
    		Ctahun = now.get(Calendar.YEAR);
    	}
    }
    private void hitungUmuryic(int year, int monthOfYear, int dayOfMonth) 
    {
    	Calendar now =  Calendar.getInstance();
    	Calendar tanggallahir = Calendar.getInstance();
    	tanggallahir.set(year, monthOfYear, dayOfMonth);
    	int years = now.get(Calendar.YEAR) - tanggallahir.get(Calendar.YEAR);
    	int months = now.get(Calendar.MONTH) - tanggallahir.get(Calendar.MONTH);
    	if (months < 0){
    		years --;
    		months +=12;
        }
    	//float years1=years;
    	age_years_yic=""+ years;
    	age_years_mic=""+ months;
    	val_ams_txt_usia_yic.setText(age_years_yic);
    	val_ams_txt_usia_mic.setText(age_years_mic);
    }
    private void hitungUmur(int year, int monthOfYear, int dayOfMonth) 
    {
    	Calendar now =  Calendar.getInstance();
    	Calendar tanggallahir = Calendar.getInstance();
    	tanggallahir.set(year, monthOfYear, dayOfMonth);
    	int years = now.get(Calendar.YEAR) - tanggallahir.get(Calendar.YEAR);
    	int months = now.get(Calendar.MONTH) - tanggallahir.get(Calendar.MONTH);
    	if (months < 0){
    		years --;
    		months +=12;
        }
    	float years1=years;
    	float months1=months;
    	varUmur=Math.round(((years1 * 12) + months1)/12) ;
    	
    	age_years = "" + years;
    	age_months = "" + months;
    }
    public static final int getMonthsDifference(Date date1, Date date2) {
        int m1 = date1.getYear() * 12 + date1.getMonth();
        int m2 = date2.getYear() * 12 + date2.getMonth();
        return m2 - m1 + 1;
    }
    private DatePickerDialog.OnDateSetListener PbTglLahirRelSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int monthOfYear, int dayOfMonth) {
        	
        	Ctanggal = dayOfMonth;
        	Cbulan = monthOfYear;
        	Ctahun = year;
        	minimalDateNow(Ctahun, Cbulan, Ctanggal);
        	
        	val_ams_txt_tgllhr_rel.setText(Ctanggal + "-" + (Cbulan + 1) + "-" + Ctahun);
        }
    };
    public void showAlertString(String messageId) {
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
    
    private void changeKategoriProduct(String selected) {
    	lovDataProvider = new LOVDataProvider();
    	lovJnsPrdct = ListOfValueAdapter.createESAdapterLovWithCode(lovDataProvider.getListOfValueDataDuo(AppConstants.SPINNER_PRODUCTJNS01,selected));

		val_ams_spn_prdct_jns.setListOfValue(lovJnsPrdct, false);
    }
    
    private void changeinsuraceCompany(String selected,String jnsAsuransi) {
      	
    	lovDataProvider = new LOVDataProvider();
    	
    	if(jnsAsuransi.equals("F"))
    	{
    		lovfire = ListOfValueAdapter.createESAdapterLovWithCode(lovDataProvider.getListOfValueDataDuo(AppConstants.SPINNER_ASURANSIFPLAN_A,selected));
        	val_ams_spn_comp_asuransi_fire.setListOfValue(lovfire, false);
    	}
    	else if(jnsAsuransi.equals("L"))
    	{
    		lovlife = ListOfValueAdapter.createESAdapterLovWithCode(lovDataProvider.getListOfValueDataDuo(AppConstants.SPINNER_ASURANSIJWPLAN_A,selected));
    		val_ams_spn_comp_asuransi.setListOfValue(lovlife, false);
    	}
    }
    private void changepromocode(String selected) {
      	
    	lovDataProvider = new LOVDataProvider();
    	
    	lovJnsPromo = ListOfValueAdapter.createESAdapterLovWithCode(lovDataProvider.getListOfValueDataDuo(AppConstants.SPINNER_PROMO_CODE,selected));
    	val_ams_spn_promo_code.setListOfValue(lovJnsPromo, false);
    	
    }
    private void changeJenisProduct(String selected) {

    	lovDataProvider = new LOVDataProvider();
    	lovJnsPrdctSub = ListOfValueAdapter.createESAdapterLovWithCode(lovDataProvider.getListOfValueDataDuo(AppConstants.SPINNER_PRODUCTSUBJNS01,selected));
    	
    	val_ams_spn_prdct_jnssub.setListOfValue(lovJnsPrdctSub, false);
    }
    
    private void changeAsrJw(String selected) {

    	
    	lovDataProvider = new LOVDataProvider();
    	lovPlanAsuransi = ListOfValueAdapter.createESAdapterLovWithCode(lovDataProvider.getListOfValueDataDuo(AppConstants.SPINNER_ASURANSIJWPLAN_B,selected));
    	
    
    	val_ams_spn_plan_asuransi.setListOfValue(lovPlanAsuransi, false);
    }
    
    private void changeAsrFire(String selected) {

    	
    	lovDataProvider = new LOVDataProvider();
    	lovPlanAsuransiFire = ListOfValueAdapter.createESAdapterLovWithCode(lovDataProvider.getListOfValueDataDuo(AppConstants.SPINNER_ASURANSIJWPLAN_B,selected));
    	
   
    	val_ams_spn_plan_asuransi_fire.setListOfValue(lovPlanAsuransiFire, false);
    }
    private float changegetRate(String selected,String tenor,String Group) {
    
    	float result=0;
    	try{
	    	if(Integer.parseInt(tenor) > 0 && selected.length() >0 ){
		    	lovDataProvider = new LOVDataProvider();
		    	lovData = lovDataProvider.getListOfValueDataTrio(Group,selected,tenor);
		    	if(lovData!=null)
		    		result=Float.parseFloat(lovData.getDESCRIPTION());
	    	}
    	}
    	catch(Exception ex){
    		result=0;
    	}
    	return result;
   
    	
    }
    private float changegetRatelife(String selected,String tenor,String Group,String age) {
    	float result=0;
    	try{
    	
	    	if(Integer.parseInt(tenor) > 0 && selected.length() >0 ){
		    	lovDataProvider = new LOVDataProvider();
		    	lovData = lovDataProvider.getListOfValueDataRatelife(Group, tenor, age, selected);
		    	if(lovData!=null)
		    		result=Float.parseFloat(lovData.getDESCRIPTION());
	    	}
    	}
    	catch(Exception ex){
    		result=0;
    	}
    	return result;
   
    	
    }
	private void saveData(String action) 
	{
		calculateBiaya();
		int intCount = 1;
		if(CekMandatory().equals(false)){
			showAlert(R.string.msg_notification_mandatory);
		} else {
	    	if(ID.equals(""))
	    	{
	    		android.text.format.DateFormat df =new android.text.format.DateFormat();
	    		String SID=df.format("yyyyMMddhhmmss", new java.util.Date()).toString();
	    		intCount = amos_entry_debitur_DataProvider.getAllAmos_Entry_Debitur_by_MaxSeq(userid);
	    		amos_debitur_int.setID(userid + SID);
	    		ID=userid + SID;
	    		amos_debitur_int.setSEQ(""+ intCount);
	    		amos_debitur_int.setAP_REGNO("");
				amos_debitur_int.setUSERID(userid);
				Date currentDate = new Date(System.currentTimeMillis());
				
				amos_debitur_int.setAP_CREATEDATE(currentDate);
				amos_debitur_int.setAP_DOCRECVDATE(currentDate);
	    	}
	    	else{
	    		
	    		amos_debitur_int = amos_entry_debitur_DataProvider.getAllAmos_Entry_Debitur_by_seq(ID);
	    		
	    	}
	    	amos_debitur_int.setCH_CODE(val_ams_spn_cus_reff.getSelectedListOfValue().toString());
			amos_debitur_int.setBOOKINGBRANCH(userDetail.getUNIT());
			
			amos_debitur_int.setPR_ID(val_ams_spn_promo_code.getSelectedListOfValue().toString());
			amos_debitur_int.setCU_FULLNM(val_ams_txt_nama_deb.getText().toString());
			amos_debitur_int.setCU_HPNO(val_ams_txt_no_tlp.getText().toString());
			amos_debitur_int.setCU_EMAIL(val_ams_txt_email.getText().toString());
			amos_debitur_int.setCU_KTPADDR1(val_ams_txt_alamat.getText().toString());
			amos_debitur_int.setCU_BORNDATE(DateFormatter.formatDate(val_ams_txt_tgllhr_deb.getText().toString()));
			amos_debitur_int.setCU_USIA_YY(val_ams_txt_usia.getText().toString());
			amos_debitur_int.setCU_JOB_CODE(val_ams_spn_job_type.getSelectedListOfValue().toString());
			amos_debitur_int.setSP_FULLNM(val_ams_txt_nm_rel.getText().toString());
			amos_debitur_int.setSP_BORNDATE(DateFormatter.formatDate(val_ams_txt_tgllhr_rel.getText().toString()));
			amos_debitur_int.setCU_COMPNAME(val_ams_txt_nm_usaha.getText().toString());
			amos_debitur_int.setCU_OFADDR1(val_ams_txt_alamat_usaha.getText().toString());
			amos_debitur_int.setCU_INCOMEMONTH(val_ams_txt_pper_bln.getText().toString().replace("Rp ", "").replace(".", "").replace(",", "."));
			amos_debitur_int.setINCOME(val_ams_txt_pengendapan.getText().toString().replace("Rp ", "").replace(".", "").replace(",", "."));
			amos_debitur_int.setOTHINSTALLMENT(val_ams_txt_ex_lblt.getText().toString().replace("Rp ", "").replace(".", "").replace(",", "."));
			amos_debitur_int.setPRODCATID(val_ams_spn_prdct_kat.getSelectedListOfValue().toString());
			amos_debitur_int.setPRODUCTID(val_ams_spn_prdct_jns.getSelectedListOfValue().toString());
			amos_debitur_int.setSUBPRODUCTID(val_ams_spn_prdct_jnssub.getSelectedListOfValue().toString());
			amos_debitur_int.setCOL_CODE(val_ams_spn_jns_jaminan.getSelectedListOfValue().toString());
			amos_debitur_int.setLINS_COMP(val_ams_spn_comp_asuransi.getSelectedListOfValue().toString());
			amos_debitur_int.setLINS_PLAN(val_ams_spn_plan_asuransi.getSelectedListOfValue().toString());
			
			
			amos_debitur_int.setPURCHASE_PRICE(val_ams_txt_hrg_rumah.getText().toString().replace("Rp ", "").replace(".", "").replace(",", "."));
			amos_debitur_int.setCP_DOWNPAYMENT_PCT(val_ams_txt_down_pay.getText().toString().replace("Rp ", "").replace(".", "").replace(",", "."));
			amos_debitur_int.setCP_INTEREST(val_ams_txt_suku_bng.getText().toString());
			amos_debitur_int.setCP_TENOR(val_ams_txt_jw_kredit_perbln.getText().toString());
		
			
			amos_debitur_int.setCP_INSTALLMENT(val_ams_txt_cicilan.getText().toString().replace("Rp ", "").replace(".", "").replace(",", "."));
			amos_debitur_int.setCP_LTV(val_ams_txt_ltv.getText().toString());
			amos_debitur_int.setIIR_IDR(val_ams_txt_iir_dbr.getText().toString());
			amos_debitur_int.setCP_LIMIT(val_ams_txt_platfond_kredit.getText().toString().replace("Rp ", "").replace(".", "").replace(",", "."));
			amos_debitur_int.setPROVISION(val_ams_txt_provisi.getText().toString().replace("Rp ", "").replace(".", "").replace(",", "."));
			amos_debitur_int.setADMINFEE(val_ams_txt_biaya_administrasi.getText().toString().replace("Rp ", "").replace(".", "").replace(",", "."));
			amos_debitur_int.setLINS_PREMI((""+biayaaslife).toString().replace("Rp ", "").replace(".", "").replace(",", "."));
			
			amos_debitur_int.setNOTACHARGE(val_ams_txt_biaya_notaris.getText().toString().replace("Rp ", "").replace(".", "").replace(",", "."));
			amos_debitur_int.setPPHTFEE(val_ams_txt_biaya_ppht.getText().toString().replace("Rp ", "").replace(".", "").replace(",", "."));
			
			amos_debitur_int.setCU_USIA_MM(val_ams_txt_usia_b.getText().toString());
			amos_debitur_int.setLINS_POLICYFEEFIRE((""+polishasfire).toString().replace("Rp ", "").replace(".", "").replace(",", "."));
			amos_debitur_int.setFINS_POLICYFEELIFE((""+polishaslife).toString().replace("Rp ", "").replace(".", "").replace(",", "."));
			
			if((val_ams_spn_jns_jaminan.getSelectedListOfValue().equals("003")) || (val_ams_spn_jns_jaminan.getSelectedListOfValue().equals("004")) || (val_ams_spn_jns_jaminan.getSelectedListOfValue().equals("005"))){
				amos_debitur_int.setCOL_LUAS("");
				amos_debitur_int.setCOL_VALUE("");
				amos_debitur_int.setFINS_COMP("");
				amos_debitur_int.setFINS_PLAN("");
				amos_debitur_int.setFINS_PREMI("");
	    	  }    	 
			else{
				amos_debitur_int.setFINS_PREMI((""+biayaasfire).toString().replace("Rp ", "").replace(".", "").replace(",", "."));
				amos_debitur_int.setCOL_LUAS(val_ams_txt_luas_bangunan.getText().toString());
				amos_debitur_int.setCOL_VALUE(val_ams_txt_hrg_bangunan.getText().toString().replace("Rp ", "").replace(".", "").replace(",", "."));
				amos_debitur_int.setFINS_COMP(val_ams_spn_comp_asuransi_fire.getSelectedListOfValue().toString());
				amos_debitur_int.setFINS_PLAN(val_ams_spn_plan_asuransi_fire.getSelectedListOfValue().toString());
			}
			
			amos_debitur_int.setCU_WORKSINCE_YY(DateFormatter.formatDate(val_ams_txt_yic.getText().toString()));
			amos_debitur_int.setCU_WORKSINCE_YY_INT(val_ams_txt_usia_yic.getText().toString());
			amos_debitur_int.setCU_WORKSINCE_MM_INT(val_ams_txt_usia_mic.getText().toString());
			
			amos_debitur_int.setCU_ED_CODE(val_ams_spn_el.getSelectedListOfValue().toString());
			amos_debitur_int.setCU_COMPSCALE(val_ams_spn_soc.getSelectedListOfValue().toString());
			if(val_rtb_rdo_sex_male.isChecked())
				amos_debitur_int.setCU_GENDER_CODE("L");
			else if(val_rtb_rdo_sex_female.isChecked())
				amos_debitur_int.setCU_GENDER_CODE("P");
			
			amos_debitur_int.setLP_CODE(val_ams_spn_ap.getSelectedListOfValue().toString());
			amos_entry_debitur_DataProvider.updateData(amos_debitur_int);
			
			if(action.equals("Save")) {
				showAlert(R.string.msg_notification_update_success);
//				btnDelete.setVisibility(View.VISIBLE);
			} else if(action.equals("Submit")) {
				try{
					btnSubmit.setEnabled(false);
					btnSave.setEnabled(false);
					btnCancel.setEnabled(false);
					btn_submit_score.setEnabled(false);
//					btnDelete.setEnabled(false);
					
					
					
					new SubmittedData().execute();
					
					//String score=SubmittedAmos();
					
					/*lovDataProvider = new LOVDataProvider();
	                lovData=lovDataProvider.getLOVDetail(score, AppConstants.SPINNER_SCORE);
	               
					if(score.equals("1")||score.equals("2")){
						//showAlertString("Data Berhasil disubmit hasil scoring : " + lovData.getDESCRIPTION());
						val_ams_txt_hasil_scoring.setText(lovData.getDESCRIPTION());
						
						amos_entry_debitur_DataProvider.deleteTransaksiById(ID);
						newData();
						
						ActivityHandler.gotoActivity(ctx, HomeActivity.class, null);
				        getActivity().finish();
                	}
                	else{
                		 if(lovData!=null){
     	                	showAlertString("Data Gagal disubmit karena hasil scoring : " + lovData.getDESCRIPTION());
                			 val_ams_txt_hasil_scoring.setText(lovData.getDESCRIPTION());	
     	                }
                		
                	}*/
            		
        		}
            	catch(Exception ex){
            		showAlert(R.string.msg_notification_update_error);
            	}
			}
			
			else{
				try{
					String score=SubmittedAmosScore();
					
					lovDataProvider = new LOVDataProvider();
	                lovData=lovDataProvider.getLOVDetail(score, AppConstants.SPINNER_SCORE);
	                if(lovData!=null){
	                	//showAlertString("Hasil Scoring : " + lovData.getDESCRIPTION());
//	                	if(score.equals("1")||score.equals("2")){
	                		btnSubmit.setVisibility(View.VISIBLE);
//	                		btnDelete.setVisibility(View.VISIBLE);
//	                	}
//	                	else{
//	                		btnSubmit.setVisibility(View.GONE);
//	                	}
	                	val_ams_txt_hasil_scoring.setText(lovData.getDESCRIPTION());	
	                }
					
        		}
            	catch(Exception ex){
            		showAlert(R.string.msg_notification_update_error);
            	}
			}
			
		}
		
	}
	 public void showConfirmationDelete(final String id) {
	       AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctx);
	       alertDialog.setTitle("Confirm");
	       alertDialog.setMessage(R.string.msg_notification_delete);
	       alertDialog.setPositiveButton(R.string.str_yes, new DialogInterface.OnClickListener() {
	           public void onClick(DialogInterface dialog, int which) {
	           	try {
	           		amos_entry_debitur_DataProvider.deleteTransaksiById(id);
	           		newData();
//	           		btnDelete.setVisibility(View.GONE);
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
	 public void showConfirmationSubmitScore(final boolean isparent,final String id) {
		 
		 AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctx);
		 alertDialog.setTitle("Confirm");
		 alertDialog.setMessage(R.string.msg_notification_scoreAmos);
		 alertDialog.setPositiveButton(R.string.str_yes, new DialogInterface.OnClickListener() {
			 ProgressDialog dialogSubmit = ProgressDialog.show(ctx, "Loading", "Please wait...", true);
			 public void onClick(DialogInterface dialog, int which) {
				 dialog.dismiss();
				 
				 try {
					 saveData("Score");
//					 dialogSubmit.dismiss();
			//	           		btnDelete.setVisibility(View.VISIBLE);
				 } catch (Exception e) {
				// TODO Auto-generated catch block
					 dialogSubmit.dismiss();
					 e.printStackTrace();
				 }
				 dialogSubmit.dismiss();
			 }
		 });
	
	   // on pressing cancel button
		 alertDialog.setNegativeButton(R.string.str_no, new DialogInterface.OnClickListener() {
			 public void onClick(DialogInterface dialog, int which) {
				 dialog.cancel();
			 }
		 });
//		 dialogSubmit.dismiss();
		 alertDialog.show();
	 }
	 
	 public void showConfirmationSubmit(final boolean isparent,final String id) {
		 AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctx);
		 alertDialog.setTitle("Confirm");
		 alertDialog.setMessage(R.string.msg_notification_submitAmos);
		 alertDialog.setPositiveButton(R.string.str_yes, new DialogInterface.OnClickListener() {
			 public void onClick(DialogInterface dialog, int which) {
			 try {
				 saveData("Submit");	
			 } catch (Exception e) {
						// TODO Auto-generated catch block
				 e.printStackTrace();
			 }

//	               dialog.dismiss();
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
	 
	 private void loadData(Bundle b) 
	 {
		String num_id = (String)b.get("ID");
		ID=num_id;
        amos_debitur_int = amos_entry_debitur_DataProvider.getAllAmos_Entry_Debitur_by_seq(num_id);
        if(amos_debitur_int != null) {
//        	btnDelete.setVisibility(View.VISIBLE);
        	
        	
        	val_ams_txt_seq.setText(amos_debitur_int.getSEQ().toString());
            val_ams_txt_nama_deb.setText(amos_debitur_int.getCU_FULLNM().toString());
        	val_ams_txt_no_tlp.setText(amos_debitur_int.getCU_HPNO().toString());
        	val_ams_txt_email.setText(amos_debitur_int.getCU_EMAIL().toString());
        	
        	val_ams_txt_alamat.setText(amos_debitur_int.getCU_KTPADDR1().toString());
        	try {
        		val_ams_txt_tgllhr_deb.setText(DateFormatter.formatString(amos_debitur_int.getCU_BORNDATE()));
        	} catch (Exception ex) {
        		val_ams_txt_tgllhr_deb.setText("");
        	}
        	
        	val_ams_txt_usia.setText(amos_debitur_int.getCU_USIA_YY().toString());
        	val_ams_txt_usia_b.setText(amos_debitur_int.getCU_USIA_MM().toString());
        	val_ams_spn_job_type.setSelectedListOfValue(amos_debitur_int.getCU_JOB_CODE());
        	
        	val_ams_txt_nm_rel.setText(amos_debitur_int.getSP_FULLNM().toString());
    		val_ams_txt_tgllhr_rel = (EditText) view.findViewById(R.id.val_ams_txt_tgllhr_rel);
    		
    		try {
    			val_ams_txt_tgllhr_rel.setText(DateFormatter.formatString(amos_debitur_int.getSP_BORNDATE()));
        	} catch (Exception ex) {
        		val_ams_txt_tgllhr_rel.setText("");
        	}
    		
    		val_ams_txt_nm_usaha.setText(amos_debitur_int.getCU_COMPNAME().toString());
    		val_ams_txt_alamat_usaha.setText(amos_debitur_int.getCU_OFADDR1().toString());
    		val_ams_txt_pper_bln.setText(formatCurrency(amos_debitur_int.getCU_INCOMEMONTH()));
    		val_ams_txt_pengendapan.setText(formatCurrency(amos_debitur_int.getINCOME()));
    		val_ams_txt_ex_lblt.setText(amos_debitur_int.getOTHINSTALLMENT().toString());
    		val_ams_txt_usia_yic.setText(amos_debitur_int.getCU_WORKSINCE_YY_INT().toString());
    		val_ams_txt_usia_mic.setText(amos_debitur_int.getCU_WORKSINCE_MM_INT().toString());
    		val_ams_spn_prdct_kat.setSelectedListOfValue(amos_debitur_int.getPRODCATID());
            
    		String selected = (String) val_ams_spn_prdct_kat.getSelectedListOfValue().toString();
            if (!selected.equalsIgnoreCase("")) {
            	changeKategoriProduct(selected);
            	val_ams_spn_prdct_jns.setSelectedListOfValue(amos_debitur_int.getPRODUCTID());
            }
            /*kategori_produk=amos_debitur_int.getPRODCATID();
        	jenis_produk=amos_debitur_int.getPRODUCTID();
        	sub_produk=amos_debitur_int.getSUBPRODUCTID();
            */
        	selected = amos_debitur_int.getPRODUCTID();
            if (!selected.equalsIgnoreCase("")) {
            	changeJenisProduct(selected);
            	changeinsuraceCompany(selected, "L");
            	changeinsuraceCompany(selected, "F");
            	changepromocode(selected);
            	
            	val_ams_spn_prdct_jns.setSelectedListOfValue(amos_debitur_int.getPRODUCTID());
            	val_ams_spn_prdct_jnssub.setSelectedListOfValue(amos_debitur_int.getSUBPRODUCTID());
            	val_ams_spn_comp_asuransi.setSelectedListOfValue(amos_debitur_int.getLINS_COMP());
            	val_ams_spn_comp_asuransi_fire.setSelectedListOfValue(amos_debitur_int.getFINS_COMP());
            	val_ams_spn_promo_code.setSelectedListOfValue(amos_debitur_int.getPR_ID());
            }
            
            val_ams_spn_jns_jaminan.setSelectedListOfValue(amos_debitur_int.getCOL_CODE());
            
            String parent = val_ams_spn_comp_asuransi.getSelectedListOfValue().toString();
            
            lovDataProvider = new LOVDataProvider();
            lovData=lovDataProvider.getLOVDetail(parent, AppConstants.SPINNER_ASURANSIJWPLAN_A);
            if(lovData!=null){
            	 if (!lovData.getPARENT_2().equalsIgnoreCase("")) {
                	changeAsrJw(lovData.getPARENT_2().toString());
                }
                val_ams_spn_plan_asuransi.setSelectedListOfValue(amos_debitur_int.getLINS_PLAN());    
            }
            
            parent = val_ams_spn_comp_asuransi_fire.getSelectedListOfValue().toString();
            lovDataProvider = new LOVDataProvider();
            lovData=lovDataProvider.getLOVDetail(parent, AppConstants.SPINNER_ASURANSIFPLAN_A);
            if(lovData!=null){
                if (!lovData.getPARENT_2().equalsIgnoreCase("")) {
                	 changeAsrFire(lovData.getPARENT_2().toString());
                } 
                val_ams_spn_plan_asuransi_fire.setSelectedListOfValue(amos_debitur_int.getFINS_PLAN());
                
            }
            
            
            val_ams_txt_hrg_rumah.setText(formatCurrency(amos_debitur_int.getPURCHASE_PRICE()));
    		val_ams_txt_down_pay.setText(formatCurrency(amos_debitur_int.getCP_DOWNPAYMENT_PCT().toString()));
    		val_ams_txt_suku_bng.setText(amos_debitur_int.getCP_INTEREST().toString());
    		val_ams_txt_jw_kredit_perbln.setText(amos_debitur_int.getCP_TENOR().toString());
    		val_ams_txt_luas_bangunan.setText(amos_debitur_int.getCOL_LUAS().toString());
    		val_ams_txt_hrg_bangunan.setText(formatCurrency(amos_debitur_int.getCOL_VALUE()));
    		val_ams_txt_cicilan.setText(formatCurrency(amos_debitur_int.getCP_INSTALLMENT()));
    		val_ams_txt_ltv.setText(amos_debitur_int.getCP_LTV().toString());
    		val_ams_txt_iir_dbr.setText(amos_debitur_int.getIIR_IDR().toString());
    		val_ams_txt_platfond_kredit.setText(formatCurrency(amos_debitur_int.getCP_LIMIT()));
    		val_ams_txt_provisi.setText(formatCurrency(amos_debitur_int.getPROVISION()));
    		val_ams_txt_biaya_administrasi.setText(formatCurrency(amos_debitur_int.getADMINFEE()));
    		val_ams_txt_biaya_notaris.setText(formatCurrency(amos_debitur_int.getNOTACHARGE()));
    		val_ams_txt_biaya_ppht.setText(formatCurrency(amos_debitur_int.getPPHTFEE()));
    		int years1 =Integer.parseInt(amos_debitur_int.getCU_USIA_YY().toString());
        	int months1= Integer.parseInt(amos_debitur_int.getCU_USIA_MM().toString());
    		varUmur=Math.round(((years1 * 12) + months1)/12) ;
    		
    		val_ams_spn_cus_reff.setSelectedListOfValue(amos_debitur_int.getCH_CODE());
    		val_ams_spn_el.setSelectedListOfValue(amos_debitur_int.getCU_ED_CODE());
    		val_ams_spn_soc.setSelectedListOfValue(amos_debitur_int.getCU_COMPSCALE());
    		val_ams_spn_ap.setSelectedListOfValue(amos_debitur_int.getLP_CODE());
    		
    		if(amos_debitur_int.getCU_GENDER_CODE().equals("L") )
    			val_rtb_rdo_sex_male.setChecked(true);
			else if(amos_debitur_int.getCU_GENDER_CODE().equals("P") )
				val_rtb_rdo_sex_female.setChecked(true);
    		try {
    		val_ams_txt_yic.setText(DateFormatter.formatString(amos_debitur_int.getCU_WORKSINCE_YY()));
    		}
    		catch(Exception es)
    		{}
    		hitungabr();
		
			
			
    		try{
    			val_ams_txt_biaya_asuransi.setText(formatCurrency(""+ (Long.parseLong(""+ amos_debitur_int.getLINS_PREMI().toString()) + Long.parseLong(""+ amos_debitur_int.getFINS_POLICYFEELIFE().toString()))));
    		    val_ams_txt_biaya_asuransi_fire.setText(formatCurrency(""+ (Long.parseLong(""+ amos_debitur_int.getFINS_PREMI().toString())+ Long.parseLong(""+ amos_debitur_int.getLINS_POLICYFEEFIRE().toString()))));

    			polishasfire=Long.parseLong(""+ amos_debitur_int.getLINS_POLICYFEEFIRE().toString());
    			polishaslife=Long.parseLong(""+ amos_debitur_int.getFINS_POLICYFEELIFE().toString());
    			biayaasfire=Long.parseLong(""+ amos_debitur_int.getFINS_PREMI().toString());
    			biayaaslife=Long.parseLong(""+ amos_debitur_int.getLINS_PREMI().toString());
    			calculateBiaya();
    		}
    		catch(Exception es)
    		{
    			
    		}
        }
 /*       else{
        	btnDelete.setVisibility(View.GONE);
        }*/
        //onload=false;
	}
	
	private void newData() {
		ID="";
		val_ams_txt_biaya_ppht.setText("");
		val_ams_txt_hasil_scoring.setText("");
		val_ams_txt_seq.setText("");
        val_ams_txt_nama_deb.setText("");
    	val_ams_txt_no_tlp.setText("");
    	val_ams_txt_email.setText("");
    	val_ams_txt_tgllhr_deb.setText("");
    	
    	val_ams_txt_usia.setText("");
    	val_ams_txt_usia_b.setText("");
    	val_ams_txt_alamat.setText("");
//    	val_ams_spn_job_type.setListOfValue(new ArrayList<ISpinnerItem>(), false);
    	
    	val_ams_txt_nm_rel.setText("");
		val_ams_txt_tgllhr_rel.setText("");
    	
		val_ams_txt_nm_usaha.setText("");
		val_ams_txt_alamat_usaha.setText("");
		val_ams_txt_pper_bln.setText("");
		val_ams_txt_pengendapan.setText("");
		val_ams_txt_ex_lblt.setText("");
		
		val_ams_spn_ap.setSelectedListOfValue("");
		val_ams_spn_prdct_kat.setSelectedListOfValue("");
		val_ams_spn_prdct_jns.setSelectedListOfValue("");
		val_ams_spn_prdct_jnssub.setSelectedListOfValue("");
		val_ams_spn_jns_jaminan.setSelectedListOfValue("");
		val_ams_spn_comp_asuransi.setSelectedListOfValue("");
//		val_ams_spn_plan_asuransi.setSelectedListOfValue("");
		val_ams_spn_plan_asuransi.setListOfValue(new ArrayList<ISpinnerItem>(), false);
		val_ams_spn_comp_asuransi_fire.setSelectedListOfValue("");
//		val_ams_spn_plan_asuransi_fire.setSelectedListOfValue("");
		val_ams_spn_plan_asuransi_fire.setListOfValue(new ArrayList<ISpinnerItem>(), false);
		val_ams_spn_promo_code.setSelectedListOfValue("");
		val_ams_spn_el.setSelectedListOfValue("");
		val_ams_spn_cus_reff.setSelectedListOfValue("");
		val_ams_spn_soc.setSelectedListOfValue("");
		val_ams_spn_job_type.setSelectedListOfValue("");
		
        val_ams_txt_hrg_rumah.setText("");
		val_ams_txt_down_pay.setText("");
		val_ams_txt_suku_bng.setText("");
		val_ams_txt_jw_kredit_perbln.setText("");
		val_ams_txt_luas_bangunan.setText("");
		val_ams_txt_hrg_bangunan.setText("");
		val_ams_txt_cicilan.setText("");
		val_ams_txt_ltv.setText("");
		val_ams_txt_iir_dbr.setText("");
		val_ams_txt_platfond_kredit.setText("");
		val_ams_txt_provisi.setText("");
		val_ams_txt_biaya_administrasi.setText("");
		val_ams_txt_biaya_asuransi.setText("");
		val_ams_txt_biaya_asuransi_fire.setText("");
		val_ams_txt_biaya_notaris.setText("");
		val_ams_txt_abr.setText("");
		val_ams_txt_usia_yic.setText("");
		val_ams_txt_usia_mic.setText("");
		val_ams_txt_yic.setText("");
	}
	
	private void hitungabr() 
	{
		float nilaiPangkat, nilaiPlatfond, nilaiSuku;
		
		try{
			
			
			float gabungan=Float.parseFloat(val_ams_txt_ex_lblt.getText().toString().replace("Rp ", "").replace(".", "").replace(",", ".")) + Float.parseFloat(val_ams_txt_cicilan.getText().toString().replace("Rp ", "").replace(".", "").replace(",", "."));
			
			double hasil=0;
			if(gabungan >0)
			{
				float CU_AVGFUND=  Float.parseFloat(val_ams_txt_pengendapan.getText().toString().replace("Rp ", "").replace(".", "").replace(",", "."));
				hasil=roundNilai(CU_AVGFUND/gabungan,2);
			}
			
			val_ams_txt_abr.setText("" + hasil);
		} catch(Exception ex){}
		
	
		
	}
	
	private void hitung()
	{
		float nilaiPangkat, nilaiPlatfond, nilaiSuku;
		
		try{
			jmlSukuBunga = val_ams_txt_suku_bng.getText().toString();
			jmlJ_W_Kredit = val_ams_txt_jw_kredit_perbln.getText().toString().replace("Rp ", "").replace(".", "").replace(",", ".");
			jmlPlatfoundKredit = val_ams_txt_platfond_kredit.getText().toString().replace("Rp ", "").replace(".", "").replace(",", ".");
			
			// mencari nilai cicilan
			if(!jmlSukuBunga.equals("") && !jmlJ_W_Kredit.equals("") && !jmlPlatfoundKredit.equals("")) {
				
				nilaiPangkat = Float.parseFloat(jmlJ_W_Kredit);
				nilaiPlatfond = Float.parseFloat(jmlPlatfoundKredit);
				nilaiSuku = Float.parseFloat(jmlSukuBunga);
				
				String hasilCICILAN = "" + dbgetInstallment(nilaiPlatfond, nilaiSuku, nilaiPangkat);
				
				val_ams_txt_cicilan.setText(formatCurrency(hasilCICILAN));
				hitungabr();
			} else {
				val_ams_txt_cicilan.setText("");
			}
		} catch(Exception ex){}
		
		hitungIIRDbr();
		hitungLtV();
		
	}
	
	private void hitungPlatfond() {
		Long platfound;
		Long totalPlatfound = Long.parseLong(""+ 0);
		try{
			downPayment = val_ams_txt_down_pay.getText().toString().replace("Rp ", "").replace(".", "").replace(",", ".");
			jmlHargaRumah = val_ams_txt_hrg_rumah.getText().toString().replace("Rp ", "").replace(".", "").replace(",", ".");
			
			if(!jmlHargaRumah.equals("")) {
				if(downPayment.equals("")) {
					platfound = Long.parseLong("0");
				} else {
					platfound = Long.parseLong(downPayment);// (Long.parseLong(jmlHargaRumah) * Long.parseLong(downPayment)) / 100;
				}
				
				totalPlatfound = Long.parseLong(jmlHargaRumah) - platfound;
				val_ams_txt_platfond_kredit.setText(formatCurrency("" + totalPlatfound));
			} else {
				val_ams_txt_platfond_kredit.setText("");
			}
			
			if(totalPlatfound > 0) {
				hitung();
	        	hitungBiayaNotaris();
	        	hitungProvisi();
	        	hitungBiayaAdmin();
	        	hitungasuransijiwa();
	        	hitungBiayaPpht();
			}
			
			
		} catch(Exception ex){}
	}
	
	private void hitungIIRDbr() {
		
		float ncicilan, hitungDBR,hitungIIR;
		
		try{
			jmlCicilan = val_ams_txt_cicilan.getText().toString().replace("Rp ", "").replace(".", "").replace(",", ".");
			jmlPenPerBln = val_ams_txt_pper_bln.getText().toString().replace("Rp ", "").replace(".", "").replace(",", ".");
			jmlExLiabilities = val_ams_txt_ex_lblt.getText().toString().replace("Rp ", "").replace(".", "").replace(",", ".");
			
			ncicilan = Float.parseFloat(jmlCicilan);
			
			String nilaiCicilan = "" + ncicilan;
		// mencari iir & dbr
			if (!nilaiCicilan.equals("") && !jmlPenPerBln.equals("")){
				
				
				//if(!jmlExLiabilities.equals("")) {
					hitungDBR = ((ncicilan + Float.parseFloat(jmlExLiabilities)) / Float.parseFloat(jmlPenPerBln)) * 100;
				//} else {
					hitungIIR = (ncicilan / Float.parseFloat(jmlPenPerBln)) * 100;
				//}
				val_ams_txt_iir_dbr.setText("" + roundNilai(hitungIIR, 2) +"/"  + roundNilai(hitungDBR, 2));
				
		   	}	else {
		   		val_ams_txt_iir_dbr.setText("0");
		   	}
		} catch(Exception ex){}
	}
	
	private void hitungLtV() {
		float hitungL_T_V;
		
		try{
			jmlHargaRumah = val_ams_txt_hrg_rumah.getText().toString().replace("Rp ", "").replace(".", "").replace(",", ".");
			jmlPlatfoundKredit = val_ams_txt_platfond_kredit.getText().toString().replace("Rp ", "").replace(".", "").replace(",", ".");
			// mecari loan
			if(!jmlHargaRumah.equals("") && !jmlPlatfoundKredit.equals("")) {
				hitungL_T_V = (Float.parseFloat(jmlPlatfoundKredit) / Float.parseFloat(jmlHargaRumah)) * 100;
				val_ams_txt_ltv.setText("" +  roundNilai(hitungL_T_V, 2));
			} else {
				val_ams_txt_ltv.setText("0");
			}
		} catch(Exception ex){}
	}
	
	public static double roundNilai(float value, float places) {
		if (places < 0) throw new IllegalArgumentException();
		
		long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	
	public static double power(double number, double power) {
    	double result = 1;
    	  if(power > 0) {
    	    for(int i = 0; i < power; i++) {
    	      result *= number;
    	    }
    	  }
    	  return result;
    }
	
    public static long dbgetInstallment(float platfond, float bunga,float tenor) {
    	double result = 0;
    	double dbungaTahun=(bunga/100)/12;
    	
    	double dtenor=tenor;
    	double powervalue=power(1+ dbungaTahun ,dtenor);
    	if((powervalue - 1) == 0 )
    	{
    		result=0;
    	}
    	else{
    		result=	(platfond * dbungaTahun * powervalue) / ( powervalue -1);
    	}
    	return Long.parseLong("" + Math.round(result));
    }
	
	private Double pangkatx(String msnilai, String mspangkat) {
		Double hasilPangkat, msNilai, msPangkat;
		
		msNilai = Double.parseDouble(msnilai);
		msPangkat = Double.parseDouble(mspangkat);
		
		if(msPangkat == 0 || mspangkat.toString().equals("")) {
			hasilPangkat = Double.parseDouble("1");
		} else {
			hasilPangkat = msNilai * pangkatx((""+msNilai), (""+(msPangkat-1)));
		}
		
		return hasilPangkat;
	}
	
	private String bagiPerTahun() {
		Double nilai = (Double.parseDouble(val_ams_txt_suku_bng.getText().toString())/100) / 12 + 1;
//		Long ConvertNilai = (new Double(nilai)).longValue();
		return ""+nilai;
	}
	
	private void hitungBiayaNotaris() 
	{
		lovDataArray_1 = lovDataProvider.getListOfValueData(AppConstants.NOTARIS);
		long notaris = 0, pkcharge = 0, phkjcharge= 0;
		Long nilaiBiayaPlatfon = Long.parseLong(val_ams_txt_platfond_kredit.getText().toString().replace("Rp ", "").replace(".", "").replace(",", "."));
		for(int y = 0; lovDataArray_1.size()>y;y++) {
			String MaxLimit = lovDataArray_1.get(y).getPARENT_2();
			String MinLimit = lovDataArray_1.get(y).getPARENT();
			String CurrentNotaris = lovDataArray_1.get(y).getDESCRIPTION();
			
			
			String[] feesplit = CurrentNotaris.split("#");
			String fee1 = feesplit[0];
			String fee2 = feesplit[1];
			String fee3 = feesplit[2];
			
			
			if(Long.parseLong(fee1) > 0) {
				pkcharge = Long.parseLong(fee1);
			} else {
				Double nilaiFee_pct = Double.parseDouble(fee3);
				pkcharge = (long) (nilaiBiayaPlatfon * (nilaiFee_pct / 1000));
			}
			
			if(Long.parseLong(fee2) > 0) {
				phkjcharge = Long.parseLong(fee2);
			} else {
				phkjcharge = Long.parseLong("0");
			}
			
			if(Long.parseLong(MinLimit) <= nilaiBiayaPlatfon) {
				if(Long.parseLong(MaxLimit) >= nilaiBiayaPlatfon) {
					notaris = pkcharge;
					break;
				}
			}
			
		}
		val_ams_txt_biaya_notaris.setText("" + notaris);
	}
	
	private void hitungBiayaPpht()
	{
		lovDataProvider = new LOVDataProvider();
		
		lovDataSingle_1 = lovDataProvider.getLOVDetail(AppConstants.CODE_PPHT, AppConstants.PPHT);
		
		lovDataArray_1 = lovDataProvider.getListOfValueData(AppConstants.PPHTFEE);
		lovDataArray_2 = lovDataProvider.getListOfValueData(AppConstants.APHTFEE);
		
		Long nilaiBiayaPlatfon = Long.parseLong(val_ams_txt_platfond_kredit.getText().toString().replace("Rp ", "").replace(".", "").replace(",", "."));
		
		Double pengalipertanggungan = 0.0;
		long nilai_fee_ppht = 0;
		long nilai_fee_apht = 0;
		long nilai_akhir = 0;
		
		try{
			pengalipertanggungan =  Double.parseDouble(lovDataSingle_1.getPARENT().toString());
        }
        catch(Exception ex){ }
		
		long hitungan_awal = (long) (nilaiBiayaPlatfon * pengalipertanggungan / 100);
		
		for(int y = 0; lovDataArray_1.size()>y;y++) {
			
			if(Long.parseLong(lovDataArray_1.get(y).getPARENT()) <= hitungan_awal) {
				if(Long.parseLong(lovDataArray_1.get(y).getPARENT_2()) >= hitungan_awal) {
					String DescFee = lovDataArray_1.get(y).getDESCRIPTION();
					
					String[] feesplit = DescFee.split("#");
					long fee1 = (long) Long.parseLong(feesplit[0]);
					String fee2 = feesplit[1];
					if(fee1 == 0) {
						nilai_fee_ppht =(long) ((Double.parseDouble(fee2) / 1000) * hitungan_awal);
						break;
					} else {
						nilai_fee_ppht = fee1;
						break;
					}
				}
			}
		}
		
		for(int y = 0; lovDataArray_2.size()>y;y++) {
			
			if(Long.parseLong(lovDataArray_2.get(y).getPARENT()) <= hitungan_awal) {
				if(Long.parseLong(lovDataArray_2.get(y).getPARENT_2()) >= hitungan_awal) {
					String DescFee = lovDataArray_2.get(y).getDESCRIPTION();
					
					String[] feesplit = DescFee.split("#");
					String fee1 = feesplit[0];
					String fee2 = feesplit[1];
					
					if(Long.parseLong(fee1) == 0) {
						Double nilaiFee_pct = Double.parseDouble(fee2);
						nilai_fee_apht = (long) (hitungan_awal * (nilaiFee_pct / 1000));
						break;
					} else {
						nilai_fee_apht = Long.parseLong(fee1);
						break;
					}
				}
			}
		}
		
		nilai_akhir = nilai_fee_ppht + nilai_fee_apht;
		
		val_ams_txt_biaya_ppht.setText("" + nilai_akhir);
	}
	
	private void hitungProvisi() {
		if(!val_ams_txt_platfond_kredit.getText().toString().equals("")) {
			Long nilaiBiayaNotaris = Long.parseLong(val_ams_txt_platfond_kredit.getText().toString().replace("Rp ", "").replace(".", "").replace(",", "."));
			val_ams_txt_provisi.setText(formatCurrency("" + (nilaiBiayaNotaris * 1/100)));
		}
	}
	
	private void hitungBiayaAdmin() 
	{
		lovDataProvider = new LOVDataProvider();
		
		lovDataSingle_1 = lovDataProvider.getLOVDetail(AppConstants.CODE_ADMIN, AppConstants.ADMIN);
		lovDataSingle_2 = lovDataProvider.getLOVDetail(AppConstants.CODE_ADMIN_MIN, AppConstants.ADMIN_MIN);
		
		Long nilaiBiayaPlatfon = Long.parseLong(val_ams_txt_platfond_kredit.getText().toString().replace("Rp ", "").replace(".", "").replace(",", "."));
		
        Double rate = 0.0;
        long feeadmin = 0;
        long feeadmins = 0;
        try{
        	rate =  Double.parseDouble(lovDataSingle_1.getPARENT().toString()); //persen
        }
        catch(Exception ex){ }
        try{
        	feeadmin = Long.parseLong(lovDataSingle_2.getPARENT().toString()); // biaya minimal
        }
        catch(Exception ex){ }
        
        feeadmins = (long) (nilaiBiayaPlatfon * rate / 100);
        
        if(feeadmin < feeadmins) {
        	biayaadmin = (long) feeadmins;
        } else {
        	biayaadmin = (long) feeadmin;
        }
//		Long hasilHitung;
//		Long nilaiBiayaNotaris = Long.parseLong(val_ams_txt_platfond_kredit.getText().toString().replace("Rp ", "").replace(".", "").replace(",", "."));
//		Long hitungBiaya = nilaiBiayaNotaris * 1/100;
//		if(hitungBiaya <= 400000) {
//			hasilHitung = Long.parseLong(""+400000);
//		} else {
//			hasilHitung = hitungBiaya;
//		}
		val_ams_txt_biaya_administrasi.setText(formatCurrency("" + biayaadmin));
	}
	
	private void calculateBiaya() {
		try{
			hitungPlatfond();
			hitungBiayaAdmin();
			hitungBiayaNotaris();
			hitungIIRDbr();
			hitungLtV();
			hitungasuransijiwa();
			hitungasuransikebakaran();
			hitungBiayaPpht();
		} catch(Exception ex){ }
	}
	
	public void updateSpiner() {
		lovDataProvider = new LOVDataProvider();
    	lovDataProvider.deleteAllTabungan();
		lovDataProvider.update(new LovData("1", "EMP", "Pegawai", "AMSO1", "1", "", ""));
		lovDataProvider.update(new LovData("2", "MOM", "Ibu Rumah Tangga", "AMSO1", "1", "", ""));
		lovDataProvider.update(new LovData("3", "PRO", "Profesional", "AMSO1", "1", "", ""));
		lovDataProvider.update(new LovData("4", "RET", "Pensiunan", "AMSO1", "1", "", ""));
		lovDataProvider.update(new LovData("5", "PNG", "Pengusaha", "AMSO1", "1", "", ""));
		lovDataProvider.update(new LovData("6", "STU", "Pelajar", "AMSO1", "1", "", ""));
		lovDataProvider.update(new LovData("7", "NON", "Tidak Bekerja", "AMSO1", "1", "", ""));
		
		lovDataProvider.update(new LovData("9","KP","Kredit Properti","AMSO2", "1", "", ""));
		lovDataProvider.update(new LovData("10","KPM","Kredit Properti Multigua","AMSO2", "1", "", ""));
		lovDataProvider.update(new LovData("11","KPP","Kredit Properti Plus","AMSO2", "1", "", ""));
		
		lovDataProvider.update(new LovData("12","KP01","KP - Fix & Fix","AMSO3", "1", "", ""));
		lovDataProvider.update(new LovData("13","KP02","KP - Fix Floating Rate","AMSO3", "1", "", ""));
		lovDataProvider.update(new LovData("14","KP03","KP - Angsuran Tetap","AMSO3", "1", "", ""));
		lovDataProvider.update(new LovData("15","KP04","KP - Floating Rate","AMSO3", "1", "", ""));
		lovDataProvider.update(new LovData("16","KP05","KP - Bebas Bunga","AMSO3", "1", "", ""));
		
		lovDataProvider.update(new LovData("17","KPM01","KP Multiguna  - Fix & Fix","AMSO4", "1", "", ""));
		lovDataProvider.update(new LovData("18","KPM02","KP Multiguna - Fix & Floating Rate","AMSO4", "1", "", ""));
		lovDataProvider.update(new LovData("19","KPM03","KP Multiguna - Angsuran Tetap","AMSO4", "1", "", ""));
		lovDataProvider.update(new LovData("20","KPM04","KP Multiguna - Floating Rate","AMSO4", "1", "", ""));
		lovDataProvider.update(new LovData("21","KPM05","KP Multiguna - Konstruksi","AMSO4", "1", "", ""));
		lovDataProvider.update(new LovData("22","KPM06","KP Multiguna - Renovasi","AMSO4", "1", "", ""));
		lovDataProvider.update(new LovData("23","KPM07","KP Multiguna - Bebas Bunga","AMSO4", "1", "", ""));
		
		lovDataProvider.update(new LovData("24","KPP01","KP - Plus","AMSO5", "1", "", ""));
		
		lovDataProvider.update(new LovData("25","KPKPM1","Rumah","AMSO6", "1", "", ""));
		lovDataProvider.update(new LovData("26","KPKPM2","Ruko / Rukan","AMSO6", "1", "", ""));
		lovDataProvider.update(new LovData("27","KPKPM3","Tanah","AMSO6", "1", "", ""));
		lovDataProvider.update(new LovData("28","KPKPM4","Kios","AMSO6", "1", "", ""));
		lovDataProvider.update(new LovData("29","KPKPM5","Apartement","AMSO6", "1", "", ""));
		
		lovDataProvider.update(new LovData("30","KPMA","Rumah","AMSO7", "1", "", ""));
		lovDataProvider.update(new LovData("31","KPMB","Ruko / Rukan","AMSO7", "1", "", ""));
		
		// jenis produk
		lovDataProvider.update(new LovData("32","KPPA","Rumah","AMSO8", "1", "", ""));
		lovDataProvider.update(new LovData("33","KPPB","Ruko / Rukan","AMSO8", "1", "", ""));
		lovDataProvider.update(new LovData("34","KPPC","Kios","AMSO8", "1", "", ""));
		lovDataProvider.update(new LovData("35","KPPD","Apartement","AMSO8", "1", "", ""));
		
		// jenis jaminan
		lovDataProvider.update(new LovData("36","JMN01","Rumah","AMSO9", "1", "", ""));
		lovDataProvider.update(new LovData("37","JMN02","Ruko / Rukan","AMSO9", "1", "", ""));
		lovDataProvider.update(new LovData("38","JMN03","Tanah / Kavling","AMSO9", "1", "", ""));
		lovDataProvider.update(new LovData("39","JMN04","Kios","AMSO9", "1", "", ""));
		lovDataProvider.update(new LovData("40","JMN05","Apartement","AMSO9", "1", "", ""));
		
		// company asuransi jiwa
		lovDataProvider.update(new LovData("41","AJW01","PT Astra Aviva Life","AMS10", "1", "", ""));
		lovDataProvider.update(new LovData("42","AJW02","PT. Avrist Assurance","AMS10", "1", "", ""));
		lovDataProvider.update(new LovData("43","AJW03","PT. Asuransi Cigna","AMS10", "1", "", ""));
		lovDataProvider.update(new LovData("44","AJW04","PT. Commonwealth Life","AMS10", "1", "", ""));
		lovDataProvider.update(new LovData("45","AJW05","PT. Asuransi Jiwa Sinarmas MSIG","AMS10", "1", "", ""));
		
		// plan asuransi jiwa
		lovDataProvider.update(new LovData("53","AJW0104A","Plafond > Rp 1 Milyar","AJW0104", "1", "", ""));
		lovDataProvider.update(new LovData("54","AJW0104B","Plafond ≤ Rp 1 Milyar","AJW0104", "1", "", ""));
		lovDataProvider.update(new LovData("55","AJW0104C","Angsuran Tetap","AJW0104", "1", "", ""));
		
		lovDataProvider.update(new LovData("56","AJW02A","Plafond > Rp 1 Milyar","AJW02", "1", "", ""));
		lovDataProvider.update(new LovData("57","AJW02B","Plafond ≤ Rp 1 Milyar","AJW02", "1", "", ""));
		
		lovDataProvider.update(new LovData("58","AJW03A","Jiwa","AJW03", "1", "", ""));
		
		lovDataProvider.update(new LovData("59","AJW05A","Plafond > Rp 1 Milyar","AJW05", "1", "", ""));
		lovDataProvider.update(new LovData("60","AJW05C","Plafond ≤ Rp 1 Milyar","AJW05", "1", "", ""));
		lovDataProvider.update(new LovData("61","AJW05D","Angsuran Tetap","AJW05", "1", "", ""));
		lovDataProvider.update(new LovData("62","AJW05E","KP Plus 20% : 80%","AJW05", "1", "", ""));
		lovDataProvider.update(new LovData("63","AJW05F","KP Plus 25% : 75%","AJW05", "1", "", ""));
		lovDataProvider.update(new LovData("64","AJW05G","KP Plus 30% : 70%","AJW05", "1", "", ""));
		lovDataProvider.update(new LovData("65","AJW05H","KP Plus 35% : 65%","AJW05", "1", "", ""));
		lovDataProvider.update(new LovData("67","AJW05I","KP Plus 50% : 50%","AJW05", "1", "", ""));
		lovDataProvider.update(new LovData("68","AJW05J","KP Plus 100% : 0%","AJW05", "1", "", ""));
		
		// company asurasi kebakaran
		lovDataProvider.update(new LovData("69","AJF01","PT. Asuransi Central Asia","AMS11", "1", "", ""));
		lovDataProvider.update(new LovData("70","AJF02","PT. Asuransi Central Asia","AMS11", "1", "", ""));
		lovDataProvider.update(new LovData("71","AJF03","PT. Asuransi Jasa Indonesia (Jasindo)","AMS11", "1", "", ""));
		lovDataProvider.update(new LovData("72","AJF04","PT. Asuransi Jaya Proteksi","AMS11", "1", "", ""));
		lovDataProvider.update(new LovData("73","AJF05","PT. Asuransi Mitra Maparya","AMS11", "1", "", ""));
		lovDataProvider.update(new LovData("74","AJF06","PT. Asuransi Sinar Mas","AMS11", "1", "", ""));
		lovDataProvider.update(new LovData("75","AJF017","PT. Asuransi Wahana Tata","AMS11", "1", "", ""));
		
		// plan asuransi kebakaran
		lovDataProvider.update(new LovData("76","AJF00A","Rumah Tinggal","AJF1367", "1", "", ""));
		lovDataProvider.update(new LovData("77","AJF00B","Ruko","AJF1367", "1", "", ""));
		lovDataProvider.update(new LovData("78","AJF00C","Apartemen / Rukan / Kantor < 7 Lantai","AJF1367", "1", "", ""));
		lovDataProvider.update(new LovData("79","AJF00D","Apartemen / Rukan / Kantor 7 - 18 lantai","AJF1367", "1", "", ""));
		lovDataProvider.update(new LovData("80","AJF00E","Apartemen / Rukan / Kantor 19 - 24 lantai","AJF1367", "1", "", ""));
		lovDataProvider.update(new LovData("81","AJF00F","Apartemen / Rukan / Kantor > 24 lantai","AJF1367", "1", "", ""));
		
		lovDataProvider.update(new LovData("82","AJF02A","Rumah Tinggal Kelas 1","AJF02", "1", "", ""));
		lovDataProvider.update(new LovData("83","AJF02B","Ruko / Toko Kelas 1","AJF02", "1", "", ""));
		lovDataProvider.update(new LovData("84","AJF02C","Apartemen / Rukan / Kantor < 7 Lantai","AJF02", "1", "", ""));
		lovDataProvider.update(new LovData("85","AJF02D","Apartemen / Rukan / Kantor 7 - 18 lantai","AJF02", "1", "", ""));
		lovDataProvider.update(new LovData("86","AJF02E","Apartemen / Rukan / Kantor 19 - 24 lantai","AJF02", "1", "", ""));
		lovDataProvider.update(new LovData("87","AJF02F","Apartemen / Rukan / Kantor > 24 lantai","AJF02", "1", "", ""));
		
		lovDataProvider.update(new LovData("88","AJF04A","Rumah Tinggal","AJF04", "1", "", ""));
		lovDataProvider.update(new LovData("89","AJF04B","Ruko / Toko","AJF04", "1", "", ""));
		lovDataProvider.update(new LovData("90","AJF04C","Rukan / Kantor < 7 Lantai","AJF04", "1", "", ""));
		lovDataProvider.update(new LovData("91","AJF04D","Rukan / Kantor 7 - 18 lantai","AJF04", "1", "", ""));
		lovDataProvider.update(new LovData("92","AJF04E","Rukan / Kantor 19 - 24 lantai","AJF04", "1", "", ""));
		lovDataProvider.update(new LovData("93","AJF04F","Rukan / Kantor > 24 lantai","AJF04", "1", "", ""));
		lovDataProvider.update(new LovData("94","AJF04G","Apartemen < 7 Lantai","AJF04", "1", "", ""));
		lovDataProvider.update(new LovData("95","AJF04H","Apartemen up 7 - 18 lantai","AJF04", "1", "", ""));
		lovDataProvider.update(new LovData("96","AJF04I","Apartemen 19 - 24 lantai","AJF04", "1", "", ""));
		lovDataProvider.update(new LovData("97","AJF04J","Apartemen > 24 lantai","AJF04", "1", "", ""));
		lovDataProvider.update(new LovData("98","AJF04K","RSMD 4.1B/2007","AJF04", "1", "", ""));
		
		lovDataProvider.update(new LovData("99","AJF05A","Rumah Tinggal","AJF05", "1", "", ""));
		lovDataProvider.update(new LovData("100","AJF05B","Ruko","AJF05", "1", "", ""));
		lovDataProvider.update(new LovData("101","AJF05C","Rukan < 6 Lantai (termasuk basemen)","AJF05", "1", "", ""));
		lovDataProvider.update(new LovData("102","AJF05D","Rukan 6-18 Lantai (termasuk basemen)","AJF05", "1", "", ""));
		lovDataProvider.update(new LovData("103","AJF05E","Rukan 18-24 Lantai (termasuk basemen)","AJF05", "1", "", ""));
		lovDataProvider.update(new LovData("104","AJF05F","Rukan > 24 Lantai (termasuk basemen)","AJF05", "1", "", ""));
		lovDataProvider.update(new LovData("105","AJF05G","Apartemen < 6 Lantai (termasuk basemen)","AJF05", "1", "", ""));
		lovDataProvider.update(new LovData("106","AJF05H","Apartemen 6-18 Lantai (termasuk basemen)","AJF05", "1", "", ""));
		lovDataProvider.update(new LovData("107","AJF05I","Apartemen 18-24 Lantai (termasuk basemen)","AJF05", "1", "", ""));
		lovDataProvider.update(new LovData("108","AJF05J","Apartemen > 24 Lantai (termasuk basemen)","AJF05", "1", "", ""));
		
	}
	
	public boolean isEmailValid(String email)
    {
	         String regExpn =
	             "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
	                 +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
	                   +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
	                   +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
	                   +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
	                   +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";
	
	     CharSequence inputStr = email;
	
	     Pattern pattern = Pattern.compile(regExpn,Pattern.CASE_INSENSITIVE);
	     Matcher matcher = pattern.matcher(inputStr);
	
	     if(matcher.matches())
	        return true;
	     else
	        return false;
	}
	
	
    
}
