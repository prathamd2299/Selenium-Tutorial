package tabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetLocationWebElement {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		WebElement logo = driver.findElement(By.xpath("//img[@alt='company-branding']"));
		// Location - method 1
		System.out.println("Location(x,y): " + logo.getLocation());
		System.out.println("Location(x): " + logo.getLocation().getX());
		System.out.println("Location(y): " + logo.getLocation().getY());

		System.out.println();

		// Location - method 2
		System.out.println("Location(x): " + logo.getRect().getX());
		System.out.println("Location(y): " + logo.getRect().getY());

		System.out.println();

		// Size - method 1
		System.out.println("Size(Width, Height): " + logo.getSize());
		System.out.println("Size(Width): " + logo.getSize().getWidth());
		System.out.println("Size(Height): " + logo.getSize().getHeight());

		System.out.println();

		// Size - method 2
		System.out.println("Size(Width): " + logo.getRect().getDimension().getWidth());
		System.out.println("Size(Height): " + logo.getRect().getDimension().getHeight());

		Thread.sleep(2000);
		driver.quit();
	}

}
