package com.mobile.amos;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.ByteArrayBuffer;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.mobile.app.activity.HomeActivity;
import com.mobile.app.activity.PreviewImageNew;
import com.mobile.app.configuration.AppConstants;
import com.mobile.app.ui.ListOfValueAdapter;
//import com.mobile.appraisal.Fragment_Dokumen_Jaminan_Dialog;
import com.mobile.bo.app.dataprovider.Amos_Document_UploadDataProvider;
import com.mobile.bo.app.dataprovider.Appr_DokumentDataProvider;
import com.mobile.bo.app.dataprovider.Appr_Email;
import com.mobile.bo.app.dataprovider.LOVDataProvider;
import com.mobile.bo.app.dataprovider.PhotoDataProvider;
import com.mobile.bo.app.datatype.DataType_Amos_Document_Upload;
import com.mobile.bo.app.datatype.DataType_Amos_Email;
import com.mobile.bo.app.datatype.Datatype_Appr_Dokument;
import com.mobile.bo.app.datatype.Datatype_attachment;
import com.mobile.bo.app.datatype.LovData;
import com.mobile.bo.app.datatype.PhotoData;
import com.mobile.bo.app.datatype.UserData;
import com.mobile.database.app.common.DataConverter;
import com.mobile.framework.activity.ActivityHandler;
import com.mobile.framework.common.DateFormatter;
import com.mobile.framework.common.FileUtility;
import com.mobile.framework.data.SessionSharedPreference;
import com.mobile.framework.webservices.HttpFileUpload;
import com.mobile.framework.widget.ISpinnerItem;

import com.mobile.services.app.ServiceData;
import com.mobile.services.app.datatype.DATA_RESPONSE;
import com.mobile.services.app.datatype.PHOTORESPONSE;
import com.mobile.services.app.datatype.SERVICEDATARESPONSE;
import com.mobile.services.app.services.JSONServiceHandler;
import com.mobile.services.app.services.ServiceDataProvider;

import maybank.mobile.amos.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnFocusChangeListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView.OnDismissListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Upload_JaminanActivity extends Activity 
{
		
	private Context ctx = null;
	
	private PhotoDataProvider photoDataProvider;
	private PhotoData photodata;
	private Appr_Email appr_Email = new Appr_Email();
	private DataType_Amos_Email dataType_Amos_Email = new DataType_Amos_Email();
	private Upload_Jaminan_Document_Dialog upload_jaminan_document_dialog = null;
	private ArrayList<DataType_Amos_Document_Upload> listdataall  = null;
	private ArrayList<DataType_Amos_Document_Upload> listdataalls  = null;
	private Amos_Document_UploadDataProvider amos_Document_DataProvider;
	private DataType_Amos_Document_Upload data_document = null;
	private PreviewImageNew  previewimg = null;
	
	private LOVDataProvider lovDataProvider;
	
	private ArrayList<String> List_Code  = new ArrayList<String>(); //dsppk
	private ArrayList<ISpinnerItem> lovDokumen = new ArrayList<ISpinnerItem>(); //dsppk
	private LovData dataDokumen = new LovData(); //dsppk
	private ArrayList<PhotoData> ReadyUpload = new ArrayList<PhotoData>(); 

	private Boolean kon;
	
	private TableLayout amos_TableLayout;
	private TextView lbl_tbl_name;
	
	private Button btn_new;
	private Button btn_submit;
	private static final int REQUEST_CODE_CHOOSE_PICTURE_FROM_GALLARY = 99;
	
	private String userid = "", ap_regno = "", doccode="";
	private String filename="", fileID="";
	private UserData userDetail;
	private String uploadBit = "";
	
	final int CAMERA_CAPTURE = 1;
	View view=null;
	String value1;
	
	private ArrayList<Object> newArrayList = new ArrayList<Object>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		//view = inflater.inflate(R.layout.amos_upload_document_jaminan, null);
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.amos_upload_document_jaminan);
		ctx = this;
		
		getActionBar().setTitle("Document");
		getActionBar().setIcon(R.drawable.dokumen);
		getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
		
		appr_Email = new Appr_Email();
		dataType_Amos_Email = new DataType_Amos_Email();
		try {
			userDetail = (UserData) SessionSharedPreference.getDataFromSharedPreference(ctx, UserData.class, AppConstants.USER_SESSION);
			userid = userDetail.getUSERID();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		upload_jaminan_document_dialog = new Upload_Jaminan_Document_Dialog(ctx);
		amos_Document_DataProvider = new Amos_Document_UploadDataProvider();
		data_document = new DataType_Amos_Document_Upload();
		photoDataProvider = new PhotoDataProvider();
		photodata = new PhotoData();
		
		amos_TableLayout = (TableLayout) findViewById(R.id.amos_tableLayout);
		lbl_tbl_name =(TextView) findViewById(R.id.lbl_tbl_amos);
		
		
		lbl_tbl_name.setText(R.string.lbl_doc_jaminan);
		btn_new = (Button) findViewById(R.id.btn_new);
		btn_submit = (Button) findViewById(R.id.btn_submit);
		
		buttonClick();
		
		
		if(savedInstanceState != null) {
			
			value1 = savedInstanceState.getString("1");
			filename= savedInstanceState.getString("filename");
			if(!value1.toString().equals("")) {
				data_document = amos_Document_DataProvider.getAllData_search_by_Id(value1);
				updateDocJaminan();
				upload_jaminan_document_dialog.show();
			}
			
		}
		else{
			
			getDataFromServerAmos();
			
		}
		
		//return view;
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		outState.putString("1",upload_jaminan_document_dialog.getData_txt_id_dokumen().toString());
		outState.putString("filename",filename);
	}
	
	public void showConfirmationSubmit(final boolean isparent) 
	{
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctx);
		alertDialog.setTitle("Confirm");
		alertDialog.setMessage(R.string.msg_notification_submitAmos);
		alertDialog.setPositiveButton(R.string.str_yes, new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
		       	try {
		       		SubmittedDokumen();
		       		
				} catch (Exception e) {
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
	
	private void buttonClick() 
	{
		btn_new.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				newDocJaminan();
				upload_jaminan_document_dialog.show();
			}
			
		});
		
		btn_submit.setBackgroundResource(R.drawable.custom_button);
//		btn_submit.getBackground().setColorFilter(R.drawable.custom_button);
		btn_submit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try{
					//new SubmittedDokumen().execute();
            		showConfirmationSubmit(true);
				}
				catch(Exception ex){
					showAlert(R.string.msg_notification_submit_failed);
				}
			}
			
		});
		
		Button btnSimpan = new Button(ctx);
		btnSimpan.setGravity(Gravity.CENTER);
		btnSimpan.setWidth(140);
		btnSimpan.setText(R.string.str_save);
		upload_jaminan_document_dialog.getSearch_Layout_Action().addView(btnSimpan);
		btnSimpan.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				saveDocument();
			}
		});
		
		Button btnTutup = new Button(ctx);
		btnTutup.setGravity(Gravity.CENTER);
		btnTutup.setWidth(140);
		btnTutup.setText(R.string.form_action_tutup);
		upload_jaminan_document_dialog.getSearch_Layout_Action().addView(btnTutup);
		btnTutup.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				upload_jaminan_document_dialog.setData_txt_id_dokumen("");
//				do {
					upload_jaminan_document_dialog.dismiss();
//				} while(!upload_jaminan_document_dialog.getData_txt_id_dokumen().toString().equals(""));
				
			}
		});
		
		upload_jaminan_document_dialog.getBtn_savedokumen().setVisibility(View.GONE);
		upload_jaminan_document_dialog.getBtn_savedokumen().setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				saveDocument();
			}
		});
		
		upload_jaminan_document_dialog.getBtn_cancel().setVisibility(View.GONE);
		upload_jaminan_document_dialog.getBtn_cancel().setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				upload_jaminan_document_dialog.setData_txt_id_dokumen("");
				if(upload_jaminan_document_dialog.getData_txt_id_dokumen().toString().equals("")) {
					upload_jaminan_document_dialog.dismiss();
				}
			}
		});
		
		upload_jaminan_document_dialog.getBtn_takepicture().setOnClickListener(new View.OnClickListener() {
    		
            @Override
            public void onClick(View v) {
//	            	if(CekMandatory().equals(true))
            	getPictureFromCamera();
            }
    	});
		
		upload_jaminan_document_dialog.getBtn_takefile().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//	            	if(CekMandatory().equals(true))
            		getPictureFromGallery();            
            }
        });
		
		upload_jaminan_document_dialog.getBtn_imgPreview().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	
//	            	if(CekMandatory().equals(true))
            		loadImage();
            }
        });
	}
	
	final void getDataFromServerAmos() {
		
		  Intent iin= getIntent();
	        Bundle b = iin.getExtras();
        if(b != null)
        {
        	ap_regno = (String)b.get("AP_REGNO");
        	newOpenDocumentList();
            GetDataInqury(ap_regno);
        }
	}
	
	@Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        
		if(item.getTitle().toString()=="Refresh") {
			getDataFromServerAmos();
		}
		
		int id=item.getItemId();
   	 	if (id==android.R.id.home) {
   	 		BackActivity();
        }
		return true;
    }
	
	public void BackActivity() {
		Intent i = new Intent(Upload_JaminanActivity.this, Upload_DocumentActivity.class);   
		startActivity(i);
		finish();
	}
	
	private void newOpenDocumentList() {
		try {
			amos_Document_DataProvider.deleteDocumentByNoAplikasi(ap_regno);
		} catch (Exception e) { }
		try {
			ArrayList<PhotoData> arrDataPhotoOld = photoDataProvider.getATTACHMENTByProspek(ap_regno);
			if(arrDataPhotoOld.size() > 0) {
				for(int yu = 0; yu < arrDataPhotoOld.size();yu++) {
					try {
						FileUtility.deleteFile(arrDataPhotoOld.get(yu).getFILENAME().toString(), AppConstants.FILEPATH);
					} catch(Exception er) {}
//					photoDataProvider.deleteATTACHMENTById(arrDataPhotoLama.get(yu).getID().toString());
					try {
						photodata = new PhotoData();
						photodata = photoDataProvider.getATTACHMENTDetail(arrDataPhotoOld.get(yu).getID().toString());
	        			photodata.setATTACH_TYPE_CODE(AppConstants.OLDF);
	        			photoDataProvider.updateATTACHMENT(photodata);
					} catch(Exception er) {}

				}
			}
			
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
//	private void GetDataLocal(String ap_regno) 
//	{
//		try {
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			btn_new.setVisibility(View.GONE);
//		}
//		
//	}

	private void GetDataInqury(String ap_regno)
	{
		
    	try {
			ArrayList<NameValuePair> params12 = new ArrayList<NameValuePair>();
            params12.add(new BasicNameValuePair("AP_REGNO", ap_regno  ));
            params12.add(new BasicNameValuePair("USERID", userid)); // userDetail.getUSERID()
            params12.add(new BasicNameValuePair("TC", "2.1.1"  ));
            
            SERVICEDATARESPONSE DokumentResponse = ServiceDataProvider.getDocumentbyregno(params12);
                
            if (DokumentResponse != null) {
                ArrayList<DataType_Amos_Document_Upload> arrLOVServiceData = ServiceData.GetDocumentamos(new JSONArray(DokumentResponse.getResults()));
                if (DokumentResponse.getStatus() == 1) {
                    for (int i = 0; i < arrLOVServiceData.size(); i++) {
                    	amos_Document_DataProvider.updateData(arrLOVServiceData.get(i));
                    }
                    arrLOVServiceData = null;
                }
                //listdataall=arrLOVServiceData;
                //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            }
            btn_new.setVisibility(View.VISIBLE);
            DokumentResponse = null;
            
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			btn_new.setVisibility(View.GONE);
		}
    	
//    	try {
//    		photoDataProvider.deleteATTACHMENTBynoApk(ap_regno);
//    	}catch(Exception e) { }
    	
    	try {
            ///Attactment
            ArrayList<NameValuePair> params30 = new ArrayList<NameValuePair>();
            params30.add(new BasicNameValuePair("AP_REGNO", ap_regno));
            
            SERVICEDATARESPONSE PhotoDataResponse = ServiceDataProvider.getDocumentFile(params30);
            
            if (PhotoDataResponse != null) {
                ArrayList<PhotoData> arrLOVServiceData = ServiceData.getDocumentFile(new JSONArray(PhotoDataResponse.getResults()));
                if (PhotoDataResponse.getStatus() == 1) {
                	
                    for (int i = 0; i < arrLOVServiceData.size(); i++) {
                    	ArrayList<PhotoData> arrDataPhotoLama = photoDataProvider.getATTACHMENTByFileOld(ap_regno, 
                    			arrLOVServiceData.get(i).getATTACH_ID().toString(), arrLOVServiceData.get(i).getID().toString());
                    	if(arrDataPhotoLama.size() > 0) {
                    		for(int is = 0; is < arrDataPhotoLama.size(); is++) {
                    			try{
                    				FileUtility.deleteFile(arrLOVServiceData.get(is).getFILENAME().toString(), AppConstants.FILEPATH);
                            	}catch(Exception e) { }
//                        		photoDataProvider.deleteATTACHMENTById(arrLOVServiceData.get(is).getID().toString());
                    			try {
            						photodata = new PhotoData();
            						photodata = photoDataProvider.getATTACHMENTDetail(arrLOVServiceData.get(is).getID().toString());
            	        			photodata.setATTACH_TYPE_CODE(AppConstants.OLDF);
            	        			photoDataProvider.updateATTACHMENT(photodata);
            					} catch(Exception er) {}
                    		}
                    	}
                    	
                    	photoDataProvider.updateATTACHMENT(arrLOVServiceData.get(i));
//                     	   	DownloadImageFromUrl(arrLOVServiceData.get(i).getCOL_ID().toString(), arrLOVServiceData.get(i).getAP_REGNO().toString(), arrLOVServiceData.get(i).getFILENAME().toString());
                    }
                    arrLOVServiceData = null;
                }
                //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            }
            
            PhotoDataResponse = null;
    	} 
		catch (Exception e) {
	// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		viewListUpload();
    }
	
	public void showAlert(int messageId) 
	{
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
	
	public void showAlertOpenSet(String message) 
	{
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctx);
        alertDialog.setTitle(R.string.MESSAGE);
        alertDialog.setMessage(message);
        alertDialog.setPositiveButton(R.string.str_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }
	
	private void viewListUpload()
	{
		
		if (listdataall != null) {
    		listdataall.clear();
        }
		
		listdataall = amos_Document_DataProvider.getAllData_search_by_User(ap_regno);
		if (listdataall != null) {
			amos_TableLayout.removeAllViews();
			
			TableRow rowHeaderTable = new TableRow(ctx);
			rowHeaderTable.setBackgroundColor(getResources().getColor(R.color.color_bacground2));
			rowHeaderTable.setPadding(0, 0, 0, 2);
			
			TableRow.LayoutParams rowParamsDetail = new TableRow.LayoutParams();
			rowParamsDetail.gravity = Gravity.LEFT;
			
			TextView header = new TextView(ctx);
			header.setGravity(Gravity.CENTER);
			header.setTextColor(getResources().getColor(android.R.color.black));
			header.setPadding(0, 3, 0, 3);
			header.setTextSize(12);
			header.setWidth(150);
			header.setText("Action");
			
			rowHeaderTable.addView(header, rowParamsDetail);
			
			TextView header1 = new TextView(ctx);
			header1.setGravity(Gravity.LEFT);
			header1.setTextColor(getResources().getColor(android.R.color.black));
			header1.setPadding(0, 3, 0, 3);
			header1.setTextSize(12);
			header1.setWidth(200);
			header1.setText("Nama Dokumen");
			rowHeaderTable.addView(header1, rowParamsDetail);
			
			TextView header2 = new TextView(ctx);
			header2.setGravity(Gravity.LEFT);
			header2.setTextColor(getResources().getColor(android.R.color.black));
			header2.setPadding(0, 3, 0, 3);
			header2.setTextSize(12);
			header2.setWidth(150);
			header2.setText("Dokumen No");
			
			rowHeaderTable.addView(header2, rowParamsDetail);
			
			
			TextView header3 = new TextView(ctx);
			header3.setGravity(Gravity.LEFT);
			header3.setTextColor(getResources().getColor(android.R.color.black));
			header3.setPadding(0, 3, 0, 3);
			header3.setTextSize(12);
			header3.setWidth(100);
			header3.setText("Asli/Tidak");
			
			rowHeaderTable.addView(header3, rowParamsDetail);
			
			
			TextView header4 = new TextView(ctx);
			header4.setGravity(Gravity.LEFT);
			header4.setTextColor(getResources().getColor(android.R.color.black));
			header4.setPadding(0, 3, 0, 3);
			header4.setTextSize(12);
			header4.setWidth(100);
			header4.setText("Ada/Tidak");
			
			rowHeaderTable.addView(header4, rowParamsDetail);
			
			
			TextView header5 = new TextView(ctx);
			header5.setGravity(Gravity.LEFT);
			header5.setTextColor(getResources().getColor(android.R.color.black));
			header5.setPadding(0, 3, 0, 3);
			header5.setTextSize(12);
			header5.setWidth(100);
			header5.setText("Valid/Tidak");
			
			rowHeaderTable.addView(header5, rowParamsDetail);
			
			amos_TableLayout.addView(rowHeaderTable);
			
			for (int i = 0; i < listdataall.size(); i++) {
				final DataType_Amos_Document_Upload contentdata = listdataall.get(i);
				final TableRow rowContentTable = new TableRow(ctx);
				
				Button content_detail = new Button(ctx);
				content_detail.setGravity(Gravity.CENTER);
				content_detail.setText(R.string.form_action_detail1);
				//content_detail.setWidth(30);
				rowContentTable.addView(content_detail, 5, 50);
				content_detail.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						TextView content_id = (TextView) rowContentTable.getChildAt(1);
						doccode = contentdata.getDOC_CODE().toString();
						data_document = new DataType_Amos_Document_Upload();
						data_document = amos_Document_DataProvider.getAllData_search_by_Id(content_id.getText().toString());
						
						updateDocJaminan();
						
						try {
							 if(!contentdata.getDOC_FILE_PATH().toString().equals("")) {
								try {
									String fullPath = "..\\"+"Upload\\"+"DOC\\" + contentdata.getAP_REGNO().toString() + "\\" + contentdata.getDOC_FILE_PATH().toString();
									DownloadImageFromUrlImage(contentdata.getID().toString(),contentdata.getAP_REGNO().toString(), fullPath, contentdata.getDOC_FILE_PATH().toString());
								} catch (Exception e) {}
							}
							if(!contentdata.getDOC_FILE_PATH().toString().equals("")) {
								int intCount = 1;
					        	intCount = photoDataProvider.get_MaxSeq(contentdata.getAP_REGNO().toString());
								fileID = contentdata.getAP_REGNO() + "" + contentdata.getDOC_CODE();
								try {
									photodata = photoDataProvider.getATTACHMENTByFileName(contentdata.getDOC_FILE_PATH().toString());
									photodata.setISALREADYDOWNLOD("1"); // terdownload
									//photodata.setISALREADYUPLOADEDTOSERVER(""); // finish upload
						            photoDataProvider.updateATTACHMENT(photodata);
						            
						            upload_jaminan_document_dialog.getBtn_imgPreview().setVisibility(View.VISIBLE);
								} catch (Exception e) {
									try {
										photodata = new PhotoData();
										try {
											photodata = photoDataProvider.getATTACHMENTDetail(fileID);
										} catch (Exception ex) {
											photodata.setID(fileID);
										}
										
							            photodata.setAP_REGNO(contentdata.getAP_REGNO().toString());
							            photodata.setATTACH_ID(contentdata.getDOC_CODE().toString());
							            photodata.setATTACH_SEQ("" + intCount);
							            photodata.setATTACH_TYPE("image/jpeg");
							            photodata.setATTACH_TYPE_CODE(AppConstants.NEWF);
							            photodata.setFILENAME(contentdata.getDOC_FILE_PATH().toString());
							            photodata.setFILETYPE("DOC");
							            photodata.setUPLOADBY(userid);
							            photodata.setUPLOADDATE(contentdata.getDOC_RECVDATE());
							            photodata.setISALREADYDOWNLOD("1"); // terdownload
//							            photodata.setISALREADYUPLOADEDTOSERVER(""); // finish upload
							            photoDataProvider.updateATTACHMENT(photodata);
							            upload_jaminan_document_dialog.getBtn_imgPreview().setVisibility(View.VISIBLE);
									} catch (Exception ex) {
										upload_jaminan_document_dialog.getBtn_imgPreview().setVisibility(View.GONE);
									}
								}
								
							} else {
								upload_jaminan_document_dialog.getBtn_imgPreview().setVisibility(View.GONE);
							}
								
							upload_jaminan_document_dialog.show();
						} catch (Exception e) {
							e.printStackTrace();
						}
						
					}
			    });
				
				TextView content_isi_1 = new TextView(ctx);
				content_isi_1.setText(contentdata.getID());
				content_isi_1.setVisibility(View.GONE);
				rowContentTable.addView(content_isi_1);
				
				TextView content_isi_2 = new TextView(ctx);
				content_isi_2.setGravity(Gravity.LEFT);
				content_isi_2.setTextColor(getResources().getColor(android.R.color.black));
				content_isi_2.setPadding(0, 3, 0, 3);
				content_isi_2.setTextSize(12);
				content_isi_2.setWidth(200);
				content_isi_2.setText(contentdata.getDOC_DESC().toString());
	            rowContentTable.addView(content_isi_2, rowParamsDetail);
	            
	            TextView content_isi_3 = new TextView(ctx);
	            content_isi_3.setGravity(Gravity.LEFT);
	            content_isi_3.setTextColor(getResources().getColor(android.R.color.black));
	            content_isi_3.setPadding(0, 3, 0, 3);
	            content_isi_3.setTextSize(12);
	            content_isi_3.setWidth(150);
	            content_isi_3.setText(contentdata.getDOC_NO().toString());
	            rowContentTable.addView(content_isi_3, rowParamsDetail);
			    
	            
	            TextView content_isi_4 = new TextView(ctx);
	            content_isi_4.setGravity(Gravity.LEFT);
	            content_isi_4.setTextColor(getResources().getColor(android.R.color.black));
	            content_isi_4.setPadding(0, 3, 0, 3);
	            content_isi_4.setTextSize(12);
	            content_isi_4.setWidth(100);
	            if(contentdata.getDOC_ORIG().equals("1"))
	            	content_isi_4.setText("Asli");
	            else
	            	content_isi_4.setText("Copy");
	         
	            rowContentTable.addView(content_isi_4, rowParamsDetail);
			    
	            
	            
	            TextView content_isi_5 = new TextView(ctx);
	            content_isi_5.setGravity(Gravity.LEFT);
	            content_isi_5.setTextColor(getResources().getColor(android.R.color.black));
	            content_isi_5.setPadding(0, 3, 0, 3);
	            content_isi_5.setTextSize(12);
	            content_isi_5.setWidth(100);
	            if(contentdata.getDOC_AVAIL().equals("1"))
	            	content_isi_5.setText("Ada");
	            else
	            	content_isi_5.setText("Tidak Ada");
	         
	            rowContentTable.addView(content_isi_5, rowParamsDetail);
			    
	            TextView content_isi_6 = new TextView(ctx);
	            content_isi_6.setGravity(Gravity.LEFT);
	            content_isi_6.setTextColor(getResources().getColor(android.R.color.black));
	            content_isi_6.setPadding(0, 3, 0, 3);
	            content_isi_6.setTextSize(12);
	            content_isi_6.setWidth(100);
	            if(contentdata.getDOC_VALID().equals("1"))
	            	content_isi_6.setText("Valid");
	            else
	            	content_isi_6.setText("Tidak Tidak");
	         
	            rowContentTable.addView(content_isi_6, rowParamsDetail);
	            
	           
	            
			    amos_TableLayout.addView(rowContentTable);
			}
		}
	}
	
//	private static final String[] DOKUMENTYPE = new String[] {
//		"Belgium", "France", "Italy", "Germany", "Spain", "FRAKO", "Frana"
//	};
	
	private void newDocJaminan()  //dsppk
	{
		upload_jaminan_document_dialog.getNew_dokumen_layout().setVisibility(View.VISIBLE);
		upload_jaminan_document_dialog.getUpd_dokumen_layout().setVisibility(View.GONE);
		upload_jaminan_document_dialog.getBtn_imgPreview().setVisibility(View.GONE);
		// new DHIMAS
//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(ctx, android.R.layout.simple_dropdown_item_1line, DOKUMENTYPE);
//		upload_jaminan_document_dialog.getData_txt_auto_dokumen().setAdapter(adapter);
		
//		upload_jaminan_document_dialog.getData_txt_auto_dokumen().setOnItemClickListener(new OnItemClickListener() {
//
//			@Override
//            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//				upload_jaminan_document_dialog.setData_txt_id_dokumen("a");
//            }
//        });
		
//		upload_jaminan_document_dialog.getData_txt_auto_dokumen().setOnDismissListener(new OnDismissListener() {
//
//			@Override
//			public void onDismiss() {
//				// TODO Auto-generated method stub
//				upload_jaminan_document_dialog.setData_txt_auto_dokumen("");
//            	upload_jaminan_document_dialog.setData_txt_id_dokumen("");
//			}
//        });
		
//		upload_jaminan_document_dialog.getData_txt_auto_dokumen().setOnFocusChangeListener(new OnFocusChangeListener() {
//            public void onFocusChange(View v, boolean hasFocus) {
//            	if(upload_jaminan_document_dialog.getData_txt_id_dokumen().toString().equals("")) {
//            		upload_jaminan_document_dialog.setData_txt_auto_dokumen("");
//            	}
//            }
//        });
		upload_jaminan_document_dialog.setData_txt_id_dokumen("");
		upload_jaminan_document_dialog.setData_txt_seq("");
		upload_jaminan_document_dialog.setData_txt_nama_dokumen("");
		upload_jaminan_document_dialog.setData_txt_no_dokumen("");
		upload_jaminan_document_dialog.setData_txt_file_upload("");
		
        upload_jaminan_document_dialog.setData_spn_dokumen("");
		
		upload_jaminan_document_dialog.setData_document_rdo_or_asli(true);
		upload_jaminan_document_dialog.setData_document_rdo_or_copy(false);
		
		upload_jaminan_document_dialog.setData_document_rdo_av_ya(true);
		upload_jaminan_document_dialog.setData_document_rdo_av_tidak(false);
		
		upload_jaminan_document_dialog.setData_document_rdo_va_true(true);
		upload_jaminan_document_dialog.setData_document_rdo_va_false(false);
		
		lovDataProvider = new LOVDataProvider();
		
		listdataall = amos_Document_DataProvider.getAllData_search_by_User(ap_regno);
		
		if(listdataall != null) {
			for(int y = 0; listdataall.size() > y; y++) {
				List_Code.add(listdataall.get(y).getDOC_CODE());
			}
		} else {
			List_Code = null;
		}
		
    	lovDokumen = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueDataWithNotInCode(AppConstants.DOCNEW, List_Code));
    	
    	upload_jaminan_document_dialog.setList_spn_dokumen(lovDokumen, false);
    	listdataall = null;
    	
    	setColorMandatory();
    	
	}
	
	@SuppressLint("DefaultLocale") 
	private void saveDocument()  //dsppk
	{
//		ArrayList<PhotoData> arrDataPhotoOlds = photoDataProvider.getATTACHMENTByNomorAndCode(ap_regno, 
//				"E10"); //test dsppk
		
		if(CekMandatory().equals(false)){
			showAlert(R.string.msg_notification_mandatory);
		} else {
			
//			int intCount = 1;
//			if(!upload_jaminan_document_dialog.getData_txt_seq().toString().equals("") && 
//				Integer.parseInt(upload_jaminan_document_dialog.getData_txt_seq().toString()) > 0)
//	    	{
//    		intCount = Integer.parseInt(upload_jaminan_document_dialog.getData_txt_seq().toString());
//	    	} else {
//	    		intCount = amos_Document_DataProvider.getData_search_by_MaxSeq(ap_regno);
//	    	}
			String CodeValue = "";
			if(upload_jaminan_document_dialog.getData_txt_id_dokumen().equals("")) {
				CodeValue = upload_jaminan_document_dialog.getData_spn_dokumen().getSelectedListOfValue().toString();
				dataDokumen = lovDataProvider.getListOfValueDataGrupCode(AppConstants.DOCNEW, CodeValue);
				data_document.setID("AMOS" + "#" + CodeValue);
				data_document.setDOC_DESC(dataDokumen.getDESCRIPTION().toString());
				data_document.setDOC_CODE(CodeValue);
			} else {
				CodeValue = upload_jaminan_document_dialog.getData_txt_id_dokumen();
				data_document.setID(CodeValue);
				data_document.setDOC_DESC(upload_jaminan_document_dialog.getData_txt_nama_dokumen());
			}
			
			data_document.setSEQ(upload_jaminan_document_dialog.getData_txt_seq());
			data_document.setUSERID(userid);
			data_document.setAP_REGNO(ap_regno);
			data_document.setDOC_NO(upload_jaminan_document_dialog.getData_txt_no_dokumen());
			
			data_document.setDOC_FILE_PATH(upload_jaminan_document_dialog.getData_txt_file_upload());
			
			data_document.setDOC_ORIG("0");
			data_document.setDOC_AVAIL("0");
			data_document.setDOC_VALID("0");
			
			data_document.setDOC_RECVDATE(DateFormatter.formatDate(dateNow()));
			
			if(upload_jaminan_document_dialog.getData_document_rdo_or_asli().isChecked())
				data_document.setDOC_ORIG("1");
			if(upload_jaminan_document_dialog.getdata_document_rdo_va_true().isChecked())
				data_document.setDOC_VALID("1");
			if(upload_jaminan_document_dialog.getData_document_rdo_av_ya().isChecked())
				data_document.setDOC_AVAIL("1");
			
			data_document.setISALREADYSUBMIT("1");
			amos_Document_DataProvider.updateData(data_document);
			upload_jaminan_document_dialog.dismiss();
			
			try {
				photodata = new PhotoData();
				photodata = photoDataProvider.getATTACHMENTByFileName(upload_jaminan_document_dialog.getData_txt_file_upload());
				if(photodata.getATTACH_ID().toString().equals("")) {
					photodata.setATTACH_ID(CodeValue);
					photoDataProvider.updateATTACHMENT(photodata);
				}
			} catch (Exception e) { }
			
			viewListUpload();
			
			
		}
		
		
//		try {
//			amos_Document_DataProvider.deleteTransaksiById(upload_jaminan_document_dialog.getData_txt_id_dokumen());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		

	}
	
	public void setColorMandatory() {
		upload_jaminan_document_dialog.getData_spn_dokumen().setBackgroundResource(R.drawable.fillcolor);
	}
	
	private Boolean CekMandatory(){
		boolean retval = true;
		if(upload_jaminan_document_dialog.getData_txt_id_dokumen().equals("")) {
			if(upload_jaminan_document_dialog.getData_spn_dokumen().getSelectedListOfValue().equals("")) {
				retval = false;
			}
		}
		return retval;
	}
	
	private void updateDocJaminan()  //dsppk
	{
		upload_jaminan_document_dialog.getNew_dokumen_layout().setVisibility(View.GONE);
		upload_jaminan_document_dialog.getUpd_dokumen_layout().setVisibility(View.VISIBLE);
		
		upload_jaminan_document_dialog.setData_txt_seq(data_document.getSEQ().toString());
		upload_jaminan_document_dialog.setData_txt_id_dokumen(data_document.getID().toString());
		upload_jaminan_document_dialog.setData_txt_nama_dokumen(data_document.getDOC_DESC().toString());
		upload_jaminan_document_dialog.setData_txt_no_dokumen(data_document.getDOC_NO().toString());
		
		upload_jaminan_document_dialog.setData_txt_file_upload(data_document.getDOC_FILE_PATH().toString());
		
		if(data_document.getDOC_ORIG().toString().equals("1"))
			upload_jaminan_document_dialog.setData_document_rdo_or_asli(true);
		else
			upload_jaminan_document_dialog.setData_document_rdo_or_copy(true);
		
		if(data_document.getDOC_AVAIL().toString().equals("1"))
			upload_jaminan_document_dialog.setData_document_rdo_av_ya(true);
		else
			upload_jaminan_document_dialog.setData_document_rdo_av_tidak(true);
		
		if(data_document.getDOC_VALID().toString().equals("1"))
			upload_jaminan_document_dialog.setData_document_rdo_va_true(true);
		else
			upload_jaminan_document_dialog.setData_document_rdo_va_false(true);
	}
	
	private String dateNow() {
		final Calendar now = Calendar.getInstance();
        int yearNow = now.get(Calendar.YEAR);
        int monthNow = (now.get(Calendar.MONTH));
        int dayNow = now.get(Calendar.DAY_OF_MONTH);
        
        String Date = dayNow + "-" + (monthNow + 1) + "-" + yearNow;
        
        return Date;
	}
	
	private void getPictureFromCamera() 
	{
    	Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    	try {
    		String fileNameCam =  userid + "_" + DateFormatter.formatStringFORMATDDMMYYHHMMSS(new Date());
    		
        	FileUtility.CreatePath(AppConstants.FILEPATH);
        	filename = fileNameCam + "___" + AppConstants.JPGEXTENSION;
            File file = new File(AppConstants.FILEPATH + filename);
        	Uri mImageCaptureUri = null;
        	String state = Environment.getExternalStorageState();
        	mImageCaptureUri = Uri.fromFile(file);
            intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, mImageCaptureUri);
            intent.putExtra("return-data", true);
            startActivityForResult(intent, CAMERA_CAPTURE);
    	} catch(Exception e) {}
	}
	
	private void getPictureFromGallery() {
        Intent gallerypickerIntent = new Intent(Intent.ACTION_PICK);
        try {
	        gallerypickerIntent.setType("image/*");
	        gallerypickerIntent.putExtra("outputFormat",Bitmap.CompressFormat.PNG.name());
	        gallerypickerIntent.putExtra("return-data", true);
	        startActivityForResult(gallerypickerIntent, REQUEST_CODE_CHOOSE_PICTURE_FROM_GALLARY);
		} catch(Exception e) {}
    }
	
	@SuppressLint("ShowToast")
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		photodata = new PhotoData();
//			filename = "";
    	super.onActivityResult(requestCode, resultCode, data);
    	try {
	        if (requestCode == REQUEST_CODE_CHOOSE_PICTURE_FROM_GALLARY && null != data) {
	            Uri selectedImage = data.getData();	
	            
		            String[] filePathColumn = { MediaStore.Images.Media.DATA };
		            
		            Cursor cursor = getContentResolver().query(selectedImage,
		                    filePathColumn, null, null, null);
	            
		            cursor.moveToFirst();
		 
		            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
		            String picturePath = cursor.getString(columnIndex);
		            cursor.close();
	            
	//	            String fileName =  userDetail.getUSERID()  + DateFormatter.formatStringFORMATDDMMYYHHMMSS(new Date());
		            String fileName =  userid + "_" + DateFormatter.formatStringFORMATDDMMYYHHMMSS(new Date());
		            filename = fileName + "___" + AppConstants.JPGEXTENSION;
		            
		            File directory = new File(picturePath);
		           
		            Bitmap imgBitmap =  BitmapFactory.decodeFile(picturePath);
		            //FileUtility.CreatePath();
		            FileUtility.CreatePath(AppConstants.FILEPATHS);
		            FileUtility.resizeImageFile(directory.getName().toString(),filename,directory.getParent().toString(),AppConstants.FILEPATH);
		            
		            int intCount = photoDataProvider.get_MaxSeq(ap_regno);
	            	fileID = "GAL_" + ap_regno + doccode + intCount;
	            	photodata.setATTACH_SEQ("" + intCount);
		            
		            setterImage();
		            
		            showIdFileUpload();
		            //loadImage();
		            upload_jaminan_document_dialog.getBtn_imgPreview().setVisibility(View.VISIBLE);
	        }
	        else  if (requestCode == CAMERA_CAPTURE)
	        {
	        	try {
	        		FileUtility.CreatePath(AppConstants.FILEPATHS);
		            FileUtility.resizeImage(filename, AppConstants.FILEPATH);
		            
		            int intCount = photoDataProvider.get_MaxSeq(ap_regno);
	            	fileID = "CAM_" + ap_regno + doccode + intCount;
	            	photodata.setATTACH_SEQ("" + intCount);
	            	
		            setterImage();
		            
		            showIdFileUpload();
		            upload_jaminan_document_dialog.getBtn_imgPreview().setVisibility(View.VISIBLE);
		            //loadImage();
	        	} catch(Exception e) {}
	        }
    	} catch(Exception e) {}
	}
	
	private void setterImage() {
		
    	
		photodata.setID(fileID);
        photodata.setAP_REGNO(ap_regno);
        photodata.setATTACH_ID(doccode);
        photodata.setATTACH_TYPE("image/jpeg");
        photodata.setATTACH_TYPE_CODE(AppConstants.NEWF);
        photodata.setFILENAME(filename);
        photodata.setFILETYPE("DOC");
        photodata.setUPLOADBY(userid);
        photodata.setUPLOADDATE(new Date());
        photodata.setISALREADYUPLOADEDTOSERVER("0"); // belum terupload
        photoDataProvider.updateATTACHMENT(photodata);
	}
	
	private void SubmittedDokumen()
	{
		
		ReadyUpload = photoDataProvider.getATTACHMENTByReadyUploadToServer(ap_regno, AppConstants.NEWF); // document yang siap untuk di upload
		
		uploadBit = AppConstants.TIDAKADADATABARU;
		
		Amos_Document_UploadDataProvider appr_DokumentDataProvider=new Amos_Document_UploadDataProvider();
		
		ArrayList<DataType_Amos_Document_Upload> arrdata = appr_DokumentDataProvider.getAllData_search_by_Userupload(ap_regno);
		newArrayList = new ArrayList<Object>();
		for(int po = 0; arrdata.size() > po; po++) {
			
			if(!arrdata.get(po).getISALREADYSUBMIT().toString().equals("")) {
				DataType_Amos_Document_Upload arrdata2 = new DataType_Amos_Document_Upload();
				arrdata2.setID(arrdata.get(po).getID().toString());
				
				if(arrdata.get(po).getSEQ().toString().equals("0") || arrdata.get(po).getSEQ().toString().equals("")) {
					arrdata2.setSEQ("");
				} else {
					arrdata2.setSEQ(arrdata.get(po).getSEQ().toString());
				}
				
				
				arrdata2.setAP_REGNO(arrdata.get(po).getAP_REGNO().toString());
				arrdata2.setDOC_CODE(arrdata.get(po).getDOC_CODE().toString());
				arrdata2.setDOC_AVAIL(arrdata.get(po).getDOC_AVAIL().toString());
				arrdata2.setDOC_NO(arrdata.get(po).getDOC_NO().toString());
				arrdata2.setDOC_ORIG(arrdata.get(po).getDOC_ORIG().toString());
				arrdata2.setDOC_VALID(arrdata.get(po).getDOC_VALID().toString());
				
				try {
					arrdata2.setDOC_RECVDATE(arrdata.get(po).getDOC_RECVDATE());
				} catch (Exception e) { }
				
				newArrayList.add(arrdata2);
				uploadBit = AppConstants.BERHASIL;
			}
		}
		
		new SubmittedDok().execute();
		
		viewListUpload();
		arrdata = null;
	
	}
	
	private class SubmittedDok extends AsyncTask<Void, Void,Void> {
		
		ProgressDialog dialogWait = ProgressDialog.show(ctx, "Loading", "Please wait...", true);
		ArrayList<String> uploadSuccess = new ArrayList<String>(); //ketika upload file berhasil di tampung di sini doc codenya
		ArrayList<String> docCodeSuccess = new ArrayList<String>(); // ketika data berhasil di save di fileupload
		ArrayList<String> successIds = new ArrayList<String>(); //ketika save appdoc berhasil di tampung di sini idnya
		ArrayList<String> successDc = new ArrayList<String>(); //ketika save appdoc berhasil di tampung di sini doc codenya
		ArrayList<String> findSuccessDoc = new ArrayList<String>();// ketika mencari perbandingan antara docCodeSuccess dan successDc
		ArrayList<String> setFileName = new ArrayList<String>(); // menampung file name baru yang akan di upload
		ArrayList<String> setFileNameOld = new ArrayList<String>(); // menampung file name lama yang akan di hapus dari server
		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			try {
				
				Gson gsondata=new Gson();
				
				ArrayList<DATA_RESPONSE> Response = ServiceDataProvider.submitData_dokumen_amos(gsondata.toJson(newArrayList).toString());
				if (Response != null) {
					if (Response.size() > 0) {
						for (int it=0; Response.size()>it; it++){
							boolean statusdoc=true;
							DATA_RESPONSE objRes= Response.get(it);
							if (objRes.getSTATUS().equalsIgnoreCase(AppConstants.STATUSPROSPEKTRUE)) {
								String[] splitID = objRes.getID().toString().split("~");
								String realID = splitID[0].toLowerCase();
								String fakeID = splitID[1];
								
								if(!fakeID.toString().equals(realID)) {
									data_document = new DataType_Amos_Document_Upload();
									data_document = amos_Document_DataProvider.getAllData_search_by_Id(fakeID);
									data_document.setID(realID);
									//data_document.setISALREADYSUBMIT("");
									amos_Document_DataProvider.updateData(data_document);
									amos_Document_DataProvider.deleteDocumentById(fakeID);
//									DataType_Amos_Document_Upload a = amos_Document_DataProvider.getAllData_search_by_Id(realID);
//								} else {
									//data_document.setISALREADYSUBMIT("");
//									amos_Document_DataProvider.updateData(data_document);
								}
								successIds.add(realID);
								//setFileName.add(data_document.getDOC_FILE_PATH().toString());
				
								data_document = new DataType_Amos_Document_Upload();
								data_document = amos_Document_DataProvider.getAllData_search_by_Id(realID);
								String namafile = data_document.getDOC_FILE_PATH().toString();
						//if(setFileName.size() > 0) {
							ArrayList<PhotoData> arrdataPhoto = photoDataProvider.getATTACHMENTByReadyUploadToServerNews(ap_regno, namafile, AppConstants.NEWF);
							if (arrdataPhoto.size() > 0) {
								for (int i = 0; i < arrdataPhoto.size(); i++) {
									
									ArrayList<NameValuePair> params2 = new ArrayList<NameValuePair>();
									
									String[] splitImg = arrdataPhoto.get(i).getFILENAME().toString().split("___.");
									String imgName = splitImg[0] + "___";
									String imgExt = splitImg[1];
									
									params2.add(new BasicNameValuePair("ID", arrdataPhoto.get(i).getID().toString()));
									params2.add(new BasicNameValuePair("AP_REGNO", arrdataPhoto.get(i).getAP_REGNO().toString()));
									params2.add(new BasicNameValuePair("FILENAME", arrdataPhoto.get(i).getFILENAME().toString()));
									params2.add(new BasicNameValuePair("DOC_CODE", arrdataPhoto.get(i).getATTACH_ID().toString()));
									params2.add(new BasicNameValuePair("FILE_CAB", "DOC"));
									params2.add(new BasicNameValuePair("FILE_NAME", imgName));
									params2.add(new BasicNameValuePair("FILE_EXT", imgExt));
									params2.add(new BasicNameValuePair("UPLOADER", userid));
									params2.add(new BasicNameValuePair("FILE_PATH", ""));
									
									try{
										params2.add(new BasicNameValuePair("UPLOADDATE", DataConverter.dateTimeToString(arrdataPhoto.get(i).getUPLOADDATE())));
									}
									catch(Exception ex)
									{
										params2.add(new BasicNameValuePair("UPLOADDATE", ""));
									}
									
									
									uploadBit = AppConstants.BERHASIL;
									
									
									String retval="";
									
									FileInputStream fstrm;
									try {
										 fstrm = new FileInputStream(AppConstants.FILEPATH + arrdataPhoto.get(i).getFILENAME().toString());
//										 HttpFileUpload hfu = new HttpFileUpload("http://192.168.1.141/biimobileamos/Contract/upload.aspx",arrdataPhoto.get(i).getFILENAME().toString(),arrdataPhoto.get(i).getCOL_ID().toString(),arrdataPhoto.get(i).getAP_REGNO().toString());
										 HttpFileUpload hfu = new HttpFileUpload("http://10.225.16.143/biimobileamos/Contract/upload.aspx",arrdataPhoto.get(i).getFILENAME().toString(),arrdataPhoto.get(i).getCOL_ID().toString(),arrdataPhoto.get(i).getAP_REGNO().toString());
										 retval=hfu.Send_Now(fstrm);
										 
										//hfu.sendFilePost("http://10.225.16.30/biimobilesme/Contract/upload.aspx", AppConstants.FILEPATH + filename);
									} catch (Exception e) {
										e.printStackTrace();
									}
									
									if(retval.equals("OK")){ // && arrdataPhoto.get(i).getATTACH_ID().toString().equals("E10")
										//old
//										PHOTORESPONSE photoResponse = ServiceDataProvider.uploadProspekPhoto(params2, arrdataPhoto.get(i).getFILENAME().toString());
//										PHOTORESPONSE photoResponse = ServiceDataProvider.uploadProspekPhoto(params2, arrdataPhoto.get(i).getFILENAME().toString());
										//end old
										uploadSuccess.add(arrdataPhoto.get(i).getATTACH_ID());
										
										JSONObject obj = new JSONObject();
										obj.put("ID",arrdataPhoto.get(i).getID().toString() );
										obj.put("AP_REGNO",  arrdataPhoto.get(i).getAP_REGNO().toString());
										obj.put("FILENAME", arrdataPhoto.get(i).getFILENAME().toString());
										obj.put("DOC_CODE",arrdataPhoto.get(i).getATTACH_ID().toString() );
										obj.put("FILE_CAB", "DOC");
										obj.put("FILE_EXT", imgExt);
										obj.put("FILE_NAME", imgName);
										obj.put("UPLOADER", userid);
										obj.put("FILE_PATH", "");
										
										
										try{
											obj.put("UPLOADDATE", DataConverter.dateTimeToString(arrdataPhoto.get(i).getUPLOADDATE()));
										}
										catch(Exception ex)
										{
											obj.put("UPLOADDATE", "");
										}
										//new
										DATA_RESPONSE photoResponse = ServiceDataProvider.uploadProspekPhotoData(obj.toString());
										//end new
										
										String photoresStatus = photoResponse.getSTATUS().toString();
										if (photoresStatus.toString().equals("1")) {
											photodata = new PhotoData();
											photodata = photoDataProvider.getATTACHMENTDetail(arrdataPhoto.get(i).getID().toString());
											
											photodata.setID(arrdataPhoto.get(i).getID().toString());
								            photodata.setAP_REGNO(arrdataPhoto.get(i).getAP_REGNO().toString());
								            photodata.setISALREADYUPLOADEDTOSERVER("1"); // terupload
								            photoDataProvider.updateATTACHMENT(photodata);
											uploadBit = AppConstants.BERHASIL;
											docCodeSuccess.add(arrdataPhoto.get(i).getATTACH_ID());
											
										}
									} else {
										uploadBit = AppConstants.GAGALUPLOADFILE;
										statusdoc=false;
										break;
									}
								}
							}
							arrdataPhoto = null;
						//}
							}
							else{
								statusdoc=false;
							}
							if(statusdoc==true){
								if(docCodeSuccess.size() > 0) {
									findSuccessDoc = docCodeSuccess;
								} else {
									successDc.add(data_document.getDOC_CODE());
									findSuccessDoc = successDc;
								}
								
							}
						}
					}
				}
				else{
					//Log.d(TAG, "Send Data To Server Via Service: Server returned null");
				}
			} catch (Exception e) {
				Log.d("Error", "Send Data To Server Via Service: Exception ->"+e.getMessage());
				uploadBit = AppConstants.GAGALUPLOADFILE;
			}
			return null;
		}
		
		protected void onPostExecute(Void result) {
			
			if (listdataalls != null) {
	    		listdataalls.clear();
	        }
			
			
			listdataalls = amos_Document_DataProvider.getAllData_bySubimt(successIds,findSuccessDoc,ap_regno);
			if(listdataalls.size() > 0) {
				for(int lo = 0;lo < listdataalls.size(); lo++) {
					data_document = new DataType_Amos_Document_Upload();
					data_document = amos_Document_DataProvider.getAllData_search_by_Id(listdataalls.get(lo).getID().toString().toLowerCase());
					data_document.setISALREADYSUBMIT("");
					amos_Document_DataProvider.updateData(data_document);
				}
			}
			
			newArrayList = null;
			
			if(uploadBit.toString().equals(AppConstants.BERHASIL) && (uploadSuccess.size() > 0 || successIds.size() > 0 )) {
				android.text.format.DateFormat df =new android.text.format.DateFormat();
				String SID=df.format("yyyyMMddhhmmss", new java.util.Date()).toString();
				dataType_Amos_Email.setID(userid + "DOC" +  SID);
	    		dataType_Amos_Email.setISALREADYSUBMIT("1");
	    		dataType_Amos_Email.setTYPE("SCORE");
	    		appr_Email.updateData(dataType_Amos_Email);
	    		
				ArrayList<PhotoData> arrDataPhoto = photoDataProvider.getATTACHMENTByUploader(ap_regno);
				
				for (int u = 0; u < arrDataPhoto.size(); u++) {
					photodata = new PhotoData();
					photodata = photoDataProvider.getATTACHMENTDetail(arrDataPhoto.get(u).getID().toString());
					
					photodata.setID(arrDataPhoto.get(u).getID().toString());
		            photodata.setAP_REGNO(arrDataPhoto.get(u).getAP_REGNO().toString());
		            photodata.setISALREADYUPLOADEDTOSERVER(""); // finish upload
		            photoDataProvider.updateATTACHMENT(photodata);
		            
	                FileUtility.deleteFile(arrDataPhoto.get(u).getFILENAME().toString(), AppConstants.FILEPATH);

	                ArrayList<PhotoData> arrDataPhotoOld = photoDataProvider.getATTACHMENTByFileOld(ap_regno, 
	                		arrDataPhoto.get(u).getATTACH_ID().toString(), arrDataPhoto.get(u).getID().toString());
	                if(arrDataPhotoOld.size() > 0) {
		                for (int i = 0; i < arrDataPhotoOld.size(); i++) {
		                	try {
		                		FileUtility.deleteFile(arrDataPhotoOld.get(i).getFILENAME().toString(), AppConstants.FILEPATH);
		                	} catch(Exception e) { }
//							photoDataProvider.deleteATTACHMENTById(arrDataPhotoOld.get(i).getID().toString());
		                	try {
	                			photodata = new PhotoData();
	        					photodata = photoDataProvider.getATTACHMENTDetail(arrDataPhotoOld.get(i).getID().toString());
	                			photodata.setATTACH_TYPE_CODE(AppConstants.OLDF);
	                			photoDataProvider.updateATTACHMENT(photodata);
							} catch (Exception e1) {}
		                }
	                }
	                arrDataPhotoOld = null;
				}
//				
				
				
				ArrayList<PhotoData> arrDaPhotoDl = photoDataProvider.getATTACHMENTByDownloader(ap_regno);
				for (int d = 0; d < arrDaPhotoDl.size(); d++) {
					photodata = new PhotoData();
					photodata = photoDataProvider.getATTACHMENTDetail(arrDaPhotoDl.get(d).getID().toString());
					
					photodata.setID(arrDaPhotoDl.get(d).getID().toString());
		            photodata.setAP_REGNO(arrDaPhotoDl.get(d).getAP_REGNO().toString());
		            photodata.setISALREADYDOWNLOD(""); // clear download
		            photoDataProvider.updateATTACHMENT(photodata);
					FileUtility.deleteFile(arrDaPhotoDl.get(d).getFILENAME().toString(), AppConstants.FILEPATH);
				}
				
				
				String NoteJmlDataTerupload = "Submit Document Berhasil. Document yang berhasil Terupload : "+uploadSuccess.size();
				showAlertOpenSet(NoteJmlDataTerupload);
//				showAlert(R.string.msg_notification_submit_success);
				arrDataPhoto = null;
				arrDaPhotoDl = null;
				
				
			} else if(uploadBit.toString().equals(AppConstants.GAGALUPLOADFILE)) {
				ArrayList<PhotoData> NotReadyUpload = photoDataProvider.getATTACHMENTByReadyUploadToServer(ap_regno, AppConstants.NEWF); // document yang siap untuk di upload
				int CountReadyUpload = ReadyUpload.size();
				int CountFailureUpload = NotReadyUpload.size();
				int CountSuccessUpload = CountReadyUpload - CountFailureUpload;
				String NoteJmlDataTerupload = "Document yang berhasil Terupload : "+CountSuccessUpload+" dan yang gagal Terupload : "+CountFailureUpload;
				showAlertOpenSet(NoteJmlDataTerupload);
			} else if(newArrayList==null){
				showAlert(R.string.msg_notification_photo_upload_null);
			}
			else {
				showAlert(R.string.msg_notification_submit_failed);
			}
			viewListUpload();
			//GetDataInqury(ap_regno);
			
			dialogWait.dismiss();
		}
	}
	
	

	private void loadImage() {
		
		if(!upload_jaminan_document_dialog.getData_txt_file_upload().toString().equals("")) {
			filename = upload_jaminan_document_dialog.getData_txt_file_upload();
			photodata = new PhotoData();
			photodata = photoDataProvider.getATTACHMENTByFileName(filename);
			try {
				fileID = photodata.getID();
			} catch (Exception e) { fileID = ""; }
			
			kon = true;
		} else {
			fileID = "";
			filename = "";
			kon = false;
		}
		
		TextView content_file = new TextView(ctx);
		content_file.setText(filename);
		Bitmap bmp;
		try {
			bmp = getPicture(content_file.getText().toString());
		} catch (Exception e) {
			bmp = getPicture(content_file.getText().toString());
		}
		 Intent intent = new Intent(Intent.ACTION_VIEW);
         intent.setDataAndType(Uri.parse("file:///" + AppConstants.FILEPATH + content_file.getText().toString()),"image/*");
         startActivity(intent);
         
		//SetPreviewImage(content_file, bmp, content_file.getText().toString(), fileID, kon);
	}
	
	private void showIdFileUpload() {
		upload_jaminan_document_dialog.setData_txt_file_upload(filename);
	}
	
	public Bitmap getPicture(String fileName) {
        File directory = new File(AppConstants.FILEPATH);
        File fileInDirectory = new File(directory, fileName);
        Bitmap imgBitmap = BitmapFactory.decodeFile(fileInDirectory.getAbsolutePath());

        return imgBitmap;

    }
	
	public void SetPreviewImage(final TextView lblView, final Bitmap bmp, final String fileName, final String id, final boolean statusAvailableImage) {
        previewimg = new PreviewImageNew(ctx);
        previewimg.getImgPreview().setImageBitmap(bmp);
        
        
        
        int dialogHeight = previewimg.getContentHeader().getHeight();
        int dialogWidth = previewimg.getContentHeader().getWidth();
        int imgWidth = 0;
        int imgHeight = 0;
        if(!fileName.equals("")) {
        	if(bmp.getWidth() > dialogWidth) {
            	imgWidth = bmp.getWidth();
            	previewimg.getContentHeader().getLayoutParams().width = imgWidth;
            }
            if(bmp.getHeight() > dialogHeight) {
                imgHeight = bmp.getHeight();
                previewimg.getContentHeader().getLayoutParams().height = imgHeight + Math.round(imgHeight * 30/100);
            }
        }
        
        
//            if (!statusAvailableImage) {
            previewimg.getDeleteButton().setVisibility(View.GONE);
//            }

        previewimg.getDeleteButton().setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void onClick(View v) {
                try {
                    lblView.setText(R.string.str_dash);

                    	filename = "";
                        showIdFileUpload();
                        FileUtility.deleteFile(fileName, AppConstants.FILEPATH);
                        //showAlert(R.string.msg_notification_photo_delete_success_submit);
                } catch (Exception e) {

                }
                previewimg.dismiss();
                previewimg = null;
            }
        });

        previewimg.getCancelButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previewimg.dismiss();
                previewimg = null;
            }
        });

        previewimg.show();
	}
	
	private class DeletePhotoTask extends AsyncTask<String, String, String> {
        boolean responseSuccess = false;
        PhotoData photoData = null;

        @Override
        protected String doInBackground(String... photoId) {
            //Log.d(TAG, "doInbackground");
            photoData = photoDataProvider.getATTACHMENTDetail(photoId[0]);
                try {
                    ArrayList<PHOTORESPONSE> arrPhotoResponse = ServiceDataProvider.deletePhoto(photoData.getID(), photoData.getFILENAME());
                    if (arrPhotoResponse != null) {
                        if (arrPhotoResponse.size() > 0) {
                            if (arrPhotoResponse.get(0).getFILENAME().equalsIgnoreCase(photoData.getFILENAME())) {
                                responseSuccess = true;
                            }
                        }
                    }
                    arrPhotoResponse = null;
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            

       
            return photoId[0];
        }
        
        @Override
        protected void onPostExecute(String idPhoto) {
          /*  //Log.d(TAG, "Message Tasks: On post Execute");
            if (responseSuccess) {
                FileUtility.deleteFile(photoData.getFILENAME(), AppConstants.FILEPATH);
                try {
                    photoDataProvider.deletePhotoById(photoData.getID().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //showAlert(R.string.msg_notification_photo_delete_success_submit);
            } else {
                photoData.setISPENDINGDELETED(true);
                photoDataProvider.updatePhoto(photoData);
                //showAlert(R.string.msg_notification_photo_delete_error_submit);
            }*/
        }
    }
	
	public void DownloadImageFromUrlImage(String id, String prospekId, String fileName,String fileName1) throws Exception 
	{
//    	try{
	        File file = new File(AppConstants.FILEPATH + fileName1);
	        if (!file.exists()) {
	            URL url = new URL(JSONServiceHandler.URLDOWNLOADIMAGESERVER + "FileManagerService.svc/RetrieveFile/?AP_REGNO=" + prospekId + "&ID=" + id + "&filename=" + URLEncoder.encode(fileName) + "&filename1=" + URLEncoder.encode(fileName1));
	            URLConnection ucon = url.openConnection();
	            InputStream is = ucon.getInputStream();
	            BufferedInputStream bis = new BufferedInputStream(is);
	               /*
		            * Read bytes to the Buffer until there is nothing more to read(-1).
		            */
	            ByteArrayBuffer baf = new ByteArrayBuffer(50);
	            int current = 0;
	            while ((current = bis.read()) != -1) {
	                baf.append((byte) current);
	            }

	            /// save image to sdcard
	            File folder = new File(AppConstants.FILEPATH);
	            boolean success = true;
	            if (!folder.exists()) {
	                success = folder.mkdirs();
	            }
	            if (success) {
	                // Do something on success
	            } else {
	                // Do something else on failure
	            }
	            FileOutputStream fos = new FileOutputStream(AppConstants.FILEPATH + fileName1);
	            fos.write(baf.toByteArray());
	            fos.close();
	        }
//		} catch(Exception ex){ }
    }
	
	public void onBackPressed() {
        ActivityHandler.gotoActivity(ctx, Upload_DocumentActivity.class, null);
        finish();
    }
}
