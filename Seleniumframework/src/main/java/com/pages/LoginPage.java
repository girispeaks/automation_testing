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
	
	public void enterUserName(String userName) {
		driver.findElement(emailId).sendKeys(userName);
	}
	
	public void enterPwd(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickSignInBtn() {
		driver.findElement(signInButton).click();
	}
	
	public MyAccountsPage doLogin(String userName, String pwd) {
		driver.findElement(emailId).sendKeys(userName);
		driver.findElement(password).sendKeys(pwd);	
		driver.findElement(signInButton).click();
		return new MyAccountsPage(driver);
		}

}
