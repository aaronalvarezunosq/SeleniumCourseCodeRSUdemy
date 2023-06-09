package First_Package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class section61_FirstHomework {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement firstCheckbox = driver.findElement(By.id("checkBoxOption1")); //store first Checkbox in WebElement to work more easily.
		firstCheckbox.click(); //click on first checkbox - checkbox gets selected
		Assert.assertTrue(firstCheckbox.isSelected()); //Assert checkbox is successfully selected
		Thread.sleep(1000); //small wait to see checkbox selected
		firstCheckbox.click(); //click on first checkbox - no longer selected.
		Assert.assertFalse(firstCheckbox.isSelected()); //Assert checkbox is not selected
		
		int count = driver.findElements(By.xpath("//fieldset //input[@type='checkbox']")).size();
		System.out.println("The number of checkboxes present on the page is: " + count);
		Thread.sleep(2000);
		driver.close();
	}

}
