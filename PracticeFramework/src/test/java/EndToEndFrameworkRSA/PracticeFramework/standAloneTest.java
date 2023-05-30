package EndToEndFrameworkRSA.PracticeFramework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

//test information: AaronFirst,AaronSecond,aarontestrsa@rsa.com,phone:1234567890 ,Static123456!


public class standAloneTest {

	public static void main(String[] args) throws InterruptedException {
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			String productToAdd = "zara coat 3";
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://rahulshettyacademy.com/client");
			
			// begin login process
			driver.findElement(By.id("userEmail")).sendKeys("aarontestrsa@rsa.com");
			driver.findElement(By.id("userPassword")).sendKeys("Static123456!");
			driver.findElement(By.id("login")).click();
			//end of login process
			
			//Start of Catalog page
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".card button.w-10")));
			
			List<WebElement> products = driver.findElements(By.cssSelector(".card"));
			
			WebElement selection = products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productToAdd)).findFirst().orElse(null);
			
			selection.findElement(By.cssSelector("button.w-10")).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container"))); //wait for green popup
			
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating")))); //wait for loading to disappear
			
			driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
			//Exits Catalog page by clicking on cart button
			
			//Start of Cart page logic
			List<WebElement> cartProducts = driver.findElements(By.cssSelector("div.cartSection h3"));
			
			Boolean flag = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productToAdd)); //returns boolean if text matches
			Assert.assertTrue(flag);
			System.out.println("Items identified in cart, proceeding to checkout page");
			driver.findElement(By.cssSelector("div.subtotal button")).click();
			//End of cart page logic
			
			//start of checkoutpage logic
			driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("Unit");
			List<WebElement> countries = driver.findElements(By.xpath("//section/button/span"));
			WebElement selectedCountry = countries.stream().filter(country->country.getText().equalsIgnoreCase("United Kingdom")).findFirst().orElse(null);
			selectedCountry.click(); //clicks on the dropdown list result that matches the country.
			driver.findElement(By.cssSelector("div.actions a.ng-star-inserted")).click(); //clicks on placeorder button.
			
			//End of checkoutpage logic
			
			List<WebElement> orderNumbers = driver.findElements(By.cssSelector("tr[class='ng-star-inserted'] label"));
			orderNumbers.stream().forEach(number->System.out.println("Order ID retrieved is : "+number.getText()));
			
			Thread.sleep(2000);
			driver.quit();
			
	}

}
