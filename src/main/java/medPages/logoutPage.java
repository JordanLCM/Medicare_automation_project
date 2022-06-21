package medPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class logoutPage {
	WebDriver driver;
	
	public logoutPage(WebDriver driver) {
		this.driver = driver;
	}
	public void userNameClick() {
		WebElement userNameIcon = driver.findElement(By.xpath("//a[@class='btn btn-default dropdown-toggle']"));
		userNameIcon.click();
	}
	public void logoutButton() {
		WebElement logout = driver.findElement(By.xpath("//a[normalize-space()='Logout']"));
		logout.click();
		System.out.println("User has been logged out!");
		System.out.println("==================================================");
	}
}