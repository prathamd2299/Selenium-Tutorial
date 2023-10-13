package dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandleUsingMethods {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");

		driver.manage().window().maximize();
		Thread.sleep(2000);

		WebElement countryEl = driver.findElement(By.xpath("//*[@id=\"post-2646\"]/div[2]/div/div/div/p/select"));
		countryEl.click();
		Thread.sleep(3000);
		Select country = new Select(countryEl);
		country.selectByVisibleText("Honduras");
		System.out.println("Selected option is: " + country.getFirstSelectedOption().getText());
		countryEl.click();
		Thread.sleep(3000);
		countryEl.click();
		country.selectByValue("AGO");
		System.out.println("Selected option is: " + country.getFirstSelectedOption().getText());
		countryEl.click();
		Thread.sleep(3000);
		countryEl.click();
		country.selectByIndex(12);
		System.out.println("Selected option is: " + country.getFirstSelectedOption().getText());
		countryEl.click();

		Thread.sleep(2000);
		driver.close();
	}

}
