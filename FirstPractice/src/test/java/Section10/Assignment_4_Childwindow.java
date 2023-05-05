package Section10;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_4_Childwindow {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[@href='/windows']")).click(); //opens new tab
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='/windows/new']")).click(); //clicks link that opens new tab

		Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId] obtains the tab Handle Names as strings

		Iterator<String> it = windows.iterator(); //creates an iterator object with the window handles as strings

		String parentId = it.next(); //store each tab handle in one variable, starting with original tab

		String childId = it.next(); //store second tab handler in variable
		
		driver.switchTo().window(childId);
		String childText = driver.findElement(By.xpath("//h3")).getText();
		System.out.println("The text obtained in child window is: "+ childText);
		
		Thread.sleep(1500);
		driver.switchTo().window(parentId);
		String parentText = driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
		System.out.print("The text obtained from the parent window is: "+ parentText);
		Thread.sleep(1500);
		driver.quit();
	}

}
