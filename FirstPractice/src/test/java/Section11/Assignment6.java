package Section11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) throws InterruptedException {

		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String[] identifiers = {"bmw","benz","honda"};
		int option = 2; //with this we can change the checkbox to select
		
		WebElement checkboxSelected = driver.findElement(By.xpath("//label[@for='"+ identifiers[option] +"']/input")); //build the xpath to the desired checkbox
		checkboxSelected.click();
		Thread.sleep(2000); //wait a bit after clicking on box
		
		
		String checkboxText = driver.findElement(By.xpath("//label[@for='"+ identifiers[option] +"']")).getText();
		System.out.println("Text obtained from checkbox is: " + checkboxText);
		Thread.sleep(2000); //wait after extracting text from selected option
		
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select dropdownSelect = new Select(dropdown);
		dropdownSelect.selectByVisibleText(checkboxText);
		Thread.sleep(2000); //wait after selecting option from dropdown menu
		
		driver.findElement(By.id("name")).sendKeys(checkboxText); //Enters checkbox text into alert box
		Thread.sleep(1500);//this wait is to allow the text to be seen in the field
		driver.findElement(By.id("alertbtn")).click();//clicks on alert button
		
		System.out.println("Does the alert text contain the checkbox text?: "+ driver.switchTo().alert().getText().contains(checkboxText)); 
		//prints true if the text obtained from alert includes checkboxText
		driver.switchTo().alert().accept();
		System.out.println("The alert has been accepted and closed");
		Thread.sleep(2500);
				
		driver.quit();
		
	}

}
