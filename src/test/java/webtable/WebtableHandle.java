package webtable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebtableHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");

		// 1. How many rows are there in table
		// Locating table rows element and storing in list
		List<WebElement> table = driver.findElements(By.xpath("//div[@class='tableFixHead']//tbody/tr"));
		int rows = table.size();
		System.out.println("Total no. of rows in table are: " + rows);

		// 2. How many columns are there in table
		// Locating table columns element and storing in list
		List<WebElement> table1 = driver.findElements(By.xpath("//div[@class='tableFixHead']//thead/tr/th"));
		int columns = table1.size();
		System.out.println("Total no. of columns in table are: " + columns);

		// 3. Retrieve the specific row/column data
		// Locating specific element
		WebElement el = driver.findElement(By.xpath("//div[@class='tableFixHead']//tbody/tr[2]/td[2]"));
		String value = el.getText();
		System.out.println("The value is: " + value);

		// 4. Retrieve all the data from table
		for (int r = 1; r <= rows; r++) {
			for (int c = 1; c <= columns; c++) {
				WebElement els = driver
						.findElement(By.xpath("//div[@class='tableFixHead']//tbody/tr[" + r + "]/td[" + c + "]"));
				String data = els.getText();
				System.out.print(data + " | ");
			}
			System.out.println();
		}

		System.out.println("\n");

		// 5. Print position,city,amount
		for (int r = 1; r <= rows; r++) {
			WebElement elscol = driver.findElement(By.xpath("//div[@class='tableFixHead']//tbody/tr[" + r + "]/td[1]"));
			String name = elscol.getText();

			if (name.equals("Ivory")) {
				String position = driver
						.findElement(By.xpath("//div[@class='tableFixHead']//tbody/tr[" + r + "]/td[2]")).getText();
				String city = driver.findElement(By.xpath("//div[@class='tableFixHead']//tbody/tr[" + r + "]/td[3]"))
						.getText();
				String amount = driver.findElement(By.xpath("//div[@class='tableFixHead']//tbody/tr[" + r + "]/td[4]"))
						.getText();
				System.out.println(position + " " + city + " " + amount);
			}
		}

		driver.close();
	}

}
