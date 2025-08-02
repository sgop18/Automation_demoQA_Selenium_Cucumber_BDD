package stepDefinitions;

import io.cucumber.java.en.Given;

import pageObjects.FormsCard_POM;
import pageObjects.HomePage_POM;
import pageObjects.StudentRegistration_POM;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;


import io.cucumber.java.en.*;

public class StudentRegistrationSteps {
	WebDriver driver = Hooks.getDriver();
	public HomePage_POM hp;
	public FormsCard_POM fcp;
	public StudentRegistration_POM srp;
	public Logger logger = LogManager.getLogger(this.getClass());
	
	
	@Given("User launches the chrome browser")
	public void user_launches_the_chrome_browser() {
		System.out.println("Browser launched based on browser selection in config.properties");    
	}

	@When("User navigates to the URL {string}")
	public void user_navigates_to_the_url(String demoQAurl) {
		
		driver.manage().deleteAllCookies();
		driver.get(demoQAurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));	    
	}


	@When("User clicks on the Forms card")
	public void user_clicks_on_the_forms_card() {
		hp=new HomePage_POM(driver);
		hp.clickFormCard();
	}

	@Then("User clicks on the Practice Form link")
	public void user_clicks_on_the_practice_form_link() {
		fcp = new FormsCard_POM(driver);
		fcp.clickPracticeForm();
	}

	@Given("User is on the DemoQA student registration form page")
	public void user_is_on_the_demo_qa_student_registration_form_page() {
		
		logger.info("*****Student Registration Tests Started******");
		
		srp = new StudentRegistration_POM(driver);
		if(srp.checkFormHeading()) {
			System.out.println("User is on the DemoQA student registration form page ");
		}
		else
		{
			System.out.println("User is NOT on the DemoQA student registration form page ");
		}
	}

	@When("User enters First Name {string} and Last Name {string}")
	public void user_enters_first_name_and_last_name(String fname, String lname) {
		srp.enterFirstName(fname);
		srp.enterLastName(lname);
	}

	@When("User enters Email {string}")
	public void user_enters_email(String email) {
		srp.enterEmail(email);	    
	}

	@When("User selects Gender {string}")
	public void user_selects_gender(String gender) {
		srp.selectGender(gender);	    
	}

	@When("User enters Mobile Number {string}")
	public void user_enters_mobile_number(String mnum) {
		srp.enterMobileNum(mnum);
	}

	@When("User select Date of Birth, Month {string}, Year {string}, Day {string}")
	public void user_select_date_of_birth_month_year_day(String month, String year, String day) {
		srp.selectDOB(month, year, day);
	}

	@When("User chooses Hobbies {string}")
	public void user_chooses_hobbies(String hobby) {
		srp.selectHobbies(hobby);

	}

	@When("User enters Address {string}")
	public void user_enters_address(String address) {
		srp.enterAddress(address);
	}

	@When("User selects State {string}")
	public void user_selects_state(String state) {
		srp.selectState(state);	    
	}

	@When("User selects City {string}")
	public void user_selects_city(String city) {
		srp.selectCity(city);
	}

	@Then("User clicks on Submit button")
	public void user_clicks_on_submit_button() {
		srp.clickSubmitbutton();	    
	}

	@And("Student registration should be successful")
	public void student_registration_should_be_successful() {
		Assert.assertTrue(srp.isRegSuccess(), "Student Registration was unsuccessful");
	}

	@Then("Validate First Name {string}, Last Name {string} and Email {string}")
	public void validate_first_name_last_name_and_email(String fname, String lname, String email) {
		String actFullName = fname + " "+ lname;
		String fullName=srp.validateFullName();
		String emailID=srp.validateemailID();
		assertEquals(fullName.trim(), actFullName, "Full name does not match");
		assertEquals(emailID.trim(), email, "does not match");

		System.out.println("Full name and email match successfully.");
	}

}
