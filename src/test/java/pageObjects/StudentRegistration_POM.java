package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.datatransfer.StringSelection;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StudentRegistration_POM extends CommonConstructor_POM {
	public int day;
	//Constructor
	public StudentRegistration_POM(WebDriver driver)
	{
		super(driver);
	}

	//Locators and elements for Student Registration page
	@FindBy(xpath="//h5[normalize-space()='Student Registration Form']") WebElement hdg_StudentReg;
	@FindBy(id="firstName") WebElement txt_FirstName;
	@FindBy(id="lastName") WebElement txt_LastName;
	@FindBy(id="userEmail") WebElement txt_Email;
	@FindBy(id="gender-radio-1") WebElement rbtn_Male;
	@FindBy(id="gender-radio-2") WebElement rbtn_Female;
	@FindBy(id="gender-radio-3") WebElement rbtn_Other;
	@FindBy(id="userNumber") WebElement txt_Mobilenum;
	@FindBy(id="dateOfBirthInput") WebElement lnk_DOB;
	@FindBy(xpath="//select[@class='react-datepicker__month-select']") WebElement dd_Month;
	@FindBy(xpath="//select[@class='react-datepicker__year-select']") WebElement dd_Year;
	@FindBy(xpath="//div[contains(@class,'react-datepicker__day') and not(contains(@class,'--outside-month'))]") List<WebElement> days;
	@FindBy(id="hobbies-checkbox-1") WebElement chkbox_Sports;
	@FindBy(id="hobbies-checkbox-2") WebElement chkbox_Reading;
	@FindBy(id="hobbies-checkbox-3") WebElement chkbox_Music;
	@FindBy(id="uploadPicture") WebElement lnk_UploadPic;
	@FindBy(id="currentAddress") WebElement txt_Address;
	@FindBy(xpath="//div[contains(text(),'Select State')]") WebElement dd_SelectState;
	@FindBy(xpath="//div[contains(text(),'Select City')]") WebElement dd_SelectCity;
	@FindBy(id="submit") WebElement btn_Submit;
	@FindBy(id="example-modal-sizes-title-lg") WebElement hdg_RegSuccess;
	@FindBy(xpath="//tr[td[text()='Student Name']]/td[2]") WebElement fullName;
	@FindBy(xpath="//tbody/tr[2]/td[2]") WebElement emailID;

	//Action Methods
	public boolean checkFormHeading() {
		return hdg_StudentReg.isDisplayed();
	}

	public String enterFirstName(String fname) {
		txt_FirstName.sendKeys(fname);
		return fname;
	}

	public String enterLastName(String lname) {
		txt_LastName.sendKeys(lname);
		return lname;
	}

	public String enterEmail(String email) {
		txt_Email.sendKeys(email);
		return email;
	}

	public void selectGender(String gender) {
		
		WebElement genderbtn;
		
		switch(gender) {
		case "Male" : genderbtn = rbtn_Male; break;
		case "Female" : genderbtn = rbtn_Female;break;
		case "Other" : genderbtn = rbtn_Other;break;
		default: System.out.println("invalid gender");return;
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", genderbtn);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", genderbtn);
	}

	public void enterMobileNum(String mnum) {
		txt_Mobilenum.sendKeys(mnum);
	}

	public void selectDOB(String month, String year, String day) {
		lnk_DOB.click();
		Select mon= new Select(dd_Month);
		mon.selectByVisibleText(month);

		Select yr = new Select(dd_Year);
		yr.selectByVisibleText(year);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		for(WebElement date:days) {
			if(date.getText().equals(day)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", date);
				wait.until(ExpectedConditions.visibilityOf(date));
				date.click();
				break;
			}			
		}
	}

	public void selectHobbies(String hobby) {
		WebElement hobbychk;
		switch(hobby.toLowerCase()) {
		case "sports" : hobbychk = chkbox_Sports; break;
		case "reading" : hobbychk = chkbox_Reading;break;
		case "music" : hobbychk = chkbox_Music;break;
		default: System.out.println("Hobby");return;
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hobbychk);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", hobbychk);
	}


	public void enterAddress(String address) {
		txt_Address.sendKeys(address);
	}

	public void selectState(String state) {
		
		dd_SelectState.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		String spath = String.format("//div[contains(@id,'react-select') and text()='%s']", state);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(spath)));
		WebElement stateOption = driver.findElement(By.xpath(spath));
		
		wait.until(ExpectedConditions.elementToBeClickable(stateOption));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", stateOption);
		
		
	}

	public void selectCity(String city) {
		
		dd_SelectCity.click();		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		String cpath = String.format("//div[contains(@id,'react-select') and text()='%s']", city);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(cpath)));
		WebElement cityOption = driver.findElement(By.xpath(cpath));
		
		wait.until(ExpectedConditions.elementToBeClickable(cityOption));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cityOption);
	}
	
	public void clickSubmitbutton() {
		btn_Submit.click();
	}

	public boolean isRegSuccess() {
		return hdg_RegSuccess.isDisplayed();
		
	}
	
	public String validateFullName() {
		return fullName.getText();
	}
	
	public String validateemailID() {
		return emailID.getText();
	}
}
