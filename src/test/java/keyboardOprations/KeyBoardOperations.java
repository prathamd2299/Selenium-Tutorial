package keyboardOprations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoardOperations {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/key_presses");
		Thread.sleep(3000);

		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER, Keys.ARROW_DOWN).perform();

		System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText());

		Thread.sleep(2000);
		driver.quit();
	}

}
