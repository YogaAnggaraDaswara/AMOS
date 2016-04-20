package com.mobile.appraisal;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.ByteArrayBuffer;
import org.json.JSONArray;

import bii.mobile.amos.R;

import com.mobile.app.MainActivity;
import com.mobile.app.activity.HomeActivity;
//import com.mobile.app.activity.HomeActivity;
import com.mobile.app.configuration.AppConstants;
import com.mobile.app.ui.MasterContent;
import com.mobile.bo.app.dataprovider.Appr_Attachment;
import com.mobile.bo.app.dataprovider.Appr_Cek_TataKota;
import com.mobile.bo.app.dataprovider.Appr_Collateral;
import com.mobile.bo.app.dataprovider.Appr_DokumentDataProvider;
import com.mobile.bo.app.dataprovider.Appr_HistoryProvider;
import com.mobile.bo.app.dataprovider.Appr_History_WorkflowProvider;
import com.mobile.bo.app.dataprovider.Appr_ImbProvider;
import com.mobile.bo.app.dataprovider.Appr_Mch_ValuationDataProvider;
import com.mobile.bo.app.dataprovider.Appr_NegativeProvider;
import com.mobile.bo.app.dataprovider.Appr_PB_ValuationDataProvider;
import com.mobile.bo.app.dataprovider.Appr_Pb_SamplingBangunan_Provider;
import com.mobile.bo.app.dataprovider.Appr_Rtb_DataDataProvider;
import com.mobile.bo.app.dataprovider.Appr_Rtb_DetailProvider;
import com.mobile.bo.app.dataprovider.Appr_Rtb_Pembanding;
import com.mobile.bo.app.dataprovider.Appr_Rtb_Progress_BangunanDataProvider;
import com.mobile.bo.app.dataprovider.Appr_Rtb_Progress_DeveloperDataProvider;
import com.mobile.bo.app.dataprovider.Appr_Rtb_ValuationDataProvider;
import com.mobile.bo.app.dataprovider.Appr_SertifikatProvider;
import com.mobile.bo.app.dataprovider.Appr_Val_BangunanDataProvider;
import com.mobile.bo.app.dataprovider.Appr_Vhc_DataDataProvider;
import com.mobile.bo.app.dataprovider.Appr_Vhc_Pembanding;
import com.mobile.bo.app.dataprovider.Appr_Vhc_ValuationDataProvider;
import com.mobile.bo.app.dataprovider.FollowUpDataProvider;
import com.mobile.bo.app.dataprovider.LOVDataProvider;
import com.mobile.bo.app.dataprovider.PhotoDataProvider;
import com.mobile.bo.app.dataprovider.Appr_InboxDataProvider;
import com.mobile.bo.app.datatype.Datatype_Appr_Collateral;
import com.mobile.bo.app.datatype.Datatype_Appr_Dokument;
import com.mobile.bo.app.datatype.Datatype_Appr_History;
import com.mobile.bo.app.datatype.Datatype_Appr_History_Workflow;
import com.mobile.bo.app.datatype.Datatype_Appr_Inquery;
import com.mobile.bo.app.datatype.Datatype_Appr_Mch_Valuation_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_NegativeList;
import com.mobile.bo.app.datatype.Datatype_Appr_Pb_Valuation_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_Pb_sampling_bangunan;
import com.mobile.bo.app.datatype.Datatype_Appr_Progress_Bangunan_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_Progress_Developer_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_Rtb_Cek_Tata_Kota_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_Rtb_Data_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_Rtb_Detail_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_Rtb_Pembanding_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_Rtb_Valuation_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_Sertifikat;
import com.mobile.bo.app.datatype.Datatype_Appr_Vch_Data_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_Vhc_Pembanding_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_Vhc_Valuation_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_imb;
import com.mobile.bo.app.datatype.Datatype_Appr_valBangunan;
import com.mobile.bo.app.datatype.FollowupData;
import com.mobile.bo.app.datatype.LovData;
import com.mobile.bo.app.datatype.PhotoData;
import com.mobile.bo.app.datatype.Datatype_Appr_Inbox;
import com.mobile.bo.app.datatype.TagihanData;
import com.mobile.bo.app.datatype.UserData;
import com.mobile.database.app.common.DataConverter;
import com.mobile.framework.activity.ActivityHandler;
import com.mobile.framework.activity.ActivityNameValuePair;
import com.mobile.framework.common.DateFormatter;
import com.mobile.framework.common.FileUtility;
import com.mobile.framework.data.SessionSharedPreference;
import com.mobile.services.app.ServiceData;
import com.mobile.services.app.datatype.PROSPEKRESPONSE;
import com.mobile.services.app.datatype.RequestCount;
import com.mobile.services.app.datatype.SERVICEDATARESPONSE;
import com.mobile.services.app.services.JSONServiceHandler;
import com.mobile.services.app.services.ServiceDataProvider;
import com.mobile.appraisal.Fragment_Inbox_Layout;
import com.mobile.bo.app.datatype.Datatype_attachment;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.view.LayoutInflater;
@SuppressLint("SimpleDateFormat")
public class InqueryActivity extends Activity {
    private UserData userDetail;
    private boolean isUserDetailExist = false;
    private TextView lblHeaderUser;
    private TextView lblDateTime;
    private RelativeLayout contentContainer;
    private ImageView btnBack;
    private MasterContent prevShownView = null;
    private Context ctx;
    private Appr_InboxDataProvider appr_Inbox;
    private Appr_Attachment appr_Attachment;
    private FollowUpDataProvider followUpDataProvider = null;
    private PhotoDataProvider photoDataProvider = null;
    private ArrayList<Datatype_Appr_Inbox> listdata = null;
    private ProgressDialog dlgProgress = null;
    private String loadingMessage = "";
    private ArrayList<Datatype_Appr_Inquery> listInquery = null;
    private ArrayList<Datatype_Appr_Inbox> arrSelectedData = null;
    private ArrayList<String> arrSelectedIdx = null;
    private ArrayList<String> arrUnSelectedIdx = null;
    private Button btnNext;
    private Button btnPrev;
    private Button btnFirst;
    private Button btnLast;
    private TextView txtPageno;
    private int limit = 10;// display 5 lines of data
    private int pageNo = 0;// page
    private int pageCount = 0;// total number of pages
    private Fragment_Inbox_Layout inbox_layout;
    private String alt_type="";
    private String ap_regno_desc="";
    private String alt_desc="";
    private String branchname="";
    private String cu_name="";
    private String cu_type="";
    private String col_kelurahan="";
    private String col_kecamatan="";
    private String col_dok_no="";
    private String alt_trdesc="";
    private String su_fullname="";
    private Fragment_Inquery_Dialog fragment_Inquery_Dialog=null; 
    private LOVDataProvider lovDataProvider;
   	private Appr_Cek_TataKota appr_Cek_TataKotaDataProvider;
   	private Appr_Vhc_DataDataProvider appr_Vhc_DataDataProvider;
   	private Appr_Rtb_DataDataProvider appr_Rtb_DataDataProvider;
   	private Appr_Rtb_DetailProvider appr_Rtb_DetailProvider;
   	private Appr_Vhc_ValuationDataProvider appr_Vhc_ValuationDataProvider;
   	private Appr_Rtb_ValuationDataProvider appr_Rtb_ValuationDataProvider;
   	private Appr_PB_ValuationDataProvider appr_PB_ValuationDataProvider;
   	private Appr_Mch_ValuationDataProvider appr_Mch_ValuationDataProvider;
   	private Appr_Rtb_Progress_BangunanDataProvider appr_Rtb_Progress_BangunanDataProvider;
   	private Appr_Rtb_Progress_DeveloperDataProvider appr_Rtb_Progress_DeveloperDataProvider;
   	private Appr_Pb_SamplingBangunan_Provider appr_Pb_SamplingBangunan_Provider;
   	private Appr_InboxDataProvider appr_InboxDataProvider;
   	private Appr_DokumentDataProvider appr_DokumentDataProvider;
   	private Appr_Rtb_Pembanding appr_Rtb_Pembanding;
   	private Appr_Vhc_Pembanding appr_Vhc_Pembanding;
   	private Appr_HistoryProvider appr_HistoryProvider;
   	private Appr_History_WorkflowProvider appr_History_WorkflowProvider;
   	private Appr_Collateral appr_CollateralProvider;
   	private Appr_SertifikatProvider appr_SertifikatProvider;
   	private Appr_ImbProvider appr_ImbProvider;
   	private Appr_NegativeProvider appr_NegativeProvider;
   	private Appr_Val_BangunanDataProvider appr_Val_BangunanDataProvider;
   	private ArrayList<Datatype_Appr_Inbox> listinbox = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        ctx = this;
        appr_Inbox = new Appr_InboxDataProvider();
        inbox_layout=new Fragment_Inbox_Layout(this);
        setTitle("List Inquery Appraisal");
        getActionBar().setIcon(R.drawable.grid);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        fragment_Inquery_Dialog=new Fragment_Inquery_Dialog(ctx);
        lovDataProvider = new LOVDataProvider();
    	appr_Cek_TataKotaDataProvider=new Appr_Cek_TataKota();
    	appr_Vhc_DataDataProvider=new Appr_Vhc_DataDataProvider();
    	appr_Rtb_DataDataProvider=new Appr_Rtb_DataDataProvider();
    	appr_Rtb_DetailProvider=new Appr_Rtb_DetailProvider();
    	appr_Vhc_ValuationDataProvider =new Appr_Vhc_ValuationDataProvider();
    	appr_Rtb_ValuationDataProvider=new Appr_Rtb_ValuationDataProvider();
    	appr_PB_ValuationDataProvider=new Appr_PB_ValuationDataProvider();
    	appr_Rtb_Progress_DeveloperDataProvider=new Appr_Rtb_Progress_DeveloperDataProvider();
    	appr_Rtb_Progress_BangunanDataProvider=new Appr_Rtb_Progress_BangunanDataProvider();
    	appr_Mch_ValuationDataProvider=new Appr_Mch_ValuationDataProvider();
    	appr_InboxDataProvider=new Appr_InboxDataProvider();  
    	appr_DokumentDataProvider=new Appr_DokumentDataProvider();
    	appr_Rtb_Pembanding=new Appr_Rtb_Pembanding();
    	appr_Vhc_Pembanding=new Appr_Vhc_Pembanding();
    	appr_HistoryProvider=new Appr_HistoryProvider();
    	appr_History_WorkflowProvider =new Appr_History_WorkflowProvider();
    	appr_CollateralProvider=new Appr_Collateral();
    	appr_SertifikatProvider=new Appr_SertifikatProvider();
    	appr_ImbProvider=new Appr_ImbProvider();
    	appr_NegativeProvider=new Appr_NegativeProvider();
    	appr_Val_BangunanDataProvider=new Appr_Val_BangunanDataProvider();
    	appr_Pb_SamplingBangunan_Provider=new Appr_Pb_SamplingBangunan_Provider();
    	photoDataProvider=new PhotoDataProvider();
    	appr_Attachment=new Appr_Attachment();
        initActivity();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	getMenuInflater().inflate(R.menu.menu_back, menu);
		return true;
    }
    /* Called whenever we call invalidateOptionsMenu() */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        //boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        //menu.findItem(R.id.action_websearch).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }
	  @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        
        switch (item.getItemId()) {
		
		case R.id.find:
			fragment_Inquery_Dialog.setData_kendaraan_txt_no_aplikasi("");
			fragment_Inquery_Dialog.setData_kendaraan_txt_jaminan("");
			fragment_Inquery_Dialog.setData_kendaraan_txt_branch("");
			fragment_Inquery_Dialog.setData_kendaraan_txt_nm_pemohon("");
			fragment_Inquery_Dialog.setData_kendaraan_txt_tipe_customer("");
			fragment_Inquery_Dialog.setData_kendaraan_txt_kelurahan("");
			fragment_Inquery_Dialog.setData_kendaraan_txt_kecamatan("");
			fragment_Inquery_Dialog.setData_kendaraan_txt_no_sertifikat("");
			fragment_Inquery_Dialog.setData_kendaraan_txt_tahapan("");
			fragment_Inquery_Dialog.show();
		      
			return true;
		case R.id.back:
			BackActivity();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
        
    }
	
	 public void BackActivity() {
    	Intent i = new Intent(InqueryActivity.this, HomeActivity.class);   
    	startActivity(i);
	}
	
    
    
    @Override
    protected void onDestroy() {
    	appr_Inbox.release();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        /*ActivityHandler.gotoActivity(ctx, HomeActivity.class, null);
        finish();*/
    }

    @SuppressLint("SimpleDateFormat")
    public void initActivity() {
        setContentView(R.layout.fragment_inquery_layout);
        try {
           /* userDetail = (UserData) SessionSharedPreference.getDataFromSharedPreference(ctx, UserData.class, AppConstants.USER_SESSION);
            isUserDetailExist = true;*/
           
            
        } catch (Exception e) {
            finish();
            return;
        }
        fragment_Inquery_Dialog.getBtn_savedokumen().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	 alt_type="";
                 ap_regno_desc=fragment_Inquery_Dialog.getData_kendaraan_txt_no_aplikasi().getText().toString();
                 alt_desc=fragment_Inquery_Dialog.getData_kendaraan_txt_jaminan().getText().toString();
                 branchname=fragment_Inquery_Dialog.getData_kendaraan_txt_branch().getText().toString();
                 cu_name=fragment_Inquery_Dialog.getData_kendaraan_txt_nm_pemohon().getText().toString();
                 cu_type=fragment_Inquery_Dialog.getData_kendaraan_txt_tipe_customer().getText().toString();
                 col_kelurahan=fragment_Inquery_Dialog.getData_kendaraan_txt_kelurahan().getText().toString();
                 col_kecamatan=fragment_Inquery_Dialog.getData_kendaraan_txt_kecamatan().getText().toString();
                 col_dok_no=fragment_Inquery_Dialog.getData_kendaraan_txt_no_sertifikat().getText().toString();
                 alt_trdesc=fragment_Inquery_Dialog.getData_kendaraan_txt_tahapan().getText().toString();
                 su_fullname="";
                 fragment_Inquery_Dialog.dismiss();
                 pageCount = GetDataCountInquery(alt_type,ap_regno_desc,alt_desc,branchname,cu_name,cu_type,col_kelurahan,col_kecamatan,col_dok_no,alt_trdesc,su_fullname);
                 if(pageCount>0){
                	 pageNo = 1;
                	 GetDataInqury(1,ap_regno_desc,alt_desc,branchname,cu_name,cu_type,col_kelurahan,col_kecamatan,col_dok_no,alt_trdesc,su_fullname);
                	 viewData();
                 }
                
            }
        });
        alt_type="";
        ap_regno_desc="a";
        alt_desc="";
        branchname="";
        cu_name="";
        cu_type="";
        col_kelurahan="";
        col_kecamatan="";
        col_dok_no="";
        alt_trdesc="";
        su_fullname="";
        lblHeaderUser = (TextView) findViewById(R.id.inbox_lbl_user_information);
        lblDateTime = (TextView) findViewById(R.id.inbox_lbl_currentdate);
        contentContainer = (RelativeLayout) findViewById(R.id.content_layout);
        btnBack = (ImageView) findViewById(R.id.inbox_btn_back);

        if (isUserDetailExist) {
            lblHeaderUser.setText(
                    String.format("%s # %s", userDetail.getNAME(), userDetail.getLOCATION()));
            lblDateTime.setText(String.format("%s", DateFormatter.format(new Date())));
        }
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityHandler.gotoActivity(ctx, HomeActivity.class, null);
                finish();
            }
        });
        
        btnBack = (ImageView) findViewById(R.id.tagihan_btn_back);
        btnNext = (Button) findViewById(R.id.btn_next);
        btnPrev = (Button) findViewById(R.id.btn_prev);
        btnFirst = (Button) findViewById(R.id.btn_first);
        btnLast = (Button) findViewById(R.id.btn_last);
        txtPageno = (TextView) findViewById(R.id.txtPageno);
        //pageCount = GetDataCountInquery(alt_type,ap_regno_desc,alt_desc,branchname,cu_name,cu_type,col_kelurahan,col_kecamatan,col_dok_no,alt_trdesc,su_fullname);
        //if (pageCount >= 1)
        //    pageNo = 1;
        btnNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    // TODO Auto-generated method stub
                    showProgressIndicator();
                    if (pageCount > pageNo) {
                        pageNo++;
                        GetDataInqury(pageNo,ap_regno_desc,alt_desc,branchname,cu_name,cu_type,col_kelurahan,col_kecamatan,col_dok_no,alt_trdesc,su_fullname);
                        viewData();
                        setpageNo(pageNo);
                    }
                    hideProgressIndicator();
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
                    showProgressIndicator();
                    if (pageNo > 1) {
                        pageNo--;
                        GetDataInqury(pageNo,ap_regno_desc,alt_desc,branchname,cu_name,cu_type,col_kelurahan,col_kecamatan,col_dok_no,alt_trdesc,su_fullname);
                        viewData();
                        setpageNo(pageNo);
                    }
                    hideProgressIndicator();
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
                    showProgressIndicator();
                    if (pageCount > 1 && pageNo != 1) {
                    	GetDataInqury(1,ap_regno_desc,alt_desc,branchname,cu_name,cu_type,col_kelurahan,col_kecamatan,col_dok_no,alt_trdesc,su_fullname);
                        pageNo = 1;
                        viewData();
                        setpageNo(1);
                    }
                    hideProgressIndicator();
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

                    showProgressIndicator();
                    // TODO Auto-generated method stub
                    if (pageCount > 1 && pageNo != pageCount) {
                    	GetDataInqury(pageCount,ap_regno_desc,alt_desc,branchname,cu_name,cu_type,col_kelurahan,col_kecamatan,col_dok_no,alt_trdesc,su_fullname);
                        pageNo = pageCount;
                        viewData();
                        setpageNo(pageCount);
                    }
                    hideProgressIndicator();
                    //if(pageCount==pageNo_
                    //disable pageno
                } catch (Exception ex) {
                    //showAlert(ex.getMessage().toString());
                }
            }
        });
        //GetDataInqury(1,ap_regno_desc,alt_desc,branchname,cu_name,cu_type,col_kelurahan,col_kecamatan,col_dok_no,alt_trdesc,su_fullname);
        //viewData();
        //new loadProspekData().execute(); 
       //populateStatistikDataProspek();
    }
    private int GetDataCountInquery(String alt_type,String ap_regno_desc,String alt_desc,String branchname,String cu_name,String cu_type,String col_kelurahan,String col_kecamatan,String col_dok_no,String alt_trdesc,String su_fullname){
    	
    	
    	int intCount = 0;
    	try {
            ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("ALT_TYPE",alt_type));
            params.add(new BasicNameValuePair("AP_REGNO_DESC",ap_regno_desc));
            params.add(new BasicNameValuePair("ALT_DESC",alt_desc));
            params.add(new BasicNameValuePair("BRANCHNAME",branchname));
            params.add(new BasicNameValuePair("CU_NAME",cu_name));
            params.add(new BasicNameValuePair("CU_TYPE",cu_type));
            params.add(new BasicNameValuePair("COL_KELURAHAN",col_kelurahan));
            params.add(new BasicNameValuePair("COL_KECAMATAN",col_kecamatan));
            params.add(new BasicNameValuePair("COL_DOK_NO",col_dok_no));
            params.add(new BasicNameValuePair("ALT_TRDESC",alt_trdesc));
            params.add(new BasicNameValuePair("SU_FULLNAME",su_fullname));
            SERVICEDATARESPONSE masterCountResponse = ServiceDataProvider.GetdataInqueryCount(params);
            if (masterCountResponse != null) {
                ArrayList<RequestCount> arrTabunganCountData = ServiceData.GetdataInqueryCount(new JSONArray(masterCountResponse.getResults()));
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
    private void GetDataInqury(int sPages,String ap_regno_desc,String alt_desc,String branchname,String cu_name,String cu_type,String col_kelurahan,String col_kecamatan,String col_dok_no,String alt_trdesc,String su_fullname){
    	if (listInquery != null) {
    		listInquery.clear();
        }
        setpageNo(sPages);
            	ArrayList<NameValuePair> params1 = new ArrayList<NameValuePair>();
                params1.add(new BasicNameValuePair("PAGES", "" + sPages ));
                params1.add(new BasicNameValuePair("ALT_TYPE",alt_type));
                params1.add(new BasicNameValuePair("AP_REGNO_DESC",ap_regno_desc));
                params1.add(new BasicNameValuePair("ALT_DESC",alt_desc));
                params1.add(new BasicNameValuePair("BRANCHNAME",branchname));
                params1.add(new BasicNameValuePair("CU_NAME",cu_name));
                params1.add(new BasicNameValuePair("CU_TYPE",cu_type));
                params1.add(new BasicNameValuePair("COL_KELURAHAN",col_kelurahan));
                params1.add(new BasicNameValuePair("COL_KECAMATAN",col_kecamatan));
                params1.add(new BasicNameValuePair("COL_DOK_NO",col_dok_no));
                params1.add(new BasicNameValuePair("ALT_TRDESC",alt_trdesc));
                params1.add(new BasicNameValuePair("SU_FULLNAME",su_fullname));
                
                SERVICEDATARESPONSE lovResponse;
				try {
					lovResponse = ServiceDataProvider.GetdataInquery(params1);
				
                  
                  if (lovResponse != null) {
                	  listInquery = ServiceData.GetdataInquery(new JSONArray(lovResponse.getResults()));
                      if (lovResponse.getStatus() == 1) {
                         
                      }
                      //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                  }
                  lovResponse = null;
    
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    }
    private void setpageNo(int pageNo) {
        String text = null;
        text = pageNo + "/" + pageCount;
        txtPageno.setText(text);
    }
 
    private class loadProspekData extends AsyncTask<Uri, Void, Void> {

		/**
		 * This is executed in the UI thread. The only place where we can show the dialog.
		 */
		@Override
		protected void onPreExecute() {
			showProgressIndicator();
		}
		
		/**
		 * This is executed in the background thread. 
		 */
		@Override
		protected Void doInBackground(Uri... params) {
			 listdata = appr_Inbox.getAllAppr_Inbox();
			
			return null;
		}

		/**
		 * This is executed in the UI thread. The only place where we can show the dialog.
		 */
	   @Override 
       protected void onPostExecute(Void unused) { 
    	  new Thread(new Runnable() {
  	            public void run() {
  	                runOnUiThread(new Runnable() {
  	                            public void run() {
  	                            	viewData();
  	                                hideProgressIndicator();
  	                            }
  	                  });
  	            }
  	        }).start();
    	 
       } 
	}

    private void viewData() {
    	inbox_layout=new Fragment_Inbox_Layout(this);
    	
    	  /* if (contentContainer != null) {
               contentContainer.removeView(inbox_layout);
           }*/

    	TableRow rowHeaderTable = new TableRow(this);
        rowHeaderTable.setBackgroundColor(getResources().getColor(R.color.color_header_grid));
        rowHeaderTable.setPadding(0, 0, 0, 2);

        TableRow.LayoutParams rowParamsDetail = new TableRow.LayoutParams();
        rowParamsDetail.gravity = Gravity.LEFT;

        TextView header9 = new TextView(ctx);
        header9.setGravity(Gravity.LEFT);
        header9.setTextColor(getResources().getColor(android.R.color.black));
        header9.setPadding(0, 2, 0,2);
        header9.setTextSize(12);
        header9.setWidth(340);
        header9.setText("Action");
        rowHeaderTable.addView(header9, rowParamsDetail);
        
        TextView header1 = new TextView(ctx);
        header1.setGravity(Gravity.LEFT);
        header1.setTextColor(getResources().getColor(android.R.color.black));
        header1.setPadding(0, 3, 0, 3);
        header1.setTextSize(12);
        header1.setWidth(170);
        header1.setText("No. Aplikasi");
        rowHeaderTable.addView(header1, rowParamsDetail);

        TextView header2 = new TextView(ctx);
        header2.setGravity(Gravity.LEFT);
        header2.setTextColor(getResources().getColor(android.R.color.black));
        header2.setPadding(0, 3, 0, 3);
        header2.setTextSize(12);
        header2.setWidth(170);
        header2.setText("Jaminan");
        rowHeaderTable.addView(header2, rowParamsDetail);

        TextView header3 = new TextView(ctx);
        header3.setGravity(Gravity.LEFT);
        header3.setTextColor(getResources().getColor(android.R.color.black));
        header3.setPadding(0, 3, 0, 3);
        header3.setTextSize(12);
        header3.setWidth(200);
        header3.setText("Branch");
        rowHeaderTable.addView(header3, rowParamsDetail);

        TextView header4 = new TextView(ctx);
        header4.setGravity(Gravity.LEFT);
        header4.setTextColor(getResources().getColor(android.R.color.black));
        header4.setPadding(0, 3, 0, 3);
        header4.setTextSize(12);
        header4.setWidth(120);
        header4.setText("Nama Pemohon");
        rowHeaderTable.addView(header4, rowParamsDetail);

        TextView header5 = new TextView(ctx);
        header5.setGravity(Gravity.LEFT);
        header5.setTextColor(getResources().getColor(android.R.color.black));
        header5.setPadding(0, 3, 0, 3);
        header5.setTextSize(12);
        header5.setWidth(100);
        header5.setText("Kelurahan");
        rowHeaderTable.addView(header5, rowParamsDetail);

        TextView header6 = new TextView(ctx);
        header6.setGravity(Gravity.LEFT);
        header6.setTextColor(getResources().getColor(android.R.color.black));
        header6.setPadding(0, 3, 0, 3);
        header6.setTextSize(12);
        header6.setWidth(100);
        header6.setText("Kecamatan");
        rowHeaderTable.addView(header6, rowParamsDetail);
        
        
        TextView header7 = new TextView(ctx);
        header7.setGravity(Gravity.LEFT);
        header7.setTextColor(getResources().getColor(android.R.color.black));
        header7.setPadding(0, 3, 0, 3);
        header7.setTextSize(12);
        header7.setWidth(100);
        header7.setText("No. Sertifikat");
        rowHeaderTable.addView(header7, rowParamsDetail);
        
        
        TextView header8 = new TextView(ctx);
        header8.setGravity(Gravity.LEFT);
        header8.setTextColor(getResources().getColor(android.R.color.black));
        header8.setPadding(0, 3, 0, 3);
        header8.setTextSize(12);
        header8.setWidth(150);
        header8.setText("Tahapan");
        rowHeaderTable.addView(header8, rowParamsDetail);
        
        TextView header10 = new TextView(ctx);
        header10.setGravity(Gravity.LEFT);
        header10.setTextColor(getResources().getColor(android.R.color.black));
        header10.setPadding(0, 3, 0, 3);
        header10.setTextSize(12);
        header10.setWidth(150);
        header10.setText("Oleh");
        rowHeaderTable.addView(header10, rowParamsDetail);
        
        TextView header11 = new TextView(ctx);
        header11.setGravity(Gravity.LEFT);
        header11.setTextColor(getResources().getColor(android.R.color.black));
        header11.setPadding(0, 3, 0, 3);
        header11.setTextSize(12);
        header11.setWidth(150);
        header11.setText("Aging");
        rowHeaderTable.addView(header11, rowParamsDetail);
        
        inbox_layout.getTableLayout().addView(rowHeaderTable);
        if(listInquery!=null){
        for (int i = 0; i < listInquery.size(); i++) {
        	
        	//final Datatype_Appr_Inbox contentdata = listdata.get(i);
        	final Datatype_Appr_Inquery contentdata = listInquery.get(i);
            final TableRow rowContentTable = new TableRow(this);
            if ((i + 1) % 2 == 0) {
                rowContentTable.setBackgroundColor(getResources().getColor(R.color.color_bacground1));
            } else {
                rowContentTable.setBackgroundColor(Color.WHITE);
            }
          
            TextView content_col_id = new TextView(ctx);
            content_col_id.setText(contentdata.getALT_ID());
            content_col_id.setVisibility(View.GONE);
            rowContentTable.addView(content_col_id);
            
            TextView content_col_type = new TextView(ctx);
            content_col_type.setText(contentdata.getCOL_TYPE());
            content_col_type.setVisibility(View.GONE);
            rowContentTable.addView(content_col_type);
            
            TextView content_appraise_type = new TextView(ctx);
            content_appraise_type.setText(contentdata.getAPPRAISE_TYPE());
            content_appraise_type.setVisibility(View.GONE);
            rowContentTable.addView(content_appraise_type);
            
           
            Button content_detail2 = new Button(ctx);
            content_detail2.setGravity(Gravity.CENTER);
            content_detail2.setText(R.string.form_action_detail1);
            rowContentTable.addView(content_detail2, 5, 50);
            
            content_detail2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                	TextView content_detail = (TextView) rowContentTable.getChildAt(4);
                 	TextView content_col_type = (TextView) rowContentTable.getChildAt(1);
                 	TextView content_appraise_type = (TextView) rowContentTable.getChildAt(2);
                 	TextView content_col_id = (TextView) rowContentTable.getChildAt(0);
                 	TextView content_pending = (TextView) rowContentTable.getChildAt(13);
                 	getDataFromServer(content_detail.getText().toString(), content_col_id.getText().toString());
                 	Intent i = new Intent(InqueryActivity.this, MainActivity.class);   
                 	String keyIdentifer  = null;
                 	i.putExtra("AP_REGNO", content_detail.getText().toString());
                 	i.putExtra("COL_ID", content_col_id.getText().toString());
                 	i.putExtra("COL_TYPE", content_col_type.getText().toString());
                 	i.putExtra("APPRAISE_TYPE", content_appraise_type.getText().toString());
                 	i.putExtra("STATUS", "INQUERY");
                 	
                 	
                 	 startActivity(i);
                }
			});
            
            TextView content_ap_regno = new TextView(ctx);
            content_ap_regno.setGravity(Gravity.LEFT);
            content_ap_regno.setTextColor(getResources().getColor(android.R.color.black));
            content_ap_regno.setPadding(0, 3, 0, 3);
            content_ap_regno.setTextSize(12);
            content_ap_regno.setWidth(170);
            content_ap_regno.setText(contentdata.getAP_REGNO());
            rowContentTable.addView(content_ap_regno, rowParamsDetail);
           

            TextView content_jaminan = new TextView(ctx);
            content_jaminan.setGravity(Gravity.LEFT);
            content_jaminan.setTextColor(getResources().getColor(android.R.color.black));
            content_jaminan.setPadding(0, 3, 0, 3);
            content_jaminan.setTextSize(12);
            content_jaminan.setWidth(170);
            content_jaminan.setText(contentdata.getALT_DESC());
            rowContentTable.addView(content_jaminan, rowParamsDetail);

            TextView content_nama = new TextView(ctx);
            content_nama.setGravity(Gravity.LEFT);
            content_nama.setTextColor(getResources().getColor(android.R.color.black));
            content_nama.setPadding(0, 3, 0, 3);
            content_nama.setTextSize(12);
            content_nama.setWidth(200);
            content_nama.setText(contentdata.getCU_NAME());
            rowContentTable.addView(content_nama, rowParamsDetail);

                        
            ///////////
            TextView content_npwp = new TextView(ctx);
            content_npwp.setGravity(Gravity.LEFT);
            content_npwp.setTextColor(getResources().getColor(android.R.color.black));
            content_npwp.setPadding(0, 3, 0, 3);
            content_npwp.setTextSize(12);
            content_npwp.setWidth(100);
            content_npwp.setText(contentdata.getCU_NPWP());
            rowContentTable.addView(content_npwp,rowParamsDetail);

            TextView content_tglterima = new TextView(ctx);
            content_tglterima.setGravity(Gravity.LEFT);
            content_tglterima.setTextColor(getResources().getColor(android.R.color.black));
            content_tglterima.setPadding(0, 3, 0, 3);
            content_tglterima.setTextSize(12);
            content_tglterima.setWidth(100);
            content_tglterima.setText(DataConverter.dateTimeToString(contentdata.getAP_RECVDATE()));
            rowContentTable.addView(content_tglterima,rowParamsDetail);

            TextView content_status = new TextView(ctx);
            content_status.setGravity(Gravity.LEFT);
            content_status.setTextColor(getResources().getColor(android.R.color.black));
            content_status.setPadding(0, 3, 0, 3);
            content_status.setTextSize(12);
            content_status.setWidth(100);
            content_status.setText(contentdata.getPENDINGSTATUS());
            rowContentTable.addView(content_status,rowParamsDetail);

            TextView content_aging = new TextView(ctx);
            content_aging.setGravity(Gravity.LEFT);
            content_aging.setTextColor(getResources().getColor(android.R.color.black));
            content_aging.setPadding(0, 3, 0, 3);
            content_aging.setTextSize(12);
            content_aging.setWidth(200);
            content_aging.setText(contentdata.getAGING());
            rowContentTable.addView(content_aging,rowParamsDetail);

            inbox_layout.getTableLayout().addView(rowContentTable);
        }

        }
        contentContainer.addView(inbox_layout);
        prevShownView = inbox_layout;
       
        /*blackbox.getBtnRequest().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrSelectedProspek = new ArrayList<ProspekData>();
                arrSelectedIdx = new ArrayList<String>();
                arrUnSelectedIdx = new ArrayList<String>();
                for (int i = 1; i < blackbox.getTableLayout().getChildCount(); i++) {
                    TableRow row = (TableRow) blackbox.getTableLayout().getChildAt(i);
                    CheckBox checkbox = (CheckBox) row.getChildAt(0);
                    TextView lblHiddenID = (TextView) row.getChildAt(1);
                    String prospekId = lblHiddenID.getText().toString();

                    if (checkbox.isChecked()) {
                        arrSelectedIdx.add(prospekId);
                        ProspekData prospekdata = prospekDataProvider.getProspekDetail(prospekId);
                        arrSelectedProspek.add(prospekdata);
                    } else {
                        arrUnSelectedIdx.add(prospekId);
                    }
                }

                if (arrSelectedProspek.size() > 0) {
                    new SendResponseDataBlackbox().execute();
                } else {
                    showAlert(R.string.msg_notification_unselect_row, false);
                }

            }
        });*/
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
                    finish();
                }
            }
        });
        alertDialog.show();
    }

    private void getDataFromServer(String ap_regno,String col_id){
  	   boolean synchronizeLov = true;
         
         if (synchronizeLov) {/*
      	      
          	
             
                 		
              		/////////////
              		try {
  	                       ///Negative
  	                       ArrayList<NameValuePair> params18 = new ArrayList<NameValuePair>();
  	                       params18.add(new BasicNameValuePair("AP_REGNO", ap_regno));
  	                        SERVICEDATARESPONSE PhotoDataResponse = ServiceDataProvider.GetAttachment(params18);
  	                    
  	                       if (PhotoDataResponse != null) {
  	                           ArrayList<PhotoData> arrLOVServiceData = ServiceData.GetAttachment(new JSONArray(PhotoDataResponse.getResults()));
  	                           if (PhotoDataResponse.getStatus() == 1) {
  	                               for (int i = 0; i < arrLOVServiceData.size(); i++) {
  	                            	   photoDataProvider.updateATTACHMENT(arrLOVServiceData.get(i));
  	                            	   //DownloadImageFromUrl(arrLOVServiceData.get(i).getID().toString(), arrLOVServiceData.get(i).getAP_REGNO().toString(), arrLOVServiceData.get(i).getFILENAME().toString());
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
              		
              		try {
  	                       ///history workflow
  	                       ArrayList<NameValuePair> params17 = new ArrayList<NameValuePair>();
  	                       params17.add(new BasicNameValuePair("AP_REGNO", ap_regno));
  	                        SERVICEDATARESPONSE historyworkflowResponse = ServiceDataProvider.GetHistoryWorkFlow(params17);
  	                    
  	                       if (historyworkflowResponse != null) {
  	                           ArrayList<Datatype_Appr_History_Workflow> arrLOVServiceData = ServiceData.GetHistoryWorkFlow(new JSONArray(historyworkflowResponse.getResults()));
  	                           if (historyworkflowResponse.getStatus() == 1) {
  	                               for (int i = 0; i < arrLOVServiceData.size(); i++) {
  	                            	   appr_History_WorkflowProvider.updateData(arrLOVServiceData.get(i));
  	                               }
  	                               arrLOVServiceData = null;
  	                           }
  	                           //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
  	                       }
  	                       
  	                       historyworkflowResponse = null;
                      } 
                      catch (Exception e) {
  						// TODO Auto-generated catch block
  						e.printStackTrace();
                      }

                      try {
  	                       ///Negative
  	                       ArrayList<NameValuePair> params18 = new ArrayList<NameValuePair>();
  	                       params18.add(new BasicNameValuePair("COL_ID", col_id));
  	                        SERVICEDATARESPONSE NegativeListResponse = ServiceDataProvider.GetNegativeList(params18);
  	                    
  	                       if (NegativeListResponse != null) {
  	                           ArrayList<Datatype_Appr_NegativeList> arrLOVServiceData = ServiceData.GetNegativeList(new JSONArray(NegativeListResponse.getResults()));
  	                           if (NegativeListResponse.getStatus() == 1) {
  	                               for (int i = 0; i < arrLOVServiceData.size(); i++) {
  	                            	   appr_NegativeProvider.updateData(arrLOVServiceData.get(i));
  	                               }
  	                               arrLOVServiceData = null;
  	                           }
  	                           //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
  	                       }
  	                       
  	                       NegativeListResponse = null;
                      } 
                      catch (Exception e) {
  						// TODO Auto-generated catch block
  						e.printStackTrace();
                      }
                      try {
  	                       ///imb
  	                       ArrayList<NameValuePair> params18 = new ArrayList<NameValuePair>();
  	                       params18.add(new BasicNameValuePair("COL_ID", col_id));
  	                        SERVICEDATARESPONSE imbResponse = ServiceDataProvider.GetIMB(params18);
  	                    
  	                       if (imbResponse != null) {
  	                           ArrayList<Datatype_Appr_imb> arrLOVServiceData = ServiceData.GetIMB(new JSONArray(imbResponse.getResults()));
  	                           if (imbResponse.getStatus() == 1) {
  	                               for (int i = 0; i < arrLOVServiceData.size(); i++) {
  	                            	   appr_ImbProvider.updateData(arrLOVServiceData.get(i));
  	                               }
  	                               arrLOVServiceData = null;
  	                           }
  	                           //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
  	                       }
  	                       
  	                       imbResponse = null;
                      } 
                      catch (Exception e) {
  						// TODO Auto-generated catch block
  						e.printStackTrace();
                      }
                      
                      try {
  	                       ///sertifikat
  	                       ArrayList<NameValuePair> params18 = new ArrayList<NameValuePair>();
  	                       params18.add(new BasicNameValuePair("COL_ID", col_id));
  	                        SERVICEDATARESPONSE sertifikatResponse = ServiceDataProvider.Getsertifikat(params18);
  	                    
  	                       if (sertifikatResponse != null) {
  	                           ArrayList<Datatype_Appr_Sertifikat> arrLOVServiceData = ServiceData.Getsertifikat(new JSONArray(sertifikatResponse.getResults()));
  	                           if (sertifikatResponse.getStatus() == 1) {
  	                               for (int i = 0; i < arrLOVServiceData.size(); i++) {
  	                            	   appr_SertifikatProvider.updateData(arrLOVServiceData.get(i));
  	                               }
  	                               arrLOVServiceData = null;
  	                           }
  	                           //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
  	                       }
  	                       
  	                       sertifikatResponse = null;
                      } 
                      catch (Exception e) {
  						// TODO Auto-generated catch block
  						e.printStackTrace();
                      }
                      try {
  	                       ///valuation bangunan
  	                       ArrayList<NameValuePair> params19 = new ArrayList<NameValuePair>();
  	                       params19.add(new BasicNameValuePair("COL_ID", col_id));
  	                        SERVICEDATARESPONSE valBangunanResponse = ServiceDataProvider.GetvaluationBangunan(params19);
  	                    
  	                       if (valBangunanResponse != null) {
  	                           ArrayList<Datatype_Appr_valBangunan> arrLOVServiceData = ServiceData.GetvaluationBangunan(new JSONArray(valBangunanResponse.getResults()));
  	                           if (valBangunanResponse.getStatus() == 1) {
  	                               for (int i = 0; i < arrLOVServiceData.size(); i++) {
  	                            	   appr_Val_BangunanDataProvider.updateData(arrLOVServiceData.get(i));
  	                               }
  	                               arrLOVServiceData = null;
  	                           }
  	                           //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
  	                       }
  	                       
  	                       valBangunanResponse = null;
                      } 
                      catch (Exception e) {
  						// TODO Auto-generated catch block
  						e.printStackTrace();
                      }
                     try {
  						
  						
                		//collateral
                		ArrayList<NameValuePair> params1 = new ArrayList<NameValuePair>();
                         params1.add(new BasicNameValuePair("COL_ID", col_id  ));
                         SERVICEDATARESPONSE colResponse = ServiceDataProvider.getAppr_collateral(params1);
                        
                        if (colResponse != null) {
                            ArrayList<Datatype_Appr_Collateral> arrLOVServiceData = ServiceData.getAppr_collateral(new JSONArray(colResponse.getResults()));
                            if (colResponse.getStatus() == 1) {
                                for (int i = 0; i < arrLOVServiceData.size(); i++) {
                                    
                                	
                                	appr_CollateralProvider.updateData(arrLOVServiceData.get(i));
                                }
                                arrLOVServiceData = null;
                            }
                            //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                        }
                        colResponse = null;
                		
                		} catch (Exception e) {
  							// TODO Auto-generated catch block
  							e.printStackTrace();
  						}
              		
              		
              		
              		
              		
              		
              		
              		/////////
              		
              		
              		
              		
              		
                      try {
  						
  					
        	    	ArrayList<NameValuePair> params2 = new ArrayList<NameValuePair>();
                       params2.add(new BasicNameValuePair("COL_ID", col_id  ));
                       params2.add(new BasicNameValuePair("APPRSTYPE", "INT"  ));
                       SERVICEDATARESPONSE cektatakotaResponse = ServiceDataProvider.getTataKota(params2);
                   
                      if (cektatakotaResponse != null) {
                          ArrayList<Datatype_Appr_Rtb_Cek_Tata_Kota_Int> arrLOVServiceData = ServiceData.getTataKota(new JSONArray(cektatakotaResponse.getResults()));
                          if (cektatakotaResponse.getStatus() == 1) {
                              for (int i = 0; i < arrLOVServiceData.size(); i++) {
                                  appr_Cek_TataKotaDataProvider.updateData(arrLOVServiceData.get(i));
                              }
                              arrLOVServiceData = null;
                          }
                          //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                      }
                      cektatakotaResponse = null;
                  	} catch (Exception e) {
  						// TODO Auto-generated catch block
  						e.printStackTrace();
  					}
                   try {
  							
                  	 ArrayList<NameValuePair> params3 = new ArrayList<NameValuePair>();
                       params3.add(new BasicNameValuePair("COL_ID", col_id  ));
                       params3.add(new BasicNameValuePair("APPRSTYPE", "INT"  ));
                       SERVICEDATARESPONSE vhcDataResponse = ServiceDataProvider.getVhcData(params3);
                   
                      if (vhcDataResponse != null) {
                          ArrayList<Datatype_Appr_Vch_Data_Int> arrLOVServiceData = ServiceData.getVhcData(new JSONArray(vhcDataResponse.getResults()));
                          if (vhcDataResponse.getStatus() == 1) {
                              for (int i = 0; i < arrLOVServiceData.size(); i++) {
                                  appr_Vhc_DataDataProvider.updateData(arrLOVServiceData.get(i));
                              }
                              arrLOVServiceData = null;
                          }
                          //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                      }
                      vhcDataResponse = null;
                      	
                      	
                   } catch (Exception e) {
  							// TODO Auto-generated catch block
  							e.printStackTrace();
  				
                   }
                   try {
  						
  					
                  	 ArrayList<NameValuePair> params4 = new ArrayList<NameValuePair>();
                  params4.add(new BasicNameValuePair("COL_ID", col_id  ));
                  params4.add(new BasicNameValuePair("APPRSTYPE", "INT"  ));
                  SERVICEDATARESPONSE RtbDataResponse = ServiceDataProvider.getRtbData(params4);
              
                 if (RtbDataResponse != null) {
                     ArrayList<Datatype_Appr_Rtb_Data_Int> arrLOVServiceData = ServiceData.getRtbData(new JSONArray(RtbDataResponse.getResults()));
                     if (RtbDataResponse.getStatus() == 1) {
                         for (int i = 0; i < arrLOVServiceData.size(); i++) {
                             appr_Rtb_DataDataProvider.updateData(arrLOVServiceData.get(i));
                         }
                         arrLOVServiceData = null;
                     }
                     //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                 }
                 RtbDataResponse = null;  
                   } catch (Exception e) {
  						// TODO Auto-generated catch block
  						e.printStackTrace();
  					}
                 try {
  					
  				
         	ArrayList<NameValuePair> params5 = new ArrayList<NameValuePair>();
             params5.add(new BasicNameValuePair("COL_ID", col_id  ));
             params5.add(new BasicNameValuePair("APPRSTYPE", "INT"  ));
             SERVICEDATARESPONSE RtbDetailResponse = ServiceDataProvider.getDetailTanah(params5);
         
            if (RtbDetailResponse != null) {
                ArrayList<Datatype_Appr_Rtb_Detail_Int> arrLOVServiceData = ServiceData.getDetailTanah(new JSONArray(RtbDetailResponse.getResults()));
                if (RtbDetailResponse.getStatus() == 1) {
                    for (int i = 0; i < arrLOVServiceData.size(); i++) {
                 	   appr_Rtb_DetailProvider.updateData(arrLOVServiceData.get(i));
                    }
                    arrLOVServiceData = null;
                }
                //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            }
            RtbDetailResponse = null; 
                 } catch (Exception e) {
  					// TODO Auto-generated catch block
  					e.printStackTrace();
  				}
            try {
  				
  			
            ArrayList<NameValuePair> params6 = new ArrayList<NameValuePair>();
            params6.add(new BasicNameValuePair("COL_ID", col_id  ));
            params6.add(new BasicNameValuePair("APPRSTYPE", "INT"  ));
            SERVICEDATARESPONSE VhcValuationResponse = ServiceDataProvider.GetValuationKendaraan(params6);
        
           if (VhcValuationResponse != null) {
               ArrayList<Datatype_Appr_Vhc_Valuation_Int> arrLOVServiceData = ServiceData.GetValuationKendaraan(new JSONArray(VhcValuationResponse.getResults()));
               if (VhcValuationResponse.getStatus() == 1) {
                   for (int i = 0; i < arrLOVServiceData.size(); i++) {
                 	  appr_Vhc_ValuationDataProvider.updateData(arrLOVServiceData.get(i));
                   }
                   arrLOVServiceData = null;
               }
               //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
           }
           VhcValuationResponse = null; 
            } catch (Exception e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
           try {
  				
  			
           ArrayList<NameValuePair> params7 = new ArrayList<NameValuePair>();
           params7.add(new BasicNameValuePair("COL_ID", col_id  ));
           params7.add(new BasicNameValuePair("APPRSTYPE", "INT"  ));
           SERVICEDATARESPONSE RtbValuationResponse = ServiceDataProvider.getvaluationTanah(params7);
       
          if (RtbValuationResponse != null) {
              ArrayList<Datatype_Appr_Rtb_Valuation_Int> arrLOVServiceData = ServiceData.getvaluationTanah(new JSONArray(RtbValuationResponse.getResults()));
              if (RtbValuationResponse.getStatus() == 1) {
                  for (int i = 0; i < arrLOVServiceData.size(); i++) {
                	  appr_Rtb_ValuationDataProvider.updateData(arrLOVServiceData.get(i));
                  }
                  arrLOVServiceData = null;
              }
              //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
          }
          RtbValuationResponse = null; 
           } catch (Exception e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
          try {
  			
  		
          ArrayList<NameValuePair> params8 = new ArrayList<NameValuePair>();
          params8.add(new BasicNameValuePair("COL_ID", col_id  ));
          params8.add(new BasicNameValuePair("APPRSTYPE", "INT"  ));
          SERVICEDATARESPONSE PbValuationResponse = ServiceDataProvider.getPBValuation(params8);
      
         if (PbValuationResponse != null) {
             ArrayList<Datatype_Appr_Pb_Valuation_Int> arrLOVServiceData = ServiceData.getPBValuation(new JSONArray(PbValuationResponse.getResults()));
             if (PbValuationResponse.getStatus() == 1) {
                 for (int i = 0; i < arrLOVServiceData.size(); i++) {
                 	appr_PB_ValuationDataProvider.updateData(arrLOVServiceData.get(i));
                 }
                 arrLOVServiceData = null;
             }
             //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
         }
         PbValuationResponse = null; 
          } catch (Exception e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
         try {
  			
  		
         ArrayList<NameValuePair> params9 = new ArrayList<NameValuePair>();
         params9.add(new BasicNameValuePair("COL_ID", col_id  ));
         params9.add(new BasicNameValuePair("APPRSTYPE", "INT"  ));
         SERVICEDATARESPONSE ProgressBangunanValuationResponse = ServiceDataProvider.getProgresbangunan(params9);
     
        if (ProgressBangunanValuationResponse != null) {
            ArrayList<Datatype_Appr_Progress_Bangunan_Int> arrLOVServiceData = ServiceData.getProgresbangunan(new JSONArray(ProgressBangunanValuationResponse.getResults()));
            if (ProgressBangunanValuationResponse.getStatus() == 1) {
                for (int i = 0; i < arrLOVServiceData.size(); i++) {
                	appr_Rtb_Progress_BangunanDataProvider.updateData(arrLOVServiceData.get(i));
                }
                arrLOVServiceData = null;
            }
            //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        }
        ProgressBangunanValuationResponse = null; 
         } catch (Exception e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}   
        try {
  			
  		
        ArrayList<NameValuePair> params10 = new ArrayList<NameValuePair>();
        params10.add(new BasicNameValuePair("COL_ID", col_id  ));
        params10.add(new BasicNameValuePair("APPRSTYPE", "INT"  ));
        SERVICEDATARESPONSE ProgressDeveloperValuationResponse = ServiceDataProvider.getProgBangunanDeveloper(params10);
    
       if (ProgressDeveloperValuationResponse != null) {
           ArrayList<Datatype_Appr_Progress_Developer_Int> arrLOVServiceData = ServiceData.getProgBangunanDeveloper(new JSONArray(ProgressDeveloperValuationResponse.getResults()));
           if (ProgressDeveloperValuationResponse.getStatus() == 1) {
               for (int i = 0; i < arrLOVServiceData.size(); i++) {
               	appr_Rtb_Progress_DeveloperDataProvider.updateData(arrLOVServiceData.get(i));
               }
               arrLOVServiceData = null;
           }
           //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
       }
       ProgressDeveloperValuationResponse = null; 
        } catch (Exception e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
       try {
  			
  		
         	 ArrayList<NameValuePair> params11 = new ArrayList<NameValuePair>();
              params11.add(new BasicNameValuePair("COL_ID", col_id  ));
              params11.add(new BasicNameValuePair("APPRSTYPE", "INT"  ));
              SERVICEDATARESPONSE MchValuationResponse = ServiceDataProvider.MCHValuation(params11);
          
             if (MchValuationResponse != null) {
                 ArrayList<Datatype_Appr_Mch_Valuation_Int> arrLOVServiceData = ServiceData.MCHValuation(new JSONArray(MchValuationResponse.getResults()));
                 if (MchValuationResponse.getStatus() == 1) {
                     for (int i = 0; i < arrLOVServiceData.size(); i++) {
                     	appr_Mch_ValuationDataProvider.updateData(arrLOVServiceData.get(i));
                     }
                     arrLOVServiceData = null;
                 }
                 //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
             }
             
             MchValuationResponse = null; 
       } catch (Exception e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
             try {
  				
  			
            ///dokument
             ArrayList<NameValuePair> params12 = new ArrayList<NameValuePair>();
             params12.add(new BasicNameValuePair("AP_REGNO", ap_regno  ));
             params12.add(new BasicNameValuePair("APPRSTYPE", "INT"  ));
              SERVICEDATARESPONSE DokumentResponse = ServiceDataProvider.GetDocument(params12);
          
             if (DokumentResponse != null) {
                 ArrayList<Datatype_Appr_Dokument> arrLOVServiceData = ServiceData.GetDocument(new JSONArray(DokumentResponse.getResults()));
                 if (DokumentResponse.getStatus() == 1) {
                     for (int i = 0; i < arrLOVServiceData.size(); i++) {
                  	   appr_DokumentDataProvider.updateData(arrLOVServiceData.get(i));
                     }
                     arrLOVServiceData = null;
                 }
                 //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
             }
             
             DokumentResponse = null;
             } catch (Exception e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
             try {
  				
  			
           ///rtb pembanding
             ArrayList<NameValuePair> params13 = new ArrayList<NameValuePair>();
             params13.add(new BasicNameValuePair("COL_ID", col_id  ));
             params13.add(new BasicNameValuePair("APPRSTYPE", "INT"  ));
              SERVICEDATARESPONSE RtbPembandingResponse = ServiceDataProvider.getDataPembanding(params13);
          
             if (RtbPembandingResponse != null) {
                 ArrayList<Datatype_Appr_Rtb_Pembanding_Int> arrLOVServiceData = ServiceData.getDataPembanding(new JSONArray(RtbPembandingResponse.getResults()));
                 if (RtbPembandingResponse.getStatus() == 1) {
                     for (int i = 0; i < arrLOVServiceData.size(); i++) {
                  	   appr_Rtb_Pembanding.updateData(arrLOVServiceData.get(i));
                     }
                     arrLOVServiceData = null;
                 }
                 //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
             }
             RtbPembandingResponse = null;
             } catch (Exception e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
             }
         	
             try {
                 ///vhc pembanding
                 ArrayList<NameValuePair> params14 = new ArrayList<NameValuePair>();
                 params14.add(new BasicNameValuePair("COL_ID", col_id  ));
                 params14.add(new BasicNameValuePair("APPRSTYPE", "INT"  ));
                  SERVICEDATARESPONSE VhcPembandingResponse = ServiceDataProvider.GetPembandingKendaraan(params14);
              
                 if (VhcPembandingResponse != null) {
                     ArrayList<Datatype_Appr_Vhc_Pembanding_Int> arrLOVServiceData = ServiceData.GetPembandingKendaraan(new JSONArray(VhcPembandingResponse.getResults()));
                     if (VhcPembandingResponse.getStatus() == 1) {
                         for (int i = 0; i < arrLOVServiceData.size(); i++) {
                      	   appr_Vhc_Pembanding.updateData(arrLOVServiceData.get(i));
                         }
                         arrLOVServiceData = null;
                     }
                     //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                 }
                 
                 VhcPembandingResponse = null;
         	
             } 
             catch (Exception e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
             }
             try {
                 ///history
                 ArrayList<NameValuePair> params16 = new ArrayList<NameValuePair>();
                 params16.add(new BasicNameValuePair("COL_ID", col_id  ));
                  SERVICEDATARESPONSE historyResponse = ServiceDataProvider.GetHistoryAppraisal(params16);
              
                 if (historyResponse != null) {
                     ArrayList<Datatype_Appr_History> arrLOVServiceData = ServiceData.GetHistoryAppraisal(new JSONArray(historyResponse.getResults()));
                     if (historyResponse.getStatus() == 1) {
                         for (int i = 0; i < arrLOVServiceData.size(); i++) {
                      	   appr_HistoryProvider.updateData(arrLOVServiceData.get(i));
                         }
                         arrLOVServiceData = null;
                     }
                     //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                 }
                 
                 historyResponse = null;
         	
             } 
             catch (Exception e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
             }
             
             try {
                 ///sampling bangunan
                 ArrayList<NameValuePair> params20 = new ArrayList<NameValuePair>();
                 params20.add(new BasicNameValuePair("COL_ID", col_id  ));
                  SERVICEDATARESPONSE historyResponse = ServiceDataProvider.GetNilaiSampling(params20);
              
                 if (historyResponse != null) {
                     ArrayList<Datatype_Appr_Pb_sampling_bangunan> arrLOVServiceData = ServiceData.GetNilaiSampling(new JSONArray(historyResponse.getResults()));
                     if (historyResponse.getStatus() == 1) {
                         for (int i = 0; i < arrLOVServiceData.size(); i++) {
                      	   appr_Pb_SamplingBangunan_Provider.updateData(arrLOVServiceData.get(i));
                         }
                         arrLOVServiceData = null;
                     }
                     //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                 }
                 
                 historyResponse = null;
         	
             } 
             catch (Exception e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
             }
            
              
          */
        	 /*listinbox = appr_InboxDataProvider.getAllAppr_InboxbyKey(ap_regno);
             if(listinbox.size()>0){
             for (int y = 0; y < listinbox.size(); y++) {
             		Datatype_Appr_Inbox contentdata=new Datatype_Appr_Inbox();
             		contentdata=listinbox.get(y);
             		*/
             		
             		/////////////
             		try {
 	                       ///photo
 	                       ArrayList<NameValuePair> params18 = new ArrayList<NameValuePair>();
 	                       params18.add(new BasicNameValuePair("AP_REGNO", ap_regno));
 	                       
 	                        SERVICEDATARESPONSE PhotoDataResponse = ServiceDataProvider.GetAttachment(params18);
 	                    
 	                       if (PhotoDataResponse != null) {
 	                           ArrayList<PhotoData> arrLOVServiceData = ServiceData.GetAttachment(new JSONArray(PhotoDataResponse.getResults()));
 	                           if (PhotoDataResponse.getStatus() == 1) {
 	                               for (int i = 0; i < arrLOVServiceData.size(); i++) {
 	                            	   photoDataProvider.updateATTACHMENT(arrLOVServiceData.get(i));
 	                            	   //DownloadImageFromUrl(arrLOVServiceData.get(i).getCOL_ID().toString(), arrLOVServiceData.get(i).getAP_REGNO().toString(), arrLOVServiceData.get(i).getFILENAME().toString());
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
             		
             		
             		/////////////
             		try {
 	                       ///Attactment
 	                       ArrayList<NameValuePair> params30 = new ArrayList<NameValuePair>();
 	                       params30.add(new BasicNameValuePair("AP_REGNO", ap_regno));
 	                       params30.add(new BasicNameValuePair("COL_ID", col_id));
 	                        SERVICEDATARESPONSE PhotoDataResponse = ServiceDataProvider.GetDocumentAttachmentDocument(params30);
 	                    
 	                       if (PhotoDataResponse != null) {
 	                           ArrayList<Datatype_attachment> arrLOVServiceData = ServiceData.GetDocumentAttachmentDocument(new JSONArray(PhotoDataResponse.getResults()));
 	                           if (PhotoDataResponse.getStatus() == 1) {
 	                               for (int i = 0; i < arrLOVServiceData.size(); i++) {
 	                            	  appr_Attachment.updateData(arrLOVServiceData.get(i));
 	                            	   //DownloadImageFromUrl(arrLOVServiceData.get(i).getCOL_ID().toString(), arrLOVServiceData.get(i).getAP_REGNO().toString(), arrLOVServiceData.get(i).getFILENAME().toString());
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
             		
             		try {
 	                       ///history workflow
 	                       ArrayList<NameValuePair> params17 = new ArrayList<NameValuePair>();
 	                       params17.add(new BasicNameValuePair("AP_REGNO", ap_regno));
 	                        SERVICEDATARESPONSE historyworkflowResponse = ServiceDataProvider.GetHistoryWorkFlow(params17);
 	                    
 	                       if (historyworkflowResponse != null) {
 	                           ArrayList<Datatype_Appr_History_Workflow> arrLOVServiceData = ServiceData.GetHistoryWorkFlow(new JSONArray(historyworkflowResponse.getResults()));
 	                           if (historyworkflowResponse.getStatus() == 1) {
 	                               for (int i = 0; i < arrLOVServiceData.size(); i++) {
 	                            	   appr_History_WorkflowProvider.updateData(arrLOVServiceData.get(i));
 	                               }
 	                               arrLOVServiceData = null;
 	                           }
 	                           //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
 	                       }
 	                       
 	                       historyworkflowResponse = null;
                     } 
                     catch (Exception e) {
 						// TODO Auto-generated catch block
 						e.printStackTrace();
                     }

                     try {
 	                       ///Negative
 	                       ArrayList<NameValuePair> params18 = new ArrayList<NameValuePair>();
 	                       params18.add(new BasicNameValuePair("COL_ID", col_id));
 	                        SERVICEDATARESPONSE NegativeListResponse = ServiceDataProvider.GetNegativeList(params18);
 	                    
 	                       if (NegativeListResponse != null) {
 	                           ArrayList<Datatype_Appr_NegativeList> arrLOVServiceData = ServiceData.GetNegativeList(new JSONArray(NegativeListResponse.getResults()));
 	                           if (NegativeListResponse.getStatus() == 1) {
 	                               for (int i = 0; i < arrLOVServiceData.size(); i++) {
 	                            	   appr_NegativeProvider.updateData(arrLOVServiceData.get(i));
 	                               }
 	                               arrLOVServiceData = null;
 	                           }
 	                           //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
 	                       }
 	                       
 	                       NegativeListResponse = null;
                     } 
                     catch (Exception e) {
 						// TODO Auto-generated catch block
 						e.printStackTrace();
                     }
                     try {
 	                       ///imb
 	                       ArrayList<NameValuePair> params18 = new ArrayList<NameValuePair>();
 	                       params18.add(new BasicNameValuePair("COL_ID", col_id));
 	                        SERVICEDATARESPONSE imbResponse = ServiceDataProvider.GetIMB(params18);
 	                    
 	                       if (imbResponse != null) {
 	                           ArrayList<Datatype_Appr_imb> arrLOVServiceData = ServiceData.GetIMB(new JSONArray(imbResponse.getResults()));
 	                           if (imbResponse.getStatus() == 1) {
 	                               for (int i = 0; i < arrLOVServiceData.size(); i++) {
 	                            	   appr_ImbProvider.updateData(arrLOVServiceData.get(i));
 	                               }
 	                               arrLOVServiceData = null;
 	                           }
 	                           //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
 	                       }
 	                       
 	                       imbResponse = null;
                     } 
                     catch (Exception e) {
 						// TODO Auto-generated catch block
 						e.printStackTrace();
                     }
                     
                     try {
 	                       ///sertifikat
 	                       ArrayList<NameValuePair> params18 = new ArrayList<NameValuePair>();
 	                       params18.add(new BasicNameValuePair("COL_ID", col_id));
 	                        SERVICEDATARESPONSE sertifikatResponse = ServiceDataProvider.Getsertifikat(params18);
 	                    
 	                       if (sertifikatResponse != null) {
 	                           ArrayList<Datatype_Appr_Sertifikat> arrLOVServiceData = ServiceData.Getsertifikat(new JSONArray(sertifikatResponse.getResults()));
 	                           if (sertifikatResponse.getStatus() == 1) {
 	                               for (int i = 0; i < arrLOVServiceData.size(); i++) {
 	                            	   appr_SertifikatProvider.updateData(arrLOVServiceData.get(i));
 	                               }
 	                               arrLOVServiceData = null;
 	                           }
 	                           //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
 	                       }
 	                       
 	                       sertifikatResponse = null;
                     } 
                     catch (Exception e) {
 						// TODO Auto-generated catch block
 						e.printStackTrace();
                     }
                     try {
 	                       ///valuation bangunan
 	                       ArrayList<NameValuePair> params19 = new ArrayList<NameValuePair>();
 	                       params19.add(new BasicNameValuePair("COL_ID", col_id));
 	                        SERVICEDATARESPONSE valBangunanResponse = ServiceDataProvider.GetvaluationBangunan(params19);
 	                    
 	                       if (valBangunanResponse != null) {
 	                           ArrayList<Datatype_Appr_valBangunan> arrLOVServiceData = ServiceData.GetvaluationBangunan(new JSONArray(valBangunanResponse.getResults()));
 	                           if (valBangunanResponse.getStatus() == 1) {
 	                               for (int i = 0; i < arrLOVServiceData.size(); i++) {
 	                            	   appr_Val_BangunanDataProvider.updateData(arrLOVServiceData.get(i));
 	                               }
 	                               arrLOVServiceData = null;
 	                           }
 	                           //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
 	                       }
 	                       
 	                       valBangunanResponse = null;
                     } 
                     catch (Exception e) {
 						// TODO Auto-generated catch block
 						e.printStackTrace();
                     }
                    try {
 						
 						
               		//collateral
               		ArrayList<NameValuePair> params1 = new ArrayList<NameValuePair>();
                        params1.add(new BasicNameValuePair("COL_ID", col_id  ));
                        SERVICEDATARESPONSE colResponse = ServiceDataProvider.getAppr_collateral(params1);
                       
                       if (colResponse != null) {
                           ArrayList<Datatype_Appr_Collateral> arrLOVServiceData = ServiceData.getAppr_collateral(new JSONArray(colResponse.getResults()));
                           if (colResponse.getStatus() == 1) {
                               for (int i = 0; i < arrLOVServiceData.size(); i++) {
                                   
                               	
                               	appr_CollateralProvider.updateData(arrLOVServiceData.get(i));
                               }
                               arrLOVServiceData = null;
                           }
                           //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                       }
                       colResponse = null;
               		
               		} catch (Exception e) {
 							// TODO Auto-generated catch block
 							e.printStackTrace();
 						}
             		
             		
             		
             		
             		
             		
             		
             		/////////
             		
             		
             		
             		
             		
                     try {
 						
 					
       	    	ArrayList<NameValuePair> params2 = new ArrayList<NameValuePair>();
                      params2.add(new BasicNameValuePair("COL_ID", col_id  ));
                      params2.add(new BasicNameValuePair("APPRSTYPE", "INT"  ));
                      SERVICEDATARESPONSE cektatakotaResponse = ServiceDataProvider.getTataKota(params2);
                  
                     if (cektatakotaResponse != null) {
                         ArrayList<Datatype_Appr_Rtb_Cek_Tata_Kota_Int> arrLOVServiceData = ServiceData.getTataKota(new JSONArray(cektatakotaResponse.getResults()));
                         if (cektatakotaResponse.getStatus() == 1) {
                             for (int i = 0; i < arrLOVServiceData.size(); i++) {
                                 appr_Cek_TataKotaDataProvider.updateData(arrLOVServiceData.get(i));
                             }
                             arrLOVServiceData = null;
                         }
                         //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                     }
                     cektatakotaResponse = null;
                 	} catch (Exception e) {
 						// TODO Auto-generated catch block
 						e.printStackTrace();
 					}
                  try {
 							
                 	 ArrayList<NameValuePair> params3 = new ArrayList<NameValuePair>();
                      params3.add(new BasicNameValuePair("COL_ID", col_id  ));
                      params3.add(new BasicNameValuePair("APPRSTYPE", "INT"  ));
                      SERVICEDATARESPONSE vhcDataResponse = ServiceDataProvider.getVhcData(params3);
                  
                     if (vhcDataResponse != null) {
                         ArrayList<Datatype_Appr_Vch_Data_Int> arrLOVServiceData = ServiceData.getVhcData(new JSONArray(vhcDataResponse.getResults()));
                         if (vhcDataResponse.getStatus() == 1) {
                             for (int i = 0; i < arrLOVServiceData.size(); i++) {
                                 appr_Vhc_DataDataProvider.updateData(arrLOVServiceData.get(i));
                             }
                             arrLOVServiceData = null;
                         }
                         //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                     }
                     vhcDataResponse = null;
                     	
                     	
                  } catch (Exception e) {
 							// TODO Auto-generated catch block
 							e.printStackTrace();
 				
                  }
                  try {
 						
 					
                 	 ArrayList<NameValuePair> params4 = new ArrayList<NameValuePair>();
                 params4.add(new BasicNameValuePair("COL_ID", col_id  ));
                 params4.add(new BasicNameValuePair("APPRSTYPE", "INT"  ));
                 SERVICEDATARESPONSE RtbDataResponse = ServiceDataProvider.getRtbData(params4);
             
                if (RtbDataResponse != null) {
                    ArrayList<Datatype_Appr_Rtb_Data_Int> arrLOVServiceData = ServiceData.getRtbData(new JSONArray(RtbDataResponse.getResults()));
                    if (RtbDataResponse.getStatus() == 1) {
                        for (int i = 0; i < arrLOVServiceData.size(); i++) {
                            appr_Rtb_DataDataProvider.updateData(arrLOVServiceData.get(i));
                        }
                        arrLOVServiceData = null;
                    }
                    //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                }
                RtbDataResponse = null;  
                  } catch (Exception e) {
 						// TODO Auto-generated catch block
 						e.printStackTrace();
 					}
                try {
 					
 				
        	ArrayList<NameValuePair> params5 = new ArrayList<NameValuePair>();
            params5.add(new BasicNameValuePair("COL_ID", col_id  ));
            params5.add(new BasicNameValuePair("APPRSTYPE", "INT"  ));
            SERVICEDATARESPONSE RtbDetailResponse = ServiceDataProvider.getDetailTanah(params5);
        
           if (RtbDetailResponse != null) {
               ArrayList<Datatype_Appr_Rtb_Detail_Int> arrLOVServiceData = ServiceData.getDetailTanah(new JSONArray(RtbDetailResponse.getResults()));
               if (RtbDetailResponse.getStatus() == 1) {
                   for (int i = 0; i < arrLOVServiceData.size(); i++) {
                	   appr_Rtb_DetailProvider.updateData(arrLOVServiceData.get(i));
                   }
                   arrLOVServiceData = null;
               }
               //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
           }
           RtbDetailResponse = null; 
                } catch (Exception e) {
 					// TODO Auto-generated catch block
 					e.printStackTrace();
 				}
           try {
 				
 			
           ArrayList<NameValuePair> params6 = new ArrayList<NameValuePair>();
           params6.add(new BasicNameValuePair("COL_ID", col_id  ));
           params6.add(new BasicNameValuePair("APPRSTYPE", "INT"  ));
           SERVICEDATARESPONSE VhcValuationResponse = ServiceDataProvider.GetValuationKendaraan(params6);
       
          if (VhcValuationResponse != null) {
              ArrayList<Datatype_Appr_Vhc_Valuation_Int> arrLOVServiceData = ServiceData.GetValuationKendaraan(new JSONArray(VhcValuationResponse.getResults()));
              if (VhcValuationResponse.getStatus() == 1) {
                  for (int i = 0; i < arrLOVServiceData.size(); i++) {
                	  appr_Vhc_ValuationDataProvider.updateData(arrLOVServiceData.get(i));
                  }
                  arrLOVServiceData = null;
              }
              //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
          }
          VhcValuationResponse = null; 
           } catch (Exception e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
          try {
 				
 			
          ArrayList<NameValuePair> params7 = new ArrayList<NameValuePair>();
          params7.add(new BasicNameValuePair("COL_ID", col_id  ));
          params7.add(new BasicNameValuePair("APPRSTYPE", "INT"  ));
          SERVICEDATARESPONSE RtbValuationResponse = ServiceDataProvider.getvaluationTanah(params7);
      
         if (RtbValuationResponse != null) {
             ArrayList<Datatype_Appr_Rtb_Valuation_Int> arrLOVServiceData = ServiceData.getvaluationTanah(new JSONArray(RtbValuationResponse.getResults()));
             if (RtbValuationResponse.getStatus() == 1) {
                 for (int i = 0; i < arrLOVServiceData.size(); i++) {
               	  appr_Rtb_ValuationDataProvider.updateData(arrLOVServiceData.get(i));
                 }
                 arrLOVServiceData = null;
             }
             //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
         }
         RtbValuationResponse = null; 
          } catch (Exception e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
         try {
 			
 		
         ArrayList<NameValuePair> params8 = new ArrayList<NameValuePair>();
         params8.add(new BasicNameValuePair("COL_ID", col_id  ));
         params8.add(new BasicNameValuePair("APPRSTYPE", "INT"  ));
         SERVICEDATARESPONSE PbValuationResponse = ServiceDataProvider.getPBValuation(params8);
     
        if (PbValuationResponse != null) {
            ArrayList<Datatype_Appr_Pb_Valuation_Int> arrLOVServiceData = ServiceData.getPBValuation(new JSONArray(PbValuationResponse.getResults()));
            if (PbValuationResponse.getStatus() == 1) {
                for (int i = 0; i < arrLOVServiceData.size(); i++) {
                	appr_PB_ValuationDataProvider.updateData(arrLOVServiceData.get(i));
                }
                arrLOVServiceData = null;
            }
            //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        }
        PbValuationResponse = null; 
         } catch (Exception e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
        try {
 			
 		
        ArrayList<NameValuePair> params9 = new ArrayList<NameValuePair>();
        params9.add(new BasicNameValuePair("COL_ID", col_id  ));
        params9.add(new BasicNameValuePair("APPRSTYPE", "INT"  ));
        SERVICEDATARESPONSE ProgressBangunanValuationResponse = ServiceDataProvider.getProgresbangunan(params9);
    
       if (ProgressBangunanValuationResponse != null) {
           ArrayList<Datatype_Appr_Progress_Bangunan_Int> arrLOVServiceData = ServiceData.getProgresbangunan(new JSONArray(ProgressBangunanValuationResponse.getResults()));
           if (ProgressBangunanValuationResponse.getStatus() == 1) {
               for (int i = 0; i < arrLOVServiceData.size(); i++) {
               	appr_Rtb_Progress_BangunanDataProvider.updateData(arrLOVServiceData.get(i));
               }
               arrLOVServiceData = null;
           }
           //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
       }
       ProgressBangunanValuationResponse = null; 
        } catch (Exception e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}   
       try {
 			
 		
       ArrayList<NameValuePair> params10 = new ArrayList<NameValuePair>();
       params10.add(new BasicNameValuePair("COL_ID", col_id  ));
       params10.add(new BasicNameValuePair("APPRSTYPE", "INT"  ));
       SERVICEDATARESPONSE ProgressDeveloperValuationResponse = ServiceDataProvider.getProgBangunanDeveloper(params10);
   
      if (ProgressDeveloperValuationResponse != null) {
          ArrayList<Datatype_Appr_Progress_Developer_Int> arrLOVServiceData = ServiceData.getProgBangunanDeveloper(new JSONArray(ProgressDeveloperValuationResponse.getResults()));
          if (ProgressDeveloperValuationResponse.getStatus() == 1) {
              for (int i = 0; i < arrLOVServiceData.size(); i++) {
              	appr_Rtb_Progress_DeveloperDataProvider.updateData(arrLOVServiceData.get(i));
              }
              arrLOVServiceData = null;
          }
          //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
      }
      ProgressDeveloperValuationResponse = null; 
       } catch (Exception e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
      try {
 			
 		
        	 ArrayList<NameValuePair> params11 = new ArrayList<NameValuePair>();
             params11.add(new BasicNameValuePair("COL_ID", col_id  ));
             params11.add(new BasicNameValuePair("APPRSTYPE", "INT"  ));
             SERVICEDATARESPONSE MchValuationResponse = ServiceDataProvider.MCHValuation(params11);
         
            if (MchValuationResponse != null) {
                ArrayList<Datatype_Appr_Mch_Valuation_Int> arrLOVServiceData = ServiceData.MCHValuation(new JSONArray(MchValuationResponse.getResults()));
                if (MchValuationResponse.getStatus() == 1) {
                    for (int i = 0; i < arrLOVServiceData.size(); i++) {
                    	appr_Mch_ValuationDataProvider.updateData(arrLOVServiceData.get(i));
                    }
                    arrLOVServiceData = null;
                }
                //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            }
            
            MchValuationResponse = null; 
      } catch (Exception e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
            try {
 				
 			
           ///dokument
            ArrayList<NameValuePair> params12 = new ArrayList<NameValuePair>();
            params12.add(new BasicNameValuePair("AP_REGNO", ap_regno  ));
            params12.add(new BasicNameValuePair("APPRSTYPE", "INT"  ));
             SERVICEDATARESPONSE DokumentResponse = ServiceDataProvider.GetDocument(params12);
         
            if (DokumentResponse != null) {
                ArrayList<Datatype_Appr_Dokument> arrLOVServiceData = ServiceData.GetDocument(new JSONArray(DokumentResponse.getResults()));
                if (DokumentResponse.getStatus() == 1) {
                    for (int i = 0; i < arrLOVServiceData.size(); i++) {
                 	   appr_DokumentDataProvider.updateData(arrLOVServiceData.get(i));
                    }
                    arrLOVServiceData = null;
                }
                //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            }
            
            DokumentResponse = null;
            } catch (Exception e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
            try {
 				
 			
          ///rtb pembanding
            ArrayList<NameValuePair> params13 = new ArrayList<NameValuePair>();
            params13.add(new BasicNameValuePair("COL_ID", col_id  ));
            params13.add(new BasicNameValuePair("APPRSTYPE", "INT"  ));
             SERVICEDATARESPONSE RtbPembandingResponse = ServiceDataProvider.getDataPembanding(params13);
         
            if (RtbPembandingResponse != null) {
                ArrayList<Datatype_Appr_Rtb_Pembanding_Int> arrLOVServiceData = ServiceData.getDataPembanding(new JSONArray(RtbPembandingResponse.getResults()));
                if (RtbPembandingResponse.getStatus() == 1) {
                    for (int i = 0; i < arrLOVServiceData.size(); i++) {
                 	   appr_Rtb_Pembanding.updateData(arrLOVServiceData.get(i));
                    }
                    arrLOVServiceData = null;
                }
                //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            }
            RtbPembandingResponse = null;
            } catch (Exception e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
            }
        	
            try {
                ///vhc pembanding
                ArrayList<NameValuePair> params14 = new ArrayList<NameValuePair>();
                params14.add(new BasicNameValuePair("COL_ID", col_id  ));
                params14.add(new BasicNameValuePair("APPRSTYPE", "INT"  ));
                 SERVICEDATARESPONSE VhcPembandingResponse = ServiceDataProvider.GetPembandingKendaraan(params14);
             
                if (VhcPembandingResponse != null) {
                    ArrayList<Datatype_Appr_Vhc_Pembanding_Int> arrLOVServiceData = ServiceData.GetPembandingKendaraan(new JSONArray(VhcPembandingResponse.getResults()));
                    if (VhcPembandingResponse.getStatus() == 1) {
                        for (int i = 0; i < arrLOVServiceData.size(); i++) {
                     	   appr_Vhc_Pembanding.updateData(arrLOVServiceData.get(i));
                        }
                        arrLOVServiceData = null;
                    }
                    //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                }
                
                VhcPembandingResponse = null;
        	
            } 
            catch (Exception e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
            }
            try {
                ///history
                ArrayList<NameValuePair> params16 = new ArrayList<NameValuePair>();
                params16.add(new BasicNameValuePair("COL_ID", col_id  ));
                 SERVICEDATARESPONSE historyResponse = ServiceDataProvider.GetHistoryAppraisal(params16);
             
                if (historyResponse != null) {
                    ArrayList<Datatype_Appr_History> arrLOVServiceData = ServiceData.GetHistoryAppraisal(new JSONArray(historyResponse.getResults()));
                    if (historyResponse.getStatus() == 1) {
                        for (int i = 0; i < arrLOVServiceData.size(); i++) {
                     	   appr_HistoryProvider.updateData(arrLOVServiceData.get(i));
                        }
                        arrLOVServiceData = null;
                    }
                    //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                }
                
                historyResponse = null;
        	
            } 
            catch (Exception e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
            }
            
            try {
                ///sampling bangunan
                ArrayList<NameValuePair> params20 = new ArrayList<NameValuePair>();
                params20.add(new BasicNameValuePair("COL_ID", col_id  ));
                 SERVICEDATARESPONSE historyResponse = ServiceDataProvider.GetNilaiSampling(params20);
             
                if (historyResponse != null) {
                    ArrayList<Datatype_Appr_Pb_sampling_bangunan> arrLOVServiceData = ServiceData.GetNilaiSampling(new JSONArray(historyResponse.getResults()));
                    if (historyResponse.getStatus() == 1) {
                        for (int i = 0; i < arrLOVServiceData.size(); i++) {
                     	   appr_Pb_SamplingBangunan_Provider.updateData(arrLOVServiceData.get(i));
                        }
                        arrLOVServiceData = null;
                    }
                    //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                }
                
                historyResponse = null;
        	
            } 
            catch (Exception e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
            }
          /* }	
             
         } */
         }
             
        
  	   
     }
    public void DownloadImageFromUrl(String id, String prospekId, String fileName) throws Exception {

        File file = new File(AppConstants.FILEPATH + fileName);
        if (!file.exists()) {
            URL url = new URL(JSONServiceHandler.URLDOWNLOADIMAGESERVER + "FileManagerService.svc/RetrieveFile/?ID=" + id + "&AP_REGNO=" + prospekId + "&filename=" + fileName);
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
            FileOutputStream fos = new FileOutputStream(AppConstants.FILEPATH + fileName);
            fos.write(baf.toByteArray());
            fos.close();
        }
    }
    @SuppressWarnings("deprecation")
    public void showProgressIndicator() {
        if (dlgProgress == null) {
            dlgProgress = new ProgressDialog(this);
            dlgProgress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dlgProgress.setTitle(getString(R.string.str_informasi));
            dlgProgress.setMessage("Loading...");
            dlgProgress.setCancelable(false);
            dlgProgress.setButton(getString(R.string.str_cancel), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    dlgProgress.setMessage(loadingMessage);
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
