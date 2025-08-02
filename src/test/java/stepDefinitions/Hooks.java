package stepDefinitions;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import utilities.TakeScreenshot;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	public static WebDriver driver;
	public static Properties p;
	
	//method to return driver
	public static WebDriver getDriver() {
		return driver;
	}
	
	@Before
	public void setup() throws IOException {
		String basepath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", basepath+"/drivers/chromedriver.exe");
		System.setProperty("webdriver.edge.driver", basepath+"/drivers/msedgedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", basepath + "\\Downloads");
        prefs.put("download.prompt_for_download", false);
        prefs.put("safebrowsing.enabled", true);
        options.setExperimentalOption("prefs", prefs);
		
		String configFilePath = basepath+"/src/test/resources/config.properties";
		FileInputStream file = new FileInputStream(configFilePath);
		p=new Properties();
		p.load(file);

		String browser = p.getProperty("browser");

		switch(browser.toLowerCase()) {
		case "chrome" : driver=new ChromeDriver(options); break;
		case "edge" : driver=new EdgeDriver();break;
		default: System.out.println("invalid browser");return;
		}
	}
		
	@After(order=1)
	public void onScenarioFailure(Scenario scenario) {
		if(scenario.isFailed()) {
			
		scenario.attach(TakeScreenshot.takeScreenshotsinByte(driver), "image/png", scenario.getName());
		}
	}
	@After(order=0)
	public void teardown() throws InterruptedException {
		Thread.sleep(Duration.ofSeconds(5));
		driver.quit();
			}

}
