package com.eperium.jumpstart.testframework.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Elements  extends BasicXMLElements{
 private List<Element> element;
 

 public List<Element> getElement() {
  return element;
 }

 @XmlElement(name="element") 
 public void setElement(List<Element> element) {
  this.element = element;
 }
 
}