package EndToEndFrameworkRSA.testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulShettyAcademy.pageObjects.LandingPage;

public class BaseTest {
		public WebDriver driver;
		public LandingPage landingPage;
		
	public WebDriver initializeDriver() throws IOException{
		
		//properties class setup
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\rahulShettyAcademy\\resources\\GlobalProperties.properties");
		properties.load(fis);
		String browserName = properties.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			}
		else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	

	public List<HashMap<String,String>> getJsonDataToMap(String pathFile) throws IOException {
		
		//read json file to String
		String jsonContent = FileUtils.readFileToString(new File(pathFile),StandardCharsets.UTF_8);
		
		//String to HashMap jackson Databind
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){			
		});
		return data;
	}
	
	
	@BeforeMethod(alwaysRun=true)
		public LandingPage launchApplication() throws IOException {
		driver = initializeDriver();
		landingPage= new LandingPage(driver);
		landingPage.navigateTo();
		return landingPage;
	}
	
	@AfterMethod(alwaysRun=true)
	public void teardown() {
		driver.quit();
	}
}