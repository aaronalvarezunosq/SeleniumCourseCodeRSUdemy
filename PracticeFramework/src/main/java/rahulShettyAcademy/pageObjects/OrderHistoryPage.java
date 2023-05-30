package rahulShettyAcademy.pageObjects;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import rahulShettyAcademy.abstractComponents.AbstractComponent;

public class OrderHistoryPage extends AbstractComponent{
	
	WebDriver driver;
	
	public OrderHistoryPage(WebDriver driver) {
		//initializing in constructor with received driver and "this" pageObject
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//-------------------------------Start of defining WebElements---------------------------------
	@FindBy(css="tr[class*='ng-star'] td:nth-child(3)")
	List<WebElement> historyOrdersItemList;
	
	
	//-------------------------------End of defining WebElements------------------------------------

	
	//-------------------------------Start of defining PageActions------------------------------------
	
	public Boolean validateProductInOrderHistory(String productName) {
		Boolean flag = historyOrdersItemList.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName)); //returns boolean if text matches
		return flag;	
	}
	
}
	