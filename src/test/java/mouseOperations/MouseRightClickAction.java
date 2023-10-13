package mouseOperations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseRightClickAction {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		Thread.sleep(3000);

		// Locating right click button
		WebElement rightClickBtn = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));

		// Creating Actions class object to perform mouse actions
		// and passing driver to it
		Actions action = new Actions(driver);

		// Right click action perform on button
		action.contextClick(rightClickBtn).build().perform();
		System.out.println("Right click action performed..");

		WebElement boxAfterRightClick = driver
				.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-edit']"));
		boxAfterRightClick.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);

		boxAfterRightClick.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);

		boxAfterRightClick.sendKeys(Keys.ENTER);

		Thread.sleep(2000);
		driver.quit();
	}

}
