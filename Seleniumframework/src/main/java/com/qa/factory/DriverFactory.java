package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

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
		
		if(browser.equals("chrome")) {
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
					System.out.println("Please pass correct browser");
		
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
