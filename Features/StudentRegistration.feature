Feature: Student Registration

# As a user, I want to submit student registration form to verify if form submission is successful.

Background: User is on the demoqa homepage
	Given User launches the chrome browser
	When User navigates to the URL "https://demoqa.com"
	When User clicks on the Forms card
	Then User clicks on the Practice Form link
	

Scenario Outline: Student registration 
	Given User is on the DemoQA student registration form page
	When User enters First Name "<firstname>" and Last Name "<lastname>"
	When User enters Email "<email>"
	When User selects Gender "<gender>"
	When User enters Mobile Number "<mobilenumber>"
	When User select Date of Birth, Month "<month>", Year "<year>", Day "<day>"
	When User chooses Hobbies "<hobbies>"
	When User enters Address "<address>"
	When User selects State "<state>"
	When User selects City "<city>"
	Then User clicks on Submit button
	And Student registration should be successful
	Then Validate First Name "<firstname>", Last Name "<lastname>" and Email "<email>"
	
	Examples:
			| firstname| lastname | email |gender|mobilenumber|day|month|year|hobbies|uploadpicture|address|state|city|
			| Sangeetha| Gopinathan | Tester@gmail.com |Female|1234567890|10|October|1990|Music|uploadpicture|123 Street|Haryana|Karnal|
			
	
 
	
	
 