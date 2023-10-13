package checkbox;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");

		WebElement monday = driver.findElement(By.xpath("//input[@id='monday']"));
		Thread.sleep(3000);
		monday.click();
		System.out.println("clicked on: " + monday.getAttribute("id") + " ->Selected: " + monday.isSelected());

		Thread.sleep(3000);
		driver.close();
	}

}
