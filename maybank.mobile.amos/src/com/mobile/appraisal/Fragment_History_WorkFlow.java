package com.mobile.appraisal;



import java.util.ArrayList;

import com.mobile.bo.app.dataprovider.Appr_History_WorkflowProvider;
import com.mobile.bo.app.datatype.Datatype_Appr_History_Workflow;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableLayout.LayoutParams;
import android.widget.TableRow;
import android.widget.TextView;

import bii.mobile.amos.R;

public class Fragment_History_WorkFlow extends Fragment {
	Button button;
    View view=null;
    private Context ctx = null;
    private String ap_regno="";
    final int CAMERA_CAPTURE = 1;
    final int CROP_PIC = 2;
    private TableLayout inbox_tableLayout;
   
    private ArrayList<Datatype_Appr_History_Workflow> listdataall  = null;
    private Appr_History_WorkflowProvider appr_History_WorkflowProvider;
    public Fragment_History_WorkFlow() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_history_workflow, null);
        ctx = this.getActivity();
        appr_History_WorkflowProvider=new Appr_History_WorkflowProvider();
        inbox_tableLayout = (TableLayout) view.findViewById(R.id.inbox_tableLayout);
        Bundle b = getArguments();
        
       
        
        //initControl();
        ap_regno=b.getString("AP_REGNO");
        viewDokJaminan();
        return view;
    }
   
     private void viewDokJaminan() {
    	
    	listdataall=appr_History_WorkflowProvider.getAllAppr_histoy(ap_regno);
    	inbox_tableLayout.removeAllViews();
    	
        TableRow rowHeaderTable = new TableRow(ctx);
        rowHeaderTable.setBackgroundColor(getResources().getColor(R.color.color_bacground2));
        rowHeaderTable.setPadding(0, 0, 0, 2);

        TableRow.LayoutParams rowParamsDetail = new TableRow.LayoutParams();
        rowParamsDetail.gravity = Gravity.LEFT;

        TextView header = new TextView(ctx);
        header.setGravity(Gravity.LEFT);
        header.setTextColor(getResources().getColor(android.R.color.black));
        header.setPadding(0, 3, 0, 3);
        header.setTextSize(12);
        header.setWidth(600);
        header.setText("Tahapan");

        rowHeaderTable.addView(header, rowParamsDetail);

        
        TextView header10 = new TextView(ctx);
        header10.setGravity(Gravity.LEFT);
        header10.setTextColor(getResources().getColor(android.R.color.black));
        header10.setPadding(0, 3, 0, 3);
        header10.setTextSize(12);
        header10.setWidth(500);
        header10.setText("Mulai");

        rowHeaderTable.addView(header10, rowParamsDetail);

        TextView header9 = new TextView(ctx);
        header9.setGravity(Gravity.LEFT);
        header9.setTextColor(getResources().getColor(android.R.color.black));
        header9.setPadding(0, 2, 0,2);
        header9.setTextSize(12);
        header9.setWidth(200);
        header9.setText("Selesai");
        rowHeaderTable.addView(header9, rowParamsDetail);
        
        TextView header1 = new TextView(ctx);
        header1.setGravity(Gravity.LEFT);
        header1.setTextColor(getResources().getColor(android.R.color.black));
        header1.setPadding(0, 3, 0, 3);
        header1.setTextSize(12);
        header1.setWidth(100);
        header1.setText("Aging");
        rowHeaderTable.addView(header1, rowParamsDetail);

        TextView header2 = new TextView(ctx);
        header2.setGravity(Gravity.LEFT);
        header2.setTextColor(getResources().getColor(android.R.color.black));
        header2.setPadding(0, 3, 0, 3);
        header2.setTextSize(12);
        header2.setWidth(70);
        header2.setText("Oleh");
        rowHeaderTable.addView(header2, rowParamsDetail);

        
        
        inbox_tableLayout.addView(rowHeaderTable);
        String lov_descoffer_type="",lov_desctransmisi="",lov_desckondisi="";
        //lovDataProvider = new LOVDataProvider();
        for (int i = 0; i < listdataall.size(); i++) {
            final Datatype_Appr_History_Workflow contentdata = listdataall.get(i);
            final TableRow rowContentTable = new TableRow(ctx);
            if ((i + 1) % 2 == 0) {
                rowContentTable.setBackgroundColor(getResources().getColor(R.color.color_bacground1));
            } else {
                rowContentTable.setBackgroundColor(Color.WHITE);
            }
        	

            TextView content_col_id = new TextView(ctx);
            content_col_id.setText(contentdata.getID());
            content_col_id.setVisibility(View.GONE);
            rowContentTable.addView(content_col_id);
            
            
            LayoutParams params = new LayoutParams(  
                    LayoutParams.WRAP_CONTENT,  
                    LayoutParams.WRAP_CONTENT);  
            params.setMargins(15, 15, 15, 15);  
            
            
            TextView content_ap_regno = new TextView(ctx);
            content_ap_regno.setGravity(Gravity.LEFT);
            content_ap_regno.setTextColor(getResources().getColor(android.R.color.black));
            content_ap_regno.setPadding(0, 3, 0, 3);
            content_ap_regno.setTextSize(12);
            content_ap_regno.setWidth(500);
            content_ap_regno.setText(contentdata.getTR_DESC().toString());
            rowContentTable.addView(content_ap_regno, rowParamsDetail);

            TextView content_jaminan = new TextView(ctx);
            content_jaminan.setGravity(Gravity.LEFT);
            content_jaminan.setTextColor(getResources().getColor(android.R.color.black));
            content_jaminan.setPadding(0, 3, 0, 3);
            content_jaminan.setTextSize(12);
            content_jaminan.setWidth(200);
            content_jaminan.setText(contentdata.getTR_START().toString());
            rowContentTable.addView(content_jaminan, rowParamsDetail);

            TextView content_nama = new TextView(ctx);
            content_nama.setGravity(Gravity.LEFT);
            content_nama.setTextColor(getResources().getColor(android.R.color.black));
            content_nama.setPadding(0, 3, 0, 3);
            content_nama.setTextSize(12);
            content_nama.setWidth(100);
            content_nama.setText(contentdata.getTR_END());
            rowContentTable.addView(content_nama, rowParamsDetail);

            TextView content_tipe = new TextView(ctx);
            content_tipe.setGravity(Gravity.LEFT);
            content_tipe.setTextColor(getResources().getColor(android.R.color.black));
            content_tipe.setPadding(0, 3, 0, 3);
            content_tipe.setTextSize(12);
            content_tipe.setWidth(70);
            content_tipe.setText(contentdata.getAGING().toString());
            rowContentTable.addView(content_tipe,rowParamsDetail);


            
            
            inbox_tableLayout.addView(rowContentTable);
        }
     }
    

}
