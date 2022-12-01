package com.eperium.jumpstart;
import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.regex.Pattern;

//import net.sourceforge.htmlunit.corejs.javascript.Context;


//import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

import com.eperium.jumpstart.testframework.utils.ReportUtil;

//@SuppressWarnings("deprecation")
public class JumpStartTestSuite extends Setup 
{
	//public static WebDriver driver = null;
	public static WebDriver driver1;

	public String AddressId;
	public String CostCenterName;

	DesiredCapabilities desiredCapabilities;
	FirefoxProfile firefoxProfile = null;
	public String str[] = new String[3];
	public String addressOnDashboard=null;
	public String str1[] = new String[10];
	private boolean x,y;
	public ArrayList<String>  al = new ArrayList<String>();
	public String temp[] = new String[4];
	public String custinfor[] = new String[11];		
	private WebElement availableTimeslot;
	private WebElement overlayElement;
	private WebElement overlayElement2;
	private WebElement overlayElement3;
	public String getvalue1;
	public String getvalue2;
	public String getvalue3;	
	public String getvalue4;
	public String getvalue6;
	public String getvalue7;
	public String getpdpskupdp;
	public String getpdpskuordertemplate;
	public String getOrderId;
	public String getPdpSalesUnit;	
	public String OrderTemp1_PdP_Sku_1;
	public String OrderTemp1_PdP_Sku_2;
	public String OrderTemp1_PdP_Sku_3;
	public String OrderTempName_1;
	public String OrderTempName_2;
	public String emailid;
	public int rannum;
	public String packInfo;
	private WebElement getvalue5;
	private String qSkuId=null;
	private boolean b;
	private ArrayList<String> browsedSku; 
	private ArrayList<String> skuIdCart;
	private int count1;
	private int count2;
	private int count3;
	private int count4;
	private String userIdToRevoke;
	private String userNameToRevokeId;
	private String solrPriceUuid;
	
	HashMap<String,String> cart;
	HashMap<String,String> cartPrice;
	HashMap<String,String> miniCart;

		
	@Test(description = "Launch Home Page")
	public void launchHomePage() throws InterruptedException 
	{
		moduleName = "homePageModule";
		methodName = "launchHomePage";
		channelLocator = "comChannel";		
		initialize(moduleName,methodName, channelLocator);
		
		driver.get(urlProp.getProperty("homePageURL"));
		
		if (browser.equals("*iexplore")) 
		{
			if (driver.getPageSource().contains("Continue to this website (not recommended)")) 
			{
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("javascript:document.getElementById('overridelink').click();");
				Thread.sleep(5000);
			} 
			else 
			{
				System.out.println("INFO :: Secure page not appear");
			}
		}
		
		driver.manage().window().maximize();		
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver,channelLocator);
	}
		
	@Test(description = "Add User")
	public void addUser() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "addUser";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		
		testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
		ReportUtil.captureScreenShot();
		
		Thread.sleep(5000);
		testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
		Thread.sleep(7000);
	}

	
	@Test(description = "Assign Address")
	public void assignAddressk() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "assignAddressk";
		channelLocator="specChannel";
        initialize(moduleName,methodName, channelLocator);
        
        testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
		Thread.sleep(3000);		
		driver.findElement(By.xpath("//*[@id='DeliveryAddressList']/div[3]/div[3]/div[1]/label")).click();
		Thread.sleep(3000);		
		driver.findElement(By.xpath("//*[@name='Assignselecteddeliveryaddress']")).click();
		Thread.sleep(3000);
	}
	
	
	@Test(description = "Assign Catalog")
	public void assignCatalogk() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "assignCatalogk";
		channelLocator="specChannel";
        initialize(moduleName,methodName, channelLocator);
        
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='CatalogSelectionList']//a")).click();
		Thread.sleep(3000);		
		driver.findElement(By.xpath("//*[@id='newUserAssignedCatalogs']//label")).click();
		Thread.sleep(2000);		
		driver.findElement(By.xpath("//*[@name='NewUserCatalogSubmit']")).click();
		
		Thread.sleep(5000);	
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	
	@Test(description = "Save User")
	public void saveUser() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "saveUser";
		channelLocator="specChannel";
        initialize(moduleName,methodName, channelLocator);
        
        testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);		
	}
	
	
	@Test(description = "Navigate to Add User page")
	public void navigateAddUserPage() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "navigateAddUserPage";
		channelLocator="comChannel";
        initialize(moduleName,methodName, channelLocator);
        
		driver.findElement(By.xpath(webElement.get("NavUserPage"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='button primary small']")).click();
		
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	
	@Test(description = "Browse category Brand")
	public void browseMakenCategory() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "browseMakenCategory";
		channelLocator="comChannel";
        initialize(moduleName,methodName, channelLocator);
        
        testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
	}
	
	
	@Test(description = "Navigate From Assortiment Category (Sub Category ...) To Lister Page")
	public void browseFromAssortimentCategoryToListerPage() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "browseFromAssortimentCategoryToListerPage";
		channelLocator = "comChannel";
        initialize(moduleName,methodName, channelLocator);
        
		testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
		
		while ( (driver.findElements(By.xpath(webElement.get("GirdView"))).size() != 0 ) && (driver.findElements(By.xpath(webElement.get("NavSubCategory"))).size() > 0) )
		{
			System.out.println("Test");	
			
			driver.findElement(By.xpath(webElement.get("NavSubCategory"))).click();
		}
		
		Thread.sleep(5000); 
		boolean x=true;
		if (driver.findElements(By.xpath("//*[@class='rwd-desktop right']")).size() == 0 )
		{
			System.out.println("Products Not Available in Sub-Catalog");
		 	Assert.assertTrue(x,"Products Not Available in Sub-Catalog"); 
		}
		else 
		{
			System.out.println("Products Available in Sub-Catalog");
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator); 
		}
	}
	
	
	@Test(description = "Verify Pagination")
	public void VerifyPagination() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "VerifyPagination";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		Thread.sleep(10000);
		int pdpValue = 0 ;
		driver.findElement(By.xpath(webElement.get("SearchTextBox"))).sendKeys("*");
		driver.findElement(By.xpath(webElement.get("SearchButtonClick"))).click();		
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(50,100)");
        
		pdpValue = (driver.findElements(By.xpath(webElement.get("GridViewPage2"))).size());
		
		if (pdpValue != 0 )
		{
			Thread.sleep(10000); 
			driver.findElement(By.xpath(webElement.get("GridViewPage2"))).click();
			JavascriptExecutor jsa = (JavascriptExecutor) driver;
	        jsa.executeScript("javascript:window.scrollBy(200,300)");				
			if (driver.findElements(By.xpath(webElement.get("GridViewPage1"))).size() > 0) 
			{
				testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
				Thread.sleep(5000); 
			}
		}	
		else 
		{				
	       	Assert.assertTrue(false, "Pagination Not Present In This SubCategory");	
		}
	}
	
	
	@Test(description = "Go To Second Page")
	public void GoToSecondPage() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "GoToSecondPage";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		Thread.sleep(10000);
		
		WebElement element = driver.findElement(By.xpath("(//*[@class='paging'])[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(5000); 		
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(50,-300)");	

		int pdpValue = 0 ;
		System.out.println("pdpValue = " + pdpValue);
		pdpValue = (driver.findElements(By.xpath(webElement.get("GridViewPage2"))).size());
		System.out.println("pdpValue = " + pdpValue);	
		System.out.println("pdpValue not found");
		if ( pdpValue != 0 )
		{
			Thread.sleep(10000); 
			//driver.findElement(By.xpath(webElement.get("GridViewPage2"))).click();
			Actions action = new Actions(driver);
	    	WebElement mainMenu = driver.findElement(By.xpath(webElement.get("GridViewPage2")));
	    	action.moveToElement(mainMenu).click().build().perform();
	    	
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("javascript:window.scrollBy(70,170)");
		}
	 }
	

	
	@Test(description = "Go To third Page")
	public void GoTothirdPage() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "GoTothirdPage";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
			Thread.sleep(10000);
			
			WebElement element = driver.findElement(By.xpath("(//*[@class='paging'])[1]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(5000); 		
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("javascript:window.scrollBy(50,-300)");
			
		int pdpValue = 0 ;
		System.out.println("pdpValue = " + pdpValue);
		pdpValue = (driver.findElements(By.xpath(webElement.get("GridViewPage3"))).size());
		System.out.println("pdpValue = " + pdpValue);	
		System.out.println("pdpValue not found");
		if ( pdpValue != 0 )
		{
			Thread.sleep(10000); 
			//driver.findElement(By.xpath(webElement.get("GridViewPage2"))).click();
			Actions action = new Actions(driver);
	    	WebElement mainMenu = driver.findElement(By.xpath(webElement.get("GridViewPage3")));
	    	action.moveToElement(mainMenu).click().build().perform();
	    	
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("javascript:window.scrollBy(70,170)");
		}
	 }
	
	
	@Test(description = "Go To Fourth Page")
	public void GoToFourthPage() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "GoToFourthPage";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
         Thread.sleep(10000);
		
		WebElement element = driver.findElement(By.xpath("(//*[@class='paging'])[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(5000); 		
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(50,-300)");	


		int pdpValue = 0 ;
		System.out.println("pdpValue = " + pdpValue);
		pdpValue = (driver.findElements(By.xpath(webElement.get("GridViewPage4"))).size());
		System.out.println("pdpValue = " + pdpValue);	
		System.out.println("pdpValue not found");
		if ( pdpValue != 0 )
		{
			Thread.sleep(10000); 
			//driver.findElement(By.xpath(webElement.get("GridViewPage2"))).click();
			Actions action = new Actions(driver);
	    	WebElement mainMenu = driver.findElement(By.xpath(webElement.get("GridViewPage4")));
	    	action.moveToElement(mainMenu).click().build().perform();
	    	
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("javascript:window.scrollBy(70,170)");
		}
	 }

	
	@Test(description = "Verify PDP Customer ")
	public void VerifyPDPCustomer() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "VerifyPDPCustomer";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		String pdpValue = "Test" ;
		int addToCartButtonDisplay = 0;	
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,-200)");
		
		count1 = driver.findElements(By.xpath("//*[@class='button right icon fa fa-th-list']")).size();
		System.out.println("TEST " + count1);
				
		Thread.sleep(10000);
		if (count1 != 0)
		{
			driver.findElement(By.xpath("//*[@class='button right icon fa fa-th-list']")).click();
			Thread.sleep(10000);	
		}
		
		System.out.println("OCI Web: " + webshop);
		
		if (webshop.contains("OCI"))
		{
			System.out.println("OCI " + webshop);
			count2 = driver.findElements(By.xpath("//*[@class='ish-product-image xl1']")).size();
			System.out.println("Image size is: " + count2);
			if (count2 != 0)
			{
				System.out.println("List view Click PDP " + webshop);
				driver.findElement(By.xpath(webElement.get("ClickPDP"))).click();
			}
			else
			{
				System.out.println("Grid View Click PDP1 " + webshop);
				driver.findElement(By.xpath(webElement.get("ClickPDP1"))).click();
			}
		}
		else
		{
			System.out.println("Not a OCI Webshop " + webshop);
			driver.findElement(By.xpath(webElement.get("ClickPDP"))).click();
		}			
	
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("javascript:window.scrollBy(100,200)");
        
        if (browser.contains("PhantomJS")) 
		{
			System.out.println("Browser is " + browser);
		}
		else
		{
			System.out.println("Browser is " + browser);
			
			pdpValue = driver.findElement(By.xpath(webElement.get("PricePDP"))).getText();
			addToCartButtonDisplay = driver.findElements(By.xpath(webElement.get("CartButtonPDP"))).size();
			try
			{
				if ( !pdpValue.isEmpty() && (addToCartButtonDisplay > 0 ))
				{
					System.out.println("pdp Value " + pdpValue);
					testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
				}	
			}
			catch (NoSuchElementException e)   
			{ 	
				throw new InterruptedException("Fail! PDP Verifcation Failed");		
			}
		}		
	}
	
	
	@Test(description = "Verify PDP Prospect Guest")
	public void VerifyPDPProspect() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "VerifyPDPProspect";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		String pdpValue = "Test" ;
		int addToCartButtonDisplay = 1;		
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,-300)");
		
		count1 = driver.findElements(By.xpath("//*[@class='button right icon fa fa-th-list']")).size();
		System.out.println("TEST " + count1);			
		
		Thread.sleep(10000);
		if (count1 != 0)
		{
			System.out.println("list view disabled " + webshop);
			driver.findElement(By.xpath("//*[@class='button right icon fa fa-th-list']")).click();
					
			Thread.sleep(10000);	
		}
		
		System.out.println("Webshop " + webshop);		
		driver.findElement(By.xpath(webElement.get("ClickPDP"))).click();
			
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("javascript:window.scrollBy(70,170)");
        
        if (browser.contains("PhantomJS")) 
		{
			System.out.println("Browser is " + browser);
		}
		else
		{
			System.out.println("Browser is " + browser);
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator); 
		}
	}	
	
	
	@Test(description = "Navigate To login page")
	public void goToLoginPage() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "goToLoginPage";
		channelLocator="comChannel";		
		initialize(moduleName, methodName,channelLocator);
		
		testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
		
		if (browser.equals("*iexplore")) 
		{
			if (driver.getPageSource().contains("Continue to this website (not recommended)"))
			{
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("javascript:document.getElementById('overridelink').click();");
				Thread.sleep(3000);
			} 
			else 
			{
				System.out.println("INFO :: Secure page not appear");
			}
		}
	}	
	
	
	@Test(description = "Navigate To PDP")
	public void openPDP() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "openPDP";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		driver.get(urlProp.getProperty("pdpPageUrl"));
		if (browser.equals("*iexplore")) 
		{
			if (driver.getPageSource().contains("Continue to this website (not recommended)")) 
			{
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("javascript:document.getElementById('overridelink').click();");
				Thread.sleep(3000);
			} 
			else 
			{
				System.out.println("INFO :: Secure page not appear");
			}
		}
		
		driver.manage().window().maximize();
		al.add(driver.findElement(By.xpath("//*[@id='main']/div/div/div/div/div/div/div[1]")).getText());
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}	
	

	@Test(description = "Goto Saved Address Page")
	public void gotoSavedAddressPage() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "gotoSavedAddressPage";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		driver.findElement(By.xpath("//*[@id='main']/div[3]/aside/nav[1]/div[2]/ul[3]/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@class='right kor-cancel kor-update-address']")).click();
		
		if (browser.equals("*iexplore"))
		{
			if (driver.getPageSource().contains("Continue to this website (not recommended)")) 
			{
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("javascript:document.getElementById('overridelink').click();");
				Thread.sleep(3000);
			} 
			else 
			{
				System.out.println("INFO :: Secure page not appear");
			}
		}
		
		//driver.manage().window().maximize();
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	 }	
	
	
	 @Test(description = "Edit Address Details And Add Cost Center")
	 public void editAddressDetailsAndAddCostCenter() throws InterruptedException 
	 {
		moduleName = "siteNavigationModule";
		methodName = "editAddressDetailsAndAddCostCenter";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@name='CostPlaceNew']")).click();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		String date1= dateFormat.format(date);
		CostCenterName = "Test " + date1;
		System.out.println(CostCenterName);
		
		driver.findElement(By.xpath("//*[@name='CostPlaceNew']")).sendKeys(CostCenterName);
		driver.findElement(By.xpath("//*[@class='add-costplace-in-edit-address button']")).click();
		driver.findElement(By.xpath("//*[@class='ish-button kor-submit kor-save-address']")).click();
		
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	 
	
	@Test(description = "Edit Address Details And Delete Cost Center")
	public void editAddressDetailsAndDeleteCostCenter() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "editAddressDetailsAndDeleteCostCenter";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='removeCostPlaces removeCostPlaces_1']")).click();
		driver.findElement(By.xpath("//*[@class='ish-button kor-submit kor-save-address']")).click();
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	
	@Test(description = "Delete All Cost Center")
	public void DeleteAllCostCenter() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "DeleteAllCostCenter";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		
		count1 = 0;
		count1 = driver.findElements(By.xpath("//*[@class='removeCostPlaces removeCostPlaces_1']")).size();
		for (count2=0;count2<count1;count2++) 
		{
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@class='removeCostPlaces removeCostPlaces_1']")).click(); 
		}
		
		Thread.sleep(3000);
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	
	@Test(description = "Validate Duplicate Cost Center Name")
	public void ValidateViaAddingDuplicateCostCenter() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "ValidateViaAddingDuplicateCostCenter";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		
		driver.findElement(By.xpath("//*[@name='CostPlaceNew']")).click();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		String date1= dateFormat.format(date);
		CostCenterName = "Test " + date1;
		System.out.println(CostCenterName);
		System.out.println("Satya Cost center name");
		
		driver.findElement(By.xpath("//*[@name='CostPlaceNew']")).sendKeys(CostCenterName);
		driver.findElement(By.xpath("//*[@class='add-costplace-in-edit-address button']")).click();	
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@name='CostPlaceNew']")).clear();
		driver.findElement(By.xpath("//*[@name='CostPlaceNew']")).click();
		driver.findElement(By.xpath("//*[@name='CostPlaceNew']")).sendKeys(CostCenterName);
		driver.findElement(By.xpath("//*[@class='add-costplace-in-edit-address button']")).click();
		
		Thread.sleep(3000);
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	
	@Test(description = "Change Cost Center")
	public void changeCostCenter() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "changeCostCenter";
		
		Thread.sleep(2000);
		Select selectByIndex = new Select(driver.findElement(By.xpath("//*[@class='costCenterSelectBox']")));
        selectByIndex.selectByIndex(1);
		ReportUtil.captureScreenShot();
	}
	
	
	@Test(description = "Prospect Sign In")
	public void loginProspect() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "loginProspect";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		
		Thread.sleep(10000);
		if (browser.contains("iexplore")) 
		{ // certificate issue in IE 7, 8 and 9
			if (driver.getPageSource().contains("Continue to this website")) 
			{
				driver.get("javascript:document.getElementById('overridelink').click();");
			}
		}
		
		testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
		driver.findElement(By.xpath(mLink.get("loginButton"))).click();
		Thread.sleep(3000); // Don't remove
		
		if (browser.contains("iexplore")) 
		{ // certificate issue in IE 7, 8 and 9
			if (driver.getPageSource().contains("Continue to this website")) 
			{
				driver.get("javascript:document.getElementById('overridelink').click();");
			}
		}
		// Fall back code, in case the provided password doesn't work then try an alternate password.
		if (driver.getPageSource().contains("De ingevoerde combinatie van gebruikersnaam en wachtwoord is niet juist. Probeer het nogmaals."))
		{
			driver.findElement(By.id("ShopLoginForm_Password")).clear();
			driver.findElement(By.id("ShopLoginForm_Password")).sendKeys("123456");
			driver.findElement(By.xpath(mLink.get("loginButton"))).click();
		}
		
		// Fall back code ends
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, "loginButton", driver, channelLocator);
	}
	

	@Test(description = "Customer Login")
	public void loginCustomer() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "loginCustomer";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		
		Thread.sleep(10000);
		if (browser.contains("iexplore")) 
		{ // certificate issue in IE 7, 8 and 9
			if (driver.getPageSource().contains("Continue to this website")) 
			{
				driver.get("javascript:document.getElementById('overridelink').click();");
			}
		}
		
		testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
		driver.findElement(By.xpath(mLink.get("loginButton"))).click();
		Thread.sleep(3000); // Don't remove
		
		if (browser.contains("iexplore")) 
		{ // certificate issue in IE 7, 8 and 9
			if (driver.getPageSource().contains("Continue to this website")) 
			{
				driver.get("javascript:document.getElementById('overridelink').click();");
			}
		}
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, "loginButton", driver, channelLocator);
	}
	

	@Test(description = "Browse Specials category")
	public void BrowseSpecialsCategory() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "BrowseSpecialsCategory";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
	}
	
	
	@Test(description = "Verify Login Mandatory Fields")
	public void verifyLoginPageBlankFields() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "verifyLoginPageBlankFields";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
	}
	
	
	@Test(description = "Verify invalid Username / Password")
	public void verifyInvalidPassword() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "verifyInvalidPassword";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
		testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
	}
	

	@Test(description = "Verify Prospect")
	public void verifyProspect() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "verifyProspect";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	
	@Test(description = "Verify Customer (Buyer/Approver/Account Admin)")
	public void verifyCustomer() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "verifyCustomer";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	

	@Test(description = "Logout")
	public void logout() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "logout";
		if (webshop.contains("MLN"))
		{
			channelLocator="specChannel";		
		}
		else if (webshop.contains("BFS"))
		{
			channelLocator="specChannel";	
		}
		else
		{
			channelLocator="comChannel"; 
		}
		
		initialize(moduleName,methodName, channelLocator);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(0,-300)");
		testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
	}
	
	
	@Test(description = "Navigate To Registration page")
	public void goToResistrationPage() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "goToResistrationPage";
		channelLocator="comChannel"; 
		initialize(moduleName,methodName, channelLocator);
		
		testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
		
		if (browser.equals("*iexplore")) 
		{
			if (driver.getPageSource().contains("Continue to this website (not recommended)")) 
			{
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("javascript:document.getElementById('overridelink').click();");
				Thread.sleep(5000);
			} 
			else 
			{
				System.out.println("INFO :: Secure page not appear");
			}
		}
		
		//driver.manage().window().maximize();
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}	
	

	@Test(description = "Navigate To Registration page")
	public void goToResistrationPage1() throws InterruptedException, AWTException 
	{
		moduleName = "siteNavigationModule";
		methodName = "goToResistrationPage1";
		channelLocator="comChannel"; 
		initialize(moduleName,methodName, channelLocator);		
		
		driver.navigate().refresh();				
		
		testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
		
		if (browser.equals("*iexplore")) 
		{
			if (driver.getPageSource().contains("Continue to this website (not recommended)")) 
			{
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("javascript:document.getElementById('overridelink').click();");
				Thread.sleep(5000);
			} 
			else 
			{
				System.out.println("INFO :: Secure page not appear");
			}
		}
		
		driver.manage().window().maximize();		
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	
	@Test(description = "Navigate To Registration page")
	public void goToResistrationPage2() throws InterruptedException, AWTException 
	{
		moduleName = "siteNavigationModule";
		methodName = "goToResistrationPage2";
		channelLocator="comChannel"; 
		initialize(moduleName,methodName, channelLocator);
				
//		WebElement element = driver.findElement(By.xpath("//*[@class='grid-14']/ul/li[3]/a"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//		Thread.sleep(5000); 
//		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("javascript:window.scrollBy(0, -150)");
		
		driver.navigate().refresh();
		
		testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
		
		if (browser.equals("*iexplore")) 
		{
			if (driver.getPageSource().contains("Continue to this website (not recommended)")) 
			{
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("javascript:document.getElementById('overridelink').click();");
				Thread.sleep(5000);
			} 
			else 
			{
				System.out.println("INFO :: Secure page not appear");
			}
		}
		
		//driver.manage().window().maximize();
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	
	@Test(description = "Navigate To Registration page")
	public void goToResistrationPage3() throws InterruptedException, AWTException 
	{
		moduleName = "siteNavigationModule";
		methodName = "goToResistrationPage3";
		if (webshop.contains("MLN"))
		channelLocator="comChannel"; 
		initialize(moduleName,methodName, channelLocator);
		
		driver.navigate().refresh();
		
		testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
		
		if (browser.equals("*iexplore")) 
		{
			if (driver.getPageSource().contains("Continue to this website (not recommended)")) 
			{
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("javascript:document.getElementById('overridelink').click();");
				Thread.sleep(5000);
			} 
			else 
			{
				System.out.println("INFO :: Secure page not appear");
			}
		}
		
		//driver.manage().window().maximize();
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}	
	
	
	@Test(description = "Navigate To Registration page")
	public void goToResistrationPage4() throws InterruptedException, AWTException 
	{
		moduleName = "siteNavigationModule";
		methodName = "goToResistrationPage4";
		channelLocator="comChannel"; 
		initialize(moduleName,methodName, channelLocator);
		
		driver.navigate().refresh();
		
		testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
		
		if (browser.equals("*iexplore")) 
		{
			if (driver.getPageSource().contains("Continue to this website (not recommended)")) 
			{
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("javascript:document.getElementById('overridelink').click();");
				Thread.sleep(5000);
			} 
			else 
			{
				System.out.println("INFO :: Secure page not appear");
			}
		}
		//driver.manage().window().maximize();
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	
	@Test(description = "Add Reference")
	public void addReference() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "addReference";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		Thread.sleep(5000);		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(300,400)");
		
		Thread.sleep(5000);		
		count1 = driver.findElements(By.xpath("//*[@id='orderReferenceId']")).size();
		System.out.println("TEST " + count1);			
		Thread.sleep(10000);
		if (count1 != 0)
		{
			driver.findElement(By.xpath("//*[@id='orderReferenceId']")).sendKeys("TestReference");
			Thread.sleep(10000);
		}			
			
		count2 = driver.findElements(By.xpath("//*[@id='yourName']")).size();
		System.out.println("TEST " + count2);			
		Thread.sleep(5000);
		if (count2 != 0)
		{
			driver.findElement(By.xpath("//*[@id='yourName']")).sendKeys("Your Name Test");
			Thread.sleep(10000);
		}
	}
	
	
	@Test(description = "Verify Registration Page Mandatory Fields")
	public void verifyRegistrationPageBlankFields() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "verifyRegistrationPageBlankFields";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);        
		Thread.sleep(1000);		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(300,1000)");
		
		Thread.sleep(2000);	
		driver.findElement(By.xpath(".//*[@id='submitBtnCreateAccount']")).click();
		testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
		
//		WebElement iFrame= driver.findElement(By.tagName("iframe"));
//		driver.switchTo().frame(iFrame);//
//		driver.findElement(By.cssSelector(".recaptcha-checkbox-checkmark")).click();		
//		driver.switchTo().defaultContent();	//		
//		Thread.sleep(2000);					
//		driver.findElement(By.xpath("//*[@id='recaptcha-checkbox-checkmark']")).click();			    
		
	}
	
	
	@Test(description = "Add Product To Cart From Quick View")
	public void addProducttoCartFromQuickView() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "addProducttoCartFromQuickView";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		Actions action = new Actions(driver);
		WebElement image = driver.findElement(By.xpath("//*[@class='ish-product-image']"));
		WebElement quickviewbutton = driver.findElement(By.xpath("//*[@id='main']/div[4]/div/div/div/div/ul/li[1]/div/div/span"));
		action.moveToElement(image).perform();
		action.click(quickviewbutton).perform();
		action.moveToElement(quickviewbutton).click().perform();
		System.out.println("Four");
		
		Thread.sleep(30000);		
		driver.findElement(By.xpath("//*[@name='addProduct']")).click();
		
		Thread.sleep(30000);		
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	
	@Test(description = "Close Pop up")
	public void closeQuickViewPopup() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "closeQuickViewPopup";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		driver.findElement(By.xpath("html/body/div[5]/div[1]/div/a")).click();
	}	
	

	@Test(description = "Navigate To PDP")
	public void navigateToPDP() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "navigateToPDP";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		driver.findElement(By.xpath("//*[@class='ish-product-image']")).click();
		if (browser.equals("*iexplore")) 
		{
			if (driver.getPageSource().contains("Continue to this website (not recommended)")) 
			{
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("javascript:document.getElementById('overridelink').click();");
				Thread.sleep(5000);
			} 
			else 
			{
				System.out.println("INFO :: Secure page not appear");
			}
		}
		
		//driver.manage().window().maximize();
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	
	@Test(description = "Registration Prospect")
	public void completeRegistration() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "completeRegistration";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		Random rn = new Random();
		rannum = rn.nextInt(1000000000) + 1;
		emailid= "test" + rannum + "@test.com" ;
		driver.findElement(By.xpath(webElement.get("EmailId"))).sendKeys(emailid);
		driver.findElement(By.xpath(webElement.get("Password1"))).sendKeys("Eperium123");
		driver.findElement(By.xpath(webElement.get("Password2"))).sendKeys("Eperium123");	
		driver.findElement(By.xpath(webElement.get("CompanyName"))).sendKeys("Test Company");
		driver.findElement(By.xpath(webElement.get("CompanyInformationForm_COC"))).sendKeys("COC Added");
		driver.findElement(By.xpath(webElement.get("CompanyInformationForm_BTW"))).sendKeys("BTW1234567");
		
		if (webshop.contains("BRS"))
		{
			driver.findElement(By.xpath("//*[@id='BRSCompanyInformationForm_IBANInfo']")).sendKeys("IBAN123456");		
		}
		
		Select gender = new Select(driver.findElement(By.xpath(webElement.get("Gender"))));
		gender.selectByIndex(2);
		driver.findElement(By.xpath(webElement.get("CompanyInformationForm_FirstName"))).sendKeys("Company First Name");
		driver.findElement(By.xpath(webElement.get("CompanyInformationForm_LastName"))).sendKeys("Company LastName");
		Select CompanyInformationForm_Function = new Select(driver.findElement(By.xpath(webElement.get("CompanyInformationForm_Function"))));
		CompanyInformationForm_Function.selectByIndex(2);
		driver.findElement(By.xpath(webElement.get("CompanyInformationForm_PhoneBusiness"))).sendKeys("1234567980");
		
		System.out.println("Channel/Application Name " + webshop);
		
		if (webshop.contains("King"))		
		{			
			Select industry = new Select(driver.findElement(By.xpath(webElement.get("KingCompanyInformationForm_Industry"))));
			industry.selectByIndex(1);
		}
		
		Select AddressForm_CountryCode = new Select(driver.findElement(By.xpath(webElement.get("AddressForm_CountryCode"))));
		AddressForm_CountryCode.selectByValue("NL");
		
		Thread.sleep(8000);
		driver.findElement(By.xpath(webElement.get("AddressForm_Address1"))).sendKeys("AddressForm_Address1");
		driver.findElement(By.xpath(webElement.get("AddressForm_PostalCode"))).sendKeys("1234567980");
		driver.findElement(By.xpath(webElement.get("AddressForm_City"))).sendKeys("AddressForm_City");
		Select AddressForm_State = new Select(driver.findElement(By.xpath(webElement.get("AddressForm_State"))));		
		AddressForm_State.selectByIndex(1);
		
		Thread.sleep(5000);
		
		WebElement iFrame= driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iFrame);
     	driver.findElement(By.cssSelector(".recaptcha-checkbox-border")).click();     		
		driver.switchTo().defaultContent();		
		Thread.sleep(2000);					
//		driver.findElement(By.xpath("//*[@id='recaptcha-checkbox-checkmark']")).click();
		Thread.sleep(5000);
		testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);	
		
		
		
		WebDriverWait wait= new WebDriverWait(driver, 30);
		if (webshop.contains("CLC"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'Logout')]")));			
		}
		else if (webshop.contains("MLN"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'Logout')]")));						
		}
		if (webshop.contains("MLN"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'Logout')]")));						
		}
		else
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'LogoutUser')]")));
		}
		
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}

	
	@Test(description = "Registration Mandatory Field Validation")
	public void mandatoryFieldValidation() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "mandatoryFieldValidation";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
		
		ReportUtil.captureScreenShot();
		Thread.sleep(8000);
		testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
	}
	
	
	@Test(description = "Registration - Password Less Then Six Characters")
	public void passwordLessThenSixCharacters() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "passwordLessThenSixCharacters";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		driver.findElement(By.xpath(webElement.get("EmailId"))).sendKeys("satya.prakash@eperiumindia.com");
		driver.findElement(By.xpath(webElement.get("Password1"))).sendKeys("Ep123");
		driver.findElement(By.xpath(webElement.get("Password2"))).sendKeys("Ep123");
		
		testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
		Thread.sleep(3000);
		testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
	}
	
	
	@Test(description = "Registration - Password Not Alpha Numeric")
	public void passwordNotAlphanuneric() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "passwordNotAlphanuneric";
		channelLocator="comChannel";
    	initialize(moduleName,methodName, channelLocator);
    	
    	driver.findElement(By.xpath(webElement.get("EmailId"))).sendKeys("satya.prakash@eperiumindia.com");
    	driver.findElement(By.xpath(webElement.get("Password1"))).sendKeys("eperium");
    	driver.findElement(By.xpath(webElement.get("Password2"))).sendKeys("eperium");
    	
    	testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
    	Thread.sleep(3000);
    	testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
	}

	
	@Test(description = "Registration - Password Not Uppercase Letter")
	public void passwordNotUppercaseLetter() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "passwordNotUppercaseLetter";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		driver.findElement(By.xpath(webElement.get("EmailId"))).sendKeys("satya.prakash@eperiumindia.com");
		driver.findElement(By.xpath(webElement.get("Password1"))).sendKeys("eperium123");
		driver.findElement(By.xpath(webElement.get("Password2"))).sendKeys("eperium123");
		
		testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
		Thread.sleep(3000);
		testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
	}
	
	
	@Test(description = "Registration - Password Not Uppercase Letter")
	public void passwordMismatch() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "passwordMismatch";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		driver.findElement(By.xpath(webElement.get("EmailId"))).sendKeys("satya.prakash@eperiumindia.com");
		driver.findElement(By.xpath(webElement.get("Password1"))).sendKeys("123456");
		driver.findElement(By.xpath(webElement.get("Password2"))).sendKeys("eperium123");
		
		testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
		Thread.sleep(3000);
		testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
	}	
	
	
	@Test(description = "Registration - Password Not Lower Case Letter")
	public void passwordNotLowerCaseLetter() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "passwordNotLowerCaseLetter";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		driver.findElement(By.xpath(webElement.get("EmailId"))).sendKeys("satya.prakash@eperiumindia.com");
		driver.findElement(By.xpath(webElement.get("Password1"))).sendKeys("EPERIUM123");
		driver.findElement(By.xpath(webElement.get("Password2"))).sendKeys("EPERIUM123");
		
		testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
		
		Thread.sleep(3000);
		testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
	}	
	
	
	//Following also BE-2159 scripts
	@Test(description = "Change Delivery Address")
	public void changeDeliveryAddress() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "changeDeliveryAddress";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		/*testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
		ReportUtil.captureScreenShot();*/
		//driver.findElement(By.id("ShippingAddressID")).click();
		/*Thread.sleep(3000);
		processElements(testCaseUtil, mLink, "click", moduleName, methodName, driver, channelLocator);
		*/
		
		driver.findElement(By.xpath("//select[@id='ShippingAddressID']/option[1]")).click();
		
		/*((JavascriptExecutor) driver).executeScript("return window.stop");
		//Thread.sleep(5000);
	
		Assert.assertTrue(driver.findElement(By.id("delivery-Address-Checkout")).isEnabled());*/
	}
	
	
	@Test(description = "Registration - Verify Existing Email ID")
	public void registrationEnterValuesAndVerifyForExistingEmailID() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "registrationEnterValuesAndVerifyForExistingEmailID";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		driver.findElement(By.xpath(webElement.get("EmailId"))).sendKeys("sprakash@salmon.com");
		driver.findElement(By.xpath(webElement.get("Password1"))).sendKeys("Eperium123");
		driver.findElement(By.xpath(webElement.get("Password2"))).sendKeys("Eperium123");	
		driver.findElement(By.xpath(webElement.get("CompanyName"))).sendKeys("Test Company");
		driver.findElement(By.xpath(webElement.get("CompanyInformationForm_COC"))).sendKeys("COC Added");
		driver.findElement(By.xpath(webElement.get("CompanyInformationForm_BTW"))).sendKeys("BTW1234567");
		
		if (webshop.contains("BRS"))
		{
			driver.findElement(By.xpath("//*[@id='BRSCompanyInformationForm_IBANInfo']")).sendKeys("IBAN123456");		
		}	
		
		Select gender = new Select(driver.findElement(By.xpath(webElement.get("Gender"))));
		gender.selectByIndex(2);
		driver.findElement(By.xpath(webElement.get("CompanyInformationForm_FirstName"))).sendKeys("Company First Name");
		driver.findElement(By.xpath(webElement.get("CompanyInformationForm_LastName"))).sendKeys("Company LastName");
		Select CompanyInformationForm_Function = new Select(driver.findElement(By.xpath(webElement.get("CompanyInformationForm_Function"))));
		CompanyInformationForm_Function.selectByIndex(2);
		driver.findElement(By.xpath(webElement.get("CompanyInformationForm_PhoneBusiness"))).sendKeys("1234567980");
		
		if (webshop.contains("King"))
		{
			Select industry = new Select(driver.findElement(By.xpath(webElement.get("KingCompanyInformationForm_Industry"))));
			industry.selectByIndex(1);
		}		
		
		Select addressFormCountryCode = new Select(driver.findElement(By.xpath(webElement.get("AddressForm_CountryCode"))));
		addressFormCountryCode.selectByValue("NL");
		Thread.sleep(8000);
		driver.findElement(By.xpath(webElement.get("AddressForm_Address1"))).sendKeys("AddressForm_Address1");
		driver.findElement(By.xpath(webElement.get("AddressForm_PostalCode"))).sendKeys("1234567980");
		driver.findElement(By.xpath(webElement.get("AddressForm_City"))).sendKeys("AddressForm_City");
		
		Select addressFormState = new Select(driver.findElement(By.xpath(webElement.get("AddressForm_State"))));
		addressFormState.selectByIndex(1);
		
		Thread.sleep(5000);
		testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);		
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	
	@Test(description = "Navigate To Bundeled PDP")
	public void navigateToBundledPDP() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "navigateToBundledPDP";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		driver.get(urlProp.getProperty("bundeledPDP"));
		
		if (browser.equals("*iexplore")) 
		{
			if (driver.getPageSource().contains("Continue to this website (not recommended)")) 
			{
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("javascript:document.getElementById('overridelink').click();");
				Thread.sleep(5000);
			} 
			else 
			{
				System.out.println("INFO :: Secure page not appear");
			}
		}
		
		//driver.manage().window().maximize();
		al.add(driver.findElement(By.xpath("//*[@id='main']/div/div/div/div/div/div/div[1]")).getText());
	    System.out.println("Contents of al: " + al);
	    
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}

	
	@Test(description = "Navigate To Sub Category")
	public void openProductListerPage() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "openProductListerPage";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		driver.get(urlProp.getProperty("navigateSubCategoryUrl"));
		Thread.sleep(3000);
		//driver.manage().window().maximize();
		
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	
	@Test(description = "Add Product To Cart From List View")
	public void addProductToCartFromSearchList() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "addProductToCartFromSearchList";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		driver.findElement(By.xpath("//*[@id='product-search-result']/div/div[6]/ul[1]/li/a[2]/div[3]/form/div[2]/button")).click();
		
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}

	
	@Test(description = "Add Product To Cart From List View")
	public void addProductCartFromList() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "addProductCartFromList";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		driver.findElement(By.xpath("//*[@id='main']/div[3]/div/ul[1]/li/a[2]/div[3]/form/div[2]/button")).click();
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	
	@Test(description = "Login Buyer")
	public void loginCustomerBuyer() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "loginCustomerBuyer";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		Thread.sleep(7000);
		if (browser.contains("iexplore")) { // certificate issue in IE 7, 8 and 9
			if (driver.getPageSource().contains("Continue to this website")) 
			{
				driver.get("javascript:document.getElementById('overridelink').click();");
			}
		}
		
		testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
		driver.findElement(By.xpath(mLink.get("loginButton"))).click();
		Thread.sleep(3000); // Don't remove
		
		if (browser.contains("iexplore")) { // certificate issue in IE 7, 8 and 9
			if (driver.getPageSource().contains("Continue to this website")) 
			{
				driver.get("javascript:document.getElementById('overridelink').click();");
			}
		}
		// Fall back code, in case the provided password doesn't work then try an alternate password.
		if (driver.getPageSource().contains("De ingevoerde combinatie van gebruikersnaam en wachtwoord is niet juist. Probeer het nogmaals."))
		{
			driver.findElement(By.id("ShopLoginForm_Password")).clear();
			driver.findElement(By.id("ShopLoginForm_Password")).sendKeys("123456");
			driver.findElement(By.xpath(mLink.get("loginButton"))).click();
		}
		// Fall back code ends
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, "loginButton", driver, channelLocator);
		Thread.sleep(3000); 
	}
	
	
	@Test(description = "Login Approver")
	public void loginCustomerApprover() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "loginCustomerApprover";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		Thread.sleep(10000);
		if (browser.contains("iexplore")) 
		{ // certificate issue in IE 7, 8 and 9
			if (driver.getPageSource().contains("Continue to this website")) 
			{
				driver.get("javascript:document.getElementById('overridelink').click();");
			}
		}
		
		testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
		driver.findElement(By.xpath(mLink.get("loginButton"))).click();
		Thread.sleep(3000); // Don't remove
		
		if (browser.contains("iexplore")) 
		{ // certificate issue in IE 7, 8 and 9
			if (driver.getPageSource().contains("Continue to this website")) 
			{
				driver.get("javascript:document.getElementById('overridelink').click();");
			}
		}
		
		// Fall back code, in case the provided password doesn't work then try an alternate password.
		if (driver.getPageSource().contains("De ingevoerde combinatie van gebruikersnaam en wachtwoord is niet juist. Probeer het nogmaals."))
		{
			driver.findElement(By.id("ShopLoginForm_Password")).clear();
			driver.findElement(By.id("ShopLoginForm_Password")).sendKeys("123456");
			driver.findElement(By.xpath(mLink.get("loginButton"))).click();
		}
		// Fall back code ends
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, "loginButton", driver, channelLocator);
	}
	
	
	@Test(description = "Login Account Admin")
	public void loginCustomerAccountAdmin() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "loginCustomerAccountAdmin";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		Thread.sleep(10000);
		if (browser.contains("iexplore")) 
		{ // certificate issue in IE 7, 8 and 9
			if (driver.getPageSource().contains("Continue to this website")) 
			{
				driver.get("javascript:document.getElementById('overridelink').click();");
			}
		}
		
		testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
		driver.findElement(By.xpath(mLink.get("loginButton"))).click();
		Thread.sleep(3000); // Don't remove
		
		if (browser.contains("iexplore")) 
		{ // certificate issue in IE 7, 8 and 9
			if (driver.getPageSource().contains("Continue to this website")) 
			{
				driver.get("javascript:document.getElementById('overridelink').click();");
			}
		}
		
		// Fall back code, in case the provided password doesn't work then try an alternate password.
		if (driver.getPageSource().contains("De ingevoerde combinatie van gebruikersnaam en wachtwoord is niet juist. Probeer het nogmaals."))
		{
			driver.findElement(By.id("ShopLoginForm_Password")).clear();
			driver.findElement(By.id("ShopLoginForm_Password")).sendKeys("123456");
			driver.findElement(By.xpath(mLink.get("loginButton"))).click();
		}
		
		// Fall back code ends
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, "loginButton", driver, channelLocator);
	}
	
	
	@Test(description = "Shopping Cart To Address Page")
	public void shoppingCartToAddressPage() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "shoppingCartToAddressPage";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		Thread.sleep(3000);		
		if (browser.contains("PhantomJS")) 
		{
			System.out.println("Phantomjs Browser");			
			
			Thread.sleep(5000);
			
			if (webshop.contains("MLN"))
			{
				System.out.println("MLN Webshop cart page " + webshop);
								
				Actions action = new Actions(driver);
				WebElement mainMenu = driver.findElement(By.xpath("//div[@class='ish-section grid-6 right']//button[@name='checkout']"));
				action.moveToElement(mainMenu).click().build().perform();
			}
			else
			{				
				Actions action = new Actions(driver);
				WebElement mainMenu = driver.findElement(By.xpath("//div[@class='ish-section grid-6 right']//button[1]"));
				action.moveToElement(mainMenu).click().build().perform();
			}
		}
		else
		{
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@class='fa fa-shopping-cart']")).click();
			
			Thread.sleep(5000);
			int temp2 = 0;
			temp2 = driver.findElements(By.xpath("//*[@class='label label_checkbox']")).size();
			System.out.println("Pitem Checkbox " + temp2);	
			if (temp2!= 0)
			{
				driver.findElement(By.xpath("//*[@class='label label_checkbox']")).click();
			}
			if (webshop.contains("DRDOCI"))
			{		
				count3 = driver.findElements(By.xpath("//*[@class='kor-content-contents']")).size();
				System.out.println("TEST-SATYA " + count3);			
				Thread.sleep(10000);
				if (count3 != 0)
				{
					Thread.sleep(4000);
					WebElement elem = driver.findElement(By.xpath("//*[@class='kor-overlay-close']"));
					int width = elem.getSize().getWidth();
					Actions act = new Actions(driver);
					act.moveToElement(elem).moveByOffset((width/2)-2, 0).click().perform();	
					
					Thread.sleep(4000);
					driver.findElement(By.xpath("//*[@class='link kor-minicart-group']")).click();
				}
				
				Actions action = new Actions(driver);
				WebElement mainMenu = driver.findElement(By.xpath("//*[@class='ish-section grid-6 right']//button[@class='ish-bar-actionButton']"));
				action.moveToElement(mainMenu).click().build().perform();
			}
			else if (webshop.contains("GLOOCI"))
			{				
				Actions action = new Actions(driver);
				WebElement mainMenu = driver.findElement(By.xpath("//*[@class='ish-section grid-6 right']//button[@class='ish-bar-actionButton']"));
				action.moveToElement(mainMenu).click().build().perform();
			}
			
			else if (webshop.contains("OCI"))
			{
				Actions action = new Actions(driver);
				WebElement mainMenu = driver.findElement(By.xpath("//*[@class='ish-section grid-6 right']//button[@class='ish-bar-actionButton']"));
				action.moveToElement(mainMenu).click().build().perform();
			}
			else if (webshop.contains("BDD"))
			{
				Actions action = new Actions(driver);
				WebElement mainMenu = driver.findElement(By.xpath("//*[@class='ish-section grid-6 right']//button[@class='ish-bar-actionButton']"));
				action.moveToElement(mainMenu).click().build().perform();
			}
			else
			{
				driver.findElement(By.xpath(webElement.get("ClickCheckOut"))).click();
				testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
			}
		}
	}

	
	@Test(description = "Address To Shipment Page")
	public void addressToShipmentPage() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "addressToShipmentPage";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		
		driver.findElement(By.xpath("//*[@id='delivery-Address-Checkout']")).click();
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	

	@Test(description = "Shipment To Payment Page")
	public void shipmentToPaymentPage() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "shipmentToPaymentPage";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		if (driver.findElements(By.xpath("//*[@class='ish-button ish-bar-actionButton kor-submit button-right']")).size() > 0)
		{
			driver.findElement(By.xpath("//*[@class='ish-button ish-bar-actionButton kor-submit button-right']")).click();
		}	
			
		driver.findElement(By.xpath("//*[@name='continue']")).click();
		
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}

	
	@Test(description = "Enter Reference Id And Name")
	public void enterRefIdAndName() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "enterRefIdAndName";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		

		Thread.sleep(5000);		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(300,400)");
		
		Thread.sleep(5000);		
		count1 = driver.findElements(By.xpath("//*[@id='orderReferenceId']")).size();
		System.out.println("TEST " + count1);			
		Thread.sleep(10000);
		if (count1 != 0)
		{
			driver.findElement(By.xpath("//*[@id='orderReferenceId']")).sendKeys("TestReference");
			Thread.sleep(10000);
		}			
			
		count2 = driver.findElements(By.xpath("//*[@id='yourName']")).size();
		System.out.println("TEST " + count2);			
		Thread.sleep(5000);
		if (count2 != 0)
		{
			driver.findElement(By.xpath("//*[@id='yourName']")).sendKeys("Your Name Test");
			Thread.sleep(10000);
		}
	}

	
	@Test(description = "Verify Mandatory Fields Reference Id And Name")
	public void verifyMandatoryFieldsRefIdAndName() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "verifyMandatoryFieldsRefIdAndName";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		driver.findElement(By.xpath("//*[@name='continue']")).click();
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	@Test(description = "Payment To Confirm Order Page")
	public void paymentToConfirmOrder() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "paymentToConfirmOrder";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		Thread.sleep(10000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(50,150)");	
		
		if (driver.findElements(By.xpath("//*[@class='ish-button ish-bar-actionButton kor-submit button-right']")).size() > 0)
		{
			driver.findElement(By.xpath("//*[@class='ish-button ish-bar-actionButton kor-submit button-right']")).click();
		}	
	
		Thread.sleep(10000);
		
		if (driver.findElements(By.xpath("//*[@class='ish-bar-actionButton button-right']")).size() > 0)
		{
			driver.findElement(By.xpath("//*[@class='ish-bar-actionButton button-right']")).click();
		}	
		
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
		
		Thread.sleep(10000);
	}
	
	@Test(description = "Payment To Confirm Order With Reference Text")
	public void paymentToConfirmOrderWithReference() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "paymentToConfirmOrderWithReference";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		driver.findElement(By.xpath("//*[@class='ish-button ish-bar-actionButton kor-submit button-right']")).click();
		Thread.sleep(5000);
		if (driver.findElements(By.xpath("//*[@class='ish-bar-actionButton button-right']")).size() > 0)
		{
			driver.findElement(By.xpath("//*[@class='ish-bar-actionButton button-right']")).click();
		}	
		
	}
	
	
	@Test(description = "Cart To Confirm Order Page")
	public void cartToReview() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "cartToReview";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		driver.findElement(By.xpath("//*[@id='cart-page']/button")).click();
		Thread.sleep(10000);	
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	
	@Test(description = "Print the cart")
	public void printCartPage() throws InterruptedException 
	{
		
		System.out.println("----------Print Cart Page");
		moduleName = "siteNavigationModule";
		methodName = "printCartPage";
		channelLocator="specChannel";
		System.out.println("----------Print Cart Page before initialise");
		initialize(moduleName,methodName, channelLocator);
		System.out.println("----------Print Cart Page after initialise");
		ReportUtil.captureScreenShot();
		driver.findElement(By.xpath(".//*[@id='main']/div[1]/div/h1/span[2]/a/i")).click();
		Thread.sleep(4000);
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
		
	}
	
	@Test(description = "Order Confirmation")
	public void orderConfirmation() throws InterruptedException
	{
		moduleName = "siteNavigationModule";
		methodName = "orderConfirmation";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		Thread.sleep(5000);	
		
		if (webshop.contains("OCI"))
        {				
			System.out.println("Webshop " + webshop);
			driver.findElement(By.xpath(".//*[@class='kor-submit place-order-btn-oci']")).click();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("javascript:window.scrollBy(0,-100)");
			
			count3 = driver.findElements(By.xpath("//*[@class='kor-noLabelErrorColor']")).size();
			System.out.println("TEST " + count3);			
			Thread.sleep(10000);
			if (count3 != 0)
			{
				WebElement elem = driver.findElement(By.xpath("//*[@class='kor-noLabelErrorColor']"));
				int width = elem.getSize().getWidth();
				Actions act = new Actions(driver);
				act.moveToElement(elem).moveByOffset((width/2)-2, 0).click().perform();	
			}
						
			driver.findElement(By.xpath(".//*[@class='kor-submit place-order-btn-oci']")).click();
			Thread.sleep(4000);
		}		
		else
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("javascript:window.scrollBy(300,400)");
			
			Thread.sleep(5000);		
			count1 = driver.findElements(By.xpath("//*[@id='orderReferenceId']")).size();
			System.out.println("TEST " + count1);			
			Thread.sleep(10000);
			if (count1 != 0)
			{
				driver.findElement(By.xpath("//*[@id='orderReferenceId']")).sendKeys("TestReference");
				Thread.sleep(10000);
			}			
				
			count2 = driver.findElements(By.xpath("//*[@id='yourName']")).size();
			System.out.println("TEST " + count2);			
			Thread.sleep(5000);
			if (count2 != 0)
			{
				driver.findElement(By.xpath("//*[@id='yourName']")).sendKeys("Your Name Test");
				Thread.sleep(10000);
			}
				
			count3 = driver.findElements(By.xpath("//*[@class='kor-noLabelErrorColor']")).size();
			System.out.println("TEST " + count3);			
			Thread.sleep(10000);
			if (count3 != 0)
			{
				WebElement elem = driver.findElement(By.xpath("//*[@class='kor-noLabelErrorColor']"));
				int width = elem.getSize().getWidth();
				Actions act = new Actions(driver);
				act.moveToElement(elem).moveByOffset((width/2)-2, 0).click().perform();	
			}
						
			driver.findElement(By.xpath(".//*[@class='kor-submit place-order-btn']")).click();
			Thread.sleep(4000);
		}
				
		
		if (webshop.contains("Kingoci-NL-Test"))
		{
			System.out.println("Kingoci " + webshop);
			
			String orgHookUrl = driver.getCurrentUrl();
			System.out.println("orgHookUrl " + orgHookUrl);
			
			Assert.assertTrue(orgHookUrl.contains(webElement.get("hookUrl")));
		}
		else if (webshop.contains("D_Care-NL-Test"))
		{
			System.out.println("D_Care " + webshop);
			
			String orgHookUrl = driver.getCurrentUrl();
			System.out.println("orgHookUrl " + orgHookUrl);
			
			Assert.assertTrue(orgHookUrl.contains(webElement.get("hookUrl")));
		}
		else if (webshop.contains("BVPOCI-DE-Test"))
		{
			System.out.println("BVPOCI " + webshop);

			String orgHookUrl = driver.getCurrentUrl();
			System.out.println("orgHookUrl " + orgHookUrl);
			
			Assert.assertTrue(orgHookUrl.contains(webElement.get("hookUrl")));
		}		
		else if (webshop.contains("BFSOCI-NL-Test"))
		{
			System.out.println("BFSOCI " + webshop);

			String orgHookUrl = driver.getCurrentUrl();
			System.out.println("orgHookUrl " + orgHookUrl);
			
			Assert.assertTrue(orgHookUrl.contains(webElement.get("hookUrl")));
		}
		else if (webshop.contains("OCI"))
		{
			System.out.println("OCI Shop is New Code " + webshop);
			String orgHookUrl = driver.getCurrentUrl();
			System.out.println("orgHookUrl: " + orgHookUrl);
			
			String orgHookUrl1 = webElement.get("hookUrl");
			System.out.println("orgHookUrl1: " + orgHookUrl1);
			
			Assert.assertTrue(orgHookUrl.contains(webElement.get("hookUrl")));		
		}
		else 
		{
			System.out.println("Not an OCI channel " + webshop);
			
			getOrderId = driver.findElement(By.xpath("//*[@class='ish-bigBar-mainLabelValue']")).getText();
			
			System.out.println("Order Id Value " + getOrderId );
			System.out.println("Product Sales Unit " + packInfo );
			
			//testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
		}	
	}
	
	
	@Test(description = "Order Confirmation With Merchant Message")
	public void orderConfirmationWithMerchantMessage() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "orderConfirmationWithMerchantMessage";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(400,500)");
		
		Thread.sleep(5000);
		
		if (driver.findElements(By.xpath("//*[@id='messageToMerchant']")).size() > 0)
		{	
			driver.findElement(By.xpath("//*[@id='messageToMerchant']")).sendKeys("Text Message To Merchant Thanks You!");		
			ReportUtil.captureScreenShot();		
		}		
		
		if (webshop.contains("DRDOCI"))
		{			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, -500);");
			System.out.println("DRDOCI Application");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@class='kor-submit place-order-btn-oci']")).click();
			Thread.sleep(4000);
		}
		else if (webshop.contains("GLOOCI"))
		{			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, -500);");
			System.out.println("GLOOCI Application");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@class='kor-submit place-order-btn-oci']")).click();
			Thread.sleep(4000);
		}
		else if (webshop.contains("MLN"))
		{			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, -300);");
			System.out.println("MLN Webshop");
			driver.findElement(By.xpath("//*[@class='kor-submit place-order-btn']")).click();
			Thread.sleep(4000);
		}
		else
		{	
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, -500);");
			driver.findElement(By.xpath("//*[@class='kor-submit place-order-btn']")).click();
			Thread.sleep(4000);
		}
		
		if(driver.findElements(By.xpath("//*[@class='kor-noLabelErrorColor']")).size() > 0)
		{
			WebElement elem = driver.findElement(By.xpath("//*[@class='kor-noLabelErrorColor']"));
			int width = elem.getSize().getWidth();
			Actions act = new Actions(driver);
			act.moveToElement(elem).moveByOffset((width/2)-2, 0).click().perform();
			Thread.sleep(4000);			
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, -500);");
			
			if (webshop.contains("DRDOCI"))
			{			
				System.out.println("DRDOCI Application+");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@class='kor-submit place-order-btn-oci']")).click();
				Thread.sleep(4000);
			}
			else if (webshop.contains("GLOOCI"))
			{			
				System.out.println("GLOOCI Application+");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@class='kor-submit place-order-btn-oci']")).click();
				Thread.sleep(4000);
			}
			else
			{
				driver.findElement(By.xpath("//*[@class='kor-submit place-order-btn']")).click();		    	
				Thread.sleep(4000);
			}
		}	
		if (webshop.contains("OCI"))
		{	
			System.out.println("OCI Shop: " + webshop);
			
			String orgHookUrl = driver.getCurrentUrl();
			System.out.println("orgHookUrl - " + orgHookUrl);
			
			Assert.assertTrue(orgHookUrl.contains(webElement.get("hookUrl")));
		}
		else
		{
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
		}		
	}
	
	
	@Test(description = "Search with * Search String")
	public void enterAndSearchStringSTAR() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "enterAndSearchStringSTAR";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,-100)");		
		
		Thread.sleep(5000);
		driver.findElement(By.xpath(webElement.get("SearchTextBox"))).sendKeys("*");
		Thread.sleep(5000);
		driver.findElement(By.xpath(webElement.get("SearchButtonClick"))).click();
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("javascript:window.scrollBy(70,170)");
		
		Thread.sleep(4000);
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
		Thread.sleep(7000);
	}
	
	
	@Test(description = "Sorting A To Z")
	public void sortAtoZ() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "sortAtoZ";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		Select dropdown = new Select(driver.findElement(By.name(webElement.get("SortDropDown"))));
		dropdown.selectByIndex(1);
	}
	
	
	@Test(description = "Left Navigation Panel - Filter")
	public void filter() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "filter";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
			
		Actions action = new Actions(driver);
	    WebElement mainMenu = driver.findElement(By.xpath(webElement.get("Filter")));
	    action.moveToElement(mainMenu).click().build().perform();

		Thread.sleep(2000);
	}
	
	
	@Test(description = "Search With Single Word Search String")
	public void enterAndSearchStringSingleWord() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "enterAndSearchStringSingleWord";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		
//		testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
//		Thread.sleep(2000);
//		testCaseUtil.processElements( mLink, "click", moduleName, methodName, driver, channelLocator);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,-100)");			
		Thread.sleep(5000);
		testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
		driver.findElement(By.xpath("//*[@class='primary small searchClick']")).click();
//		driver.findElement(By.xpath(mLink.get("searchButtonClick"))).click();
		Thread.sleep(3000);
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, "loginButton", driver, channelLocator);
		Thread.sleep(3000);	
		
	}
	
	//BRS-166	Ordering lifecycle status P items

	@Test(description = "Search With Single Word Search String")
	public void enterAndSearchPitem() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "enterAndSearchPitem";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		
//		testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
//		Thread.sleep(2000);
//		testCaseUtil.processElements( mLink, "click", moduleName, methodName, driver, channelLocator);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,-100)");			
		Thread.sleep(5000);
		testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
		driver.findElement(By.xpath(mLink.get("SearchButtonClick"))).click();
		Thread.sleep(3000);
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, "loginButton", driver, channelLocator);
		Thread.sleep(3000);	
		
	}
	
	
	@Test(description = "Search With Single Word Search String")
	public void enterAndSearchJitem() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "enterAndSearchJitem";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		
//		testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
//		Thread.sleep(2000);
//		testCaseUtil.processElements( mLink, "click", moduleName, methodName, driver, channelLocator);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,-100)");			
		Thread.sleep(5000);
		testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
		driver.findElement(By.xpath(mLink.get("SearchButtonClick"))).click();
		Thread.sleep(3000);
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, "loginButton", driver, channelLocator);
		Thread.sleep(3000);			
	}
	
	
	@Test(description = "Search With Double Word Search String")
	public void enterAndSearchStringDoubleWord() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "enterAndSearchStringDoubleWord";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
//		testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
//		Thread.sleep(2000);
//		testCaseUtil.processElements( mLink, "click", moduleName, methodName, driver, channelLocator);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,-100)");			
		Thread.sleep(5000);
		testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
		driver.findElement(By.xpath("//*[@class='primary small searchClick']")).click();
//		driver.findElement(By.xpath(mLink.get("SearchButtonClick"))).click();
		Thread.sleep(3000);
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, "loginButton", driver, channelLocator);
		Thread.sleep(3000);
		
		
	}
	
	
	@Test(description = "Search With Double Word With AND")
	public void enterAndSearchStringDoubleWordWithAnd() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "enterAndSearchStringDoubleWordWithAnd";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
//		testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
//		Thread.sleep(2000);
//		testCaseUtil.processElements( mLink, "click", moduleName, methodName, driver, channelLocator);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,-100)");			
		Thread.sleep(5000);
		testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
		driver.findElement(By.xpath("//*[@class='primary small searchClick']")).click();
//		driver.findElement(By.xpath(mLink.get("SearchButtonClick"))).click();
		Thread.sleep(3000);
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, "loginButton", driver, channelLocator);
		Thread.sleep(3000);
	}
	
	
	@Test(description = "Search With Invalid Search String")
	public void enterAndSearchStringNoProductFound() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "enterAndSearchStringNoProductFound";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
//		testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
//		Thread.sleep(2000);
//		testCaseUtil.processElements( mLink, "click", moduleName, methodName, driver, channelLocator);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,-100)");			
		Thread.sleep(5000);
		testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
		driver.findElement(By.xpath("//*[@class='primary small searchClick']")).click();
//		driver.findElement(By.xpath(mLink.get("SearchButtonClick"))).click();
		Thread.sleep(3000);
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, "loginButton", driver, channelLocator);
		Thread.sleep(3000);
	}
	
	
	@Test(description = "Search With Special Characters Search String")
	public void enterAndSearchStringSpecialCharacters() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "enterAndSearchStringSpecialCharacters";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
//		testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
//		Thread.sleep(2000);
//		testCaseUtil.processElements( mLink, "click", moduleName, methodName, driver, channelLocator);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,-100)");			
		Thread.sleep(5000);
		testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
		driver.findElement(By.xpath("//*[@class='primary small searchClick']")).click();
//		driver.findElement(By.xpath(mLink.get("SearchButtonClick"))).click();
		Thread.sleep(3000);
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, "loginButton", driver, channelLocator);
		Thread.sleep(3000);
	}
	
	
	@Test(description = "Grid View To List View")
	public void gridToListView() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "gridToListView";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		driver.findElement(By.xpath(webElement.get("ClickList"))).click();
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
		
	
	@Test(description = "Grid View To List View")
	public void listView() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "listView";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,-200)");
		
		count1 = driver.findElements(By.xpath("//*[@class='button right icon fa fa-th-list']")).size();
		System.out.println("TEST " + count1);		
		
		Thread.sleep(10000);
		if (count1 != 0)
		{
			driver.findElement(By.xpath("//*[@class='button right icon fa fa-th-list']")).click();
			Thread.sleep(10000);	
		}
        
		//driver.findElement(By.xpath("//*[@class='button right icon fa fa-th-list']")).click();
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}	
	
		
	@Test(description = "Save Order Template")
	public void saveOrderTemplate() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "saveOrderTemplate";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		Thread.sleep(3000);
		
		getpdpskupdp = driver.findElement(By.xpath("//*[@class='ish-productNumber-value']")).getText();
		

		if (browser.contains("PhantomJS")) 
		{
			System.out.println("Browser is ++" + browser);
			
			Actions action = new Actions(driver);
		   	WebElement mainMenu = driver.findElement(By.xpath("//*[@name='addToWishlistProduct']"));
		    action.moveToElement(mainMenu).click().build().perform();
			
			System.out.println("Browser is + on PDP" + browser);
		}
		else
		{
			driver.findElement(By.xpath("//*[@class='grid-4 kor-addToWishList-container']")).click();
		}		
		
		if (browser.contains("PhantomJS")) 
		{
			Thread.sleep(7000);
			
			System.out.println("Fav List Name pop up to be opened " + browser);			
		    
			driver.findElement(By.xpath("//*[@name='AddToWishlistForm_NewWishlistName']")).click();	
			driver.findElement(By.xpath("//*[@name='AddToWishlistForm_NewWishlistName']")).clear();		
			
			Random rn = new Random();
			rannum = rn.nextInt(1000000000) + 1;
			OrderTempName_1 = "Order_Template" + rannum ;
			System.out.println("Order Template Name " + OrderTempName_1);			
			driver.findElement(By.xpath("//*[@class='ish-input-xs']")).sendKeys(OrderTempName_1);
			
			driver.findElement(By.xpath("//*[@name='AddWishlistItem']")).click();
			System.out.println("Order Template Name + " + OrderTempName_1);
			
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@class='kor-overlay-close kor-control']")).click();
			ReportUtil.captureScreenShot();
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
		}
		else
		{
			Thread.sleep(7000);
			driver.findElement(By.xpath("//*[@name='AddToWishlistForm_NewWishlistName']")).click();	
			driver.findElement(By.xpath("//*[@name='AddToWishlistForm_NewWishlistName']")).clear();		
			Random rn = new Random();
			rannum = rn.nextInt(1000000000) + 1;
			OrderTempName_1 = "Order_Template" + rannum ;
			System.out.println("Order Template Name " + OrderTempName_1);	
			
			driver.findElement(By.xpath("//*[@name='AddToWishlistForm_NewWishlistName']")).sendKeys(OrderTempName_1);
			driver.findElement(By.xpath("//*[@name='AddWishlistItem']")).click();
			System.out.println("Order Template Name + " + OrderTempName_1);
			
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@class='kor-overlay-close kor-control']")).click();
			ReportUtil.captureScreenShot();
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
		}
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,-100)");	
	}

	
	@Test(description = "Save Order Template")
	public void saveOrderTemplate2() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "saveOrderTemplate2";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@class='grid-4 kor-addToWishList-container']")).click();
		
		Thread.sleep(5000);
		String OrderTemplate1 = "//*[contains(text(),'" + OrderTempName_1 + "')]";
		System.out.println("Order Template1 xpath " + OrderTemplate1);	
		
		count1 = driver.findElements(By.xpath("//*[@class='ish-field']")).size();
		System.out.println("Size Count " + count1);
		
		boolean TempSelectf = driver.findElement(By.xpath(OrderTemplate1)).isDisplayed();
		System.out.println("Template selection status " + TempSelectf);
		
		if (TempSelectf && (count1 < 3))
		{
			System.out.println("Template is selected");
			driver.findElement(By.xpath(OrderTemplate1)).click(); 
		}
		
		Thread.sleep(7000);
		driver.findElement(By.xpath("//*[@name='AddToWishlistForm_NewWishlistName']")).click();
		driver.findElement(By.xpath("//*[@name='AddToWishlistForm_NewWishlistName']")).clear();		
		Random rn = new Random();
		rannum = rn.nextInt(1000000000) + 1;
		OrderTempName_2 = "Order_Template" + rannum ;
		driver.findElement(By.xpath("//*[@name='AddToWishlistForm_NewWishlistName']")).sendKeys(OrderTempName_2);
		driver.findElement(By.xpath("//*[@name='AddWishlistItem']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='kor-overlay-close kor-control']")).click();
		ReportUtil.captureScreenShot();
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	
	@Test(description = "Add product to Order Template from Bundeled PDP")
	public void addProductToOrderTemplateFromPDPWithQTYTen() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "addProductToOrderTemplateFromPDPWithQTYTen";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		getAndUpdateProductQtyOnPdpPage(10);
		Thread.sleep(3000);		
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	
	@Test(description = "Save Order Template")
	public void saveOrderTemplateFromBundeledPDP() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "saveOrderTemplateFromBundeledPDP";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		Thread.sleep(3000);
		driver.findElement(By.xpath(mLink.get("wishlistNameTextbox"))).click();
		driver.findElement(By.xpath(mLink.get("wishlistNameTextbox"))).sendKeys("test2");
		driver.findElement(By.xpath(mLink.get("createWishlistBtn"))).click();
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, "createWishlistBtn", driver, channelLocator);
		ReportUtil.captureScreenShot();
		driver.findElement(By.xpath(mLink.get("wishlistOkBtn"))).click();
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, "wishlistOkBtn", driver, channelLocator);
	}

	
	@Test(description = "Add product to Order Template from Bundeled PDP")
	public void addProductToOrderTemplateFromCart() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "addProductToOrderTemplateFromCart";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
	}
	
	
	@Test(description = "Save Order Template")
	public void saveOrderTemplateFromCart() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "saveOrderTemplateFromCart";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@name='WishlistPropertiesForm_WishlistName']")).click();
		Random rn = new Random();
		rannum = rn.nextInt(1000000000) + 1;
		OrderTempName_1 = "Order_Template" + rannum ;
		driver.findElement(By.xpath("//*[@name='WishlistPropertiesForm_WishlistName']")).sendKeys(OrderTempName_1);
		driver.findElement(By.xpath("//*[@name='CreateWishlist']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='kor-overlay-close kor-control']")).click();	
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}

	
	@Test(description = "Add product to Order Template from PDP")
	public void addCartToOrderTemplate() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "addCartToOrderTemplate";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		testCaseUtil.processElements( mLink, "click", moduleName, methodName, driver, channelLocator);
	}

	
	@Test(description = "Save Order Template")
	public void saveOrderTemplateCart() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "saveOrderTemplateCart";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id='add-to-wishlist-form']/div/div[8]/input[2]")).click();
		driver.findElement(By.xpath("//*[@id='add-to-wishlist-form']/div/div/input[2]")).sendKeys("FromPDP");
		driver.findElement(By.xpath("//*[@name='AddWishlistItem']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='kor-overlay-close kor-control']")).click();		
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	
	@Test(description = "Add product to Order Template from PDP")
	public void addProductToOrderTemplateFromListView() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "addProductToOrderTemplateFromListView";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		count1 = driver.findElements(By.xpath("//*[@class='button right icon fa fa-th-list']")).size();
		System.out.println("List view status " + count1);		
		Thread.sleep(10000);
		if (count1 != 0)
		{
			System.out.println("List view is not enabled " + count1);
			driver.findElement(By.xpath("//*[@class='button right icon fa fa-th-list']")).click();
			
			count2 = driver.findElements(By.xpath("//*[@class='button right icon fa fa-th-list']")).size();
			System.out.println("List view is enabled " + count2);
			
			Thread.sleep(10000);	
		}
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("javascript:window.scrollBy(70,170)");
		
		testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
	}
	
	
	@Test(description = "Save Order Template")
	public void saveOrderTemplateFromListView() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "saveOrderTemplateFromListView";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@name='AddToWishlistForm_NewWishlistName']")).click();
		driver.findElement(By.xpath("//*[@name='AddToWishlistForm_NewWishlistName']")).clear();
		driver.findElement(By.xpath("//*[@name='AddToWishlistForm_NewWishlistName']")).sendKeys("Order Template From List View");
		driver.findElement(By.xpath("//*[@name='AddWishlistItem']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='kor-overlay-close kor-control']")).click();
		Thread.sleep(5000);
	}
	
	
	@Test(description = "Create New Blank Order Template")
	public void addBlankOrderTemplate() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "addBlankOrderTemplate";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='main']/div[3]/div/div[2]/div[2]/div/div[2]/a/span")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//*[@name='WishlistPropertiesForm_WishlistName']")).click();	
		Thread.sleep(5000);
		Random rn = new Random();
		rannum = rn.nextInt(1000000000) + 1;
		OrderTempName_1 = "Order_Template" + rannum ;
		driver.findElement(By.xpath("//*[@name='WishlistPropertiesForm_WishlistName']")).sendKeys(OrderTempName_1);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@name='CreateWishlist']")).click();
		Thread.sleep(5000);
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	
	@Test(description = "Search with * Search String")
	public void enterAndSearchStringSTAR1() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "enterAndSearchStringSTAR1";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,-100)");
		
		driver.findElement(By.xpath("//*[@id='searchTerm_Header']")).sendKeys("*");
		driver.findElement(By.xpath("//*[@class='primary small searchClick']")).click();
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("javascript:window.scrollBy(70,170)");
		
		Thread.sleep(4000);
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	
	@Test(description = "Search with * Search String")
	public void enterAndSearchStringSTAR2() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "enterAndSearchStringSTAR2";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		//driver.navigate().refresh();
	
		driver.findElement(By.xpath("//*[@id='searchTerm_Header']")).sendKeys("*");
		driver.findElement(By.xpath("//*[@class='primary small searchClick']")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(70,170)");
		
		Thread.sleep(4000);
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	
	@Test(description = "Search with * Search String")
	public void enterAndSearchStringSTAR3() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "enterAndSearchStringSTAR3";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		driver.findElement(By.xpath("//*[@id='searchTerm_Header']")).sendKeys("*");
		driver.findElement(By.xpath("//*[@class='primary small searchClick']")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(70,170)");
		
		Thread.sleep(4000);
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	
	@Test(description = "Navigate To PDP")
	public void navigateToPDP1() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "navigateToPDP1";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		driver.findElement(By.xpath("//*[@class='ish-product-image']")).click();
		if (browser.equals("*iexplore")) 
		{
			if (driver.getPageSource().contains("Continue to this website (not recommended)")) 
			{
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("javascript:document.getElementById('overridelink').click();");
				Thread.sleep(5000);
			} else 
			{
				System.out.println("INFO :: Secure page not appear");
			}
		}
		//driver.manage().window().maximize();
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}	
	
	
	@Test(description = "Get Packaging Information From PDP")
	public void getPackagingInfoFromPDP() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "getPackagingInfoFromPDP";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		System.out.println("Packinfo");
		
		packInfo = driver.findElement(By.xpath("//*[@id='variation_pdp_packaging_info']")).getText();
		System.out.println("Packaing info   " + packInfo);
		
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	

	@Test(description = "Verify Packaging Information On Cart Page")
	public void verifyPackagingInfoOnCartPage() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "verifyPackagingInfoOnCartPage";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		//packInfo = driver.findElement(By.xpath("//*[@id='main']/div[2]/div/div[1]/form/div[2]/div/table/tbody/tr[4]/td[1]")).getText();
		System.out.println("Packaing info   " + packInfo);
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	
	@Test(description = "Verify Packaging Information On Address Page")
	public void verifyPackagingInfoOnAddressPage() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "verifyPackagingInfoOnAddressPage";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		String packInfotemp = driver.findElement(By.xpath("//*[@id='main']/div[3]/div[1]/div/form/div[1]/div/table/tbody/tr[2]/td[2]/div/div[3]/span")).getText();
		String temp3[] = new String[3];
		temp3 = packInfotemp.split(" ");
		System.out.println("Str 3 length   "  + temp3.length);
		int temp = 0 ;
		temp = temp3.length;
		packInfotemp = temp3[temp-1];
		System.out.println(packInfotemp  + "  SatyaPass  "  + packInfo);	
		boolean x = false;
		
		if(packInfo.contains(packInfotemp))
		{
			x=true;
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
			System.out.println(packInfotemp  + "  SatyaPass");
		} 
		else 
		{
			ReportUtil.captureScreenShot();
			Assert.assertTrue(x,"Packaging Information Not found Correct on Address Page"); 
			System.out.println(  packInfotemp + "   SatyaFail");
		}
	}
	
	
	@Test(description = "Verify Packaging Information On Shipment Page")
	public void verifyPackagingInfoOnShipment() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "verifyPackagingInfoOnShipment";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		String packInfotemp = driver.findElement(By.xpath("//*[@class='ish-section-lastTable']/tbody/tr[2]/td[2]/div/div[3]/span")).getText();
		System.out.println(packInfotemp);
		
		String temp3[] = new String[3];
		temp3 = packInfotemp.split(" ");
		System.out.println("Str 3 length   "  + temp3.length);
		int temp = 0 ;
		temp = temp3.length;
		packInfotemp = temp3[temp-1];
		System.out.println(packInfotemp  + "  SatyaPass  "  + packInfo);	
		boolean x = false;
		
		if(packInfo.contains(packInfotemp))
		{
			x=true;
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
			System.out.println(packInfotemp  + "  SatyaPass");
		} 
		else 
		{
			ReportUtil.captureScreenShot();
			Assert.assertTrue(x,"Packaging Information Not found Correct on Shipment Page"); 
			System.out.println(  packInfotemp + "   SatyaFail");
		}
	}
	
	
	@Test(description = "Verify Packaging Information On Payment Page")
	public void verifyPackagingInfoOnPaymentPage() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "verifyPackagingInfoOnPaymentPage";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		packInfo = driver.findElement(By.xpath("//*[@id='main']/div[2]/div/div[1]/form/div[2]/div/table/tbody/tr[4]/td[1]")).getText();
		System.out.println("Packaing info   " + packInfo);
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	
	@Test(description = "Verify Packaging Information On Order Confirmation Page")
	public void verifyPackagingInfoOnOrderConfirmationPage() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "verifyPackagingInfoOnOrderConfirmationPage";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		packInfo = driver.findElement(By.xpath("//*[@id='main']/div[2]/div/div[1]/form/div[2]/div/table/tbody/tr[4]/td[1]")).getText();
		System.out.println("Packaing info   " + packInfo);
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	
	@Test(description = "Add Order Template From My Account")
	public void addOrderTemplateFromMyAccount() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "addOrderTemplateFromMyAccount";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		if (webshop.contains("BFS"))
		{
		    driver.findElement(By.xpath("//*[@class='fa fa-user']")).click();		    
		    driver.findElement(By.xpath("//*[@id='kor-infoBox-horizontalGroupRight']//button")).click();
		}
		else if (webshop.contains("BRS"))
		{
		    driver.findElement(By.xpath("//*[@id='container']//label/a")).click();
		    driver.findElement(By.xpath("//*[@id='kor-infoBox-horizontalGroupRight']//button")).click();
		}
		else if (webshop.contains("BDD"))
		{
			driver.findElement(By.xpath("//*[@class='fa fa-user']")).click();
		    driver.findElement(By.xpath("//*[@id='kor-infoBox-horizontalGroupRight']//button")).click();
		    
			int R = driver.findElements(By.xpath("//*[@class='kor-overlay kor-active-content']")).size();
			System.out.println("Order template delete overlay " + R);
			
		    if (R != 0)
		    {
		    	driver.findElement(By.xpath("//*[@class='kor-overlay-close']")).click();
		    }
		    
		    Thread.sleep(5000);	
		    
		    driver.findElement(By.xpath("//*[@class='fa fa-shopping-cart']")).click();
		}
		else
		{
			driver.findElement(By.xpath("//*[@id='kor-infoBox-horizontalGroupRight']//button")).click();			
		}		
		
		int i =0 ,j =0;
		boolean k= false;
		i = driver.findElements(By.xpath("//*[@class='ish-cartHeader']")).size();
		j = driver.findElements(By.xpath("//*[@class='ish-bar-actionButton']")).size();
		System.out.println("Satya i j k");
		System.out.println(i);
		System.out.println(j);
		System.out.println(k);
		if ( i >0  || j >0 )
		{
			k = true;
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator); 
		}
		else
		{
			Assert.assertTrue(k,"Incorrect Address Found"); 
		}  
	}
	

	@Test(description = "Navigate to My Account")
	public void navigatetoMyAccount() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "navigatetoMyAccount";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
	    
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,-300)");
		
		if (webshop.contains("GLOOCI"))
		{
			driver.findElement(By.xpath("//div[@class='loggedin-links']//a[contains(text(),'Mon compte')]")).click();
		}
		else if (webshop.contains("DRDOCI"))
		{
			driver.findElement(By.xpath("//a[contains(text(),'Mijn Account')]")).click();
		}
		else
		{
			testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
		}		
	}
	
	
	@Test(description = "Navigate to My Account Page Again")
	public void navigatetoMyAccount1() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "navigatetoMyAccount1";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,-300)");
		
		if (webshop.contains("GLOOCI"))
		{
			driver.findElement(By.xpath("//div[@class='loggedin-links']//a[contains(text(),'Mon compte')]")).click();
		}
		else if (webshop.contains("DRDOCI"))
		{
			driver.findElement(By.xpath("//a[contains(text(),'Mijn Account')]")).click();
		}
		else
		{
			testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
		}		
	}
	

	@Test(description = "Navigate To Order Template Detail Page")
	public void navigateToOrderTempateDetailPage() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "navigateToOrderTempateDetailPage";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		if (webshop.contains("OCI"))
		{
			driver.findElement(By.xpath("//*[@id='container']//label/a")).click();
		}
		else
		{
			
		driver.findElement(By.xpath("//a[@class='account-page-btn']")).click();
		}
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	
	@Test(description = "Navigate To Order Detail Page")
	public void navigateOrderDetailPage() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "navigateOrderDetailPage";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		//driver.findElement(By.xpath("//*[@class='ish-infoBox-content']/a")).click();
		driver.findElement(By.xpath("//*[@alt='Logo']")).click();
		Thread.sleep(2000);	
		driver.findElement(By.xpath("//*[@id='container']/header/div[4]/div[2]/ul/li[1]/label/a")).click();
		Thread.sleep(10000);	
		driver.findElement(By.xpath("//*[@id='main']/div[3]/aside/nav[1]/div[2]/ul[1]/li[3]/a")).click();
		Thread.sleep(10000);	
		driver.findElement(By.xpath("//*[@class='ish-itemLink ish-itemLinkSingle']")).click();
		Thread.sleep(3000);
		
		String tempPackUnit;
		tempPackUnit = driver.findElement(By.xpath("//*[@class='ish-productTable']//tbody/tr/td[3]")).getText();
		String temp3[];
		temp3 = tempPackUnit.split(" ");
		System.out.println("Str 3 length   "  + temp3.length);
		int temp = 0 ;
		temp = temp3.length;
		tempPackUnit = temp3[temp-1];		
		System.out.println(tempPackUnit  + "tempPackUnit");
		System.out.println(packInfo  + "packInfo");
		
		if (packInfo.contains(tempPackUnit))
		{
			System.out.println(tempPackUnit  + "  SatyaPass");	
			x=true;
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
		} 
		else 
		{
			System.out.println(tempPackUnit + "   SatyaFail");		
			ReportUtil.captureScreenShot();
			Assert.assertTrue(x,"Packaging Information Not found Correct on Order Detail Page"); 
		}
		
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	
	@Test(description = "Navigate To Order Template Detail Page")
	public void navigateToOrderTempateDetailPage2() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "navigateToOrderTempateDetailPage2";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		
		if (webshop.contains("OCI"))
		{
			System.out.println("OCI Application does not have this button.");
		}
		else
		{
			driver.findElement(By.xpath("//a[@class='account-page-btn']")).click();
		}		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='product-title-wrapper'][1]")).click();
		Thread.sleep(1000);		
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	
	@Test(description = "Add Order Template")
	public void addOrderTemplateFromDetailPage() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "addOrderTemplateFromDetailPage";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		int size=driver.findElements(By.xpath("//table//tr/td[1]/a")).size();
		for (int r=2;r<=size-1;r++)
		{
			String orderTemplateName=driver.findElement(By.xpath("//table//tr["+r+"]/td[1]/a")).getText();
			if (orderTemplateName.contains("["))
			{
				driver.findElement(By.xpath("//table//tr["+r+"]/td[5]/a")).click();
				break;
			}
		}
		
		int i =0 ,j =0;
		boolean k= false;
		i = driver.findElements(By.xpath("//*[@class='ish-productTable-cart']//tr/td/..")).size();
		j = driver.findElements(By.xpath("//*[@class='ish-bar-actionButton']")).size();
		
		if ( i >0  || j ==2 )
		{
			k = true;
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator); 
		}
	}
	
	
	@Test(description = "Add Blank Order Template To Blank Basket")
	public void addBlankOrderTemplateToBlankBasket() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "addBlankOrderTemplateToBlankBasket";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		Thread.sleep(3000);		

		int temp = driver.findElements(By.xpath("//*[@class='product-title']")).size();
		System.out.println("Satya template size " + temp);
		String objVal;
		for (int i=1; i<=temp; i++) 
		{
			String tempstr = driver.findElement(By.xpath("(//*[@class='product-title'])[" + (i) + "]")).getText();
			System.out.println("Satya template name " + tempstr);
			System.out.println("Satya template actual name " + OrderTempName_1);
			objVal = "(//*[@class='product-title'])[" + (i) + "]";
			System.out.println("Satya objvalue " + objVal);
			if (tempstr.contains(OrderTempName_1))
			{
				driver.findElement(By.xpath(objVal)).click();
				break;
			}
		}
		Thread.sleep(5000);	
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	
	@Test(description = "Open Order Template Detail Page And Verify Product")
	public void OrderTemplateDetailPage() throws InterruptedException {
		moduleName = "siteNavigationModule";
		methodName = "OrderTemplateDetailPage";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		Thread.sleep(3000);		

		int temp = driver.findElements(By.xpath("//*[@class='product-title']")).size();
		System.out.println("Satya template size " + temp);
		
		System.out.println("Satya template actual name " + OrderTempName_1);
		
		for (int i=1; i<=temp; i++) 
		{
			String tempstr = driver.findElement(By.xpath("(//*[@class='product-title'])[" + i + "]")).getText();
			System.out.println("Satya template name " + tempstr);
			
			if (tempstr.contains(OrderTempName_1))
			{
				driver.findElement(By.xpath("(//*[@class='product-title'])[" + i + "]")).click();
				System.out.println("Template detail page " + tempstr);
				break;
			}
			
		}
				
		Thread.sleep(5000);	
		String tempstr2 = driver.findElement(By.xpath("//span[@class='ish-itemNumber']")).getText();
		System.out.println("Satya Product SKU on Order Template " + tempstr2);
		
		System.out.println("Satya Product SKU on PDP" + getvalue1);
		
		if (browser.contains("PhantomJS")) 
		{
			System.out.println("Phantomjs Browser - on Order detail page");
		}
		else
		{
			if (tempstr2.contains(getvalue1))
			{
				testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
			}
			else 
			{
				throw new InterruptedException("Fail! To add product in Order Template");
			}
		}
		
	}
	
	
	@Test(description = "Add Product To Cart From Lister")
	public void addProductToCartFromLister() throws InterruptedException {
		moduleName = "siteNavigationModule";
		methodName = "addProductToCartFromLister";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		getvalue1 = null;
		getvalue2 = null;
//		getvalue3 = null;
//		getvalue4 = null;
		System.out.println("First");	
		try{
			getvalue1 = driver.findElement(By.xpath("//*[@id='main']/div[3]/div/ul[1]/li/a[2]/div[2]/div[3]/div[2]")).getText();
			System.out.println(getvalue1);
			driver.findElement(By.xpath("//*[@id='main']/div[3]/div/ul[1]/li/a[2]/div[3]/form/div[2]/button")).click();
			getvalue2 = driver.findElement(By.xpath("//*[@id='main']/div[2]/div/div[1]/form/div[2]/div/table/tbody/tr[2]/td[3]/div/div[3]/span")).getText();
//			System.out.println(getvalue2);
//			getvalue3 = driver.findElement(By.xpath("//*[@id='main']/div[2]/div/div[1]/form/div[2]/div/table/tbody/tr[3]/td[3]/div/div[3]/span")).getText();
//			System.out.println(getvalue3);
//			getvalue4 = driver.findElement(By.xpath("//*[@id='main']/div[2]/div/div[1]/form/div[2]/div/table/tbody/tr[4]/td[3]/div/div[3]/span")).getText();			
//			System.out.println(getvalue4);
			}catch (NoSuchElementException e) {
			}	
			if ((getvalue2.contains(getvalue1)) ) // || (getvalue3.contains(getvalue1)) || (getvalue4.contains(getvalue1)) )
				{
					testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
				} 
				else 
					{
						throw new InterruptedException("Fail! Add to Cart");
					}	
	}
	
	@Test(description = "Open Quick Order Page")
	public void openQuickOrderPage() throws InterruptedException {
		moduleName = "siteNavigationModule";
		methodName = "openQuickOrderPage";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		driver.get(urlProp.getProperty("quickOrderPageUrl"));
		if (browser.equals("*iexplore")) {
			if (driver.getPageSource().contains("Continue to this website (not recommended)")) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("javascript:document.getElementById('overridelink').click();");
				Thread.sleep(5000);
			} else {
				System.out.println("INFO :: Secure page not appear");
			}
		}
		//driver.manage().window().maximize();
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
		
	}
	
	
	
	@Test(description = "Enter PDP Sku And Price")
	public void enterPDPSkuAndPrice() throws InterruptedException {
		moduleName = "siteNavigationModule";
		methodName = "enterPDPSkuAndPrice";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		driver.findElement(By.xpath("//*[@name='SKU_1']")).sendKeys("10050");		
		driver.findElement(By.xpath("//*[@name='Quantity_1']")).sendKeys("12");
//		driver.findElement(By.xpath("//*[@name='SKU_2']")).sendKeys("30947V");		
//		driver.findElement(By.xpath("//*[@name='Quantity_2']")).sendKeys("44");
		driver.findElement(By.xpath("//*[@name='addToCart']")).click();
		Thread.sleep(5000);
		if (browser.equals("*iexplore")) {
			if (driver.getPageSource().contains("Continue to this website (not recommended)")) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("javascript:document.getElementById('overridelink').click();");
				Thread.sleep(5000);
			} else {
				System.out.println("INFO :: Secure page not appear");
			}
		}
		//driver.manage().window().maximize();
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	
	@Test(description = "Add Product To Cart From PDP")
	public void addProducttoCartFromPDP() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "addProducttoCartFromPDP";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		getvalue1 = null;
		getvalue2 = null;
		getvalue3 = null;
		getvalue4 = null;
      

		if (browser.contains("PhantomJS")) 
		{
			System.out.println("Phantomjs Browser");			
			String getvalue1 = driver.findElement(By.xpath("//*[@class='ish-productNumber-value']")).getText();
			System.out.println("Satya Product SKU on PDP" + getvalue1);
		}
		else
		{
			Thread.sleep(10000);
			getvalue1 = driver.findElement(By.xpath("//*[@class='ish-productNumber-value']")).getText();
			System.out.println("Product SKU first PDP " + getvalue1);
		}
		
		try
		{
			Thread.sleep(5000);
			int temp = 0;
			temp = driver.findElements(By.xpath("//*[@class='header-expressShop']")).size();
			System.out.println("1st Overlay pop up " + temp);	
			if (temp!= 0)
			{
				getvalue1 = driver.findElement(By.xpath("html/body/div[5]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/span[2]")).getText();			
				System.out.println("Product SKU on Overlay " + getvalue1);
								
				driver.findElement(By.xpath("html/body/div[5]/div[2]/div/div/div/div[1]/div[2]/div/form/div[3]/button")).click();
				
				Thread.sleep(5000);
				int temp1 = 0;
				temp1 = driver.findElements(By.xpath("//*[@class='kor-expressshop-title']")).size();
				System.out.println("2nd Overlay pop up " + temp1);	
				if (temp1!= 0)
				{
					driver.findElement(By.xpath("//*[@class='ish-button ish-bar-actionButton show-spinner']")).click();	
					
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@class='link kor-minicart-group']")).click();
					getvalue2 = driver.findElement(By.xpath("(//span[@class='ish-itemNumber'])[1]")).getText();
				}
				else
				{
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@class='link kor-minicart-group']")).click();
					getvalue2 = driver.findElement(By.xpath("(//span[@class='ish-itemNumber'])[1]")).getText();
					Thread.sleep(5000);
				}
			}
			else
			{	
				if (browser.contains("PhantomJS")) 
				{
					System.out.println("Phantomjs Browser");
					
					if (webshop.contains("MLN"))
					{
						System.out.println("MLN Webshop " + webshop);
						
						Actions action = new Actions(driver);
					   	WebElement mainMenu = driver.findElement(By.xpath("//*[@class='fa fa-shopping-cart']"));
					    action.moveToElement(mainMenu).click().build().perform();
					}
					else
					{
						Actions action = new Actions(driver);
					   	WebElement mainMenu = driver.findElement(By.xpath("//div[@class='container-Addto-cart-button paragraph']//button[@name='addProduct']"));
					    action.moveToElement(mainMenu).click().build().perform();
					}
					
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@id='desktopAjax']/li/a/i")).click();					
				}
				else
				{
					getvalue1 = driver.findElement(By.xpath("//*[@class='ish-product-detail-page clearfix']//span[@class='ish-productNumber-value']")).getText();
					System.out.println("Product SKU on PDP+ " + getvalue1);
					
					Thread.sleep(5000);
					int temp2 = 0;
					temp2 = driver.findElements(By.xpath("//*[@class='pitem-checkbox pos-checkbox']")).size();
					System.out.println("Pitem Checkbox " + temp2);	
					if (temp2!= 0)
					{
						Thread.sleep(5000);
						driver.findElement(By.xpath("//*[@class='label label_checkbox']")).click();
						Thread.sleep(5000);
					}
					
					Actions action = new Actions(driver);
			    	WebElement mainMenu = driver.findElement(By.xpath("//*[@name='addProduct']"));
			    	action.moveToElement(mainMenu).click().build().perform();
					
					Thread.sleep(5000);
					//driver.findElement(By.xpath("//*[@class='link kor-minicart-group']")).click();
					
					driver.findElement(By.xpath("//*[@class='quantity-display']")).click();
					
					getvalue2 = driver.findElement(By.xpath("(//span[@class='ish-itemNumber'])[1]")).getText();
					System.out.println("Product SKU on Cart " + getvalue2);
				}		    	
			}
		}
		catch (NoSuchElementException e) 
	    {
			throw e;  
		}	
		
		if (browser.contains("PhantomJS")) 
		{
			System.out.println("Phantomjs Browser - Cart page");
		}
		else
		{
			if (getvalue2.contains(getvalue1))
			{
					testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
			} 
			else Assert.assertFalse(getvalue2.contains(getvalue1));
		}
	}
	
	
	@Test(description = "Add Product To Cart From PDP")
	public void CloseJitemOverlayFromPDP() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "addProducttoCartFromPDP";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		getvalue1 = null;
		getvalue2 = null;
		getvalue3 = null;
		getvalue4 = null;
      

		
		Integer count = driver.findElements(By.xpath("//*[@class='popup-msg-no-items']")).size();
		System.out.println("Jitem popup " + count);
		
		if (count > 0)
		{
			System.out.println("Jitem popup is Visible on PDP " + count);       
			driver.findElement(By.xpath("//*[@class='kor-overlay-close kor-control']")).click();
		}		
	}
	
	
//	BE-2490	Disable' add to basket button when clicked once
	@Test(description = "add Product to Cart And Verify button")
	public void addProducttoCartAndVerifybutton() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "addProducttoCartAndVerifybutton";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		getvalue1 = null;
		getvalue2 = null;
		getvalue3 = null;
		getvalue4 = null;
      

		if (browser.contains("PhantomJS")) 
		{
			System.out.println("Phantomjs Browser");			
			String getvalue1 = driver.findElement(By.xpath("//*[@class='ish-productNumber-value']")).getText();
			System.out.println("Satya Product SKU on PDP" + getvalue1);
		}
		else
		{
			Thread.sleep(10000);
			getvalue1 = driver.findElement(By.xpath("//*[@class='ish-productNumber-value']")).getText();
			System.out.println("Product SKU first PDP " + getvalue1);
		}
		
		try
		{
			Thread.sleep(5000);
			int temp = 0;
			temp = driver.findElements(By.xpath("//*[@class='header-expressShop']")).size();
			System.out.println("1st Overlay pop up " + temp);	
			if (temp!= 0)
			{
				getvalue1 = driver.findElement(By.xpath("html/body/div[5]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/span[2]")).getText();			
				System.out.println("Product SKU on Overlay " + getvalue1);
								
				driver.findElement(By.xpath("html/body/div[5]/div[2]/div/div/div/div[1]/div[2]/div/form/div[3]/button")).click();
				
				Thread.sleep(5000);
				int temp1 = 0;
				temp1 = driver.findElements(By.xpath("//*[@class='kor-expressshop-title']")).size();
				System.out.println("2nd Overlay pop up " + temp1);	
				if (temp1!= 0)
				{
					driver.findElement(By.xpath("//*[@class='ish-button ish-bar-actionButton show-spinner']")).click();	
					
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@class='link kor-minicart-group']")).click();
					getvalue2 = driver.findElement(By.xpath("(//span[@class='ish-itemNumber'])[1]")).getText();
				}
				else
				{
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@class='link kor-minicart-group']")).click();
					getvalue2 = driver.findElement(By.xpath("(//span[@class='ish-itemNumber'])[1]")).getText();
					Thread.sleep(5000);
				}
			}
			else
			{	
				if (browser.contains("PhantomJS")) 
				{
					System.out.println("Phantomjs Browser");
					
					if (webshop.contains("MLN"))
					{
						System.out.println("MLN Webshop " + webshop);
						
						Actions action = new Actions(driver);
					   	WebElement mainMenu = driver.findElement(By.xpath("//*[@class='fa fa-shopping-cart']"));
					    action.moveToElement(mainMenu).click().build().perform();
					}
					else
					{
						Actions action = new Actions(driver);
					   	WebElement mainMenu = driver.findElement(By.xpath("//div[@class='container-Addto-cart-button paragraph']//button[@name='addProduct']"));
					    action.moveToElement(mainMenu).click().build().perform();
					}
					
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@id='desktopAjax']/li/a/i")).click();					
				}
				else
				{
					getvalue1 = driver.findElement(By.xpath("//*[@class='ish-product-detail-page clearfix']//span[@class='ish-productNumber-value']")).getText();
					System.out.println("Product SKU on PDP+ " + getvalue1);
					
					Thread.sleep(5000);
					int temp2 = 0;
					temp2 = driver.findElements(By.xpath("//*[@class='pitem-checkbox pos-checkbox']")).size();
					System.out.println("Pitem Checkbox " + temp2);	
					if (temp2!= 0)
					{
						driver.findElement(By.xpath("//*[@class='pitem-checkbox pos-checkbox']")).click();
					}
					
					Actions action = new Actions(driver);
			    	WebElement mainMenu = driver.findElement(By.xpath("//*[@name='addProduct']"));
			    	action.moveToElement(mainMenu).click().build().perform();
					
					Thread.sleep(5000);
					//driver.findElement(By.xpath("//*[@class='link kor-minicart-group']")).click();
					
					driver.findElement(By.xpath("//*[@class='quantity-display']")).click();
					
					getvalue2 = driver.findElement(By.xpath("(//span[@class='ish-itemNumber'])[1]")).getText();
					System.out.println("Product SKU on Cart " + getvalue2);
				}		    	
			}
		}
		catch (NoSuchElementException e) 
	    {
			throw e;  
		}	
		
		if (browser.contains("PhantomJS")) 
		{
			System.out.println("Phantomjs Browser - Cart page");
		}
		else
		{
			if (getvalue2.contains(getvalue1))
			{
					testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
			} 
			else Assert.assertFalse(getvalue2.contains(getvalue1));
		}
	}
	
	
	@Test(description = "Add Product To Cart From PDP")
	public void addProducttoCartFromPDP1() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "addProducttoCartFromPDP";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		getvalue1 = null;
		getvalue2 = null;
		getvalue3 = null;
		getvalue4 = null;
      

		if (browser.contains("PhantomJS")) 
		{
			System.out.println("Phantomjs Browser");			
			String getvalue1 = driver.findElement(By.xpath("//*[@class='ish-productNumber-value']")).getText();
			System.out.println("Satya Product SKU on PDP" + getvalue1);
		}
		else
		{
			Thread.sleep(10000);
			getvalue1 = driver.findElement(By.xpath("//*[@class='ish-productNumber-value']")).getText();
			System.out.println("Product SKU first PDP " + getvalue1);
		}
		
		try
		{
			Thread.sleep(5000);
			int temp = 0;
			temp = driver.findElements(By.xpath("//*[@class='header-expressShop']")).size();
			System.out.println("1st Overlay pop up " + temp);	
			if (temp!= 0)
			{
				getvalue1 = driver.findElement(By.xpath("html/body/div[5]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/span[2]")).getText();			
				System.out.println("Product SKU on Overlay " + getvalue1);
								
				driver.findElement(By.xpath("html/body/div[5]/div[2]/div/div/div/div[1]/div[2]/div/form/div[3]/button")).click();
				
				Thread.sleep(5000);
				int temp1 = 0;
				temp1 = driver.findElements(By.xpath("//*[@class='kor-expressshop-title']")).size();
				System.out.println("2nd Overlay pop up " + temp1);	
				if (temp1!= 0)
				{
					driver.findElement(By.xpath("//*[@class='ish-button ish-bar-actionButton show-spinner']")).click();	
					
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@class='link kor-minicart-group']")).click();
					getvalue2 = driver.findElement(By.xpath("(//span[@class='ish-itemNumber'])[1]")).getText();
				}
				else
				{
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@class='link kor-minicart-group']")).click();
					getvalue2 = driver.findElement(By.xpath("(//span[@class='ish-itemNumber'])[1]")).getText();
					Thread.sleep(5000);
				}
			}
			else
			{	
				if (browser.contains("PhantomJS")) 
				{
					System.out.println("Phantomjs Browser");
					
					if (webshop.contains("MLN"))
					{
						System.out.println("MLN Webshop " + webshop);
						
						Actions action = new Actions(driver);
					   	WebElement mainMenu = driver.findElement(By.xpath("//*[@class='fa fa-shopping-cart']"));
					    action.moveToElement(mainMenu).click().build().perform();
					}
					else
					{
						Actions action = new Actions(driver);
					   	WebElement mainMenu = driver.findElement(By.xpath("//div[@class='container-Addto-cart-button paragraph']//button[@name='addProduct']"));
					    action.moveToElement(mainMenu).click().build().perform();
					}
					
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@id='desktopAjax']/li/a/i")).click();					
				}
				else
				{
					getvalue1 = driver.findElement(By.xpath("//*[@class='ish-product-detail-page clearfix']//span[@class='ish-productNumber-value']")).getText();
					System.out.println("Product SKU on PDP+ " + getvalue1);
					
					Actions action = new Actions(driver);
			    	WebElement mainMenu = driver.findElement(By.xpath("//*[@name='addProduct']"));
			    	action.moveToElement(mainMenu).click().build().perform();
					
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@class='link kor-minicart-group']")).click();
					
					getvalue2 = driver.findElement(By.xpath("(//*[@class='ish-itemNumber'])[3]")).getText();
					System.out.println("Product SKU on Cart " + getvalue2);
				}		    	
			}
		}
		catch (NoSuchElementException e) 
	    {
			throw e;  
		}	
		
		if (browser.contains("PhantomJS")) 
		{
			System.out.println("Phantomjs Browser - Cart page");
		}
		else
		{
			if (getvalue2.contains(getvalue1))
			{
					testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
			} 
			else Assert.assertTrue(getvalue2.contains(getvalue1));
		}
	}


	@Test(description = "Goto Change Email  Page")
	public void navigateChangeEmailPage() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "navigateChangeEmailPage";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		driver.findElement(By.xpath("//*[contains(text(),'Profiel instellingen')]")).click();
		Thread.sleep(10000);
	//	driver.findElement(By.xpath("//*[contains(text(),'Wijzig')]")).click();
		driver.findElement(By.xpath("(//*[contains(text(),'Wijzig')])[1]")).click();
		if (browser.equals("*iexplore")) {
			if (driver.getPageSource().contains("Continue to this website (not recommended)")) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("javascript:document.getElementById('overridelink').click();");
				Thread.sleep(5000);
			} else {
				System.out.println("INFO :: Secure page not appear");
			}
		}
		//driver.manage().window().maximize();
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}

	@Test(description = "Click on Save Changes Button")
	public void saveChanges() throws InterruptedException {
		moduleName = "siteNavigationModule";
		methodName = "saveChanges";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
	}

	@Test(description = "Click on Cancel Button")
	public void cancelChangeEmail() throws InterruptedException {
		moduleName = "siteNavigationModule";
		methodName = "cancelChangeEmail";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		testCaseUtil.processElements( mLink, "click", moduleName, methodName, driver, channelLocator);
	}
	
	@Test(description = "Click on Cancel Button")
	public void cancelChangeCompanyProfile() throws InterruptedException {
		moduleName = "siteNavigationModule";
		methodName = "cancelChangeEmail";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		testCaseUtil.processElements( mLink, "click", moduleName, methodName, driver, channelLocator);
	}

	@Test(description = "Goto Change Company Detials Page")
	public void navigateToUpdateCompanyProfilePage() throws InterruptedException {
		moduleName = "siteNavigationModule";
		methodName = "navigateToUpdateCompanyProfilePage";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		driver.get(urlProp.getProperty("navigateToUpdateCompanyProfilePageUrl"));
		if (browser.equals("*iexplore")) {
			if (driver.getPageSource().contains("Continue to this website (not recommended)")) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("javascript:document.getElementById('overridelink').click();");
				Thread.sleep(5000);
			} else {
				System.out.println("INFO :: Secure page not appear");
			}
		}
		//driver.manage().window().maximize();
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}

	@Test(description = "Update & Save Changes")
	public void updateCompanyDetails() throws InterruptedException {
		moduleName = "siteNavigationModule";
		methodName = "updateCompanyDetails";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		driver.findElement(By.xpath("//*[@id='UpdateCompanyProfileForm_CompanyName_FormValue_CompanyName']")).sendKeys("Test");		
		testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
	}
	
	@Test(description = "Roll Back Updates")
	public void rollBackCompanyDetails() throws InterruptedException {
		moduleName = "siteNavigationModule";
		methodName = "rollBackCompanyDetails";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		driver.findElement(By.xpath("//*[@id='UpdateCompanyProfileForm_CompanyName_FormValue_CompanyName']")).sendKeys("Achmea");		
		testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
	}	

	
	@Test(description = "Goto PDP")
	public void gotoFirstPDP() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "gotoFirstPDP";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);	
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,-200)");
		
		getvalue1 = null;
		
//		Counter to find which all Views (Grid/List) is enabled
		
		count1 = driver.findElements(By.xpath("//*[@class='button right icon fa fa-th-list']")).size();
		System.out.println("Find if list view is disabled " + count1);
			
		Thread.sleep(10000);
//		If condition to enable the list view
		if (count1 != 0)
		{
			System.out.println(" list view is not enabled " + count1);
			driver.findElement(By.xpath("//*[@class='button right icon fa fa-th-list']")).click();
			
			count2 = driver.findElements(By.xpath("//*[@class='button right icon fa fa-th-list']")).size();
			System.out.println(" list view is now enabled " + count2);
			
			Thread.sleep(10000);	
		}
		
		String str = webshop;
		System.out.println("str " + str);
		
		if (str.toLowerCase().contains("oci"))
		{
			System.out.println("OCI name " + webshop);
			count2 = driver.findElements(By.xpath("//*[@class='ish-product-image xl1']")).size();
			System.out.println("1 for XL Image size " + count2);
			if (count2 != 0)
			{
				System.out.println("List view click product " + webshop);
				driver.findElement(By.xpath(webElement.get("ClickPDP"))).click();
			}
			else
			{
				System.out.println("Grid view click product" + webshop);
				driver.findElement(By.xpath(webElement.get("ClickPDP1"))).click();
			}
		}
		else if (webshop.contains("MAJ-NL-Test"))
		{
			System.out.println("MAJ Webshop " + webshop);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
	        js1.executeScript("javascript:window.scrollBy(70,170)");
			driver.findElement(By.xpath(webElement.get("ClickPDPMAJ"))).click();
		}
		else
		{
			if (browser.contains("PhantomJS")) 
			{
				System.out.println("Browser is " + browser);
				driver.findElement(By.xpath("(//*[@class='row no-margin rwd-tablet rwd-desktop lister-tile'])[1]")).click();
			
//				JavascriptExecutor js1 = (JavascriptExecutor) driver;
//				js1.executeScript("javascript:window.scrollBy(100,200)");
				
//				getvalue1 = driver.findElement(By.xpath("//*[@id='change-variation-sku-pdp']")).getText();				
//				System.out.println("Product SKU on first PDP +++ " + getvalue1);
			
			}
			else
			{
				System.out.println("Not a OCI Webshop " + webshop);			
				driver.findElement(By.xpath(webElement.get("ClickPDP"))).click();
				
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
				js1.executeScript("javascript:window.scrollBy(100,200)");
				
				getvalue1 = driver.findElement(By.xpath(webElement.get("GetPDPSkuOL"))).getText();				
				System.out.println("Product SKU on first PDP +++ " + getvalue1);
			}
		}
				
		if (browser.contains("PhantomJS")) 
		{
			System.out.println("Browser is " + browser);
			Thread.sleep(5000);			
			
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("javascript:window.scrollBy(100,200)");
			
			//testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);			
		}
		else
		{	
			System.out.println("Browser is " + browser);
			//driver.manage().window().maximize();
		
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("javascript:window.scrollBy(100,200)");
			
			Thread.sleep(5000);
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);	
		}
	}
	
	
	@Test(description = "Go to Second PDP")
	public void gotoSecondPDP() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "gotoSecondPDP";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator); 
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,-200)");		
		count1 = driver.findElements(By.xpath("//*[@class='button right icon fa fa-th-list']")).size();
		System.out.println("Switch view 2 " + count1);		
		Thread.sleep(10000);
		
		getvalue3 = null;
		
		if (count1 != 0)
		{
			driver.findElement(By.xpath("//*[@class='button right icon fa fa-th-list']")).click();
			Thread.sleep(10000);	
		}
		
		System.out.println("Web is OCI " + webshop);
		
		if (webshop.contains("OCI"))
		{
			System.out.println("OCI Name: " + webshop);
			count2 = driver.findElements(By.xpath("//*[@class='ish-product-image xl1']")).size();
			System.out.println("Image size " + count2);
			if (count2 != 0)
			{
				System.out.println("Click PDP 2: " + webshop);
				driver.findElement(By.xpath(webElement.get("ClickPDP"))).click();
			}
			else
			{
				System.out.println("Grid view click product 2:" + webshop);
				driver.findElement(By.xpath(webElement.get("ClickPDP1"))).click();
			}
		}
			else if (webshop.contains("MAJ-NL-Test"))
			{
				System.out.println("MAJ Webshop " + webshop);
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
		        js1.executeScript("javascript:window.scrollBy(70,170)");
				driver.findElement(By.xpath(webElement.get("ClickPDPMAJ"))).click();
			}
		else
		{
			System.out.println("Not a OCI Webshop " + webshop);
			driver.findElement(By.xpath(webElement.get("ClickPDP"))).click();
			
			getvalue3 = driver.findElement(By.xpath(webElement.get("GetPDPSkuOL1"))).getText();				
			System.out.println("Product SKU on Second PDP ++++ " + getvalue3);	
		}
		if (browser.contains("PhantomJS")) 
		{
			System.out.println("Browser is " + browser);
		}
		else
		{
			System.out.println("Browser is " + browser);
			//driver.manage().window().maximize();
			
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("javascript:window.scrollBy(70,170)");
			
			Thread.sleep(5000);
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
		}
	}
	
	
	@Test(description = "Goto PDP")
	public void gotoThirdPDP() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "gotoThirdPDP";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,-200)");
		
		count1 = driver.findElements(By.xpath("//*[@class='button right icon fa fa-th-list']")).size();
		System.out.println("Switch view 3" + count1);
		
		
		Thread.sleep(10000);
		if (count1 != 0)
		{
			driver.findElement(By.xpath("//*[@class='button right icon fa fa-th-list']")).click();
			Thread.sleep(10000);	
		}
		
		System.out.println("Web is OCI" + webshop);
		
		if (webshop.contains("OCI"))
		{
			System.out.println("OCI name: " + webshop);
			count2 = driver.findElements(By.xpath("//*[@class='ish-product-image xl1']")).size();
			System.out.println("Image size " + count2);
			if (count2 != 0)
			{
				System.out.println("Click PDP 3:" + webshop);
				driver.findElement(By.xpath(webElement.get("ClickPDP"))).click();
			}
			else
			{
				System.out.println("Click PDP1 3:" + webshop);
				driver.findElement(By.xpath(webElement.get("ClickPDP1"))).click();
			}
		}
		else if (webshop.contains("MAJ-NL-Test"))
		{
			System.out.println("MAJ Webshop " + webshop);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
	        js1.executeScript("javascript:window.scrollBy(70,170)");
			driver.findElement(By.xpath(webElement.get("ClickPDPMAJ"))).click();
		}		
		else
		{
			System.out.println("Not a OCI Webshop " + webshop);
			driver.findElement(By.xpath(webElement.get("ClickPDP"))).click();
		}
		
		if (browser.contains("PhantomJS")) 
		{
			System.out.println("Browser is " + browser);
		}
		else
		{
			System.out.println("Browser is " + browser);
			//driver.manage().window().maximize();
			
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("javascript:window.scrollBy(70,170)");
			
			Thread.sleep(5000);
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);		
		}
	}
	
	
	@Test(description = "Goto PDP")
	public void gotoFourthPDP() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "gotoFourthPDP";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,-200)");
		
		count1 = driver.findElements(By.xpath("//*[@class='button right icon fa fa-th-list']")).size();
		System.out.println("Switch view 4:" + count1);
		
		
		Thread.sleep(10000);
		if (count1 != 0)
		{
			driver.findElement(By.xpath("//*[@class='button right icon fa fa-th-list']")).click();
			Thread.sleep(10000);	
		}
	
		System.out.println("Web is OCI " + webshop);
		
		if (webshop.contains("OCI"))
		{
			System.out.println("OCI name: " + webshop);
			count2 = driver.findElements(By.xpath("//*[@class='ish-product-image xl1']")).size();
			System.out.println("Image size " + count2);
			if (count2 != 0)
			{
				System.out.println("Click PDP 4: " + webshop);
				driver.findElement(By.xpath(webElement.get("ClickPDP"))).click();
			}
			else
			{
				System.out.println("Click PDP1 4:" + webshop);
				driver.findElement(By.xpath(webElement.get("ClickPDP1"))).click();
			}
		}
		else if (webshop.contains("MAJ-NL-Test"))
		{
			System.out.println("MAJ Webshop " + webshop);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
	        js1.executeScript("javascript:window.scrollBy(70,170)");
			driver.findElement(By.xpath(webElement.get("ClickPDPMAJ"))).click();
		}
		else
		{
			System.out.println("Not a OCI Webshop " + webshop);
			driver.findElement(By.xpath(webElement.get("ClickPDP"))).click();
		}
		
		if (browser.contains("PhantomJS")) 
		{
			System.out.println("Browser is " + browser);
		}
		else
		{
			System.out.println("Browser is " + browser);
			//driver.manage().window().maximize();
		
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("javascript:window.scrollBy(70,170)");
		
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
		}
	}
	
	
	@Test(description = "Goto PDP")
	public void gotoFifthPDP() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "gotoFifthPDP";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,-200)");
		
		count1 = driver.findElements(By.xpath("//*[@class='button right icon fa fa-th-list']")).size();
		System.out.println("Switch view 5:" + count1);
		
		
		Thread.sleep(10000);
		if (count1 != 0)
		{
			driver.findElement(By.xpath("//*[@class='button right icon fa fa-th-list']")).click();
			Thread.sleep(10000);	
		}
		
		System.out.println("Web is OCI" + webshop);
		
		if (webshop.contains("OCI"))
		{
			System.out.println("OCI name: " + webshop);
			count2 = driver.findElements(By.xpath("//*[@class='ish-product-image xl1']")).size();
			System.out.println("Image size " + count2);
			if (count2 != 0)
			{
				System.out.println("Click PDP 5: " + webshop);
				driver.findElement(By.xpath(webElement.get("ClickPDP"))).click();
			}
			else
			{
				System.out.println("Click PDP1 5:" + webshop);
				driver.findElement(By.xpath(webElement.get("ClickPDP1"))).click();
			}
		}
		
		else if (webshop.contains("MAJ-NL-Test"))
		{
			System.out.println("MAJ Webshop " + webshop);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
	        js1.executeScript("javascript:window.scrollBy(70,170)");
			driver.findElement(By.xpath(webElement.get("ClickPDPMAJ"))).click();
		}
		else
		{
			System.out.println("Not a OCI Webshop " + webshop);
			driver.findElement(By.xpath(webElement.get("ClickPDP"))).click();
		}
		
		if (browser.contains("PhantomJS")) 
		{
			System.out.println("Browser is " + browser);
		}
		else
		{
			System.out.println("Browser is " + browser);
		
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("javascript:window.scrollBy(70,170)");
	
			//driver.manage().window().maximize();
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
		}
	}
	
	
	@Test(description = "Add Product To Cart From Bundled PDP")
	public void addProducttoCartFromBundledPDP() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "addProducttoCartFromBundledPDP";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		getvalue1 = null;
		getvalue2 = null;
		getvalue3 = null;
		getvalue4 = null;	
		try{
			getvalue1 = driver.findElement(By.xpath("//*[@id='main']/div[1]/div[4]/div[2]/div/div[3]/span[2]")).getText();
			driver.findElement(By.xpath("//*[@name='addProduct']")).click();
			getvalue2 = driver.findElement(By.xpath("//*[@id='main']/div[2]/div/div[1]/form/div[2]/div/table/tbody/tr[2]/td[3]/div/div[3]/span")).getText();
			getvalue3 = driver.findElement(By.xpath("//*[@id='main']/div[2]/div/div[1]/form/div[2]/div/table/tbody/tr[3]/td[3]/div/div[3]/span")).getText();
			getvalue4 = driver.findElement(By.xpath("//*[@id='main']/div[2]/div/div[1]/form/div[2]/div/table/tbody/tr[4]/td[3]/div/div[3]/span")).getText();			
			}catch (NoSuchElementException e) {
			}	
			if ((getvalue2.contains(getvalue1)) || (getvalue3.contains(getvalue1)) || (getvalue4.contains(getvalue1)) )
			{
				testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
			} 
			else 
			{
				throw new InterruptedException("Fail! Add to Cart");
			}			
	}
	
	
	@Test(description = "Add First Product To Compare List from PDP")
	public void addFirstPDPToCompareList() throws InterruptedException {
		moduleName = "siteNavigationModule";
		methodName = "addFirstPDPToCompareList";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		getvalue1 = null;
		getvalue2 = null;	
		
		try
		{			
			Thread.sleep(5000);
			int temp = 0;
			temp = driver.findElements(By.xpath("//*[@class='header-expressShop']")).size();
			System.out.println("Overlay pop up " + temp);	
			if (temp!= 0)
			{
				getvalue1 = driver.findElement(By.xpath(webElement.get("GetPDPSkuOL"))).getText();				
				System.out.println("Product SKU on first PDP++ " + getvalue1);
								
				driver.findElement(By.xpath(webElement.get("Click3dots"))).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@class='ish-product-compare']")).click();
				
				Thread.sleep(3000);
				getvalue2 = driver.findElement(By.xpath(webElement.get("GetCompareSku"))).getText();				
				System.out.println("Product SKU of first PDP on comapre page" + getvalue2);					
				Thread.sleep(5000);
			}
			else
			{		
				getvalue1 = driver.findElement(By.xpath(webElement.get("GetPDPSku"))).getText();				
				System.out.println("Product SKU on first PDP## " + getvalue1);
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("javascript:window.scrollBy(70,170)");
				
				System.out.println("first PDP");
				getvalue1 = driver.findElement(By.xpath(webElement.get("GetPDPSku"))).getText();				
				System.out.println("Product SKU on first PDP " + getvalue1);
				System.out.println("first PDP");
				if (browser.contains("PhantomJS")) 
				{
					System.out.println("PhantomJS Browser");
					getvalue1 = driver.findElement(By.id("//*[@id='change-variation-sku-pdp']")).getText();
					
				}
				else
				{
					getvalue1 = driver.findElement(By.xpath(webElement.get("GetPDPSku"))).getText();
				}
				 
				System.out.println("Product SKU on first PDP " + getvalue1);
				
				driver.findElement(By.xpath(webElement.get("Click3dots"))).click();				
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@class='ish-product-compare']")).click();
				
				Thread.sleep(3000);
				
				getvalue2 = driver.findElement(By.xpath(webElement.get("GetCompareSku"))).getText();					
				System.out.println("Product SKU of first PDP on comapre page" + getvalue2);		
			}	
		}
		catch (NoSuchElementException e) 
		{			
		}
		
		System.out.println("getvalue1" + getvalue1);
		System.out.println("getvalue2" + getvalue2);
		
		if (getvalue2.contains(getvalue1))
		{
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
		} 
		else 
		{
			throw new InterruptedException("Fail! Add to Compare List");
		}
	}
	
	
	@Test(description = "Add Second Product To Compare List from PDP")
	public void addSecondPDPToCompareList() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "addSecondPDPToCompareList";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		getvalue1 = null;
		getvalue2 = null;
		getvalue3 = null;
		
		try
		{			
			Thread.sleep(5000);
			int temp = 0;
			temp = driver.findElements(By.xpath("//*[@class='header-expressShop']")).size();
			System.out.println("Overlay pop up " + temp);	
			if (temp!= 0)
			{
				getvalue1 = driver.findElement(By.xpath(webElement.get("GetPDPSkuOL"))).getText();				
				System.out.println("Product SKU on first PDP " + getvalue1);
								
				driver.findElement(By.xpath(webElement.get("Click3dots"))).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@class='ish-product-compare']")).click();
				
				Thread.sleep(3000);
				
				getvalue2 = driver.findElement(By.xpath(webElement.get("GetCompareSku1"))).getText();
				getvalue3 = driver.findElement(By.xpath(webElement.get("GetCompareSku2"))).getText();			
				System.out.println("Product SKU of first PDP on comapre page" + getvalue2);	
				System.out.println("Product SKU of second PDP on comapre page" + getvalue3);	
				Thread.sleep(5000);
			}
			else
			{			
				getvalue1 = driver.findElement(By.xpath(webElement.get("GetPDPSku"))).getText();
				System.out.println("Product SKU on first PDP " + getvalue1);
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("javascript:window.scrollBy(70,170)");
				
				driver.findElement(By.xpath(webElement.get("Click3dots"))).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@class='ish-product-compare']")).click();
				
				Thread.sleep(3000);
				
				getvalue2 = driver.findElement(By.xpath(webElement.get("GetCompareSku1"))).getText();
				getvalue3 = driver.findElement(By.xpath(webElement.get("GetCompareSku2"))).getText();
			}	
		}
		catch (NoSuchElementException e) 
		{
		}	
		if((getvalue2.contains(getvalue1)) || (getvalue3.contains(getvalue1)))
		{
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
		} 
		else 
		{
			throw new InterruptedException("Fail! Add to Compare List");
		}
	}	

	
	@Test(description = "Add Third Product To Compare List from PDP")
	public void addThirdPDPToCompareList() throws InterruptedException {
		moduleName = "siteNavigationModule";
		methodName = "addThirdPDPToCompareList";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		getvalue1 = null;
		getvalue2 = null;
		getvalue3 = null;
		getvalue4 = null;		
		
		try
		{			
			Thread.sleep(5000);
			int temp = 0;
			temp = driver.findElements(By.xpath("//*[@class='header-expressShop']")).size();
			System.out.println("Overlay pop up " + temp);	
			if (temp!= 0)
			{
				getvalue1 = driver.findElement(By.xpath(webElement.get("GetPDPSkuOL"))).getText();				
				System.out.println("Product SKU on first PDP " + getvalue1);
								
				driver.findElement(By.xpath(webElement.get("Click3dots"))).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@class='ish-product-compare']")).click();
				
				Thread.sleep(3000);
				
				getvalue2 = driver.findElement(By.xpath(webElement.get("GetCompareSku1"))).getText();
				getvalue3 = driver.findElement(By.xpath(webElement.get("GetCompareSku2"))).getText();
				getvalue4 = driver.findElement(By.xpath(webElement.get("GetCompareSku3"))).getText();			
				System.out.println("Product SKU of first PDP on comapre page " + getvalue2);	
				System.out.println("Product SKU of second PDP on comapre page " + getvalue3);
				System.out.println("Product SKU of second PDP on comapre page " + getvalue4);
				Thread.sleep(5000);
			}
			else
			{			
				getvalue1 = driver.findElement(By.xpath(webElement.get("GetPDPSku"))).getText();
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("javascript:window.scrollBy(70,170)");
				
				driver.findElement(By.xpath(webElement.get("Click3dots"))).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@class='ish-product-compare']")).click();
				
				Thread.sleep(3000);
				getvalue2 = driver.findElement(By.xpath(webElement.get("GetCompareSku1"))).getText();
				getvalue3 = driver.findElement(By.xpath(webElement.get("GetCompareSku2"))).getText();
				getvalue4 = driver.findElement(By.xpath(webElement.get("GetCompareSku3"))).getText();	
			}	
		}
		catch (NoSuchElementException e) 
		{
		}	
		
		if ( (getvalue2.contains(getvalue1)) || (getvalue3.contains(getvalue1)) || (getvalue4.contains(getvalue1))  )
		{
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
		} 
		else 
		{
			throw new InterruptedException("Fail! Add to Compare List");
		}
	}	
	
	@Test(description = "Add PDP To Compare List And Verify Navigation")
	public void addPDPToCompareListAndVerifyNavigation() throws InterruptedException {
		moduleName = "siteNavigationModule";
		methodName = "addPDPToCompareListAndVerifyNavigation";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		getvalue1 = null;
		getvalue2 = null;	
		
		try
		{			
			Thread.sleep(5000);
			int temp = 0;
			temp = driver.findElements(By.xpath("//*[@class='header-expressShop']")).size();
			System.out.println("Overlay pop up " + temp);	
			if (temp!= 0)
			{
				getvalue1 = driver.findElement(By.xpath(webElement.get("GetPDPSkuOL"))).getText();				
				System.out.println("Product SKU on first PDP " + getvalue1);
								
				driver.findElement(By.xpath(webElement.get("Click3dots"))).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@class='ish-product-compare']")).click();
				
				Thread.sleep(3000);
				
				driver.findElement(By.xpath(webElement.get("GetCompareSku1"))).click();
				WebDriverWait wait = new  WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(webElement.get("GetCompareSku2"))));
			}
			else
			{	
				  if (webshop.contains("BDD"))
				  {
					getvalue1 = driver.findElement(By.xpath(webElement.get("GetPDPSku"))).getText();
					getvalue1 = getvalue1.split("_")[0];
					System.out.println("Product SKU on first PDP " + getvalue1);					  
				  }
				  else
				  {
					getvalue1 = driver.findElement(By.xpath(webElement.get("GetPDPSku"))).getText();
					System.out.println("Product SKU on first PDP printing " + getvalue1);
				  }
					//JavascriptExecutor js = (JavascriptExecutor) driver;
					//js.executeScript("javascript:window.scrollBy(70,170)");
					
					driver.findElement(By.xpath(webElement.get("Click3dots"))).click();
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@class='ish-product-compare']")).click();
					
					Thread.sleep(3000);
					
					driver.findElement(By.xpath(webElement.get("GetCompareSku1"))).click();
					WebDriverWait wait = new  WebDriverWait(driver, 10);
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(webElement.get("GetCompareSku2"))));		
				 
		   }	
		}
		catch (NoSuchElementException e) 
		{
		}	
			Thread.sleep(5000);
			

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("javascript:window.scrollBy(200,300)");

			getvalue2 = driver.findElement(By.xpath(webElement.get("GetCompareSku2"))).getText();
			System.out.println("Product SKUs on compare page " + getvalue2);
			getvalue2 = getvalue2.split("_")[0];
			System.out.println("Product SKU getvalue2 " + getvalue2);
			System.out.println(getvalue2);
			
			if (getvalue1.equals(getvalue2))
			{
				testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
				Thread.sleep(10000); 
			}
			else 
			{
				throw new InterruptedException("Fail! Navigation");
			}
		}
	
	
	@Test(description = "Add Product To Cart From Compare Page And Verify")
	public void addProductToCartFromComparePageAndVerify() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "addProductToCartFromComparePageAndVerify";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		getvalue1 = null;
		getvalue2 = null;
		getvalue3 = null;
		getvalue4 = null;
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(100,250)");
		
		if (webshop.contains("GLOOCI"))
	    {
			getvalue1 = driver.findElement(By.xpath(webElement.get("GetCompareSku3"))).getText();
			getvalue2 = driver.findElement(By.xpath(webElement.get("GetCompareSku4"))).getText();
			
			System.out.println("Compare page sku values: " +getvalue1+ " " +getvalue2);
			 
			getvalue1 = getvalue1.split("_")[0];
			getvalue2 = getvalue2.split("_")[0];
			
			System.out.println("Compare page sku values:- " +getvalue1+ " "+getvalue2);
	    }
		else
		{
			getvalue1 = driver.findElement(By.xpath(webElement.get("GetCompareSku1"))).getText();
			getvalue2 = driver.findElement(By.xpath(webElement.get("GetCompareSku2"))).getText();
			
			System.out.println("Compare page sku values: " +getvalue1+ " " +getvalue2);
			 
			getvalue1 = getvalue1.split("_")[0];
			getvalue2 = getvalue2.split("_")[0];
			
			System.out.println("Compare page sku values:- " +getvalue1+ " "+getvalue2);
		}
		driver.findElement(By.xpath(webElement.get("ClickAddToCartButtonTop"))).click();
		
		if (webshop.contains("DRDOCI"))
	    {
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("javascript:window.scrollBy(800,900)");
			
			System.out.println("This is DRD OCI application");
			
			Thread.sleep(4000);
			
			driver.findElement(By.xpath(webElement.get("ClickAddToCartButtonBottom"))).click();
	    }
		else if (webshop.contains("GLOOCI"))
	    {
			JavascriptExecutor js5 = (JavascriptExecutor) driver;
			js5.executeScript("javascript:window.scrollBy(800,900)");	
			
			System.out.println("This is GLO OCI application");
			
			Thread.sleep(4000);
			
			driver.findElement(By.xpath(webElement.get("ClickAddToCartButtonBottom"))).click();
	    }
		else
		{
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("javascript:window.scrollBy(800,900)");	
			
			Thread.sleep(4000);
			driver.findElement(By.xpath(webElement.get("ClickAddToCartButtonBottom"))).click();
			Thread.sleep(5000);	
			driver.findElement(By.xpath("//*[@class='fa fa-shopping-cart']")).click();
		}		
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='fa fa-shopping-cart']")).click();
		Thread.sleep(5000);	
		//driver.findElement(By.xpath(webElement.get("CartButtonPDP"))).click();
		////*[@class='fa fa-shopping-cart']
		
		if (webshop.contains("MLN"))
	    {
			getvalue3 = driver.findElement(By.xpath("(//*[@class='ish-itemNumber'])[1]")).getText();
			getvalue4 = driver.findElement(By.xpath("(//*[@class='ish-itemNumber'])[4]")).getText();
			
			getvalue3 = getvalue3.split(" ")[1];
			getvalue4 = getvalue4.split(" ")[1];
			
		    System.out.println("Cart page sku values: " +getvalue3+ " "+getvalue4);
	    }
		else if (webshop.contains("BDD"))
	    {
			getvalue3 = driver.findElement(By.xpath("(//*[@class='ish-itemNumber'])[1]")).getText();
			getvalue4 = driver.findElement(By.xpath("(//*[@class='ish-itemNumber'])[3]")).getText();
			
			getvalue3 = getvalue3.split(" ")[1];
			getvalue4 = getvalue4.split(" ")[1];
			
		    System.out.println("Cart page sku values: " +getvalue3+ " "+getvalue4);
	    }
		else if (webshop.contains("DRDOCI"))
	    {
			getvalue3 = driver.findElement(By.xpath("(//*[@class='ish-itemNumber'])[1]")).getText();
			getvalue4 = driver.findElement(By.xpath("(//*[@class='ish-itemNumber'])[3]")).getText();
			
			getvalue3 = getvalue3.split(" ")[1];
			getvalue4 = getvalue4.split(" ")[1];
			
		    System.out.println("Cart page sku values: " +getvalue3+ " "+getvalue4);
	    }
		else
		{
			getvalue3 = driver.findElement(By.xpath("(//*[@class='ish-itemNumber'])[1]")).getText();
			getvalue4 = driver.findElement(By.xpath("(//*[@class='ish-itemNumber'])[3]")).getText();
			getvalue3 = getvalue3.split(" ")[1];
			getvalue4 = getvalue4.split(" ")[1];
			
		    System.out.println("Cart page sku values: " +getvalue3+ " "+getvalue4);
		}
		
		if ( (getvalue3.contains(getvalue1)) && (getvalue4.contains(getvalue2)) )
		{
			if (webshop.equals("DRDOCI-NL-Test"))		
			{	
			    System.out.println("This is an OCI application");
			}
			else
			{
				Thread.sleep(5000);
				testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
			}			
		} 
		else 
		{
			Thread.sleep(5000);
			throw new InterruptedException("Fail! Add to Cart From Compare Page");
		}
	}	
	
	
	@Test(description = "Delete All Products From Compare Page")
	public void deleteAllProductsFromComparePage() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "deleteAllProductsFromComparePage";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		Thread.sleep(10000);
		count1 = 0;
			count1 = driver.findElements(By.xpath(webElement.get("PDPCount"))).size();
			System.out.println("Satya");
			System.out.println(count1);	
			driver.findElement(By.xpath(webElement.get("PDPCount"))).click();
			if (count1 > 0) 	
			{
				System.out.println("TEST " + count1);
				testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);				
			}
			else 
			{
				throw new InterruptedException("Fail! No Product to Delete");
			}
	}
	

	@Test(description = "Goto Your Profile Page")
	public void navigateToUpdateYourProfilePage() throws InterruptedException {
		moduleName = "siteNavigationModule";
		methodName = "navigateToUpdateYourProfilePage";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		driver.findElement(By.xpath("//*[contains(text(),'Profiel instellingen')]")).click();
		Thread.sleep(10000);
	//	driver.findElement(By.xpath("//*[contains(text(),'Wijzig')]")).click();
		driver.findElement(By.xpath("(//*[contains(text(),'Wijzig')])[3]")).click();
		if (browser.equals("*iexplore")) {
			if (driver.getPageSource().contains("Continue to this website (not recommended)")) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("javascript:document.getElementById('overridelink').click();");
				Thread.sleep(5000);
			} else {
				System.out.println("INFO :: Secure page not appear");
			}
		}
		//driver.manage().window().maximize();
		Thread.sleep(5000);
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	@Test(description = "Update Your Profile Details")
	public void updateYourDetails() throws InterruptedException {
		moduleName = "siteNavigationModule";
		methodName = "updateYourDetails";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		driver.findElement(By.xpath("//*[@id='UpdateProfileForm_Title']")).sendKeys("Geachte heer");
		driver.findElement(By.xpath("//*[@id='UpdateProfileForm_FirstName']")).clear();
		driver.findElement(By.xpath("//*[@id='UpdateProfileForm_FirstName']")).sendKeys("Satya F Updated");
		driver.findElement(By.xpath("//*[@id='UpdateProfileForm_LastName']")).clear();
		driver.findElement(By.xpath("//*[@id='UpdateProfileForm_LastName']")).sendKeys("L Name Updated");		
		driver.findElement(By.xpath("//*[@id='UpdateProfileForm_Gender']")).sendKeys("Vrouw");
		driver.findElement(By.xpath("//*[@id='UpdateProfileForm_Phone']")).clear();
		driver.findElement(By.xpath("//*[@id='UpdateProfileForm_Phone']")).sendKeys("12345");	
		driver.findElement(By.xpath("//*[@name='UpdateProfile']")).click();
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}

	@Test(description = "Click on Cancel Button")
	public void cancelChangeYourProfile() throws InterruptedException {
		moduleName = "siteNavigationModule";
		methodName = "cancelChangeYourProfile";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
	}

	@Test(description = "Goto To Forgot Password Page")
	public void gotoForgotPasswordPage() throws InterruptedException {
	moduleName = "siteNavigationModule";
	methodName = "gotoForgotPasswordPage";
	channelLocator="comChannel";
    initialize(moduleName,methodName, channelLocator);
    testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);	
	//driver.manage().window().maximize();
	testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	@Test(description = "Verify Forgot Password Page Mandatory Fields")
	public void ValidateforgotPasswordMandatoryField() throws InterruptedException {
		moduleName = "siteNavigationModule";
		methodName = "ValidateforgotPasswordMandatoryField";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);	
		driver.findElement(By.xpath(webElement.get("OkButton"))).click();
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}

	@Test(description = "Verify Forgot Password Confirmation Message")
	public void validateforgotPasswordConfirmationMesssage() throws InterruptedException {
		moduleName = "siteNavigationModule";
		methodName = "validateforgotPasswordConfirmationMesssage";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		driver.findElement(By.xpath("//*[@id='ForgotPasswordStep1Email_Login']")).sendKeys("sprakash@salmon.com");
		ReportUtil.captureScreenShot();
		driver.findElement(By.xpath("//*[@name='Step2']")).click();
		Thread.sleep(5000);
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}

	@Test(description = "Verify Blank Order Template Name")
	public void verifyBlankOrderTemplateName() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "verifyBlankOrderTemplateName";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		driver.findElement(By.xpath("//button[@name='addToWishlistProduct']")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='add-to-wishlist-form']/div/div/input[2]")));
		
		driver.findElement(By.xpath("//*[@id='add-to-wishlist-form']/div/div/input[2]")).click();
		driver.findElement(By.xpath("//*[@id='add-to-wishlist-form']/div/div/input[2]")).clear();
		driver.findElement(By.xpath("//*[@name='AddWishlistItem']")).click();
		
		Thread.sleep(5000);
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}

	@Test(description = "Prospect Sign In")
	public void loginProspectUser() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "loginProspectUser";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		Thread.sleep(10000);
		if (browser.contains("iexplore")) { // certificate issue in IE 7, 8 and 9
			if (driver.getPageSource().contains("Continue to this website")) {
				driver.get("javascript:document.getElementById('overridelink').click();");
			}
		}
		
		testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
		driver.findElement(By.xpath(mLink.get("loginButton"))).click();
		Thread.sleep(3000); // Don't remove
		
		if (browser.contains("iexplore")) { // certificate issue in IE 7, 8 and 9
			if (driver.getPageSource().contains("Continue to this website")) {
				driver.get("javascript:document.getElementById('overridelink').click();");
			}
		}
		// Fall back code, in case the provided password doesn't work then try an alternate password.
		if (driver.getPageSource().contains("Uw e-mailadres/wachtwoord combinatie is onjuist. Gelieve opnieuw te proberen."))
		{
			driver.findElement(By.id("ShopLoginForm_Password")).clear();
			driver.findElement(By.id("ShopLoginForm_Password")).sendKeys("Ebsi@123");
			driver.findElement(By.xpath(mLink.get("loginButton"))).click();
		}
		// Fall back code ends
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, "loginButton", driver, channelLocator);
	}

	@Test(description = "Goto Change Password page")
	public void goToChangePasswordPage() throws InterruptedException {
		moduleName = "siteNavigationModule";
		methodName = "goToChangePasswordPage";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		driver.findElement(By.xpath("//*[contains(text(),'Profiel instellingen')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[contains(text(),'Wijzig')])[2]")).click();
		if (browser.equals("*iexplore")) {
			if (driver.getPageSource().contains("Continue to this website (not recommended)")) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("javascript:document.getElementById('overridelink').click();");
				Thread.sleep(5000);
			} else {
				System.out.println("INFO :: Secure page not appear");
			}
		}
		//driver.manage().window().maximize();
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	
	@Test(description = "Update Password From Profile")
	public void updatePassword() throws InterruptedException {
		moduleName = "siteNavigationModule";
		methodName = "updatePassword";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		driver.findElement(By.xpath("//*[@id='UpdatePasswordForm_Password']")).sendKeys("Eperium123");
		driver.findElement(By.xpath("//*[@id='UpdatePasswordForm_NewPassword']")).sendKeys("Ebsi@123");
		driver.findElement(By.xpath("//*[@id='UpdatePasswordForm_NewPasswordConfirmation']")).sendKeys("Ebsi@123");
		driver.findElement(By.xpath("//*[@name='UpdatePassword']")).click();
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	
	@Test(description = "Re-login Prospect With Changed Password")
	public void reLoginProspectWithChangedPassword() throws InterruptedException {
		moduleName = "siteNavigationModule";
		methodName = "reLoginProspectWithChangedPassword";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		Thread.sleep(10000);
		if (browser.contains("iexplore")) { // certificate issue in IE 7, 8 and 9
			if (driver.getPageSource().contains("Continue to this website")) {
				driver.get("javascript:document.getElementById('overridelink').click();");
			}
		}
		
		testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
		driver.findElement(By.xpath(mLink.get("loginButton"))).click();
		Thread.sleep(3000); // Don't remove
		
		if (browser.contains("iexplore")) { // certificate issue in IE 7, 8 and 9
			if (driver.getPageSource().contains("Continue to this website")) {
				driver.get("javascript:document.getElementById('overridelink').click();");
			}
		}
		// Fall back code, in case the provided password doesn't work then try an alternate password.
		if (driver.getPageSource().contains("Uw e-mailadres/wachtwoord combinatie is onjuist. Gelieve opnieuw te proberen."))
		{
			driver.findElement(By.id("ShopLoginForm_Password")).clear();
			driver.findElement(By.id("ShopLoginForm_Password")).sendKeys("Eperium123");
			driver.findElement(By.xpath(mLink.get("loginButton"))).click();
		}
		// Fall back code ends
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, "loginButton", driver, channelLocator);
		}

	@Test(description = "Goto Change Password page Again")
	public void goToChangePasswordPageAgain() throws InterruptedException {
		moduleName = "siteNavigationModule";
		methodName = "goToChangePasswordPageAgain";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		driver.findElement(By.xpath("//*[contains(text(),'Profiel instellingen')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[contains(text(),'Wijzig')])[2]")).click();
		if (browser.equals("*iexplore")) {
			if (driver.getPageSource().contains("Continue to this website (not recommended)")) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("javascript:document.getElementById('overridelink').click();");
				Thread.sleep(5000);
			} else {
				System.out.println("INFO :: Secure page not appear");
			}
		}
		//driver.manage().window().maximize();
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	
	@Test(description = "Restore Original Password")
	public void restoreOriginalPassword() throws InterruptedException {
		moduleName = "siteNavigationModule";
		methodName = "restoreOriginalPassword";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		driver.findElement(By.xpath("//*[@id='UpdatePasswordForm_Password']")).sendKeys("Ebsi@123");
		driver.findElement(By.xpath("//*[@id='UpdatePasswordForm_NewPassword']")).sendKeys("Eperium123");
		driver.findElement(By.xpath("//*[@id='UpdatePasswordForm_NewPasswordConfirmation']")).sendKeys("Eperium123");
		driver.findElement(By.xpath("//*[@name='UpdatePassword']")).click();
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	@Test(description = "Change Delivery Address")
	public void changeSpecificDeliveryAddress() throws InterruptedException {
		moduleName = "siteNavigationModule";
		methodName = "changeSpecificDeliveryAddress";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		driver.findElement(By.xpath("//*[@id='ShippingAddressID']")).click();
		Thread.sleep(5000);
		Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='ShippingAddressID']")));
		List<WebElement> z = dropdown.getOptions();
		int s = z.size();
//		dropdown.selectByIndex(1);
//		int s = driver.findElements(By.xpath("//*[@id='ShippingAddressID']/option")).size();
//		System.out.println(s);
		for(int x = 2; x < s+1 ; x++)
			{
			   String y= String.valueOf(x).toString();
				if (driver.findElement(By.xpath("//*[@value='ShippingAddressID']/option["+y+"]")).getAttribute("value") == AddressId ) {
					System.out.println("Satya2");	
					dropdown.selectByIndex(x);
					break;
					}
			}
	//	driver.findElement(By.xpath("//*[@value='"+AddressId+"']")).click();
//		testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
		ReportUtil.captureScreenShot();
		Thread.sleep(5000);
	}
	
	
	@Test(description = "Navigate from Confirm Order To Payment Page")
	public void confirmOrderToPaymentPage() throws InterruptedException {
		moduleName = "siteNavigationModule";
		methodName = "confirmOrderToPaymentPage";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,-700)");
		
		int temp = 0;
		temp = driver.findElements(By.xpath("(//*[@class='rwd-tablet rwd-desktop'])")).size();
		if (temp == 6)
		{
			driver.findElement(By.xpath("(//*[@class='rwd-tablet rwd-desktop'])[3]")).click();
		}	
		driver.findElement(By.xpath("(//*[@class='rwd-tablet rwd-desktop'])[2]")).click();
		Thread.sleep(5000);
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	@Test(description = "Navigate From Payment To Shipping Page")
	public void paymentToShippingPage() throws InterruptedException {
		moduleName = "siteNavigationModule";
		methodName = "paymentToShippingPage";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		driver.findElement(By.xpath("(//*[@class='rwd-tablet rwd-desktop'])[1]")).click();
		Thread.sleep(5000);
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	@Test(description = "Navigate From Shipping To Delivery Address Page")
	public void shippingToDeliveryAddressPage() throws InterruptedException {
		moduleName = "siteNavigationModule";
		methodName = "shippingToDeliveryAddressPage";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		driver.findElement(By.xpath("(//*[@class='rwd-tablet rwd-desktop'])[1]")).click();
		Thread.sleep(5000);
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
	
	
	@Test(description = "Browse Assortiment Category")
	public void browseAssortimentCategory() throws InterruptedException 
		{
			moduleName = "siteNavigationModule";
			methodName = "browseAssortimentCategory";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);
			driver.findElement(By.xpath("//a[contains(text(),'Assortiment')]")).click();
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
		}

		@Test(description = "Login With No Delivery Address Assigined Customer")
		public void loginWithNoDeliveryAddressAssiginedCustomer() throws InterruptedException {
			moduleName = "siteNavigationModule";
			methodName = "loginWithNoDeliveryAddressAssiginedCustomer";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);
			Thread.sleep(10000);
			if (browser.contains("iexplore")) { // certificate issue in IE 7, 8 and 9
				if (driver.getPageSource().contains("Continue to this website")) {
					driver.get("javascript:document.getElementById('overridelink').click();");
				}
			}
			
			testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
			driver.findElement(By.xpath(mLink.get("loginButton"))).click();
			Thread.sleep(3000); // Don't remove
			
			if (browser.contains("iexplore")) { // certificate issue in IE 7, 8 and 9
				if (driver.getPageSource().contains("Continue to this website")) {
					driver.get("javascript:document.getElementById('overridelink').click();");
				}
			}
			// Fall back code, in case the provided password doesn't work then try an alternate password.
			if (driver.getPageSource().contains("De ingevoerde combinatie van gebruikersnaam en wachtwoord is niet juist. Probeer het nogmaals."))
			{
				driver.findElement(By.id("ShopLoginForm_Password")).clear();
				driver.findElement(By.id("ShopLoginForm_Password")).sendKeys("123456");
				driver.findElement(By.xpath(mLink.get("loginButton"))).click();
			}
			// Fall back code ends
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, "loginButton", driver, channelLocator);
		}
	
		@Test(description = "Search with * Search String")
		public void enterForSearchStringSTAR() throws InterruptedException {
			moduleName = "siteNavigationModule";
			methodName = "enterForSearchStringSTAR";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);
			driver.findElement(By.xpath("//*[@id='searchTerm_Header']")).sendKeys("*");
			ReportUtil.captureScreenShot();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@class='primary small']")).click();
			Thread.sleep(4000);
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
		}

	
		@Test(description = "Goto All Order Template Page")
		public void gotoAllOrderTemplatePage() throws InterruptedException {
			moduleName = "siteNavigationModule";
			methodName = "gotoAllOrderTemplatePage";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);
			driver.findElement(By.xpath("(//*[@id='kor-infoBox-horizontalGroupRight']//p/a)[1]")).click();
			
			if (browser.equals("*iexplore")) {
				if (driver.getPageSource().contains("Continue to this website (not recommended)")) {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.get("javascript:document.getElementById('overridelink').click();");
					Thread.sleep(5000);
				} else {
					System.out.println("INFO :: Secure page not appear");
				}
			}
			//driver.manage().window().maximize();
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
		}

		@Test(description = "Goto All Order Template Page")
		public void gotoAllOrderTemplatePage1() throws InterruptedException {
			moduleName = "siteNavigationModule";
			methodName = "gotoAllOrderTemplatePage1";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);
			driver.findElement(By.xpath("(//*[@id='kor-infoBox-horizontalGroupRight']//p/a)[1]")).click();
			if (browser.equals("*iexplore")) {
				if (driver.getPageSource().contains("Continue to this website (not recommended)")) {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.get("javascript:document.getElementById('overridelink').click();");
					Thread.sleep(5000);
				} else {
					System.out.println("INFO :: Secure page not appear");
				}
			}
			//driver.manage().window().maximize();
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
		}
		
		@Test(description = "Navigate To All Order Template Page")
		public void navigatetoAllOrderTemplatePageAgain() throws InterruptedException {
			moduleName = "siteNavuploadValidCsvAtQuickOrderigationModule";
			methodName = "navigatetoAllOrderTemplatePageAgain";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);
			Thread.sleep(5000);
			driver.findElement(By.xpath("(//*[@id='kor-infoBox-horizontalGroupRight']//p/a)[1]")).click();
			if (browser.equals("*iexplore")) 
			{
				if (driver.getPageSource().contains("Continue to this website (not recommended)")) 
				{
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.get("javascript:document.getElementById('overridelink').click();");
					Thread.sleep(5000);
				} 
				else 
				{
					System.out.println("INFO :: Secure page not appear");
				}
			}
			//driver.manage().window().maximize();
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
		}
	
		
		@Test(description = "Navigate To All Order Template Page")
		public void navigatetoAllOrderTemplatePageAgain1() throws InterruptedException {
			moduleName = "siteNavigationModule";
			methodName = "navigatetoAllOrderTemplatePageAgain1";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);
			driver.get(urlProp.getProperty("orderTemplateUrl"));
			Thread.sleep(3000);
			if (browser.equals("*iexplore")) {
				if (driver.getPageSource().contains("Continue to this website (not recommended)")) {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.get("javascript:document.getElementById('overridelink').click();");
					Thread.sleep(5000);
				} else {
					System.out.println("INFO :: Secure page not appear");
				}
			}
			//driver.manage().window().maximize();
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
		}
		
		@Test(description = "Navigate To All Order Template Page")
		public void navigatetoAllOrderTemplatePage() throws InterruptedException {
			moduleName = "siteNavigationModule";
			methodName = "navigatetoAllOrderTemplatePage";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);
			driver.get(urlProp.getProperty("orderTemplateUrl"));
			Thread.sleep(3000);
			if (browser.equals("*iexplore")) {
				if (driver.getPageSource().contains("Continue to this website (not recommended)")) {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.get("javascript:document.getElementById('overridelink').click();");
					Thread.sleep(5000);
				} else {
					System.out.println("INFO :: Secure page not appear");
				}
			}
			//driver.manage().window().maximize();
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
		}
		
		
		@Test(description = "Delete All Order Template")
		public void deleteAllOrderTemplate() throws InterruptedException 
		{
			moduleName = "siteNavigationModule";
			methodName = "deleteAllOrderTemplate";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);				
			
			if (webshop.contains("MLN"))
		    {
				driver.findElement(By.xpath("//*[@class='fa fa-list']")).click();
		    }
			else if (webshop.contains("BDD"))
		    {
				driver.findElement(By.xpath("//*[@class='fa fa-list']")).click();
		    }
			else
			{
				Thread.sleep(3000);	
				driver.findElement(By.xpath("//*[@id='container']/header/div[4]/div[3]/ul[2]/li[2]/a/span")).click();
				Thread.sleep(3000);	
				driver.findElement(By.xpath("//*[@id='kor-infoBox-horizontalGroupRight']/div[3]/p[2]/a")).click();	
			}
			
			Thread.sleep(3000);	
			int i = driver.findElements(By.xpath("//tr[*]//td[1]")).size();
			System.out.println("Order template list size " + i);
			
			Thread.sleep(3000);	
			if (i != 0)
			{
				for(int j=1;j<=i;j++)
				{
						driver.findElement(By.xpath("//tr["+j+"]//td[6]//a[1]//i[1]")).click();
						Thread.sleep(3000);
						
						int k = driver.findElements(By.xpath("//*[@class='kor-overlay kor-active-content']")).size();
						System.out.println("Order template delete overlay " + k);
						
					    if (k != 0)
					    {
							driver.findElement(By.xpath("//*[@name='DeleteWishlist']")).click();
							Thread.sleep(8000);	
							
							int y = driver.findElements(By.xpath("//tr[*]//td[1]")).size();
							System.out.println("Order template list size " + y);
							i = y;
							j = 0;
					    }
					    else
					    {					    	
					    	System.out.println("This is AX managed template.");
					    	j++;
					    }	    
				}
			}
			else
			{
				System.out.println("No user defined order template exists");
			}
		}
	
		
		@Test(description = "Open Second Order Template And Verify Product")
		public void openSecondOrderTemplateAndVerifyProduct() throws InterruptedException 
		{
			moduleName = "siteNavigationModule";
			methodName = "openSecondOrderTemplateAndVerifyProduct";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);
			Thread.sleep(3000);		
			String OrderTemplate2 = "//a[contains(text(),'" + OrderTempName_2 + "')]";
			Thread.sleep(3000);
			driver.findElement(By.xpath(OrderTemplate2)).click();
			Thread.sleep(3000);
			OrderTemp1_PdP_Sku_2 = driver.findElement(By.xpath("(//span[@class='ish-itemNumber'])[1]")).getText();
			OrderTemp1_PdP_Sku_3 = driver.findElement(By.xpath("(//span[@class='ish-itemNumber'])[2]")).getText();
			
			if ( (OrderTemp1_PdP_Sku_2.contains(OrderTemp1_PdP_Sku_1)) || (OrderTemp1_PdP_Sku_3.contains(OrderTemp1_PdP_Sku_1)) )
			{
			    if (webshop.contains("OCI"))
			    {
			    	System.out.println("This is an OCI application - DRDOCI");	
			    }
			    else
			    {
					testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
					System.out.println("SatyaPass");
			    }
			} 
			else 
			{
				System.out.println("Product Not moved from One order template to another");
				ReportUtil.captureScreenShot();
				System.out.println("SatyaFail");
			}
		}
	

		@Test(description = "Open Order Template, Add Product To Cart And Verify")
		public void openOrderTemplateAndAddProductToCartAndVerify() throws InterruptedException 
		{
			moduleName = "siteNavigationModule";
			methodName = "openOrderTemplateAndAddProductToCartAndVerify";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);
			Thread.sleep(3000);		
			String OrderTemplate1 = "//a[contains(text(),'" + OrderTempName_1 + "')]";
			Thread.sleep(3000);
			driver.findElement(By.xpath(OrderTemplate1)).click();
			Thread.sleep(3000);
			OrderTemp1_PdP_Sku_2 = driver.findElement(By.xpath("(//span[@class='ish-itemNumber'])[1]")).getText();
			driver.findElement(By.xpath("//*[@class='grid-2 default-button']")).sendKeys("1");
			Thread.sleep(5000);
			//driver.findElement(By.xpath("//*[@name='AddToBasket']")).click();
			driver.findElement(By.xpath("//div[@id='container']//button[2]")).click();
			Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@class='link kor-minicart-group']")).click();
			Thread.sleep(5000);
			OrderTemp1_PdP_Sku_3 = driver.findElement(By.xpath("(//span[@class='ish-itemNumber'])[1]")).getText();
						
			String temp3[] = new String[3];
			temp3 = OrderTemp1_PdP_Sku_3.split(" ");
			System.out.println("Str 3 length   "  + temp3.length);
			int temp =0 ;
			temp = temp3.length;
			OrderTemp1_PdP_Sku_3 = temp3[temp-1];
						
			String temp2[] = new String[3];
			temp2 = OrderTemp1_PdP_Sku_2.split(" ");
			System.out.println("Str 2 length  "  + temp2.length);
			temp = temp2.length;
			OrderTemp1_PdP_Sku_2 = temp2[temp-1];
						
			//OrderTemp1_PdP_Sku_3 = OrderTemp1_PdP_Sku_3.replace(".: ","");
			//OrderTemp1_PdP_Sku_3 = OrderTemp1_PdP_Sku_3.replace(" # ","");
			//OrderTemp1_PdP_Sku_2 = OrderTemp1_PdP_Sku_2.replace(".: ","");
			//OrderTemp1_PdP_Sku_2 = OrderTemp1_PdP_Sku_2.replace(" # ","");
			System.out.println("OrderTemp1_PdP_Sku_3  "  + OrderTemp1_PdP_Sku_3);
			System.out.println("OrderTemp1_PdP_Sku_2  " + OrderTemp1_PdP_Sku_2);
			boolean x = false;
						
			if ( OrderTemp1_PdP_Sku_3.contains(OrderTemp1_PdP_Sku_2) )
			{
				x=true;
				testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
				System.out.println("SatyaPass");
			} 
			else 
			{
				ReportUtil.captureScreenShot();
				Assert.assertTrue(x,"Product Not Added To Cart from Order Template"); 
				System.out.println("SatyaFail");
			}		
		}			
		
		
		@Test(description = "Open First Order Template Increase QTY And Move Product")
		public void openFirstOrderTemplateIncreaseQTYAndMoveProduct() throws InterruptedException 
		{
			moduleName = "siteNavigationModule";
			methodName = "openFirstOrderTemplateIncreaseQTYAndMoveProduct";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);
			Thread.sleep(5000);		
			String OrderTemplate1 = "//*[contains(text(),'" + OrderTempName_1 + "')]";
			String OrderTemplate2 = "//*[contains(text(),'" + OrderTempName_2 + "')]";
			
			System.out.println("Satya Order Template Name 1 " + OrderTemplate1);
			System.out.println("Satya Order Template Name 2 " + OrderTemplate2);
			
			driver.findElement(By.xpath(OrderTemplate1)).click(); 
			
			Thread.sleep(3000);
			OrderTemp1_PdP_Sku_1 = driver.findElement(By.xpath("//span[@class='ish-itemNumber']")).getText();
			Thread.sleep(3000);	
						
			driver.findElement(By.xpath("//*[@class='ish-actionItemLink kor-open-as-dialog']")).click();	
			Thread.sleep(3000);
			
			boolean visible=driver.findElement(By.xpath("//*[@name='MoveWishlistItemForm_Quantity']")).isDisplayed();
			System.out.println("pop up display" + visible );				
			if (visible)
			{
				driver.findElement(By.xpath("//*[@name='MoveWishlistItemForm_Quantity']")).click();
				driver.findElement(By.xpath("//*[@name='MoveWishlistItemForm_Quantity']")).clear();
				driver.findElement(By.xpath("//*[@name='MoveWishlistItemForm_Quantity']")).sendKeys("2");
			}			
            
			count2 = driver.findElements(By.xpath("//*[@class='ish-field']")).size();
			System.out.println("Size Count " + count2);
			
			boolean TempSelectS = driver.findElement(By.xpath(OrderTemplate2)).isDisplayed();
			System.out.println("Template selection status " + TempSelectS);			
	
			if (TempSelectS && (count2 > 2))
			{
				System.out.println("Template to be selected");
				driver.findElement(By.xpath(OrderTemplate2)).click(); 
			}
					
		    if (webshop.contains("DRDOCI"))
		    {
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@class='primary small']")).click();
		    }
		    else
		    {
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@name='MoveWishlistItem']")).click();
		    }
		    
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@class='ish-button']")).click();
			Thread.sleep(3000);
			
		    if (webshop.contains("OCI"))
		    {
		    	System.out.println("This is an OCI application - DRDOCI");	
		    }
		    else
		    {
		    	testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
		    }			
		}
		

		@Test(description = "Add Product To Order Template From PDP With QTY Five")
		public void addProductToOrderTemplateFromPDPWithQTYFive() throws InterruptedException {
			moduleName = "siteNavigationModule";
			methodName = "addProductToOrderTemplateFromPDPWithQTYFive";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);
			getAndUpdateProductQtyOnPdpPage(5);
//			driver.findElement(By.xpath("//*[@id='Quantity_04138']")).clear();
//			driver.findElement(By.xpath("//*[@id='Quantity_04138']")).sendKeys("5");
			Thread.sleep(3000);
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
		}

		@Test(description = "Add product to Order Template from PDP")
		public void addProductToOrderTemplateFromPDP() throws InterruptedException {
			moduleName = "siteNavigationModule";
			methodName = "addProductToOrderTemplateFromPDP";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);	
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
		}
		
		@Test(description = "Open First Order Template Decrease QTY And Move Product")
		public void openFirstOrderTemplateDecreaseQTYAndMoveProduct() throws InterruptedException {
			moduleName = "siteNavigationModule";
			methodName = "openFirstOrderTemplateDecreaseQTYAndMoveProduct";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);
					driver.findElement(By.xpath("//a[contains(text(),'Order_Template_1')]")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//a[contains(text(),'Verplaats naar andere bestellijst')]")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//*[@name='MoveWishlistItemForm_Quantity']")).clear();
					driver.findElement(By.xpath("//*[@name='MoveWishlistItemForm_Quantity']")).sendKeys("2");
					Thread.sleep(3000);
					driver.findElement(By.xpath("//button[contains(text(),'Verplaats')]")).click();
					Thread.sleep(3000);						
					driver.findElement(By.xpath("//a[contains(text(),'Ok')]")).click();
					Thread.sleep(3000);						
					driver.findElement(By.xpath("//a[contains(text(),'Bestellijsten')]")).click();
					Thread.sleep(3000);
					getvalue1 = "1 Artikelen";
					getvalue2 = "2 Artikelen";
					getvalue7 = driver.findElement(By.xpath("//*[@id='main']/div[3]/div/div/div/table/tbody/tr[2]/td[4]")).getText();
					getvalue6 = driver.findElement(By.xpath("//*[@id='main']/div[3]/div/div/div/table/tbody/tr[3]/td[4]")).getText();
					System.out.println(getvalue7);
					System.out.println(getvalue6);
					if ( (getvalue7.contains(getvalue1)) || (getvalue7.contains(getvalue2)) || (getvalue6.contains(getvalue1)) || (getvalue6.contains(getvalue2)) )  {
						testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
						System.out.println("Pass");
					} else {
						System.out.println("INFO :: Secure page not appear");
						ReportUtil.captureScreenShot();
						System.out.println("Fail");
					}
				}
	
		@Test(description = "Login Customer")
		public void loginForOrderTemplate() throws InterruptedException {
			moduleName = "siteNavigationModule";
			methodName = "loginForOrderTemplate";
			channelLocator="specChannel";
			initialize(moduleName,methodName, channelLocator);
			Thread.sleep(10000);
			if (browser.contains("iexplore")) { // certificate issue in IE 7, 8 and 9
				if (driver.getPageSource().contains("Continue to this website")) {
					driver.get("javascript:document.getElementById('overridelink').click();");
				}
			}
			
			testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
			driver.findElement(By.xpath(mLink.get("loginButton"))).click();
			Thread.sleep(3000); // Don't remove
			
			if (browser.contains("iexplore")) { // certificate issue in IE 7, 8 and 9
				if (driver.getPageSource().contains("Continue to this website")) {
					driver.get("javascript:document.getElementById('overridelink').click();");
				}
			}
			// Fall back code, in case the provided password doesn't work then try an alternate password.
			if (driver.getPageSource().contains("De ingevoerde combinatie van gebruikersnaam en wachtwoord is niet juist. Probeer het nogmaals."))
			{
				driver.findElement(By.id("ShopLoginForm_Password")).clear();
				driver.findElement(By.id("ShopLoginForm_Password")).sendKeys("123456");
				driver.findElement(By.xpath(mLink.get("loginButton"))).click();
			}
			// Fall back code ends
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, "loginButton", driver,channelLocator);
		}
	

		@Test(description = "Go to To Contact Us page")
		public void goToContactUsPage() throws InterruptedException 
		{
			moduleName = "siteNavigationModule";
			methodName = "goToContactUsPage";
			channelLocator="specChannel";
			//comChannel
			initialize(moduleName,methodName, channelLocator);
			//driver.manage().window().maximize();			
			driver.navigate().refresh();
			
			System.out.println("Webshop "+ webshop);
			
		    Thread.sleep(10000);
		    if (webshop.contains("BFS"))
		    {
			   driver.findElement(By.xpath("//*[@id='container']/header/div[2]/div[1]/ul[3]/li[4]/a[1]")).click();
		    }
		    else if (webshop.contains("MLNCLC"))
		    {
			   driver.findElement(By.xpath("//*[@id='container']/header/div[4]/div[2]/ul/li[6]/a")).click();
		    }
		    else if (webshop.contains("MLN"))
		    {
			   driver.findElement(By.xpath("//*[@id='container']/footer/nav/div[2]/div/ul[1]/li[1]/a")).click();
		    }
		    else if (webshop.contains("King"))
		    {
			   driver.findElement(By.xpath("//*[@id='container']/header[1]/div[2]/div[1]/ul[3]/li[3]/a[1]")).click();
		    }
		    else if (webshop.contains("MAJ"))
		    {
			   driver.findElement(By.xpath("//*[@id='container']/header[1]/div[2]/div[1]/ul[3]/li[3]/a[1]")).click();
		    }
		    else if (webshop.contains("WPK"))
		    {
			   driver.findElement(By.xpath("//*[@id='container']/header[1]/div[2]/div[1]/ul[3]/li[3]/a[1]")).click();
		    }
		    else if (webshop.contains("BDD"))
		    {
			   driver.findElement(By.xpath("//*[@id='container']/header[1]/div[2]/div[1]/ul[3]/li[3]/a[1]")).click();
		    }
		    else
		    {
		       System.out.println("Webshop "+ webshop);
			   testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
		    }
			   
			
			if (browser.equals("*iexplore")) 
			{
				if (driver.getPageSource().contains("Continue to this website (not recommended)")) 
				{
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.get("javascript:document.getElementById('overridelink').click();");
					Thread.sleep(5000);
				} else 
				{
					System.out.println("INFO :: Secure page not appear");
				}
			}
			////driver.manage().window().maximize();
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
		}		
	
		
		@Test(description = "Enter Contact Details")
		public void enterContactDetails() throws InterruptedException 
		{
			moduleName = "siteNavigationModule";
			methodName = "enterContactDetails";
			channelLocator="specChannel";
			//comChannel
			//specChannel
			initialize(moduleName,methodName, channelLocator);
			testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
			ReportUtil.captureScreenShot();
			Thread.sleep(3000);
			Select subject = new Select(driver.findElement(By.xpath(webElement.get("subject"))));
			subject.selectByIndex(1);
			testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
		}
		

		@Test(description = "Enter Unregistered Email Address And Click OK Button")
		public void EnterUnregisteredEmailAddressAndClickOKButton() throws InterruptedException {
			moduleName = "siteNavigationModule";
			methodName = "EnterUnregisteredEmailAddressAndClickOKButton";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);	
			String Emailaddress;
			DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
			Date date = new Date();
			String date1= dateFormat.format(date);
			Emailaddress = "Test" + date1 + "@eperiumindia.com";
			driver.findElement(By.xpath("//*[@id='ForgotPasswordStep1Email_Login']")).sendKeys(Emailaddress);
			driver.findElement(By.xpath("//*[@id='ForgotPasswordStep1Email_FirstName']")).sendKeys("Satya");
			driver.findElement(By.xpath("//*[@id='ForgotPasswordStep1Email_LastName']")).sendKeys("Prakash");
			driver.findElement(By.xpath("//*[@name='Step2']")).click();
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
		}
		
		
		@Test(description = "Click On King Logo")
		public void clickOnKingLogo() throws InterruptedException {
			moduleName = "siteNavigationModule";
			methodName = "clickOnKingLogo";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);	
			driver.findElement(By.xpath("//*[@class='logo']")).click();
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
		}
		
		@Test(description = "Click On My Account Link")
		public void clickOnMyAccountLink() throws InterruptedException {
			moduleName = "siteNavigationModule";
			methodName = "clickOnMyAccountLink";
			if (webshop.contains("BDDOCI"))
			{
				channelLocator="specChannel";
			}
			else
			{
				channelLocator="comChannel";
			}
			initialize(moduleName,methodName, channelLocator);
			Thread.sleep(5000);
			testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
			Thread.sleep(5000);
		}
		
		@Test(description = "Click On click On OCI Order History Link")
		public void clickOnOCIOrderHistoryLink() throws InterruptedException {
			moduleName = "siteNavigationModule";
			methodName = "clickOnOCIOrderHistoryLink";
			if (webshop.contains("BDDOCI"))
			{
				channelLocator="specChannel";
			}
			else
			{
				channelLocator="comChannel";
			}
			initialize(moduleName,methodName, channelLocator);
			Thread.sleep(5000);
			testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
			Thread.sleep(5000);
		}

		@Test(description = "Enter Contact Details Only Mandatory Fields")
		public void enterContactDetailsMandatoryFields() throws InterruptedException {
			moduleName = "siteNavigationModule";
			methodName = "enterContactDetailsMandatoryFields";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);
			testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
			ReportUtil.captureScreenShot();
			Thread.sleep(8000);
			testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
		}
	
		@Test(description = "Navigate To User Update Role Page")
		public void navigateToUserUpdateRolePage() throws InterruptedException 
		{
			moduleName = "siteNavigationModule";
			methodName = "navigateToUserUpdateRolePage";
			channelLocator="specChannel";
			initialize(moduleName,methodName, channelLocator);
			driver.findElement(By.xpath("//a[contains(text(),'Gebruikers')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Satya Prakash')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='main']/div[3]/div/div[3]/div[3]/a")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@name='UpdateUserRoleForm_Role']")).click();
			Thread.sleep(3000);
			WebElement selectElement = driver.findElement(By.xpath("//*[@name='UpdateUserRoleForm_Role']"));
			Thread.sleep(3000);
			Select select = new Select(selectElement);
	        List<WebElement> options = select.getOptions();
	         for (int i=0; i<options.size(); i++){
	        	 str[i] = options.get(i).getText();
	        	  System.out.println(options.get(i).getText());
	        	  // System.out.println(str[i]);
	             } 
	         // System.out.println(str);
	         // driver.findElement(By.xpath("//*[@id='container']/header/div[3]/div[1]/a/img")).click();
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
		}		
		
		@Test(description = "Navigate To login page")
		public void goToLoginPage1() throws InterruptedException 
		{
			moduleName = "siteNavigationModule";
			methodName = "goToLoginPage1";
			channelLocator="comChannel"; 
			initialize(moduleName,methodName, channelLocator);
			
			//Click on Logo
			driver.findElement(By.xpath("//*[@class='grid-5']/a")).click();
			
			testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
			
			if (browser.equals("*iexplore")) 
			{
				if (driver.getPageSource().contains("Continue to this website (not recommended)"))
				{
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.get("javascript:document.getElementById('overridelink').click();");
					Thread.sleep(3000);
				} 
				else 
				{
					System.out.println("INFO :: Secure page not appear");
				}
			}
			//driver.manage().window().maximize();
		}	
		
		
		@Test(description = "Navigate To login page")
		public void goToLoginPage2() throws InterruptedException 
		{
			moduleName = "siteNavigationModule";
			methodName = "goToLoginPage2";
			channelLocator="comChannel"; 
			initialize(moduleName,methodName, channelLocator);
			
			driver.findElement(By.xpath("//*[@class='grid-5']/a")).click();
			
			testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
			if (browser.equals("*iexplore")) {
				if (driver.getPageSource().contains("Continue to this website (not recommended)")) {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.get("javascript:document.getElementById('overridelink').click();");
					Thread.sleep(3000);
				} else {
					System.out.println("INFO :: Secure page not appear");
				}
			}
			//driver.manage().window().maximize();
		}	
		
		@Test(description = "Navigate To login page")
		public void goToLoginPage3() throws InterruptedException 
		{
			moduleName = "siteNavigationModule";
			methodName = "goToLoginPage3";
			channelLocator="comChannel"; 
			initialize(moduleName,methodName, channelLocator);
			
			driver.findElement(By.xpath("//*[@class='grid-5']/a")).click();
			
			testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
			if (browser.equals("*iexplore")) {
				if (driver.getPageSource().contains("Continue to this website (not recommended)")) {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.get("javascript:document.getElementById('overridelink').click();");
					Thread.sleep(3000);
				} else {
					System.out.println("INFO :: Secure page not appear");
				}
			}
			//driver.manage().window().maximize();
		}
		
		@Test(description = "Navigate To login page")
		public void goToLoginPage4() throws InterruptedException 
		{
			moduleName = "siteNavigationModule";
			methodName = "goToLoginPage4";
			channelLocator="comChannel"; 
			initialize(moduleName,methodName, channelLocator);
			
			driver.findElement(By.xpath("//*[@class='grid-5']/a")).click();
			
			testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
			if (browser.equals("*iexplore")) {
				if (driver.getPageSource().contains("Continue to this website (not recommended)")) {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.get("javascript:document.getElementById('overridelink').click();");
					Thread.sleep(3000);
				} else {
					System.out.println("INFO :: Secure page not appear");
				}
			}
			//driver.manage().window().maximize();
		}
		
		@Test(description = "Verify Account Admin Role")
		public void verifyUserRole() throws InterruptedException 
		{
			moduleName = "siteNavigationModule";
			methodName = "verifyUserRole";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);	
		}
	
		@Test(description = "Verify Buyer Role")
		public void verifyUserRole1() throws InterruptedException 
		{
			moduleName = "siteNavigationModule";
			methodName = "verifyUserRole1";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);
			
			if (webshop.contains("BFS"))
			{
			    driver.findElement(By.xpath("//*[@class='fa fa-user']")).click();				    
			}
			else if (webshop.contains("BRS"))
			{
			    driver.findElement(By.xpath("//*[@id='container']//label/a")).click();
			}
			else if (webshop.contains("BVP"))
			{
				driver.findElement(By.xpath("//*[@id='kor-infoBox-horizontalGroupRight']/div[1]/p/a")).click();
			    testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);		
			}
			else
			{
				testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);				
			}
		}
		
		
		@Test(description = "Verify Approver Role")
		public void verifyUserRole2() throws InterruptedException {
			moduleName = "siteNavigationModule";
			methodName = "verifyUserRole2";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);	 	
		}
		
		@Test(description = "Logout")
		public void logout1() throws InterruptedException {
			moduleName = "siteNavigationModule";
			methodName = "logout1";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);
			testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
		}
	
		@Test(description = "Remove Product And Verify Cart")
		public void removeProductAndVerifyCart() throws InterruptedException 
		{
			moduleName = "siteNavigationModule";
			methodName = "removeProductAndVerifyCart";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);
			
			count1 = 0;
			count1 = driver.findElements(By.xpath("//*[@class='link remove-product']")).size();
			System.out.println(count1 + "count1");			
			
			if (webshop.contains("OCI"))
			{							
				for (count2=2;count2<count1;count2++) 
				{
					Thread.sleep(10000);
					driver.findElement(By.xpath("//*[@class='link remove-product']")).click(); 
					Thread.sleep(10000);
					System.out.println(count2 + "Count of Number of remove links");
				}
				
				testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
			}
			else
			{
				for (count2=0;count2<count1;count2++) 
				{
					Thread.sleep(10000);
					driver.findElement(By.xpath("//*[@class='link remove-product']")).click(); 
					Thread.sleep(10000);
					System.out.println(count2 + "count2");
				}
				
				testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
			}
			
		}

		@Test(description = "Add Product to Cart From PDP With Qty One")
		public void addProducttoCartFromPDPWithQtyGreaterThenOne() throws InterruptedException 
		{
			moduleName = "siteNavigationModule";
			methodName = "addProducttoCartFromPDPWithQtyGreaterThenOne";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);
			getvalue1 = null;
			getvalue2 = null;
			getvalue3 = null;
			getvalue4 = null;
			System.out.println("Second");
						
			if (browser.contains("PhantomJS")) 
			{
				System.out.println("Phantomjs Browser");			
				String getvalue1 = driver.findElement(By.xpath("//*[@class='ish-productNumber-value']")).getText();
				System.out.println("Satya Product SKU on PDP" + getvalue1);
			}
			else
			{
				Thread.sleep(10000);
				getvalue1 = driver.findElement(By.xpath("//*[@class='ish-productNumber-value']")).getText();
				System.out.println("Product SKU first PDP " + getvalue1);
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("javascript:window.scrollBy(0,-200)");
			}
			
			getAndUpdateProductQtyOnPdpPage(6);		
			
			if (browser.contains("PhantomJS")) 
			{
				System.out.println("Phantomjs Browser");
				
				Actions action = new Actions(driver);
			   	WebElement mainMenu = driver.findElement(By.xpath("//div[@class='container-Addto-cart-button paragraph']//button[@name='addProduct']"));
			    action.moveToElement(mainMenu).click().build().perform();
				
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='desktopAjax']/li/a/i")).click();					
			}
			else
			{
				getvalue1 = driver.findElement(By.xpath("//*[@class='ish-product-detail-page clearfix']//span[@class='ish-productNumber-value']")).getText();
				System.out.println("Product SKU on PDP+ " + getvalue1);
				
				Actions action = new Actions(driver);
		    	WebElement mainMenu = driver.findElement(By.xpath("//*[@name='addProduct']"));
		    	action.moveToElement(mainMenu).click().build().perform();
				
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@class='link kor-minicart-group']")).click();
				
				getvalue2 = driver.findElement(By.xpath("(//span[@class='ish-itemNumber'])[1]")).getText();
				System.out.println("Product SKU on Cart " + getvalue2);
			}	
			
			try
			{
				getvalue2 = driver.findElement(By.xpath("(//span[@class='ish-itemNumber'])[1]")).getText();
				//getvalue3 = driver.findElement(By.xpath("(//span[@class='ish-itemNumber'])[3]")).getText();
					
				System.out.println("SKU First Item on Cart" + getvalue2);
				//System.out.println("SKU Second Item on Cart" + getvalue3);
			}
			catch (NoSuchElementException e) 
			{
				throw e; 
			}	
			if (browser.contains("PhantomJS")) 
			{
				System.out.println("Phantomjs Browser on PDP");
			}
			else
			{
				if (getvalue2.contains(getvalue1))
				{
					testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
				} 
				else 
				{
					throw new InterruptedException("Fail! Add to Cart");
				}
			}	
		}
		
		
		private Object findElement(By xpath) 
		{
			// TODO Auto-generated method stub
			return null;
		}

		public void getAndUpdateProductQtyOnPdpPage(int i) 
		{		
			if (browser.contains("PhantomJS")) 
			{
				System.out.println("Phantomjs Browser on PDP");
				
				//String qtyProp = "//*[@class='ish-productQuantity-input kor-product-qty']";
				//driver.findElement(By.xpath(qtyProp)).clear();
				//driver.findElement(By.xpath(qtyProp)).sendKeys(Integer.toString(i));
			}
			else
			{
				String qtyProp = "//*[@class='ish-productQuantity-input kor-product-qty']";
				driver.findElement(By.xpath(qtyProp)).clear();
				driver.findElement(By.xpath(qtyProp)).sendKeys(Integer.toString(i));
			}

		}	
		

		@Test(description = "Get Address Details")
		public void getAddressDetails() throws InterruptedException 
		{
			moduleName = "siteNavigationModule";
			methodName = "getAddressDetails";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);
			Thread.sleep(5000);

			String addressOnDashboard1;
		    driver.findElement(By.xpath("//*[@class='fa fa-user']")).click();
			addressOnDashboard1 = driver.findElement(By.xpath("//*[@id='preferredDelivery']/div[1]/div[1]/div[2]/div")).getText();
						
			String addressOnDashboard2 = addressOnDashboard1;
			addressOnDashboard = addressOnDashboard1.replace(",","");				
			System.out.println("Customer Address " + addressOnDashboard);
			
			if (addressOnDashboard2.contains(","))
			{
				temp = addressOnDashboard2.split(", ");
				custinfor[1] = temp[0];
				custinfor[2] = temp[1];	
				System.out.println("Customer Address split0 " + custinfor[1]);
				System.out.println("Customer Address split1 " + custinfor[2]);
			}
			else 
			{
				custinfor[1] = custinfor[0];
				custinfor[2] = custinfor[0];
				System.out.println("Customer Address split0 " + custinfor[1]);
				System.out.println("Customer Address split1 " + custinfor[2]);
			}			
			
			Assert.assertNotNull(addressOnDashboard);
		}
	

		@Test(description = "Get And Verify Address Detail On Address Page")
		public void getAndVerifyAddressDetailOnAddressPage() throws InterruptedException {
			
			moduleName = "siteNavigationModule";
			methodName = "getAndVerifyAddressDetailOnAddressPage";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);
			String daOnAddressPage;
		
			daOnAddressPage=driver.findElement(By.xpath("//*[@id='defaultAddress']/div")).getText().replaceAll("\n", " ");
			
			daOnAddressPage = daOnAddressPage.replace(",","");	
			
			System.out.println("DA on Address page " + daOnAddressPage);
			
			Assert.assertTrue(daOnAddressPage.contains(addressOnDashboard));			
		}		
	
		
		@Test(description = "Get And Verify Address Detail On Shipping Page")
		public void getAndVerifyAddressDetailOnShippingPage() throws InterruptedException 
		{
			moduleName = "siteNavigationModule";
			methodName = "getAndVerifyAddressDetailOnShippingPage";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);		
			
			String daOnShippingpage = driver.findElement(By.xpath("//*[@class='info alt']/div/div")).getText().replaceAll("\n", " ");
			
			//daOnShippingpage = daOnShippingpage.replaceAll("", " ");			
			Assert.assertTrue(daOnShippingpage.contains(addressOnDashboard)); 
		}			

		
		@Test(description = "Get And Verify Address Detail On Payment Page")
		public void getAndVerifyAddressDetailOnReviewPage() throws InterruptedException
		{
			moduleName = "siteNavigationModule";
			methodName = "getAndVerifyAddressDetailOnReviewPage";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);
			
			String daOnReviewpage = driver.findElement(By.xpath("//*[@class='info alt']/div/div")).getText().replaceAll("\n", " ");
			
			//daOnReviewpage = daOnReviewpage.replaceAll("", " ");
			Assert.assertTrue(daOnReviewpage.contains(addressOnDashboard)); 
		}	
		
		
		@Test(description = "Get And Verify Address Detail On Confirmation Page")
		public void getAndVerifyAddressDetailOnConfirmationPage() throws InterruptedException 
		{
			moduleName = "siteNavigationModule";
			methodName = "getAndVerifyAddressDetailOnConfirmationPage";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);
			
			boolean w = false;
			boolean x = false;
			boolean y = false;
			boolean z = false;
			
			str1[6] = driver.findElement(By.xpath("//*[@class='info'][1]/div/address")).getText();
			
			
			System.out.println("------------------");
			System.out.println("Confirmation Page Address " + "\n" + str1[6]);		
			System.out.println("------------------");

						
			str1[6] = str1[6].replace("\n"," ");
						
			System.out.println("Customer Address on order confirmation page " + str1[6]);

			System.out.println("Customer Address on Dashboard0 " + custinfor[1]);
			System.out.println("Customer Address on Dashboard1 " + custinfor[2]);
							
			w = str1[6].contains(custinfor[1]);
			x = str1[6].contains(custinfor[2]);
			
			y = w && x;

			if (y)
			{
				testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
			}
			else
			{
	       	 	Assert.assertTrue(x,"Incorrect Address Found"); 
			}
		}		
		

		@Test(description = "Get Product Sku And Navigate To Quote Page")
		public void getProductSkuAndOpenQuotePopUp() throws InterruptedException 
		{
			moduleName = "siteNavigationModule";
			methodName = "getProductSkuAndOpenQuotePopUp";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);
			getvalue1 = driver.findElement(By.xpath("//*[@class='ish-productNumber-value']")).getText();
			//temp = getvalue1.split(": ");
			temp[1] = getvalue1;
			driver.findElement(By.xpath("(//*[@class='ish-link kor-add-to-wishlist-submit'])[1]")).click();
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
			//driver.findElement(By.xpath("(//*[@class='ish-bar-actionButton ish-button-secondary']")).click();
		}	
		

		@Test(description = "Verify Quote Page")
		public void verifyQuote() throws InterruptedException 
		{
			moduleName = "siteNavigationModule";
			methodName = "verifyQuote";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);
			getvalue1 = driver.findElement(By.xpath("//*[@class='ish-itemNumber']")).getText();
			String temp1[] = new String[3];
			temp1 = getvalue1.split("# ");
			System.out.println("Satya Quote");
			System.out.println(temp[1]);
			System.out.println(temp1[1]);
			System.out.println("Satya");
			boolean x = false;
			x = temp[1].equals(temp1[1]);
			String tp = "//*[contains(text(),'" + temp1[1] +  "')]" ;
			boolean visible=driver.findElement(By.xpath(tp)).isDisplayed();
			if (visible)
				testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
			else
	       	 	Assert.assertTrue(x,"Issue In Creating Quote"); 
		}
		
		
		@Test(description = "Send Quote Details")
		public void sendQuoteDetails() throws InterruptedException 
		{
			moduleName = "siteNavigationModule";
			methodName = "sendQuoteDetails";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);
			
			driver.findElement(By.xpath(".//*[@name='submit']")).click();
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
		}	
		
	
		@Test(description = "Get Customer Address")
		public void getCustomerAddress() throws InterruptedException 
		{
			moduleName = "siteNavigationModule";
			methodName = "getCustomerAddress";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);
			String temp[] = new String[2];
			
		    driver.findElement(By.xpath("//*[@class='loggedin-links']/li[2]/a/span")).click();
			custinfor[0] = driver.findElement(By.xpath("//*[@id='preferredDelivery']/div[1]/div[1]/div[2]/h4")).getText();
		    
//			driver.findElement(By.xpath("(//*[@class='right'])[2]")).click();
									
			if (custinfor[0].contains(","))
			{
				temp = custinfor[0].split(", ");
				custinfor[1] = temp[0];				
				custinfor[2] = temp[1];					
			}
			else 
			{
				custinfor[1] = custinfor[0];
				custinfor[2] = custinfor[0];
			}
			
			System.out.println("Customer info (Address) at Home/My Account page");	
			System.out.println("cust infor 1 Delivery Address " + custinfor[1]);
			System.out.println("cust infor 2 Customer Name " + custinfor[2]);
			
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
		}	
		
		
		@Test(description = "Get Customer Name")
		public void getCustomerName() throws InterruptedException 
		{
			moduleName = "siteNavigationModule";
			methodName = "getCustomerName";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);
			
			if (webshop.equals("BFS"))
			{
				  driver.findElement(By.xpath("//*[@class='fa fa-user']")).click();
				  String strMain = driver.findElement(By.xpath("//*[@id='main']/div[3]/aside/nav[1]/ul[1]/li/h3")).getText();
				  String[] arrSplit = strMain.split(", ");
				  System.out.println(arrSplit[1]);
				  System.out.println(arrSplit[0]);
				  custinfor[5] = arrSplit[1] + " " + arrSplit[0];	
				  
				  System.out.println("Customer info (Name) at Home/My Account page");			
				  System.out.println(custinfor[5]);
					
				  testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);					
			}			
			else if	(webshop.equals("BFSOCI-NL-Test"))
			{
				 System.out.println("Customer info (Name) at Home/My Account page entered BFS OCI");
				 //driver.findElement(By.xpath("//*[@class='fa fa-user']")).click();
				 String strMain = driver.findElement(By.xpath("(.//*[@class='right'])[2]")).getText();
				 String[] arrSplit = strMain.split(" ");
				 System.out.println(arrSplit[1]);
				 System.out.println(arrSplit[0]);
				 custinfor[5] = arrSplit[0] + " " + arrSplit[1];
				 //System.out.println(strMain);

				 System.out.println("Customer info (Name) at Home/My Account page");			
				 System.out.println(custinfor[5]);
			}	
			else if	(webshop.equals("DRDOCI-NL-Test"))
			{
				 System.out.println("Customer info (Name) at Home/My Account page entered DRD OCI");
				 String strMain = driver.findElement(By.xpath("(.//*[@class='right'])[2]")).getText();
				 String[] arrSplit = strMain.split(" ");
				 System.out.println(arrSplit[1]);
				 System.out.println(arrSplit[0]);
				 custinfor[5] = arrSplit[0] + " " + arrSplit[1];
				 
				 System.out.println("Customer info (Name) at Home/My Account page");			
				 System.out.println(custinfor[5]);				 
			}	
			else if	(webshop.equals("GLOOCI-NL-Test"))
			{
				 System.out.println("Customer info (Name) at Home/My Account page entered GLO OCI");
				 String strMain = driver.findElement(By.xpath("(.//*[@class='right'])[2]")).getText();
				 String[] arrSplit = strMain.split(" ");
				 System.out.println(arrSplit[1]);
				 System.out.println(arrSplit[0]);
				 custinfor[5] = arrSplit[0] + " " + arrSplit[1];
				 
				 System.out.println("Customer info (Name) at Home/My Account page");			
				 System.out.println(custinfor[5]);
			}
			else
			{			   
				String strMain = driver.findElement(By.xpath("//*[@id='main']/div[3]/aside/nav[1]/ul[1]/li/h3")).getText();
				System.out.println(strMain);
				String[] arrSplit = strMain.split(", ");
				System.out.println(arrSplit[1]);
				System.out.println(arrSplit[0]);
				custinfor[5] = arrSplit[0] + " " + arrSplit[1];		
				
				System.out.println("Customer info (Name) at Home/My Account page");			
				System.out.println(custinfor[5]);
				
				testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
			}	
		}
		

		@Test(description = "Get And Verify Customer Detail On Address Page")
		public void getAndVerifyCustomerDetailOnAddressPage() throws InterruptedException 
		{
			moduleName = "siteNavigationModule";
			methodName = "getAndVerifyCustomerDetailOnAddressPage";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);
			
			boolean w = false;
			boolean x = false;
			boolean y = false;
			boolean z = false;
            
			if (webshop.equals("BFSOCI-NL-Test"))
			{			
				 JavascriptExecutor js = (JavascriptExecutor) driver;
				 js.executeScript("javascript:window.scrollBy(0,-200)");				
				
				 custinfor[6] = driver.findElement(By.xpath(".//*[@class='info alt']/div/div")).getText();
				 System.out.println(custinfor[6]);			
				 System.out.println(custinfor[5]);									
				 //w = custinfor[6].contains(custinfor[1]);
				 //System.out.println(w);
				 //x = custinfor[6].contains(custinfor[2]);
				 //System.out.println(x);
				 y = custinfor[6].contains(custinfor[5]);
				 System.out.println(y);			
				 System.out.println("Customer info (Name and Address) at Address page");			
				 System.out.println(custinfor[6]);
				 //System.out.println(custinfor[1]);
				 //System.out.println(custinfor[2]);
				 System.out.println(custinfor[5]);
			}
			else if (webshop.equals("DRDOCI-NL-Test"))
			{			
				 JavascriptExecutor js = (JavascriptExecutor) driver;
				 js.executeScript("javascript:window.scrollBy(0,-200)");				
				
				 custinfor[6] = driver.findElement(By.xpath(".//*[@class='info alt']/div/div")).getText();
				 System.out.println(custinfor[6]);			
				 System.out.println(custinfor[5]);									
				 //w = custinfor[6].contains(custinfor[1]);
				 //System.out.println(w);
				 //x = custinfor[6].contains(custinfor[2]);
				 //System.out.println(x);
				 y = custinfor[6].contains(custinfor[5]);
				 System.out.println(y);			
				 System.out.println("Customer info (Name and Address) at Address page");			
				 System.out.println(custinfor[6]);
				 //System.out.println(custinfor[1]);
				 //System.out.println(custinfor[2]);
				 System.out.println(custinfor[5]);
			}
			else if (webshop.equals("GLOOCI-NL-Test"))
			{			
				 JavascriptExecutor js = (JavascriptExecutor) driver;
				 js.executeScript("javascript:window.scrollBy(0,-200)");				
				
				 custinfor[6] = driver.findElement(By.xpath(".//*[@class='info alt']/div/div")).getText();
				 System.out.println(custinfor[6]);				 
				 System.out.println(custinfor[5]);									
				 //w = custinfor[6].contains(custinfor[1]);
				 //System.out.println(w);
				 //x = custinfor[6].contains(custinfor[2]);
				 //System.out.println(x);
				 y = custinfor[6].contains(custinfor[5]);
				 System.out.println(y);			
				 System.out.println("Customer info (Name and Address) at Address page");			
				 System.out.println(custinfor[6]);
				 //System.out.println(custinfor[1]);
				 //System.out.println(custinfor[2]);
				 System.out.println(custinfor[5]);
			}
			else
			{							
				custinfor[6] = driver.findElement(By.xpath(".//*[@id='defaultAddress']/div")).getText();
				System.out.println(custinfor[6]);	
				System.out.println("Test");
				System.out.println(custinfor[5]);									
				w = custinfor[6].contains(custinfor[1]);
				System.out.println(w);
				x = custinfor[6].contains(custinfor[2]);
				System.out.println(x);
				y = custinfor[6].contains(custinfor[5]);				
				System.out.println(y);
				
				System.out.println("Customer info (Name and Address) at Address page");			
				System.out.println(custinfor[6]);
				System.out.println(custinfor[1]);
				System.out.println(custinfor[2]);
				System.out.println(custinfor[5]);
			}
			
			if (x)
				if (webshop.contains("OCI"))
				{
					System.out.println("Customer info is OK for OCI application");	
				}
				else
				{
					testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
		        }
			else
		       	Assert.assertTrue(z,"Incorrect Customer Info");  
		}		
	
		
		@Test(description = "Get And Verify Customer Detail On Shipping Page")
		public void getAndVerifyCustomerDetailOnShippingPage() throws InterruptedException 
		{
			moduleName = "siteNavigationModule";
			methodName = "getAndVerifyCustomerDetailOnShippingPage";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);		
			custinfor[7] = driver.findElement(By.xpath("//*[@class='info alt'][1]//div/div")).getText();
			
			boolean w = false;
			boolean x = false;
			boolean y = false;
			boolean z = false;
						
			w = custinfor[7].contains(custinfor[1]);
			x = custinfor[7].contains(custinfor[2]);
			y = custinfor[7].contains(custinfor[5]);
			
			System.out.println("Customer info (Name and Address) at Shipping page");			
			System.out.println(custinfor[7]);
			System.out.println(custinfor[1]);
			System.out.println(custinfor[2]);
			System.out.println(custinfor[5]);
			
			z = x && y && w;
			if (z)
				testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
			else
	       	 	Assert.assertTrue(z,"Incorrect Customer Info");  
		}			
		
		
		@Test(description = "Get And Verify Customer Detail On Payment Page")
		public void getAndVerifyCustomerDetailOnPaymentPage() throws InterruptedException 
		{
			moduleName = "siteNavigationModule";
			methodName = "getAndVerifyCustomerDetailOnPaymentPage";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);
			
			custinfor[8] = driver.findElement(By.xpath("//*[@class='info alt'][1]//div/div")).getText();
									
			boolean w = false;
			boolean x = false;
			boolean y = false;
			boolean z = false;
									
			w = custinfor[8].contains(custinfor[1]);
			x = custinfor[8].contains(custinfor[2]);
			y = custinfor[8].contains(custinfor[5]);
			
			System.out.println("Customer info (Name and Address) at Payment page");			
			System.out.println(custinfor[8]);
			System.out.println(custinfor[1]);
			System.out.println(custinfor[2]);
			System.out.println(custinfor[5]);
			
			z = x && y && w;
			if (z)
				testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
			else
	       	 	Assert.assertTrue(z,"Incorrect Customer Info"); 
		}
		
		
		@Test(description = "Get And Verify Customer Detail On Confirmation Page")
		public void getAndVerifyACustomerDetailOnConfirmationPage() throws InterruptedException 
		{
			moduleName = "siteNavigationModule";
			methodName = "getAndVerifyACustomerDetailOnConfirmationPage";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);
			
			custinfor[9] = driver.findElement(By.xpath("//*[@class='adreess-wrapper']")).getText();
			custinfor[10] = driver.findElement(By.xpath("//*[@class='ish-address']/div[2]")).getText();
								
			System.out.println(custinfor[9]);			
			System.out.println(custinfor[10]);
			
			System.out.println("Customer info (Name and Address) at Payment page");	
			System.out.println(custinfor[1]);			
			System.out.println(custinfor[2]);			
			System.out.println(custinfor[5]);
			
			
			boolean w = false;
			boolean x = false;
			boolean y = false;
			boolean z = false;
			
			w = custinfor[9].contains(custinfor[1]);
			x = custinfor[9].contains(custinfor[2]);
			y = custinfor[10].contains(custinfor[5]);				

			z = x && y && w;
			Assert.assertTrue(z,"Incorrect Customer Info"); 
		}
		
	
		@Test(description = "Uncheck Terms Checkbox")
		public void uncheckTermsCheckbox() throws InterruptedException 
		{
			moduleName = "siteNavigationModule";
			methodName = "uncheckTermsCheckbox";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);
			
			if (driver.findElements(By.xpath("//*[@class='kor-noLabelErrorColor']")).size() > 0)
			{
				//driver.findElement(By.xpath("//*[@name='sendOrder']")).click();	
				driver.findElement(By.xpath("//*[@class='kor-submit place-order-btn']")).click();
				testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
			}
						
		}	

		
		@Test(description = "order to default order template")
		public void validateOrdertoDefaultOrderTemplate() throws InterruptedException, ParseException 
		{
			   moduleName = "orderTemplate";
			   methodName = "validateOrdertoDefaultOrderTemplate";
			   channelLocator="comChannel";
			   initialize(moduleName,methodName, channelLocator);
			   boolean act;
			   boolean exp=true;
			   //fetching all sku from cart
			   ArrayList<String> cartSku = new ArrayList<String>();
			  
			   List<WebElement> qSKU = driver.findElements(By.xpath("//table/tbody/tr/td[2]/div/div[2]"));
			   int size1=qSKU.size();
			   System.out.println(size1);
			   
			   for (WebElement gsku: qSKU) 
			   {
				   String sup=gsku.getText();
				   System.out.println(sup);
				   String spl[]=sup.split(" ");
				   String sup1=spl[spl.length-1];
				   cartSku.add(sup1); 		   
			   }
			   
			   System.out.println("cartSku "+cartSku);
			       
			   //go to My account
			   Thread.sleep(10000);
			   if (webshop.contains("MAJ-NL-Test"))
			   {
				   driver.findElement(By.xpath("//*[@class='ish-infoBox-content']//a")).click();
				   
				   WebDriverWait wait=new WebDriverWait(driver, 10);
				   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='kor-infoBox-horizontalGroupRight']//p/a")));
				   
				   //go to order template
			       driver.findElement(By.xpath("//*[@id='kor-infoBox-horizontalGroupRight']//p/a")).click();
			       Thread.sleep(5000);
			   }
			   else if (webshop.contains("MLN"))
			   {
				   driver.findElement(By.xpath("//*[@class='paragraph logo checkout-logo']")).click();
				   driver.findElement(By.xpath("//*[@class='fa fa-list']")).click();
			   }
			   else if (webshop.contains("BDD"))
			   {
				   driver.findElement(By.xpath("//*[@class='paragraph logo checkout-logo']")).click();
				   driver.findElement(By.xpath("//*[@class='fa fa-list']")).click();
			   }
			   else
			   {
				   driver.findElement(By.xpath("//*[@class='ish-infoBox-content']/a")).click();
				   
				   WebDriverWait wait=new WebDriverWait(driver, 10);
				   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='kor-infoBox-horizontalGroupRight']//p/a")));
				   
				   //go to order template
			       driver.findElement(By.xpath("//*[@id='kor-infoBox-horizontalGroupRight']//p/a")).click();
			       Thread.sleep(5000);
			   }
		       
		       //open default order template
		       if (driver.findElements(By.xpath("//*[text()[contains(.,'Onlangs bestelde artikelen')]]")).size() >0 )
		       {
		           driver.findElement(By.xpath("//*[text()[contains(.,'Onlangs bestelde artikelen')]]")).click(); 
		       }
		       else if (driver.findElements(By.xpath("//*[text()[contains(.,'Zuletzt gekaufte Artikel')]]")).size() >0 )
		       {
		           driver.findElement(By.xpath("//*[text()[contains(.,'Zuletzt gekaufte Artikel')]]")).click(); 
		       }
		       else if (driver.findElements(By.xpath("//*[text()[contains(.,'Senest bestilte varer')]]")).size() >0 )
		       {
		           driver.findElement(By.xpath("//*[text()[contains(.,'Senest bestilte varer')]]")).click(); 
		       }
		       else if (driver.findElements(By.xpath("//*[text()[contains(.,'Online bestelhistorie laatste 3 maanden')]]")).size() >0 )
		       {
		           driver.findElement(By.xpath("//*[text()[contains(.,'Online bestelhistorie laatste 3 maanden')]]")).click(); 
		       }
		       else if (driver.findElements(By.xpath("//*[text()[contains(.,'Recently Ordered Items')]]")).size() >0 )
		       {
		           driver.findElement(By.xpath("//*[text()[contains(.,'Recently Ordered Items')]]")).click(); 
		       }
		       else if (driver.findElements(By.xpath("//*[text()[contains(.,'RecentOrderedProducts')]]")).size() >0 )
		       {
		           driver.findElement(By.xpath("//*[text()[contains(.,'RecentOrderedProducts')]]")).click(); 
		       }
			         
			   //fetching all sku order template
		       ArrayList<String> otsku = new ArrayList<String>();
		       List<WebElement> oSKU = driver.findElements(By.xpath("//span[@class='ish-itemNumber']"));
			               
			   int size11=oSKU.size();
			   System.out.println("Satya Size 11 Value");
			   System.out.println(size11);
			   
			   for (WebElement gsku: oSKU) 
			   {
				    String sup=gsku.getText();
				    String spl[]=sup.split("# ",2);
				    String sup1=spl[1];
				    otsku.add(sup1); 		    
			   }
			   
			   System.out.println(otsku); 
			   Set<String> uSku = new HashSet<String>();
			   Set<String> set1 = new HashSet<String>(cartSku);
			   Set<String> set2 = new HashSet<String>(otsku);
			   Set<String> intersection = new HashSet<String>(set1);
			   intersection.retainAll(set2);
			     
			   System.out.println(intersection);
			   act=set1.equals(intersection);
			     
			   if(!act)
			   {
			      System.out.println("Not all/all Ordered products are not present in Default order template");
			      Assert.assertEquals(act,exp);
			   }
			   else
			   {
	               System.out.println("Now Ordered products are present in Default order template");
	               for(int i=2;i<size11+2;i++)
	               {
		                String date1=driver.findElement(By.xpath("//*[@class='ish-productTable wishlistLazyLoadItemTable']//tr["+i+"]/td[5]")).getText();
		                System.out.println("date1="+date1);
		                char separate =date1.charAt(2);
		                String separate1=Character.toString(separate);
		                System.out.println(separate1);       
		                DateFormat dateFormat=new SimpleDateFormat("dd"+separate1+"MM"+separate1+"yyyy");
		                Date date=new Date();
		                System.out.println(dateFormat.format(date));
		                String uDate=dateFormat.format(date);
		                System.out.println("uDate"+uDate);
		                // Date uDate1=dateFormat.parse(date1);
		                // System.out.println("uDate1"+uDate1);
		                
		                if(date1.equals(uDate))
		                {
			                 String uSkuid=driver.findElement(By.xpath("//*[@class='ish-productTable']//tr["+i+"]/td[3]/span")).getText();
			                 String spl1[]=uSkuid.split("# ",2);
			                 String sup1=spl1[1];
			                 uSku.add(sup1);		                
		                }
		                
		                System.out.println(uSku);
		                System.out.println(set1);
		            }
		            boolean result2=uSku.containsAll(set1);
		            System.out.println("result2"+result2);
		            Assert.assertTrue(result2);			               
			   }			 
	}
		
	
	@Test(description = "validate quantity =1 in default order template")
	public void validateQtyInOrderTemplate() throws InterruptedException
	{
		moduleName = "orderTemplate";
		methodName = "validateQtyInOrderTemplate";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		//boolean isOne=true;
		Assert.assertTrue(chkQTYEqualsOne());
	}


	@Test(description = "fetch all sku from list view & input sku in quick order from and add to cart")
	 public void quickOrdertoCart() throws InterruptedException
	 {
		moduleName = "quickorderform";
		methodName = "quickOrdertoCart";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		String skuID=null;
		ArrayList<String> sku = new ArrayList<String>();
		//fetch all listed sku
		Thread.sleep(5000);
		
		count2 = driver.findElements(By.xpath("//*[@class='ish-product-image xl1']")).size();
		System.out.println("TEST " + count2);
		if (count2 != 0)
		{		 
			if (webshop.contains("King"))
			{
				System.out.println("List view " + webshop);
				List<WebElement> allsku = driver.findElements(By.xpath("//*[@class='ish-productNumber-value']"));	            
																		
				//*[@class='ish-productNumber-value']
				int size = allsku.size();
			    System.out.println("size"+size);
			    
			    for ( WebElement gsku: allsku) 
			    {
			           sku.add(gsku.getText()); 
			    }
			    sku.removeAll(Arrays.asList("", null));
			    System.out.println("sku Values " + sku);
			}		 
			else if (webshop.contains("MLN-DK-Test"))
			{
				System.out.println("List view " + webshop);
				List<WebElement> allsku = driver.findElements(By.xpath("//*[@id='product-search-result']/div/div[6]/ul[*]/li/div[2]/div/a/div[2]/div[3]/div[2]"));	            
																		
				//*[@class='ish-productNumber-value']
				int size = allsku.size();
			    System.out.println("size"+size);
			    
			    for (WebElement gsku: allsku) 
			    {
			           sku.add(gsku.getText()); 
			    }
			    sku.removeAll(Arrays.asList("", null));
			    System.out.println("sku Values " + sku);
			}
			else if (webshop.contains("MLNCLC-DK-Test"))
			{
				System.out.println("List view CLC Application " + webshop);
				List<WebElement> allsku = driver.findElements(By.xpath("//*[@class='ish-productNumber-value']"));	            
																		
				//*[@class='ish-productNumber-value']
				int size = allsku.size();
			    System.out.println("size "+size);
			    
			    for (WebElement gsku: allsku) 
			    {
			           sku.add(gsku.getText()); 			           
			    } 
			    sku.removeAll(Arrays.asList("", null));
			    System.out.println("sku Values " + sku);
			}
			else if (webshop.contains("BDD"))
			{
				count1 = driver.findElements(By.xpath("//*[@class='button right icon fa fa-th-list']")).size();
				System.out.println("TEST+++ " + count1);			
				
				Thread.sleep(10000);
				if (count1 != 0)
				{
					System.out.println("list view disabled " + webshop);
					driver.findElement(By.xpath("//*[@class='button right icon fa fa-th-list']")).click();
							
					Thread.sleep(10000);	
				}
				
				System.out.println("List view BDD Application " + webshop);
				List<WebElement> allsku = driver.findElements(By.xpath("//*[@class='ish-productNumber-value']"));	            
																		
				//*[@class='ish-productNumber-value']
				int size = allsku.size();
			    System.out.println("size "+size);
			    
			    for (WebElement gsku: allsku) 
			    {
			           sku.add(gsku.getText()); 			           
			    } 
			    sku.removeAll(Arrays.asList("", null));
			    System.out.println("sku Values " + sku);
			}
			else
			{
					System.out.println("List view " + webshop);
					List<WebElement> allsku = driver.findElements(By.xpath("//*[@class='ish-productNmuber-value']"));	            
																			
					//*[@class='ish-productNumber-value']
					int size = allsku.size();
				    System.out.println("size"+size);
				    
				    for ( WebElement gsku: allsku) 
				    {
				           sku.add(gsku.getText()); 
				    }
				    sku.removeAll(Arrays.asList("", null));
				    System.out.println("sku Values Grid " + sku);			
			}
		}
		else
		{
			if (webshop.contains("BDD-DK-Test"))
			{
				count1 = driver.findElements(By.xpath("//*[@class='button right icon fa fa-th-list']")).size();
				System.out.println("TEST+++ " + count1);			
				
				Thread.sleep(10000);
				if (count1 != 0)
				{
					System.out.println("list view disabled " + webshop);
					driver.findElement(By.xpath("//*[@class='button right icon fa fa-th-list']")).click();
							
					Thread.sleep(10000);	
				}
				
				System.out.println("List view BDD Application " + webshop);
				List<WebElement> allsku = driver.findElements(By.xpath("//*[@class='ish-productNumber-value']"));	            
																		
				//*[@class='ish-productNumber-value']
				int size = allsku.size();
			    System.out.println("size "+size);
			    
			    for (WebElement gsku: allsku) 
			    {
			           sku.add(gsku.getText()); 			           
			    } 
			    sku.removeAll(Arrays.asList("", null));
			    System.out.println("sku Values " + sku);
			}
			else
			{
				System.out.println("Gried View " + webshop);
				List<WebElement> allsku = driver.findElements(By.xpath("//*[@id='ish-productTile-size']/div/div/div[1]/span[2]"));
			    
				//*[@class='ish-productNumber-value']
				int size = allsku.size();
			    System.out.println("size"+size);
			    
			    for ( WebElement gsku: allsku) 
			    {
			           sku.add(gsku.getText()); 
			    }
			    sku.removeAll(Arrays.asList("", null));
			    System.out.println("sku Values " + sku);
			}
		}
		
		if (webshop.contains("BDD"))		
		{	
			//access quick order page
			driver.findElement(By.xpath("//*[@id='container']/footer/nav/div[1]/div[2]/ul/li[1]/a")).click();
			Thread.sleep(5000);
		}
		else if (webshop.contains("BFS"))		
		{	
			//access quick order page
			driver.findElement(By.xpath("//*[@id='container']/footer[1]/nav[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")).click();
			Thread.sleep(5000);
		}
		else if (webshop.contains("MLN"))		
		{	
			//access quick order page
			driver.findElement(By.xpath("//*[@id='container']/footer[1]/nav[1]/div[1]/div[2]/ul[1]/li[1]/a[1]")).click();
			Thread.sleep(5000);
		}
		else
		{
			//access quick order page
			driver.findElement(By.xpath("//button[@class='primary quick']")).click();
			Thread.sleep(5000);	
		}

	    //input sku in quick order form
	    List<WebElement> inputSKU = driver.findElements(By.xpath("//*[@id='quickorderForm']/div[1]//input[1]"));
	    
	    Iterator itr = sku.iterator();
	    for (WebElement iSKU: inputSKU)
	    {
	       while(itr.hasNext())
	       {  
	    	   skuID=(String) itr.next();
	    	   break;
	       }
	       iSKU.sendKeys(skuID);       
	    }
	    
	    //input quantity in quick order form
	    List<WebElement> inputQTY = driver.findElements(By.xpath("//*[@id='quickorderForm']/div[1]//input[2]"));
	    Random ran=new Random();
	    int ranNum;
	    String qty;
	    
	    for (WebElement iQTY: inputQTY)
	    {
	     
	        ranNum=ran.nextInt(10);
	        qty=String.valueOf(ranNum+1);
	        iQTY.sendKeys(qty);   
	    }
	    
	    Thread.sleep(15000);
	    driver.findElement(By.xpath("//*[@id='quickorderForm']//button[1]")).click();
	    Thread.sleep(15000);
	    
	    ArrayList<String> cartSku = new ArrayList<String>();
	    List<WebElement> qSKU = driver.findElements(By.xpath("//td[@class='ish-productQuantity']"));
	    
	    int size1=qSKU.size();
	    System.out.println(size1);
	    for ( WebElement gsku: qSKU) 
	    {
		     String sup=gsku.getText();
		     System.out.println(sup);
		     String spl[]=sup.split(" ");
		     String sup1=spl[spl.length-1];
		     cartSku.add(sup1); 
		     System.out.println("sup1"  + sup1);
	    }
	    System.out.println("cartSku"+cartSku);
	         
	    boolean result= sku.containsAll(cartSku);
	    Assert.assertTrue(result);	  
	 }
	
		
	// Quick Order Form-Satya Prakash	
	@Test(description = "validate quick order with no value in sku and quantity field ")
	public void chkBlankSkuQty() throws InterruptedException
	{
		moduleName = "quickorderform";
		methodName = "chkBlankSkuQty";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		
		System.out.println("Quick Order Form " + webshop);
		
		if (webshop.contains("King"))		
		{
			if (driver.findElements(By.xpath("//*[@class='primary quick']")).size() > 0)
			{
				driver.findElement(By.xpath("//*[@class='primary quick']")).click();				
				
			int count = driver.findElements(By.name("addToCart")).size();
			System.out.println("two add to carts"+count);					
			driver.findElement(By.xpath("(.//*[@class='ish-button show-spinner'])[1]")).click();
			
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);	
		}	
			else
			{
				System.out.println("Quick order button is not visible for this channel");
			}
		}
		else if (webshop.contains("WPK"))		
		{
			if (driver.findElements(By.xpath("//*[@class='primary quick']")).size() > 0)
			{
				driver.findElement(By.xpath("//*[@class='primary quick']")).click();
				int count = driver.findElements(By.name("addToCart")).size();
				System.out.println("two add to carts"+count);					
				 driver.findElement(By.xpath("(.//*[@class='ish-button show-spinner'])[1]")).click();
			  testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);	
			}		
			else
			{
				System.out.println("Quick order button is not visible for this channel");
			}
		}
		else if (webshop.contains("GLOOCI"))		
		{
			if (driver.findElements(By.xpath("//*[@class='primary quick']")).size() > 0)
			{
				driver.findElement(By.xpath("//*[@class='primary quick']")).click();
				int count = driver.findElements(By.name("addToCart")).size();
				System.out.println("two add to carts"+count);					
				driver.findElement(By.xpath("(.//*[@class='ish-button show-spinner'])[1]")).click();
			    testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);	
			}		
			else
			{
				System.out.println("Quick order button is not visible for this channel");
			}
		}
		else if (webshop.contains("DRDOCI"))		
		{
			if (driver.findElements(By.xpath("//*[@class='primary quick']")).size() > 0)
			{
				driver.findElement(By.xpath("//*[@class='primary quick']")).click();
				
				int count = driver.findElements(By.name("addToCart")).size();
				System.out.println("two add to carts "+count);	
				
				//driver.findElement(By.name("addToCart")).click();
				
				driver.findElement(By.xpath("(.//*[@class='ish-button show-spinner'])[1]")).click();
				
			    testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);	
			}		
			else
			{
				System.out.println("Quick order button is not visible for this channel");
			}
		}		
		else if (webshop.contains("BFS"))		
		{
			if (driver.findElements(By.xpath("//*[@id='container']/footer[1]/nav[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")).size() > 0)
			{
				driver.findElement(By.xpath("//*[@id='container']/footer[1]/nav[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")).click();
				
				int count = driver.findElements(By.name("addToCart")).size();
				System.out.println("two add to carts"+count);					
				 driver.findElement(By.xpath("(.//*[@class='ish-button show-spinner'])[1]")).click();
				testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);	
			}		
			else
			{
				System.out.println("Quick order button is not visible for this channel");
			}
		}
		else if (webshop.contains("OCI"))
		{
			if (driver.findElements(By.xpath("//*[@class='primary quick']")).size() > 0)
			{
				driver.findElement(By.xpath("//*[@class='primary quick']")).click();
				
				int count = driver.findElements(By.name("addToCart")).size();
				System.out.println("two add to carts "+count);	
				
				//driver.findElement(By.name("addToCart")).click();
				
				driver.findElement(By.xpath("(.//*[@class='ish-button show-spinner'])[1]")).click();
				
			    testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);	
			}		
			else
			{
				System.out.println("Quick order button is not visible for this channel");
			}
		}
		else
		{
			if (driver.findElements(By.xpath("//*[@id='container']/footer/nav/div[1]/div[2]/ul/li[1]/a")).size() > 0)
			{
				driver.findElement(By.xpath("//*[@id='container']/footer/nav/div[1]/div[2]/ul/li[1]/a")).click();
				
				int count = driver.findElements(By.name("addToCart")).size();
				System.out.println("two add to carts"+count);					
				 driver.findElement(By.xpath("(.//*[@class='ish-button show-spinner'])[1]")).click();
				testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);	
			}		
			else
			{
				System.out.println("Quick order button is not visible for this channel");
			}
		}
	}
	
	
	@Test(description = "validate quick order with no value in sku field ")
	public void chkBlankSku() throws InterruptedException
	{
		moduleName = "quickorderform";
		methodName = "chkBlankSku";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		if (driver.findElements(By.xpath("//*[@class='primary quick']")).size() > 0)
		{
			testCaseUtil.checkAllFormElements(moduleName, methodName,driver,channelLocator);
			driver.findElement(By.name("addToCart")).click();
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);		
		}
		else
		{
			System.out.println("Quick order button is not visible for this channel");
		}
	}
	
	
	@Test(description = "validate quick order with no value in quantity field ")
	public void chkBlankQty() throws InterruptedException
	{
		moduleName = "quickorderform";
		methodName = "chkBlankQty";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		if (driver.findElements(By.xpath("//*[@class='primary quick']")).size() > 0)
		{
			testCaseUtil.checkAllFormElements(moduleName, methodName,driver,channelLocator);
			driver.findElement(By.name("addToCart")).click();
			Thread.sleep(5000);
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);	
		}
		else
		{
			System.out.println("Quick order button is not visible for this channel");
		}
	}
	
	
	@Test(description = "validate reset in quick order form")
	public void resetQuickOrderForm() throws InterruptedException
	{
		moduleName = "quickorderform";
		methodName = "resetQuickOrderForm";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		if (driver.findElements(By.xpath("//*[@class='primary quick']")).size() > 0)
		{
			testCaseUtil.processElements(mLink, "click", moduleName, methodName,  driver, channelLocator);			
		}
		else
		{
			System.out.println("Quick order button is not visible for this channel");
		}
		
	}
	
	@Test(description = "validate reset in quick order form")
	public void chkValidSkuInvalidQty() throws InterruptedException
	{
		moduleName = "quickorderform";
		methodName = "chkValidSkuInvalidQty";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		
		if (driver.findElements(By.xpath("//*[@class='primary quick']")).size() > 0)
		{
			testCaseUtil.checkAllFormElements(moduleName, methodName,driver,channelLocator);
			driver.findElement(By.name("addToCart")).click();
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);	
		}	
		else
		{
			System.out.println("Quick order button is not visible for this channel");
		}
	}
	
		
	// Quick Order upload csv-Satya Prakash	
	@Test(description = "upload valid csv and navigate to cart")
	public void uploadValidCsvAtQuickOrder() throws InterruptedException, IOException
	{
		moduleName = "quickorder";
	    methodName = "uploadValidCsvAtQuickOrder";
	    channelLocator="comChannel";
	    initialize(moduleName,methodName, channelLocator);
	    
	    String path = null;
	    
	    System.out.println("Webshop " + webshop);

		if (webshop.contains("BDD"))		
		{	
			driver.findElement(By.xpath("//*[@id='container']/footer/nav/div[1]/div[2]/ul/li[1]/a")).click();
			Thread.sleep(5000);
			
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("javascript:window.scrollBy(100,300)");
			Thread.sleep(5000);
		    driver.findElement(By.xpath("//*[@class='fa fa-file']")).click();
		    Thread.sleep(5000);
		    
			path= System.getProperty("user.dir")+"\\quickorder\\ValidCsv\\BDD_100.csv";
			System.out.println(path);
			uploadFile(path);
			Thread.sleep(20000);
		}
		else if (webshop.contains("BRS"))		
		{		
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();		    
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();	
		    
			path= System.getProperty("user.dir")+"\\quickorder\\ValidCsv\\BRS_100.csv";   
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("BFS"))		
		{		
		    driver.findElement(By.xpath("//*[@id='container']/footer[1]/nav[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")).click();		    
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();	
		    
			path= System.getProperty("user.dir")+"\\quickorder\\ValidCsv\\BFS_100.csv";   
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("BVP"))		
		{		
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();		    
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();	
		    
			path= System.getProperty("user.dir")+"\\quickorder\\ValidCsv\\BVP_100.csv";  
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.equals("GLO-NL-Test"))		
		{		
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\ValidCsv\\GLO_100.csv";
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.equals("GLOOCI-NL-Test"))		
		{		
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click(); 
		    Thread.sleep(5000);
		    driver.findElement(By.xpath("//*[@class='fa fa-file']")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\ValidCsv\\GLO_100.csv";
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("KBE"))		
		{		
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();		    
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();	
		    
			path= System.getProperty("user.dir")+"\\quickorder\\ValidCsv\\KBE_100.csv"; 
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("King"))		
		{	
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();		    
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();	
		    
			path= System.getProperty("user.dir")+"\\quickorder\\ValidCsv\\King_100.csv"; 
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("MAJ"))		
		{			
			driver.findElement(By.xpath("//button[@class='primary quick']")).click();			 
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();	
		    
			path= System.getProperty("user.dir")+"\\quickorder\\ValidCsv\\MAJ_100.csv";   
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("SAE"))		
		{	
			driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();	
		    
			path= System.getProperty("user.dir")+"\\quickorder\\ValidCsv\\SAE_100.csv";   
			System.out.println(path);
			uploadFile(path);
		}		
		else if (webshop.contains("WPK"))		
		{	
			driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();	
		    
			path= System.getProperty("user.dir")+"\\quickorder\\ValidCsv\\WPK_100.csv";   
			System.out.println(path);
			uploadFile(path);
		}		
	    else if (webshop.contains("MLN-DK-Test"))		
		{	
		    driver.findElement(By.xpath("//*[@id='container']/footer[1]/nav[1]/div[1]/div[2]/ul[1]/li[1]/a[1]")).click();		    
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();	
		    
			path= System.getProperty("user.dir")+"\\quickorder\\ValidCsv\\MLN_100.csv";   
			System.out.println(path);
			uploadFile(path);
		}
	    else if (webshop.contains("DRD"))		
		{	
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();		    
		    Thread.sleep(5000);
		    driver.findElement(By.xpath("//*[@class='fa fa-file']")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\ValidCsv\\DRD_100.csv";   
			System.out.println(path);
			uploadFile(path);
		}
	    else if (webshop.contains("CLC"))		
		{	
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();		    
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();	
		    
			path= System.getProperty("user.dir")+"\\quickorder\\ValidCsv\\CLC_100.csv";   
			System.out.println(path);
			uploadFile(path);
		}
		
		ArrayList<String> csvSku = readCsv(path);
		System.out.println("csvSku " +csvSku);		
		 
	    Thread.sleep(10000);
	    if (webshop.equals("GLOOCI-NL-Test"))		
		{	
	    	driver.findElement(By.xpath("(.//*[@class='ish-button show-spinner'])[1]")).click();   	
		}
	    else
	    {
	    	driver.findElement(By.name("addToCart")).click();
	    }
	    
	    WebDriverWait wait = new WebDriverWait(driver,20); 
        
		Integer count = driver.findElements(By.xpath("//*[@id='overlayJItems']/div/form")).size();
		System.out.println("Error popup " + count);
		
		if (count > 0)
		{
			System.out.println("Error popup addtocart " + count);       
			driver.findElement(By.xpath("//*[@class='kor-overlay-close']")).click();
			
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@class='fa fa-shopping-cart']")).click();		
		}
		
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.name("checkout")));
	    	    
		//on cart page check sku of each PLI
	    List<WebElement> oSKU = driver.findElements(By.xpath("//table//tr/td[3]//div[2]"));
        int size1=oSKU.size();
		System.out.println(size1);
		
		ArrayList<String> cartSku = new ArrayList<String>();		
		for (WebElement gsku: oSKU) 
		{
			String sup = gsku.getText();
			System.out.println(sup);
			if(sup.contains(":"))
			{
				String spl[]=sup.split(":", 2);
				String sup1=spl[1];
				cartSku.add(sup1); 
			}			
	    }
		
		System.out.println("csvSku " + csvSku);
		
		System.out.println("cartSku " + cartSku);
	    
		//boolean result=cartSku.containsAll(csvSku);
	    boolean result = csvSku.containsAll(cartSku);
	    System.out.println(result);
	    Assert.assertTrue(result);	  
	}
	
	
	public static void setClipboardData(String string) 
	{
			//StringSelection is a class that can be used for copy and paste operations.
			   StringSelection stringSelection = new StringSelection(string);
			   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}
		
	
	public static void uploadFile(String fileLocation) 
	{
	        try 
	        {
	        	//Setting clipboard with file location
	            setClipboardData(fileLocation);
	            //native key strokes for CTRL, V and ENTER keys
	            Robot robot = new Robot();
	            robot.delay(3000);
	            robot.keyPress(KeyEvent.VK_CONTROL);
	            robot.keyPress(KeyEvent.VK_V);
	            robot.keyRelease(KeyEvent.VK_V);
	            robot.keyRelease(KeyEvent.VK_CONTROL);
	            robot.delay(10000);
	            robot.keyPress(KeyEvent.VK_ENTER);
	            robot.keyRelease(KeyEvent.VK_ENTER);
	            
	        } 
	        catch (Exception exp) 
	        {
	        	exp.printStackTrace();
	        }	
	}
	
	
	//Add to cart from Quick View-Bibudhendu Swain 
	
	@Test(description = "on quick view page click on add to cart")
	public void addtocartQuickView() throws InterruptedException 
	{
		moduleName = "quickview";
		methodName = "addtocartQuickView";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		Thread.sleep(5000);
		driver.get(urlProp.getProperty("homePageURL"));
		//accessquickview
		showQuickview("1");
		hideQuickview();
	    Thread.sleep(5000);
	    testCaseUtil.processElements( mLink, "click", moduleName, methodName, driver, channelLocator);
		String article=driver.findElement(By.xpath("//*[@class='ish-itemNumber']")).getText();
		String[] subSku=article.split(": ",2);
		qSkuId = subSku[1].toString();
		System.out.println(qSkuId);
		
	}
	
	@Test(description = "after adding product go to cart")
	public void goToCartFromQuickView() throws InterruptedException 
	{
		moduleName = "quickview";
		methodName = "goToCartFromQuickView";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		testCaseUtil.processElements( mLink, "click", moduleName, methodName, driver, channelLocator);
		System.out.println(qSkuId);
		String article=driver.findElement(By.xpath("//table//tr/td[3]//div[3]")).getText();
		String[] subSku=article.split(": ",2);
		String skuId = subSku[1].toString();
		System.out.println(skuId);
		boolean result=qSkuId.equals(skuId);
		System.out.println(result);
		Assert.assertTrue(result);
		
	}
	

	public void showQuickview(String no)
	{
		String n=no;
		System.out.println(n);
		String li="li["+n+"]";
		System.out.println(li);
		String locator=".ish-productTile-expressShopTrigger";
		String script= "$("+"\""+locator+"\""+").show();";
		System.out.println(script);
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript(script);
		execute(script);
		
		boolean visible=driver.findElement(By.xpath("//*[contains(text(),'Direct bestellen')]")).isDisplayed();
	    System.out.println(visible);
	    driver.findElement(By.xpath("//*[@class='ish-productList']/"+li+"/div/div/span")).click();
	    hideQuickview();
	}
	
	public void hideQuickview()
	{
		
		String locator=".ish-productTile-expressShopTrigger";
		String script= "$("+"\""+locator+"\""+").hide();";
		System.out.println(script);
		execute(script);
		boolean visible=driver.findElement(By.xpath("//*[contains(text(),'Direct bestellen')]")).isDisplayed();
	    System.out.println(visible);
	}
	
	public void execute(String script)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript(script);
		
	}
	
	
	//DA-Soft Login scenario-Bibudhendu Swain
	
	//DA Soft Login Scenarios
	
	
	@Test(description = "change delivery address and check address section")
	public void changeDA() throws InterruptedException {
	moduleName = "DAsoftlogin";
	methodName = "changeDA";
	channelLocator="specChannel";
    initialize(moduleName,methodName, channelLocator);
	Thread.sleep(5000);
	String bChange=getAddressId();
	String selectedId=changeAddress();
	String aChange=getAddressId();
	//Assert.assertEquals(bChange, aChange);
	boolean result=false;
	if((!bChange.equals(aChange)) & selectedId.equals(aChange))
	{   
		result=true;
		System.out.println(result);
	}
	 Assert.assertTrue(result);
	}

	@Test(description = "change delivery address and check Header section")
	public void chkAddAtHeader() throws InterruptedException {
	moduleName = "DAsoftlogin";
	methodName = "chkAddAtHeader";
	channelLocator="specChannel";
       initialize(moduleName,methodName, channelLocator);
	String selectedId=changeAddress();
	//Assert.assertEquals(bChange, aChange);
	String addHeader=driver.findElement(By.xpath("//*[@id='container']/header//div[2]/div[1]")).getText();
	boolean result=addHeader.contains(selectedId);
	System.out.println(result);
	Assert.assertTrue(result);
	}
	
	@Test(description = "logout and check soft login")
	public void logoutChkHeader() throws InterruptedException {
	moduleName = "DAsoftlogin";
	methodName = "logoutChkHeader";
	channelLocator="specChannel";
       initialize(moduleName,methodName, channelLocator);
	
	//Assert.assertEquals(bChange, aChange);
	String aH=driver.findElement(By.xpath("//*[@id='container']/header//div[2]/div[1]")).getText();
	System.out.println(aH);
	//String[] ah1=aH.split(")",2);
	String[] ah1=aH.split(Pattern.quote(")"));
	String addHeader=ah1[0];
	System.out.println(addHeader);
	driver.findElement(By.xpath("//*[contains(text(),'Uitloggen')]")).click();
	Thread.sleep(5000);
	String aH2=driver.findElement(By.xpath("//*[@id='container']/header//div[2]/div[1]")).getText();
	System.out.println(aH2);
	boolean result=aH.contains(aH2);
	System.out.println(result);
	Assert.assertTrue(result);
	}
	
	@Test(description = "on checkout address page change address and check soft login scenario")
	public void changeChkoutAddress() throws InterruptedException 
	{
		//login	
		//login("DAsoftlogin","validlogin");
		//Thread.sleep(5000);
//		driver.get(urlProp.getProperty("homePageURL"));
		//accessquickview
//		showQuickview("1");
//		hideQuickview();
//	    Thread.sleep(5000);
//	    driver.findElement(By.xpath("//form/div[3]/button")).click();
//	    WebDriverWait wait = new WebDriverWait(driver,20); 
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Bekijk winkelwagen')]")));
//	    driver.findElement(By.xpath("//*[contains(text(),'Bekijk winkelwagen')]")).click();	    
//	    driver.findElement(By.name("checkout")).click();
	    
	    String otext=driver.findElement(By.xpath("//*[@data-rwd-src='menu']/div[2]/div/div")).getText();
		System.out.println(otext);
	    
	    
	    //Change delivery address at Checkout Address page
	    
	    WebElement element= driver.findElement(By.id("ShippingAddressID"));
	    Select shippdrop = new Select(element);
	    int sz=shippdrop.getOptions().size();
	    System.out.println(sz);
	    element.click();
	    
	    
	        List<WebElement> we=shippdrop.getOptions();
		    WebElement e;
			e=we.get(sz-1);
			//System.out.println(e.getAttribute("value"));
			System.out.println(e.getText());
			String aid=e.getText();
			String[] sid=aid.split(",",2);
			String id=sid[0];
			System.out.println("id is"+id);
			element.click();
			shippdrop.selectByIndex(sz-1);
			
		//match with customer info box
			
			String text=driver.findElement(By.xpath("//*[@data-rwd-src='menu']/div[2]/div/div")).getText();
			System.out.println(text);
			boolean result=text.contains(id);
			System.out.println("result"+result);
			if(!result)
			{
				Assert.assertTrue(result);
				
			}
			else
			{
				driver.get(urlProp.getProperty("homePageURL"));
				String aH2=driver.findElement(By.xpath("//*[@id='container']/header//div[2]/div[1]")).getText();
				boolean result1=aH2.contains(id);
				System.out.println("result1"+result1);
				Assert.assertTrue(result1);
			}
			
	}
			
	public String getAddressId()
	{
		String address = driver.findElement(By.xpath("//*[@class='kor-myAccount-addressBook']/h4")).getText();
		System.out.println(address);
		String[] address1=address.split(",",2);
		String preAdd=address1[0];
		System.out.println(preAdd);
		return preAdd;
	}
	
	
	public String changeAddress()
    {
    	String selAddId=null;
    	boolean b = driver.findElement(By.xpath("//*[@id='deliveryAddressAnchor']/a")).isDisplayed();
    	
    	if(b)
    	{
    	driver.findElement(By.xpath("//*[@id='deliveryAddressAnchor']/a")).click();	
    	List <WebElement> nDA=driver.findElements(By.xpath("//*[@name='SelectedAddressUUID']"));
    	int nAddress= nDA.size();
    	if(nDA.size()>1)
    		{    		   		   		
    		search:
    		{
    		for(int i=3;i<i+nAddress;i++)
    		{
	    		String nn=Integer.toString(i);
	    		String x= "tr["+nn+"]";
	    		System.out.println(x);
	    		WebElement chkRadio=driver.findElement(By.xpath("//*[@id='assignedDeliveryAddressesDiv']//"+x+"/td[1]/input"));
	    		boolean chk=chkRadio.isSelected();
	    		if(!chk)
	    		{
			        driver.findElement(By.xpath("//*[@id='assignedDeliveryAddressesDiv']//"+x+"/td[1]/label")).click();
			        WebElement selAdd=driver.findElement(By.xpath("//*[@id='assignedDeliveryAddressesDiv']//"+x+"/td[1]/label"));
			        selAddId=selAdd.getText();
			        //System.out.println("aaaaaaaaaaaaaa");
			        System.out.println("Selected ID is "+selAddId);
			        driver.findElement(By.name("confirmDeliveryAddress")).click();
			        break search;
    		    }
    		  
    		   }
    		}    	
    	}
    	else System.out.println("Only one delivery address still change address link appears it should not appear");
    	}
    	else
    	System.out.println("Only one delivery address so no change address link is there");
    	
    	return selAddId;
    }
	
		
	public ArrayList<String> readCsv(String csvFile) throws InterruptedException, IOException 
	{
		FileReader fr = new FileReader(new File(csvFile));  
        BufferedReader br = new BufferedReader(fr);  
        String st;  
        ArrayList<String> csvSku1 = new ArrayList<String>();
        while ((st = br.readLine()) != null) 
        {  
            System.out.println(st);  
            String spl[]=st.split(";", 2);
			String sup1=spl[0];
			csvSku1.add(sup1); 			
        }  
        System.out.println("csvSku1 " +csvSku1);
        return csvSku1;
	}
	
    
	public void login(String modName, String methName) throws InterruptedException
	{
		moduleName = modName;
		methodName = methName;
		channelLocator="comChannel";
       initialize(moduleName,methodName, channelLocator);
		driver.get(urlProp.getProperty("homePageURL"));
		driver.findElement(By.xpath("//*[@class='line']/a")).click();
		Thread.sleep(5000);
		testCaseUtil.checkAllFormElements(moduleName, methodName,driver,channelLocator);
		testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
	}
	
	public boolean chkQTYEqualsOne()
	{
		List<WebElement> oQTY = driver.findElements(By.xpath("//*[@class='ish-productQuantity']/input"));
		int size11=oQTY.size();
		int count=0;
		System.out.println(size11);
		for ( WebElement gQTY: oQTY) 
		  {
			int qty = Integer.parseInt(gQTY.getAttribute("value"));		
			if (qty==1)
			 {
				 count+=qty;	 
			 }
			 else
				 break;			
	      }
		if (count==size11 || count==0)
		{
			System.out.println(count);
			return true;
		}
		else return false;
	}
	
	public void search(String searchString)
	{
		// Search
		driver.findElement(By.xpath("//*[@id='searchTerm_Header']")).sendKeys(searchString);
		driver.findElement(By.xpath("//*[@class='primary small']")).click();
		
	}

	
	@Test(description = "browse products from grid view")
	public void browseProductsFromGridView() throws InterruptedException 
	{
		moduleName = "browseProducts";
		methodName = "browseProductsFromGridView";
		channelLocator="comChannel";
	    initialize(moduleName,methodName, channelLocator);
		Thread.sleep(3000);	
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,-200)");
		
		count1 = driver.findElements(By.xpath("//*[@class='button right icon fa fa-th']")).size();
		
		Thread.sleep(10000);
		if (count1 != 0)
		{
			System.out.println("Gried View is disabled by default " + count1);
			
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("javascript:window.scrollBy(500,100)");
			
			driver.findElement(By.xpath("//*[@class='button right icon fa fa-th']")).click();
			Thread.sleep(10000);	
		}	
		
		ArrayList<String> browsedSku=new ArrayList<String>();			
		Assert.assertTrue(browse());		
	}
	
	
	@Test(description = "browse products from grid view")
	public void browseProductsFromListView() throws InterruptedException 
	{
		moduleName = "browseProducts";
		methodName = "browseProductsFromListView";
		channelLocator="comChannel";
	    initialize(moduleName,methodName, channelLocator);
		Thread.sleep(3000);	
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,-200)");
		
		count1 = driver.findElements(By.xpath("//*[@class='button right icon fa fa-th']")).size();
		System.out.println("TEST " + count1);
		
		
		Thread.sleep(10000);
		if (count1 != 0)
		{
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("javascript:window.scrollBy(500,100)");
			
			Thread.sleep(10000);
			
			driver.findElement(By.xpath("//*[@class='button right icon fa fa-th']")).click();
			Thread.sleep(10000);	
		}
		
		ArrayList<String> browsedSku=new ArrayList<String>();
		Assert.assertTrue(browse());		
	}
	
	
	@Test(description="check browsed products are present in Recently Viewed section")
	 public void chkbrowsedProductsInRecentView() throws InterruptedException
	 {
		 moduleName = "browseProducts";
		 methodName = "chkbrowsedProductsInRecentView";
		 channelLocator="comChannel";
	     initialize(moduleName,methodName, channelLocator);
	     
	     getvalue2 = null;
			
	     System.out.println("Product SKU on first PDP +++ ## " + getvalue1);
	     
	     System.out.println("Product SKU on Second PDP ++++ " + getvalue3);
	     
		 ArrayList<String> recntViewSku=new ArrayList<String>();
		 boolean result=false;
		 Thread.sleep(3000);
		 
		 if (webshop.contains("MAJ-NL-Test"))
		 {
				System.out.println("MAJ Webshop " + webshop);				
		        driver.findElement(By.xpath("//*[@id='product-search-result']/div/div[6]/ul[1]/li[1]")).click();
		 }
		 else if (webshop.contains("King-NL-Test"))
		 {
				System.out.println("King Webshop " + webshop);			
		        driver.findElement(By.xpath("//*[@id='product-search-result']/div/div[6]/ul[2]/li[1]")).click();
		 }
		 else if (webshop.contains("WPK-EN-Test"))
		 {
				System.out.println("Webshop " + webshop);
				driver.findElement(By.xpath("//div[@class='ish-search-productList']//ul[*]//li[*]")).click();				
		 }
		 else
		 {	
			 	System.out.println("Webshop " + webshop);
			 	//driver.findElement(By.xpath("//*[@id='ish-productTile-size']/a/div")).click();
		 }
		 
	
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("javascript:window.scrollBy(900,1000)");
		 
		 Thread.sleep(3000);
		 List<WebElement> recentViewList=driver.findElements(By.cssSelector(".ish-recentlyViewed"));
		 if(!recentViewList.isEmpty())
		 {
			 //List<WebElement> recentView=driver.findElements(By.xpath("//*[@class='ish-productNmuber-value']"));
	
			 List<WebElement> recentView=driver.findElements(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[8]/div[2]/div[1]/ul[1]/li[*]/div[2]/div[1]/div[*]/div[1]/div[1]/div[1]/span[2]"));
				
			 for(WebElement e: recentView)
			 {
		       String rSku=e.getText();
		       recntViewSku.add(rSku);
		       //browse();		       
		       System.out.println("Recently viewed "+recntViewSku);
			 }
			   System.out.println("browsedSku +++***" + getvalue1);
			   result=recntViewSku.contains(getvalue1);
			   Assert.assertTrue(result);		   
		  }
		  else Assert.assertTrue(result);	
	}

	
	public boolean browse() throws InterruptedException
	{
//		int k=1;
//        WebElement test=driver.findElement(By.xpath(".//*[@id='product-search-result']/div/div[6]/ul[2]/li[1]/a/div[2]/div[2]/div[2]"));
//		System.out.println("SKU" +test.getText());
		
		
	   ArrayList<String> browsedSku=new ArrayList<String>();
	   ArrayList<String> skuIdCart=new ArrayList<String>();
	   Thread.sleep(5000);	   
	   List<WebElement> resultList=driver.findElements(By.xpath("//*[@id='product-search-result']/div/div[6]/ul[*]/li[*]"));
	   WebElement element;
	   System.out.println("Entered Browse");
	   int i,j,fail=0;
	   if(resultList.size()>0)
	   {  
          for (i=2;i<4;i++)
          {
           for (j=1;j<2;j++)
           {
            Thread.sleep(3000);         

			count2 = driver.findElements(By.xpath(".//*[@class='ish-product-image']")).size();
			System.out.println("TEST " + count2);
			
			if (count2 != 0)
			{		  
	            
	            if(webshop.contains("MAJ-NL-Test"))
	            {
	            	System.out.println("MAJ Webshop " + webshop);
		            element=driver.findElement(By.xpath("//*[@id='product-search-result']/div/div[6]/div/ul["+i+"]/li["+i+"]"));
	            }
	            if(webshop.contains("BDD"))
	            {
	            	System.out.println("BDD Webshop " + webshop);
		            element=driver.findElement(By.xpath("//div[@class='ish-search-productList']//ul["+i+"]//li["+i+"]"));
	            }
	            if(webshop.contains("BFS"))
	            {
	            	System.out.println("BFS Webshop " + webshop);
		            element=driver.findElement(By.xpath("//div[@class='ish-search-productList']//ul["+i+"]//li["+i+"]"));
	            }
	            else
	            {
	            	System.out.println("Webshop is " + webshop);
		            element=driver.findElement(By.xpath("//*[@id='product-search-result']/div/div[6]/ul["+i+"]/li["+j+"]"));
	            }
	            
				System.out.println("list view " + webshop);
     			WebElement gSku=driver.findElement(By.xpath("//*[@id='product-search-result']//*/ul["+i+"]/li["+j+"]//*/a/div[2]/div[3]/div[2]"));	
//				WebElement gSku=driver.findElement(By.xpath(".//*[@id='product-search-result']/div/div[6]/ul["+i+"]/li["+j+"]/a/div[2]/div[2]/div[2]"));
//				WebElement gSku=driver.findElement(By.xpath(".//*[@id='product-search-result']/div/div[6]/ul[2]/li[1]/a/div[2]/div[2]/div[2]"));
//				String s12=driver.findElement(By.xpath("(//*[@class='ish-productNmuber-value'])["+i+"]")).getText();
				String s = gSku.getText();
				System.out.println("sku" + s);
//	            System.out.println("SKU" +s12);	 
	            
	            browsedSku.add(s);	            
	            System.out.println("element to be clicked " + element);
	            element.click();
	            
	            WebElement sku=driver.findElement(By.className("ish-productNumber-value"));
	            skuIdCart.add(sku.getText());
	            
	            if (!(s.equals(sku.getText())))
	            {
	               fail=fail+1; 
	               System.out.println("List view test failed");
	            }
			}
			else
			{	            
	            if(webshop.contains("MAJ-NL-Test"))
	            {
	            	System.out.println("MAJ Webshop " + webshop);
		            element=driver.findElement(By.xpath("//*[@id='product-search-result']/div/div[6]/div/ul["+i+"]/li["+i+"]"));
	            }
	            else if (webshop.contains("BDD"))
	            {
	            	System.out.println("BDD Webshop " + webshop);
		            element=driver.findElement(By.xpath("//div[@class='ish-search-productList']//ul["+i+"]//li["+i+"]"));	            	
	            }
	            else if(webshop.contains("BFS"))
	            {
	            	System.out.println("BFS Webshop " + webshop);
		            element=driver.findElement(By.xpath("//div[@class='ish-search-productList']//ul["+i+"]//li["+i+"]"));
	            }
	            else
	            {
		            element=driver.findElement(By.xpath("//*[@id='product-search-result']/div/div[6]/ul["+i+"]/li["+j+"]"));
	            }
	            
				System.out.println("Grid View " + webshop);
				WebElement gSku=driver.findElement(By.xpath("//*[@id='product-search-result']//ul["+i+"]/li["+j+"]/div//span[2]"));		            
	            String s = gSku.getText();
	            System.out.println(s);
	            
	            browsedSku.add(s);
	            
	            System.out.println("element to be clicked " + element);
	            element.click();
	            
	            //WebElement sku=driver.findElement(By.className("ish-productNumber-value"));
	            //skuIdCart.add(sku.getText());
	            //if (!(s.equals(sku.getText())))
	            //{
	               //fail=fail+1; 
	              //System.out.println("Gried view test failed");
	           // }
			}
            if(i!=3)
            {
                Thread.sleep(3000);
                driver.navigate().back();  
            }  
           }
          }
	       
	    }	    

	    System.out.println("browsedsku "+ browsedSku);
	    System.out.println("skuid "+skuIdCart);
	    		
	    if(fail>0)
	    {
	    	return false;
	    }
	    else  return true;
	}
	
	
	@Test(description="open new window")
	public void openNewWindow()
	{		
		LoggingPreferences logs1 = new LoggingPreferences();
		logs1.enable(LogType.DRIVER, Level.SEVERE);
		logs1.enable(LogType.CLIENT, Level.SEVERE);
		logs1.enable(LogType.BROWSER, Level.SEVERE);
		logs1.enable(LogType.SERVER, Level.SEVERE);
		logs1.enable(LogType.SERVER, Level.SEVERE);		
		
		if (browser.contains("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			
			DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();			
			desiredCapabilities.setCapability("marionette",true);			
			//driver = new firefoxDriver(desiredCapabilities);
	        
	        //firefoxOptions options = new firefoxOptions();        
	        //options.setLegacy(true);
	        //options.addArguments("--headless");
	        
			firefoxProfile = new FirefoxProfile();
			firefoxProfile.setAcceptUntrustedCertificates(true);
			
			desiredCapabilities.setCapability("firefox_profile", firefoxProfile);
			//desiredCapabilities.setCapability("firefox_profile", profile.ToBase64String());
			
			desiredCapabilities.setBrowserName(browser);
			desiredCapabilities.setVersion(version);
//			version=desiredCapabilities.getVersion().toString();
//			System.out.println("version" +version);		
			desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, setLoggingPreference());
			//return desiredCapabilities;
		} 
		else if (browser.contains("chrome")) 
		{
			if(platform.contains("Desktop"))
			{	
				desiredCapabilities = DesiredCapabilities.chrome();				
				//desiredCapabilities.setPlatform(Platform.WINDOWS);
				
				//desiredCapabilities.setCapability("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
				
				desiredCapabilities.setBrowserName(browser);
				desiredCapabilities.setVersion(version);
				
		        ChromeOptions options = new ChromeOptions();
		        //options.addArguments("--headless");
		        //options.addArguments("window-size=1024x768");
		        options.addArguments("test-type");
		        options.addArguments("disable-infobars");
		        options.addArguments("--no-sandbox");
		        options.addArguments("--disable-setuid-sandbox");
		        options.addArguments("--allow-insecure-localhost");
		        options.addArguments("--proxy-bypass-list");

		        options.addArguments("window-size=1000,1076");
		        DesiredCapabilities cap = DesiredCapabilities.chrome();
		        cap.setCapability(ChromeOptions.CAPABILITY, options);
		        
		        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
		        desiredCapabilities.setCapability("chrome.switches", Arrays.asList("--ignore-certificate-errors,--web-security=false,--ssl-protocol=any,--ignore-ssl-errors=true"));
		        
		        desiredCapabilities.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, true);
				desiredCapabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
				desiredCapabilities.setCapability(CapabilityType.ENABLE_PROFILING_CAPABILITY, true);
				desiredCapabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
				desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);		
				desiredCapabilities.setJavascriptEnabled(true);	
		        
				desiredCapabilities.setCapability("chrome.switches", Arrays.asList("--disable-print-preview"));
				desiredCapabilities.setCapability("chrome.switches", Arrays.asList("--disable-print-preview"));
				desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, logs1);
				driver = new ChromeDriver(desiredCapabilities);
			} 
			else if(platform.contains("Linux"))
			{
				desiredCapabilities = DesiredCapabilities.chrome();				
				//desiredCapabilities.setPlatform(Platform.LINUX);
				
				//desiredCapabilities.setCapability("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
				desiredCapabilities.setCapability("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");

				desiredCapabilities.setBrowserName(browser);
				desiredCapabilities.setVersion(version);
				
		        ChromeOptions options = new ChromeOptions();
		        //options.addArguments("--headless");
		        options.addArguments("window-size=1900x1200");
		        options.addArguments("test-type");
		        options.addArguments("disable-infobars");
		        
		        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
		        desiredCapabilities.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, true);
				desiredCapabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
				desiredCapabilities.setCapability(CapabilityType.ENABLE_PROFILING_CAPABILITY, true);
				desiredCapabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
				desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);		
				desiredCapabilities.setJavascriptEnabled(true);	
		        
				desiredCapabilities.setCapability("chrome.switches", Arrays.asList("--disable-print-preview"));
				desiredCapabilities.setCapability("chrome.switches", Arrays.asList("--disable-print-preview"));
				desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, logs1);
				driver = new ChromeDriver(desiredCapabilities);
			}
		}
		else if (browser.contains("iexplore")) 
		{
			desiredCapabilities = DesiredCapabilities.internetExplorer();
			
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/drivers/IEDriverServer.exe");
			
			desiredCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			desiredCapabilities.setCapability(InternetExplorerDriver.EXTRACT_PATH,true);
			desiredCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);
			desiredCapabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS,true);
			
			desiredCapabilities.setBrowserName(browser);
			desiredCapabilities.setVersion(version);
			desiredCapabilities.setCapability(CapabilityType.ENABLE_PROFILING_CAPABILITY, true);
			desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, setLoggingPreference());
			desiredCapabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
			desiredCapabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
			desiredCapabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, true);
			
			//desiredCapabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, "dismiss");
			desiredCapabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
			desiredCapabilities.setCapability(CapabilityType.SUPPORTS_FINDING_BY_CSS, true);
			desiredCapabilities.setPlatform(Platform.WINDOWS);
			
			//desiredCapabilities.setPlatform(Platform.LINUX);
			desiredCapabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			//WebDriver driver = new InternetExplorerDriver(desiredCapabilities);
			
			driver = new InternetExplorerDriver(desiredCapabilities);
		} 
		else if (browser.contains("safari")) 
		{
			desiredCapabilities = DesiredCapabilities.safari();
			desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			desiredCapabilities.setBrowserName(browser);
			desiredCapabilities.setVersion(version);
			driver1 = new SafariDriver(desiredCapabilities);
		}		
		else if (browser.contains("phantomJS")) 
		{
			if(platform.contains("Desktop"))
			{	
				System.out.println("Windows");
				System.out.println("path : "+System.getProperty("user.dir") + "/drivers/phantomjs.exe");
				
				desiredCapabilities = DesiredCapabilities.phantomjs();	
				
				desiredCapabilities.setPlatform(Platform.WINDOWS);
				
				String[] phantomArgs = new String[] { "--webdriver-loglevel=NONE" }; 
				desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomArgs);
				desiredCapabilities.setCapability("takesScreenshot", true);
				desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[] {"--web-security=no", "--ignore-ssl-errors=yes"});
				desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, System.getProperty("user.dir") + "/drivers/phantomjs.exe");	
				
				desiredCapabilities.setJavascriptEnabled(true);
				 
				driver = new PhantomJSDriver(desiredCapabilities);
			} 
			else if(platform.contains("Linux"))
			{
				 System.out.println("LINUX");
				 System.out.println("path : "+System.getProperty("user.dir") + "/drivers/phantomjs");
				 
            	 desiredCapabilities = DesiredCapabilities.phantomjs();	
            	 
            	 desiredCapabilities.setPlatform(Platform.LINUX);
            	 
				 String[] phantomArgs = new String[] { "--webdriver-loglevel=NONE" }; 				 
				 desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomArgs);
				 
            	 desiredCapabilities.setCapability("takesScreenshot", true);
				 desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				 
				 desiredCapabilities.setCapability("phantomjs.binary.path", System.getProperty("user.dir") + "/drivers/phantomjs");
				 desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, System.getProperty("user.dir") + "/drivers/phantomjs"); 
				 
				 desiredCapabilities.setJavascriptEnabled(true);
				 desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[] {"--ssl-protocol=any", "--ignore-ssl-errors=true", "--web-security=false"});			
				 				   					 
				 driver = new PhantomJSDriver(desiredCapabilities);
			}				   
		}		
		driver1.manage().window().maximize();	
	}
	
	
	@Test(description = "Login as Account Admin")
	public void loginAccountAdminInNewWindow() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "loginAccountAdminInNewWindow";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		driver1.get(urlProp.getProperty("homePageURL"));
		Thread.sleep(3000);
		driver1.findElement(By.xpath("//*[@class='line']//a")).click();
		Thread.sleep(3000);
		testCaseUtil.checkAllFormElements(moduleName, methodName, driver1,channelLocator);
		driver1.findElement(By.xpath(mLink.get("loginButton"))).click();
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, "loginButton", driver1,channelLocator);
	}
	
	
	@Test(description = "Set User name and ID which will be revoked by Account Admin")
	public void setPreferredIdToRevoke()
	{
		moduleName = "siteNavigationModule";
		methodName = "setPreferredIdToRevoke";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		boolean result=false;
		String[] userIdName = new String[2];
		userIdName= getUserNameAndId();
		userIdToRevoke=userIdName[0];
		System.out.println(userIdToRevoke);
		userNameToRevokeId=userIdName[1];
		System.out.println(userNameToRevokeId);
		if(!userIdToRevoke.isEmpty() && !userNameToRevokeId.isEmpty())
		{   
			result=true;
			Assert.assertTrue(result);
		}
		else Assert.assertTrue(result);		  
	}
	
 	
	public String[] getUserNameAndId()
	{
		boolean isChkd;
		String id=null;
		String name=null;
		String[] userIdName = new String[2];
		driver.findElement(By.xpath("//*[@id='deliveryAddressAnchor']/a")).click();
		List<WebElement> userId=new ArrayList<WebElement>();
		userId=driver.findElements(By.xpath("//*[@type='radio']"));
		label:for(WebElement e:userId)
		{
			isChkd=e.isSelected();
			if(isChkd)
			{
				id=e.getAttribute("id");
				System.out.println(id);
				userIdName[0]=id;
				break label;
			}		
		}
		driver.get(urlProp.getProperty("homePageURL"));
		name=driver.findElement(By.xpath("//*[@id='main']/div[1]/h2/strong")).getText();
		userIdName[1]=name;
		return userIdName;		
	}
	
	
	@Test(description="revoke preferred delivery address of the user")
	public void revokePrefferedDaOfUser() throws InterruptedException
	{
		moduleName = "siteNavigationModule";
		methodName = "revokePrefferedDaOfUser";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator); 
		
		boolean result=false;
		driver1.findElement(By.xpath("//*[contains(text(),'Gebruikers')]")).click();
		
		Thread.sleep(4000);
		System.out.println(userNameToRevokeId);
		driver1.findElement(By.partialLinkText(userNameToRevokeId)).click();
		Thread.sleep(4000);
		driver1.findElement(By.xpath("//*[@id='main']/div[3]/div/div[4]/div[3]/a")).click();
		Thread.sleep(4000);
		
		driver1.findElement(By.xpath("//*[@for='"+userIdToRevoke+"']")).click();
		driver1.findElement(By.name("Assignselecteddeliveryaddress")).click();
		Thread.sleep(4000);
		driver1.findElement(By.xpath("//*[@id='main']/div[3]/div/div[4]/div[3]/a")).click();
		Thread.sleep(4000);
		result=driver1.findElement(By.id(userIdToRevoke)).isSelected();
		
		System.out.println(result);
        if (!result)
        {   result=true;
        	Assert.assertTrue(result);
        	System.out.println("in");
        }
        else Assert.assertTrue(result);  			
	}
	
	
    @Test(description="after preferred address gets revoked when user tries to checkout, it gets redirected to dashboard")
	public void redirectCustomerToDashboard() throws InterruptedException
    {
    	moduleName = "siteNavigationModule";
		methodName = "redirectCustomerToDashboard";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		boolean result=false;	
    	driver.findElement(By.cssSelector(".ish-button.ish-bar-actionButton")).click();
    	Thread.sleep(5000);
    	result=driver.findElement(By.cssSelector(".message")).isDisplayed();
    	if(result)
    	{
    	  testCaseUtil.checkAllTextMsgs(moduleName, methodName, "noClick", driver,channelLocator);
    	}
    	else Assert.assertTrue(result);
    }
	
    
    @Test(description="Reassign revoked delivery address to user")
    public void reassignRevokedDaToUser() throws InterruptedException
    {
    	moduleName = "siteNavigationModule";
		methodName = "reassignRevokedDaToUser";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		boolean result;
		driver1.findElement(By.xpath("//*[@for='"+userIdToRevoke+"']")).click();
		driver1.findElement(By.name("Assignselecteddeliveryaddress")).click();
		Thread.sleep(4000);
		
		//now check whether that preferred DA is unchecked or not
		driver1.findElement(By.xpath("//*[@id='main']/div[3]/div/div[4]/div[3]/a")).click();
		Thread.sleep(4000);
		result=driver1.findElement(By.id(userIdToRevoke)).isSelected();
		System.out.println(result);
        if (result)
        {   result=true;
        	Assert.assertTrue(result);
        	System.out.println("in");
        }
        else Assert.assertTrue(result); 		
	}
    
    	
    @Test(description="close new window")
    public void closeNewWindow()
    {
    	driver1.quit();
    	boolean hasQuit = (driver1.toString().contains("(null)")) ? true : false;
    	System.out.println(hasQuit);
    	Assert.assertTrue(hasQuit);   
    }
	
    
	//Quick Order - Upload Invalid csv files    
    @Test(description="upload a csv file with few valid SKU & QTY along with one invalid sku which doesn't exist")
    public void uploadFileInvalidSku() throws InterruptedException
    {
    	moduleName = "quickorder";
	    methodName = "uploadFileInvalidSku";
	    channelLocator="comChannel";
	    initialize(moduleName,methodName, channelLocator);

	    String path = null;
	    System.out.println(" Webshop " + webshop);

		if (webshop.contains("BDD"))		
		{	
			System.out.println(" Webshop++ " + webshop);
			
			driver.findElement(By.xpath("//*[@id='container']/footer/nav/div[1]/div[2]/ul/li[1]/a")).click();
			
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("javascript:window.scrollBy(100,300)");
			Thread.sleep(5000);
		    driver.findElement(By.xpath("//*[@class='fa fa-file']")).click();
		    Thread.sleep(5000);
			path= System.getProperty("user.dir")+"\\quickorder\\Invalidsku\\BDD.csv";
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("BRS"))		
		{	
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\Invalidsku\\BRS.csv";   
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("BFS"))		
		{		
		    driver.findElement(By.xpath("//*[@id='container']/footer[1]/nav[1]/div[1]/div[2]/ul[1]/li[1]/a[1]")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\Invalidsku\\BFS.csv";   
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("BVP"))		
		{		
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\Invalidsku\\BVP.csv";  
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("GLO"))		
		{		
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//*[@class='fa fa-file']")).click();		    
		    Thread.sleep(4000);
			path= System.getProperty("user.dir")+"\\quickorder\\Invalidsku\\GLO.csv";
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.equals("DRDOCI-NL-Test"))		
		{		
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//*[@class='fa fa-file']")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\Invalidsku\\DRD.csv";
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("KBE"))		
		{	
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\Invalidsku\\KBE.csv"; 
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("King"))		
		{		
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\Invalidsku\\King.csv"; 
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("MAJ"))		
		{		
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\Invalidsku\\MAJ.csv";   
			System.out.println(path);
			uploadFile(path);
		}
	    else if (webshop.contains("MLN-DK-Test"))		
		{		
		    driver.findElement(By.xpath("//*[@id='container']/footer[1]/nav[1]/div[1]/div[2]/ul[1]/li[1]/a[1]")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\Invalidsku\\MLN.csv";   
			System.out.println(path);
			uploadFile(path);
		}
	    else if (webshop.contains("SAE"))		
		{		
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\Invalidsku\\SAE.csv";   
			System.out.println(path);
			uploadFile(path);
		}
	    else if (webshop.contains("WPK"))		
		{		
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\Invalidsku\\WPK.csv";   
			System.out.println(path);
			uploadFile(path);
		}
	    else if (webshop.contains("CLC"))		
		{		
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\Invalidsku\\CLC.csv";   
			System.out.println(path);
			uploadFile(path);
		}
	    else if (webshop.contains("DRD"))		
		{		
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//*[@class='fa fa-file']")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\Invalidsku\\DRD.csv";   
			System.out.println(path);
			uploadFile(path);
		}
	    
	    Thread.sleep(2000);
	    driver.findElement(By.name("addToCart")).click();
	   
		if (webshop.contains("GLO"))
		{	
		    System.out.println("This is an application");	  
		}
		else if (webshop.contains("BDD"))
		{	
			System.out.println("This is an application");	  	    
		}
		else if (webshop.equals("DRDOCI-NL-Test"))
		{	
		    System.out.println("This is an OCI application");		    
		}
		else
		{
		    WebDriverWait wait = new WebDriverWait(driver,20); 
		    wait.until(ExpectedConditions.presenceOfElementLocated(By.name("checkout")));
		    System.out.println("Checkout page");
		    testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);	  
		}	  
    }
	
    
    @Test(description="upload a csv file with few valid SKU & QTY but Invalid File Extn")
    public void uploadFileInvalidFileExtn() throws InterruptedException
    {
    	moduleName = "quickorder";
	    methodName = "uploadFileInvalidFileExtn";
	    channelLocator="comChannel";
	    initialize(moduleName,methodName, channelLocator);	    

	    String path = null;
	    System.out.println(" Webshop " + webshop);
	    
		if (webshop.contains("BDD"))		
		{	 
			driver.findElement(By.xpath("//*[@id='container']/footer/nav/div[1]/div[2]/ul/li[1]/a")).click();

	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("javascript:window.scrollBy(100,300)");
			Thread.sleep(5000);
		    driver.findElement(By.xpath("//*[@class='fa fa-file']")).click();
		    Thread.sleep(5000);
		    
			path= System.getProperty("user.dir")+"\\quickorder\\InvalidFileExtn\\BDD.txt";
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("BRS"))		
		{	 
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\InvalidFileExtn\\BRS.txt";   
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("BFS"))		
		{   
		    driver.findElement(By.xpath("//*[@id='container']/footer[1]/nav[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\InvalidFileExtn\\BFS.txt";   
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("BVP"))		
		{	
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\InvalidFileExtn\\BVP.txt";  
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("GLO"))		
		{		
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//*[@class='fa fa-file']")).click();		    
		    Thread.sleep(4000);
			path= System.getProperty("user.dir")+"\\quickorder\\Invalidsku\\GLO.csv";
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("KBE"))		
		{	
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\InvalidFileExtn\\KBE.txt"; 
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("King"))		
		{		
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\InvalidFileExtn\\King.txt"; 
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("MAJ"))		
		{	   
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\InvalidFileExtn\\MAJ.txt";   
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("SAE"))		
		{	   
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\InvalidFileExtn\\SAE.txt";   
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("WPK"))		
		{	   
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\InvalidFileExtn\\WPK.txt";   
			System.out.println(path);
			uploadFile(path);
		}
	    else if (webshop.contains("MLN"))		
		{			     
		    driver.findElement(By.xpath("//*[@id='container']/footer[1]/nav[1]/div[1]/div[2]/ul[1]/li[1]/a[1]")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\InvalidFileExtn\\MLN.txt";   
			System.out.println(path);
			uploadFile(path);
		}
	    else if (webshop.contains("CLC"))		
		{			     
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\InvalidFileExtn\\CLC.txt";   
			System.out.println(path);
			uploadFile(path);
		}
	    else if (webshop.contains("DRD"))		
		{			     
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//*[@class='fa fa-file']")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\InvalidFileExtn\\DRD.txt";   
			System.out.println(path);
			uploadFile(path);
		}
	    
	    Thread.sleep(2000);
	    driver.findElement(By.name("addToCart")).click();
	    
		if (webshop.contains("GLO"))
		{	
		    System.out.println("This is an OCI application");	  
		}
		else if (webshop.equals("DRDOCI-NL-Test"))		
		{	
		    System.out.println("This is an OCI application");
		}
		else
		{
		    testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);	  
		}
    }    
    
    
    @Test(description="upload a csv file in which one of the row is blank")
    public void uploadFileInvalidMissingSkuQty() throws InterruptedException
    {
    	moduleName = "quickorder";
	    methodName = "uploadFileInvalidMissingSkuQty";
	    channelLocator="comChannel";
	    initialize(moduleName,methodName, channelLocator);	  
	    
	    String path = null;
	    System.out.println(" Webshop " + webshop);
	    
		if (webshop.contains("BDD"))		
		{		
			driver.findElement(By.xpath("//*[@id='container']/footer/nav/div[1]/div[2]/ul/li[1]/a")).click();

	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("javascript:window.scrollBy(100,300)");
			Thread.sleep(5000);
		    driver.findElement(By.xpath("//*[@class='fa fa-file']")).click();
		    Thread.sleep(5000);
		    
			path= System.getProperty("user.dir")+"\\quickorder\\InvalidMissingSkuQty\\BDD.csv";
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("BRS"))		
		{	
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\InvalidMissingSkuQty\\BRS.csv";   
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("BFS"))		
		{	
		    driver.findElement(By.xpath("//*[@id='container']/footer[1]/nav[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\InvalidMissingSkuQty\\BFS.csv";   
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("BVP"))		
		{	
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\InvalidMissingSkuQty\\BVP.csv";  
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("GLO"))		
		{		
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//*[@class='fa fa-file']")).click();		    
		    Thread.sleep(4000);
			path= System.getProperty("user.dir")+"\\quickorder\\Invalidsku\\GLO.csv";
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("KBE"))		
		{	
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\InvalidMissingSkuQty\\KBE.csv"; 
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("King"))		
		{	
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\InvalidMissingSkuQty\\King.csv"; 
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("MAJ"))		
		{	
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\InvalidMissingSkuQty\\MAJ.csv";   
			System.out.println(path);
			uploadFile(path);
		}
	    else if (webshop.contains("MLN-DK-Test"))		
		{		
	    	driver.findElement(By.xpath("//*[@id='container']/footer[1]/nav[1]/div[1]/div[2]/ul[1]/li[1]/a[1]")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\InvalidMissingSkuQty\\MLN.csv";   
			System.out.println(path);
			uploadFile(path);
		}
	    else if (webshop.contains("SAE"))		
		{		
	    	driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\InvalidMissingSkuQty\\SAE.csv";   
			System.out.println(path);
			uploadFile(path);
		}			
	    else if (webshop.contains("WPK"))		
		{		
	    	driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\InvalidMissingSkuQty\\WPK.csv";   
			System.out.println(path);
			uploadFile(path);
		}		
	    else if (webshop.contains("CLC"))		
	    {	
	    	driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
	    	path= System.getProperty("user.dir")+"\\quickorder\\InvalidMissingSkuQty\\CLC.csv";   
			System.out.println(path);
			uploadFile(path);
	    }
	    else if (webshop.contains("DRD"))		
	    {	
	    	driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//*[@class='fa fa-file']")).click();
		    
	    	path= System.getProperty("user.dir")+"\\quickorder\\InvalidMissingSkuQty\\DRD.csv";   
			System.out.println(path);
			uploadFile(path);
	    }
	    
	    Thread.sleep(2000);
	    driver.findElement(By.name("addToCart")).click();	  
	    
		if (webshop.contains("GLO"))
		{	
		    System.out.println("This is an OCI application");	  
		}
		else if (webshop.equals("DRDOCI-NL-Test"))		
		{	
		    System.out.println("This is an OCI application");
		}
		else
		{
		    testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);  
		    Thread.sleep(5000);
		}
    }
    
    
    @Test(description="upload a csv file in which one quantity is non numeric")
    public void uploadFileInvalidQtyNonnumeric() throws InterruptedException
    {
    	moduleName = "quickorder";
	    methodName = "uploadFileInvalidQtyNonnumeric";
	    channelLocator="comChannel";
	    initialize(moduleName,methodName, channelLocator);

	    String path = null;
	    System.out.println(" Webshop " + webshop);
	    
		if (webshop.contains("BDD"))		
		{		
			driver.findElement(By.xpath("//*[@id='container']/footer/nav/div[1]/div[2]/ul/li[1]/a")).click();

	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("javascript:window.scrollBy(100,300)");
			Thread.sleep(5000);
		    driver.findElement(By.xpath("//*[@class='fa fa-file']")).click();
		    Thread.sleep(5000);
		    
			path= System.getProperty("user.dir")+"\\quickorder\\InvalidQtyNonnumeric\\BDD.csv";
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("BRS"))		
		{		
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\InvalidQtyNonnumeric\\BRS.csv";   
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("BFS"))		
		{	
		    driver.findElement(By.xpath("//*[@id='container']/footer[1]/nav[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\InvalidQtyNonnumeric\\BFS.csv";   
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("BVP"))		
		{	
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\InvalidQtyNonnumeric\\BVP.csv";  
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("GLO"))		
		{		
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//*[@class='fa fa-file']")).click();		    
		    Thread.sleep(4000);
			path= System.getProperty("user.dir")+"\\quickorder\\Invalidsku\\GLO.csv";
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.equals("DRDOCI-NL-Test"))		
		{		
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//*[@class='fa fa-file']")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\InvalidQtyNonnumeric\\DRD.csv";
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("KBE"))		
		{		
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\InvalidQtyNonnumeric\\KBE.csv"; 
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("King"))		
		{	
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\InvalidQtyNonnumeric\\King.csv"; 
			System.out.println(path);
			uploadFile(path);
		}
		else if (webshop.contains("MAJ"))		
		{	
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\InvalidQtyNonnumeric\\MAJ.csv";   
			System.out.println(path);
			uploadFile(path);
		}
	    else if (webshop.contains("MLN-DK-Test"))		
		{	
		    driver.findElement(By.xpath("//*[@id='container']/footer[1]/nav[1]/div[1]/div[2]/ul[1]/li[1]/a[1]")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\InvalidQtyNonnumeric\\MLN.csv";   
			System.out.println(path);
			uploadFile(path);
		}
	    else if (webshop.contains("SAE"))		
		{	
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\InvalidQtyNonnumeric\\SAE.csv";   
			System.out.println(path);
			uploadFile(path);
		}		
	    else if (webshop.contains("WPK"))		
		{	
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
			path= System.getProperty("user.dir")+"\\quickorder\\InvalidQtyNonnumeric\\WPK.csv";   
			System.out.println(path);
			uploadFile(path);
		}		
	    else if (webshop.contains("CLC"))		
	    {		
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
	    	path= System.getProperty("user.dir")+"\\quickorder\\InvalidQtyNonnumeric\\CLC.csv";   
			System.out.println(path);
			uploadFile(path);
	    }
	    else if (webshop.contains("DRD"))		
	    {		
		    driver.findElement(By.xpath("//button[@class='primary quick']")).click();
		    driver.findElement(By.xpath("//*[@name='quickorderFormCSV']//button[1]")).click();
		    
	    	path= System.getProperty("user.dir")+"\\quickorder\\InvalidQtyNonnumeric\\DRD.csv";   
			System.out.println(path);
			uploadFile(path);
	    }	

	    Thread.sleep(2000);
	    driver.findElement(By.name("addToCart")).click();
	    
		if (webshop.contains("GLO"))
		{	
		    System.out.println("This is an OCI application");	  
		}
	    else if (webshop.equals("DRDOCI-NL-Test"))		
		{	
		    System.out.println("This is an OCI application");
		}
		else
		{
			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
		}
    }

    
    @Test(description="Select And Enter Alternate Address")
    public void selectAndEnterAlternateAddress() throws InterruptedException
    {
    	moduleName = "siteNavigationModule";
	    methodName = "selectAndEnterAlternateAddress";
	    channelLocator="comChannel";
	    initialize(moduleName,methodName, channelLocator);
	    driver.findElement(By.xpath("//*[@for='useAlternateAddress']")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@id='AlternateAddress_CountryCode']")).sendKeys("Netherlands");
	    driver.findElement(By.xpath("//*[@id='AlternateAddress_CompanyName']")).sendKeys("Test Company Name");
	    driver.findElement(By.xpath("//*[@id='AlternateAddress_FirstName']")).sendKeys("Test First Name");
	    driver.findElement(By.xpath("//*[@id='AlternateAddress_LastName']")).sendKeys("Test Last Name");
	    driver.findElement(By.xpath("//*[@id='AlternateAddress_Address1']")).sendKeys("Test State");
	    driver.findElement(By.xpath("//*[@id='AlternateAddress_City']")).sendKeys("Test City");
	    driver.findElement(By.xpath("//*[@id='AlternateAddress_PostalCode']")).sendKeys("123456789");
	    testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
    	
    }
    
    @Test(description="Verify Alternate Address On Shipment Page")
    public void verifyAlternateAddressShipmentPage() throws InterruptedException
    {
    	moduleName = "siteNavigationModule";
	    methodName = "verifyAlternateAddressShipmentPage";
	    channelLocator="comChannel";
	    initialize(moduleName,methodName, channelLocator);
	    testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
    	
    }
    
    @Test(description="Verify Alternate Address On Payment Confirmation Page")
    public void verifyAlternateAddressPaymentConfirmationPage() throws InterruptedException
    {
    	moduleName = "siteNavigationModule";
	    methodName = "verifyAlternateAddressPaymentConfirmationPage";
	    channelLocator="comChannel";
	    initialize(moduleName,methodName, channelLocator);
	    testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
    	
    }
    
    @Test(description="Verify Alternate Address On Order Confirmation Page")
    public void verifyAlternateAddressOrderConfirmationPage() throws InterruptedException
    {
    	moduleName = "siteNavigationModule";
	    methodName = "verifyAlternateAddressOrderConfirmationPage";
	    channelLocator="comChannel";
	    initialize(moduleName,methodName, channelLocator);
	    testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
    	
    }
    
	
    //set price solr -> price mismatch back to cart
    
   @Test(description="setting UuID for price change in solr")
    public void setUuidForPriceChangeInSolr() throws InterruptedException
    {
    	moduleName = "SolrPrice";
	    methodName = "setUuidForPriceChangeInSolr";
	    channelLocator="specChannel";
	    initialize(moduleName,methodName, channelLocator);
	    String articleNo=driver.findElement(By.xpath("//table//tr[2]/td[3]/div/div[3]")).getText();
        String[] s=articleNo.split(": ",2);
        String solrProductSku =s[1];
        System.out.println(solrProductSku);
        
        String headerDeliveryID=driver.findElement(By.xpath("//*[@id='container']/header/div[3]/div[2]/div[1]")).getText();
        String DeliveryID = headerDeliveryID.substring(headerDeliveryID.indexOf("(")+1,headerDeliveryID.indexOf(")"));
        System.out.println(DeliveryID);
        solrPriceUuid=DeliveryID+"_"+solrProductSku;
        System.out.println(solrPriceUuid);
    }
    
    @Test(description="go to solr ax price query section")
    public void goToSolrPriceQuery() throws InterruptedException
   {
   	    moduleName = "SolrPrice";
	    methodName = "goToSolrPriceQuery";
	    channelLocator="specChannel";
	    initialize(moduleName,methodName, channelLocator);
        driver1.get("http://10.5.8.80:8080/solr/#/Bunzl-King-AX_price/query");
	    testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver1, channelLocator);
    
   }
    
    
    @Test(description="check EAN Sales unit of UUID on solr ax price query section")
    public void checkSalesUnitOfUuid() throws InterruptedException
   {
   	    moduleName = "SolrPrice";
	    methodName = "checkSalesUnitOfUuid";
	    channelLocator="specChannel";
	    initialize(moduleName,methodName, channelLocator);
	    Thread.sleep(10000);
        driver1.findElement(By.id("q")).clear();
        driver1.findElement(By.id("q")).sendKeys("UUID"+":"+solrPriceUuid);
        driver1.findElement(By.xpath("//*[@type='submit']")).click();
	    testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver1,channelLocator);
    
   }
    

    @Test(description="check EAN Sales unit of UUID on solr ax price query section")
    public void createQueryToChangePrice() throws InterruptedException
   {
   	    moduleName = "SolrPrice";
	    methodName = "createQueryToChangePrice";
	    channelLocator="specChannel";
	    initialize(moduleName,methodName, channelLocator);
	    String[] sa = new String[5];
	    String UUID;
	    String pInfo;
	    String ean;
	    String salesUnit;
	    String timeStamp;
	    String query;
        
	    UUID=solrPriceUuid;
	    	
	    	for(int i=6,j=0;i<13;i=i+2,j++)
		    {
	    	System.out.println(( driver1.findElement(By.xpath("//*[@id='response']/pre/code/span[4]/span[6]/span["+i+"]"))).getText());
	        String a=driver1.findElement(By.xpath("//*[@id='response']/pre/code/span[4]/span[6]/span["+i+"]")).getText();
	        sa[j]=a;
	        System.out.println(sa[j]);
		    }
	    	for(int i=0;i<4;i++)
	    	{
	    		System.out.println(sa[i]);
	    	}
        
        query="{\"UUID\":"+"\"" +UUID+ "" +"\",price\":\""+"10.02"+"\""  + ",timestamp\":"+sa[0]+""  +",\"salesUnit\":"+sa[1]+"\""   +"\",ean\":"+sa[2]+"\""   +"\"packagingInfo\":"+sa[2]+"\""  ;
        System.out.println(query);
    
   }

    
    
    // check cookie warning
    
    @Test(description="check that cookie warning appears")
    public void chkCookieWarningAppear() throws InterruptedException
    {
    	moduleName = "cookieWarning";
 	    methodName = "chkCookieWarningAppear";
 	    channelLocator="comChannel";
 	    initialize(moduleName,methodName, channelLocator);	
 	    
 	    Thread.sleep(10000); 	   
    	WebElement cookieWarning=driver.findElement(By.id(webElement.get("CookieBanner")));
    	
    	boolean result=cookieWarning.isDisplayed();
    	if(result)
    	{
    		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
    	}
    	else Assert.assertTrue(result, "cookie warning banner doesn't appear");
    }
    
    @Test(description="check that cookie warning closes")
    public void closeCookieWarning() throws InterruptedException
    {
    	moduleName = "cookieWarning";
 	    methodName = "closeCookieWarning";
 	    channelLocator="comChannel";
 	    initialize(moduleName,methodName, channelLocator);	
 	    
 	    //driver.navigate().refresh();
 	    Thread.sleep(1000);
    	WebElement cookieWarning=driver.findElement(By.id(webElement.get("CookieBanner")));
    	driver.findElement(By.xpath(webElement.get("SetCookie"))).click();
    	
    	Thread.sleep(3000);
    	boolean result=cookieWarning.isDisplayed();
    	if(!result)
    	{   
    		System.out.println(result);
    		Assert.assertFalse(result,"cookie warning doesn't appear now");
    	}
    	else Assert.assertFalse(result, "cookie warning banner still appears");
    }

    @Test(description="browse through webshop and check cookie warning doesn't appear")
    public void browseChkCookieWarningNotAppear() throws InterruptedException
    {
    	moduleName = "cookieWarning";
 	    methodName = "browseChkCookieWarningNotAppear";
 	    channelLocator="comChannel";
 	    initialize(moduleName,methodName, channelLocator);
 	    boolean result;
 	    //go to My Account & FAQ page 
 	    int val=0;
 	    WebElement e1=driver.findElement(By.className(webElement.get("logo")));
 	    WebElement e;
 	    	    
 	    for (int i=0;i<2;i++)
 	    {
 	    	if(i==0)
 	    	{
 	    		e=e1;
 	    	}
 	    	else  e=driver.findElement(By.xpath(webElement.get("Login")));
 	    	//for 1st iteration go to home page and on 2nd go to contact us page
 	    	e.click();
 	    	
 	    		result=driver.findElement(By.id(webElement.get("cookie-banner"))).isDisplayed();
 	    		System.out.println("result");
 	    	
 	    	if(!result)
 	    	{   
 	    		System.out.println(result);
 	    		val=val+1;
 	    	} 	    	
 	    	Thread.sleep(5000); 	    	
 	    }
 	    
 	    	System.out.println(val);
 	    
 	    if(val==2)
 	    {
 	    	result=true;
 	    }
 	    else result=false;
 	    
 	    Assert.assertTrue(result);     	   
    }

   
    // FAQ page show all and hide all
    
    @Test(description="Go to FAQ page")
    public void goToFaqPage()
    { 
    	moduleName="contentFaq";
    	methodName="goToFaqPage";
    	channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
    	
    	driver.findElement(By.xpath("//*[contains(text(),'FAQ')]")).click();
    	String expTitle=driver.getTitle();
    	System.out.println(expTitle);
    	boolean result=expTitle.equalsIgnoreCase("Veelgestelde vragen");
    	System.out.println(result);
    	Assert.assertTrue(result);       	
    }
    
    //"check whether answers are already opened or not"
    public String chkStateOfFaqPage()
    {
    	
    	String result=null;
    	boolean disAns=driver.findElement(By.xpath("//*[contains(@id,'answer')]")).isDisplayed();
    	System.out.println(disAns);
    	boolean disQue=driver.findElement(By.xpath("//*[contains(@data-hide-all-show-one,'answer')]")).isDisplayed();
    	System.out.println(disQue);
    	
    	if(!disAns && disQue)
    	{
    		result= "Qustion only appears";
    	}else {if(disAns)
    	{
    		result= "Answers are already open";
    	}else {if(!disQue)
    	{
    		result= "Questions are not displayed";
    	}
      }
     }
    	return result;
    }
    
    @Test(description="Check clicking on Show All links display all the answers")
    public void chkShowAll()
    {
    	moduleName="contentFaq";
    	methodName="chkShowAll";
    	channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
    	int count=0;
    	String status=chkStateOfFaqPage();
    	System.out.println(status);
    	//click on Show All link
    	driver.findElement(By.id("ShowAll")).click();
    	
    	//check how many questions are there
    	int nQue= driver.findElements(By.xpath("//*[contains(@data-hide-all-show-one,'_answer')]")).size();
    	System.out.println(nQue);
    	
    	//check how many answer appear
    	List<WebElement> answer= driver.findElements(By.xpath("//*[contains(@id,'_answer')]"));
    	System.out.println(answer.size());
    	for(WebElement e: answer)
    	{
    		String s=e.getAttribute("style");
    		System.out.println(s);
    		if(s.equals("display: block;"))
    		{
    			count=count+1;
    			System.out.println(count);
    		}
    	}
    	
    	Assert.assertTrue(nQue==count);
    }
    
    @Test(description="Check clicking on Hide All link, hide all the answers")
    public void chkHideAll()
    {
    	moduleName="contentFaq";
    	methodName="chkHideAll";
    	channelLocator="comChannel";
        initialize(moduleName,methodName, channelLocator);
    	int count=0;
    	String status=chkStateOfFaqPage();
    	System.out.println(status);
    	//click on Show All link
    	driver.findElement(By.id("HideAll")).click();
    	
    	//check how many questions are there
    	int nQue= driver.findElements(By.xpath("//*[contains(@data-hide-all-show-one,'_answer')]")).size();
    	System.out.println(nQue);
    	
    	//check how many answers appear
    	List<WebElement> answer= driver.findElements(By.xpath("//*[contains(@id,'_answer')]"));
    	System.out.println(answer.size());
    	for(WebElement e: answer)
    	{
    		String s=e.getAttribute("style");
    		System.out.println(s);
    		if(s.equals("display: block;"))
    		{
    			count=count+1;
    			System.out.println(count);
    		}
    	}
    	
    	Assert.assertTrue(count==0);
    }  

    @Test(description="Check any question- Clicking on it opens its answers")
    public void chkSingleQueAns()
    {
    	moduleName="contentFaq";
    	methodName="chkSingleQueAns";
    	channelLocator="comChannel";
        initialize(moduleName,methodName, channelLocator);
    	
    	boolean result=false;
    	int count=0;
    	List<WebElement> nQue= driver.findElements(By.xpath("//*[contains(@data-hide-all-show-one,'_answer')]"));
    	ArrayList <String> idAns=new ArrayList<String>();
    	System.out.println(nQue.size());
    	for(WebElement e:nQue)
    	{
    		String s=e.getAttribute("data-hide-all-show-one");
    		System.out.println(s);
    		idAns.add(s);
    	}
    	
    	Random ran=new Random();
    	int n= ran.nextInt((nQue.size()-1));
    	System.out.println(n);
    	System.out.println(idAns.get(n));
    	
    	//click on any random question
    	driver.findElement(By.xpath("//*[@data-hide-all-show-one='"+idAns.get(n)+"']")).click();
    	
    	//check whehter answer of that particular question appears.
    	String display=driver.findElement(By.id(""+idAns.get(n)+"")).getAttribute("style");
    	if(display.equals("display: block;"))
    	{
    		
    		
    		//now check only one answer appears
    		List<WebElement> answer= driver.findElements(By.xpath("//*[contains(@id,'_answer')]"));
        	System.out.println(answer.size());
        	for(WebElement e: answer)
        	{
        		String s=e.getAttribute("style");
        		System.out.println(s);
        		if(s.equals("display: block;"))
        		{
        			count=count+1;
        			System.out.println(count);
        		}
        	}
        	
        	if(count==1)
        	{
        		result=true;
        	}
        	
    	}else result=false;
    	Assert.assertTrue(result);
    	
    	
    	
    }

    
    //Header_Navigation_Link "Email Signup"
    
    @Test(description="check whether clicking on Emailk Sign up link takes user to a new window")
    public void navEmailSignUp() throws InterruptedException
    { 
    	moduleName="siteNavigationModule";
    	methodName="navEmailSignUp";
    	channelLocator="comChannel";
        initialize(moduleName,methodName, channelLocator);
    	
    	String pWindow;
    	String cWnndow;
    	String actUrl=null;
    	System.out.println(driver.getWindowHandles().size());
    	pWindow=driver.getWindowHandle();
    	testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
    	driver.findElement(By.xpath("//*[contains(text(),'Aanmelden nieuwsbrief')]")).click();
    	
    	for (String winHandle:driver.getWindowHandles())
    	{
    		driver.switchTo().window(winHandle);
    		actUrl=driver.getCurrentUrl();
    		System.out.println(actUrl);
    	}
    	
    	String expUrl="http://king.m12.mailplus.nl/genericservice/code/servlet/React?wpEncId=4vijbGiSVs&wpMessageId=11087&userId=31200149&command=viewPage";
    	boolean result=expUrl.equalsIgnoreCase(actUrl);
    	System.out.println(result);
    	Assert.assertTrue(result);       	
    }

    
    //View user name & updated name on dashboard in left panel & at Header
    
    public String[] getUserFirstLastName() throws InterruptedException
    {
    	String[] getUserName=new String[2];
    	//now check first name and last name
    	Thread.sleep(4000);
    	String fName=driver.findElement(By.id("UpdateProfileForm_FirstName")).getAttribute("value");
    	getUserName[0]=fName;
    	String lName=driver.findElement(By.id("UpdateProfileForm_LastName")).getAttribute("value");
    	getUserName[1]=lName;
    	return getUserName;
    }
    
    
    @Test(description="On dashboard left panel view user name")
    public void viewUserNameOnDashboard() throws InterruptedException
    {
    	moduleName="DAsoftlogin";
    	methodName="viewUserNameOnDashboard";
    	channelLocator="specChannel";
        initialize(moduleName,methodName, channelLocator);
    	driver.findElement(By.xpath("(//*[contains(text(),'Wijzig')])[3]")).click();
    	String [] name = getUserFirstLastName();
    	String fName;
    	String lName;
    	fName=name[0];
    	lName=name[1];
    	
        String fullName=lName+", "+fName;
    	System.out.println(fullName);
    	String nameOnLeftPanel=driver.findElement(By.xpath("//*[@id='main']/div[3]/aside/nav[1]/ul[1]/li/h3")).getText();
    	System.out.println(nameOnLeftPanel);
    	Thread.sleep(4000);
    	Assert.assertTrue(nameOnLeftPanel.equals(fullName));

    }
    
    @Test(description="At header view user name")
    public void viewUserNameAtHeader() throws InterruptedException
    {
    	moduleName="DAsoftlogin";
    	methodName="viewUserNameAtHeader";
    	channelLocator="specChannel";
        initialize(moduleName,methodName, channelLocator);
    	String fName;
    	String lName;
    	String [] name =getUserFirstLastName();
    	fName=name[0];
    	lName=name[1];
    	//now check first name and last name
    	Thread.sleep(4000);
    	String fullName=fName+" "+lName;
    	System.out.println(fullName);
    	String nameAtHeader=driver.findElement(By.xpath("//*[@id='container']/header/div[4]/div[2]/div[1]")).getText();
    	System.out.println(nameAtHeader);
    	Thread.sleep(4000);
    	Assert.assertTrue(nameAtHeader.contains(fullName));

    }

    @Test(description="View Updated Name On Dashboard")
    public void viewUpdatedNameOnDashboard() throws InterruptedException
    {
    	moduleName="DAsoftlogin";
    	methodName="viewUpdatedNameOnDashboard";
    	channelLocator="specChannel";
        initialize(moduleName,methodName, channelLocator);
    	String fName;
    	String lName;
    	//now update first name and last name
    	Thread.sleep(3000);
		driver.findElement(By.xpath("//*[contains(text(),'Profiel instellingen')]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//*[contains(text(),'Wijzig')])[3]")).click();
		driver.findElement(By.xpath("//*[@id='UpdateProfileForm_FirstName']")).clear();
		driver.findElement(By.xpath("//*[@id='UpdateProfileForm_LastName']")).clear();
		driver.findElement(By.xpath("//*[@id='UpdateProfileForm_FirstName']")).sendKeys("Satya Test");
		driver.findElement(By.xpath("//*[@id='UpdateProfileForm_LastName']")).sendKeys("Agarwal Test");
    //	testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
    	String [] name =getUserFirstLastName();
		driver.findElement(By.xpath("//button[@name='UpdateProfile']")).click();
    	fName=name[0];
    	lName=name[1];
    	String fullName=lName+", "+fName;
    	System.out.println(fullName);
    	String nameOnLeftPanel=driver.findElement(By.xpath("//*[@id='main']/div[3]/aside/nav[1]/ul[1]/li/h3")).getText();
    	System.out.println(nameOnLeftPanel);
    	Thread.sleep(4000);
    	Assert.assertTrue(nameOnLeftPanel.equals(fullName));

    }
    
    @Test(description="View Updated Name at Header")
    public void viewUpdatedNameAtHeader() throws InterruptedException
    {
    	moduleName="DAsoftlogin";
    	methodName="viewUpdatedNameAtHeader";
    	channelLocator="specChannel";
        initialize(moduleName,methodName, channelLocator);
		driver.findElement(By.xpath("//*[contains(text(),'Profiel instellingen')]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//*[contains(text(),'Wijzig')])[3]")).click();
    	String fName;
    	String lName;
    	String [] name =getUserFirstLastName();
    	fName=name[0];
    	lName=name[1];
    	
    	String fullName=fName+" "+lName;
    	System.out.println("Satya Fullname");
    	System.out.println(fullName);
    	String nameAtHeader=driver.findElement(By.xpath("//*[@id='container']/header/div[4]/div[2]/div[1]")).getText();
    	System.out.println("Satya nameAtheader");
    	System.out.println(nameAtHeader);
    	Thread.sleep(4000);
    	Assert.assertTrue(nameAtHeader.contains(fullName));

    }
    
    @Test(description="Reset User Name")
    public void resetUserName() throws InterruptedException
    {
    	login("siteNavigationModule","loginCustomerBuyer");
    	
		driver.findElement(By.xpath("//*[contains(text(),'Profiel instellingen')]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//*[contains(text(),'Wijzig')])[3]")).click();
		
    	moduleName="DAsoftlogin";
    	methodName="resetUserName";
    	channelLocator="specChannel";
        initialize(moduleName,methodName, channelLocator);
    	
    	//now update first name and last name
    	testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
    	testCaseUtil.processElements( mLink, "click", moduleName, methodName, driver, channelLocator);
    	Thread.sleep(3000);
    	
		driver.findElement(By.xpath("//*[contains(text(),'Profiel instellingen')]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//*[contains(text(),'Wijzig')])[3]")).click();
		
    	String [] name =getUserFirstLastName();
    	String fName;
    	String lName;
    	fName=name[0];
    	lName=name[1];
    	
    	String fullName=lName+", "+fName;
    	System.out.println(fullName);
    	String nameOnLeftPanel=driver.findElement(By.xpath("//*[@id='main']/div[3]/aside/nav[1]/ul[1]/li/h3")).getText();
    	System.out.println(nameOnLeftPanel);
    	Thread.sleep(4000);
    	Assert.assertTrue(nameOnLeftPanel.equals(fullName));

    }
    
    @Test(description="logout and check updated name appears at the header")
    public void logoutViewUpdatedNameAtHeader() throws InterruptedException
    {
    	moduleName="DAsoftlogin";
    	methodName="logoutViewUpdatedNameAtHeader";
    	channelLocator="specChannel";
        initialize(moduleName,methodName, channelLocator);
    	String fName;
    	String lName;
    	String [] name =getUserFirstLastName();
    	fName=name[0];
    	lName=name[1];
    	
    	String fullName=fName+" "+lName;
    	System.out.println(fullName);
    	driver.findElement(By.xpath("//*[@class='line']/a")).click();
    	
    	String nameAtHeader=driver.findElement(By.xpath("//*[@id='container']/header/div[4]/div[2]/div[1]")).getText();
    	System.out.println(nameAtHeader);
    	Thread.sleep(4000);
    	Assert.assertTrue(nameAtHeader.contains(fullName));

    }
    
    
    
    //get cart summary from checkout pages
    
    public HashMap<String,String> getDetilasFromCart()
    {
    	cart=new HashMap<>();
    	int size=driver.findElements(By.xpath("//table/tbody/tr")).size();
    	System.out.println("Satya");
    	System.out.println(size);
    	for(int i=2;i<=size-2;i++)
    	//for(int i=2;i<=2;i++)
    	{
    		int j=i-1;
    		String iQty=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]/input")).getAttribute("value");
    		String iName=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]//div[1]/a")).getText();
    		String iTotalPrice=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]/div")).getText();
    		String iDetail=iQty+"*"+iName+"*"+iTotalPrice;
    		System.out.println(iDetail);
    		cart.put(iName, iDetail); 		
    		
    	}
    	
    	return cart;
    }
    
    
    public HashMap<String,String> getDetilasFromCart1()
    {
    	cart=new HashMap<>();
    	int size=driver.findElements(By.xpath("//*[@class='kor-quantity view-cart']")).size();
    	System.out.println("Satya");
    	System.out.println(size);
    	for(int i=2;i<=size+1;i++)
   // 	for(int i=2;i<=2;i++)
    	{
    		//int j=i-1;
    		String iQty=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]/input")).getAttribute("value");
    		String iName=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]//div[1]/a")).getText();
    		String iTotalPrice=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]/div")).getText();
    		String iDetail=iQty+"*"+iName+"*"+iTotalPrice;
    		System.out.println(iDetail);
    		cart.put(iName, iDetail); 		
    		
    	}
    	
    	return cart;
    }
    
    @Test(description="get all cart details qty,name,price ")   
    public void getCartDetails() throws InterruptedException
    {
    	moduleName="validateCheckOut";
    	methodName="getCartDetails";
    	channelLocator="comChannel";
        initialize(moduleName,methodName, channelLocator);
    	boolean result=false;
    	Map<String,String> cart1=new HashMap<String,String>();
    	Map<String,String> cartPrice1=new HashMap<String,String>();
    	Thread.sleep(4000);
    	cart1=getDetilasFromCart();
    	Thread.sleep(4000);
    	cartPrice1=getCartPriceSummary();
    	if(!cart1.isEmpty() && !cartPrice1.isEmpty())
    	{
    		result =true;
    	}  	
    	
    	Assert.assertTrue(result);
    }
    
    @Test(description="get all cart details qty,name,price ")   
    public void getCartDetails1() throws InterruptedException
    {
    	moduleName="validateCheckOut";
    	methodName="getCartDetails1";
    	channelLocator="comChannel";
        initialize(moduleName,methodName, channelLocator);
    	boolean result=false;
    	Map<String,String> cart1=new HashMap<String,String>();
    	Map<String,String> cartPrice1=new HashMap<String,String>();
    	Thread.sleep(4000);
    	cart1=getDetilasFromCart1();
    	Thread.sleep(4000);
    	cartPrice1=getCartPriceSummary();
    	if(!cart1.isEmpty() && !cartPrice1.isEmpty())
    	{
    		result =true;
    	}  	
    	
    	Assert.assertTrue(result);
    }
    
    
    public HashMap<String,String> getCartSummaryCheckoutPage()
    {
    	
    	driver.findElement(By.xpath("//*[@class='kor-showAll']")).click();
    	HashMap<String,String> cartCheckout=new HashMap<>();
    	int size=driver.findElements(By.xpath("//*[@class='info'][1]//tr")).size();
    	System.out.println(size);
    	for(int i=1;i<=size;i++)
    	{
    		String iQty=driver.findElement(By.xpath("//*[@class='info'][1]//tr["+i+"]/td[1]")).getText();
    		System.out.println("Satya iQty bef" + iQty);
            String[] stemp=iQty.split(" ");
            iQty =stemp[0];
    		System.out.println("Satya iQty after" + iQty);
    		String iName=driver.findElement(By.xpath("//*[@class='info'][1]//tr["+i+"]/td[2]/a")).getText();
    		String iTotalPrice=driver.findElement(By.xpath("//*[@class='info'][1]//tr["+i+"]/td[3]")).getText();
    		String iDetail=iQty+"*"+iName+"*"+iTotalPrice;
    		System.out.println("Satya idetail");
    		System.out.println(iDetail);
    		cartCheckout.put(iName, iDetail); 		
    	}
    	return cartCheckout;
    }
        
    @Test(description="check cart summary on checkout address page")   
    public void addressPageValidateCartSummary()
    {
    	moduleName="validateCheckOut";
    	methodName="addressPageValidateCartSummary";
    	channelLocator="comChannel";
        initialize(moduleName,methodName, channelLocator);
    	Map<String,String> cartSummary=getCartSummaryCheckoutPage();
    	Map<String,String> cartDetails=cart;
    	boolean result=cartDetails.equals(cartSummary);
    	Assert.assertTrue(result);    
    }
       
    @Test(description="check order summary/price details  on checkout address page")   
    public void addressPageValidateOrderSummary()
    {
    	moduleName="validateCheckOut";
    	methodName="addressPageValidateOrderSummary";
    	channelLocator="comChannel";
        initialize(moduleName,methodName, channelLocator);
    	Map<String,String> OrderSummary=getOrderSummaryCheckoutPage();
    	Map<String,String> cartOrderDetails=cartPrice;
    	boolean result=cartOrderDetails.equals(OrderSummary);
    	Assert.assertTrue(result);
     
    }   
    
    @Test(description="check cart summary on shipping details page")   
    public void shippmentPageValidateCartSummary()
    {
    	moduleName="validateCheckOut";
    	methodName="shippmentPageValidateCartSummary";
    	channelLocator="comChannel";
        initialize(moduleName,methodName, channelLocator);
    	Map<String,String> cartSummary=getCartSummaryCheckoutPage();
    	Map<String,String> cartDetails=cart;
    	boolean result=cartDetails.equals(cartSummary);
    	Assert.assertTrue(result);
     
    }
    
    @Test(description="check order summary/price details  on shippment page")   
    public void shippmentPageValidateOrderSummary()
    {
    	moduleName="validateCheckOut";
    	methodName="shippmentPageValidateOrderSummary";
    	channelLocator="comChannel";
        initialize(moduleName,methodName, channelLocator);
    	Map<String,String> OrderSummary=getOrderSummaryCheckoutPage();
    	Map<String,String> cartOrderDetails=cartPrice;
    	boolean result=cartOrderDetails.equals(OrderSummary);
    	Assert.assertTrue(result);
     
    }
     
    @Test(description="check order summary/price details  on checkout payment page")   
    public void paymentPageValidateOrderSummary()
    {
    	moduleName="validateCheckOut";
    	methodName="paymentPageValidateOrderSummary";
    	channelLocator="comChannel";
        initialize(moduleName,methodName, channelLocator);
    	Map<String,String> OrderSummary=getOrderSummaryCheckoutPage();
    	Map<String,String> cartOrderDetails=cartPrice;
    	boolean result=cartOrderDetails.equals(OrderSummary);
    	Assert.assertTrue(result);
     
    }
    
    @Test(description="check cart summary on checkout payment page")   
    public void paymentPageValidateCartSummary()
    {
    	moduleName="validateCheckOut";
    	methodName="paymentPageValidateCartSummary";
    	channelLocator="comChannel";
        initialize(moduleName,methodName, channelLocator);
    	Map<String,String> cartSummary=getCartSummaryCheckoutPage();
    	Map<String,String> cartDetails=cart;
    	boolean result=cartDetails.equals(cartSummary);
    	Assert.assertTrue(result);
     
    }
     
    @Test(description="validate subtotal of all items in cart")   
    public void validateCartSubTotal()
    {
    	moduleName="validateCheckOut";
    	methodName="validateCartSubTotal";
    	channelLocator="comChannel";
        initialize(moduleName,methodName, channelLocator);
    	String actSubTotal;
    	String expSubTotal;
    	float acSubtotal,aSubtotal=0;    	
    	float eSubTotal=0;
    	int size=driver.findElements(By.xpath("//*[@class='kor-quantity view-cart']")).size();
    	System.out.println("Size of Cart " + size);
    	
    	for(int i=2;i<=size+1;i++)
    	{
    		actSubTotal=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText();
    		System.out.println("Line item total price " + actSubTotal);
    		
    		String s = actSubTotal.split(" ")[0];
    		actSubTotal=s.trim();
    		System.out.println("Line item total " + actSubTotal);
    		
    		actSubTotal=actSubTotal.replace(".","");
    		actSubTotal=actSubTotal.replace(",",".");
    		System.out.println("Item total " + actSubTotal);
    		
    		acSubtotal=(Float.parseFloat(actSubTotal));
    		System.out.println("Item total updated " + acSubtotal);
    		
    		aSubtotal=(aSubtotal+acSubtotal);  

    	}   
    	
		System.out.println("Total price of all line items " + aSubtotal);		
	        
    	int atemp = (int)aSubtotal;
		aSubtotal = atemp;
		System.out.println("Final total price of all line items " + aSubtotal);    	
    	
    	
    	expSubTotal=driver.findElement(By.xpath("//*[@class='ish-costSummary-item'][1]/span[2]")).getText();
    	String s = expSubTotal.split(" ")[0];
    	expSubTotal=s.trim();
		System.out.println("Sub total " + expSubTotal);
		
		expSubTotal=expSubTotal.replace(".","");
		expSubTotal=expSubTotal.replace(",",".");
		System.out.println("Sub total updated " + expSubTotal);
		
		eSubTotal=(Float.parseFloat(expSubTotal));
		System.out.println("Final Cart sub total " + eSubTotal);

		
		int etemp = (int)eSubTotal;
		eSubTotal = etemp;
		System.out.println("Final cart sub total updated " + eSubTotal);
		
		Assert.assertEquals(eSubTotal, aSubtotal);
    }

    
	@Test(description="check estimated total price")
    public void validateEstimatedTotal()
    {
    	moduleName="validateCheckOut";
    	methodName="validateEstimatedTotal";
    	channelLocator="comChannel";
        initialize(moduleName,methodName, channelLocator);
    	String price=null;
    	String estTotal=null;
    	float iPrice;
    	float fPrice=0;
    	float eTotal;
    	BigDecimal roundOffPrice = null;
    	BigDecimal bigDecimal = null;
    	int size= driver.findElements(By.xpath("//*[@class='ish-costSummary-item']/span[2]")).size();
    	System.out.println("costSummary-item " + size);
    	
    	for(int i=1;i<=size;i++)
    	{
    		price=driver.findElement(By.xpath("//*[@class='ish-costSummary-item']["+i+"]/span[2]")).getText();

    		String s = price.split(" ")[0];
    		price=s.trim();
    		System.out.println("Final cart Estimated total " + price);
    		
    		price=price.replace(".","");
    		price=price.replace(",",".");
    		iPrice=(Float.parseFloat(price));    		
    		System.out.println("Final cart Estimated total updated " + iPrice);
    		    		
    		fPrice=fPrice+iPrice;
    		bigDecimal=new BigDecimal(fPrice);
    		roundOffPrice=bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
    		System.out.println("round off price " + roundOffPrice);
    	}
    	
    	estTotal=driver.findElement(By.xpath("//*[@class='ish-costSummary-item ish-costSummary-totalItem']/span[2]")).getText();
    	System.out.println("Estimated total price " + estTotal);
    	
    	String a=estTotal.split(" ")[0];
    	estTotal=a.trim();
    	System.out.println("Estimated total price value" + estTotal);
    	
    	estTotal=estTotal.replace(".","");
    	estTotal=estTotal.replace(",",".");    	
    	eTotal=(Float.parseFloat(estTotal));
    	System.out.println("Estimated total price value updated " + estTotal);
    	
    	BigDecimal roundOffTotal=new BigDecimal(fPrice);
    	roundOffTotal=bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
		System.out.println("round of Estimated total price "+roundOffTotal);
		
    	Assert.assertEquals(roundOffPrice, roundOffTotal);
    }
    
    public HashMap<String,String> getCartPriceSummary()
    {
    	cartPrice=new HashMap<>();
    	int size= driver.findElements(By.xpath("//*[contains(@class,'ish-costSummary-item')]/span[2]")).size();
    	System.out.println(size);
    	int len=size-1;
    	System.out.println(len);
    	for(int i=1;i<=size;i++)
    	{
    		String label=driver.findElement(By.xpath("//*[contains(@class,'ish-costSummary-item')]["+i+"]/span[1]")).getText();
    		String price=driver.findElement(By.xpath("//*[contains(@class,'ish-costSummary-item')]["+i+"]/span[2]")).getText();
    		String cartPriceDetail=label+"*"+price;
    		System.out.println(cartPriceDetail);
    		cartPrice.put(label, cartPriceDetail); 		
    		
    	}
    	
    	return cartPrice;
    }
    
    public HashMap<String,String> getOrderSummaryCheckoutPage()
    {
    	
    	HashMap<String,String> orderCheckout=new HashMap<>();
    	int size=driver.findElements(By.xpath("//*[@class='info'][2]//tr")).size();
    	System.out.println(size);
    	for(int i=1;i<=size;i++)
    	{
    		String label=driver.findElement(By.xpath("//*[@class='info'][2]//tr["+i+"]/td[1]")).getText();
    		String price=driver.findElement(By.xpath("//*[@class='info'][2]//tr["+i+"]/td[2]")).getText();
    		String cartPriceDetail=label+"*"+price;
    		System.out.println(cartPriceDetail);
    		orderCheckout.put(label, cartPriceDetail); 			
    		
    	}
    	
    	return orderCheckout;
    	
    }
       
       
    //minicart  test cases
    
    @Test(description="check minicart appears blank for guest or a relevant message appears")
    public void guestViewMiniCart() throws InterruptedException
    {
    	moduleName="minicart";
    	methodName="guestViewMiniCart";
    	channelLocator="comChannel";
        initialize(moduleName,methodName, channelLocator);
    	
    	driver.findElement(By.xpath("//*[contains(@class,'kor-minicart-items')]")).click();
    	Thread.sleep(4000);
    	
        //System.out.println(s);
//        WebDriverWait wait=new WebDriverWait(driver,8000);
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("ish-minicart-empty"))));
//        boolean result= driver.findElement(By.cssSelector(".ish-minicart-empty")).isDisplayed();
        testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
     //   Assert.assertTrue(result);
    }
    
    @Test(description="check added products available in minicart")
    public void checkItemsInMinicart() throws InterruptedException
    {
    	moduleName="minicart";
    	methodName="checkItemsInMinicart";
    	channelLocator="comChannel";
        initialize(moduleName,methodName, channelLocator);
    	driver.findElement(By.xpath("//*[contains(@class,'kor-minicart-items')]")).click();
        //System.out.println(s);
        Thread.sleep(8000);
    	Map<String,String> miniCart1=getMiniCartDetails();
    	Map<String,String> cart11=cart;
    	Assert.assertTrue(cart11.equals(miniCart1));	
    
    }
    
    public HashMap<String,String> getMiniCartDetails()
    {
    	
    	miniCart=new HashMap<>();
    	int size=driver.findElements(By.xpath("//div[@class='ish-productList']//tr")).size();
    	System.out.println(size);
    	for(int i=1;i<=size;i++)
    	{
    		String mQty=driver.findElement(By.xpath("//*[@class='ish-productList']//tr["+i+"]/td[2]//dl/dd")).getText().trim();
    		String mName=driver.findElement(By.xpath("//*[@class='ish-productList']//tr["+i+"]/td[2]/a")).getText();
    		String mTotalPrice=driver.findElement(By.xpath("//*[@class='ish-productList']//tr["+i+"]/td[3]")).getText();
    		String mDetail=mQty+"*"+mName+"*"+mTotalPrice;
    		System.out.println(mDetail);
    		miniCart.put(mName, mDetail); 				
    		
    	}
    	
    	return miniCart;
    	
    }
    
    @Test(description="clicking on Checkout button on minicart should take user to cart page")
    public void navCheckoutBtnMiniCart()
    {
    	moduleName="minicart";
    	methodName="navCheckoutBtnMiniCart";
    	channelLocator="comChannel";
        initialize(moduleName,methodName, channelLocator);
    	
    	driver.findElement(By.cssSelector(".kor-content-contents.ish-minicart>a")).click();
    	WebDriverWait wait=new WebDriverWait(driver,8000);
    	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("cartForm"))));
    	boolean result=driver.findElement(By.name("cartForm")).isDisplayed();
    	Assert.assertTrue(result);
    }
    

    
    
    //items per page drop down test cases
    
    
    @Test(description="check whether items per page drop down appears and its values")
    public void checkItemPerPageDropDownOptions()
    {
    	moduleName="siteNavigationModule";
    	methodName="checkItemPerPageDropDownOptions";
    	channelLocator="comChannel";
        initialize(moduleName,methodName, channelLocator);
    	
        if (webshop.contains("BDD"))
		{
	        //JavascriptExecutor js = (JavascriptExecutor) driver;
	        //js.executeScript("javascript:window.scrollBy(70,170)");
	        
	    	//select[@name='PageSize']/option
	    	driver.findElement(By.xpath(webElement.get("CheckPageSize"))).click();
	    	Select select=new Select(driver.findElement(By.xpath(webElement.get("CheckPageSize"))));
	    	boolean result =select.getOptions().isEmpty();
	    	
	    	for (WebElement e:select.getOptions())
	    	{
	    	         System.out.println(e.getAttribute("value"));	
	    	}
	    	driver.findElement(By.xpath(webElement.get("CheckPageSize"))).click();
	    	Assert.assertTrue(!result);
		}
        else if (webshop.contains("WPK"))
		{
	        //JavascriptExecutor js = (JavascriptExecutor) driver;
	        //js.executeScript("javascript:window.scrollBy(70,170)");
	        
	    	//select[@name='PageSize']/option
	    	driver.findElement(By.xpath(webElement.get("CheckPageSize"))).click();
	    	Select select=new Select(driver.findElement(By.xpath(webElement.get("CheckPageSize"))));
	    	boolean result =select.getOptions().isEmpty();
	    	
	    	for (WebElement e:select.getOptions())
	    	{
	    	         System.out.println(e.getAttribute("value"));	
	    	}
	    	driver.findElement(By.xpath(webElement.get("CheckPageSize"))).click();
	    	Assert.assertTrue(!result);
		}
        else if (webshop.contains("BFS"))
		{
	        //JavascriptExecutor js = (JavascriptExecutor) driver;
	        //js.executeScript("javascript:window.scrollBy(70,170)");
	        
	    	//select[@name='PageSize']/option
	    	driver.findElement(By.xpath(webElement.get("CheckPageSize"))).click();
	    	Select select=new Select(driver.findElement(By.xpath(webElement.get("CheckPageSize"))));
	    	boolean result =select.getOptions().isEmpty();
	    	
	    	for (WebElement e:select.getOptions())
	    	{
	    	         System.out.println(e.getAttribute("value"));	
	    	}
	    	driver.findElement(By.xpath(webElement.get("CheckPageSize"))).click();
	    	Assert.assertTrue(!result);
		}
        
        else if (webshop.contains("GLO"))
		{
	        //JavascriptExecutor js = (JavascriptExecutor) driver;
	        //js.executeScript("javascript:window.scrollBy(70,170)");
	        
	    	//select[@name='PageSize']/option
	    	driver.findElement(By.xpath(webElement.get("CheckPageSize"))).click();
	    	Select select=new Select(driver.findElement(By.xpath(webElement.get("CheckPageSize"))));
	    	boolean result =select.getOptions().isEmpty();
	    	
	    	for (WebElement e:select.getOptions())
	    	{
	    	         System.out.println(e.getAttribute("value"));	
	    	}
	    	driver.findElement(By.xpath(webElement.get("CheckPageSize"))).click();
	    	Assert.assertTrue(!result);
		}
        
        else if (webshop.contains("King"))
		{
	        //JavascriptExecutor js = (JavascriptExecutor) driver;
	        //js.executeScript("javascript:window.scrollBy(70,170)");
	        
	    	//select[@name='PageSize']/option
	    	driver.findElement(By.xpath(webElement.get("CheckPageSize"))).click();
	    	Select select=new Select(driver.findElement(By.xpath(webElement.get("CheckPageSize"))));
	    	boolean result =select.getOptions().isEmpty();
	    	
	    	for (WebElement e:select.getOptions())
	    	{
	    	         System.out.println(e.getAttribute("value"));	
	    	}
	    	driver.findElement(By.xpath(webElement.get("CheckPageSize"))).click();
	    	Assert.assertTrue(!result);
		}
        else
        {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("javascript:window.scrollBy(70,170)");
	        
	    	//select[@name='PageSize']/option
	    	driver.findElement(By.xpath(webElement.get("CheckPageSize"))).click();
	    	Select select=new Select(driver.findElement(By.xpath(webElement.get("CheckPageSize"))));
	    	boolean result =select.getOptions().isEmpty();
	    	
	    	for (WebElement e:select.getOptions())
	    	{
	    	         System.out.println(e.getAttribute("value"));	
	    	}
	    	driver.findElement(By.xpath(webElement.get("CheckPageSize"))).click();
	    	Assert.assertTrue(!result);
        }
    }
    
    @Test(description="validate whether same number of items per page appears as selected in drop down")
    public void validateItemPerPageDropDown() throws InterruptedException
    {
    	moduleName="siteNavigationModule";
    	methodName="validateItemPerPageDropDown";
    	channelLocator="comChannel";
        initialize(moduleName,methodName, channelLocator);     	
    	
    	Select select=new Select(driver.findElement(By.xpath("//select[@name='PageSize']")));
    	int nOptions=select.getOptions().size();
    	boolean result =false;
    	int count =0;
    	String dropDownValue=null;
    	for (int i=1;i<=nOptions;i++)
    	{
    		     driver.findElement(By.xpath("//select[@name='PageSize']/option["+i+"]")).click();
    		     //Thread.sleep(10000);
    		     driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    	         dropDownValue=driver.findElement(By.xpath("//select[@name='PageSize']/option["+i+"]")).getAttribute("value");
    	         int value= Integer.parseInt(dropDownValue);
    	         System.out.println(value);
    	         
    	         
    	         int size=driver.findElements(By.xpath("//*[@data-bus='generic-product-list']")).size();
    	         System.out.println(size);
    	         if(size!=value)
    	         {
    	        	 count=count+1;
    	         }
    	         driver.findElement(By.xpath("//select[@name='PageSize']")).click();
    	}
    	if(count==0)
    	{
    		System.out.println("Assert"+count);
    		result=true;
    	}
    	Assert.assertTrue(result);
    }
    
    
    public void selectItemsPerPage(int i) throws InterruptedException
    {
    	
    	Select select=new Select(driver.findElement(By.xpath("//select[@name='PageSize']")));
    	//driver.findElement(By.xpath("//select[@name='PageSize']")).click();
    	
    	int index= i;    		
    	select.selectByIndex(index);
    	
    	//select.notify();
    	//Thread.sleep(30000);
        
    }
    
    @Test(description="select 9 items from drop down")
    public void select9ItemsPerPage() throws InterruptedException
    {
    	moduleName="siteNavigationModule";
    	methodName="select9ItemsPerPage";
    	channelLocator="comChannel";
        initialize(moduleName,methodName, channelLocator);
        
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("javascript:window.scrollBy(100,1700)");
		
		count1 = driver.findElements(By.xpath("//*[@class='button right icon fa fa-th']")).size();
		System.out.println("TEST " + count1);
		
		
		Thread.sleep(10000);
		if (count1 != 0)
		{
			driver.findElement(By.xpath("//*[@class='button right icon fa fa-th']")).click();
			Thread.sleep(10000);	
		}
		
		
    	String dropDownValue=null;
    	selectItemsPerPage(0);
    	driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
    	
    	Select select=new Select(driver.findElement(By.xpath(webElement.get("CheckPageSize"))));
    	dropDownValue=select.getFirstSelectedOption().getAttribute("value");
    	System.out.println(dropDownValue);
    	Assert.assertEquals(dropDownValue, "9");
    	
    }

    
    @Test(description="validate 9 items per page appears as selected in drop down")
    public void validate9ItemPerPage() throws InterruptedException
    {
    	moduleName="siteNavigationModule";
    	methodName="validate9ItemPerPage";
    	channelLocator="comChannel";
        initialize(moduleName,methodName, channelLocator);
    	boolean result =false; 
    	driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	
    	int size=driver.findElements(By.xpath(webElement.get("CheckNoOfItemOnPage"))).size();
    	System.out.println(size);
    	if(size==9 || size==12)
    	{
    	  result=true;  	        	 
    	}
    	         
    	Assert.assertTrue(result);
    	
    }
    
    @Test(description="select 12 items from drop down")
    public void select12ItemsPerPage() throws InterruptedException
    {
    	moduleName="siteNavigationModule";
    	methodName="select12ItemsPerPage";
    	channelLocator="comChannel";
        initialize(moduleName,methodName, channelLocator);
    	
    	String dropDownValue=null;
    	selectItemsPerPage(1);
    	driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
    	
    	Select select=new Select(driver.findElement(By.xpath(webElement.get("CheckPageSize"))));
    	dropDownValue=select.getFirstSelectedOption().getAttribute("value");
    	System.out.println(dropDownValue);
    	Assert.assertEquals(dropDownValue, "12");
    	
    }
    
    
    @Test(description="validate 12 items per page appears as selected in drop down")
    public void validate12ItemPerPage() throws InterruptedException
    {
    	moduleName="siteNavigationModule";
    	methodName="validate12ItemPerPage";
    	channelLocator="comChannel";
        initialize(moduleName,methodName, channelLocator);
    	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    	boolean result =false;    
    	int size=driver.findElements(By.xpath(webElement.get("CheckNoOfItemOnPage"))).size();
    	System.out.println(size);
    	if(size==12 || size==15)
    	{
    	  result=true;  	        	 
    	}
    	         
    	Assert.assertTrue(result);
    	
    }
    
    @Test(description="select 15 items from drop down")
    public void select15ItemsPerPage() throws InterruptedException
    {
    	moduleName="siteNavigationModule";
    	methodName="select15ItemsPerPage";
    	channelLocator="comChannel";
        initialize(moduleName,methodName, channelLocator);
    	String dropDownValue=null;
    	selectItemsPerPage(2);
    	driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
    	Select select=new Select(driver.findElement(By.xpath(webElement.get("CheckPageSize"))));
    	dropDownValue=select.getFirstSelectedOption().getAttribute("value");
    	System.out.println(dropDownValue);
    	Assert.assertEquals(dropDownValue, "15");
    	
    }
    
    
    @Test(description="validate 15 items per page appears as selected in drop down")
    public void validate15ItemPerPage() throws InterruptedException
    {
    	moduleName="siteNavigationModule";
    	methodName="validate15ItemPerPage";
    	channelLocator="comChannel";
        initialize(moduleName,methodName, channelLocator);
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
    	boolean result =false;    
    	int size=driver.findElements(By.xpath(webElement.get("CheckNoOfItemOnPage"))).size();
    	System.out.println(size);
    	if(size==15 || size==18)
    	{
    	  result=true;  	        	 
    	}
    	         
    	Assert.assertTrue(result);    	
    }
    
    @Test(description="select 24 items from drop down")
    public void select24ItemsPerPage() throws InterruptedException
    {
    	moduleName="siteNavigationModule";
    	methodName="select24ItemsPerPage";
    	channelLocator="comChannel";
        initialize(moduleName,methodName, channelLocator);
    	String dropDownValue=null;
    	selectItemsPerPage(3);
    	driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
    	Select select=new Select(driver.findElement(By.xpath(webElement.get("CheckPageSize"))));
    	dropDownValue=select.getFirstSelectedOption().getAttribute("value");
    	System.out.println(dropDownValue);
    	Assert.assertEquals(dropDownValue, "24");
    	
    	//JavascriptExecutor js = (JavascriptExecutor) driver;
    	//js.executeScript("javascript:window.scrollBy(300,400)");
    	
    }   
    
    @Test(description="validate 24 items per page appears as selected in drop down")
    public void validate24ItemPerPage() throws InterruptedException
    {
    	moduleName="siteNavigationModule";
    	methodName="validate24ItemPerPage";
    	channelLocator="comChannel";
        initialize(moduleName,methodName, channelLocator);
    	driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
    	boolean result =false;    
    	int size=driver.findElements(By.xpath(webElement.get("CheckNoOfItemOnPage"))).size();
    	Thread.sleep(10000);
    	
    	System.out.println(size);
    	if(size==24 || size==27)
    	{
    	  result=true;  	        	 
    	}
 	    
    	Thread.sleep(10000);	
    	Assert.assertTrue(result);    	
    }
    
    
    
    @Test(description = "move from overview page to order template details page")
	public void moveToOrderTemplateDetailPage() throws InterruptedException {
		moduleName = "ordertemplatelazyload";
		methodName = "moveToOrderTemplateDetailPage";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);
		Thread.sleep(3000);		
//		String OrderTemplate1 = "//a[contains(text(),'" + OrderTempName_1 + "')]";
//		Thread.sleep(3000);
		int temp = driver.findElements(By.xpath("//*[@class='product-title']")).size();
		System.out.println("Satya template size " + temp);
		String objVal;
		String objVal2;
		for (int i=1; i<=temp; i++) {
		String tempstr = driver.findElement(By.xpath("(//*[@class='product-title'])[" + (i) + "]")).getText();
		System.out.println("Satya template name " + tempstr);
		System.out.println("Satya template actual name " + OrderTempName_1);
		objVal = "(//*[@class='product-title'])[" + (i) + "]";
		objVal2 = "(//*[@class='product-title'])[" + (i) + "]";
		System.out.println("Satya objvalue " + objVal);
			if (tempstr.contains(OrderTempName_1))
					{
				driver.findElement(By.xpath(objVal2)).click();
				break;
			}
		}
    }
     
    
    @Test(description="Scroll down and check top icon appears")
    public void viewNoTopOnScrollDown() throws InterruptedException
    {
    	moduleName="ordertemplatelazyload";
    	methodName="viewNoTopOnScrollDown";
    	channelLocator="comChannel";
        initialize(moduleName,methodName, channelLocator);
  
    	Thread.sleep(5000);
    	JavascriptExecutor je = (JavascriptExecutor)driver;
    	
    	
    /*	if (driver.findElements(By.xpath("//*[@class='ish-productTable wishlistLazyLoadItemTable']//tr")).size()==0)
    	{
    		je.executeScript("window.scrollBy(0,250)");
    		viewTop=driver.findElement(By.id(webElement.get("scroll-button"))).isDisplayed();
    	}
    	Assert.assertFalse(viewTop);
    */	    System.out.println(driver.findElement(By.id(webElement.get("scroll-button"))).getAttribute("style"));
    		//je.executeScript("window.scrollBy(0,$(document).height())");
    		//System.out.println(driver.findElement(By.id(webElement.get("scroll-button"))).getAttribute("style"));
    		boolean viewTop=driver.findElement(By.id(webElement.get("scroll-button"))).getAttribute("style").contains("display: none");
    		System.out.println(viewTop);
    	    Assert.assertTrue(viewTop);  	
    }
    
       
    @Test(description="Scroll down and check top icon appears")
    public void viewTopOnScrollDown() throws InterruptedException
    {
    	moduleName="ordertemplatelazyload";
    	methodName="viewTopOnScrollDown";
    	channelLocator="comChannel";
        initialize(moduleName,methodName, channelLocator);
  
    	Thread.sleep(5000);
    	JavascriptExecutor je = (JavascriptExecutor)driver;
    	
    /*	if (driver.findElements(By.xpath("//*[@class='ish-productTable wishlistLazyLoadItemTable']//tr")).size()==0)
    	{
    		je.executeScript("window.scrollBy(0,250)");
    		viewTop=driver.findElement(By.id(webElement.get("scroll-button"))).isDisplayed();
    	}
    	Assert.assertFalse(viewTop);
    */	
    		je.executeScript("window.scrollBy(0,$(document).height())");
    		
    		//Thread.sleep(15000);
    		System.out.println(driver.findElement(By.id(webElement.get("scroll-button"))).getAttribute("style"));
    	    
    		
    		boolean viewIn=driver.findElement(By.id(webElement.get("scroll-button"))).getAttribute("style").contains("display: inline");
    		System.out.println(viewIn);
    		boolean viewBl=driver.findElement(By.id(webElement.get("scroll-button"))).getAttribute("style").contains("display: block");
    		System.out.println(viewBl);
    		boolean viewTop = (viewIn||viewBl);
    		System.out.println(viewTop);
    	    Assert.assertTrue(viewTop);   	
    }

    
    @Test(description="Scroll down and check top icon appears")
    public void viewAddToCartBtnOrderTemplate() throws InterruptedException
    {
    	moduleName="ordertemplatelazyload";
    	methodName="viewAddToCartBtnOrderTemplate";
    	channelLocator="comChannel";
        initialize(moduleName,methodName, channelLocator);   
        Thread.sleep(1000);
    	int btnCount=driver.findElements(By.xpath("//*[@name='AddToBasket']")).size();
    	System.out.println(btnCount);
    	Assert.assertTrue(btnCount==2);
    	Thread.sleep(1000);
  
   
    }
    //BE-2534 
    @Test(description="To verify the Add to cart button at product level in Favoritelist")
    public void viewAddToCartBtnOrderTemplateItemLevel() throws InterruptedException
    {
    	moduleName="ordertemplatelazyload";
    	methodName="viewAddToCartBtnOrderTemplateItemLevel";
    	channelLocator="comChannel";
        initialize(moduleName,methodName, channelLocator);   
        Thread.sleep(1000);
        int btnCount=driver.findElements(By.xpath("//*[@class='add-cart-item add-pl-item']")).size();
        int btnCount1=driver.findElements(By.xpath("//*[@class='ish-actionItemLink kor-open-as-dialog']")).size();
//      driver.findElement(By.xpath("(//*[@class='add-cart-item add-pl-item'])[1]")).click();        
        if (btnCount!= 0 && btnCount1!= 0)
        {    	
        System.out.println("Add to Cart button count" + btnCount); 
        System.out.println("Move to List button count" + btnCount1);
  	    Assert.assertTrue(btnCount>0);    	
        }
        else if(btnCount==0 && btnCount1!= 0)
        {
        	
        	System.out.println("Add to Cart button count" + btnCount); 
            System.out.println("Move to List button count" + btnCount1);
            System.out.println("There preference is switched off for the Application");
        }	
        else
        {
        	System.out.println("There are no items in the Favoritelist");
        }
  
   
    }
    
    
    
    //KIN 44 scripts
    
    @Test(description="validate the country list displayed on registration page")
    public void LimitCountryList() throws InterruptedException
    {
    	moduleName="LimitCountryListKing";
    	methodName="LimitCountryList";
    	channelLocator="specChannel";
        initialize(moduleName,methodName, channelLocator);
    	boolean Fail = false;
    	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    	Select Country = new Select(driver.findElement(By.className("kor-countryList")));
    	ReportUtil.captureScreenShot();
    	int size = Country.getOptions().size();
    	if (size == 12)
    	{
    	testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
    	testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator); 
        }
    	else
    	{
    	Assert.assertTrue(Fail);
         
    	}
    }
    
    //KIN 45 Scripts
    
    @Test(description="Navigate to the Users Page")
    public void GoToUsers() throws InterruptedException
    {
    	moduleName="siteNavigationModule";
    	methodName="GoToUsers";
    	channelLocator="specChannel";
        initialize(moduleName,methodName, channelLocator);    	
    	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    	Thread.sleep(4000);       	
       //	testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
    	testCaseUtil.processElements( mLink, "click", moduleName, methodName, driver, channelLocator);
    	
    }	
    
    @Test(description="Open the details page of a particular User")
    public void UserDetails() throws InterruptedException
    {
    	moduleName="siteNavigationModule";
    	methodName="UserDetails";
    	channelLocator="specChannel";
        initialize(moduleName,methodName, channelLocator);    	
    	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    	Thread.sleep(4000);       	
       	testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
       	testCaseUtil.processElements( mLink, "click", moduleName, methodName, driver, channelLocator);
    	
    }
    
    @Test(description="Open the details page of a particular User")
    public void SelectAddress() throws InterruptedException
    {
    	moduleName="siteNavigationModule";
    	methodName="SelectAddress";
    	channelLocator="specChannel";
        initialize(moduleName,methodName, channelLocator);    	
    	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    	Thread.sleep(4000);       	
       	testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
       	testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);
    	
    }
    @Test(description="Open the details page of a particular User")
    public void SelectALLAddress() throws InterruptedException
    {
    	moduleName="siteNavigationModule";
    	methodName="SelectALLAddress";
    	channelLocator="specChannel";
        initialize(moduleName,methodName, channelLocator);
    	//boolean result =false;
    	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    	Thread.sleep(4000); 
    	int size=driver.findElements(By.xpath("//*[@class='custom-myAccount-addressBox']//label")).size();
    	System.out.println("Total number of Delivery Address"+size);
        testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
        testCaseUtil.processElements( mLink, "click", moduleName, methodName, driver, channelLocator);
       	int size1=driver.findElements(By.xpath("//*[@checked='checked']")).size();
       	System.out.println("no of checked Delivery Address"+size1);
       	Assert.assertTrue(size==size1);
    	
    }
    
    @Test(description="Open the details page of a particular User")
    public void ClearALLAddress() throws InterruptedException
    {
    	moduleName="siteNavigationModule";
    	methodName="ClearALLAddress";
    	channelLocator="specChannel";
        initialize(moduleName,methodName, channelLocator);    	
    	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    	Thread.sleep(4000); 
    	int size=driver.findElements(By.xpath("//*[@class='custom-myAccount-addressBox']//label")).size();
    	System.out.println("Total number of Delivery Address"+size);
    	if (size>0)
    	{
    		testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
    		testCaseUtil.processElements(mLink, "click", moduleName, methodName, driver, channelLocator);    	
           	int size1=driver.findElements(By.xpath("//*[@checked='checked']")).size();
           	System.out.println("no of checked Delivery Address"+size1);
           	Assert.assertTrue(size1==0);
    	}
    	else
    	{	
    	Assert.assertTrue(false);
    	System.out.println("No delivery Address found");
    	}
    }
    
    //MAJ 219 Scripts
    
    @Test(description="To find the packaging info is displayed or not")
    public void PackagingInfoListerpage() throws InterruptedException
    {
    	moduleName="siteNavigationModule";
    	methodName="PackagingInfoListerpage";
    	channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);    	
    	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    	Thread.sleep(4000); 
    	List<WebElement> Z = driver.findElements(By.xpath("//*[@class='row no-margin rwd-tablet rwd-desktop lister-tile']//*[@class ='packaging-info']"));
    			for(WebElement e:Z)
    			{
    			 String pinfo =e.getText();
    			 System.out.println("the packaging info"+pinfo);
    			 if(pinfo!=null)
    			 {
    				String String1[] = new String[3];
    			    String1 = pinfo.split("/P");    			    
    			    {
    			    	if(String1.equals(null))
    			    	break;
    			    	System.out.println("the packaging info"+String1);
    			    }
    			 }
    			 }
    }  
    
    //BVP-13 Script
    
    @Test(description="fill in field, Change locale & check Alert")
    public void fillInChangeLocale() throws InterruptedException
    {
    	moduleName="siteNavigationModule";
    	methodName="fillInChangeLocale";
    	channelLocator="comChannel"; 
    	initialize(moduleName,methodName, channelLocator);   
    	//fill in email id field
    	testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);	    	
    	//now change locale
    	Assert.assertTrue(changeLocaleCheckAlert());  	 	
    		
    }  
    
    public boolean changeLocaleCheckAlert() throws InterruptedException{
    	String paretWindow= driver.getWindowHandle();
    	driver.findElement(By.xpath("//*[@class='localeSelect']//i")).click();
    	try {
			Thread.sleep(5000);
		}
    	catch (InterruptedException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	driver.findElement(By.xpath("//*[@id='setLanguage']/a/span")).click();
    	Alert a=driver.switchTo().alert();
    	Thread.sleep(5000);
    	System.out.println(a.getText());
    	String alertText=a.getText();
    	a.accept();
    	driver.switchTo().window(paretWindow);
    	return(!(alertText.isEmpty()));
    	
    }
	
	@Test(description = "Get Product Sku And open the Quote Page for prospect")
		public void getProductSkuAndQuotePopUp() throws InterruptedException 
		{
			moduleName = "siteNavigationModule";
			methodName = "getProductSkuAndQuotePopUp";
			channelLocator="comChannel";
			initialize(moduleName,methodName, channelLocator);					
			String getvalue2 = driver.findElement(By.xpath("(//*[@class='ish-link kor-add-to-wishlist-submit'])[1]")).getText();
            driver.findElement(By.xpath("//*[@class='fa fa-user']")).click();			
			Thread.sleep(1000);	
			String getvalue3 = driver.findElement(By.xpath("//*[@class='rwd-tablet rwd-desktop']/ul/li[3]")).getText();
			
//			driver.findElement(By.xpath("(//*[@class='ish-link kor-add-to-wishlist-submit'])[1]")).click();
//			testCaseUtil.processElements(mLink, "click", moduleName, methodName,  driver, channelLocator);
			if(getvalue2 != null && getvalue3 != null)
			{
			 System.out.println("Add to quote link exists for prospect user");
			}			
			Thread.sleep(2000);			            
			
//			driver.findElement(By.xpath("(//*[@class='ish-bar-actionButton ish-button-secondary']")).click();
//			testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);	
		
		}
    
 // For 34499
    @Test(description = "Click On Login Button")
	public void clickLoginButton() throws InterruptedException {
		moduleName = "siteNavigationModule";
		methodName = "clickLoginButton";
		channelLocator="comChannel";
		initialize(moduleName,methodName, channelLocator);	
		driver.findElement(By.xpath("(//li[@class='login-button-wrapper'])[2]")).click();
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver, channelLocator);
	}
    // For 34499
    @Test(description = "Login Using Pop In")
	public void loginUsingPopIn() throws InterruptedException 
	{
		moduleName = "siteNavigationModule";
		methodName = "loginUsingPopIn";
		channelLocator="specChannel";
		initialize(moduleName,methodName, channelLocator);
		Thread.sleep(7000);
		if (browser.contains("iexplore")) { // certificate issue in IE 7, 8 and 9
			if (driver.getPageSource().contains("Continue to this website")) 
			{
				driver.get("javascript:document.getElementById('overridelink').click();");
			}
		}
		
		testCaseUtil.checkAllFormElements(moduleName, methodName, driver, channelLocator);
		driver.findElement(By.xpath(mLink.get("loginButton"))).click();
		Thread.sleep(3000); // Don't remove
		
		if (browser.contains("iexplore")) { // certificate issue in IE 7, 8 and 9
			if (driver.getPageSource().contains("Continue to this website")) 
			{
				driver.get("javascript:document.getElementById('overridelink').click();");
			}
		}
		// Fall back code, in case the provided password doesn't work then try an alternate password.
		if (driver.getPageSource().contains("De ingevoerde combinatie van gebruikersnaam en wachtwoord is niet juist. Probeer het nogmaals."))
		{
			driver.findElement(By.id("ShopLoginForm_Password")).clear();
			driver.findElement(By.id("ShopLoginForm_Password")).sendKeys("123456");
			driver.findElement(By.xpath(mLink.get("loginButton"))).click();
		}
		// Fall back code ends
		testCaseUtil.checkAllTextMsgs(moduleName, methodName, "loginButton", driver, channelLocator);
		Thread.sleep(3000); 
	}
	
}
