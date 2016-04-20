package com.mobile.appraisal;



import java.util.ArrayList;
import com.mobile.app.configuration.AppConstants;
import com.mobile.bo.app.dataprovider.Appr_Vhc_Pembanding;
import com.mobile.bo.app.dataprovider.LOVDataProvider;
import com.mobile.bo.app.datatype.Datatype_Appr_Vhc_Pembanding_Int;
import com.mobile.bo.app.datatype.LovData;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.app.AlertDialog;
import android.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import bii.mobile.amos.R;

public class Fragment_VHC_Pembanding extends Fragment {
	Button button;
    View view=null;
    Button Btnsave;
    private Context ctx = null;
    private Appr_Vhc_Pembanding Appr_Vhc_Pembanding_DataProvider=new Appr_Vhc_Pembanding();
    private Datatype_Appr_Vhc_Pembanding_Int Appr_Vhc_Pembanding_int = new Datatype_Appr_Vhc_Pembanding_Int();
    private String col_id="";
    private String ap_regno="";
    private ArrayList<Datatype_Appr_Vhc_Pembanding_Int> listdataall  = null;;
    private Fragment_VHC_Pembanding_Dialog fragment_vhc_Pembanding_Dialog=null; 
    private Button btn_new;
    private TableLayout pembanding_tableLayout;
    private LOVDataProvider lovDataProvider;
    public Fragment_VHC_Pembanding() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_rtb_pembanding, null);
        ctx = this.getActivity();
        Appr_Vhc_Pembanding_DataProvider=new Appr_Vhc_Pembanding();
        Appr_Vhc_Pembanding_int = new Datatype_Appr_Vhc_Pembanding_Int();
        fragment_vhc_Pembanding_Dialog=new Fragment_VHC_Pembanding_Dialog(ctx);
        pembanding_tableLayout = (TableLayout) view.findViewById(R.id.pembanding_tableLayout);
      	Bundle b = getArguments();
        col_id=b.getString("COL_ID");
        ap_regno=b.getString("AP_REGNO");
        if(b.getString("STATUS").equals("INQUERY")){
        	fragment_vhc_Pembanding_Dialog.getBtn_save().setEnabled(false);
        	btn_new.setEnabled(false);
        }
        
        viewPembanding() ;
        fragment_vhc_Pembanding_Dialog.getBtn_save().setOnClickListener(new View.OnClickListener() {
       
      
            @Override
            public void onClick(View v) {
            	try{
	            	 if(fragment_vhc_Pembanding_Dialog.CekMandatory().equals(false)){
	         			showAlert(R.string.msg_notification_mandatory);
	         		}
	            	 else{
		            	int intCount=1;
		            	if(!fragment_vhc_Pembanding_Dialog.getVal_vhc_txt_seq().getText().toString().equals(""))
		            	{
		            		intCount=Integer.parseInt(fragment_vhc_Pembanding_Dialog.getVal_vhc_txt_seq().getText().toString());
		            	}
		            	else{
		            		intCount=Appr_Vhc_Pembanding_DataProvider.getAllAppr_Vhc_Pembanding_by_MaxSeq(col_id);
		            	}
		            	Appr_Vhc_Pembanding_int.setCOL_ID(col_id);
		            	Appr_Vhc_Pembanding_int.setAP_REGNO(ap_regno);
		            	Appr_Vhc_Pembanding_int.setSEQ(""+ intCount);
		            	Appr_Vhc_Pembanding_int.setID(col_id + intCount);
		            	
		            	Appr_Vhc_Pembanding_int.setVHC_BRAND_CODE(fragment_vhc_Pembanding_Dialog.getval_vhc_txt_merk().getText().toString());
		            	Appr_Vhc_Pembanding_int.setVHC_CODE(fragment_vhc_Pembanding_Dialog.getval_vhc_txt_model().getText().toString());
		            	Appr_Vhc_Pembanding_int.setCOLOR_CODE(fragment_vhc_Pembanding_Dialog.getval_vhc_txt_warna().getText().toString());
		            	Appr_Vhc_Pembanding_int.setYEAR_CREATED(fragment_vhc_Pembanding_Dialog.getval_vhc_txt_tahun().getText().toString());
		            	Appr_Vhc_Pembanding_int.setTRANSMISION(fragment_vhc_Pembanding_Dialog.getval_vhc_spn_transmisi());
		            	 
		            	
		            	Appr_Vhc_Pembanding_int.setCONDITION(fragment_vhc_Pembanding_Dialog.getval_vhc_spn_kondisi());
		            	Appr_Vhc_Pembanding_int.setOFFER_PRICE(fragment_vhc_Pembanding_Dialog.getVal_vhc_txt_harga_penawaran().getText().toString());
		            	Appr_Vhc_Pembanding_int.setAFTER_ADJUSTMENT_PRICE(fragment_vhc_Pembanding_Dialog.getVal_vhc_txt_adjusment().getText().toString());
		            	Appr_Vhc_Pembanding_int.setNARA_SUMBER(fragment_vhc_Pembanding_Dialog.getVal_vhc_txt_nara_sumber().getText().toString());
		            	Appr_Vhc_Pembanding_int.setPHONE_NO(fragment_vhc_Pembanding_Dialog.getVal_vhc_txt_no_telp().getText().toString());
		            	Appr_Vhc_Pembanding_int.setOFFER_TYPE(fragment_vhc_Pembanding_Dialog.getVal_vhc_spn_penawaran());
		            	
		            	Appr_Vhc_Pembanding_DataProvider.updateData(Appr_Vhc_Pembanding_int);   
		            	viewPembanding();
		            	fragment_vhc_Pembanding_Dialog.dismiss();
		            	showAlert(R.string.msg_notification_update_success); 
	            	 }
            	}
            	catch(Exception ex){
            		showAlert(R.string.msg_notification_update_error);
            	}
            }
    	});
        
       
        btn_new = (Button) view.findViewById(R.id.btn_new);
        btn_new.setOnClickListener(new View.OnClickListener() {
    		
            @Override
            public void onClick(View v) {
           	
            	fragment_vhc_Pembanding_Dialog.setval_vhc_txt_merk("");
            	fragment_vhc_Pembanding_Dialog.setval_vhc_txt_model("");
            	fragment_vhc_Pembanding_Dialog.setval_vhc_txt_warna("");
            	fragment_vhc_Pembanding_Dialog.setval_vhc_txt_tahun("");
            	fragment_vhc_Pembanding_Dialog.setval_vhc_spn_transmisi("");
            	
            	fragment_vhc_Pembanding_Dialog.setval_vhc_spn_kondisi("");
            	fragment_vhc_Pembanding_Dialog.setVal_vhc_txt_harga_penawaran("");
            	fragment_vhc_Pembanding_Dialog.setVal_vhc_txt_adjusment("");
            	fragment_vhc_Pembanding_Dialog.setVal_vhc_txt_nara_sumber("");
            	fragment_vhc_Pembanding_Dialog.setVal_vhc_txt_no_telp("");
            	fragment_vhc_Pembanding_Dialog.setVal_vhc_spn_penawaran("");
            	
            	fragment_vhc_Pembanding_Dialog.show();
            }
    	});
        
       
        
        return view;
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
    private void initControl(){
    	
    	
            	
    }
    
    private void loadData(String col_id){
    	
    
      	 
    }
    private void viewPembanding_test(){
    	
    	
    }
    private void viewPembanding() {
    	
    	listdataall=Appr_Vhc_Pembanding_DataProvider.getAllAppr_Vhc_Pembanding(col_id);
    	if (listdataall != null) {
            pembanding_tableLayout.removeAllViews();
    	
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
        header.setWidth(400);
        header.setText("Action");

        rowHeaderTable.addView(header, rowParamsDetail);

        
        TextView header10 = new TextView(ctx);
        header10.setGravity(Gravity.LEFT);
        header10.setTextColor(getResources().getColor(android.R.color.black));
        header10.setPadding(0, 3, 0, 3);
        header10.setTextSize(12);
        header10.setWidth(200);
        header10.setText("Merk");

        rowHeaderTable.addView(header10, rowParamsDetail);

        TextView header9 = new TextView(ctx);
        header9.setGravity(Gravity.LEFT);
        header9.setTextColor(getResources().getColor(android.R.color.black));
        header9.setPadding(0, 2, 0,2);
        header9.setTextSize(12);
        header9.setWidth(200);
        header9.setText("Jenis/Model");
        rowHeaderTable.addView(header9, rowParamsDetail);
        
        TextView header1 = new TextView(ctx);
        header1.setGravity(Gravity.LEFT);
        header1.setTextColor(getResources().getColor(android.R.color.black));
        header1.setPadding(0, 3, 0, 3);
        header1.setTextSize(12);
        header1.setWidth(170);
        header1.setText("Warna");
        rowHeaderTable.addView(header1, rowParamsDetail);

        TextView header2 = new TextView(ctx);
        header2.setGravity(Gravity.LEFT);
        header2.setTextColor(getResources().getColor(android.R.color.black));
        header2.setPadding(0, 3, 0, 3);
        header2.setTextSize(12);
        header2.setWidth(170);
        header2.setText("Tahun Pembuatan");
        rowHeaderTable.addView(header2, rowParamsDetail);

        TextView header11 = new TextView(ctx);
        header11.setTextColor(getResources().getColor(android.R.color.black));
        header11.setPadding(0, 3, 0, 3);
        header11.setTextSize(12);
        header11.setWidth(170);
        header11.setText("Transmisi");
        rowHeaderTable.addView(header11, rowParamsDetail);
        
        TextView header3 = new TextView(ctx);
        header3.setGravity(Gravity.LEFT);
        header3.setTextColor(getResources().getColor(android.R.color.black));
        header3.setPadding(0, 3, 0, 3);
        header3.setTextSize(12);
        header3.setWidth(200);
        header3.setText("Kondisi");
        rowHeaderTable.addView(header3, rowParamsDetail);

        TextView header4 = new TextView(ctx);
        header4.setGravity(Gravity.LEFT);
        header4.setTextColor(getResources().getColor(android.R.color.black));
        header4.setPadding(0, 3, 0, 3);
        header4.setTextSize(12);
        header4.setWidth(200);
        header4.setText("Penawaran / Transaksi");
        rowHeaderTable.addView(header4, rowParamsDetail);

        TextView header5 = new TextView(ctx);
        header5.setGravity(Gravity.LEFT);
        header5.setTextColor(getResources().getColor(android.R.color.black));
        header5.setPadding(0, 3, 0, 3);
        header5.setTextSize(12);
        header5.setWidth(200);
        header5.setText("Harga Penawaran / Transaksi (Rp.)");
        rowHeaderTable.addView(header5, rowParamsDetail);

        TextView header6 = new TextView(ctx);
        header6.setGravity(Gravity.LEFT);
        header6.setTextColor(getResources().getColor(android.R.color.black));
        header6.setPadding(0, 3, 0, 3);
        header6.setTextSize(12);
        header6.setWidth(200);
        header6.setText("Adjusment Internal Appr (Rp.)");
        rowHeaderTable.addView(header6, rowParamsDetail);
        
        
        TextView header7 = new TextView(ctx);
        header7.setGravity(Gravity.LEFT);
        header7.setTextColor(getResources().getColor(android.R.color.black));
        header7.setPadding(0, 3, 0, 3);
        header7.setTextSize(12);
        header7.setWidth(150);
        header7.setText("Nara Sumber");
        rowHeaderTable.addView(header7, rowParamsDetail);
        
        
        TextView header8 = new TextView(ctx);
        header8.setGravity(Gravity.LEFT);
        header8.setTextColor(getResources().getColor(android.R.color.black));
        header8.setPadding(0, 3, 0, 3);
        header8.setTextSize(12);
        header8.setWidth(150);
        header8.setText("No. Telp");
        rowHeaderTable.addView(header8, rowParamsDetail);
        
        
        pembanding_tableLayout.addView(rowHeaderTable);
        String lov_descoffer_type="",lov_desctransmisi="",lov_desckondisi="";
        lovDataProvider = new LOVDataProvider();
        for (int i = 0; i < listdataall.size(); i++) {
            final Datatype_Appr_Vhc_Pembanding_Int contentdata = listdataall.get(i);
            final TableRow rowContentTable = new TableRow(ctx);
            if ((i + 1) % 2 == 0) {
                rowContentTable.setBackgroundColor(getResources().getColor(R.color.color_bacground1));
            } else {
                rowContentTable.setBackgroundColor(Color.WHITE);
            }
        	
    	    LovData	lovoffer_type = lovDataProvider.getLOVDetail(contentdata.getOFFER_TYPE().toString(), AppConstants.SPINNER_PENAWARAN);
    	    LovData	lovtransmisi = lovDataProvider.getLOVDetail(contentdata.getTRANSMISION().toString(), AppConstants.SPINNER_TRANSMISI);
    	    LovData	lovkondisi = lovDataProvider.getLOVDetail(contentdata.getCONDITION().toString(), AppConstants.SPINNER_KONDISI);
    	    try{
    	    	lov_descoffer_type=lovoffer_type.getDESCRIPTION().toString();
    	    }
            catch(Exception ex){
            	lov_descoffer_type="";
            }
    	
    	    try{
    	    	lov_desctransmisi=lovtransmisi.getDESCRIPTION().toString();
    	    }
            catch(Exception ex){
            	lov_desctransmisi="";
            }
    	    
    	    try{
    	    	lov_desckondisi=lovkondisi.getDESCRIPTION().toString();
    	    }
            catch(Exception ex){
            	lov_desckondisi="";
            }
            TextView content_col_id = new TextView(ctx);
            content_col_id.setText(contentdata.getCOL_ID().toString() + contentdata.getSEQ().toString());
            content_col_id.setVisibility(View.GONE);
            rowContentTable.addView(content_col_id);
            
            Button content_detail = new Button(ctx);
            content_detail.setGravity(Gravity.CENTER);
            content_detail.setText(R.string.form_action_detail);
            //content_detail.setWidth(30);
            rowContentTable.addView(content_detail, 5, 50);
            content_detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                	TextView content_col_id = (TextView) rowContentTable.getChildAt(0);
                	Appr_Vhc_Pembanding_int=Appr_Vhc_Pembanding_DataProvider.getAllAppr_Vhc_Pembanding_by_seq(content_col_id.getText().toString());
                	
                	fragment_vhc_Pembanding_Dialog.setval_vhc_txt_merk(Appr_Vhc_Pembanding_int.getVHC_BRAND_CODE().toString());
                	fragment_vhc_Pembanding_Dialog.setval_vhc_txt_model(Appr_Vhc_Pembanding_int.getVHC_CODE().toString());
                	fragment_vhc_Pembanding_Dialog.setval_vhc_txt_warna(Appr_Vhc_Pembanding_int.getCOLOR_CODE().toString());
                	fragment_vhc_Pembanding_Dialog.setval_vhc_txt_tahun(Appr_Vhc_Pembanding_int.getYEAR_CREATED().toString());
                	fragment_vhc_Pembanding_Dialog.setval_vhc_spn_transmisi(Appr_Vhc_Pembanding_int.getTRANSMISION().toString());
                	
                	fragment_vhc_Pembanding_Dialog.setval_vhc_spn_kondisi(Appr_Vhc_Pembanding_int.getCONDITION().toString());
                
                	
                	fragment_vhc_Pembanding_Dialog.setVal_vhc_txt_harga_penawaran(Appr_Vhc_Pembanding_int.getOFFER_PRICE().toString());
                	fragment_vhc_Pembanding_Dialog.setVal_vhc_txt_adjusment(Appr_Vhc_Pembanding_int.getAFTER_ADJUSTMENT_PRICE().toString());
                	fragment_vhc_Pembanding_Dialog.setVal_vhc_txt_nara_sumber(Appr_Vhc_Pembanding_int.getNARA_SUMBER().toString());
                	fragment_vhc_Pembanding_Dialog.setVal_vhc_txt_no_telp(Appr_Vhc_Pembanding_int.getPHONE_NO().toString());
                	fragment_vhc_Pembanding_Dialog.setVal_vhc_spn_penawaran(Appr_Vhc_Pembanding_int.getOFFER_TYPE().toString());
                	fragment_vhc_Pembanding_Dialog.setVal_vhc_txt_seq(Appr_Vhc_Pembanding_int.getSEQ().toString());
                	fragment_vhc_Pembanding_Dialog.show();	
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
                	TextView content_col_id = (TextView) rowContentTable.getChildAt(0);
                	
                	try {
						Appr_Vhc_Pembanding_DataProvider.deleteTransaksiById(content_col_id.toString());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                	
                }
            });
            
            TextView content_ap_regno = new TextView(ctx);
            content_ap_regno.setGravity(Gravity.LEFT);
            content_ap_regno.setTextColor(getResources().getColor(android.R.color.black));
            content_ap_regno.setPadding(0, 3, 0, 3);
            content_ap_regno.setTextSize(12);
            content_ap_regno.setWidth(200);
           content_ap_regno.setText(contentdata.getVHC_BRAND_CODE().toString());
            rowContentTable.addView(content_ap_regno, rowParamsDetail);

            TextView content_jaminan = new TextView(ctx);
            content_jaminan.setGravity(Gravity.LEFT);
            content_jaminan.setTextColor(getResources().getColor(android.R.color.black));
            content_jaminan.setPadding(0, 3, 0, 3);
            content_jaminan.setTextSize(12);
            content_jaminan.setWidth(200);
            content_jaminan.setText(contentdata.getVHC_CODE().toString());
            rowContentTable.addView(content_jaminan, rowParamsDetail);

            TextView content_nama = new TextView(ctx);
            content_nama.setGravity(Gravity.LEFT);
            content_nama.setTextColor(getResources().getColor(android.R.color.black));
            content_nama.setPadding(0, 3, 0, 3);
            content_nama.setTextSize(12);
            content_nama.setWidth(170);
            content_nama.setText(contentdata.getCOLOR_CODE().toString());
            rowContentTable.addView(content_nama, rowParamsDetail);

            TextView content_tipe = new TextView(ctx);
            content_tipe.setGravity(Gravity.LEFT);
            content_tipe.setTextColor(getResources().getColor(android.R.color.black));
            content_tipe.setPadding(0, 3, 0, 3);
            content_tipe.setTextSize(12);
            content_tipe.setWidth(170);
            content_tipe.setText(contentdata.getYEAR_CREATED().toString());
            rowContentTable.addView(content_tipe,rowParamsDetail);


            TextView content_transmisi = new TextView(ctx);
            content_transmisi.setGravity(Gravity.LEFT);
            content_transmisi.setTextColor(getResources().getColor(android.R.color.black));
            content_transmisi.setPadding(0, 3, 0, 3);
            content_transmisi.setTextSize(12);
            content_transmisi.setWidth(170);
            content_transmisi.setText(lov_desctransmisi);
            rowContentTable.addView(content_transmisi,rowParamsDetail);
            
            
            TextView content_npwp = new TextView(ctx);
            content_npwp.setGravity(Gravity.LEFT);
            content_npwp.setTextColor(getResources().getColor(android.R.color.black));
            content_npwp.setPadding(0, 3, 0, 3);
            content_npwp.setTextSize(12);
            content_npwp.setWidth(200);
            content_npwp.setText(lov_desckondisi);
            rowContentTable.addView(content_npwp,rowParamsDetail);

            
            TextView content_status = new TextView(ctx);
            content_status.setGravity(Gravity.LEFT);
            content_status.setTextColor(getResources().getColor(android.R.color.black));
            content_status.setPadding(0, 3, 0, 3);
            content_status.setTextSize(12);
            content_status.setWidth(200);
            content_status.setText(lov_descoffer_type);
            rowContentTable.addView(content_status,rowParamsDetail);

            TextView content_aging = new TextView(ctx);
            content_aging.setGravity(Gravity.LEFT);
            content_aging.setTextColor(getResources().getColor(android.R.color.black));
            content_aging.setPadding(0, 3, 0, 3);
            content_aging.setTextSize(12);
            content_aging.setWidth(200);
            content_aging.setText(contentdata.getOFFER_PRICE().toString());
            rowContentTable.addView(content_aging,rowParamsDetail);

            TextView content_adjustment = new TextView(ctx);
            content_adjustment.setGravity(Gravity.LEFT);
            content_adjustment.setTextColor(getResources().getColor(android.R.color.black));
            content_adjustment.setPadding(0, 3, 0, 3);
            content_adjustment.setTextSize(12);
            content_adjustment.setWidth(200);
            content_adjustment.setText(contentdata.getAFTER_ADJUSTMENT_PRICE().toString());
            rowContentTable.addView(content_adjustment,rowParamsDetail);
            
            TextView content_narasumber = new TextView(ctx);
            content_narasumber.setGravity(Gravity.LEFT);
            content_narasumber.setTextColor(getResources().getColor(android.R.color.black));
            content_narasumber.setPadding(0, 3, 0, 3);
            content_narasumber.setTextSize(12);
            content_narasumber.setWidth(150);
            content_narasumber.setText(contentdata.getNARA_SUMBER().toString());
            rowContentTable.addView(content_narasumber,rowParamsDetail);
            
            
            TextView content_phone = new TextView(ctx);
            content_phone.setGravity(Gravity.LEFT);
            content_phone.setTextColor(getResources().getColor(android.R.color.black));
            content_phone.setPadding(0, 3, 0, 3);
            content_phone.setTextSize(12);
            content_phone.setWidth(150);
            content_phone.setText(contentdata.getPHONE_NO().toString());
            rowContentTable.addView(content_phone,rowParamsDetail);
            
           pembanding_tableLayout.addView(rowContentTable);
        }
    	}
    }
}
