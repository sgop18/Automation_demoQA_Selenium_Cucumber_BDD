Feature: Tool Tip Validation

# As a user, I want to validate the tool tip functionality under the Widgets.

Background: User is on the demoqa homepage
	Given User launches the chrome browser
	When User navigates to the URL "https://demoqa.com"
	When User clicks on the Widgets card
	Then User clicks on the Tool Tips link
	

Scenario Outline: Student registration 
	Given User is on the DemoQA Tool Tips page
	When User hovers over the button with Tool Tip
	Then User sees a Tool tip
	And User Validates the message in the tool tip "You hovered over the Button"
	