package com.eperium.jumpstart.testframework.utils;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WriteException;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.eperium.jumpstart.Setup;
import com.lowagie.text.BadElementException;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.eperium.jumpstart.testframework.utils.SuiteReportUtils;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;
import com.unitedinternet.portal.selenium.utils.logging.LoggingUtils;




public class ReportUtil extends TestListenerAdapter  {
	// static public boolean reportAttributesAdded=false;
	public static File pdfReportDir=null;
	static public Document pdfdocument = null;
	PdfPTable  failTable,successTable = null;
	static public String pdfFileName =null;
	public String testCaseStartAt =null;
	public String testCase = null;
	static public String pdfTestCaseName =null;
	static public ArrayList<String> arrInfoOnTestFinish = new ArrayList<String>();
	public static ArrayList<Image> arrAllScreenShot = new ArrayList<Image>();
	public static ArrayList<String> arrAllScreenShotAdded = new ArrayList<String>();

	@Override
	public void onStart(ITestContext context)
	{
		SuiteReportUtils so = new SuiteReportUtils();
	  	getPDFTestCaseName(context);
	  	testCase = context.getName();
	  	if(SuiteReportUtils.pdfRequired.equalsIgnoreCase("true")){
	  		pdfdocument = new Document();
	  	}
	  	else{
	  		pdfdocument = SuiteReportUtils.getPDFDocument();
	  	}
	  	
	    if(SuiteReportUtils.pdfRequired.equalsIgnoreCase("true")){
		try {
			
			pdfReportDir = new File(SuiteReportUtils.currDir+File.separator+SuiteReportUtils.site+File.separator+SuiteReportUtils.startDate+File.separator+"pdf"+File.separator);
			if(!pdfReportDir.exists()){
				pdfReportDir.mkdirs();
			}
			pdfFileName =SuiteReportUtils.channel+"_"+testCase+"_"+SuiteReportUtils.browser+"_"+LoggingUtils.timeStampForFileName()+".pdf";
			PdfWriter.getInstance(pdfdocument, new FileOutputStream(pdfReportDir+File.separator+pdfFileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		pdfdocument.open();
	    }
	    
	    try {
	    	if(!SuiteReportUtils.reportAttributesAdded){
	       	Paragraph channelParagraph = new Paragraph("Channel  :: "+SuiteReportUtils.channel,
						FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new Color(0, 0, 255)));
				Paragraph browserParagraph = new Paragraph("Browser  :: "+SuiteReportUtils.browser.substring(1),
						FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new Color(0, 0, 255)));
		//		Paragraph versionParagraph = new Paragraph("Version  :: "+setBrowserVersion(),
		//				FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new Color(0, 0, 255)));
				Paragraph startsAt = new Paragraph("Starts at  :: "+testCaseStartAt,
						FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new Color(0, 0, 255)));
				pdfdocument.add(browserParagraph);
				//pdfdocument.add(versionParagraph);
				pdfdocument.add(channelParagraph);
				pdfdocument.add(startsAt);
				SuiteReportUtils.reportAttributesAdded=true;
	    	}
	    
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			Paragraph testCaseParagraph = new Paragraph("TestCase :: "+context.getName(),
					FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new Color(0, 0, 255)));
			try {
				pdfdocument.add(testCaseParagraph);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} 


/*
 * This method writes the data in the excel report
*
* */
	private void setReportData(ITestResult result)
	{
		WritableSheet sheet = SuiteReportUtils.workbook.getSheet(0);
		WritableFont wrapCell = new WritableFont(WritableFont.TIMES);
		Label label1,label2,label3,label4,label5,label6,label7,label8,label9,label10;
		
		try {
			WritableCellFormat wrapText = new WritableCellFormat(wrapCell);
			wrapText.setWrap(true);
			WritableCellFormat passCellformat = new WritableCellFormat(wrapCell);
			passCellformat.setWrap(true);
			passCellformat.setBackground(Colour.LIGHT_GREEN);
			WritableCellFormat failCellformat = new WritableCellFormat(wrapCell);
			failCellformat.setWrap(true);
			failCellformat.setBackground(Colour.RED);
			if(result.getStatus() == 1)
			{
				label1 = new Label(SuiteReportUtils.testCaseName,SuiteReportUtils.rowNum,result.getTestClass().getXmlTest().getName(),passCellformat);
			}
			else
			{
				label1 = new Label(SuiteReportUtils.testCaseName,SuiteReportUtils.rowNum,result.getTestClass().getXmlTest().getName(),failCellformat);
			}
			sheet.addCell(label1);
			label2 = new Label(SuiteReportUtils.classMethod, SuiteReportUtils.rowNum,result.getMethod().getDescription(),wrapText);
			sheet.addCell(label2);
			label3 = new Label(SuiteReportUtils.time,SuiteReportUtils.rowNum,String.valueOf(result.getEndMillis()-result.getStartMillis()),wrapText);
			sheet.addCell(label3);
			Throwable throwable =  result.getThrowable();
			if (throwable != null)
			{
				if(result.getStatus() == 1)
				{
					label4 = new Label(SuiteReportUtils.exception,SuiteReportUtils.rowNum,"Passed",passCellformat);
					label10 = new Label(SuiteReportUtils.failReason,SuiteReportUtils.rowNum, "",wrapText);
				}
				else
				{
					label4 = new Label(SuiteReportUtils.exception,SuiteReportUtils.rowNum,"Failed",failCellformat);
					label10 = new Label(SuiteReportUtils.failReason,SuiteReportUtils.rowNum, throwable.getMessage(),wrapText);
				}
			}
			else
			{
				if(result.getStatus() == 1)
				{
					label4 = new Label(SuiteReportUtils.exception,SuiteReportUtils.rowNum,"Passed",passCellformat);
					label10 = new Label(SuiteReportUtils.failReason,SuiteReportUtils.rowNum, "",wrapText);
				}
				else
				{
					label4 = new Label(SuiteReportUtils.exception,SuiteReportUtils.rowNum,"Failed",failCellformat);
					label10 = new Label(SuiteReportUtils.failReason,SuiteReportUtils.rowNum, throwable.getMessage(),wrapText);
				}
			}
			sheet.addCell(label4);
		//	label10 = new Label(SuiteReportUtils.failReason,SuiteReportUtils.rowNum, throwable.getMessage(),failCellformat);
			sheet.addCell(label10);
			label5 = new Label(SuiteReportUtils.customer,SuiteReportUtils.rowNum,SuiteReportUtils.site,wrapText);
			sheet.addCell(label5);
			label6 = new Label(SuiteReportUtils.browserCol,SuiteReportUtils.rowNum, SuiteReportUtils.browser,wrapText);
			sheet.addCell(label6);
			label7 = new Label(SuiteReportUtils.versionCol,SuiteReportUtils.rowNum, setBrowserVersion(),wrapText);
			sheet.addCell(label7);
			label8 = new Label(SuiteReportUtils.channelCol,SuiteReportUtils.rowNum, SuiteReportUtils.channel,wrapText);
			sheet.addCell(label8);
			label9 = new Label(SuiteReportUtils.localeCol,SuiteReportUtils.rowNum,  SuiteReportUtils.locale,wrapText);
			sheet.addCell(label9);
			
			
			SuiteReportUtils.rowNum++;
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}
	

	/*
	 * This methods call the excel report method and adds the screenshot to be appended in the PDF report
	 * */
	@Override
	public void onTestSuccess(ITestResult result) {
		log("onTestSuccess("+result+")");
		setReportData(result);
		if (this.successTable == null) {
			this.successTable = new PdfPTable(new float[]{.3f, .3f, .1f});
			this.successTable.setTotalWidth(20f);
			Paragraph p = new Paragraph("PASSED TESTS", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD));
			p.setAlignment(Element.ALIGN_CENTER);
			PdfPCell cell = new PdfPCell(p);
			cell.setColspan(4);
			cell.setBackgroundColor(Color.GREEN);
			this.successTable.addCell(cell);
			
			
			cell = new PdfPCell(new Paragraph("Steps"));
			cell.setBackgroundColor(Color.LIGHT_GRAY);
			this.successTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Time (ms)"));
			cell.setBackgroundColor(Color.LIGHT_GRAY);
			this.successTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Result"));
			cell.setBackgroundColor(Color.LIGHT_GRAY);
			this.successTable.addCell(cell);
			
		}
		
		PdfPCell cell = new PdfPCell(new Paragraph(result.getMethod().getDescription()));
		this.successTable.addCell(cell);
		cell = new PdfPCell(new Paragraph("" + (result.getEndMillis()-result.getStartMillis())));
		this.successTable.addCell(cell);
		String exception = result.getThrowable() == null ? "Passed" : "";
		cell = new PdfPCell(new Paragraph(exception));
		this.successTable.addCell(cell);
		 System.out.println("============================"+result.getMethod().getDescription()+"============================");
		String strMultiChannelBrowser=result.getTestClass().getXmlTest().getParameter("channel")+result.getTestClass().getXmlTest().getParameter("selenium.browser");
		// need to check if a screenshot is added in the pdf for a testcase in a single channel and 
		if(!arrAllScreenShotAdded.contains(result.getMethod().getMethodName()+strMultiChannelBrowser))
		{
			Image img;
			 try {
				if(strMultiChannelBrowser.contains("iexplore")||strMultiChannelBrowser.contains("chrome")||strMultiChannelBrowser.contains("firefox")|| strMultiChannelBrowser.contains("safari"))
				{
					
						//  RemoteWebDriver compatibleDriver = (RemoteWebDriver) OciJumpStartTestSuite.driver;
						  // this allows only the screen shot compatible drivers instance.
						 // if(!(compatibleDriver != null)){
							  RemoteWebDriver  compatibleDriver = (RemoteWebDriver) Setup.driver;
						//  }
							  
						  File file =null; 
			              file = ((TakesScreenshot)compatibleDriver).getScreenshotAs(OutputType.FILE);

			              img = Image.getInstance(ImageIO.read(file) , null);  
			              img.scalePercent(40);
			              arrAllScreenShot.add(img);
			              arrAllScreenShotAdded.add(result.getMethod().getMethodName()+strMultiChannelBrowser);
				
				}
			 } catch (IOException e) {
					e.printStackTrace();
				} catch (BadElementException e) {
				e.printStackTrace();
			}
		
	}
	}
	

	/*
	 * This methods call the excel report method and adds the screenshot to be appended in the PDF report
	 * */
	@Override
	public void onTestFailure(ITestResult result) {
		log("onTestFailure("+result+")");
		setReportData(result);
		if (this.failTable == null) {
			this.failTable = new PdfPTable(new float[]{.3f, .3f, .1f, .3f});
			this.failTable.setTotalWidth(20f);
			Paragraph p = new Paragraph("FAILED TESTS", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD));
			p.setAlignment(Element.ALIGN_CENTER);
			PdfPCell cell = new PdfPCell(p);
			cell.setColspan(4);
			cell.setBackgroundColor(Color.RED);
			this.failTable.addCell(cell);
			
			cell = new PdfPCell(new Paragraph("Steps"));
			cell.setBackgroundColor(Color.LIGHT_GRAY);
			this.failTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Time (ms)"));
			cell.setBackgroundColor(Color.LIGHT_GRAY);
			this.failTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Result"));
			cell.setBackgroundColor(Color.LIGHT_GRAY);
			this.failTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Error"));
			cell.setBackgroundColor(Color.LIGHT_GRAY);
			this.failTable.addCell(cell);
		}
		
		PdfPCell cell = new PdfPCell(new Paragraph("" + result.getMethod().getDescription()));
		this.failTable.addCell(cell);
		cell = new PdfPCell(new Paragraph("" + (result.getEndMillis()-result.getStartMillis())));
		this.failTable.addCell(cell);
		String exception = result.getThrowable() == null ? "Passed" : "Failed";
		cell = new PdfPCell(new Paragraph(exception));
		this.failTable.addCell(cell);
		cell = new PdfPCell(new Paragraph(result.getThrowable().getMessage()));
		this.failTable.addCell(cell);
		String strMultiChannelBrowser=result.getTestClass().getXmlTest().getParameter("channel")+result.getTestClass().getXmlTest().getParameter("selenium.browser");
		// need to check if a screenshot is added in the pdf for a testcase in a single channel and 
		if(!arrAllScreenShotAdded.contains(result.getTestClass().getXmlTest().getName()+strMultiChannelBrowser))
		{
			Image img;
			 try {
				if(strMultiChannelBrowser.contains("iexplore")||strMultiChannelBrowser.contains("chrome")||strMultiChannelBrowser.contains("firefox"))
				{
					//RemoteWebDriver compatibleDriver = (RemoteWebDriver) OciJumpStartTestSuite.driver;
					  // this allows only the screen shot compatible drivers instance.
					//  if(!(compatibleDriver != null)){
						  RemoteWebDriver compatibleDriver = (RemoteWebDriver) Setup.driver;
					//  } // this allows only the screen shot compatible drivers instance.
					File file =null; 
		            String str = System.getProperty("user.dir") + "\\";
		            file = ((TakesScreenshot)compatibleDriver).getScreenshotAs(OutputType.FILE); 
		            System.out.println("str+================================="+str);
		              
		              
		              img = Image.getInstance(ImageIO.read(file) , null);  
		              img.scalePercent(40);
		              arrAllScreenShot.add(img);
		              arrAllScreenShotAdded.add(result.getMethod().getMethodName()+strMultiChannelBrowser);
		             
				}
				} catch (IOException e) {
					e.printStackTrace();
				} catch (BadElementException e) {
					e.printStackTrace();
				}
		}
		
	}
	@Override
	public void onFinish(ITestContext context) {
		log("onFinish("+context+")");
		
		try {
			
			if (this.successTable != null) {
				log("Added success table");
				this.successTable.setSpacingBefore(15f);
				pdfdocument.add(this.successTable);
				this.successTable.setSpacingAfter(15f);
				this.successTable = null;
				 
			}
			if (this.failTable != null) {
				log("Added fail table");
				this.failTable.setSpacingBefore(15f);
				pdfdocument.add(this.failTable);
				this.failTable.setSpacingAfter(15f);
				this.failTable = null;
			}
			/*Add screenshot in the order of the test case executed after the tables have been printed*/
			for(int i= 0 ;i <arrAllScreenShot.size();i++)
			{
				pdfdocument.newPage();
				pdfdocument.add(arrAllScreenShot.get(i));
			}
			pdfdocument.newPage();
			arrAllScreenShot.clear();//removing the screenshot which has been added to the document 
			arrAllScreenShotAdded.clear();//removing the screenshot check which has been added to the document
			if(SuiteReportUtils.pdfRequired.equalsIgnoreCase("true")){
			 if(pdfdocument!=null && pdfdocument.isOpen())
    		 {
				 pdfdocument.close();
    		 }
    		 if(new File(pdfReportDir+File.separator+pdfFileName).length() == 0)
    		 {
    			 new File(pdfReportDir+File.separator+pdfFileName).delete();	 // if the pdf report has no entry then delete the pdf file.
    		 }
			}			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}
	
	public void getPDFTestCaseName(ITestContext context)
	{
		testCaseStartAt= LoggingUtils.timeStampForFileName();
		String strbrowser = SuiteReportUtils.browser;
		pdfTestCaseName = SuiteReportUtils.channel+"_"+strbrowser+"_"/*+setBrowserVersion()*/+"_"+context.getName()+"_"+testCaseStartAt;
	}
	
	public static void log(Object o) {
		System.out.println("[EperiumListener] " + o);
	}

    public static void captureScreenShot() {
	
		Image img;
	 try {
		// RemoteWebDriver compatibleDriver = (RemoteWebDriver) OciJumpStartTestSuite.driver;
		  // this allows only the screen shot compatible drivers instance.
		 // if(!(compatibleDriver != null)){
			  RemoteWebDriver  compatibleDriver = (RemoteWebDriver) Setup.driver;
		 // } // this allows only the screen shot compatible drivers instance.
			File file =null; 
           String str = System.getProperty("user.dir") + "\\";
           file = ((TakesScreenshot)compatibleDriver).getScreenshotAs(OutputType.FILE); 
           img = Image.getInstance(ImageIO.read(file) , null);  
           img.scalePercent(40);
           arrAllScreenShot.add(img);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BadElementException e) {
			e.printStackTrace();
		}
	}


    public static String setBrowserVersion()
 {
			Capabilities capa = ((RemoteWebDriver) Setup.driver).getCapabilities();
			SuiteReportUtils.version = capa.getVersion().toString();
			return SuiteReportUtils.version;
		
 }




}






