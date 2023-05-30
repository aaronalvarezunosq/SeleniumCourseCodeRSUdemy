package EndToEndFrameworkRSA.PracticeFramework;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import EndToEndFrameworkRSA.testComponents.BaseTest;


import rahulShettyAcademy.pageObjects.CartCheckOutPage;

import rahulShettyAcademy.pageObjects.OrderCheckOutPage;
import rahulShettyAcademy.pageObjects.OrderHistoryPage;
import rahulShettyAcademy.pageObjects.OrderSummaryPage;
import rahulShettyAcademy.pageObjects.ProductCatalog;

//test information: AaronFirst,AaronSecond,aarontestrsa@rsa.com,phone:1234567890 ,Static123456!


public class standAloneTestPageObject extends BaseTest{
	String productToAdd = "zara coat 3";	
	@Test(groups= {"PlaceOrderFlow"},dataProvider="getData")
	 public void getOrderNumbers(HashMap<String,String> input) throws InterruptedException, IOException {			
			// begin login process
			ProductCatalog productCatalog = landingPage.loginWebsite(input.get("email"), input.get("password"));			
			//end of login process
			
			//Start of Catalog page
			productCatalog.addProductToCart(input.get("productToAdd"));
			CartCheckOutPage cartCheckoutPage = productCatalog.clickOnCartButton();
			//Exits Catalog page by clicking on cart button
			
			//Start of Cart page logic
			Boolean match = cartCheckoutPage.validateProductIsAddedToOrder(input.get("productToAdd"));
			Assert.assertTrue(match);
			System.out.println("Items identified in cart, proceeding to checkout page");
			OrderCheckOutPage orderCheckoutPage = cartCheckoutPage.clickOnCheckout();
			//End of cart page logic
			
			//start of checkoutpage logic
			orderCheckoutPage.inputCountryText("unit");
			orderCheckoutPage.clickOnWantedCountry("United Kingdom");
			OrderSummaryPage orderSummaryPage = orderCheckoutPage.clickPlaceOrderButton();
			
			//End of checkoutpage logic			
			orderSummaryPage.printOrderNumbers();			
			Thread.sleep(2000);
	}
	
	@Test(dependsOnMethods= {"getOrderNumbers"})
	public void orderHistoryTest() {
		//Test if order of item "zara coat 3" exists in history page
		ProductCatalog productCatalog = landingPage.loginWebsite("aarontestrsa@rsa.com", "Static123456!");
		OrderHistoryPage orderHistoryPage = productCatalog.clickOnOrderHistory();
		Boolean flag = orderHistoryPage.validateProductInOrderHistory(productToAdd);
		Assert.assertTrue(flag,"The item was not found in the order history");
		System.out.println("Assertion in Order History Passed, Item was found in orders list");
	}
	
	
	public String getScreenshot(String testCaseName) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(System.getProperty("user.dir")+"//screenshotReports"+testCaseName+".png");
		FileUtils.copyFile(source,destinationFile);
		return System.getProperty("user.dir")+"//screenshotReports"+testCaseName+".png";
	}

	@DataProvider //with hashmap implementation
	public Object[][] getData() throws IOException{
		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\EndToEndFrameworkRSA\\Data\\testData.json");
		return new Object[][] {{data.get(0)},{data.get(1)}}; //creates a new object with each data map as parameters
	}
}
	
	
	/*
	@DataProvider
	public Object[][] getData(){
		Object [][] data={{"aarontestrsa@rsa.com","Static123456!","zara coat 3"},{"aarontestrsa@rsa.com","Static123456!","ADIDAS ORIGINAL"}};
		return data;
	}*/

	/* //hardcoded Hashmap implementation
	HashMap<String,String> data1 = new HashMap<String,String>();
	data1.put("email", "aarontestrsa@rsa.com");
	data1.put("password", "Static123456!");
	data1.put("productToAdd", "zara coat 3");
	
	HashMap<String,String> data2 = new HashMap<String,String>(); //creating the new map objects
	data2.put("email", "aarontestrsa@rsa.com");
	data2.put("password", "Static123456!");
	data2.put("productToAdd", "ADIDAS ORIGINAL");*/
