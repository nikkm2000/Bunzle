package com.eperium.jumpstart.testframework.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class MouseOver extends BasicXMLElements {
private List<Button> buttons;
	

	public List<Button> getButtons() {
		return buttons;
	}

	@XmlElement(name="button") 
	public void setButtons(List<Button> buttons) {
		this.buttons = buttons;
	}
}
