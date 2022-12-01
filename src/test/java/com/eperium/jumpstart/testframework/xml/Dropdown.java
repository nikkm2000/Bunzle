package com.eperium.jumpstart.testframework.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Dropdown extends BasicXMLElements{
	private List <Selected> selected;

	public List <Selected> getSelected() {
		return selected;
	}

	@XmlElement(name="selected")
	public void setSelected(List <Selected> selected) {
		this.selected = selected;
	}

}
