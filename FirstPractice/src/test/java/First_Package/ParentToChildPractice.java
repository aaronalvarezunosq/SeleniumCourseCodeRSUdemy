package First_Package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParentToChildPractice {

	public static void main(String[] args) throws InterruptedException {
		// 
		WebDriver driver = new ChromeDriver(); //creates object of type Webdriver using ChromeDriver constructor
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String buttonText= driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button")).getText();
		System.out.println(buttonText);
		Thread.sleep(2000);
		driver.close();
	}

}
