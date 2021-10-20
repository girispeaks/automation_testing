package com.qa.factory;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlWebDriver = new ThreadLocal<WebDriver>();
	
	/**
	 * This method is used to initialize the threadlocal driver on the basis of given browser
	 * @param browser
	 * @return WebDriver
	 */
	
	public WebDriver init_driver(String browser) {
		
		//MutableCapabilities sauceOpts = new MutableCapabilities();
		//sauceOpts.setCapability("build", "Java-W3C-Examples");
		//sauceOpts.setCapability("seleniumVersion", "4.0.0-alpha-7");
		//sauceOpts.setCapability("username", "oauth-girispeaks-3dc2c");
		//sauceOpts.setCapability("accessKey", "5f64ebbb-9c01-4c84-9206-bed535fb38cc");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("build", "Java-W3C-Examples");
		cap.setCapability("seleniumVersion", "4.0.0-alpha-7");
		cap.setCapability("browserVersion", "latest");
		cap.setCapability("platformName", "windows 10");
		cap.setCapability("username", "oauth-girispeaks-3dc2c"); //we can get this credential from environmental variables
		cap.setCapability("accessKey", "5f64ebbb-9c01-4c84-9206-bed535fb38cc");
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			cap.setCapability("browserName", "chrome");
		} else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			cap.setCapability("browserName", "firefox");
		}
		//https://oauth-girispeaks-3dc2c:5f64ebbb-9c01-4c84-9206-bed535fb38cc@ondemand.eu-central-1.saucelabs.com:443/wd/hub
		try {
			driver = new RemoteWebDriver(new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub"), cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tlWebDriver.set(driver);
		
		//Code to run in local
		/*if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			
			
			tlWebDriver.set(new ChromeDriver());
			
		} else
			if(browser.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				tlWebDriver.set(new FirefoxDriver());
			} else
				if(browser.equals("IE")) {
					WebDriverManager.iedriver().setup();
					tlWebDriver.set(new InternetExplorerDriver());
				} else
					System.out.println("Please pass correct browser");*/
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
		
	}
	
	
	/**
	 * This is used to get the driver with threadlocal 
	 * @return WebDriver
	 */
	public static synchronized WebDriver getDriver() {
		return tlWebDriver.get();
	}
	

}
