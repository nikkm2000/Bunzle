package com.eperium.jumpstart.testframework.utils;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.eperium.jumpstart.Setup;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class NewPDFReport extends TestListenerAdapter {
	Document document=null;	
	PdfWriter writer;
	PdfPTable table;
	String actualScreen=null;
			
	Font font = new Font(Font.BOLD);
	Font font1 = new Font(Font.BOLD);
	
	
	
	@Override
	public void onStart(ITestContext context)
	{
		        String pdfName=context.getCurrentXmlTest().getName().toString();
		        document = new Document();
		        table = new PdfPTable(2);
		        font1.setColor(Color.RED);
		        font1.setSize(10);
		        font.setColor(Color.GREEN);
		        font.setSize(10);
		 		
		    try {
				writer = PdfWriter.getInstance(document, new FileOutputStream(pdfName+".pdf"));
				document.open();
			    table.setWidthPercentage(100);
			} catch (DocumentException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		    
	    
		
	}
	
	@Override
	public void onFinish(ITestContext context)
	{
		document.close();
	    writer.close();
	}
	
	@Override
	public void onTestSuccess(ITestResult tr)
	{
		try {
			System.out.println("Page number"+document.getPageNumber());
			
			document.add(new Paragraph(tr.getMethod().getDescription()+" :: Passed",font));
			document.add( Chunk.NEWLINE );
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		RemoteWebDriver compatibleDriver = (RemoteWebDriver) Setup.driver;
		File actualFile = ((TakesScreenshot) compatibleDriver).getScreenshotAs(OutputType.FILE);
		actualScreen="file:///"+actualFile.getAbsolutePath();
		System.out.println("actualScreen"+actualScreen);
		if(findSourceImage(tr))
		{		
			String expectedScreen="./images/"+tr.getMethod().getMethodName().toString()+".png";
			table.addCell("Expected Image");
		    table.addCell("Actual Image");
	        try {
				table.addCell(createImageCell(expectedScreen));
				table.addCell(createImageCell(actualScreen));
			} catch (DocumentException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
				document.add(table);
				document.newPage();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			Image image1 = null;
			try {
				//document.add(new Paragraph(tr.getMethod().getMethodName()));
				image1 = Image.getInstance(new URL(actualScreen));
				image1.scalePercent(40);
				document.add(image1);
				//image1.scaleAbsoluteHeight(30);
			} catch (IOException | DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
		
	}

	@Override
	public void onTestFailure(ITestResult tr)
	{
		try {
			System.out.println("Page number"+document.getPageNumber());
			document.add(new Paragraph(tr.getMethod().getDescription()+" :: Failed",font1));
			//tr.getMethod().getDescription()
			document.add( Chunk.NEWLINE );
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		RemoteWebDriver compatibleDriver = (RemoteWebDriver) Setup.driver;
		File actualFile = ((TakesScreenshot) compatibleDriver).getScreenshotAs(OutputType.FILE);
		actualScreen="file:///"+actualFile.getAbsolutePath();
		System.out.println("actualScreen"+actualScreen);
		if(findSourceImage(tr))
		{		
			String expectedScreen="./images/"+tr.getMethod().getMethodName().toString()+".png";
			table.addCell("Expected Image");
		    table.addCell("Actual Image");
	        try {
				table.addCell(createImageCell(expectedScreen));
				table.addCell(createImageCell(actualScreen));
			} catch (DocumentException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
				document.add(table);
				document.newPage();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			Image image1 = null;
			try {
				//document.add(new Paragraph(tr.getMethod().getMethodName()));
				image1 = Image.getInstance(new URL(actualScreen));
				image1.scalePercent(40);
				document.add(image1);
				//image1.scaleAbsoluteHeight(30);
			} catch (IOException | DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}		
	}
	
	private static PdfPCell createImageCell(String path) throws DocumentException, MalformedURLException, IOException 
	{
		Image img = Image.getInstance(path);
        PdfPCell cell = new PdfPCell(img, true);
        return cell;
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
	
	/*public static void captureScreenShot() {

		Image img;
		try {
			RemoteWebDriver compatibleDriver = (RemoteWebDriver) Setup.driver;
			File file1 = null;
			String str = System.getProperty("user.dir") + "\\";
			file1 = ((TakesScreenshot) compatibleDriver).getScreenshotAs(OutputType.FILE);
			img = Image.getInstance(ImageIO.read(file1), null);
			//img.scalePercent(40);
			//arrAllScreenShot.add(img);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BadElementException e) {
			e.printStackTrace();
		}
	}*/

	}
