package rahulShettyAcademy.abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulShettyAcademy.pageObjects.CartCheckOutPage;
import rahulShettyAcademy.pageObjects.OrderHistoryPage;

public class AbstractComponent {
	
	WebDriver driver;
	
	
	public AbstractComponent(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//----Defining Locators for WebElements-----

	@FindBy(css="button[routerlink*='cart']")
	WebElement cartButton;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement ordersHeader;
	
	
	//End of Locators section
	
	//Start of page actions


	public void waitForElementToAppear(By findBy) {
	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(findBy));
	}
	
	public void waitForWebElementToDisappear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(element)); //wait for loading to disappear
	}
	
	public void waitForWebElementToAppear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element)); //wait for loading to disappear
	}
	

	//Click on cart button function is defined here because the header section is common to all pages.
	public CartCheckOutPage clickOnCartButton() {
		cartButton.click();
		CartCheckOutPage cartCheckoutPage = new CartCheckOutPage(driver);
		return cartCheckoutPage;
	}

	public OrderHistoryPage clickOnOrderHistory() {
		ordersHeader.click();;
		OrderHistoryPage orderHistoryPage = new OrderHistoryPage(driver);
		return orderHistoryPage;
	}
}
