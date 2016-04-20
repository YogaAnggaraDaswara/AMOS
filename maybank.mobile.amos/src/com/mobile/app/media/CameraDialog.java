package com.mobile.app.media;

import com.mobile.framework.media.CameraPreview;

import maybank.mobile.amos.R;

import android.app.Dialog;
import android.content.Context;
import android.widget.Button;
import android.widget.LinearLayout;
import android.content.DialogInterface;
import android.view.View;

public class CameraDialog extends Dialog {

    private CameraPreview _cameraPreview;
    private LinearLayout _cameraBodyLayout;
    private Button _btnOK;
    private Button _btnCancel;

    public CameraDialog(Context context) {
        super(context, R.style.master_dialog_notitle_borderless);
        setContentView(R.layout.camera_dialog_layout);

        _btnOK = (Button) findViewById(R.id.camera_dialog_btn_ok);
        _btnCancel = (Button) findViewById(R.id.camera_dialog_btn_cancel);
        _cameraPreview = (CameraPreview) findViewById(R.id.camera_camera_viewer);
        _cameraBodyLayout = (LinearLayout) findViewById(R.id.camera_dialog_body_layout);
        this.setCanceledOnTouchOutside(false);

        _btnOK.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getCameraPreview().capturePicture();
                    }
                });

        _btnCancel.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        getCameraPreview().discardCapturedPicture();
                        getCameraPreview().stopCamera();
                        dismiss();
                    }
                }
        );

        this.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                refreshUI();
                getCameraPreview().startCamera();
            }
        });

    }

    public CameraPreview getCameraPreview() {
        return _cameraPreview;
    }

    public Button getBtnOK() {
        return _btnOK;
    }

    public Button getBtnCancel() {
        return _btnCancel;
    }

    public void refreshUI() {
        _cameraBodyLayout.invalidate();
    }
}