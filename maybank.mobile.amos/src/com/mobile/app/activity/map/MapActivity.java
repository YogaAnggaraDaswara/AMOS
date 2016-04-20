package com.mobile.app.activity.map;

import bii.mobile.mitra.R;

import com.mobile.app.activity.HomeActivity;
import com.mobile.app.configuration.AppConstants;
import com.mobile.app.ui.MasterContent;
import com.mobile.bo.app.datatype.MotionTrackerData;
import com.mobile.bo.app.datatype.MotionTrackerDetailData;
import com.mobile.bo.app.datatype.UserData;
import com.mobile.framework.activity.ActivityHandler;
import com.mobile.framework.common.DateFormatter;
import com.mobile.framework.data.SessionSharedPreference;
import com.mobile.services.app.ServiceData;
import com.mobile.services.app.datatype.SERVICEDATARESPONSE;
import com.mobile.services.app.datatype.SERVICERESPONSE;
import com.mobile.services.app.services.ServiceDataProvider;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapActivity extends FragmentActivity {
    private UserData userDetail;
    private boolean isUserDetailExist = false;
    private TextView lblHeaderUser;
    private TextView lblDateTime;
    private RelativeLayout contentContainer;
    private GoogleMap googleMap;
    private ImageView btnBack;
    private Context ctx;
    private ArrayList<LatLng> listDataMap;
    private Location location = null;
    private MasterContent prevShownView = null;
    private MotionTrackerData motionTrackerData;
    private ProgressDialog dlgProgress = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;
        initActivity();
    }

    @Override
    protected void onDestroy() {
        googleMap.clear();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        googleMap.clear();
        ActivityHandler.gotoActivity(ctx, HomeActivity.class, null);
        finish();
    }

    @SuppressLint("SimpleDateFormat")
    public void initActivity() {
        setContentView(R.layout.map_layout);
        try {
            userDetail = (UserData) SessionSharedPreference.getDataFromSharedPreference(ctx, UserData.class, AppConstants.USER_SESSION);
            isUserDetailExist = true;
        } catch (Exception e) {
            finish();
            return;
        }

        lblHeaderUser = (TextView) findViewById(R.id.location_lbl_user_information);
        lblDateTime = (TextView) findViewById(R.id.location_lbl_currentdate);
        if (googleMap != null) {
            return;
        }
        googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
        if (googleMap == null) {
            return;
        }

        contentContainer = (RelativeLayout) findViewById(R.id.content_layout);
        btnBack = (ImageView) findViewById(R.id.location_btn_back);

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

        loadMapTrackerView();
    }


    private void loadMapTrackerView() {
        showProgressIndicator();
        new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
                            params.add(new BasicNameValuePair("userid", userDetail.getUSERID()));

                            SERVICEDATARESPONSE motionTrackerResponse = ServiceDataProvider.getMotionTrackerData(params);
                            if (motionTrackerResponse != null) {
                                motionTrackerData = ServiceData.getMotionTrackerData(new JSONArray(motionTrackerResponse.getResults()).getJSONObject(0));
                                if (motionTrackerResponse.getStatus() == 1) {
                                    populateMotionTrackerView();
                                }
                            }
                            motionTrackerResponse = null;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        hideProgressIndicator();
                    }
                });
            }
        }).start();
    }

    private void populateMotionTrackerView() {
        if (motionTrackerData != null) {
            location = new Location(ctx);
            //populate header data to table
            location.getLblTitle().setText("Pencapaian Sampai " + new SimpleDateFormat("dd MMMM yyyy").format((motionTrackerData.getTANGGAL())));
            TableRow rowHeaderTable = new TableRow(ctx);
            rowHeaderTable.setBackgroundColor(Color.BLUE);
            for (int i = 0; i < AppConstants.HEADER_TABLE_LOCATION.length; i++) {
                TextView header = new TextView(ctx);
                header.setText(AppConstants.HEADER_TABLE_LOCATION[i]);
                rowHeaderTable.addView(header);
            }
            location.getTableLayout().addView(rowHeaderTable);

            googleMap.setMyLocationEnabled(true);
            // Initialize map options
            if (motionTrackerData.getAKTUAL().size() > 0) {
                if (motionTrackerData.getAKTUAL().get(0).getMAPDATA().size() > 0) {
                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(motionTrackerData.getAKTUAL().get(0).getMAPDATA().get(0), 2));
                }
            }

            for (int i = 0; i < motionTrackerData.getAKTUAL().size(); i++) {
                // populate map top polyline
                PolylineOptions polylineOptions = new PolylineOptions();
                polylineOptions.color(Color.RED);
                polylineOptions.width(1);

                MotionTrackerDetailData motionTrackerDetailData = motionTrackerData.getAKTUAL().get(i);

                polylineOptions.addAll(motionTrackerDetailData.getMAPDATA());

                for (int j = 0; j < motionTrackerDetailData.getMAPDATA().size(); j++) {
                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.position(motionTrackerDetailData.getMAPDATA().get(j));
                    markerOptions.title(motionTrackerDetailData.getUSERID());
                    markerOptions.snippet(motionTrackerDetailData.getMAPDATA().get(j).latitude + "," + motionTrackerDetailData.getMAPDATA().get(j));
                    googleMap.addMarker(markerOptions);
                }

                googleMap.addPolyline(polylineOptions);

                // populate data to table
                TableRow rowContentTable = new TableRow(ctx);
                if ((i + 1) % 2 == 0) {
                    rowContentTable.setBackgroundColor(Color.BLUE);
                } else {
                    rowContentTable.setBackgroundColor(Color.WHITE);
                }

                TextView content_user = new TextView(ctx);
                content_user.setText(motionTrackerDetailData.getUSERID());
                rowContentTable.addView(content_user);

                TextView content_countprospek = new TextView(ctx);
                content_countprospek.setText("" + motionTrackerDetailData.getJUMLAHPROSPEK());
                rowContentTable.addView(content_countprospek);

                TextView content_countkenalan = new TextView(ctx);
                content_countkenalan.setText("" + motionTrackerDetailData.getJUMLAHKENALAN());
                rowContentTable.addView(content_countkenalan);

                TextView content_countpendekatan = new TextView(ctx);
                content_countpendekatan.setText("" + motionTrackerDetailData.getJUMLAHPENDEKATAN());
                rowContentTable.addView(content_countpendekatan);

                TextView content_countclosing = new TextView(ctx);
                content_countclosing.setText("" + motionTrackerDetailData.getJUMLAHCLOSING());
                rowContentTable.addView(content_countclosing);

                location.getTableLayout().addView(rowContentTable);
            }

            if (contentContainer != null) {
                contentContainer.removeView(prevShownView);
            }

            contentContainer.addView(location);
            prevShownView = location;
        }

    }

    public void showProgressIndicator() {
        if (dlgProgress == null) {
            dlgProgress = new ProgressDialog(this);
            dlgProgress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dlgProgress.setTitle(getString(R.string.str_informasi));
            dlgProgress.setMessage("Data Sedang Dimuat");
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
                                    dlgProgress.setMessage("Data Sedang Dimuat");
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
/*
    private void loadDataMap(){
		if (listDataMap != null){
			listDataMap.clear();
		}
		listDataMap= new ArrayList<LatLng>();
		listDataMap.add(new LatLng(-18.142, 178.431));
		listDataMap.add(new LatLng(-33.866, 151.195));  // Sydney
		listDataMap.add(new LatLng(-18.142, 178.431)); // Fiji
		listDataMap.add(new LatLng(21.291, -157.821));  // Hawaii
		listDataMap.add(new LatLng(37.423, -122.091));  // Mountain View
		
		if (liststatistikdataprospek != null){
			liststatistikdataprospek.clear();
		}
		liststatistikdataprospek= statistikDataProvider.getStatistikDataProspek();
	}
	private void loadMapView(){
		// populate map
		PolylineOptions polylineOptions = new PolylineOptions();
        polylineOptions.color(Color.RED);
        polylineOptions.width(3);
        
     // Initialize map options. For example:
        googleMap.setMyLocationEnabled(true);
        polylineOptions.addAll(listDataMap);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(listDataMap.get(0), 2));

        
        for (int i=0;i<listDataMap.size();i++){
       	 	MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(listDataMap.get(i));
            markerOptions.title("Position");
            markerOptions.snippet(listDataMap.get(i).latitude+","+listDataMap.get(i).longitude); 
            googleMap.addMarker(markerOptions);
        }
        
        googleMap.addPolyline(polylineOptions);
        
        // populate table        
        if(liststatistikdataprospek.size()>0){
            location = new Location(ctx);

            location.getLblTitle().setText("Pencapaian Sampai "+formattedDate);
			TableRow rowHeaderTable = new TableRow(this);
			rowHeaderTable.setBackgroundColor(Color.BLUE);
			for (int i=0;i<AppConstants.HEADER_TABLE_LOCATION.length;i++){
				 TextView header = new TextView(ctx);
				 header.setText(AppConstants.HEADER_TABLE_LOCATION[i]);
				 rowHeaderTable.addView(header);
			}
			location.getTableLayout().addView(rowHeaderTable);
			
			// loop data fill table			
			for(int i=0;i<liststatistikdataprospek.size();i++){
				StatistikDataTemp contentdata= liststatistikdataprospek.get(i);
				TableRow rowContentTable = new TableRow(this);
				if ((i+1)%2==0){rowContentTable.setBackgroundColor(Color.BLUE);}
				else{rowContentTable.setBackgroundColor(Color.WHITE);}
				
				TextView content_user = new TextView(ctx);
				content_user.setText("User "+(i+1));				
				rowContentTable.addView(content_user);
				 
				TextView content_countprospek = new TextView(ctx);
				content_countprospek.setText(""+contentdata.getPROSPEK());
				rowContentTable.addView(content_countprospek);
				
				TextView content_countkenalan = new TextView(ctx);
				content_countkenalan.setText(""+contentdata.getKENALAN());
				rowContentTable.addView(content_countkenalan);
				
				TextView content_countpendekatan = new TextView(ctx);
				content_countpendekatan.setText(""+contentdata.getPDKT());
				rowContentTable.addView(content_countpendekatan);
				
				TextView content_countclosing = new TextView(ctx);
				content_countclosing.setText(""+contentdata.getCLOSING());
				rowContentTable.addView(content_countclosing);

				location.getTableLayout().addView(rowContentTable);
			}
			
			if (contentContainer != null){
				contentContainer.removeView(prevShownView);
			}
			
			contentContainer.addView(location);
			prevShownView = location;
        }
	}
*/
//	public String GetLocationName(LatLng objMap){
//		String address="-";
//		try {
//	        Geocoder geo = new Geocoder(this.getApplicationContext(), Locale.getDefault());
//	        List<Address> addresses = geo.getFromLocation(objMap.latitude, objMap.longitude, 1);
//	        if (!addresses.isEmpty()) {
//	            if (addresses.size() > 0) {
//	            	address = addresses.get(0).getFeatureName() + ", " + addresses.get(0).getLocality() +", " + addresses.get(0).getAdminArea() + ", " + addresses.get(0).getCountryName();
//	            }
//	        }
//	    }
//	    catch (Exception e) {
//	        e.printStackTrace();
//	    }
//		
//		return address;
//	}

}
