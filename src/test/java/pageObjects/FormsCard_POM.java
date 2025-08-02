package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormsCard_POM extends CommonConstructor_POM{

	//Constructor
	public FormsCard_POM(WebDriver driver) {
		super(driver);
	}

	//Locators for Home Page
	@FindBy(xpath="//span[normalize-space()='Practice Form']") WebElement lnk_PracticeForm;
	
	//Action methods
	public void clickPracticeForm() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(lnk_PracticeForm));
		lnk_PracticeForm.click();
	}

}
