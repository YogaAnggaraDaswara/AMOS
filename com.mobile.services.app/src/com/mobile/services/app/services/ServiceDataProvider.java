package com.mobile.services.app.services;

import java.util.ArrayList;
import java.util.Date;

import org.apache.http.NameValuePair;
import org.json.JSONObject;

import com.mobile.bo.app.datatype.Datatype_Appr_imb;
import com.mobile.bo.app.datatype.Datatype_Apprs_Main;
import com.mobile.bo.app.datatype.FollowupData;
import com.mobile.bo.app.datatype.GeoLocationData;
import com.mobile.bo.app.datatype.LoginHistoryData;
import com.mobile.bo.app.datatype.MessageData;
import com.mobile.bo.app.datatype.NewsData;
import com.mobile.bo.app.datatype.PhotoData;
import com.mobile.bo.app.datatype.ProspekData;
import com.mobile.bo.app.datatype.StateHistoryData;

import com.mobile.services.app.datatype.BLACKBOXDATARESULTREQUEST;
import com.mobile.services.app.datatype.CHANGEPASSWORDREQUEST;
import com.mobile.services.app.datatype.CHECKVERSION;
import com.mobile.services.app.datatype.DATA_RESPONSE;
import com.mobile.services.app.datatype.DATA_RESPONSE_SCORE;
import com.mobile.services.app.datatype.DATA_RESPONSE_STATUS;
import com.mobile.services.app.datatype.GEOLOCATIONREQUEST;
import com.mobile.services.app.datatype.LOGINHISTORYREQUEST;
import com.mobile.services.app.datatype.MESSAGENOTIFICATION;
import com.mobile.services.app.datatype.PHOTOREQUEST;
import com.mobile.services.app.datatype.PHOTORESPONSE;
import com.mobile.services.app.datatype.UPLOADPHOTOREQUEST;
import com.mobile.services.app.datatype.PROSPEKREQUEST;
import com.mobile.services.app.datatype.PROSPEKRESPONSE;
import com.mobile.services.app.datatype.REQUESTBLACKBOX;
import com.mobile.services.app.datatype.SERVICEDATARESPONSE;
import com.mobile.services.app.datatype.STATEHISTORYREQUEST;
import com.mobile.services.app.datatype.TRANSAKSIREQUEST;
import com.mobile.services.app.datatype.TOKENREQUEST;
import com.mobile.services.app.datatype.TRANSAKSIRESPONSE;
import com.mobile.services.app.datatype.USERDATAREQUEST;

public class ServiceDataProvider {
	////amos
	//old
	/*public static PHOTORESPONSE uploadProspekPhotoData(String Data) throws Exception{
		PHOTORESPONSE photoResponse=new PHOTORESPONSE();	
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("AmosService.svc/insertFileUpload/New",Data);
		photoResponse.updateUploadPhoto(objresponse);	
		return photoResponse;
	}*/
	//end old
	
	//new
	public static DATA_RESPONSE uploadProspekPhotoData(String Data) throws Exception{
		DATA_RESPONSE photoResponse=new DATA_RESPONSE();	
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("AmosService.svc/insertFileUpload/New",Data);
			
		return photoResponse.updateFromJSONR(objresponse);
	}
	//end new
	
	public static ArrayList<DATA_RESPONSE_SCORE> submitData_amos_score(String Data) throws Exception{
		//PROSPEKREQUEST req= new PROSPEKREQUEST();
		DATA_RESPONSE_SCORE response=new DATA_RESPONSE_SCORE();
		//String jsonparamrequest = req.updateToJSONString(prospeks,actiontype);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		//JSONObject objresponse= jsh.JSONServicePostData("AmosService.svc/InsertAmos/New",Data);
		JSONObject objresponse= jsh.JSONServicePostData("AmosService.svc/InsertAmosScore/New",Data);
		return response.updateFromJSONList(objresponse);
	}
	public static ArrayList<DATA_RESPONSE_SCORE> submitData_email(String Data) throws Exception{
		//PROSPEKREQUEST req= new PROSPEKREQUEST();
		DATA_RESPONSE_SCORE response=new DATA_RESPONSE_SCORE();
		//String jsonparamrequest = req.updateToJSONString(prospeks,actiontype);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		//JSONObject objresponse= jsh.JSONServicePostData("AmosService.svc/InsertAmos/New",Data);
		JSONObject objresponse= jsh.JSONServicePostData("AmosService.svc/SendEmail/New",Data);
		return response.updateFromJSONList(objresponse);
	}
	public static ArrayList<DATA_RESPONSE> submitData_dokumen_amos(String Data) throws Exception{
		//PROSPEKREQUEST req= new PROSPEKREQUEST();
		DATA_RESPONSE response=new DATA_RESPONSE();
		//String jsonparamrequest = req.updateToJSONString(prospeks,actiontype);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("AmosService.svc/InsertDocument/New",Data);

		return response.updateFromJSONList(objresponse);
	}	
	public static SERVICEDATARESPONSE getDocumentbyregno(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AmosService.svc/getDocumentbyregno",params);
		response.updateFromJSON(objresponse);

		return response;
		
	}
	public static SERVICEDATARESPONSE getDocumentFile(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AmosService.svc/getDocumentFile",params);
		response.updateFromJSON(objresponse);

		return response;
		
	}
	public static SERVICEDATARESPONSE GetdataInqueryDocummentCount(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AmosService.svc/GetDocumentCount",params);
		response.updateFromJSON(objresponse);

		return response;
		
	}
	public static ArrayList<DATA_RESPONSE_SCORE> submitData_amos(String Data) throws Exception{
		//PROSPEKREQUEST req= new PROSPEKREQUEST();
		DATA_RESPONSE_SCORE response=new DATA_RESPONSE_SCORE();
		//String jsonparamrequest = req.updateToJSONString(prospeks,actiontype);	
				
		JSONServiceHandler jsh=new JSONServiceHandler();
		//JSONObject objresponse= jsh.JSONServicePostData("AmosService.svc/InsertAmos/New",Data);
		JSONObject objresponse= jsh.JSONServicePostData("AmosService.svc/InsertAmos/New",Data);
		return response.updateFromJSONList(objresponse);
	
	}
	public static ArrayList<DATA_RESPONSE_SCORE> uploadPendingSubmited(String Data) throws Exception{
		DATA_RESPONSE_SCORE response=new DATA_RESPONSE_SCORE();
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("AmosService.svc/InsertAmosPending/New",Data);
		return response.updateFromJSONList(objresponse);
	}
	public static SERVICEDATARESPONSE GetdataInqueryDocumment(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AmosService.svc/GetDocument",params);
		response.updateFromJSON(objresponse);

		return response;
		
	}
	
	public static SERVICEDATARESPONSE GetdataInformasiAplikasiCount(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AmosService.svc/GetInformasiAplikasiCount",params);
		response.updateFromJSON(objresponse);

		return response;
		
	} // dsppk 1
	public static SERVICEDATARESPONSE GetdataInformasiAplikasi(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AmosService.svc/GetInformasiAplikasi",params);
		response.updateFromJSON(objresponse);

		return response;
		
	} // dsppk 1
	
	public static SERVICEDATARESPONSE GetDataDocDetailCount(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AmosService.svc/GetDataDocDetailCount",params);
		response.updateFromJSON(objresponse);

		return response;
		
	} // dsppk 2
	public static SERVICEDATARESPONSE GetDataDocDetail(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AmosService.svc/GetDataDocDetail",params);
		response.updateFromJSON(objresponse);

		return response;
		
	} // dsppk 2
	////

	
	public static SERVICEDATARESPONSE UpdateReceive(String Data) throws Exception{
		//PROSPEKREQUEST req= new PROSPEKREQUEST();
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();
		//String jsonparamrequest = req.updateToJSONString(prospeks,actiontype);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("AppraisalService.svc/UpdateReceive/New",Data);
		response.updateFromJSON(objresponse);
		return response;
	}

	public static SERVICEDATARESPONSE LockApp(String Data) throws Exception{
		//PROSPEKREQUEST req= new PROSPEKREQUEST();
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();
		//String jsonparamrequest = req.updateToJSONString(prospeks,actiontype);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("AppraisalService.svc/LockApp/New",Data);
		response.updateFromJSON(objresponse);
		return response;
	}
	public static SERVICEDATARESPONSE UpdateStatus(String Data) throws Exception{
		//PROSPEKREQUEST req= new PROSPEKREQUEST();
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();
		//String jsonparamrequest = req.updateToJSONString(prospeks,actiontype);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("AppraisalService.svc/UpdateStatus/New",Data);
		response.updateFromJSON(objresponse);
		return response;
	}
	public static SERVICEDATARESPONSE GetAttachmentStatus(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AppraisalService.svc/GetAttachmentStatus",params);
		response.updateFromJSON(objresponse);

		return response;
		
	}
	public static SERVICEDATARESPONSE GetAttachment(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AppraisalService.svc/GetAttachment",params);
		response.updateFromJSON(objresponse);

		return response;
		
	}
	public static SERVICEDATARESPONSE GetdataInquery(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AppraisalService.svc/GetdataInquery",params);
		response.updateFromJSON(objresponse);

		return response;
		
	}
	public static SERVICEDATARESPONSE GetdataInqueryCount(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AppraisalService.svc/GetdataInqueryCount",params);
		response.updateFromJSON(objresponse);

		return response;
		
	}
	public static SERVICEDATARESPONSE GetDocumentAttachmentDocument(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AppraisalService.svc/GetAttachmentDocument",params);
		response.updateFromJSON(objresponse);

		return response;
		
	}
	public static SERVICEDATARESPONSE GetNilaiSampling(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AppraisalService.svc/GetNilaiSampling",params);
		response.updateFromJSON(objresponse);

		return response;
		
	}
	public static ArrayList<DATA_RESPONSE> submitData_InsertSampling(String Data) throws Exception{
		//PROSPEKREQUEST req= new PROSPEKREQUEST();
		DATA_RESPONSE response=new DATA_RESPONSE();
		//String jsonparamrequest = req.updateToJSONString(prospeks,actiontype);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("AppraisalService.svc/InsertSampling/New",Data);

		return response.updateFromJSONList(objresponse);
	}
	
	public static ArrayList<DATA_RESPONSE> submitData_Insertattachment(String Data) throws Exception{
		//PROSPEKREQUEST req= new PROSPEKREQUEST();
		DATA_RESPONSE response=new DATA_RESPONSE();
		//String jsonparamrequest = req.updateToJSONString(prospeks,actiontype);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("AppraisalService.svc/Insertattachment/New",Data);

		return response.updateFromJSONList(objresponse);
	}
	public static DATA_RESPONSE submitData_progress_developer(String Data) throws Exception{
		//PROSPEKREQUEST req= new PROSPEKREQUEST();
		DATA_RESPONSE response=new DATA_RESPONSE();
		//String jsonparamrequest = req.updateToJSONString(prospeks,actiontype);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("AppraisalService.svc/InsertProgresbangunanDeveloper/New",Data);

		return response.updateFromJSON(objresponse);
	}
	public static DATA_RESPONSE submitData_progress_bangunan(String Data) throws Exception{
		//PROSPEKREQUEST req= new PROSPEKREQUEST();
		DATA_RESPONSE response=new DATA_RESPONSE();
		//String jsonparamrequest = req.updateToJSONString(prospeks,actiontype);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("AppraisalService.svc/InsertProgresbangunan/New",Data);

		return response.updateFromJSON(objresponse);
	}
	public static DATA_RESPONSE submitData_pb_valuation(String Data) throws Exception{
		//PROSPEKREQUEST req= new PROSPEKREQUEST();
		DATA_RESPONSE response=new DATA_RESPONSE();
		//String jsonparamrequest = req.updateToJSONString(prospeks,actiontype);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("AppraisalService.svc/InsertPBAprValuation/New",Data);

		return response.updateFromJSON(objresponse);
	}
	public static DATA_RESPONSE submitData_mhc_valuation(String Data) throws Exception{
		//PROSPEKREQUEST req= new PROSPEKREQUEST();
		DATA_RESPONSE response=new DATA_RESPONSE();
		//String jsonparamrequest = req.updateToJSONString(prospeks,actiontype);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("AppraisalService.svc/InsertMCHValuation/New",Data);

		return response.updateFromJSON(objresponse);
	}
	public static DATA_RESPONSE submitData_vhc_data(String Data) throws Exception{
		//PROSPEKREQUEST req= new PROSPEKREQUEST();
		DATA_RESPONSE response=new DATA_RESPONSE();
		//String jsonparamrequest = req.updateToJSONString(prospeks,actiontype);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("AppraisalService.svc/InsertDataKendaraan/New",Data);

		return response.updateFromJSON(objresponse);
	}
	public static DATA_RESPONSE submitData_rtb_tatakota(String Data) throws Exception{
		//PROSPEKREQUEST req= new PROSPEKREQUEST();
		DATA_RESPONSE response=new DATA_RESPONSE();
		//String jsonparamrequest = req.updateToJSONString(prospeks,actiontype);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("AppraisalService.svc/InserttataKota/New",Data);

		return response.updateFromJSON(objresponse);
	}
	public static DATA_RESPONSE submitData_vhc_valuation(String Data) throws Exception{
		//PROSPEKREQUEST req= new PROSPEKREQUEST();
		DATA_RESPONSE response=new DATA_RESPONSE();
		//String jsonparamrequest = req.updateToJSONString(prospeks,actiontype);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("AppraisalService.svc/InsertValuationKendaraan/New",Data);

		return response.updateFromJSON(objresponse);
	}
	public static ArrayList<DATA_RESPONSE> submitData_valbangunan(String Data) throws Exception{
		//PROSPEKREQUEST req= new PROSPEKREQUEST();
		DATA_RESPONSE response=new DATA_RESPONSE();
		//String jsonparamrequest = req.updateToJSONString(prospeks,actiontype);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("AppraisalService.svc/InsertvaluationBangunan/New",Data);

		return response.updateFromJSONList(objresponse);
	}
	
	public static DATA_RESPONSE submitData_rtb_detil(String Data) throws Exception{
		//PROSPEKREQUEST req= new PROSPEKREQUEST();
		DATA_RESPONSE response=new DATA_RESPONSE();
		//String jsonparamrequest = req.updateToJSONString(prospeks,actiontype);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("AppraisalService.svc/InsertDetailTanah/New",Data);

		return response.updateFromJSON(objresponse);
	}	
	public static DATA_RESPONSE submitData_rtb_data(String Data) throws Exception{
		//PROSPEKREQUEST req= new PROSPEKREQUEST();
		DATA_RESPONSE response=new DATA_RESPONSE();
		//String jsonparamrequest = req.updateToJSONString(prospeks,actiontype);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("AppraisalService.svc/InsertDataTanah/New",Data);

		return response.updateFromJSON(objresponse);
	}	
	
	public static DATA_RESPONSE submitData_rtb_valuation(String Data) throws Exception{
		//PROSPEKREQUEST req= new PROSPEKREQUEST();
		DATA_RESPONSE response=new DATA_RESPONSE();
		//String jsonparamrequest = req.updateToJSONString(prospeks,actiontype);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("AppraisalService.svc/InsertvaluationTanah/New",Data);

		return response.updateFromJSON(objresponse);
	}	
	public static ArrayList<DATA_RESPONSE> submitData_dokumen(String Data) throws Exception{
		//PROSPEKREQUEST req= new PROSPEKREQUEST();
		DATA_RESPONSE response=new DATA_RESPONSE();
		//String jsonparamrequest = req.updateToJSONString(prospeks,actiontype);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("AppraisalService.svc/InsertDocument/New",Data);

		return response.updateFromJSONList(objresponse);
	}	
	
	public static ArrayList<DATA_RESPONSE> submitData_vhc_pembanding(String Data) throws Exception{
		//PROSPEKREQUEST req= new PROSPEKREQUEST();
		DATA_RESPONSE response=new DATA_RESPONSE();
		//String jsonparamrequest = req.updateToJSONString(prospeks,actiontype);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("AppraisalService.svc/InsertPembandingKendaraan/New",Data);

		return response.updateFromJSONList(objresponse);
	}	
	
	public static ArrayList<DATA_RESPONSE> submitData_rtb_pembanding(String Data) throws Exception{
		//PROSPEKREQUEST req= new PROSPEKREQUEST();
		DATA_RESPONSE response=new DATA_RESPONSE();
		//String jsonparamrequest = req.updateToJSONString(prospeks,actiontype);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("AppraisalService.svc/InsertDataPembanding/New",Data);

		return response.updateFromJSONList(objresponse);
	}	
	
	public static ArrayList<DATA_RESPONSE> submitData_negative(String Data) throws Exception{
		//PROSPEKREQUEST req= new PROSPEKREQUEST();
		DATA_RESPONSE response=new DATA_RESPONSE();
		//String jsonparamrequest = req.updateToJSONString(prospeks,actiontype);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("AppraisalService.svc/InsertNegative/New",Data);

		return response.updateFromJSONList(objresponse);
	}	
	public static ArrayList<DATA_RESPONSE> submitData_imb(String Data) throws Exception{
		//PROSPEKREQUEST req= new PROSPEKREQUEST();
		DATA_RESPONSE response=new DATA_RESPONSE();
		//String jsonparamrequest = req.updateToJSONString(prospeks,actiontype);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("AppraisalService.svc/InsertDetailIMB/New",Data);

		return response.updateFromJSONList(objresponse);
	}
	
	public static SERVICEDATARESPONSE GetvaluationBangunan(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AppraisalService.svc/GetvaluationBangunan",params);
		response.updateFromJSON(objresponse);

		return response;
		
	}
	public static SERVICEDATARESPONSE Getsertifikat(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AppraisalService.svc/Getsertifikat",params);
		response.updateFromJSON(objresponse);

		return response;
		
	}
	public static SERVICEDATARESPONSE GetIMB(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AppraisalService.svc/GetIMB",params);
		response.updateFromJSON(objresponse);

		return response;
		
	}
	public static SERVICEDATARESPONSE GetHistoryAppraisal(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AppraisalService.svc/GetHistoryAppraisal",params);
		response.updateFromJSON(objresponse);

		return response;
		
	}
	public static SERVICEDATARESPONSE GetHistoryWorkFlow(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AppraisalService.svc/GetHistoryWorkFlow",params);
		response.updateFromJSON(objresponse);

		return response;
		
	}
	public static SERVICEDATARESPONSE GetDocument(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AppraisalService.svc/GetDocument",params);
		response.updateFromJSON(objresponse);

		return response;
		
	}
	
	
	public static SERVICEDATARESPONSE GetNegativeList(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AppraisalService.svc/GetNegativeList",params);
		response.updateFromJSON(objresponse);

		return response;
		
	}
	
	
	
	public static SERVICEDATARESPONSE getInboxAppr(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AppraisalService.svc/getInboxAppr",params);
		response.updateFromJSON(objresponse);

		return response;
		
	}
	public static SERVICEDATARESPONSE getDataMasterCount(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AmosService.svc/getDataMasterCount",params);
		response.updateFromJSON(objresponse);

		return response;
		
	}

	public static SERVICEDATARESPONSE getPBValuation(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AppraisalService.svc/getPBValuation",params);
		response.updateFromJSON(objresponse);

		return response;
		
	}
	public static SERVICEDATARESPONSE MCHValuation(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AppraisalService.svc/MCHValuation",params);
		response.updateFromJSON(objresponse);

		return response;
		
	}
	public static SERVICEDATARESPONSE getProgresbangunan(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AppraisalService.svc/getProgresbangunan",params);
		response.updateFromJSON(objresponse);

		return response;
		
	}
	public static SERVICEDATARESPONSE getProgBangunanDeveloper(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AppraisalService.svc/getProgBangunanDeveloper",params);
		response.updateFromJSON(objresponse);

		return response;
		
	}
	public static SERVICEDATARESPONSE GetTatakotaKendaraan(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AppraisalService.svc/GetTatakotaKendaraan",params);
		response.updateFromJSON(objresponse);

		return response;
		
	}
	public static SERVICEDATARESPONSE GetPembandingKendaraan(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AppraisalService.svc/GetPembandingKendaraan",params);
		response.updateFromJSON(objresponse);

		return response;
		
	}
	
	public static SERVICEDATARESPONSE GetValuationKendaraan(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AppraisalService.svc/GetValuationKendaraan",params);
		response.updateFromJSON(objresponse);

		return response;
		
	}
	
	public static SERVICEDATARESPONSE getDataPembanding(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AppraisalService.svc/getDataPembanding",params);
		response.updateFromJSON(objresponse);

		return response;
		
	}
	
	public static SERVICEDATARESPONSE getvaluationTanah(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AppraisalService.svc/getvaluationTanah",params);
		response.updateFromJSON(objresponse);

		return response;
		
	}
	
	public static SERVICEDATARESPONSE getDetailTanah(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AppraisalService.svc/getDetailTanah",params);
		response.updateFromJSON(objresponse);

		return response;
		
	}
	
	public static SERVICEDATARESPONSE getRtbData(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AppraisalService.svc/getDataTanah",params);
		response.updateFromJSON(objresponse);

		return response;
		
	}
	
		public static SERVICEDATARESPONSE getVhcData(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AppraisalService.svc/GetDataKendaraan",params);
		response.updateFromJSON(objresponse);

		return response;
		}
	

	/*-------- GET DATA -----------*/
	public static SERVICEDATARESPONSE getTataKota(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AppraisalService.svc/gettataKota",params);
		response.updateFromJSON(objresponse);
//		response.updateFromJSON(JSONTestTemporary.getLov());

		return response;
	}
	
	/*-------- GET DATA -----------*/
	public static SERVICEDATARESPONSE getAppr_collateral(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AppraisalService.svc/GetCollateral",params);
		response.updateFromJSON(objresponse);
//		response.updateFromJSON(JSONTestTemporary.getLov());

		return response;
	}
	
	
	public static SERVICEDATARESPONSE doLogin(String userid,String password,String imei,String moduleid) throws Exception{
		USERDATAREQUEST req= new USERDATAREQUEST();
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();
		String jsonparamrequest = req.toJSONObject(userid, password, imei,moduleid).toString();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("UserRestServiceimpl.svc/mUserRestServiceList/New",jsonparamrequest);
		response.updateFromJSON(objresponse);
//		response.updateFromJSON(JSONTestTemporary.getLogin());

		return response;
	}
	
	public static ArrayList<PROSPEKRESPONSE> submitDataProspek(ArrayList<ProspekData> prospeks,int actiontype) throws Exception{
		PROSPEKREQUEST req= new PROSPEKREQUEST();
		PROSPEKRESPONSE response=new PROSPEKRESPONSE();
		String jsonparamrequest = req.updateToJSONString(prospeks,actiontype);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("ProspekRestServiceimpl.svc/mProspekRestServiceInsert/New",jsonparamrequest);

		return response.updateFromJSON(objresponse);
	}
	
	public static ArrayList<PROSPEKRESPONSE> updateNewDataProspek(ProspekData prospek,FollowupData followup) throws Exception{
		PROSPEKREQUEST req= new PROSPEKREQUEST();
		PROSPEKRESPONSE response=new PROSPEKRESPONSE();
		String jsonparamrequest = req.updateToJSONString(prospek,followup);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("ProspekRestServiceimpl.svc/mProspekRestServiceInsert/New",jsonparamrequest);

		return response.updateFromJSON(objresponse);
	}
	
	public static ArrayList<PROSPEKRESPONSE> updateExistingDataProspek(ArrayList<ProspekData> prospeks) throws Exception{
		PROSPEKREQUEST req= new PROSPEKREQUEST();
		PROSPEKRESPONSE response=new PROSPEKRESPONSE();
		String jsonparamrequest = req.updateToJSONString(prospeks);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("ProspekRestServiceimpl.svc/mProspekRestServiceInsert/New",jsonparamrequest);

		return response.updateFromJSON(objresponse);
	}
	
	// TODO
	public static ArrayList<PHOTORESPONSE> submitPhoto(PhotoData photoData) throws Exception{
		PHOTORESPONSE arrResponse=new PHOTORESPONSE();
		UPLOADPHOTOREQUEST blackboxs=new UPLOADPHOTOREQUEST();
		String jsonparamrequest =blackboxs.toJSONString(photoData).toString();
		
		//JSONServiceHandler jsh=new JSONServiceHandler();
		//JSONObject objresponse= jsh.JSONServicePostData("ProspekRestServiceimpl.svc/mResultUmRestServiceList/New",jsonparamrequest);
		//return response.updateFromJSON(objresponse);
		return null;
	}
	public static PHOTORESPONSE uploadProspekPhotoGenfile(ArrayList<NameValuePair> params,String filename) throws Exception{
		PHOTORESPONSE photoResponse=new PHOTORESPONSE();	
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceUploadPhoto("FileManagerService.svc/UploadFileGenFile",params,filename);
		photoResponse.updateUploadPhoto(objresponse);	
		return photoResponse;
	}
	
	public static PHOTORESPONSE uploadProspekPhoto(ArrayList<NameValuePair> params,String filename) throws Exception{
		PHOTORESPONSE photoResponse=new PHOTORESPONSE();	
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceUploadPhoto("FileManagerService.svc/UploadFile",params,filename);
		photoResponse.updateUploadPhoto(objresponse);	
		return photoResponse;
	}
	
	public static ArrayList<PROSPEKRESPONSE> sendBlackboxResultsForMitra(ArrayList<ProspekData> arrProspekData) throws Exception{
		PROSPEKRESPONSE response=new PROSPEKRESPONSE();
		BLACKBOXDATARESULTREQUEST blackboxs=new BLACKBOXDATARESULTREQUEST();
		String jsonparamrequest =blackboxs.toJSONString(arrProspekData).toString();
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("ProspekRestServiceimpl.svc/mResultMitraRestServiceList/New",jsonparamrequest);
//		response.updateFromJSON(JSONTestTemporary.getStatusResponse());

		 return response.updateFromJSON(objresponse);
	}
	
	public static ArrayList<PROSPEKRESPONSE> sendBlackboxResultsForUM(ArrayList<ProspekData> arrProspekData) throws Exception{
		PROSPEKRESPONSE response=new PROSPEKRESPONSE();
		BLACKBOXDATARESULTREQUEST blackboxs=new BLACKBOXDATARESULTREQUEST();
		String jsonparamrequest =blackboxs.toJSONString(arrProspekData).toString();
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("ProspekRestServiceimpl.svc/mResultUmRestServiceList/New",jsonparamrequest);
//		response.updateFromJSON(JSONTestTemporary.getStatusResponse());
		 return response.updateFromJSON(objresponse);
	}
	
	public static TRANSAKSIRESPONSE sendTransaksi(String norekening,String totalbayar,String token,String userid,String nomorhandphone,String transtype,String cif,String notabungan,String namanasabah) throws Exception{
		TRANSAKSIRESPONSE response=new TRANSAKSIRESPONSE();
		TRANSAKSIREQUEST transaksirequest=new TRANSAKSIREQUEST();
		String jsontransaksi =transaksirequest.toJSONObject(norekening,totalbayar,token,userid,nomorhandphone,transtype,cif,notabungan,namanasabah).toString();
		
		System.out.println(jsontransaksi);
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("TabunganRestServiceimpl.svc/mSubmitTransaksiRestServiceList/New",jsontransaksi);
		response.updateFromJSON(objresponse);
		//response.updateFromJSON(JSONTestTemporary.getStatusResponse());

		return response;
	}
	
	
	public static SERVICEDATARESPONSE submitStateHistory(ArrayList<StateHistoryData> stateHistory) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();
		STATEHISTORYREQUEST stateHistoryRequest=new STATEHISTORYREQUEST();
		String jsonparamrequest = stateHistoryRequest.toJSONString(stateHistory);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("ProspekRestServiceimpl.svc/mStageHistoryRestService/New",jsonparamrequest);
//		response.updateFromJSON(JSONTestTemporary.getStatusUploadProspek(prospek));
		response.updateFromJSON(objresponse);
		return response;
	}
	
	public static SERVICEDATARESPONSE submitGeoLocation(ArrayList<GeoLocationData> geoLocation) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();
		GEOLOCATIONREQUEST geolocationrequest=new GEOLOCATIONREQUEST();
		String jsonparamrequest = geolocationrequest.toJSONString(geoLocation);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("StatistikRestServiceimpl.svc/mGeoLocationRestService/New",jsonparamrequest);
		response.updateFromJSON(objresponse);
//		response.updateFromJSON(JSONTestTemporary.getStatusResponse());
		return response;
	}
	
	public static SERVICEDATARESPONSE submitLoginHistory(ArrayList<LoginHistoryData> arrLoginHistory) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();
		LOGINHISTORYREQUEST loginHistoryRequest=new LOGINHISTORYREQUEST();
		String jsonparamrequest = loginHistoryRequest.toJSONString(arrLoginHistory);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("ParamRestServiceimpl.svc/mLogLoginRestService/New",jsonparamrequest);
//		response.updateFromJSON(JSONTestTemporary.getStatusUploadProspek(prospek));
		response.updateFromJSON(objresponse);
		return response;
	}
	
	/*-------- GET DATA -----------*/
	public static SERVICEDATARESPONSE getLOV(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("AmosService.svc/getDataMaster",params);
		response.updateFromJSON(objresponse);
//		response.updateFromJSON(JSONTestTemporary.getLov());

		return response;
	}
	
	public static SERVICEDATARESPONSE getTabunganCount(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("TabunganRestServiceimpl.svc/mTabunganCountRestService",params);
		response.updateFromJSON(objresponse);
//		response.updateFromJSON(JSONTestTemporary.getTabungan());

		return response;
	}
	
	public static SERVICEDATARESPONSE getTabungan(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("TabunganRestServiceimpl.svc/mTabunganRestService",params);
		response.updateFromJSON(objresponse);
//		response.updateFromJSON(JSONTestTemporary.getTabungan());

		return response;
	}
	
	public static SERVICEDATARESPONSE getTagihanCount(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("TabunganRestServiceimpl.svc/mTagihanCountRestService",params);
		response.updateFromJSON(objresponse);
//		response.updateFromJSON(JSONTestTemporary.getTagihan());

		return response;
	}
	
	public static SERVICEDATARESPONSE getTagihan(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("TabunganRestServiceimpl.svc/mTagihanRestService",params);
		response.updateFromJSON(objresponse);
//		response.updateFromJSON(JSONTestTemporary.getTagihan());

		return response;
	}
	
	public static SERVICEDATARESPONSE requestBlackbox(String milik,String stage,String status,String userid,Date startdate,Date endDate) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();
		REQUESTBLACKBOX requestblackbox=new REQUESTBLACKBOX();
		String jsonparam= requestblackbox.JsonToString(milik, stage, status, userid, startdate, endDate);
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("ProspekRestServiceimpl.svc/mRequestMitraRestServiceList/New",jsonparam);
		response.updateFromJSON(objresponse);

		return response;
	}
	
	public static SERVICEDATARESPONSE getBlackboxRetrievalForUM(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("ProspekRestServiceimpl.svc/mRetrievBlackRestServiceList",params);
		response.updateFromJSON(objresponse);
		
//		response.updateFromJSON(JSONTestTemporary.getBlackboxRetrieval());

		return response;
	}
	
	public static SERVICEDATARESPONSE getBlackboxRetrievalForMitra(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("ProspekRestServiceimpl.svc/mResultBlackRestServiceList",params);
		response.updateFromJSON(objresponse);
		
//		response.updateFromJSON(JSONTestTemporary.getBlackboxRetrieval());

		return response;
	}
	
	public static TRANSAKSIRESPONSE requestToken(String nomorRekening,String userId,String nomorHandphone,String transtype) throws Exception{
		TRANSAKSIRESPONSE response=new TRANSAKSIRESPONSE();
		TOKENREQUEST tokenrequest=new TOKENREQUEST();
		String jsonparamrequest =tokenrequest.toJSONString(nomorRekening, userId, nomorHandphone,transtype);
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("TabunganRestServiceimpl.svc/mGetTokenRestServiceList/New",jsonparamrequest);
		
//		response.updateFromJSON(JSONTestTemporary.getStatusResponse());
		response.updateFromJSON(objresponse);
		return response;
	}
	
	public static SERVICEDATARESPONSE approveCashCheckup(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		//JSONServiceHandler jsh=new JSONServiceHandler();
		//JSONObject objresponse= jsh.JSONServicePostData("login",json);
		response.updateFromJSON(JSONTestTemporary.getStatusResponse());

		return response;
	}
	
	public static SERVICEDATARESPONSE getStatistikData(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("StatistikRestServiceimpl.svc/mStatistikRestServiceList",params);
		response.updateFromJSON(objresponse);

//		response.updateFromJSON(JSONTestTemporary.getStatistikData());

		return response;
	}
	
	public static SERVICEDATARESPONSE getMotionTrackerData(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("StatistikRestServiceimpl.svc/mMapRestServiceList",params);
		response.updateFromJSON(objresponse);
		
//		response.updateFromJSON(JSONTestTemporary.getMotionTrackerData());

		return response;
	}
	
	public static SERVICEDATARESPONSE getMitra(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("UserRestServiceimpl.svc/mMitraRestServiceList",params);
		response.updateFromJSON(objresponse);
//		response.updateFromJSON(JSONTestTemporary.getMitra());

		return response;
	}
	
	public static SERVICEDATARESPONSE getAllMitra(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("UserRestServiceimpl.svc/mMitraAllRestServiceList",params);
		response.updateFromJSON(objresponse);
//		response.updateFromJSON(JSONTestTemporary.getMitra());

		return response;
	}
	
	public static SERVICEDATARESPONSE getCashPickup(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("TabunganRestServiceimpl.svc/mGetChashPickupRestServiceList",params);
		response.updateFromJSON(objresponse);

//		response.updateFromJSON(JSONTestTemporary.getCashPickup());

		return response;
	}
	
	public static SERVICEDATARESPONSE getNews(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("UserRestServiceimpl.svc/mNewRestServiceList",params);
		response.updateFromJSON(objresponse);
//		response.updateFromJSON(JSONTestTemporary.getNews());

		return response;
	}
	
	public static SERVICEDATARESPONSE getMessages(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("UserRestServiceimpl.svc/mMessageRestServiceList",params);
		response.updateFromJSON(objresponse);
//		response.updateFromJSON(JSONTestTemporary.getMessages());

		return response;
	}
	
	public static SERVICEDATARESPONSE getScheduler(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("UserRestServiceimpl.svc/mSchedulerRestService",params);
		response.updateFromJSON(objresponse);
//		response.updateFromJSON(JSONTestTemporary.getScheduler());

		return response;
	}
	
	public static SERVICEDATARESPONSE sendMessageResponse(ArrayList<MessageData> arrMessage) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();
		MESSAGENOTIFICATION messageRequest=new MESSAGENOTIFICATION();
		String jsonparamrequest = messageRequest.messageToJSONString(arrMessage);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("UserRestServiceimpl.svc/mUpdateMessageUser/New",jsonparamrequest);
//		response.updateFromJSON(JSONTestTemporary.getStatusResponse());
		response.updateFromJSON(objresponse);
		return response;
	}
	
	// TODO
	public static SERVICEDATARESPONSE sendNewsResponse(ArrayList<NewsData> arrMessage) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();
		MESSAGENOTIFICATION messageRequest=new MESSAGENOTIFICATION();
		String jsonparamrequest = messageRequest.newsToJSONString(arrMessage);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("UserRestServiceimpl.svc/mUpdateMessageUser/New",jsonparamrequest);
//		response.updateFromJSON(JSONTestTemporary.getStatusResponse());
		response.updateFromJSON(objresponse);
		return response;
	}
	
	// TODO
	public static ArrayList<PHOTORESPONSE> getPhoto(String prospekId,String fileName) throws Exception{
		PHOTORESPONSE arrResponse=new PHOTORESPONSE();
		PHOTOREQUEST photoRequest=new PHOTOREQUEST();
		String jsonparamrequest = photoRequest.toJSONString(prospekId,fileName);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("ProspekRestServiceimpl.svc/mStageHistoryRestService/New",jsonparamrequest);
		return arrResponse.updateGetPhotoFromJSON(objresponse);
	}
	
	public static ArrayList<PHOTORESPONSE> deletePhoto(String prospekId,String fileName) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();
		PHOTORESPONSE photoResponse=new PHOTORESPONSE();
		PHOTOREQUEST photoRequest=new PHOTOREQUEST();
		String jsonparamrequest = photoRequest.toJSONString(prospekId,fileName);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("ProspekRestServiceimpl.svc/UpdateImage/New",jsonparamrequest);
		response.updateFromJSON(objresponse);
		return photoResponse.updateDeletePhotoFromJSON(response.getResults());
	}
	
	public static SERVICEDATARESPONSE changePassword(String userid,String oldpassword,String newpassword) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();
		CHANGEPASSWORDREQUEST changePasswordRequest=new CHANGEPASSWORDREQUEST();
		String jsonparamrequest = changePasswordRequest.toJSONString(userid,oldpassword,newpassword);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("UserRestServiceimpl.svc/UpdatePassword/New",jsonparamrequest);
		response.updateFromJSON(objresponse);
		return response;
	}
	/*public static SERVICEDATARESPONSE CheckVersion(String userid,String imei) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();
		CHECKVERSION checkVersion=new CHECKVERSION();
		String jsonparamrequest = checkVersion.toJSONString(userid,imei);	
		
		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServicePostData("FileManagerService.svc/CheckAppVersion",jsonparamrequest);
		response.updateFromJSON(objresponse);
		return response;
	}*/
	public static SERVICEDATARESPONSE CheckVersion(ArrayList<NameValuePair> params) throws Exception{
		SERVICEDATARESPONSE response=new SERVICEDATARESPONSE();

		JSONServiceHandler jsh=new JSONServiceHandler();
		JSONObject objresponse= jsh.JSONServiceGetData("FileManagerService.svc/CheckAppVersion",params);
		response.updateFromJSON(objresponse);
//		response.updateFromJSON(JSONTestTemporary.getScheduler());

		return response;
	}
	
	

}
