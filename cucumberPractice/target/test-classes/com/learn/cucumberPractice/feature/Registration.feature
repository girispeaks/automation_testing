Feature: User Registration

Scenario: User registration with different data
	Given user is on the registration page
	When user enters following user details
	 |Girish|automation|girish@gmail.com|5555|Bangalore|
	 |Tom|peter|tom@gmail.com|9999|London|
	 |Lisa|dsouza|lisa@gmail.com|7777|Sydney|
	Then user registration must be successfull
	
	
	Scenario: User registration with different data with columns
	Given user is on the registration page
	When user enters following user details with columns
	 |FirstName|LastName|email|phone|city|
	 |Girish|automation|girish@gmail.com|5555|Bangalore|
	 |Tom|peter|tom@gmail.com|9999|London|
	 |Lisa|dsouza|lisa@gmail.com|7777|Sydney|
	Then user registration must be successfull
	