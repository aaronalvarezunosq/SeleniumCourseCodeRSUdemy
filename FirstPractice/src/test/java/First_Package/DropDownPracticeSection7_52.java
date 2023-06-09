package First_Package;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownPracticeSection7_52 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement adultMenu = driver.findElement(By.id("divpaxinfo"));
		System.out.println(adultMenu.getText());
		adultMenu.click();
		Thread.sleep(1500);
		//increasing adult count by 5
		WebElement signoMas = driver.findElement(By.id("hrefIncAdt"));
		for(int i=1;i<=5;i++) {
			signoMas.click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(adultMenu.getText());
		Thread.sleep(1500);
		driver.close();
		
	}

}
