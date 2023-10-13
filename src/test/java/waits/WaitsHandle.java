package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitsHandle {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement search = driver.findElement(By.xpath("//textarea[@name='q']"));
		search.sendKeys("Selenium");
		search.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//h3[text()='Selenium']")).click();
		
		driver.close();

	}

}
