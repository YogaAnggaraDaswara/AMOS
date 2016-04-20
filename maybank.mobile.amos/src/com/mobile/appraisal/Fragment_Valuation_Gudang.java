package com.mobile.appraisal;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import bii.mobile.amos.R;
public class Fragment_Valuation_Gudang extends Fragment {


    public Fragment_Valuation_Gudang() {
    }

    private TableLayout tableLayout;
    private FragmentActivity ctx;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_valuation_kendaraan, null);
        tableLayout = (TableLayout) view.findViewById(R.id.tagihan_tableLayout);
        super.onCreate(savedInstanceState);
        ctx = getActivity();
        loadViewTagihan();
        return view;
    }

    private void loadViewTagihan() {

		/*if(listTagihan != null){
			if(tagihan.getTableLayout()!=null)
				tagihan.getTableLayout().removeAllViews();*/

        //tagihan = new Tagihan(ctx);
        //{"No","No.Rekening","Nama Debitur","Nominal","Sisa Tagihan","Action"};

        //Collections.sort(listTagihan);
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
        header.setWidth(1000);
        header.setText("No");
        rowHeaderTable.addView(header, rowParamsDetail);

        TextView header1 = new TextView(ctx);
        header1.setGravity(Gravity.LEFT);
        header1.setTextColor(getResources().getColor(android.R.color.black));
        header1.setPadding(0, 3, 0, 3);
        header1.setTextSize(12);
        header1.setWidth(1000);
        header1.setText("No.Rekening");
        rowHeaderTable.addView(header1, rowParamsDetail);

        TextView header2 = new TextView(ctx);
        header2.setGravity(Gravity.LEFT);
        header2.setTextColor(getResources().getColor(android.R.color.black));
        header2.setPadding(0, 3, 0, 3);
        header2.setTextSize(12);
        header2.setWidth(180);
        header2.setText("Nama Debitur");
        rowHeaderTable.addView(header2, rowParamsDetail);

        TextView header3 = new TextView(ctx);
        header3.setGravity(Gravity.LEFT);
        header3.setTextColor(getResources().getColor(android.R.color.black));
        header3.setPadding(0, 3, 0, 3);
        header3.setTextSize(12);
        header3.setWidth(100);
        header3.setText("Nominal");
        rowHeaderTable.addView(header3, rowParamsDetail);

        TextView header4 = new TextView(ctx);
        header4.setGravity(Gravity.LEFT);
        header4.setTextColor(getResources().getColor(android.R.color.black));
        header4.setPadding(0, 3, 0, 3);
        header4.setTextSize(12);
        header4.setWidth(100);
        header4.setText("Sisa Tagihan");
        rowHeaderTable.addView(header4, rowParamsDetail);

        TextView header5 = new TextView(ctx);
        header5.setGravity(Gravity.LEFT);
        header5.setTextColor(getResources().getColor(android.R.color.black));
        header5.setPadding(0, 3, 0, 3);
        header5.setTextSize(12);
        header5.setWidth(60);
        header5.setText("Action");
        rowHeaderTable.addView(header5, rowParamsDetail);

        tableLayout.addView(rowHeaderTable);

        // loop data
			/*int intnomor=0;
			if(pageNo > 1)		
				intnomor=pageNo*10;
			
			for(int i=0;i<listTagihan.size();i++){
				TagihanData contentdata= listTagihan.get(i);
				
				final TableRow rowContentTable = new TableRow(this);
				if ((i+1)%2==0){rowContentTable.setBackgroundColor(getResources().getColor(R.color.color_bacground1));}
				else{rowContentTable.setBackgroundColor(Color.WHITE);}
				
				TextView counter = new TextView(ctx);
				counter.setGravity(Gravity.LEFT);
				counter.setTextColor(getResources().getColor(android.R.color.black));
				counter.setPadding(0, 3, 0, 3);
				counter.setTextSize(12);
				counter.setWidth(25);
				counter.setText(""+(i+1+intnomor));
				rowContentTable.addView(counter,rowParamsDetail);
				
				
									
				TextView tv_valuehidden = new TextView(ctx);
				tv_valuehidden.setText(contentdata.getID().toString());
				rowContentTable.addView(tv_valuehidden);
				tv_valuehidden.setVisibility(View.GONE);
				
				TextView tv_rekening = new TextView(ctx);
				tv_rekening.setGravity(Gravity.LEFT);
				tv_rekening.setTextColor(getResources().getColor(android.R.color.black));
				tv_rekening.setPadding(0, 3, 0, 3);
				tv_rekening.setTextSize(12);
				tv_rekening.setWidth(100);
				tv_rekening.setText(contentdata.getNOMORREKENING());
				rowContentTable.addView(tv_rekening,rowParamsDetail);
				
				TextView tv_namadebitur = new TextView(ctx);
				tv_namadebitur.setGravity(Gravity.LEFT);
				tv_namadebitur.setTextColor(getResources().getColor(android.R.color.black));
				tv_namadebitur.setPadding(0, 3, 0, 3);
				tv_namadebitur.setTextSize(12);
				tv_namadebitur.setWidth(180);
				tv_namadebitur.setText(contentdata.getNAMADEBITUR());
				rowContentTable.addView(tv_namadebitur,rowParamsDetail);
				
				TextView tv_nominal = new TextView(ctx);
				tv_nominal.setGravity(Gravity.LEFT);
				tv_nominal.setTextColor(getResources().getColor(android.R.color.black));
				tv_nominal.setPadding(0, 3, 0, 3);
				tv_nominal.setTextSize(12);
				tv_nominal.setWidth(100);
				tv_nominal.setText(contentdata.getTAGIHAN());
				rowContentTable.addView(tv_nominal,rowParamsDetail);
										
				TextView tv_sisatagihan = new TextView(ctx);
				tv_sisatagihan.setGravity(Gravity.LEFT);
				tv_sisatagihan.setTextColor(getResources().getColor(android.R.color.black));
				tv_sisatagihan.setPadding(0, 3, 0, 3);
				tv_sisatagihan.setTextSize(12);
				tv_sisatagihan.setWidth(95);
				tv_sisatagihan.setText(contentdata.getSISATAGIHAN());
				rowContentTable.addView(tv_sisatagihan,rowParamsDetail);
				
								
			
				
				if (Double.parseDouble(contentdata.getSISATAGIHAN())==0){
					TextView tv_lunas = new TextView(ctx);
					tv_lunas.setGravity(Gravity.LEFT);
					tv_lunas.setTextColor(getResources().getColor(android.R.color.black));
					tv_lunas.setPadding(0, 3, 0, 3);
					tv_lunas.setTextSize(12);
					tv_lunas.setWidth(57);
					tv_lunas.setText(R.string.form_action_status_lunas);
					rowContentTable.addView(tv_lunas,rowParamsDetail);
				}
				else{
					Button bt_bayar = new Button(ctx);
					bt_bayar.setGravity(Gravity.LEFT);
					bt_bayar.setText(R.string.form_action_status_bayar);
					rowContentTable.addView(bt_bayar,60,35);
					
					bt_bayar.setOnClickListener(new View.OnClickListener() {
					    @Override
					    public void onClick(View view) {
					        TextView contentTrx = (TextView) rowContentTable.getChildAt(1);
					        loadDetailTagihan(contentTrx.getText().toString());
					        loadTagihanDialog();
					    }
					});
				}
				tagihan.getTableLayout().addView(rowContentTable);
			}
			
			if (contentContainer != null){
				contentContainer.removeView(prevShownView);
			}
			
			contentContainer.addView(tagihan);
			prevShownView = tagihan;*/
        //}
    }

}
