package section14_JavaStreams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class lesson118_usingStreamsWithPagination {

	public static void main(String[] args) throws InterruptedException {
	
	WebDriver driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

	// click on column
	driver.findElement(By.xpath("//tr/th[1]")).click();

	// capture all webelements into list
	List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));

	// capture text of all webelements into new(original) list

	List<String> originalList = elementsList.stream().map(s ->s.getText()).collect(Collectors.toList());
	
	// sort on the original list of step 3 -> sorted list
	
	List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
	// compare original list vs sorted list
	Assert.assertTrue(originalList.equals(sortedList));

	List<String> price;
	String vegToSearch = "Rice";
	// scan the name column with getText ->Beans->print the price of the Rice
	do{
	Thread.sleep(1500); //small wait to see page change
	List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
	price = rows.stream().filter(s ->s.getText().contains(vegToSearch)).map(s -> getPriceVeggie(s)).collect(Collectors.toList());
	price.forEach(a -> System.out.println("The price of "+vegToSearch+" in the table is: "+a));

	if(price.size()<1){
	driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		}
	}while(price.size()<1);
	System.out.println("Reached end of test");
	driver.quit();
}



	private static String getPriceVeggie(WebElement s) {
	String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
	return pricevalue;

	}
}