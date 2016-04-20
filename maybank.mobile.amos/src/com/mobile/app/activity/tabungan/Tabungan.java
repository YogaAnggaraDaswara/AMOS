package com.mobile.app.activity.tabungan;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import bii.mobile.mitra.R;

import com.mobile.app.ui.MasterContent;
import com.mobile.framework.common.StringUtility;

public class Tabungan extends MasterContent {
    private EditText txtNamaDebitur;
    private EditText txtAlamat;
    private EditText txtJenisTabungan;
    private EditText txtSetoran;
    //private EditText txtPin;
    private EditText txtHandphone;
    private EditText txtNoRekening;
    private EditText txtNoTabungan;
    private EditText txtNamaPenabung;

    private Button btnClose;
    private Button btnRequestPIN;
    private Button btnSendTransaction;
    private ImageView imgSearchRekening;

    public Tabungan(Context context) {
        super(context);
    }

    public Tabungan(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Tabungan(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onInitMasterContentView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.tabungan_content_layout, getContentBody());
        getContentTitle().setVisibility(View.GONE);
        getContentFooter().setVisibility(View.GONE);
        txtNamaDebitur = (EditText) getContentBody().findViewById(R.id.tabungan_view_txt_namadebitur_value);
        txtAlamat = (EditText) getContentBody().findViewById(R.id.tabungan_view_txt_alamat_value);
        txtJenisTabungan = (EditText) getContentBody().findViewById(R.id.tabungan_view_txt_jenistabungan_value);
        txtSetoran = (EditText) getContentBody().findViewById(R.id.tabungan_view_txt_setoran_value);
        setTextWatcher(txtSetoran);
        //txtPin = (EditText) getContentBody().findViewById(R.id.tabungan_view_txt_pin_value);
        txtHandphone = (EditText) getContentBody().findViewById(R.id.tabungan_view_txt_handphone_value);
        txtNoRekening = (EditText) getContentBody().findViewById(R.id.tabungan_view_txt_rekening_value);
        txtNoTabungan = (EditText) getContentBody().findViewById(R.id.tabungan_view_txt_nomortabungan_value);
        txtNamaPenabung = (EditText) getContentBody().findViewById(R.id.tabungan_view_txt_namapenabung_value);

        imgSearchRekening = (ImageView) getContentBody().findViewById(R.id.tabungan_view_img_searchrekening);
        btnClose = (Button) getContentBody().findViewById(R.id.tabungan_view_btn_close);
        btnRequestPIN = (Button) getContentBody().findViewById(R.id.tabungan_view_btn_requestpin);
        btnSendTransaction = (Button) getContentBody().findViewById(R.id.tabungan_view_btn_sendtransaction);
        btnClose.setVisibility(View.GONE);
        btnRequestPIN.setVisibility(View.VISIBLE);
        btnSendTransaction.setVisibility(View.GONE);
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
        String strSetoran = txtSetoran.getText().toString().replace("Rp ", "").replace(".", "");
        if (StringUtility.isEmpty(strSetoran)) {
            return txtSetoran;
        }
    /*	if (StringUtility.isEmpty(txtPin.getText().toString())) {
			return txtPin;
		}*/
        return null;
    }

    public void clearFields() {
        txtNamaDebitur.setText("");
        txtJenisTabungan.setText("");
        txtAlamat.setText("");
        txtSetoran.setText("");
        //txtPin.setText("");
        txtHandphone.setText("");
        txtNoRekening.setText("");
        txtNoTabungan.setText("");
        txtNamaPenabung.setText("");
    }

    public EditText getTxtNamaDebitur() {
        return txtNamaDebitur;
    }

    public void setTxtNamaDebitur(EditText txtNamaDebitur) {
        this.txtNamaDebitur = txtNamaDebitur;
    }

    public EditText getTxtAlamat() {
        return txtAlamat;
    }

    public void setTxtAlamat(EditText txtAlamat) {
        this.txtAlamat = txtAlamat;
    }

    public EditText getTxtJenisTabungan() {
        return txtJenisTabungan;
    }

    public void setTxtJenisTabungan(EditText txtJenisTabungan) {
        this.txtJenisTabungan = txtJenisTabungan;
    }

    public EditText getTxtSetoran() {
        return txtSetoran;
    }

    public void setTxtSetoran(EditText txtSetoran) {
        this.txtSetoran = txtSetoran;
    }

    /*public EditText getTxtPin() {
        return txtPin;
    }
    public void setTxtPin(EditText txtPin) {
        this.txtPin = txtPin;
    }*/
    public EditText getTxtHandphone() {
        return txtHandphone;
    }

    public void setTxtHandphone(EditText txtHandphone) {
        this.txtHandphone = txtHandphone;
    }

    public EditText getTxtNoRekening() {
        return txtNoRekening;
    }

    public void setTxtNoRekening(EditText txtNoRekening) {
        this.txtNoRekening = txtNoRekening;
    }

    public Button getBtnClose() {
        return btnClose;
    }

    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
    }

    public Button getBtnRequestPIN() {
        return btnRequestPIN;
    }

    public void setBtnRequestPIN(Button btnRequestPIN) {
        this.btnRequestPIN = btnRequestPIN;
    }

    public Button getBtnSendTransaction() {
        return btnSendTransaction;
    }

    public void setBtnSendTransaction(Button btnSendTransaction) {
        this.btnSendTransaction = btnSendTransaction;
    }

    public ImageView getImgSearchRekening() {
        return imgSearchRekening;
    }

    public void setImgSearchRekening(ImageView imgSearchRekening) {
        this.imgSearchRekening = imgSearchRekening;
    }

    public EditText getTxtNoTabungan() {
        return txtNoTabungan;
    }

    public void setTxtNoTabungan(EditText txtNoTabungan) {
        this.txtNoTabungan = txtNoTabungan;
    }

    public EditText getTxtNamaPenabung() {
        return txtNamaPenabung;
    }

    public void setTxtNamaPenabung(EditText txtNamaPenabung) {
        this.txtNamaPenabung = txtNamaPenabung;
    }
}
