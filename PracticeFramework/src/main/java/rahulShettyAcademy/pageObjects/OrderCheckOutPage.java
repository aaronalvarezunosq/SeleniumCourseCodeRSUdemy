package rahulShettyAcademy.pageObjects;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import rahulShettyAcademy.abstractComponents.AbstractComponent;

public class OrderCheckOutPage extends AbstractComponent{
	
	WebDriver driver;
	
	public OrderCheckOutPage(WebDriver driver) {
		//initializing in constructor with received driver and "this" pageObject
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//-------------------------------Start of defining WebElements---------------------------------
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement countryField;

	@FindBy(xpath="//section/button/span")
	List<WebElement> countriesList;
	
	@FindBy(css="div.actions a.ng-star-inserted")
	WebElement orderButton;
	
	//-------------------------------End of defining WebElements------------------------------------
	
	
	
	
	//-------------------------------Start of defining By Locators------------------------------------
	
	//-------------------------------End of defining By Locators------------------------------------
	
	
	//-------------------------------Start of defining PageActions------------------------------------
	
	public void inputCountryText(String country) {
		countryField.sendKeys(country);
	}
	
	public void clickOnWantedCountry(String country) {
		WebElement selectedCountry = countriesList.stream().filter(option->option.getText().equalsIgnoreCase(country)).findFirst().orElse(null);
		selectedCountry.click(); //clicks on the dropdown list result that matches the country.
	}
	
	public OrderSummaryPage clickPlaceOrderButton() {
		orderButton.click();
		return new OrderSummaryPage(driver);
	}
}
	