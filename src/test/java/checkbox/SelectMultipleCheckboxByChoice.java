package checkbox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectMultipleCheckboxByChoice {

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

//		Selecting multiple checkboxes by choice		
		for (WebElement chbox : checkboxItems) {
			String chboxname = chbox.getAttribute("id");
			if (chboxname.equals("thursday") || chboxname.equals("sunday")) {
				Thread.sleep(2000);
				chbox.click();
				System.out.println("clicked on: " + chbox.getAttribute("id") + " " + chbox.isSelected());
			}
		}
		Thread.sleep(2000);
		driver.quit();
	}

}
