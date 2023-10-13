package alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");
		Thread.sleep(2000);

		// Alert window with OK button
		driver.findElement(By.xpath("//input[@id='alertexamples']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept(); // close alert by using OK button

		Thread.sleep(3000);

		// Alert window with OK and Cancel buttons
		WebElement confirm_alert = driver.findElement(By.xpath("//input[@id='confirmexample']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", confirm_alert);
		confirm_alert.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept(); // close alert by using OK button
		System.out.println(driver.findElement(By.xpath("//p[@id='confirmreturn']")).getText());
		System.out.println(driver.findElement(By.xpath("//p[@id='confirmexplanation']")).getText());
		Thread.sleep(2000);
		confirm_alert.click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss(); // close alert by using Cancel button
		System.out.println(driver.findElement(By.xpath("//p[@id='confirmreturn']")).getText());
		System.out.println(driver.findElement(By.xpath("//p[@id='confirmexplanation']")).getText());

		Thread.sleep(3000);

		// Alert window with input box, capture text from alert
		WebElement prompt_alert = driver.findElement(By.xpath("//input[@id='promptexample']"));
		js.executeScript("arguments[0].scrollIntoView();", prompt_alert);
		prompt_alert.click();
		Thread.sleep(2000);
		Alert alertWin = driver.switchTo().alert();
		System.out.println("The message displayed on alert: " + alertWin.getText());
		alertWin.sendKeys("Welcome");
		alertWin.accept();
		System.out.println(driver.findElement(By.xpath("//p[@id='promptreturn']")).getText());
		System.out.println(driver.findElement(By.xpath("//p[@id='promptexplanation']")).getText());

		Thread.sleep(2000);
		driver.quit();
	}

}
