package checkbox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectLastTwoCheckboxes {

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

//		Selecting last 2 checkboxes
//		Total no. of checkboxes - No. of checkboxes want to select = Starting index		
		int totalchboxes = checkboxItems.size();
		for (int i = totalchboxes - 2; i < totalchboxes; i++) {
			Thread.sleep(3000);
			checkboxItems.get(i).click();
			System.out.println(
					"clicked on: " + checkboxItems.get(i).getAttribute("id") + " ->Selected: " + checkboxItems.get(i).isSelected());
		}
		Thread.sleep(2000);
		driver.quit();
	}

}
