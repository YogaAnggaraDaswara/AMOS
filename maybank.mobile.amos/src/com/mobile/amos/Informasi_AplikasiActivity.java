package com.mobile.amos;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;

import com.mobile.app.activity.HomeActivity;
import com.mobile.app.configuration.AppConstants;
import com.mobile.app.ui.DatePickerManager;
import com.mobile.bo.app.dataprovider.Amos_Entry_Debitur;
import com.mobile.bo.app.dataprovider.LOVDataProvider;
import com.mobile.bo.app.datatype.DataType_Amos_Debitur_Int;
import com.mobile.bo.app.datatype.DataType_Amos_Document_Upload;
import com.mobile.bo.app.datatype.DataType_Ams_informationApk_Detail;
import com.mobile.bo.app.datatype.DataType_Ams_informationAplikasi;
import com.mobile.bo.app.datatype.DataType_inbox_document;
import com.mobile.bo.app.datatype.UserData;
import com.mobile.database.app.common.DataConverter;
import com.mobile.framework.activity.ActivityHandler;
import com.mobile.framework.common.DateFormatter;
import com.mobile.framework.data.SessionSharedPreference;
import com.mobile.services.app.ServiceData;
import com.mobile.services.app.datatype.RequestCount;
import com.mobile.services.app.datatype.SERVICEDATARESPONSE;
import com.mobile.services.app.services.ServiceDataProvider;

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

public class Informasi_AplikasiActivity extends Activity{
	private Context ctx;
	
	private EditText val_txt_nama, val_txt_no_aplikasi;
	private EditText val_txt_tgl_lhr, val_txt_tgl_input;
	private ImageView view_img_calender, view_img_calender_inp;
	
	private TableLayout amos_tableLayout, amos_tableLayout_dtl;
	
	private ArrayList<DataType_Ams_informationAplikasi> listInformasiApp = null;
	private ArrayList<DataType_Ams_informationApk_Detail> listdataalldoc = null;
	
	private TextView txtPageno;
	private int pageNo = 0;// page
    private int pageCount = 0;// total number of pages
    private Button btnNext, btnPrev, btnFirst, btnLast;
    
    private TextView txtPageno_dtl;
    private int pageNo_dtl = 0;// page
    private int pageCount_dtl = 0;// total number of pages
    private Button btnNext_dtl, btnPrev_dtl, btnFirst_dtl, btnLast_dtl;
    
    private Button btnCari, btnClear;
    
    private String putNOAPLIKASI = "";
    
    private UserData userDetail;
    
    private LinearLayout search_layout_action;
	
	public Informasi_AplikasiActivity() {
    	
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
		
		setTitle("Informasi Aplikasi");
        getActionBar().setIcon(R.drawable.grid);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
		setContentView(R.layout.amos_informasi_aplikasi);
		
		
		initControl();
		
	}
	
	
//	@Override
//    public boolean onCreateOptionsMenu(Menu menu) {
////            menu.add("Refresh")
////              	.setIcon(R.drawable.download)
////                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
////
////            menu.add("Back")
////                .setIcon(R.drawable.back)
////                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
//		return true;
//    }
//	
//	@Override
//    public boolean onPrepareOptionsMenu(Menu menu) {
//        return super.onPrepareOptionsMenu(menu);
//    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        
        
    	int id=item.getItemId();
   	 	if (id==android.R.id.home) {
   	 		BackActivity();
        }
		return true;
    }
	  
  	public void BackActivity() {
  		ActivityHandler.gotoActivity(ctx, HomeActivity.class, null);
    	finish();
  	}
	
	private void initControl()
	{
		
		val_txt_no_aplikasi = (EditText) findViewById(R.id.val_txt_no_aplikasi);
		val_txt_nama = (EditText) findViewById(R.id.val_txt_nama);
		val_txt_tgl_lhr = (EditText) findViewById(R.id.val_txt_tgl_lhr);
		val_txt_tgl_input = (EditText) findViewById(R.id.val_txt_tgl_input);
		
		amos_tableLayout = (TableLayout) findViewById(R.id.amos_tableLayout);
		amos_tableLayout_dtl = (TableLayout) findViewById(R.id.amos_tableLayout_dtl);
		
		txtPageno = (TextView) findViewById(R.id.txtPageno);
		btnNext = (Button) findViewById(R.id.btn_next);
	    btnPrev = (Button) findViewById(R.id.btn_prev);
	    btnFirst = (Button) findViewById(R.id.btn_first);
	    btnLast = (Button) findViewById(R.id.btn_last);
	    
	    txtPageno_dtl = (TextView) findViewById(R.id.txtPageno_dtl);
	    btnNext_dtl = (Button) findViewById(R.id.btn_next_dtl);
	    btnPrev_dtl = (Button) findViewById(R.id.btn_prev_dtl);
	    btnFirst_dtl = (Button) findViewById(R.id.btn_first_dtl);
	    btnLast_dtl = (Button) findViewById(R.id.btn_last_dtl);
	    
	    btnCari = (Button) findViewById(R.id.btn_cari);
	    btnClear = (Button) findViewById(R.id.btn_clear);
	    
		
		view_img_calender = (ImageView) findViewById(R.id.view_img_calender);
		
		
		view_img_calender_inp = (ImageView) findViewById(R.id.view_img_calender_inp);
		search_layout_action=(LinearLayout) findViewById(R.id.search_layout_action);
		
		buttonClick();
	}
	
	private void buttonClick() 
	{
		
		btnCari.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				if(!val_txt_no_aplikasi.getText().toString().equals("") ||
//					!val_txt_nama.getText().toString().equals("") ||
//					!val_txt_tgl_lhr.getText().toString().equals("") ||
//					!val_txt_tgl_input.getText().toString().equals("")) {
					reloadPage();
					getDataFromServerAmos();
//				}
			}
		});
	    
	    btnClear.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				bersihField();
				reloadPage();
//				getDataFromServerAmos();
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
				reloadPage();
				getDataFromServerAmos();
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
				bersihField();
				reloadPage();
			}
		});
		
		btnNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    // TODO Auto-generated method stub
                    //showProgressIndicator();
                    if (pageCount > pageNo) {
                        pageNo++;
                        GetDataInqury(pageNo);
                        viewListInfo();
                        setpageNo(pageNo);
                    }
                    //hideProgressIndicator();
                } catch (Exception ex) {
                   // showAlert(ex.getMessage().toString());
                }
            }
        });
        btnPrev.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    // TODO Auto-generated method stub
                    //showProgressIndicator();
                    if (pageNo > 1) {
                        pageNo--;
                        GetDataInqury(pageNo);
                        viewListInfo();
                        setpageNo(pageNo);
                    }
                    //hideProgressIndicator();
                } catch (Exception ex) {
                    //showAlert(ex.getMessage().toString());
                }
            }

        });

        btnFirst.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    // TODO Auto-generated method stub
                    //showProgressIndicator();
                    if (pageCount > 1 && pageNo != 1) {
                    	GetDataInqury(1);
                        pageNo = 1;
                        viewListInfo();
                        setpageNo(1);
                    }
                    //hideProgressIndicator();
                    //if(pageCount==pageNo_
                    //disable pageno
                } catch (Exception ex) {
                    //showAlert(ex.getMessage().toString());
                }
            }
        });
        btnLast.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {

                    //showProgressIndicator();
                    // TODO Auto-generated method stub
                    if (pageCount > 1 && pageNo != pageCount) {
                    	GetDataInqury(pageCount);
                        pageNo = pageCount;
                        viewListInfo();
                        setpageNo(pageCount);
                    }
                    //hideProgressIndicator();
                    //if(pageCount==pageNo_
                    //disable pageno
                } catch (Exception ex) {
                    //showAlert(ex.getMessage().toString());
                }
            }
        });
        
        // -------------------- document detail paggination --------------------
        btnNext_dtl.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    // TODO Auto-generated method stub
                    //showProgressIndicator();
                    if (pageCount_dtl > pageNo_dtl) {
                        pageNo_dtl++;
                        GetDocDetail(pageNo_dtl);
                        viewListInfoDetail();
                        setpageNo_dtl(pageNo_dtl);
                    }
                    //hideProgressIndicator();
                } catch (Exception ex) {
                   // showAlert(ex.getMessage().toString());
                }
            }
        });
        btnPrev_dtl.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    // TODO Auto-generated method stub
                    //showProgressIndicator();
                    if (pageNo_dtl > 1) {
                        pageNo_dtl--;
                        GetDocDetail(pageNo_dtl);
                        viewListInfoDetail();
                        setpageNo_dtl(pageNo_dtl);
                    }
                    //hideProgressIndicator();
                } catch (Exception ex) {
                    //showAlert(ex.getMessage().toString());
                }
            }

        });

        btnFirst_dtl.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    // TODO Auto-generated method stub
                    //showProgressIndicator();
                    if (pageCount_dtl > 1 && pageNo_dtl != 1) {
                    	GetDocDetail(1);
                        pageNo_dtl = 1;
                        viewListInfoDetail();
                        setpageNo_dtl(1);
                    }
                } catch (Exception ex) {
                    //showAlert(ex.getMessage().toString());
                }
            }
        });
		
		btnLast_dtl.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {

                    //showProgressIndicator();
                    // TODO Auto-generated method stub
                    if (pageCount_dtl > 1 && pageNo_dtl != pageCount_dtl) {
                    	GetDocDetail(pageCount_dtl);
                        pageNo_dtl = pageCount_dtl;
                        viewListInfoDetail();
                        setpageNo_dtl(pageCount_dtl);
                    }
                } catch (Exception ex) {
                    //showAlert(ex.getMessage().toString());
                }
            }
        });
		
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
		view_img_calender_inp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] arrTgl = null;

                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = (c.get(Calendar.MONTH));
                int day = c.get(Calendar.DAY_OF_MONTH);
                try{
	                if (!val_txt_tgl_input.getText().toString().equalsIgnoreCase("")) {
	                	arrTgl = val_txt_tgl_input.getText().toString().split("-");
	                    year = Integer.parseInt(arrTgl[2]);
	                    month = Integer.parseInt(arrTgl[1]) - 1;
	                    day = Integer.parseInt(arrTgl[0]);
	                }
                }
                catch(Exception e){
                	
                }
                DatePickerManager datePickerDialog = new DatePickerManager(ctx, PbTglInputSetListener, year, month, day);
                datePickerDialog.show();

            }
        });
	}
	
	private void bersihField() {
		val_txt_tgl_lhr.setText("");
		val_txt_tgl_input.setText("");
		val_txt_nama.setText(""); 
		val_txt_no_aplikasi.setText("");
		
	}
	
	private void reloadPage() {
		pageNo_dtl = 0;// page
	    pageCount_dtl = 0;// total number of pages
	    pageNo = 0;// page
	    pageCount = 0;// total number of pages
	    putNOAPLIKASI = "";
	    amos_tableLayout_dtl.removeAllViews();
	    amos_tableLayout.removeAllViews();
	}
	
	private DatePickerDialog.OnDateSetListener PbTglLahirDebSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int monthOfYear, int dayOfMonth) {
        	val_txt_tgl_lhr.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
        }
    };
    
    private DatePickerDialog.OnDateSetListener PbTglInputSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int monthOfYear, int dayOfMonth) {
        	val_txt_tgl_input.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
        }
    };
    
    private void getDataFromServerAmos() {
		pageCount = GetDataCountInquery();
        if(pageCount>0){
        	pageNo = 1;
        	GetDataInqury(1);
        	viewListInfo();
        }
	}
	
	private void GetDataInqury(int sPages){
    	if (listInformasiApp != null) {
    		listInformasiApp.clear();
        }
        setpageNo(sPages);
        String Userid = userDetail.getUSERID(); // ESETIA
		String Branchid = userDetail.getUNIT(); // 206
		
		String NoAplikasi = val_txt_no_aplikasi.getText().toString();
		String NmDebitur = val_txt_nama.getText().toString();
		
		String TglLahir = DataConverter.dateToString(DateFormatter.formatDate(val_txt_tgl_lhr.getText().toString()));
		String TglInput = DataConverter.dateToString(DateFormatter.formatDate(val_txt_tgl_input.getText().toString()));
		
		ArrayList<NameValuePair> params1 = new ArrayList<NameValuePair>();
        params1.add(new BasicNameValuePair("Userid", "" + Userid ));
        params1.add(new BasicNameValuePair("Branchid",Branchid));
        
        params1.add(new BasicNameValuePair("NoAplikasi",NoAplikasi));
        params1.add(new BasicNameValuePair("NmDebitur",NmDebitur));
        params1.add(new BasicNameValuePair("TglLahir",TglLahir));
        params1.add(new BasicNameValuePair("TglInput",TglInput));
        
        params1.add(new BasicNameValuePair("Pages","" + pageNo));
                
        SERVICEDATARESPONSE lovResponse;
		try {
			lovResponse = ServiceDataProvider.GetdataInformasiAplikasi(params1);
		
          
          if (lovResponse != null) {
        	  listInformasiApp = ServiceData.GetdataInformasiAplikasi(new JSONArray(lovResponse.getResults()));
              if (lovResponse.getStatus() == 1) {
                 
              }
              //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
          }
          lovResponse = null;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		viewListInfo();
    }
	
	private void setpageNo(int pageNo) {
        String text = null;
        text = pageNo + "/" + pageCount;
        txtPageno.setText(text);
    }
	
	private int GetDataCountInquery()
	{
    	int intCount = 0;
    	try {
    		String Userid="ESETIA";
    		String Branchid="206";
    		
    		String NoAplikasi = val_txt_no_aplikasi.getText().toString();
    		String NmDebitur = val_txt_nama.getText().toString();
    		
    		String TglLahir = DataConverter.dateToString(DateFormatter.formatDate(val_txt_tgl_lhr.getText().toString()));
    		String TglInput = DataConverter.dateToString(DateFormatter.formatDate(val_txt_tgl_input.getText().toString()));

    		ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
    		params.add(new BasicNameValuePair("Userid", "" + Userid ));
    		params.add(new BasicNameValuePair("Branchid",Branchid));
    		
    		params.add(new BasicNameValuePair("NoAplikasi",NoAplikasi));
    		params.add(new BasicNameValuePair("NmDebitur",NmDebitur));
    		params.add(new BasicNameValuePair("TglLahir",TglLahir));
    		params.add(new BasicNameValuePair("TglInput",TglInput));
            
            SERVICEDATARESPONSE masterCountResponse = ServiceDataProvider.GetdataInformasiAplikasiCount(params);
            if (masterCountResponse != null) {
                ArrayList<RequestCount> arrTabunganCountData = ServiceData.GetCount(new JSONArray(masterCountResponse.getResults()));
                if (masterCountResponse.getStatus() == 1) {
                    RequestCount contentdata = arrTabunganCountData.get(0);
                    intCount = Integer.parseInt(contentdata.getPAGES().toString());
                }
   	
            }

    	} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
    	}
    	return intCount;
    }
	
	@SuppressLint("RtlHardcoded") 
	private void viewListInfo()
	{
		amos_tableLayout.removeAllViews();
		
		TableRow rowHeaderTable = new TableRow(this);
        rowHeaderTable.setBackgroundColor(getResources().getColor(R.color.color_bacground2));
        rowHeaderTable.setPadding(0, 0, 0, 2);

        TableRow.LayoutParams rowParamsDetail = new TableRow.LayoutParams();
        rowParamsDetail.gravity = Gravity.CENTER;

        TextView header = new TextView(ctx);
        header.setGravity(Gravity.CENTER);
        header.setTextColor(getResources().getColor(android.R.color.black));
        header.setPadding(0, 3, 0, 3);
        header.setTextSize(12);
        header.setWidth(150);
        header.setText("Action");

        rowHeaderTable.addView(header, rowParamsDetail);
        
        TextView header1 = new TextView(ctx);
        header1.setGravity(Gravity.CENTER);
        header1.setTextColor(getResources().getColor(android.R.color.black));
        header1.setPadding(0, 3, 0, 3);
        header1.setTextSize(12);
        header1.setWidth(200);
        header1.setText("No Aplikasi");
        rowHeaderTable.addView(header1, rowParamsDetail);
        
        TextView header2 = new TextView(ctx);
        header2.setGravity(Gravity.CENTER);
        header2.setTextColor(getResources().getColor(android.R.color.black));
        header2.setPadding(0, 3, 0, 3);
        header2.setTextSize(12);
        header2.setWidth(150);
        header2.setText("Nama Debitur");
        rowHeaderTable.addView(header2, rowParamsDetail);

        TextView header3 = new TextView(ctx);
        header3.setGravity(Gravity.CENTER);
        header3.setTextColor(getResources().getColor(android.R.color.black));
        header3.setPadding(0, 2, 0,2);
        header3.setTextSize(12);
        header3.setWidth(150);
        header3.setText("Tanggal lahir");
        rowHeaderTable.addView(header3, rowParamsDetail);
        
        TextView header4 = new TextView(ctx);
        header4.setGravity(Gravity.CENTER);
        header4.setTextColor(getResources().getColor(android.R.color.black));
        header4.setPadding(0, 2, 0,2);
        header4.setTextSize(12);
        header4.setWidth(150);
        header4.setText("Tanggal Input");
        rowHeaderTable.addView(header4, rowParamsDetail);
        
        TextView header5 = new TextView(ctx);
        header5.setGravity(Gravity.CENTER);
        header5.setTextColor(getResources().getColor(android.R.color.black));
        header5.setPadding(0, 2, 0,2);
        header5.setTextSize(12);
        header5.setWidth(150);
        header5.setText("Fasilitas");
        rowHeaderTable.addView(header5, rowParamsDetail);
        
        TextView header6 = new TextView(ctx);
        header6.setGravity(Gravity.CENTER);
        header6.setTextColor(getResources().getColor(android.R.color.black));
        header6.setPadding(0, 2, 0,2);
        header6.setTextSize(12);
        header6.setWidth(150);
        header6.setText("Status Aplikasi");
        rowHeaderTable.addView(header6, rowParamsDetail);
        
        amos_tableLayout.addView(rowHeaderTable);
        
      //isi list
        if(listInformasiApp!=null){
            for (int i = 0; i < listInformasiApp.size(); i++) {
            	
            	//final Datatype_Appr_Inbox contentdata = listdata.get(i);
            	final DataType_Ams_informationAplikasi contentdata = listInformasiApp.get(i);
            	final TableRow rowContentTable = new TableRow(ctx);
		        
		        Button content_action = new Button(ctx);
		        content_action.setGravity(Gravity.CENTER);
		        content_action.setText(R.string.form_action_detail1);
		        //content_detail.setWidth(30);
		        rowContentTable.addView(content_action, 5, 50);
		        content_action.setOnClickListener(new View.OnClickListener() {
		
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						TextView content_col_seq = (TextView) rowContentTable.getChildAt(1);
						putNOAPLIKASI = content_col_seq.getText().toString();
						getDocWithNoAplikasi();
					}
		        	
		        });
		        TextView content1 = new TextView(ctx);
		        content1.setGravity(Gravity.CENTER);
		        content1.setTextColor(getResources().getColor(android.R.color.black));
		        content1.setPadding(0, 3, 0, 3);
		        content1.setTextSize(12);
		        content1.setWidth(200);
		        content1.setText(contentdata.getAP_REGNO());
	            rowContentTable.addView(content1, rowParamsDetail);
	            
	            TextView content2 = new TextView(ctx);
	            content2.setGravity(Gravity.LEFT);
	            content2.setTextColor(getResources().getColor(android.R.color.black));
	            content2.setPadding(0, 3, 0, 3);
	            content2.setTextSize(12);
	            content2.setWidth(150);
	            content2.setText(contentdata.getAP_NEXTTRBYNAME());
	            rowContentTable.addView(content2, rowParamsDetail);
	            
	            TextView content3 = new TextView(ctx);
	            content3.setGravity(Gravity.CENTER);
	            content3.setTextColor(getResources().getColor(android.R.color.black));
	            content3.setPadding(0, 3, 0, 3);
	            content3.setTextSize(12);
	            content3.setWidth(150);
	            try{
	            	content3.setText(DateFormatter.formatString(DataConverter.stringToDate(contentdata.getCU_BORNDATE())));
	            }
	            catch(Exception ex){}
	            rowContentTable.addView(content3, rowParamsDetail);
	            
	            TextView content4 = new TextView(ctx);
	            content4.setGravity(Gravity.CENTER);
	            content4.setTextColor(getResources().getColor(android.R.color.black));
	            content4.setPadding(0, 3, 0, 3);
	            content4.setTextSize(12);
	            content4.setWidth(150);
	            try{
	            	content4.setText(DateFormatter.formatString(DataConverter.stringToDate(contentdata.getAP_RECVDATE())));
	            }
	            catch(Exception ex){}
	            rowContentTable.addView(content4, rowParamsDetail);
	            
	            TextView content5 = new TextView(ctx);
	            content5.setGravity(Gravity.LEFT);
	            content5.setTextColor(getResources().getColor(android.R.color.black));
	            content5.setPadding(0, 3, 0, 3);
	            content5.setTextSize(12);
	            content5.setWidth(150);
	            content5.setText(contentdata.getPRODCATDESC());
	            rowContentTable.addView(content5, rowParamsDetail);
	            
	            TextView content6 = new TextView(ctx);
	            content6.setGravity(Gravity.LEFT);
	            content6.setTextColor(getResources().getColor(android.R.color.black));
	            content6.setPadding(0, 3, 0, 3);
	            content6.setTextSize(12);
	            content6.setWidth(150);
	            content6.setText(contentdata.getTR_DESC());
	            rowContentTable.addView(content6, rowParamsDetail);
	            
	            amos_tableLayout.addView(rowContentTable);
            }
        }
	}
	
	// detail
	
	private void getDocWithNoAplikasi() {
		pageCount_dtl = GetDocDetailCount();
        if(pageCount_dtl > 0){
        	pageNo_dtl = 1;
        	GetDocDetail(1);
        	viewListInfoDetail();
        }
	}
	
	private void GetDocDetail(int sPages) {
    	if (listdataalldoc != null) {
    		listdataalldoc.clear();
        }
    	setpageNo_dtl(sPages);
    	String noAplikasi = putNOAPLIKASI;
		
		ArrayList<NameValuePair> params1 = new ArrayList<NameValuePair>();
		params1.add(new BasicNameValuePair("noAplikasi", "" +  noAplikasi));
		
		params1.add(new BasicNameValuePair("Pages","" + pageNo_dtl));
                
        SERVICEDATARESPONSE lovResponse;
		try {
			lovResponse = ServiceDataProvider.GetDataDocDetail(params1);
		
          
          if (lovResponse != null) {
        	  listdataalldoc = ServiceData.GetdataDocDetail(new JSONArray(lovResponse.getResults()));
              if (lovResponse.getStatus() == 1) {
                 
              }
              //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
          }
          lovResponse = null;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		viewListInfoDetail();
    }
	
	private void setpageNo_dtl(int pageNo_dtl) {
        String text = null;
        text = pageNo_dtl + "/" + pageCount_dtl;
        txtPageno_dtl.setText(text);
    }
	
	private int GetDocDetailCount()
	{
    	int intCount = 0;
    	try {
    		String noAplikasi = putNOAPLIKASI;
    		
    		ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
    		params.add(new BasicNameValuePair("noAplikasi", "" +  noAplikasi));
            
            SERVICEDATARESPONSE masterCountResponse = ServiceDataProvider.GetDataDocDetailCount(params);
            if (masterCountResponse != null) {
                ArrayList<RequestCount> arrTabunganCountData = ServiceData.GetCount(new JSONArray(masterCountResponse.getResults()));
                if (masterCountResponse.getStatus() == 1) {
                    RequestCount contentdata = arrTabunganCountData.get(0);
                    intCount = Integer.parseInt(contentdata.getPAGES().toString());
                }
   	
            }

    	} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
    	}
    	return intCount;
    }
	
	@SuppressLint("RtlHardcoded") 
	private void viewListInfoDetail()
	{
		amos_tableLayout_dtl.removeAllViews();
		
		TableRow rowHeaderTable = new TableRow(this);
        rowHeaderTable.setBackgroundColor(getResources().getColor(R.color.color_bacground2));
        rowHeaderTable.setPadding(0, 0, 0, 2);

        TableRow.LayoutParams rowParamsDetail = new TableRow.LayoutParams();
        rowParamsDetail.gravity = Gravity.CENTER;
        
        TextView header_detail1 = new TextView(ctx);
        header_detail1.setGravity(Gravity.CENTER);
        header_detail1.setTextColor(getResources().getColor(android.R.color.black));
        header_detail1.setPadding(0, 3, 0, 3);
        header_detail1.setTextSize(12);
        header_detail1.setWidth(200);
        header_detail1.setText("Nama Document");
        rowHeaderTable.addView(header_detail1, rowParamsDetail);
        
        TextView header_detail2 = new TextView(ctx);
        header_detail2.setGravity(Gravity.CENTER);
        header_detail2.setTextColor(getResources().getColor(android.R.color.black));
        header_detail2.setPadding(0, 3, 0, 3);
        header_detail2.setTextSize(12);
        header_detail2.setWidth(150);
        header_detail2.setText("Asli/Tidak");
        rowHeaderTable.addView(header_detail2, rowParamsDetail);
        
        TextView header_detail3 = new TextView(ctx);
        header_detail3.setGravity(Gravity.CENTER);
        header_detail3.setTextColor(getResources().getColor(android.R.color.black));
        header_detail3.setPadding(0, 3, 0, 3);
        header_detail3.setTextSize(12);
        header_detail3.setWidth(150);
        header_detail3.setText("Ada/Tidak");
        rowHeaderTable.addView(header_detail3, rowParamsDetail);

        TextView header_detail4 = new TextView(ctx);
        header_detail4.setGravity(Gravity.CENTER);
        header_detail4.setTextColor(getResources().getColor(android.R.color.black));
        header_detail4.setPadding(0, 2, 0,2);
        header_detail4.setTextSize(12);
        header_detail4.setWidth(150);
        header_detail4.setText("Valid/Tidak Valid");
        rowHeaderTable.addView(header_detail4, rowParamsDetail);
        
        TextView header_detail5 = new TextView(ctx);
        header_detail5.setGravity(Gravity.CENTER);
        header_detail5.setTextColor(getResources().getColor(android.R.color.black));
        header_detail5.setPadding(0, 2, 0,2);
        header_detail5.setTextSize(12);
        header_detail5.setWidth(150);
        header_detail5.setText("Tanggal Terima Dokumen");
        rowHeaderTable.addView(header_detail5, rowParamsDetail);
        
        amos_tableLayout_dtl.addView(rowHeaderTable);
        
      //isi list
        if(listdataalldoc!=null){
            for (int i = 0; i < listdataalldoc.size(); i++) {
            	
            	//final Datatype_Appr_Inbox contentdata = listdata.get(i);
            	final DataType_Ams_informationApk_Detail contentdata = listdataalldoc.get(i);
            	final TableRow rowContentTable = new TableRow(ctx);
		        
		        TextView content_detail1 = new TextView(ctx);
		        content_detail1.setGravity(Gravity.LEFT);
		        content_detail1.setTextColor(getResources().getColor(android.R.color.black));
		        content_detail1.setPadding(0, 3, 0, 3);
		        content_detail1.setTextSize(12);
		        content_detail1.setWidth(200);
		        content_detail1.setText(contentdata.getDOC_DESC());
	            rowContentTable.addView(content_detail1, rowParamsDetail);
	            
	            TextView content_isi_4 = new TextView(ctx);
	            content_isi_4.setGravity(Gravity.CENTER);
	            content_isi_4.setTextColor(getResources().getColor(android.R.color.black));
	            content_isi_4.setPadding(0, 3, 0, 3);
	            content_isi_4.setTextSize(12);
	            content_isi_4.setWidth(150);
	            if(contentdata.getDOC_ORIG().equals("1"))
	            	content_isi_4.setText("Asli");
	            else
	            	content_isi_4.setText("Copy");
	         
	            rowContentTable.addView(content_isi_4, rowParamsDetail);
	            
	            TextView content_isi_5 = new TextView(ctx);
	            content_isi_5.setGravity(Gravity.CENTER);
	            content_isi_5.setTextColor(getResources().getColor(android.R.color.black));
	            content_isi_5.setPadding(0, 3, 0, 3);
	            content_isi_5.setTextSize(12);
	            content_isi_5.setWidth(150);
	            if(contentdata.getDOC_AVAIL().equals("1"))
	            	content_isi_5.setText("Ada");
	            else
	            	content_isi_5.setText("Tidak Ada");
	         
	            rowContentTable.addView(content_isi_5, rowParamsDetail);
	            
	            TextView content_isi_6 = new TextView(ctx);
	            content_isi_6.setGravity(Gravity.CENTER);
	            content_isi_6.setTextColor(getResources().getColor(android.R.color.black));
	            content_isi_6.setPadding(0, 3, 0, 3);
	            content_isi_6.setTextSize(12);
	            content_isi_6.setWidth(150);
	            if(contentdata.getDOC_VALID().equals("1"))
	            	content_isi_6.setText("Valid");
	            else
	            	content_isi_6.setText("Tidak Tidak");
	         
	            rowContentTable.addView(content_isi_6, rowParamsDetail);
	            
	            
	            
	            TextView content_detail5 = new TextView(ctx);
	            content_detail5.setGravity(Gravity.CENTER);
	            content_detail5.setTextColor(getResources().getColor(android.R.color.black));
	            content_detail5.setPadding(0, 3, 0, 3);
	            content_detail5.setTextSize(12);
	            content_detail5.setWidth(150);
	            try{
	            	//content_detail4.setText(DateFormatter.formatString(contentdata.getDOC_RECVDATE()));
	            	content_detail5.setText(DateFormatter.formatString(DataConverter.stringToDate(contentdata.getDOC_RECVDATE())));
	            }
	            catch(Exception ex){}
	            rowContentTable.addView(content_detail5, rowParamsDetail);
	            
	            amos_tableLayout_dtl.addView(rowContentTable);
            }
        }
        
	}
	
	@Override
    public void onBackPressed() {
        ActivityHandler.gotoActivity(ctx, HomeActivity.class, null);
        finish();
    }
}