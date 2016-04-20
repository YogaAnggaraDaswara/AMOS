package com.mobile.app.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ZoomControls;
import android.widget.RelativeLayout.LayoutParams;

import maybank.mobile.amos.R;

import com.mobile.app.Mainactivityzoom;
import com.mobile.app.ui.MasterEntryDialog;

public class PreviewImageNew extends MasterEntryDialog {

    private Button deleteButton;
    private Button cancelButton;
    private ImageView imgPreview;
    RelativeLayout rl;
    ZoomControls zoom;
    public PreviewImageNew(Context context) {
        super(context);
    }

    @Override
    protected void onInitMasterEntryDialogContentView(Context context) {
        //getContentHeader().getLayoutParams().height = context.get//700;
        //getContentHeader().getLayoutParams().width = //800;
        getContentHeader().invalidate();

        LayoutInflater.from(context).inflate(R.layout.image_preview_layout, getContentBody());
        getContentTitle().setText(context.getString(R.string.form_dialog_img_preview));
        rl = (RelativeLayout) findViewById(R.id.rl);
        
        imgPreview = (ImageView) getContentBody().findViewById(R.id.app_img_content);
        deleteButton = (Button) getContentBody().findViewById(R.id.app_img_delete);
        cancelButton = (Button) getContentBody().findViewById(R.id.app_img_back);
        
        zoom = new ZoomControls(context);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams 
        		((int) LayoutParams.WRAP_CONTENT, (int) LayoutParams.WRAP_CONTENT);
        
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params.bottomMargin = 40;
        
        zoom.setLayoutParams(params);
        
        rl.addView(zoom);
        
       /* zoom.setOnZoomInClickListener(new OnClickListener() {
			
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			float x = imgPreview.getScaleX();
			float y = imgPreview.getScaleY();
			
			imgPreview.setScaleX((float) (x+1));
			imgPreview.setScaleY((float) (y+1));
		}

		@Override
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
			
		}
	});*/
        
        zoom.setOnZoomInClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				float x = imgPreview.getScaleX();
				float y = imgPreview.getScaleY();
				
				imgPreview.setScaleX((float) (x+1));
				imgPreview.setScaleY((float) (y+1));
				
			}
			
		});
        zoom.setOnZoomOutClickListener(new View.OnClickListener() {
			
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			float x = imgPreview.getScaleX();
			float y = imgPreview.getScaleY();
			
			imgPreview.setScaleX((float) (x-1));
			imgPreview.setScaleY((float) (y-1));
		}
	});
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