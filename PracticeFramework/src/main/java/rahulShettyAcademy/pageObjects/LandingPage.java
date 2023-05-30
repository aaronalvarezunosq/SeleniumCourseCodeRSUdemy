package rahulShettyAcademy.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulShettyAcademy.abstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		//initializing in constructor with received driver and "this" pageObject
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//----------------Defining Webelements for PageFactory--------------
	@FindBy(id="userEmail")
	WebElement userEmail;
	

	@FindBy(id="userPassword")
	WebElement userPassword;
	

	@FindBy(id="login")
	WebElement submitButton;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement loginError;
	
	
	//--------------End of WebElements-----------
	
	//--------------Start of action functions -----------------
	
	public ProductCatalog loginWebsite(String username, String password) {
		userEmail.sendKeys(username);
		userPassword.sendKeys(password);
		submitButton.click();
		ProductCatalog productCatalog = new ProductCatalog(driver);
		return productCatalog;
	}
	
	public String getLoginError() {
		waitForWebElementToAppear(loginError);
		return loginError.getText();
	}
	
	public void navigateTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
}
