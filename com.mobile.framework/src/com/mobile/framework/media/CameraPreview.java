package com.mobile.framework.media;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
	
	private SurfaceHolder _surfaceHolder;
	private boolean _isSurfaceCreated = false;
	private Camera _camera;
	private boolean _isCameraFeatureAvailable = false;
	private boolean _isCameraCreated = false;
	private boolean _isPreviewStarted = false;
	private File _tempPicFile = null;
	private Drawable _picture = null;
	private CameraActionListener _cameraListener = null;
	private int ROTATIONVALUE=90;
	
    public CameraPreview(Context context) {
        super(context);
        initCamerePreview(context);
    }
    
	public CameraPreview(Context context, AttributeSet attrs) {
		super(context, attrs);
		initCamerePreview(context);
	}
	
	public CameraPreview(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initCamerePreview(context);
	}
	
	private void initCamerePreview(Context context) {
		
		if (!isInEditMode()) {
	        if (context.getPackageManager().hasSystemFeature(
	        		PackageManager.FEATURE_CAMERA)){
	            _isCameraFeatureAvailable = true;
	        } else {
	        	_isCameraFeatureAvailable = false;
	        }
		}
		
        _surfaceHolder = getHolder();
        _surfaceHolder.addCallback(this);
        
        _surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);		
	}
	
    public boolean isCameraAvailable() {
    	return _isCameraFeatureAvailable;
    }
    
    public boolean startCamera() {
    	if (!_isCameraFeatureAvailable) {
    		return false;
    	}
    	
    	if (!_isCameraCreated) {
    		try {
    			_camera = Camera.open();
    			_isCameraCreated = true;
    		} catch (Exception e) {
                Log.i(getClass().getName(), 
                		String.format("startCamera Error Opening Camera: %s",
                						e.getMessage()));    			
    		}
    		
    		Parameters cameraParameters = _camera.getParameters();
    		_camera.setDisplayOrientation(ROTATIONVALUE);
    		cameraParameters.setWhiteBalance(Parameters.WHITE_BALANCE_AUTO);
    		cameraParameters.setFlashMode(Parameters.FOCUS_MODE_AUTO);
    		
    		if (_isSurfaceCreated) {
    			startPreview();
    		}
    	}
    	
    	return _isCameraCreated;
    }
    
    public boolean stopCamera() {
    	if (_isCameraCreated) {
    		if (_isSurfaceCreated) {
    			stopPreview();
    		}
    		
    		try {
    			_camera.release();
    		} catch (Exception e) {
                Log.i(getClass().getName(), 
                		String.format("startCamera Error Opening Camera: %s",
                						e.getMessage()));    			
    		}
    		_isCameraCreated = false;
    	}
    	
    	return _isCameraCreated;    	
    }
    
    private boolean startPreview() {
    	if (!_isPreviewStarted && _isCameraCreated && _isSurfaceCreated) {
            try {
            	_camera.setPreviewDisplay(_surfaceHolder);
            	_camera.startPreview();
            	_isPreviewStarted = true;
            } catch (Exception e) {
                Log.i(getClass().getName(), 
                		String.format("startPreview Error setting camera preview: %s",
                						e.getMessage()));
            }    		
    	}
    	
    	return _isPreviewStarted;
    }
    
    private boolean stopPreview() {
    	if (_isPreviewStarted && _isCameraCreated && _isSurfaceCreated) {
            try {
            	_camera.stopPreview();
            	_camera.setPreviewDisplay(null);
            	_isPreviewStarted = false;
            } catch (Exception e) {
                Log.i(getClass().getName(), 
                		String.format("stopPreview Error setting camera preview: %s",
                						e.getMessage()));
            }    		
    	}
    	
    	return !_isPreviewStarted;
    }
    
    public void setCameraActionListiner(CameraActionListener listener) {
    	_cameraListener = listener;
    }
    
    public void capturePicture() {
    	if (_isCameraCreated && _isPreviewStarted) {
    		_camera.takePicture(
    				null, 
    				null, 
    				new PictureCallback() {
						@Override
						public void onPictureTaken(byte[] data, Camera camera) {
							CameraPreview.this.onPictureCaptured(data, camera);
						}
					});
    	}
    }    
    
	public Drawable getCapturedPicture() {
		Drawable retVal = null;
		if (_tempPicFile != null) {
			retVal = Drawable.createFromPath(_tempPicFile.getAbsolutePath());
		}
		return retVal;
	}
	
	public boolean discardCapturedPicture() {
		boolean retVal = false;
		
		if (_tempPicFile != null) {
			try {
				if (_tempPicFile.delete()) {
					retVal = true;
				} else {
					Log.i(getClass().getName(),
		            		String.format(
		            				"discardCapturedPicture, Fail deleting file: %s",
		            				_tempPicFile.getAbsolutePath()));					
				}
			} catch (Exception ex) {
	            Log.i(getClass().getName(), 
	            		String.format(
	            				"discardCapturedPicture, Error deleting file: %s",
	            				ex.getMessage()));
			}
			_tempPicFile = null;
		}
		return retVal;
	}
	
	public boolean savePictureTo(File destFile) {
		
		boolean destFileCreated = false;
		boolean retVal = false;
		
		if (_tempPicFile == null) {
			return retVal;
		}
		
		if (destFile.exists()) {
			destFile.delete();
		} else {
			destFile.getParentFile().mkdirs();
		}
		
		try {
			destFileCreated = destFile.createNewFile();
		} catch (Exception e) {
            Log.i(getClass().getName(), 
            		String.format(
            				"savePicture, Error crating destination file: %s",
            				e.getMessage()));
		}
		
		if (!destFileCreated) {
			return retVal;
		}
		
		int size = 0;
		FileInputStream fi = null;
		try {
			fi = new FileInputStream(_tempPicFile);
		} catch (FileNotFoundException e) {
            Log.i(getClass().getName(), 
            		String.format(
            				"savePicture, Error opening source file: %s",
            				e.getMessage()));
		}
		
		FileOutputStream fo = null;
		try {
			fo = new FileOutputStream(destFile);
		} catch (FileNotFoundException e) {
            Log.i(getClass().getName(), 
            		String.format(
            				"savePicture, Error opening destination file: %s",
            				e.getMessage()));
		}
		
		if ((fo != null) && (fi != null)) {
			try {
				size = fi.available();
			} catch (Exception e) {
	            Log.i(getClass().getName(), 
	            		String.format(
	            				"savePicture, Error retrieving source file size: %s",
	            				e.getMessage()));
			}
			
			if (size > 0) {
				try {
					byte[] buffer = new byte[size];
					fi.read(buffer, 0, size);
					fo.write(buffer);
					retVal = true;
				} catch (Exception ex) {
		            Log.i(getClass().getName(), 
		            		String.format(
		            				"savePicture, Error saving file: %s",
		            				ex.getMessage()));				
				}
			} else {
	            Log.i(getClass().getName(), "savePicture, Source file size is zero");
			}
		}
		
		if (fo != null) {
			try {
				fo.close();
			} catch (Exception e) {
	            Log.i(getClass().getName(), 
	            		String.format(
	            				"savePicture, Error closing destination file: %s",
	            				e.getMessage()));				
			}
		}
		
		if (fi != null) {
			try {
				fi.close();
			} catch (Exception e) {
	            Log.i(getClass().getName(), 
	            		String.format(
	            				"savePicture, Error closing source file: %s",
	            				e.getMessage()));				
			}
		}
		
		if (retVal) {
			discardCapturedPicture();
		}
		
		return retVal;
	}
	
    private void onPictureCaptured(byte[] data, Camera camera) {
		discardCapturedPicture();
		
		Date today = new Date();
		String tempFileName = 
				String.format(
						"PIC-%d-%d-%d-%d-%d-%d",
						today.getYear(),
						today.getMonth(),
						today.getDate(),
						today.getHours(),
						today.getMinutes(),
						today.getSeconds());
		try {
			_tempPicFile = File.createTempFile(tempFileName, null);
		} catch (Exception ex) {
	        if (_tempPicFile == null){
	            Log.i(getClass().getName(), 
	            		String.format(
	            				"onPictureTaken, Error creating media file: %s",
	            				ex.getMessage()));
	        }
		}
		
		if (_tempPicFile != null) {
	        try {
	            FileOutputStream fos = new FileOutputStream(_tempPicFile);
	            fos.write(data);
	            fos.close();
	        } catch (FileNotFoundException e) {
	            Log.i(getClass().getName(), 
	            		String.format( 
	            				"onPictureTaken, File not found: ",
	            				e.getMessage()));
	        } catch (IOException e) {
	            Log.i(getClass().getName(), 
	            		String.format(
	            				"onPictureTaken, IO Error: ",
	            				e.getMessage()));
	        } catch (Exception e) {
	            Log.i(getClass().getName(), 
	            		String.format(
	            				"onPictureTaken, General error: ",
	            				e.getMessage()));   	
	        }
	        
	        new Thread(new Runnable() {
				
				@Override
				public void run() {
					CameraPreview.this.post(new Runnable() {
						@Override
						public void run() {
					        if (_cameraListener != null) {
					        	_cameraListener.onPictureTaken(CameraPreview.this);
					        }						
						}
					});
				}
			}).start();
		}
    }
    
    public void surfaceCreated(SurfaceHolder holder) {
    	_isSurfaceCreated = true;
    	if (!_isPreviewStarted) {
    		startPreview();
    	}
    }
    
    public void surfaceDestroyed(SurfaceHolder holder) {
    	if (_isPreviewStarted) {
    		stopPreview();
    	}
    	_isSurfaceCreated = false;
    }
    
    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
    	
    	requestLayout();
    	
        if (_surfaceHolder.getSurface() == null){
          return;
        }
        
        //stopPreview();
        //startPreview();
    }
}
