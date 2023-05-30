package rahulShettyAcademy.pageObjects;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import rahulShettyAcademy.abstractComponents.AbstractComponent;

public class CartCheckOutPage extends AbstractComponent{
	
	WebDriver driver;
	
	public CartCheckOutPage(WebDriver driver) {
		//initializing in constructor with received driver and "this" pageObject
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//-------------------------------Start of defining WebElements---------------------------------
	@FindBy(css="div.cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(css="div.subtotal button")
	WebElement checkoutButton;
	
	//-------------------------------End of defining WebElements------------------------------------

	
	//-------------------------------Start of defining PageActions------------------------------------
	
	public Boolean validateProductIsAddedToOrder(String productName) {
		Boolean flag = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName)); //returns boolean if text matches
		return flag;	
	}
	
	public OrderCheckOutPage clickOnCheckout() {
		checkoutButton.click();
		OrderCheckOutPage orderCheckoutPage = new OrderCheckOutPage(driver);
		return orderCheckoutPage;
	}
}
	