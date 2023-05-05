package Section10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Lesson85_Actions {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		Actions actions = new Actions(driver);
		driver.get("https://www.amazon.com/");
		WebElement hoverMenu = driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
		
		actions.moveToElement(hoverMenu).build().perform();
		
		Thread.sleep(3000);
		driver.quit();
		

	}

}
