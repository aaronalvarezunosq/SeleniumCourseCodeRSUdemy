package First_Package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class First_Lesson {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\aaron.alvarez\\Documents\\geckodriver\\geckodriver.exe");
		System.setProperty("webdriver.edge.driver", "C:\\Users\\aaron.alvarez\\Documents\\edgedriver_win64\\msedgedriver.exe");
		//Code to initialize ChromedDriver
		WebDriver driver = new ChromeDriver(); //creates object of type Webdriver using ChromeDriver constructor
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Code to initialize FirefoxDriver
		//WebDriver driver = new FirefoxDriver();
		
		//Code to intialize EdgeDriver
		//WebDriver driver = new EdgeDriver();
		
				
		//obtain page title and url and print to console
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		//Locating and storing webelements from the page
		WebElement usernameField = driver.findElement(By.id("inputUsername"));
		WebElement passwordField = driver.findElement(By.name("inputPassword"));
		WebElement signinButton = driver.findElement(By.className("signInBtn"));
		
		
		//interacting with previously located elements
		usernameField.sendKeys("TestUsername");	//type into usernamefield
		passwordField.sendKeys("TestPassword");	//type into password field
		signinButton.click(); //click sign in button
		WebElement errorMessage = driver.findElement(By.className("error"));
		System.out.println("The error message is : " + errorMessage.getText());
		
		//locating the forgot password link
		WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot your password?"));
		forgotPasswordLink.click(); //clicking on the forgot password link
		WebElement recoveryName = driver.findElement(By.xpath("//input[@placeholder='Name']"));
		WebElement recoveryEmail = driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")); //Locates E-mail field using CssSelector and nth child notation
		WebElement recoveryPhone = driver.findElement(By.xpath("//input[@placeholder='Phone Number']"));
		Thread.sleep(1500);//wait for page transition
		
		
		recoveryName.sendKeys("AaronTest");
		recoveryEmail.sendKeys("recoveryEmail@gmail.com");
		recoveryPhone.sendKeys("55512345678");
		Thread.sleep(1500);
		
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();//click on ResetLogin Button
		String recoveryMessage= driver.findElement(By.cssSelector("p.infoMsg")).getText(); //obtain the password recovery text.
		System.out.println(recoveryMessage);
		driver.findElement(By.className("go-to-login-btn")).click();
		Thread.sleep(3000);
		
		
		//going back to original login page
		usernameField.clear();
		usernameField.sendKeys("AaronTest");
		passwordField.clear();
		passwordField.sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//input[@id='chkboxOne']")).click();
		Thread.sleep(1000);
		signinButton.click();
		//now page should correctly login
		
		Thread.sleep(2000); //wait on successful page for 2 seconds
		driver.close();
	}

}
