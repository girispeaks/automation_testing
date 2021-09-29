Feature: Login page feature

Background: user login
Given user is on login page

Scenario: Login page title
When user gets the title of the page
Then page title should be "Login - My Store"

Scenario: Forgot password link
Then forgot your password link should be displayed

Scenario: Login with correct credentials
When user enters username "girispeaks@gmail.com"
And user enters password "Wed@1234"
And user clicks on login button
Then user gets the title of the page
And page title should be "My account - My Store"