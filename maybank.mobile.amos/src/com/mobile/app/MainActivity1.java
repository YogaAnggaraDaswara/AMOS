package com.mobile.app;




import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;

import com.mobile.app.activity.HomeActivity;
import com.mobile.app.configuration.AppConstants;
import com.mobile.appraisal.Fragment_Cek_Tata_Kota;
import com.mobile.appraisal.Fragment_Detail;
import com.mobile.appraisal.Fragment_Data_Rumah_Tanah_Bangunan;
import com.mobile.appraisal.Fragment_Data_Kendaraan;
import com.mobile.appraisal.Fragment_Informasi_Jaminan;
import com.mobile.appraisal.Fragment_Progress_Bangunan;
import com.mobile.appraisal.Fragment_Progress_Developer;
import com.mobile.appraisal.Fragment_Valuation_Kendaraan;
import com.mobile.appraisal.Fragment_Valuation_Mesin;
import com.mobile.appraisal.Fragment_Valuation_Persediaan;
import com.mobile.appraisal.Fragment_Valuation_Rumah_Tanah_Bangunan;
import com.mobile.bo.app.datatype.LovData;
import com.mobile.bo.app.datatype.MessageData;
import com.mobile.bo.app.datatype.NewsData;
import com.mobile.bo.app.datatype.ProspekData;
import com.mobile.bo.app.datatype.ScheduleData;
import com.mobile.bo.app.datatype.TabunganData;
import com.mobile.bo.app.datatype.TagihanData;
import com.mobile.framework.activity.ActivityHandler;
import com.mobile.framework.common.DateFormatter;
import com.mobile.framework.data.SessionSharedPreference;
import com.mobile.services.app.ServiceData;
import com.mobile.services.app.datatype.RequestCount;
import com.mobile.services.app.datatype.SERVICEDATARESPONSE;
import com.mobile.services.app.services.ServiceDataProvider;

import layout.MainLayout;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;

import bii.mobile.mitra.R;
import com.mobile.bo.app.dataprovider.LOVDataProvider;
// DK 
// This is my studying about Sliding Menu following Youtube video
public class MainActivity1 extends FragmentActivity {
	private LOVDataProvider lovDataProvider;
    // The MainLayout which will hold both the sliding menu and our main content
    // Main content will holds our Fragment respectively
    MainLayout mainLayout;

    // ListView menu
    private ListView lvMenu;
    private String[] lvMenuItems;

    // Menu button
    Button btMenu;

    // Title according to fragment
    TextView tvTitle;
    TabWidget twMenu;
    private String ap_regno="";
    private String col_id="";
    private String col_type="";
    private String appraise_type="";
    private Button btnsave,btnback;
    private Context ctx;
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

/*        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
        	Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
*/
        mainLayout.refresh();
        //mainLayout.onLayout(true, 0, 0, this.getHeight(), 5);        
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      
        // Inflate the mainLayout
        mainLayout = (MainLayout) this.getLayoutInflater().inflate(R.layout.activity_main, null);
        setContentView(mainLayout);
        ctx=this;
        /////
        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            ap_regno=(String)b.get("AP_REGNO");
            col_id=(String)b.get("COL_ID");
            col_type=(String)b.get("COL_TYPE");
            appraise_type=(String)b.get("APPRAISE_TYPE");
        }
        
        /////
       
        // Init menu
        if(col_type.equals("RE")){
        	lvMenuItems = getResources().getStringArray(R.array.menu_items_rtb);
        }
        if(col_type.equals("MCH")){
        	lvMenuItems = getResources().getStringArray(R.array.menu_items_mch);
        }
        if(col_type.equals("VEH")){
        	lvMenuItems = getResources().getStringArray(R.array.menu_items_vch);
        }
        if(col_type.equals("STK")){
        	lvMenuItems = getResources().getStringArray(R.array.menu_items_psb);
        }
        
        if(appraise_type.equals("D")){
        	lvMenuItems = getResources().getStringArray(R.array.menu_items_pb);
        }
        if(appraise_type.equals("K")){
        	lvMenuItems = getResources().getStringArray(R.array.menu_items_pd);
        }
        lvMenu = (ListView) findViewById(R.id.activity_main_menu_listview);
        btnsave = (Button) findViewById(R.id.btn_save);
        btnback= (Button) findViewById(R.id.btn_batal);
        lvMenu.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lvMenuItems));

        twMenu = (TabWidget) findViewById(R.id.tabs);
        //twMenu.setAdapter(new ArrayAdapter<String>(this,
        //        android.R.layout.simple_list_item_1, lvMenuItems));
        lvMenu.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onMenuItemClick(parent, view, position, id);
            }

        });

       
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	Toast.makeText(ctx, "Save", Toast.LENGTH_LONG).show();
           }
        }); 
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	ActivityHandler.gotoActivity(ctx, HomeActivity.class, null);
                finish();
           }
        }); 
        // Get menu button
        btMenu = (Button) findViewById(R.id.activity_main_content_button_menu);
        btMenu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show/hide the menu
                toggleMenu(v);
            }
        });

        // Get title textview
        tvTitle = (TextView) findViewById(R.id.activity_main_content_title);
        tvTitle.setText("Main");

        // Add FragmentMain as the initial fragment       
        FragmentManager fm = MainActivity1.this.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        
        Bundle c = new Bundle();
        c.putString("AP_REGNO", ap_regno);
        c.putString("COL_ID", col_id);
        
        Fragment_Informasi_Jaminan fragment = new Fragment_Informasi_Jaminan();
        fragment.setArguments(c);
        ft.add(R.id.activity_main_content_fragment, fragment);
        ft.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        
        return true;
    }

    public void toggleMenu(View v) {
        mainLayout.toggleMenu();

    }

    // Perform action when a menu item is clicked
    private void onMenuItemClick(AdapterView<?> parent, View view, int position, long id) {
        String selectedItem = lvMenuItems[position];
        String currentItem = tvTitle.getText().toString();

        // Do nothing if selectedItem is currentItem
        if (selectedItem.compareTo(currentItem) == 0) {
            mainLayout.toggleMenu();
            return;
        }

        FragmentManager fm = MainActivity1.this.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment fragment = null;
/*        Dokumen Jaminan</item>
        <item >Valuation</item>
        <item >Data</item>
        <item >Detail</item>
        <item >Data Pembanding</item>
        <item >Cek Tata Kota</item>
        <item >Progress Bangunan</item>
        <item >Progress Developer</item>*/
        Bundle b = new Bundle();
        b.putString("AP_REGNO", ap_regno);
        b.putString("COL_ID", col_id);
        
        
       
        if (selectedItem.compareTo("Main") == 0) {
            fragment = new Fragment_Informasi_Jaminan();
            
        } else if (selectedItem.compareTo("Dokumen Jaminan") == 0) {
            fragment = new Fragment_Informasi_Jaminan();
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
            fragment = new Fragment_Detail();
        } else if (selectedItem.compareTo("Cek Tata Kota") == 0) {
            fragment = new Fragment_Cek_Tata_Kota();
        } else if (selectedItem.compareTo("Progress Bangunan") == 0) {
            fragment = new Fragment_Progress_Bangunan();
            fragment.setArguments(b);
            
            /*fragment = new FragmentTextView();
            Bundle b = new Bundle();
            b.putString("KEY_STRING", "Please display this text");
            fragment.setArguments(b);*/
        } else if (selectedItem.compareTo("Progress Developer") == 0) {
            fragment=new Fragment_Progress_Developer();
        	//fragment = new Fragment_Progress_Developer();
        } /*else if(selectedItem.compareTo("WebView") == 0) {
            fragment = new FragmentWebView();
        }*/

        if (fragment != null) {
            // Replace current fragment by this new one
            ft.replace(R.id.activity_main_content_fragment, fragment);
            ft.commit();

            // Set title accordingly
            tvTitle.setText(selectedItem);
        }
        fragment.setArguments(b);
        // Hide menu anyway
        mainLayout.toggleMenu();
    }

    @Override
    public void onBackPressed() {
        if (mainLayout.isMenuShown()) {
            mainLayout.toggleMenu();
        } else {
            super.onBackPressed();
        }
    }
    
 
    
}
