package section12;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) throws InterruptedException {

		
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver; //se hace un parse al driver para pasarlo a tipo js
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		js.executeScript("window.scroll(0,480)"); //this will scroll so that the table is in view, just in case
		int tableRows = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr")).size();
		int tableColumns = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr[1]/th")).size();
		
		List<WebElement> secondRow = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr[3]/td"));
		
		System.out.println("The number of Rows in the table is: "+ tableRows);
		System.out.println("The number of columns in the table is: "+ tableColumns);
		
		for(int i=0;i<secondRow.size();i++) {
			
			String columnText= secondRow.get(i).getText();
			System.out.println("The text in column "+i+"of row 2 is: "+columnText);
		}
		Thread.sleep(1500);
		driver.quit();
	}
}
