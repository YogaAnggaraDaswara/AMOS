package com.mobile.appraisal;




import java.util.ArrayList;

import com.mobile.bo.app.dataprovider.Appr_HistoryProvider;
import com.mobile.bo.app.datatype.Datatype_Appr_History;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
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

public class Fragment_History_Appraisal extends Fragment {
	Button button;
    View view=null;
    Button Btnsave;
    private Context ctx = null;
    
    private String col_id="";
    private String ap_regno="";
    final int CAMERA_CAPTURE = 1;
    final int CROP_PIC = 2;
    private Uri picUri;
    private TableLayout inbox_tableLayout;
   
    private ArrayList<Datatype_Appr_History> listdataall  = null;
    private Appr_HistoryProvider appr_HistoryProvider;
    public Fragment_History_Appraisal() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_history, null);
        ctx = this.getActivity();
        appr_HistoryProvider=new Appr_HistoryProvider();
        inbox_tableLayout = (TableLayout) view.findViewById(R.id.inbox_tableLayout);
        Bundle b = getArguments();
        //initControl();
        col_id=b.getString("COL_ID");
        ap_regno=b.getString("AP_REGNO");
        viewDokJaminan();
        return view;
    }
   
     private void viewDokJaminan() {
    	
    	listdataall=appr_HistoryProvider.getAllAppr_histoy(col_id);
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
        header.setText("Agunan");

        rowHeaderTable.addView(header, rowParamsDetail);

        
        TextView header10 = new TextView(ctx);
        header10.setGravity(Gravity.LEFT);
        header10.setTextColor(getResources().getColor(android.R.color.black));
        header10.setPadding(0, 3, 0, 3);
        header10.setTextSize(12);
        header10.setWidth(500);
        header10.setText("Alamat");

        rowHeaderTable.addView(header10, rowParamsDetail);

        TextView header9 = new TextView(ctx);
        header9.setGravity(Gravity.LEFT);
        header9.setTextColor(getResources().getColor(android.R.color.black));
        header9.setPadding(0, 2, 0,2);
        header9.setTextSize(12);
        header9.setWidth(200);
        header9.setText("Market Price");
        rowHeaderTable.addView(header9, rowParamsDetail);
        
        TextView header1 = new TextView(ctx);
        header1.setGravity(Gravity.LEFT);
        header1.setTextColor(getResources().getColor(android.R.color.black));
        header1.setPadding(0, 3, 0, 3);
        header1.setTextSize(12);
        header1.setWidth(100);
        header1.setText("After Safety Margin");
        rowHeaderTable.addView(header1, rowParamsDetail);

        TextView header2 = new TextView(ctx);
        header2.setGravity(Gravity.LEFT);
        header2.setTextColor(getResources().getColor(android.R.color.black));
        header2.setPadding(0, 3, 0, 3);
        header2.setTextSize(12);
        header2.setWidth(70);
        header2.setText("Liquid Value");
        rowHeaderTable.addView(header2, rowParamsDetail);

        TextView header11 = new TextView(ctx);
        header11.setTextColor(getResources().getColor(android.R.color.black));
        header11.setPadding(0, 3, 0, 3);
        header11.setTextSize(12);
        header11.setWidth(70);
        header11.setText("Market Value (Fisik)");
        rowHeaderTable.addView(header11, rowParamsDetail);
        
        TextView header3 = new TextView(ctx);
        header3.setGravity(Gravity.LEFT);
        header3.setTextColor(getResources().getColor(android.R.color.black));
        header3.setPadding(0, 3, 0, 3);
        header3.setTextSize(12);
        header3.setWidth(70);
        header3.setText("Market Value (IMB)");
        rowHeaderTable.addView(header3, rowParamsDetail);

        TextView header4 = new TextView(ctx);
        header4.setGravity(Gravity.LEFT);
        header4.setTextColor(getResources().getColor(android.R.color.black));
        header4.setPadding(0, 3, 0, 3);
        header4.setTextSize(12);
        header4.setWidth(70);
        header4.setText("Liq Value (Fisik)");
        rowHeaderTable.addView(header4, rowParamsDetail);

        TextView header5 = new TextView(ctx);
        header5.setGravity(Gravity.LEFT);
        header5.setTextColor(getResources().getColor(android.R.color.black));
        header5.setPadding(0, 3, 0, 3);
        header5.setTextSize(12);
        header5.setWidth(70);
        header5.setText("Liq Value (IMB)");
        rowHeaderTable.addView(header5, rowParamsDetail);

        TextView header6 = new TextView(ctx);
        header6.setGravity(Gravity.LEFT);
        header6.setTextColor(getResources().getColor(android.R.color.black));
        header6.setPadding(0, 3, 0, 3);
        header6.setTextSize(12);
        header6.setWidth(100);
        header6.setText("Sampling Count");
        rowHeaderTable.addView(header6, rowParamsDetail);
        
        
        TextView header7 = new TextView(ctx);
        header7.setGravity(Gravity.LEFT);
        header7.setTextColor(getResources().getColor(android.R.color.black));
        header7.setPadding(0, 3, 0, 3);
        header7.setTextSize(12);
        header7.setWidth(150);
        header7.setText("Total Item");
        rowHeaderTable.addView(header7, rowParamsDetail);
        
        
        
        inbox_tableLayout.addView(rowHeaderTable);
        String lov_descoffer_type="",lov_desctransmisi="",lov_desckondisi="";
        //lovDataProvider = new LOVDataProvider();
        for (int i = 0; i < listdataall.size(); i++) {
            final Datatype_Appr_History contentdata = listdataall.get(i);
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
            content_ap_regno.setText(contentdata.getCOL_DESC().toString());
            rowContentTable.addView(content_ap_regno, rowParamsDetail);

            TextView content_jaminan = new TextView(ctx);
            content_jaminan.setGravity(Gravity.LEFT);
            content_jaminan.setTextColor(getResources().getColor(android.R.color.black));
            content_jaminan.setPadding(0, 3, 0, 3);
            content_jaminan.setTextSize(12);
            content_jaminan.setWidth(200);
            content_jaminan.setText(contentdata.getCOL_ADDR1().toString());
            rowContentTable.addView(content_jaminan, rowParamsDetail);

            TextView content_nama = new TextView(ctx);
            content_nama.setGravity(Gravity.LEFT);
            content_nama.setTextColor(getResources().getColor(android.R.color.black));
            content_nama.setPadding(0, 3, 0, 3);
            content_nama.setTextSize(12);
            content_nama.setWidth(100);
            content_nama.setText(contentdata.getMARKETVALUE());
            rowContentTable.addView(content_nama, rowParamsDetail);

            TextView content_tipe = new TextView(ctx);
            content_tipe.setGravity(Gravity.LEFT);
            content_tipe.setTextColor(getResources().getColor(android.R.color.black));
            content_tipe.setPadding(0, 3, 0, 3);
            content_tipe.setTextSize(12);
            content_tipe.setWidth(70);
            content_tipe.setText(contentdata.getSAFETYMARGIN().toString());
            rowContentTable.addView(content_tipe,rowParamsDetail);


            TextView content_transmisi = new TextView(ctx);
            content_transmisi.setGravity(Gravity.LEFT);
            content_transmisi.setTextColor(getResources().getColor(android.R.color.black));
            content_transmisi.setPadding(0, 3, 0, 3);
            content_transmisi.setTextSize(12);
            content_transmisi.setWidth(70);
            content_transmisi.setText(contentdata.getLIQVALUE().toString());
            rowContentTable.addView(content_transmisi,rowParamsDetail);
            
            
            TextView content_npwp = new TextView(ctx);
            content_npwp.setGravity(Gravity.LEFT);
            content_npwp.setTextColor(getResources().getColor(android.R.color.black));
            content_npwp.setPadding(0, 3, 0, 3);
            content_npwp.setTextSize(12);
            content_npwp.setWidth(70);
            content_npwp.setText(contentdata.getMARKETFISIK().toString());
            rowContentTable.addView(content_npwp,rowParamsDetail);

            
            TextView content_status = new TextView(ctx);
            content_status.setGravity(Gravity.LEFT);
            content_status.setTextColor(getResources().getColor(android.R.color.black));
            content_status.setPadding(0, 3, 0, 3);
            content_status.setTextSize(12);
            content_status.setWidth(70);
            content_status.setText(contentdata.getMARKETIMB().toString());
            rowContentTable.addView(content_status,rowParamsDetail);

            TextView content_aging = new TextView(ctx);
            content_aging.setGravity(Gravity.LEFT);
            content_aging.setTextColor(getResources().getColor(android.R.color.black));
            content_aging.setPadding(0, 3, 0, 3);
            content_aging.setTextSize(12);
            content_aging.setWidth(70);
            content_aging.setText(contentdata.getLIQFISIK().toString());
            rowContentTable.addView(content_aging,rowParamsDetail);

            TextView content_adjustment = new TextView(ctx);
            content_adjustment.setGravity(Gravity.LEFT);
            content_adjustment.setTextColor(getResources().getColor(android.R.color.black));
            content_adjustment.setPadding(0, 3, 0, 3);
            content_adjustment.setTextSize(12);
            content_adjustment.setWidth(100);
            content_adjustment.setText(contentdata.getLIQIMB());
            rowContentTable.addView(content_adjustment,rowParamsDetail);
            
            TextView content_narasumber = new TextView(ctx);
            content_narasumber.setGravity(Gravity.LEFT);
            content_narasumber.setTextColor(getResources().getColor(android.R.color.black));
            content_narasumber.setPadding(0, 3, 0, 3);
            content_narasumber.setTextSize(12);
            content_narasumber.setWidth(150);
            content_narasumber.setText(contentdata.getSAMPLINGCOUNT().toString());
            rowContentTable.addView(content_narasumber,rowParamsDetail);
            
            
            TextView content_phone = new TextView(ctx);
            content_phone.setGravity(Gravity.LEFT);
            content_phone.setTextColor(getResources().getColor(android.R.color.black));
            content_phone.setPadding(0, 3, 0, 3);
            content_phone.setTextSize(12);
            content_phone.setWidth(100);
            content_phone.setText(contentdata.getTOTALITEM().toString());
            rowContentTable.addView(content_phone,rowParamsDetail);
            
            
            inbox_tableLayout.addView(rowContentTable);
        }
     }
    

}
