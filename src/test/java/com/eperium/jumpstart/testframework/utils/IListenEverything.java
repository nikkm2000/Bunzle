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



public class IListenEverything extends TestListenerAdapter {
	
	public String site;

	FileWriter fw1;
	BufferedWriter bw1;
	File f1,f2;
	//File f3;
	DateFormat t=new SimpleDateFormat("dd-mm-yyyy HH:mm:ss");
	Date d=new Date();
	
	

	@Override
	  public void onStart(ITestContext testContext) {
		 
		  //m_count=0;l_count=0;p_count=0;f_count=0;
		//System.out.println("QWERTY TEST"+site);
		site=testContext.getCurrentXmlTest().getParameter("site");
		//System.out.println("QWERTY TEST"+site);
		f2=new File("IListenReports");
		if (!f2.exists()){
			new File("IListenReports").mkdir();
		}
		
		f1=new File("IListenReports"+"/iReport_"+site+".html");
		if(f1.exists()){
			f1.delete();
			f1=new File("IListenReports"+"/iReport_"+site+".html");
		}
		/*f3=new File("IListenReports"+"/SummaryReport.html");
		if(f3.exists())
		{
			System.out.println("HI");
		}
		*/
	  }
	  
	  @Override
	  public void onTestFailure(ITestResult tr) {
		  
		  ITestContext tc =tr.getTestContext();
		  ListenEverything.f_count+=1;
		  log("<tr class=\"failedRow\"><td width=\"50%\">"+tc.getName()+"</td>"+"<td width=\"45%\">"+tr.getMethod().getMethodName().toString()+"</td>"+"<td width=\"5%\">"+"<img src=\"../ReportImages/error.png\" alt=\"Test\" title="+tr.getThrowable().toString()+"/>"+" "+"</td></tr>");
		  
	  }
	 
	  @Override
	  public void onTestSkipped(ITestResult tr) {

		  ITestContext tc =tr.getTestContext();
		  log("<tr><td width=\"50%\">"+tc.getName()+"</td>"+"<td width=\"45%\">"+tr.getMethod().getMethodName().toString()+"</td>"+"<td width=\"5%\">"+"<img src=\"../ReportImages/skip.png\" alt=\"Test\" title=\"Skipped\"/></td></tr>");
	  }
	 
	  @Override
	  public void onTestSuccess(ITestResult tr) {
		  ITestContext tc =tr.getTestContext();
		  ListenEverything.p_count+=1;
		  log("<tr><td width=\"50%\">"+tc.getName()+"</td>"+"<td width=\"45%\">"+tr.getMethod().getMethodName().toString()+"</td>"+"<td width=\"5%\">"+"<img src=\"../ReportImages/pass.png\" alt=\"Test\" title=\"Passed\"/></td></tr>");
		 
	  }
	  	 
	  private void log(String string) {
		  try {
				fw1 = new FileWriter(f1.getAbsolutePath(),true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bw1= new BufferedWriter(fw1);
			
			try {
				bw1.write("<head><meta name=\"viewport\" http-equiv=\"refresh\"  content= \"20\"content=\"width=device-width, initial-scale=1.0\">");
				if(ListenEverything.l_count==0){
					
					bw1.write("<style>.label.failure, .label.fail { background-color: #f44336 !important;}.label.success, .label.pass { background-color: #7fbb00 !important;}.label { border-radius: 2px; font-size: 14px; padding: 1px 2px;text-transform: none;}.status.fail, .fail i {color: #fff;}.status.pass, .pass i {color: #fff;}#header {background-color:orange;color:black;clear:both;text-align:center;padding:5px;} #nav{height:30px;width:130px;float:left;position:fixed;padding:2px;}#section {width:100px;float:center;padding:10px;}#footer{background-color:black;color:white;clear:both;text-align:center;padding:5px;}table, td {border: 1px solid green;table-layout: fixed;width: 65%;}.top-banner-root {background-color: #0066ff;color: #fff;font-family: Times;height: 45px;left: 0;margin: 0 0 5px;padding: 5px;position: absolute;right: 0;text-align: center;top: 0;}.top-banner-title-font {font-size: 25px;} tr:nth-of-type(odd) {background-color:#eeeeee;}</style></head>");
					bw1.write("<img src=\"../ReportImages/Eperium.png\" align=\"left\" height=\"30\" width=\"100\" ><img src=\"../ReportImages/Eperium.png\" align=\"right\" height=\"30\" width=\"100\" >");
				    bw1.write("<div id=\"header\">Automation Test Report Overview </div>");
				    bw1.write("Execution Start Time:  "+t.format(d)+"&nbsp");
				    bw1.write("<div id=\"nav\"><span class=\"top-banner-font-1 status pass label\">Passed "+ListenEverything.p_count+" </span>");
				   // +"<span class=\"top-banner-font-1 status fail label\"> Failed </span>"+f_count+""
				    bw1.write("<span class=\"top-banner-font-1 status fail label\">Failed "+ListenEverything.f_count+" </span></div><br><br>");
				    bw1.write("<table align=\"center\" style=table-layout: fixed;\"width=70% margin: 0px auto;\"><th width=\"50%\">Scenario</th><th width=\"47%\">Test Steps</th><th></th>");
				    bw1.write("<div id=\"nav\"><button onclick=\"myFunction()\">Reload page</button><div><script>function myFunction(){window.location.reload();}</script><div>");
				    bw1.write("<div id=\"nav\"><form><input type=\"radio\" name=\"result\" value=\"Show All\" onclick=\"myFunction1()\" > Show All<br><input type=\"radio\" name=\"result\" value=\"Failed\" onclick=\"myFunction2()\"> Failed  </form> <div>");
				    bw1.write("<script>function myFunction2(){tr=document.querySelectorAll(\"tr\");for(i=1;i<tr.length;i++){fail=tr[i].getAttribute(\"class\");if(!fail){tr[i].style.display=\"none\";}}}function myFunction1(){tr=document.querySelectorAll(\"tr\");for(i=1;i<tr.length;i++){fail=tr[i].getAttribute(\"class\");if(!fail){tr[i].style.display=\"\";}}}</script>");
				   
				} ++ListenEverything.l_count;
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	    //System.out.print(string);
	    try {
			//bw1.write(string);
			
			//System.out.println("<script>document.querySelector(\".top-banner-font-1\").innerHTML=\"Passed "+p_count+ " Failed "+f_count+"\";</script>");
			//bw1.write("<script>document.querySelector(\".top-banner-font-1\").innerHTML=\"Passed "+p_count+ " Failed "+f_count+"\";</script>");
			
			//System.out.println("<script>document.querySelector(\".top-banner-font-1.status.pass.label\").innerHTML=\"Passed "+p_count+"\"</script>");
			bw1.write("<script>document.querySelector(\".top-banner-font-1.status.pass.label\").innerHTML=\"Passed "+ListenEverything.p_count+"\"</script><div>");
			bw1.write("<script>document.querySelector(\".top-banner-font-1.status.fail.label\").innerHTML=\"Failed "+ListenEverything.f_count+"\"</script><div>");
						
			bw1.write(string);
		//	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    if (++ListenEverything.m_count % 40 == 0) {
	      //System.out.println("");
	    }
	    try {
	    	bw1.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	  }
 
	 /* @Override
	  public void onFinish(ITestContext testContext){
		  l_count=0;
	  }*/

}
