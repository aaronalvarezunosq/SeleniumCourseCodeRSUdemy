package section13;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Lesson105_exploringChromeOptionsProxyAndDownloads {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		Proxy proxy = new Proxy(); //to set up a proxy it has to be created with the Proxy class
		proxy.setHttpProxy("ipaddress:4444"); //this proxy then needs to be configured with the correct proxy type
		options.setCapability("proxy", proxy); //pass the proxy to driver using this method
		
		//-----The following is an example configuration for configuring where to download files------//
		Map<String, Object> prefs = new HashMap<String, Object>();

		prefs.put("download.default_directory", "/directory/path");
		options.setExperimentalOption("prefs", prefs);
		//--------end of example downloads configuration-------
		
		options.setAcceptInsecureCerts(true);

		System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/chromedriver");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		}
}


