package links;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksHandle {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.deadlinkcity.com/");
		Thread.sleep(3000);

		// Capture all links
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links are: " + links.size());
		
		int brokenLinks = 0;

		// For each loop
		for (WebElement element : links) {
			String url = element.getAttribute("href");
			
			if(url == null || url.isEmpty())
			{
				System.out.println("Url is empty");
				continue;
			}
			
			URL link = new URL(url);
			
			try
			{
				HttpURLConnection httpconn = (HttpURLConnection) link.openConnection();
				httpconn.connect();
				
				if(httpconn.getResponseCode() >= 400)
				{
					System.out.println(httpconn.getResponseCode() + " is broken");
					brokenLinks++;
				}
				else
				{
					System.out.println(httpconn.getResponseCode() + " is valid link");
				}
			}
			catch(Exception e)
			{
				System.out.println("vhjhj");
			}
		
		}

		Thread.sleep(2000);
		System.out.println("No. of broken links are: " + brokenLinks);
		driver.quit();
	}

}
