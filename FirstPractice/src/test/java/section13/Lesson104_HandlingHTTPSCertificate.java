package section13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions; //this class is to configure chromedriver behavior


public class Lesson104_HandlingHTTPSCertificate {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true); //set to accept insecure certs by default on some pages
		
		WebDriver driver = new ChromeDriver(options); //passes the preconfigured options object to the driver constructor
		driver.get("https://expired.badssl.com");
		System.out.println(driver.getTitle()); //now this will be able to print the title of the insecure cert page
		Thread.sleep(1500);
		driver.quit();
	}

}
