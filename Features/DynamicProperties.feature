Feature: Dynamic Properties Validation

# As a user, I want to check if the Text in the button changes color dynamically after 5 seconds.

Background: User is on the demoqa homepage
	Given User launches the chrome browser
	When User navigates to the URL "https://demoqa.com"
	When User clicks on the Elements card
	Then User clicks on the Dynamic Properties link
	

Scenario Outline: Student registration 
	Given User is on the DemoQA Dynamic Properties page
	Then User checks and stores the initial text color of the button
  Then User waits for 5 seconds
  And User checks if the text color of the button has changed
  Then User verifies if the button with text "Visible After 5 Seconds" is displayed
      