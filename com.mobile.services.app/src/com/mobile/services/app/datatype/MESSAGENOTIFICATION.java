package com.mobile.services.app.datatype;

import java.util.ArrayList;
import com.google.gson.Gson;
import com.mobile.bo.app.datatype.MessageData;
import com.mobile.bo.app.datatype.NewsData;

public class MESSAGENOTIFICATION {
	private String ID;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	
	public String messageToJSONString(ArrayList<MessageData> arrMessage) throws Exception {  
		Gson gsonGeoLocation =  new Gson();
		ArrayList<MESSAGENOTIFICATION> arrayMessageRequest=new ArrayList<MESSAGENOTIFICATION>();
		
		 for (int i=0;i<arrMessage.size();i++){
			 MESSAGENOTIFICATION msg=new MESSAGENOTIFICATION();
			 MessageData message= arrMessage.get(i);
			 msg.setID(message.getID().toString());
			 arrayMessageRequest.add(msg);
		 }
		return gsonGeoLocation.toJson(arrayMessageRequest);
	}
	
	public String newsToJSONString(ArrayList<NewsData> arrNews) throws Exception {  
		Gson gsonGeoLocation =  new Gson();
		ArrayList<MESSAGENOTIFICATION> arrayMessageRequest=new ArrayList<MESSAGENOTIFICATION>();
		
		 for (int i=0;i<arrNews.size();i++){
			 MESSAGENOTIFICATION msg=new MESSAGENOTIFICATION();
			 NewsData message= arrNews.get(i);
			 msg.setID(message.getID().toString());
			 arrayMessageRequest.add(msg);
		 }
		return gsonGeoLocation.toJson(arrayMessageRequest);
	}
}
