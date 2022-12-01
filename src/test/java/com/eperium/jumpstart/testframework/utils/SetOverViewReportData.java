package com.eperium.jumpstart.testframework.utils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class SetOverViewReportData extends TestListenerAdapter {


		public String site;
		public int numberTests;
		File suiteReport;
		FileWriter fw;
		BufferedWriter bw1;


		DateFormat t=new SimpleDateFormat("dd-mm-yyyy HH:mm:ss");
		Date d=new Date();
		
		  @Override
		  public void onStart(ITestContext testContext) {
			  numberTests=testContext.getSuite().getXmlSuite().getTests().size();
			  //set all counter to zero
			  
			  System.out.println("Bibud "+numberTests);
			  
			  
			  
			  //html report start
			  if(SetOverViewReport1._count==0){
				  /*  suiteReport=new File(testContext.getSuite().getName()+".html");
				if(suiteReport.exists()){
					suiteReport.delete();
				}*/
				 suiteReport=new File("index.html");
				try {
					fw = new FileWriter(suiteReport.getAbsoluteFile(), true);
					bw1 = new BufferedWriter(fw);
				} 
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					bw1.write("<html><head><style>table, th, td {    border: 1px solid black; "
							+ "border-collapse: collapse;}th, td {    padding: 5px;    text-align: left;}table#t01 {    width: 70%;        background-color: #ffffff;}</style></head><body>"
							+ "<table id=\"t01\"><tr><th>Test Scenario</th><th style=\"background-color:#66ff99;\">Passed Tests</th><th style=\"background-color:red;\">Failed Tests</th></tr>");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  }
			  SetOverViewReport1._count++;

		  }
		  
		  @Override
		  public void onTestFailure(ITestResult tr) {
			  
			  SetOverViewReport1._fail=SetOverViewReport1._fail+1;
		  }
		 
		  @Override
		  public void onTestSkipped(ITestResult tr) {
			
			  SetOverViewReport1._skip=SetOverViewReport1._skip+1;
		  }
		 
		  @Override
		  public void onTestSuccess(ITestResult tr) {
			  
			  SetOverViewReport1._pass=SetOverViewReport1._pass+1;
		  }
			
	 
		  @Override
		  public void onFinish(ITestContext testContext){
			  
			  try {
				if(SetOverViewReport1._count<numberTests)
				{
				bw1.write("<tr><td><a href=\"OverviewReport/"+testContext.getSuite().getName()+"/"+testContext.getCurrentXmlTest().getName()+".html\">"+testContext.getCurrentXmlTest().getName()+"</td><td>"+testContext.getPassedTests().size()+"</td><td>"+testContext.getFailedTests().size()+"</td></tr>");
				}else if(SetOverViewReport1._count==numberTests)
				{
					bw1.write("<tr><td><a href=\"OverviewReport/"+testContext.getSuite().getName()+"/"+testContext.getCurrentXmlTest().getName()+".html\">"+testContext.getCurrentXmlTest().getName()+"</td><td>"+testContext.getPassedTests().size()+"</td><td>"+testContext.getFailedTests().size()+"</td></tr>");
					bw1.write("</table><br><br></body></html>");
					bw1.flush();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
		  }



}
