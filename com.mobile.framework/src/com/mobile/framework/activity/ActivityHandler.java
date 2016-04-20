package com.mobile.framework.activity;

import java.util.List;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class ActivityHandler {

	public static void gotoActivity(Context ctx,Class<?> cls,List<ActivityNameValuePair> params) {
		Intent intent = new Intent(ctx, cls);		
		if (params != null){
			for (int i=0;i<params.size();i++){
				intent.putExtra(params.get(i).getKEY(), params.get(i).getVALUE());
			}
		}
		ctx.startActivity(intent);
	}
	
	public static void makePhoneCall(Context ctx,String phonenumber) throws Exception{
		Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(phonenumber));
		ctx.startActivity(intent);
	}
	public static void sendSMS(Context ctx,String phonenumber) throws Exception{
		Intent intent = new Intent(Intent.ACTION_SENDTO);
		intent.addCategory(Intent.CATEGORY_DEFAULT);
		intent.setType("vnd.android-dir/mms-sms");
		intent.setData(Uri.parse("sms:" + phonenumber));
		ctx.startActivity(intent);
	}
	
}
