package com.eperium.jumpstart.testframework.xml;
 

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement
public class Module extends BasicXMLElements {
 
	private List <XMLMethod> xmlMethods;
	
	public List<XMLMethod> getXmlMethods() {
		return xmlMethods;
	}
	
	@XmlElement(name="method") 
	public void setXmlMethods(List<XMLMethod> xmlMethods) {
		this.xmlMethods = xmlMethods;;
	}
	
	
	
	}
 
