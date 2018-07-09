package com.differentBrowserTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LaunchBrowser {
	
	public WebDriver driver;
	public String url = "http://automationpractice.com/index.php/";
	
	@Parameters({"Browser"})
	@Test
	public void launchBrowser(String browser) {
		System.out.println("Select browser of your choice:");
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.out.println("Launching chrome browser");
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\a631020\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url);
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			System.out.println("Launching firefox browser");
			
			System.setProperty("webdriver.firefox.marionette", "C:\\Users\\a631020\\Downloads\\geckodriver-v0.19.1-win64\\geckodriver.exe");
			driver = new  FirefoxDriver();
			driver.get(url);
		}
		
		else if(browser.equalsIgnoreCase("ie")){
        	System.out.println("launching internet explorer browser"); 
      	   	 
            System.setProperty("webdriver.ie.driver", "C:\\Users\\a631020\\Downloads\\IEDriverServer_x64_3.8.0\\IEDriverServer.exe");
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();	
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);  
			capabilities.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP,true);
			capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION,true);    
			capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL,url);
			capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS,true);        	
		//	driver=new RemoteWebDriver(new URL(url),capabilities);
			driver=new InternetExplorerDriver(capabilities);
			driver.get(url); 
        }
    	
    	else {
    		System.out.println("browser not found");
    	}
	}
	

}
