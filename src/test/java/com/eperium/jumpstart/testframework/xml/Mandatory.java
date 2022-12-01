package com.eperium.jumpstart.testframework.xml;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

public class Mandatory extends ValidateableXMLElement {
	public static final String NODE_NAME = "Mandatory";

	@Override
	public void validate(WebDriver driver, int timeout) {
		String value = getCheckedValue();
		String id = getId();
		
		if(!id.isEmpty()){
		WebElement ele=validateTextForElement(driver,id);
		if(ele != null)
		{
			Assert.assertEquals(ele.getText(), value);
		}else
			Reporter.log("Could not find the element: locator is not correct");
			Assert.assertNotNull(ele,"Could not find the element: locator is not correct");
		}
		else if (driver.findElements(By.linkText(value)).size() > 0) {
			Assert.assertTrue(driver.findElement(By.linkText(value)).isDisplayed(), "Couldn't find mandatory text: " + value);
		} else {
			Assert.assertTrue(driver.getPageSource().toLowerCase().contains(value.toLowerCase()), "Couldn't find mandatory text: " + value);
		}

	}

	@Override
	public void validateAfterClick(WebDriver driver, int timeout) {
		String value = getCheckedValue();
		String id = getId();
		
		if(id!=null){
		WebElement ele=validateTextForElement(driver,id);
		if(ele != null)
		{
			Assert.assertEquals(ele.getText(), value);
		}else Assert.assertNotNull(ele,"Could not find the element: locator is not correct");
		}
		else if (driver.findElements(By.linkText(value)).size() > 0) {
			Assert.assertTrue(driver.findElement(By.linkText(value)).isDisplayed(), "Couldn't find mandatory text after click: " + value);
		} else {
			Assert.assertTrue(driver.getPageSource().toLowerCase().contains(value.toLowerCase()), "Couldn't find mandatory text after click: " + value);
		}

	}

}
