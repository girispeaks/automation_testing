package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	//1. Locators
	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By signInButton = By.id("SubmitLogin");
	private By linkText = By.linkText("Forgot your password?");
	
	//2. Constructor of the page class
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//3. page actions: features of the page in the form of methods.
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public Boolean isForgotPasswordLinkPresent() {
		return driver.findElement(linkText).isDisplayed();
	}

}
