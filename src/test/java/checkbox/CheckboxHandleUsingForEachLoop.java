package checkbox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxHandleUsingForEachLoop {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");

		List<WebElement> checkboxItems = driver
				.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		System.out.println("Checkbox size is: " + checkboxItems.size());

//		Using for each loop
		for (WebElement k : checkboxItems) {
			Thread.sleep(2000);
			k.click();
			System.out.println("clicked on: " + k.getAttribute("id") + " " + k.isSelected());
		}
		Thread.sleep(2000);
		driver.quit();
	}

}
