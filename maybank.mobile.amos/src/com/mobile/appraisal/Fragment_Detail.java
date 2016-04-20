package com.mobile.appraisal;

import java.util.ArrayList;
import java.util.Calendar;

import com.mobile.app.MainActivity;
import com.mobile.app.configuration.AppConstants;
import com.mobile.app.ui.DatePickerManager;
import com.mobile.app.ui.ListOfValueAdapter;
import com.mobile.bo.app.dataprovider.Appr_Collateral;
import com.mobile.bo.app.dataprovider.Appr_ImbProvider;
import com.mobile.bo.app.dataprovider.Appr_Rtb_DetailProvider;
import com.mobile.bo.app.dataprovider.Appr_SertifikatProvider;
import com.mobile.bo.app.dataprovider.LOVDataProvider;
import com.mobile.bo.app.datatype.Datatype_Appr_Collateral;
import com.mobile.bo.app.datatype.Datatype_Appr_Rtb_Detail_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_Sertifikat;
import com.mobile.bo.app.datatype.Datatype_Appr_imb;
import com.mobile.framework.common.DateFormatter;
import com.mobile.framework.widget.ExSpinner;
import com.mobile.framework.widget.ISpinnerItem;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import bii.mobile.amos.R;

public class Fragment_Detail extends Fragment {
    View view=null;
    Button Btnsave,btn_new;
    private Context ctx = null;
    private ProgressDialog dlgProgress = null;
    private Appr_Rtb_DetailProvider appr_Detail_DataProvider=new Appr_Rtb_DetailProvider();
    private Appr_ImbProvider appr_ImbProvider=new Appr_ImbProvider();
    private Appr_SertifikatProvider appr_SertifikatProvider=new Appr_SertifikatProvider();
    private Datatype_Appr_Rtb_Detail_Int appr_Rtb_detail_int = new Datatype_Appr_Rtb_Detail_Int();
    private LOVDataProvider lovDataProvider;
    private Datatype_Appr_Collateral datatype_Appr_Collateral = new Datatype_Appr_Collateral();
    private Appr_Collateral appr_Collateral=new Appr_Collateral();
    private TextView header_deb;
    private TextView header_alamat;
    private ArrayList<ISpinnerItem> lovlandshape = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovlandcontour = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovlandpurpose = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovlandrange = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovconst_inti = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovconst_floor = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovconst_wall = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovconst_ceiling = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovbuilding_type = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovbuilding_condotion = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovjns_sertifikat = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovconst_roof = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovconst_pam = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovconst_phone = new ArrayList<ISpinnerItem>();
    
    private ExSpinner val_rtb_spn_land_shape;
    private ExSpinner val_rtb_spn_land_contour;
    private ExSpinner val_rtb_spn_land_purpose;
    private ExSpinner val_rtb_spn_land_range;
    private ExSpinner val_rtb_spn_const_inti;
    private ExSpinner val_rtb_spn_const_floor;
    private ExSpinner val_rtb_spn_const_wall;
    private ExSpinner val_rtb_spn_const_ceiling;
    private ExSpinner val_rtb_spn_building_type;
    private ExSpinner val_rtb_spn_building_condotion;
    private ExSpinner val_rtb_spn_jns_sertifikat;
    private ExSpinner val_rtb_spn_const_roof;
    private ExSpinner val_rtb_spn_avail_pdam;
    private ExSpinner val_rtb_spn_avail_phone;
    
    private EditText val_rtb_txt_an_sertifikat;
    private EditText val_rtb_txt_no_sertifikat;
   
    private EditText val_rtb_txt_tgl_expire;
    private EditText val_rtb_txt_land_area;
    private EditText val_rtb_txt_north_boundary;
    private EditText val_rtb_txt_south_boundary;
   
    private EditText val_rtb_txt_east_boundary;
    private EditText val_rtb_txt_west_boundary;
    
    private EditText val_rtb_txt_building_area;
   
   
    private EditText val_rtb_txt_avail_pln;
    private EditText val_rtb_txt_avail_genset;

    private EditText val_rtb_txt_purpose_not_imb;
    private EditText val_rtb_txt_const_progress;
    private EditText val_rtb_txt_const_lantai;
    private EditText val_rtb_txt_const_tahun;
    private EditText val_rtb_txt_land_range;
    private RadioButton val_rtb_rdo_air_ada;
	private RadioButton val_rtb_rdo_air_tidak;
	private ImageView val_rtb_view_img_tgl_tgl_expire;
	private TableLayout inbox_tableLayout;
	private TableLayout dok_tableLayout;
    private ArrayList<Datatype_Appr_imb> listdataimb  = null;
    private Datatype_Appr_imb data_imb  = null;
    private Datatype_Appr_Sertifikat data_sertifikat  = null;
    private ArrayList<Datatype_Appr_Sertifikat> listdatasertifikat  = null;

    
    private Fragment_Detail_IMB_Dialog fragment_Detail_IMB_Dialog=null; 
    private String col_id="";
    private String ap_regno="";
	private String col_type="";
	private String status="";
	private LinearLayout contentlayout;
    public Fragment_Detail() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detail, null);
        ctx = this.getActivity();
        inbox_tableLayout = (TableLayout) view.findViewById(R.id.inbox_tableLayout);
        dok_tableLayout= (TableLayout) view.findViewById(R.id.dok_tableLayout);
        appr_Detail_DataProvider=new Appr_Rtb_DetailProvider();
        appr_Rtb_detail_int = new Datatype_Appr_Rtb_Detail_Int();
        appr_SertifikatProvider=new Appr_SertifikatProvider();
        fragment_Detail_IMB_Dialog=new Fragment_Detail_IMB_Dialog(ctx);
        appr_Collateral=new Appr_Collateral();
        datatype_Appr_Collateral = new Datatype_Appr_Collateral();
        
        data_imb=new Datatype_Appr_imb();
        Bundle b = getArguments();
        col_id=b.getString("COL_ID");
        ap_regno=b.getString("AP_REGNO");
        col_type=b.getString("COL_TYPE");
        status=b.getString("STATUS");
        initControl();
        
        loadData();
        viewdataImb();
        viewdataSertifikat();
        return view;
    }
    private void initControl(){
    	header_deb							=(TextView) view.findViewById(R.id.info_Nama_deb);
    	header_alamat						=(TextView) view.findViewById(R.id.info_Nama_Alamat);
    	    	
    	val_rtb_view_img_tgl_tgl_expire= (ImageView) view.findViewById(R.id.val_rtb_view_img_tgl_tgl_expire);
    	val_rtb_txt_an_sertifikat= (EditText) view.findViewById(R.id.val_rtb_txt_an_sertifikat);
    	val_rtb_txt_no_sertifikat= (EditText) view.findViewById(R.id.val_rtb_txt_no_sertifikat);
    	val_rtb_txt_tgl_expire= (EditText) view.findViewById(R.id.val_rtb_txt_tgl_expire);
    	val_rtb_txt_land_area= (EditText) view.findViewById(R.id.val_rtb_txt_land_area);
    	val_rtb_txt_north_boundary= (EditText) view.findViewById(R.id.val_rtb_txt_north_boundary);
    	val_rtb_txt_south_boundary= (EditText) view.findViewById(R.id.val_rtb_txt_south_boundary);
    	
    	val_rtb_spn_jns_sertifikat= (ExSpinner) view.findViewById(R.id.val_rtb_spn_jns_sertifikat);
    	val_rtb_spn_land_shape= (ExSpinner) view.findViewById(R.id.val_rtb_spn_land_shape);
    	val_rtb_spn_land_contour= (ExSpinner) view.findViewById(R.id.val_rtb_spn_land_contour);
    	val_rtb_spn_land_purpose= (ExSpinner) view.findViewById(R.id.val_rtb_spn_land_purpose);
    	val_rtb_spn_land_range= (ExSpinner) view.findViewById(R.id.val_rtb_spn_land_range);
    	val_rtb_spn_building_type= (ExSpinner) view.findViewById(R.id.val_rtb_spn_building_type);
    	val_rtb_spn_building_condotion= (ExSpinner) view.findViewById(R.id.val_rtb_spn_building_condotion);
    	val_rtb_spn_const_inti= (ExSpinner) view.findViewById(R.id.val_rtb_spn_const_inti);
    	val_rtb_spn_const_floor= (ExSpinner) view.findViewById(R.id.val_rtb_spn_const_floor);
    	val_rtb_spn_const_wall= (ExSpinner) view.findViewById(R.id.val_rtb_spn_const_wall);
    	val_rtb_spn_const_ceiling= (ExSpinner) view.findViewById(R.id.val_rtb_spn_const_ceiling);
    	val_rtb_spn_const_roof= (ExSpinner) view.findViewById(R.id.val_rtb_spn_const_roof);
    	val_rtb_spn_avail_pdam= (ExSpinner) view.findViewById(R.id.val_rtb_spn_avail_pdam);
    	val_rtb_spn_avail_phone= (ExSpinner) view.findViewById(R.id.val_rtb_spn_avail_phone);
    	
    	val_rtb_txt_east_boundary= (EditText) view.findViewById(R.id.val_rtb_txt_east_boundary);
    	val_rtb_txt_west_boundary= (EditText) view.findViewById(R.id.val_rtb_txt_west_boundary);
    	val_rtb_txt_building_area= (EditText) view.findViewById(R.id.val_rtb_txt_building_area);
    	
    	val_rtb_txt_avail_pln= (EditText) view.findViewById(R.id.val_rtb_txt_avail_pln);
    	val_rtb_txt_avail_genset= (EditText) view.findViewById(R.id.val_rtb_txt_avail_genset);
    
    	val_rtb_txt_purpose_not_imb= (EditText) view.findViewById(R.id.val_rtb_txt_purpose_not_imb);
    	val_rtb_txt_const_progress= (EditText) view.findViewById(R.id.val_rtb_txt_const_progress);
    	val_rtb_txt_const_lantai= (EditText) view.findViewById(R.id.val_rtb_txt_const_lantai);
    	val_rtb_txt_const_tahun= (EditText) view.findViewById(R.id.val_rtb_txt_const_tahun);
    	val_rtb_txt_land_range= (EditText) view.findViewById(R.id.val_rtb_txt_land_range);
    	
    	val_rtb_rdo_air_ada= (RadioButton) view.findViewById(R.id.val_rtb_rdo_air_ada);
    	val_rtb_rdo_air_tidak= (RadioButton) view.findViewById(R.id.val_rtb_rdo_air_tidak);
    	    	  
    	lovDataProvider = new LOVDataProvider();
    	lovlandshape = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_LAND_SHAPE));
    	val_rtb_spn_land_shape.setListOfValue(lovlandshape, false);
             
    	lovlandcontour = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_LAND_CONTOUR));
    	val_rtb_spn_land_contour.setListOfValue(lovlandcontour, false);
             
    	lovlandpurpose = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_LANDPURPOSE));
    	val_rtb_spn_land_purpose.setListOfValue(lovlandpurpose, false);
    	
    	lovlandrange = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_RANGE_ROAD));
    	val_rtb_spn_land_range.setListOfValue(lovlandrange, false);
    	
    	lovconst_inti = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_CONST_INTI));
    	val_rtb_spn_const_inti.setListOfValue(lovconst_inti, false);
    	
    	lovconst_floor = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_CONST_FLOOR));
    	val_rtb_spn_const_floor.setListOfValue(lovconst_floor, false);
    	
    	lovconst_wall = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_CONST_WALL));
    	val_rtb_spn_const_wall.setListOfValue(lovconst_wall, false);
    	
    	lovconst_ceiling = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_CONST_CEILING));
    	val_rtb_spn_const_ceiling.setListOfValue(lovconst_ceiling, false);
    	
    	lovbuilding_type = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_BUILDING_TYPE));
    	val_rtb_spn_building_type.setListOfValue(lovbuilding_type, false);
    	
    	lovbuilding_condotion = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_BUILDING_CONDITION));
    	val_rtb_spn_building_condotion.setListOfValue(lovbuilding_condotion, false);
    	
        if(col_type.equals("MHC"))
        	lovjns_sertifikat = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_CERTIFICATE_MHC));
        
        if(col_type.equals("RE"))
        	lovjns_sertifikat = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_CERTIFICATE_RE));
        
        if(col_type.equals("STK"))
        	lovjns_sertifikat = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_CERTIFICATE_STK));
        
        if(col_type.equals("VER"))
        	lovjns_sertifikat = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_CERTIFICATE_VER));
      
    	val_rtb_spn_jns_sertifikat.setListOfValue(lovjns_sertifikat, false);
    	
    	lovconst_roof = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_CONST_ROOF));
    	val_rtb_spn_const_roof.setListOfValue(lovconst_roof, false);
    	
    	lovconst_pam = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_AVAIL_PDAM));
    	val_rtb_spn_avail_pdam.setListOfValue(lovconst_pam, false);
    	
    	lovconst_phone = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_AVAIL_PHONE));
    	val_rtb_spn_avail_phone.setListOfValue(lovconst_phone, false);
    	btn_new= (Button) view.findViewById(R.id.btn_new);

    	btn_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            
            	fragment_Detail_IMB_Dialog.setData_kendaraan_txt_id("");
            	fragment_Detail_IMB_Dialog.setData_kendaraan_txt_no_imb("");
            	fragment_Detail_IMB_Dialog.setVal_kendaraan_txt_tgl_imb("");
            	fragment_Detail_IMB_Dialog.setData_kendaraan_txt_peruntukan("");
            	
            	fragment_Detail_IMB_Dialog.show();
           }
        }); 
    	
    	Btnsave = (Button) view.findViewById(R.id.btn_savedetail);

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
    	
    	val_rtb_view_img_tgl_tgl_expire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] arrTglLahir = null;

                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = (c.get(Calendar.MONTH));
                int day = c.get(Calendar.DAY_OF_MONTH);
                try{
	                if (val_rtb_txt_tgl_expire.getText().toString().equalsIgnoreCase("")) {
	                    arrTglLahir = val_rtb_txt_tgl_expire.getText().toString().split("-");
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
    	
    	fragment_Detail_IMB_Dialog.getBtn_saveimb().setOnClickListener(new View.OnClickListener() {
            
            
            @Override
            public void onClick(View v) {
            	try{
	            	 if(fragment_Detail_IMB_Dialog.CekMandatory().equals(false)){
	         			showAlert(R.string.msg_notification_mandatory);
	         		}
	            	 else{
		            	int intCount=1;
		            	if(!fragment_Detail_IMB_Dialog.getData_kendaraan_txt_id().equals(""))
		            	{
		            		intCount=Integer.parseInt(fragment_Detail_IMB_Dialog.getData_kendaraan_txt_seq().toString());
		            	}
		            	else{
		            		intCount=appr_ImbProvider.getAllAppr_detail_imb_by_MaxSeq(col_id);
		            	}
		            	data_imb.setID(col_id + intCount);
		            	data_imb.setIMB_SEQ(""+intCount);
		            	data_imb.setCOL_ID(col_id);
		            	data_imb.setIMB_NO(fragment_Detail_IMB_Dialog.getData_kendaraan_txt_no_imb());
		            	data_imb.setIMB_PURPOSE(fragment_Detail_IMB_Dialog.getData_kendaraan_txt_peruntukan());
		            	data_imb.setIMB_DATE(DateFormatter.formatDate(fragment_Detail_IMB_Dialog.getVal_kendaraan_txt_tgl_imb()));
		            	appr_ImbProvider.updateData(data_imb);
		            	viewdataImb();
		            	fragment_Detail_IMB_Dialog.dismiss();
		            	showAlert(R.string.msg_notification_update_success);
	            	 }
            	 }
            	catch(Exception ex){
            		showAlert(R.string.msg_notification_update_error);
            	}
            }
    	});
    	setColorMandatory();
    	 
    	if(status.equals("INQUERY")){
    		    	contentlayout= (LinearLayout) view.findViewById(R.id.contentlayout);
    		    	val_rtb_rdo_air_ada.setEnabled(false);
    		    	val_rtb_rdo_air_tidak.setEnabled(false);
    		    	val_rtb_view_img_tgl_tgl_expire.setEnabled(false);
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
    	val_rtb_txt_an_sertifikat.setBackgroundResource(R.drawable.fillcolor);
    	val_rtb_txt_no_sertifikat.setBackgroundResource(R.drawable.fillcolor);
    	val_rtb_txt_land_area.setBackgroundResource(R.drawable.fillcolor);
    	val_rtb_txt_north_boundary.setBackgroundResource(R.drawable.fillcolor);
    	val_rtb_txt_south_boundary.setBackgroundResource(R.drawable.fillcolor);
    	val_rtb_txt_east_boundary.setBackgroundResource(R.drawable.fillcolor);
    	val_rtb_txt_west_boundary.setBackgroundResource(R.drawable.fillcolor);
    	val_rtb_txt_land_range.setBackgroundResource(R.drawable.fillcolor);
    	val_rtb_txt_building_area.setBackgroundResource(R.drawable.fillcolor);
    	val_rtb_txt_const_tahun.setBackgroundResource(R.drawable.fillcolor);
    	val_rtb_txt_const_progress.setBackgroundResource(R.drawable.fillcolor);
    	val_rtb_txt_const_lantai.setBackgroundResource(R.drawable.fillcolor);
    	val_rtb_txt_avail_pln.setBackgroundResource(R.drawable.fillcolor);
    	val_rtb_txt_avail_genset.setBackgroundResource(R.drawable.fillcolor);
    }
    private Boolean CekMandatory(){
    	/*AVAIL_PLN
    	AVAIL_GENSET
    	BUILDING_AREA
    	CONST_TAHUN
    	CONST_PROGRESS
    	CONST_LANTAI
    	CERTIFICATE_NAME
    	CERTIFCATE_NO
    	LAND_AREA
    	NORTH_BOUNDARY
    	SOUTH_BOUNDARY
    	EAST_BOUNDARY
    	WEST_BOUNDARY
    	RANGE_WIDTH
    	CERTIFICATE_TYPE
    	LAND_SHAPE
    	LAND_CONTOUR
    	LAND_PURPOSE
    	RANGE_ROAD
    	BUILDING_TYPE
    	BUILDING_CONDITION
    	CONST_INTI
    	CONST_FLOOR
    	CONST_WALL
    	CONST_CEILING
    	CONST_ROOF
    	AVAIL_PHONE
    	AVAIL_PDAM*/
    	
    	
    	  boolean retval=true;
    	  appr_Rtb_detail_int=appr_Detail_DataProvider.getAllAppr_Rtb_Detail(col_id);
        	if(appr_Rtb_detail_int.COL_ID!=null && !appr_Rtb_detail_int.COL_ID.equals("")){
  			if(appr_Rtb_detail_int.AVAIL_PLN==null || appr_Rtb_detail_int.AVAIL_PLN.equals(""))
        			retval=false;
  			if(appr_Rtb_detail_int.AVAIL_GENSET==null || appr_Rtb_detail_int.AVAIL_GENSET.equals(""))
        			retval=false;

  			if(appr_Rtb_detail_int.BUILDING_AREA==null || appr_Rtb_detail_int.BUILDING_AREA.equals(""))
        			retval=false;
  				
  			if(appr_Rtb_detail_int.CONST_TAHUN==null || appr_Rtb_detail_int.CONST_TAHUN.equals(""))
        			retval=false;
  			if(appr_Rtb_detail_int.CONST_PROGRESS==null || appr_Rtb_detail_int.CONST_PROGRESS.equals(""))
        			retval=false;
  				
  			if(appr_Rtb_detail_int.CONST_LANTAI==null || appr_Rtb_detail_int.CONST_LANTAI.equals(""))
        			retval=false;
  			if(appr_Rtb_detail_int.CERTIFICATE_NAME==null || appr_Rtb_detail_int.CERTIFICATE_NAME.equals(""))
        			retval=false;
  				
  			if(appr_Rtb_detail_int.CERTIFCATE_NO==null || appr_Rtb_detail_int.CERTIFCATE_NO.equals(""))
        			retval=false;
  			if(appr_Rtb_detail_int.LAND_AREA==null || appr_Rtb_detail_int.LAND_AREA.equals(""))
        			retval=false;
  			if(appr_Rtb_detail_int.EAST_BOUNDARY==null || appr_Rtb_detail_int.EAST_BOUNDARY.equals(""))
        			retval=false;
  			if(appr_Rtb_detail_int.NORTH_BOUNDARY==null || appr_Rtb_detail_int.NORTH_BOUNDARY.equals(""))
        			retval=false;
  			if(appr_Rtb_detail_int.SOUTH_BOUNDARY==null || appr_Rtb_detail_int.SOUTH_BOUNDARY.equals(""))
        			retval=false;
  				
  			if(appr_Rtb_detail_int.WEST_BOUNDARY==null || appr_Rtb_detail_int.WEST_BOUNDARY.equals(""))
        			retval=false;
  			
  			if(appr_Rtb_detail_int.RANGE_WIDTH==null || appr_Rtb_detail_int.RANGE_WIDTH.equals(""))
        			retval=false;
  			if(appr_Rtb_detail_int.CERTIFICATE_TYPE==null || appr_Rtb_detail_int.CERTIFICATE_TYPE.equals(""))
        			retval=false;
  			if(appr_Rtb_detail_int.LAND_SHAPE==null || appr_Rtb_detail_int.LAND_SHAPE.equals(""))
        			retval=false;
  			if(appr_Rtb_detail_int.LAND_CONTOUR==null || appr_Rtb_detail_int.LAND_CONTOUR.equals(""))
        			retval=false;
  			if(appr_Rtb_detail_int.LAND_PURPOSE==null || appr_Rtb_detail_int.LAND_PURPOSE.equals(""))
        			retval=false;
  			if(appr_Rtb_detail_int.RANGE_ROAD==null || appr_Rtb_detail_int.RANGE_ROAD.equals(""))
        			retval=false;
  			if(appr_Rtb_detail_int.BUILDING_CONDITION==null || appr_Rtb_detail_int.BUILDING_CONDITION.equals(""))
        			retval=false;
  			if(appr_Rtb_detail_int.CONST_INTI==null || appr_Rtb_detail_int.CONST_INTI.equals(""))
        			retval=false;
  			if(appr_Rtb_detail_int.CONST_FLOOR==null || appr_Rtb_detail_int.CONST_FLOOR.equals(""))
        			retval=false;
  			if(appr_Rtb_detail_int.BUILDING_TYPE==null || appr_Rtb_detail_int.BUILDING_TYPE.equals(""))
        			retval=false;
  			if(appr_Rtb_detail_int.CONST_WALL==null || appr_Rtb_detail_int.CONST_WALL.equals(""))
        			retval=false;
  			if(appr_Rtb_detail_int.CONST_CEILING==null || appr_Rtb_detail_int.CONST_CEILING.equals(""))
        			retval=false;
  			if(appr_Rtb_detail_int.CONST_ROOF==null || appr_Rtb_detail_int.CONST_ROOF.equals(""))
        			retval=false;
  			if(appr_Rtb_detail_int.AVAIL_PHONE==null || appr_Rtb_detail_int.AVAIL_PHONE.equals(""))
        			retval=false;
  			if(appr_Rtb_detail_int.AVAIL_PDAM==null || appr_Rtb_detail_int.AVAIL_PDAM.equals(""))
        			retval=false;	
  		}
    	  
    	 /* if(val_rtb_txt_avail_pln.getText().length()==0){
    		  val_rtb_txt_avail_pln.setError("Field Tidak Boleh Kososng");
    		  retval=false;
    	  }
    	  if(val_rtb_txt_avail_genset.getText().length()==0){
    		  val_rtb_txt_avail_genset.setError("Field Tidak Boleh Kososng");
    		  retval=false;
    	  }
    	  if(val_rtb_txt_building_area.getText().length()==0){
    		  val_rtb_txt_building_area.setError("Field Tidak Boleh Kososng");
    		  retval=false;
    	  }
    	  if(val_rtb_txt_const_tahun.getText().length()==0){
    		  val_rtb_txt_const_tahun.setError("Field Tidak Boleh Kososng");
    		  retval=false;
    	  }
    	  if(val_rtb_txt_const_progress.getText().length()==0){
    		  val_rtb_txt_const_progress.setError("Field Tidak Boleh Kososng");
    		  retval=false;
    	  }
    	  if(val_rtb_txt_const_lantai.getText().length()==0){
    		  val_rtb_txt_const_lantai.setError("Field Tidak Boleh Kososng");
    		  retval=false;
    	  }
    	  if(val_rtb_txt_an_sertifikat.getText().length()==0){
    		  val_rtb_txt_an_sertifikat.setError("Field Tidak Boleh Kososng");
    		  retval=false;
    	  }
    	  if(val_rtb_txt_no_sertifikat.getText().length()==0){
    		  val_rtb_txt_no_sertifikat.setError("Field Tidak Boleh Kososng");
    		  retval=false;
    	  }
    	  if(val_rtb_txt_land_area.getText().length()==0){
    		  val_rtb_txt_land_area.setError("Field Tidak Boleh Kososng");
    		  retval=false;
    	  }
    	  if(val_rtb_txt_north_boundary.getText().length()==0){
    		  val_rtb_txt_north_boundary.setError("Field Tidak Boleh Kososng");
    		  retval=false;
    	  }
    	  if(val_rtb_txt_south_boundary.getText().length()==0){
    		  val_rtb_txt_south_boundary.setError("Field Tidak Boleh Kososng");
    		  retval=false;
    	  }
    	  if(val_rtb_txt_east_boundary.getText().length()==0){
    		  val_rtb_txt_east_boundary.setError("Field Tidak Boleh Kososng");
    		  retval=false;
    	  }
    	  if(val_rtb_txt_west_boundary.getText().length()==0){
    		  val_rtb_txt_west_boundary.setError("Field Tidak Boleh Kososng");
    		  retval=false;
    	  }
    	  if(val_rtb_txt_land_range.getText().length()==0){
    		  val_rtb_txt_land_range.setError("Field Tidak Boleh Kososng");
    		  retval=false;
    	  }
    	  
    	  View selectedView = val_rtb_spn_jns_sertifikat.getSelectedView();
    	  if (selectedView != null && selectedView instanceof TextView) {
    	      TextView selectedTextView = (TextView) selectedView;
    	      if (val_rtb_spn_jns_sertifikat.getSelectedListOfValue().toString().length()==0) {
    	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
    	          selectedTextView.setError(errorString);
    	          retval=false;
    	      }
    	      else {
    	          selectedTextView.setError(null);
    	      }
    	  }
    	  
    	  View selectedView1 = val_rtb_spn_land_shape.getSelectedView();
    	  if (selectedView1 != null && selectedView1 instanceof TextView) {
    	      TextView selectedTextView = (TextView) selectedView1;
    	      if (val_rtb_spn_land_shape.getSelectedListOfValue().toString().length()==0) {
    	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
    	          selectedTextView.setError(errorString);
    	          retval=false;
    	      }
    	      else {
    	          selectedTextView.setError(null);
    	      }
    	  }
    	  View selectedView2 = val_rtb_spn_land_contour.getSelectedView();
    	  if (selectedView2 != null && selectedView2 instanceof TextView) {
    	      TextView selectedTextView = (TextView) selectedView2;
    	      if (val_rtb_spn_land_contour.getSelectedListOfValue().toString().length()==0) {
    	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
    	          selectedTextView.setError(errorString);
    	          retval=false;
    	      }
    	      else {
    	          selectedTextView.setError(null);
    	      }
    	  }
    	  View selectedView3 = val_rtb_spn_land_purpose.getSelectedView();
    	  if (selectedView3 != null && selectedView3 instanceof TextView) {
    	      TextView selectedTextView = (TextView) selectedView3;
    	      if (val_rtb_spn_land_purpose.getSelectedListOfValue().toString().length()==0) {
    	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
    	          selectedTextView.setError(errorString);
    	          retval=false;
    	      }
    	      else {
    	          selectedTextView.setError(null);
    	      }
    	  }
    	  View selectedView4 = val_rtb_spn_land_range.getSelectedView();
    	  if (selectedView4 != null && selectedView4 instanceof TextView) {
    	      TextView selectedTextView = (TextView) selectedView4;
    	      if (val_rtb_spn_land_range.getSelectedListOfValue().toString().length()==0) {
    	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
    	          selectedTextView.setError(errorString);
    	          retval=false;
    	      }
    	      else {
    	          selectedTextView.setError(null);
    	      }
    	  }
    	  View selectedView5 = val_rtb_spn_building_type.getSelectedView();
    	  if (selectedView5 != null && selectedView5 instanceof TextView) {
    	      TextView selectedTextView = (TextView) selectedView5;
    	      if (val_rtb_spn_building_type.getSelectedListOfValue().toString().length()==0) {
    	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
    	          selectedTextView.setError(errorString);
    	          retval=false;
    	      }
    	      else {
    	          selectedTextView.setError(null);
    	      }
    	  }
    	  View selectedView6 = val_rtb_spn_building_condotion.getSelectedView();
    	  if (selectedView6 != null && selectedView6 instanceof TextView) {
    	      TextView selectedTextView = (TextView) selectedView6;
    	      if (val_rtb_spn_building_condotion.getSelectedListOfValue().toString().length()==0) {
    	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
    	          selectedTextView.setError(errorString);
    	          retval=false;
    	      }
    	      else {
    	          selectedTextView.setError(null);
    	      }
    	  }
    	  View selectedView7 = val_rtb_spn_const_inti.getSelectedView();
    	  if (selectedView7 != null && selectedView7 instanceof TextView) {
    	      TextView selectedTextView = (TextView) selectedView7;
    	      if (val_rtb_spn_const_inti.getSelectedListOfValue().toString().length()==0) {
    	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
    	          selectedTextView.setError(errorString);
    	          retval=false;
    	      }
    	      else {
    	          selectedTextView.setError(null);
    	      }
    	  }
    	  View selectedView8 = val_rtb_spn_const_floor.getSelectedView();
    	  if (selectedView8 != null && selectedView8 instanceof TextView) {
    	      TextView selectedTextView = (TextView) selectedView8;
    	      if (val_rtb_spn_const_floor.getSelectedListOfValue().toString().length()==0) {
    	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
    	          selectedTextView.setError(errorString);
    	          retval=false;
    	      }
    	      else {
    	          selectedTextView.setError(null);
    	      }
    	  }
    	  View selectedView9 = val_rtb_spn_const_wall.getSelectedView();
    	  if (selectedView9 != null && selectedView9 instanceof TextView) {
    	      TextView selectedTextView = (TextView) selectedView9;
    	      if (val_rtb_spn_const_wall.getSelectedListOfValue().toString().length()==0) {
    	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
    	          selectedTextView.setError(errorString);
    	          retval=false;
    	      }
    	      else {
    	          selectedTextView.setError(null);
    	      }
    	  }
    	  View selectedView10 = val_rtb_spn_const_ceiling.getSelectedView();
    	  if (selectedView10 != null && selectedView10 instanceof TextView) {
    	      TextView selectedTextView = (TextView) selectedView10;
    	      if (val_rtb_spn_const_ceiling.getSelectedListOfValue().toString().length()==0) {
    	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
    	          selectedTextView.setError(errorString);
    	          retval=false;
    	      }
    	      else {
    	          selectedTextView.setError(null);
    	      }
    	  }
    	  View selectedView11 = val_rtb_spn_const_roof.getSelectedView();
    	  if (selectedView11 != null && selectedView11 instanceof TextView) {
    	      TextView selectedTextView = (TextView) selectedView11;
    	      if (val_rtb_spn_const_roof.getSelectedListOfValue().toString().length()==0) {
    	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
    	          selectedTextView.setError(errorString);
    	          retval=false;
    	      }
    	      else {
    	          selectedTextView.setError(null);
    	      }
    	  }
    	  View selectedView12 = val_rtb_spn_avail_phone.getSelectedView();
    	  if (selectedView12 != null && selectedView12 instanceof TextView) {
    	      TextView selectedTextView = (TextView) selectedView12;
    	      if (val_rtb_spn_avail_phone.getSelectedListOfValue().toString().length()==0) {
    	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
    	          selectedTextView.setError(errorString);
    	          retval=false;
    	      }
    	      else {
    	          selectedTextView.setError(null);
    	      }
    	  }
    	  
    	  View selectedView13 = val_rtb_spn_avail_pdam.getSelectedView();
    	  if (selectedView13 != null && selectedView13 instanceof TextView) {
    	      TextView selectedTextView = (TextView) selectedView13;
    	      if (val_rtb_spn_avail_pdam.getSelectedListOfValue().toString().length()==0) {
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
    private DatePickerDialog.OnDateSetListener RtbTglLaporDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int monthOfYear, int dayOfMonth) {
        	val_rtb_txt_tgl_expire.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
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
    private void 	saveData(){
    	
	    	appr_Rtb_detail_int.setCOL_ID(col_id);
	    	appr_Rtb_detail_int.setAP_REGNO(ap_regno);
	    	appr_Rtb_detail_int.setCERTIFICATE_NAME(val_rtb_txt_an_sertifikat.getText().toString());
	    	appr_Rtb_detail_int.setCERTIFCATE_NO(val_rtb_txt_no_sertifikat.getText().toString());
	    	appr_Rtb_detail_int.setCERTIFICATE_TYPE(val_rtb_spn_jns_sertifikat.getSelectedListOfValue().toString());
	    	appr_Rtb_detail_int.setCERTIFICATE_EXPIRE(DateFormatter.formatDate(val_rtb_txt_tgl_expire.getText().toString()));
	    	appr_Rtb_detail_int.setLAND_AREA(val_rtb_txt_land_area.getText().toString());
	    	appr_Rtb_detail_int.setNORTH_BOUNDARY(val_rtb_txt_north_boundary.getText().toString());
	    	appr_Rtb_detail_int.setSOUTH_BOUNDARY(val_rtb_txt_south_boundary.getText().toString());
	    	appr_Rtb_detail_int.setLAND_SHAPE(val_rtb_spn_land_shape.getSelectedListOfValue().toString());
	    	appr_Rtb_detail_int.setLAND_CONTOUR(val_rtb_spn_land_contour.getSelectedListOfValue().toString());
	    	appr_Rtb_detail_int.setLAND_PURPOSE(val_rtb_spn_land_purpose.getSelectedListOfValue().toString());
	    	appr_Rtb_detail_int.setRANGE_ROAD(val_rtb_spn_land_range.getSelectedListOfValue().toString());
	    	appr_Rtb_detail_int.setEAST_BOUNDARY(val_rtb_txt_east_boundary.getText().toString());
	    	appr_Rtb_detail_int.setWEST_BOUNDARY(val_rtb_txt_west_boundary.getText().toString());
	    	appr_Rtb_detail_int.setBUILDING_TYPE(val_rtb_spn_building_type.getSelectedListOfValue().toString());
	    	appr_Rtb_detail_int.setBUILDING_CONDITION(val_rtb_spn_building_condotion.getSelectedListOfValue().toString());
	    	appr_Rtb_detail_int.setBUILDING_AREA(val_rtb_txt_building_area.getText().toString());
	    	appr_Rtb_detail_int.setCONST_INTI(val_rtb_spn_const_inti.getSelectedListOfValue().toString());
	    	appr_Rtb_detail_int.setCONST_FLOOR(val_rtb_spn_const_floor.getSelectedListOfValue().toString());
	    	appr_Rtb_detail_int.setCONST_WALL(val_rtb_spn_const_wall.getSelectedListOfValue().toString());
	    	appr_Rtb_detail_int.setCONST_CEILING(val_rtb_spn_const_ceiling.getSelectedListOfValue().toString());
	    	appr_Rtb_detail_int.setCONST_ROOF(val_rtb_spn_const_roof.getSelectedListOfValue().toString());
	    	appr_Rtb_detail_int.setAVAIL_PLN(val_rtb_txt_avail_pln.getText().toString());
	    	appr_Rtb_detail_int.setAVAIL_GENSET(val_rtb_txt_avail_genset.getText().toString());
	    	appr_Rtb_detail_int.setAVAIL_PDAM(val_rtb_spn_avail_pdam.getSelectedListOfValue().toString());
	    	appr_Rtb_detail_int.setAVAIL_PHONE(val_rtb_spn_avail_phone.getSelectedListOfValue().toString());
	    	appr_Rtb_detail_int.setPURPOSE_NOT_IMB(val_rtb_txt_purpose_not_imb.getText().toString());
	    	appr_Rtb_detail_int.setCONST_PROGRESS(val_rtb_txt_const_progress.getText().toString());
	    	appr_Rtb_detail_int.setCONST_LANTAI(val_rtb_txt_const_lantai.getText().toString());
	    	if(val_rtb_rdo_air_ada.isChecked()){
	    		appr_Rtb_detail_int.setAVAIL_AIR(AppConstants.RDOADA);
	    	}
	    	else if(val_rtb_rdo_air_tidak.isChecked() ){
	    		appr_Rtb_detail_int.setAVAIL_AIR(AppConstants.RDOTDK);
	    	}
	    	
	    	appr_Rtb_detail_int.setCONST_TAHUN(val_rtb_txt_const_tahun.getText().toString());
	    	appr_Rtb_detail_int.setRANGE_WIDTH(val_rtb_txt_land_range.getText().toString());
	    	appr_Detail_DataProvider.updateData(appr_Rtb_detail_int);
	    	showAlert(R.string.msg_notification_update_success);
	    	//if(CekMandatory().equals(false)){
			//	showAlert(R.string.msg_notification_mandatory);
			//}
    }
    private void loadData(){
    	appr_Rtb_detail_int=appr_Detail_DataProvider.getAllAppr_Rtb_Detail(col_id);
      	if(appr_Rtb_detail_int.COL_ID!=null && !appr_Rtb_detail_int.COL_ID.equals("")){
      		val_rtb_txt_an_sertifikat.setText(appr_Rtb_detail_int.getCERTIFICATE_NAME());
      		val_rtb_txt_no_sertifikat.setText(appr_Rtb_detail_int.getCERTIFCATE_NO());
      		val_rtb_spn_jns_sertifikat.setSelectedListOfValue(appr_Rtb_detail_int.getCERTIFICATE_TYPE());
      		if(appr_Rtb_detail_int.getCERTIFICATE_EXPIRE()!=null)
      			val_rtb_txt_tgl_expire.setText(DateFormatter.formatString(appr_Rtb_detail_int.getCERTIFICATE_EXPIRE()));
      		
      		datatype_Appr_Collateral=appr_Collateral.getAllAppr_Collateral(col_id);
      		if(datatype_Appr_Collateral.COL_ID!=null && !datatype_Appr_Collateral.COL_ID.toString().equals("")){
      			header_alamat.setText(datatype_Appr_Collateral.getCOL_ADDR1() + " , " +  datatype_Appr_Collateral.getCOL_KELURAHAN() + " , " +  datatype_Appr_Collateral.getCOL_KECAMATAN() + " , " +  datatype_Appr_Collateral.getCOL_CITY() + " , " +  datatype_Appr_Collateral.getCOL_ZIPCODE());
      		    header_deb.setText(datatype_Appr_Collateral.getAP_REGNO() + " # " + datatype_Appr_Collateral.getCU_NAME() );
      		}
      		
      		val_rtb_txt_land_area.setText(appr_Rtb_detail_int.getLAND_AREA());
      		val_rtb_txt_north_boundary.setText(appr_Rtb_detail_int.getNORTH_BOUNDARY());
      		val_rtb_txt_south_boundary.setText(appr_Rtb_detail_int.getSOUTH_BOUNDARY());
      		val_rtb_spn_land_shape.setSelectedListOfValue(appr_Rtb_detail_int.getLAND_SHAPE());
      		val_rtb_spn_land_contour.setSelectedListOfValue(appr_Rtb_detail_int.getLAND_CONTOUR());
      		val_rtb_spn_land_purpose.setSelectedListOfValue(appr_Rtb_detail_int.getLAND_PURPOSE());
      		val_rtb_spn_land_range.setSelectedListOfValue(appr_Rtb_detail_int.getRANGE_ROAD());
      		val_rtb_txt_east_boundary.setText(appr_Rtb_detail_int.getEAST_BOUNDARY());
      		val_rtb_txt_west_boundary.setText(appr_Rtb_detail_int.getWEST_BOUNDARY());
      		val_rtb_spn_building_type.setSelectedListOfValue(appr_Rtb_detail_int.getBUILDING_TYPE());
      		val_rtb_spn_building_condotion.setSelectedListOfValue(appr_Rtb_detail_int.getBUILDING_CONDITION());
      		val_rtb_txt_building_area.setText(appr_Rtb_detail_int.getBUILDING_AREA());
      		val_rtb_spn_const_inti.setSelectedListOfValue(appr_Rtb_detail_int.getCONST_INTI());
      		val_rtb_spn_const_floor.setSelectedListOfValue(appr_Rtb_detail_int.getCONST_FLOOR());
      		val_rtb_spn_const_wall.setSelectedListOfValue(appr_Rtb_detail_int.getCONST_WALL());
      		val_rtb_spn_const_ceiling.setSelectedListOfValue(appr_Rtb_detail_int.getCONST_CEILING());
      		val_rtb_spn_const_roof.setSelectedListOfValue(appr_Rtb_detail_int.getCONST_ROOF());
      		val_rtb_txt_avail_pln.setText(appr_Rtb_detail_int.getAVAIL_PLN());
      		val_rtb_txt_avail_genset.setText(appr_Rtb_detail_int.getAVAIL_GENSET());
      		val_rtb_spn_avail_pdam.setSelectedListOfValue(appr_Rtb_detail_int.getAVAIL_PDAM());
      		val_rtb_spn_avail_phone.setSelectedListOfValue(appr_Rtb_detail_int.getAVAIL_PHONE());
      		val_rtb_txt_purpose_not_imb.setText(appr_Rtb_detail_int.getPURPOSE_NOT_IMB());
      		val_rtb_txt_const_progress.setText(appr_Rtb_detail_int.getCONST_PROGRESS());
      		val_rtb_txt_const_lantai.setText(appr_Rtb_detail_int.getCONST_LANTAI());
      		val_rtb_txt_const_tahun.setText(appr_Rtb_detail_int.getCONST_TAHUN());
      		val_rtb_txt_land_range.setText(appr_Rtb_detail_int.getRANGE_WIDTH());

      	 	if(appr_Rtb_detail_int.getAVAIL_AIR().equals(AppConstants.RDOADA)){
      	 		val_rtb_rdo_air_ada.setChecked(true);
	    	}
	    	else if(appr_Rtb_detail_int.getAVAIL_AIR().equals(AppConstants.RDOTDK)){
	    		val_rtb_rdo_air_tidak.setChecked(true);
	    	}
      	 	
      	}
    }
    private void viewdataImb() {
    	listdataimb =appr_ImbProvider.getAllAppr_imb(col_id);
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
        header10.setText("No IMB");

        rowHeaderTable.addView(header10, rowParamsDetail);

        TextView header9 = new TextView(ctx);
        header9.setGravity(Gravity.LEFT);
        header9.setTextColor(getResources().getColor(android.R.color.black));
        header9.setPadding(0, 2, 0,2);
        header9.setTextSize(12);
        header9.setWidth(200);
        header9.setText("Tanggal IMB");
        rowHeaderTable.addView(header9, rowParamsDetail);
        
        TextView header1 = new TextView(ctx);
        header1.setGravity(Gravity.LEFT);
        header1.setTextColor(getResources().getColor(android.R.color.black));
        header1.setPadding(0, 3, 0, 3);
        header1.setTextSize(12);
        header1.setWidth(170);
        header1.setText("Peruntukan Obyek (Sesuai IMB)");
        rowHeaderTable.addView(header1, rowParamsDetail);

      
        inbox_tableLayout.addView(rowHeaderTable);

        for (int i = 0; i < listdataimb.size(); i++) {
            final Datatype_Appr_imb contentdata = listdataimb.get(i);
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
            content_seq.setText(contentdata.getIMB_SEQ());
            content_seq.setVisibility(View.GONE);
            rowContentTable.addView(content_seq);
            
            
           
			
			  Button content_detail = new Button(ctx);
	            content_detail.setGravity(Gravity.CENTER);
	            content_detail.setText(R.string.form_action_detail);
	            rowContentTable.addView(content_detail, 5, 50);
	            content_detail.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					TextView content_id = (TextView) rowContentTable.getChildAt(0);
					TextView content_seq = (TextView) rowContentTable.getChildAt(1);
					TextView content_no = (TextView) rowContentTable.getChildAt(4);
					TextView content_tgl = (TextView) rowContentTable.getChildAt(5);
					TextView content_peruntukan = (TextView) rowContentTable.getChildAt(6);
					
					fragment_Detail_IMB_Dialog.setData_kendaraan_txt_seq(content_seq.getText().toString());
                	fragment_Detail_IMB_Dialog.setData_kendaraan_txt_id(content_id.getText().toString());
                	fragment_Detail_IMB_Dialog.setData_kendaraan_txt_id(content_id.getText().toString());
                	fragment_Detail_IMB_Dialog.setData_kendaraan_txt_no_imb(content_no.getText().toString());
                	fragment_Detail_IMB_Dialog.setVal_kendaraan_txt_tgl_imb(content_tgl.getText().toString());
                	fragment_Detail_IMB_Dialog.setData_kendaraan_txt_peruntukan(content_peruntukan.getText().toString());
                	
                	fragment_Detail_IMB_Dialog.show();	
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
					showConfirmationDelete(true, content_id.getText().toString());
				}
			});
           
            TextView content_ap_regno = new TextView(ctx);
            content_ap_regno.setGravity(Gravity.LEFT);
            content_ap_regno.setTextColor(getResources().getColor(android.R.color.black));
            content_ap_regno.setPadding(0, 3, 0, 3);
            content_ap_regno.setTextSize(12);
            content_ap_regno.setWidth(200);
            content_ap_regno.setText(contentdata.getIMB_NO().toString());
            rowContentTable.addView(content_ap_regno, rowParamsDetail);

            TextView content_jaminan = new TextView(ctx);
            content_jaminan.setGravity(Gravity.LEFT);
            content_jaminan.setTextColor(getResources().getColor(android.R.color.black));
            content_jaminan.setPadding(0, 3, 0, 3);
            content_jaminan.setTextSize(12);
            content_jaminan.setWidth(200);
            try{
            	content_jaminan.setText(DateFormatter.formatString(contentdata.getIMB_DATE()));
            }
            catch(Exception ex){
            	content_jaminan.setText("");
            }
            rowContentTable.addView(content_jaminan, rowParamsDetail);

            TextView content_nama = new TextView(ctx);
            content_nama.setGravity(Gravity.LEFT);
            content_nama.setTextColor(getResources().getColor(android.R.color.black));
            content_nama.setPadding(0, 3, 0, 3);
            content_nama.setTextSize(12);
            content_nama.setWidth(400);
            content_nama.setText(contentdata.getIMB_PURPOSE().toString());
            rowContentTable.addView(content_nama, rowParamsDetail);

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
            		appr_ImbProvider.deleteTransaksiById(id);
	            	viewdataImb();
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
    private void viewdataSertifikat() {
    	listdatasertifikat =appr_SertifikatProvider.getAllAppr_Sertifikat(col_id);
    	dok_tableLayout.removeAllViews();
    	
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
        header1.setText("Jenis Dokumen");

        rowHeaderTable.addView(header1, rowParamsDetail);

        TextView header2 = new TextView(ctx);
        header2.setGravity(Gravity.LEFT);
        header2.setTextColor(getResources().getColor(android.R.color.black));
        header2.setPadding(0, 2, 0,2);
        header2.setTextSize(12);
        header2.setWidth(340);
        header2.setText("No Dokumen/Bukti Kepemilikan");
        rowHeaderTable.addView(header2, rowParamsDetail);
        
        TextView header3 = new TextView(ctx);
        header3.setGravity(Gravity.LEFT);
        header3.setTextColor(getResources().getColor(android.R.color.black));
        header3.setPadding(0, 3, 0, 3);
        header3.setTextSize(12);
        header3.setWidth(170);
        header3.setText("Tanggal Terbit/Dokumen");
        rowHeaderTable.addView(header3, rowParamsDetail);
       
        
        TextView header4 = new TextView(ctx);
        header4.setGravity(Gravity.LEFT);
        header4.setTextColor(getResources().getColor(android.R.color.black));
        header4.setPadding(0, 3, 0, 3);
        header4.setTextSize(12);
        header4.setWidth(170);
        header4.setText("Tanggal jatuh Tempo");
        rowHeaderTable.addView(header4, rowParamsDetail);
        
        
        TextView header5 = new TextView(ctx);
        header5.setGravity(Gravity.LEFT);
        header5.setTextColor(getResources().getColor(android.R.color.black));
        header5.setPadding(0, 3, 0, 3);
        header5.setTextSize(12);
        header5.setWidth(170);
        header5.setText("TAtas Nama");
        rowHeaderTable.addView(header5, rowParamsDetail);
        dok_tableLayout.addView(rowHeaderTable);

        for (int i = 0; i < listdatasertifikat.size(); i++) {
            final Datatype_Appr_Sertifikat contentdata = listdatasertifikat.get(i);
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
            
            TextView content_dok_type = new TextView(ctx);
            content_dok_type.setGravity(Gravity.LEFT);
            content_dok_type.setTextColor(getResources().getColor(android.R.color.black));
            content_dok_type.setPadding(0, 3, 0, 3);
            content_dok_type.setTextSize(12);
            content_dok_type.setWidth(170);
            content_dok_type.setText(contentdata.getCOL_DOK_TYPE());
            rowContentTable.addView(content_dok_type, rowParamsDetail);
           

            TextView content_dok_no = new TextView(ctx);
            content_dok_no.setGravity(Gravity.LEFT);
            content_dok_no.setTextColor(getResources().getColor(android.R.color.black));
            content_dok_no.setPadding(0, 3, 0, 3);
            content_dok_no.setTextSize(12);
            content_dok_no.setWidth(170);
            content_dok_no.setText(contentdata.getCOL_DOK_NO());
            rowContentTable.addView(content_dok_no, rowParamsDetail);

            TextView content_dok_date = new TextView(ctx);
            content_dok_date.setGravity(Gravity.LEFT);
            content_dok_date.setTextColor(getResources().getColor(android.R.color.black));
            content_dok_date.setPadding(0, 3, 0, 3);
            content_dok_date.setTextSize(12);
            content_dok_date.setWidth(200);
            //content_nama.setText(DateFormatter.formatString(contentdata.getCOL_DOK_DATE()));
            rowContentTable.addView(content_dok_date, rowParamsDetail);

            
            TextView content_dok_ex = new TextView(ctx);
            content_dok_ex.setGravity(Gravity.LEFT);
            content_dok_ex.setTextColor(getResources().getColor(android.R.color.black));
            content_dok_ex.setPadding(0, 3, 0, 3);
            content_dok_ex.setTextSize(12);
            content_dok_ex.setWidth(200);
            //content_nama.setText(DateFormatter.formatString(contentdata.getCOL_DOK_EXPDATE()));
            rowContentTable.addView(content_dok_ex, rowParamsDetail);

            TextView content_dok_name = new TextView(ctx);
            content_dok_name.setGravity(Gravity.LEFT);
            content_dok_name.setTextColor(getResources().getColor(android.R.color.black));
            content_dok_name.setPadding(0, 3, 0, 3);
            content_dok_name.setTextSize(12);
            content_dok_name.setWidth(200);
            //content_nama.setText(DateFormatter.formatString(contentdata.getCOL_DOK_NAME()));
            rowContentTable.addView(content_dok_name, rowParamsDetail);
            
            dok_tableLayout.addView(rowContentTable);
        }
    }

    public void showAlert(int messageId, final boolean isbacktohome) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctx);
        alertDialog.setTitle(R.string.form_blackbox_result);
        alertDialog.setMessage(messageId);
        alertDialog.setPositiveButton(R.string.str_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                if (isbacktohome) {
                   // ActivityHandler.gotoActivity(ctx, HomeActivity.class, null);
                    //finish();
                }
            }
        });
        alertDialog.show();
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
