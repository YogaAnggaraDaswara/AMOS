package com.mobile.app.activity;

import com.mobile.app.ui.MasterNagivationLinear;

import maybank.mobile.amos.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;

public class NavigationList extends MasterNagivationLinear {

    Button btnprospek;
    Button btnkenalan;
    Button btnpendekatan;
    Button btnclosing;
    Button btnrequestblackbox;
    Button btninbox;
    Button btnstatistik;
    Button btnHasilBlacbox;
    Button btnTabungan;
    Button btnTagihan;
    Button btnLov;
    Button btnUbahPassword;
    Button btnLogOut, btnDocStts, btnDebStts, btnUplDoc,btndownload,btnsms,btnupload;

    public NavigationList(Context context) {
        super(context);
    }

    public NavigationList(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onInitMasterNavigationView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.navigation_layout, getNavigationBody());
        btnprospek = (Button) getNavigationBody().findViewById(R.id.home_menu_dataprospek);
        btnsms= (Button) getNavigationBody().findViewById(R.id.home_menu_log_email);
        btnupload= (Button) getNavigationBody().findViewById(R.id.home_menu_log_upload);
        
        btnLov = (Button) getNavigationBody().findViewById(R.id.home_menu_getlov);
        
        btnUbahPassword = (Button) getNavigationBody().findViewById(R.id.home_menu_ubahpassword);
        btnLogOut = (Button) getNavigationBody().findViewById(R.id.home_btn_logout);
        btnDocStts = (Button) getNavigationBody().findViewById(R.id.home_menu_doc_sts);
        btnDebStts = (Button) getNavigationBody().findViewById(R.id.home_menu_deb_sts);
        btnUplDoc = (Button) getNavigationBody().findViewById(R.id.home_menu_upload_doc);
        btndownload = (Button) getNavigationBody().findViewById(R.id.home_menu_download_master);
        
    }
    public Button getbtnsms() {
        return btnsms;
    }
    public Button getbtnupload() {
        return btnupload;
    }
    
    public Button getbtndownload() {
        return btndownload;
    }
    public Button getBtnprospek() {
        return btnprospek;
    }

    public Button getBtnkenalan() {
        return btnkenalan;
    }

    public Button getBtnpendekatan() {
        return btnpendekatan;
    }

    public Button getBtnclosing() {
        return btnclosing;
    }

    public Button getBtnrequestblackbox() {
        return btnrequestblackbox;
    }

    public Button getBtninbox() {
        return btninbox;
    }

    public Button getBtnstatistik() {
        return btnstatistik;
    }

    public Button getBtnHasilBlacbox() {
        return btnHasilBlacbox;
    }

    public Button getBtnTabungan() {
        return btnTabungan;
    }

    public Button getBtnUbahPassword() {
        return btnUbahPassword;
    }

    public Button getBtnTagihan() {
        return btnTagihan;
    }

    public Button getbtnLov() {
        return btnLov;
    }
    
    public Button getBtnLogOut() {
    	return btnLogOut;
    }
    
    public Button getBtnDocStts() {
    	return btnDocStts;
    }
    
    public Button getBtnDebStts() {
    	return btnDebStts;
    }
    
    public Button getBtnUplDoc() {
    	return btnUplDoc;
    }
    

}
