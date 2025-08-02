Feature: Check the Upload and Download Functionality

# As a user, I want to check if the Upload file and the download file functionality works.

Background: User is on the demoqa homepage
	Given User launches the chrome browser
	When User navigates to the URL "https://demoqa.com"
	When User clicks on the Elements card
	Then User clicks on the Upload and Download link

	Scenario: Upload file Verification
	Given User is on the Upload and Download page
	When User clicks on the Choose File button and uploads a file from Path "./Toolsqa.jpg"
	Then upload file is successful
	
	Scenario: Download file Verification
	Given User is on the Upload and Download page
	When User clicks on the Download button to download a file
	Then Download file is successful
	