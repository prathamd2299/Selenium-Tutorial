package links;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		//Locate link by linkText locator
//		driver.findElement(By.linkText("Today's Deals")).click();
		//Locate link by partialLinkText locator
//		driver.findElement(By.partialLinkText("Deals")).click();
		
		//Capture all links
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links are: " + links.size());
		
		//Normal for loop
	/*	for(int i = 0; i <= links.size(); i++)
		{
			System.out.println(links.get(i).getText());
			System.out.println(links.get(i).getAttribute("href"));
		}
	*/
		
		//For each loop
		for(WebElement link : links)
		{
			System.out.println(link.getText());
			System.out.println(link.getAttribute("href"));
		}
		
		
		Thread.sleep(2000);
		driver.close();
	}

}
