package fileUpload;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadUsingRobotClass {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// Launch chrome browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Open Url
		driver.get("https://demoqa.com/upload-download");
		Thread.sleep(3000);

		// Locating choose file web element
		// We only use sendKeys method if there is attribute type="file"
		WebElement choose_file = driver.findElement(By.xpath("//input[@id='uploadFile']"));

		// Action class for operation
		Actions action = new Actions(driver);
		action.moveToElement(choose_file).click().perform();

		// Robot class for upload
		Robot rbt = new Robot();
		rbt.delay(1000);

		// Copy File to Clipboard
		StringSelection ss = new StringSelection("C:\\Users\\Lenovo\\Downloads\\6_Months_Experience_QA_Prathamesh_Dhasade.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// Paste file operation perform by ctrl + v
		rbt.keyPress(KeyEvent.VK_CONTROL);
		rbt.keyPress(KeyEvent.VK_V);

		rbt.keyRelease(KeyEvent.VK_CONTROL);
		rbt.keyRelease(KeyEvent.VK_V);
		
		rbt.keyPress(KeyEvent.VK_ENTER);
		rbt.keyRelease(KeyEvent.VK_ENTER);

		// Close browser
		Thread.sleep(2000);
		driver.quit();

	}

}
