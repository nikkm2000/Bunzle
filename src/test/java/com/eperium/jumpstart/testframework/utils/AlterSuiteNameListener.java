package com.eperium.jumpstart.testframework.utils;

import java.util.List;

import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlSuite;

public class AlterSuiteNameListener implements IAlterSuiteListener {
	
	private String name="Default Testng TestSuite";

	@Override
	public void alter(List<XmlSuite> suites) {
		XmlSuite suite = suites.get(0);
		name= System.getProperty("suiteName");
		//suite.setName(getClass().getSimpleName());
		suite.setName(name);
	}

}
