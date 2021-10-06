Feature: My Accounts page feature

Background:
Given user has already logged into the application
|      username      |password|
|girispeaks@gmail.com|Wed@1234|

Scenario: Accounts title page
Given user is on Accounts page
When user gets the title of the page
Then page title should be "My account - My Store"

Scenario: Accounts section count
Given user is on Accounts page
Then user gets accounts section
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
And account section count should be 5
