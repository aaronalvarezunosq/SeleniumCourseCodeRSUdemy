package rahulShettyAcademy.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulShettyAcademy.abstractComponents.AbstractComponent;

public class ProductCatalog extends AbstractComponent{
	
	WebDriver driver;
	
	public ProductCatalog(WebDriver driver) {
		//initializing in constructor with received driver and "this" pageObject
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//-------------------------------Start of defining WebElements---------------------------------
	@FindBy(css=".card")
	List<WebElement> productsObject;
	
	@FindBy(css=".ng-animating")
	WebElement greenPopUp;

	
	
	
	//-------------------------------End of defining WebElements------------------------------------
	
	
	//-------------------------------Start of defining By Locators------------------------------------
	By productsBy = By.cssSelector(".card button.w-10"); //Locator to use for wait method
	By addToCartBy = By.cssSelector("button.w-10");
	By toastLoading = By.cssSelector("#toast-container");
	//-------------------------------End of defining By Locators------------------------------------
	
	
	//-------------------------------Start of defining PageActions------------------------------------
	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		return productsObject;
	}
	
	public WebElement getProductByName(String productName) {
		WebElement selection = getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		return selection;
		
	}
	
	public void addProductToCart(String productName) {
		WebElement selection = getProductByName(productName);
		selection.findElement(addToCartBy).click();
		waitForElementToAppear(toastLoading);
		waitForWebElementToDisappear(greenPopUp);

	}
	
	
}
	