Feature: Login Feature

Scenario Outline: Login fail - possible combinations
	Given user is on Application landing page
	When user clicks on sign in button
	Then user is displayed login screen
	When user enters "<Username>" in username field
	And user enters "<Password>" in password field
	And user clicks sign in button
	Then user gets login failed error message
	
	Examples:
		| Username          | Password          |
		| incorrectusername | 123456            |
		| naveenautomation  | incorrectpassword |