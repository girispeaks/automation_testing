Feature: My Accounts page feature

Background:
Given user has already logged into the application
|      username      |password|
|girispeaks@gmail.com|Wed@1234|

Scenario: Accounts title page
Given user is on Accounts page
Then page title should be "My account - My Store"

Scenario: Accounts section count
Given user is on Accounts page
Then user gets accounts section
|Order history and details|
|My credit slips|
|My addresses|
|My personal information|
|My wishlists|
And account section count should be 5
