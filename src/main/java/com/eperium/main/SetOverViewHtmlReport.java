package com.eperium.main;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class SetOverViewHtmlReport {
	
	Properties property= new Properties();
	File fin =new File("SuiteResults.properties");
	File f11;
	InputStream inStream;
	OutputStream out;
	/*DateFormat t1 = new SimpleDateFormat("dd-MM-yyyy");
	String d1= t1.format(new Date());*/
	String date1,date2,date3;
	String pass1,pass2,pass3;
	String fail1,fail2,fail3;
	String suites[];
	String colorsuite[];
	int size,p1,p2,p3,f1,f2,f3,d11,d22,d33;
	int tp1=0,tp2=0,tp3=0,tf1=0,tf2=0,tf3=0;
	float  _pPercent1,_pPercent2,_pPercent3,_cPercent1;
	String verdict,oVerdict;
	BufferedWriter bw;
	
	private void getSuiteData() throws IOException {
		
		inStream=new FileInputStream(fin);
		property.load(inStream);
		if(property.containsKey("suiteRun")){
		String suiteNames=property.getProperty("suiteRun");
		suites=suiteNames.split("@");
		size=suites.length;
		System.out.println(size+"eee");
		f11=new File("OverviewReport/Overview.html");//_"+d1+"
		bw = new BufferedWriter(new FileWriter(f11));
		
		
		bw.write("<html><head><style>table, th, td {    border: 1px cadetblue;}th {    padding: 1px; font-family:calibri;   text-align: left;} td {    padding: 1px; font-family:calibri;   text-align: center;}table#t01{    width: 50%;        background-color: #ffffff;}table#t02{    width: 50%;        background-color: #ffffff;}.foo { width: 20px;  height: 20px;  display: table-cell;}.green1 {  background: #DAF7A6;}.green2 {  background: #81F796;}.wine1{  background: #FAC9BA;}.wine2 {  background: #FA99A3;}</style></style></head><body>");
		bw.write("Hi,<br><br>Automation suite execution is complete now. Please find the overall automation suite report below.<br><br>");
		
		/*bw.write("<br><div><div class=\"foo green1\"></div><span style=\"font-size: smaller; display: table-cell;\">&nbsp;>= 70% Passed &nbsp;&nbsp;</span> <div class=\"foo green2\"></div><span style=\"font-size: smaller; display: table-cell;\">&nbsp;>=90% Passed &nbsp; &nbsp;</span>");
		bw.write("<div class=\"foo wine1\"></div><span style=\"font-size: smaller; display: table-cell;\">&nbsp;> 30% Failed &nbsp;&nbsp; </span> <div class=\"foo wine2\"></div><span style=\"font-size: smaller; display: table-cell;\">&nbsp;>= 50% Failed &nbsp;&nbsp;</span></div><br>");
		*/
		//bw.write("<table id=\"t01\"><tbody><tr><td style=\"background-color:#DAF7A6; color:white; text-align: center;\"><b> >= 70% Passed</b></td><td></td><td style=\"background-color:#81F796; color:white; text-align: center;\"><b> >= 90% Passed</b></td><td></td><td style=\"background-color:#FAC9BA; color:white; text-align: center;\"><b> >= 30% Failed</b></td><td></td><td style=\"background-color:#FA99A3; color:white; text-align: center;\"><b> >= 50% Failed</b></td></tr></tbody></table><br>");
		
		setAnalysisData();
		
	//	bw.write("<table id=\"t00\"><tr><td style=\"background-color:#9932CC; color:white; text-align: left;\"><b>QUALITY STATEMENT</b></td><td><b><span style=\"background-color:red \">Pathetic!</span></b></td></tr><tr><td style=\"background-color:#ECECEC ;text-align: left\"><b>ADDITIONAL REMARK</b></td><td><p>Recent build is <b>NOT</b> good, as failed tests are more than 30%.</p></td></tr></table>");
		bw.write("<br><br><table id=\"t01\"><tbody><tr><td style=\"background-color:#DAF7A6; color:white; text-align: center;\"><b> >= 70% Passed</b></td><td></td><td style=\"background-color:#81F796; color:white; text-align: center;\"><b> >= 90% Passed</b></td><td></td><td style=\"background-color:#FAC9BA; color:white; text-align: center;\"><b> >= 30% Failed</b></td><td></td><td style=\"background-color:#FA99A3; color:white; text-align: center;\"><b> >= 50% Failed</b></td></tr></tbody></table>");
		bw.write("<table id=\"t01\"><tr><td colspan=\"2\" style=\"background-color:#ECECEC;\"><b>Suite Details</b></td><td></td><td colspan=\"2\" style=\"background-color:#ECECEC;\" ><b>Recent Run</b></td><td></td><td colspan=\"2\" style=\"background-color:#ECECEC;\"><b>Last Run</b></td><td></td><td colspan=\"2\" style=\"background-color:#ECECEC;\"><b>Previous Run</b></td></tr>");
		//<table id=\"t01\">
		bw.write("<tr><th style=\"background-color:#ECECEC\">Suite Name</th><th style=\"background-color:#ECECEC\">Last 3 Execution Dates</th><td></td><td style=\"background-color:#A7CF87;\">Passed</td><td style=\"background-color:#CF9487;\">Failed</td><td></td><td style=\"background-color:#A7CF87;\">Passed</td><td style=\"background-color:#CF9487;\">Failed</td><td></td><td style=\"background-color:#A7CF87;\">Passed</td><td style=\"background-color:#CF9487;\">Failed</td></tr>");
		for (int i=0;i<size;i++){
		    setAllParameters(i);
		    
			bw.write("<tr><th  text-align:\"left\" style=\"background-color:"+colorsuite[i]+";\">"+suites[i]+"</th><td style=\"background-color:linen;text-align:left;\">"+date1+" <i><span style=\"color: darkgray;\">(Recent)</span></i><br>"+date2+" <i><span style=\"color: darkgray;\">(Last)</span></i><br>"+date3+"<i><span style=\"color: darkgray;\"> (Previous)</span></i></td><td></td><td style=\"background-color:linen;\">"+pass1+"</td><td style=\"background-color:linen;\">"+fail1+"</td><td></td><td style=\"background-color:linen;\">"+pass2+"</td><td style=\"background-color:linen;\">"+fail2+"</td><td></td><td style=\"background-color:linen;\">"+pass3+"</td><td style=\"background-color:linen;\">"+fail3+"</td></tr>");
			
		}
		bw.write("<tr><td style=\"background-color:#ECECEC;\"><b>Total:</b></td><td style=\"background-color:#ECECEC;\"> </td><td></td><td style=\"background-color:#ECECEC;\"><b>"+tp1+"</b></td><td style=\"background-color:#ECECEC;\"><b>"+tf1+"</b></td><td></td><td style=\"background-color:#ECECEC;\"><b>"+tp2+"</b></td><td style=\"background-color:#ECECEC;\"><b>"+tf2+"</b></td><td></td><td style=\"background-color:#ECECEC;\"><b>"+tp3+"</b></td><td style=\"background-color:#ECECEC;\"><b>"+tf3+"</b></td></tr></table></body></html>");
		bw.write("<br><br>Thanks <br>Testing Team");
		bw.flush();
		property.remove("suiteRun");
		try {
			out = new FileOutputStream( fin );
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			property.store(out, "");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
		

	}	



	private void setAnalysisData() throws IOException {
		//bw.write("<p><b>QUALITY STATEMENT</b></p>");
		  bw.write("<table id=\"t01\"><tr><td style=\"background-color:purple; color:white; text-align: left;\"><b>QUALITY STATEMENT</b></td>");
		  colorsuite=new String[size];
		for (int i=0;i<size;i++){
			
			setAllParameters(i);
			tp1= tp1+p1;tp2= tp2+p2;tp3= tp3+p3;tf1= tf1+f1;tf2= tf2+f2;tf3= tf3+f3;
			if((tp1+tf1)==0)
			{
				_pPercent1=(float)0;
			}else{
				_pPercent1= (((float)tp1)/(float)(tp1+tf1))*100;
			}
			if((tp2+tf2)==0)
			{
				_pPercent2=(float)0;
			}else{
				_pPercent2= (((float)tp2)/(float)(tp2+tf2))*100;
			}
			if((tp3+tf3)==0)
			{
				_pPercent3=(float)0;
			}else{
				_pPercent3= (((float)tp3)/(float)(tp3+tf3))*100;
			}
			
			
			
			if((p1+f1)>0){
			_cPercent1= (((float)p1)/(float)(p1+f1))*100;
			if(70<=_cPercent1 && _cPercent1<90){
				colorsuite[i]="#DAF7A6";
				
			}else if(90<=_cPercent1){
				colorsuite[i]="#81F796";
				
			}else if(50<_cPercent1 && _cPercent1<70){
				colorsuite[i]="#FAC9BA";
				
			}else if(50>=_cPercent1){
				colorsuite[i]="#FA99A3";
				
			}
			}
			for(String k:colorsuite){
				System.out.println("okokok"+k);
			}
			
			//bw.write("<p><b>"+suites[i]+": </b>");
			//float per = (Float.parseFloat(fail1)/(Float.parseFloat(fail1)+Float.parseFloat(pass1)))*100;
			/*p1=Integer.parseInt(pass1);p2=Integer.parseInt(pass2);p3=Integer.parseInt(pass3);
			f1=Integer.parseInt(fail1);f2=Integer.parseInt(fail2);f3=Integer.parseInt(fail3);*/
			//d11=Integer.parseInt(date1);d22=Integer.parseInt(date2);d33=Integer.parseInt(date3);
			//System.out.println("Failure percentage is"+per);
			
		}
		if(_pPercent1<=70)
		{
			
			if(50< _pPercent1 && _pPercent1 <=70)
			{
				oVerdict= "<p><span style=\"color: red;\"><b>SICK!</b> </span>More than 30% test cases failed.</span><p>";
			}else if (30< _pPercent1 && _pPercent1 <=50)
			{
				oVerdict= "<p><span style=\"color: red;\"><b>MISERABLE!</b> </span><span>More than 50% test cases failed.</span><p>";
			}else if(_pPercent1<=30)
			{
				oVerdict= "<p><span style=\"color: red;\"><b>PATHETIC!</b> </span>More than 70% test cases failed.</span><p>";
			}
			
			verdict= "Recent build is <b>NOT</b> good, as failed tests are more than 30%.";
			
			
		}
		if (_pPercent1 >= 70){
			/*System.out.println("Build is NOK, as failure percentage is more than 30%.");
			}
			else*/
			if(70<= _pPercent1 && _pPercent1 <80)
			{
				oVerdict= "<span style=\"color:green\"><b>Just Fine!</b> </span>More than 70% test cases passed.</span>";
			}else if (80<= _pPercent1 && _pPercent1 <90)
			{
				oVerdict= "<span style=\"color:green\"><b>Good!</b> </span>More than 80% test cases passed.</span>";
			}else if (90<= _pPercent1 && _pPercent1 <95)
			{
				oVerdict= "<p><span style=\"color:green\"><b>Excellent!</b> </span>More than 90% test cases passed.</span>";
			}
			else if (95<= _pPercent1 && _pPercent1 <100)
			{
				oVerdict= "<p><span style=\"color:green\"><b>Awesome!</b> </span>More than 95% test cases passed.</span>";
			} else if (_pPercent1==100)
			{
				oVerdict= "<p><span style=\"color:green\"><b>Top Quality!</b> </span>More than 70% test cases passed.</span>";
			}
			
			
			if (_pPercent1 > _pPercent2 && _pPercent1 > _pPercent3)
			{
				verdict= "This build is better than the previous two builds. Number of passed tests have increased.";
			}
			else if (_pPercent1 > _pPercent2 && _pPercent1 < _pPercent3)
			{
				verdict= "This build has improved than the last build but not good enough as compared to the previous build.";
			}
			else if (_pPercent1 < _pPercent2 && _pPercent1 > _pPercent3)
			{
				verdict= "This build is poorer than the last build.";
			}
			else if (_pPercent1 < _pPercent2 && _pPercent1 < _pPercent3)
			{
				verdict= "This build is poorer than the last 2 builds.";
			}
			else if (_pPercent1 == _pPercent2 && _pPercent1 == _pPercent3)
			{
				verdict= "This build is same as last 2 ones.";
			}
			else if (_pPercent1 == _pPercent2 && _pPercent1 != _pPercent3)
			{
				verdict= "This build is same as last build.";
			}
			 
			else if (_pPercent1 != _pPercent2 && _pPercent1 == _pPercent3)
			{
				verdict= "This build is same as previous build.";
			}
		}
		bw.write("<td style=\"background-color:#ECECEC; colspan=7; text-align: left;\"><p>"+oVerdict+"</p></td></tr>");
		
		bw.write("<tr><td style=\"background-color:#B6B6B6 ;text-align: left\"><b>Additional Remark</b></td><td style=\"background-color:#ECECEC; colspan=7; text-align: left;\"><p>"+verdict+"</p></td></tr></table>");//
		
		
		/*bw.write("<p>"+oVerdict+"</p>");
		bw.write("<p>"+verdict+"</p>");*/
			}
		
	private void setAllParameters(int i) {
			
				System.out.println(suites[i]);
				date1=property.getProperty(suites[i]+"_Run1_Dt");
				if(date1==null){
					date1= "<span>not run</span>";
				};
				date2=property.getProperty(suites[i]+"_Run2_Dt");
				if(date2==null){
					date2= "<span>not run</span>";
				};
				date3=property.getProperty(suites[i]+"_Run3_Dt");
				if(date3==null){
					date3= "<span>not run</span>";
				};
				
				pass1=property.getProperty(suites[i]+"_Run1_Pass");
				if(pass1==null){
					pass1= "<span>not run</span>";
					p1=0;
				}else p1=Integer.parseInt(pass1);
				pass2=property.getProperty(suites[i]+"_Run2_Pass");
				if(pass2==null){
					pass2= "<span>not run</span>";
					p2=0;
				}else p2=Integer.parseInt(pass2);
				pass3=property.getProperty(suites[i]+"_Run3_Pass");
				if(pass3==null){
					pass3= "<span>not run</span>";
					p3=0;
				}else p3=Integer.parseInt(pass3);
				fail1=property.getProperty(suites[i]+"_Run1_Fail");
				if(fail1==null){
					fail1= "<span>not run</span>";
					f1=0;
				}else f1=Integer.parseInt(fail1);
				fail2=property.getProperty(suites[i]+"_Run2_Fail");
				if(fail2==null){
					fail2= "<span>not run</span>";
					f2=0;
				}else f2=Integer.parseInt(fail2);
				fail3=property.getProperty(suites[i]+"_Run3_Fail");
				if(fail3==null){
					fail3= "<span>not run</span>";
					f3=0;
				}else f3=Integer.parseInt(fail3);
		
										

		}
		
	


	

	public static void main(String[] args) throws IOException {
		
         SetOverViewHtmlReport setHtml=new SetOverViewHtmlReport();
         setHtml.getSuiteData();
        // setHtml.setOverViewReport();
         		
	}

	

	

	

}
