package First_Package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CorrectSignIn_Practice {

	public static void main(String[] args) throws InterruptedException {
		String username = "AaronUser";
		
		//Code to initialize ChromedDriver
		WebDriver driver = new ChromeDriver(); //creates object of type Webdriver using ChromeDriver constructor
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
						
		//obtain page title and url and print to console
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		//Locating and storing webelements from the page
		WebElement usernameField = driver.findElement(By.id("inputUsername"));
		WebElement passwordField = driver.findElement(By.name("inputPassword"));
		WebElement signinButton = driver.findElement(By.className("signInBtn"));
		String password = getPassword(driver);
		
		usernameField.sendKeys(username);
		passwordField.sendKeys(password); //now password is obtained dinamically
		signinButton.click();
		System.out.println("Now accessing Logged in Page");
		Thread.sleep(2000);
		String validMessage = driver.findElement(By.xpath("//p[@style='color: rgb(27, 179, 102); font-size: 18px; text-align: center;']")).getText(); //finds validation message and stores text
		Assert.assertEquals(validMessage, "You are successfully logged in.");
		System.out.println("Login message assertion passed Successfully");
		
		String greetingMessage = driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText();
		Assert.assertEquals(greetingMessage, "Hello "+username+",");
		System.out.println("Greeting assertion passed successfully");
		
		Thread.sleep(2000);
		driver.close();
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();//click on ResetLogin Button
		String recoveryMessage= driver.findElement(By.cssSelector("p.infoMsg")).getText(); //obtain the password recovery text.
		String[] passwordPart1 = recoveryMessage.split("'");
		String[] passwordPart2 = passwordPart1[1].split("'");
		String password = passwordPart2[0]; //now this string should contain the temporary password
		driver.findElement(By.className("go-to-login-btn")).click();
		Thread.sleep(2000);//going back to login page
		
		return password;
	}

}
