package com.eperium.jumpstart.testframework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SetOverViewReport1 implements ISuiteListener {
	
	DateFormat t = new SimpleDateFormat("dd-MM-yyyy");
	String d= t.format(new Date());
	File file,file1,dirSuite;
	Properties prop =new Properties();
	InputStream in;
	OutputStream out;
	String suiteName;
	public static int _pass;
	public static int _fail;
	public static int _skip;
	public static int _count;
	
	@Override
	public void onStart(ISuite suite) {
		_pass=0;_fail=0;_skip=0;_count=0;
		suiteName=suite.getName();
		System.out.println(suiteName+" || "+d+" || "+_pass+" || "+_fail+" || "+_skip);
		file=new File("OverviewReport");
		dirSuite=new File("OverviewReport/"+suiteName);
		if (!file.exists()){
			file.mkdir();
			if(!dirSuite.exists()){
				dirSuite.mkdir();
			}
		}else if (!dirSuite.exists()){
			dirSuite.mkdir();
		}else {if(dirSuite.list().length>0){
			for(String _dDir:dirSuite.list()){
				new File(dirSuite+"/"+_dDir).delete();
			}
		}
			dirSuite.delete();
			dirSuite.mkdir();
		}
		
	}

	@Override
	public void onFinish(ISuite suite) {
	file1= new File("SuiteResults.properties");
		if (!file1.exists()){
			try {
				file1.createNewFile();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//else{
			try {
				in=new FileInputStream(file1);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				prop.load(in);
				//prop.clear();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			prop.setProperty(suiteName, d+" || "+_pass+" || "+_fail+" || "+_skip);
			//check if run3 details exists or not
			if(prop.containsKey(suiteName+"_Run3_Dt")){
				//copy Run2 values to Run3
				prop.setProperty(suiteName+"_Run3_Dt", prop.getProperty(suiteName+"_Run2_Dt"));
				prop.setProperty(suiteName+"_Run3_Pass", prop.getProperty(suiteName+"_Run2_Pass"));
				prop.setProperty(suiteName+"_Run3_Fail", prop.getProperty(suiteName+"_Run2_Fail"));
				
				//copy Run1 values to Run2
				prop.setProperty(suiteName+"_Run2_Dt", prop.getProperty(suiteName+"_Run1_Dt"));
				prop.setProperty(suiteName+"_Run2_Pass", prop.getProperty(suiteName+"_Run1_Pass"));
				prop.setProperty(suiteName+"_Run2_Fail", prop.getProperty(suiteName+"_Run1_Fail"));
				
				//set Run1 values
				prop.setProperty(suiteName+"_Run1_Dt", d);
				prop.setProperty(suiteName+"_Run1_Pass", String.valueOf(_pass));
				prop.setProperty(suiteName+"_Run1_Fail", String.valueOf(_fail));
				
				
			}else if(prop.containsKey(suiteName+"_Run2_Dt")) {
				//copy Run2 values to Run3
				prop.setProperty(suiteName+"_Run3_Dt", prop.getProperty(suiteName+"_Run2_Dt"));
				prop.setProperty(suiteName+"_Run3_Pass", prop.getProperty(suiteName+"_Run2_Pass"));
				prop.setProperty(suiteName+"_Run3_Fail", prop.getProperty(suiteName+"_Run2_Fail"));
				
				//copy Run1 values to Run2
				prop.setProperty(suiteName+"_Run2_Dt", prop.getProperty(suiteName+"_Run1_Dt"));
				prop.setProperty(suiteName+"_Run2_Pass", prop.getProperty(suiteName+"_Run1_Pass"));
				prop.setProperty(suiteName+"_Run2_Fail", prop.getProperty(suiteName+"_Run1_Fail"));
				
				//set Run1 values
				prop.setProperty(suiteName+"_Run1_Dt", d);
				prop.setProperty(suiteName+"_Run1_Pass", String.valueOf(_pass));
				prop.setProperty(suiteName+"_Run1_Fail", String.valueOf(_fail));
				
			}else if(prop.containsKey(suiteName+"_Run1_Dt")){
				//copy Run1 values to Run2
				prop.setProperty(suiteName+"_Run2_Dt", prop.getProperty(suiteName+"_Run1_Dt"));
				prop.setProperty(suiteName+"_Run2_Pass", prop.getProperty(suiteName+"_Run1_Pass"));
				prop.setProperty(suiteName+"_Run2_Fail", prop.getProperty(suiteName+"_Run1_Fail"));
				
				//set Run1 values
				prop.setProperty(suiteName+"_Run1_Dt", d);
				prop.setProperty(suiteName+"_Run1_Pass", String.valueOf(_pass));
				prop.setProperty(suiteName+"_Run1_Fail", String.valueOf(_fail));
				
			}else{
			prop.setProperty(suiteName+"_Run1_Dt", d);
			prop.setProperty(suiteName+"_Run1_Pass", String.valueOf(_pass));
			prop.setProperty(suiteName+"_Run1_Fail", String.valueOf(_fail));
			}
			if(prop.containsKey("suiteRun")){
				if(!prop.getProperty("suiteRun").contains(suiteName)){				
					prop.setProperty("suiteRun", prop.getProperty("suiteRun").concat("@")+suiteName);
				}
				
			}else prop.setProperty("suiteRun", suiteName);
			try {
				out = new FileOutputStream( file1 );
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 try {
				prop.store(out, "");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		//}
	}
}

