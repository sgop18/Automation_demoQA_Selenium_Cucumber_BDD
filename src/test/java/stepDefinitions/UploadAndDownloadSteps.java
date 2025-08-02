package stepDefinitions;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.ElementsCard_POM;
import pageObjects.HomePage_POM;
import pageObjects.UploadAndDownload_POM;

public class UploadAndDownloadSteps {
	WebDriver driver = Hooks.getDriver();
	public HomePage_POM hp;
	public ElementsCard_POM ecp;
	public UploadAndDownload_POM up;

	@When("User clicks on the Elements card")
	public void user_clicks_on_the_elements_card() {
		hp = new HomePage_POM(driver);
		hp.clickElementsCard();	   
	}

	@Then("User clicks on the Upload and Download link")
	public void user_clicks_on_the_upload_and_download_link() {
		ecp = new ElementsCard_POM(driver);
		ecp.clickUploadAndDownloadLink();

	}

	@Given("User is on the Upload and Download page")
	public void user_is_on_the_upload_and_download_page() {
		up = new UploadAndDownload_POM(driver);
		if(up.checkHdgUploadDownloadPage()) {
			System.out.println("User is on the Upload and Download Page");
		}
		else {
			System.out.println("User is Not on the Upload and Download Page");
		}

	}

	@When("User clicks on the Choose File button and uploads a file from Path {string}")
	public void user_clicks_on_the_choose_file_button_and_uploads_a_file_from_path(String string) {
		up.uploadFile();
	}


	@Then("upload file is successful")
	public void upload_file_is_successful() {
		Assert.assertTrue(up.isUploadSuccessful("Toolsqa.jpg"), "Upload was not successful");
		System.out.println("Upload Successful");

	}

	@When("User clicks on the Download button to download a file")
	public void user_clicks_on_the_download_button_to_download_a_file() {
		up.downloadFile();
	}


	@Then("Download file is successful")
	public void download_file_is_successful() {

	}


}
