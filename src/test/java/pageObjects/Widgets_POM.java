package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Widgets_POM extends CommonConstructor_POM {
	
	//Constructor
		public Widgets_POM(WebDriver driver) {
			super(driver);
		}

	//Locators and element for the Widgets page
		@FindBy(xpath="//h5[normalize-space()='Widgets']") WebElement card_Widgets;
		@FindBy(xpath="//span[normalize-space()='Tool Tips']") WebElement lnk_TootlTips;
		@FindBy(xpath="//h1[normalize-space()='Tool Tips']") WebElement hdg_ToolTip;
		@FindBy(id="toolTipButton") WebElement btn_ToolTip;
		@FindBy(xpath="//div[@class='tooltip-inner']") WebElement msg_ToolTip;
		
	//Action methods for Tool Tips
		public void clickWidgetsCard() {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", card_Widgets);
			card_Widgets.click();			
		}
		
		public void clickToolTipsLink() {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lnk_TootlTips);
			lnk_TootlTips.click();			
		}
		
		public boolean checkToolTipHeading() {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hdg_ToolTip);
			return hdg_ToolTip.isDisplayed();
		}
		
		public void moveToTTButton() {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_ToolTip);
			Actions action = new Actions(driver);
			action.moveToElement(btn_ToolTip).build().perform();
		}
		
		public String getToolTipMessage() {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		    wait.until(ExpectedConditions.visibilityOf(msg_ToolTip));
			return msg_ToolTip.getText();
		}

}
