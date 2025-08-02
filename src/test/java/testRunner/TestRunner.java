package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions( 
		features = {"Features"},
		glue={"stepDefinitions","Hooks"},
		monochrome=true,
		dryRun=false,
				plugin = {
				        "pretty",
				        "html:target/reports/HtmlReports/DemoQAReport.html",
				        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class TestRunner extends AbstractTestNGCucumberTests{

static {
System.out.println(">>>>> DemoQA Automation Testing is initialized <<<<<");
}

}