package com.mobile.app.activity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;

import com.mobile.amos.Debitur_DocumentActivity;
import com.mobile.amos.Debitur_EntryActivity;
import com.mobile.amos.Debitur_InqueryActivity;
import com.mobile.amos.Debitur_StatusActivity;
import com.mobile.amos.DownloadActivity;
import com.mobile.amos.Informasi_AplikasiActivity;
import com.mobile.amos.List_SendEmailActivity;
import com.mobile.amos.List_UploadActivity;
import com.mobile.amos.MainActivityDebitur;
import com.mobile.amos.Upload_DocumentActivity;
import com.mobile.app.LoginActivity;

import com.mobile.app.configuration.AppConstants;
import com.mobile.app.ui.DatePickerManager;
import com.mobile.app.ui.ListOfValueAdapter;
import com.mobile.app.ui.MasterContent;
import com.mobile.app.ui.ProgressDialogFragment;


import com.mobile.bo.app.dataprovider.LOVDataProvider;
import com.mobile.bo.app.dataprovider.MessageDataProvider;
import com.mobile.bo.app.dataprovider.NewsDataProvider;
import com.mobile.bo.app.dataprovider.UserDataProvider;
import com.mobile.bo.app.datatype.LovData;
import com.mobile.bo.app.datatype.MitraData;
import com.mobile.bo.app.datatype.NewsData;
import com.mobile.bo.app.datatype.ScheduleData;
import com.mobile.bo.app.datatype.UserData;
import com.mobile.framework.activity.ActivityHandler;
import com.mobile.framework.activity.ActivityNameValuePair;
import com.mobile.framework.common.DateFormatter;
import com.mobile.framework.data.SessionSharedPreference;
import com.mobile.framework.widget.ISpinnerItem;
import com.mobile.services.app.ServiceData;
import com.mobile.services.app.datatype.RequestCount;
import com.mobile.services.app.datatype.SERVICEDATARESPONSE;
import com.mobile.services.app.services.ServiceDataProvider;

import maybank.mobile.amos.R;

import android.os.AsyncTask;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mobile.bo.app.dataprovider.ScheduleDataProvider;
import android.app.Activity;
@SuppressLint("SimpleDateFormat")
public class HomeActivity extends Activity  {
    private UserData userDetail;
    private boolean isUserDetailExist = false;
    private TextView lblHeaderUser;
    private TextView lblDateTime;
//    private ImageView btnLogout;
    private LinearLayout navContainer;
    private NavigationList navigationList = null;
    private RequestCriteriaDialog requestCriteriaDialog = null;
    private NewsDialog newsDialog = null;
    private ArrayList<ISpinnerItem> lovOwner = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovStage = new ArrayList<ISpinnerItem>();
    private LOVDataProvider lovDataProvider;
    private ScheduleDataProvider scheduleDataProvider;

    
    private UserDataProvider userDataProvider;
    private int totalUnreadMessage = 0;
    private int totalUnreadNews = 0;
    private int totalMessages = 0;
    private int totalNews = 0;
    private int INITINDEXRECORD = 0;
    private int currIndex = 0;
    private News news;
    private ArrayList<String> listIdNews = null;
    private MasterContent prevShownView = null;
    private Context ctx;
    private ProgressDialog dlgProgress = null;
    private ArrayList<MitraData> mitraData;
//	private static final String TAG = "LeadsDataService";
    private ProgressDialogFragment Pdialog; 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;
        try {
			userDetail = (UserData) SessionSharedPreference.getDataFromSharedPreference(ctx, UserData.class, AppConstants.USER_SESSION);
			if(userDetail==null){
				ActivityHandler.gotoActivity(ctx, LoginActivity.class, null);
			}
        
        } catch (Exception e) {
        	ActivityHandler.gotoActivity(ctx, LoginActivity.class, null);
			e.printStackTrace();
		}
        scheduleDataProvider = new ScheduleDataProvider();
        lovDataProvider = new LOVDataProvider();
       
        getActionBar().setIcon(R.drawable.home);
        getActionBar().setTitle("Home");
        userDataProvider = new UserDataProvider();
        initActivity();
    }

    @Override
    protected void onDestroy() {
        lovDataProvider.release();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
    	doLogout();
        //ActivityHandler.gotoActivity(ctx, LoginActivity.class, null);
        //finish();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    public void initActivity() {
        setContentView(R.layout.homelayout);
        try {
           /* userDetail = (UserData) SessionSharedPreference.getDataFromSharedPreference(ctx, UserData.class, AppConstants.USER_SESSION);
            isUserDetailExist = true;*/
        } catch (Exception e) {
            finish();
            return;
        }

        navContainer = (LinearLayout) findViewById(R.id.master_navigation_layout);
//        btnLogout = (ImageView) findViewById(R.id.home_btn_logout);
        lblHeaderUser = (TextView) findViewById(R.id.master_lbl_user_information);
        lblDateTime = (TextView) findViewById(R.id.master_lbl_currentdate);
        navigationList = new NavigationList(ctx);

        if (isUserDetailExist) {
            lblHeaderUser.setText(
                    String.format("%s # %s", userDetail.getNAME(), userDetail.getLOCATION()));

            lblDateTime.setText(String.format("%s", DateFormatter.format(new Date())));
        }

//        btnLogout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showConfirmation(R.string.app_title, R.string.str_confirmation_logout);
//            }
//        });

        getCountMessage();
        registerNavigationButtonListener();
        if (navContainer != null) {
            navContainer.addView(navigationList);
        }

        if (totalUnreadNews > 0) {
            //showUnreadNews();
        }
    }

    public void getCountMessage() {
        totalMessages =0;// messageDataProvider.getCountAllMessages();
        totalNews =0;// newsDataProvider.getCountNews();
        totalUnreadMessage =0;// messageDataProvider.getCountUnreadMessage();
        totalUnreadNews = 0;//newsDataProvider.getCountUnreadNews();
    }

    public void showConfirmation(int title, int message) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctx);
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setPositiveButton(R.string.str_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                doLogout();
            }
        });

        // on pressing cancel button
        alertDialog.setNegativeButton(R.string.str_cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }

    private void doLogout() {
        userDetail = null;
        SessionSharedPreference.removeDataFromSharePreference(ctx, AppConstants.USER_SESSION);
        ActivityHandler.gotoActivity(ctx, LoginActivity.class, null);
        finish();
    }
    public void showConfirmationSubmitScore() {
	       AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctx);
	       alertDialog.setTitle("Confirm");
	       alertDialog.setMessage(R.string.msg_notification_download);
	       alertDialog.setPositiveButton(R.string.str_yes, new DialogInterface.OnClickListener() {
	           public void onClick(DialogInterface dialog, int which) {
	           	try {
	           		ActivityHandler.gotoActivity(ctx,DownloadActivity.class,null);
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
    private void registerNavigationButtonListener() {
    	navigationList.getbtndownload().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	showConfirmationSubmitScore();
            	
            }
        });
    	
        navigationList.getBtnprospek().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	ActivityHandler.gotoActivity(ctx, MainActivityDebitur.class, null); // dsppk
            }
        });
        navigationList.getbtnLov().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	ActivityHandler.gotoActivity(ctx, Debitur_InqueryActivity.class, null); // dsppk
            }
        });
        
        navigationList.getbtnsms().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityHandler.gotoActivity(ctx, List_SendEmailActivity.class, null);
            }
        });
        navigationList.getbtnupload().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityHandler.gotoActivity(ctx, List_UploadActivity.class, null);
            }
        });
      

        navigationList.getBtnUbahPassword().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	showUbahPasswordDialog();
//            	ActivityHandler.gotoActivity(ctx, Debitur_InqueryActivity.class, null); // dsppk
            }
        });
        
        navigationList.getBtnLogOut().setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showConfirmation(R.string.app_title, R.string.str_confirmation_logout);
			}
		});
        
        navigationList.getBtnDocStts().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	ActivityHandler.gotoActivity(ctx, Debitur_DocumentActivity.class, null); // dsppk
            }
        });
        
        navigationList.getBtnDebStts().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	ActivityHandler.gotoActivity(ctx, Informasi_AplikasiActivity.class, null); // dsppk
            }
        });
        
        navigationList.getBtnUplDoc().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	ActivityHandler.gotoActivity(ctx, Upload_DocumentActivity.class, null); // dsppk
            }
        });
        
    }

	 private void getDataFromServer(){
		  try {

			 	try {				 	
				  		//sinkron data schedule
		        		ArrayList<NameValuePair> params1=new ArrayList<NameValuePair>();
				        params1.add(new BasicNameValuePair("Userid", userDetail.getUSERID()));

				        SERVICEDATARESPONSE scheduleResponse= ServiceDataProvider.getScheduler(params1);
						if (scheduleResponse != null){
							ArrayList<ScheduleData> arrScheduleService= ServiceData.getSchedules(new JSONArray(scheduleResponse.getResults()));
							if (scheduleResponse.getStatus() == 1){
								for (int i=0;i<arrScheduleService.size();i++){
									scheduleDataProvider.updateSchedule(arrScheduleService.get(i));
								}
								arrScheduleService = null;
							}								
						} 
						scheduleResponse = null;
						//configSyncronizationData.setLASTSYNCHRONIZESCHEDULE(new Date());
				 }
				 catch(Exception e){
					 e.printStackTrace();
				 }
			  
				
		       ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
		       int intCount = 0;
		       SERVICEDATARESPONSE masterCountResponse = ServiceDataProvider.getDataMasterCount(params);
		       if (masterCountResponse != null) {
		           ArrayList<RequestCount> arrTabunganCountData = ServiceData.getDataMasterCount(new JSONArray(masterCountResponse.getResults()));
		           if (masterCountResponse.getStatus() == 1) {
		               RequestCount contentdata = arrTabunganCountData.get(0);
		               intCount = Integer.parseInt(contentdata.getPAGES().toString());
		               if(intCount>0)
		              	 lovDataProvider.deleteAllTabungan();
		               
		               for (int a = 0; a < intCount; a++) {
		                   String sPages = "" + (a + 1);

		               	ArrayList<NameValuePair> params1 = new ArrayList<NameValuePair>();
		                      params1.add(new BasicNameValuePair("PART", "" + sPages ));
		                      params1.add(new BasicNameValuePair("BRANCHID", "" + userDetail.getUNIT() ));
		                      SERVICEDATARESPONSE lovResponse = ServiceDataProvider.getLOV(params1);
		                     
		                     if (lovResponse != null) {
		                         ArrayList<LovData> arrLOVServiceData = ServiceData.getLOV(new JSONArray(lovResponse.getResults()));
		                         if (lovResponse.getStatus() == 1) {
		                             for (int i = 0; i < arrLOVServiceData.size(); i++) {
		                            
		                                 lovDataProvider.update(arrLOVServiceData.get(i));
		                             }
		                             arrLOVServiceData = null;
		                         }
		                         //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
		                     }
		                     lovResponse = null;
		               }
		               
		           }
			



		           
		       }
			  	    	
		           
		           } catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	  }
	  
		  
	 

/*    public void showUnreadNews() {
        if (totalNews > 0) {
            newsDialog = new NewsDialog(ctx);
            loadDataNews();
            loadViewMessage(INITINDEXRECORD);
            newsDialog.show();
        }
    }*/

    /*private void loadDataNews() {
        if (listIdNews != null) {
            listIdNews.clear();
        }
        listIdNews = newsDataProvider.getAllNews();
    }*/

    private void loadViewMessage(final int idxRecord) {
        currIndex = idxRecord;
        news = null;
        news = new News(ctx);
       // NewsData newsdata = newsDataProvider.getNewsDetail(listIdNews.get(currIndex));
       // newsdata.setISREAD("1");
        //newsDataProvider.udpateNews(newsdata);
       /* news.getLblTotalRecords().setText((idxRecord + 1) + "/" + listIdNews.size());
        news.getLblContent().setText(newsdata.getMESSAGE());
        news.getLblSubject().setText(newsdata.getSUBJECT());*/

        news.getBtnPrev().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int previndex = currIndex - 1 <= 0 ? 0 : currIndex - 1;
                loadViewMessage(previndex);
            }
        });

        news.getBtnNext().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextindex = currIndex + 1 >= listIdNews.size() - 1 ? listIdNews.size() - 1 : currIndex + 1;
                loadViewMessage(nextindex);
            }
        });

       /* news.getBtnBack().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCountMessage();
                navigationList.getBtnNews().setText("News (" + totalUnreadNews + ")");
                navigationList.getBtninbox().setText("Inbox (" + totalUnreadMessage + ")");

                newsDialog.dismiss();
            }
        });*/

        manageContentProperty(listIdNews.size());

        if (newsDialog.getRelativelayout() != null) {
            newsDialog.getRelativelayout().removeView(prevShownView);
        }

        newsDialog.getRelativelayout().addView(news);
        prevShownView = news;
    }

    public void manageContentProperty(int totalData) {
        if (totalData > 1) {
            news.getBtnPrev().setVisibility(View.VISIBLE);
            news.getBtnNext().setVisibility(View.VISIBLE);
        } else {
            news.getBtnPrev().setVisibility(View.GONE);
            news.getBtnNext().setVisibility(View.GONE);
        }
    }

    public void showUbahPasswordDialog() {
        final UbahPasswordDialog ubahPasswordDialog = new UbahPasswordDialog(ctx);
        ubahPasswordDialog.getBtnSave().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ubahPasswordDialog.checkContentValidation() == null) {
                    if (ubahPasswordDialog.isNewPasswordEqual()) {
                        if (ubahPasswordDialog.getTxtPasswordLama().getText().toString().equals(userDetail.getPASSWORD())) {
                            showProgressIndicator();
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            try {
                                                String oldpassword = ubahPasswordDialog.getTxtPasswordLama().getText().toString();
                                                String newpassword = ubahPasswordDialog.getTxtPasswordBaru().getText().toString();

                                                SERVICEDATARESPONSE response = ServiceDataProvider.changePassword(userDetail.getUSERID(), oldpassword, newpassword);
                                                if (response != null) {
                                                    if (response.getStatus() == 1) {
                                                        userDetail.setPASSWORD(newpassword);
                                                        userDataProvider.updateUser(userDetail);
                                                        ubahPasswordDialog.dismiss();
                                                        showAlertWithActionRedirect(R.string.msg_notification_ubahpassword_success);
                                                    } else {
                                                        showAlert(R.string.msg_notification_ubahpassword_failed);
                                                    }
                                                }

                                                response = null;
                                            } catch (Exception e) {
                                                showAlert(R.string.msg_notification_ubahpassword_failed);
                                            }
                                            hideProgressIndicator();
                                        }

                                    });
                                }

                                ;
                            }).start();
                        } else {
                            showAlert(R.string.msg_notification_ubahpassword_oldpasswordisnotequal);
                        }
                    } else {
                        showAlert(R.string.msg_notification_ubahpassword_newpasswordisnotequal);
                    }
                } else {
                    showAlert(R.string.msg_notification_update_field);
                }
            }
        });

        ubahPasswordDialog.getBtnCancel().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ubahPasswordDialog.dismiss();
            }
        });

        ubahPasswordDialog.show();
    }

    public void showRequestBlackboxDialog() {
        requestCriteriaDialog = new RequestCriteriaDialog(ctx);
        new LoadMitra().execute();
        lovStage = ListOfValueAdapter.createESAdapterStage(AppConstants.getAllStages());
        requestCriteriaDialog.getSpnStage().setListOfValue(lovStage, false);
        requestCriteriaDialog.getBtnApproval().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (requestCriteriaDialog.checkContentValidation() == null) {
                    if (requestCriteriaDialog.isRangeDateValid()) {
                        showProgressIndicator();
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            String milik = requestCriteriaDialog.getSpnOwner().getSelectedListOfValue().toString();
                                            String stage = requestCriteriaDialog.getSpnStage().getSelectedListOfValue().toString();
                                            String status = "";
                                            String userid = userDetail.getUSERID();
                                            Date startdate = DateFormatter.formatDate(requestCriteriaDialog.getTxtFrom().getText().toString());
                                            Date endDate = DateFormatter.formatDate(requestCriteriaDialog.getTxtTo().getText().toString());

                                            SERVICEDATARESPONSE response = ServiceDataProvider.requestBlackbox(milik, stage, status, userid, startdate, endDate);
                                            if (response != null) {
                                                if (response.getStatus() == 1) {
                                                    showAlert(R.string.msg_notification_submit_success);
                                                    requestCriteriaDialog.dismiss();
                                                } else {
                                                    showAlert(R.string.msg_notification_submit_failed);
                                                }
                                            }

                                            response = null;
                                        } catch (Exception e) {
                                            showAlert(R.string.msg_notification_submit_failed);
                                        }
                                        hideProgressIndicator();
                                    }

                                });
                            }

                            ;
                        }).start();
                    } else {
                        showAlert(R.string.msg_notification_error_date);
                    }
                } else {
                    showAlert(R.string.msg_notification_update_field);
                }
            }
        });
        requestCriteriaDialog.getBtnCancel().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestCriteriaDialog.dismiss();
            }
        });
        requestCriteriaDialog.getDatePickerFrom().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = (c.get(Calendar.MONTH));
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerManager datePickerDialog = new DatePickerManager(ctx, FromDateDateSetListener, year, month, day);
                datePickerDialog.show();
            }
        });
        requestCriteriaDialog.getDatePickerTo().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = (c.get(Calendar.MONTH));
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerManager datePickerDialog = new DatePickerManager(ctx, ToDateDateSetListener, year, month, day);
                datePickerDialog.show();
            }
        });
        requestCriteriaDialog.show();
    }

    // DatePicker Listener
    private DatePickerDialog.OnDateSetListener FromDateDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int monthOfYear, int dayOfMonth) {
            requestCriteriaDialog.getTxtFrom().setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
        }
    };

    private DatePickerDialog.OnDateSetListener ToDateDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int monthOfYear, int dayOfMonth) {
            requestCriteriaDialog.getTxtTo().setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
        }
    };

    public void showAlert(int messageId) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctx);
        alertDialog.setTitle(R.string.menu_requestblackbox);
        alertDialog.setMessage(messageId);
        alertDialog.setPositiveButton(R.string.str_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }

    public void showAlertWithActionRedirect(int messageId) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctx);
        alertDialog.setTitle(R.string.menu_ubahpassword);
        alertDialog.setMessage(messageId);
        alertDialog.setPositiveButton(R.string.str_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                doLogout();
            }
        });
        alertDialog.show();
    }

    @SuppressWarnings("deprecation")
    public void showProgressIndicator() {
        if (dlgProgress == null) {
            dlgProgress = new ProgressDialog(this);
            dlgProgress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dlgProgress.setTitle(getString(R.string.str_informasi));
            dlgProgress.setMessage("Sedang Memuat Data");
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

    private class LoadMitra extends AsyncTask<Void, Void, Void> {
        private boolean responseSuccess = false;

        @Override
        protected Void doInBackground(Void... paramss) {
            try {
                ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("userid", userDetail.getUSERID()));
                params.add(new BasicNameValuePair("Unit", userDetail.getUNIT()));
                SERVICEDATARESPONSE mitraResponse = ServiceDataProvider.getAllMitra(params);
                if (mitraResponse != null) {
                    mitraData = ServiceData.getMitra(new JSONArray(mitraResponse.getResults()));
                    if (mitraResponse.getStatus() == 1) {
                        lovOwner = ListOfValueAdapter.createESAdapterMitra(mitraData);
                    }
                }
                mitraResponse = null;
                responseSuccess = true;
            } catch (Exception e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            if (responseSuccess) {
                requestCriteriaDialog.getSpnOwner().setListOfValue(lovOwner, false);
            }
        }
    }

	public void onProgressCancelled() {
		// TODO Auto-generated method stub
		
	}
}
