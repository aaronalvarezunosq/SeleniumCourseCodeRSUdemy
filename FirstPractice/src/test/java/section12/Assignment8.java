package section12;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Assignment8 {

	public static void main(String[] args) throws InterruptedException {
		
		String desiredCountry = "United Arab Emirates";
		WebDriver driver = new ChromeDriver();
		Actions actions = new Actions(driver); //create new actions object		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/"); //open practice site
		
		WebElement autocompleteField = driver.findElement(By.xpath("//input[@id='autocomplete']"));
		autocompleteField.sendKeys("uni"); //Enter first three letters of " United Arab Emirates"
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='ui-id-1']/li[1]"))); //waits until suggestions appear (can take a bit)
		
		//autocomplete dropdown should appear now
		List<WebElement> dropdownResults = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li/div")); //stores suggestions and we can access text
		
		for(int i=0; i<dropdownResults.size();i++) {
			System.out.println("Country being validated currently is: " + dropdownResults.get(i).getText());
			if(dropdownResults.get(i).getText().contains(desiredCountry)) {
				i+=1; //adjust the value of i to select the correct child WebElement since these start from index=1
				actions.moveToElement(driver.findElement(By.xpath("//ul[@id='ui-id-1']/li["+i+"]"))).click().build().perform();
				break; //exit for loop
			}
			Thread.sleep(1500);//small wait between each loop
		}
		
		Assert.assertEquals(autocompleteField.getAttribute("value"), desiredCountry);//Verify that the autocompletefield has the desired Country.
		System.out.println("reached end of test");
		driver.quit();
	}

}
