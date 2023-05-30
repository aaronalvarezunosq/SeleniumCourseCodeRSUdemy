package EndToEndFrameworkRSA.PracticeFramework;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import EndToEndFrameworkRSA.testComponents.BaseTest;
import rahulShettyAcademy.pageObjects.CartCheckOutPage;
import rahulShettyAcademy.pageObjects.ProductCatalog;

//test information: AaronFirst,AaronSecond,aarontestrsa@rsa.com,phone:1234567890 ,Static123456!


public class errorValidationsTest extends BaseTest{
	
	@Test(groups= {"ErrorHandling"})
	 public void loginErrorValidation() throws InterruptedException, IOException {
				
			// begin login process
			landingPage.loginWebsite("aarontestrsa@rsa.com", "WrongPassword!");
			String errorMessage= landingPage.getLoginError();
			Assert.assertEquals("Incorrect email or password.", errorMessage);
			System.out.println("Login Error Message Assertion Passed");
			Thread.sleep(2000);
	}
	
	@Test
	public void cartItemErrorValidation() {

		String productToAdd = "zara coat 3";
			
		// begin login process
		ProductCatalog productCatalog = landingPage.loginWebsite("aarontestrsa@rsa.com", "Static123456!");
		
		//end of login process
		
		//Start of Catalog page
		productCatalog.addProductToCart(productToAdd);
		CartCheckOutPage cartCheckoutPage = productCatalog.clickOnCartButton();
		//Exits Catalog page by clicking on cart button
		
		//Start of Cart page logic
		Boolean match = cartCheckoutPage.validateProductIsAddedToOrder("zara coat 42");
		Assert.assertFalse(match,"Incorrect item detected in cart");
		System.out.println("Cart functionality works as expected for incorrect items");
		//End of cart page logic
	}

}
