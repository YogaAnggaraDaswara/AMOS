package com.mobile.appraisal;

import java.util.ArrayList;

import com.mobile.app.configuration.AppConstants;
import com.mobile.app.ui.ListOfValueAdapter;
import com.mobile.bo.app.dataprovider.Appr_Vhc_DataDataProvider;
import com.mobile.bo.app.dataprovider.LOVDataProvider;
import com.mobile.bo.app.datatype.Datatype_Appr_Vch_Data_Int;
import com.mobile.framework.widget.ExSpinner;
import com.mobile.framework.widget.ISpinnerItem;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.AlertDialog;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import bii.mobile.amos.R;

public class Fragment_Data_Kendaraan extends Fragment {
    EditText editText;
    private Appr_Vhc_DataDataProvider appr_Vhc_DataProvider=new Appr_Vhc_DataDataProvider();
    private Datatype_Appr_Vch_Data_Int appr_Vhc_data_int = new Datatype_Appr_Vch_Data_Int();
    private ArrayList<ISpinnerItem> lovtranspor = new ArrayList<ISpinnerItem>();
    private LOVDataProvider lovDataProvider;

    private EditText data_kendaraan_txt_merek_jaminan;
    private EditText data_kendaraan_txt_merek_kendaraan;
    private EditText data_kendaraan_txt_tahun_kendaraan;
    private EditText data_kendaraan_txt_warna_kendaraan;
    private EditText data_kendaraan_txt_no_rangka;
    private EditText data_kendaraan_txt_no_mesin;
    private EditText data_kendaraan_txt_no_polisi;
    private ExSpinner data_kendaraan_spn_kondisi_kendaraan;
    private RadioButton data_kendaraan_rdo_lokasi_automatic;
    private CheckBox data_kendaraan_chk_radio;
    private CheckBox data_kendaraan_chk_cd;
    private CheckBox data_kendaraan_chk_alarm;
    private CheckBox data_kendaraan_chk_ac;
    private CheckBox data_kendaraan_chk_power_windows;
    private CheckBox data_kendaraan_chk_velg;
    private EditText data_kendaraan_txt_perlengkapan;
    private RadioButton data_kendaraan_rdo_manual;
    View view=null;
    Button Btnsave;
    private Context ctx = null;
    private String col_id="";
    private String ap_regno="";
    private String status="";
    private LinearLayout contentlayout;
    public Fragment_Data_Kendaraan() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_data_kendaraan, null);
        ctx = this.getActivity();
        appr_Vhc_DataProvider=new Appr_Vhc_DataDataProvider();
        appr_Vhc_data_int = new Datatype_Appr_Vch_Data_Int();
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

    	data_kendaraan_spn_kondisi_kendaraan= (ExSpinner) view.findViewById(R.id.data_kendaraan_spn_kondisi_kendaraan);
    	lovDataProvider = new LOVDataProvider();
        lovtranspor = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_KONDISI_KENDARAAN));
        data_kendaraan_spn_kondisi_kendaraan.setListOfValue(lovtranspor, false);
        
        
    	data_kendaraan_txt_merek_jaminan= (EditText) view.findViewById(R.id.data_kendaraan_txt_merek_jaminan);
    	data_kendaraan_txt_merek_kendaraan= (EditText) view.findViewById(R.id.data_kendaraan_txt_merek_kendaraan);
    	data_kendaraan_txt_tahun_kendaraan= (EditText) view.findViewById(R.id.data_kendaraan_txt_tahun_kendaraan);
    	data_kendaraan_txt_warna_kendaraan= (EditText) view.findViewById(R.id.data_kendaraan_txt_warna_kendaraan);
    	data_kendaraan_txt_no_rangka= (EditText) view.findViewById(R.id.data_kendaraan_txt_no_rangka);
    	data_kendaraan_txt_no_mesin= (EditText) view.findViewById(R.id.data_kendaraan_txt_no_mesin);
    	data_kendaraan_txt_no_polisi= (EditText) view.findViewById(R.id.data_kendaraan_txt_no_polisi);
    	data_kendaraan_rdo_lokasi_automatic= (RadioButton) view.findViewById(R.id.data_kendaraan_rdo_automatic);
    	data_kendaraan_rdo_manual= (RadioButton) view.findViewById(R.id.data_kendaraan_rdo_manual);
    	data_kendaraan_chk_radio= (CheckBox) view.findViewById(R.id.data_kendaraan_chk_radio);
    	data_kendaraan_chk_cd= (CheckBox) view.findViewById(R.id.data_kendaraan_chk_cd);
    	data_kendaraan_chk_alarm= (CheckBox) view.findViewById(R.id.data_kendaraan_chk_alarm);
    	data_kendaraan_chk_ac= (CheckBox) view.findViewById(R.id.data_kendaraan_chk_ac);
    	data_kendaraan_chk_power_windows= (CheckBox) view.findViewById(R.id.data_kendaraan_chk_power_windows);
    	data_kendaraan_chk_velg= (CheckBox) view.findViewById(R.id.data_kendaraan_chk_velg);
    	data_kendaraan_txt_perlengkapan= (EditText) view.findViewById(R.id.data_kendaraan_txt_perlengkapan);

    	Btnsave = (Button) view.findViewById(R.id.btn_savedataken);

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
    	setColorMandatory();
    	if(status.equals("INQUERY")){
	    	contentlayout= (LinearLayout) view.findViewById(R.id.contentlayout);
	    	data_kendaraan_rdo_lokasi_automatic.setEnabled(false);
	    	data_kendaraan_rdo_manual.setEnabled(false);
	    	data_kendaraan_chk_radio.setEnabled(false);
	    	data_kendaraan_chk_cd.setEnabled(false);
	    	data_kendaraan_chk_alarm.setEnabled(false);
	    	data_kendaraan_chk_ac.setEnabled(false);
	    	data_kendaraan_chk_power_windows.setEnabled(false);
	    	data_kendaraan_chk_velg.setEnabled(false);
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
		    	    if (v instanceof CheckBox) {
		    	    	 ((CheckBox)v).setVisibility(View.GONE);
		 	        	
		    	    }
		    	   
	    	    }
	    	}
    	}
    }
    private void setColorMandatory(){
    	data_kendaraan_txt_merek_jaminan.setBackgroundResource(R.drawable.fillcolor);
    	data_kendaraan_txt_merek_kendaraan.setBackgroundResource(R.drawable.fillcolor);
    	data_kendaraan_txt_tahun_kendaraan.setBackgroundResource(R.drawable.fillcolor);
    	data_kendaraan_txt_warna_kendaraan.setBackgroundResource(R.drawable.fillcolor);
    	data_kendaraan_txt_no_rangka.setBackgroundResource(R.drawable.fillcolor);
    	data_kendaraan_txt_no_mesin.setBackgroundResource(R.drawable.fillcolor);
    	data_kendaraan_txt_no_polisi.setBackgroundResource(R.drawable.fillcolor);	
    }
    private Boolean CekMandatory(){
  	  boolean retval=true;
  	appr_Vhc_data_int=appr_Vhc_DataProvider.getAllAppr_Vhc_Data_Int(col_id);
  	if(appr_Vhc_data_int.COL_ID!=null && !appr_Vhc_data_int.COL_ID.equals("")){
		if(appr_Vhc_data_int.VHC_CODE==null || appr_Vhc_data_int.VHC_CODE.equals(""))
  			retval=false;
		if(appr_Vhc_data_int.VHC_BRAND_CODE==null || appr_Vhc_data_int.VHC_BRAND_CODE.equals(""))
  			retval=false;
		if(appr_Vhc_data_int.YEAR_CREATED==null || appr_Vhc_data_int.YEAR_CREATED.equals(""))
  			retval=false;
		if(appr_Vhc_data_int.COLOR_CODE==null || appr_Vhc_data_int.COLOR_CODE.equals(""))
  			retval=false;
			
		if(appr_Vhc_data_int.FRAME_NO==null || appr_Vhc_data_int.FRAME_NO.equals(""))
  			retval=false;
		if(appr_Vhc_data_int.MACHINE_NO==null || appr_Vhc_data_int.MACHINE_NO.equals(""))
  			retval=false;
			
		if(appr_Vhc_data_int.POLICE_NO==null || appr_Vhc_data_int.POLICE_NO.equals(""))
  			retval=false;
		if(appr_Vhc_data_int.VHC_PHYSIC_COND_CODE==null || appr_Vhc_data_int.VHC_PHYSIC_COND_CODE.equals(""))
  			retval=false;
			
	}
  	  /*if(data_kendaraan_txt_merek_jaminan.getText().length()==0){
  		data_kendaraan_txt_merek_jaminan.setError("Field Tidak Boleh Kososng");
  		  retval=false;
  	  }
  	  if(data_kendaraan_txt_merek_kendaraan.getText().length()==0){
  		data_kendaraan_txt_merek_kendaraan.setError("Field Tidak Boleh Kososng");
  		  retval=false;
  	  }
  	  if(data_kendaraan_txt_tahun_kendaraan.getText().length()==0){
  		data_kendaraan_txt_tahun_kendaraan.setError("Field Tidak Boleh Kososng");
  		  retval=false;
  	  }
  	  if(data_kendaraan_txt_warna_kendaraan.getText().length()==0){
  		data_kendaraan_txt_warna_kendaraan.setError("Field Tidak Boleh Kososng");
  		  retval=false;
  	  }
  	  if(data_kendaraan_txt_no_rangka.getText().length()==0){
  		data_kendaraan_txt_no_rangka.setError("Field Tidak Boleh Kososng");
  		  retval=false;
  	  }
  	  if(data_kendaraan_txt_no_mesin.getText().length()==0){
  		data_kendaraan_txt_no_mesin.setError("Field Tidak Boleh Kososng");
  		  retval=false;
  	  }
  	  if(data_kendaraan_txt_no_polisi.getText().length()==0){
  		data_kendaraan_txt_no_polisi.setError("Field Tidak Boleh Kososng");
  		  retval=false;
  	  }
  	 
  	  View selectedView = data_kendaraan_spn_kondisi_kendaraan.getSelectedView();
	  if (selectedView != null && selectedView instanceof TextView) {
	      TextView selectedTextView = (TextView) selectedView;
	      if (data_kendaraan_spn_kondisi_kendaraan.getSelectedListOfValue().toString().length()==0) {
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

    	appr_Vhc_data_int.setCOL_ID(col_id);
    	appr_Vhc_data_int.setAP_REGNO(ap_regno);
    	appr_Vhc_data_int.setVHC_CODE(data_kendaraan_txt_merek_jaminan.getText().toString());
    	appr_Vhc_data_int.setVHC_BRAND_CODE(data_kendaraan_txt_merek_kendaraan.getText().toString());
    	appr_Vhc_data_int.setYEAR_CREATED(data_kendaraan_txt_tahun_kendaraan.getText().toString());
    	appr_Vhc_data_int.setCOLOR_CODE(data_kendaraan_txt_warna_kendaraan.getText().toString());
    	appr_Vhc_data_int.setFRAME_NO(data_kendaraan_txt_no_rangka.getText().toString());
    	appr_Vhc_data_int.setMACHINE_NO(data_kendaraan_txt_no_mesin.getText().toString());
    	appr_Vhc_data_int.setPOLICE_NO(data_kendaraan_txt_no_polisi.getText().toString());
    	appr_Vhc_data_int.setVHC_PHYSIC_COND_CODE(data_kendaraan_spn_kondisi_kendaraan.getSelectedListOfValue().toString());
    	if(data_kendaraan_rdo_lokasi_automatic.isChecked()){
    		appr_Vhc_data_int.setTRANSMISION(AppConstants.RDOA);
    	}
    	else if(data_kendaraan_rdo_manual.isChecked()){
    		appr_Vhc_data_int.setTRANSMISION(AppConstants.RDOM);
    	}
    	if(data_kendaraan_chk_radio.isChecked())
    		appr_Vhc_data_int.setRADIO_TAPE(AppConstants.RDOYA);
    	else
    		appr_Vhc_data_int.setRADIO_TAPE(AppConstants.RDOTIDAK);
    	
    	if(data_kendaraan_chk_cd.isChecked())
    		appr_Vhc_data_int.setCD_PLAYER(AppConstants.RDOYA);
    	else
    		appr_Vhc_data_int.setCD_PLAYER(AppConstants.RDOTIDAK);
    	
    	if(data_kendaraan_chk_alarm.isChecked())
    		appr_Vhc_data_int.setALARM(AppConstants.RDOYA);
    	else
    		appr_Vhc_data_int.setALARM(AppConstants.RDOTIDAK);
    	if(data_kendaraan_chk_ac.isChecked())
    		appr_Vhc_data_int.setAC(AppConstants.RDOYA);
    	else
    		appr_Vhc_data_int.setAC(AppConstants.RDOTIDAK);
    	if(data_kendaraan_chk_power_windows.isChecked())	
    		appr_Vhc_data_int.setPOWER_WINDOW(AppConstants.RDOYA);
    	else
    		appr_Vhc_data_int.setPOWER_WINDOW(AppConstants.RDOTIDAK);
    	if(data_kendaraan_chk_velg.isChecked())
    		appr_Vhc_data_int.setVELG_RACING(AppConstants.RDOYA);
    	else
    		appr_Vhc_data_int.setVELG_RACING(AppConstants.RDOTIDAK);
    	
    	appr_Vhc_data_int.setS_LAIN_LAIN(data_kendaraan_txt_perlengkapan.getText().toString());

    	appr_Vhc_DataProvider.updateData(appr_Vhc_data_int);
    	showAlert(R.string.msg_notification_update_success);
    	//if(CekMandatory().equals(false)){
    	//	showAlert(R.string.msg_notification_mandatory);
    	//}
    	
    }
    private void loadData(){
    	appr_Vhc_data_int=appr_Vhc_DataProvider.getAllAppr_Vhc_Data_Int(col_id);
      	if(appr_Vhc_data_int.COL_ID!=null && !appr_Vhc_data_int.COL_ID.equals("")){
      		data_kendaraan_txt_merek_jaminan.setText(appr_Vhc_data_int.getVHC_CODE());
	    	data_kendaraan_txt_merek_kendaraan.setText(appr_Vhc_data_int.getVHC_BRAND_CODE());
	    	data_kendaraan_txt_tahun_kendaraan.setText(appr_Vhc_data_int.getYEAR_CREATED());
	    	data_kendaraan_txt_warna_kendaraan.setText(appr_Vhc_data_int.getCOLOR_CODE());
	    	data_kendaraan_txt_no_rangka.setText(appr_Vhc_data_int.getFRAME_NO());
	    	data_kendaraan_txt_no_mesin.setText(appr_Vhc_data_int.getMACHINE_NO());
	    	data_kendaraan_txt_no_polisi.setText(appr_Vhc_data_int.getPOLICE_NO());
	    	data_kendaraan_spn_kondisi_kendaraan.setSelectedListOfValue(appr_Vhc_data_int.getVHC_PHYSIC_COND_CODE());
	    	
	    	if(appr_Vhc_data_int.getRADIO_TAPE().equals(AppConstants.RDOYA))
	    		data_kendaraan_chk_radio.setChecked(true);
	    	if(appr_Vhc_data_int.getCD_PLAYER().equals(AppConstants.RDOYA))
	    		data_kendaraan_chk_cd.setChecked(true);
	    	if(appr_Vhc_data_int.getALARM().equals(AppConstants.RDOYA))
	    		data_kendaraan_chk_alarm.setChecked(true);
	    	if(appr_Vhc_data_int.getAC().equals(AppConstants.RDOYA))
	    		data_kendaraan_chk_ac.setChecked(true);
	    	if(appr_Vhc_data_int.getPOWER_WINDOW().equals(AppConstants.RDOYA))
	    		data_kendaraan_chk_power_windows.setChecked(true);
	    	if(appr_Vhc_data_int.getVELG_RACING().equals(AppConstants.RDOYA))
	    		data_kendaraan_chk_velg.setChecked(true);
	    	
	    	
	    	data_kendaraan_txt_perlengkapan.setText(appr_Vhc_data_int.getS_LAIN_LAIN());
	    	
	    	if(appr_Vhc_data_int.getTRANSMISION().equals("A")){
	    		data_kendaraan_rdo_lokasi_automatic.setChecked(true);
	    	}
	    	else if(appr_Vhc_data_int.getTRANSMISION().equals("M")){
	    		data_kendaraan_rdo_manual.setChecked(true);
	    	}
    	
      	}
    }
}
