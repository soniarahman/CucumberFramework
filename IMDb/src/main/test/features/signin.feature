Feature: IMDb Signin Feature
This feature Sign In to IMDb

Scenario Outline: IMDb Signin Test Scenario

Given user have navigate to Signin Page
Then user have to click to Sign in with IMDb
And user enters "<email>" and "<password>"
When user clicks on Signin button
Then user navigates to home page




Examples:
	| email | password |
	| automationsonia@gmail.com | S1234567@ |