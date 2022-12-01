package com.eperium.jumpstart.testframework.xml;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.thoughtworks.selenium.SeleneseTestBase;

public class LoopMsg extends ValidateableXMLElement 
{
	public static final String NODE_NAME = "loopMsg";

	@Override
	public void validate(WebDriver driver, int timeout) 
	{
		try 
		{
			_validate(driver, timeout);
		} 
		catch (TimeoutException e) 
		{
			SeleneseTestBase.fail("Couldn't find loopMsg text: " + getCheckedValue());
		}
	}

	@Override
	public void validateAfterClick(WebDriver driver, int timeout) 
	{
		try 
		{
			_validate(driver, timeout);
		} 
		catch (TimeoutException e) 
		{
			SeleneseTestBase.fail("Couldn't find loopMsg text after click: " + getCheckedValue());
		}

	}

	private void _validate(WebDriver driver, int timeout) throws TimeoutException 
	{
		final String textToVerify = getCheckedValue();
        final String id = getId();        
       
        System.out.println("Loop Message Text " + textToVerify);
        System.out.println("Loop Message id " + id);
        
        if(id!=null)
        {
		
		/*final WebElement ele=validateTextForElement(driver,id);
		if(ele != null)
		{*/
		new WebDriverWait(driver, timeout).until(new ExpectedCondition<Boolean>() 
		{
			@Override
			public Boolean apply(WebDriver driver) 
			{
				System.out.println("Loop Message ID " + id);
			    final WebElement ele = validateTextForElement(driver,id);
			    
			    System.out.println("Final WebElement " + ele);
			    
			    if(ele != null)
			    {
			    	return ele.getText().toLowerCase().contains(textToVerify.toLowerCase());
			    }
			    else Assert.assertNotNull(ele,"Could not find the element: locator is not correct");
			       
			    return false;
			}
	
		});
        
		//}
		
	}else 
		new WebDriverWait(driver, timeout).until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return driver.getPageSource().toLowerCase().contains(textToVerify.toLowerCase());
			}
		});
        
        
	}
	
}