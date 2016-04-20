package com.mobile.framework.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Base64;

public class FileUtility {
	
	public static byte[] convertFileToByteArray(String fileName,String filePath) {
		byte[] byteArray = null;
		try {
			File directory = new File(filePath);
			File originalFile = new File(directory, fileName);
			
			Bitmap bm= BitmapFactory.decodeFile(originalFile.getAbsolutePath());
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			bm.compress(Bitmap.CompressFormat.JPEG, 100, stream);
			byteArray = stream.toByteArray();
			stream.close();
			
			/*Bitmap bm= BitmapFactory.decodeFile(originalFile.getAbsolutePath());
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			bm.compress(Bitmap.CompressFormat.JPEG, 100, stream);
			byteArray = stream.toByteArray();
			stream.close();
			*/
		}catch(Exception e){
			 e.printStackTrace();
		}
			
		return byteArray;
	}
	
	public static String encodeToStringBase64(String fileName,String filePath) {
		String encodedFile = "";
        try {
        	FileInputStream fileInputStream = new FileInputStream(filePath+fileName);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead = 0;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
               bos.write(buffer, 0, bytesRead);
            }
            byte[] ba = bos.toByteArray();
            encodedFile = Base64.encodeToString(ba,Base64.DEFAULT);
            fileInputStream.close();
		}catch(Exception e){
			 e.printStackTrace();
		}

        return encodedFile;
    }
	
	public static void decodeBase64ToFile(String fileName,String filePath,String content) {
        try {
        	FileOutputStream fileOutputStream = new FileOutputStream(filePath+fileName);
        	InputStream inputStream = new ByteArrayInputStream(Base64.decode(content.getBytes(), Base64.DEFAULT));
        	byte[] buffer = new byte[1024];
            int bytesRead;
            
            while((bytesRead = inputStream.read(buffer)) !=-1){
            	fileOutputStream.write(buffer, 0, bytesRead);
            }
            fileOutputStream.close();
            fileOutputStream.flush();
            fileOutputStream.close();           
		}catch(Exception e){
			 e.printStackTrace();
		}
    }
	
	public static void deleteFile(String fileName,String filePath){
        try {      
        	File directory = new File(filePath);
        	File file = new File(directory, fileName);
        	file.delete();
  	    } catch (Exception e) {
	        e.printStackTrace();
	        return;
        }    
	}
	
	public static void resizeImage(String fileName,String filePath){
		try {
			FileOutputStream fOutputStream;     
			//CreatePath(filePath);
			File directory = new File(filePath);
			File originalFile = new File(directory, fileName);
			
			Bitmap bm= BitmapFactory.decodeFile(originalFile.getAbsolutePath());
			
			int width = bm.getWidth();
		    int height = bm.getHeight();
		    long FileSizeOriginal = originalFile.length();
		    Bitmap resizedBitmap = changeResize(bm, width, height, FileSizeOriginal);
		    
		    File fileResized = new File(directory, "RES"+fileName);
		    File newfileName =new File(directory, fileName);
		    
            fOutputStream = new FileOutputStream(fileResized);	         	           
            resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 80, fOutputStream);
            fOutputStream.flush();
            fOutputStream.close();                
            originalFile.delete();
            fileResized.renameTo(newfileName);
	            
  	    } catch (FileNotFoundException e) {
	         e.printStackTrace();
	         return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }      
	}
	public static void CreatePath(String path){
		File Directory = new File(path);
		if(!Directory.exists())
			Directory.mkdirs();
	}
	public static void resizeImageFile(String fileName,String fileNameNew,String filePath,String filePathNew){
		try {
			FileOutputStream fOutputStream;   
			//CreatePath(filePathNew);
			File directory = new File(filePath);
			File originalFile = new File(directory, fileName);
			
			 File directoryNew = new File(filePathNew);
	         //File destination= new File(directory, fileName);
			
			Bitmap bm= BitmapFactory.decodeFile(originalFile.getAbsolutePath());
			
//			float scaleWidth, scaleHeight;
			int width = bm.getWidth();
		    int height = bm.getHeight();
		    
//		    scaleWidth = (float) 0.365625;
//		    scaleHeight = (float) 0.3777778;
//		    if(width > height) {
//		    	scaleWidth = ((float) 680) / width; // 0.265625
//		    	scaleHeight = ((float) 400) / height; // 0.2777778
//		    } else {
//		    	scaleWidth = ((float) 400) / width; //0.2777778
//		    	scaleHeight = ((float) 680) / height; //0.265625
//		    }
		    
//		    Matrix matrix = new Matrix();
//		    matrix.postRotate(90);
//		    long FileSizeOriginal = originalFile.length();
//		    if(FileSizeOriginal >= Long.parseLong("524288")) {
//		    	matrix.postScale(scaleWidth, scaleHeight);
//		    }
		    long FileSizeOriginal = originalFile.length();
		    Bitmap resizedBitmap = changeResize(bm, width, height, FileSizeOriginal);
//		    Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);	    
		    
		    File fileResized = new File(directoryNew, fileNameNew);
		    //File newfileName =new File(directoryNew, fileNameNew);
		    
            fOutputStream = new FileOutputStream(fileResized);	         	           
            resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 80, fOutputStream);
            fOutputStream.flush();
            fOutputStream.close();                
            //originalFile.delete();
            //fileResized.renameTo(newfileName);
	            
  	    } catch (FileNotFoundException e) {
	         e.printStackTrace();
	         return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }      
	}
	
	public static Bitmap changeResize(Bitmap bm,int width, int height, long FileSizeOriginal)
	{
		float scaleWidth, scaleHeight;
		Matrix matrix =  null;
		Bitmap resized =  null;
	    if(FileSizeOriginal >= Long.parseLong("524288")) {
	    	scaleWidth = (float) 0.665625;
		    scaleHeight = (float) 0.6777778;
		    matrix = new Matrix();
	    	
	    	matrix.postScale(scaleWidth, scaleHeight);
	    	resized = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
//	    	ByteArrayOutputStream stream = new ByteArrayOutputStream();
//	    	resized.compress(Bitmap.CompressFormat.JPEG, 70, stream);
//	    	byte[] byteArray = stream.toByteArray();
//	    	long sizeRez = byteArray.length;
//	    	changeResize(bm, resized.getWidth(), resized.getHeight(), sizeRez);
	    } else {
	    	matrix = new Matrix();
	    	resized = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
	    }
	    
	    return resized;
	}
	
}
