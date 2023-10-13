package dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandleWithoutUsingMethods {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement countryEl = driver.findElement(By.xpath("//*[@id=\"post-2646\"]/div[2]/div/div/div/p/select"));
		countryEl.click();
		Thread.sleep(2000);
		Select country = new Select(countryEl);
		
		List<WebElement> allOptions = country.getOptions();
		
		for(WebElement option  : allOptions)
		{
			if(option.getText().equalsIgnoreCase("icELand"))
			{
				Thread.sleep(2000);
				option.click();
				System.out.println(option.getText());
				break;
			}
		}
		
		Thread.sleep(2000);
		driver.close();
	}

}
