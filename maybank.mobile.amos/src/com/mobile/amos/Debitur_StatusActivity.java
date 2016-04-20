package com.mobile.amos;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import com.mobile.app.activity.HomeActivity;
import com.mobile.app.ui.DatePickerManager;
import com.mobile.bo.app.dataprovider.Amos_Entry_Debitur;
import com.mobile.bo.app.dataprovider.LOVDataProvider;
import com.mobile.bo.app.datatype.DataType_Amos_Debitur_Int;
import com.mobile.framework.common.DateFormatter;

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

public class Debitur_StatusActivity extends Activity{
	private Context ctx;
	
	Button btnCari, btnAdd;
	
	private EditText val_txt_nama;
	
	private EditText val_txt_tgl_lhr;
	
	private ImageView view_img_calender;
	
	private TableLayout amos_TableLayout;
	
	private Button ams_btn_search;
	
	public Debitur_StatusActivity() {
    	
    }
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ctx = this;
		
		setTitle("Inquery Update List");
        getActionBar().setIcon(R.drawable.grid);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
		setContentView(R.layout.amos_debitur_status);
		
		val_txt_nama = (EditText) findViewById(R.id.val_txt_nama);
		val_txt_tgl_lhr = (EditText) findViewById(R.id.val_txt_tgl_lhr);
		amos_TableLayout = (TableLayout) findViewById(R.id.amos_tableLayout);
		
		initControl();
		
		viewListEntry();
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
            menu.add("Refresh")
              	.setIcon(R.drawable.download)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);

            menu.add("Back")
                .setIcon(R.drawable.back)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
		return true;
    }
	
	@Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }
	  @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        
        
		if(item.getTitle().toString()=="Refresh") {
//			InqueryDataInbox();
//			new loadProspekData().execute(); 
		}
		else if(item.getTitle().toString()=="Back") {
			BackActivity();
		}
		return true;
    }
	  
  	public void BackActivity() {
    	Intent i = new Intent(Debitur_StatusActivity.this, HomeActivity.class);   
    	startActivity(i);
  	}
	
	private void initControl()
	{
		
		view_img_calender = (ImageView) findViewById(R.id.view_img_calender);
		view_img_calender.setOnClickListener(new View.OnClickListener() {
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
				// TODO Auto-generated method stub
				val_txt_tgl_lhr = (EditText) findViewById(R.id.val_txt_tgl_lhr);
				val_txt_nama = (EditText) findViewById(R.id.val_txt_nama);
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
        header.setWidth(200);
        header.setText("Action");

        rowHeaderTable.addView(header, rowParamsDetail);
        
        TextView header1 = new TextView(ctx);
        header1.setGravity(Gravity.LEFT);
        header1.setTextColor(getResources().getColor(android.R.color.black));
        header1.setPadding(0, 3, 0, 3);
        header1.setTextSize(12);
        header1.setWidth(100);
        header1.setText("No Aplikasi");
        rowHeaderTable.addView(header1, rowParamsDetail);
        
        TextView header2 = new TextView(ctx);
        header2.setGravity(Gravity.LEFT);
        header2.setTextColor(getResources().getColor(android.R.color.black));
        header2.setPadding(0, 3, 0, 3);
        header2.setTextSize(12);
        header2.setWidth(100);
        header2.setText("Nama Debitur");
        rowHeaderTable.addView(header2, rowParamsDetail);

        TextView header3 = new TextView(ctx);
        header3.setGravity(Gravity.LEFT);
        header3.setTextColor(getResources().getColor(android.R.color.black));
        header3.setPadding(0, 2, 0,2);
        header3.setTextSize(12);
        header3.setWidth(100);
        header3.setText("Tanggal lahir");
        rowHeaderTable.addView(header3, rowParamsDetail);
        
        TextView header4 = new TextView(ctx);
        header4.setGravity(Gravity.LEFT);
        header4.setTextColor(getResources().getColor(android.R.color.black));
        header4.setPadding(0, 2, 0,2);
        header4.setTextSize(12);
        header4.setWidth(100);
        header4.setText("Status");
        rowHeaderTable.addView(header4, rowParamsDetail);
        
        TextView header5 = new TextView(ctx);
        header5.setGravity(Gravity.LEFT);
        header5.setTextColor(getResources().getColor(android.R.color.black));
        header5.setPadding(0, 2, 0,2);
        header5.setTextSize(12);
        header5.setWidth(100);
        header5.setText("Tanggal Status");
        rowHeaderTable.addView(header5, rowParamsDetail);
        
        amos_TableLayout.addView(rowHeaderTable);
        
	}
	
	@Override
    public void onBackPressed() {
        /*ActivityHandler.gotoActivity(ctx, HomeActivity.class, null);
        finish();*/
    }
}
