package com.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.factory.DriverFactory;

public class MyAccountsPage {
	
	private WebDriver driver;
	//xpath ---> div[@id='center_column']/div[1]//span
	private By accountsSection = By.cssSelector("div#center_column div span");
	
	public MyAccountsPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public String getMyAccountsPageTitle() {
		return driver.getTitle();
	}
	 
	public int getAccountsSectionCount() {
		return driver.findElements(accountsSection).size();
	}
	
	public List<String> getAccountsSectionList() {
		List<WebElement> accountsList = driver.findElements(accountsSection);
		List<String> elements = new ArrayList<String>();
		for(WebElement e : accountsList)
			elements.add(e.getText());
		return elements;
	}	
}
