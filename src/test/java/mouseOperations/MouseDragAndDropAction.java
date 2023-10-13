package mouseOperations;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseDragAndDropAction {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)", "");

		// Source WebElements
		WebElement oslo = driver.findElement(By.id("box1"));
		WebElement stockholm = driver.findElement(By.id("box2"));
		WebElement washington = driver.findElement(By.id("box3"));
		WebElement copenhagen = driver.findElement(By.id("box4"));
		WebElement seoul = driver.findElement(By.id("box5"));
		WebElement rome = driver.findElement(By.id("box6"));
		WebElement madrid = driver.findElement(By.id("box7"));

		// Target WebElements
		WebElement norway = driver.findElement(By.id("box101"));
		WebElement sweden = driver.findElement(By.id("box102"));
		WebElement unitedStates = driver.findElement(By.id("box103"));
		WebElement denmark = driver.findElement(By.id("box104"));
		WebElement southKorea = driver.findElement(By.id("box105"));
		WebElement italy = driver.findElement(By.id("box106"));
		WebElement spain = driver.findElement(By.id("box107"));

		Thread.sleep(3000);
		// Creating Actions class object to perform mouse actions
		// and passing driver to it
		Actions action = new Actions(driver);

		// Drag and Drop Actions perform on boxes
		// Dragging Oslo and dropping in Norway
		action.dragAndDrop(oslo, norway).build().perform();
		System.out.println("1. Oslo dragged and dropped in Norway.");
		Thread.sleep(3000);

		// Dragging Stockholm and dropping in Sweden
		action.dragAndDrop(stockholm, sweden).build().perform();
		System.out.println("2. Stockholm dragged and dropped in Sweden.");
		Thread.sleep(3000);

		// Dragging Washington and dropping in United States
		action.dragAndDrop(washington, unitedStates).build().perform();
		System.out.println("3. Washington dragged and dropped in United States.");
		Thread.sleep(3000);

		// Dragging Copenhagen and dropping in Denmark
		action.dragAndDrop(copenhagen, denmark).build().perform();
		System.out.println("4. Copenhagen dragged and dropped in Denmark.");
		Thread.sleep(3000);

		// Dragging Seoul and dropping in South Korea
		action.dragAndDrop(seoul, southKorea).build().perform();
		System.out.println("5. Seoul dragged and dropped in South Korea.");
		Thread.sleep(3000);

		// Dragging Rome and dropping in Italy
		action.dragAndDrop(rome, italy).build().perform();
		System.out.println("6. Rome dragged and dropped in Italy.");
		Thread.sleep(3000);

		// Dragging Madrid and dropping in Spain
		action.dragAndDrop(madrid, spain).build().perform();
		System.out.println("7. Madrid dragged and dropped in Spain.");
		Thread.sleep(3000);

		Thread.sleep(3000);
		driver.quit();
	}

}
