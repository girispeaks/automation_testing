package com.qa.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.LoginPage;
import com.pages.MyAccountsPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class MyAccountsPageSteps {
	
	//public static DriverFactory driver;
	private LoginPage login=new LoginPage(DriverFactory.getDriver());
	private MyAccountsPage myAccountsPage;
	private static String title;
	
	@Given("user has already logged into the application")
	public void user_has_already_logged_into_the_application(DataTable userCredential) {
	  List<Map<String, String>> userCred=  userCredential.asMaps();
	  String userName = userCred.get(0).get("username");
	  String password = userCred.get(0).get("password");
	  DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	  myAccountsPage = login.doLogin(userName, password);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		title = myAccountsPage.getMyAccountsPageTitle();
		System.out.println("Accounts Page title is "+title);
	}

	/* @Then("page title should be {string}")
	public void page_title_should_be(String pageTitle) {
	    Assert.assertEquals(title, pageTitle);
	}*/

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable dataTable) {
		List<String> expectedAccountsList = dataTable.asList();
		List<String> actualAccountsList = myAccountsPage.getAccountsSectionList();
		Assert.assertTrue(expectedAccountsList.containsAll(actualAccountsList));
	   
	}

	@Then("account section count should be {int}")
	public void account_section_count_should_be(Integer count) {
		Assert.assertTrue(myAccountsPage.getAccountsSectionCount() == count);
	}

}
