package com.eperium.jumpstart.testframework.utils;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfWriter;
import com.unitedinternet.portal.selenium.utils.logging.LoggingUtils;
//import com.lowagie.text.pdf.PdfWriter;

public class SuiteReportUtilsUI implements ISuiteListener{
	private static final String START_DATE_TIME_FORMAT = "startDateTimeFormat";
	private static final String START_DATE_TIME = "startDateTime";
	//SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
     static public WritableWorkbook workbook;
     static public int testCaseName= 0;
     static public int classMethod=1;
     static public int exception= 2;
     static public int failReason =3;
     static public int customer= 4;
     static public int browserCol= 5;
     static public int versionCol= 6;
     static public int channelCol= 7;
     static public int localeCol= 8;
     static public int time= 9;
     static public int rowNum = 0;
     static public String browser=null,version=null,testcasename=null;
     static public String site=null,environment=null;
     static public String channel=null;
     static public String locale=null;
     static public String currFileName = null;
     static public String pdfFileName =null;
     static public String pdfTestCaseName =null;
     public WritableSheet sheet=null;
     public File reportDir=null;
     public ArrayList<String> arrFileNames =null,existingPDFFiles=null;
     public static File pdfReportDir=null;
     public String testCaseStartAt =null;
     static public String currDir=null;
     static public String pdfRequired=null;
     static public String startDate=null;
     static public String startDateTime=null;
     
     static public Document pdfdocument = null;
     static public boolean reportAttributesAdded=false;
    
     @Override
	public void onStart(ISuite arg0)
     {
		site = arg0.getXmlSuite().getParameter("site");
	 	channel = arg0.getXmlSuite().getParameter("channel");
		browser = arg0.getXmlSuite().getParameter("selenium.browser");
		//version = Setup.version;
		locale = arg0.getXmlSuite().getParameter("locale");
		testcasename = arg0.getXmlSuite().getParameter("testcasename");
		pdfRequired = arg0.getXmlSuite().getParameter("PDFRequiredPerTestCase");
		 try {
		    	Properties urlProp = PropertyLoader.getUrlPropertiesFile(channel);
		    			
			    environment = urlProp.getProperty("environment");
		     } 
		 catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		currDir =  System.getProperty("user.dir")+File.separator+"TestcasesReports";
	    reportDir = new File(currDir);
	    startDate= getStartDate();	
		startDateTime= getStartDateTime();
		/*String reports = "reports";
		startDate= getStartDate();	
		startDateTime= getStartDateTime();
		reportDir = new File(currDir+File.separator+site+File.separator+startDate+File.separator+reports);
		String fileName = site+"_"+"AutomationReport"+"_"+environment+"_"+startDateTime; 
		currFileName = reportDir+File.separator+fileName+".xls";
		System.out.println("Directory where report generated." +reportDir);
		if(!reportDir.exists()){
			reportDir.mkdirs();
		}*/
		if(!reportDir.exists()){
			reportDir.mkdirs();
		}
		pdfReportDir = new File(currDir+File.separator+site+File.separator+startDate+File.separator+"pdf_UI"+File.separator);
		if(!pdfReportDir.exists()){
			pdfReportDir.mkdirs();
		}
		
			if(!pdfRequired.equalsIgnoreCase("true")){
				setPDFReportData(arg0);
			}
		
	}
     
     @Override
	public void onFinish(ISuite arg0)
     {
    	 
    		 if(!pdfRequired.equalsIgnoreCase("true")){
    		    if(pdfdocument!=null && pdfdocument.isOpen())
    	     	 {
    			 pdfdocument.close();
    		      }
    		 if(new File(pdfReportDir+File.separator+pdfFileName).length() == 0)
    		 {
    			 new File(pdfReportDir+File.separator+pdfFileName).delete();	 // if the pdf report has no entry then delete the pdf file.
    		 }
    		
    		 }
    	 
     }
     
     /**
      * This method will read the system environment variables "startDateTime" and "dateTimeFormat" and return the date in required format.
      * If no date is found in environment, current date will be used.
      * @return String
      */
     
     private String getStartDate() {
    	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
    	 String date = System.getenv(START_DATE_TIME);
       	 String format = System.getenv(START_DATE_TIME_FORMAT);
    	 String startDate = null;
    	 if(date != null && format != null){
    		  try{
    			 startDate = dateformat.format(new SimpleDateFormat(format).parse(date));
    		 }catch(ParseException x){
    			 //nothing to do
    			 System.out.println("Start date not found in system environment." );
    		 }
    	 }
    	 if(startDate == null){
    		 System.out.println("Falling back to current date.");
    		 startDate = dateformat.format(new Date());
    	 }
    	 return startDate;
     }
     
     /**
      * This method will read the system environment variables "startDateTime" and "dateTimeFormat" and return the date in required format.
      * If no date is found in environment, current date will be used.
      * @return String
      */
     
     private String getStartDateTime() {
    	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd_HH-mm");
    	 String date = System.getenv("startDateTime");
    	 String format = System.getenv("startDateTimeFormat");
    	 String startDateTime = null;
    	 if(date != null && format != null){
    		 try{
    			 startDateTime = dateformat.format(new SimpleDateFormat(format).parse(date));
    		 }catch(ParseException x){
    			 //nothing to do
    		 }
    	 }
    	 if(startDateTime == null){
    		 System.out.println("Start date not found in system environment. Falling back to current date.");
    		 startDateTime = LoggingUtils.timeStampForFileName();
    	 }
    	 return startDateTime;
     }
     
/**
 * if the time difference between the file and current time is more than five minutes, a new test case is running so create a new file for report 
 * */
public boolean getTimeDifference(Date d1, Date d2)
{
	boolean writeInSameFile = false ;
	
	Calendar cal1 = Calendar.getInstance();
	Calendar cal2 = Calendar.getInstance();
	cal1.setTime(d1);
	cal2.setTime(d2);
	long milliSeconds1 = cal1.getTimeInMillis();
	long milliSeconds2 = cal2.getTimeInMillis();
	long diff = milliSeconds1 - milliSeconds2;
	long minutes = diff/(1000*60);
	System.out.println("difference in minutes is "+minutes);
	if(minutes >= 5)
	{
		writeInSameFile= false;
	}
	else
	{
		writeInSameFile= true;
	}
	
	
	return writeInSameFile;
}

/**
 * Generates a pdf for testCases
 * */
public void setPDFReportData(ISuite result)
{
	try	{
		pdfdocument= new Document();
		pdfFileName =channel+"_"+testcasename+"_"+browser.substring(1)+"_"+LoggingUtils.timeStampForFileName()+".pdf";
		PdfWriter.getInstance(pdfdocument, new FileOutputStream(pdfReportDir+File.separator+pdfFileName));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (DocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	pdfdocument.open();
	}

public static Document getPDFDocument()
{
	return pdfdocument;
}
}

