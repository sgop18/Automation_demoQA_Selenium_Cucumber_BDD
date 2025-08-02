package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//Common Constructor to be used across all the Page Object Classes

public class CommonConstructor_POM {
	WebDriver driver;
	
	public CommonConstructor_POM(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

}
