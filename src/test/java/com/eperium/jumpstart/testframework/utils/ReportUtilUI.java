package com.eperium.jumpstart.testframework.utils;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.eperium.jumpstart.Setup;
import com.lowagie.text.Chunk;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.eperium.jumpstart.testframework.utils.SuiteReportUtilsUI;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;
import com.unitedinternet.portal.selenium.utils.logging.LoggingUtils;




public class ReportUtilUI extends TestListenerAdapter  {
	// static public boolean reportAttributesAdded=false;
	public static File pdfReportDir=null;
	static public Document pdfdocument = null;
	//PdfPTable  failTable,successTable;
	static public String pdfFileName =null;
	public String testCaseStartAt =null;
	public String testCase = null;
	static public String pdfTestCaseName =null;
	static public ArrayList<String> arrInfoOnTestFinish = new ArrayList<String>();
	String actualScreen=null;
	PdfPTable tables;
	Font font = new Font(Font.BOLD);
	Font font1 = new Font(Font.BOLD);

	@Override
	public void onStart(ITestContext context)
	{
		Rectangle rect = new Rectangle(600, 600);
		SuiteReportUtilsUI so = new SuiteReportUtilsUI();
	  	getPDFTestCaseName(context);
	  	testCase = context.getName();
	  	tables = new PdfPTable(2);
	  	tables.setWidthPercentage(100);
	  	font1.setColor(Color.RED);
        font.setColor(Color.GREEN);
	  	if(SuiteReportUtilsUI.pdfRequired.equalsIgnoreCase("true")){
	  		pdfdocument = new Document(rect);
	  	}
	  	else{
	  		pdfdocument = SuiteReportUtilsUI.getPDFDocument();
	  	}
	  	
	    if(SuiteReportUtilsUI.pdfRequired.equalsIgnoreCase("true")){
		try {
			
			pdfReportDir = new File(SuiteReportUtilsUI.currDir+File.separator+SuiteReportUtilsUI.site+File.separator+SuiteReportUtilsUI.startDate+File.separator+"pdf_UI"+File.separator);
			if(!pdfReportDir.exists()){
				pdfReportDir.mkdirs();
			}
			pdfFileName =SuiteReportUtilsUI.channel+"_"+testCase+"_"+SuiteReportUtilsUI.browser+"_"+LoggingUtils.timeStampForFileName()+".pdf";
			PdfWriter.getInstance(pdfdocument, new FileOutputStream(pdfReportDir+File.separator+pdfFileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		pdfdocument.open();
		
	    }
	    
	    try {
	    	if(!SuiteReportUtilsUI.reportAttributesAdded){
	    		
	    		Paragraph subject = new Paragraph("UI Automation Test Report",
						FontFactory.getFont(FontFactory.HELVETICA, 22, Font.BOLD, new Color(102, 0, 102)));	    		
	       	    Paragraph channelParagraph = new Paragraph(SuiteReportUtilsUI.channel,
						FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL, new Color(80, 77, 77)));
				Paragraph browserParagraph = new Paragraph(SuiteReportUtilsUI.browser.substring(1),
						FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL, new Color(80, 77, 77)));
				Paragraph startsAt = new Paragraph(testCaseStartAt,
						FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL, new Color(80, 77, 77)));
				Paragraph testCaseParagraph = new Paragraph(context.getName(),
						FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD, new Color(0, 0, 0)));
				Paragraph channel = new Paragraph("CHANNEL",
						FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new Color(80, 77, 77)));
				Paragraph date = new Paragraph("DATE",
						FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new Color(80, 77, 77)));
				Paragraph browser = new Paragraph("BROWSER",
						FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new Color(80, 77, 77)));
				
				testCaseParagraph.setAlignment(Element.ALIGN_BOTTOM);
				startsAt.setAlignment(Element.ALIGN_CENTER);
				browserParagraph.setAlignment(Element.ALIGN_CENTER);
				subject.setSpacingBefore(160f);
				subject.setAlignment(Element.ALIGN_BOTTOM);
				channelParagraph.setAlignment(Element.ALIGN_CENTER);
				
				
				
				//Adding Logos
				try {
					Image logo = Image.getInstance("./PDFLogos/images.jpg");
					logo.scalePercent(60);
					logo.setAlignment(Element.ALIGN_TOP);//(100f, 10f);
					Image sLogo = Image.getInstance("./PDFLogos/Salmon.png");
					sLogo.scalePercent(40);
					sLogo.setAbsolutePosition(400f, 10f);
					//pdfdocument.setPageSize(new Rectangle(400, 300));
					pdfdocument.add(logo);
					pdfdocument.add(sLogo);
					/*pdfdocument.add( Chunk.NEWLINE);
					pdfdocument.add( Chunk.NEWLINE);*/
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
								
				tables.setSpacingBefore(20f);
				tables.addCell(channel);
				tables.addCell(channelParagraph);
				
				tables.addCell(date);
				tables.addCell(startsAt);
				
				tables.addCell(browser);
				tables.addCell(browserParagraph);
				tables.setHorizontalAlignment(Element.ALIGN_BOTTOM);
				
				/*pdfdocument.add( Chunk.NEWLINE);
				pdfdocument.add( Chunk.NEWLINE);*/
				pdfdocument.add(subject);
				pdfdocument.add( Chunk.NEWLINE);
				pdfdocument.add(testCaseParagraph);
				pdfdocument.add( Chunk.NEWLINE);
				pdfdocument.add( Chunk.NEWLINE);
				/*pdfdocument.add(testCaseParagraph);
				pdfdocument.add(startsAt);
				pdfdocument.add(browserParagraph);
				//pdfdocument.add(versionParagraph);
				pdfdocument.add(channelParagraph);	*/
				pdfdocument.add(tables);
				pdfdocument.add( Chunk.NEXTPAGE );
				SuiteReportUtilsUI.reportAttributesAdded=true;
	    	}
	    
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			/*Paragraph testCaseParagraph = new Paragraph("TestCase :: "+context.getName(),
					FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new Color(0, 0, 255)));
			try {
				pdfdocument.add(testCaseParagraph);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
		} 



	@Override
	public void onTestSuccess(ITestResult result) {
		if(result.getMethod().getMethodName().toString().contains("_UI"))
		{
		log("onTestSuccess("+result+")");
	  	tables = new PdfPTable(2);
	  	tables.setWidthPercentage(100);
		PdfPTable successTable=null;
		if (successTable == null) {
			successTable = new PdfPTable(new float[]{.3f, .3f, .1f});
			successTable.setTotalWidth(20f);
			/*Paragraph p = new Paragraph("PASSED TESTS", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD));
			p.setAlignment(Element.ALIGN_CENTER);
			PdfPCell cell = new PdfPCell(p);
			cell.setColspan(4);
			cell.setBackgroundColor(Color.GREEN);
			successTable.addCell(cell);*/
			
			
			PdfPCell cell = new PdfPCell(new Paragraph("Steps"));
			cell.setBackgroundColor(Color.LIGHT_GRAY);
			successTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Time (ms)"));
			cell.setBackgroundColor(Color.LIGHT_GRAY);
			successTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Result"));
			cell.setBackgroundColor(Color.LIGHT_GRAY);
			successTable.addCell(cell);
			
		}
		PdfPCell cell = new PdfPCell(new Paragraph(result.getMethod().getDescription()));
		successTable.addCell(cell);
		cell = new PdfPCell(new Paragraph("" + (result.getEndMillis()-result.getStartMillis())));
		successTable.addCell(cell);
		String exception = result.getThrowable() == null ? "Passed" : "";
		cell = new PdfPCell(new Paragraph(exception,font));
		successTable.addCell(cell);
		 System.out.println("============================"+result.getMethod().getDescription()+"============================");
		String strMultiChannelBrowser=result.getTestClass().getXmlTest().getParameter("channel")+result.getTestClass().getXmlTest().getParameter("selenium.browser");
		try {
			
			if (successTable != null) {
				log("Added success table");
				successTable.setSpacingBefore(15f);
				pdfdocument.add(successTable);
				successTable.setSpacingAfter(15f);
				successTable = null;
				 
			}
			pdfdocument.add(Chunk.NEWLINE);
			RemoteWebDriver compatibleDriver = (RemoteWebDriver) Setup.driver;
			File actualFile = ((TakesScreenshot) compatibleDriver).getScreenshotAs(OutputType.FILE);
			actualScreen="file:///"+actualFile.getAbsolutePath();
			System.out.println("actualScreen"+actualScreen);
			if(findSourceImage(result))
			{		
				String expectedScreen="./images/"+result.getMethod().getMethodName().toString()+".png";
				tables.addCell("Expected Image");
				tables.addCell("Actual Image");
		        try {
		        	tables.addCell(createImageCell(expectedScreen));
		        	tables.addCell(createImageCell(actualScreen));
				} catch (DocumentException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        try {
					pdfdocument.add(tables);
						
						Image sLogo = Image.getInstance("./PDFLogos/Salmon.png");
						sLogo.scalePercent(40);
						sLogo.setAbsolutePosition(400f, 10f);
						//pdfdocument.setPageSize(new Rectangle(400, 300));
						pdfdocument.add(sLogo);
						pdfdocument.newPage();
						/*pdfdocument.add( Chunk.NEWLINE);
						pdfdocument.add( Chunk.NEWLINE);*/
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				//String expectedScreen="./images/"+result.getMethod().getMethodName().toString()+".png";
				tables.addCell("Expected Image");
				tables.addCell("Actual Image");
		        try {
		        	tables.addCell("Expected Image is not found");
		        	tables.addCell(createImageCell(actualScreen));
				} catch (DocumentException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        try {
					pdfdocument.add(tables);
					try {
						pdfdocument.add(tables);
							
							Image sLogo = Image.getInstance("./PDFLogos/Salmon.png");
							sLogo.scalePercent(40);
							sLogo.setAbsolutePosition(400f, 10f);
							//pdfdocument.setPageSize(new Rectangle(400, 300));
							pdfdocument.add(sLogo);
							pdfdocument.newPage();
							/*pdfdocument.add( Chunk.NEWLINE);
							pdfdocument.add( Chunk.NEWLINE);*/
						} catch (MalformedURLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (DocumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					pdfdocument.newPage();
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

		}catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	}
	

	
	@Override
	public void onTestFailure(ITestResult result) {
		if(result.getMethod().getMethodName().toString().contains("_UI"))
		{
		tables = new PdfPTable(2);
	  	tables.setWidthPercentage(100);
		log("onTestFailure("+result+")");
		PdfPTable failTable=null;
		if (failTable == null) {
			failTable = new PdfPTable(new float[]{.3f, .3f, .1f});
			failTable.setTotalWidth(20f);
			/*Paragraph p = new Paragraph("FAILED TESTS", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD));
			p.setAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1 = new PdfPCell(p);
			cell1.setColspan(4);
			cell1.setBackgroundColor(Color.RED);
			failTable.addCell(cell1);*/
			
			PdfPCell cell1 = new PdfPCell(new Paragraph("Steps"));
			cell1.setBackgroundColor(Color.LIGHT_GRAY);
			failTable.addCell(cell1);
			cell1 = new PdfPCell(new Paragraph("Time (ms)"));
			cell1.setBackgroundColor(Color.LIGHT_GRAY);
			failTable.addCell(cell1);
			cell1 = new PdfPCell(new Paragraph("Result"));
			cell1.setBackgroundColor(Color.LIGHT_GRAY);
			failTable.addCell(cell1);
			/*cell1 = new PdfPCell(new Paragraph("Error"));
			cell1.setBackgroundColor(Color.LIGHT_GRAY);
			failTable.addCell(cell1);*/
		}	
		PdfPCell cell = new PdfPCell(new Paragraph("" + result.getMethod().getDescription()));
		failTable.addCell(cell);
		cell = new PdfPCell(new Paragraph("" + (result.getEndMillis()-result.getStartMillis())));
		failTable.addCell(cell);
		String exception = result.getThrowable() == null ? "Passed" : "Failed";
		cell = new PdfPCell(new Paragraph(exception,font1));
		failTable.addCell(cell);
		/*cell = new PdfPCell(new Paragraph(result.getThrowable().getMessage()));
		failTable.addCell(cell);*/
		String strMultiChannelBrowser=result.getTestClass().getXmlTest().getParameter("channel")+result.getTestClass().getXmlTest().getParameter("selenium.browser");
		try{
		if (failTable != null) {
			log("Added fail table");
			failTable.setSpacingBefore(15f);
			pdfdocument.add(failTable);
			failTable.setSpacingAfter(15f);
			failTable = null;
		}
		pdfdocument.add(Chunk.NEWLINE);
		RemoteWebDriver compatibleDriver = (RemoteWebDriver) Setup.driver;
		File actualFile = ((TakesScreenshot) compatibleDriver).getScreenshotAs(OutputType.FILE);
		actualScreen="file:///"+actualFile.getAbsolutePath();
		System.out.println("actualScreen"+actualScreen);
		if(findSourceImage(result))
		{		
			String expectedScreen="./images/"+result.getMethod().getMethodName().toString()+".png";
			tables.addCell("Expected Image");
			tables.addCell("Actual Image");
	        try {
	        	tables.addCell(createImageCell(expectedScreen));
	        	tables.addCell(createImageCell(actualScreen));
			} catch (DocumentException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
				try {
					pdfdocument.add(tables);
						
						Image sLogo = Image.getInstance("./PDFLogos/Salmon.png");
						sLogo.scalePercent(40);
						sLogo.setAbsolutePosition(400f, 10f);
						//pdfdocument.setPageSize(new Rectangle(400, 300));
						pdfdocument.add(sLogo);
						pdfdocument.newPage();
						/*pdfdocument.add( Chunk.NEWLINE);
						pdfdocument.add( Chunk.NEWLINE);*/
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		else
		{
			//String expectedScreen="./images/"+result.getMethod().getMethodName().toString()+".png";
			tables.addCell("Expected Image");
			tables.addCell("Actual Image");
	        try {
	        	tables.addCell("Expected Image is not found");
	        	tables.addCell(createImageCell(actualScreen));
			} catch (DocumentException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
				pdfdocument.add(tables);
					
					Image sLogo = Image.getInstance("./PDFLogos/Salmon.png");
					sLogo.scalePercent(40);
					sLogo.setAbsolutePosition(400f, 10f);
					//pdfdocument.setPageSize(new Rectangle(400, 300));
					pdfdocument.add(sLogo);
					pdfdocument.newPage();
					/*pdfdocument.add( Chunk.NEWLINE);
					pdfdocument.add( Chunk.NEWLINE);*/
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	  }catch (DocumentException e) {
			e.printStackTrace();
		}
		
		}
		
	}
	
	
	
	@Override
	public void onFinish(ITestContext context) {
		log("onFinish("+context+")");
		pdfdocument.close();
	   // writer.close();

		}
		
	
	public void getPDFTestCaseName(ITestContext context)
	{
		testCaseStartAt= LoggingUtils.timeStampForFileName();
		String strbrowser = SuiteReportUtilsUI.browser;
		pdfTestCaseName = SuiteReportUtilsUI.channel+"_"+strbrowser+"_"/*+setBrowserVersion()*/+"_"+context.getName()+"_"+testCaseStartAt;
	}
	
	
	public static void log(Object o) {
		System.out.println("[EperiumListener] " + o);
	}

	
    public static String setBrowserVersion()
 {
			Capabilities capa = ((RemoteWebDriver) Setup.driver).getCapabilities();
			SuiteReportUtilsUI.version = capa.getVersion().toString();
			return SuiteReportUtilsUI.version;
		
 }
    
   
    private static boolean findSourceImage(ITestResult tr) {
		
		boolean res=false;
		String fPath="./images/"+tr.getMethod().getMethodName()+".png";
		System.out.println("path is what "+fPath);
		File file=new File(fPath);
		if (file.exists())
		{
			res= true;
		}
		 return res;
	}
    
    
    private static PdfPCell createImageCell(String path) throws DocumentException, MalformedURLException, IOException 
	{
		Image img = Image.getInstance(path);
        PdfPCell cell2 = new PdfPCell(img, true);
        return cell2;
	}




}






