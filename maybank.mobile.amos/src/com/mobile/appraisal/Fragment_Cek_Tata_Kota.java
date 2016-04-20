package com.mobile.appraisal;

import java.util.ArrayList;
import java.util.Calendar;

import com.mobile.app.LoginActivity;
import com.mobile.app.configuration.AppConstants;
import com.mobile.app.ui.DatePickerManager;
import com.mobile.app.ui.ListOfValueAdapter;
import com.mobile.bo.app.dataprovider.Appr_Cek_TataKota;
import com.mobile.bo.app.dataprovider.Appr_Collateral;
import com.mobile.bo.app.dataprovider.LOVDataProvider;
import com.mobile.bo.app.datatype.Datatype_Appr_Collateral;
import com.mobile.bo.app.datatype.Datatype_Appr_Rtb_Cek_Tata_Kota_Int;
import com.mobile.framework.activity.ActivityHandler;
import com.mobile.framework.common.DateFormatter;
import com.mobile.framework.common.StringUtility;
import com.mobile.framework.widget.ExSpinner;
import com.mobile.framework.widget.ISpinnerItem;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.support.v4.app.DialogFragment;
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
import android.widget.Toast;

import bii.mobile.amos.R;

@SuppressLint("ResourceAsColor")
public class Fragment_Cek_Tata_Kota extends Fragment {
    public static final int LOADING_DIALOG = 0;
	EditText editText;
    private Appr_Cek_TataKota appr_Cek_Tata_DataProvider=new Appr_Cek_TataKota();
    private Datatype_Appr_Rtb_Cek_Tata_Kota_Int appr_Cek_Tata_data_int = new Datatype_Appr_Rtb_Cek_Tata_Kota_Int();
    private ArrayList<ISpinnerItem> lovcara_pengecekan = new ArrayList<ISpinnerItem>();
    private LOVDataProvider lovDataProvider;
    private Datatype_Appr_Collateral datatype_Appr_Collateral = new Datatype_Appr_Collateral();
    private Appr_Collateral appr_Collateral=new Appr_Collateral();
    private TextView header_deb;
    private TextView header_alamat;
    	
    private EditText cek_tatakota_txt_no_laporan;
    private EditText cek_tatakota_txt_tgl_laporan;
    private EditText cek_tatakota_txt_tgl_pengecekan;
    private EditText cek_tatakota_txt_divisi;
    private EditText cek_tatakota_txt_segment;
    private ExSpinner cek_tatakota_spn_cara_pengecekan;
    private EditText cek_tatakota_txt_nama_petugas;
    private RadioButton cek_tatakota_rdo_wedening_tidak;
    private RadioButton cek_tatakota_rdo_wedening_ya;
    private EditText cek_tatakota_txt_widening;
    private EditText cek_tatakota_txt_line2;
    private RadioButton cek_tatakota_rdo_line_tidak;
    private RadioButton cek_tatakota_rdo_line_ya;
    private EditText cek_tatakota_txt_peruntukan_objek;
    private EditText cek_tatakota_other_info;
    private EditText cek_tatakota_txt_nama_deb;
    private EditText cek_tatakota_txt_alamat_jaminan;
    private EditText cek_tatakota_txt_sertifikatlain;
    private EditText cek_tatakota_txt_nodokumen;
    private EditText cek_tatakota_txt_atasnama;
    private ImageView cek_tatakota_view_img_pengecekan;
    private ImageView cek_tatakota_view_img_tgl_laporan;
    
    View view=null;
    Button Btnsave;
    private Context ctx = null;
    private ProgressDialog dlgProgress = null;
    private String col_id="";
    private String ap_regno="";
    private String status="";
    
    private LinearLayout contentlayout;
    public Fragment_Cek_Tata_Kota() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_cek_tatakota, null);
        ctx = this.getActivity();
        appr_Cek_Tata_DataProvider=new Appr_Cek_TataKota();
        appr_Cek_Tata_data_int = new Datatype_Appr_Rtb_Cek_Tata_Kota_Int();
        appr_Collateral=new Appr_Collateral();
        datatype_Appr_Collateral = new Datatype_Appr_Collateral();
        Bundle b = getArguments();

        
        col_id=b.getString("COL_ID");
        ap_regno=b.getString("AP_REGNO");
        status=b.getString("STATUS");
        initControl();
        loadData();
        //editText = (EditText) view.findViewById(R.id.fragment_edittext_edittext);

        return view;
    }
    private void initControl(){
    	header_deb							=(TextView) view.findViewById(R.id.info_Nama_deb);
    	header_alamat						=(TextView) view.findViewById(R.id.info_Nama_Alamat);
    	 
    	cek_tatakota_txt_no_laporan= (EditText) view.findViewById(R.id.cek_tatakota_txt_no_laporan);
    	cek_tatakota_txt_tgl_laporan= (EditText) view.findViewById(R.id.cek_tatakota_txt_tgl_laporan);
    	cek_tatakota_txt_tgl_pengecekan= (EditText) view.findViewById(R.id.cek_tatakota_txt_tgl_pengecekan);
    	cek_tatakota_txt_divisi= (EditText) view.findViewById(R.id.cek_tatakota_txt_divisi);
    	cek_tatakota_txt_segment= (EditText) view.findViewById(R.id.cek_tatakota_txt_segment);
    	cek_tatakota_spn_cara_pengecekan= (ExSpinner) view.findViewById(R.id.cek_tatakota_spn_cara_pengecekan);
    	cek_tatakota_txt_nama_petugas= (EditText) view.findViewById(R.id.cek_tatakota_txt_nama_petugas);
    	cek_tatakota_rdo_wedening_tidak= (RadioButton) view.findViewById(R.id.cek_tatakota_rdo_wedening_tidak);
    	cek_tatakota_rdo_wedening_ya= (RadioButton) view.findViewById(R.id.cek_tatakota_rdo_wedening_ya);
    	cek_tatakota_txt_widening= (EditText) view.findViewById(R.id.cek_tatakota_txt_wedening);
    	cek_tatakota_txt_line2= (EditText) view.findViewById(R.id.cek_tatakota_txt_line2);
    	cek_tatakota_rdo_line_tidak= (RadioButton) view.findViewById(R.id.cek_tatakota_rdo_line_tidak);
    	cek_tatakota_rdo_line_ya= (RadioButton) view.findViewById(R.id.cek_tatakota_rdo_line_ya);
    	cek_tatakota_txt_peruntukan_objek= (EditText) view.findViewById(R.id.cek_tatakota_txt_peruntukan_objek);
    	cek_tatakota_other_info= (EditText) view.findViewById(R.id.cek_tatakota_other_info);
    	cek_tatakota_txt_nama_deb= (EditText) view.findViewById(R.id.cek_tatakota_txt_nama_deb);
    	cek_tatakota_txt_alamat_jaminan= (EditText) view.findViewById(R.id.cek_tatakota_txt_alamat_jaminan);
    	cek_tatakota_txt_sertifikatlain= (EditText) view.findViewById(R.id.cek_tatakota_txt_sertifikatlain);
    	cek_tatakota_txt_nodokumen= (EditText) view.findViewById(R.id.cek_tatakota_txt_nodokumen);
    	cek_tatakota_txt_atasnama= (EditText) view.findViewById(R.id.cek_tatakota_txt_atasnama);

        lovDataProvider = new LOVDataProvider();
        lovcara_pengecekan = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_PENGECEKAN));
        cek_tatakota_spn_cara_pengecekan.setListOfValue(lovcara_pengecekan, false);
        
        cek_tatakota_view_img_pengecekan= (ImageView) view.findViewById(R.id.cek_tatakota_view_img_pengecekan);
        cek_tatakota_view_img_tgl_laporan= (ImageView) view.findViewById(R.id.cek_tatakota_view_img_tgl_laporan);
        cek_tatakota_view_img_pengecekan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] arrTglLahir = null;

                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = (c.get(Calendar.MONTH));
                int day = c.get(Calendar.DAY_OF_MONTH);
                try{
	                if (cek_tatakota_txt_tgl_pengecekan.getText().toString().equalsIgnoreCase("")) {
	                    arrTglLahir = cek_tatakota_txt_tgl_pengecekan.getText().toString().split("-");
	                    year = Integer.parseInt(arrTglLahir[2]);
	                    month = Integer.parseInt(arrTglLahir[1]) - 1;
	                    day = Integer.parseInt(arrTglLahir[0]);
	                }
                }
                catch(Exception e){
                	
                }
                DatePickerManager datePickerDialog = new DatePickerManager(ctx, Rtbtgl_pengecekanDateSetListener, year, month, day);
                datePickerDialog.show();

            }
        });
        
        cek_tatakota_view_img_tgl_laporan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] arrTglLahir = null;

                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = (c.get(Calendar.MONTH));
                int day = c.get(Calendar.DAY_OF_MONTH);
                try{
	                if (cek_tatakota_txt_tgl_laporan.getText().toString().equalsIgnoreCase("")) {
	                    arrTglLahir = cek_tatakota_txt_tgl_laporan.getText().toString().split("-");
	                    year = Integer.parseInt(arrTglLahir[2]);
	                    month = Integer.parseInt(arrTglLahir[1]) - 1;
	                    day = Integer.parseInt(arrTglLahir[0]);
	                }
                }
                catch(Exception e){
                	
                }
                DatePickerManager datePickerDialog = new DatePickerManager(ctx, Rtbtgl_laporanDateSetListener, year, month, day);
                datePickerDialog.show();

            }
        });
    	Btnsave = (Button) view.findViewById(R.id.btn_savemesin);

    	Btnsave.setOnClickListener(new View.OnClickListener() {
    		 public void onClick(View v) {
    			 showProgressIndicator();
                    new Thread(new Runnable() {
            	            public void run() {
            	                getActivity().runOnUiThread(new Runnable() {
            	                            public void run() {
            	                                saveData();
            	                                hideProgressIndicator();
            	                            }
            	                  });
            	            }
            	        }).start();
           }
        }); 
    	if(status.equals("INQUERY")){
	    	contentlayout= (LinearLayout) view.findViewById(R.id.contentlayout);
	    	cek_tatakota_rdo_line_tidak.setEnabled(false);
	    	cek_tatakota_rdo_line_ya.setEnabled(false);
	    	cek_tatakota_view_img_tgl_laporan.setEnabled(false);
	    	cek_tatakota_view_img_pengecekan.setEnabled(false);
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
    private DatePickerDialog.OnDateSetListener Rtbtgl_laporanDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int monthOfYear, int dayOfMonth) {
        	cek_tatakota_txt_tgl_laporan.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
        }
    };
    private DatePickerDialog.OnDateSetListener Rtbtgl_pengecekanDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int monthOfYear, int dayOfMonth) {
        	cek_tatakota_txt_tgl_pengecekan.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
        }
    };
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
	
    private void setColorMandatory(){
    	//cek_tatakota_txt_no_laporan.setBackgroundResource(R.drawable.fillcolor);
    		
    }
    private Boolean CekMandatory(){
  	  boolean retval=true;
  	  if(cek_tatakota_txt_no_laporan.getText().length()==0){
  		cek_tatakota_txt_no_laporan.setError("Field Tidak Boleh Kososng");
  		  retval=false;
  	  }
  	  return retval;
    }
    private void saveData(){
    	try
    	{
    	
    		/*if(CekMandatory().equals(false)){
    			showAlert(R.string.msg_notification_mandatory);
    		}
	    	else{*/
	    		appr_Cek_Tata_data_int.setCOL_ID(col_id);
	    		appr_Cek_Tata_data_int.setAP_REGNO(ap_regno);
		    	appr_Cek_Tata_data_int.setREPORT_NO(cek_tatakota_txt_no_laporan.getText().toString());
		    	appr_Cek_Tata_data_int.setREPORT_DATE(DateFormatter.formatDate(cek_tatakota_txt_tgl_laporan.getText().toString()));
		    	appr_Cek_Tata_data_int.setREPORT_INSPECT_DATE(DateFormatter.formatDate(cek_tatakota_txt_tgl_pengecekan.getText().toString()));
		    	appr_Cek_Tata_data_int.setREPORT_BRANCH_CODE(cek_tatakota_txt_divisi.getText().toString());
		    	appr_Cek_Tata_data_int.setREPORT_SEG_CODE(cek_tatakota_txt_segment.getText().toString());
		    	appr_Cek_Tata_data_int.setINSPECT_WAY(cek_tatakota_spn_cara_pengecekan.getSelectedListOfValue().toString());
		    	appr_Cek_Tata_data_int.setINSPECTOR_NAME(cek_tatakota_txt_nama_petugas.getText().toString());
		    	if(cek_tatakota_rdo_wedening_tidak.isChecked())
		    		appr_Cek_Tata_data_int.setWIDENING(AppConstants.RDOTIDAK);
		    	else if(cek_tatakota_rdo_wedening_ya.isChecked())
		    		appr_Cek_Tata_data_int.setWIDENING(AppConstants.RDOTIDAK);
		    	
		    	appr_Cek_Tata_data_int.setWIDENING_DESC(cek_tatakota_txt_widening.getText().toString());
		    	if(cek_tatakota_rdo_line_tidak.isChecked())
		    		appr_Cek_Tata_data_int.setLINE_VIOLATE(AppConstants.RDOTIDAK);
		    	else if(cek_tatakota_rdo_line_ya.isChecked())
		    		appr_Cek_Tata_data_int.setLINE_VIOLATE(AppConstants.RDOYA);
		    	
		    	
		    	appr_Cek_Tata_data_int.setLINE_VIOLATE_DESC(cek_tatakota_txt_line2.getText().toString());
		    	appr_Cek_Tata_data_int.setOBJECT_PURPOSE(cek_tatakota_txt_peruntukan_objek.getText().toString());
		    	appr_Cek_Tata_data_int.setOTHER_INFORMATION(cek_tatakota_other_info.getText().toString());
		    	appr_Cek_Tata_data_int.setCU_NAME(cek_tatakota_txt_nama_deb.getText().toString());
		    	appr_Cek_Tata_data_int.setCOL_ADDR1(cek_tatakota_txt_alamat_jaminan.getText().toString());
		    	appr_Cek_Tata_data_int.setDOC_DESC(cek_tatakota_txt_sertifikatlain.getText().toString());
		    	appr_Cek_Tata_data_int.setCOL_DOK_NO(cek_tatakota_txt_nodokumen.getText().toString());
		    	appr_Cek_Tata_data_int.setCOL_DOK_NAME(cek_tatakota_txt_atasnama.getText().toString());
		
		    	appr_Cek_Tata_DataProvider.updateData(appr_Cek_Tata_data_int);
		    	showAlert(R.string.msg_notification_update_success);
	       //}
    	}
    	catch(Exception ex){
    		showAlert(R.string.msg_notification_submit_error);
    	}
    }
    private void loadData(){
    	appr_Cek_Tata_data_int=appr_Cek_Tata_DataProvider.getAllAppr_Cek_TataKota_Int(col_id);
      	if(appr_Cek_Tata_data_int.COL_ID!=null && !appr_Cek_Tata_data_int.COL_ID.equals("")){
      		datatype_Appr_Collateral=appr_Collateral.getAllAppr_Collateral(col_id);
      		if(datatype_Appr_Collateral.COL_ID!=null && !datatype_Appr_Collateral.COL_ID.toString().equals("")){
      			header_alamat.setText(datatype_Appr_Collateral.getCOL_ADDR1() + " , " +  datatype_Appr_Collateral.getCOL_KELURAHAN() + " , " +  datatype_Appr_Collateral.getCOL_KECAMATAN() + " , " +  datatype_Appr_Collateral.getCOL_CITY() + " , " +  datatype_Appr_Collateral.getCOL_ZIPCODE());
      		    header_deb.setText(datatype_Appr_Collateral.getAP_REGNO() + " # " + datatype_Appr_Collateral.getCU_NAME() );
      		}
      		cek_tatakota_txt_no_laporan.setText(appr_Cek_Tata_data_int.getREPORT_NO());
      		if(appr_Cek_Tata_data_int.getREPORT_DATE()!=null)
      			cek_tatakota_txt_tgl_laporan.setText(DateFormatter.formatString(appr_Cek_Tata_data_int.getREPORT_DATE()));
      		if(appr_Cek_Tata_data_int.getREPORT_INSPECT_DATE()!=null)
      			cek_tatakota_txt_tgl_pengecekan.setText(DateFormatter.formatString(appr_Cek_Tata_data_int.getREPORT_INSPECT_DATE()));
      		
      		cek_tatakota_txt_divisi.setText(appr_Cek_Tata_data_int.getREPORT_BRANCH_CODE());
      		cek_tatakota_txt_segment.setText(appr_Cek_Tata_data_int.getREPORT_SEG_CODE());
      		cek_tatakota_spn_cara_pengecekan.setSelectedListOfValue(appr_Cek_Tata_data_int.getINSPECT_WAY());
      		cek_tatakota_txt_nama_petugas.setText(appr_Cek_Tata_data_int.getINSPECTOR_NAME());
      		cek_tatakota_txt_widening.setText(appr_Cek_Tata_data_int.getWIDENING_DESC());
      		cek_tatakota_txt_line2.setText(appr_Cek_Tata_data_int.getLINE_VIOLATE_DESC());
      		cek_tatakota_txt_peruntukan_objek.setText(appr_Cek_Tata_data_int.getOBJECT_PURPOSE());
      		cek_tatakota_other_info.setText(appr_Cek_Tata_data_int.getOTHER_INFORMATION());
      		cek_tatakota_txt_nama_deb.setText(appr_Cek_Tata_data_int.getCU_NAME());
      		cek_tatakota_txt_alamat_jaminan.setText(appr_Cek_Tata_data_int.getCOL_ADDR1());
      		cek_tatakota_txt_sertifikatlain.setText(appr_Cek_Tata_data_int.getDOC_DESC());
      		cek_tatakota_txt_nodokumen.setText(appr_Cek_Tata_data_int.getCOL_DOK_NO());
      		cek_tatakota_txt_atasnama.setText(appr_Cek_Tata_data_int.getCOL_DOK_NAME());

      		if(appr_Cek_Tata_data_int.getWIDENING().equals(AppConstants.RDOTIDAK))
      			cek_tatakota_rdo_wedening_tidak.setChecked(true);
        	else if(appr_Cek_Tata_data_int.getWIDENING().equals(AppConstants.RDOYA))
        			cek_tatakota_rdo_wedening_ya.setChecked(true);
        	
        	if(appr_Cek_Tata_data_int.getLINE_VIOLATE().equals(AppConstants.RDOTIDAK))
        		cek_tatakota_rdo_line_tidak.setChecked(true);
        	else if(appr_Cek_Tata_data_int.getLINE_VIOLATE().equals(AppConstants.RDOYA))
        		cek_tatakota_rdo_line_ya.setChecked(true);
    	
      	}
    }
   
    @SuppressWarnings("deprecation")
    public void showProgressIndicator() {
        if (dlgProgress == null) {
            dlgProgress = new ProgressDialog(getActivity());
            dlgProgress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dlgProgress.setTitle(getString(R.string.str_informasi));
            dlgProgress.setMessage("Sedang Memproses Data");
            dlgProgress.setCancelable(false);
            dlgProgress.setButton(getString(R.string.str_cancel), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                        	getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    dlgProgress.setMessage("Data Sedang Dimuat");
                                }
                            });
                        }
                    }).start();
                }
            });
            dlgProgress.show();
        }
    }

    public void hideProgressIndicator() {
        if (dlgProgress != null) {
            dlgProgress.dismiss();
        }
    }
    
    
}

