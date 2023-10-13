package fileUpload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadUsingSendKeys {

	public static void main(String[] args) throws InterruptedException {
		//Launch chrome browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//Open Url
		driver.get("https://demoqa.com/upload-download");
		Thread.sleep(3000);
		
		//Locating choose file web element
		//We only use sendKeys method if there is attribute type="file" 
		driver.findElement(By.xpath("//input[@id='uploadFile']")).sendKeys("C:\\Users\\Lenovo\\Downloads\\QA_Engineer_Prathamesh_Dhasade.pdf");

		//Close browser
		Thread.sleep(2000);
		driver.quit();
	}

}
