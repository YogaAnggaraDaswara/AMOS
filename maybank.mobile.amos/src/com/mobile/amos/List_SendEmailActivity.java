package com.mobile.amos;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import com.mobile.app.activity.HomeActivity;
import com.mobile.app.configuration.AppConstants;
import com.mobile.app.ui.DatePickerManager;
import com.mobile.bo.app.dataprovider.Amos_Entry_Debitur;
import com.mobile.bo.app.dataprovider.Appr_Email;
import com.mobile.bo.app.dataprovider.LOVDataProvider;
import com.mobile.bo.app.datatype.DataType_Amos_Debitur_Int;
import com.mobile.bo.app.datatype.DataType_Amos_Email;
import com.mobile.bo.app.datatype.UserData;
import com.mobile.framework.activity.ActivityHandler;
import com.mobile.framework.common.DateFormatter;
import com.mobile.framework.data.SessionSharedPreference;
import com.mobile.app.*;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import maybank.mobile.amos.R;

public class List_SendEmailActivity extends Activity{
	private Context ctx;
	
	Button btnCari, btnClear;
	
	private Appr_Email appr_Email = new Appr_Email();
	private ArrayList<DataType_Amos_Email> dataType_Amos_Email = new ArrayList<DataType_Amos_Email>();
	
	private EditText val_txt_nama;
	
	private EditText val_txt_tgl_lhr;
	
	private ArrayList<DataType_Amos_Debitur_Int> listdataall  = null;
	
	private ImageView viw_img_calender;
	
	private TableLayout amos_TableLayout;
	
	private DataType_Amos_Debitur_Int amos_entry_debitur_int = new DataType_Amos_Debitur_Int();
	
	private UserData userDetail;
	private String userid = "";
	
	private LOVDataProvider lovDataProvider;
	
	private Button ams_btn_search;
	
	public List_SendEmailActivity() {
    	
    }
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ctx = this;
		
		try {
			userDetail = (UserData) SessionSharedPreference.getDataFromSharedPreference(ctx, UserData.class, AppConstants.USER_SESSION);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userid = userDetail.getUSERID();
		
		setTitle("Inquery");
        getActionBar().setIcon(R.drawable.grid);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        
        appr_Email = new Appr_Email();
    	dataType_Amos_Email = new ArrayList<DataType_Amos_Email>();
		
		setContentView(R.layout.amos_fragment_send_email);
		
		val_txt_nama = (EditText) findViewById(R.id.val_txt_nama);
		val_txt_tgl_lhr = (EditText) findViewById(R.id.val_txt_tgl_lhr);
		amos_TableLayout = (TableLayout) findViewById(R.id.amos_tableLayout);
		
		initControl();
		
		viewListEntry();
	}
	
	
	 @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         int id=item.getItemId();
    	 if (id==android.R.id.home) {
    		 BackActivity();
         }
        
    	 return super.onOptionsItemSelected(item);
    }
	 
  	public void BackActivity() {
  		ActivityHandler.gotoActivity(ctx, HomeActivity.class, null);
        finish();
  	}
	
	private void initControl()
	{
		
		btnClear = (Button) findViewById(R.id.ams_btn_clear);
		btnClear.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dataClear();
			}
			
		});
		
		viw_img_calender = (ImageView) findViewById(R.id.viw_img_calender);
		viw_img_calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] arrTglLahir = null;

                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = (c.get(Calendar.MONTH));
                int day = c.get(Calendar.DAY_OF_MONTH);
                try{
	                if (!val_txt_tgl_lhr.getText().toString().equalsIgnoreCase("")) {
	                    arrTglLahir = val_txt_tgl_lhr.getText().toString().split("-");
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
		
		ams_btn_search = (Button) findViewById(R.id.ams_btn_search);
		ams_btn_search.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewListEntry();
			}
		});
	}
	
	private DatePickerDialog.OnDateSetListener PbTglLahirDebSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int monthOfYear, int dayOfMonth) {
        	val_txt_tgl_lhr.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
        }
    };
	
	@SuppressLint("RtlHardcoded") 
	private void viewListEntry()
	{
		amos_TableLayout.removeAllViews();
		
		dataType_Amos_Email = appr_Email.getAllEmail();
		
		amos_TableLayout.removeAllViews();
		
		TableRow rowHeaderTable = new TableRow(this);
        rowHeaderTable.setBackgroundColor(getResources().getColor(R.color.color_bacground2));
        rowHeaderTable.setPadding(0, 0, 0, 2);

        TableRow.LayoutParams rowParamsDetail = new TableRow.LayoutParams();
        rowParamsDetail.gravity = Gravity.LEFT;

        TextView header1 = new TextView(ctx);
        header1.setGravity(Gravity.LEFT);
        header1.setTextColor(getResources().getColor(android.R.color.black));
        header1.setPadding(0, 3, 0, 3);
        header1.setTextSize(12);
        header1.setWidth(200);
        header1.setText("Nama Debitur");
        rowHeaderTable.addView(header1, rowParamsDetail);
        
        TextView header10 = new TextView(ctx);
        header10.setGravity(Gravity.LEFT);
        header10.setTextColor(getResources().getColor(android.R.color.black));
        header10.setPadding(0, 3, 0, 3);
        header10.setTextSize(12);
        header10.setWidth(200);
        header10.setText("Type");
        rowHeaderTable.addView(header10, rowParamsDetail);

        TextView header9 = new TextView(ctx);
        header9.setGravity(Gravity.LEFT);
        header9.setTextColor(getResources().getColor(android.R.color.black));
        header9.setPadding(0, 2, 0,2);
        header9.setTextSize(12);
        header9.setWidth(150);
        header9.setText("Status");
        rowHeaderTable.addView(header9, rowParamsDetail);
        
        amos_TableLayout.addView(rowHeaderTable);
//        String lov_desc="";
        lovDataProvider = new LOVDataProvider();
        for (int i = 0; i < dataType_Amos_Email.size(); i++) {
        	final DataType_Amos_Email contentdata = dataType_Amos_Email.get(i);
            final TableRow rowContentTable = new TableRow(ctx);
            if ((i + 1) % 2 == 0) {
                rowContentTable.setBackgroundColor(getResources().getColor(R.color.color_bacground1));
            } else {
                rowContentTable.setBackgroundColor(Color.WHITE);
            }
            
           
            
            TextView content_no_ap = new TextView(ctx);
            content_no_ap.setGravity(Gravity.LEFT);
            content_no_ap.setTextColor(getResources().getColor(android.R.color.black));
            content_no_ap.setPadding(0, 3, 0, 3);
            content_no_ap.setTextSize(12);
            content_no_ap.setWidth(200);
            content_no_ap.setText(contentdata.getNAMADEBITUR().toString());
            rowContentTable.addView(content_no_ap, rowParamsDetail);
            
            TextView content_deb_name = new TextView(ctx);
            content_deb_name.setGravity(Gravity.LEFT);
            content_deb_name.setTextColor(getResources().getColor(android.R.color.black));
            content_deb_name.setPadding(0, 3, 0, 3);
            content_deb_name.setTextSize(12);
            content_deb_name.setWidth(200);
            content_deb_name.setText(contentdata.getTYPE().toString());
            rowContentTable.addView(content_deb_name, rowParamsDetail);

            TextView content_tgllhr_deb = new TextView(ctx);
            content_tgllhr_deb.setGravity(Gravity.LEFT);
            content_tgllhr_deb.setTextColor(getResources().getColor(android.R.color.black));
            content_tgllhr_deb.setPadding(0, 3, 0, 3);
            content_tgllhr_deb.setTextSize(12);
            content_tgllhr_deb.setWidth(150);
            content_tgllhr_deb.setText("InProgress");
            
            rowContentTable.addView(content_tgllhr_deb, rowParamsDetail);
            
            amos_TableLayout.addView(rowContentTable);
        }
	}
	
	
	
	public void dataClear() {
		val_txt_nama.setText("");
		val_txt_tgl_lhr.setText("");
	}
	
	@Override
    public void onBackPressed() {
        ActivityHandler.gotoActivity(ctx, HomeActivity.class, null);
        finish();
    }
}
