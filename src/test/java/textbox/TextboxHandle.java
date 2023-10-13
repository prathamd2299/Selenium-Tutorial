package textbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextboxHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement emailbox = driver.findElement(By.xpath("//input[@id='Email']"));
		emailbox.clear();
		Thread.sleep(2000);
		emailbox.sendKeys("admin123@gmail.com");
		//printing value attribute value
		System.out.println("Results from getAttribute method: " + emailbox.getAttribute("value"));
		//printing visible text
		System.out.println("Results from getText method: " + emailbox.getText());
		
		WebElement label = driver.findElement(By.cssSelector("label[for='Email']"));
		//printing visible text
		System.out.println("Results from getText method: " + label.getText());
		
		//Locating login button
		WebElement login = driver.findElement(By.cssSelector("button[type='submit']"));
		//printing value attribute value
		System.out.println("Results from getAttribute method: " + login.getAttribute("type"));
		//printing value attribute value
		System.out.println("Results from getAttribute method: " + login.getAttribute("class"));
		//printing visible text
		System.out.println("Results from getText method: " + login.getText());
		
		WebElement title = driver.findElement(By.xpath("//div[@class='page-title']/h1"));
		System.out.println(title.getText());
		
		Thread.sleep(2000);
		driver.close();
	}

}
