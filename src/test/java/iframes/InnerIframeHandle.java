package iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InnerIframeHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Frames.html");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();
		
		WebElement outer_frame = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		driver.switchTo().frame(outer_frame);
		
		WebElement inner_frame = driver.findElement(By.cssSelector("iframe[src='SingleFrame.html']"));
		driver.switchTo().frame(inner_frame);
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Welcome");
		
		Thread.sleep(2000);
		driver.close();
	}

}
