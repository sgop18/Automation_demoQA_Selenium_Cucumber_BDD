package stepDefinitions;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import io.cucumber.java.en.*;

import pageObjects.Widgets_POM;

public class ToolTipValidation {
	WebDriver driver=Hooks.getDriver();
	public Widgets_POM wp;
	String actTTMsg;
	public Logger logger = LogManager.getLogger(this.getClass());
	
	@When("User clicks on the Widgets card")
	public void user_clicks_on_the_widgets_card() {
		wp = new Widgets_POM(driver);
		wp.clickWidgetsCard();
	}

	@Then("User clicks on the Tool Tips link")
	public void user_clicks_on_the_tool_tips_link() {
		logger.info("*****Tool Tip Validation Tests Started******");
		wp.clickToolTipsLink();
	}

	@Given("User is on the DemoQA Tool Tips page")
	public void user_is_on_the_demo_qa_tool_tips_page() {
		if(wp.checkToolTipHeading()) {
			System.out.println("User is on the DemoQA Tool Tips page ");
		}
		else
		{
			System.out.println("User is NOT on the DemoQA Tool Tips page ");
		}
	}

	@When("User hovers over the button with Tool Tip")
	public void user_hovers_over_the_button_with_tool_tip() {
		wp.moveToTTButton();
	}

	@Then("User sees a Tool tip")
	public void user_sees_a_tool_tip() {
		actTTMsg= wp.getToolTipMessage();		
	}

	@Then("User Validates the message in the tool tip {string}")
	public void user_validates_the_message_in_the_tool_tip(String ttMsg) {
		Assert.assertEquals(actTTMsg, ttMsg, "Tooltip message does not match!");

	}
}
