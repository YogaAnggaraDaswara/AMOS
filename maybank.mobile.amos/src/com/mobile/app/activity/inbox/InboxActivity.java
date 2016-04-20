package com.mobile.app.activity.inbox;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bii.mobile.mitra.R;

import com.mobile.app.activity.HomeActivity;
import com.mobile.app.configuration.AppConstants;
import com.mobile.app.ui.MasterContent;
import com.mobile.bo.app.dataprovider.MessageDataProvider;
import com.mobile.bo.app.datatype.MessageData;
import com.mobile.bo.app.datatype.UserData;
import com.mobile.framework.activity.ActivityHandler;
import com.mobile.framework.common.DateFormatter;
import com.mobile.framework.data.SessionSharedPreference;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;

public class InboxActivity extends Activity {
    private MessageDataProvider messageDataProvider;
    private UserData userDetail;
    private boolean isUserDetailExist = false;
    private TextView lblHeaderUser;
    private TextView lblDateTime;
    private RelativeLayout contentContainer;
    private ImageView btnBack;
    private MasterContent prevShownView = null;
    private ArrayList<String> listIdmessage = null;
    private int INITINDEXRECORD = 0;
    private int currIndex = 0;
    private Inbox inbox;
    private Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;
        messageDataProvider = new MessageDataProvider();
        initActivity();
    }

    @Override
    protected void onDestroy() {
        messageDataProvider.release();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        ActivityHandler.gotoActivity(ctx, HomeActivity.class, null);
        finish();
    }

    @SuppressLint("SimpleDateFormat")
    public void initActivity() {
        setContentView(R.layout.inbox_layout);
        try {
            userDetail = (UserData) SessionSharedPreference.getDataFromSharedPreference(ctx, UserData.class, AppConstants.USER_SESSION);
            isUserDetailExist = true;
        } catch (Exception e) {
            finish();
            return;
        }

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

        loadDataMessage();
        loadViewMessage(INITINDEXRECORD);
    }

    private void loadDataMessage() {
        if (listIdmessage != null) {
            listIdmessage.clear();
        }
        //listIdmessage = messageDataProvider.getAllMessage();
    }

    private void loadViewMessage(final int idxRecord) {
        currIndex = idxRecord;
        inbox = null;
        inbox = new Inbox(ctx);
        //MessageData message = messageDataProvider.getMessageDetail(listIdmessage.get(currIndex));
        //message.setISREAD("1");
        //messageDataProvider.updateMessage(message);
        inbox.getLblTotalRecords().setText((idxRecord + 1) + "/" + listIdmessage.size());
        //inbox.getLblContent().setText(message.getMESSAGE());

        inbox.getBtnPrev().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int previndex = currIndex - 1 <= 0 ? 0 : currIndex - 1;
                loadViewMessage(previndex);
            }
        });

        inbox.getBtnNext().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextindex = currIndex + 1 >= listIdmessage.size() - 1 ? listIdmessage.size() - 1 : currIndex + 1;
                loadViewMessage(nextindex);
            }
        });

        manageContentProperty(listIdmessage.size());

        if (contentContainer != null) {
            contentContainer.removeView(prevShownView);
        }

        contentContainer.addView(inbox);
        prevShownView = inbox;
    }

    public void manageContentProperty(int totalData) {
        if (totalData > 1) {
            inbox.getBtnPrev().setVisibility(View.VISIBLE);
            inbox.getBtnNext().setVisibility(View.VISIBLE);
        } else {
            inbox.getBtnPrev().setVisibility(View.GONE);
            inbox.getBtnNext().setVisibility(View.GONE);
        }
    }
}
