package com.mobile.app;
import maybank.mobile.amos.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ZoomControls;
import android.widget.RelativeLayout.LayoutParams;

public class Mainactivityzoom extends Activity {
		
	RelativeLayout rl;
	ZoomControls zoom;
	ImageView img;
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zoom);
        
        rl = (RelativeLayout) findViewById(R.id.rl);
        img = (ImageView) findViewById(R.id.imageView1);
        
        zoom = new ZoomControls(Mainactivityzoom.this);
        
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams 
        		((int) LayoutParams.WRAP_CONTENT, (int) LayoutParams.WRAP_CONTENT);
        
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params.bottomMargin = 40;
        
        zoom.setLayoutParams(params);
        
        rl.addView(zoom);
        
        zoom.setOnZoomInClickListener(new OnClickListener() {
			
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			float x = img.getScaleX();
			float y = img.getScaleY();
			
			img.setScaleX((float) (x+1));
			img.setScaleY((float) (y+1));
		}
	});
        
        zoom.setOnZoomOutClickListener(new View.OnClickListener() {
			
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			float x = img.getScaleX();
			float y = img.getScaleY();
			
			img.setScaleX((float) (x-1));
			img.setScaleY((float) (y-1));
		}
	});
    }
 
	 
	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        //getMenuInflater().inflate(R.menu.zoom, menu);
	        return true;
	    }
	}