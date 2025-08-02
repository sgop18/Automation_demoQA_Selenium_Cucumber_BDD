Feature: Form Input Data Validation

# As a user, I want to submit the details on the form and validate the same.

Background: User is on the demoqa homepage
	Given User launches the chrome browser
	When User navigates to the URL "https://demoqa.com"
	When User clicks on the Elements card
	Then User clicks on the Text Box link
	

Scenario Outline: Student registration 
	Given User is on the DemoQA Text Box page
	When User enters the following Details
      | Full Name|Sangeetha Gopinathan |
      | Email|Testing123@gmail.com |
      | Current Address| Test st New York |
      | Permanent Address| Test st New Jersey  |
  Then User clicks on the submit button
  And User validates the Data entered in the form
  		| Full Name|Sangeetha Gopinathan |
      | Email|Testing123@gmail.com |
      | Current Address| Test st New York |
      | Permanent Address| Test st New Jersey  |
      