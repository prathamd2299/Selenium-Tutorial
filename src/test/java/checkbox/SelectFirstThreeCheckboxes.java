package checkbox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectFirstThreeCheckboxes {

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

//		Selecting first 3 checkboxes
		int totalchboxes = checkboxItems.size();
		for (int i = 0; i < totalchboxes; i++) {
			if (i < 4) {
				Thread.sleep(2000);
				checkboxItems.get(i).click();
				System.out.println("Clicked on: " + checkboxItems.get(i).getAttribute("id") + " ->Selected: "
						+ checkboxItems.get(i).isSelected());
			}
		}

		Thread.sleep(3000);
		driver.close();

	}

}
