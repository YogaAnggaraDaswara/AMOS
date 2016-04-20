package com.mobile.app.activity.cashcheckup;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import bii.mobile.mitra.R;

import com.mobile.app.ui.MasterContent;

public class CashCheckup extends MasterContent {
    private LinearLayout contentTabungan;
    private LinearLayout contentTagihan;
    private LinearLayout contentCashPickup;
    private LinearLayout contentAction;
    private TextView lblTotalTabungan;
    private TextView lblTotalTagihan;
    private TextView lblTotalCashPickup;
    private TableLayout tblTabungan;
    private TableLayout tblTagihan;
    private Button btnSetuju;
    private Button btnTidakSetuju;

    public CashCheckup(Context context) {
        super(context);
    }

    public CashCheckup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CashCheckup(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onInitMasterContentView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cashcheckup_content_layout, getContentBody());
        getContentTitle().setVisibility(View.GONE);
        getContentFooter().setVisibility(View.GONE);

        contentTabungan = (LinearLayout) getContentBody().findViewById(R.id.cashcheckup_content_linier_tabungan);
        contentTagihan = (LinearLayout) getContentBody().findViewById(R.id.cashcheckup_content_linier_tagihan);
        contentCashPickup = (LinearLayout) getContentBody().findViewById(R.id.cashcheckup_content_linier_cashpickup);
        contentAction = (LinearLayout) getContentBody().findViewById(R.id.cashcheckup_content_linier_action);

        lblTotalTabungan = (TextView) getContentBody().findViewById(R.id.cashcheckup_lbl_totaltabungan_value);
        lblTotalTagihan = (TextView) getContentBody().findViewById(R.id.cashcheckup_lbl_totaltagihan_value);
        lblTotalCashPickup = (TextView) getContentBody().findViewById(R.id.cashcheckup_lbl_totalcashpickup_value);

        tblTabungan = (TableLayout) getContentBody().findViewById(R.id.cashcheckup_tableLayout_tabungan);
        tblTagihan = (TableLayout) getContentBody().findViewById(R.id.cashcheckup_tableLayout_tagihan);

        btnSetuju = (Button) getContentBody().findViewById(R.id.cashcheckup_view_btn_agree);
        btnTidakSetuju = (Button) getContentBody().findViewById(R.id.cashcheckup_view_btn_disagree);

        contentTabungan.setVisibility(View.GONE);
        contentTagihan.setVisibility(View.GONE);
        contentCashPickup.setVisibility(View.GONE);
        contentAction.setVisibility(View.GONE);
    }

    @Override
    public View checkContentValidation() {
        // TODO Auto-generated method stub
        return null;
    }

    public LinearLayout getContentTabungan() {
        return contentTabungan;
    }

    public void setContentTabungan(LinearLayout contentTabungan) {
        this.contentTabungan = contentTabungan;
    }

    public LinearLayout getContentTagihan() {
        return contentTagihan;
    }

    public void setContentTagihan(LinearLayout contentTagihan) {
        this.contentTagihan = contentTagihan;
    }

    public LinearLayout getContentCashPickup() {
        return contentCashPickup;
    }

    public void setContentCashPickup(LinearLayout contentCashPickup) {
        this.contentCashPickup = contentCashPickup;
    }

    public LinearLayout getContentAction() {
        return contentAction;
    }

    public void setContentAction(LinearLayout contentAction) {
        this.contentAction = contentAction;
    }

    public TextView getLblTotalTabungan() {
        return lblTotalTabungan;
    }

    public void setLblTotalTabungan(TextView lblTotalTabungan) {
        this.lblTotalTabungan = lblTotalTabungan;
    }

    public TextView getLblTotalTagihan() {
        return lblTotalTagihan;
    }

    public void setLblTotalTagihan(TextView lblTotalTagihan) {
        this.lblTotalTagihan = lblTotalTagihan;
    }

    public TextView getLblTotalCashPickup() {
        return lblTotalCashPickup;
    }

    public void setLblTotalCashPickup(TextView lblTotalCashPickup) {
        this.lblTotalCashPickup = lblTotalCashPickup;
    }

    public TableLayout getTblTabungan() {
        return tblTabungan;
    }

    public void setTblTabungan(TableLayout tblTabungan) {
        this.tblTabungan = tblTabungan;
    }

    public TableLayout getTblTagihan() {
        return tblTagihan;
    }

    public void setTblTagihan(TableLayout tblTagihan) {
        this.tblTagihan = tblTagihan;
    }

    public Button getBtnSetuju() {
        return btnSetuju;
    }

    public void setBtnSetuju(Button btnSetuju) {
        this.btnSetuju = btnSetuju;
    }

    public Button getBtnTidakSetuju() {
        return btnTidakSetuju;
    }

    public void setBtnTidakSetuju(Button btnTidakSetuju) {
        this.btnTidakSetuju = btnTidakSetuju;
    }
}
