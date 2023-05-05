package Section10;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5_NestedFrames {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[@href='/nested_frames']")).click();
		
		driver.switchTo().frame(driver.findElement(By.name("frame-top")));
		System.out.println("Switched to top frame");
		driver.switchTo().frame(driver.findElement(By.name("frame-middle")));
		System.out.println("Switched to top frame - Middle frame");
		String frameText = driver.findElement(By.xpath("//div[@id='content']")).getText(); //extracts text from middle frame?
		System.out.print("The text obtained from middle frame is: "+ frameText);
		Thread.sleep(2000);
		driver.quit();
	}

}
