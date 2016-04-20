package com.mobile.app.activity.tagihan;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import bii.mobile.mitra.R;

import com.mobile.app.ui.MasterEntryDialog;
import com.mobile.framework.common.NumberTextWatcher;
import com.mobile.framework.common.StringUtility;

public class TagihanDialog extends MasterEntryDialog {
    private EditText txtRekening;
    private EditText txtNamaDebitur;
    private EditText txtAlamat;
    private EditText txtNomorTabungan;
    private EditText txtJenisTagihan;
    private EditText txtTenor;
    private EditText txtTanggalCair;
    private EditText txtPokokPinjaman;
    private EditText txtBungaPinjaman;
    private EditText txtTotalPinjaman;
    private EditText txtTotalCicilan;
    private EditText txtSisaPinjaman;
    private EditText txtTagihan;
    private EditText txtSisaTagihan;
    private EditText txtPembayaran;
    private EditText txtPin;
    private EditText txtHandphone;
    private Button btnClose;
    private Button btnRequestPIN;
    private Button btnSendTransaction;

    public TagihanDialog(Context context) {
        super(context);
    }

    @Override
    protected void onInitMasterEntryDialogContentView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.tagihan_form_layout, getContentBody());
        getContentTitle().setText(context.getString(R.string.title_activity_tagihan_dialog));
        getContentHeader().getLayoutParams().height = 500;
        getContentHeader().invalidate();
        /*txtRekening = (EditText) getContentBody().findViewById(R.id.tagihan_view_txt_norekening_value);
		txtNamaDebitur = (EditText) getContentBody().findViewById(R.id.tagihan_view_txt_namadebitur_value);
		txtAlamat = (EditText) getContentBody().findViewById(R.id.tagihan_view_txt_alamat_value);
		txtNomorTabungan = (EditText) getContentBody().findViewById(R.id.tagihan_view_txt_nomortabungan_value);
		txtJenisTagihan = (EditText) getContentBody().findViewById(R.id.tagihan_view_txt_jenistagihan_value);
		txtTenor= (EditText) getContentBody().findViewById(R.id.tagihan_view_txt_tenor_value);
		txtTanggalCair= (EditText) getContentBody().findViewById(R.id.tagihan_view_txt_tanggalcair_value);
		txtPokokPinjaman= (EditText) getContentBody().findViewById(R.id.tagihan_view_txt_pokokpinjaman_value);
		txtBungaPinjaman= (EditText) getContentBody().findViewById(R.id.tagihan_view_txt_bungapinjaman_value);
		txtTotalPinjaman= (EditText) getContentBody().findViewById(R.id.tagihan_view_txt_totalpinjaman_value);
		txtTotalCicilan= (EditText) getContentBody().findViewById(R.id.tagihan_view_txt_totalcicilan_value);
		txtSisaPinjaman= (EditText) getContentBody().findViewById(R.id.tagihan_view_txt_sisapinjaman_value);
		txtTagihan= (EditText) getContentBody().findViewById(R.id.tagihan_view_txt_tagihan_value);
		txtSisaTagihan = (EditText) getContentBody().findViewById(R.id.tagihan_view_txt_sisatagihan_value);
		txtHandphone = (EditText) getContentBody().findViewById(R.id.tagihan_view_txt_handphone_value1);
		txtPembayaran= (EditText) getContentBody().findViewById(R.id.tagihan_view_txt_pembayaran_value1);
		setTextWatcher(txtPembayaran);
		//txtPembayaran.addTextChangedListener(new NumberTextWatcher(txtPembayaran));
		//txtPin = (EditText) getContentBody().findViewById(R.id.tagihan_view_txt_pin_value);
		
		btnClose = (Button) getContentBody().findViewById(R.id.tagihan_view_btn_close);
		btnRequestPIN = (Button) getContentBody().findViewById(R.id.tagihan_view_btn_requestpin);
		btnSendTransaction = (Button) getContentBody().findViewById(R.id.tagihan_view_btn_sendtransaction);*/
    }

    public void setTextWatcher(final EditText ed) {
        TextWatcher tw = new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                ed.removeTextChangedListener(this);
                try {
                    String numberformat = "";
                    String userInput = s.toString().replace("R", "").replace("p", "").replace(" ", "").replace(".", "");

                    int lengthstring = userInput.length();

                    int loops = (int) Math.floor(lengthstring / 3);

                    if (lengthstring % 3 != 0)
                        loops++;

                    Log.d("RESPON " + loops, userInput.toString());

                    for (int x = 0; x < loops; x++) {
                        int startchar = userInput.length() - 3;

                        String stringuse = "";
                        if (startchar > 0) {
                            stringuse = userInput.substring(startchar);
                            userInput = userInput.substring(0, startchar);
                        } else {
                            stringuse = userInput;
                        }

                        if (!numberformat.isEmpty())
                            numberformat = stringuse + "." + numberformat;
                        else
                            numberformat = stringuse + numberformat;
                    }

                    numberformat = "Rp " + numberformat;

                    ed.setText(numberformat);
                    Selection.setSelection(ed.getText(), numberformat.toString().length());
                } catch (Exception e) {
                    Log.d("RESPON", e.toString());
                }

                ed.addTextChangedListener(this);
            }
        };

        ed.addTextChangedListener(tw);
    }

    @Override
    public View checkContentValidation() {
        String pembayaran = txtPembayaran.getText().toString().replace("Rp ", "").replace(".", "");
        if (StringUtility.isEmpty(pembayaran)) {
            return txtPembayaran;
        }
        //if (StringUtility.isEmpty(txtPin.getText().toString())) {
        //	return txtPin;
        //}
        return null;
    }

    public boolean isPembayaranValid() {
        String strpembayaran = txtPembayaran.getText().toString().replace("Rp ", "").replace(".", "").replace(",", ".");
        String strTagihan = txtTagihan.getText().toString().replace("Rp ", "").replace(".", "");
        float pembayaran = Float.parseFloat(strpembayaran);
        float tagihan = Float.parseFloat(strTagihan);

        if (pembayaran <= tagihan && pembayaran > 0) {
            return true;
        } else {
            return false;
        }
    }

    public EditText getTxtRekening() {
        return txtRekening;
    }

    public EditText getTxtNamaDebitur() {
        return txtNamaDebitur;
    }

    public EditText getTxtAlamat() {
        return txtAlamat;
    }

    public EditText getTxtJenisTagihan() {
        return txtJenisTagihan;
    }

    public EditText getTxtTenor() {
        return txtTenor;
    }

    public EditText getTxtTanggalCair() {
        return txtTanggalCair;
    }

    public EditText getTxtPokokPinjaman() {
        return txtPokokPinjaman;
    }

    public EditText getTxtBungaPinjaman() {
        return txtBungaPinjaman;
    }

    public EditText getTxtTotalPinjaman() {
        return txtTotalPinjaman;
    }

    public EditText getTxtTotalCicilan() {
        return txtTotalCicilan;
    }

    public EditText getTxtSisaPinjaman() {
        return txtSisaPinjaman;
    }

    public EditText getTxtTagihan() {
        return txtTagihan;
    }

    public EditText getTxtSisaTagihan() {
        return txtSisaTagihan;
    }

    public EditText getTxtPembayaran() {
        return txtPembayaran;
    }

    public EditText getTxtPin() {
        return txtPin;
    }

    public EditText getTxtHandphone() {
        return txtHandphone;
    }

    public Button getBtnClose() {
        return btnClose;
    }

    public Button getBtnRequestPIN() {
        return btnRequestPIN;
    }

    public Button getBtnSendTransaction() {
        return btnSendTransaction;
    }

    public EditText getTxtNomorTabungan() {
        return txtNomorTabungan;
    }
}
