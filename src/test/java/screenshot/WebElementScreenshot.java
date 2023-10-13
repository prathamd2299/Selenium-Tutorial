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

public class WebElementScreenshot {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); // driver is an instance of webdriver interface
		// chromedriver is an class
		driver.get("https://www.nopcommerce.com/en/demo");
		Thread.sleep(3000);

		// 3. Screenshot of any particular element
		WebElement logo = driver.findElement(By.xpath("//img[@title='nopCommerce']"));
		File src2 = logo.getScreenshotAs(OutputType.FILE);
		File target2 = new File("C:\\Users\\Lenovo\\Desktop\\selenium screenshot\\logo.png");
		FileUtils.copyFile(src2, target2);
		System.out.println("logo screenshot captured");

		driver.quit();
	}

}
