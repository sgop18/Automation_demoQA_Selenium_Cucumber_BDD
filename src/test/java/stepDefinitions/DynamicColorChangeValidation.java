package stepDefinitions;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.ElementsCard_POM;


public class DynamicColorChangeValidation {
	WebDriver driver = Hooks.getDriver();
	public ElementsCard_POM ep;
	String initialColor;
	public Logger logger = LogManager.getLogger(this.getClass());
	
	@Then("User clicks on the Dynamic Properties link")
	public void user_clicks_on_the_dynamic_properties_link() {
		ep = new ElementsCard_POM(driver);
		ep.clickDynamicProp();
	}

	@Given("User is on the DemoQA Dynamic Properties page")
	public void user_is_on_the_demo_qa_dynamic_properties_page() {
		if(ep.checkDynamicPropHeading()){
			System.out.println("User is on the DemoQA Dynamic Properties page ");
		}
		else
		{
			System.out.println("User is NOT on the DemoQA Dynamic Properties page ");
		}
	}

	@Then("User checks and stores the initial text color of the button")
	public void user_checks_and_stores_the_initial_text_color_of_the_button() {
		logger.info("*****Dynamic color change Tests Started******");
		initialColor = ep.getColor();
	}

	@Then("User waits for {int} seconds")
	public void user_waits_for_seconds(Integer seconds) throws InterruptedException {
		Thread.sleep(seconds * 1000);
	}

	@Then("User checks if the text color of the button has changed")
	public void user_checks_if_the_text_color_of_the_button_has_changed() {
		String changedColor = ep.getColor();
		Assert.assertNotEquals(changedColor, initialColor, "The Text color in the button did not Change");	    
	}

	@Then("User verifies if the button with text {string} is displayed")
	public void user_verifies_if_the_button_with_text_is_displayed(String expText) {
		String actText=ep.getVisibleAfterButtonText();
		Assert.assertEquals(actText, expText,"Button text does not match");
		Assert.assertTrue(ep.checkVisibleAfterButton(), "Button Not Visible after 5 Seconds");
	}

}
