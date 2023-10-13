package tabs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenLinkInNewTab {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://bstackdemo.com/");
		Thread.sleep(2000);

		String tab = Keys.chord(Keys.CONTROL, Keys.ENTER);
		WebElement register_link = driver.findElement(By.linkText("Offers"));
		register_link.sendKeys(tab);

		Thread.sleep(2000);
		driver.quit();
	}
}
