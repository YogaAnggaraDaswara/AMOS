package com.mobile.appraisal;

import java.text.SimpleDateFormat;

//import com.mobile.app.activity.tagihan.TagihanDialog;
import com.mobile.app.configuration.AppConstants;
import com.mobile.app.ui.ListOfValueAdapter;
import com.mobile.services.app.datatype.TRANSAKSIRESPONSE;
import com.mobile.services.app.services.ServiceDataProvider;

import bii.mobile.amos.R;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.app.AlertDialog;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import com.mobile.bo.app.*;

import java.util.ArrayList;
import java.util.UUID;

import com.mobile.bo.app.dataprovider.Appr_Collateral;
import com.mobile.bo.app.dataprovider.Appr_NegativeProvider;
import com.mobile.bo.app.dataprovider.Appr_Rtb_DataDataProvider;
import com.mobile.bo.app.dataprovider.Appr_Vhc_DataDataProvider;
import com.mobile.bo.app.dataprovider.LOVDataProvider;
import com.mobile.bo.app.datatype.Datatype_Appr_Collateral;
import com.mobile.bo.app.datatype.Datatype_Appr_NegativeList;
import com.mobile.bo.app.datatype.Datatype_Appr_Rtb_Data_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_Rtb_Pembanding_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_Vch_Data_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_imb;
import com.mobile.bo.app.datatype.LovData;
import com.mobile.framework.common.DateFormatter;
import com.mobile.framework.widget.ExSpinner;
import com.mobile.framework.widget.ISpinnerItem;

public class Fragment_Data_Rumah_Tanah_Bangunan extends Fragment {
    //private TagihanDialog tagihanDialog = null;
	View view=null;
    Button Btnsave;
    private Context ctx = null;
    private Datatype_Appr_Collateral datatype_Appr_Collateral = new Datatype_Appr_Collateral();
    private Appr_Collateral appr_Collateral=new Appr_Collateral();
    private TextView header_deb;
    private TextView header_alamat;
    
    private Appr_Rtb_DataDataProvider appr_Rtb_DataProvider=new Appr_Rtb_DataDataProvider();
    private Datatype_Appr_Rtb_Data_Int appr_Rtb_data_int = new Datatype_Appr_Rtb_Data_Int();
    private ArrayList<ISpinnerItem> lovjnslokasi = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovkodepos = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovjenisagunan = new ArrayList<ISpinnerItem>();
    private LOVDataProvider lovDataProvider;
    private ArrayList<ISpinnerItem> lovNegative = new ArrayList<ISpinnerItem>();
    private ExSpinner info_jaminan_spn_jenis_lebar_lokasi;
    private EditText info_jaminan_txt_jenis_lebar_lokasi;
    private EditText info_jaminan_rdogroup_lokasi_jaminan;
    private EditText info_jaminan_txt_alamat_agunan;
    private EditText info_jaminan_txt_rw;
    private EditText info_jaminan_txt_rt;
    private ExSpinner info_jaminan_spn_kodepos;
    private EditText info_jaminan_txt_kelurahan;
    private EditText info_jaminan_txt_kecamatan;
    private EditText info_jaminan_txt_kota;
    private EditText info_jaminan_txt_sarana_umum;
    private EditText info_jaminan_txt_tersedia;
    private EditText info_jaminan_txt_inspeksi;
    private EditText info_jaminan_rdogroup_bussiness;
    private EditText info_jaminan_txt_ket_lain;
    private ExSpinner info_jaminan_spn_jenis_agunan;
    private RadioButton info_jaminan_rdo_business_ya;
    private RadioButton info_jaminan_rdo_business_tidak;
    private RadioButton info_jaminan_rdo_lokasi_jaminan_pernah;
    private RadioButton info_jaminan_rdo_lokasi_jaminan_sering;
    private RadioButton info_jaminan_rdo_lokasi_jaminan_bebas;
    private CheckBox data_chk_sme;
    private CheckBox data_chk_ll;
    private Fragment_Data_negative_Dialog fragment_Data_negative_Dialog=null; 
    private TableLayout negative_tableLayout;
    Button btn_negative_add;
    private Appr_NegativeProvider appr_NegativeProvider=new Appr_NegativeProvider();
    private Datatype_Appr_NegativeList appr_NegativeList = new Datatype_Appr_NegativeList();
    private ArrayList<Datatype_Appr_NegativeList> listdataall  = null;;
    private String col_id="";
    private String ap_regno="";
    private String status="";
    private LinearLayout contentlayout;
	public Fragment_Data_Rumah_Tanah_Bangunan() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_data_gudang, null);
        ctx = this.getActivity();
        appr_Rtb_DataProvider=new Appr_Rtb_DataDataProvider();
        appr_Rtb_data_int = new Datatype_Appr_Rtb_Data_Int();
        appr_NegativeProvider=new Appr_NegativeProvider();
        appr_NegativeList = new Datatype_Appr_NegativeList();
        negative_tableLayout= (TableLayout) view.findViewById(R.id.negative_tableLayout);
        fragment_Data_negative_Dialog=new Fragment_Data_negative_Dialog(ctx);
        appr_Collateral=new Appr_Collateral();
        datatype_Appr_Collateral = new Datatype_Appr_Collateral();
        
        Bundle b = getArguments();

     
        col_id=b.getString("COL_ID");
        ap_regno=b.getString("AP_REGNO");
        status=b.getString("STATUS");
        initControl();
        
        loadData();
        return view;
    }
    private void initControl(){
    	info_jaminan_spn_kodepos= (ExSpinner) view.findViewById(R.id.info_jaminan_spn_kodepos);
    	lovDataProvider = new LOVDataProvider();
    	lovkodepos = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_DATI2));
        info_jaminan_spn_kodepos.setListOfValue(lovkodepos, false);
        data_chk_sme= (CheckBox) view.findViewById(R.id.data_chk_sme);
        data_chk_ll= (CheckBox) view.findViewById(R.id.data_chk_ll);
        header_deb							=(TextView) view.findViewById(R.id.info_Nama_deb);
        header_alamat						=(TextView) view.findViewById(R.id.info_Nama_Alamat);
        data_chk_sme.setOnClickListener(new View.OnClickListener() {
			
        	  public void onClick(View view) {
        		  data_chk_ll.setChecked(false);
             }
		});
        
        data_chk_ll.setOnClickListener(new View.OnClickListener() {
			
      	  public void onClick(View view) {
      		  	data_chk_sme.setChecked(false);
           }
		});
        info_jaminan_spn_jenis_lebar_lokasi= (ExSpinner) view.findViewById(R.id.info_jaminan_spn_jenis_lebar_lokasi);
    	lovjnslokasi = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_LEBAR_JALAN));
    	info_jaminan_spn_jenis_lebar_lokasi.setListOfValue(lovjnslokasi, false);
       
    	info_jaminan_spn_jenis_agunan= (ExSpinner) view.findViewById(R.id.info_jaminan_spn_jenis_agunan);
     	lovjenisagunan = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_JENIS_AGUNAN));
     	info_jaminan_spn_jenis_agunan.setListOfValue(lovjenisagunan, false);
     	
    	info_jaminan_txt_jenis_lebar_lokasi= (EditText) view.findViewById(R.id.info_jaminan_txt_jenis_lebar_lokasi);
    	info_jaminan_txt_alamat_agunan= (EditText) view.findViewById(R.id.info_jaminan_txt_alamat_agunan);
    	info_jaminan_txt_rw= (EditText) view.findViewById(R.id.info_jaminan_txt_rw);
    	info_jaminan_txt_rt= (EditText) view.findViewById(R.id.info_jaminan_txt_rt);
    	info_jaminan_txt_kelurahan= (EditText) view.findViewById(R.id.info_jaminan_txt_kelurahan);
    	info_jaminan_txt_kecamatan= (EditText) view.findViewById(R.id.info_jaminan_txt_kecamatan);
    	info_jaminan_txt_kota= (EditText) view.findViewById(R.id.info_jaminan_txt_kota);
    	info_jaminan_txt_sarana_umum= (EditText) view.findViewById(R.id.info_jaminan_txt_sarana_umum);
    	info_jaminan_txt_tersedia= (EditText) view.findViewById(R.id.info_jaminan_txt_tersedia);
    	info_jaminan_txt_inspeksi= (EditText) view.findViewById(R.id.info_jaminan_txt_inspeksi);
    	info_jaminan_rdo_business_ya= (RadioButton) view.findViewById(R.id.info_jaminan_rdo_business_ya);
    	info_jaminan_rdo_business_tidak= (RadioButton) view.findViewById(R.id.info_jaminan_rdo_business_tidak);
    	info_jaminan_txt_ket_lain= (EditText) view.findViewById(R.id.info_jaminan_txt_ket_lain);
    	info_jaminan_rdo_lokasi_jaminan_pernah= (RadioButton) view.findViewById(R.id.info_jaminan_rdo_lokasi_jaminan_pernah);
    	info_jaminan_rdo_lokasi_jaminan_sering= (RadioButton) view.findViewById(R.id.info_jaminan_rdo_lokasi_jaminan_sering);
    	info_jaminan_rdo_lokasi_jaminan_bebas= (RadioButton) view.findViewById(R.id.info_jaminan_rdo_lokasi_jaminan_bebas);
    	Btnsave = (Button) view.findViewById(R.id.btn_savedatartb);

    	Btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	try{
            		saveData();
            	}
            	catch(Exception ex){
            		showAlert(R.string.msg_notification_update_error);
            	}
           }
        }); 
    	
    	btn_negative_add = (Button) view.findViewById(R.id.btn_negative_add);

    	btn_negative_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(data_chk_sme.isChecked() || data_chk_ll.isChecked()){
            	
            	//Bundle b = new Bundle();
				if(data_chk_sme.isChecked()){
					lovNegative = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_NEGATIVE));
					fragment_Data_negative_Dialog.setData_kendaraan_spn_negative_listx(lovNegative);
				}
				else if(data_chk_ll.isChecked())
				{
					lovNegative = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_NEGATIVELL));
					fragment_Data_negative_Dialog.setData_kendaraan_spn_negative_listx(lovNegative);
				}
				
            	fragment_Data_negative_Dialog.setData_kendaraan_txt_id("");
            	fragment_Data_negative_Dialog.setData_kendaraan_txt_seq("");
            	fragment_Data_negative_Dialog.setData_kendaraan_spn_negative_list("");
            	fragment_Data_negative_Dialog.show();
            }
            else{
            	
            	showAlert(R.string.msg_notification_pilih);
            }
           }
        }); 
    	fragment_Data_negative_Dialog.getBtn_savenegative().setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				int intCount=1;
            	if(!fragment_Data_negative_Dialog.getData_kendaraan_txt_id().toString().equals(""))
            	{
            		intCount=Integer.parseInt(fragment_Data_negative_Dialog.getData_kendaraan_txt_seq().toString());
            	}
            	else{
            		intCount=appr_NegativeProvider.getAllAppr_detail_Negative_by_MaxSeq(col_id);
            	}
				
				appr_NegativeList.setCOL_ID(col_id);
				appr_NegativeList.setID(col_id + intCount);
				appr_NegativeList.setNEG_SEQ("" +intCount);
				appr_NegativeList.setNEG_CODE(fragment_Data_negative_Dialog.getData_kendaraan_spn_negative_list());
				
				
            	appr_NegativeProvider.updateData(appr_NegativeList);   
            	viewNegativeList();
            	fragment_Data_negative_Dialog.dismiss();
				
			}
		});
    	setColorMandatory();
    	 
    	if(status.equals("INQUERY")){
    		    	contentlayout= (LinearLayout) view.findViewById(R.id.contentlayout);
    		    	info_jaminan_rdo_business_ya.setEnabled(false);
    		    	info_jaminan_rdo_business_tidak.setEnabled(false);
    		    	info_jaminan_txt_ket_lain.setEnabled(false);
    		    	info_jaminan_rdo_lokasi_jaminan_pernah.setEnabled(false);
    		    	info_jaminan_rdo_lokasi_jaminan_sering.setEnabled(false);
    		    	info_jaminan_rdo_lokasi_jaminan_bebas.setEnabled(false);
    		    	info_jaminan_txt_rw.setEnabled(false);
    		    	info_jaminan_txt_rt.setEnabled(false);
    		    	
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
    private void setColorMandatory(){
    	info_jaminan_txt_jenis_lebar_lokasi.setBackgroundResource(R.drawable.fillcolor);
    	info_jaminan_txt_alamat_agunan.setBackgroundResource(R.drawable.fillcolor);
    	info_jaminan_txt_kelurahan.setBackgroundResource(R.drawable.fillcolor);
    	info_jaminan_txt_kecamatan.setBackgroundResource(R.drawable.fillcolor);
    	info_jaminan_txt_kota.setBackgroundResource(R.drawable.fillcolor);
    	info_jaminan_txt_sarana_umum.setBackgroundResource(R.drawable.fillcolor);
    	info_jaminan_txt_tersedia.setBackgroundResource(R.drawable.fillcolor);
    	info_jaminan_txt_inspeksi.setBackgroundResource(R.drawable.fillcolor);
  	  
  	
    }
    private Boolean CekMandatory(){
  	  boolean retval=true;
  	appr_Rtb_data_int=appr_Rtb_DataProvider.getAllAppr_Rtb_Data_Int(col_id);
  	if(appr_Rtb_data_int.COL_ID!=null && !appr_Rtb_data_int.COL_ID.equals("")){
		if(appr_Rtb_data_int.ROAD_WIDTH==null || appr_Rtb_data_int.ROAD_WIDTH.equals(""))
  			retval=false;
		if(appr_Rtb_data_int.COL_ADDR1==null || appr_Rtb_data_int.COL_ADDR1.equals(""))
  			retval=false;
		if(appr_Rtb_data_int.COL_KELURAHAN==null || appr_Rtb_data_int.COL_KELURAHAN.equals(""))
  			retval=false;
		if(appr_Rtb_data_int.COL_KECAMATAN==null || appr_Rtb_data_int.COL_KECAMATAN.equals(""))
  			retval=false;
			
		if(appr_Rtb_data_int.COL_CITY==null || appr_Rtb_data_int.COL_CITY.equals(""))
  			retval=false;
		if(appr_Rtb_data_int.FAS_TRANSPORTATION==null || appr_Rtb_data_int.FAS_TRANSPORTATION.equals(""))
  			retval=false;
			
		if(appr_Rtb_data_int.FAS_TRANSPORTATION_DISTANCE==null || appr_Rtb_data_int.FAS_TRANSPORTATION_DISTANCE.equals(""))
  			retval=false;
		if(appr_Rtb_data_int.INSPECTION_PERSON==null || appr_Rtb_data_int.INSPECTION_PERSON.equals(""))
  			retval=false;
		if(appr_Rtb_data_int.COL_ZIPCODE==null || appr_Rtb_data_int.COL_ZIPCODE.equals(""))
  			retval=false;
		if(appr_Rtb_data_int.ROAD_TYPE==null || appr_Rtb_data_int.ROAD_TYPE.equals(""))
  			retval=false;
		if(appr_Rtb_data_int.COL_CLASS==null || appr_Rtb_data_int.COL_CLASS.equals(""))
  			retval=false;
	}



 return retval;	
  /*	  if(info_jaminan_txt_jenis_lebar_lokasi.getText().length()==0){
  		info_jaminan_txt_jenis_lebar_lokasi.setError("Field Tidak Boleh Kososng");
  		  retval=false;
  	  }
  	  if(info_jaminan_txt_alamat_agunan.getText().length()==0){
  		info_jaminan_txt_alamat_agunan.setError("Field Tidak Boleh Kososng");
  		  retval=false;
  	  }
  	  if(info_jaminan_txt_kelurahan.getText().length()==0){
  		info_jaminan_txt_kelurahan.setError("Field Tidak Boleh Kososng");
  		  retval=false;
  	  }
  	  if(info_jaminan_txt_kecamatan.getText().length()==0){
  		info_jaminan_txt_kecamatan.setError("Field Tidak Boleh Kososng");
  		  retval=false;
  	  }
  	  if(info_jaminan_txt_kota.getText().length()==0){
  		info_jaminan_txt_kota.setError("Field Tidak Boleh Kososng");
  		  retval=false;
  	  }
  	  if(info_jaminan_txt_sarana_umum.getText().length()==0){
  		info_jaminan_txt_sarana_umum.setError("Field Tidak Boleh Kososng");
  		  retval=false;
  	  }
  	  if(info_jaminan_txt_tersedia.getText().length()==0){
  		info_jaminan_txt_tersedia.setError("Field Tidak Boleh Kososng");
  		  retval=false;
  	  }
  	  if(info_jaminan_txt_inspeksi.getText().length()==0){
  		info_jaminan_txt_inspeksi.setError("Field Tidak Boleh Kososng");
  		  retval=false;
  	  }
  	  View selectedView = info_jaminan_spn_kodepos.getSelectedView();
	  if (selectedView != null && selectedView instanceof TextView) {
	      TextView selectedTextView = (TextView) selectedView;
	      if (info_jaminan_spn_kodepos.getSelectedListOfValue().toString().length()==0) {
	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
	          selectedTextView.setError(errorString);
	          retval=false;
	      }
	      else {
	          selectedTextView.setError(null);
	      }
	  }
	  
	  View selectedView1 = info_jaminan_spn_jenis_lebar_lokasi.getSelectedView();
	  if (selectedView1 != null && selectedView1 instanceof TextView) {
	      TextView selectedTextView = (TextView) selectedView1;
	      if (info_jaminan_spn_jenis_lebar_lokasi.getSelectedListOfValue().toString().length()==0) {
	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
	          selectedTextView.setError(errorString);
	          retval=false;
	      }
	      else {
	          selectedTextView.setError(null);
	      }
	  }
	  
	  View selectedView2 = info_jaminan_spn_jenis_agunan.getSelectedView();
	  if (selectedView2 != null && selectedView2 instanceof TextView) {
	      TextView selectedTextView = (TextView) selectedView2;
	      if (info_jaminan_spn_jenis_agunan.getSelectedListOfValue().toString().length()==0) {
	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
	          selectedTextView.setError(errorString);
	          retval=false;
	      }
	      else {
	          selectedTextView.setError(null);
	      }
	  }
	  
  	  return retval;*/
    }
    private void saveData(){
    	
	    	appr_Rtb_data_int.setCOL_ID(col_id);
	    	appr_Rtb_data_int.setAP_REGNO(ap_regno);
	    	appr_Rtb_data_int.setROAD_TYPE(info_jaminan_spn_jenis_lebar_lokasi.getSelectedListOfValue().toString());
	    	appr_Rtb_data_int.setROAD_WIDTH(info_jaminan_txt_jenis_lebar_lokasi.getText().toString());
	    	appr_Rtb_data_int.setCOL_ADDR1(info_jaminan_txt_alamat_agunan.getText().toString());
	    	appr_Rtb_data_int.setCOL_RT(info_jaminan_txt_rw.getText().toString());
	    	appr_Rtb_data_int.setCOL_RW(info_jaminan_txt_rt.getText().toString());
	    	appr_Rtb_data_int.setCOL_ZIPCODE(info_jaminan_spn_kodepos.getSelectedListOfValue().toString());
	    	appr_Rtb_data_int.setCOL_KELURAHAN(info_jaminan_txt_kelurahan.getText().toString());
	    	appr_Rtb_data_int.setCOL_KECAMATAN(info_jaminan_txt_kecamatan.getText().toString());
	    	appr_Rtb_data_int.setCOL_CITY(info_jaminan_txt_kota.getText().toString());
	    	appr_Rtb_data_int.setFAS_TRANSPORTATION(info_jaminan_txt_sarana_umum.getText().toString());
	    	appr_Rtb_data_int.setFAS_TRANSPORTATION_DISTANCE(info_jaminan_txt_tersedia.getText().toString());
	    	appr_Rtb_data_int.setINSPECTION_PERSON(info_jaminan_txt_inspeksi.getText().toString());
	    	if(info_jaminan_rdo_business_ya.isChecked())
	    		appr_Rtb_data_int.setINSPECTION_BUSINESSUNIT(AppConstants.RDOYA);
	    	else if(info_jaminan_rdo_business_tidak.isChecked())
	    		appr_Rtb_data_int.setINSPECTION_BUSINESSUNIT(AppConstants.RDOTIDAK);
	    	
	    	if(info_jaminan_rdo_lokasi_jaminan_pernah.isChecked())
	    		appr_Rtb_data_int.setLOCATION(AppConstants.RDOA);
	    	else if(info_jaminan_rdo_lokasi_jaminan_sering.isChecked())
	    		appr_Rtb_data_int.setLOCATION(AppConstants.RDOB);
	    	else if(info_jaminan_rdo_lokasi_jaminan_bebas.isChecked())
	    		appr_Rtb_data_int.setLOCATION(AppConstants.RDOC);
	    	
	
	    	appr_Rtb_data_int.setOTHER_INFO(info_jaminan_txt_ket_lain.getText().toString());
	    	appr_Rtb_data_int.setCOL_CLASS(info_jaminan_spn_jenis_agunan.getSelectedListOfValue().toString());
	    	if(data_chk_sme.isChecked())
  			{
	    		appr_Rtb_data_int.setNEGATIVELIST("SME");
  			}
	  		else if(data_chk_ll.isChecked())
	  		{
	  			appr_Rtb_data_int.setNEGATIVELIST("LL");
	  		}
	    	appr_Rtb_DataProvider.updateData(appr_Rtb_data_int);
	    	
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
    public static String replaceNull(String input) {
  	  return input == null ? "" : input;
  	}
    private void loadData(){
    	appr_Rtb_data_int=appr_Rtb_DataProvider.getAllAppr_Rtb_Data_Int(col_id);
      	if(appr_Rtb_data_int.COL_ID!=null && !appr_Rtb_data_int.COL_ID.equals("")){
      		info_jaminan_spn_jenis_lebar_lokasi.setSelectedListOfValue(replaceNull(appr_Rtb_data_int.getROAD_TYPE()));
      		info_jaminan_txt_jenis_lebar_lokasi.setText(replaceNull(appr_Rtb_data_int.getROAD_WIDTH()));
      		info_jaminan_txt_alamat_agunan.setText(replaceNull(appr_Rtb_data_int.getCOL_ADDR1()));
      		info_jaminan_txt_rw.setText(replaceNull(appr_Rtb_data_int.getCOL_RT()));
      		info_jaminan_txt_rt.setText(replaceNull(appr_Rtb_data_int.getCOL_RW()));
      		info_jaminan_spn_kodepos.setSelectedListOfValue(replaceNull(appr_Rtb_data_int.getCOL_ZIPCODE()));
      		info_jaminan_txt_kelurahan.setText(replaceNull(appr_Rtb_data_int.getCOL_KELURAHAN()));
      		info_jaminan_txt_kecamatan.setText(replaceNull(appr_Rtb_data_int.getCOL_KECAMATAN()));
      		info_jaminan_txt_kota.setText(replaceNull(appr_Rtb_data_int.getCOL_CITY()));
      		info_jaminan_txt_sarana_umum.setText(replaceNull(appr_Rtb_data_int.getFAS_TRANSPORTATION()));
      		info_jaminan_txt_tersedia.setText(replaceNull(appr_Rtb_data_int.getFAS_TRANSPORTATION_DISTANCE()));
      		info_jaminan_txt_inspeksi.setText(replaceNull(appr_Rtb_data_int.getINSPECTION_PERSON()));
      		info_jaminan_txt_ket_lain.setText(replaceNull(appr_Rtb_data_int.getOTHER_INFO()));
      		info_jaminan_spn_jenis_agunan.setSelectedListOfValue(replaceNull(appr_Rtb_data_int.getCOL_CLASS()));
      		datatype_Appr_Collateral=appr_Collateral.getAllAppr_Collateral(col_id);
      		if(datatype_Appr_Collateral.COL_ID!=null && !datatype_Appr_Collateral.COL_ID.toString().equals("")){
      			header_alamat.setText(datatype_Appr_Collateral.getCOL_ADDR1() + " , " +  datatype_Appr_Collateral.getCOL_KELURAHAN() + " , " +  datatype_Appr_Collateral.getCOL_KECAMATAN() + " , " +  datatype_Appr_Collateral.getCOL_CITY() + " , " +  datatype_Appr_Collateral.getCOL_ZIPCODE());
      		    header_deb.setText(datatype_Appr_Collateral.getAP_REGNO() + " # " + datatype_Appr_Collateral.getCU_NAME() );
      		}
      		      	
      		if(appr_Rtb_data_int.getNEGATIVELIST().equals("SME"))
      			{
      				data_chk_sme.setChecked(true);
      				data_chk_ll.setChecked(false);
      			}
      		else if(appr_Rtb_data_int.getNEGATIVELIST().equals("LL"))
      		{
      			data_chk_sme.setChecked(false);
  				data_chk_ll.setChecked(true);
      		}
      		if(appr_Rtb_data_int.getINSPECTION_BUSINESSUNIT().equals(AppConstants.RDOYA))
        		info_jaminan_rdo_business_ya.setChecked(true);
        	else if(appr_Rtb_data_int.getINSPECTION_BUSINESSUNIT().equals(AppConstants.RDOTIDAK))
        		info_jaminan_rdo_business_tidak.setChecked(true);
        	
        	if(appr_Rtb_data_int.getLOCATION().equals(AppConstants.RDOA))
        		info_jaminan_rdo_lokasi_jaminan_pernah.setChecked(true);
        	else if(appr_Rtb_data_int.getLOCATION().equals(AppConstants.RDOB))
        		info_jaminan_rdo_lokasi_jaminan_sering.setChecked(true);
        	else if(appr_Rtb_data_int.getLOCATION().equals(AppConstants.RDOC))
        		info_jaminan_rdo_lokasi_jaminan_bebas.setChecked(true);
      	}
      	viewNegativeList();
    }
    public void loadTagihanDialog() {
        String uniqueKey = UUID.randomUUID().toString().toUpperCase();
        Toast.makeText(ctx, uniqueKey, Toast.LENGTH_LONG).show();
        //tagihanDialog = new TagihanDialog(ctx);


        //tagihanDialog.show();
    }
   private void viewNegativeList() {
    	
    	listdataall=appr_NegativeProvider.getAllAppr_Negative(col_id);
        negative_tableLayout.removeAllViews();
    	
        TableRow rowHeaderTable = new TableRow(ctx);
        rowHeaderTable.setBackgroundColor(getResources().getColor(R.color.color_bacground2));
        rowHeaderTable.setPadding(0, 0, 0, 2);

        TableRow.LayoutParams rowParamsDetail = new TableRow.LayoutParams();
        rowParamsDetail.gravity = Gravity.LEFT;

        TextView header = new TextView(ctx);
        header.setGravity(Gravity.RIGHT);
        header.setTextColor(getResources().getColor(android.R.color.black));
        header.setPadding(0, 3, 0, 3);
        header.setTextSize(12);
        header.setWidth(150);
        header.setText("Action");

        rowHeaderTable.addView(header, rowParamsDetail);

        TextView header2 = new TextView(ctx);
        header2.setGravity(Gravity.LEFT);
        header2.setTextColor(getResources().getColor(android.R.color.black));
        header2.setPadding(0, 3, 0, 3);
        header2.setTextSize(12);
        header2.setWidth(150);
        header2.setText("");

        rowHeaderTable.addView(header2, rowParamsDetail);
        
        TextView header10 = new TextView(ctx);
        header10.setGravity(Gravity.LEFT);
        header10.setTextColor(getResources().getColor(android.R.color.black));
        header10.setPadding(0, 3, 0, 3);
        header10.setTextSize(12);
        header10.setWidth(500);
        header10.setText("Negative List");

        rowHeaderTable.addView(header10, rowParamsDetail);

         
        
        negative_tableLayout.addView(rowHeaderTable);
        String lov_desc="";
        for (int i = 0; i < listdataall.size(); i++) {
            final Datatype_Appr_NegativeList contentdata = listdataall.get(i);
            final TableRow rowContentTable = new TableRow(ctx);
            if ((i + 1) % 2 == 0) {
                rowContentTable.setBackgroundColor(getResources().getColor(R.color.color_bacground1));
            } else {
                rowContentTable.setBackgroundColor(Color.WHITE);
            }
        	
    	   
           
            
            Button content_detail = new Button(ctx);
            content_detail.setGravity(Gravity.CENTER);
            content_detail.setText(R.string.form_action_detail);
            rowContentTable.addView(content_detail, 5, 50);
            
            content_detail.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					TextView content_id = (TextView) rowContentTable.getChildAt(3);
					TextView content_col_id = (TextView) rowContentTable.getChildAt(4);
					TextView content_seq = (TextView) rowContentTable.getChildAt(5);
					TextView content_code = (TextView) rowContentTable.getChildAt(6);
					if(data_chk_sme.isChecked()){
						lovNegative = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_NEGATIVE));
						fragment_Data_negative_Dialog.setData_kendaraan_spn_negative_listx(lovNegative);
					}
					else if(data_chk_ll.isChecked())
					{
						lovNegative = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_NEGATIVELL));
						fragment_Data_negative_Dialog.setData_kendaraan_spn_negative_listx(lovNegative);
					}
					
                	fragment_Data_negative_Dialog.setData_kendaraan_txt_id(content_id.getText().toString());
                	fragment_Data_negative_Dialog.setData_kendaraan_txt_seq(content_seq.getText().toString());
                	fragment_Data_negative_Dialog.setData_kendaraan_spn_negative_list(content_code.getText().toString());
                	
                	fragment_Data_negative_Dialog.show();	
					
				}
			});
            
            Button content_delete = new Button(ctx);
            content_delete.setGravity(Gravity.CENTER);
            content_delete.setText(R.string.form_action_delete);
            rowContentTable.addView(content_delete, 5, 50);
            
           
           content_delete.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					TextView content_id = (TextView) rowContentTable.getChildAt(3);
					showConfirmationDelete(true,content_id.getText().toString());
					
				}
			});
           LovData	lovnegative = lovDataProvider.getLOVDetail(contentdata.getNEG_CODE().toString(), AppConstants.SPINNER_NEGATIVE);
           if(data_chk_ll.isChecked())
			{
        	   lovnegative = lovDataProvider.getLOVDetail(contentdata.getNEG_CODE().toString(), AppConstants.SPINNER_NEGATIVELL);
				
			}
            try{
	   	    	lov_desc=lovnegative.getDESCRIPTION().toString();
	   	    }
           catch(Exception ex){
           	lov_desc="";
           }
            TextView content_ap_regno = new TextView(ctx);
            content_ap_regno.setGravity(Gravity.LEFT);
            content_ap_regno.setTextColor(getResources().getColor(android.R.color.black));
            content_ap_regno.setPadding(0, 3, 0, 3);
            content_ap_regno.setTextSize(12);
            content_ap_regno.setWidth(500);
            content_ap_regno.setText(lov_desc);
            rowContentTable.addView(content_ap_regno, rowParamsDetail);

            TextView content_id = new TextView(ctx);
            content_id.setText(contentdata.getID().toString());
            content_id.setVisibility(View.GONE);
            rowContentTable.addView(content_id);
            
            TextView content_col_id = new TextView(ctx);
            content_col_id.setText(contentdata.getCOL_ID().toString());
            content_col_id.setVisibility(View.GONE);
            rowContentTable.addView(content_col_id);
            
            TextView content_seq = new TextView(ctx);
            content_seq.setText(contentdata.getNEG_SEQ().toString());
            content_seq.setVisibility(View.GONE);
            rowContentTable.addView(content_seq);
            
            TextView content_code = new TextView(ctx);
            content_code.setText(contentdata.getNEG_CODE().toString());
            content_code.setVisibility(View.GONE);
            rowContentTable.addView(content_code);
           negative_tableLayout.addView(rowContentTable);
        }
   }
   public void showConfirmationDelete(final boolean isparent,final String id) {
       AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctx);
       alertDialog.setTitle("Confirm");
       alertDialog.setMessage(R.string.msg_notification_delete);
       alertDialog.setPositiveButton(R.string.str_yes, new DialogInterface.OnClickListener() {
           public void onClick(DialogInterface dialog, int which) {
           	try {
					appr_NegativeProvider.deleteTransaksiById(id);   
	            	viewNegativeList();
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
