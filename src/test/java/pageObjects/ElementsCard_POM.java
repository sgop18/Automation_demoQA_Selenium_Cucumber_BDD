package pageObjects;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsCard_POM extends CommonConstructor_POM{

	//Constructor
	public ElementsCard_POM(WebDriver driver) {
		super(driver);
	}

	//Locators for Elements Page	
	@FindBy(xpath="//span[normalize-space()='Upload and Download']") WebElement lnk_UpDown;
	//Test Box
	@FindBy(xpath="//span[normalize-space()='Text Box']") WebElement lnk_TextBox;
	@FindBy(xpath="//h1[normalize-space()='Text Box']") WebElement hdg_Textbox;
	@FindBy(id="userName") WebElement txt_FullName;
	@FindBy(id="userEmail") WebElement txt_Email;
	@FindBy(id="currentAddress") WebElement txt_cAddress;
	@FindBy(id="permanentAddress") WebElement txt_pAddress;
	@FindBy(id="submit") WebElement btn_Submit;
	@FindBy(xpath="//p[@id='name']") WebElement txt_ValName;
	@FindBy(xpath="//p[@id='email']") WebElement txt_ValEmail;
	@FindBy(xpath="//p[@id='currentAddress']") WebElement txt_ValcAddress;
	@FindBy(xpath="//p[@id='permanentAddress']") WebElement txt_ValpAddress;

	//Dynamic Properties
	@FindBy(xpath="//span[normalize-space()='Dynamic Properties']") WebElement lnk_DynamicProp;
	@FindBy(xpath="//h1[normalize-space()='Dynamic Properties']") WebElement hdg_DynamicProp;
	@FindBy(xpath="//button[@id='colorChange']") WebElement btn_ColorChange;
	@FindBy(xpath="//button[@id='visibleAfter']") WebElement btn_VisibleAfter;

	//Locators for WebTables
	@FindBy(xpath="//span[contains(text(),'Web Tables')]") WebElement lnk_WebTables;
	@FindBy(xpath="//h1[normalize-space()='Web Tables']") WebElement hdg_WebTables;
	@FindBy(xpath="//div[@class='rt-tbody']//div[@class='rt-tr-group']//div[contains(@class,'rt-tr') and not(contains(@class,'-padRow'))]/div[1]") List<WebElement> getFirstColumn;
	@FindBy(xpath="//div[contains(text(),'First Name')]") WebElement hdr_colFirstName;
	@FindBy(xpath="//select[@aria-label='rows per page']") WebElement dd_RowsPerPage;
	@FindBy(xpath="//div[@class='rt-tr-group' and .//div[contains(@class,'rt-td') and not(.//span[text()=' '])]]") List<WebElement> rowsWithData;
	@FindBy(xpath="//button[normalize-space()='Next']") WebElement btn_Next;
	@FindBy(xpath="//button[normalize-space()='Previous']") WebElement btn_Prev;
	@FindBy(id="addNewRecordButton") WebElement btn_AddnewRecord;
	@FindBy(id="firstName") WebElement txt_FName;
	@FindBy(id="lastName") WebElement txt_LName;
	@FindBy(id="userEmail") WebElement txt_eMail;
	@FindBy(id="age") WebElement txt_Age;
	@FindBy(id="salary") WebElement txt_Salary;
	@FindBy(id="department") WebElement txt_Dept;
	@FindBy(id="submit") WebElement btn_SubmitnewRecord;
	@FindBy(css=".rt-tbody .rt-tr-group") List<WebElement> NoOfRows;
	
	
	


	//Action methods for Upload and Download
	public void clickUploadAndDownloadLink() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lnk_UpDown);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(lnk_UpDown));
		lnk_UpDown.click();
	}

	//Action methods for Text Box
	public void clickTextBox() {
		lnk_TextBox.click();
	}

	public boolean checkTextBoxHeading() {
		return hdg_Textbox.isDisplayed();
	}

	public String enterFullName(String fullname) {
		txt_FullName.sendKeys(fullname);
		return fullname;
	}

	public String enteruserEmail(String userEmail) {
		txt_Email.sendKeys(userEmail);
		return userEmail;
	}

	public String enterCurrentAddress(String cAddress) {
		txt_cAddress.sendKeys(cAddress);
		return cAddress;
	}

	public String enterPermanentAddress(String pAddress) {
		txt_pAddress.sendKeys(pAddress);
		return pAddress;
	}

	public void clickSubmit() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_Submit);
		btn_Submit.click();
	}

	public String validateFullName() {
		return txt_ValName.getText();
	}

	public String validateUserEmail() {
		return txt_ValEmail.getText();
	}

	public String validateCurrentAddress() {
		return txt_ValcAddress.getText();
	}

	public String validatePermanentAddress() {
		return txt_ValpAddress.getText();
	}

	//Action methods for Dynamic Properties
	public void clickDynamicProp() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lnk_DynamicProp);
		lnk_DynamicProp.click();
	}

	public boolean checkDynamicPropHeading() {
		return hdg_DynamicProp.isDisplayed();
	}

	public String getColor() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_ColorChange);
		return btn_ColorChange.getCssValue("color");		
	}

	public boolean checkVisibleAfterButton() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_VisibleAfter);
		return btn_VisibleAfter.isDisplayed();
	}

	public String getVisibleAfterButtonText() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_VisibleAfter);
		return btn_VisibleAfter.getText();
	}

	//Action methods for sorting

	public void clickWebTables() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lnk_WebTables);
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(lnk_WebTables));
		lnk_WebTables.click();
	}

	public boolean checkWebTablesHeading() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hdg_WebTables);
		return hdg_WebTables.isDisplayed();
	}

	public String[] getFirstColumnData() {
		String[] getFirstColData = new String[getFirstColumn.size()];

		for(int i=0; i<getFirstColumn.size();i++) {
			getFirstColData[i]=getFirstColumn.get(i).getText().trim();
		}
		return getFirstColData;
	}

	public void clickFirstNameHeader() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hdr_colFirstName);
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(hdr_colFirstName));
		hdr_colFirstName.click();
		}
		
	public String[] getManualSortedFirstColumnData() {
		String[] manualSortedData = new String[getFirstColumn.size()];
		for(int i=0; i<getFirstColumn.size();i++) {
			manualSortedData[i]=getFirstColumn.get(i).getText().trim();
		}
		Arrays.sort(manualSortedData);
		return manualSortedData;
	}
	
	//Action methods for Rows and Pagination Selection
		public List<WebElement> getRowsDropDownOptions() {
			Select rowsPP = new Select(dd_RowsPerPage);
			List<WebElement> listofopt = rowsPP.getOptions();
			return listofopt;
		}
		
		public void selectRowsPerPage(String rows) {
			Select rowsPP = new Select(dd_RowsPerPage);
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(dd_RowsPerPage));
			rowsPP.selectByValue(rows);
		}
		public boolean checkNextButtonState() {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_Next);
			return btn_Next.isEnabled();
		}
		
		public void clickNextButton() {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_Next);
			btn_Next.click();
		}
		
		public void clickPrevButton() {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_Prev);
			btn_Prev.click();
		}
		
		public boolean checkPrevButtonState() {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_Prev);
			return btn_Prev.isEnabled();
		}
		public void addButton() {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_AddnewRecord);
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(btn_AddnewRecord));
			btn_AddnewRecord.click();
		}

		public void addNewRecordData(String fname, String lname, String email, String age, String salary, String department) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_AddnewRecord);
		    btn_AddnewRecord.click();
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		    wait.until(ExpectedConditions.visibilityOf(txt_FName));
		    
		    txt_FName.sendKeys(fname);
		    txt_LName.sendKeys(lname);
		    txt_eMail.sendKeys(email);
		    txt_Age.sendKeys(age);
		    txt_Salary.sendKeys(salary);
		    txt_Dept.sendKeys(department);
		    
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_SubmitnewRecord);
		    btn_SubmitnewRecord.click();
		}

		public void clickSubmitNewRecord() {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_SubmitnewRecord);
			btn_SubmitnewRecord.click();
		}
		
		public int noOfRowsPerPage() {
			return NoOfRows.size();
			
		}
		
		public int getRowsWithData() {
			return rowsWithData.size();
		}
}

