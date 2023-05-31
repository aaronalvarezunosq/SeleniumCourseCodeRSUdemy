package section15_relativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*; //relative locators static package must be included manually


public class Lesson124_relativeLocators {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		//WebElement nameEditBox =driver.findElement(By.cssSelector("[name='name']"));
		int testCount =driver.findElements(By.cssSelector("[name='badlocator']")).size();
		System.out.println("findElements size is: "+ testCount);
		
		/*
		String nameLabelText=driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText();
		System.out.println("The text above the nameEditBox is: "+nameLabelText);

		WebElement dateofBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dateofBirth)).click();

		WebElement iceCreamLabel =driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']")); //pivot webElement
		driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();

		WebElement rdb = driver.findElement(By.id("inlineRadio1")); //pivot webElement
		String rightLabelText = driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText(); 
		System.out.println("The label obtained from 'ToRightOf' Locator is: " + rightLabelText);
		*/
		Thread.sleep(2000);
		driver.quit();

	}
}