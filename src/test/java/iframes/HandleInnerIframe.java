package iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleInnerIframe {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
		Thread.sleep(2000);
		
		driver.switchTo().frame("iframeResult"); //outer iframe
		driver.switchTo().frame(0); //inner iframe
		
		System.out.println("Text inside the inner frame is: " + driver.findElement(By.xpath("//h1")).getText());
		
		driver.switchTo().parentFrame(); //switch to outer frame i.e. parent frame
		
		String text = driver.findElement(By.xpath("//p[contains(text(),'You can use the height and width attributes to spe')]")).getText();
		System.out.println("Text present in outer iframe is: " + text);
		
		Thread.sleep(2000);
		driver.close();
	}

}
