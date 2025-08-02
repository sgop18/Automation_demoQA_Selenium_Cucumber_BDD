package utilities;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot {

	public static byte[] takeScreenshotsinByte(WebDriver driver) {
		TakesScreenshot ss = (TakesScreenshot)driver;
				return ss.getScreenshotAs(OutputType.BYTES);
	}
}
