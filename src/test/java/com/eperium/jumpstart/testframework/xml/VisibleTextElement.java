package com.eperium.jumpstart.testframework.xml;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.SeleneseTestBase;

public class VisibleTextElement extends ValidateableXMLElement {
	public static final String NODE_NAME = "visibleTextElement";

	@Override
	public void validate(WebDriver driver, int timeout) 
	{
		try 
		{
			_validate(driver, timeout);
		} 
		catch (TimeoutException e) 
		{
			SeleneseTestBase.fail("Couldn't find visible element: " + getCheckedValue());
		}
	}

	@Override
	public void validateAfterClick(WebDriver driver, int timeout) {
		try {
			_validate(driver, timeout);
		} catch (TimeoutException e) {
			SeleneseTestBase.fail("Couldn't find visible element after click: " + getCheckedValue());
		}
	}

	private void _validate(WebDriver driver, int timeout) throws TimeoutException 
	{
		final String value = getCheckedValue();
		new WebDriverWait(driver, timeout).until(new ExpectedCondition<Boolean>() 
		{
			@Override
			public Boolean apply(WebDriver driver) 
			{
				return validateTextForElement(driver, value).isDisplayed();
			}
		});
	}
}
