package alerts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticatedPopupHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
//		driver.get("https://the-internet.herokuapp.com/basic_auth");
		
		//Syntax
		//https://admin:admin@the-internet.herokuapp.com/basic_auth
		//https://username:password@URL
		
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		Thread.sleep(2000);
		driver.close();
	}

}
