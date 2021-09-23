Feature: Amazon Order Page
				In order the check my order details
				As a registered user
				I want to specify the features of the order details page
				
Background:
		Given a registered user exists
		Given user is on amazon login page
		When user enters username
		And user enters password
		And user clicks on login button
		Then user navigates to order page
				
Scenario: Check previous Order details
		When user click on Order link
		Then user checks the previous order page
		
Scenario: Check open order details
		When user click on Open Orders link
		Then user check the open order details
		
Scenario: Check cancelled order details
		When user click on Cancelled Orders link
		Then user check the cancelled order details 
		