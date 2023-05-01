package First_Package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Section67_AlertPractice {

	public static void main(String[] args) throws InterruptedException {
		
		
		String testText = "alertText";
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(testText); //send text to alert textinput
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click(); //click on alert button
		Thread.sleep(1500);
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println("The alert message is: "+ alertMessage);
		driver.switchTo().alert().accept(); //clicks on accept button and closes alert
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		String confirmAlertText = driver.switchTo().alert().getText(); //stores the text that shows up in the confirm pop up
		Thread.sleep(1500);
		driver.switchTo().alert().dismiss(); //closes alert pop up by clicking on the negative interaction
		System.out.println("The confirm alert text is: "+ confirmAlertText);
		Thread.sleep(1500);
		driver.close();
	}

}
