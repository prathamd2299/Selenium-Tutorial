package screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SectionOfPageScreenshot {
public static void main(String[] args) throws InterruptedException, IOException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver(); // driver is an instance of webdriver interface
	// chromedriver is an class
	driver.get("https://www.nopcommerce.com/en/demo");
	Thread.sleep(3000);
	
	// 2. Screenshot of portion of any page
	WebElement footer_section = driver.findElement(By.xpath("//div[@class='footer-upper']"));
	File src1 = footer_section.getScreenshotAs(OutputType.FILE);
	File target1 = new File("C:\\Users\\Lenovo\\Desktop\\selenium screenshot\\footer_section.png");
	FileUtils.copyFile(src1, target1);
	System.out.println("Footer section screenshot captured");
	
	driver.quit();
}
}
