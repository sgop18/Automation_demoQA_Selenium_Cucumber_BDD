Feature: Web Table Interactions like sorting and pagination Validation

# As a user, I want to check if the sorting and pagination works as expected.

Background: User is on the demoqa homepage
	Given User launches the chrome browser
	When User navigates to the URL "https://demoqa.com"
	When User clicks on the Elements card
	Then User clicks on the Web Tables link
	Then User is on the DemoQA Web Tables page

Scenario: Verification of Sorting functionality of Webtable data
	When User stores the initial first name data in the table in the original sorted order
	When User clicks on the First name column header to sort the names in Ascending order
	And User verifies if all the data is sorted in ascending order
	
Scenario: User adds Data to verify Row Selection and Pagination
	When User selects first option "5" in the rows drop down and checks the state of the Next button
	When User adds the following user data to validate row selection and pagination:
      | First Name | Last Name | Email             | Age | Salary | Department |
      | Apple      | TestA     | Apple@email.com   | 20  | 10000  | QA         |
      | Orange     | TestB     | Orange@email.com  | 40  | 40000  | Dev        |
      | Mango      | TestC     | Mango@email.com   | 50  | 60000  | PM         |
	Then User checks the state of the Next button
	When User gets rows options from the rows drop down
	Then User verifies if same number of rows are displayed based on selection of dropdown values
	When User selects "5" rows from the rows drop down
	Then User verifies if the Next button is enabled
	And User verifies if the Previous button is enabled
	
