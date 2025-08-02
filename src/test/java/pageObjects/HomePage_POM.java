package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage_POM extends CommonConstructor_POM{
	
	
	//Constructor
	public HomePage_POM(WebDriver driver) {
		super(driver);
		
	}

	//Locators for Home Page
	@FindBy(xpath="//h5[normalize-space()='Forms']") WebElement card_Forms;
	@FindBy(xpath="//h5[normalize-space()='Elements']") WebElement card_Elements; 
	
	
	
	//Action Methods
	
	public void clickFormCard() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", card_Forms);
		card_Forms.click();
	}
	
		
	public void clickElementsCard() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", card_Elements);
		card_Elements.click();
	}
	
	
	
}
