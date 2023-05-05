package Section10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Lesson91_Frames_Draganddrop {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		Actions action = new Actions(driver);
		
		
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.className("demo-frame"))); //switches to frame by using the WebElement
		WebElement draggable = driver.findElement(By.id("draggable")); //obtains the WebElement to drag
		WebElement droppable = driver.findElement(By.id("droppable")); //obtains the WebElement location to drop
		action.dragAndDrop(draggable, droppable).build().perform(); //performs the action of dragging element to target location
		Thread.sleep(2000);
		driver.switchTo().defaultContent(); //exits the frame and returns to normal page operation
		System.out.println("Driver has now exited frame");
		Thread.sleep(2000);
		driver.quit();
		
	}

}
