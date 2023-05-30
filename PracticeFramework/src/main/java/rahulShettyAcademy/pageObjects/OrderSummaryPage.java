package rahulShettyAcademy.pageObjects;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import rahulShettyAcademy.abstractComponents.AbstractComponent;

public class OrderSummaryPage extends AbstractComponent{
	
	WebDriver driver;
	
	public OrderSummaryPage(WebDriver driver) {
		//initializing in constructor with received driver and "this" pageObject
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//-------------------------------Start of defining WebElements---------------------------------
	@FindBy(css="tr[class='ng-star-inserted'] label")
	List<WebElement> orderNumbers;
	
	//-------------------------------End of defining WebElements------------------------------------
	
	
	//-------------------------------Start of defining By Locators------------------------------------
	
	//-------------------------------End of defining By Locators------------------------------------
	
	
	//-------------------------------Start of defining PageActions------------------------------------
	public void printOrderNumbers() {
		orderNumbers.stream().forEach(number->System.out.println("Order ID retrieved is : "+number.getText()));
	}
	
}
	