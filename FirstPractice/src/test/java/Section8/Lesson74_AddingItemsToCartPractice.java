package Section8;

import java.util.Arrays;

import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

public class Lesson74_AddingItemsToCartPractice {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" };

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		Thread.sleep(3000);

		addItems(driver, itemsNeeded);

	}

	public static void addItems(WebDriver driver, String[] itemsNeeded){
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < products.size(); i++)
		{
			// Brocolli - 1 Kg
			// Brocolli, 1 kg
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim(); //Removes space after the vegetable name
			// format it to get actual vegetable name
			// convert array into array list for easy search
			// check whether name you extracted is present in arrayList or not-

			List<String> itemsNeededList = Arrays.asList(itemsNeeded);
			if (itemsNeededList.contains(formattedName))
			{
				j++;
				// click on Add to cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();//changed locator to not depend on visible text as visible text changes when element is clicked
				System.out.println("Item "+formattedName+" has been added to cart"); //print the item that was added to cart in the console
				if (j == itemsNeeded.length)
				{
					break;
				}
			}
		}
	}
}
