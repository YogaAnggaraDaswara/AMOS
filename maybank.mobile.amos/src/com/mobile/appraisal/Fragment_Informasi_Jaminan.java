package com.mobile.appraisal;



import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.ByteArrayBuffer;
import org.json.JSONArray;
import org.jsoup.Jsoup;

import com.mobile.app.configuration.AppConstants;
import com.mobile.app.media.CameraDialog;
import com.mobile.app.ui.ListOfValueAdapter;
import com.mobile.bo.app.dataprovider.Appr_Attachment;
import com.mobile.bo.app.dataprovider.Appr_Collateral;
import com.mobile.bo.app.dataprovider.Appr_DokumentDataProvider;
import com.mobile.bo.app.dataprovider.Appr_Pb_SamplingBangunan_Provider;
import com.mobile.bo.app.dataprovider.Appr_Rtb_ValuationDataProvider;
import com.mobile.bo.app.dataprovider.Appr_mainDataProvider;
import com.mobile.bo.app.dataprovider.LOVDataProvider;
import com.mobile.bo.app.dataprovider.PhotoDataProvider;
import com.mobile.bo.app.datatype.Datatype_Appr_Collateral;
import com.mobile.bo.app.datatype.Datatype_Appr_Dokument;
import com.mobile.bo.app.datatype.Datatype_Appr_Inbox;
import com.mobile.bo.app.datatype.Datatype_Appr_Pb_sampling_bangunan;
import com.mobile.bo.app.datatype.Datatype_Appr_Rtb_Valuation_Int;
import com.mobile.bo.app.datatype.Datatype_Apprs_Main;
import com.mobile.bo.app.datatype.LovData;
import com.mobile.bo.app.datatype.PhotoData;
import com.mobile.bo.app.datatype.Datatype_attachment;
import com.mobile.bo.app.datatype.UserData;
import com.mobile.database.app.common.DataConverter;
import com.mobile.database.app.entities.USER;
import com.mobile.framework.common.DateFormatter;
import com.mobile.framework.common.FileUtility;
import com.mobile.framework.data.SessionSharedPreference;
import com.mobile.framework.media.CameraActionListener;
import com.mobile.framework.media.CameraPreview;
import com.mobile.framework.widget.ExSpinner;
import com.mobile.framework.widget.ISpinnerItem;
import com.mobile.services.app.ServiceData;
import com.mobile.services.app.datatype.DATA_RESPONSE;
import com.mobile.services.app.datatype.PHOTORESPONSE;
import com.mobile.services.app.datatype.SERVICEDATARESPONSE;
import com.mobile.services.app.services.JSONServiceHandler;
import com.mobile.services.app.services.ServiceDataProvider;
import com.mobile.app.activity.PreviewImage;
import com.mobile.app.activity.PreviewImageNew;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import bii.mobile.amos.R;
//import org.xhtmlrenderer.pdf.ITextRenderer;

import com.google.gson.Gson;



/*import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
*/
import org.jsoup.Jsoup;
/*import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;*/
//import org.xhtmlrenderer.pdf.ITextRenderer;

@SuppressWarnings("deprecation")
public class Fragment_Informasi_Jaminan extends Fragment {
	private Datatype_Appr_Rtb_Valuation_Int appr_rtb_valuation_int = new Datatype_Appr_Rtb_Valuation_Int();
	private Appr_Rtb_ValuationDataProvider appr_Rtb_ValuationDataProvider;
	private Appr_Attachment appr_Attachment;
	private static final int RESULT_LOAD_IMAGE = 2;
	private static final int RESULT_OK = 0;
	private static final int REQUEST_CODE_CHOOSE_PICTURE_FROM_GALLARY = 99;
	Button button;
    View view=null;
    Button Btnsave;
    Button BtnRefresh;
    private Context ctx = null;
    private Appr_Collateral appr_Collateral=new Appr_Collateral();
    private Datatype_Appr_Collateral datatype_Appr_Collateral = new Datatype_Appr_Collateral();
    private TextView info_jaminan_lbl_jenis_jaminan_1;
    private TextView info_jaminan_lbl_bentuk_jaminan_1;
    private TextView info_jaminan_lbl_jenis_dokumen_1;
    private TextView info_jaminan_lbl_no_dokumen_1;
    private TextView info_jaminan_lbl_an_dokumen_1;
    private TextView info_jaminan_lbl_hubungan_1;
    private TextView info_jaminan_lbl_contact_1;
    private TextView info_jaminan_lbl_hp_1;
    private TextView info_jaminan_lbl_almt_1;		  
    private TextView info_jaminan_lbl_kecamatan_1;
    private TextView info_jaminan_lbl_kelurahan_1;
    private TextView info_jaminan_lbl_kota_1;
    private TextView info_jaminan_lbl_kode_pos_1;
    private TextView info_jaminan_lbl_cek_tata_kota_1;
    private TextView info_jaminan_lbl_penilaian_1;
    private TextView header_deb;
    private TextView header_alamat;
    private PhotoDataProvider photoDataProvider;
    private PhotoData photodata;
    private Button btn_takepicture,btn_takefile,btn_GenFile;
    private PreviewImageNew  previewimg = null;
    final List<ImageView> imgView = new ArrayList<ImageView>();
    final List<TextView> lblView = new ArrayList<TextView>();
    private ArrayList<ISpinnerItem> lovattach = new ArrayList<ISpinnerItem>();
    private ArrayList<ISpinnerItem> lovtipefile = new ArrayList<ISpinnerItem>();
    private ExSpinner info_jaminan_spn_attachtype;
    private ExSpinner info_jaminan_spn_tipefile;
    private TextView lblImg01;
    private TextView lblImg02;
    private TextView lblImg03;
    private ImageView imgView01;
    private ImageView imgView02;
    private ImageView imgView03;
    private String col_id="";
    private String ap_regno="",col_type="";
    final int CAMERA_CAPTURE = 1;
    final int CROP_PIC = 2;
    private Uri picUri;
    private TableLayout inbox_tableLayout;
    private TableLayout inbox_tableLayoutfile;
    private ArrayList<PhotoData> listdata = null;
    private ArrayList<Datatype_attachment> listdatafile = null;
    private LOVDataProvider lovDataProvider;
    private String GenerateType="";
    private String tipefile="";
    private UserData userDetail;
    private String filename="";
    public Fragment_Informasi_Jaminan() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_informasi_jaminan, null);
        ctx = this.getActivity();
        try {
			userDetail = (UserData) SessionSharedPreference.getDataFromSharedPreference(ctx, UserData.class, AppConstants.USER_SESSION);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        appr_Collateral=new Appr_Collateral();
        datatype_Appr_Collateral = new Datatype_Appr_Collateral();
        appr_rtb_valuation_int=new Datatype_Appr_Rtb_Valuation_Int();
        appr_Rtb_ValuationDataProvider=new Appr_Rtb_ValuationDataProvider();
        appr_Attachment=new Appr_Attachment();
        photoDataProvider=new PhotoDataProvider();
        photodata=new PhotoData();
        Bundle b = getArguments();
       /* previewimg = new PreviewImage(ctx);
        imgView01 = (ImageView) view.findViewById(R.id.kenalan_view_img_01);
        imgView02 = (ImageView) view.findViewById(R.id.kenalan_view_img_02);
        imgView03 = (ImageView) view.findViewById(R.id.kenalan_view_img_03);
        lblImg01 = (TextView) view.findViewById(R.id.kenalan_view_lbl_01);
        lblImg02 = (TextView) view.findViewById(R.id.kenalan_view_lbl_02);
        lblImg03 = (TextView) view.findViewById(R.id.kenalan_view_lbl_03);*/
       
        col_id=b.getString("COL_ID");
        ap_regno=b.getString("AP_REGNO");
        col_type=b.getString("COL_TYPE");
        
        initControl();
        loadData(col_id);
    	lovtipefile = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(GenerateType));
    	info_jaminan_spn_tipefile.setListOfValue(lovtipefile, false);
    	
        //GenerateHTMLToPDF();
        //GenerateHTMLToPDF();
        return view;
    }
    /*private void GeneratePdfAndro(){
        String inputFile = AppConstants.FILEPATH + "alice/alice.xhtml";
        String url;
		try {
			url = new File(inputFile).toURI().toURL().toString();
		
	        String outputFile = AppConstants.FILEPATH + "alice.pdf";
	        OutputStream os = new FileOutputStream(outputFile);
	        
	        @SuppressWarnings("unused")
			ITextRenderer renderer = new ITextRenderer();
	        
	        renderer.setDocument(url);
	        renderer.layout();
	        renderer.createPDF(os);
	        
	        os.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }*/
 /*   private void GenerateHTMLToPDF(){
    	    try {
    		      Document document = new Document(PageSize.LETTER);
    		      PdfWriter.getInstance(document, new FileOutputStream(AppConstants.FILEPATH + "testpdf1.pdf"));
    		      document.open();
    		      document.addAuthor("Real Gagnon");
    		      document.addCreator("Real's HowTo");
    		      document.addSubject("Thanks for your support");
    		      document.addCreationDate();
    		      document.addTitle("Please read this");

    		      HTMLWorker htmlWorker = new HTMLWorker(document);
    		      File input = new File(AppConstants.FILEPATH + "alice/alice.xhtml");
    		      org.jsoup.nodes.Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
    		     
    		      String str =doc.toString();  "<html><head></head><body>"+
    		        "<a href='http://www.rgagnon.com/howto.html'><b>Real's HowTo</b></a>" +
    		        "<h1>Show your support</h1>" +
    		        "<p>It DOES cost a lot to produce this site - in ISP storage and transfer fees, " +
    		        "in personal hardware and software costs to set up test environments, and above all," +
    		        "the huge amounts of time it takes for one person to design and write the actual content." +
    		        "<p>If you feel that effort has been useful to you, perhaps you will consider giving something back?" +
    		        "<p>Donate using PayPal® to real@rgagnon.com." +
    		        "<p>Contributions via PayPal are accepted in any amount " +
    		        "<P><br><table border='1'><tr><td>Java HowTo<tr>" +
    		        "<td bgcolor='red'>Javascript HowTo<tr><td>Powerbuilder HowTo</table>" +
    		        "</body></html>";
    		      htmlWorker.parse(new StringReader(str));
    		      document.close();
    		      System.out.println("Done");
    		      }
    		    catch (Exception e) {
    		      e.printStackTrace();
    		    }
    }
 */  
    private void initControl(){
    	header_deb							=(TextView) view.findViewById(R.id.info_Nama_deb);
        header_alamat						=(TextView) view.findViewById(R.id.info_Nama_Alamat);
    	
    	info_jaminan_spn_attachtype 		=(ExSpinner) view.findViewById(R.id.info_jaminan_spn_attachtype);
    	info_jaminan_spn_tipefile 			=(ExSpinner) view.findViewById(R.id.info_jaminan_spn_tipe_file);
    	BtnRefresh							=(Button) view.findViewById(R.id.btn_Refresh);
    	info_jaminan_lbl_jenis_jaminan_1	=(TextView) view.findViewById(R.id.info_jaminan_lbl_jenis_jaminan_1);
    	info_jaminan_lbl_bentuk_jaminan_1   =(TextView) view.findViewById(R.id.info_jaminan_lbl_bentuk_jaminan_1);
    	info_jaminan_lbl_jenis_dokumen_1    =(TextView) view.findViewById(R.id.info_jaminan_lbl_jenis_dokumen_1);
    	info_jaminan_lbl_no_dokumen_1       =(TextView) view.findViewById(R.id.info_jaminan_lbl_no_dokumen_1);
    	info_jaminan_lbl_an_dokumen_1       =(TextView) view.findViewById(R.id.info_jaminan_lbl_an_dokumen_1);
    	info_jaminan_lbl_hubungan_1         =(TextView) view.findViewById(R.id.info_jaminan_lbl_hubungan_1);
    	info_jaminan_lbl_contact_1          =(TextView) view.findViewById(R.id.info_jaminan_lbl_contact_1);
    	info_jaminan_lbl_hp_1               =(TextView) view.findViewById(R.id.info_jaminan_lbl_hp_1);
    	info_jaminan_lbl_almt_1		        =(TextView) view.findViewById(R.id.info_jaminan_lbl_almt_1);
    	info_jaminan_lbl_kecamatan_1        =(TextView) view.findViewById(R.id.info_jaminan_lbl_kecamatan_1);
    	info_jaminan_lbl_kelurahan_1        =(TextView) view.findViewById(R.id.info_jaminan_lbl_kelurahan_1);
    	info_jaminan_lbl_kota_1             =(TextView) view.findViewById(R.id.info_jaminan_lbl_kota_1);
    	info_jaminan_lbl_kode_pos_1         =(TextView) view.findViewById(R.id.info_jaminan_lbl_kode_pos_1);
    	info_jaminan_lbl_cek_tata_kota_1    =(TextView) view.findViewById(R.id.info_jaminan_lbl_cek_tata_kota_1);
    	info_jaminan_lbl_penilaian_1        =(TextView) view.findViewById(R.id.info_jaminan_lbl_penilaian_1);
    	inbox_tableLayout					=(TableLayout) view.findViewById(R.id.inbox_tableLayout);
    	inbox_tableLayoutfile				=(TableLayout) view.findViewById(R.id.inbox_tableLayoutfile);
    	
    	btn_takepicture        				=(Button) view.findViewById(R.id.btn_takepicture);
    	btn_takefile        				=(Button) view.findViewById(R.id.btn_takefile);
    	btn_GenFile							=(Button) view.findViewById(R.id.btn_GenFile);
    	
    	lovDataProvider = new LOVDataProvider();
    	if(col_type.equals("RE")) 
    	{
    		lovattach = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_ATTACH_RE));
    		tipefile=AppConstants.SPINNER_ATTACH_RE;
    	}
    	
    	if(col_type.equals("VEH")) 
    	{
    		lovattach = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_ATTACH_VEH));
    		tipefile=AppConstants.SPINNER_ATTACH_VEH;
    	}
    	
    	if(col_type.equals("PIU")) 
    	{
    		lovattach = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_ATTACH_PIU));
    		tipefile=AppConstants.SPINNER_ATTACH_PIU;
    	}
    	
    	if(col_type.equals("DEP")) 
    	{
    		lovattach = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_ATTACH_DEP));
    		tipefile=AppConstants.SPINNER_ATTACH_DEP;
    	}
    	
    	if(col_type.equals("MCH")) 
    	{
    		lovattach = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_ATTACH_MCH));
    		tipefile=AppConstants.SPINNER_ATTACH_MCH;
    	}
    	
    	if(col_type.equals("PG")) 
    	{
    		lovattach = ListOfValueAdapter.createESAdapterLov(lovDataProvider.getListOfValueData(AppConstants.SPINNER_ATTACH_PG));
    		tipefile=AppConstants.SPINNER_ATTACH_PG;
    	}
        
    	
    	info_jaminan_spn_attachtype.setListOfValue(lovattach, false);
        
    	
    
    	btn_takepicture.setOnClickListener(new View.OnClickListener() {
    		
            @Override
            public void onClick(View v) {
            	/*try {
                    // use standard intent to capture an image
                    Intent captureIntent = new Intent(
                            MediaStore.ACTION_IMAGE_CAPTURE);
                    // we will handle the returned data in onActivityResult
                    startActivityForResult(captureIntent, CAMERA_CAPTURE);
                } catch (ActivityNotFoundException anfe) {
                    Toast toast = Toast.makeText(ctx, "This device doesn't support the crop action!",
                            Toast.LENGTH_SHORT);
                    toast.show();
                }
            	}*/
            	if(CekMandatory().equals(true)){
	            	Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	            	filename = userDetail.getUSERID() + DateFormatter.formatStringFORMATDDMMYYHHMMSS(new Date());
	            	filename = filename + AppConstants.JPGEXTENSION;
	                File file = new File(AppConstants.FILEPATH + filename);
	            	Uri mImageCaptureUri = null;
	            	String state = Environment.getExternalStorageState();
	            	mImageCaptureUri = Uri.fromFile(file);
	                intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, mImageCaptureUri);
	                intent.putExtra("return-data", true);
	                startActivityForResult(intent, CAMERA_CAPTURE);
            	}
            	//if(CekMandatory().equals(true))
            	//	captureImage(imgView, lblView);
            }
    	});
    	
    	btn_GenFile.setOnClickListener(new View.OnClickListener() {
    		
            @Override
            public void onClick(View v) {
            	  new SubmittedPhoto().execute();
                  new SubmittedAttachmentHeader().execute();
                  Datatype_attachment attachment =new Datatype_attachment();
                  
                  attachment.setID(ap_regno + col_id + GenerateType + info_jaminan_spn_tipefile.getSelectedListOfValue().toString());
                  attachment.setAP_REGNO(ap_regno);
				  attachment.setCOL_ID(col_id);
				  attachment.setGENERATE_TYPE(GenerateType);
				  attachment.setGENERATE_TYPE_REFF(info_jaminan_spn_tipefile.getSelectedListOfValue().toString());
				  attachment.setSTATUS("0");
				  attachment.setTOTAL_IMAGE("0");
				  attachment.setUSERID(userDetail.getUSERID());
				  attachment.setISDOWNLOAD("0");
				  attachment.setFILENAME("");
				  attachment.setISSTATUS("0");
				  attachment.setCOL_ID(col_id);
				  appr_Attachment.updateData(attachment);
				  loadFile();
                  
                 /* try {
					DownloadImageFromUrl(ap_regno,col_id,GenerateType,info_jaminan_spn_tipefile.getSelectedListOfValue().toString());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
              
            }
    	});
    	btn_takefile.setOnClickListener(new View.OnClickListener() {
    		
            @Override
            public void onClick(View v) {
            	
            	if(CekMandatory().equals(true))
            		getPictureFromGallery();            
            }
        });
    	BtnRefresh.setOnClickListener(new View.OnClickListener() {
    		
            @Override
            public void onClick(View v) {
            	loadFile();
            	            
            }
        });
            	
    }
    private class GetDataPDF extends AsyncTask<Void, Void,Void> {
  		boolean bolstatus=false;
  		@Override
  		protected Void doInBackground(Void... params) {
  				ArrayList<Datatype_attachment> arrdata = appr_Attachment.getAllAppr_Attachment_Int(col_id) ;
				if (arrdata.size() > 0){
					for (int x=0;x<arrdata.size();x++ ){
						Datatype_attachment appr_Attachmentdata=arrdata.get(x);
						
						if(appr_Attachmentdata.getISDOWNLOAD().equals("0") ||  appr_Attachmentdata.getISDOWNLOAD().equals("") ||  appr_Attachmentdata.getISDOWNLOAD()==null )
						{
						    ArrayList<NameValuePair> params15 = new ArrayList<NameValuePair>();
				              params15.add(new BasicNameValuePair("AP_REGNO", ap_regno  ));
				              params15.add(new BasicNameValuePair("COL_ID", col_id  ));
				              params15.add(new BasicNameValuePair("GENERATE_TYPE", appr_Attachmentdata.getGENERATE_TYPE().toString()  ));
				              params15.add(new BasicNameValuePair("GENERATE_TYPE_REFF", appr_Attachmentdata.getGENERATE_TYPE_REFF().toString()  ));
				              
				              
				              SERVICEDATARESPONSE InboxResponse;
				 			try {
				 				
				 				InboxResponse = ServiceDataProvider.GetAttachmentStatus(params15);
				             
				             if (InboxResponse != null) {
				                 ArrayList<Datatype_attachment> arrLOVServiceData = ServiceData.GetAttachmentStatus (new JSONArray(InboxResponse.getResults()));
				                 if (InboxResponse.getStatus() == 1) {
				                     for (int i = 0; i < arrLOVServiceData.size(); i++) {
				                    	 if(arrLOVServiceData.get(i).getSTATUS().equals("0")){
				         					String FileName=DownloadImageFromUrl(ap_regno,col_id,appr_Attachmentdata.getGENERATE_TYPE().toString() ,appr_Attachmentdata.getGENERATE_TYPE_REFF().toString() );
				                    	
				         					appr_Attachmentdata.setFILENAME(FileName) ;
					                    	appr_Attachmentdata.setSTATUS("0");
											appr_Attachmentdata.setTOTAL_IMAGE("0");
											appr_Attachmentdata.setUSERID(userDetail.getUSERID());
											appr_Attachmentdata.setISDOWNLOAD("1");
												  
											appr_Attachment.updateData(appr_Attachmentdata);
											
				                    	 }
				                     }
				                     if(arrLOVServiceData.size()>0)
				                    	 bolstatus=true;
				                     
				                     arrLOVServiceData = null;
				                 }
				                 //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
				             }
				 			
				 			} catch (Exception e) {
				 				// TODO Auto-generated catch block
				 				e.printStackTrace();
				 			}
				             InboxResponse = null;
				             
							
						
						}
					}
				}
				else{
					//Log.d(TAG, "No data to be syncronized");
				}
				arrdata = null;
				return null;
  		}
  		
  		 @Override
  	     protected void onPostExecute(Void result) {
  			if(bolstatus)
  				loadFile();
  		 }	 
      }

    private void getPictureFromGallery(){
        /*
        //This allows to select the application to use when selecting an image.
        Intent i = new Intent(Intent.ACTION_GET_CONTENT);
        i.setType("image/*");
        startActivityForResult(Intent.createChooser(i, "Escoge una foto"), PICTURE_TAKEN_FROM_GALLERY);
        */

        //This takes images directly from gallery
        Intent gallerypickerIntent = new Intent(Intent.ACTION_PICK);
        gallerypickerIntent.setType("image/*");
        gallerypickerIntent.putExtra("outputFormat",Bitmap.CompressFormat.PNG.name());
        gallerypickerIntent.putExtra("return-data", true);
        startActivityForResult(gallerypickerIntent, REQUEST_CODE_CHOOSE_PICTURE_FROM_GALLARY);

        //startActivityForResult(gallerypickerIntent, 2); 
    }
    
    private void copyFile(File sourceFile, File destFile) throws IOException {
        if (!sourceFile.exists()) {
            return;
        }

        FileChannel source = null;
            FileChannel destination = null;
            source = new FileInputStream(sourceFile).getChannel();
            destination = new FileOutputStream(destFile).getChannel();
            if (destination != null && source != null) {
                destination.transferFrom(source, 0, source.size());
            }
            if (source != null) {
                source.close();
            }
            if (destination != null) {
                destination.close();
            }


}
    private Boolean CekMandatory(){
    	  boolean retval=true;
    	  View selectedView = info_jaminan_spn_attachtype.getSelectedView();
    	  if (selectedView != null && selectedView instanceof TextView) {
    	      TextView selectedTextView = (TextView) selectedView;
    	      if (info_jaminan_spn_attachtype.getSelectedListOfValue().toString().length()==0) {
    	          String errorString = selectedTextView.getResources().getString(R.drawable.error);
    	          selectedTextView.setError(errorString);
    	          retval=false;
    	      }
    	      else {
    	          selectedTextView.setError(null);
    	      }
    	  }
    	  return retval;
    }
    private void performCrop() {
        // take care of exceptions
        try {
            // call the standard crop action intent (the user device may not
            // support it)
            Intent cropIntent = new Intent("com.android.camera.action.CROP");
            // indicate image type and Uri
            cropIntent.setDataAndType(picUri, "image/*");
            // set crop properties
            cropIntent.putExtra("crop", "true");
            // indicate aspect of desired crop
            cropIntent.putExtra("aspectX", 2);
            cropIntent.putExtra("aspectY", 1);
            // indicate output X and Y
            cropIntent.putExtra("outputX", 256);
            cropIntent.putExtra("outputY", 256);
            // retrieve data on return
            cropIntent.putExtra("return-data", true);
            // start the activity - we handle returning in onActivityResult
            startActivityForResult(cropIntent, CROP_PIC);
        }
        // respond to users whose devices do not support the crop action
        catch (ActivityNotFoundException anfe) {
            Toast toast = Toast.makeText(ctx, "This device doesn't support the crop action!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    public void captureImage(final List<ImageView> _imgView, final List<TextView> _lblView) {
        final CameraDialog cameraDialog = new CameraDialog(ctx);

        cameraDialog.getCameraPreview().setCameraActionListiner(new CameraActionListener() {
            @Override
            public void onPictureTaken(CameraPreview cameraPreview) {
                Bitmap bmp;
                //String fileName = userDetail.getUSERID() + DateFormatter.formatStringFORMATDDMMYYHHMMSS(new Date());
                
                String fileName = userDetail.getUSERID() + DateFormatter.formatStringFORMATDDMMYYHHMMSS(new Date());
                
                FileUtility.deleteFile(fileName, AppConstants.FILEPATH);
                fileName = fileName + "_" + AppConstants.JPGEXTENSION;
               /* for (int i = 0; i < _imgView.size(); i++) {
                    if (_imgView.get(i).getDrawable() == null) {
                        fileName = fileName + "_" + (i + 1) + AppConstants.JPGEXTENSION;
                        break;
                    }

                }
*/
                cameraDialog.getCameraPreview().savePictureTo(new File(AppConstants.FILEPATH + fileName));
                cameraDialog.getCameraPreview().stopCamera();
                FileUtility.resizeImage(fileName, AppConstants.FILEPATH);

                int intCount=1;
            	intCount=photoDataProvider.get_MaxSeq(ap_regno);
            	photodata.setID("Appraisal|" + col_id + intCount);
                photodata.setAP_REGNO(ap_regno);
                photodata.setATTACH_ID("Appraisal|" + col_id);
                photodata.setATTACH_SEQ("" + intCount);
                photodata.setATTACH_TYPE(col_type);
                photodata.setATTACH_TYPE_CODE(info_jaminan_spn_attachtype.getSelectedListOfValue().toString());
                photodata.setFILENAME(fileName);
                photodata.setFILETYPE("image/jpeg");
                photodata.setUPLOADBY("");
                photodata.setUPLOADDATE(new Date());
                photodata.setCOL_ID(col_id);
                photoDataProvider.updateATTACHMENT(photodata);
              	loadImage();
                cameraDialog.dismiss();
            }
        });

        cameraDialog.show();

    }
    @SuppressLint("ShowToast")
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
    	super.onActivityResult(requestCode, resultCode, data);
        
        if (requestCode == REQUEST_CODE_CHOOSE_PICTURE_FROM_GALLARY && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
 
            Cursor cursor = getActivity().getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
 
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
             
            String fileName =  userDetail.getUSERID()  + DateFormatter.formatStringFORMATDDMMYYHHMMSS(new Date());
            fileName = fileName + "_" + AppConstants.JPGEXTENSION;
            File directory = new File(picturePath);
           
            Bitmap imgBitmap =  BitmapFactory.decodeFile(picturePath);
            FileUtility.resizeImageFile(directory.getName().toString(),fileName,directory.getParent().toString(),AppConstants.FILEPATH);
            
           
            
            
            int intCount=1;
        	intCount=photoDataProvider.get_MaxSeq(ap_regno);
        	photodata.setID("Appraisal|" + col_id + intCount);
            photodata.setAP_REGNO(ap_regno);
            photodata.setATTACH_ID("Appraisal|" + col_id);
            photodata.setATTACH_SEQ("" + intCount);
            photodata.setATTACH_TYPE(col_type);
            photodata.setATTACH_TYPE_CODE(info_jaminan_spn_attachtype.getSelectedListOfValue().toString());
            photodata.setFILENAME(fileName);
            photodata.setFILETYPE("image/jpeg");
            photodata.setUPLOADBY("");
            photodata.setUPLOADDATE(new Date());
            photoDataProvider.updateATTACHMENT(photodata);
          	loadImage();
        }
        else  if (requestCode ==CAMERA_CAPTURE )
        {
        	
            FileUtility.resizeImage(filename, AppConstants.FILEPATH);
            int intCount=1;
        	intCount=photoDataProvider.get_MaxSeq(ap_regno);
        	photodata.setID("Appraisal|" + col_id + intCount);
            photodata.setAP_REGNO(ap_regno);
            photodata.setATTACH_ID("Appraisal|" + col_id);
            photodata.setATTACH_SEQ("" + intCount);
            photodata.setATTACH_TYPE(col_type);
            photodata.setATTACH_TYPE_CODE(info_jaminan_spn_attachtype.getSelectedListOfValue().toString());
            photodata.setFILENAME(filename);
            photodata.setFILETYPE("image/jpeg");
            photodata.setUPLOADBY("");
            photodata.setUPLOADDATE(new Date());
            photodata.setCOL_ID(col_id);
            photoDataProvider.updateATTACHMENT(photodata);
          	loadImage();
          	filename="";
        }
     }
    public Bitmap getPicture(String fileName) {
        File directory = new File(AppConstants.FILEPATH);
        File fileInDirectory = new File(directory, fileName);
        Bitmap imgBitmap = BitmapFactory.decodeFile(fileInDirectory.getAbsolutePath());

        return imgBitmap;

    }
    public void SetPreviewImage( final TextView lblView, final Bitmap bmp, final String fileName, final String id, final boolean statusAvailableImage) {
                previewimg = new PreviewImageNew(ctx);
                previewimg.getImgPreview().setImageBitmap(bmp);

                if (!statusAvailableImage) {
                    previewimg.getDeleteButton().setVisibility(View.GONE);
                }

                previewimg.getDeleteButton().setOnClickListener(new View.OnClickListener() {
                    @SuppressWarnings("deprecation")
                    @Override
                    public void onClick(View v) {
                        try {
                            lblView.setText(R.string.str_dash);

                            if (!id.equalsIgnoreCase("0")) {
                                new DeletePhotoTask().execute(id);
                            } else {
                                FileUtility.deleteFile(fileName, AppConstants.FILEPATH);
                                //showAlert(R.string.msg_notification_photo_delete_success_submit);
                            }

                           
                        } catch (Exception e) {

                        }
                        previewimg.dismiss();
                        previewimg = null;
                    }
                });

                previewimg.getCancelButton().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        previewimg.dismiss();
                        previewimg = null;
                    }
                });

                previewimg.show();
    }
    

    // Task Delete Image
    private class DeletePhotoTask extends AsyncTask<String, String, String> {
        boolean responseSuccess = false;
        PhotoData photoData = null;

        @Override
        protected String doInBackground(String... photoId) {
            //Log.d(TAG, "doInbackground");
            photoData = photoDataProvider.getATTACHMENTDetail(photoId[0]);
                try {
                    ArrayList<PHOTORESPONSE> arrPhotoResponse = ServiceDataProvider.deletePhoto(photoData.getID(), photoData.getFILENAME());
                    if (arrPhotoResponse != null) {
                        if (arrPhotoResponse.size() > 0) {
                            if (arrPhotoResponse.get(0).getFILENAME().equalsIgnoreCase(photoData.getFILENAME())) {
                                responseSuccess = true;
                            }
                        }
                    }
                    arrPhotoResponse = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            

       
            return photoId[0];
        }

        @Override
        protected void onPostExecute(String idPhoto) {
          /*  //Log.d(TAG, "Message Tasks: On post Execute");
            if (responseSuccess) {
                FileUtility.deleteFile(photoData.getFILENAME(), AppConstants.FILEPATH);
                try {
                    photoDataProvider.deletePhotoById(photoData.getID().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //showAlert(R.string.msg_notification_photo_delete_success_submit);
            } else {
                photoData.setISPENDINGDELETED(true);
                photoDataProvider.updatePhoto(photoData);
                //showAlert(R.string.msg_notification_photo_delete_error_submit);
            }*/
        }
    }
    private void loadData(String col_id){
    	
    	datatype_Appr_Collateral=appr_Collateral.getAllAppr_Collateral(col_id);
      	if(datatype_Appr_Collateral.COL_ID!=null && !datatype_Appr_Collateral.COL_ID.toString().equals("")){
      		header_alamat.setText(datatype_Appr_Collateral.getCOL_ADDR1() + " , " +  datatype_Appr_Collateral.getCOL_KELURAHAN() + " , " +  datatype_Appr_Collateral.getCOL_KECAMATAN() + " , " +  datatype_Appr_Collateral.getCOL_CITY() + " , " +  datatype_Appr_Collateral.getCOL_ZIPCODE());
      		header_deb.setText(datatype_Appr_Collateral.getAP_REGNO() + " # " + datatype_Appr_Collateral.getCU_NAME() );
      		
      		info_jaminan_lbl_jenis_jaminan_1.setText(datatype_Appr_Collateral.getCOL_CLASS_DESC());
      		info_jaminan_lbl_bentuk_jaminan_1.setText(datatype_Appr_Collateral.getCOL_DESC());
      		info_jaminan_lbl_jenis_dokumen_1.setText(datatype_Appr_Collateral.getCOL_DESC());
      		info_jaminan_lbl_no_dokumen_1.setText(datatype_Appr_Collateral.getCOL_DOK_NO());
      		info_jaminan_lbl_an_dokumen_1.setText(datatype_Appr_Collateral.getCOL_DOK_NAME());
      		info_jaminan_lbl_hubungan_1.setText(datatype_Appr_Collateral.getCOL_RELATIONSHIP());
      		info_jaminan_lbl_contact_1.setText(datatype_Appr_Collateral.getCP_NAME());
      		info_jaminan_lbl_hp_1.setText(datatype_Appr_Collateral.getCP_HP());
      		info_jaminan_lbl_almt_1.setText(datatype_Appr_Collateral.getCOL_ADDR1());
      		info_jaminan_lbl_kecamatan_1.setText(datatype_Appr_Collateral.getCOL_KECAMATAN());
      		info_jaminan_lbl_kelurahan_1.setText(datatype_Appr_Collateral.getCOL_KELURAHAN());
      		info_jaminan_lbl_kota_1.setText(datatype_Appr_Collateral.getCOL_CITY());
      		info_jaminan_lbl_kode_pos_1.setText(datatype_Appr_Collateral.getCOL_ZIPCODE());
      		info_jaminan_lbl_cek_tata_kota_1.setText(datatype_Appr_Collateral.getTATAKOTA_DESC());
      		info_jaminan_lbl_penilaian_1.setText(datatype_Appr_Collateral.getAPPR_DESC());
      		
      		appr_rtb_valuation_int=appr_Rtb_ValuationDataProvider.getAllAppr_Rtb_Valuation_Int(col_id);
      		
      		if(col_type.equals("RE") && !datatype_Appr_Collateral.getAPPRAISE_TYPE().equals("B") && !datatype_Appr_Collateral.getAPPRAISE_TYPE().equals("M") && !datatype_Appr_Collateral.getAPPRAISE_TYPE().equals("L") )
      		{
      			String appraise = datatype_Appr_Collateral.getAPPRAISE_TYPE();
                if (appraise.equals("C"))
                    appraise = appraise + appr_rtb_valuation_int.getAPPR_JNSPENILAIAN();
                //if (Request.QueryString["apprstype"].ToString() == "INT" && Request.QueryString["atc"] == "1.1")
                else
                	GenerateType = appraise + "2";
                //else GenerateType = appraise;
      		}
      		else if (col_type.equals("RE") ){
      			if (appr_rtb_valuation_int.getAP_REGNO().equals(null) || (!appr_rtb_valuation_int.getAP_REGNO().equals(null) &&( appr_rtb_valuation_int.getAPPR_JNSPENILAIAN().equals(null) || appr_rtb_valuation_int.getAPPR_JNSPENILAIAN().equals(""))))
                {
                    //if (Request.QueryString["apprstype"].ToString() == "INT" && Request.QueryString["atc"] == "1.1")
                        GenerateType = col_type + "2";
                   // else generate.GenerateType = dt3.Rows[0]["COL_TYPE"].ToString();
                }
                else
                {
                    //if (Request.QueryString["apprstype"].ToString() == "INT" && Request.QueryString["atc"] == "1.1")
                        GenerateType = appr_rtb_valuation_int.getAPPR_JNSPENILAIAN() + "2";
                    //else generate.GenerateType = dt4.Rows[0]["APPR_JNSPENILAIAN"].ToString();
                }
      			
      		}	
      		else{
      			//if (Request.QueryString["apprstype"].ToString() == "INT" && Request.QueryString["atc"] == "1.1")
                    GenerateType = col_type + "2";
                //else generate.GenerateType = dt3.Rows[0]["COL_TYPE"].ToString();
      			
      		}	
      	}
      	
      	loadImage();
      	loadFile();
      	 
    }
    private void loadImage(){
    	
    			listdata = photoDataProvider.getATTACHMENTByProspek(ap_regno);
    			inbox_tableLayout.removeAllViews();
    			
    	        TableRow rowHeaderTable = new TableRow(ctx);
    	        rowHeaderTable.setBackgroundColor(getResources().getColor(R.color.color_bacground2));
    	        rowHeaderTable.setPadding(0, 0, 0, 2);

    	        TableRow.LayoutParams rowParamsDetail = new TableRow.LayoutParams();
    	        rowParamsDetail.gravity = Gravity.LEFT;

    	        TextView header9 = new TextView(ctx);
    	        header9.setGravity(Gravity.LEFT);
    	        header9.setTextColor(getResources().getColor(android.R.color.black));
    	        header9.setPadding(0, 2, 0,2);
    	        header9.setTextSize(12);
    	        header9.setWidth(50);
    	        header9.setText("No");
    	        rowHeaderTable.addView(header9, rowParamsDetail);
    	        
    	        TextView header1 = new TextView(ctx);
    	        header1.setGravity(Gravity.LEFT);
    	        header1.setTextColor(getResources().getColor(android.R.color.black));
    	        header1.setPadding(0, 3, 0, 3);
    	        header1.setTextSize(12);
    	        header1.setWidth(380);
    	        header1.setText("Nama file");
    	        rowHeaderTable.addView(header1, rowParamsDetail);
    	        
    	        TextView header3 = new TextView(ctx);
    	        header3.setGravity(Gravity.LEFT);
    	        header3.setTextColor(getResources().getColor(android.R.color.black));
    	        header3.setPadding(0, 3, 0, 3);
    	        header3.setTextSize(12);
    	        header3.setWidth(200);
    	        header3.setText("Tipe file");
    	        rowHeaderTable.addView(header3, rowParamsDetail);

    	        TextView header2 = new TextView(ctx);
    	        header2.setGravity(Gravity.LEFT);
    	        header2.setTextColor(getResources().getColor(android.R.color.black));
    	        header2.setPadding(0, 3, 0, 3);
    	        header2.setTextSize(12);
    	        header2.setWidth(200);
    	        header2.setText("Action");
    	        rowHeaderTable.addView(header2, rowParamsDetail);

    	        inbox_tableLayout.addView(rowHeaderTable);

    	        for (int i = 0; i < listdata.size(); i++) {
    	            final PhotoData contentdata = listdata.get(i);
    	            final TableRow rowContentTable = new TableRow(ctx);
    	            if ((i + 1) % 2 == 0) {
    	                rowContentTable.setBackgroundColor(getResources().getColor(R.color.color_bacground1));
    	            } else {
    	                rowContentTable.setBackgroundColor(Color.WHITE);
    	            }
    	            
    	            TextView content_col_id_1 = new TextView(ctx);
    	            content_col_id_1.setText("" + contentdata.getID());
    	            content_col_id_1.setVisibility(View.GONE);
    	            rowContentTable.addView(content_col_id_1);
    	            
    	            TextView content_col_id = new TextView(ctx);
    	            content_col_id.setText(contentdata.getAP_REGNO());
    	            content_col_id.setVisibility(View.GONE);
    	            rowContentTable.addView(content_col_id);
    	            
    	           /* TextView content_ap_regno = new TextView(ctx);
    	            content_ap_regno.setText(contentdata.getPROSPEKID());
    	            content_ap_regno.setVisibility(View.GONE);
    	            rowContentTable.addView(content_ap_regno);*/
    	            
    	            TextView content_no = new TextView(ctx);
    	            content_no.setGravity(Gravity.LEFT);
    	            content_no.setTextColor(getResources().getColor(android.R.color.black));
    	            content_no.setPadding(0, 3, 0, 3);
    	            content_no.setTextSize(12);
    	            content_no.setWidth(50);
    	            content_no.setText(" " + (i + 1));
    	            rowContentTable.addView(content_no, rowParamsDetail);
    	            
    				TextView content_file = new TextView(ctx);
    	            content_file.setGravity(Gravity.LEFT);
    	            content_file.setTextColor(getResources().getColor(android.R.color.black));
    	            content_file.setPadding(0, 3, 0, 3);
    	            content_file.setTextSize(12);
    	            content_file.setWidth(350);
    	            content_file.setText(contentdata.getFILENAME());
    	            rowContentTable.addView(content_file, rowParamsDetail);
    				
    	            TextView content_tipe = new TextView(ctx);
    	            content_tipe.setGravity(Gravity.LEFT);
    	            content_tipe.setTextColor(getResources().getColor(android.R.color.black));
    	            content_tipe.setPadding(0, 3, 0, 3);
    	            content_tipe.setTextSize(12);
    	            content_tipe.setWidth(200);
    	            LovData	lov = lovDataProvider.getLOVDetail(contentdata.getATTACH_TYPE_CODE().toString(), tipefile);
    	    	    try{
    	    	    	content_tipe.setText(lov.getDESCRIPTION().toString());
    	    	    }
    	            catch(Exception ex){
    	    	    	content_tipe.setText("");
    	            }
    	            rowContentTable.addView(content_tipe, rowParamsDetail);
    	            
    	            Button content_booked = new Button(ctx);
    	            content_booked.setGravity(Gravity.LEFT);
    	            
    	            content_booked.setText(R.string.form_action_detail);
    	            content_booked.setWidth(100);
    	            rowContentTable.addView(content_booked,90, 50);
    	            content_booked.setOnClickListener(new View.OnClickListener() {
    	                @Override
    	                public void onClick(View v) {
    	                	TextView content_col_id_1 = (TextView) rowContentTable.getChildAt(0);
    	                	TextView content_file = (TextView) rowContentTable.getChildAt(3);
    	    
    	                	try {
    	                        Bitmap bmp;
    	                            try {
    	                                bmp = getPicture(content_file.getText().toString());
    	                            } catch (Exception e) {
    	                                bmp = getUnAvailablePicture();
    	                        }
    	                          SetPreviewImage(content_file, bmp, content_file.getText().toString(), content_col_id_1.getText().toString(), true);
    	                    } catch (Exception ex) {


    	                    }
    	                	
    	                }
    	            });
    	            
    	            Button content_detail = new Button(ctx);
    	            content_detail.setGravity(Gravity.LEFT);
    	            content_detail.setText(R.string.DELETEPHOTO);
    	            content_detail.setWidth(100);
    	            rowContentTable.addView(content_detail, 90, 50);
    	            content_detail.setOnClickListener(new View.OnClickListener() {
    	                @Override
    	                public void onClick(View v) {
    	                	TextView content_col_id_1 = (TextView) rowContentTable.getChildAt(0);
    	                	try {
								photoDataProvider.deleteATTACHMENTById(content_col_id_1.getText().toString());
								loadImage();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
    	                	
    	                	
    	                }
    	            });
    	        
    	         

    	            inbox_tableLayout.addView(rowContentTable);
    	        }

    	   /*     if (contentContainer != null) {
    	            contentContainer.removeView(prevShownView);
    	        }

    	        contentContainer.addView(inbox_layout);*/
    	       
    }
    private void loadFile(){
    	
		listdatafile = appr_Attachment.getAllAppr_Attachment_Int(col_id);
		inbox_tableLayoutfile.removeAllViews();
		
        TableRow rowHeaderTable = new TableRow(ctx);
        rowHeaderTable.setBackgroundColor(getResources().getColor(R.color.color_bacground2));
        rowHeaderTable.setPadding(0, 0, 0, 2);

        TableRow.LayoutParams rowParamsDetail = new TableRow.LayoutParams();
        rowParamsDetail.gravity = Gravity.LEFT;

        TextView header9 = new TextView(ctx);
        header9.setGravity(Gravity.LEFT);
        header9.setTextColor(getResources().getColor(android.R.color.black));
        header9.setPadding(0, 2, 0,2);
        header9.setTextSize(12);
        header9.setWidth(50);
        header9.setText("No");
        rowHeaderTable.addView(header9, rowParamsDetail);
        
        TextView header1 = new TextView(ctx);
        header1.setGravity(Gravity.LEFT);
        header1.setTextColor(getResources().getColor(android.R.color.black));
        header1.setPadding(0, 3, 0, 3);
        header1.setTextSize(12);
        header1.setWidth(380);
        header1.setText("Nama file");
        rowHeaderTable.addView(header1, rowParamsDetail);
        
        TextView header3 = new TextView(ctx);
        header3.setGravity(Gravity.LEFT);
        header3.setTextColor(getResources().getColor(android.R.color.black));
        header3.setPadding(0, 3, 0, 3);
        header3.setTextSize(12);
        header3.setWidth(200);
        header3.setText("Status");
        rowHeaderTable.addView(header3, rowParamsDetail);

        TextView header2 = new TextView(ctx);
        header2.setGravity(Gravity.LEFT);
        header2.setTextColor(getResources().getColor(android.R.color.black));
        header2.setPadding(0, 3, 0, 3);
        header2.setTextSize(12);
        header2.setWidth(200);
        header2.setText("Action");
        rowHeaderTable.addView(header2, rowParamsDetail);

        inbox_tableLayoutfile.addView(rowHeaderTable);
        

        for (int i = 0; i < listdatafile.size(); i++) {
            final Datatype_attachment contentdata = listdatafile.get(i);
            final TableRow rowContentTable = new TableRow(ctx);
            if ((i + 1) % 2 == 0) {
                rowContentTable.setBackgroundColor(getResources().getColor(R.color.color_bacground1));
            } else {
                rowContentTable.setBackgroundColor(Color.WHITE);
            }
            
            TextView content_col_id_1 = new TextView(ctx);
            content_col_id_1.setText("" + contentdata.getID());
            content_col_id_1.setVisibility(View.GONE);
            rowContentTable.addView(content_col_id_1);
            
            TextView content_col_id = new TextView(ctx);
            content_col_id.setText(contentdata.getAP_REGNO());
            content_col_id.setVisibility(View.GONE);
            rowContentTable.addView(content_col_id);
            
           /* TextView content_ap_regno = new TextView(ctx);
            content_ap_regno.setText(contentdata.getPROSPEKID());
            content_ap_regno.setVisibility(View.GONE);
            rowContentTable.addView(content_ap_regno);*/
            
            TextView content_no = new TextView(ctx);
            content_no.setGravity(Gravity.LEFT);
            content_no.setTextColor(getResources().getColor(android.R.color.black));
            content_no.setPadding(0, 3, 0, 3);
            content_no.setTextSize(12);
            content_no.setWidth(50);
            content_no.setText(" " + (i + 1));
            rowContentTable.addView(content_no, rowParamsDetail);
            
			TextView content_file = new TextView(ctx);
            content_file.setGravity(Gravity.LEFT);
            content_file.setTextColor(getResources().getColor(android.R.color.black));
            content_file.setPadding(0, 3, 0, 3);
            content_file.setTextSize(12);
            content_file.setWidth(350);
            content_file.setText(contentdata.getFILENAME());
            rowContentTable.addView(content_file, rowParamsDetail);
			
            TextView content_tipe = new TextView(ctx);
            content_tipe.setGravity(Gravity.LEFT);
            content_tipe.setTextColor(getResources().getColor(android.R.color.black));
            content_tipe.setPadding(0, 3, 0, 3);
            content_tipe.setTextSize(12);
            content_tipe.setWidth(200);
            if(contentdata.getISDOWNLOAD().equals("1"))
            	content_tipe.setText("Done");
            if(contentdata.getISDOWNLOAD().equals("0"))
            	content_tipe.setText("In Progress");
            
            rowContentTable.addView(content_tipe, rowParamsDetail);
            
            Button content_booked = new Button(ctx);
            content_booked.setGravity(Gravity.LEFT);
            
            content_booked.setText(R.string.form_action_detail);
            content_booked.setWidth(100);
            rowContentTable.addView(content_booked,90, 50);
            content_booked.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                	TextView content_col_id_1 = (TextView) rowContentTable.getChildAt(0);
                	TextView content_file = (TextView) rowContentTable.getChildAt(3);
    
                	try {
                		displaypdf(content_file.getText().toString());
                    } catch (Exception ex) {


                    }
                	
                }
            });
            
            Button content_detail = new Button(ctx);
            content_detail.setGravity(Gravity.LEFT);
            content_detail.setText(R.string.DELETEPHOTO);
            content_detail.setWidth(100);
            rowContentTable.addView(content_detail, 90, 50);
            content_detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                	TextView content_col_id_1 = (TextView) rowContentTable.getChildAt(0);
                	try {
						photoDataProvider.deleteATTACHMENTById(content_col_id_1.getText().toString());
						loadImage();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                	
                	
                }
            });
        
         

            inbox_tableLayoutfile.addView(rowContentTable);
        }

   /*     if (contentContainer != null) {
            contentContainer.removeView(prevShownView);
        }

        contentContainer.addView(inbox_layout);*/
       
}


    public Bitmap getUnAvailablePicture() {
        Bitmap imgBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.no_image_available);
        return imgBitmap;
    }  
    private class SubmittedPhoto extends AsyncTask<Void, Void,Void> {
  		PhotoDataProvider photoDataProvider=new PhotoDataProvider();
  		//Datatype_Appr_History_Workflow appr_history_workflow=new Datatype_Appr_History_Workflow();
  		@Override
  		protected Void doInBackground(Void... params) {
  				ArrayList<PhotoData> arrdata = photoDataProvider.getATTACHMENTByProspek(ap_regno) ;
				if (arrdata.size() > 0){
					try {
						Gson gsondata=new Gson();
						 for (int i = 0; i < arrdata.size(); i++) {
							 ArrayList<NameValuePair> params1 = new ArrayList<NameValuePair>();
							 params1.add(new BasicNameValuePair("ID", arrdata.get(i).getID().toString()));
							 params1.add(new BasicNameValuePair("AP_REGNO", arrdata.get(i).getAP_REGNO().toString()));
							 params1.add(new BasicNameValuePair("ATTACH_ID", arrdata.get(i).getATTACH_ID().toString()));
							 params1.add(new BasicNameValuePair("ATTACH_SEQ", arrdata.get(i).getATTACH_SEQ().toString()));
							 params1.add(new BasicNameValuePair("FILEFOLDER", arrdata.get(i).getFILEFOLDER().toString()));
							 params1.add(new BasicNameValuePair("FILENAME", arrdata.get(i).getFILENAME().toString()));
							 params1.add(new BasicNameValuePair("FILETYPE", arrdata.get(i).getFILETYPE().toString()));
							 params1.add(new BasicNameValuePair("FILESIZE", arrdata.get(i).getFILESIZE().toString()));
							 params1.add(new BasicNameValuePair("UPLOADBY", arrdata.get(i).getUPLOADBY().toString()));
							 try{
								 params1.add(new BasicNameValuePair("UPLOADDATE", DataConverter.dateTimeToString(arrdata.get(i).getUPLOADDATE())));
							 }
							 catch(Exception ex)
							 {
								 params1.add(new BasicNameValuePair("UPLOADDATE", ""));
							 }
							 params1.add(new BasicNameValuePair("ATTACH_TYPE", arrdata.get(i).getATTACH_TYPE().toString()));
							 params1.add(new BasicNameValuePair("ATTACH_TYPE_CODE", arrdata.get(i).getATTACH_TYPE_CODE().toString()));
	
	                         PHOTORESPONSE photoResponse = ServiceDataProvider.uploadProspekPhotoGenfile(params1, arrdata.get(i).getFILENAME());
	                         if (photoResponse != null) {
	                           /*  if (photoResponse.getFILENAME().equalsIgnoreCase(arrdata.get(i).getFILENAME())) {
	                                 listphoto.get(i).setISALREADYUPLOADEDTOSERVER(true);
	                             } else {
	                                 listphoto.get(i).setISPENDINGUPLOADED(true);
	                             }
	                             photoDataProvider.updatePhoto(listphoto.get(i));*/
	                         }	
						 }
					} catch (Exception e) {
						Log.d("Error", "Send Data To Server Via Service: Exception ->"+e.getMessage());
					}
				}
				else{
					//Log.d(TAG, "No data to be syncronized");
				}
				arrdata = null;
				return null;
  		}
  		
  		 @Override
  	     protected void onPostExecute(Void result) {
  			photoDataProvider = null;
  		 }	 
      }
    private class SubmittedAttachmentHeader extends AsyncTask<Void, Void,Void> {
  		Appr_DokumentDataProvider appr_DokumentDataProvider=new Appr_DokumentDataProvider();
  		Datatype_attachment attachment =new Datatype_attachment();
  		//Datatype_Appr_History_Workflow appr_history_workflow=new Datatype_Appr_History_Workflow();
  		@Override
  		protected Void doInBackground(Void... params) {
  			ArrayList<PhotoData> arrdata = photoDataProvider.getATTACHMENTByProspek(ap_regno) ;
  				//if (arrdata.size() > 0){
  					try {
  						
  						
  						Gson gsondata=new Gson();
  						attachment.setAP_REGNO(ap_regno);
  						attachment.setCOL_ID(col_id);
  						attachment.setGENERATE_TYPE(GenerateType);
  						attachment.setGENERATE_TYPE_REFF(info_jaminan_spn_tipefile.getSelectedListOfValue().toString());
  						attachment.setSTATUS("1");
  						attachment.setTOTAL_IMAGE(""+ arrdata.size());
  						attachment.setUSERID(userDetail.getUSERID());
  						attachment.setFILEPATH("");
  						attachment.setISDOWNLOAD("0");
  						attachment.setISSTATUS("1");
  						ArrayList<DATA_RESPONSE> Response = ServiceDataProvider.submitData_Insertattachment(gsondata.toJson(attachment).toString());
  						if (Response != null){
  							if (Response.size() > 0){
  								for (int i=0;i<Response.size();i++ ){
  									DATA_RESPONSE objRes= Response.get(i);
  									if (objRes.getSTATUS().equalsIgnoreCase(AppConstants.STATUSPROSPEKTRUE)){
  										String id=objRes.getID();
  										/*String prospekid = objRes.getID();
  										Datatype_Appr_imb pd= appr_ImbProvider.getAllAppr_imb_by_id(id);
  										pd.setPROSPEKID(prospekid);	
  										pd.setISPENDINGUPLOADED(false);								
  										try {
  											followupDataProvider.updateProspekIdFollowUp(prospekid, id);
  											prospekDataProvider.updateProspek(pd);
  										} catch (Exception e) {
  											Log.d(TAG, "Error Update Data: "+e.getMessage());
  										}*/
  									}
  								}	
  							}			
  						}
  						else{
  							//Log.d(TAG, "Send Data To Server Via Service: Server returned null");
  						}
  					} catch (Exception e) {
  						Log.d("Error", "Send Data To Server Via Service: Exception ->"+e.getMessage());
  					}
  				//}
  				//else{
  					//Log.d(TAG, "No data to be syncronized");
  				//}
  				arrdata = null;
  				return null;
  		}
  		
  		 @Override
  	     protected void onPostExecute(Void result) {
  			appr_DokumentDataProvider = null;
  		 }	 
      }
   
    public String DownloadImageFromUrl(String AP_REGNO, String COL_ID, String GENERATE_TYPE,String GENERATE_TYPE_REFF) throws Exception {
    	String fileName="Test.pdf";
        //if (!file.exists()) {
            URL url = new URL(JSONServiceHandler.URLDOWNLOADIMAGESERVER + "FileManagerService.svc/RetrieveFileGen/?AP_REGNO=" + AP_REGNO + "&COL_ID=" + COL_ID + "&GENERATE_TYPE=" + GENERATE_TYPE + "&GENERATE_TYPE_REFF=" + GENERATE_TYPE_REFF );
            URLConnection ucon = url.openConnection();
            Map<String, List<String>> map = ucon.getHeaderFields();
            
        	System.out.println("Printing Response Header...\n");
         
        	
        	for (Map.Entry<String, List<String>> entry : map.entrySet()) {
        		 String key = entry.getKey();
        		 try{
	        		 if(key.compareTo("sfilename")==0){
	        			 //List<String> value = entry.getValue(); 
	        			 fileName=entry.getValue().get(0);
	        			 
	        			 //System.out.println(values);
	        			 //System.out.println(value);
	        		 }
        		 }
        		 catch(Exception ex){}
        		/*System.out.println("Key : " + entry.getKey()
                                   + " ,Value : " + entry.getValue());
        		if(entry.getKey().compareTo(AppConstants.HEADERFILE)==0)
        		{
        			fileName=entry.getValue().toString();
        		}	
        		String xx=entry.getKey().toString();
        		System.out.println( xx);*/
        	}
         
            File file = new File(AppConstants.FILEPATH + "/" + ap_regno + fileName);
                
            InputStream is = ucon.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
               /*
	            * Read bytes to the Buffer until there is nothing more to read(-1).
	            */
            ByteArrayBuffer baf = new ByteArrayBuffer(50);
            int current = 0;
            while ((current = bis.read()) != -1) {
                baf.append((byte) current);
            }

            /// save image to sdcard
            File folder = new File(AppConstants.FILEPATH + "/" + ap_regno);
            boolean success = true;
            if (!folder.exists()) {
                success = folder.mkdirs();
            }
            if (success) {
                // Do something on success
            } else {
                // Do something else on failure
            }
            FileOutputStream fos = new FileOutputStream(AppConstants.FILEPATH + "/" + ap_regno + fileName);
            fos.write(baf.toByteArray());
            fos.close();
            Datatype_attachment attachment =new Datatype_attachment();
            
          return fileName;
         
        //}
    }
    

    public void displaypdf(String filename) {

           File file = null;
           file = new File(AppConstants.FILEPATH + "/" + ap_regno + "/" + filename );
           //Toast.makeText(getApplicationContext(), file.toString() , Toast.LENGTH_LONG).show();
           if(file.exists()) {
               Intent target = new Intent(Intent.ACTION_VIEW);
               target.setDataAndType(Uri.fromFile(file), "application/pdf");
               target.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

               Intent intent = Intent.createChooser(target, "Open File");
               try {
                   startActivity(intent);
               } catch (ActivityNotFoundException e) {
                   // Instruct the user to install a PDF reader here, or something
               }
           }
        }
}
