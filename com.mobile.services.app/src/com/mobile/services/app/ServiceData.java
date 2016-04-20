package com.mobile.services.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
import com.google.android.gms.maps.model.LatLng;
import com.mobile.bo.app.datatype.DataType_Amos_Document_Upload;
import com.mobile.bo.app.datatype.DataType_Ams_informationApk_Detail;
import com.mobile.bo.app.datatype.DataType_Ams_informationAplikasi;
import com.mobile.bo.app.datatype.DataType_inbox_document;
import com.mobile.bo.app.datatype.Datatype_Appr_Collateral;
import com.mobile.bo.app.datatype.Datatype_Appr_Dokument;
import com.mobile.bo.app.datatype.Datatype_Appr_History;
import com.mobile.bo.app.datatype.Datatype_Appr_History_Workflow;
import com.mobile.bo.app.datatype.Datatype_Appr_Inbox;
import com.mobile.bo.app.datatype.Datatype_Appr_Inquery;
import com.mobile.bo.app.datatype.Datatype_Appr_Mch_Valuation_Int;
import com.mobile.bo.app.datatype.Datatype_Appr_NegativeList;
import com.mobile.bo.app.datatype.Datatype_Appr_Pb_Pembanding_Int;
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
import com.mobile.bo.app.datatype.Datatype_Apprs_Main;
import com.mobile.bo.app.datatype.Datatype_attachment;
import com.mobile.bo.app.datatype.Z_CashCheckupData;
import com.mobile.bo.app.datatype.FollowupData;
import com.mobile.bo.app.datatype.LovData;
import com.mobile.bo.app.datatype.MessageData;
import com.mobile.bo.app.datatype.MitraData;
import com.mobile.bo.app.datatype.MotionTrackerData;
import com.mobile.bo.app.datatype.MotionTrackerDetailData;
import com.mobile.bo.app.datatype.NewsData;
import com.mobile.bo.app.datatype.PhotoData;
import com.mobile.bo.app.datatype.ProspekData;
import com.mobile.bo.app.datatype.ProspekResponse;
import com.mobile.bo.app.datatype.ScheduleData;
import com.mobile.bo.app.datatype.StatistikData;
import com.mobile.bo.app.datatype.TabunganData;
import com.mobile.bo.app.datatype.TagihanData;
import com.mobile.bo.app.datatype.UserData;
import com.mobile.framework.common.DateFormatter;
import com.mobile.services.app.datatype.CHECKVERSION;
import com.mobile.services.app.datatype.RequestCount;
import com.mobile.services.app.datatype.SERVICEDATARESPONSE;
import com.mobile.services.app.services.JSONServiceHandler;


public class ServiceData {	
	public static ArrayList<PhotoData> getDocumentFile(JSONArray arrJSON) throws Exception{
		ArrayList<PhotoData> arrData=new ArrayList<PhotoData>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				PhotoData Main=new PhotoData();	
				Main.updatePhotoBlackboxFromJSON(obj);
				arrData.add(Main);
			}
		}
		
		return arrData;
	}
	public static ArrayList<DataType_Amos_Document_Upload> GetDocumentamos(JSONArray arrJSON) throws Exception{
		ArrayList<DataType_Amos_Document_Upload> arrData=new ArrayList<DataType_Amos_Document_Upload>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				DataType_Amos_Document_Upload Main=new DataType_Amos_Document_Upload();	
				Main.updateMainFromJSON(obj);
				arrData.add(Main);
			}
		}
		
		return arrData;
	}
	public static ArrayList<RequestCount> GetdataInqueryDocumentCount(JSONArray arrJSON) throws Exception{
		ArrayList<RequestCount> arrData=new ArrayList<RequestCount>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				RequestCount Main=new RequestCount();	
				Main.updateRequestCountFromJSON(obj);
				arrData.add(Main);
			}
		}
		
		return arrData;
	}
	public static ArrayList<DataType_inbox_document> GetdataInqueryDocument(JSONArray arrJSON) throws Exception{
		ArrayList<DataType_inbox_document> arrData=new ArrayList<DataType_inbox_document>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				DataType_inbox_document Main=new DataType_inbox_document();	
				Main.updateMainFromJSON(obj);
				arrData.add(Main);
			}
		}
		
		return arrData;
	}
	
	public static ArrayList<RequestCount> GetCount(JSONArray arrJSON) throws Exception{
		ArrayList<RequestCount> arrData=new ArrayList<RequestCount>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				RequestCount Main=new RequestCount();	
				Main.updateRequestCountFromJSON(obj);
				arrData.add(Main);
			}
		}
		
		return arrData;
	} // dsppk 1 
	public static ArrayList<DataType_Ams_informationAplikasi> GetdataInformasiAplikasi(JSONArray arrJSON) throws Exception{
		ArrayList<DataType_Ams_informationAplikasi> arrData=new ArrayList<DataType_Ams_informationAplikasi>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				DataType_Ams_informationAplikasi Main=new DataType_Ams_informationAplikasi();	
				Main.updateMainFromJSON(obj);
				arrData.add(Main);
			}
		}
		
		return arrData;
	} // dsppk 1
	public static ArrayList<DataType_Ams_informationApk_Detail> GetdataDocDetail(JSONArray arrJSON) throws Exception{
		ArrayList<DataType_Ams_informationApk_Detail> arrData=new ArrayList<DataType_Ams_informationApk_Detail>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				DataType_Ams_informationApk_Detail Main = new DataType_Ams_informationApk_Detail();	
				Main.updateMainFromJSON(obj);
				arrData.add(Main);
			}
		}
		
		return arrData;
	} // dsppk 2
	public static ArrayList<Datatype_attachment> GetAttachmentStatus(JSONArray arrJSON) throws Exception{
		ArrayList<Datatype_attachment> arrData=new ArrayList<Datatype_attachment>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				Datatype_attachment Main=new Datatype_attachment();	
				Main.updateMainFromJSON(obj);
				arrData.add(Main);
			}
		}
		
		return arrData;
	}
	public static ArrayList<Datatype_attachment> GetDocumentAttachmentDocument(JSONArray arrJSON) throws Exception{
		ArrayList<Datatype_attachment> arrData=new ArrayList<Datatype_attachment>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				Datatype_attachment Main=new Datatype_attachment();	
				Main.updateMainFromJSON(obj);
				arrData.add(Main);
			}
		}
		
		return arrData;
	}
	public static ArrayList<PhotoData> GetAttachment(JSONArray arrJSON) throws Exception{
		ArrayList<PhotoData> arrData=new ArrayList<PhotoData>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				PhotoData Main=new PhotoData();	
				Main.updatePhotoBlackboxFromJSON(obj);
				arrData.add(Main);
			}
		}
		
		return arrData;
	}
	public static ArrayList<Datatype_Appr_Inquery> GetdataInquery(JSONArray arrJSON) throws Exception{
		ArrayList<Datatype_Appr_Inquery> arrData=new ArrayList<Datatype_Appr_Inquery>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				Datatype_Appr_Inquery Main=new Datatype_Appr_Inquery();	
				Main.updateMainFromJSON(obj);
				arrData.add(Main);
			}
		}
		
		return arrData;
	}
	public static ArrayList<RequestCount> GetdataInqueryCount(JSONArray arrJSON) throws Exception{
		ArrayList<RequestCount> arrData=new ArrayList<RequestCount>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				RequestCount Main=new RequestCount();	
				Main.updateRequestCountFromJSON(obj);
				arrData.add(Main);
			}
		}
		
		return arrData;
	}
	
	public static ArrayList<Datatype_Appr_Pb_sampling_bangunan> GetNilaiSampling(JSONArray arrJSON) throws Exception{
		ArrayList<Datatype_Appr_Pb_sampling_bangunan> arrData=new ArrayList<Datatype_Appr_Pb_sampling_bangunan>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				Datatype_Appr_Pb_sampling_bangunan Main=new Datatype_Appr_Pb_sampling_bangunan();	
				Main.updateMainFromJSON(obj);
				arrData.add(Main);
			}
		}
		
		return arrData;
	}
	public static ArrayList<Datatype_Appr_valBangunan> GetvaluationBangunan(JSONArray arrJSON) throws Exception{
		ArrayList<Datatype_Appr_valBangunan> arrData=new ArrayList<Datatype_Appr_valBangunan>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				Datatype_Appr_valBangunan Main=new Datatype_Appr_valBangunan();	
				Main.updateMainFromJSON(obj);
				arrData.add(Main);
			}
		}
		
		return arrData;
	}
	public static ArrayList<Datatype_Appr_Sertifikat> Getsertifikat(JSONArray arrJSON) throws Exception{
		ArrayList<Datatype_Appr_Sertifikat> arrData=new ArrayList<Datatype_Appr_Sertifikat>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				Datatype_Appr_Sertifikat Main=new Datatype_Appr_Sertifikat();	
				Main.updateMainFromJSON(obj);
				arrData.add(Main);
			}
		}
		
		return arrData;
	}
	public static ArrayList<Datatype_Appr_imb> GetIMB(JSONArray arrJSON) throws Exception{
		ArrayList<Datatype_Appr_imb> arrData=new ArrayList<Datatype_Appr_imb>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				Datatype_Appr_imb Main=new Datatype_Appr_imb();	
				Main.updateMainFromJSON(obj);
				arrData.add(Main);
			}
		}
		
		return arrData;
	}
	public static ArrayList<Datatype_Appr_History> GetHistoryAppraisal(JSONArray arrJSON) throws Exception{
		ArrayList<Datatype_Appr_History> arrData=new ArrayList<Datatype_Appr_History>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				Datatype_Appr_History Main=new Datatype_Appr_History();	
				Main.updateMainFromJSON(obj);
				arrData.add(Main);
			}
		}
		
		return arrData;
	}
	public static ArrayList<Datatype_Appr_History_Workflow> GetHistoryWorkFlow(JSONArray arrJSON) throws Exception{
		ArrayList<Datatype_Appr_History_Workflow> arrData=new ArrayList<Datatype_Appr_History_Workflow>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				Datatype_Appr_History_Workflow Main=new Datatype_Appr_History_Workflow();	
				Main.updateMainFromJSON(obj);
				arrData.add(Main);
			}
		}
		
		return arrData;
	}
	public static ArrayList<Datatype_Appr_Vhc_Pembanding_Int> GetPembandingKendaraan(JSONArray arrJSON) throws Exception{
		ArrayList<Datatype_Appr_Vhc_Pembanding_Int> arrData=new ArrayList<Datatype_Appr_Vhc_Pembanding_Int>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				Datatype_Appr_Vhc_Pembanding_Int Main=new Datatype_Appr_Vhc_Pembanding_Int();	
				Main.updateMainFromJSON(obj);
				arrData.add(Main);
			}
		}
		
		return arrData;
	}
	
	public static ArrayList<Datatype_Appr_Rtb_Pembanding_Int> getDataPembanding(JSONArray arrJSON) throws Exception{
		ArrayList<Datatype_Appr_Rtb_Pembanding_Int> arrData=new ArrayList<Datatype_Appr_Rtb_Pembanding_Int>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				Datatype_Appr_Rtb_Pembanding_Int Main=new Datatype_Appr_Rtb_Pembanding_Int();	
				Main.updateMainFromJSON(obj);
				arrData.add(Main);
			}
		}
		
		return arrData;
	}
	
	
	public static ArrayList<Datatype_Appr_NegativeList> GetNegativeList(JSONArray arrJSON) throws Exception{
		ArrayList<Datatype_Appr_NegativeList> arrData=new ArrayList<Datatype_Appr_NegativeList>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				Datatype_Appr_NegativeList Main=new Datatype_Appr_NegativeList();	
				Main.updateMainFromJSON(obj);
				arrData.add(Main);
			}
		}
		
		return arrData;
	}
	
	
	
	public static ArrayList<Datatype_Appr_Dokument> GetDocument(JSONArray arrJSON) throws Exception{
		ArrayList<Datatype_Appr_Dokument> arrData=new ArrayList<Datatype_Appr_Dokument>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				Datatype_Appr_Dokument Main=new Datatype_Appr_Dokument();	
				Main.updateMainFromJSON(obj);
				arrData.add(Main);
			}
		}
		
		return arrData;
	}
	
	public static ArrayList<Datatype_Appr_Inbox> getInboxAppr(JSONArray arrJSON) throws Exception{
		ArrayList<Datatype_Appr_Inbox> arrData=new ArrayList<Datatype_Appr_Inbox>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				Datatype_Appr_Inbox Main=new Datatype_Appr_Inbox();	
				Main.updateMainFromJSON(obj);
				arrData.add(Main);
			}
		}
		
		return arrData;
	}
	
	public static ArrayList<RequestCount> getDataMasterCount(JSONArray arrJSON) throws Exception{
		ArrayList<RequestCount> arrData=new ArrayList<RequestCount>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				RequestCount Main=new RequestCount();	
				Main.updateRequestCountFromJSON(obj);
				arrData.add(Main);
			}
		}
		
		return arrData;
	}
	

	
	public static ArrayList<Datatype_Appr_Progress_Developer_Int> getProgBangunanDeveloper(JSONArray arrJSON) throws Exception{
		ArrayList<Datatype_Appr_Progress_Developer_Int> arrData=new ArrayList<Datatype_Appr_Progress_Developer_Int>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				Datatype_Appr_Progress_Developer_Int Main=new Datatype_Appr_Progress_Developer_Int();	
				Main.updateMainFromJSON(obj);
				arrData.add(Main);
			}
		}
		
		return arrData;
	}
	
	public static ArrayList<Datatype_Appr_Progress_Bangunan_Int> getProgresbangunan(JSONArray arrJSON) throws Exception{
		ArrayList<Datatype_Appr_Progress_Bangunan_Int> arrData=new ArrayList<Datatype_Appr_Progress_Bangunan_Int>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				Datatype_Appr_Progress_Bangunan_Int Main=new Datatype_Appr_Progress_Bangunan_Int();	
				Main.updateMainFromJSON(obj);
				arrData.add(Main);
			}
		}
		
		return arrData;
	}
	
	public static ArrayList<Datatype_Appr_Mch_Valuation_Int> MCHValuation(JSONArray arrJSON) throws Exception{
		ArrayList<Datatype_Appr_Mch_Valuation_Int> arrData=new ArrayList<Datatype_Appr_Mch_Valuation_Int>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				Datatype_Appr_Mch_Valuation_Int Main=new Datatype_Appr_Mch_Valuation_Int();	
				Main.updateMainFromJSON(obj);
				arrData.add(Main);
			}
		}
		
		return arrData;
	}
	
	
	public static ArrayList<Datatype_Appr_Pb_Valuation_Int> getPBValuation(JSONArray arrJSON) throws Exception{
		ArrayList<Datatype_Appr_Pb_Valuation_Int> arrData=new ArrayList<Datatype_Appr_Pb_Valuation_Int>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				Datatype_Appr_Pb_Valuation_Int Main=new Datatype_Appr_Pb_Valuation_Int();	
				Main.updateMainFromJSON(obj);
				arrData.add(Main);
			}
		}
		
		return arrData;
	}
	
	public static ArrayList<Datatype_Appr_Rtb_Valuation_Int> getvaluationTanah(JSONArray arrJSON) throws Exception{
		ArrayList<Datatype_Appr_Rtb_Valuation_Int> arrData=new ArrayList<Datatype_Appr_Rtb_Valuation_Int>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				Datatype_Appr_Rtb_Valuation_Int Main=new Datatype_Appr_Rtb_Valuation_Int();	
				Main.updateMainFromJSON(obj);
				arrData.add(Main);
			}
		}
		
		return arrData;
	}
	public static ArrayList<Datatype_Appr_Vhc_Valuation_Int> GetValuationKendaraan(JSONArray arrJSON) throws Exception{
		ArrayList<Datatype_Appr_Vhc_Valuation_Int> arrData=new ArrayList<Datatype_Appr_Vhc_Valuation_Int>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				Datatype_Appr_Vhc_Valuation_Int Main=new Datatype_Appr_Vhc_Valuation_Int();	
				Main.updateMainFromJSON(obj);
				arrData.add(Main);
			}
		}
		
		return arrData;
	}
	public static ArrayList<Datatype_Appr_Rtb_Detail_Int> getDetailTanah(JSONArray arrJSON) throws Exception{
		ArrayList<Datatype_Appr_Rtb_Detail_Int> arrData=new ArrayList<Datatype_Appr_Rtb_Detail_Int>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				Datatype_Appr_Rtb_Detail_Int Main=new Datatype_Appr_Rtb_Detail_Int();	
				Main.updateMainFromJSON(obj);
				arrData.add(Main);
			}
		}
		
		return arrData;
	}
	public static ArrayList<Datatype_Appr_Rtb_Data_Int> getRtbData(JSONArray arrJSON) throws Exception{
		ArrayList<Datatype_Appr_Rtb_Data_Int> arrData=new ArrayList<Datatype_Appr_Rtb_Data_Int>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				Datatype_Appr_Rtb_Data_Int Main=new Datatype_Appr_Rtb_Data_Int();	
				Main.updateMainFromJSON(obj);
				arrData.add(Main);
			}
		}
		
		return arrData;
	}
	
	public static ArrayList<Datatype_Appr_Vch_Data_Int> getVhcData(JSONArray arrJSON) throws Exception{
		ArrayList<Datatype_Appr_Vch_Data_Int> arrData=new ArrayList<Datatype_Appr_Vch_Data_Int>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				Datatype_Appr_Vch_Data_Int Main=new Datatype_Appr_Vch_Data_Int();	
				Main.updateMainFromJSON(obj);
				arrData.add(Main);
			}
		}
		
		return arrData;
	}
	
	public static ArrayList<Datatype_Appr_Rtb_Cek_Tata_Kota_Int> getTataKota(JSONArray arrJSON) throws Exception{
		ArrayList<Datatype_Appr_Rtb_Cek_Tata_Kota_Int> arrData=new ArrayList<Datatype_Appr_Rtb_Cek_Tata_Kota_Int>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				Datatype_Appr_Rtb_Cek_Tata_Kota_Int Main=new Datatype_Appr_Rtb_Cek_Tata_Kota_Int();	
				Main.updateMainFromJSON(obj);
				arrData.add(Main);
			}
		}
		
		return arrData;
	}

	
	public static ArrayList<Datatype_Appr_Collateral> getAppr_collateral(JSONArray arrJSON) throws Exception{
		ArrayList<Datatype_Appr_Collateral> arrData=new ArrayList<Datatype_Appr_Collateral>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				Datatype_Appr_Collateral Main=new Datatype_Appr_Collateral();	
				Main.updateMainFromJSON(obj);
				arrData.add(Main);
			}
		}
		
		return arrData;
	}

	public static List<ProspekData> getDataBlackbox(JSONArray arrObj){
		List<ProspekData> resList=new ArrayList<ProspekData>();
		if (arrObj.length() > 0){
			for (int i=0;i<arrObj.length();i++){						
				try {
					JSONObject obj = arrObj.getJSONObject(i);
					ProspekData pd=new ProspekData();
					pd.setID("P"+DateFormatter.formatStringFORMATDDMMYYHHMMSS(new Date())+obj.getString("USERID")+(i+1));
					pd.updateBlackboxFromJSON(obj);
					resList.add(pd);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return resList;	
	}
	
	public static List<FollowupData> getDataBlackbox(JSONArray arrObj,ProspekData prospek){
		List<FollowupData> resList=new ArrayList<FollowupData>();
		if (arrObj.length() > 0){
			for (int i=0;i<arrObj.length();i++){						
				try {
					JSONObject obj = arrObj.getJSONObject(i);
					FollowupData fd=new FollowupData();	
					fd.updateBlackboxFromJSON(obj);
					fd.setUSERID(prospek.getUSERID());
					fd.setPARENTID(prospek.getID().toString());
					fd.setSTAGE(prospek.getSTAGE());
					fd.setPROSPEKID(prospek.getPROSPEKID());
					resList.add(fd);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return resList;	
	}
	
	/*public static List<PhotoData> getDataPhotoBlackbox(JSONArray arrObj,ProspekData prospek){
		List<PhotoData> resList=new ArrayList<PhotoData>();
		if (arrObj.length() > 0){
			for (int i=0;i<arrObj.length();i++){						
				try {
					JSONObject obj = arrObj.getJSONObject(i);
					PhotoData pd=new PhotoData();	
					pd.updatePhotoBlackboxFromJSON(obj);
					pd.setPROSPEKID(prospek.getPROSPEKID());
					pd.setPROSPEKIDLOCAL(prospek.getID());
					resList.add(pd);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return resList;	
	}*/
	
	public static StatistikData getStatistikData(JSONObject obj) throws Exception {
		StatistikData pd=new StatistikData();	
		pd.updateStatistikDataFromJSON(obj);
		return pd;	
	}
	
	public static MotionTrackerData getMotionTrackerData(JSONObject obj){
		ArrayList<MotionTrackerDetailData> resAktual=new ArrayList<MotionTrackerDetailData>();
		MotionTrackerData mt=new MotionTrackerData();	
		try {
			mt.updateDetailAktualDataFromJSON(obj);
			JSONArray arrObjAktual = new JSONArray(obj.getString("AKTUAL"));			
			for (int i=0;i<arrObjAktual.length();i++){						
				try {
					MotionTrackerDetailData mtd=new MotionTrackerDetailData();	
					JSONObject objTrackerDetail = arrObjAktual.getJSONObject(i);
					
					ArrayList<LatLng> resMap=new ArrayList<LatLng>();
					JSONArray objTrackerMap = new JSONArray(objTrackerDetail.getString("MAP"));			

					for (int j=0;j<objTrackerMap.length();j++){
						JSONObject objMap = objTrackerMap.getJSONObject(j);
						resMap.add(new LatLng(Double.parseDouble(objMap.getString("LATITUDE")), Double.parseDouble(objMap.getString("LONGITUDE"))));
					}
					
					mtd.updateDetailAktualDataFromJSON(objTrackerDetail);	
					mtd.setMAPDATA(resMap);
					
					resAktual.add(mtd);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		mt.setAKTUAL(resAktual);
		
		return mt;	
	}
	
	public static Z_CashCheckupData getCheckupData(JSONObject obj) throws Exception{
		Z_CashCheckupData ccd=new Z_CashCheckupData();	
		ccd.updateCashCheckupFromJSON(obj);
		return ccd;
	}
	
	public static ArrayList<MitraData> getMitra(JSONArray arrObj) throws Exception{
		ArrayList<MitraData> arrMd=new ArrayList<MitraData>();	
		for (int i=0;i<arrObj.length();i++){
			MitraData md=new MitraData();
			md.updateMitraFromJSON(arrObj.getJSONObject(i));
			arrMd.add(md);
		}		
		return arrMd;
	}
	
	public static UserData getUser(JSONObject obj) throws Exception{
		UserData ud=new UserData();	
		ud.updateUserFromJSON(obj);
		return ud;
	}
	
	public static ArrayList<LovData> getLOV(JSONArray arrJSON) throws Exception{
		ArrayList<LovData> arrData=new ArrayList<LovData>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				LovData lov=new LovData();	
				lov.updateLOVFromJSON(obj);
				arrData.add(lov);
			}
		}
		
		return arrData;
	}
	
	public static ArrayList<TabunganData> getTabungan(JSONArray arrJSON) throws Exception{
		ArrayList<TabunganData> arrData=new ArrayList<TabunganData>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				TabunganData tb=new TabunganData();	
				tb.updateTabunganMasterFromJSON(obj);
				arrData.add(tb);
			}
		}
		
		return arrData;
	}
	public static ArrayList<RequestCount> getTagihanCount(JSONArray arrJSON) throws Exception{
		ArrayList<RequestCount> arrData=new ArrayList<RequestCount>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				RequestCount tg=new RequestCount();	
				tg.updateRequestCountFromJSON(obj);
				arrData.add(tg);
			}
		}
		
		return arrData;
	}
	public static ArrayList<TagihanData> getTagihan(JSONArray arrJSON) throws Exception{
		ArrayList<TagihanData> arrData=new ArrayList<TagihanData>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				TagihanData tg=new TagihanData();	
				tg.setID("TG"+DateFormatter.formatStringFORMATDDMMYYHHMMSS(new Date())+(i+1));
				tg.updateTagihanMasterFromJSON(obj);
				arrData.add(tg);
			}
		}
		
		return arrData;
	}
	
	public static ArrayList<NewsData> getNews(JSONArray arrJSON) throws Exception{
		ArrayList<NewsData> arrData=new ArrayList<NewsData>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				NewsData nw=new NewsData();	
				nw.updateNewsFromJSON(obj);
				nw.setISREAD("0");
				arrData.add(nw);
			}
		}
		
		return arrData;
	}
	
	public static ArrayList<MessageData> getMessages(JSONArray arrJSON) throws Exception{
		ArrayList<MessageData> arrData=new ArrayList<MessageData>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				MessageData ms=new MessageData();	
				ms.updateMessageFromJSON(obj);
				ms.setISREAD("0");
				arrData.add(ms);
			}
		}
		
		return arrData;
	}
	
	public static ArrayList<ProspekResponse> getProspekResponse(JSONArray arrJSON) throws Exception{
		ArrayList<ProspekResponse> arrData=new ArrayList<ProspekResponse>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				ProspekResponse pr=new ProspekResponse();	
				pr.updateProspekResponseFromJSON(obj);				
				arrData.add(pr);
			}
		}
		
		return arrData;
	}
	
	public static ArrayList<ScheduleData> getSchedules(JSONArray arrJSON) throws Exception{
		ArrayList<ScheduleData> arrData=new ArrayList<ScheduleData>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				ScheduleData ms=new ScheduleData();	
				ms.updateScheduleFromJSON(obj);
				arrData.add(ms);
			}
		}
		
		return arrData;
	}
	public static ArrayList<CHECKVERSION> getVersion(JSONArray arrJSON) throws Exception{
		ArrayList<CHECKVERSION> arrData=new ArrayList<CHECKVERSION>();
		if (arrJSON.length() > 0){
			for (int i=0;i<arrJSON.length();i++ ){
				JSONObject obj = arrJSON.getJSONObject(i);
				CHECKVERSION ms=new CHECKVERSION();	
				ms.updateVersionFromJSON(obj);
				arrData.add(ms);
			}
		}
		
		return arrData;
	}

}
