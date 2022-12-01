package com.eperium.jumpstart.testframework.utils;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class ListenEverything implements ISuiteListener {

	public static int m_count;
	public static int l_count;
	public static int p_count;
	public static int f_count;
	
	
	
	@Override
	public void onStart(ISuite suite) {
		m_count=0;l_count=0;p_count=0;f_count=0;
		
	}

	@Override
	public void onFinish(ISuite suite) {
		
		
	}

}
