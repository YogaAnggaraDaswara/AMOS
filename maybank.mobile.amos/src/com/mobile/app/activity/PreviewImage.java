package com.mobile.app.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import maybank.mobile.amos.R;
import com.mobile.app.ui.MasterEntryDialog;

public class PreviewImage extends MasterEntryDialog {

    private Button deleteButton;
    private Button cancelButton;
    private ImageView imgPreview;

    public PreviewImage(Context context) {
        super(context);
    }

    @Override
    protected void onInitMasterEntryDialogContentView(Context context) {
        getContentHeader().getLayoutParams().height = 700;
        getContentHeader().getLayoutParams().width = 800;
        getContentHeader().invalidate();

        LayoutInflater.from(context).inflate(R.layout.image_preview_layout, getContentBody());
        getContentTitle().setText(context.getString(R.string.form_dialog_img_preview));

        imgPreview = (ImageView) getContentBody().findViewById(R.id.app_img_content);
        deleteButton = (Button) getContentBody().findViewById(R.id.app_img_delete);
        cancelButton = (Button) getContentBody().findViewById(R.id.app_img_back);
    }

    @Override
    public View checkContentValidation() {
        return null;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public Button getCancelButton() {
        return cancelButton;
    }

    public ImageView getImgPreview() {
        return imgPreview;
    }
}