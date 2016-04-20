/*
 * RenderAlice.java
 * 
 * Created on Jun 19, 2007, 8:06:48 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mobile.appraisal;

import java.io.*;
import com.lowagie.text.DocumentException;
import com.mobile.app.configuration.AppConstants;

import org.xhtmlrenderer.pdf.ITextRenderer;

/**
 *
 * @author joshy
 */
public class RenderAlice {

    public static void main(String[] args) 
            throws IOException, DocumentException {
        
    	
    	String inputFile = AppConstants.FILEPATH + "alice/alice.xhtml";
        String url = new File(inputFile).toURI().toURL().toString();
        String outputFile = AppConstants.FILEPATH + "alice.pdf";
        OutputStream os = new FileOutputStream(outputFile);
        
        ITextRenderer renderer = new ITextRenderer();
        
        renderer.setDocument(url);
        renderer.layout();
        renderer.createPDF(os);
        
        os.close();
    }
}
