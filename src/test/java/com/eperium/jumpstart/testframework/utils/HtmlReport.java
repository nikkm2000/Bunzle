package com.eperium.jumpstart.testframework.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class HtmlReport extends TestListenerAdapter {
	
	
	public int numberTests;
	File indiTest;
	FileWriter _fw;
	BufferedWriter _bw;


	DateFormat t=new SimpleDateFormat("dd-mm-yyyy HH:mm:ss");
	Date d=new Date();
	
	 @Override
	  public void onStart(ITestContext testContext) {
		 ISuite si = testContext.getSuite();
		 indiTest=new File("OverviewReport/"+si.getName()+"/"+testContext.getName()+".html");
		 if(indiTest.exists()){
			try {
				_fw = new FileWriter(indiTest.getAbsoluteFile());
				_bw = new BufferedWriter(_fw);
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }else{
			 try {
				     indiTest.getAbsolutePath();
					_fw = new FileWriter(indiTest,indiTest.createNewFile());
					_bw = new BufferedWriter(_fw);
				}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 
		 }
				 	 
			try {
				_bw.write("<html><head><style>table, th, td {    border: 1px solid black; "
						+ "border-collapse: collapse;}th, td {    padding: 5px;    text-align: left;}table#t01 {    width: 70%;        background-color: #ffffff;}</style></head><body>"
						+ "<table id=\"t01\"><tr><th>Test Scenario</th><th style=\"background-color:#66ff99;\">Methods</th><th style=\"background-color:#66ff99;\">Result</th><th style=\"background-color:red;\">Failure Reason</th></tr>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

	  }
	 }
	  
	  @Override
	  public void onTestFailure(ITestResult tr) {
		  
		  try {
			_bw.write("<tr><td>"+tr.getTestContext().getName()+"</td><td>"+tr.getName()+"</td><td>Failed</td><td>"+tr.getThrowable().getMessage()+"</td></tr>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	 
	  @Override
	  public void onTestSkipped(ITestResult tr) {
		
		  try {
			  _bw.write("<tr><td>"+tr.getTestContext().getName()+"</td><td>"+tr.getName()+"</td><td>Skipped</td><td></td></tr>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
	 
	  @Override
	  public void onTestSuccess(ITestResult tr) {
		  try {
			  _bw.write("<tr><td>"+tr.getTestContext().getName()+"</td><td>"+tr.getName()+"</td><td>Passed</td><td></td></tr>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
	  }
		

	  @Override
	  public void onFinish(ITestContext testContext){
		  System.out.println("Bibudhendu Swain"+testContext.getName()+testContext.getFailedTests().size());
		  try {
			_bw.write("</table><br><br></body></html>");
			_bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
	  }


	
}
