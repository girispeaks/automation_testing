package com.learn.cucumberPractice.stepDefinition;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationSteps {
	
	@Given("user is on the registration page")
	public void user_is_on_the_registration_page() {
		System.out.println("User navigates to registration page");
	}

	@When("user enters following user details")
	public void user_enters_following_user_details(DataTable dataTable) {
		List<List<String>> userList = dataTable.asLists(String.class);		
		for(List<String> userData : userList) {
			System.out.println(userData);
			
		}

	}
	
	@When("user enters following user details with columns")
	public void user_enters_following_user_details_with_columns(DataTable dataTable) {
	   List<Map<String,String>> userList = dataTable.asMaps(String.class,String.class);
	   /*System.out.println(userList);
	   System.out.println(userList.get(0).get("FirstName"));*/
	   
	   for(Map<String, String> userData : userList)
		   System.out.println(userData.get("FirstName"));
	}

	@Then("user registration must be successfull")
	public void user_registration_must_be_successfull() {
		System.out.println("User Registration successful");

	}

}
