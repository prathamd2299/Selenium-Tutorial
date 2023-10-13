package mouseOperations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseDoubleClickAction {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		Thread.sleep(3000);

		// First go in frame of name "iframeResult"
		driver.switchTo().frame("iframeResult");

		// Locating first input box
		WebElement firstField = driver.findElement(By.xpath("//input[@id='field1']"));
		Thread.sleep(2000);
		// Clicking on first inputbox
		firstField.click();

		Thread.sleep(2000);
		// Clearing existing value
		firstField.clear();

		Thread.sleep(2000);
		// Sending new value
		firstField.sendKeys("Prathamesh");
		System.out.println("First inputbox value is: " + firstField.getAttribute("value"));

		// Locating Copy Text button
		WebElement doubleClickBtn = driver.findElement(By.xpath("//button[text()='Copy Text']"));
		Thread.sleep(2000);
		// Creating Actions class object to perform mouse actions
		// and passing driver to it
		Actions action = new Actions(driver);

		// Double click action perform on button
		action.doubleClick(doubleClickBtn).build().perform();
		System.out.println("Double click action performed...");

		WebElement secondField = driver.findElement(By.xpath("//input[@id='field1']"));
		System.out.println("Second inputbox value is: " + secondField.getAttribute("value"));

		Thread.sleep(2000);
		driver.quit();
	}
}
