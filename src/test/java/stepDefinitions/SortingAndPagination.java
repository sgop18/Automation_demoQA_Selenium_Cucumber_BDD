package stepDefinitions;

import java.util.Arrays;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pageObjects.ElementsCard_POM;

public class SortingAndPagination {
	WebDriver driver = Hooks.getDriver();
	public ElementsCard_POM ep;
	String beforeSort[];
	String afterSort[];
	List<WebElement> rowOpt;
	public Logger logger = LogManager.getLogger(this.getClass());

	@Then("User clicks on the Web Tables link")
	public void user_clicks_on_the_web_tables_link() {
		ep = new ElementsCard_POM(driver);
		ep.clickWebTables();
	}
	@Given("User is on the DemoQA Web Tables page")
	public void user_is_on_the_demo_qa_web_tables_page() {
		if(ep.checkWebTablesHeading()){
			System.out.println("User is on the DemoQA Web Tables page ");
		}
		else
		{
			System.out.println("User is NOT on the DemoQA Web Tables page ");
		}
	}

	@When("User stores the initial first name data in the table in the original sorted order")
	public void user_stores_the_initial_first_name_data_in_the_table_in_the_original_sorted_order() {
		logger.info("*****Data Sorting Tests Started******");
		beforeSort=ep.getFirstColumnData();
	}

	@When("User clicks on the First name column header to sort the names in Ascending order")
	public void user_clicks_on_the_first_name_column_header_to_sort_the_names_in_ascending_order() {
		ep.clickFirstNameHeader();
	}

	@When("User verifies if all the data is sorted in ascending order")
	public void user_verifies_if_all_the_data_is_sorted_in_ascending_order() {
		afterSort=ep.getFirstColumnData();
		String[] expSorted = ep.getManualSortedFirstColumnData();
		Assert.assertEquals(afterSort, expSorted, "First Name column is not sorted in ascending order");

	}

	@When("User selects first option {string} in the rows drop down and checks the state of the Next button")
	public void user_selects_first_option_in_the_rows_drop_down_and_checks_the_state_of_the_next_button(String rows) {
		ep.selectRowsPerPage(rows);
		if(ep.checkNextButtonState()) {
			System.out.println("Not enough data to validate");
		}
	}

	@When("User adds the following user data to validate row selection and pagination:")
	public void user_adds_the_following_user_data_to_validate_row_selection_and_pagination(DataTable dataTable) {
		logger.info("*****Row Selection Tests Started******");
		List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : rows) {
			ep.addNewRecordData(
					row.get("First Name"),
					row.get("Last Name"),
					row.get("Email"),
					row.get("Age"),
					row.get("Salary"),
					row.get("Department")
					);
		}
	}



	@Then("User checks the state of the Next button")
	public void user_checks_the_state_of_the_next_button() {
		if(ep.checkNextButtonState()) {
			System.out.println("Next Button is Enabled after adding more Data");
		}

	}

	@When("User gets rows options from the rows drop down")
	public void user_gets_rows_options_from_the_rows_drop_down(){
		rowOpt=ep.getRowsDropDownOptions();

	}

	@Then("User verifies if same number of rows are displayed based on selection of dropdown values")
	public void user_verifies_if_same_number_of_rows_are_displayed_based_on_selection_of_dropdown_vlaues() {

		for(WebElement row:rowOpt) {
			String rowValue = row.getText().replaceAll("[^\\d]", "");
			int expRowCount = Integer.parseInt(rowValue);
			ep.selectRowsPerPage(rowValue);
			int actNoOfRows=ep.noOfRowsPerPage();
			Assert.assertEquals(expRowCount, actNoOfRows, "Rows do not Match");			
		}	
	}

	@When("User selects {string} rows from the rows drop down")
	public void user_selects_rows_from_the_rows_drop_down(String rows) {
		logger.info("*****Pagination Tests Started******");
		ep.selectRowsPerPage(rows);
	}

	@Then("User verifies if the Next button is enabled")
	public void user_verifies_if_the_next_button_is_enabled() {
		if(ep.checkNextButtonState()) {
			System.out.println("Next Button is Enabled after selecting the first option in the drop down");
		}
	}

	@Then("User verifies if the Previous button is enabled")
	public void user_verifies_if_the_previous_button_is_enabled() {
		if(ep.checkPrevButtonState()) {
			System.out.println("Previous Button is Enabled");
		}
	}

	}

