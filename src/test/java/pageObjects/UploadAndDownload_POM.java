package pageObjects;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UploadAndDownload_POM extends CommonConstructor_POM{
	
	//constructor
	public UploadAndDownload_POM(WebDriver driver){
		super(driver);
	}

	//Locators and elements for Upload and Download Functionality
	
	@FindBy(xpath="//h1[normalize-space()='Upload and Download']") WebElement hdg_upDown;
	@FindBy(id="uploadFile") WebElement btn_Upload;
	@FindBy(id="uploadedFilePath") WebElement msg_Upload;
	@FindBy(id="downloadButton") WebElement btn_Download;
	
	
	//Action methods 
	public boolean checkHdgUploadDownloadPage() {
		return hdg_upDown.isDisplayed();	
	}
	
	public void uploadFile() {
		File file = new File("./Toolsqa.jpg");
		btn_Upload.sendKeys(file.getAbsolutePath());
	}
	
	public boolean isUploadSuccessful(String filename) {
		String uploadPath = msg_Upload.getText();
		return uploadPath.contains(filename);
	}
	
	public void downloadFile() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_Download);
		btn_Download.click();		
	}
	
}
