package tabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenUrlInTwoWindows {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://bstackdemo.com/");
		Thread.sleep(2000);
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://demo.opencart.com/");
		Thread.sleep(2000);
		driver.quit();

	}

}
