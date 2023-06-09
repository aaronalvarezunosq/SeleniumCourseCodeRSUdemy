package First_Package;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;


public class section63_SecondHomework {

	public static void main(String[] args) throws InterruptedException {

				WebDriver driver =new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
				driver.get("http://rahulshettyacademy.com/angularpractice/");
				
				//sending keys to input fields
				driver.findElement(By.xpath("//input[@name='name']")).sendKeys("AaronTest");
				driver.findElement(By.xpath("//input[@name='email']")).sendKeys("aarontest@gmail.com");
				driver.findElement(By.id("exampleInputPassword1")).sendKeys("testpassword");
				//done sending input text strings
				Thread.sleep(1000);

				driver.findElement(By.id("exampleCheck1")).click(); //clicks on checkbox
				
				WebElement genders = driver.findElement(By.id("exampleFormControlSelect1"));
				Select genderSelect = new Select(genders);
				genderSelect.selectByVisibleText("Female"); //selects female from the dropdown list
				
				Thread.sleep(1000);

				
				driver.findElement(By.xpath("//input[@id='inlineRadio1']")).click(); //clicks on student radiobutton
				
				driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("04252019");//sends the date to the date inputbox dd/mm/yyyy
				
				driver.findElement(By.xpath("//input[@value='Submit']")).click(); //clicks on the submit button.
				
				Thread.sleep(1000);

				String alert = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
				System.out.println("The alert message is: "+ alert);
				
				Thread.sleep(2000);
				driver.close();
			}

		
}
