package com.mobile.app.ui;

import java.util.ArrayList;

import com.mobile.bo.app.datatype.UserData;

import maybank.mobile.amos.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public abstract class MasterActivity extends Activity {

    public enum RequestCode {
        REQUEST_NEW(10001),
        REQUEST_EDIT(10002);

        private int code;

        public int getCode() {
            return this.code;
        }

        RequestCode(int rCode) {
            this.code = rCode;
        }
    }

    ;

    public class NavigationItem {
        private String text;
        private int id;
        private MasterContent content;

        public NavigationItem(int itemID, String itemText, MasterContent itemContent) {
            this.id = itemID;
            this.text = itemText;
            this.content = itemContent;
        }

        public String getText() {
            return text;
        }

        public int getId() {
            return id;
        }

        public MasterContent getContent() {
            return content;
        }
    }

    private LinearLayout navgationContainer;
    private ProgressBar prgNavLoadingIndicator;
    private TextView lblFooterUserName;
    private TextView lblFooterUserNIK;
    private TextView lblFooterUserAreaName;
    private TextView lblFooterLastUpdate;
    private RelativeLayout contentContainer;

    private boolean isLoading = true;

    private UserData userDetail;
    private boolean isUserDetailExist = false;

    private boolean isInitDataPrivederCalled = false;

    ArrayList<Object> navList = new ArrayList<Object>();
    ArrayList<MasterContent> contentList = new ArrayList<MasterContent>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (initMasterActivity()) {
            onInitDataProvider();
            isInitDataPrivederCalled = true;
        }
    }

    @Override
    protected void onDestroy() {
        if (isInitDataPrivederCalled) {
            onReleaseDataProvider();
        }
        super.onDestroy();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && isLoading) {
            isLoading = false;
            startLoading();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    onLoadListOfValue();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            endLoading();
                        }
                    });
                }
            }).start();
        }
    }

    private boolean initMasterActivity() {
        /*setContentView(R.layout.master_layout);

        Intent intent = getIntent();
        if (intent.hasExtra(UserData.class.getName())) {
            userDetail = (UserData) intent.getSerializableExtra(UserData.class.getName());
            isUserDetailExist = true;
        }

        if (!isUserDetailExist) {
            finish();
            return false;
        }

        navgationContainer = (LinearLayout) findViewById(R.id.master_navigation_layout);
        prgNavLoadingIndicator = (ProgressBar) findViewById(R.id.master_navigation_prg_loading_indicator);
        contentContainer = (RelativeLayout) findViewById(R.id.master_content_layout);

        lblFooterUserName = (TextView) findViewById(R.id.master_lbl_name_value);
        lblFooterUserNIK = (TextView) findViewById(R.id.master_lbl_nik_value);
        lblFooterUserAreaName = (TextView) findViewById(R.id.master_lbl_area_value);
*/
        onLoadIntentExtraData();

        return true;
    }


    private void startLoading() {
        prgNavLoadingIndicator.setVisibility(View.VISIBLE);
    }

    private void endLoading() {
        onLoadNavigationView();
        onLoadContentsView();

        prgNavLoadingIndicator.setVisibility(View.GONE);

        onShowDefaultContentView();
    }

    protected void addContentView(NavigationItem item) {

    }

    protected void showNextContent() {

    }

    protected void showPrevContent() {

    }

    protected void showActivityForResult(Intent intentData, RequestCode requestCode) {
        if (isUserDetailExist) {
            intentData.putExtra(
                    UserData.class.getName(),
                    userDetail);
        }

        startActivityForResult(
                intentData,
                requestCode.getCode());
    }

    protected void showActivity(Intent intentData) {
        if (isUserDetailExist) {
            intentData.putExtra(
                    UserData.class.getName(),
                    userDetail);
        }

        startActivity(intentData);
    }

    protected abstract void onInitDataProvider();

    protected abstract void onReleaseDataProvider();

    protected abstract void onLoadIntentExtraData();

    protected abstract void onLoadListOfValue();

    protected abstract void onLoadNavigationView();

    protected abstract void onLoadContentsView();

    protected abstract void onShowDefaultContentView();

}
