package com.mobile.appraisal;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobile.bo.app.datatype.Datatype_Appr_Collateral;
import com.mobile.bo.app.datatype.Datatype_Appr_Dokument;
import com.mobile.bo.app.dataprovider.Appr_Collateral;
import com.mobile.bo.app.dataprovider.Appr_DokumentDataProvider;
import com.mobile.framework.common.DateFormatter;

import com.mobile.app.MainActivity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableLayout.LayoutParams;
import android.widget.TableRow;
import android.widget.TextView;

import bii.mobile.amos.R;

public class Fragment_Dokumen_Jaminan extends Fragment {
	Button button;
    View view=null;
    Button Btnsave;
    private Context ctx = null;
   
    final List<ImageView> imgView = new ArrayList<ImageView>();
    final List<TextView> lblView = new ArrayList<TextView>();
    private String col_id="";
    private String ap_regno="";
    final int CAMERA_CAPTURE = 1;
    final int CROP_PIC = 2;
    private TableLayout inbox_tableLayout;
    private Datatype_Appr_Collateral datatype_Appr_Collateral = new Datatype_Appr_Collateral();
    private Appr_Collateral appr_Collateral=new Appr_Collateral();
    private TextView header_deb;
    private TextView header_alamat;
    private ArrayList<Datatype_Appr_Dokument> listdataall  = null;
    private Datatype_Appr_Dokument data_dokumen  = null;
    private Appr_DokumentDataProvider appr_DokumentDataProvider;
    private Fragment_Dokumen_Jaminan_Dialog fragment_Dokumen_Jaminan_Dialog=null; 
    public Fragment_Dokumen_Jaminan() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dokumen_jaminan, null);
        ctx = this.getActivity();
        appr_DokumentDataProvider=new Appr_DokumentDataProvider();
        inbox_tableLayout = (TableLayout) view.findViewById(R.id.inbox_tableLayout);
        fragment_Dokumen_Jaminan_Dialog=new Fragment_Dokumen_Jaminan_Dialog(ctx);
        data_dokumen=new Datatype_Appr_Dokument();
        appr_Collateral=new Appr_Collateral();
        datatype_Appr_Collateral = new Datatype_Appr_Collateral();

        Bundle b = getArguments();
        
       
        
        //initControl();
        col_id=b.getString("COL_ID");
        ap_regno=b.getString("AP_REGNO");
        viewDokJaminan();
        header_deb							=(TextView) view.findViewById(R.id.info_Nama_deb);
        header_alamat						=(TextView) view.findViewById(R.id.info_Nama_Alamat);
         

		datatype_Appr_Collateral=appr_Collateral.getAllAppr_Collateral(col_id);
		if(datatype_Appr_Collateral.COL_ID!=null && !datatype_Appr_Collateral.COL_ID.toString().equals("")){
			header_alamat.setText(datatype_Appr_Collateral.getCOL_ADDR1() + " , " +  datatype_Appr_Collateral.getCOL_KELURAHAN() + " , " +  datatype_Appr_Collateral.getCOL_KECAMATAN() + " , " +  datatype_Appr_Collateral.getCOL_CITY() + " , " +  datatype_Appr_Collateral.getCOL_ZIPCODE());
		    header_deb.setText(datatype_Appr_Collateral.getAP_REGNO() + " # " + datatype_Appr_Collateral.getCU_NAME() );
		}
		      	
        fragment_Dokumen_Jaminan_Dialog.getBtn_savedokumen().setOnClickListener(new View.OnClickListener() {
            
            
            @Override
            public void onClick(View v) {
            	data_dokumen.setID(fragment_Dokumen_Jaminan_Dialog.getdata_kendaraan_txt_id_dokumen());
            	data_dokumen.setDOC_NO(fragment_Dokumen_Jaminan_Dialog.getData_kendaraan_txt_no_dokumen());
            	data_dokumen.setDOC_EXPIREDATE(DateFormatter.formatDate(fragment_Dokumen_Jaminan_Dialog.getVal_rtb_txt_tgl_kadaluarsa()));
            	data_dokumen.setDOC_ORIG("0");
            	data_dokumen.setDOC_COPY("0");
            	data_dokumen.setDOC_NA("0");
            	data_dokumen.setDOC_WAIVE("0");
            	data_dokumen.setDOC_TBO("0");
            	
            	if(fragment_Dokumen_Jaminan_Dialog.getData_kendaraan_rdo_asli().isChecked())
            		data_dokumen.setDOC_ORIG("1");
            	if(fragment_Dokumen_Jaminan_Dialog.getData_kendaraan_rdo_copy().isChecked())
            		data_dokumen.setDOC_COPY("1");
            	if(fragment_Dokumen_Jaminan_Dialog.getData_kendaraan_rdo_na().isChecked())
            		data_dokumen.setDOC_NA("1");
            	if(fragment_Dokumen_Jaminan_Dialog.getData_kendaraan_rdo_waiver().isChecked())
            		data_dokumen.setDOC_WAIVE("1");
            	if(fragment_Dokumen_Jaminan_Dialog.getData_kendaraan_rdo_tbo().isChecked())
            		data_dokumen.setDOC_TBO("1");
            	
            	data_dokumen.setDOC_TBODATE(DateFormatter.formatDate(fragment_Dokumen_Jaminan_Dialog.getVal_rtb_txt_tgl_tbo()));
            	data_dokumen.setDOC_JUSTIFIED(fragment_Dokumen_Jaminan_Dialog.getData_kendaraan_txt_justifikasi());
            	data_dokumen.setJUMLAH(fragment_Dokumen_Jaminan_Dialog.getData_kendaraan_txt_upload());
            	data_dokumen.setUPLOADDATE(DateFormatter.formatDate(fragment_Dokumen_Jaminan_Dialog.getData_kendaraan_txt_last_upload()));
            	appr_DokumentDataProvider.updateData(data_dokumen);   
            	viewDokJaminan();
            	fragment_Dokumen_Jaminan_Dialog.dismiss();
            	
            }
    	});
        
            
        return view;
    }
    private void initControl(){
    	
    	
            	
    }
   
     private void viewDokJaminan() {
    	
    	listdataall=appr_DokumentDataProvider.getAllAppr_dokument(ap_regno);
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
        header.setWidth(190);
        header.setText("Action");

        //rowHeaderTable.addView(header, rowParamsDetail);

        
        TextView header10 = new TextView(ctx);
        header10.setGravity(Gravity.LEFT);
        header10.setTextColor(getResources().getColor(android.R.color.black));
        header10.setPadding(0, 3, 0, 3);
        header10.setTextSize(12);
        header10.setWidth(500);
        header10.setText("Dokumen");

        rowHeaderTable.addView(header10, rowParamsDetail);

        TextView header9 = new TextView(ctx);
        header9.setGravity(Gravity.LEFT);
        header9.setTextColor(getResources().getColor(android.R.color.black));
        header9.setPadding(0, 2, 0,2);
        header9.setTextSize(12);
        header9.setWidth(200);
        header9.setText("No");
        rowHeaderTable.addView(header9, rowParamsDetail);
        
        TextView header1 = new TextView(ctx);
        header1.setGravity(Gravity.LEFT);
        header1.setTextColor(getResources().getColor(android.R.color.black));
        header1.setPadding(0, 3, 0, 3);
        header1.setTextSize(12);
        header1.setWidth(100);
        header1.setText("Tanggal Kadaluarsa");
        rowHeaderTable.addView(header1, rowParamsDetail);

        TextView header2 = new TextView(ctx);
        header2.setGravity(Gravity.LEFT);
        header2.setTextColor(getResources().getColor(android.R.color.black));
        header2.setPadding(0, 3, 0, 3);
        header2.setTextSize(12);
        header2.setWidth(50);
        header2.setText("Asli");
        rowHeaderTable.addView(header2, rowParamsDetail);

        TextView header11 = new TextView(ctx);
        header11.setTextColor(getResources().getColor(android.R.color.black));
        header11.setPadding(0, 3, 0, 3);
        header11.setTextSize(12);
        header11.setWidth(50);
        header11.setText("Copy");
        rowHeaderTable.addView(header11, rowParamsDetail);
        
        TextView header3 = new TextView(ctx);
        header3.setGravity(Gravity.LEFT);
        header3.setTextColor(getResources().getColor(android.R.color.black));
        header3.setPadding(0, 3, 0, 3);
        header3.setTextSize(12);
        header3.setWidth(50);
        header3.setText("NA");
        rowHeaderTable.addView(header3, rowParamsDetail);

        TextView header4 = new TextView(ctx);
        header4.setGravity(Gravity.LEFT);
        header4.setTextColor(getResources().getColor(android.R.color.black));
        header4.setPadding(0, 3, 0, 3);
        header4.setTextSize(12);
        header4.setWidth(50);
        header4.setText("Waiver");
        rowHeaderTable.addView(header4, rowParamsDetail);

        TextView header5 = new TextView(ctx);
        header5.setGravity(Gravity.LEFT);
        header5.setTextColor(getResources().getColor(android.R.color.black));
        header5.setPadding(0, 3, 0, 3);
        header5.setTextSize(12);
        header5.setWidth(50);
        header5.setText("TBO");
        rowHeaderTable.addView(header5, rowParamsDetail);

        TextView header6 = new TextView(ctx);
        header6.setGravity(Gravity.LEFT);
        header6.setTextColor(getResources().getColor(android.R.color.black));
        header6.setPadding(0, 3, 0, 3);
        header6.setTextSize(12);
        header6.setWidth(50);
        header6.setText("Tanggal TBO");
        rowHeaderTable.addView(header6, rowParamsDetail);
        
        
        TextView header7 = new TextView(ctx);
        header7.setGravity(Gravity.LEFT);
        header7.setTextColor(getResources().getColor(android.R.color.black));
        header7.setPadding(0, 3, 0, 3);
        header7.setTextSize(12);
        header7.setWidth(150);
        header7.setText("Justifikasi");
        rowHeaderTable.addView(header7, rowParamsDetail);
        
        
        TextView header8 = new TextView(ctx);
        header8.setGravity(Gravity.LEFT);
        header8.setTextColor(getResources().getColor(android.R.color.black));
        header8.setPadding(0, 3, 0, 3);
        header8.setTextSize(12);
        header8.setWidth(70);
        header8.setText("Upload Count");
        rowHeaderTable.addView(header8, rowParamsDetail);
        
        TextView header12 = new TextView(ctx);
        header12.setGravity(Gravity.LEFT);
        header12.setTextColor(getResources().getColor(android.R.color.black));
        header12.setPadding(0, 3, 0, 3);
        header12.setTextSize(12);
        header12.setWidth(70);
        header12.setText("Last Upload Date");
        rowHeaderTable.addView(header12, rowParamsDetail);


             
        inbox_tableLayout.addView(rowHeaderTable);
        String lov_descoffer_type="",lov_desctransmisi="",lov_desckondisi="";
        //lovDataProvider = new LOVDataProvider();
        for (int i = 0; i < listdataall.size(); i++) {
        	 final Datatype_Appr_Dokument contentdata = listdataall.get(i);
             final TableRow rowContentTable = new TableRow(ctx);
             if ((i + 1) % 2 == 0) {
                 rowContentTable.setBackgroundColor(getResources().getColor(R.color.color_bacground1));
             } else {
                 rowContentTable.setBackgroundColor(Color.WHITE);
             }

             /*Button content_detail = new Button(ctx);
	            content_detail.setGravity(Gravity.CENTER);
	            content_detail.setText(R.string.form_action_detail);
	            rowContentTable.addView(content_detail, 5, 50);
	            content_detail.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						TextView content_id = (TextView) rowContentTable.getChildAt(1);
	                	data_dokumen=appr_DokumentDataProvider.getAllAppr_dokument_byid(content_id.getText().toString());
	                	//fragment_Dokumen_Jaminan_Dialog=new Fragment_Dokumen_Jaminan_Dialog(ctx);
	                	fragment_Dokumen_Jaminan_Dialog.setData_kendaraan_txt_id_dokumen(data_dokumen.getID().toString());
	                	fragment_Dokumen_Jaminan_Dialog.setData_kendaraan_txt_nama_dokumen(data_dokumen.getDOC_DESC().toString());
	                	fragment_Dokumen_Jaminan_Dialog.setData_kendaraan_txt_no_dokumen(data_dokumen.getDOC_NO().toString());
	                	try{
	                	fragment_Dokumen_Jaminan_Dialog.setVal_rtb_txt_tgl_kadaluarsa(DateFormatter.formatString(data_dokumen.getDOC_EXPIREDATE()));
	                	}
	                	catch(Exception ex){
	                		fragment_Dokumen_Jaminan_Dialog.setVal_rtb_txt_tgl_kadaluarsa("");
	                	}
	                	
	                	if(data_dokumen.getDOC_ORIG().toString().equals("1")){
	                		fragment_Dokumen_Jaminan_Dialog.setData_kendaraan_rdo_asli(true);
	                	}
	                	else if(data_dokumen.getDOC_COPY().toString().equals("1")){
	                		fragment_Dokumen_Jaminan_Dialog.setData_kendaraan_rdo_copy(true);
	                	}
	                	else if(data_dokumen.getDOC_NA().toString().equals("1")){
	                		fragment_Dokumen_Jaminan_Dialog.setData_kendaraan_rdo_na(true);
	                	}
	                	else if(data_dokumen.getDOC_WAIVE().toString().equals("1")){
	                		fragment_Dokumen_Jaminan_Dialog.setData_kendaraan_rdo_waiver(true);
	                	}
	                	else if(data_dokumen.getDOC_TBO().toString().equals("1")){
	                		fragment_Dokumen_Jaminan_Dialog.setData_kendaraan_rdo_tbo(true);
	                	}
	                	try{
	                		fragment_Dokumen_Jaminan_Dialog.setVal_rtb_txt_tgl_tbo(DateFormatter.formatString(data_dokumen.getDOC_TBODATE()));
	                	}
	                	catch(Exception ex){
	                		fragment_Dokumen_Jaminan_Dialog.setVal_rtb_txt_tgl_tbo("");
	                	}
	                	fragment_Dokumen_Jaminan_Dialog.setData_kendaraan_txt_justifikasi(data_dokumen.getDOC_JUSTIFIED().toString());
	                	fragment_Dokumen_Jaminan_Dialog.setData_kendaraan_txt_upload(data_dokumen.getJUMLAH().toString());
	                	try{
	                		fragment_Dokumen_Jaminan_Dialog.setData_kendaraan_txt_last_upload(DateFormatter.formatString(data_dokumen.getUPLOADDATE()));
	                	}
	                	catch(Exception ex){
	                		fragment_Dokumen_Jaminan_Dialog.setData_kendaraan_txt_last_upload("");
	                   	}
	                	fragment_Dokumen_Jaminan_Dialog.show();	
						
					}
				});*/
	            
	             TextView content_col_id = new TextView(ctx);
	             content_col_id.setText(contentdata.getID());
	             content_col_id.setVisibility(View.GONE);
	             rowContentTable.addView(content_col_id);

	            
	            TextView content_ap_regno = new TextView(ctx);
	            content_ap_regno.setGravity(Gravity.LEFT);
	            content_ap_regno.setTextColor(getResources().getColor(android.R.color.black));
	            content_ap_regno.setPadding(0, 3, 0, 3);
	            content_ap_regno.setTextSize(12);
	            content_ap_regno.setWidth(500);
	            content_ap_regno.setText(contentdata.getDOC_DESC().toString());
	            rowContentTable.addView(content_ap_regno, rowParamsDetail);

	            TextView content_jaminan = new TextView(ctx);
	            content_jaminan.setGravity(Gravity.LEFT);
	            content_jaminan.setTextColor(getResources().getColor(android.R.color.black));
	            content_jaminan.setPadding(0, 3, 0, 3);
	            content_jaminan.setTextSize(12);
	            content_jaminan.setWidth(200);
	            content_jaminan.setText(contentdata.getDOC_NO().toString());
	            rowContentTable.addView(content_jaminan, rowParamsDetail);

	            TextView content_nama = new TextView(ctx);
	            content_nama.setGravity(Gravity.LEFT);
	            content_nama.setTextColor(getResources().getColor(android.R.color.black));
	            content_nama.setPadding(0, 3, 0, 3);
	            content_nama.setTextSize(12);
	            content_nama.setWidth(100);
	            try{
	            	content_nama.setText(DateFormatter.formatString(contentdata.getDOC_EXPIREDATE()));
	            }
	            catch(Exception ex){
	            	content_nama.setText("");
	            }
	            rowContentTable.addView(content_nama, rowParamsDetail);

	     
	            
	            
	            //TextView content_tipe = new TextView(ctx);
	            CheckBox content_tipe=new CheckBox(ctx);
	            content_tipe.setGravity(Gravity.LEFT);
	            content_tipe.setTextColor(getResources().getColor(android.R.color.black));
	            content_tipe.setPadding(0, 3, 0, 3);
	            content_tipe.setTextSize(12);
	            content_tipe.setWidth(50);
	            if(contentdata.getDOC_ORIG().equals("1"))
	            	content_tipe.setChecked(true);
	            else
	            	content_tipe.setChecked(false);
	            
	            content_tipe.setEnabled(false);
	            
	            //content_tipe.setText(contentdata.getDOC_ORIG().toString());
	            rowContentTable.addView(content_tipe,rowParamsDetail);


	            //TextView content_transmisi = new TextView(ctx);
	            CheckBox content_transmisi=new CheckBox(ctx);
	            content_transmisi.setGravity(Gravity.LEFT);
	            content_transmisi.setTextColor(getResources().getColor(android.R.color.black));
	            content_transmisi.setPadding(0, 3, 0, 3);
	            content_transmisi.setTextSize(12);
	            content_transmisi.setWidth(50);
	            if(contentdata.getDOC_COPY().equals("1"))
	            	content_transmisi.setChecked(true);
	            else
	            	content_transmisi.setChecked(false);
	            
	            content_transmisi.setEnabled(false);
	            rowContentTable.addView(content_transmisi,rowParamsDetail);
	            
	            
	            //TextView content_npwp = new TextView(ctx);
	            CheckBox content_npwp=new CheckBox(ctx);
	            content_npwp.setGravity(Gravity.LEFT);
	            content_npwp.setTextColor(getResources().getColor(android.R.color.black));
	            content_npwp.setPadding(0, 3, 0, 3);
	            content_npwp.setTextSize(12);
	            content_npwp.setWidth(50);
	            if(contentdata.getDOC_NA().equals("1"))
	            	content_npwp.setChecked(true);
	            else
	            	content_npwp.setChecked(false);
	            
	            content_npwp.setEnabled(false);
	            //content_npwp.setText(contentdata.getDOC_NA().toString());
	            rowContentTable.addView(content_npwp,rowParamsDetail);

	            
	            //TextView content_status = new TextView(ctx);
	            CheckBox content_status=new CheckBox(ctx);
	            content_status.setGravity(Gravity.LEFT);
	            content_status.setTextColor(getResources().getColor(android.R.color.black));
	            content_status.setPadding(0, 3, 0, 3);
	            content_status.setTextSize(12);
	            content_status.setWidth(50);
	            if(contentdata.getDOC_WAIVE().equals("1"))
	            	content_status.setChecked(true);
	            else
	            	content_status.setChecked(false);
	            
	            
	            content_status.setEnabled(false);
	            //content_status.setText(contentdata.getDOC_WAIVE().toString());
	            rowContentTable.addView(content_status,rowParamsDetail);

	            //TextView content_aging = new TextView(ctx);
	            CheckBox content_aging=new CheckBox(ctx);
	            content_aging.setGravity(Gravity.LEFT);
	            content_aging.setTextColor(getResources().getColor(android.R.color.black));
	            content_aging.setPadding(0, 3, 0, 3);
	            content_aging.setTextSize(12);
	            content_aging.setWidth(50);
	            if(contentdata.getDOC_TBO().equals("1"))
	            	content_aging.setChecked(true);
	            else
	            	content_aging.setChecked(false);
	            
	            content_aging.setEnabled(false);
	            //content_aging.setText(contentdata.getDOC_TBO().toString());
	            rowContentTable.addView(content_aging,rowParamsDetail);

	            TextView content_adjustment = new TextView(ctx);
	            content_adjustment.setGravity(Gravity.LEFT);
	            content_adjustment.setTextColor(getResources().getColor(android.R.color.black));
	            content_adjustment.setPadding(0, 3, 0, 3);
	            content_adjustment.setTextSize(12);
	            content_adjustment.setWidth(50);
	            try{
	            	content_adjustment.setText(DateFormatter.formatString(contentdata.getDOC_TBODATE()));
	            }
	            catch(Exception ex){
	            	content_adjustment.setText("");
	            }
	            rowContentTable.addView(content_adjustment,rowParamsDetail);
	            
	            TextView content_narasumber = new TextView(ctx);
	            content_narasumber.setGravity(Gravity.LEFT);
	            content_narasumber.setTextColor(getResources().getColor(android.R.color.black));
	            content_narasumber.setPadding(0, 3, 0, 3);
	            content_narasumber.setTextSize(12);
	            content_narasumber.setWidth(50);
	            content_narasumber.setText(contentdata.getDOC_JUSTIFIED().toString());
	            rowContentTable.addView(content_narasumber,rowParamsDetail);
	            
	            
	            TextView content_phone = new TextView(ctx);
	            content_phone.setGravity(Gravity.LEFT);
	            content_phone.setTextColor(getResources().getColor(android.R.color.black));
	            content_phone.setPadding(0, 3, 0, 3);
	            content_phone.setTextSize(12);
	            content_phone.setWidth(50);
	            content_phone.setText(contentdata.getJUMLAH().toString());
	            rowContentTable.addView(content_phone,rowParamsDetail);
	            
	            TextView content_last = new TextView(ctx);
	            content_last.setGravity(Gravity.LEFT);
	            content_last.setTextColor(getResources().getColor(android.R.color.black));
	            content_last.setPadding(0, 3, 0, 3);
	            content_last.setTextSize(12);
	            content_last.setWidth(50);
	            try{
	            	content_last.setText(DateFormatter.formatString(contentdata.getUPLOADDATE()));
	            }
	            catch(Exception ex){
	            	content_last.setText("");
	            }
	            rowContentTable.addView(content_last,rowParamsDetail);
         
        

         inbox_tableLayout.addView(rowContentTable);

   
        }
     }
    

}
