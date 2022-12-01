package com.eperium.jumpstart.testframework.xml;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public abstract class ValidateableXMLElement extends BasicXMLElements {

	/**
	 * Method that determines if this element is valid within specified timeout.
	 * Each concrete implementation must specify its validation logic.
	 * 
	 * @param driver
	 * @param timeout
	 */
	public abstract void validate(WebDriver driver, int timeout);

	/**
	 * Method that determines if this element is valid within specified timeout
	 * after click. Each concrete implementation must specify its validation
	 * logic.
	 * 
	 * @param driver
	 * @param timeout
	 */
	public abstract void validateAfterClick(WebDriver driver, int timeout);

	/**
	 * Utility method to get processed element value
	 * 
	 * @return String
	 */
	protected String getCheckedValue() 
	{
		String value = getValue();
		if (value == null) 
		{
			value = getXmlValue();
		}
		if (value == null) 
		{
			// fallback value
			value = "";
		} else 
		{
			value = value.replace("&", "&amp;");
		}
		return value;
	}

	@Override
	public String toString() 
	{
		String id = getId();
		String val = getCheckedValue();
		return (id != null ? id : "") + "=" + val;
	}
	
	
	public WebElement validateTextForElement(WebDriver driver,String id)
	{
	 if (!driver.findElements(By.id(id)).isEmpty())	
	 {
		 return driver.findElement(By.id(id));
	 }
	 else if (!driver.findElements(By.name(id)).isEmpty())
	 {
		 return driver.findElement(By.name(id));
	 }
	 else if (!driver.findElements(By.linkText(id)).isEmpty())
	 {
		 return driver.findElement(By.linkText(id));
	 }
	 else if (!driver.findElements(By.xpath(id)).isEmpty())
	 {
		 return driver.findElement(By.xpath(id));
	 }
	 else if (!driver.findElements(By.partialLinkText(id)).isEmpty())
	 {
		 return driver.findElement(By.partialLinkText(id));
	 }
	 else if (!driver.findElements(By.className(id)).isEmpty())
	 {
		 return driver.findElement(By.className(id));
	 }
	 else try
	 { 
		 if (!driver.findElements(By.cssSelector(id)).isEmpty())
		 {
		 return driver.findElement(By.cssSelector(id));
		 } 
		 return null;
	 }
	 catch (InvalidSelectorException inSel)
	 {
		 Reporter.log("Locator for the cssSelector is invalid- Please check");
		 System.out.println("Locator for the cssSelector is invalid- Please check");
		 return null;
	 }
	}
	
}