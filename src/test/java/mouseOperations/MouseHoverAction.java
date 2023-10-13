package mouseOperations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverAction {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		Thread.sleep(3000);

		// Locating desktop menu elelment
		WebElement desktopMenu = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));

		// Locating mac item element
		WebElement macMenuItem = driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));

		// Creating Actions class object to perform mouse actions
		// and passing driver to it
		Actions action = new Actions(driver);

		// Mouse hover operation performing
		action.moveToElement(desktopMenu).build().perform();
		action.moveToElement(macMenuItem).click().build().perform();
		System.out.println("clicked on mac.");
		Thread.sleep(3000);
		driver.quit();
	}

}
