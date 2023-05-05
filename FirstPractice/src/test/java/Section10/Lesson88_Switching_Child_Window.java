package Section10;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lesson88_Switching_Child_Window {

	public static void main(String[] args) throws InterruptedException {

	WebDriver driver = new ChromeDriver();

	driver.get("https://rahulshettyacademy.com/loginpagePractise/#");

	driver.findElement(By.cssSelector(".blinkingText")).click(); //opens new tab
	
	Thread.sleep(2000);

	Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId] obtains the tab Handle Names as strings

	Iterator<String> it = windows.iterator(); //creates an iterator object with the window handles as strings

	String parentId = it.next(); //store each tab handle in one variable, starting with original tab

	String childId = it.next(); //store second tab handler in variable

	driver.switchTo().window(childId); //switch to second tab

	System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText()); //extract text that includes email

	driver.findElement(By.cssSelector(".im-para.red")).getText();

	String emailId= driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];

	driver.switchTo().window(parentId); //switch back to first tab
	Thread.sleep(2000);

	driver.findElement(By.id("username")).sendKeys(emailId);
	
	Thread.sleep(2000);
	driver.quit();
	}
}
