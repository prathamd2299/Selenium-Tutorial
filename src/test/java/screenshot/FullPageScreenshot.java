package screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FullPageScreenshot {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); // driver is an instance of webdriver interface
		// chromedriver is an class
		driver.get("https://www.nopcommerce.com/en/demo");
		Thread.sleep(3000);

		// 1. Full Page Screenshot
		// driver is an instance of webdriver interface and ts is an instance of
		// takesscreenshot interface
		// they both are different
		// so we have to typecast driver int takesscreenshot interface
		TakesScreenshot ts = (TakesScreenshot) driver;
		// This below statement capture the screenshot and store it in file
		// or somewhere in the hardware or memory
		// this method will return file instance
		File src = ts.getScreenshotAs(OutputType.FILE);
		// This will create one location to store the screenshots
		// we cannot see screenshot file if we do not copy into any particular location
		File target = new File("C:\\Users\\Lenovo\\Desktop\\selenium screenshot\\homepage.png");
		// below statement will copy src file into target file
		FileUtils.copyFile(src, target);
		System.out.println("Screenshot captured");

		driver.quit();
	}
}
