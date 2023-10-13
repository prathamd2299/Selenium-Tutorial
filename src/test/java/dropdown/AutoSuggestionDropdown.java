package dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestionDropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.twoplugs.com/"); //Launching the browser
		driver.manage().window().maximize(); //maximize the window
		Thread.sleep(2000); //sleep for 2 seconds
		
		//Locating Live Posting link 
		WebElement link = driver.findElement(By.xpath("//a[text()='Live Posting']"));
		link.click(); //clicking on Live Posting link
		
		//Locating searchbox
		WebElement searchbox = driver.findElement(By.xpath("//input[@placeholder='Toronto,ON,Canada']"));
		Thread.sleep(2000); //sleep for 2 seconds
		searchbox.clear(); //clear existed value
		Thread.sleep(2000); //sleep for 2 seconds
		searchbox.sendKeys("Tor"); //passing new value
		String txt;
		
		do
		{
			searchbox.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(2000); //sleep for 2 seconds
			txt = searchbox.getAttribute("value");
			if(txt.equals("Torremolinos, Spain"))
			{
				Thread.sleep(2000); //sleep for 2 seconds
				searchbox.sendKeys(Keys.ENTER);
				System.out.println(txt);
				break;
			}
			Thread.sleep(2000); //sleep for 2 seconds
		}while(!txt.isEmpty());
		
		Thread.sleep(2000);
		driver.close();

	}

}
