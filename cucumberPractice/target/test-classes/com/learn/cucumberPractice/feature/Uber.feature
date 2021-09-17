@all
Feature: Uber Booking

@smoke
Scenario: Booking cab Sedan
Given User wants to select a car type "sedan" from uber app
When user select car "sedan" and pick up point "Bangalore" and drop location "Pune"
Then Driver starts the journey
And Driver ends the journey
Then User pays 1100 USD

@regression @sanity
Scenario: Booking cab SUV
Given User wants to select a car type "SUV" from uber app
When user select car "SUV" and pick up point "Bangalore" and drop location "Hyderabad"
Then Driver starts the journey
And Driver ends the journey
Then User pays 1000 USD

@production
Scenario: Booking cab for mini
Given User wants to select a car type "mini" from uber app
When user select car "mini" and pick up point "Pune" and drop location "Mumbai"
Then Driver starts the journey
And Driver ends the journey
Then User pays 500 USD