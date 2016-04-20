package com.mobile.amos;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import com.mobile.app.activity.HomeActivity;
import com.mobile.app.configuration.AppConstants;
import com.mobile.app.ui.DatePickerManager;
import com.mobile.bo.app.dataprovider.Amos_Entry_Debitur;
import com.mobile.bo.app.dataprovider.LOVDataProvider;
import com.mobile.bo.app.dataprovider.ScheduleDataProvider;
import com.mobile.bo.app.datatype.DataType_Amos_Debitur_Int;
import com.mobile.bo.app.datatype.ScheduleData;
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
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import maybank.mobile.amos.R;

public class Debitur_InqueryActivity extends Activity{
	private Context ctx;
	
	Button btnCari, btnClear;
	
	private Amos_Entry_Debitur amos_entry_debitur_DataProvider = new Amos_Entry_Debitur();
	
	private EditText val_txt_nama;
	
	private EditText val_txt_tgl_lhr;
	
	private ArrayList<DataType_Amos_Debitur_Int> listdataall  = null;
	
	private ImageView viw_img_calender;
	
	private TableLayout amos_TableLayout;
	private ScheduleDataProvider scheduleDataProvider;
	
	private DataType_Amos_Debitur_Int amos_entry_debitur_int = new DataType_Amos_Debitur_Int();
	
	private UserData userDetail;
	private String userid = "";
	
	private LOVDataProvider lovDataProvider;
	
	private Button ams_btn_search;
	
	private LinearLayout search_layout_action;
	
	private int Field_dATE = 0, dateRangeComparation = 0;
	private String typeComparation = "";
	
	public Debitur_InqueryActivity() {
    	
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
		
		setTitle("Inquiry");
        getActionBar().setIcon(R.drawable.grid);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        
		amos_entry_debitur_DataProvider = new Amos_Entry_Debitur();
		scheduleDataProvider = new ScheduleDataProvider();
		
		setContentView(R.layout.amos_fragment_debitur);
		
		val_txt_nama = (EditText) findViewById(R.id.val_txt_nama);
		val_txt_tgl_lhr = (EditText) findViewById(R.id.val_txt_tgl_lhr);
		amos_TableLayout = (TableLayout) findViewById(R.id.amos_tableLayout);
		search_layout_action=(LinearLayout) findViewById(R.id.search_layout_action);
		
		initControl();
		
		viewListEntry();
	}
	
	//@Override
   /* public boolean onCreateOptionsMenu(Menu menu) {
    	//getMenuInflater().inflate(R.menu.menu_inbox, menu);
    	
            menu.add("Refresh")
              	.setIcon(R.drawable.download)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);

            menu.add("Back")
                .setIcon(R.drawable.back)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);

        
		return true;
    }
	*/
	/*@Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        //boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        //menu.findItem(R.id.action_websearch).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }
	  @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        
        switch (item.getItemId()) {
		
		case R.id.download:
			getDataFromServer();
			return true;
		case "Back":
			BackActivity();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
        
        
		if(item.getTitle().toString()=="Refresh") {
//			InqueryDataInbox();
//			new loadProspekData().execute(); 
		}
		else if(item.getTitle().toString()=="Back") {
			BackActivity();
		}
		return true;
    }*/
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
	public void refresh(){
		
		viewListEntry();
	}
	private void initControl()
	{
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
				// TODO Auto-generated method stub
				val_txt_tgl_lhr = (EditText) findViewById(R.id.val_txt_tgl_lhr);
				val_txt_nama = (EditText) findViewById(R.id.val_txt_nama);
				viewListEntry();
			}
		});
		
		btnClear = (Button) findViewById(R.id.ams_btn_clear);
		btnClear.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dataClear();
			}
			
		});
		
		Button btnsave = new Button(ctx);
		btnsave.setGravity(Gravity.CENTER);
		btnsave.setWidth(140);
		btnsave.setText(R.string.str_search);
		search_layout_action.addView(btnsave);
		btnsave.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				val_txt_tgl_lhr = (EditText) findViewById(R.id.val_txt_tgl_lhr);
				val_txt_nama = (EditText) findViewById(R.id.val_txt_nama);
				viewListEntry();
			}
		});
		
		Button btnclear = new Button(ctx);
		btnclear.setGravity(Gravity.CENTER);
		btnclear.setWidth(140);
		btnclear.setText(R.string.str_clear);
		search_layout_action.addView(btnclear);
		btnclear.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dataClear();
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
		
		if(!val_txt_nama.getText().toString().equalsIgnoreCase("") ||
				!val_txt_tgl_lhr.getText().toString().equalsIgnoreCase("")) 
		{
			String namaDebitur = val_txt_nama.getText().toString();
			String tglLhrDebitur = val_txt_tgl_lhr.getText().toString();
			
			listdataall = amos_entry_debitur_DataProvider.getAllAmos_Entry_Debitur_Filter(namaDebitur, tglLhrDebitur);
		} else {
			listdataall = amos_entry_debitur_DataProvider.getAllAmos_Entry_Debitur(userid);
		}
		
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
        header1.setWidth(200);
        header1.setText("No Aplikasi");
        rowHeaderTable.addView(header1, rowParamsDetail);
        
        TextView header10 = new TextView(ctx);
        header10.setGravity(Gravity.LEFT);
        header10.setTextColor(getResources().getColor(android.R.color.black));
        header10.setPadding(0, 3, 0, 3);
        header10.setTextSize(12);
        header10.setWidth(200);
        header10.setText("Nama Debitur");
        rowHeaderTable.addView(header10, rowParamsDetail);

        TextView header9 = new TextView(ctx);
        header9.setGravity(Gravity.LEFT);
        header9.setTextColor(getResources().getColor(android.R.color.black));
        header9.setPadding(0, 2, 0,2);
        header9.setTextSize(12);
        header9.setWidth(150);
        header9.setText("Tgl lahir");
        rowHeaderTable.addView(header9, rowParamsDetail);
        
        TextView header4 = new TextView(ctx);
        header4.setGravity(Gravity.LEFT);
        header4.setTextColor(getResources().getColor(android.R.color.black));
        header4.setPadding(0, 2, 0,2);
        header4.setTextSize(12);
        header4.setWidth(150);
        header4.setText("Batas Akhir Submit");
        rowHeaderTable.addView(header4, rowParamsDetail);
        
        amos_TableLayout.addView(rowHeaderTable);
//        String lov_desc="";
        lovDataProvider = new LOVDataProvider();
        for (int i = 0; i < listdataall.size(); i++) {
        	final DataType_Amos_Debitur_Int contentdata = listdataall.get(i);
            final TableRow rowContentTable = new TableRow(ctx);
            if ((i + 1) % 2 == 0) {
                rowContentTable.setBackgroundColor(getResources().getColor(R.color.color_bacground1));
            } else {
                rowContentTable.setBackgroundColor(Color.WHITE);
            }
            
            TextView content_col_seq = new TextView(ctx);
            content_col_seq.setText(contentdata.getID().toString());
            content_col_seq.setVisibility(View.GONE);
            rowContentTable.addView(content_col_seq);
            
            Button content_detail = new Button(ctx);
            content_detail.setGravity(Gravity.CENTER);
            content_detail.setText(R.string.form_action_detail);
//            content_detail.setWidth(300);
            rowContentTable.addView(content_detail, 5, 50);
            content_detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                	TextView content_col_seq = (TextView) rowContentTable.getChildAt(0);
                	Intent i = new Intent(Debitur_InqueryActivity.this,MainActivityDebitur.class);
                	i.putExtra("ID", content_col_seq.getText().toString());
                	startActivity(i);
               }
            });
            
//            Button content_delete = new Button(ctx);
//            content_delete.setGravity(Gravity.CENTER);
//            content_delete.setText(R.string.form_action_delete);
//            //content_delete.setWidth(30);
//            rowContentTable.addView(content_delete, 5, 50);
//            content_delete.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                	TextView content_col_id = (TextView) rowContentTable.getChildAt(0);
//                	showConfirmationDelete(true, content_col_id.getText().toString());
//                	
//                }
//            });
            
            TextView content_no_ap = new TextView(ctx);
            content_no_ap.setGravity(Gravity.LEFT);
            content_no_ap.setTextColor(getResources().getColor(android.R.color.black));
            content_no_ap.setPadding(0, 3, 0, 3);
            content_no_ap.setTextSize(12);
            content_no_ap.setWidth(200);
            content_no_ap.setText(contentdata.getAP_REGNO().toString());
            rowContentTable.addView(content_no_ap, rowParamsDetail);
            
            TextView content_deb_name = new TextView(ctx);
            content_deb_name.setGravity(Gravity.LEFT);
            content_deb_name.setTextColor(getResources().getColor(android.R.color.black));
            content_deb_name.setPadding(0, 3, 0, 3);
            content_deb_name.setTextSize(12);
            content_deb_name.setWidth(200);
            content_deb_name.setText(contentdata.getCU_FULLNM().toString());
            rowContentTable.addView(content_deb_name, rowParamsDetail);

            TextView content_tgllhr_deb = new TextView(ctx);
            content_tgllhr_deb.setGravity(Gravity.LEFT);
            content_tgllhr_deb.setTextColor(getResources().getColor(android.R.color.black));
            content_tgllhr_deb.setPadding(0, 3, 0, 3);
            content_tgllhr_deb.setTextSize(12);
            content_tgllhr_deb.setWidth(150);
            try{
            	content_tgllhr_deb.setText(DateFormatter.formatString(contentdata.getCU_BORNDATE()));
            }
            catch(Exception ex){
            	content_tgllhr_deb.setText("");
            }
            rowContentTable.addView(content_tgllhr_deb, rowParamsDetail);
            
            TextView content_bts_akhir_sbt = new TextView(ctx);
            content_bts_akhir_sbt.setGravity(Gravity.LEFT);
            content_bts_akhir_sbt.setTextColor(getResources().getColor(android.R.color.black));
            content_bts_akhir_sbt.setPadding(0, 3, 0, 3);
            content_bts_akhir_sbt.setTextSize(12);
            content_bts_akhir_sbt.setWidth(150);
            
            try{
            	String jml_hari =  hitungBatasWaktu(DateFormatter.formatStringYYYYMMDDHHmmss(contentdata.getAP_CREATEDATE()));
            	content_bts_akhir_sbt.setText(jml_hari + " Hari");
            }
            catch(Exception ex){
            	content_bts_akhir_sbt.setText("");
            }
            rowContentTable.addView(content_bts_akhir_sbt, rowParamsDetail);
            
            amos_TableLayout.addView(rowContentTable);
        }
	}
	
	private String hitungBatasWaktu(String tanggalBatas) 
    {
		
		ScheduleData schedule = scheduleDataProvider.getDetailSchedule(AppConstants.PAGEBLACKBOX);
		if (schedule != null) {
			dateRangeComparation = Integer.parseInt(schedule.getINTERVAL());
			typeComparation = schedule.getTYPE();
		}
 		
 		if(typeComparation.toString().equals(AppConstants.SCHEDULE_TYPE_DAYS)) {
 			Field_dATE = Calendar.DATE;
		} else if(typeComparation.toString().equals(AppConstants.SCHEDULE_TYPE_HOUR)) {
			Field_dATE = Calendar.HOUR;
		} else if(typeComparation.toString().equals(AppConstants.SCHEDULE_TYPE_MINUTE)) {
			Field_dATE = Calendar.MINUTE;
		}
 		
		Calendar date1 =  Calendar.getInstance();
		long dateNow = date1.getTimeInMillis();
		
		Calendar date2 =  Calendar.getInstance();
		date2.setTime(DateFormatter.formatYYYYMMDDHHmmss(tanggalBatas));
		date2.add(Field_dATE, dateRangeComparation);
		
		long dateBatas = date2.getTimeInMillis();
		
		
    	long day = dateBatas - dateNow;
    	long result = day / (24*60*60*1000);
    	
    	String jmlHari = "" + result;
    	
    	return  jmlHari;
    }
	
	public void showConfirmationDelete(final boolean isparent,final String id) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctx);
        alertDialog.setTitle("Confirm");
        alertDialog.setMessage(R.string.msg_notification_delete);
        alertDialog.setPositiveButton(R.string.str_yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            	try {
            		amos_entry_debitur_DataProvider.deleteTransaksiById(id);
            		viewListEntry();
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
