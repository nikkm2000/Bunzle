package com.eperium.jumpstart;

import java.awt.Desktop;

//import io.appium.java_client.android.AndroidDriver;

//import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
//import java.net.MalformedURLException;
//import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.firefox.FirefoxDriver;  
import org.openqa.selenium.remote.DesiredCapabilities;  

import org.openqa.selenium.ie.*;
import org.codehaus.plexus.util.cli.CommandLineException;
import org.codehaus.plexus.util.cli.CommandLineUtils;
import org.codehaus.plexus.util.cli.Commandline;
import org.codehaus.plexus.util.cli.WriterStreamConsumer;
import org.openqa.selenium.*;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.eperium.jumpstart.testframework.utils.AdvanceXMLUtil;
import com.eperium.jumpstart.testframework.utils.PropertyLoader;
import com.eperium.jumpstart.testframework.utils.TestCaseUtil;

public class Setup 
{	
	public static WebDriver driver;
	public static String browser;
	public static String OCITYPE;
	public static String version;
	public static String testcasename;
	public static String platform;
	public static String environment;
	public static String noClick = "noClick";
	public static Properties urlProp;
	public static Properties localizationProp;
	public static Properties dataProp;
	public static Properties skuProp;
	public static Properties ENVIRONMENT;
	public static File app;
	static String channel;
	protected String timeoutString = "10";
	String moduleName = null;
	String methodName = null;
	protected String baseWidowHandle = null ,channelLocator=null;;
	protected Boolean checkInNewWindow = false;
	TestCaseUtil testCaseUtil = null;
	LinkedHashMap<String, String> mLink = null, mElements = null;;
	LinkedHashMap<String, String> element = null;
	LinkedHashMap<String, String> webElement = null;
	static FirefoxProfile firefoxProfile = null;
	static String site;
	static LoggingPreferences logs;
	protected WebDriver wDriver = null;
	static WebDriverWait wait = null;
	static JavascriptExecutor js = null;
	protected static String webshop=null;

	
	@BeforeSuite(alwaysRun = true)
	public void setupBeforeSuite(ITestContext context) throws Exception 
	{
		getParameter(context);
	}

	@BeforeTest(alwaysRun = true)
	public void setUpBeforeclass() throws Exception 
	{
		driverInitialization();
		this.wDriver = getDriver();
	//	Setup.wait = new WebDriverWait(wDriver, Integer.parseInt(timeoutString));
		Setup.js = (JavascriptExecutor) wDriver;
	}	
	
	public static void getParameter(ITestContext context) throws Exception 
	{
		try 
		{
			File classpathRoot = new File(System.getProperty("user.dir"));
			File appDir = new File(classpathRoot, "/app");
			app = new File(appDir, "android-debug.v.1.5.BETA.apk");
			channel = context.getCurrentXmlTest().getParameter("channel");
			String comchannel = context.getCurrentXmlTest().getParameter("comchannel");
			webshop=channel;
			AdvanceXMLUtil.loadXml(channel);
			AdvanceXMLUtil.loadCommonXml(comchannel);
			webshop=channel;
			AdvanceXMLUtil.loadXml(channel);
			AdvanceXMLUtil.loadCommonXml(comchannel);
			urlProp = PropertyLoader.getUrlPropertiesFile(channel);
			dataProp = PropertyLoader.getDatapropertiesFile(channel);
			skuProp = PropertyLoader.getSKUpropertiesFile(channel);
			localizationProp = PropertyLoader.getLocalizationPropertiesFile(channel);
			browser = context.getCurrentXmlTest().getParameter("selenium.browser");
			OCITYPE = context.getCurrentXmlTest().getParameter("OCITYPE");
			//version = context.getCurrentXmlTest().getParameter("selenium.browser.version");
			testcasename = context.getCurrentXmlTest().getParameter("testcasename");
			platform = context.getCurrentXmlTest().getParameter("platform");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public static LoggingPreferences setLoggingPreference() 
	{
		logs = new LoggingPreferences();
		logs.enable(LogType.DRIVER, Level.SEVERE);
		logs.enable(LogType.CLIENT, Level.SEVERE);
		logs.enable(LogType.BROWSER, Level.SEVERE);
		logs.enable(LogType.SERVER, Level.SEVERE);
		Logger logger = Logger.getLogger("");
		logger.setLevel(Level.OFF);
		return logs;
	}
	
	public static void driverInitialization() throws Exception 
	{
		if (!(platform.contains("mobile"))) 
		{
			if (("firefox").equalsIgnoreCase(browser)) 
			{
				startFirefoxDriver();
			}

			else if (("chrome").equalsIgnoreCase(browser)) 
			{
				//Desktop.getDesktop().open(new File(System.getProperty("user.dir")+"\\cXML\\DRD\\Chrome"));
				startChromeDriver();
			}
			
			else if (("headless").equalsIgnoreCase(browser)) 
			{
				startheadlessChromeDriver();
			}

			else if (("iexplore").equalsIgnoreCase(browser)) 
			{
				startIExploreDriver();
			}

			else if (("safari").equalsIgnoreCase(browser)) 
			{
				startSafariDriver();
			}
			else if (("PhantomJS").equalsIgnoreCase(browser)) 
			{
				startPhantomJSDriver();
			}
		}
		else if (platform.contains("mobile")) 
		{
			startAndroidDriver();
		}
		else 
		{
			throw new Exception("Browser " + browser + " or Platform " + platform + " type not supported");
		}
	}
	
	public static DesiredCapabilities internetExplorerDesiredCapebilities() 
	{
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.internetExplorer();
		
		
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/drivers/IEDriverServer.exe");
				
		desiredCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		desiredCapabilities.setCapability(InternetExplorerDriver.EXTRACT_PATH,true);
		desiredCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);
		desiredCapabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS,true);
		desiredCapabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
		desiredCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		
		desiredCapabilities.setCapability("allow-blocked-content", true);
		desiredCapabilities.setCapability("allowBlockedContent", true);
		
		desiredCapabilities.setBrowserName(browser);
		desiredCapabilities.setVersion(version);
	

		desiredCapabilities.setCapability(browser, BrowserType.IE);
		desiredCapabilities.setCapability(platform, Platform.WINDOWS);

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
		return desiredCapabilities;
	}

	public static DesiredCapabilities fireFoxDesiredCapebilities() 
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();			
		desiredCapabilities.setCapability("marionette",true);			
		//driver = new firefoxDriver(desiredCapabilities);
        
        //firefoxOptions options = new firefoxOptions();        
        //options.setLegacy(true);
        //options.addArguments("--headless");
        
		//firefoxProfile = new FirefoxProfile();
		//firefoxProfile.setAcceptUntrustedCertificates(true);
		
		//firefoxProfile.setPreference("browser.startup.homepage_override.mstone", "ignore");
		//firefoxProfile.setPreference("startup.homepage_welcome_url.additional", "about:blank");
		
		//desiredCapabilities.setCapability("firefox_profile", firefoxProfile);
		//desiredCapabilities.setCapability("firefox_profile", profile.ToBase64String());
		
		desiredCapabilities.setBrowserName(browser);
		desiredCapabilities.setVersion(version);
		//version=desiredCapabilities.getVersion().toString();
		//System.out.println("version" +version);		
		desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, setLoggingPreference());
		return desiredCapabilities;
	}


	public static DesiredCapabilities chromeDesiredCapebilities() 
	{
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		
		if(platform.contains("Desktop"))
		{
			
			//desiredCapabilities.setCapability("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");

			desiredCapabilities.setBrowserName(browser);
			desiredCapabilities.setVersion(version);
			
	        ChromeOptions options = new ChromeOptions();
	        //options.addArguments("--headless");
	        options.addArguments("--disable-gpu","--ignore-certificate-errors", "--silent");
	        //options.addArguments("--incognito");	        
	        //options.addArguments("--headless", "--disable-gpu", "--window-size=1900,1200","--ignore-certificate-errors", "--silent");
	        options.addArguments("window-size=1900x1200");
	        options.addArguments("test-type");
	        options.addArguments("disable-infobars");
	        options.addArguments("--allow-insecure-localhost");
	        options.addArguments("--proxy-bypass-list");	        

	        //options.addArguments("window-size=800,1024");
	        //DesiredCapabilities cap = DesiredCapabilities.chrome();
	        //cap.setCapability(ChromeOptions.CAPABILITY, options);
	        
	        //Map<String, String> mobileEmulation = new HashMap<>();
	        //mobileEmulation.put("deviceName", "iPad");
	        //ChromeOptions chromeOptions = new ChromeOptions();
	        //chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
	        
        		  
	        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
	        desiredCapabilities.setCapability("chrome.switches", Arrays.asList("--ignore-certificate-errors,--web-security=false,--ssl-protocol=any,--ignore-ssl-errors=true"));
	        desiredCapabilities.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, true);
			desiredCapabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
			desiredCapabilities.setCapability(CapabilityType.ENABLE_PROFILING_CAPABILITY, true);
			desiredCapabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
			desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);		
			desiredCapabilities.setJavascriptEnabled(true);			
	        
	        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
	       	desiredCapabilities.setCapability("chrome.switches", Arrays.asList("--disable-print-preview"));
			desiredCapabilities.setCapability("chrome.switches", Arrays.asList("--disable-print-preview"));
			desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, setLoggingPreference());
		}
		else if(platform.contains("Linux"))
		{
			//desiredCapabilities.setCapability("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			desiredCapabilities.setCapability("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");

			desiredCapabilities.setBrowserName(browser);
			desiredCapabilities.setVersion(version);
			
	        ChromeOptions options = new ChromeOptions();
	        //options.addArguments("--headless");
	        //options.addArguments("--headless", "--disable-gpu", "--window-size=1900,1200","--ignore-certificate-errors", "--silent");
	        options.addArguments("window-size=1900x1200");
	        options.addArguments("test-type");
	        options.addArguments("disable-infobars");
	        options.addArguments("--no-sandbox");
	        options.addArguments("--disable-setuid-sandbox");
	        
	        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
	        desiredCapabilities.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, true);
			desiredCapabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
			desiredCapabilities.setCapability(CapabilityType.ENABLE_PROFILING_CAPABILITY, true);
			desiredCapabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
			desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);		
			desiredCapabilities.setJavascriptEnabled(true);			
	        
	        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
	       	desiredCapabilities.setCapability("chrome.switches", Arrays.asList("--disable-print-preview"));
			desiredCapabilities.setCapability("chrome.switches", Arrays.asList("--disable-print-preview"));
			desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, setLoggingPreference());
		}
		return desiredCapabilities;
	}
	
	public static DesiredCapabilities headlesschromeDesiredCapebilities() 
	{
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		
		if(platform.contains("Desktop"))
		{
			
			desiredCapabilities.setCapability("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
//			System.setProperty("webdriver.chrome.driver","/opt/intershop/Automation_scripts/trunk/drivers/chromedriver");

			desiredCapabilities.setBrowserName(browser);
			desiredCapabilities.setVersion(version);
			
	        ChromeOptions options = new ChromeOptions();
	        //options.addArguments("--headless");
	        //options.addArguments("--headless", "--disable-gpu", "--window-size=1900,1200","--ignore-certificate-errors", "--silent");
	        //options.addArguments("--incognito");	        
//	        options.addArguments("window-size=1900x1200");
	        options.addArguments("test-type");
	        options.addArguments("disable-infobars");
	        options.addArguments("--allow-insecure-localhost");
	        options.addArguments("--proxy-bypass-list");	        
        		  
	        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
	        desiredCapabilities.setCapability("chrome.switches", Arrays.asList("--ignore-certificate-errors,--web-security=false,--ssl-protocol=any,--ignore-ssl-errors=true"));
	        desiredCapabilities.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, true);
			desiredCapabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
			desiredCapabilities.setCapability(CapabilityType.ENABLE_PROFILING_CAPABILITY, true);
			desiredCapabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
			desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);		
			desiredCapabilities.setJavascriptEnabled(true);			
	        
	        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
	       	desiredCapabilities.setCapability("chrome.switches", Arrays.asList("--disable-print-preview"));
			desiredCapabilities.setCapability("chrome.switches", Arrays.asList("--disable-print-preview"));
			desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, setLoggingPreference());
		}
		else if(platform.contains("Linux"))
		{
			//desiredCapabilities.setCapability("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			desiredCapabilities.setCapability("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
//			desiredCapabilities.setCapability("webdriver.chrome.driver", "/drivers/chromedriver");
//			System.setProperty("webdriver.chrome.driver","/opt/intershop/Automation_scripts/trunk/drivers/chromedriver");
			
			desiredCapabilities.setBrowserName(browser);
			desiredCapabilities.setVersion(version);
			
	        ChromeOptions options = new ChromeOptions();
	        //options.addArguments("--headless");
	        //options.addArguments("--headless", "--disable-gpu", "--window-size=1900,1200","--ignore-certificate-errors", "--silent");
//	        options.addArguments("window-size=1900x1200");
	        options.addArguments("test-type");
	        options.addArguments("disable-infobars");
	        options.addArguments("--no-sandbox");
	        options.addArguments("--disable-setuid-sandbox");
	        
	        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
	        desiredCapabilities.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, true);
			desiredCapabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
			desiredCapabilities.setCapability(CapabilityType.ENABLE_PROFILING_CAPABILITY, true);
			desiredCapabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
			desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);		
			desiredCapabilities.setJavascriptEnabled(true);			
	        
	        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
	       	desiredCapabilities.setCapability("chrome.switches", Arrays.asList("--disable-print-preview"));
			desiredCapabilities.setCapability("chrome.switches", Arrays.asList("--disable-print-preview"));
			desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, setLoggingPreference());
		}
		return desiredCapabilities;
	}
	

	public static DesiredCapabilities phantomJsDesiredCapebilities() 
	{		
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.phantomjs();
		if(platform.contains("Desktop"))
		{				
			desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, System.getProperty("user.dir") + "/drivers/phantomjs.exe");
	        
			desiredCapabilities.setPlatform(Platform.WINDOWS);
			
			desiredCapabilities.setJavascriptEnabled(true);
			desiredCapabilities.setCapability("locationContextEnabled", true);
			desiredCapabilities.setCapability("browserConnectionEnabled", true);
			desiredCapabilities.setCapability("localToRemoteUrlAccessEnabled", true);
			desiredCapabilities.setCapability("locationContextEnabled", true);
			
			desiredCapabilities.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, true);
			desiredCapabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
			desiredCapabilities.setCapability(CapabilityType.ENABLE_PROFILING_CAPABILITY, true);
			desiredCapabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
			desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);		
			desiredCapabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
			desiredCapabilities.setCapability(CapabilityType.SUPPORTS_LOCATION_CONTEXT, true);
			desiredCapabilities.setCapability(CapabilityType.OVERLAPPING_CHECK_DISABLED, true);
			desiredCapabilities.setCapability(CapabilityType.SUPPORTS_NETWORK_CONNECTION, true);
			desiredCapabilities.setCapability(CapabilityType.SUPPORTS_APPLICATION_CACHE, true);
			desiredCapabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, true);
			desiredCapabilities.setCapability(CapabilityType.SUPPORTS_FINDING_BY_CSS, true);
			desiredCapabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, true);
			desiredCapabilities.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
			
			String[] phantomArgs = new String[] { "--webdriver-loglevel=NONE", "--disk-cache=true", "--ssl-protocol=any", "--ignore-ssl-errors=true", "--web-security=false", "--webdriver-loglevel=NONE", "--disk-cache=true"}; 
			desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomArgs);
		}
		else if(platform.contains("Linux"))
		{
			desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, System.getProperty("user.dir") + "/drivers/phantomjs");
			
			desiredCapabilities.setPlatform(Platform.LINUX);
			
			desiredCapabilities.setJavascriptEnabled(true);
			desiredCapabilities.setCapability("locationContextEnabled", true);
			
			desiredCapabilities.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, true);
			desiredCapabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
			desiredCapabilities.setCapability(CapabilityType.ENABLE_PROFILING_CAPABILITY, true);
			desiredCapabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
			desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);		
			desiredCapabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
			desiredCapabilities.setCapability(CapabilityType.SUPPORTS_LOCATION_CONTEXT, true);
			desiredCapabilities.setCapability(CapabilityType.OVERLAPPING_CHECK_DISABLED, true);
			desiredCapabilities.setCapability(CapabilityType.SUPPORTS_NETWORK_CONNECTION, true);
			desiredCapabilities.setCapability(CapabilityType.SUPPORTS_APPLICATION_CACHE, true);
			desiredCapabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, true);
			desiredCapabilities.setCapability(CapabilityType.SUPPORTS_FINDING_BY_CSS, true);
			desiredCapabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, true);
			desiredCapabilities.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
			
			String[] phantomArgs = new String[] { "--webdriver-loglevel=NONE", "--disk-cache=true", "--ssl-protocol=any", "--ignore-ssl-errors=true", "--web-security=false", "--webdriver-loglevel=NONE", "--disk-cache=true"}; 
			desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomArgs);
		}	
		return desiredCapabilities;
	}

	
	public static DesiredCapabilities safariDesiredCapebilities() 
	{
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.safari();
		desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		desiredCapabilities.setBrowserName(browser);
		desiredCapabilities.setVersion(version);
		return desiredCapabilities;
	}
	
	public static DesiredCapabilities androidDesireCapabilities() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("deviceName", "5362ab76");
		capabilities.setCapability("appPackage", "com.salmon.dfs.servicemanager");
		capabilities.setCapability("appActivity", "com.salmon.dfs.servicemanager.MainActivity");
		capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
		capabilities.setCapability("recreateChromeDriverSessions", true);
		return capabilities;
	}

	private static void startSafariDriver() 
	{
		driver = new SafariDriver(safariDesiredCapebilities());
	}

	private static void startPhantomJSDriver() 
	{
		driver = new PhantomJSDriver(phantomJsDesiredCapebilities());
	}

	private static void startIExploreDriver() 
	{
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/drivers/IEDriverServer.exe");
		driver = new InternetExplorerDriver(internetExplorerDesiredCapebilities());
	}

	private static void startChromeDriver() 
	{
		if(platform.contains("Desktop"))
		{		
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			driver = new ChromeDriver(chromeDesiredCapebilities());	
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
			driver = new ChromeDriver(headlesschromeDesiredCapebilities());
		}

	}
	
	private static void startheadlessChromeDriver() 
	{
		if(platform.contains("Desktop"))
		{		
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			driver = new ChromeDriver(chromeDesiredCapebilities());	
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
			driver = new ChromeDriver(headlesschromeDesiredCapebilities());
		}
	}

	private static void startFirefoxDriver() 
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
		driver = new FirefoxDriver(fireFoxDesiredCapebilities());
	}

	private static void startAndroidDriver() 
	{
		/*try {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), androidDesireCapabilities());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}*/
	}

	public static WebDriver getDriver() 
	{
		return driver;
	}

	public void initialize(String moduleName, String methodName, String channelLocator)
	{
		//element = AdvanceXMLUtil.getAllChildrenForElements(moduleName, methodName);
//		System.out.println("----enter inside initialize");
		webElement=AdvanceXMLUtil.getAllChildrenForElements(moduleName,methodName, channelLocator);
//		System.out.println("----done getAllChildrenForElements");
		mLink = AdvanceXMLUtil.getAllChildrenForClick(moduleName, methodName, channelLocator);
//		System.out.println("----done getAllChildrenForClick");
		timeoutString = AdvanceXMLUtil.getValueForTimeOutById(moduleName, methodName, "timeout", channelLocator);
//		System.out.println("----done getValueForTimeOutById");
		testCaseUtil = new TestCaseUtil();
		baseWidowHandle = driver.getWindowHandle();
		
//		System.out.println("----exit inside initialize");
	}

	
	@AfterTest(alwaysRun = true)
	public void setupAfterTest() 
	{
		
		System.out.println("Cookies are about to delete");
		driver.manage().deleteAllCookies();
		wDriver.close();
		//Runtime.getRuntime().exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 2");
		wDriver.quit();
	}
	
	@AfterSuite(alwaysRun = true)
	public void setupAfterSuite() {
		
		System.out.println("It's OVer");
	}
	
}