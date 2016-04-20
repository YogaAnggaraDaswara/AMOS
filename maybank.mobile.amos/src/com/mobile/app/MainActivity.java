

package com.mobile.app;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.annotation.SuppressLint;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import maybank.mobile.amos.R;

//import com.actionbarsherlock.view.SubMenu;
import com.google.gson.Gson;
import com.mobile.app.configuration.AppConstants;
import com.mobile.appraisal.Fragment_Cek_Tata_Kota;
import com.mobile.appraisal.Fragment_Data_Kendaraan;
import com.mobile.appraisal.Fragment_Data_Rumah_Tanah_Bangunan;
import com.mobile.appraisal.Fragment_Detail;
import com.mobile.appraisal.Fragment_Dokumen_Jaminan;
import com.mobile.appraisal.Fragment_History_Appraisal;
import com.mobile.appraisal.Fragment_History_WorkFlow;
import com.mobile.appraisal.Fragment_Informasi_Jaminan;
import com.mobile.appraisal.Fragment_Progress_Bangunan;
import com.mobile.appraisal.Fragment_Progress_Developer;
import com.mobile.appraisal.Fragment_RTB_Pembanding;
import com.mobile.appraisal.Fragment_VHC_Pembanding;
import com.mobile.appraisal.Fragment_Valuation_Kendaraan;
import com.mobile.appraisal.Fragment_Valuation_Mesin;
import com.mobile.appraisal.Fragment_Valuation_Persediaan;
import com.mobile.appraisal.Fragment_Valuation_Rumah_Tanah_Bangunan;
import com.mobile.appraisal.InboxActivity;
import com.mobile.appraisal.InqueryActivity;
import com.mobile.bo.app.dataprovider.Appr_Cek_TataKota;
import com.mobile.bo.app.dataprovider.Appr_Collateral;
import com.mobile.bo.app.dataprovider.Appr_DokumentDataProvider;
import com.mobile.bo.app.dataprovider.Appr_ImbProvider;
import com.mobile.bo.app.dataprovider.Appr_InboxDataProvider;
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
import com.mobile.bo.app.dataprovider.Appr_Status;
import com.mobile.bo.app.dataprovider.Appr_Val_BangunanDataProvider;
import com.mobile.bo.app.dataprovider.Appr_Vhc_DataDataProvider;
import com.mobile.bo.app.dataprovider.Appr_Vhc_Pembanding;
import com.mobile.bo.app.dataprovider.Appr_Vhc_ValuationDataProvider;
import com.mobile.bo.app.dataprovider.PhotoDataProvider;
import com.mobile.bo.app.datatype.Datatype_Appr_Collateral;
import com.mobile.bo.app.datatype.Datatype_Appr_Dokument;
import com.mobile.bo.app.datatype.Datatype_Appr_Inbox;
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
import com.mobile.bo.app.datatype.Datatype_Appr_Status;
import com.mobile.bo.app.datatype.Datatype_Appr_Vch_Data_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_Vhc_Pembanding_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_Vhc_Valuation_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_imb;
import com.mobile.bo.app.datatype.Datatype_Appr_update;
import com.mobile.bo.app.datatype.Datatype_Appr_valBangunan;
import com.mobile.bo.app.datatype.PhotoData;
import com.mobile.bo.app.datatype.UserData;
import com.mobile.database.app.common.DataConverter;
import com.mobile.framework.data.SessionSharedPreference;
import com.mobile.services.app.datatype.DATA_RESPONSE;
import com.mobile.services.app.datatype.PHOTORESPONSE;
import com.mobile.services.app.datatype.SERVICEDATARESPONSE;
import com.mobile.services.app.services.ServiceDataProvider;

@SuppressLint("NewApi")
public class MainActivity extends Activity implements TabListener {
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private ArrayList<Datatype_Appr_Status> datatype_Appr_Status = null;
    private Appr_Status appr_Status=new Appr_Status();
    private UserData userDetail;
    private int total_save=0;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] mListMenu;
    private String ap_regno="";
    private String col_id="";
    private String col_type="";
    private String appraise_type="";
    private String status="";
    private String statuapps="";
    private String col_class="";
    private Context ctx=null; 
    private Appr_InboxDataProvider appr_Inbox;
    private Datatype_Appr_Inbox listdata = null;
    private Datatype_Appr_Collateral datatype_Appr_Collateral=new Datatype_Appr_Collateral() ;
    private Appr_Collateral appr_Collateral=new Appr_Collateral();
    private Appr_Rtb_Progress_BangunanDataProvider appr_progress_DataProvider=new Appr_Rtb_Progress_BangunanDataProvider();
    private Datatype_Appr_Progress_Bangunan_Int appr_progress_data_int = new Datatype_Appr_Progress_Bangunan_Int();
    private Appr_Rtb_Progress_DeveloperDataProvider appr_progress_DataProvider_dev=new Appr_Rtb_Progress_DeveloperDataProvider();
    private Datatype_Appr_Progress_Developer_Int appr_progress_data_int_dev = new Datatype_Appr_Progress_Developer_Int();
    
    
    private Appr_Rtb_ValuationDataProvider appr_Rtb_ValuationDataProvider;
    private Datatype_Appr_Rtb_Valuation_Int appr_rtb_valuation_int = new Datatype_Appr_Rtb_Valuation_Int();
    private Appr_PB_ValuationDataProvider appr_Pb_ValuationDataProvider;
    private Datatype_Appr_Pb_Valuation_Int appr_pb_valuation_int = new Datatype_Appr_Pb_Valuation_Int();
    private Appr_Mch_ValuationDataProvider appr_mch_ValuationDataProvider=new Appr_Mch_ValuationDataProvider();
    private Datatype_Appr_Mch_Valuation_Int appr_mch_valuation_int = new Datatype_Appr_Mch_Valuation_Int();
    private Appr_Vhc_ValuationDataProvider appr_vhc_ValuationDataProvider=new Appr_Vhc_ValuationDataProvider();
    private Datatype_Appr_Vhc_Valuation_Int appr_kendaraan_valuation_int = new Datatype_Appr_Vhc_Valuation_Int();
    private Datatype_Appr_Rtb_Detail_Int appr_Rtb_detail_int = new Datatype_Appr_Rtb_Detail_Int();
    private Appr_Rtb_DetailProvider appr_Detail_DataProvider=new Appr_Rtb_DetailProvider();
    private Appr_Vhc_DataDataProvider appr_Vhc_DataProvider=new Appr_Vhc_DataDataProvider();
    private Datatype_Appr_Vch_Data_Int appr_Vhc_data_int = new Datatype_Appr_Vch_Data_Int();
    private Appr_Rtb_DataDataProvider appr_Rtb_DataProvider=new Appr_Rtb_DataDataProvider();
    private Datatype_Appr_Rtb_Data_Int appr_Rtb_data_int = new Datatype_Appr_Rtb_Data_Int();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);
        appr_Inbox=new Appr_InboxDataProvider();
        datatype_Appr_Status = new ArrayList<Datatype_Appr_Status> ();
        appr_Status=new Appr_Status();
        appr_progress_data_int = new Datatype_Appr_Progress_Bangunan_Int();
        appr_progress_DataProvider=new Appr_Rtb_Progress_BangunanDataProvider();	
        appr_Rtb_ValuationDataProvider=new Appr_Rtb_ValuationDataProvider();
        appr_rtb_valuation_int=new Datatype_Appr_Rtb_Valuation_Int();
        appr_Pb_ValuationDataProvider=new Appr_PB_ValuationDataProvider();
        appr_pb_valuation_int = new Datatype_Appr_Pb_Valuation_Int();
        appr_mch_ValuationDataProvider=new Appr_Mch_ValuationDataProvider();
        appr_mch_valuation_int = new Datatype_Appr_Mch_Valuation_Int();
        appr_vhc_ValuationDataProvider=new Appr_Vhc_ValuationDataProvider();
        appr_kendaraan_valuation_int = new Datatype_Appr_Vhc_Valuation_Int();
        appr_Detail_DataProvider=new Appr_Rtb_DetailProvider();
        appr_Rtb_detail_int = new Datatype_Appr_Rtb_Detail_Int();
        appr_Vhc_DataProvider=new Appr_Vhc_DataDataProvider();
        appr_Vhc_data_int = new Datatype_Appr_Vch_Data_Int();
        appr_Rtb_DataProvider=new Appr_Rtb_DataDataProvider();
        appr_Rtb_data_int = new Datatype_Appr_Rtb_Data_Int();	
        appr_progress_DataProvider_dev=new Appr_Rtb_Progress_DeveloperDataProvider();
        appr_progress_data_int_dev = new Datatype_Appr_Progress_Developer_Int();
        
        
        ctx=this;
        try {
 			userDetail = (UserData) SessionSharedPreference.getDataFromSharedPreference(ctx, UserData.class, AppConstants.USER_SESSION);
 		} catch (Exception e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
         Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            ap_regno=(String)b.get("AP_REGNO");
            col_id=(String)b.get("COL_ID");
            col_type=(String)b.get("COL_TYPE");
            appraise_type=(String)b.get("APPRAISE_TYPE");
            status=(String)b.get("STATUS");
            if(status.equals("INBOX"))
            	statuapps=(String)b.get("STATUSAPP");
            
            datatype_Appr_Collateral=new Datatype_Appr_Collateral();
         	datatype_Appr_Collateral=appr_Collateral.getAllAppr_Collateral(col_id);
         	
         	
         	col_class=datatype_Appr_Collateral.COL_CLASS;
        }
        if(col_type.equals("RE")){
        	mListMenu = getResources().getStringArray(R.array.menu_items_rtb);
        	total_save=2;
        }
        if(col_type.equals("MCH")){
        	mListMenu = getResources().getStringArray(R.array.menu_items_mch);
        	total_save=2;
        }
        if(col_type.equals("VEH")){
        	mListMenu = getResources().getStringArray(R.array.menu_items_vch);
        	total_save=2;
        }
        if(col_type.equals("STK")){
        	mListMenu = getResources().getStringArray(R.array.menu_items_psb);
        	total_save=2;
        }
        if(col_class.equals("001")){
	        if(appraise_type.equals("D")){
	        	mListMenu = getResources().getStringArray(R.array.menu_items_pd);
	        	total_save=2;
	        }
	        if(appraise_type.equals("K")){
	        	mListMenu = getResources().getStringArray(R.array.menu_items_pb);
	        	total_save=2;
	        }
        }
        //setTheme(R.style.);
        mTitle = mDrawerTitle = getTitle();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mListMenu));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        getActionBar().setIcon(R.drawable.ic_launcher);
        // enable ActionBar app icon to behave as action to toggle nav drawer
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
     
   
       
        // ActionBarDrawerToggle ties together the the proper interactions
        // between the sliding drawer and the action bar app icon
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                R.drawable.ic_drawer,  /* nav drawer image to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description for accessibility */
                R.string.drawer_close  /* "close drawer" description for accessibility */
                ) {
            public void onDrawerClosed(View view) {
                //getActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                //getActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            selectItem("Main",0);
        }
    }
    private String checkMandatory(){
    	String reVal="";
    	if(col_type.equals("RE")){

    	        
        }
        if(col_type.equals("MCH")){
        	mListMenu = getResources().getStringArray(R.array.menu_items_mch);
        	total_save=2;
        }
        if(col_type.equals("VEH")){
        	mListMenu = getResources().getStringArray(R.array.menu_items_vch);
        	total_save=2;
        }
        if(col_type.equals("STK")){
        	mListMenu = getResources().getStringArray(R.array.menu_items_psb);
        	total_save=2;
        }
        if(col_class.equals("001")){
	        if(appraise_type.equals("D")){
	        	mListMenu = getResources().getStringArray(R.array.menu_items_pd);
	        	total_save=2;
	        }
	        if(appraise_type.equals("K")){
	        	mListMenu = getResources().getStringArray(R.array.menu_items_pb);
	        	total_save=2;
	        }
        }
    	return reVal;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        android.view.SubMenu subMenu1 = menu.addSubMenu("");
        if(status.equals("INBOX")){
	        if(statuapps.equals("Pending")){
	        	 subMenu1.add("UnPending").setIcon(R.drawable.unpending);
	        }
	        else{
	        	 subMenu1.add("Back Staff Assigment").setIcon(R.drawable.backassigment);
	             subMenu1.add("Pending").setIcon(R.drawable.pending);
	             subMenu1.add("Proceed").setIcon(R.drawable.proceed);
	        }
        }
        subMenu1.add("Back").setIcon(R.drawable.back);
        
        MenuItem subMenu1Item = subMenu1.getItem();
        subMenu1Item.setIcon(R.drawable.ic_drawer);
        subMenu1Item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
       
       

        return super.onCreateOptionsMenu(menu);
    }

    
    /*public boolean onCreateOptionsMenu(Menu menu) {
    	//getMenuInflater().inflate(R.menu.menu, menu);
        menu.add("Back Staff Assigment")
      	//.setIcon(R.drawable.button_back)
        .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
       
    
        menu.add("Pending")
        //.setIcon(R.drawable.button_back)
        .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
        
        menu.add("Proceed")
        //.setIcon(R.drawable.save)
        .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
        
        menu.add("Back")
        //.setIcon(R.drawable.back)
        .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
        
        return true;
    }*/

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
         // The action bar home/up action should open or close the drawer.
         // ActionBarDrawerToggle will take care of this.
    	 if (mDrawerToggle.onOptionsItemSelected(item)) {
             return true;
         }
         else{
	    	if(item.getTitle().toString()=="Back Staff Assigment")
	    	{
	    		backstaffassigment();
	    	}
	    	else if(item.getTitle().toString()=="Pending")
	    	{
	    		pending();
	    	}
	    	else if(item.getTitle().toString()=="Proceed")
	    	{
	    		if(cekMandatoryByType().equals(true)){	
					Save();
	    		}
	    		else{
	    			showAlert(R.string.msg_notification_mandatory);
	    		}
	    	}
	    	else if(item.getTitle().toString()=="UnPending")
	    	{
	    		Unpending();
	    	}
	    	else if(item.getTitle().toString()=="Back")
	    	{
	    		BackActivity();
	    	}
	    	return true;
         }
    	 
       /* if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        else{
		      switch (item.getItemId()) {
		      	case R.id.backtoao:
		    	  
		      	case R.id.pending:
		      		
				case R.id.save:
				
					//datatype_Appr_Status=appr_Status.getAllAppr_Status(col_id);
					//if(datatype_Appr_Status.size()== total_save)
					//{				
						Save();
		      		//}
					return true;
		
				case R.id.back:
					BackActivity();
					return true;

				default:
					return super.onOptionsItemSelected(item);
				}
        }*/
    }
   
    public void BackActivity() {
    	Intent i=null;
    	if(status.equals("INBOX")){
    		i = new Intent(MainActivity.this, InboxActivity.class);   
    	}
    	else{
    		i = new Intent(MainActivity.this, InqueryActivity.class);   
    	}
    	 startActivity(i);
	}
	

	public void androidActivity() {
		setTitle(mListMenu[1]);
	}
    /* The click listner for ListView in the navigation drawer */
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        	 //String text = ((TextView) view.findViewById(android.R.id.text1)).getText().toString();
        	
            selectItem(((TextView)view).getText().toString(),position);
        }
    }

    private void selectItem(String selectedItem,int position) {
    	  Fragment fragment = null;
         
    	setTitle(mListMenu[position]);
    	if (selectedItem.compareTo("Main") == 0) {
            fragment = new Fragment_Informasi_Jaminan();
            
        } else if (selectedItem.compareTo("Dokumen Jaminan") == 0) {
            fragment = new Fragment_Dokumen_Jaminan();
        } else if (selectedItem.compareTo("Valuation") == 0) {
        	if(col_type.equals("RE")){
        		fragment = new Fragment_Valuation_Rumah_Tanah_Bangunan();
        	}
        	else if(col_type.equals("MCH")){
        		fragment = new Fragment_Valuation_Mesin();
        	}	
        	else if(col_type.equals("VEH")){
        		fragment = new Fragment_Valuation_Kendaraan();
        	}	
        	else if(col_type.equals("STK")){
        		fragment = new Fragment_Valuation_Persediaan();
        	}
        } else if (selectedItem.compareTo("Data") == 0) {
        	if(col_type.equals("RE")){
        		 fragment = new Fragment_Data_Rumah_Tanah_Bangunan();
        	}
        	else if(col_type.equals("VEH")){
        		fragment = new Fragment_Data_Kendaraan();
        	}	
        	
         } else if (selectedItem.compareTo("Detail") == 0) {
            fragment = new Fragment_Detail();
        } else if (selectedItem.compareTo("Data Pembanding") == 0) {
        	if(col_type.equals("VEH")){
        		fragment = new Fragment_VHC_Pembanding();
        	}	
        	else if(col_type.equals("RE")){
//        		 fragment = new Fragment_RTB_Pembanding();
        	}
           
        } else if (selectedItem.compareTo("Cek Tata Kota") == 0) {
            fragment = new Fragment_Cek_Tata_Kota();
        } else if (selectedItem.compareTo("Progress Bangunan") == 0) {
            fragment = new Fragment_Progress_Bangunan();
        } else if (selectedItem.compareTo("Progress Developer") == 0) {
            fragment=new Fragment_Progress_Developer();
        	//fragment = new Fragment_Progress_Developer();
        } /*else if(selectedItem.compareTo("WebView") == 0) {
            fragment = new FragmentWebView();
        }*/
        else if (selectedItem.compareTo("History") == 0) {
        fragment=new Fragment_History_Appraisal();
    	//fragment = new Fragment_Progress_Developer();
        }
        else if (selectedItem.compareTo("Workflow History") == 0) {
            fragment=new Fragment_History_WorkFlow();
        	//fragment = new Fragment_Progress_Developer();
        }
    	 Bundle b = new Bundle();
         b.putString("AP_REGNO", ap_regno);
         b.putString("COL_ID", col_id);
         b.putString("COL_TYPE", col_type);
         b.putString("STATUS", status);
         
         fragment.setArguments(b);
    	// update the main content by replacing fragments
         
        
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
        
        // update selected item and title, then close the drawer
        mDrawerList.setItemChecked(position, true);
        setTitle(mListMenu[position]);
        mDrawerLayout.closeDrawer(mDrawerList);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
    public void Save() {
    	new SubmittedImb().execute();
    	new SubmittedNegative().execute();
    	new SubmittedRtbPembanding().execute();
    	new SubmittedVhcPembanding().execute();
    	new SubmittedDokumen().execute();
    	new SubmittedRtbValuation().execute();
    	new SubmittedRtbBangunan().execute();
    	new SubmittedRtbData().execute();
    	new SubmittedRtbDetail().execute();
    	new SubmittedRtbTataKota().execute();
    	new SubmittedVhcValuation().execute();
    	new SubmittedVhcData().execute();
    	
    	new SubmittedMhcValuation().execute();
    	new SubmittedPbValuation().execute();
    	new SubmittedProgressbangunan().execute();
    	new SubmittedProgressdeveloper().execute();
    	new SubmittedSampling().execute();
    	new SubmittedPhoto().execute();
    	new UpdateStatus().execute();
    	showAlert(R.string.msg_notification_submit_success);
    }
    public void Unpending() {
    	new SubmittedImb().execute();
    	new SubmittedNegative().execute();
    	new SubmittedRtbPembanding().execute();
    	new SubmittedVhcPembanding().execute();
    	new SubmittedDokumen().execute();
    	new SubmittedRtbValuation().execute();
    	new SubmittedRtbBangunan().execute();
    	new SubmittedRtbData().execute();
    	new SubmittedRtbDetail().execute();
    	new SubmittedRtbTataKota().execute();
    	new SubmittedVhcValuation().execute();
    	new SubmittedVhcData().execute();
    	
    	new SubmittedMhcValuation().execute();
    	new SubmittedPbValuation().execute();
    	new SubmittedProgressbangunan().execute();
    	new SubmittedProgressdeveloper().execute();
    	new SubmittedSampling().execute();
    	new SubmittedPhoto().execute();
    	new UpdateUnPending().execute();
    	showAlert(R.string.msg_notification_submit_success);
    }
    public void pending() {
    	new SubmittedImb().execute();
    	new SubmittedNegative().execute();
    	new SubmittedRtbPembanding().execute();
    	new SubmittedVhcPembanding().execute();
    	new SubmittedDokumen().execute();
    	new SubmittedRtbValuation().execute();
    	new SubmittedRtbBangunan().execute();
    	new SubmittedRtbData().execute();
    	new SubmittedRtbDetail().execute();
    	new SubmittedRtbTataKota().execute();
    	new SubmittedVhcValuation().execute();
    	new SubmittedVhcData().execute();
    	
    	new SubmittedMhcValuation().execute();
    	new SubmittedPbValuation().execute();
    	new SubmittedProgressbangunan().execute();
    	new SubmittedProgressdeveloper().execute();
    	new SubmittedSampling().execute();
    	new SubmittedPhoto().execute();
    	new UpdatePending().execute();
    	showAlert(R.string.msg_notification_submit_success);
    }
    public void backstaffassigment() {
    	new SubmittedImb().execute();
    	new SubmittedNegative().execute();
    	new SubmittedRtbPembanding().execute();
    	new SubmittedVhcPembanding().execute();
    	new SubmittedDokumen().execute();
    	new SubmittedRtbValuation().execute();
    	new SubmittedRtbBangunan().execute();
    	new SubmittedRtbData().execute();
    	new SubmittedRtbDetail().execute();
    	new SubmittedRtbTataKota().execute();
    	new SubmittedVhcValuation().execute();
    	new SubmittedVhcData().execute();
    	
    	new SubmittedMhcValuation().execute();
    	new SubmittedPbValuation().execute();
    	new SubmittedProgressbangunan().execute();
    	new SubmittedProgressdeveloper().execute();
    	new SubmittedSampling().execute();
    	new SubmittedPhoto().execute();
    	new UpdateBackStaff().execute();
    	showAlert(R.string.msg_notification_submit_success);
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
    private class SubmittedSampling extends AsyncTask<Void, Void,Void> {
  		Appr_Pb_SamplingBangunan_Provider appr_Pb_SamplingBangunan_Provider=new Appr_Pb_SamplingBangunan_Provider();
  		//Datatype_Appr_History_Workflow appr_history_workflow=new Datatype_Appr_History_Workflow();
  		@Override
  		protected Void doInBackground(Void... params) {
  				ArrayList<Datatype_Appr_Pb_sampling_bangunan> arrdata = appr_Pb_SamplingBangunan_Provider.getAllAppr_Pb_sampling(col_id) ;
				if (arrdata.size() > 0){
					try {
						Gson gsondata=new Gson();
						
						ArrayList<DATA_RESPONSE> Response = ServiceDataProvider.submitData_InsertSampling(gsondata.toJson(arrdata).toString());
						if (Response != null){
							if (Response.size() > 0){
								for (int i=0;i<Response.size();i++ ){
									DATA_RESPONSE objRes= Response.get(i);
									if (objRes.getSTATUS().equalsIgnoreCase(AppConstants.STATUSPROSPEKTRUE)){
										String id=objRes.getID();
										/*String prospekid = objRes.getID();
										Datatype_Appr_imb pd= appr_ImbProvider.getAllAppr_imb_by_id(id);
										pd.setPROSPEKID(prospekid);	
										pd.setISPENDINGUPLOADED(false);								
										try {
											followupDataProvider.updateProspekIdFollowUp(prospekid, id);
											prospekDataProvider.updateProspek(pd);
										} catch (Exception e) {
											Log.d(TAG, "Error Update Data: "+e.getMessage());
										}*/
									}
								}	
							}			
						}
						else{
							//Log.d(TAG, "Send Data To Server Via Service: Server returned null");
						}
					} catch (Exception e) {
						Log.d("Error", "Send Data To Server Via Service: Exception ->"+e.getMessage());
					}
				}
				else{
					//Log.d(TAG, "No data to be syncronized");
				}
				arrdata = null;
				return null;
  		}
  		
  		 @Override
  	     protected void onPostExecute(Void result) {
  			appr_Pb_SamplingBangunan_Provider = null;
  		 }	 
      }

    private class SubmittedImb extends AsyncTask<Void, Void,Void> {
		Appr_ImbProvider appr_ImbProvider=new Appr_ImbProvider();
		//Datatype_Appr_History_Workflow appr_history_workflow=new Datatype_Appr_History_Workflow();
		@Override
		protected Void doInBackground(Void... params) {
				ArrayList<Datatype_Appr_imb> arrdata = appr_ImbProvider.getAllAppr_imb(col_id);					
				if (arrdata.size() > 0){
					try {
						Gson gsondata=new Gson();
						
						ArrayList<DATA_RESPONSE> imbResponse = ServiceDataProvider.submitData_imb(gsondata.toJson(arrdata).toString());
						if (imbResponse != null){
							if (imbResponse.size() > 0){
								for (int i=0;i<imbResponse.size();i++ ){
									DATA_RESPONSE objRes= imbResponse.get(i);
									if (objRes.getSTATUS().equalsIgnoreCase(AppConstants.STATUSPROSPEKTRUE)){
										String id=objRes.getID();
										/*String prospekid = objRes.getID();
										Datatype_Appr_imb pd= appr_ImbProvider.getAllAppr_imb_by_id(id);
										pd.setPROSPEKID(prospekid);	
										pd.setISPENDINGUPLOADED(false);								
										try {
											followupDataProvider.updateProspekIdFollowUp(prospekid, id);
											prospekDataProvider.updateProspek(pd);
										} catch (Exception e) {
											Log.d(TAG, "Error Update Data: "+e.getMessage());
										}*/
									}
								}	
							}			
						}
						else{
							//Log.d(TAG, "Send Data To Server Via Service: Server returned null");
						}
					} catch (Exception e) {
						Log.d("Error", "Send Data To Server Via Service: Exception ->"+e.getMessage());
					}
				}
				else{
					//Log.d(TAG, "No data to be syncronized");
				}
				arrdata = null;
				return null;
		}
		
		 @Override
	     protected void onPostExecute(Void result) {
			 appr_ImbProvider = null;
		 }	 
    }
    private class SubmittedNegative extends AsyncTask<Void, Void,Void> {
		Appr_NegativeProvider qppr_NegativeProvider=new Appr_NegativeProvider();
		//Datatype_Appr_History_Workflow appr_history_workflow=new Datatype_Appr_History_Workflow();
		@Override
		protected Void doInBackground(Void... params) {
				ArrayList<Datatype_Appr_NegativeList> arrdata = qppr_NegativeProvider.getAllAppr_Negative(col_id);					
				if (arrdata.size() > 0){
					try {
						Gson gsondata=new Gson();
						
						ArrayList<DATA_RESPONSE> imbResponse = ServiceDataProvider.submitData_negative(gsondata.toJson(arrdata).toString());
						if (imbResponse != null){
							if (imbResponse.size() > 0){
								for (int i=0;i<imbResponse.size();i++ ){
									DATA_RESPONSE objRes= imbResponse.get(i);
									if (objRes.getSTATUS().equalsIgnoreCase(AppConstants.STATUSPROSPEKTRUE)){
										String id=objRes.getID();
										/*String prospekid = objRes.getID();
										Datatype_Appr_imb pd= appr_ImbProvider.getAllAppr_imb_by_id(id);
										pd.setPROSPEKID(prospekid);	
										pd.setISPENDINGUPLOADED(false);								
										try {
											followupDataProvider.updateProspekIdFollowUp(prospekid, id);
											prospekDataProvider.updateProspek(pd);
										} catch (Exception e) {
											Log.d(TAG, "Error Update Data: "+e.getMessage());
										}*/
									}
								}	
							}			
						}
						else{
							//Log.d(TAG, "Send Data To Server Via Service: Server returned null");
						}
					} catch (Exception e) {
						Log.d("Error", "Send Data To Server Via Service: Exception ->"+e.getMessage());
					}
				}
				else{
					//Log.d(TAG, "No data to be syncronized");
				}
				arrdata = null;
				return null;
		}
		
		 @Override
	     protected void onPostExecute(Void result) {
			 qppr_NegativeProvider = null;
		 }	 
    }
    private class SubmittedRtbPembanding extends AsyncTask<Void, Void,Void> {
		Appr_Rtb_Pembanding appr_Rtb_Pembanding=new Appr_Rtb_Pembanding();
		//Datatype_Appr_History_Workflow appr_history_workflow=new Datatype_Appr_History_Workflow();
		@Override
		protected Void doInBackground(Void... params) {
				ArrayList<Datatype_Appr_Rtb_Pembanding_Int> arrdata = appr_Rtb_Pembanding.getAllAppr_Rtb_Pembanding(col_id);					
				if (arrdata.size() > 0){
					try {
						Gson gsondata=new Gson();
						
						ArrayList<DATA_RESPONSE> Response = ServiceDataProvider.submitData_rtb_pembanding(gsondata.toJson(arrdata).toString());
						if (Response != null){
							if (Response.size() > 0){
								for (int i=0;i<Response.size();i++ ){
									DATA_RESPONSE objRes= Response.get(i);
									if (objRes.getSTATUS().equalsIgnoreCase(AppConstants.STATUSPROSPEKTRUE)){
										String id=objRes.getID();
										/*String prospekid = objRes.getID();
										Datatype_Appr_imb pd= appr_ImbProvider.getAllAppr_imb_by_id(id);
										pd.setPROSPEKID(prospekid);	
										pd.setISPENDINGUPLOADED(false);								
										try {
											followupDataProvider.updateProspekIdFollowUp(prospekid, id);
											prospekDataProvider.updateProspek(pd);
										} catch (Exception e) {
											Log.d(TAG, "Error Update Data: "+e.getMessage());
										}*/
									}
								}	
							}			
						}
						else{
							//Log.d(TAG, "Send Data To Server Via Service: Server returned null");
						}
					} catch (Exception e) {
						Log.d("Error", "Send Data To Server Via Service: Exception ->"+e.getMessage());
					}
				}
				else{
					//Log.d(TAG, "No data to be syncronized");
				}
				arrdata = null;
				return null;
		}
		
		 @Override
	     protected void onPostExecute(Void result) {
			 appr_Rtb_Pembanding = null;
		 }	 
    }
    private class SubmittedVhcPembanding extends AsyncTask<Void, Void,Void> {
		Appr_Vhc_Pembanding appr_Vhc_Pembanding=new Appr_Vhc_Pembanding();
		//Datatype_Appr_History_Workflow appr_history_workflow=new Datatype_Appr_History_Workflow();
		@Override
		protected Void doInBackground(Void... params) {
				ArrayList<Datatype_Appr_Vhc_Pembanding_Int> arrdata = appr_Vhc_Pembanding.getAllAppr_Vhc_Pembanding(col_id);					
				if (arrdata.size() > 0){
					try {
						Gson gsondata=new Gson();
						
						ArrayList<DATA_RESPONSE> Response = ServiceDataProvider.submitData_vhc_pembanding(gsondata.toJson(arrdata).toString());
						if (Response != null){
							if (Response.size() > 0){
								for (int i=0;i<Response.size();i++ ){
									DATA_RESPONSE objRes= Response.get(i);
									if (objRes.getSTATUS().equalsIgnoreCase(AppConstants.STATUSPROSPEKTRUE)){
										String id=objRes.getID();
										/*String prospekid = objRes.getID();
										Datatype_Appr_imb pd= appr_ImbProvider.getAllAppr_imb_by_id(id);
										pd.setPROSPEKID(prospekid);	
										pd.setISPENDINGUPLOADED(false);								
										try {
											followupDataProvider.updateProspekIdFollowUp(prospekid, id);
											prospekDataProvider.updateProspek(pd);
										} catch (Exception e) {
											Log.d(TAG, "Error Update Data: "+e.getMessage());
										}*/
									}
								}	
							}			
						}
						else{
							//Log.d(TAG, "Send Data To Server Via Service: Server returned null");
						}
					} catch (Exception e) {
						Log.d("Error", "Send Data To Server Via Service: Exception ->"+e.getMessage());
					}
				}
				else{
					//Log.d(TAG, "No data to be syncronized");
				}
				arrdata = null;
				return null;
		}
		
		 @Override
	     protected void onPostExecute(Void result) {
			 appr_Vhc_Pembanding = null;
		 }	 
    }
    private class SubmittedDokumen extends AsyncTask<Void, Void,Void> {
  		Appr_DokumentDataProvider appr_DokumentDataProvider=new Appr_DokumentDataProvider();
  		//Datatype_Appr_History_Workflow appr_history_workflow=new Datatype_Appr_History_Workflow();
  		@Override
  		protected Void doInBackground(Void... params) {
  				ArrayList<Datatype_Appr_Dokument> arrdata = appr_DokumentDataProvider.getAllAppr_dokument(ap_regno);					
  				if (arrdata.size() > 0){
  					try {
  						Gson gsondata=new Gson();
  						
  						ArrayList<DATA_RESPONSE> Response = ServiceDataProvider.submitData_dokumen(gsondata.toJson(arrdata).toString());
  						if (Response != null){
  							if (Response.size() > 0){
  								for (int i=0;i<Response.size();i++ ){
  									DATA_RESPONSE objRes= Response.get(i);
  									if (objRes.getSTATUS().equalsIgnoreCase(AppConstants.STATUSPROSPEKTRUE)){
  										String id=objRes.getID();
  									
  									}
  								}	
  							}			
  						}
  						else{
  							//Log.d(TAG, "Send Data To Server Via Service: Server returned null");
  						}
  					} catch (Exception e) {
  						Log.d("Error", "Send Data To Server Via Service: Exception ->"+e.getMessage());
  					}
  				}
  				else{
  					//Log.d(TAG, "No data to be syncronized");
  				}
  				arrdata = null;
  				return null;
  		}
  		
  		 @Override
  	     protected void onPostExecute(Void result) {
  			appr_DokumentDataProvider = null;
  		 }	 
      }
    private class SubmittedRtbBangunan extends AsyncTask<Void, Void,Void> {
		Appr_Val_BangunanDataProvider appr_Val_BangunanDataProvider=new Appr_Val_BangunanDataProvider();
		//Datatype_Appr_History_Workflow appr_history_workflow=new Datatype_Appr_History_Workflow();
		@Override
		protected Void doInBackground(Void... params) {
				ArrayList<Datatype_Appr_valBangunan> arrdata = appr_Val_BangunanDataProvider.getAllAppr_Bangunan(col_id);					
				if (arrdata.size() > 0){
					try {
						Gson gsondata=new Gson();
						
						ArrayList<DATA_RESPONSE> Response = ServiceDataProvider.submitData_valbangunan(gsondata.toJson(arrdata).toString());
						if (Response != null){
							if (Response.size() > 0){
								for (int i=0;i<Response.size();i++ ){
									DATA_RESPONSE objRes= Response.get(i);
									if (objRes.getSTATUS().equalsIgnoreCase(AppConstants.STATUSPROSPEKTRUE)){
										String id=objRes.getID();
										/*String prospekid = objRes.getID();
										Datatype_Appr_imb pd= appr_ImbProvider.getAllAppr_imb_by_id(id);
										pd.setPROSPEKID(prospekid);	
										pd.setISPENDINGUPLOADED(false);								
										try {
											followupDataProvider.updateProspekIdFollowUp(prospekid, id);
											prospekDataProvider.updateProspek(pd);
										} catch (Exception e) {
											Log.d(TAG, "Error Update Data: "+e.getMessage());
										}*/
									}
								}	
							}			
						}
						else{
							//Log.d(TAG, "Send Data To Server Via Service: Server returned null");
						}
					} catch (Exception e) {
						Log.d("Error", "Send Data To Server Via Service: Exception ->"+e.getMessage());
					}
				}
				else{
					//Log.d(TAG, "No data to be syncronized");
				}
				arrdata = null;
				return null;
		}
		
		 @Override
	     protected void onPostExecute(Void result) {
			 appr_Val_BangunanDataProvider = null;
		 }	 
    }
    private class SubmittedRtbValuation extends AsyncTask<Void, Void,Void> {
  		Appr_Rtb_ValuationDataProvider appr_Rtb_ValuationDataProvider=new Appr_Rtb_ValuationDataProvider();
  		//Datatype_Appr_History_Workflow appr_history_workflow=new Datatype_Appr_History_Workflow();
  		@Override
  		protected Void doInBackground(Void... params) {
  				Datatype_Appr_Rtb_Valuation_Int arrdata = appr_Rtb_ValuationDataProvider.getAllAppr_Rtb_Valuation_Int(col_id);					
  				if (arrdata.COL_ID.length()>0){
  					try {
  						Gson gsondata=new Gson();
  						
  						DATA_RESPONSE Response = ServiceDataProvider.submitData_rtb_valuation(gsondata.toJson(arrdata).toString());
  						if (Response != null){
  							if (Response.getCOL_ID().length() > 0){
  								//for (int i=0;i<Response.size();i++ ){
  									DATA_RESPONSE objRes= Response;
  									if (objRes.getSTATUS().equalsIgnoreCase(AppConstants.STATUSPROSPEKTRUE)){
  										String id=objRes.getID();
  										/*String prospekid = objRes.getID();
  										Datatype_Appr_imb pd= appr_ImbProvider.getAllAppr_imb_by_id(id);
  										pd.setPROSPEKID(prospekid);	
  										pd.setISPENDINGUPLOADED(false);								
  										try {
  											followupDataProvider.updateProspekIdFollowUp(prospekid, id);
  											prospekDataProvider.updateProspek(pd);
  										} catch (Exception e) {
  											Log.d(TAG, "Error Update Data: "+e.getMessage());
  										}*/
  									}
  								//}	
  							}			
  						}
  						else{
  							//Log.d(TAG, "Send Data To Server Via Service: Server returned null");
  						}
  					} catch (Exception e) {
  						Log.d("Error", "Send Data To Server Via Service: Exception ->"+e.getMessage());
  					}
  				}
  				else{
  					//Log.d(TAG, "No data to be syncronized");
  				}
  				arrdata = null;
  				return null;
  		}
  		
  		 @Override
  	     protected void onPostExecute(Void result) {
  			appr_Rtb_ValuationDataProvider = null;
  		 }	 
      }
    private class SubmittedRtbData extends AsyncTask<Void, Void,Void> {
  		Appr_Rtb_DataDataProvider appr_Rtb_DataDataProvider=new Appr_Rtb_DataDataProvider();
  		//Datatype_Appr_History_Workflow appr_history_workflow=new Datatype_Appr_History_Workflow();
  		@Override
  		protected Void doInBackground(Void... params) {
  				Datatype_Appr_Rtb_Data_Int arrdata = appr_Rtb_DataDataProvider.getAllAppr_Rtb_Data_Int(col_id);					
  				if (arrdata.COL_ID.length()>0){
  					try {
  						Gson gsondata=new Gson();
  						
  						DATA_RESPONSE Response = ServiceDataProvider.submitData_rtb_data(gsondata.toJson(arrdata).toString());
  						if (Response != null){
  							if (Response.getCOL_ID().length() > 0){
  								//for (int i=0;i<Response.size();i++ ){
  									DATA_RESPONSE objRes= Response;
  									if (objRes.getSTATUS().equalsIgnoreCase(AppConstants.STATUSPROSPEKTRUE)){
  										String id=objRes.getID();
  										/*String prospekid = objRes.getID();
  										Datatype_Appr_imb pd= appr_ImbProvider.getAllAppr_imb_by_id(id);
  										pd.setPROSPEKID(prospekid);	
  										pd.setISPENDINGUPLOADED(false);								
  										try {
  											followupDataProvider.updateProspekIdFollowUp(prospekid, id);
  											prospekDataProvider.updateProspek(pd);
  										} catch (Exception e) {
  											Log.d(TAG, "Error Update Data: "+e.getMessage());
  										}*/
  									}
  								//}	
  							}			
  						}
  						else{
  							//Log.d(TAG, "Send Data To Server Via Service: Server returned null");
  						}
  					} catch (Exception e) {
  						Log.d("Error", "Send Data To Server Via Service: Exception ->"+e.getMessage());
  					}
  				}
  				else{
  					//Log.d(TAG, "No data to be syncronized");
  				}
  				arrdata = null;
  				return null;
  		}
  		
  		 @Override
  	     protected void onPostExecute(Void result) {
  			appr_Rtb_DataDataProvider = null;
  		 }	 
      }
    private class SubmittedRtbDetail extends AsyncTask<Void, Void,Void> {
  		Appr_Rtb_DetailProvider appr_Rtb_DetailProvider=new Appr_Rtb_DetailProvider();
  		//Datatype_Appr_History_Workflow appr_history_workflow=new Datatype_Appr_History_Workflow();
  		@Override
  		protected Void doInBackground(Void... params) {
  				Datatype_Appr_Rtb_Detail_Int arrdata= appr_Rtb_DetailProvider.getAllAppr_Rtb_Detail(col_id);					
  				if (arrdata.AP_REGNO.length()>0){
  					try {
  						Gson gsondata=new Gson();
  						
  						DATA_RESPONSE Response = ServiceDataProvider.submitData_rtb_detil(gsondata.toJson(arrdata).toString());
  						if (Response != null){
  							if (Response.getCOL_ID().length() > 0){
  								//for (int i=0;i<Response.size();i++ ){
  									DATA_RESPONSE objRes= Response;
  									if (objRes.getSTATUS().equalsIgnoreCase(AppConstants.STATUSPROSPEKTRUE)){
  										String id=objRes.getID();
  										/*String prospekid = objRes.getID();
  										Datatype_Appr_imb pd= appr_ImbProvider.getAllAppr_imb_by_id(id);
  										pd.setPROSPEKID(prospekid);	
  										pd.setISPENDINGUPLOADED(false);								
  										try {
  											followupDataProvider.updateProspekIdFollowUp(prospekid, id);
  											prospekDataProvider.updateProspek(pd);
  										} catch (Exception e) {
  											Log.d(TAG, "Error Update Data: "+e.getMessage());
  										}*/
  									}
  								//}	
  							}			
  						}
  						else{
  							//Log.d(TAG, "Send Data To Server Via Service: Server returned null");
  						}
  					} catch (Exception e) {
  						Log.d("Error", "Send Data To Server Via Service: Exception ->"+e.getMessage());
  					}
  				}
  				else{
  					//Log.d(TAG, "No data to be syncronized");
  				}
  				arrdata = null;
  				return null;
  		}
  		
  		 @Override
  	     protected void onPostExecute(Void result) {
  			appr_Rtb_DetailProvider = null;
  		 }	 
      }
    private class SubmittedRtbTataKota extends AsyncTask<Void, Void,Void> {
  		Appr_Cek_TataKota appr_Cek_TataKota=new Appr_Cek_TataKota();
  		//Datatype_Appr_History_Workflow appr_history_workflow=new Datatype_Appr_History_Workflow();
  		@Override
  		protected Void doInBackground(Void... params) {
  				Datatype_Appr_Rtb_Cek_Tata_Kota_Int arrdata= appr_Cek_TataKota.getAllAppr_Cek_TataKota_Int(col_id);					
  				if (arrdata.AP_REGNO.length()>0){
  					try {
  						Gson gsondata=new Gson();
  						
  						DATA_RESPONSE Response = ServiceDataProvider.submitData_rtb_tatakota(gsondata.toJson(arrdata).toString());
  						if (Response != null){
  							if (Response.getCOL_ID().length() > 0){
  								//for (int i=0;i<Response.size();i++ ){
  									DATA_RESPONSE objRes= Response;
  									if (objRes.getSTATUS().equalsIgnoreCase(AppConstants.STATUSPROSPEKTRUE)){
  										String id=objRes.getID();
  										/*String prospekid = objRes.getID();
  										Datatype_Appr_imb pd= appr_ImbProvider.getAllAppr_imb_by_id(id);
  										pd.setPROSPEKID(prospekid);	
  										pd.setISPENDINGUPLOADED(false);								
  										try {
  											followupDataProvider.updateProspekIdFollowUp(prospekid, id);
  											prospekDataProvider.updateProspek(pd);
  										} catch (Exception e) {
  											Log.d(TAG, "Error Update Data: "+e.getMessage());
  										}*/
  									}
  								//}	
  							}			
  						}
  						else{
  							//Log.d(TAG, "Send Data To Server Via Service: Server returned null");
  						}
  					} catch (Exception e) {
  						Log.d("Error", "Send Data To Server Via Service: Exception ->"+e.getMessage());
  					}
  				}
  				else{
  					//Log.d(TAG, "No data to be syncronized");
  				}
  				arrdata = null;
  				return null;
  		}
  		
  		 @Override
  	     protected void onPostExecute(Void result) {
  			appr_Cek_TataKota = null;
  		 }	 
      }
    private class SubmittedVhcValuation extends AsyncTask<Void, Void,Void> {
  		Appr_Vhc_ValuationDataProvider appr_Vhc_ValuationDataProvider=new Appr_Vhc_ValuationDataProvider();
  		//Datatype_Appr_History_Workflow appr_history_workflow=new Datatype_Appr_History_Workflow();
  		@Override
  		protected Void doInBackground(Void... params) {
  				Datatype_Appr_Vhc_Valuation_Int arrdata= appr_Vhc_ValuationDataProvider.getAllAppr_Vhc_Valuation_Int(col_id);					
  				if (arrdata.AP_REGNO.length()>0){
  					try {
  						Gson gsondata=new Gson();
  						
  						DATA_RESPONSE Response = ServiceDataProvider.submitData_vhc_valuation(gsondata.toJson(arrdata).toString());
  						if (Response != null){
  							if (Response.getCOL_ID().length() > 0){
  								//for (int i=0;i<Response.size();i++ ){
  									DATA_RESPONSE objRes= Response;
  									if (objRes.getSTATUS().equalsIgnoreCase(AppConstants.STATUSPROSPEKTRUE)){
  										String id=objRes.getID();
  										/*String prospekid = objRes.getID();
  										Datatype_Appr_imb pd= appr_ImbProvider.getAllAppr_imb_by_id(id);
  										pd.setPROSPEKID(prospekid);	
  										pd.setISPENDINGUPLOADED(false);								
  										try {
  											followupDataProvider.updateProspekIdFollowUp(prospekid, id);
  											prospekDataProvider.updateProspek(pd);
  										} catch (Exception e) {
  											Log.d(TAG, "Error Update Data: "+e.getMessage());
  										}*/
  									}
  								//}	
  							}			
  						}
  						else{
  							//Log.d(TAG, "Send Data To Server Via Service: Server returned null");
  						}
  					} catch (Exception e) {
  						Log.d("Error", "Send Data To Server Via Service: Exception ->"+e.getMessage());
  					}
  				}
  				else{
  					//Log.d(TAG, "No data to be syncronized");
  				}
  				arrdata = null;
  				return null;
  		}
  		
  		 @Override
  	     protected void onPostExecute(Void result) {
  			appr_Vhc_ValuationDataProvider = null;
  		 }	 
      }
    private class SubmittedVhcData extends AsyncTask<Void, Void,Void> {
  		Appr_Vhc_DataDataProvider appr_Vhc_DataDataProvider=new Appr_Vhc_DataDataProvider();
  		//Datatype_Appr_History_Workflow appr_history_workflow=new Datatype_Appr_History_Workflow();
  		@Override
  		protected Void doInBackground(Void... params) {
  				Datatype_Appr_Vch_Data_Int arrdata= appr_Vhc_DataDataProvider.getAllAppr_Vhc_Data_Int(col_id) ;					
  				if (arrdata.AP_REGNO.length()>0){
  					try {
  						Gson gsondata=new Gson();
  						
  						DATA_RESPONSE Response = ServiceDataProvider.submitData_vhc_data(gsondata.toJson(arrdata).toString());
  						if (Response != null){
  							if (Response.getCOL_ID().length() > 0){
  								//for (int i=0;i<Response.size();i++ ){
  									DATA_RESPONSE objRes= Response;
  									if (objRes.getSTATUS().equalsIgnoreCase(AppConstants.STATUSPROSPEKTRUE)){
  										String id=objRes.getID();
  										/*String prospekid = objRes.getID();
  										Datatype_Appr_imb pd= appr_ImbProvider.getAllAppr_imb_by_id(id);
  										pd.setPROSPEKID(prospekid);	
  										pd.setISPENDINGUPLOADED(false);								
  										try {
  											followupDataProvider.updateProspekIdFollowUp(prospekid, id);
  											prospekDataProvider.updateProspek(pd);
  										} catch (Exception e) {
  											Log.d(TAG, "Error Update Data: "+e.getMessage());
  										}*/
  									}
  								//}	
  							}			
  						}
  						else{
  							//Log.d(TAG, "Send Data To Server Via Service: Server returned null");
  						}
  					} catch (Exception e) {
  						Log.d("Error", "Send Data To Server Via Service: Exception ->"+e.getMessage());
  					}
  				}
  				else{
  					//Log.d(TAG, "No data to be syncronized");
  				}
  				arrdata = null;
  				return null;
  		}
  		
  		 @Override
  	     protected void onPostExecute(Void result) {
  			appr_Vhc_DataDataProvider = null;
  		 }	 
      }
    private class SubmittedMhcValuation extends AsyncTask<Void, Void,Void> {
  		Appr_Mch_ValuationDataProvider appr_Mch_ValuationDataProvider=new Appr_Mch_ValuationDataProvider();
  		//Datatype_Appr_History_Workflow appr_history_workflow=new Datatype_Appr_History_Workflow();
  		@Override
  		protected Void doInBackground(Void... params) {
  				Datatype_Appr_Mch_Valuation_Int arrdata= appr_Mch_ValuationDataProvider.getAllAppr_Mch_Valuation_Int(col_id) ;					
  				if (arrdata.AP_REGNO.length()>0){
  					try {
  						Gson gsondata=new Gson();
  						
  						DATA_RESPONSE Response = ServiceDataProvider.submitData_mhc_valuation(gsondata.toJson(arrdata).toString());
  						if (Response != null){
  							if (Response.getCOL_ID().length() > 0){
  								//for (int i=0;i<Response.size();i++ ){
  									DATA_RESPONSE objRes= Response;
  									if (objRes.getSTATUS().equalsIgnoreCase(AppConstants.STATUSPROSPEKTRUE)){
  										String id=objRes.getID();
  										/*String prospekid = objRes.getID();
  										Datatype_Appr_imb pd= appr_ImbProvider.getAllAppr_imb_by_id(id);
  										pd.setPROSPEKID(prospekid);	
  										pd.setISPENDINGUPLOADED(false);								
  										try {
  											followupDataProvider.updateProspekIdFollowUp(prospekid, id);
  											prospekDataProvider.updateProspek(pd);
  										} catch (Exception e) {
  											Log.d(TAG, "Error Update Data: "+e.getMessage());
  										}*/
  									}
  								//}	
  							}			
  						}
  						else{
  							//Log.d(TAG, "Send Data To Server Via Service: Server returned null");
  						}
  					} catch (Exception e) {
  						Log.d("Error", "Send Data To Server Via Service: Exception ->"+e.getMessage());
  					}
  				}
  				else{
  					//Log.d(TAG, "No data to be syncronized");
  				}
  				arrdata = null;
  				return null;
  		}
  		
  		 @Override
  	     protected void onPostExecute(Void result) {
  			appr_Mch_ValuationDataProvider = null;
  		 }	 
      }
    private class SubmittedPbValuation extends AsyncTask<Void, Void,Void> {
  		Appr_PB_ValuationDataProvider appr_PB_ValuationDataProvider=new Appr_PB_ValuationDataProvider();
  		//Datatype_Appr_History_Workflow appr_history_workflow=new Datatype_Appr_History_Workflow();
  		@Override
  		protected Void doInBackground(Void... params) {
  				Datatype_Appr_Pb_Valuation_Int arrdata= appr_PB_ValuationDataProvider.getAllAppr_Pb_Valuation_Int(col_id) ;					
  				if (arrdata.AP_REGNO.length()>0){
  					try {
  						Gson gsondata=new Gson();
  						
  						DATA_RESPONSE Response = ServiceDataProvider.submitData_pb_valuation(gsondata.toJson(arrdata).toString());
  						if (Response != null){
  							if (Response.getCOL_ID().length() > 0){
  								//for (int i=0;i<Response.size();i++ ){
  									DATA_RESPONSE objRes= Response;
  									if (objRes.getSTATUS().equalsIgnoreCase(AppConstants.STATUSPROSPEKTRUE)){
  										String id=objRes.getID();
  										/*String prospekid = objRes.getID();
  										Datatype_Appr_imb pd= appr_ImbProvider.getAllAppr_imb_by_id(id);
  										pd.setPROSPEKID(prospekid);	
  										pd.setISPENDINGUPLOADED(false);								
  										try {
  											followupDataProvider.updateProspekIdFollowUp(prospekid, id);
  											prospekDataProvider.updateProspek(pd);
  										} catch (Exception e) {
  											Log.d(TAG, "Error Update Data: "+e.getMessage());
  										}*/
  									}
  								//}	
  							}			
  						}
  						else{
  							//Log.d(TAG, "Send Data To Server Via Service: Server returned null");
  						}
  					} catch (Exception e) {
  						Log.d("Error", "Send Data To Server Via Service: Exception ->"+e.getMessage());
  					}
  				}
  				else{
  					//Log.d(TAG, "No data to be syncronized");
  				}
  				arrdata = null;
  				return null;
  		}
  		
  		 @Override
  	     protected void onPostExecute(Void result) {
  			appr_PB_ValuationDataProvider = null;
  		 }	 
      }
    private class SubmittedProgressbangunan extends AsyncTask<Void, Void,Void> {
  		Appr_Rtb_Progress_BangunanDataProvider appr_Rtb_Progress_BangunanDataProvider=new Appr_Rtb_Progress_BangunanDataProvider();
  		//Datatype_Appr_History_Workflow appr_history_workflow=new Datatype_Appr_History_Workflow();
  		@Override
  		protected Void doInBackground(Void... params) {
  				Datatype_Appr_Progress_Bangunan_Int arrdata= appr_Rtb_Progress_BangunanDataProvider.getAllAppr_Rtb_Progress_Int(col_id) ;					
  				if (arrdata.AP_REGNO.length()>0){
  					try {
  						Gson gsondata=new Gson();
  						
  						DATA_RESPONSE Response = ServiceDataProvider.submitData_progress_bangunan(gsondata.toJson(arrdata).toString());
  						if (Response != null){
  							if (Response.getCOL_ID().length() > 0){
  								//for (int i=0;i<Response.size();i++ ){
  									DATA_RESPONSE objRes= Response;
  									if (objRes.getSTATUS().equalsIgnoreCase(AppConstants.STATUSPROSPEKTRUE)){
  										String id=objRes.getID();
  										/*String prospekid = objRes.getID();
  										Datatype_Appr_imb pd= appr_ImbProvider.getAllAppr_imb_by_id(id);
  										pd.setPROSPEKID(prospekid);	
  										pd.setISPENDINGUPLOADED(false);								
  										try {
  											followupDataProvider.updateProspekIdFollowUp(prospekid, id);
  											prospekDataProvider.updateProspek(pd);
  										} catch (Exception e) {
  											Log.d(TAG, "Error Update Data: "+e.getMessage());
  										}*/
  									}
  								//}	
  							}			
  						}
  						else{
  							//Log.d(TAG, "Send Data To Server Via Service: Server returned null");
  						}
  					} catch (Exception e) {
  						Log.d("Error", "Send Data To Server Via Service: Exception ->"+e.getMessage());
  					}
  				}
  				else{
  					//Log.d(TAG, "No data to be syncronized");
  				}
  				arrdata = null;
  				return null;
  		}
  		
  		 @Override
  	     protected void onPostExecute(Void result) {
  			appr_Rtb_Progress_BangunanDataProvider = null;
  		 }	 
      }
    private class SubmittedProgressdeveloper extends AsyncTask<Void, Void,Void> {
  		Appr_Rtb_Progress_DeveloperDataProvider appr_Rtb_Progress_DeveloperDataProvider=new Appr_Rtb_Progress_DeveloperDataProvider();
  		//Datatype_Appr_History_Workflow appr_history_workflow=new Datatype_Appr_History_Workflow();
  		@Override
  		protected Void doInBackground(Void... params) {
  				Datatype_Appr_Progress_Developer_Int arrdata= appr_Rtb_Progress_DeveloperDataProvider.getAllAppr_Rtb_Progress_Int(col_id) ;					
  				if (arrdata.AP_REGNO.length()>0){
  					try {
  						Gson gsondata=new Gson();
  						
  						DATA_RESPONSE Response = ServiceDataProvider.submitData_progress_developer(gsondata.toJson(arrdata).toString());
  						if (Response != null){
  							if (Response.getCOL_ID().length() > 0){
  								//for (int i=0;i<Response.size();i++ ){
  									DATA_RESPONSE objRes= Response;
  									if (objRes.getSTATUS().equalsIgnoreCase(AppConstants.STATUSPROSPEKTRUE)){
  										String id=objRes.getID();
  										/*String prospekid = objRes.getID();
  										Datatype_Appr_imb pd= appr_ImbProvider.getAllAppr_imb_by_id(id);
  										pd.setPROSPEKID(prospekid);	
  										pd.setISPENDINGUPLOADED(false);								
  										try {
  											followupDataProvider.updateProspekIdFollowUp(prospekid, id);
  											prospekDataProvider.updateProspek(pd);
  										} catch (Exception e) {
  											Log.d(TAG, "Error Update Data: "+e.getMessage());
  										}*/
  									}
  								//}	
  							}			
  						}
  						else{
  							//Log.d(TAG, "Send Data To Server Via Service: Server returned null");
  						}
  					} catch (Exception e) {
  						Log.d("Error", "Send Data To Server Via Service: Exception ->"+e.getMessage());
  					}
  				}
  				else{
  					//Log.d(TAG, "No data to be syncronized");
  				}
  				arrdata = null;
  				return null;
  		}
  		
  		 @Override
  	     protected void onPostExecute(Void result) {
  			appr_Rtb_Progress_DeveloperDataProvider = null;
  		 }	 
      }
    private class SubmittedPhoto extends AsyncTask<Void, Void,Void> {
  		PhotoDataProvider photoDataProvider=new PhotoDataProvider();
  		//Datatype_Appr_History_Workflow appr_history_workflow=new Datatype_Appr_History_Workflow();
  		@Override
  		protected Void doInBackground(Void... params) {
  				ArrayList<PhotoData> arrdata = photoDataProvider.getATTACHMENTByProspek(ap_regno) ;
				if (arrdata.size() > 0){
					try {
						Gson gsondata=new Gson();
						 for (int i = 0; i < arrdata.size(); i++) {
							 ArrayList<NameValuePair> params1 = new ArrayList<NameValuePair>();
							 params1.add(new BasicNameValuePair("COL_ID", arrdata.get(i).getCOL_ID().toString()));
							 params1.add(new BasicNameValuePair("ID", arrdata.get(i).getID().toString()));
							 params1.add(new BasicNameValuePair("AP_REGNO", arrdata.get(i).getAP_REGNO().toString()));
							 params1.add(new BasicNameValuePair("ATTACH_ID", arrdata.get(i).getATTACH_ID().toString()));
							 params1.add(new BasicNameValuePair("ATTACH_SEQ", arrdata.get(i).getATTACH_SEQ().toString()));
							 params1.add(new BasicNameValuePair("FILEFOLDER", arrdata.get(i).getFILEFOLDER().toString()));
							 params1.add(new BasicNameValuePair("FILENAME", arrdata.get(i).getFILENAME().toString()));
							 params1.add(new BasicNameValuePair("FILETYPE", arrdata.get(i).getFILETYPE().toString()));
							 params1.add(new BasicNameValuePair("FILESIZE", arrdata.get(i).getFILESIZE().toString()));
							 params1.add(new BasicNameValuePair("UPLOADBY", arrdata.get(i).getUPLOADBY().toString()));
							 try{
								 params1.add(new BasicNameValuePair("UPLOADDATE", DataConverter.dateTimeToString(arrdata.get(i).getUPLOADDATE())));
							 }
							 catch(Exception ex)
							 {
								 params1.add(new BasicNameValuePair("UPLOADDATE", ""));
							 }
							 params1.add(new BasicNameValuePair("ATTACH_TYPE", arrdata.get(i).getATTACH_TYPE().toString()));
							 params1.add(new BasicNameValuePair("ATTACH_TYPE_CODE", arrdata.get(i).getATTACH_TYPE_CODE().toString()));
	
	                         PHOTORESPONSE photoResponse = ServiceDataProvider.uploadProspekPhoto(params1, arrdata.get(i).getFILENAME());
	                         if (photoResponse != null) {
	                           /*  if (photoResponse.getFILENAME().equalsIgnoreCase(arrdata.get(i).getFILENAME())) {
	                                 listphoto.get(i).setISALREADYUPLOADEDTOSERVER(true);
	                             } else {
	                                 listphoto.get(i).setISPENDINGUPLOADED(true);
	                             }
	                             photoDataProvider.updatePhoto(listphoto.get(i));*/
	                         }	
						 }
					} catch (Exception e) {
						Log.d("Error", "Send Data To Server Via Service: Exception ->"+e.getMessage());
					}
				}
				else{
					//Log.d(TAG, "No data to be syncronized");
				}
				arrdata = null;
				return null;
  		}
  		
  		 @Override
  	     protected void onPostExecute(Void result) {
  			photoDataProvider = null;
  		 }	 
      }
   
 private class UpdateStatus extends AsyncTask<Void, Void,Void> {
  		//Appr_Rtb_Progress_DeveloperDataProvider appr_Rtb_Progress_DeveloperDataProvider=new Appr_Rtb_Progress_DeveloperDataProvider();
  		//Datatype_Appr_History_Workflow appr_history_workflow=new Datatype_Appr_History_Workflow();
  		@Override
  		protected Void doInBackground(Void... params) {
  			Datatype_Appr_update arrdata= new Datatype_Appr_update() ;					
  				//if (arrdata.AP_REGNO.length()>0){
  					try {
  						Gson gsondata=new Gson();
  						arrdata.setAP_REGNO(ap_regno);
  						arrdata.setCOL_ID(col_id);
  						arrdata.setUSERID(userDetail.getUSERID());
  						arrdata.setATC_REQUEST("1");
  						SERVICEDATARESPONSE Response = ServiceDataProvider.UpdateStatus(gsondata.toJson(arrdata).toString());
  						if (Response != null){
  							if (Response.getStatus()== 0){
  								
  							}			
  						}
  						else{
  							//Log.d(TAG, "Send Data To Server Via Service: Server returned null");
  						}
  					} catch (Exception e) {
  						Log.d("Error", "Send Data To Server Via Service: Exception ->"+e.getMessage());
  					}
  				//}
  				//else{
  				//	//Log.d(TAG, "No data to be syncronized");
  				//}
  				arrdata = null;
  				return null;
  		}
  		
  		 @Override
  	     protected void onPostExecute(Void result) {
  			
  		 }	 
      }
   
    
    private class UpdateBackStaff extends AsyncTask<Void, Void,Void> {
  		//Appr_Rtb_Progress_DeveloperDataProvider appr_Rtb_Progress_DeveloperDataProvider=new Appr_Rtb_Progress_DeveloperDataProvider();
  		//Datatype_Appr_History_Workflow appr_history_workflow=new Datatype_Appr_History_Workflow();
  		@Override
  		protected Void doInBackground(Void... params) {
  			Datatype_Appr_update arrdata= new Datatype_Appr_update() ;					
  				//if (arrdata.AP_REGNO.length()>0){
  					try {
  						Gson gsondata=new Gson();
  						arrdata.setAP_REGNO(ap_regno);
  						arrdata.setCOL_ID(col_id);
  						arrdata.setUSERID(userDetail.getUSERID());
  						arrdata.setATC_REQUEST("21");
  						SERVICEDATARESPONSE Response = ServiceDataProvider.UpdateStatus(gsondata.toJson(arrdata).toString());
  						if (Response != null){
  							if (Response.getStatus()== 0){
  							
  							}			
  						}
  						else{
  							//Log.d(TAG, "Send Data To Server Via Service: Server returned null");
  						}
  					} catch (Exception e) {
  						Log.d("Error", "Send Data To Server Via Service: Exception ->"+e.getMessage());
  					}
  				//}
  				//else{
  				//	//Log.d(TAG, "No data to be syncronized");
  				//}
  				arrdata = null;
  				return null;
  		}
  		
  		 @Override
  	     protected void onPostExecute(Void result) {
  			
  		 }	 
      }
   
    private class UpdatePending extends AsyncTask<Void, Void,Void> {
  		//Appr_Rtb_Progress_DeveloperDataProvider appr_Rtb_Progress_DeveloperDataProvider=new Appr_Rtb_Progress_DeveloperDataProvider();
  		//Datatype_Appr_History_Workflow appr_history_workflow=new Datatype_Appr_History_Workflow();
  		@Override
  		protected Void doInBackground(Void... params) {
  			Datatype_Appr_update arrdata= new Datatype_Appr_update() ;					
  				//if (arrdata.AP_REGNO.length()>0){
  					try {
  						Gson gsondata=new Gson();
  						arrdata.setAP_REGNO(ap_regno);
  						arrdata.setCOL_ID(col_id);
  						arrdata.setUSERID(userDetail.getUSERID());
  						arrdata.setATC_REQUEST("24");
  						SERVICEDATARESPONSE Response = ServiceDataProvider.UpdateStatus(gsondata.toJson(arrdata).toString());
  						if (Response != null){
  							if (Response.getStatus()== 0){
  								listdata=appr_Inbox.getAllAppr_Inboxbyid(col_id);
  								listdata.PENDINGSTATUS="Pending";
  								appr_Inbox.updateData(listdata);
  								Intent i = new Intent(MainActivity.this, InboxActivity.class);   
  						    	startActivity(i);
  							}			
  						}
  						else{
  							//Log.d(TAG, "Send Data To Server Via Service: Server returned null");
  						}
  					} catch (Exception e) {
  						Log.d("Error", "Send Data To Server Via Service: Exception ->"+e.getMessage());
  					}
  				//}
  				//else{
  				//	//Log.d(TAG, "No data to be syncronized");
  				//}
  				arrdata = null;
  				return null;
  		}
  		
  		 @Override
  	     protected void onPostExecute(Void result) {
  			
  		 }	 
      }
   
    private class UpdateUnPending extends AsyncTask<Void, Void,Void> {
  		//Appr_Rtb_Progress_DeveloperDataProvider appr_Rtb_Progress_DeveloperDataProvider=new Appr_Rtb_Progress_DeveloperDataProvider();
  		//Datatype_Appr_History_Workflow appr_history_workflow=new Datatype_Appr_History_Workflow();
  		@Override
  		protected Void doInBackground(Void... params) {
  			Datatype_Appr_update arrdata= new Datatype_Appr_update() ;					
  				//if (arrdata.AP_REGNO.length()>0){
  					try {
  						Gson gsondata=new Gson();
  						arrdata.setAP_REGNO(ap_regno);
  						arrdata.setCOL_ID(col_id);
  						arrdata.setUSERID(userDetail.getUSERID());
  						arrdata.setATC_REQUEST("5");
  						SERVICEDATARESPONSE Response = ServiceDataProvider.UpdateStatus(gsondata.toJson(arrdata).toString());
  						if (Response != null){
  							if (Response.getStatus()== 0){
  								listdata=appr_Inbox.getAllAppr_Inboxbyid(col_id);
  								listdata.PENDINGSTATUS="";
  								appr_Inbox.updateData(listdata);
  								Intent i = new Intent(MainActivity.this, InboxActivity.class);   
  						    	startActivity(i);
  							}			
  						}
  						else{
  							//Log.d(TAG, "Send Data To Server Via Service: Server returned null");
  						}
  					} catch (Exception e) {
  						Log.d("Error", "Send Data To Server Via Service: Exception ->"+e.getMessage());
  					}
  				//}
  				//else{
  				//	//Log.d(TAG, "No data to be syncronized");
  				//}
  				arrdata = null;
  				return null;
  		}
  		
  		 @Override
  	     protected void onPostExecute(Void result) {
  			
  		 }	 
      }
   
    public static String replaceNull(String input) {
    	  return input == null ? "" : input;
    	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		String xx="1221";
		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
	private Boolean cekMandatoryByType(){
	 boolean retval=true;
	if(col_type.equals("RE")){
		
		if(CekMandatoryValTanah().equals(false) || 	CekMandatoryDataTanah().equals(false) || CekMandatoryDetail().equals(false))
				retval =false;
    }
    if(col_type.equals("MCH")){
    	if(CekMandatoryValMesin().equals(false))
    		retval =false;
    }
    if(col_type.equals("VEH")){
    	if(CekMandatoryValKendaraan().equals(false) || CekMandatoryDataKendaraan().equals(false))
    		retval =false;
    }
    if(col_type.equals("STK")){
    	if(CekMandatoryValPersediaan().equals(false))
    		retval =false;
    }
    if(col_class.equals("001")){
        if(appraise_type.equals("D")){
        	if(CekMandatoryProgDeveloper().equals(false))
        		retval =false;
        }
        if(appraise_type.equals("K")){
        	if(CekMandatoryProgBangunan().equals(false))
        		retval =false;
        }
    }
    return retval;
}
	private Boolean CekMandatoryValTanah(){
  	  boolean retval=true;
  	  appr_rtb_valuation_int=appr_Rtb_ValuationDataProvider.getAllAppr_Rtb_Valuation_Int(col_id);
    	if(appr_rtb_valuation_int.COL_ID!=null){
    		if(appr_rtb_valuation_int.APPR_JNSPENILAIAN==null || appr_rtb_valuation_int.APPR_JNSPENILAIAN.equals(""))
    			retval=false;
    		if(appr_rtb_valuation_int.REPORT_DATE==null || appr_rtb_valuation_int.REPORT_DATE.equals(""))
    			retval=false;
    		if(appr_rtb_valuation_int.REPORT_INSPECT_DATE==null || appr_rtb_valuation_int.REPORT_DATE.equals(""))
    			retval=false;
    		if(appr_rtb_valuation_int.APPR_CPNAME==null || appr_rtb_valuation_int.APPR_CPNAME.equals(""))
    			retval=false;
    		if(appr_rtb_valuation_int.APPR_CPHP==null || appr_rtb_valuation_int.APPR_CPHP.equals(""))
    			retval=false;
    		
    		if(appr_rtb_valuation_int.APPR_CPPHONE==null || appr_rtb_valuation_int.APPR_CPPHONE.equals(""))
    			retval=false;
    		if(appr_rtb_valuation_int.COL_APPRAISER_CODE==null || appr_rtb_valuation_int.COL_APPRAISER_CODE.equals(""))
    			retval=false;
    		if(appr_rtb_valuation_int.LAND_AREA==null || appr_rtb_valuation_int.LAND_AREA.equals(""))
    			retval=false;
    		if(appr_rtb_valuation_int.LAND_PERMETER_VALUE==null || appr_rtb_valuation_int.LAND_PERMETER_VALUE.equals(""))
    			retval=false;
    		if(appr_rtb_valuation_int.LAND_MARKET_VALUE==null || appr_rtb_valuation_int.LAND_MARKET_VALUE.equals(""))
    			retval=false;
    		if(appr_rtb_valuation_int.LAND_LIQ_PCT==null || appr_rtb_valuation_int.LAND_LIQ_PCT.equals(""))
    			retval=false;
    		if(appr_rtb_valuation_int.LAND_LIQ_VALUE==null || appr_rtb_valuation_int.LAND_LIQ_VALUE.equals(""))
    			retval=false;
    		if(appr_rtb_valuation_int.BUILD_MARKET_VALUE_FISIK_TOTAL==null || appr_rtb_valuation_int.BUILD_MARKET_VALUE_FISIK_TOTAL.equals(""))
    			retval=false;
    		if(appr_rtb_valuation_int.BUILD_LIQ_VALUE_FISIK_TOTAL==null || appr_rtb_valuation_int.BUILD_LIQ_VALUE_FISIK_TOTAL.equals(""))
    			retval=false;
    		if(appr_rtb_valuation_int.TOTAL_LIQ_VALUE_FISIK==null || appr_rtb_valuation_int.TOTAL_LIQ_VALUE_FISIK.equals(""))
    			retval=false;
    		if(appr_rtb_valuation_int.BUILD_ASURANSI_MARKET==null || appr_rtb_valuation_int.BUILD_ASURANSI_MARKET.equals(""))
    			retval=false;
    		if(appr_rtb_valuation_int.UNIT_MARKET_VALUE==null || appr_rtb_valuation_int.UNIT_MARKET_VALUE.equals(""))
    			retval=false;
    		if(appr_rtb_valuation_int.UNIT_LIQ_PCT==null || appr_rtb_valuation_int.UNIT_LIQ_PCT.equals(""))
    			retval=false;
    		if(appr_rtb_valuation_int.UNIT_LIQ_VALUE==null || appr_rtb_valuation_int.UNIT_LIQ_VALUE.equals(""))
    			retval=false;
    		if(appr_rtb_valuation_int.UNIT_AREA==null || appr_rtb_valuation_int.UNIT_AREA.equals(""))
    			retval=false;
    		if(appr_rtb_valuation_int.UNIT_BUILD_AREA==null || appr_rtb_valuation_int.UNIT_BUILD_AREA.equals(""))
    			retval=false;
    		
    		if(appr_rtb_valuation_int.APPR_JNSPENILAIAN.equals("T"))
    		{
    			if(appr_rtb_valuation_int.LAND_AREA==null || appr_rtb_valuation_int.LAND_AREA.equals(""))
    				retval=false;
    			if(appr_rtb_valuation_int.LAND_MARKET_VALUE==null || appr_rtb_valuation_int.LAND_MARKET_VALUE.equals(""))
    				retval=false;
    			if(appr_rtb_valuation_int.LAND_MARKET_VALUE==null || appr_rtb_valuation_int.LAND_MARKET_VALUE.equals(""))
    				retval=false;
    			if(appr_rtb_valuation_int.LAND_LIQ_PCT==null || appr_rtb_valuation_int.LAND_LIQ_PCT.equals(""))
    				retval=false;
    			if(appr_rtb_valuation_int.LAND_LIQ_VALUE==null || appr_rtb_valuation_int.LAND_LIQ_VALUE.equals(""))
    				retval=false;
    		}
    		if(appr_rtb_valuation_int.APPR_JNSPENILAIAN.equals("TB"))
    		{
    			if(appr_rtb_valuation_int.BUILD_ASURANSI_AREA==null || appr_rtb_valuation_int.BUILD_ASURANSI_AREA.equals(""))
    				retval=false;
    			if(appr_rtb_valuation_int.TOTAL_LIQ_VALUE_FISIK==null || appr_rtb_valuation_int.TOTAL_LIQ_VALUE_FISIK.equals(""))
    				retval=false;
    			if(appr_rtb_valuation_int.BUILD_LIQ_VALUE_FISIK_TOTAL==null || appr_rtb_valuation_int.BUILD_LIQ_VALUE_FISIK_TOTAL.equals(""))
    				retval=false;
    			if(appr_rtb_valuation_int.BUILD_MARKET_VALUE_FISIK_TOTAL==null || appr_rtb_valuation_int.BUILD_MARKET_VALUE_FISIK_TOTAL.equals(""))
    				retval=false;
    			if(appr_rtb_valuation_int.LAND_LIQ_VALUE==null || appr_rtb_valuation_int.LAND_LIQ_VALUE.equals(""))
    				retval=false;
    			if(appr_rtb_valuation_int.LAND_LIQ_PCT==null || appr_rtb_valuation_int.LAND_LIQ_PCT.equals(""))
    				retval=false;
    			if(appr_rtb_valuation_int.LAND_MARKET_VALUE==null || appr_rtb_valuation_int.LAND_MARKET_VALUE.equals(""))
    				retval=false;
    			if(appr_rtb_valuation_int.LAND_PERMETER_VALUE==null || appr_rtb_valuation_int.LAND_PERMETER_VALUE.equals(""))
    				retval=false;
    			if(appr_rtb_valuation_int.LAND_AREA==null || appr_rtb_valuation_int.LAND_AREA.equals(""))
    				retval=false;
    		}
    		if(appr_rtb_valuation_int.APPR_JNSPENILAIAN.equals("U"))
    		{
    			if(appr_rtb_valuation_int.UNIT_MARKET_VALUE==null || appr_rtb_valuation_int.UNIT_MARKET_VALUE.equals(""))
    				retval=false;
    			if(appr_rtb_valuation_int.UNIT_LIQ_PCT==null || appr_rtb_valuation_int.UNIT_LIQ_PCT.equals(""))
    				retval=false;
    			if(appr_rtb_valuation_int.UNIT_LIQ_VALUE==null || appr_rtb_valuation_int.UNIT_LIQ_VALUE.equals(""))
    				retval=false;
    			if(appr_rtb_valuation_int.UNIT_JUMLAH==null || appr_rtb_valuation_int.UNIT_JUMLAH.equals(""))
    				retval=false;
    			if(appr_rtb_valuation_int.UNIT_BUILD_AREA==null || appr_rtb_valuation_int.UNIT_BUILD_AREA.equals(""))
    				retval=false;
    		}
    	}
  	
    	  return retval;
  }

private Boolean CekMandatoryValPersediaan(){
  	  boolean retval=true;	
  	  appr_pb_valuation_int=appr_Pb_ValuationDataProvider.getAllAppr_Pb_Valuation_Int(col_id);
	if(appr_pb_valuation_int.COL_ID!=null){
		if(appr_pb_valuation_int.COL_ZIPCODE==null || appr_pb_valuation_int.COL_ZIPCODE.equals(""))
    			retval=false;
    		if(appr_pb_valuation_int.COL_APPRAISER_CODE==null || appr_pb_valuation_int.COL_APPRAISER_CODE.equals(""))
    			retval=false;
    		if(appr_pb_valuation_int.REPORT_NO==null || appr_pb_valuation_int.REPORT_NO.equals(""))
    			retval=false;
    		if(appr_pb_valuation_int.REPORT_INSPECT_DATE==null || appr_pb_valuation_int.REPORT_INSPECT_DATE.equals(""))
    			retval=false;
    		if(appr_pb_valuation_int.COL_ADDR1==null || appr_pb_valuation_int.COL_ADDR1.equals(""))
    			retval=false;
				
				
			if(appr_pb_valuation_int.COL_KELURAHAN==null || appr_pb_valuation_int.COL_KELURAHAN.equals(""))
    			retval=false;
			if(appr_pb_valuation_int.COL_KECAMATAN==null || appr_pb_valuation_int.COL_KECAMATAN.equals(""))
				retval=false;
			if(appr_pb_valuation_int.COL_CITY==null || appr_pb_valuation_int.COL_CITY.equals(""))
				retval=false;
			if(appr_pb_valuation_int.PB_RANDOM_SAMPLING_COUNT==null || appr_pb_valuation_int.PB_RANDOM_SAMPLING_COUNT.equals(""))
				retval=false;
			if(appr_pb_valuation_int.PB_TOTAL_ITEM==null || appr_pb_valuation_int.PB_TOTAL_ITEM.equals(""))
				retval=false;
			if(appr_pb_valuation_int.INSPECTION_PERSON==null || appr_pb_valuation_int.INSPECTION_PERSON.equals(""))
				retval=false;	
			if(appr_pb_valuation_int.PB_BII_DATE==null || appr_pb_valuation_int.PB_BII_DATE.equals(""))
				retval=false;								
		}
		
	 return retval;
}	

private Boolean CekMandatoryValMesin(){
boolean retval=true;
	  
	appr_mch_valuation_int=appr_mch_ValuationDataProvider.getAllAppr_Mch_Valuation_Int(col_id);
	if(appr_mch_valuation_int.COL_ID!=null && !appr_mch_valuation_int.COL_ID.equals("")){
		if(appr_mch_valuation_int.CREATED_YEAR==null || appr_mch_valuation_int.CREATED_YEAR.equals(""))
			retval=false;
		if(appr_mch_valuation_int.LIQUID_PERCENT==null || appr_mch_valuation_int.LIQUID_PERCENT.equals(""))
			retval=false;
		if(appr_mch_valuation_int.LIQUID_VALUE==null || appr_mch_valuation_int.LIQUID_VALUE.equals(""))
			retval=false;
		if(appr_mch_valuation_int.INSPECTION_PERSON==null || appr_mch_valuation_int.INSPECTION_PERSON.equals(""))
			retval=false;
		if(appr_mch_valuation_int.DOC_NO==null || appr_mch_valuation_int.DOC_NO.equals(""))
			retval=false;
			
		if(appr_mch_valuation_int.MCH_FUNGSI==null || appr_mch_valuation_int.MCH_FUNGSI.equals(""))
			retval=false;	
		if(appr_mch_valuation_int.DOC_NOSERI==null || appr_mch_valuation_int.DOC_NOSERI.equals(""))
			retval=false;
		if(appr_mch_valuation_int.MCH_CODE==null || appr_mch_valuation_int.MCH_CODE.equals(""))
			retval=false;
		if(appr_mch_valuation_int.MCH_BRAND==null || appr_mch_valuation_int.MCH_BRAND.equals(""))
			retval=false;
		if(appr_mch_valuation_int.MCH_MODEL==null || appr_mch_valuation_int.MCH_MODEL.equals(""))
			retval=false;
		if(appr_mch_valuation_int.REPORT_DATE==null || appr_mch_valuation_int.REPORT_DATE.equals(""))
			retval=false;
		if(appr_mch_valuation_int.REPORT_INSPECT_DATE==null || appr_mch_valuation_int.REPORT_INSPECT_DATE.equals(""))
			retval=false;	
		if(appr_mch_valuation_int.COL_ADDR1==null || appr_mch_valuation_int.COL_ADDR1.equals(""))
			retval=false;	
		if(appr_mch_valuation_int.COL_KELURAHAN==null || appr_mch_valuation_int.COL_KELURAHAN.equals(""))
			retval=false;	
		if(appr_mch_valuation_int.COL_KECAMATAN==null || appr_mch_valuation_int.COL_KECAMATAN.equals(""))
			retval=false;		
		if(appr_mch_valuation_int.COL_CITY==null || appr_mch_valuation_int.COL_CITY.equals(""))
			retval=false;	
		if(appr_mch_valuation_int.DOC_DATE==null || appr_mch_valuation_int.DOC_DATE.equals(""))
			retval=false;	
		if(appr_mch_valuation_int.MARKET_PRICE==null || appr_mch_valuation_int.MARKET_PRICE.equals(""))
			retval=false;
		if(appr_mch_valuation_int.COL_ZIPCODE==null || appr_mch_valuation_int.COL_ZIPCODE.equals(""))
			retval=false;
		if(appr_mch_valuation_int.APPR_PENILAINAME==null || appr_mch_valuation_int.APPR_PENILAINAME.equals(""))
			retval=false;
		if(appr_mch_valuation_int.DOC_CODE==null || appr_mch_valuation_int.DOC_CODE.equals(""))
			retval=false;	
	}
	 return retval;
}

private Boolean CekMandatoryValKendaraan(){
boolean retval=true;
	  
	appr_kendaraan_valuation_int=appr_vhc_ValuationDataProvider.getAllAppr_Vhc_Valuation_Int(col_id);
	if(appr_kendaraan_valuation_int.COL_ID!=null && !appr_kendaraan_valuation_int.COL_ID.equals("")){
		if(appr_kendaraan_valuation_int.REPORT_NO==null || appr_kendaraan_valuation_int.REPORT_NO.equals(""))
			retval=false;
		if(appr_kendaraan_valuation_int.REPORT_DATE==null || appr_kendaraan_valuation_int.REPORT_DATE.equals(""))
			retval=false;
		if(appr_kendaraan_valuation_int.REPORT_INSPECT_DATE==null || appr_kendaraan_valuation_int.REPORT_INSPECT_DATE.equals(""))
			retval=false;
		if(appr_kendaraan_valuation_int.COL_ADDR1==null || appr_kendaraan_valuation_int.COL_ADDR1.equals(""))
			retval=false;
		if(appr_kendaraan_valuation_int.COL_KELURAHAN==null || appr_kendaraan_valuation_int.COL_KELURAHAN.equals(""))
			retval=false;
		if(appr_kendaraan_valuation_int.COL_KECAMATAN==null || appr_kendaraan_valuation_int.COL_KECAMATAN.equals(""))
			retval=false;
		if(appr_kendaraan_valuation_int.COL_CITY==null || appr_kendaraan_valuation_int.COL_CITY.equals(""))
			retval=false;
		if(appr_kendaraan_valuation_int.MARKET_PRICE==null || appr_kendaraan_valuation_int.MARKET_PRICE.equals(""))
			retval=false;
		if(appr_kendaraan_valuation_int.LIQUID_PERCENT==null || appr_kendaraan_valuation_int.LIQUID_PERCENT.equals(""))
			retval=false;
		if(appr_kendaraan_valuation_int.LIQUID_VALUE==null || appr_kendaraan_valuation_int.LIQUID_VALUE.equals(""))
			retval=false;
		if(appr_kendaraan_valuation_int.INSPECTION_PERSON==null || appr_kendaraan_valuation_int.INSPECTION_PERSON.equals(""))
			retval=false;
		if(appr_kendaraan_valuation_int.COL_ZIPCODE==null || appr_kendaraan_valuation_int.COL_ZIPCODE.equals(""))
			retval=false;
		if(appr_kendaraan_valuation_int.COL_APPRAISER_CODE==null || appr_kendaraan_valuation_int.COL_APPRAISER_CODE.equals(""))
			retval=false;
	}
		 return retval;
}	

private Boolean CekMandatoryDetail(){
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
	 return retval;		
}	 

private Boolean CekMandatoryDataKendaraan(){
boolean retval=true;
appr_Vhc_data_int=appr_Vhc_DataProvider.getAllAppr_Vhc_Data_Int(col_id);
    	if(appr_Vhc_data_int.COL_ID!=null && !appr_Vhc_data_int.COL_ID.equals("")){
			if(appr_Vhc_data_int.VHC_CODE==null || appr_Vhc_data_int.VHC_CODE.equals(""))
    			retval=false;
			if(appr_Vhc_data_int.VHC_BRAND_CODE==null || appr_Vhc_data_int.VHC_BRAND_CODE.equals(""))
    			retval=false;
			if(appr_Vhc_data_int.YEAR_CREATED==null || appr_Vhc_data_int.YEAR_CREATED.equals(""))
    			retval=false;
			if(appr_Vhc_data_int.COLOR_CODE==null || appr_Vhc_data_int.COLOR_CODE.equals(""))
    			retval=false;
				
			if(appr_Vhc_data_int.FRAME_NO==null || appr_Vhc_data_int.FRAME_NO.equals(""))
    			retval=false;
			if(appr_Vhc_data_int.MACHINE_NO==null || appr_Vhc_data_int.MACHINE_NO.equals(""))
    			retval=false;
				
			if(appr_Vhc_data_int.POLICE_NO==null || appr_Vhc_data_int.POLICE_NO.equals(""))
    			retval=false;
			if(appr_Vhc_data_int.VHC_PHYSIC_COND_CODE==null || appr_Vhc_data_int.VHC_PHYSIC_COND_CODE.equals(""))
    			retval=false;
				
		}
	 return retval;		
		
}	
private Boolean CekMandatoryProgBangunan(){
boolean retval=true;
appr_progress_data_int=appr_progress_DataProvider.getAllAppr_Rtb_Progress_Int(col_id);
    	if(appr_progress_data_int.COL_ID!=null && !appr_progress_data_int.COL_ID.equals("")){
			if(appr_progress_data_int.REPORT_NO==null || appr_progress_data_int.REPORT_NO.equals(""))
    			retval=false;
			if(appr_progress_data_int.REPORT_DATE==null || appr_progress_data_int.REPORT_DATE.equals(""))
    			retval=false;
			if(appr_progress_data_int.REPORT_INSPECT_DATE==null || appr_progress_data_int.REPORT_INSPECT_DATE.equals(""))
    			retval=false;
			if(appr_progress_data_int.COL_ADDR1==null || appr_progress_data_int.COL_ADDR1.equals(""))
    			retval=false;
				
			if(appr_progress_data_int.COL_DOK_NAME==null || appr_progress_data_int.COL_DOK_NAME.equals(""))
    			retval=false;
			if(appr_progress_data_int.COL_DOK_NO==null || appr_progress_data_int.COL_DOK_NO.equals(""))
    			retval=false;
				
			if(appr_progress_data_int.INSPECTOR_NAME==null || appr_progress_data_int.INSPECTOR_NAME.equals(""))
    			retval=false;
			if(appr_progress_data_int.REPORT_BRANCH_CODE==null || appr_progress_data_int.REPORT_BRANCH_CODE.equals(""))
    			retval=false;
			if(appr_progress_data_int.REPORT_SEG_CODE==null || appr_progress_data_int.REPORT_SEG_CODE.equals(""))
    			retval=false;
			if(appr_progress_data_int.COL_ZIPCODE==null || appr_progress_data_int.COL_ZIPCODE.equals(""))
    			retval=false;
			if(appr_progress_data_int.COL_APPRAISER_CODE==null || appr_progress_data_int.COL_APPRAISER_CODE.equals(""))
    			retval=false;
			if(appr_progress_data_int.COL_DOK_TYPE==null || appr_progress_data_int.COL_DOK_TYPE.equals(""))
    			retval=false;	
		}



	 return retval;		
		
}		
private Boolean CekMandatoryDataTanah(){
boolean retval=true;
appr_Rtb_data_int=appr_Rtb_DataProvider.getAllAppr_Rtb_Data_Int(col_id);
	if(appr_Rtb_data_int.COL_ID!=null && !appr_Rtb_data_int.COL_ID.equals("")){
		if(appr_Rtb_data_int.ROAD_WIDTH==null || appr_Rtb_data_int.ROAD_WIDTH.equals(""))
			retval=false;
		if(appr_Rtb_data_int.COL_ADDR1==null || appr_Rtb_data_int.COL_ADDR1.equals(""))
			retval=false;
		if(appr_Rtb_data_int.COL_KELURAHAN==null || appr_Rtb_data_int.COL_KELURAHAN.equals(""))
			retval=false;
		if(appr_Rtb_data_int.COL_KECAMATAN==null || appr_Rtb_data_int.COL_KECAMATAN.equals(""))
			retval=false;
			
		if(appr_Rtb_data_int.COL_CITY==null || appr_Rtb_data_int.COL_CITY.equals(""))
			retval=false;
		if(appr_Rtb_data_int.FAS_TRANSPORTATION==null || appr_Rtb_data_int.FAS_TRANSPORTATION.equals(""))
			retval=false;
			
		if(appr_Rtb_data_int.FAS_TRANSPORTATION_DISTANCE==null || appr_Rtb_data_int.FAS_TRANSPORTATION_DISTANCE.equals(""))
			retval=false;
		if(appr_Rtb_data_int.INSPECTION_PERSON==null || appr_Rtb_data_int.INSPECTION_PERSON.equals(""))
			retval=false;
		if(appr_Rtb_data_int.COL_ZIPCODE==null || appr_Rtb_data_int.COL_ZIPCODE.equals(""))
			retval=false;
		if(appr_Rtb_data_int.ROAD_TYPE==null || appr_Rtb_data_int.ROAD_TYPE.equals(""))
			retval=false;
		if(appr_Rtb_data_int.COL_CLASS==null || appr_Rtb_data_int.COL_CLASS.equals(""))
			retval=false;
	}
return retval;
}

private Boolean CekMandatoryProgDeveloper(){
boolean retval=true;

	    appr_progress_data_int_dev=appr_progress_DataProvider_dev.getAllAppr_Rtb_Progress_Int(col_id);
    	if(appr_progress_data_int_dev.COL_ID!=null && !appr_progress_data_int_dev.COL_ID.equals("")){
			if(appr_progress_data_int_dev.REPORT_NO==null || appr_progress_data_int_dev.REPORT_NO.equals(""))
    			retval=false;
			if(appr_progress_data_int_dev.REPORT_DATE==null || appr_progress_data_int_dev.REPORT_DATE.equals(""))
    			retval=false;
			if(appr_progress_data_int_dev.REPORT_INSPECT_DATE==null || appr_progress_data_int_dev.REPORT_INSPECT_DATE.equals(""))
    			retval=false;
			if(appr_progress_data_int_dev.COL_ADDR1==null || appr_progress_data_int_dev.COL_ADDR1.equals(""))
    			retval=false;
				
			if(appr_progress_data_int_dev.COL_DOK_NAME==null || appr_progress_data_int_dev.COL_DOK_NAME.equals(""))
    			retval=false;
			if(appr_progress_data_int_dev.COL_DOK_NO==null || appr_progress_data_int_dev.COL_DOK_NO.equals(""))
    			retval=false;
				
			if(appr_progress_data_int_dev.INSPECTOR_NAME==null || appr_progress_data_int_dev.INSPECTOR_NAME.equals(""))
    			retval=false;
			if(appr_progress_data_int_dev.REPORT_BRANCH_CODE==null || appr_progress_data_int_dev.REPORT_BRANCH_CODE.equals(""))
    			retval=false;
			if(appr_progress_data_int_dev.REPORT_SEG_CODE==null || appr_progress_data_int_dev.REPORT_SEG_CODE.equals(""))
    			retval=false;
			if(appr_progress_data_int_dev.COL_ZIPCODE==null || appr_progress_data_int_dev.COL_ZIPCODE.equals(""))
    			retval=false;
			if(appr_progress_data_int_dev.COL_APPRAISER_CODE==null || appr_progress_data_int_dev.COL_APPRAISER_CODE.equals(""))
    			retval=false;
			if(appr_progress_data_int_dev.COL_DOK_TYPE==null || appr_progress_data_int_dev.COL_DOK_TYPE.equals(""))
    			retval=false;	
		}



	 return retval;		
		
}
}