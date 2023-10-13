package iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IframeHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		// Switch into frame 1 by using name of frame
		driver.switchTo().frame("packageListFrame");
		WebElement e = driver.findElement(By.xpath("//a[@href='org/openqa/selenium/chrome/package-frame.html']"));
		e.click();
		Thread.sleep(2000);

		// referesh the webpage
		driver.navigate().refresh();
		Thread.sleep(2000);
		// Switch to main frame
		driver.switchTo().defaultContent();
		Thread.sleep(2000);

		// Switch into frame 2 by using index
		driver.switchTo().frame(1);
		WebElement e1 = driver.findElement(By.xpath("//a[@href='org/openqa/selenium/interactions/Actions.html']"));
		e1.click();
		Thread.sleep(2000);

		// referesh the webpage
		driver.navigate().refresh();
		Thread.sleep(2000);
		// Switch to main frame
		driver.switchTo().defaultContent();
		Thread.sleep(2000);

		// Switch into frame 3 by using xpath of frame
		driver.switchTo()
				.frame(driver.findElement(By.xpath("//iframe[@title='Package, class and interface descriptions']")));
		WebElement e2 = driver.findElement(By.xpath("//a[@href='org/openqa/selenium/devtools/package-summary.html']"));
		e2.click();

		// referesh the webpage
		driver.navigate().refresh();
		Thread.sleep(2000);
		// Switch to main frame
		driver.switchTo().defaultContent();

		Thread.sleep(2000);
		driver.close();
	}

}
