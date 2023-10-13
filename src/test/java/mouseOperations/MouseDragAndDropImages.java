package mouseOperations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseDragAndDropImages {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		Thread.sleep(3000);

		// Switching in frame which have class of "demo-frame lazyload"
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));

		WebElement highTatras = driver.findElement(By.xpath("//li[1]"));
		WebElement highTatras2 = driver.findElement(By.xpath("//li[2]"));
		WebElement highTatras3 = driver.findElement(By.xpath("//li[3]"));
		WebElement highTatras4 = driver.findElement(By.xpath("//li[4]"));

		WebElement trash = driver.findElement(By.xpath("//div[@id='trash']"));

		Thread.sleep(3000);
		// Creating Actions class object to perform mouse actions
		// and passing driver to it
		Actions action = new Actions(driver);

		// Drag and Drop Actions perform on boxes
		// Dragging High Tatras and dropping in Trash
		action.dragAndDrop(highTatras, trash).build().perform();
		System.out.println("1. High Tatras dragged and dropped in Trash.");
		Thread.sleep(3000);

		// Dragging High Tatras2 and dropping in Trash
		action.dragAndDrop(highTatras2, trash).build().perform();
		System.out.println("1. High Tatras2 dragged and dropped in Trash.");
		Thread.sleep(3000);

		// Dragging High Tatras3 and dropping in Trash
		action.dragAndDrop(highTatras3, trash).build().perform();
		System.out.println("1. High Tatras3 dragged and dropped in Trash.");
		Thread.sleep(3000);

		// Dragging High Tatras4 and dropping in Trash
		action.dragAndDrop(highTatras4, trash).build().perform();
		System.out.println("1. High Tatras4 dragged and dropped in Trash.");
		Thread.sleep(3000);

		Thread.sleep(2000);
		driver.quit();
	}

}
