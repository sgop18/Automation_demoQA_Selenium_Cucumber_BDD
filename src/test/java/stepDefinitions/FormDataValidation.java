package stepDefinitions;

import java.util.Map;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pageObjects.ElementsCard_POM;

public class FormDataValidation {
	WebDriver driver = Hooks.getDriver();
	public ElementsCard_POM ep;
	public Logger logger=LogManager.getLogger(this.getClass());

	
	@Then("User clicks on the Text Box link")
	public void user_clicks_on_the_text_box_link() {
		ep = new ElementsCard_POM(driver);
		ep.clickTextBox();	    
	}

	@Given("User is on the DemoQA Text Box page")
	public void user_is_on_the_demo_qa_text_box_page() {
	    if(ep.checkTextBoxHeading()) {
			System.out.println("User is on the DemoQA Text Box page ");
		}
		else
		{
			System.out.println("User is NOT on the DemoQA Text Box page ");
		}
	}

	@When("User enters the following Details")
	public void user_enters_the_following_details(DataTable dataTable) {
		logger.info("*****Data input and Validation Tests Started******");
		Map<String,String> Details=dataTable.asMap(String.class,String.class);
		ep.enterFullName(Details.get("Full Name"));
		ep.enteruserEmail(Details.get("Email"));
		ep.enterCurrentAddress(Details.get("Current Address"));
		ep.enterPermanentAddress(Details.get("Permanent Address"));
		}

	@Then("User clicks on the submit button")
	public void user_clicks_on_the_submit_button() {
		ep.clickSubmit();	    
	}

	@And("User validates the Data entered in the form")
	public void user_validates_the_data_entered_in_the_form(DataTable dataTable) {
		 Map<String, String> expectedData = dataTable.asMap(String.class, String.class);
		 String actualFullName=ep.validateFullName().replace("Name:","").trim();
		 String actualEmail=ep.validateUserEmail().replace("Email:","").trim();
		 String actualCurrentAddress=ep.validateCurrentAddress().replace("Current Address :","").trim();
		 String actualPermAddress=ep.validatePermanentAddress().replace("Permananet Address :","").trim();
		 
		 Assert.assertEquals(actualFullName, expectedData.get("Full Name"));
		 Assert.assertEquals(actualEmail, expectedData.get("Email"));
		 Assert.assertEquals(actualCurrentAddress, expectedData.get("Current Address"));
		 Assert.assertEquals(actualPermAddress, expectedData.get("Permanent Address"));
	    
	}
}
