package section13;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

public class Lesson108_manageMethodandScreenshots {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("String to send before Screenshot");
		
		driver.manage().window().maximize(); //method to maximize browser window
		driver.manage().deleteAllCookies(); //method to delete cookies is part of manage class
		
		File source= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //casts driver into TakesScreenshot object and takes screenshot
		FileUtils.copyFile(source,new File("C:\\Users\\aaron.alvarez\\Desktop\\SeleniumScreenshotTest.png"));//stores screenshot file in local dir
		
		driver.quit();
	}

}
