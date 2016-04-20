package com.mobile.appraisal;

import java.util.ArrayList;

import com.mobile.app.configuration.AppConstants;
import com.mobile.bo.app.dataprovider.Appr_Collateral;
import com.mobile.bo.app.dataprovider.Appr_Rtb_Pembanding;
import com.mobile.bo.app.dataprovider.LOVDataProvider;
import com.mobile.bo.app.datatype.Datatype_Appr_Collateral;
import com.mobile.bo.app.datatype.Datatype_Appr_Rtb_Pembanding_Int;
import com.mobile.bo.app.datatype.LovData;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import bii.mobile.amos.R;

@SuppressLint("RtlHardcoded") 
public class Fragment_RTB_Pembanding extends Activity {
    private static final int RESULT_LOAD_IMAGE = 2;
	private static final int RESULT_OK = 0;
	Button button;
    View view=null;
    Button Btnsave;
    private Context ctx;
    private Appr_Rtb_Pembanding appr_rtb_pembanding_DataProvider=new Appr_Rtb_Pembanding();
    private Datatype_Appr_Rtb_Pembanding_Int appr_rtb_pembanding_int = new Datatype_Appr_Rtb_Pembanding_Int();
    private Datatype_Appr_Rtb_Pembanding_Int appr_rtb_pembanding_int_seq = new Datatype_Appr_Rtb_Pembanding_Int();
    private ArrayList<Datatype_Appr_Rtb_Pembanding_Int> listdata  = null;
    private Datatype_Appr_Collateral datatype_Appr_Collateral = new Datatype_Appr_Collateral();
    private Appr_Collateral appr_Collateral=new Appr_Collateral();
    private TextView header_deb;
    private TextView header_alamat;
    
    private Datatype_Appr_Rtb_Pembanding_Int appr_rtb_pembanding_int_all = new Datatype_Appr_Rtb_Pembanding_Int();
    private ArrayList<Datatype_Appr_Rtb_Pembanding_Int> listdataall  = null;
    
    private Fragment_RTB_Pembanding_Dialog fragment_RTB_Pembanding_Dialog=null;
    
    private Button btn_new;
    private String col_id="";
    private String ap_regno="";
    private TableLayout pembanding_tableLayout;
    private LOVDataProvider lovDataProvider;
    public Fragment_RTB_Pembanding() {
    	
    }
    
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ctx = this;
		appr_rtb_pembanding_DataProvider=new Appr_Rtb_Pembanding();
        appr_rtb_pembanding_int = new Datatype_Appr_Rtb_Pembanding_Int();
        appr_rtb_pembanding_int_seq = new Datatype_Appr_Rtb_Pembanding_Int();
        appr_rtb_pembanding_int_all = new Datatype_Appr_Rtb_Pembanding_Int();
        appr_Collateral=new Appr_Collateral();
        datatype_Appr_Collateral = new Datatype_Appr_Collateral();
        setContentView(R.layout.fragment_rtb_pembanding);
        fragment_RTB_Pembanding_Dialog=new Fragment_RTB_Pembanding_Dialog(ctx);
        pembanding_tableLayout = (TableLayout) findViewById(R.id.pembanding_tableLayout);    

//        Bundle b = getArguments();
//        col_id=b.getString("COL_ID");
//        ap_regno=b.getString("AP_REGNO");
        col_id = "1";
	    ap_regno = "1";
       	viewPembanding();
            
	    header_deb =(TextView) findViewById(R.id.info_Nama_deb);
	    header_alamat =(TextView) findViewById(R.id.info_Nama_Alamat);
	    
	    datatype_Appr_Collateral=appr_Collateral.getAllAppr_Collateral(col_id);
	    if(datatype_Appr_Collateral.COL_ID!=null && !datatype_Appr_Collateral.COL_ID.toString().equals("")){
	    	header_alamat.setText(datatype_Appr_Collateral.getCOL_ADDR1() + " , " +  datatype_Appr_Collateral.getCOL_KELURAHAN() + " , " +  datatype_Appr_Collateral.getCOL_KECAMATAN() + " , " +  datatype_Appr_Collateral.getCOL_CITY() + " , " +  datatype_Appr_Collateral.getCOL_ZIPCODE());
	        header_deb.setText(datatype_Appr_Collateral.getAP_REGNO() + " # " + datatype_Appr_Collateral.getCU_NAME() );
	    }
        
	   
    	
		fragment_RTB_Pembanding_Dialog.getBtn_save().setOnClickListener(new View.OnClickListener() {
        
	        @Override
	        public void onClick(View v) {
	        	
	        	int intCount=1;
	        	if(!fragment_RTB_Pembanding_Dialog.getVal_rtb_txt_seq().getText().toString().equals(""))
	        	{
	        		intCount=Integer.parseInt(fragment_RTB_Pembanding_Dialog.getVal_rtb_txt_seq().getText().toString());
	        	}
	        	else{
	        		intCount=appr_rtb_pembanding_DataProvider.getAllAppr_Rtb_Pembanding_by_MaxSeq(col_id);
	        	}
	        	appr_rtb_pembanding_int.setCOL_ID(col_id);
	        	appr_rtb_pembanding_int.setAP_REGNO(ap_regno);
	        	appr_rtb_pembanding_int.setSEQ(""+ intCount);
	        	appr_rtb_pembanding_int.setID(col_id + intCount);
	        	
	        	appr_rtb_pembanding_int.setPROPERTY_TYPE(fragment_RTB_Pembanding_Dialog.getVal_rtb_txt_type().getText().toString());
	        	appr_rtb_pembanding_int.setLOCATION(fragment_RTB_Pembanding_Dialog.getVal_rtb_txt_lokasi().getText().toString());
	        	appr_rtb_pembanding_int.setLAND_AREA(fragment_RTB_Pembanding_Dialog.getVal_rtb_txt_luas_tanah().getText().toString());
	        	appr_rtb_pembanding_int.setBUILDING_AREA(fragment_RTB_Pembanding_Dialog.getVal_rtb_txt_luas_banunan().getText().toString());
	        	appr_rtb_pembanding_int.setCONDITION(fragment_RTB_Pembanding_Dialog.getVal_rtb_txt_kodisi().getText().toString());
	        	appr_rtb_pembanding_int.setOFFER_PRICE(fragment_RTB_Pembanding_Dialog.getVal_rtb_txt_harga_penawaran().getText().toString());
	        	appr_rtb_pembanding_int.setAFTER_ADJUSTMENT_PRICE(fragment_RTB_Pembanding_Dialog.getVal_rtb_txt_adjusment().getText().toString());
	        	appr_rtb_pembanding_int.setNARA_SUMBER(fragment_RTB_Pembanding_Dialog.getVal_rtb_txt_nara_sumber().getText().toString());
	        	appr_rtb_pembanding_int.setPHONE_NO(fragment_RTB_Pembanding_Dialog.getVal_rtb_txt_no_telp().getText().toString());
	        	appr_rtb_pembanding_int.setOFFER_TYPE(fragment_RTB_Pembanding_Dialog.getVal_rtb_spn_penawaran());
	        	
	        	appr_rtb_pembanding_DataProvider.updateData(appr_rtb_pembanding_int);   
	        	viewPembanding();
	        	fragment_RTB_Pembanding_Dialog.dismiss();
	        }
		});
	    
	    btn_new = (Button) findViewById(R.id.btn_new);
	    btn_new.setOnClickListener(new View.OnClickListener() {
			
	        @Override
	        public void onClick(View v) {
	        	
	        	fragment_RTB_Pembanding_Dialog.setVal_rtb_txt_seq("");
	        	fragment_RTB_Pembanding_Dialog.setVal_rtb_txt_type("");
	        	fragment_RTB_Pembanding_Dialog.setVal_rtb_txt_lokasi("");
	        	fragment_RTB_Pembanding_Dialog.setVal_rtb_txt_luas_tanah("");
	        	fragment_RTB_Pembanding_Dialog.setVal_rtb_txt_luas_banunan("");
	        	fragment_RTB_Pembanding_Dialog.setVal_rtb_txt_kodisi("");
	        	fragment_RTB_Pembanding_Dialog.setVal_rtb_txt_harga_penawaran("");
	        	fragment_RTB_Pembanding_Dialog.setVal_rtb_txt_adjusment("");
	        	fragment_RTB_Pembanding_Dialog.setVal_rtb_txt_nara_sumber("");
	        	fragment_RTB_Pembanding_Dialog.setVal_rtb_txt_no_telp("");
	        	fragment_RTB_Pembanding_Dialog.setVal_rtb_spn_penawaran("");
	        	
	        	fragment_RTB_Pembanding_Dialog.show();
	        	
	        }
		});
    }
  
    private void viewPembanding() {
    	
    	listdataall = appr_rtb_pembanding_DataProvider.getAllAppr_Rtb_Pembanding(col_id);
    	if (listdataall != null) {
    		pembanding_tableLayout.removeAllViews();
    	
	        TableRow rowHeaderTable = new TableRow(this);
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
	        header10.setText("Type Property");
	
	        rowHeaderTable.addView(header10, rowParamsDetail);
	
	        TextView header9 = new TextView(ctx);
	        header9.setGravity(Gravity.LEFT);
	        header9.setTextColor(getResources().getColor(android.R.color.black));
	        header9.setPadding(0, 2, 0,2);
	        header9.setTextSize(12);
	        header9.setWidth(200);
	        header9.setText("Lokasi");
	        rowHeaderTable.addView(header9, rowParamsDetail);
	        
	        TextView header1 = new TextView(ctx);
	        header1.setGravity(Gravity.LEFT);
	        header1.setTextColor(getResources().getColor(android.R.color.black));
	        header1.setPadding(0, 3, 0, 3);
	        header1.setTextSize(12);
	        header1.setWidth(170);
	        header1.setText("Luas Tanah");
	        rowHeaderTable.addView(header1, rowParamsDetail);
	
	        TextView header2 = new TextView(ctx);
	        header2.setGravity(Gravity.LEFT);
	        header2.setTextColor(getResources().getColor(android.R.color.black));
	        header2.setPadding(0, 3, 0, 3);
	        header2.setTextSize(12);
	        header2.setWidth(170);
	        header2.setText("Luas Bangunan");
	        rowHeaderTable.addView(header2, rowParamsDetail);
	
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
	        String lov_desc="";
	        lovDataProvider = new LOVDataProvider();
	        for (int i = 0; i < listdataall.size(); i++) {
	            final Datatype_Appr_Rtb_Pembanding_Int contentdata = listdataall.get(i);
	            final TableRow rowContentTable = new TableRow(ctx);
	            if ((i + 1) % 2 == 0) {
	                rowContentTable.setBackgroundColor(getResources().getColor(R.color.color_bacground1));
	            } else {
	                rowContentTable.setBackgroundColor(Color.WHITE);
	            }
	        	
	    	    LovData	lovoffer_type = lovDataProvider.getLOVDetail(contentdata.getOFFER_TYPE().toString(), AppConstants.SPINNER_PENAWARAN);
	    	    try{
	    	    	lov_desc=lovoffer_type.getDESCRIPTION().toString();
	    	    }
	            catch(Exception ex){
	            	lov_desc="";
	            }
	            TextView content_col_id = new TextView(ctx);
	            content_col_id.setText(contentdata.getID().toString());
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
	                	appr_rtb_pembanding_int=appr_rtb_pembanding_DataProvider.getAllAppr_Rtb_Pembanding_by_seq(content_col_id.getText().toString());
	                	fragment_RTB_Pembanding_Dialog.setVal_rtb_txt_type(appr_rtb_pembanding_int.getPROPERTY_TYPE().toString());
	                	fragment_RTB_Pembanding_Dialog.setVal_rtb_txt_lokasi(appr_rtb_pembanding_int.getLOCATION().toString());
	                	fragment_RTB_Pembanding_Dialog.setVal_rtb_txt_luas_tanah(appr_rtb_pembanding_int.getLAND_AREA().toString());
	                	fragment_RTB_Pembanding_Dialog.setVal_rtb_txt_luas_banunan(appr_rtb_pembanding_int.getBUILDING_AREA().toString());
	                	fragment_RTB_Pembanding_Dialog.setVal_rtb_txt_kodisi(appr_rtb_pembanding_int.getCONDITION().toString());
	                	fragment_RTB_Pembanding_Dialog.setVal_rtb_txt_harga_penawaran(appr_rtb_pembanding_int.getOFFER_PRICE().toString());
	                	fragment_RTB_Pembanding_Dialog.setVal_rtb_txt_adjusment(appr_rtb_pembanding_int.getAFTER_ADJUSTMENT_PRICE().toString());
	                	fragment_RTB_Pembanding_Dialog.setVal_rtb_txt_nara_sumber(appr_rtb_pembanding_int.getNARA_SUMBER().toString());
	                	fragment_RTB_Pembanding_Dialog.setVal_rtb_txt_no_telp(appr_rtb_pembanding_int.getPHONE_NO().toString());
	                	fragment_RTB_Pembanding_Dialog.setVal_rtb_spn_penawaran(appr_rtb_pembanding_int.getOFFER_TYPE().toString());
	                	fragment_RTB_Pembanding_Dialog.setVal_rtb_txt_seq(appr_rtb_pembanding_int.getSEQ().toString());
	                	fragment_RTB_Pembanding_Dialog.show();	
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
	                	showConfirmationDelete(true, content_col_id.getText().toString());
	                	
	                	
	                }
	            });
	            
	            TextView content_ap_regno = new TextView(ctx);
	            content_ap_regno.setGravity(Gravity.LEFT);
	            content_ap_regno.setTextColor(getResources().getColor(android.R.color.black));
	            content_ap_regno.setPadding(0, 3, 0, 3);
	            content_ap_regno.setTextSize(12);
	            content_ap_regno.setWidth(200);
	            content_ap_regno.setText(contentdata.getPROPERTY_TYPE().toString());
	            rowContentTable.addView(content_ap_regno, rowParamsDetail);
	
	            TextView content_jaminan = new TextView(ctx);
	            content_jaminan.setGravity(Gravity.LEFT);
	            content_jaminan.setTextColor(getResources().getColor(android.R.color.black));
	            content_jaminan.setPadding(0, 3, 0, 3);
	            content_jaminan.setTextSize(12);
	            content_jaminan.setWidth(200);
	            content_jaminan.setText(contentdata.getLOCATION().toString());
	            rowContentTable.addView(content_jaminan, rowParamsDetail);
	
	            TextView content_nama = new TextView(ctx);
	            content_nama.setGravity(Gravity.LEFT);
	            content_nama.setTextColor(getResources().getColor(android.R.color.black));
	            content_nama.setPadding(0, 3, 0, 3);
	            content_nama.setTextSize(12);
	            content_nama.setWidth(170);
	            content_nama.setText(contentdata.getLAND_AREA().toString());
	            rowContentTable.addView(content_nama, rowParamsDetail);
	
	            TextView content_tipe = new TextView(ctx);
	            content_tipe.setGravity(Gravity.LEFT);
	            content_tipe.setTextColor(getResources().getColor(android.R.color.black));
	            content_tipe.setPadding(0, 3, 0, 3);
	            content_tipe.setTextSize(12);
	            content_tipe.setWidth(170);
	            content_tipe.setText(contentdata.getBUILDING_AREA().toString());
	            rowContentTable.addView(content_tipe,rowParamsDetail);
	
	
	            TextView content_npwp = new TextView(ctx);
	            content_npwp.setGravity(Gravity.LEFT);
	            content_npwp.setTextColor(getResources().getColor(android.R.color.black));
	            content_npwp.setPadding(0, 3, 0, 3);
	            content_npwp.setTextSize(12);
	            content_npwp.setWidth(200);
	            content_npwp.setText(contentdata.getCONDITION().toString());
	            rowContentTable.addView(content_npwp,rowParamsDetail);
	
	            
	            TextView content_status = new TextView(ctx);
	            content_status.setGravity(Gravity.LEFT);
	            content_status.setTextColor(getResources().getColor(android.R.color.black));
	            content_status.setPadding(0, 3, 0, 3);
	            content_status.setTextSize(12);
	            content_status.setWidth(200);
	            content_status.setText(lov_desc);
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
    
    public void showConfirmationDelete(final boolean isparent,final String id) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctx);
        alertDialog.setTitle("Confirm");
        alertDialog.setMessage(R.string.msg_notification_delete);
        alertDialog.setPositiveButton(R.string.str_yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            	try {
            		appr_rtb_pembanding_DataProvider.deleteTransaksiById(id);
            		viewPembanding();
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
